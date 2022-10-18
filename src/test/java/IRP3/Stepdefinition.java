package IRP3;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Stepdefinition extends Baseclass {

	@Given("The user launches the chromebrowser")
	public void the_user_launches_the_chromebrowser() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		po = new Pageobject(driver);
	}

	@Given("user opens the application url {string}")
	public void user_opens_the_application_url(String url) {
		driver.navigate().to(url);
	}

	@And("Enters the username as {string} and password as {string}")
	public void enters_the_username_as_and_password_as(String uname, String pwd) throws InterruptedException {

		Thread.sleep(5000);
		po.setUserName(uname);
		po.setPassword(pwd);
	}

	@Then("Clicks on signin button")
	public void clicks_on_signin_button() {
		po.Signin();

	}

	@And("User should navigate to the Usersite Page")
	public void user_should_navigate_to_the_usersite_page() {

		System.out.println("Page title is : " + driver.getTitle());
	}

	@And("User Clicks on the create new campaign button")
	public void user_clicks_on_the_create_new_campaign_button() {
		po.CreateCampaign();
	}

	@Then("Enters the Role Dropdown")
	public void enters_the_role_dropdown() throws InterruptedException {
		Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");

		WebElement dropdown = driver.findElement(By.xpath("//div[@id='96a71a1bd003eeb1df5d17f2693d8726_value']"));

		dropdown.click();

		dropdown.sendKeys("Jav" + Keys.ENTER);

	}

	@Then("Enter the Keyskills")
	public void enter_the_keyskills() {
		driver.findElement(By.xpath("//input[@id='5506ac8c5cc46c3ca1a37bb1d2204d1d']")).sendKeys("Java,Corejava"); // keyskills
	}

	@Then("Enter the Requirement")
	public void enter_the_requirement() {
		driver.findElement(By.xpath("//input[@id='aa5ad04ab99beedc74423921e7674b4f']")).sendKeys("21");// Requirement

	}

	@Then("Enddate")
	public void enddate() throws InterruptedException {
		po.date();

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

		po.Number();
		po.Submit();

	}

	// 2nd Featurefile

	@Then("Get the tabledata to excel")
	public void get_the_tabledata_to_excel() throws IOException {

		int pagination = 1, counter = 1;
		while (pagination != 0) {
			String excel = "DATA//toexcel.xlsx";
			XLUtility xlUtil = new XLUtility(excel);
			xlUtil.setCellData("Sheet1", 0, 0, "Sno");
			xlUtil.setCellData("Sheet1", 0, 1, "Campaign");
			xlUtil.setCellData("Sheet1", 0, 2, "TotalPositions");

			List<WebElement> table = driver.findElements(By.xpath("//table//tbody//tr"));
			int rows = table.size();
			System.out.println(rows);
			for (int r = 1; r <= rows; r++) {
				String Sno = driver.findElement(By.xpath("//table//tbody/tr[" + r + "]//td[1]")).getText();
				String Campaign = driver.findElement(By.xpath("//table//tbody/tr[" + r + "]//td[2]")).getText();
				String TotalPositions = driver.findElement(By.xpath("//table//tbody/tr[" + r + "]//td[3]")).getText();

				xlUtil.setCellData("Sheet1", counter, 0, Sno);
				xlUtil.setCellData("Sheet1", counter, 1, Campaign);
				xlUtil.setCellData("Sheet1", counter, 2, TotalPositions);

				counter++;
				System.out.println("Sno:" + Sno + ", Campaign: " + Campaign + ", TotalPositions: " + TotalPositions);
			}
			if (driver.findElement(By.xpath("//a[@title='Next page']")).equals("-1")) {
				break;
			} else {
				WebElement next = driver.findElement(By.xpath("//a[@title='Next page']"));
				System.out.println(driver.findElement(By.xpath("//a[@title='Next page']")));
				next.click();
			}

			pagination++;
		}
		System.out.println("Webscrapping  is successfully done and fetch to excel file ");
//				driver. Close();

	}

}
