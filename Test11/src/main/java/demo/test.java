package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class test {
	ChromeDriver driver;
	@BeforeTest
	public void open() throws InterruptedException
	{
		driver = new ChromeDriver();
		Thread.sleep(3000);
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
	}
	@Test(priority = 1)
	public void login() throws InterruptedException
	{
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(2000);
	}
	@Test(priority = 2)
	public void addproduct() throws InterruptedException
	{
		driver.findElement(By.linkText("Sauce Labs Backpack")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("add-to-cart")).click();
		driver.findElement( By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("checkout")).click();
		Thread.sleep(2000);
	}
	
	@Test(priority = 3)
	public void confirmation() throws InterruptedException
	{
		driver.findElement(By.id("first-name")).sendKeys("prashanth");
		driver.findElement(By.id("last-name")).sendKeys("Boss");
		Thread.sleep(2000);
		driver.findElement(By.id("postal-code")).sendKeys("56125");
		Thread.sleep(2000);
		driver.findElement(By.id("continue")).click();
		Thread.sleep(2000);
	}
	
	@Test(priority = 4)
	public void finish() throws InterruptedException
	{
		driver.findElement(By.id("finish")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("back-to-products")).click();
	}
	@Test(priority = 5)
	public void Logout() throws InterruptedException
	{
		driver.findElement(By.id("react-burger-menu-btn")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("logout_sidebar_link")).click();
	}
	@AfterTest
	public void close()
	{
		driver.close();
	}
}