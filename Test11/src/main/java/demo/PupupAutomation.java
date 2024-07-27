package demo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class PupupAutomation {
	@Test
	public void Auto() throws InterruptedException {
		 ChromeDriver driver = new ChromeDriver();
	        
	        driver.get("https://practice-automation.com/popups/");
	        driver.manage().window().maximize();
	        // Handle the alert popup
	        WebElement alertButton = driver.findElement(By.id("alert"));
	        alertButton.click();
	        Thread.sleep(4000);
	        Alert alert = driver.switchTo().alert();
	        System.out.println("Alert Text: " + alert.getText());
	        alert.accept();

	        // Handle the confirmation popup
	        WebElement confirmButton = driver.findElement(By.id("confirm"));
	        confirmButton.click();
	        Alert confirmAlert = driver.switchTo().alert();
	        System.out.println("Confirm Text: " + confirmAlert.getText());
	        Thread.sleep(4000);
	        confirmAlert.accept();  // To accept the confirmation
	        // confirmAlert.dismiss();  // To dismiss the confirmation
	        Thread.sleep(4000);
	        WebElement promptButton = driver.findElement(By.id("prompt"));
	        promptButton.click();
	        Alert promptAlert = driver.switchTo().alert();
	        System.out.println("Prompt Text: " + promptAlert.getText());
	        promptAlert.sendKeys("irfan");
	        Thread.sleep(4000);
	        promptAlert.accept();
	        
	        // Print the result after handling the prompt
	        WebElement promptResult = driver.findElement(By.id("promptResult"));
	        System.out.println("Prompt Result: " + promptResult.getText());
	        Reporter.log("Testrep");
		
	}

}
