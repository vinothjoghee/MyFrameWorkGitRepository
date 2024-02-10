package vjPractise.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import vjPractise.AbstractComponent.AbstractComponent;

public class Register extends AbstractComponent  {
	WebDriver driver;

	@FindBy(id="firstName")
	WebElement fname;
	@FindBy(id="lastName")
	WebElement lname;
	@FindBy(id="userEmail")
	WebElement eMail;
	@FindBy(id="userMobile")
	WebElement ph;
	//method1
	@FindBy(xpath="//select[@formcontrolname='occupation']")
	WebElement occupation1;
	//Mehtod2:
	@FindBy(xpath="//select[@formcontrolname='occupation']/option")
	List<WebElement> occupation2;
	@FindBy (css="input[value='Male']")
	WebElement gender;
	@FindBy(id="userPassword")
	WebElement upwd;
	@FindBy(id="confirmPassword")
	WebElement cpwd;
	@FindBy(css="input[type='checkbox']")
	WebElement chkbox;
	@FindBy(id="login")
	WebElement login;
	
	
	
	public Register(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void Registerationdetails(String firname,String lastname, String email,String phone,String occ,String usrpwd,String cnpwd)
	{
	   fname.sendKeys(firname);	
	   lname.sendKeys(lastname);
	   eMail.sendKeys(email);
	   ph.sendKeys(phone);
	   Select s=new Select(occupation1);
	   s.selectByVisibleText(occ);
	   gender.click();
	   upwd.sendKeys(usrpwd);
	   cpwd.sendKeys(cnpwd);
	   chkbox.click();
	   login.click();
	   
	}

}
