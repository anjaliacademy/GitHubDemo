package IndianConsultinServices.Pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import IndianConsultinServices.Abstractcomponent.AbstractComponent;

public class checkOutPage extends AbstractComponent {
	WebDriver driver;
	public checkOutPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	@FindBy(css=".action__submit")
	WebElement submit;
	@FindBy(css=".ta-item:nth-of-type(2)")
	WebElement selectItem;
	
	public void selectCountry(String counrtyName)
	{
		Actions a=new Actions(driver);
		a.sendKeys(country, counrtyName).build().perform();
		waitForElement(By.cssSelector(".ta-results"));
		selectItem.click();
	}
	public ConfirmationPage submitOrder()
	{
		submit.click();
		ConfirmationPage confirm=new ConfirmationPage(driver);
		return confirm;
	}

}
