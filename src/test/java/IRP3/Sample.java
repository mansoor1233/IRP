package IRP3;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://techtamminaapps.appiancloud.com/suite/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//input[@id='un']")).sendKeys("appianrpa.bot");
		driver.findElement(By.xpath("//input[@id='pw']")).sendKeys("Tammina123");
		driver.findElement(By.xpath("//input[@value='Sign In']")).click();

		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[name()='path' and contains(@d,'M48 48a48 ')]")).click();

		WebElement element = driver.findElement(By.xpath(
				"//div[@class='SplitPaneLayout---pane SplitPaneLayout---primary_pane SplitPaneLayout---primary_pane_animation_horizontal']"));
		Actions ac = new Actions(driver);
		WebElement element1 = driver.findElement(By.xpath("//label[contains(text(),'Web API')]"));
		ac.moveToElement(element).scrollToElement(element1).build().perform();

		driver.findElement(By.xpath("//label[contains(text(),'Site')]")).click();

		String IRP = driver.findElement(By.xpath("//p[contains(text(),'Site for all the users to perform irp')]"))
				.getText();
		System.out.println(IRP);
		if (IRP.equalsIgnoreCase("Site for all the users to perform irp"))
			driver.findElement(By.xpath(
					"//*[@id='content']/div[2]/div/div/div[3]/div/div[2]/div/div/div/div/div[3]/div/div/div[2]/div[2]/div/div[1]/table/tbody/tr[4]/td[3]/div/div/div/p/a"))
					.click();
		driver.findElement(By.xpath(
				"//*[@id=\"content\"]/div[2]/div/div/div[3]/div/div[1]/div[1]/div/div/div/div/div[1]/div[3]/div[2]/div/p/a[1]"))
				.click();
		Set<String> set = driver.getWindowHandles();
		Iterator<String> itr = set.iterator();
		String mainWindow = itr.next();
		String childWindow = itr.next();
		driver.switchTo().window(childWindow);
		Thread.sleep(5000);
		driver.switchTo().window(mainWindow);
		
	}

}
