package definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static support.TestContext.getDriver;

public class DeeptiStepDefs {
    @Given("DP navigates to URL {string}")
    public void dpNavigatesToURL(String stringURL) {
//        getDriver().get(stringURL);
//        getDriver().get("https://google.com");
        switch (stringURL) {
            case "Google":
                getDriver().get("https://google.com");
                break;
            case "Portnov":
                getDriver().get("https://portnov.com");
                break;
            case "Yahoo":
                getDriver().get("https://yahoo.com");
                break;
            case "ASK":
                getDriver().get("http://ask-m.portnov.com/#/login");
                break;
            default:
                System.out.println("No Url Found");
        }

    }

    @Then("DP gets page information")
    public void dpGetsPageInformation() {
        System.out.println("The Page Title is: " + getDriver().getTitle());
        System.out.println("The Page URL is: " + getDriver().getCurrentUrl());
        System.out.println("Window Handle is: " + getDriver().getWindowHandle());
    }

    @Then("DP maximizes the window")
    public void dpMaximizesTheWindow() {
        getDriver().manage().window().maximize();
    }
}
