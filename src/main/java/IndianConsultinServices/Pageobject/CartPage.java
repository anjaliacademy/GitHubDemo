package IndianConsultinServices.Pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import IndianConsultinServices.Abstractcomponent.AbstractComponent;

public class CartPage extends AbstractComponent {
	WebDriver driver;
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//*[@class='cartSection']/h3")
	 private List<WebElement> cartItems;
	@FindBy(css=".totalRow button")
	 WebElement checkoutEle;
	
	public Boolean verifyProductDisplay(String Productname)
	{
		Boolean match=cartItems.stream().anyMatch(cart->cart.getText().equalsIgnoreCase(Productname));
		return match;
	}
	public checkOutPage goTocheckOutPage()
	{
		checkoutEle.click();
		checkOutPage checkout=new checkOutPage(driver);
		return checkout;

		
		
	}
	
	
	
	

}
