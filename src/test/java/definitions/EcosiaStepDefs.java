package definitions;

import io.cucumber.java.en.When;
import pages.EcosiaLanding;

public class EcosiaStepDefs {
    private EcosiaLanding ecosiaLandingPage = new EcosiaLanding();

    @When("I click on {string} footer link")
    public void iClickOnFooterLink(String linkName) {
        ecosiaLandingPage.clickFooterElementByText(linkName);
    }
}
