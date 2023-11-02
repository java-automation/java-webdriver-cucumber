package support;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before(order = 0)
    public void scenarioStart() {

    }

    @After(order = 0)
    public void scenarioEnd(Scenario scenario) {
        if (scenario.isFailed() && DriverFactory.isDriverUp()) {
            TakesScreenshot screenshotTaker = (TakesScreenshot) DriverFactory.getDriver();
            byte[] screenshot = screenshotTaker.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Screenshot");
        }
        DriverFactory.quitDriver();
    }
}
