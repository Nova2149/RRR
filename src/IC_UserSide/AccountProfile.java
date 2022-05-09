package IC_UserSide;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;

import java.io.IOException;
import java.util.Properties;

public class AccountProfile extends UserLoginUtility {


    By new_application_link_text=By.xpath("//a[contains(text(),'New Application')]");
    By account_profile_link_text=By.xpath("//a[contains(text(),'Account Profile')]");
    By logout_link_text=By.xpath("//a[contains(text(),'Logout')]");

    By email_input=By.xpath("//input[@id='user_email']"); //disabled on page load
    By phone_input=By.xpath("//input[@id='user_phone']");//disabled on page load
    By edit_button=By.xpath("//button[@id='edit_account']");
    By update_account_info_button=By.xpath("//button[@id='update_button']");//disabled on page load
    By old_password_input=By.xpath("//input[@id='old_password']");
    By new_password_input=By.xpath("//input[@id='new_password']");
    By confirm_password_input=By.xpath("//input[@id='confirm_password']");
    By check_button=By.xpath("//button[contains(text(),'Check')]");
    By update_password_button=By.xpath("//button[@id='update_password']");

    @Test
    public void verify() throws IOException {
        WebDriver driver=loginUser();
       driver.findElement(account_profile_link_text).click();
       Properties prop=getProperties();
       Assert.assertTrue(driver.getCurrentUrl().equals(prop.getProperty("ic_user_account_profile_url")));
       Assert.assertTrue(driver.getTitle().equals("Account Profile"));
       Assert.assertFalse(driver.findElement(email_input).isEnabled());
       Assert.assertFalse(driver.findElement(phone_input).isEnabled());
       Assert.assertFalse(driver.findElement(update_account_info_button).isEnabled());
       Assert.assertTrue(driver.findElement(edit_button).isEnabled());
       Assert.assertTrue(driver.findElement(old_password_input).isEnabled());
       Assert.assertTrue(driver.findElement(check_button).isEnabled());
       Assert.assertFalse(driver.findElement(new_password_input).isEnabled());
       Assert.assertFalse(driver.findElement(confirm_password_input).isEnabled());
       Assert.assertFalse(driver.findElement(update_password_button).isEnabled());
       driver.quit();
    }
    //User changes Email address
    @Test
    public void tc1() throws InterruptedException, IOException {
        WebDriver driver=loginUser();
        Properties prop=getProperties();
        driver.findElement(account_profile_link_text).click();
        //Assert.assertTrue(driver.findElement(edit_button).isEnabled());
        Assert.assertTrue(driver.getCurrentUrl().equals(prop.getProperty("ic_user_account_profile_url")));

        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("document.getElementById(\"edit_account\").click()");
        System.out.println(driver.findElement(email_input).getAttribute("value"));
        System.out.println(driver.findElement(phone_input).getAttribute("value"));
        driver.findElement(email_input).clear();
        // driver.findElement(email_input).sendKeys(Keys.chord(Keys.CONTROL,Keys.BACK_SPACE));
        driver.findElement(phone_input).clear();
        Thread.sleep(2300);

        driver.findElement(email_input).sendKeys("ad1@gmail.com");
        driver.findElement(phone_input).sendKeys("5143568023");
        driver.findElement(update_account_info_button).click();
        Alert a =driver.switchTo().alert();
        Assert.assertTrue(a.getText().equals("Account Info Updated"));
        a.accept();
        System.out.println("--End of Script--");

    }
    //User changes Email address
    @Test
    public void tc2() throws IOException, InterruptedException {
        WebDriver driver=loginUser();
        Properties prop=getProperties();
        driver.findElement(account_profile_link_text).click();
        //Assert.assertTrue(driver.findElement(edit_button).isEnabled());
        Assert.assertTrue(driver.getCurrentUrl().equals(prop.getProperty("ic_user_account_profile_url")));

        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("document.getElementById(\"edit_account\").click()");
        System.out.println(driver.findElement(email_input).getAttribute("value"));
        System.out.println(driver.findElement(phone_input).getAttribute("value"));
        driver.findElement(email_input).clear();
        // driver.findElement(email_input).sendKeys(Keys.chord(Keys.CONTROL,Keys.BACK_SPACE));
        driver.findElement(phone_input).clear();
        Thread.sleep(500);

        driver.findElement(email_input).sendKeys("ad1@gmail.com");
        driver.findElement(phone_input).sendKeys("5143568023");
        driver.findElement(update_account_info_button).click();
        Alert a =driver.switchTo().alert();
        Assert.assertTrue(a.getText().equals("Account Info Updated"));
        a.accept();
        System.out.println("--End of Script--");
    }
    //User is able to change his password successfully
    @Test
    public void tc3() throws InterruptedException, IOException {
        WebDriver driver=loginUser();
        driver.findElement(account_profile_link_text).click();
        Thread.sleep(2300);
        driver.findElement(old_password_input).sendKeys("Msdhoni0");
        driver.findElement(check_button).click();
        Assert.assertTrue(driver.findElement(new_password_input).isEnabled());
        Assert.assertTrue(driver.findElement(confirm_password_input).isEnabled());
        driver.findElement(new_password_input).sendKeys("Msdhoni0");
        driver.findElement(confirm_password_input).sendKeys("Msdhoni0");
        Thread.sleep(2000);
        driver.findElement(update_password_button).click();
        Thread.sleep(2000);
        Alert a=driver.switchTo().alert();
        Assert.assertTrue(a.getText().equals("Password changed success"));
        a.accept();



        driver.quit();
    }

