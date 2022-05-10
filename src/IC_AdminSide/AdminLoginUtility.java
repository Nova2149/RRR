package IC_AdminSide;


import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import IC_UserSide.ProjectConfig;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import static java.lang.System.getProperties;

public class AdminLoginUtility extends ProjectConfig {
    By admin_email_input=By.xpath("//input[@id='admin_email']");
    By admin_password_input=By.xpath("//input[@id='admin_password']");
    By login_btn=By.xpath("//button[contains(text(),'Login')]");

    public WebDriver Login() throws IOException, InterruptedException {
        WebDriver driver=getDriver();
        Properties prop=getProperties();
        System.out.println(prop.getProperty("ic_admin_signin_url"));
        driver.get(prop.getProperty("ic_admin_signin_url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(admin_email_input).sendKeys("tm1@gmail.com");
        driver.findElement(admin_password_input).sendKeys("Msdhoni0");
        driver.findElement(login_btn).click();
        Thread.sleep(1200);
        Alert a =driver.switchTo().alert();
        a.accept();
        System.out.println("User should be logged in successfully");


        return driver;
    }
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Hello World");
        AdminLoginUtility alu=new AdminLoginUtility();
        alu.Login();

    }
}
