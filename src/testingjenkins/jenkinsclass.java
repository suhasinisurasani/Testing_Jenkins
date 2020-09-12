package testingjenkins;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;

public class jenkinsclass
{
	 public static WebDriver driver=null;
	 public static WebDriverWait Wait=null;
	 
	  Logger log = Logger.getLogger(jenkinsclass.class);
	 
	 @Test
	public void display()
	{
   System.setProperty("webdriver.chrome.driver","C:\\Selenium-new-workspace\\Selenium\\drivers\\chromedriver.exe");
    driver=new ChromeDriver();
    log.info("Chrome browser is launched");
    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      Wait=new WebDriverWait(driver,10);
      driver.get("http://demo.automationtesting.in/Alerts.html");
       driver.findElement(By.xpath("//a[@href='#CancelTab']")).click();
       log.info("Clicked on cancel button");
      driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
      Alert alert=driver.switchTo().alert();
      String alertText=alert.getText();
      
      if(!alertText.isEmpty()) {
    	  log.info("Test Case Passed");
      }else {
    	  log.info("Test Case Failed");
      }
      
     System.out.println( alertText);
     
     
      alert.accept();
	}
	 
	 
	 @AfterTest
	 public void close() {
		 driver.quit();
	 }
}
