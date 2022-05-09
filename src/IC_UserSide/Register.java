package IC_UserSide;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Properties;

public class Register extends ProjectConfig {

    //navBarLinks
    By register_option=By.xpath("//label[contains(text(),'Signup')]");
    By family_name=By.xpath("//input[@id='user_family_name']");
    By given_name=By.xpath("//input[@id='user_given_name']");
    By phone=By.xpath("//input[@id='user_phone']");
    By email=By.xpath("//input[@id='u_email']");
    By confirm_email=By.xpath("//input[@id='user_confirm_email']");
    By password=By.xpath("//input[@id='u_password']");
    By confirm_password=By.xpath("//input[@id='user_confirm_password']");
    By security1=By.xpath("//input[@id='user_security1']");
    By security2=By.xpath("//input[@id='user_security2']");
    By security3=By.xpath("//input[@id='user_security3']");
    By regitser_button=By.xpath("//button[contains(text(),'Register')]");


    @Test
    public void Verify() throws IOException {
        WebDriver driver=getDriver();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_user_signin_url"));
        driver.findElement(register_option).click();
        Assert.assertTrue(driver.getCurrentUrl().equals(prop.getProperty("ic_user_signin_url")));
        Assert.assertTrue(driver.getTitle().equals("Register"));
        Assert.assertTrue(driver.findElement(family_name).isEnabled());
        Assert.assertTrue(driver.findElement(given_name).isEnabled());
        Assert.assertTrue(driver.findElement(email).isEnabled());
        Assert.assertTrue(driver.findElement(confirm_email).isEnabled());
        Assert.assertTrue(driver.findElement(password).isEnabled());
        Assert.assertTrue(driver.findElement(confirm_password).isEnabled());
        Assert.assertTrue(driver.findElement(security1).isEnabled());
        Assert.assertTrue(driver.findElement(security2).isEnabled());
        Assert.assertTrue(driver.findElement(security3).isEnabled());
        Assert.assertTrue(driver.findElement(regitser_button).isEnabled());
        driver.quit();

    }
    @Test
    public void t1() throws IOException {
        WebDriver driver=getDriver();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_user_signin_url"));
        driver.findElement(register_option).click();
        driver.findElement(family_name).sendKeys("Gupta");
        driver.findElement(given_name).sendKeys("Vibhav");
        driver.findElement(phone).sendKeys("4359781212");
        driver.findElement(email).sendKeys("vg1@gmail.com");
        driver.findElement(confirm_email).sendKeys("vg1@gmail.com");
        driver.findElement(password).sendKeys("Msdhoni0");
        driver.findElement(confirm_password).sendKeys("Msdhoni0");
        driver.findElement(security1).sendKeys("Ajay");
        driver.findElement(security2).sendKeys("Janak");
        driver.findElement(security3).sendKeys("Tommy");
        driver.findElement(regitser_button).click();
        Alert a =driver.switchTo().alert();
        a.accept();
        driver.quit();
    }
    @Test
    public void t2() throws IOException {

        WebDriver driver=getDriver();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_user_signin_url"));
        driver.findElement(register_option).click();
        driver.findElement(family_name).sendKeys("123");
        driver.findElement(given_name).sendKeys("Vibhav");
        driver.findElement(phone).sendKeys("4359781212");
        driver.findElement(email).sendKeys("vg1@gmail.com");
        driver.findElement(confirm_email).sendKeys("vg1@gmail.com");
        driver.findElement(password).sendKeys("Msdhoni0");
        driver.findElement(confirm_password).sendKeys("Msdhoni0");
        driver.findElement(security1).sendKeys("Ajay");
        driver.findElement(security2).sendKeys("Janak");
        driver.findElement(security3).sendKeys("Tommy");
        driver.findElement(regitser_button).click();

        Alert a =driver.switchTo().alert();
        a.accept();
        driver.quit();

    }
    @Test
    public void tc3() throws IOException {
        WebDriver driver=getDriver();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_user_signin_url"));
        driver.findElement(register_option).click();
        driver.findElement(family_name).sendKeys("Gupta");
        driver.findElement(given_name).sendKeys("345");
        driver.findElement(phone).sendKeys("4359781212");
        driver.findElement(email).sendKeys("vg1@gmail.com");
        driver.findElement(confirm_email).sendKeys("vg1@gmail.com");
        driver.findElement(password).sendKeys("Msdhoni0");
        driver.findElement(confirm_password).sendKeys("Msdhoni0");
        driver.findElement(security1).sendKeys("Ajay");
        driver.findElement(security2).sendKeys("Janak");
        driver.findElement(security3).sendKeys("Tommy");
        driver.findElement(regitser_button).click();
        Alert a =driver.switchTo().alert();
        a.accept();
        driver.quit();
    }
    @Test
    public void tc4() throws IOException {
        WebDriver driver=getDriver();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_user_signin_url"));
        driver.findElement(register_option).click();
        driver.findElement(family_name).sendKeys("Gupta");
        driver.findElement(given_name).sendKeys("345");
        driver.findElement(phone).sendKeys("thtrhrthrth");
        driver.findElement(email).sendKeys("vg1@gmail.com");
        driver.findElement(confirm_email).sendKeys("vg1@gmail.com");
        driver.findElement(password).sendKeys("Msdhoni0");
        driver.findElement(confirm_password).sendKeys("Msdhoni0");
        driver.findElement(security1).sendKeys("Ajay");
        driver.findElement(security2).sendKeys("Janak");
        driver.findElement(security3).sendKeys("Tommy");
        driver.findElement(regitser_button).click();
        Alert a =driver.switchTo().alert();
        a.accept();
        driver.quit();
    }
    @Test
    public void tc5() throws IOException {
        WebDriver driver=getDriver();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_user_signin_url"));
        driver.findElement(register_option).click();
        driver.findElement(family_name).sendKeys("Gupta");
        driver.findElement(given_name).sendKeys("345");
        driver.findElement(phone).sendKeys("4359781212");
        driver.findElement(email).sendKeys("vibhavgupta12");
        driver.findElement(confirm_email).sendKeys("vibhavgupta12");
        driver.findElement(password).sendKeys("Msdhoni0");
        driver.findElement(confirm_password).sendKeys("Msdhoni0");
        driver.findElement(security1).sendKeys("Ajay");
        driver.findElement(security2).sendKeys("Janak");
        driver.findElement(security3).sendKeys("Tommy");
        driver.findElement(regitser_button).click();
        Alert a =driver.switchTo().alert();
        a.accept();
        driver.quit();
    }
    //Testing awated
    public void tc6()
    {

    }

    public void tc7() throws IOException {
        WebDriver driver=getDriver();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_user_signin_url"));
        driver.findElement(register_option).click();
        driver.findElement(family_name).sendKeys("Gupta");
        driver.findElement(given_name).sendKeys("345");
        driver.findElement(phone).sendKeys("4359781212");
        driver.findElement(email).sendKeys("vibhavgupta12");
        driver.findElement(confirm_email).sendKeys("vibhavgupta12");
        driver.findElement(password).sendKeys("Msdhoni0");
        driver.findElement(confirm_password).sendKeys("Msdhoni0");
        driver.findElement(security1).sendKeys("");
        driver.findElement(security2).sendKeys("Janak");
        driver.findElement(security3).sendKeys("Tommy");
        driver.findElement(regitser_button).click();
        Alert a =driver.switchTo().alert();
        a.accept();
        driver.quit();
    }




}
