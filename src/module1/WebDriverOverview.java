package module1;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverOverview {

	public static void main(String[] args) throws InterruptedException {

		// +++++++++++++ SET AND CONFIGURE DRIVER +++++++++++++++++++
		// System.setProperty("webdriver.chrome.driver", "C:\\Programas de
		// Desarrollo\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// System.setProperty("webdriver.firefox.marionette","C:\\Programas de
		// Desarrollo\\WebDrivers\\geckodriver.exe");
		// WebDriver driver = new FirefoxDriver();

		String baseUrl = "https://mx.nba.com";
		String expectedTitle = "El sitio oficial de la NBA | NBA.com";
		String actualTitle = "";
		String currentUrl = "";

		/*
		 * Metodos Basicos de Webdriver:
		 * 
		 * - get(); Load a new web page in the current browser window.
		 * 
		 * - getCurentUrl(); Get a string representing the current URL that the browser
		 * is looking at.
		 * 
		 * - getTitle() The title of the current page
		 * 
		 * - getPageSource() Get the source of the last loaded page.
		 * 
		 * - quit(); Quits this driver, closing every associated window.
		 * 
		 * - close(); Close the current window, quitting the browser if it's the last
		 * window currently open.
		 * 
		 * - driver.manage().window().maximize(); Maximize window
		 * 
		 * - driver.manage().window().fullscreen(); FullScreen
		 * 
		 * - driver.manage().window().setSize(new Dimension(700,400));
		 * 
		 * 
		 */

		// launch Fire fox and direct it to the Base URL
		driver.get(baseUrl);

		// get the actual value of the title
		actualTitle = driver.getTitle();
		System.out.println("Current title: " + actualTitle);

		// get the actual value of the title
		currentUrl = driver.getCurrentUrl();
		System.out.println("Current Url: " + currentUrl);

		Thread.sleep(3000);

		// Maximizar
		driver.manage().window().maximize();
		System.out.println("Maximized");

		Thread.sleep(3000);

		// FullScreen
		driver.manage().window().fullscreen();
		System.out.println("FullScreen");

		Thread.sleep(3000);

		// Setear un tamaño especifico
		driver.manage().window().setSize(new Dimension(700, 400));
		System.out.println("Set Size");

		Thread.sleep(3000);
		
		//Actividad: Como posicionar la ventana en un lugar especifico de la pantalla? 
		
		
		// Comparar el titulo de la pagina con el esperado
		if (actualTitle.contentEquals(expectedTitle)) {
			System.out.println("Test Passed!");
		} else {
			System.out.println("Test Failed");
		}

		// Cerrar la ventana activa
		driver.close();

		// Cerrar el Browser
		// driver.quit();

	}
}
