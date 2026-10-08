package ui.register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_009 {
	@Test
	public void verifyRegisteringExistingEmailAccount() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//a[@title='My Account']")).click();
		
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("shobi");
		driver.findElement(By.id("input-lastname")).sendKeys("pra");
		driver.findElement(By.id("input-email")).sendKeys("aa@aa.com");
		driver.findElement(By.id("input-telephone")).sendKeys("1234567");
		driver.findElement(By.id("input-password")).sendKeys("shobi123");
		driver.findElement(By.id("input-confirm")).sendKeys("shobi123");
		driver.findElement(By.name("agree")).click();
		
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		String ExpectedWarning=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		String actualWarning="Warning: E-Mail Address is already registered!";
		
		Assert.assertEquals(ExpectedWarning, actualWarning);
		
		driver.quit();
	}

}
