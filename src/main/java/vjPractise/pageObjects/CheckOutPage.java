package vjPractise.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import vjPractise.AbstractComponent.AbstractComponent;

public class CheckOutPage extends AbstractComponent{

	WebDriver driver=null; 
	

	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement country;
	
	@FindBy(css=".action__submit")
	WebElement submitButton;
	By btn=By.cssSelector(".action__submit");
	
	@FindBy(css=".ta-results button:nth-last-child(1)")
	WebElement selectCountry;

	public CheckOutPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	By results=By.cssSelector(".ta-results");
	
	   public void selectCountry(String CountryName) {
		   Actions a=new Actions(driver);
			a.sendKeys(country, CountryName).build().perform();
			waitForElemenToAppear(By.cssSelector(".ta-results"));
			selectCountry.click();
		   
	   }
	   
	   public ConfirmationPage submitOrder() {
		   JavascriptExecutor js=(JavascriptExecutor)driver;
		    js.executeScript("window.scrollBy(0,1000)");
		    waitForElemenToAppear(btn);
		   submitButton.click();
		   return new ConfirmationPage(driver);
	   }
	

}
