package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import support.DriverFactory;

public class QuoteResult {

    // constructor
    public QuoteResult() {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    // selectors
    @FindBy(xpath = "//div[@id='quotePageResult']//section")
    private WebElement sectionResult;

    @FindBy(xpath = "//b[@name='username']")
    private WebElement userNameResult;

    @FindBy(xpath = "//b[@name='email']")
    private WebElement emailResult;



    // methods
    public String getSectionResultValue() {
        return sectionResult.getText();
    }
    public String getUserNameResult() {
        return userNameResult.getText();
    }
    public String getEmailResult() {
        return emailResult.getText();
    }

}
