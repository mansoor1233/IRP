package IRP3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Stepdefinition {

	WebDriver driver;

	@Given("The user opens the application")
	public void the_user_opens_the_application() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://techtamminaapps.appiancloud.com/suite/sites/irp3-users-site");

	}

	@And("Enters the username and password")
	public void enters_the_username_and_password() {
		driver.findElement(By.xpath("//input[@id='un']")).sendKeys("appianrpa.bot");
		driver.findElement(By.xpath("//input[@id='pw']")).sendKeys("Tammina123");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("Clicks on signin button")
	public void clicks_on_signin_button() {
		driver.findElement(By.xpath("//input[@value='Sign In']")).click();

	}

	@And("User should navigate to the Usersite Page")
	public void user_should_navigate_to_the_usersite_page() {

		System.out.println("Page title is : " + driver.getTitle());
	}

	@And("User Clicks on the create new campaign button")
	public void user_clicks_on_the_create_new_campaign_button() {
		driver.findElement(By.xpath("//span[normalize-space()='CREATE CAMPAIGN']")).click();
	}

	@And("Enters the Required fields")
	public void enters_the_required_fields() throws InterruptedException {

		Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");

		WebElement dropdown = driver.findElement(By.xpath("//div[@id='96a71a1bd003eeb1df5d17f2693d8726_value']"));

		dropdown.click();

		dropdown.sendKeys("pyt" + Keys.ENTER);

		driver.findElement(By.xpath("//input[@id='5506ac8c5cc46c3ca1a37bb1d2204d1d']")).sendKeys("Java,phython");

		driver.findElement(By.xpath("//input[@id='aa5ad04ab99beedc74423921e7674b4f']")).sendKeys("20");

		driver.findElement(By.xpath("//button[@class='DatePickerWidget---calendar_btn']")).click();

		WebElement mondrpdown = driver.findElement(By.xpath("//div[@class='DatePicker---month css-2b097c-container']"));

		mondrpdown.click();

		new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("DatePicker---calendar")));

		Thread.sleep(5000);
		Actions ac = new Actions(driver);

		driver.findElement(By.xpath("//div[@class='DatePicker---month css-2b097c-container']")).click();
		ac.sendKeys(Keys.DOWN).pause(Duration.ofSeconds(1));
		ac.sendKeys(Keys.DOWN).pause(Duration.ofSeconds(1));
		ac.sendKeys(Keys.DOWN).pause(Duration.ofSeconds(1));
		ac.sendKeys(Keys.ENTER).build().perform();

		driver.findElement(By.xpath("//div[@class='DatePicker---year css-2b097c-container']")).click();
		ac.sendKeys(Keys.DOWN).pause(Duration.ofSeconds(1));
		ac.sendKeys(Keys.DOWN).pause(Duration.ofSeconds(1));
		ac.sendKeys(Keys.DOWN).pause(Duration.ofSeconds(1));
		ac.sendKeys(Keys.ENTER).build().perform();

		driver.findElement(By.xpath("//table//tbody//tr[2]//td[6]")).click();

		driver.findElement(By.xpath("//button[text()='SUBMIT']")).click();

		

	}

}
