package IndianConsultinServices.Abstractcomponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import IndianConsultinServices.Pageobject.CartPage;
import IndianConsultinServices.Pageobject.checkOutPage;

public class AbstractComponent {
	WebDriver driver;
	public AbstractComponent(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="[routerlink*='cart']")
    WebElement cart;
	
	public CartPage goToCart()
	{
		cart.click();
		CartPage cartpage=new CartPage(driver);
		return cartpage;
	}
	public void waitForElement(By findby)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.visibilityOfElementLocated((findby)));
	}
	public void waitForelementDisapaer(WebElement ele)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	

}
