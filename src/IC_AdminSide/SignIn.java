package IC_AdminSide;

import IC_UserSide.ProjectConfig;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Properties;

public class SignIn extends ProjectConfig {

    //navbar links
//    By users_navbar_link=By.xpath("");
//    By applications_navabr_link=By.xpath("");
//    By news_section_navabr_link=By.xpath("");
//    By webforms_navbar_link=By.xpath("");
//    By help_centre_navbar_link=By.xpath("");
//    By process_time_navbar_link=By.xpath("");

    //Main Entities
    By admin_email_input=By.xpath("//input[@id='admin_email']");
    By admin_password_input=By.xpath("//input[@id='admin_password']");
    By login_btn=By.xpath("//button[contains(text(),'Login')]");
    @Test
    public void verify() throws IOException {

        WebDriver driver=getDriver();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_admin_signin_url"));
        Assert.assertTrue(driver.getCurrentUrl().equals(prop.getProperty("ic_admin_signin_url")));
        Assert.assertTrue(driver.getTitle().equals("Admin Login"));
        Assert.assertTrue(driver.findElement(admin_email_input).isDisplayed());
        Assert.assertTrue(driver.findElement(admin_password_input).isDisplayed());
        Assert.assertTrue(driver.findElement(login_btn).isDisplayed());
        System.out.println("--End of Script--");
        driver.quit();




    }
    //Email is Empty
    @Test
    public void tc1() throws IOException {
        WebDriver driver=getDriver();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_admin_signin_url"));

        driver.findElement(admin_email_input).sendKeys("");
        driver.findElement(admin_password_input).sendKeys("fdyueudfvu");
         driver.findElement(login_btn).click();
         Alert a =driver.switchTo().alert();
         Assert.assertTrue(a.getText().equals("Missing Fields"));
         a.accept();
         driver.quit();

    }
    //password Empty
    @Test
    public void tc2() throws IOException {
        WebDriver driver=getDriver();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_admin_signin_url"));

        driver.findElement(admin_email_input).sendKeys("ad1@gmail.com");
        driver.findElement(admin_password_input).sendKeys("");
        driver.findElement(login_btn).click();
        Alert a =driver.switchTo().alert();
        Assert.assertTrue(a.getText().equals("Missing Fields"));
        a.accept();
        driver.quit();
    }
    //Invalid Email
    @Test
    public void tc3() throws IOException {
        WebDriver driver=getDriver();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_admin_signin_url"));

        driver.findElement(admin_email_input).sendKeys("tdbbdded");
        driver.findElement(admin_password_input).sendKeys("");
        driver.findElement(login_btn).click();
        Alert a =driver.switchTo().alert();
        Assert.assertTrue(a.getText().equals("Invalid Email address"));
        a.accept();
        driver.quit();

    }
    //Login Failed
    @Test
    public void tc4() throws IOException {
        //Login Failed,Try again
        WebDriver driver=getDriver();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_admin_signin_url"));

        driver.findElement(admin_email_input).sendKeys("tm1@gmail.com");
        driver.findElement(admin_password_input).sendKeys("Msdhoni0");
        driver.findElement(login_btn).click();
        Alert a =driver.switchTo().alert();
        Assert.assertTrue(a.getText().equals("Login Failed,Try again"));
        a.accept();
        driver.quit();
    }
    //successfull login
    @Test
    public void tc5() throws IOException {
        WebDriver driver=getDriver();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_admin_signin_url"));

        driver.findElement(admin_email_input).sendKeys("tm1@gmail.com");
        driver.findElement(admin_password_input).sendKeys("Msdhoni0");
        driver.findElement(login_btn).click();
        Alert a =driver.switchTo().alert();
        Assert.assertTrue(a.getText().equals("Welcome"));
        a.accept();
        Assert.assertTrue(driver.getCurrentUrl().equals("http://localhost:7000/immigration-canada/users"));
        driver.quit();
    }


}
