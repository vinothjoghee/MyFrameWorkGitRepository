package vjPractise.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vjPractise.AbstractComponent.AbstractComponent;

public class YourOrder extends AbstractComponent{
	
	WebDriver driver=null;

	public YourOrder(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//tbody/tr[1]/td[5]/button[1]")
	WebElement ClickViewbtn;

	
	 public OrderSummary ClickView() {
		 ClickViewbtn.click();
		 OrderSummary ordsum=new OrderSummary(driver);
		 return ordsum;
		 
		 
		 }
	public void VerifyOrder() {
		// TODO Auto-generated method stub
		System.out.println("Need to implement");

	}

}
