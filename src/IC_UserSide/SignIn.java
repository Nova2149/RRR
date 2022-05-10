package IC_UserSide;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Properties;
//status-done
public class SignIn extends ProjectConfig {
    By user_email=By.xpath("//input[@id='user_email']");
    By user_password=By.xpath("//input[@id='user_password']");
    By login_btn=By.xpath("//button[contains(text(),'Login')]");
    By username_heading=By.xpath("//h1[contains(text(),\"Account\")]");
    By forgot_password_link=By.xpath("//a[contains(text(),'Forgot Password ?')]");
    @Test
    public void verify() throws IOException {
        WebDriver driver=getDriver();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_user_signin_url"));
        Assert.assertTrue(driver.getCurrentUrl().equals(prop.getProperty("ic_user_signin_url")));
        Assert.assertTrue(driver.getTitle().equals("Register"));
        Assert.assertTrue(driver.findElement(user_email).isEnabled());
        Assert.assertTrue(driver.findElement(user_password).isEnabled());
        Assert.assertTrue(driver.findElement(forgot_password_link).isEnabled());
        Assert.assertTrue(driver.findElement(login_btn).isEnabled());
        driver.quit();
    }
    //Login Successfull
    @Test
    public void t1() throws IOException {
        WebDriver driver=getDriver();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_user_signin_url"));
        driver.findElement(user_email).sendKeys("ad1@gmail.com");
        driver.findElement(user_password).sendKeys("Msdhoni0");
        driver.findElement(login_btn).click();
        Assert.assertTrue(driver.getCurrentUrl().equals(prop.getProperty("ic_user_myapplication_url")));
        Assert.assertTrue(driver.findElement(username_heading).getText().contains("Anthony"));
        driver.quit();


    }
    //Invalid Username
    @Test
    public void t2() throws IOException {
        WebDriver driver=getDriver();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_user_signin_url"));
        driver.findElement(user_email).sendKeys("ad1ducamo");
        driver.findElement(user_password).sendKeys("Msdhoni0");
        driver.findElement(login_btn).click();
        Alert a =driver.switchTo().alert();
        a.accept();
        driver.quit();

    }
    //Invalid Password
    @Test
    public void t3() throws IOException {
        WebDriver driver=getDriver();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_user_signin_url"));
        driver.findElement(user_email).sendKeys("ad1@gmail.com");
        driver.findElement(user_password).sendKeys("ffrwefref");
        driver.findElement(login_btn).click();
        Alert a =driver.switchTo().alert();
        a.accept();
        driver.quit();
    }
    //Empty username Field
    @Test
    public void tc4() throws IOException {
        WebDriver driver=getDriver();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_user_signin_url"));
        driver.findElement(user_email).sendKeys("");
        driver.findElement(user_password).sendKeys("ffrwefref");
        driver.findElement(login_btn).click();
        Alert a =driver.switchTo().alert();
        a.accept();
        driver.quit();
    }
    //Empty password Field
    @Test
    public void tc5() throws IOException {
        WebDriver driver=getDriver();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_user_signin_url"));
        driver.findElement(user_email).sendKeys("ad1@gmail.com");
        driver.findElement(user_password).sendKeys("");
        driver.findElement(login_btn).click();
        Alert a =driver.switchTo().alert();
        a.accept();
        driver.quit();
    }
    //Both Fields left Empty
    @Test
    public void tc6() throws IOException {
        WebDriver driver=getDriver();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_user_signin_url"));
        driver.findElement(user_email).sendKeys("");
        driver.findElement(user_password).sendKeys("");
        driver.findElement(login_btn).click();
        Alert a =driver.switchTo().alert();
        a.accept();
        driver.quit();
    }
}
