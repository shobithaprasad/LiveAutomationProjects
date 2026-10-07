package ui.register;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_001 {

	@Test
	public void VerifyRegistration() {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//a[@title='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		driver.findElement(By.id("input-firstname")).sendKeys("shobi");
		driver.findElement(By.id("input-lastname")).sendKeys("pra");
		driver.findElement(By.id("input-email")).sendKeys(generateNewEmail());
		driver.findElement(By.id("input-telephone")).sendKeys("1234567");
		driver.findElement(By.id("input-password")).sendKeys("shobi123");
		driver.findElement(By.id("input-confirm")).sendKeys("shobi123");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
		String actualText=driver.findElement(By.xpath("//div[@id='common-success']//h1")).getText();
		String expectedText="Your Account Has Been Created!";
		Assert.assertEquals(actualText, expectedText);
		
		String actualText1="Congratulations! Your new account has been successfully created!";
		String actualText2="You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String actualText3="If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		String actualText4="A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please";
		String actualText5="contact us";
		String expectedTexts=driver.findElement(By.id("content")).getText();
		Assert.assertTrue(expectedTexts.contains(actualText1));
		Assert.assertTrue(expectedTexts.contains(actualText2));
		Assert.assertTrue(expectedTexts.contains(actualText3));
		Assert.assertTrue(expectedTexts.contains(actualText4));
		Assert.assertTrue(expectedTexts.contains(actualText5));
		
		driver.findElement(By.xpath("//a[text()='Continue']")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		driver.close();
	}
	
	public String generateNewEmail() {
		Date date=new Date();
		String dateString=date.toString();
		String noSpaceString=dateString.replaceAll(" ","");
		String noColonString=noSpaceString.replaceAll(":", "");
		String emailWithTimeStamp=noColonString+"@gmail.com";
		return emailWithTimeStamp;
		
	}

}
