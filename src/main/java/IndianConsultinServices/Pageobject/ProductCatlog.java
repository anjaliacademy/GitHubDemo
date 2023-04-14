package IndianConsultinServices.Pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import IndianConsultinServices.Abstractcomponent.AbstractComponent;

public class ProductCatlog extends AbstractComponent {

	WebDriver driver;
	
	public ProductCatlog(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
//List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
	@FindBy(css=".mb-3")
	List<WebElement> products;
	@FindBy(css=".ng-animating")
    WebElement spinner;
	
	
	By productsBy=By.cssSelector(".mb-3");
	By addToCart=By.cssSelector(".card-body button:last-of-type");
	By toastMessage=By.cssSelector("#toast-container");
	public List<WebElement> getProductList()
	{
		waitForElement(productsBy);
		return products;
	}
	public WebElement getProductbyName(String Productname)
	{
		WebElement prod=getProductList().stream().filter(p->p.findElement(By.cssSelector("b")).getText().equals(Productname)).findFirst().orElse(null);
		return prod;
	}
	public void addItemToCart(String Productname)
	{
		WebElement prod=getProductbyName(Productname);
		prod.findElement(addToCart).click();
		waitForElement(toastMessage);
		waitForelementDisapaer(spinner);
		
	}

	
	
}
