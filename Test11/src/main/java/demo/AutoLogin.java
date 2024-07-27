package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AutoLogin 
{
	ChromeDriver driver;
	@BeforeTest
	public void open() throws InterruptedException
	{
		driver = new ChromeDriver();
		Thread.sleep(3000);
		driver.manage().window().maximize();
		driver.get("https://practicetestautomation.com/practice-test-login/");
	}
	@Test(priority = 1)
	public void login() throws InterruptedException
	{
		driver.findElement(By.id("username")).sendKeys("student");
		driver.findElement(By.id("password")).sendKeys("Password123");
		driver.findElement(By.id("submit")).click();
		Thread.sleep(2000);
	}
	@Test(priority = 2)
	public void plussin() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@id=\"loop-container\"]/div/article/div[2]/div/div/div/a")).click();

	}
	
	@Test(priority = 3)
	public void confirmation() throws InterruptedException
	{
		driver.findElement(By.id("first-name")).sendKeys("prashanth");
		
	}
	
	@Test(priority = 4)
	public void finish() throws InterruptedException
	{
		driver.findElement(By.id("finish")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("back-to-products")).click();
	}
//	@Test(priority = 5)
//	public void Logout() throws InterruptedException
//	{
//		driver.findElement(By.id("react-burger-menu-btn")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.id("logout_sidebar_link")).click();
//	}
	@AfterTest
	public void close()
	{
		driver.close();
	}
}