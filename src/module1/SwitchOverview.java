package module1;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchOverview {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// +++++++++++++ SET AND CONFIGURE DRIVER +++++++++++++++++++

		//System.setProperty("webdriver.chrome.driver", "C:\\Programas de Desarrollo\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// System.setProperty("webdriver.firefox.marionette","C:\\Programas de Desarrollo\\WebDrivers\\geckodriver.exe");
		// WebDriver driver = new FirefoxDriver();

		// +++++++++++++++++++++ El Metodo Switch +++++++++++++++++++++++++++++++
		// Documentacion de Referencia:
		// http://toolsqa.com/selenium-webdriver/switch-commands/

		/*
		 * El metodo switch sirve para 3 principales tareas
		 * 1.- Seleccionar una Alerta
		 * 2.- Cambiar de ventanas
		 * 3.- Seleccionar un iFrame
		 * 
		 * 1.- driver.switchTo().alert();
		 * 2.- driver.switchTo().window("");
		 * 3.- driver.switchTo().frame(1);
		 */

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// Launch the URL
		driver.get("http://toolsqa.wpengine.com/automation-practice-switch-windows/");

		// Store and Print the name of the First window on the console
		String handle = driver.getWindowHandle();
		System.out.println("Ventanas existentes al inicio:" + handle);

		// Click on the Button "New Message Window"
		//driver.findElement(By.xpath("div[@class='content']//button[text()='New Message Window']")).click();
		driver.findElement(By.id("button1")).click();
		
		// Store and Print the name of all the windows open
		Set<String> handles = driver.getWindowHandles();
		System.out.println("Ventanas existentes despues de dar click al boton: " + handles);

		
		// Pass a window handle to the other window
		System.out.println("Recorriendo las ventanas existentes una a una:: ");
		int i=0;
		for (String handle1 : driver.getWindowHandles()) {
			System.out.println("Switcheando a la Ventana "+i+": "+handle1);
			driver.switchTo().window(handle1);
			Thread.sleep(4000);
			System.out.println("Titulo de la ventana seleccionada: "+driver.getTitle());
			i++;
		}
		
		Thread.sleep(4000);

		// Cierra la ventana seleccionada
		driver.close();

		Thread.sleep(4000);
		
		// Cierra todas las ventanas del browser
		driver.quit();

	}

}
