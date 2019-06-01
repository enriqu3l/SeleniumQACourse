package module1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectOverview {

	public static void main(String[] args) throws InterruptedException {
		// +++++++++++++ SET AND CONFIGURE DRIVER +++++++++++++++++++
		//System.setProperty("webdriver.chrome.driver", "C:\\Programas de Desarrollo\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// System.setProperty("webdriver.firefox.marionette","C:\\Programas de
		// Desarrollo\\WebDrivers\\geckodriver.exe");
		// WebDriver driver = new FirefoxDriver();

		// +++++++++++++++++ NAVIGATE ++++++++++++++++++++++++++
		// Documentacion de Referencia:
		// https://www.guru99.com/select-option-dropdown-selenium-webdriver.html

		String baseURL = "http://demo.guru99.com/test/newtours/register.php";
		driver.get(baseURL);

		/*
		 * Metodos para selecionar items de un DropDown Option:
		 * 1.- selectByVisibleText - Segun lo que se muestre visible
		 * 2.- selectByValue - Segun lo que contenga el atributo "value"
		 * 3.- selectByIndex - Segun el indice en Base 0
		 */
		
		WebElement dropdown = driver.findElement(By.name("country"));
		
		Select drpCountry = new Select(dropdown);
		drpCountry.selectByVisibleText("ANTARCTICA");
		
		Thread.sleep(6000);
		
		//---------- Seleccionar multiples elementos ----------
		driver.get("http://jsbin.com/osebed/2");
		
		Select fruits = new Select(driver.findElement(By.id("fruits")));
		fruits.selectByVisibleText("Banana");
		fruits.selectByIndex(1);
	}

}
