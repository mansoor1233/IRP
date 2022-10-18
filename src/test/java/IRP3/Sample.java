package IRP3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://techtamminaapps.appiancloud.com/suite/sites/irp3-users-site");
		driver.manage().window().maximize();
		// driver.get("https://techtamminaapps.appiancloud.com/suite/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//input[@id='un']")).sendKeys("appianrpa.bot");
		driver.findElement(By.xpath("//input[@id='pw']")).sendKeys("Tammina123");
		driver.findElement(By.xpath("//input[@value='Sign In']")).click();

		driver.findElement(By.xpath("//span[normalize-space()='CREATE CAMPAIGN']")).click();

		WebElement dropdown = driver.findElement(By.xpath("//div[@id='96a71a1bd003eeb1df5d17f2693d8726_value']"));

		dropdown.click();

		dropdown.sendKeys("Sql" + Keys.ENTER);

		driver.findElement(By.xpath("//input[@id='5506ac8c5cc46c3ca1a37bb1d2204d1d']")).sendKeys("Java,phython");

		driver.findElement(By.xpath("//input[@id='aa5ad04ab99beedc74423921e7674b4f']")).sendKeys("20");

		driver.findElement(By.xpath("//button[@class='DatePickerWidget---calendar_btn']")).click();

		WebElement mondrpdown = driver.findElement(By.xpath("//div[@class='DatePicker---month css-2b097c-container']"));

		mondrpdown.click();

		new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("DatePicker---calendar")));

		// String MonYearvalidation =
		// driver.findElement(By.className("DatePicker---header")).getText();

		// System.out.println(MonYearvalidation);

		
		//String day = "20";
		Thread.sleep(5000);
		Actions ac = new Actions(driver);

		driver.findElement(By.xpath("//div[@class='DatePicker---month css-2b097c-container']")).click();
		ac.sendKeys(Keys.DOWN).pause(Duration.ofSeconds(2));
		ac.sendKeys(Keys.DOWN).pause(Duration.ofSeconds(2));
		ac.sendKeys(Keys.DOWN).pause(Duration.ofSeconds(2));
		ac.sendKeys(Keys.ENTER).build().perform();

		driver.findElement(By.xpath("//div[@class='DatePicker---year css-2b097c-container']")).click();
		ac.sendKeys(Keys.DOWN).pause(Duration.ofSeconds(2));
		ac.sendKeys(Keys.DOWN).pause(Duration.ofSeconds(2));
		ac.sendKeys(Keys.DOWN).pause(Duration.ofSeconds(2));
		ac.sendKeys(Keys.ENTER).build().perform();
		
		
		driver.findElement(By.xpath("//table//tbody//tr[2]//td[6]")).click();
		
		driver.findElement(By.xpath("//button[contains(text(),'SUBMIT')]")).click();

		//button[contains(text(),'TODAY')]

//		month.sendKeys(Keys.SPACE);
//		month.sendKeys(Keys.ARROW_DOWN);
//		month.sendKeys(Keys.ENTER);
//		month.sendKeys(Keys.RETURN);

		// Thread.sleep(3000);
//		driver.findElement(By.xpath("//*[name()='path' and contains(@d,'M48 48a48 ')]")).click();
//
//		WebElement element = driver.findElement(By.xpath(
//				"//div[@class='SplitPaneLayout---pane SplitPaneLayout---primary_pane SplitPaneLayout---primary_pane_animation_horizontal']"));
//		Actions ac = new Actions(driver);
//		WebElement element1 = driver.findElement(By.xpath("//label[contains(text(),'Web API')]"));
//		ac.moveToElement(element).scrollToElement(element1).build().perform();
//
//		driver.findElement(By.xpath("//label[contains(text(),'Site')]")).click();
//
//		String IRP = driver.findElement(By.xpath("//p[contains(text(),'Site for all the users to perform irp')]"))
//				.getText();
//		System.out.println(IRP);
//
//		String Parent = driver.getWindowHandle();
//		System.out.println("Parent Window -" + Parent);
//		if (IRP.equalsIgnoreCase("Site for all the users to perform irp")) {
////			driver.findElement(By.xpath("//div/p/a[contains(text(),'Intelligent Recruitment Process 3.0')]"));
//			driver.findElement(By.xpath("//table/tbody/tr[4]/td[3]/div/div/div/p/a")).click();
//		}
//
//		Set<String> Newwindow = driver.getWindowHandles();
//
//		for (String Handle : Newwindow) {
//
//			System.out.println(Handle);
//
//			if (!Handle.equals(Parent)) {
//
//				driver.switchTo().window(Handle);
//				driver.findElement(By.xpath(
//						"//a[contains(text(),'https://techtamminaapps.appiancloud.com/suite/sites/irp3-users-site')]"))
//						.click();
//				Thread.sleep(2000);
//
//			}
//			driver.switchTo().window(Handle);
//
//		}
//
//	}

	}
}

//"//*[@id='content']/div[2]/div/div/div[3]/div/div[2]/div/div/div/div/div[3]/div/div/div[2]/div[2]/div/div[1]/table/tbody/tr[4]/td[3]/div/div/div/p/a"))
