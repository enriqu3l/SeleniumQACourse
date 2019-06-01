package module1;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateOverview {
	public static ChromeDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		// +++++++++++++ SET AND CONFIGURE DRIVER +++++++++++++++++++
		//System.setProperty("webdriver.chrome.driver", "C:\\Programas de Desarrollo\\WebDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		// System.setProperty("webdriver.firefox.marionette","C:\\Programas de Desarrollo\\WebDrivers\\geckodriver.exe");
		// WebDriver driver = new FirefoxDriver();
		
		// +++++++++++++++++ NAVIGATE ++++++++++++++++++++++++++
		//Documentacion de Referencia: https://www.guru99.com/find-element-selenium.html
		
		String appUrl = "https://mx.nba.com";
		String appUrl2 = "https://www.nbatienda.com";
		driver.get(appUrl);
		
		// Click on Registration link
		driver.findElement(By.linkText("Videos")).click();
		System.out.println("Click on Videos");
		
		Thread.sleep(4000);
		
		// Go back to Home Page
		driver.navigate().back();
		System.out.println("Go Back");
		
		Thread.sleep(4000);
		
		// Go forward to Registration page
		driver.navigate().forward();
		System.out.println("Forward");
		
		Thread.sleep(4000);
		
		// Go back to Home page
		driver.navigate().to(appUrl2);
		System.out.println("Navigate To");
		
		Thread.sleep(4000);
		
		// Refresh browser
		driver.navigate().refresh();
		System.out.println("Refresh");
		
		// Close browser
		driver.close();
		System.out.println("Close");
	}

}
