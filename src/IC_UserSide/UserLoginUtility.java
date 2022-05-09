package IC_UserSide;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Properties;

public class UserLoginUtility extends ProjectConfig {
    By user_email = By.xpath("//input[@id='user_email']");
    By user_password = By.xpath("//input[@id='user_password']");
    By login_btn = By.xpath("//button[contains(text(),'Login')]");
    By username_heading = By.xpath("//h1[contains(text(),\"Account\")]");

    public WebDriver loginUser() throws IOException {
        WebDriver driver = getDriver();
        Properties prop = getProperties();
        driver.get(prop.getProperty("ic_user_signin_url"));
        driver.manage().window().maximize();
        driver.findElement(user_email).sendKeys("ad1@gmail.com");
        driver.findElement(user_password).sendKeys("Msdhoni0");
        driver.findElement(login_btn).click();
        Assert.assertTrue(driver.getCurrentUrl().equals(prop.getProperty("ic_user_myapplication_url")));

        return driver;
    }
}
