// Created by Viacheslav (Slava) Skryabin 04/01/2011
package support;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public static WebDriver getDriver() {
        TestConfig testConfig = TestDataManager.getTestConfig();
        if (driverThreadLocal.get() == null) {
            Dimension size = new Dimension(testConfig.getWindowWidth(), testConfig.getWindowHeight());
            Point position = new Point(0, 0);
            if (testConfig.getTestExecutionMode().equals("local")) {
                switch (testConfig.getBrowser()) {
                    case "chrome":
                        Map<String, Object> chromePreferences = new HashMap<>();
                        chromePreferences.put("profile.default_content_settings.geolocation", 2);
                        chromePreferences.put("profile.default_content_settings.popups", 0);
                        chromePreferences.put("download.prompt_for_download", false);
                        chromePreferences.put("download.directory_upgrade", true);
                        chromePreferences.put("download.default_directory", System.getProperty("user.dir") + "/src/test/resources/downloads");
                        chromePreferences.put("safebrowsing.enabled", false);
                        chromePreferences.put("plugins.always_open_pdf_externally", true);
                        chromePreferences.put("plugins.plugins_disabled", new ArrayList<String>(){{ add("Chrome PDF Viewer"); }});
                        chromePreferences.put("credentials_enable_service", false);
                        chromePreferences.put("password_manager_enabled", false);
                        // for EMEA only - disable cookies
//                    chromePreferences.put("profile.default_content_setting_values.cookies", 2);
                        ChromeOptions chromeOptions = new ChromeOptions();
                        chromeOptions.addArguments("--start-maximized");
                        chromeOptions.addArguments("--remote-allow-origins=*");
                        chromeOptions.setExperimentalOption("prefs", chromePreferences);
                        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
                        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_LEVEL_PROPERTY, "SEVERE");
                        if (testConfig.isHeadless()) {
                            chromeOptions.addArguments("--headless=new");
                            chromeOptions.addArguments("--window-size=" + size.getWidth() + "," + size.getWidth());
                            chromeOptions.addArguments("--disable-gpu");
                        }
                        ChromeDriverService service = new ChromeDriverService.Builder()
                                .withLogOutput(System.out)
                                .build();
                        driverThreadLocal.set(new ChromeDriver(service, chromeOptions));
                        break;
                    case "firefox":
                        FirefoxOptions firefoxOptions = new FirefoxOptions();
                        if (testConfig.isHeadless()) {
                            FirefoxBinary firefoxBinary = new FirefoxBinary();
                            firefoxBinary.addCommandLineOptions("--headless");
                            firefoxOptions.setBinary(firefoxBinary);
                        }
                        driverThreadLocal.set(new FirefoxDriver(firefoxOptions));
                        break;
                    case "safari":
                        driverThreadLocal.set(new SafariDriver());
                        break;
                    case "edge":
                        driverThreadLocal.set(new EdgeDriver());
                        break;
                    case "ie":
                        driverThreadLocal.set(new InternetExplorerDriver());
                        break;
                    default:
                        throw new RuntimeException("Driver is not implemented for: " + testConfig.getBrowser());
                }
            } else if (testConfig.getTestExecutionMode().equals("grid")){
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setBrowserName(testConfig.getBrowser());
                capabilities.setPlatform(Platform.ANY);
                try {
                    URL hubUrl = new URL("http://localhost:4444/wd/hub");
                    driverThreadLocal.set(new RemoteWebDriver(hubUrl, capabilities));
                    ((RemoteWebDriver) driverThreadLocal.get()).setFileDetector(new LocalFileDetector());
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e.getMessage());
                }
            } else {
                throw new RuntimeException("Unsupported test environment: " + testConfig.getTestExecutionMode());
            }
        }
        return driverThreadLocal.get();
    }

    public static void quitDriver() {
        if (driverThreadLocal.get() != null) {
            driverThreadLocal.get().quit();
            driverThreadLocal.remove();
        }
    }

    public static boolean isDriverUp() {
        return driverThreadLocal.get() != null;
    }
}
