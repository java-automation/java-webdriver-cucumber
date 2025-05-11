package definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.DriverFactory;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardReaderStepDefs {

    WebDriver driver = DriverFactory.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    @When("I search for {string} on boardreader")
    public void iSearchForOnBoardreader(String text) {
        driver.findElement(By.xpath("//input[@id='title-query']")).sendKeys(text);
        driver.findElement(By.xpath("//button[@id='title-submit']")).click();
    }

    @Then("I validate {string} shows on boardreader results")
    public void iValidateShowsOnBoardreaderResults(String expectedText) {
        WebElement resultContainer = driver.findElement(By.xpath("//ul[@class='mdl-list']"));
        wait.until(d -> !resultContainer.getText().isEmpty());
        String actualTextContainer = resultContainer.getText();
        assertThat(actualTextContainer).contains(expectedText);
    }
}
