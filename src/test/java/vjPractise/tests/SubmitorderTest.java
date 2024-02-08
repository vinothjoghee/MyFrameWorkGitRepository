package vjPractise.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vjPractise.Testcomponents.BaseTest;
import vjPractise.pageObjects.Cartpage;
import vjPractise.pageObjects.CheckOutPage;
import vjPractise.pageObjects.ConfirmationPage;
import vjPractise.pageObjects.LandingPage;
import vjPractise.pageObjects.OrderSummary;
import vjPractise.pageObjects.ProductCatalog;
import vjPractise.pageObjects.YourOrder;

public class SubmitorderTest extends BaseTest {

	
	@Test(dataProvider="getdata", groups={"Purchase"})
	public void SubmitOrder(HashMap<String,String> input) throws IOException, InterruptedException {
		
		ProductCatalog pc=lp.loginApplication(input.get("uname"),input.get("pwd"));
		List<WebElement>products=pc.getProductList();
		pc.addProductToCart(input.get("productname"));
		Cartpage cp=pc.goToCartPage();

		boolean match=cp.verifyProductDisplay(input.get("productname"));
		Assert.assertTrue(match);
			CheckOutPage checkout=cp.checkOut();
			checkout.selectCountry("India");
			ConfirmationPage confrmpage=checkout.submitOrder();
			String confirmTextval=confrmpage.getconfirmationText();
			System.out.println(confirmTextval);
			Assert.assertTrue(confirmTextval.equalsIgnoreCase("THANKYOU FOR THE ORDER.") );
			/*YourOrder yo=confrmpage.ViewMyOrder();
			OrderSummary ordsum=yo.ClickView();
			String billemail=ordsum.verifybillingemail();
			System.out.println(billemail);
			*/
			//Assert.assertEquals("THANKYOU FOR THE ORDER", confirmTextval);		
		
	} 
	
	//parametrisation,data driven using JSON,Hashmap using JacksonBinding
	
    //Step 3:
	//data provider using JSON files.
	@DataProvider
	public Object[][] getdata() throws IOException {
	
		List<HashMap<String,String>> data=getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\vjPractise\\TestData\\PurchaseOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
}
	//Step 1:
/*//data provider using 2 dimensional array -normal
	@DataProvider()
	public Object[][] getData() {
		return new Object[][] {{"testvj@vj.com", "WelcomeJFM@2024","ZARA COAT 3"}, {"testvj@vj.com", "WelcomeJFM@2024","ZARA COAT 3"}};
	
	}*/

   //Step 2:
	//data provider using hashmap-key value pair
	//@DataProvider
	//public Object[][] getdata() throws IOException {
		//HashMap<String,String> map=new HashMap<String,String>();
		//map.put("uname", "testvj@vj.com");
		//map.put("pwd", "WelcomeJFM@2024");
		//map.put("productname", "ZARA COAT 3");
		//HashMap<String,String> map1=new HashMap<String,String>();
		//map1.put("uname", "testvj@vj.com");
		//map1.put("pwd", "WelcomeJFM@2024");
		//map1.put("productname", "ADIDAS ORIGINAL");
	//return new Object[][] {{map},{map1}};
