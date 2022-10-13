package IRP3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Stepdefinition {

	WebDriver driver;

	@Given("the user opens the application")
	public void the_user_opens_the_application() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://techtamminaapps.appiancloud.com/suite/");

	}

	@Given("enters the username and password")
	public void enters_the_username_and_password() {
		driver.findElement(By.xpath("//input[@id='un']")).sendKeys("appianrpa.bot");
		driver.findElement(By.xpath("//input[@id='pw']")).sendKeys("Tammina123");
	}

	@Then("clicks on signin button")
	public void clicks_on_signin_button() {
		driver.findElement(By.xpath("//input[@value='Sign In']")).click();
	}
	

}
