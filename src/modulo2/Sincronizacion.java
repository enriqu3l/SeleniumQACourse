package modulo2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sincronizacion {

	public static void main(String[] args) {
		
		//Documentacion
		//https://www.guru99.com/implicit-explicit-waits-selenium.html
		
		WebDriver driver = BrowserFactory.startBrowser("chrom", "https://www.phptravels.net/");
		
		//Timeout
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//Implicit Waits
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		//Explicit Waits
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains("Title"));
		
		
	}
}
