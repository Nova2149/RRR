package IC_UserSide;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.Properties;

public class ForgotPassword extends ProjectConfig{
    By email_address=By.xpath("//input[@id='user_email']");
    //Its a dropdown
    By security_question=By.xpath("//select[@id='security_ques']");
    By security_answer_input=By.xpath("//input[@id='security_ques_ans']");
    By check_button=By.xpath("//button[contains(text(),'Check')]");
    By new_password_input=By.xpath("//input[@id='new_password']"); //disabled on page laod
    By new_confirm_password_input=By.xpath("//input[@id='confirm_new_password']");//disabled on page load
    By reset_password_button=By.xpath("//button[@id='re']");

    @Test
    public void verify() throws IOException {
        WebDriver driver=getDriver();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_user_forgot_password_url"));
       Assert.assertTrue(driver.getCurrentUrl().equals(prop.getProperty("ic_user_forgot_password_url")));
       Assert.assertTrue(driver.findElement(email_address).isEnabled());
       Assert.assertTrue(driver.findElement(security_question).isEnabled());
       Assert.assertTrue(driver.findElement(security_answer_input).isEnabled());
       Assert.assertTrue(driver.findElement(check_button).isEnabled());
       Assert.assertFalse(driver.findElement(new_password_input).isEnabled());
       Assert.assertFalse(driver.findElement(new_confirm_password_input).isEnabled());
       Assert.assertFalse(driver.findElement(reset_password_button).isEnabled());
       System.out.println("--End of Script--");
       driver.quit();

    }
    //Email id is Empty
    @Test
    public void tc1() throws IOException {
        WebDriver driver=getDriver();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_user_forgot_password_url"));
        driver.findElement(email_address).sendKeys("");
        Select s=new Select(driver.findElement(security_question));
        s.selectByValue("ques1");
        driver.findElement(security_answer_input).sendKeys("Tom");
        driver.findElement(check_button).click();
        Alert a =driver.switchTo().alert();
        Assert.assertTrue(a.getText().equals("Please enter Email"));
        a.accept();
        driver.quit();

    }
    //Invalid Email Addresss
    @Test
    public void tc2() throws IOException {
        WebDriver driver=getDriver();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_user_forgot_password_url"));
        driver.findElement(email_address).sendKeys("");
        Select s=new Select(driver.findElement(security_question));
        s.selectByValue("ques1");
        driver.findElement(security_answer_input).sendKeys("Tom");
        driver.findElement(check_button).click();
        Alert a =driver.switchTo().alert();
        Assert.assertTrue(a.getText().equals("Invalid Email Addresss"));
        a.accept();
        driver.quit();
    }
    //Missing Security Question

    @Test
    public void tc3() throws IOException {
        WebDriver driver=getDriver();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_user_forgot_password_url"));
        driver.findElement(email_address).sendKeys("ad1@gmail.com");
        Select s=new Select(driver.findElement(security_question));
        s.selectByValue("ques1");
        driver.findElement(security_answer_input).sendKeys("");
        driver.findElement(check_button).click();
        Alert a =driver.switchTo().alert();
        Assert.assertTrue(a.getText().equals("Check your details,Try again"));
        a.accept();
        driver.quit();
    }
    //Wrong Security answer to security question
    @Test
    public void tc4() throws IOException {
        WebDriver driver=getDriver();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_user_forgot_password_url"));
        driver.findElement(email_address).sendKeys("ad1@gmail.com");
        Select s=new Select(driver.findElement(security_question));
        s.selectByValue("ques1");
        driver.findElement(security_answer_input).sendKeys("Honey");
        driver.findElement(check_button).click();
        Alert a =driver.switchTo().alert();
        Assert.assertTrue(a.getText().equals("Check your details,Try again"));
        a.accept();
        driver.quit();
    }
    //New password field empty
    @Test
    public void tc5() throws IOException {
        WebDriver driver=getDriver();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_user_forgot_password_url"));
        driver.findElement(email_address).sendKeys("ad1@gmail.com");
        Select s=new Select(driver.findElement(security_question));
        s.selectByValue("ques1");
        driver.findElement(security_answer_input).sendKeys("Vikas");
        driver.findElement(check_button).click();
        Assert.assertTrue(driver.findElement(new_password_input).isEnabled());
        Assert.assertTrue(driver.findElement(new_confirm_password_input).isEnabled());
        driver.findElement(new_password_input).sendKeys("");
        driver.findElement(new_confirm_password_input).sendKeys("euhud");
        driver.findElement(reset_password_button).click();

        Alert a =driver.switchTo().alert();
        Assert.assertTrue(a.getText().equals("Missing Fields"));
        a.accept();
        driver.quit();
    }
    //confirm password field is empty
    @Test
    public void tc6() throws IOException {
        WebDriver driver=getDriver();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_user_forgot_password_url"));
        driver.findElement(email_address).sendKeys("ad1@gmail.com");
        Select s=new Select(driver.findElement(security_question));
        s.selectByValue("ques1");
        driver.findElement(security_answer_input).sendKeys("Vikas");
        driver.findElement(check_button).click();
        Assert.assertTrue(driver.findElement(new_password_input).isEnabled());
        Assert.assertTrue(driver.findElement(new_confirm_password_input).isEnabled());
        driver.findElement(new_password_input).sendKeys("euhud");
        driver.findElement(new_confirm_password_input).sendKeys("");
        driver.findElement(reset_password_button).click();
        Alert a =driver.switchTo().alert();
        Assert.assertTrue(a.getText().equals("Missing Fields"));
        a.accept();
        driver.quit();
    }
    //new and confirm password don't match
    @Test
    public void tc7() throws IOException {
        WebDriver driver=getDriver();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_user_forgot_password_url"));
        driver.findElement(email_address).sendKeys("ad1@gmail.com");
        Select s=new Select(driver.findElement(security_question));
        s.selectByValue("ques1");
        driver.findElement(security_answer_input).sendKeys("Vikas");
        driver.findElement(check_button).click();
        Assert.assertTrue(driver.findElement(new_password_input).isEnabled());
        Assert.assertTrue(driver.findElement(new_confirm_password_input).isEnabled());
        driver.findElement(new_password_input).sendKeys("reregr");
        driver.findElement(new_confirm_password_input).sendKeys("gergeger");
        driver.findElement(reset_password_button).click();

        Alert a =driver.switchTo().alert();
        Assert.assertTrue(a.getText().equals("Password and confirm Password  don't match"));
        a.accept();
        driver.quit();
    }
    //Password reset success
    @Test
    public void tc8() throws IOException, InterruptedException {
        WebDriver driver=getDriver();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_user_forgot_password_url"));
        driver.findElement(email_address).sendKeys("ad1@gmail.com");
        Select s=new Select(driver.findElement(security_question));
        s.selectByValue("ques1");
        driver.findElement(security_answer_input).sendKeys("Vikas");
        driver.findElement(check_button).click();
        Assert.assertTrue(driver.findElement(new_password_input).isEnabled());
        Assert.assertTrue(driver.findElement(new_confirm_password_input).isEnabled());
        driver.findElement(new_password_input).sendKeys("Msdhoni0");
        driver.findElement(new_confirm_password_input).sendKeys("Msdhoni0");
        driver.findElement(reset_password_button).click();
        Alert a =driver.switchTo().alert();
        Assert.assertTrue(a.getText().equals("Password changed successfully"));
        a.accept();
        Thread.sleep(2300);
        Assert.assertTrue(driver.getCurrentUrl().equals(prop.getProperty("ic_user_signin_url")));
        driver.quit();
    }

}
