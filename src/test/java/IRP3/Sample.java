package IRP3;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample {



	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://techtamminaapps.appiancloud.com/suite/sites/irp3-users-site");
		driver.manage().window().maximize();
		// driver.get("https://techtamminaapps.appiancloud.com/suite/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//input[@id='un']")).sendKeys("appianrpa.bot");
		driver.findElement(By.xpath("//input[@id='pw']")).sendKeys("Tammina123");
		driver.findElement(By.xpath("//input[@value='Sign In']")).click();
		Thread.sleep(2000);

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

		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");

		// String MonYearvalidation =
		// driver.findElement(By.className("DatePicker---header")).getText();

		// System.out.println(MonYearvalidation);

		// String day = "20";
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

		driver.findElement(By.xpath("//button[contains(text(),'SUBMIT')]")).click();

		// SitePanelContent spc
		for (int spc = 1; spc < 4; spc++) {
			String ThirdColumn = null;
			if(spc==1)
				ThirdColumn ="Total Positions";
			if(spc==2)
			{
				driver.findElement(By.xpath("//strong[normalize-space()='Openings']")).click();
				 ThirdColumn ="Openings";
			}
			if(spc==3)
			{
				 ThirdColumn ="Closed";
				driver.findElement(By.xpath("//strong[normalize-space()='Closed']")).click();
			}

			if(spc==4)
				System.out.println();
			Thread.sleep(5000);
			int pagination = 1, counter = 1, sheetCount = 1;

			while (pagination != 0) {
				String excel = "DATA//Tabledata.xlsx";

				XLUtility xlUtil = new XLUtility(excel);
				
				xlUtil.setCellData("Sheet" + sheetCount, 0, 0, "Sno");
				xlUtil.setCellData("Sheet" + sheetCount, 0, 1, "Campaign");
				xlUtil.setCellData("Sheet" + sheetCount, 0, 2, ThirdColumn );

				
//				xlUtil.setCellData("Sheet2", 0, 0, "Sno");
//				xlUtil.setCellData("Sheet2", 0, 1, "Campaign");
//				xlUtil.setCellData("Sheet2", 0, 2, "TotalPositions");
				
				List<WebElement> table = driver.findElements(By.xpath("//table//tbody//tr"));
				int rows = table.size();
				System.out.println(rows);
				for (int r = 1; r <= rows; r++) {

					String Sno = driver.findElement(By.xpath("//table//tbody/tr[" + r + "]//td[1]")).getText();
					String Campaign = driver.findElement(By.xpath("//table//tbody/tr[" + r + "]//td[2]")).getText();
					String TotalPositions = driver.findElement(By.xpath("//table//tbody/tr[" + r + "]//td[3]"))
							.getText();
					
					xlUtil.setCellData("Sheet" + sheetCount, counter, 0, Sno);
					xlUtil.setCellData("Sheet" + sheetCount, counter, 1, Campaign);   
					xlUtil.setCellData("Sheet" + sheetCount, counter, 2, TotalPositions);
					
//					xlUtil.setCellData("Sheet2", counter, 0, "Sno");
//					xlUtil.setCellData("Sheet2", counter, 1, "Campaign");
//					xlUtil.setCellData("Sheet2", counter, 2, "TotalPositions");

					Thread.sleep(2000);

					counter++;
					System.out
							.println("Sno:" + Sno + ", Campaign: " + Campaign + ", "+ThirdColumn+ ": "+TotalPositions);
				}

				if (driver.findElement(By.xpath("//a[@aria-label='Next page']")).getAttribute("aria-disabled")
						.contains("false")) {
					WebElement next = driver.findElement(By.xpath("//a[@aria-label='Next page']"));
					Thread.sleep(2000);
					next.click();
					Thread.sleep(2000);

				} else {

					break;
  
				}

				pagination++;

			}
			sheetCount++;
			System.out.println("Webscrapping is successfully done and fetch to excel file ");
//		driver. Close();

		}
	}
}

// button[contains(text(),'TODAY')]

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
