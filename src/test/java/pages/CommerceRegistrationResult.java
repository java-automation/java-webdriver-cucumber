package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import support.DriverFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class CommerceRegistrationResult {

    // constructor
    public CommerceRegistrationResult() {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    // selectors

    @FindBy(css = ".result")
    private WebElement resultMessage;

    // methods

    public String getResultMessage() {
        return resultMessage.getText();
    }

    public String getMessageColor() {
        return resultMessage.getCssValue("color");
    }

    public void assertResultSuccessMessage() {
        assertThat(resultMessage).isEqualTo("Your registration completed");
        assertThat(resultMessage).isEqualTo("rgba(76, 177, 124, 1)"); // green color
    }

}
