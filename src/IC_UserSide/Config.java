package IC_UserSide;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

	public Properties getProperties() throws IOException
	{
		Properties prop=new Properties();
		FileInputStream fs=new FileInputStream("D:\\Calorie_Fix_Test\\CFT\\src\\resource.properties");
		prop.load(fs);
		return prop;
	}
	
	
	public WebDriver  getChromeDriver() throws IOException
	{
		System.out.println(System.getProperty("user.dir"));
		

		Properties prop=getProperties();
		System.out.println(prop.getProperty("chromeDriver"));
		System.setProperty("webdriver.chrome.driver",prop.getProperty("chromeDriver"));
		WebDriver driver=new ChromeDriver();
		return driver;
		
		
	}
	public WebDriver getFirefoxDriver() throws IOException
	{
		Properties prop=getProperties();
		System.setProperty("webdriver.gecko.driver",prop.getProperty("firefoxDriver"));
		WebDriver driver=new FirefoxDriver();
		
		return driver;
	}
	public WebDriver getDriver() throws IOException
	{	
		WebDriver driver;
		int user_option=1;
		if(user_option==0)
		{
			 driver=getChromeDriver();
			
			
		}
		else 
		{
			 driver=getFirefoxDriver();
			
		}
	
		return driver;
	}

}
