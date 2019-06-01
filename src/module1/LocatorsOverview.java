package module1;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsOverview {

	public static void main(String[] args) {

		// +++++++++++++ SET AND CONFIGURE DRIVER +++++++++++++++++++

		//System.setProperty("webdriver.chrome.driver", "C:\\Programas de Desarrollo\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// System.setProperty("webdriver.firefox.marionette","C:\\Programas de
		// Desarrollo\\WebDrivers\\geckodriver.exe");
		// WebDriver driver = new FirefoxDriver();

		// +++++++++++++++++++++++ WEB ELEMENTS ++++++++++++++++++++++++++++++++
		// Documentacion de Referencia:
		// https://www.guru99.com/find-element-selenium.html
		driver.get("http://demo.guru99.com/test/ajax.html");

		/*
		 * driver.findElementById(""); driver.findElementByName("");
		 * driver.findElementByClassName(""); driver.findElementByTagName("");
		 * driver.findElementByLinkText(""); driver.findElementByPartialLinkText("");
		 * driver.findElementByCssSelector(""); driver.findElementByXPath("");
		 */

		By id = By.id("someID");
		By name = By.name("name");//<<--
		By className = By.className("someClassName");
		By tagName = By.tagName("someTagName");
		By linkText = By.linkText("someLinkText");
		By partialLinkText = By.partialLinkText("somePartialLinkText");
		By cssSelector = By.cssSelector("somePartialLinkText");
		By xPath = By.xpath("somePartialLinkText");

		//Metodo 1
		WebElement we = driver.findElement(By.name("name"));
		
		//Metodo 2
		List<WebElement> elements = driver.findElements(name);
		

		System.out.println("Number of elements:" + elements.size());
		System.out.println("Element we:" + we.toString());

		for (int i = 0; i < elements.size(); i++) {
			System.out.println("Radio button text:" + elements.get(i).getAttribute("value"));
		}
		
		
		//TECNICAS COMPLEJAS PARA LOCALIZAR ELEMENTOS
		//Documento de apoyo para XPath https://www.guru99.com/xpath-selenium.html
		//Documento de apoyo para CssSelector: https://www.swtestacademy.com/css-selenium/
		
		
		/*------------- CssSelector ------------------
		 * Es el metodo mas practico para localizar elementos complejos
		 */
		By css1 = By.cssSelector(".btn.primary"); //elemento con ambas clases
		By css2 = By.cssSelector(".btn .primary"); //elemento btn y elmento primary
		By css3 = By.cssSelector(".btn > .primary"); //elemento btn y elmento primary directamente relacionados
		By css4 = By.cssSelector(".btn div span ul.primery");
		By css5 = By.cssSelector("input.btn a");
		By css6 = By.cssSelector("#send .primary div a");
		
		By css7 = By.cssSelector("input[id='xxxxx']");
		By css8 = By.cssSelector("input[id='xxxxx'].btn");
		By css9 = By.cssSelector("input[id='xxxxx'].btn div a");
		By css10 = By.cssSelector("input[id='xxxxx'].btn div a[tag='xxxxx']");
		
		//Expresiones Regulares
		By css11 = By.cssSelector("input[id^='xxxxx']");  //Que el id comienze con
		By css12 = By.cssSelector("input[id$='xxxxx']");  //Que el id termine con
		By css13 = By.cssSelector("input[id*='xxxxx']");  //Que el id contenga
		
		//Locate the first, last and nth child elements
		By css15 = By.cssSelector("body > *:first-child"); //Locates the first child element under the body tag
		By css16 = By.cssSelector("body > *:last-child");   //Locates the last child element under the body tag
		By css17 = By.cssSelector("body > *:nth-child(2)"); //Locates the 2nd child element under the body tab
		
		
		/* ------------- XPath------------------------
		 * Es el mas completo de los metodos
		 * Es la unica forma de seleccionar texto particular de una pagina web que no sea un link 
		 */
		
		//Full Path
		By xpath0 = By.xpath("//html/body/header/div[3]/div[1]/nav/ul/li[11]/div/div/a");
		By xpath1 = By.xpath("//div[@id='xxxxx']/div/a");
		
		//Relative Path Sintaxis: tag[@attribute='value']
		By xpath7 = By.xpath("//div[@class='xxxxx']");
		By xpath5 = By.xpath("//div[@id='xxxxx']");
		By xpath6 = By.xpath("//div[@class='xxxxx' and @type='button']");
		
		//Metodos avanzados para seleccionar texto
		By xpath2 = By.xpath("//div[text(), 'xxxxx']"); //div con texto concreto
		By xpath3 = By.xpath("//div[contains(text(), 'xxxxx')]"); //div que contenga texto
		By xpath4 = By.xpath("//div[starts-with(text(), 'xxxxx')]"); //div que inicie con texto
		
		By xpath20 = By.xpath("//div[contains(@name, 'xxxxx')]");
		By xpath21 = By.xpath("//*[contains(@id, 'xxxxx')]");
		
		//Busqueda de elementos child y parents
		By xpath8 = By.xpath("//div[@id='xxxxx']/parent::ul");
		By xpath9 = By.xpath("//div[@id='xxxxx']/child::li");
		By xpath10 = By.xpath("//div[@id='xxxxx']/child::li[2]");
		By xpath11 = By.xpath("//*[@type='submit']//preceding::input");
		
	}
}
