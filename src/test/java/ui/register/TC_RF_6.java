package ui.register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_6 {
	@Test
 public void verifyNewsLetter()
 {
	 WebDriver driver=new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	 driver.get("https://tutorialsninja.com/demo/");
	 
	 driver.findElement(By.xpath("//a[@title='My Account']")).click();
	 driver.findElement(By.xpath("//a[text()='Register']")).click();
	 
	 driver.findElement(By.id("input-firstname")).sendKeys("aaa");
	 driver.findElement(By.id("input-lastname")).sendKeys("aa");
	 driver.findElement(By.id("input-email")).sendKeys("dawaq23222@gmail.com");
	 driver.findElement(By.id("input-telephone")).sendKeys("123457");
	 driver.findElement(By.id("input-password")).sendKeys("aaa12");
	 driver.findElement(By.id("input-confirm")).sendKeys("aaa12");
	 driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
	 driver.findElement(By.xpath("//input[@name='agree'][@value='0']")).click();
	 driver.findElement(By.xpath("//input[@value='Continue']")).click();

	 driver.findElement(By.xpath("//a[text()='Continue']")).click();
	 driver.findElement(By.linkText("Subscribe / unsubscribe to newsletter")).click();

Assert.assertTrue(driver.findElement(By.xpath("//input[@name='newsletter'][@value='0']")).isSelected());

driver.quit();
 }
}
