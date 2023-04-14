package IndianConsultinServices.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WindowPopup {

	public static void main(String[] args) {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\ANJALI\\Downloads\\seleniumGrid\\msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
		driver.get("https://admin:admin@the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Basic Auth")).click();
		
	}

}
