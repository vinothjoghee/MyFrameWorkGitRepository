package vjPractise.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vjPractise.AbstractComponent.AbstractComponent;

public class ProductCatalog extends AbstractComponent{

	
	WebDriver driver=null;
	
	By addToCart=By.cssSelector(".card-body button:last-of-type");
	By productsBy=By.cssSelector(".mb-3");
	By toaster=By.cssSelector("#toast-container");
	
	@FindBy(css=".col-lg-4 ")
	List<WebElement> products;
	

	@FindBy(css=".ng-animating")
	WebElement spinner;
	

	
	
	public ProductCatalog(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public List<WebElement> getProductList() {
		waitForElemenToAppear(productsBy);
		return products;
	}
	
	public WebElement getProductByName(String productname) {
		WebElement prod=getProductList().stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productname)).
		findFirst().orElse(null);
		return prod;
		
	}
	
	public void addProductToCart(String ProductName) throws InterruptedException {
		WebElement prod=getProductByName(ProductName);
		prod.findElement(addToCart).click();
		waitForElemenToAppear(toaster);
		waitForElementToDisappear(spinner);
		
	}
	
	
}
