package IRP3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pageobject {

	public WebDriver Idriver;

	public Pageobject(WebDriver rdriver) {
		Idriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	@FindBy(xpath = "//input[@id='un']")
	WebElement txtusername;

	@FindBy(xpath = "//input[@id='pw']")
	WebElement txtPassword;

	@FindBy(xpath = "//input[@value='Sign In']")
	WebElement btnsignin;

	@FindBy(xpath = "//span[normalize-space()='CREATE CAMPAIGN']")
	WebElement createcampaign;

	@FindBy(xpath = "//div[@id='96a71a1bd003eeb1df5d17f2693d8726_value']")
	WebElement dropdown;

	@FindBy(xpath = "//button[@class='DatePickerWidget---calendar_btn']")
	WebElement datepicker;

	@FindBy(xpath = "//table//tbody//tr[2]//td[6]")
	WebElement NumericalDate;

	@FindBy(xpath = "//button[text()='SUBMIT']")
	WebElement Submitbtw;

	public void setUserName(String uname) {
		txtusername.sendKeys(uname);
	}

	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}

	public void Signin() {
		btnsignin.click();
	}

	public void CreateCampaign() {
		createcampaign.click();
	}

	public void Drpdwn() {
		dropdown.click();
	}

	public void date() {
		datepicker.click();
	}

	public void Number() {
		NumericalDate.click();
	}

	public void Submit() {
		Submitbtw.click();
	}

}
