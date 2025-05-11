package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import support.DriverFactory;

import java.util.Map;

public class CommerceRegistration {

    // constructor
    public CommerceRegistration() {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    // selectors

    @FindBy(id = "FirstName")
    private WebElement firstName;

    @FindBy(id = "LastName")
    private WebElement lastName;

    @FindBy(id = "Email")
    private WebElement email;

    @FindBy(id = "Password")
    private WebElement password;

    @FindBy(id = "ConfirmPassword")
    private WebElement confirmPassword;

    @FindBy(id = "register-button")
    private WebElement registerButton;

    @FindBy(id = "gender-male")
    private WebElement maleRadioButton;

    @FindBy(id = "gender-female")
    private WebElement femaleRadioButton;

    @FindBy(name = "DateOfBirthDay")
    private WebElement dateOfBirthDay;

    @FindBy(name = "DateOfBirthMonth")
    private WebElement dateOfBirthMonth;

    @FindBy(name = "DateOfBirthYear")
    private WebElement dateOfBirthYear;

    @FindBy(id = "Company")
    private WebElement companyName;

    @FindBy(id = "Newsletter")
    private WebElement newsletterCheckbox;

    // methods

    public void subscribeToNewsletter() {
        if (!newsletterCheckbox.isSelected()) {
            newsletterCheckbox.click();
        }
    }

    public void unsubscribeFromNewsletter() {
        if (newsletterCheckbox.isSelected()) {
            newsletterCheckbox.click();
        }
    }

    public void fillCompanyName(String companyNameValue) {
        companyName.sendKeys(companyNameValue);
    }

    public void fillPersonalDetails(String firstNameValue, String lastNameValue, String emailValue) {
        firstName.sendKeys(firstNameValue);
        lastName.sendKeys(lastNameValue);
        email.sendKeys(emailValue);
    }

    // example of method overloading - static polymorphism
    public void fillPersonalDetails(String firstNameValue, String lastNameValue, String emailValue, String genderValue, String dayValue, String monthValue, String yearValue) {
        fillPersonalDetails(firstNameValue, lastNameValue, emailValue);
    }

    // another example of method overloading - static polymorphism
    public void fillPersonalDetails(Map<String, String> user) {
        fillPersonalDetails(user.get("firstName"), user.get("lastName"), user.get("email"));
        if (user.get("gender") != null) {
            selectGender(user.get("gender"));
        }
        if (user.get("dateOfBirthDay") != null && user.get("dateOfBirthMonth") != null && user.get("dateOfBirthYear") != null) {
            fillDateOfBirth(user.get("dateOfBirthDay"), user.get("dateOfBirthMonth"), user.get("dateOfBirthYear"));
        }
    }

    public void fillDateOfBirth(String dayValue, String monthValue, String yearValue) {
        new Select(dateOfBirthDay).selectByVisibleText(dayValue);
        new Select(dateOfBirthMonth).selectByVisibleText(monthValue);
        new Select(dateOfBirthYear).selectByVisibleText(yearValue);
    }

    public void selectGender(String genderValue) {
        switch (genderValue) {
            case "male" -> maleRadioButton.click();
            case "female" -> femaleRadioButton.click();
            default -> throw new Error("UI page has the following options: Gender: Male  Female");
        }
    }

    public void fillPasswordAndConfirmPassword(String passwordValue) {
        password.sendKeys(passwordValue);
        confirmPassword.sendKeys(passwordValue);
    }

    public void submitForm() {
        registerButton.click();
    }




}
