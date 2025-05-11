package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import support.DriverFactory;

public class CommerceCustomerInfo {
    // constructor
    public CommerceCustomerInfo() {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    // selectors

    @FindBy(id = "FirstName")
    private WebElement firstName;

    @FindBy(id = "LastName")
    private WebElement lastName;

    @FindBy(id = "Email")
    private WebElement email;

    
    // methods

    public String getFirstNameValue() {
        return firstName.getAttribute("value");
    }
    public String getLastNameValue() {
        return lastName.getAttribute("value");
    }
    public String getEmailValue() {
        return email.getAttribute("value");
    }


}
