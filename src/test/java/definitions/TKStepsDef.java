package definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static support.TestContext.getDriver;

public class TKStepsDef {
    @Given("TK navigate to URL {string}")
    public void tkNavigateToURL(String sURL) {
        switch (sURL) {
            case "Google":
                getDriver().get("https://www.google.com");
                break;
            case "Portnov School":
                getDriver().get("https://www.portnov.com");
                break;
            case "Yahoo":
                getDriver().get("https://www.yahoo.com");
                break;
            case "ASK":
                getDriver().get("http://www.ask-int.portnov.com");
                break;
            default:
                System.out.println("No URL found");
        }
    }

    @Then("TK get page info")
    public void tkGetPageInfo() {
        System.out.println("The page title is " + getDriver().getTitle());
        System.out.println("The page URL is " + getDriver().getCurrentUrl());
        System.out.println("Window handle is " + getDriver().getWindowHandle());
    }


    @Then("TK maximize the window")
    public void tkMaximizeTheWindow() {
        getDriver().manage().window().maximize();
    }
}

