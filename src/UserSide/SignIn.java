package UserSide;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import graphql.Assert;
//Testing-done
public class SignIn extends Config{
	By email=By.xpath("/html/body/center/div/div[2]/div[2]/form[1]/div[1]/input");
	By password=By.xpath("/html/body/center/div/div[2]/div[2]/form[1]/div[2]/input");
	By loginHomePage=By.xpath("/html/body/div[1]/div[3]/button[2]");
	By loginButton=By.xpath("//button[contains(text(),'Login')]");
	
	
	
	//Best Case Scenario
	//User is able to login successfully into the application;@

	@Test
	public void t1() throws IOException
	{
		WebDriver driver=getDriver();
		Properties prop=getProperties();
		System.out.println(prop.getProperty("homePageUrl"));
		driver.get(prop.getProperty("homePageUrl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Assert.assertTrue(driver.getCurrentUrl().equals(prop.getProperty("homePageUrl")));
		driver.findElement(loginHomePage).click();
	
		Assert.assertTrue(driver.getCurrentUrl().equals(prop.getProperty("registertaionPageUrl")));
		driver.findElement(email).sendKeys("mayanktagra1@gmail.com");
		driver.findElement(password).sendKeys("Msdhoni0");
		driver.findElement(loginButton).click();
	
		
		//Assert.assertTrue(driver.getCurrentUrl().equals(prop.getProperty("LoginnedHomePage")));
		System.out.println("--End of Script--");
		driver.quit();
		
		
	}
	//Invalid Credentials
	//USer is unable to login ,Alert box should show up

	@Test
	public void t2() throws IOException, InterruptedException
	{
		WebDriver driver=getDriver();
		Properties prop=getProperties();
		System.out.println(prop.getProperty("homePageUrl"));
		driver.get(prop.getProperty("homePageUrl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Assert.assertTrue(driver.getCurrentUrl().equals(prop.getProperty("homePageUrl")));
		driver.findElement(loginHomePage).click();
		
		Assert.assertTrue(driver.getCurrentUrl().equals(prop.getProperty("registertaionPageUrl")));
		driver.findElement(email).sendKeys("ronaldo1@gmail.com");
		driver.findElement(password).sendKeys("Msdhoni0");
		driver.findElement(loginButton).click();
		Thread.sleep(1200);
		Alert a=driver.switchTo().alert();
		a.accept();
		
		System.out.println("--End of Script--");
		driver.quit();
		
		
		
		
		
		
		
	}

}
