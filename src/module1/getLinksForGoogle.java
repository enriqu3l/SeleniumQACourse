package module1;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class getLinksForGoogle {

	public static void main(String[] args) throws InterruptedException {

		// +++++++++++++ SET AND CONFIGURE DRIVER +++++++++++++++++++
		// System.setProperty("webdriver.chrome.driver", "C:\\Programas de
		// Desarrollo\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// System.setProperty("webdriver.firefox.marionette","C:\\Programas de
		// Desarrollo\\WebDrivers\\geckodriver.exe");
		// WebDriver driver = new FirefoxDriver();

		String baseUrl = "https://google.com";

		// launch Fire fox and direct it to the Base URL
		driver.get(baseUrl);
		Thread.sleep(3000);
		
		//Actividad: Como posicionar la ventana en un lugar especifico de la pantalla? 
		
		
		WebElement busqueda = driver.findElement(By.name("q"));
		busqueda.sendKeys("auto");
		busqueda.sendKeys(Keys.ENTER);
		
		//Obtener todos los bloques de resultados 
		List<WebElement> listado = driver.findElements(By.className("g"));
		
		for(WebElement e : listado) {
			//Buscamos el link
			WebElement link = e.findElement(By.cssSelector(".r a h3"));
			
			//Imprimimos log del texto del link
			System.out.println(link.getText());
		}

		// Cerrar el Browser
		driver.quit();

	}
}
