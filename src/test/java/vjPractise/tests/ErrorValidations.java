package vjPractise.tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import vjPractise.Testcomponents.BaseTest;
import vjPractise.Testcomponents.Retry;
import vjPractise.pageObjects.Cartpage;
import vjPractise.pageObjects.ProductCatalog;

public class ErrorValidations extends BaseTest {
	
	@Test (groups={"ErrorHandling"}, retryAnalyzer=Retry.class ,priority=1)
	public void loginErrorValidation() {
		lp.loginApplication("testvjvj@vj.com", "WelcomeJFM@2024");
		Assert.assertEquals("Incorrect email or password.", lp.getErrormessage());

	}
	
	@Test(groups= {"ErrorHandling"} ,priority=-1)
	public void EmailValidation() {
		lp.loginApplication("", "WelcomeJFM@2024");
		Assert.assertEquals("*Email is required", lp.getemailErrorValidation());
	}
	
	//checkPwdErrorValidation
	@Test(groups= {"ErrorHandling"} ,priority=-1)
	public void PwdValidation() {
		lp.loginApplication("Test", "");
		Assert.assertEquals("*Password is required", lp.checkPwdErrorValidation());
	}
	@Test
	public void productErrorvalidations() throws InterruptedException {
		String productname="ZARA COAT 3";
		ProductCatalog pc=lp.loginApplication("testvj@vj.com", "WelcomeJFM@2024");
		List<WebElement>products=pc.getProductList();
		pc.addProductToCart(productname);
		Cartpage cp=pc.goToCartPage();

		boolean match=cp.verifyProductDisplay(productname);
		Assert.assertTrue(match);
		
	}

}
