package pageObjects;

import org.apache.commons.text.RandomStringGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class RegisterAccount extends BaseClass {
	public RegisterAccount(WebDriver driver) {

		super(driver);

	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtFirstName;

	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtLastName;

	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement txtTelephone;

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmail;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPassword;

	@FindBy(xpath = "(//input[@id='input-confirm'])[1]") //input[@id='input-confirm']
	WebElement txtConfirmPassword;

	@FindBy(xpath = "//input[@value='0']")
	WebElement btnSubscribeNo;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement btnPrivesyPolicy;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btnContinue;

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement confirmationText;

	public void setFirstName(String name) {
		txtFirstName.sendKeys(name);
	}

	public void setLastName(String lastName) {
		txtLastName.sendKeys(lastName);
	}

	public void setTelephone(String phone) {
		txtTelephone.sendKeys(phone);
	}

	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}

	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}

	public void setConfirmPassword(String pwd) {
		txtConfirmPassword.sendKeys(pwd);
	}

	public void clickSubscribeNO() {
		btnSubscribeNo.click();
	}

	public void clickPrivacyPolicy() {
		btnPrivesyPolicy.click();
	}

	public void clickContinue() {
		btnContinue.click();
	}

	public void verifyConfirmationMsg(String expectedMsg) {
	    String actualMsg = confirmationText.getText();
	    Assert.assertEquals(actualMsg, expectedMsg, "Confirmation message mismatch!");
	}

	
	

}