    //Input Email is Empty
    @Test
    public void tc6() throws IOException, InterruptedException {
        WebDriver driver=loginUser();
       Properties prop=getProperties();
       driver.findElement(account_profile_link_text).click();
       //Assert.assertTrue(driver.findElement(edit_button).isEnabled());
        Assert.assertTrue(driver.getCurrentUrl().equals(prop.getProperty("ic_user_account_profile_url")));

        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("document.getElementById(\"edit_account\").click()");
        System.out.println(driver.findElement(email_input).getAttribute("value"));
        System.out.println(driver.findElement(phone_input).getAttribute("value"));
        driver.findElement(email_input).clear();
       // driver.findElement(email_input).sendKeys(Keys.chord(Keys.CONTROL,Keys.BACK_SPACE));
        driver.findElement(phone_input).clear();
        Thread.sleep(5000);

       driver.findElement(email_input).sendKeys("");
       driver.findElement(phone_input).sendKeys("4358781414");
       driver.findElement(update_account_info_button).click();
       Alert a =driver.switchTo().alert();
       Assert.assertTrue(a.getText().equals("Missing Fields"));
       a.accept();
       System.out.println("--End of Script--");

//       Assert.assertTrue(driver.findElement(email_input).isEnabled());
//       Assert.assertTrue(driver.findElement(phone_input).isEnabled());
//
//       driver.findElement(email_input).sendKeys("");
//       driver.findElement(phone_input).sendKeys("5143349090");
//       driver.findElement(update_account_info_button).click();

        //driver.quit();

    }
    //When the phone number is empty
    @Test
    public void tc7() throws IOException, InterruptedException {
        WebDriver driver=loginUser();
        Properties prop=getProperties();
        driver.findElement(account_profile_link_text).click();
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("document.getElementById(\"edit_account\").click()");
        driver.findElement(email_input).clear();
        driver.findElement(phone_input).clear();
        Thread.sleep(2300);
        driver.findElement(email_input).sendKeys("ad1@gmail.com");
        driver.findElement(phone_input).sendKeys("");
        driver.findElement(update_account_info_button).click();
        Alert a =driver.switchTo().alert();
        Assert.assertTrue(a.getText().equals("Missing Fields"));
        a.accept();
        System.out.println("--End of Script--");
    }
    //Invalid Email
    @Test
    public void tc4() throws IOException, InterruptedException {
        WebDriver driver=loginUser();
        Properties prop=getProperties();
        driver.findElement(account_profile_link_text).click();
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("document.getElementById(\"edit_account\").click()");
        driver.findElement(email_input).clear();
        driver.findElement(phone_input).clear();
        Thread.sleep(2300);
        driver.findElement(email_input).sendKeys("anthony");
        driver.findElement(phone_input).sendKeys("4356781212");
        driver.findElement(update_account_info_button).click();
        Alert a =driver.switchTo().alert();
        Assert.assertTrue(a.getText().equals("Invalid Email"));
        a.accept();
        System.out.println("--End of Script--");
    }
    //Invalid Phone
    @Test
    public void tc5() throws IOException, InterruptedException {
        WebDriver driver=loginUser();
        Properties prop=getProperties();
        driver.findElement(account_profile_link_text).click();
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("document.getElementById(\"edit_account\").click()");
        driver.findElement(email_input).clear();
        driver.findElement(phone_input).clear();
        Thread.sleep(2300);
        driver.findElement(email_input).sendKeys("ad1@gmail.com");
        driver.findElement(phone_input).sendKeys("86886");
        driver.findElement(update_account_info_button).click();
        Alert a =driver.switchTo().alert();
        Assert.assertTrue(a.getText().equals("Invalid Phone Number"));
        a.accept();
        System.out.println("--End of Script--");
    }
    //User enters wrong old password
    @Test
    public void tc9() throws IOException, InterruptedException {
        WebDriver driver=loginUser();
        driver.findElement(account_profile_link_text).click();
        Thread.sleep(2300);
        driver.findElement(old_password_input).sendKeys("dhehdheh");
        driver.findElement(check_button).click();
        Alert a =driver.switchTo().alert();
        Assert.assertTrue(a.getText().equals("Invalid Password"));
        a.accept();
        driver.quit();
    }
    //old password Field is missing
    @Test
    public void tc10() throws IOException, InterruptedException {
        WebDriver driver=loginUser();
        driver.findElement(account_profile_link_text).click();
        Thread.sleep(2300);
        driver.findElement(old_password_input).sendKeys("");
        driver.findElement(check_button).click();
        Alert a =driver.switchTo().alert();
        Assert.assertTrue(a.getText().equals("Missing Fields"));
        a.accept();
        driver.quit();
    }
    //new password and confirm password don't match
    @Test
    public void tc8() throws IOException, InterruptedException {
        WebDriver driver=loginUser();
        driver.findElement(account_profile_link_text).click();
        Thread.sleep(2300);
        driver.findElement(old_password_input).sendKeys("Msdhoni0");
        driver.findElement(check_button).click();
        Assert.assertTrue(driver.findElement(new_password_input).isEnabled());
        Assert.assertTrue(driver.findElement(confirm_password_input).isEnabled());
        driver.findElement(new_password_input).sendKeys("yveyude");
        driver.findElement(confirm_password_input).sendKeys("bebidb");
        driver.findElement(update_password_button).click();
        Alert a=driver.switchTo().alert();
        Assert.assertTrue(a.getText().equals("Password and Confirm Password don't match"));
        a.accept();



        driver.quit();
    }
    //new password field is missing
    @Test
    public void tc11() throws InterruptedException, IOException {
        WebDriver driver=loginUser();
        driver.findElement(account_profile_link_text).click();
        Thread.sleep(2300);
        driver.findElement(old_password_input).sendKeys("Msdhoni0");
        driver.findElement(check_button).click();
        Assert.assertTrue(driver.findElement(new_password_input).isEnabled());
        Assert.assertTrue(driver.findElement(confirm_password_input).isEnabled());
        driver.findElement(new_password_input).sendKeys("");
        driver.findElement(confirm_password_input).sendKeys("bebidb");
        driver.findElement(update_password_button).click();
        Alert a=driver.switchTo().alert();
        Assert.assertTrue(a.getText().equals("Missing Fields"));
        a.accept();



        driver.quit();
    }
    //confirm password field is missing
    @Test
    public void tc12() throws IOException, InterruptedException {
        WebDriver driver=loginUser();
        driver.findElement(account_profile_link_text).click();
        Thread.sleep(2300);
        driver.findElement(old_password_input).sendKeys("Msdhoni0");
        driver.findElement(check_button).click();
        Assert.assertTrue(driver.findElement(new_password_input).isEnabled());
        Assert.assertTrue(driver.findElement(confirm_password_input).isEnabled());
        driver.findElement(new_password_input).sendKeys("yveyude");
        driver.findElement(confirm_password_input).sendKeys("");
        Thread.sleep(2000);
        driver.findElement(update_password_button).click();
        Thread.sleep(2000);
        Alert a=driver.switchTo().alert();
        Assert.assertTrue(a.getText().equals("Missing Fields"));
        a.accept();



        driver.quit();
    }




}
