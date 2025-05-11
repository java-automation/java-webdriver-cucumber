package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.CommerceRegistration;
import support.DriverFactory;

import java.io.FileNotFoundException;
import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class MarketStepDefs {

    WebDriver driver = DriverFactory.getDriver();

    @Given("I navigate to {string} page")
    public void iNavigateToPage(String pageName) {
        switch (pageName) {
            case "nop commerce registration" -> driver.get("https://nop-qa.portnov.com/register");
            case "quote" -> driver.get("https://skryabin.com/market/quote.html");
            case "converter" -> driver.get("https://www.unitconverters.net/temperature-converter.html");
            case "usps lookup by address" -> driver.get("https://tools.usps.com/zip-code-lookup.htm?byaddress");
            case "boardreader" -> driver.get("https://boardreader.com/");
            case "ecosia" -> driver.get("https://www.ecosia.org/");
            default -> throw new Error("Invalid pageName argument: " + pageName);
        }
        String title = driver.getTitle();
        System.out.println("Title: " + title);
        String url = driver.getCurrentUrl();
        System.out.println("URL: " + url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
    }

    @When("I fill out the required fields on the form")
    public void iFillOutTheRequiredFieldsOnTheForm() {
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("john_doe");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("john@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("password123");
        driver.findElement(By.xpath("//input[@id='confirmPassword']")).sendKeys("password123");
//        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("John Doe");
        driver.findElement(By.xpath("//input[@id='name']")).click();
        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("John");
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Doe");
//        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//span[text()='Save']")).click();
        driver.findElement(By.xpath("//input[@name='agreedToPrivacyPolicy']")).click();
    }

    @And("I submit the quote form")
    public void iSubmitTheQuoteForm() {
        driver.findElement(By.xpath("//button[@id='formSubmit']")).click();
    }

    @Then("I see required fields submitted successfully")
    public void iSeeRequiredFieldsSubmittedSuccessfully() {
        String usernameValue = driver.findElement(By.xpath("//b[@name='username']")).getText();
        String passwordValue = driver.findElement(By.xpath("//b[@name='password']")).getText();
        assertThat(usernameValue).isEqualTo("john_doe");
        assertThat(passwordValue).isEqualTo("[entered]");
        assertThat(passwordValue).isNotEqualTo("password123");

        String resultSection = driver.findElement(By.xpath("//div[@id='quotePageResult']//section")).getText();
        assertThat(resultSection).contains("john_doe");
        assertThat(resultSection).contains("john@example.com");
        assertThat(resultSection).doesNotContain("password123");

    }

    @When("I fill out the name field with first name {string} and last name {string}")
    public void iFillOutTheNameFieldWithFirstNameAndLastName(String firstName, String lastName) {

    }

    @When("I select {string} and {string} car makes")
    public void iSelectAndCarMakes(String firstCar, String secondCar) {
        WebElement carMakeElement = driver.findElement(By.xpath("//select[@name='carMake']"));
        Select carMakeSelect = new Select(carMakeElement);
        carMakeSelect.selectByVisibleText(firstCar);
        carMakeSelect.selectByVisibleText(secondCar);
//        Actions actions = new Actions(driver);
//        WebElement firstCarElement = driver.findElement(By.xpath("//option[text()='" + firstCar + "']"));
//        WebElement secondCarElement = driver.findElement(By.xpath("//option[text()='" + secondCar + "']"));
//        actions.click(firstCarElement).keyDown(Keys.COMMAND).click(secondCarElement).perform();
    }

}
