// Created by Viacheslav (Slava) Skryabin 04/01/2011
package support;

import java.util.List;

public class TestConfig {

    private String browser;
    private int windowWidth;
    private int windowHeight;
    private String testExecutionMode;
    private boolean headless;
    private int pageLoadTimeout;
    private int implicitTimeout;
    private int explicitTimeout;
    private List<String> supportedOS;

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public int getWindowWidth() {
        return windowWidth;
    }

    public void setWindowWidth(int windowWidth) {
        this.windowWidth = windowWidth;
    }

    public int getWindowHeight() {
        return windowHeight;
    }

    public void setWindowHeight(int windowHeight) {
        this.windowHeight = windowHeight;
    }

    public String getTestExecutionMode() {
        return testExecutionMode;
    }

    public void setTestExecutionMode(String testExecutionMode) {
        this.testExecutionMode = testExecutionMode;
    }

    public boolean isHeadless() {
        return headless;
    }

    public void setHeadless(boolean headless) {
        this.headless = headless;
    }

    public int getPageLoadTimeout() {
        return pageLoadTimeout;
    }

    public void setPageLoadTimeout(int pageLoadTimeout) {
        this.pageLoadTimeout = pageLoadTimeout;
    }

    public int getImplicitTimeout() {
        return implicitTimeout;
    }

    public void setImplicitTimeout(int implicitTimeout) {
        this.implicitTimeout = implicitTimeout;
    }

    public int getExplicitTimeout() {
        return explicitTimeout;
    }

    public void setExplicitTimeout(int explicitTimeout) {
        this.explicitTimeout = explicitTimeout;
    }

    public List<String> getSupportedOS() {
        return supportedOS;
    }

    public void setSupportedOS(List<String> supportedOS) {
        this.supportedOS = supportedOS;
    }

}