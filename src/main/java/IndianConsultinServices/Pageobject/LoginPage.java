package IndianConsultinServices.Pageobject;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import IndianConsultinServices.Abstractcomponent.AbstractComponent;

public class LoginPage extends  AbstractComponent {

	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//WebElement userEmail=driver.findElement(By.id("userEmail"));
	@FindBy(id="userEmail")
	WebElement userEmail;
	@FindBy(id="userPassword")
	WebElement password;
	@FindBy(id="login")
	WebElement submit;
	public ProductCatlog loginAction(String email,String pwd)
	{
		userEmail.sendKeys(email);
		password.sendKeys(pwd);
		submit.click();
		ProductCatlog productcatalog=new ProductCatlog(driver);
		return productcatalog; 
		
	}
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	
}
