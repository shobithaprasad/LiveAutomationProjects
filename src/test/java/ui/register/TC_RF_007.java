package ui.register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_007 {
	@Test
public void verifyNavigatingToDifferentRegistrationWays() {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	driver.get("https://tutorialsninja.com/demo/");
	
	driver.findElement(By.xpath("//a[@title='My Account']")).click();
	driver.findElement(By.xpath("//a[text()='Login']")).click();
	
	Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Login']")).isDisplayed());
	driver.findElement(By.linkText("Continue")).click();
	Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Register']")).isDisplayed());

	
	
	driver.findElement(By.xpath("//a[@title='My Account']")).click();
	driver.findElement(By.xpath("//a[text()='Register']")).click();
	Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Register']")).isDisplayed());
	
	driver.findElement(By.xpath("//a[@title='My Account']")).click();
	driver.findElement(By.xpath("//a[text()='Login']")).click();
	driver.findElement(By.xpath("//a[@class='list-group-item'][text()='Register']")).click();
	Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Register']")).isDisplayed());

	driver.quit();
	
	
}
}
