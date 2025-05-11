package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import support.DriverFactory;

public class EcosiaLanding {

    WebDriver driver = DriverFactory.getDriver();

    // constructor
    public EcosiaLanding() {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    // selectors
    @FindBy(xpath = "//a[normalize-space()='Careers']")
    private WebElement careersLink;

    @FindBy(xpath = "//button[@data-test-id='cookie-notice-accept']")
    private WebElement acceptCookiesButton;

    private WebElement footerElementByText(String linkName) {
        return driver.findElement(By.xpath("//a[normalize-space()='" + linkName + "']"));
    }

    // actions
    public void clickCareersLink() {
        // example of using javascript click
        clickWithJavaScript(careersLink);
    }

    public void clickFooterElementByText(String linkName) {
        // example of closing sticky footer and then using standard webdriver click
        acceptCookiesButton.click();
        footerElementByText(linkName).click();

        // example of using javascript click
//        clickWithJavaScript(footerElementByText(linkName));
    }

    private void clickWithJavaScript(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

}
