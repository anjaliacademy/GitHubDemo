package IndianConsultinServices.tests;

import java.io.IOException;
//import java.util.concurrent.TimeUnit;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
public class AutoIt {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException, InterruptedException {
		String dowmloaded_file_path=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ANJALI\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		driver.get("https://pdfcandy.com/");
		driver.findElement(By.cssSelector("[class*='addbutton']")).click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\Users\\ANJALI\\Documents\\SeleniumGrid\\FileUpload.exe");
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("To JPG")));
	    driver.findElement(By.linkText("To JPG")).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Convert PDF")));
	    driver.findElement(By.linkText("Convert PDF")).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[class='result__button-download']")));
	    driver.findElement(By.cssSelector("a[class='result__button-download']")).click();
	    File f=new File(dowmloaded_file_path+"/font anju.jpg");
	    if(f.exists())
	    {
	    	System.out.println("file found");
	    }
	    
	
	}

}
