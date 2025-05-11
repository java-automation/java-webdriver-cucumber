package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CommerceCustomerInfo;
import pages.CommerceHeader;
import pages.CommerceRegistration;
import pages.CommerceRegistrationResult;
import support.TestDataManager;

import java.util.ArrayList;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class CommerceStepDefs {

    CommerceRegistration registrationPage = new CommerceRegistration();
    CommerceRegistrationResult registrationResultPage = new CommerceRegistrationResult();
    CommerceHeader headerPage = new CommerceHeader();
    CommerceCustomerInfo customerInfoPage = new CommerceCustomerInfo();
    Map<String, String> commerceUser = TestDataManager.getCommerceUserData();

    @When("I fill out required user personal details on the registration form")
    public void iFillOutUserPersonalDetailsOnTheRegistrationForm() {
        // method stub
        registrationPage.fillPersonalDetails(commerceUser.get("firstName"), commerceUser.get("lastName"), commerceUser.get("email"));
        registrationPage.fillPasswordAndConfirmPassword(commerceUser.get("password"));
    }

    @And("I submit the registration form")
    public void iSubmitTheRegistrationForm() {
        registrationPage.submitForm();
    }

    @Then("I see that user registration was successful")
    public void iSeeThatUserRegistrationWasSuccessful() {
        String message = registrationResultPage.getResultMessage();
        String color = registrationResultPage.getMessageColor();
        assertThat(message).isEqualTo("Your registration completed");
        assertThat(color).isEqualTo("rgba(76, 177, 124, 1)"); // green color
    }

    @And("I verify that required user fields saved correctly on account page")
    public void iVerifyThatRequiredUserFieldsSavedCorrectlyOnAccountPage() {
        headerPage.clickMyAccountLink();
        String firstName = customerInfoPage.getFirstNameValue();
        String lastName = customerInfoPage.getLastNameValue();
        String email = customerInfoPage.getEmailValue();
        assertThat(firstName).isEqualTo(commerceUser.get("firstName"));
        assertThat(lastName).isEqualTo(commerceUser.get("lastName"));
        assertThat(email).isEqualTo(commerceUser.get("email"));
    }

    @And("I fill out optional fields on the registration form")
    public void iFillOutOptionalFieldsOnTheRegistrationForm() {
        String gender = commerceUser.get("gender");
        String day = commerceUser.get("dateOfBirthDay");
        String month = commerceUser.get("dateOfBirthMonth");
        String year = commerceUser.get("dateOfBirthYear");

        registrationPage.selectGender(gender);
        registrationPage.fillDateOfBirth(day, month, year);
        registrationPage.subscribeToNewsletter();
    }

    @And("I verify that optional user fields saved correctly on account page")
    public void iVerifyThatOptionalUserFieldsSavedCorrectlyOnAccountPage() {


    }
}
