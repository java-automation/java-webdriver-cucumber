package definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import support.DriverFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class ConverterStepDefs {

    WebDriver driver = DriverFactory.getDriver();

    @When("I type {string} in Fahrenheit input field")
    public void iTypeInFahrenheitInputField(String degrees) {
        driver.findElement(By.xpath("//select[@id='ucfromunit']/option[text()='Fahrenheit [°F]']")).click();
        driver.findElement(By.xpath("//input[@id='ucfrom']")).sendKeys(degrees);
    }

    @Then("I see {string} in Celsius input field")
    public void iSeeInCelsiusInputField(String degrees) {
        driver.findElement(By.xpath("//select[@id='uctounit']/option[contains(text(),'Celsius')]")).click();
        String celsiusValue = driver.findElement(By.xpath("//input[@id='ucto']")).getAttribute("value");
        System.out.println("Actual Celsius value: " + celsiusValue);
        assertThat(celsiusValue).contains(degrees);
    }
}
