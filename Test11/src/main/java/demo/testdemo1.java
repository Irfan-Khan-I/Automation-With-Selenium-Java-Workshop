package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class testdemo1 
{
	@Test
	public void login()
	{
		ChromeDriver driver= new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		WebElement ListBox=driver.findElement(By.id("country"));
		Select select = new Select(ListBox);
//		Thread.sleep(1000);
		select.selectByValue("germany");
		Reporter.log("Test");
	}
}
