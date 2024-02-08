package vjPractise.AbstractComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import vjPractise.pageObjects.Cartpage;
import vjPractise.pageObjects.YourOrder;

public class AbstractComponent {
	

	WebDriver driver=null;
	
	@FindBy(css="button[routerlink*='cart']")
	WebElement CartHeader;

	@FindBy(css="button[routerlink*='myorders']")
	WebElement MyOrderHeader;

	public AbstractComponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void waitForElemenToAppear(By findBy) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
		
	}
	
	public void waitForWebElementToAppear(WebElement ele) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(ele));
		
	}
	public void waitForElementToDisappear(WebElement ele) throws InterruptedException {
		//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		//wait.until(ExpectedConditions.invisibilityOf(ele));
		Thread.sleep(2000);
	}
	
	public Cartpage goToCartPage() {
		CartHeader.click();
		Cartpage cp=new Cartpage(driver);
		return cp;
	}
	
	public YourOrder ViewMyOrder() throws InterruptedException  {
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
	    js.executeScript("window.scrollBy(1000,-100)");
	    Thread.sleep(2000);
		MyOrderHeader.click();
		YourOrder yourord=new YourOrder(driver);
		return yourord;
	}

}
