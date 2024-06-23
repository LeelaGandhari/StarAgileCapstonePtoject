package Scenario_1;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test
;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;

public class HRMTest {
  @Test(dataProvider="ExcelData",dataProviderClass=CustomData.class)
  public void login(String un,String pwd) throws InterruptedException {
	  
	  WebDriver driver = new ChromeDriver();
	  //driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  
	  driver.findElement(By.name("username")).sendKeys(un); //username
	  driver.findElement(By.name("password")).sendKeys(pwd);//password
	  
	  Utility.captureScreenshot(driver);//screenshot utility
	  
	  driver.findElement(By.xpath("//button[@type='submit']")).click();//login
	  Thread.sleep(500);

	 
	
	  //assertion
	   Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"),"Login Failed");
	   System.out.println("Login Successful");
	   
	driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/header[1]/div[1]/div[2]/ul[1]/li[1]/ul[1]/li[4]/a[1]")).click();
    driver.findElement(By.linkText("Logout"));//Logout
			
	   
	   
	  }
}





















	  