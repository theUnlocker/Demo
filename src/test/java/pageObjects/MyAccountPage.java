package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BaseClass {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "(//a[@class='list-group-item'][normalize-space()='Logout'])[1]")
	WebElement btnLogout;

	@FindBy(xpath = "//h2[text()='My Account']")
	WebElement MyAccountMsg;

	@FindBy(xpath = "//*[text()='Tablets']")
	WebElement tabletsButton;

	@FindBy(xpath = "//*[@class='product-thumb']/div/a/img[@title='Samsung Galaxy Tab 10.1']")
	WebElement samsungGalexyTabButton;

	@FindBy(xpath = "//*[@id='button-cart']")
	WebElement addToCartButton;

	@FindBy(xpath = "//*[@class='alert alert-success alert-dismissible']")
	WebElement addToCartSuccessMsg;

	public void clickAddToCartButton() {
		addToCartButton.click();
	}

	public void clickSamsungGalexyTabButton() {
		samsungGalexyTabButton.click();
	}

	public void clickLogoutButton() {
		btnLogout.click();
	}

	public void clickTabletsButton() {
		tabletsButton.click();
	}
	
	public String getAddToCartMsg() {
		return addToCartSuccessMsg.getText();
	}
	
	public boolean isMyAccountMsgDisplayed() {
		try {
			return MyAccountMsg.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isAddToCartMsgDisplyed() {
		try {
			return addToCartButton.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

}
