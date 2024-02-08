package vjPractise.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vjPractise.AbstractComponent.AbstractComponent;

public class ConfirmationPage extends AbstractComponent {

	WebDriver driver=null;
	public ConfirmationPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".box h1")
	WebElement actualmsg;
	
	
	public String getconfirmationText() {
		return actualmsg.getText();
		
	}

}
