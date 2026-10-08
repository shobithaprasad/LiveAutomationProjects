package ui.register;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class TC_RF_010 {
	@Test
public void verifyRegisteringInvalidEmails() throws InterruptedException, IOException {
	WebDriver driver=new ChromeDriver();
	driver.get("https://tutorialsninja.com/demo/");
	driver.findElement(By.xpath("//a[@title='My Account']")).click();
	
	driver.findElement(By.linkText("Register")).click();
	driver.findElement(By.id("input-firstname")).sendKeys("shobi");
	driver.findElement(By.id("input-lastname")).sendKeys("pra");
	driver.findElement(By.id("input-email")).sendKeys("aa");
	driver.findElement(By.id("input-telephone")).sendKeys("1234567");
	driver.findElement(By.id("input-password")).sendKeys("shobi123");
	driver.findElement(By.id("input-confirm")).sendKeys("shobi123");
	driver.findElement(By.name("agree")).click();
	
	driver.findElement(By.xpath("//input[@value='Continue']")).click();
	
	Thread.sleep(3000);
	File srcScreenShot1=driver.findElement(By.xpath("//form[@class='form-horizontal']")).getScreenshotAs(OutputType.FILE);
	FileHandler.copy(srcScreenShot1, new File(System.getProperty("user.dir")+"\\Screenshots\\sc1Actual.png"));
	
	BufferedImage actialImag=ImageIO.read(new File(System.getProperty("user.dir")+"\\Screenshots\\sc1Actual.png"));
	BufferedImage expectedImage=ImageIO.read(new File(System.getProperty("user.dir")+"\\Screenshots\\sc1Expected.png"));
	
	ImageDiffer imgDiffer=new ImageDiffer();
	ImageDiff imgDifference=imgDiffer.makeDiff(expectedImage, actialImag);
	
	boolean b=imgDifference.hasDiff();
	System.out.println(b);
	
	driver.quit();
}
}
