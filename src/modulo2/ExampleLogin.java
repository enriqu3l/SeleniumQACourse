package modulo2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ExampleLogin {

	public static void main(String[] args) {
		
		WebDriver driver = BrowserFactory.startBrowser("chrome", "https://www.phptravels.net/");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		//Declaracion de web elements
		WebElement myAccount = driver.findElement(By.cssSelector("nav #li_myaccount > a"));
		WebElement login = driver.findElement(By.cssSelector("nav #li_myaccount li a"));
		
		
		//Ir a la pagina de Login
		myAccount.click();
		login.click();
		
		//Validar que estamos en la pagina de login
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.phptravels.net/login","ERROR - No estamos en la pagina de login!!");
		System.out.println("Si estamos en la pagina de Login!!!");
		
		//Declaracion de web Elements para la pagina de Login
		WebElement email = driver.findElement(By.name("username"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement loginButton = driver.findElement(By.className("loginbtn"));
		
		//Realizar el logueo
		email.sendKeys("user@phptravels.com");
		password.sendKeys("demouser");
		loginButton.click();
		
		
		//Esperar hasta llegar a la pagina de la cuenta
		wait.until(ExpectedConditions.urlContains("https://www.phptravels.net/account/"));
		
		//Validar que estamos logueados
		Assert.assertTrue(driver.findElement(By.cssSelector("img-responsive.go-right.img-thumbnail")).isDisplayed());
		System.out.println("Si entramos a nuestra cuenta!!");
	}
}
