package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import support.DriverFactory;

public class QuoteForm {

    // constructor
    public QuoteForm() {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    // selectors
    private WebElement name;
    private WebElement firstName;
    private WebElement lastName;
    private WebElement nameDialogSaveButton;

    // methods

    public void fillName(String firstNameValue, String lastNameValue) {
        name.click();
        firstName.sendKeys(firstNameValue);
        lastName.sendKeys(lastNameValue);
        nameDialogSaveButton.click();
    }
}
