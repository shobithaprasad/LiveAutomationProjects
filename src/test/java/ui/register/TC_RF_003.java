package ui.register;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_003 {
	
	@Test
	public void VerifyRegistrationWitllAllFields() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.findElement(By.xpath("//a[@title='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		driver.findElement(By.id("input-firstname")).sendKeys("Shobi");
		driver.findElement(By.id("input-lastname")).sendKeys("1234");
		
		driver.findElement(By.id("input-email")).sendKeys(generateEmail());
		driver.findElement(By.id("input-telephone")).sendKeys("1234567");
		driver.findElement(By.id("input-password")).sendKeys("shobi123");
		driver.findElement(By.id("input-confirm")).sendKeys("shobi123");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@name='newsletter' and @value='1']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Success']")).isDisplayed());
		
		String ActualDetail1="Congratulations! Your new account has been successfully created!";
		String ActualDetail2="You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String ActualDetail3="If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		String ActualDetail4="A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please";
		String ActualDetail5=" contact us.";
		
		String ExpectedDetails=driver.findElement(By.id("content")).getText();
		
		
		Assert.assertTrue(ExpectedDetails.contains(ActualDetail1));
		Assert.assertTrue(ExpectedDetails.contains(ActualDetail2));
		Assert.assertTrue(ExpectedDetails.contains(ActualDetail3));
		Assert.assertTrue(ExpectedDetails.contains(ActualDetail4));
		Assert.assertTrue(ExpectedDetails.contains(ActualDetail5));
		
		
	}
	
	public String generateEmail()
	{
		Date date=new Date();
		String dateString=date.toString();
		String noSpaceString=dateString.replaceAll(" ","");
		String noColonString=noSpaceString.replaceAll(":", "");
		String emailWithTimeStamp=noColonString+"@gmail.com";
		return(emailWithTimeStamp);
	}
}
