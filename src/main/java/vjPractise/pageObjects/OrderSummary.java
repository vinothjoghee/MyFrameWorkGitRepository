package vjPractise.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vjPractise.AbstractComponent.AbstractComponent;

public class OrderSummary extends AbstractComponent {

	WebDriver driver=null;
	
	@FindBy(xpath="//div[@class=\"email-wrapper ng-star-inserted\"]//div[1]//div[1]//p[1]")
	WebElement billingemail;
	public OrderSummary(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String verifybillingemail() {
		return billingemail.getText();
	}
	

}
