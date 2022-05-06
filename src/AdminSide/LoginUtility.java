package AdminSide;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import graphql.Assert;

public class LoginUtility  extends Config {
	By email=By.xpath("/html/body/center/div/div[2]/div[2]/form[1]/div[1]/input");
	By password=By.xpath("/html/body/center/div/div[2]/div[2]/form[1]/div[2]/input");
	By loginHomePage=By.xpath("/html/body/div[1]/div[3]/button[2]");
	By loginButton=By.xpath("//button[contains(text(),'Login')]");
	
	public WebDriver login() throws IOException
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
	driver.findElement(email).sendKeys("tm1@gmail.com");
	driver.findElement(password).sendKeys("Mshoni0");
	driver.findElement(loginButton).click();
	return driver;

}


}
