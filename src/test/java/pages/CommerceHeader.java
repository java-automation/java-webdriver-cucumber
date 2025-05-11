package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import support.DriverFactory;

public class CommerceHeader {
    // constructor
    public CommerceHeader() {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    // selectors
    @FindBy(css = ".ico-account")
    private WebElement myAccountLink;


    // methods
    public void clickMyAccountLink() {
        myAccountLink.click();
    }


}
