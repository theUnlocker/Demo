package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BaseClass;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import utilities.DataProviders;
import utilities.ExcelUtilsV2;

public class TC_02_LoginData_Test extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups = { "Sanity", "Master" })
	public void Login(String email, String password, String expectedResult) {
		log.info("Test started with email: " + email + ", expected result: " + expectedResult);

		try {
			HomePage hp = new HomePage(driver);
			MyAccountPage map = new MyAccountPage(driver);

			hp.clickMyAccount();
			log.info("Clicked on My Account");

			hp.clickMyAcLoginButton();
			log.info("Clicked on login button");

			hp.setEmailId(email);
			log.info("Entered email");

			hp.setPassword(password);
			log.info("Entered password");

			hp.clickLoginButton();
			log.info("Clicked login button");

			boolean targetPage = map.isMyAccountMsgDisplayed();
			System.out.println("Is My Account page displayed? " + targetPage);

			if (expectedResult.equalsIgnoreCase("valid")) {
				if (targetPage) {
					System.out.println("✅ Test Passed for valid user");

					map.clickLogoutButton();
					log.info("Logged out after successful login");
					Assert.assertTrue(true);
				} else {
					System.out.println("❌ Test Failed for valid user: Login failed");
					Assert.fail("Login failed but expected valid login.");
				}
			} else if (expectedResult.equalsIgnoreCase("invalid")) {
				if (targetPage) {
					System.out.println("❌ Test Failed for invalid user: Login succeeded");
					map.clickLogoutButton();
					Assert.fail("Login succeeded but expected invalid login.");
				} else {
					System.out.println("❌ Test Failed for invalid user: Login failed");
					Assert.fail("Invalid user login failed as expected, but test is set to fail.");
				}
			} else {
				System.out.println("❓ Unexpected expectedResult value: " + expectedResult);
				Assert.fail("Invalid expectedResult value in test data.");
			}

		} catch (Exception e) {
			log.error("Exception in test: ", e);
			Assert.fail("Exception occurred during test execution.");
		}

		log.info("Test completed");
	}
}
