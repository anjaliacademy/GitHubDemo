package IndianConsultinServices.testCaseComponent;


import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import IndianConsultinServices.Pageobject.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;
	public LoginPage loginpage;
	
	
	public WebDriver driverInitializer() throws IOException 
	{
		
		Properties prop=new Properties();
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\IndianConsultinServices\\resourses\\GlobalData.properties");
		prop.load(file);
		String browserName=prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
		WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
		    driver=new EdgeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			//firfox
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    driver.manage().window().maximize();
		return driver;
		
}
	@BeforeMethod
	public LoginPage launchApplication() throws IOException
	{
		driver=driverInitializer();
		loginpage=new LoginPage(driver);
		loginpage.goTo();
		return loginpage;
	}
	@AfterMethod
	public void closeWindow()
	{
		driver.close();
	}
	
	

}
