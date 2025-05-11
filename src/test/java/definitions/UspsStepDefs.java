package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.DriverFactory;

import java.time.Duration;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UspsStepDefs {
    WebDriver driver = DriverFactory.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    Actions actions = new Actions(driver);

    @And("I fill out {string} street, {string} city, {string} state")
    public void iFillOutStreetCityState(String street, String city, String state) {
        driver.findElement(By.xpath("//input[@id='tAddress']")).sendKeys(street);
        driver.findElement(By.xpath("//input[@id='tCity']")).sendKeys(city);
        WebElement stateElement = driver.findElement(By.xpath("//select[@id='tState']"));
        new Select(stateElement).selectByValue(state);
    }

    @And("I submit lookup by address form")
    public void iSubmitLookupByAddressForm() {
        driver.findElement(By.xpath("//a[@id='zip-by-address']")).click();
    }

    @Then("I validate {string} zip code exists in the result")
    public void iValidateZipCodeExistsInTheResult(String expectedZip) {
        WebElement resultContainer = driver.findElement(By.xpath("//div[@id='zipByAddressDiv']"));
//        wait.until(ExpectedConditions.visibilityOf(resultContainer));
        wait.until(d -> resultContainer.isDisplayed());
        String resultContainerText = resultContainer.getText();
        assertThat(resultContainerText).contains(expectedZip);
    }

    @When("I click menu item {string} under {string} menu")
    public void iClickMenuItemUnder(String menuItem, String menuTitle) {
        WebElement menuTitleElement = driver.findElement(By.xpath("//a[text()='" + menuTitle + "']"));
        WebElement menuItemElement = driver.findElement(By.xpath("//a[text()='"+ menuItem +"' and @role='menuitem']"));
        actions.moveToElement(menuTitleElement).click(menuItemElement).perform();
    }

    @When("I hover over search and search for {string}")
    public void iHoverOverSearchAndSearchFor(String text) {
        WebElement menuSearchIcon = driver.findElement(By.xpath("//a[@id='navsearch']/.."));
        WebElement searchInput = driver.findElement(By.xpath("//input[@id='global-header--search-track-search']"));
        actions.moveToElement(menuSearchIcon)
                .sendKeys(searchInput, text)
                .sendKeys(Keys.ENTER)
                .perform();
        WebElement spinner = driver.findElement(By.xpath("//div[@class='spinner-content']"));
        wait.until(ExpectedConditions.invisibilityOf(spinner));
    }

    @And("I filter results with {string}")
    public void iFilterResultsWith(String filterName) {
        driver.findElement(By.xpath("//label[contains(text(),'" + filterName + "')]")).click();
        WebElement spinner = driver.findElement(By.xpath("//div[@class='spinner-content']"));
        wait.until(ExpectedConditions.invisibilityOf(spinner));
    }

    @Then("I verify {int} results are displayed")
    public void iVerifyResultsAreDisplayed(int count) {
        String resultsString = driver.findElement(By.xpath("//span[@id='searchResultsHeading']")).getText();
        assertThat(resultsString).contains(String.valueOf(count));

        List<WebElement> listOfResults = driver.findElements(By.xpath("//ul[@id='records']/li"));
        assertThat(listOfResults.size()).isEqualTo(count);

    }

    @When("I click on {string} link")
    public void iClickOnLink(String link) {
        driver.findElement(By.xpath("//span[text()='" + link + "']")).click();
    }

    @And("I click on {string} button")
    public void iClickOnButton(String link) {
        driver.findElement(By.xpath("//a[contains(text(),'" + link + "')]")).click();
    }

    @Then("I verify login page is displayed")
    public void iVerifyLoginPageIsDisplayed() {
        // Example how set of handles (browser tabs) looks like:
        //     0           1        2
        // ["ABDF1G", "CD333EF", "EFG5235H"]
        // 1) switch to new window with array
        String[] handles = driver.getWindowHandles().toArray(String[]::new);
        int lastIndex = handles.length - 1;
        driver.switchTo().window(handles[lastIndex]);
        // 2) using for loop
//        for (String handle : driver.getWindowHandles()) {
//            driver.switchTo().window(handle);
//        }
        // 3) another way via lambda
//        driver.getWindowHandles().forEach(handle -> driver.switchTo().window(handle));

        wait.until(ExpectedConditions.titleIs("Login"));
    }
}
