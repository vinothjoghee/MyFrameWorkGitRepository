package vjPractise.Testcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import vjPractise.pageObjects.LandingPage;

public class BaseTest {
	
	public WebDriver driver;
	public LandingPage lp=null;
	
	public WebDriver initializeDriver() throws IOException {
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//main/java//vjPractice//resources//GlobalData.properties");
		Properties p=new Properties();
		p.load(fis);
		String browsername=p.getProperty("browser");
		if(browsername.equalsIgnoreCase("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
	
		}
		else if(browsername.equalsIgnoreCase("firefox")) {
			//implement later
		}
		else if(browsername.equalsIgnoreCase("IE")) {
			//implement later
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
		
	}
      public List<HashMap<String, String>> getJsonDataToMap(String FilePath) throws IOException {
		
		//read json file to string
		String jsonContent=FileUtils.readFileToString(new File(FilePath),
				StandardCharsets.UTF_8);
		//String to hasp map- Jackson binding
		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String,String>> data=mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){	
		});
		return data;
	}
	
	@BeforeMethod(alwaysRun=true)
	public LandingPage launchApplication() throws IOException {
		driver=initializeDriver();
		lp=new LandingPage(driver);
		lp.goTo();
		return lp;
	}
	
	@AfterMethod(alwaysRun=true)
	public void closeBrowser() {
		driver.close();
		
	}
	

	public String getScreeshot(String testcaseName,WebDriver driver) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File destination=new File(System.getProperty("user.dir")+"//reports//"+testcaseName+".png");
		FileUtils.copyFile(source, destination);
		return System.getProperty("user.dir")+"//reports//"+testcaseName+".png";
		
	}
	

}
