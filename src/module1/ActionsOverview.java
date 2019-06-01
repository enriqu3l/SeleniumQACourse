package module1;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionsOverview {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Documento de referencia https://www.guru99.com/keyboard-mouse-events-files-webdriver.html
		
		String baseUrl = "http://www.facebook.com/"; 
		WebDriver driver = new ChromeDriver();
		
		driver.get(baseUrl);
		WebElement txtUsername = driver.findElement(By.id("email"));
		
		Actions builder = new Actions(driver);
		Action seriesOfActions = builder
			.moveToElement(txtUsername)
			.click()
			.keyDown(txtUsername, Keys.SHIFT)
			.sendKeys(txtUsername, "hello")
			.keyUp(txtUsername, Keys.SHIFT)
			.doubleClick(txtUsername)
			.contextClick()
			.build();
			
		seriesOfActions.perform();
		
		
		//+++++++++++++++++++++ DRAG AND DROP +++++++++++++++++++++++++++++++++
		
		//ChromeDriver d = new ChromeDriver();
		Actions a = new Actions(driver);
		driver.get("http://jqueryui.com/droppable/");
		
		driver.switchTo().frame(0);
		
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));
		
		a.dragAndDrop(drag, drop).perform();
		a.contextClick(drag).perform();
		
		
	}

}
