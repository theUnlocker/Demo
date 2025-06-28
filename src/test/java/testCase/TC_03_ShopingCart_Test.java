package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BaseClass;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;

public class TC_03_ShopingCart_Test extends BaseClass {

	@Test(groups = { "Functional", "Master" })
	public void shoppingCartTest() {
		HomePage hp = new HomePage(driver);
		MyAccountPage map = new MyAccountPage(driver);
		try {
			log.info("***Test Started**");
			hp.clickMyAccount();
			log.info("Clicked on My Account");
			hp.clickMyAcLoginButton();
			log.info("Clicked on login button");
			hp.setEmailId(prop.getProperty("Email2"));
			log.info("Entered email");
			hp.setPassword(prop.getProperty("Password"));
			log.info("Entered password");
			hp.clickLoginButton();
			log.info("Clicked login button");
			Thread.sleep(5000);
			map.clickTabletsButton();
			log.info("Clicked tablet button");
			map.clickSamsungGalexyTabButton();
			log.info("Clicked samsung tab button");
			map.clickAddToCartButton();
			log.info("Clicked add to cart button");
			Assert.assertEquals(map.isAddToCartMsgDisplyed(), true, map.getAddToCartMsg());
			log.info("***Test Completed**");
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
