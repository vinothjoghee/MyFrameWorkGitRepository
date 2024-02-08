package vjPractise.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vjPractise.AbstractComponent.AbstractComponent;

public class LandingPage extends AbstractComponent {
	WebDriver driver=null;
	//page object
	@FindBy(id="userEmail")
	WebElement username;
	@FindBy(id="userPassword")
	WebElement password;
	@FindBy(id="login")
	WebElement login;
	
	@FindBy(css=".invalid-feedback div")
	WebElement emailVal;
	
	@FindBy(xpath="//input[@id='userPassword']/following-sibling::div/div")
	WebElement pwdVal;

	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	public LandingPage(WebDriver driver) {
		super(driver);
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	
	public ProductCatalog loginApplication(String uname,String pwd) {
		username.sendKeys(uname);
		password.sendKeys(pwd);
		login.click();
		ProductCatalog pc=new ProductCatalog(driver);
		return pc;
	}
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client/");
	}
	
	public String getErrormessage() {
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}
	
	public String getemailErrorValidation() {
		//System.out.print(emailVal.getText());
		//waitForWebElementToAppear(emailVal);
		return emailVal.getText();
	}
	
	public String checkPwdErrorValidation() {
		return pwdVal.getText();
	}

}
