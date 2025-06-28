package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BaseClass {

	public HomePage(WebDriver driver) {

		super(driver);

	}

	@FindBy(xpath = "//*[@class='fa fa-user']")
	WebElement lnkMyAccount;

	@FindBy(xpath = "//*[text()='Register']")
	WebElement linkRegister;

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement linkEmail;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement linkPassword;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement btnLogin1;

	@FindBy(xpath = "(//a[normalize-space()='Login'])[1]")
	WebElement btnLogin2;

	public void clickMyAccount() {
		lnkMyAccount.click();
	}

	public void clickRegister() {
		linkRegister.click();
	}

	public void setEmailId(String email) {
		linkEmail.sendKeys(email);
	}

	public void setPassword(String password) {
		linkPassword.sendKeys(password);
	}

	public void clickLoginButton() {
		btnLogin1.click();
	}

	public void clickMyAcLoginButton() {
		btnLogin2.click();
	}

}
