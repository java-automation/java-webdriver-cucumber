package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import support.DriverFactory;
import org.openqa.selenium.support.PageFactory;

public class EcosiaCareers {


    // constructor

public EcosiaCareers() {
    PageFactory.initElements(DriverFactory.getDriver(), this);
}
    // selectors
    @FindBy(css = ".module-text-cta__is-hero-button")
    private WebElement positionsButton;


    // methods







}
