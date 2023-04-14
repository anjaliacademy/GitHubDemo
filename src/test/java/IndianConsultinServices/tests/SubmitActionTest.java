package IndianConsultinServices.tests;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import IndianConsultinServices.Pageobject.LoginPage;
import IndianConsultinServices.Pageobject.ProductCatlog;
import IndianConsultinServices.Pageobject.CartPage;
import IndianConsultinServices.Pageobject.ConfirmationPage;
import IndianConsultinServices.Pageobject.checkOutPage;
import IndianConsultinServices.testCaseComponent.BaseTest;


public class SubmitActionTest extends BaseTest {

@Test
	public void submit() throws IOException
	{
		ProductCatlog productcatalog=loginpage.loginAction("radhu@gmail.com", "Radhu@123");
		String Productname="ZARA COAT 3";
		List<WebElement> products=productcatalog.getProductList();
		productcatalog.addItemToCart(Productname);
		CartPage cartpage=productcatalog.goToCart();
		Boolean match=cartpage.verifyProductDisplay(Productname);
		Assert.assertTrue(match);
		checkOutPage checkout=cartpage.goTocheckOutPage();
		checkout.selectCountry("india");
		ConfirmationPage confirm=checkout.submitOrder();
		String msg=confirm.verifyMessage();
		Assert.assertTrue(msg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
}

	
	
	}






/*JavascriptExecutor executor=(JavascriptExecutor)driver;
executor.executeScript("arguments[0].click();", placeorder);*/