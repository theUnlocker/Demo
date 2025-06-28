package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.BaseClass;
import pageObjects.HomePage;
import pageObjects.RegisterAccount;

public class TC_01_AC_Creation extends BaseClass {
	@Test(groups = { "Regression", "Master" })
	public void mainTest() {
		log.info("--> Test has been started <--");
		try {
			HomePage hp = new HomePage(driver);
			RegisterAccount ra = new RegisterAccount(driver); // fixed class name

			hp.clickMyAccount();
			log.info("--clicked on my account--");

			hp.clickRegister();
			log.info("--clicked on account registration button--");

			ra.setFirstName(createFirstLastName());
			log.info("first name added");

			ra.setLastName(createFirstLastName());
			log.info("last name added");

			ra.setEmail(createEmail());
			log.info("email created");

			final String password = createPassword();
			ra.setPassword(password);
			log.info("password created");

			ra.setConfirmPassword(password);
			ra.setTelephone(createPhone());
			log.info("phone added");

			ra.clickSubscribeNO();
			log.info("subscription button clicked");

			ra.clickPrivacyPolicy();
			log.info("privacy policy checkbox clicked");

			ra.clickContinue();
			log.info("continue button clicked");

			// Assertion
			ra.verifyConfirmationMsg("Your Account Has Been Created!");
			log.info("Tested successfully!");

		} catch (Exception e) {
			log.error("Test has failed", e);
			Assert.fail("Test failed due to exception: " + e.getMessage());
		} finally {
			System.out.println("......END!");
		}
	}
}
