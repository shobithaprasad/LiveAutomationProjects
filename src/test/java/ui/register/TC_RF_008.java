package ui.register;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_008 {
	@Test
public void verifyConfirmPassword() {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://tutorialsninja.com/demo/");
	
	driver.findElement(By.xpath("//a[@title='My Account']")).click();
	driver.findElement(By.linkText("Register")).click();
	
	driver.findElement(By.id("input-firstname")).sendKeys("shobi");
	driver.findElement(By.id("input-lastname")).sendKeys("pra");
	driver.findElement(By.id("input-email")).sendKeys(generateNewEmail());
	driver.findElement(By.id("input-telephone")).sendKeys("1234567");
	driver.findElement(By.id("input-password")).sendKeys("shobi123");
	driver.findElement(By.id("input-confirm")).sendKeys("1234");
	driver.findElement(By.name("agree")).click();
	driver.findElement(By.xpath("//input[@value='Continue']")).click();
	String errorMessage="Password confirmation does not match password!";
	
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-confirm']/following-sibling::div")).getText(), errorMessage);
	driver.quit();
}
	public String generateNewEmail() {
		Date date=new Date();
		String dateString=date.toString();
		String noSpaceString=dateString.replaceAll(" ","");
		String noColonString=noSpaceString.replaceAll(":", "");
		String emailWithTimeStamp=noColonString+"@gmail.com";
		return(emailWithTimeStamp);
	}
}
