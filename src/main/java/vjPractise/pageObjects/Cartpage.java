package vjPractise.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vjPractise.AbstractComponent.AbstractComponent;

public class Cartpage extends AbstractComponent {
	WebDriver driver=null;
	
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProducts;
	@FindBy(css=".subtotal.cf.ng-star-inserted button")
	WebElement checkout;

	public Cartpage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyProductDisplay(String productname) {
		Boolean match=cartProducts.stream().anyMatch(product->product.getText().equalsIgnoreCase(productname));
		return match;
	}
	
	public CheckOutPage checkOut() {
		checkout.click();
		return new CheckOutPage(driver);
	}
	
	
}
