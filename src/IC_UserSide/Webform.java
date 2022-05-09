package IC_UserSide;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.Properties;
//status-done
public class Webform extends ProjectConfig {
    By type_of_application= By.xpath("//select[@id='type_of_application']");
    By webform_textarea=By.xpath("//textarea[@id='webform_message']");
    By family_name_input=By.xpath("//input[@id='family_name']");
    By given_name_input=By.xpath("//input[@id='given_name']");
    By email_address_input=By.xpath("//input[@id='email_address']");
    By date_of_birth_input=By.xpath("//input[@id='date_of_birth']");
    By application_number_input=By.xpath("//input[@id='application_number']");
    By mobile_number_input=By.xpath("//input[@id='mobile_number']");
    By submit_button=By.xpath("//button[contains(text(),'Submit')]");
    //End of xpath that are all used


    @Test
    public void verify() throws IOException {
        WebDriver driver=getDriver();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_user_webform_url"));
        Assert.assertTrue(driver.getCurrentUrl().equals(prop.getProperty("ic_user_webform_url")));
        Assert.assertTrue(driver.getTitle().equals("Webform"));
        Assert.assertTrue(driver.findElement(type_of_application).isEnabled());
        Assert.assertTrue(driver.findElement(webform_textarea).isEnabled());
        Assert.assertTrue(driver.findElement(family_name_input).isEnabled());
        Assert.assertTrue(driver.findElement(given_name_input).isEnabled());
        Assert.assertTrue(driver.findElement(email_address_input).isEnabled());
        Assert.assertTrue(driver.findElement(date_of_birth_input).isEnabled());
        Assert.assertTrue(driver.findElement(application_number_input).isEnabled());
        Assert.assertTrue(driver.findElement(mobile_number_input).isEnabled());
        Assert.assertTrue(driver.findElement(submit_button).isEnabled());
        driver.quit();
    }
    @Test
    public void tc1() throws IOException {
       // Your Webform has been submitted successfully
        WebDriver driver=getDriver();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_user_webform_url"));
        Select s=new Select(driver.findElement(type_of_application));
        s.selectByIndex(0);
        driver.findElement(webform_textarea).sendKeys("Anthony");
        driver.findElement(family_name_input).sendKeys("Ducamos");
        driver.findElement(given_name_input).sendKeys("Anthony");
        driver.findElement(email_address_input).sendKeys("ad1@gmail.com");
        driver.findElement(date_of_birth_input).sendKeys("1995-08-22");
        driver.findElement(application_number_input).sendKeys("6");
        driver.findElement(mobile_number_input).sendKeys("4569781212");
        driver.findElement(submit_button).click();
        Alert a =driver.switchTo().alert();
        Assert.assertTrue(a.getText().equals("Your Webform has been submitted successfully"));
        a.accept();

    }
    //Enquiry Empty
    @Test
    public void tc2() throws IOException {
        WebDriver driver=getDriver();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_user_webform_url"));
        Select s=new Select(driver.findElement(type_of_application));
        s.selectByIndex(0);
        driver.findElement(webform_textarea).sendKeys("");
        driver.findElement(family_name_input).sendKeys("Ducamos");
        driver.findElement(given_name_input).sendKeys("Anthony");
        driver.findElement(email_address_input).sendKeys("ad1@gmail.com");
        driver.findElement(date_of_birth_input).sendKeys("1995-08-22");
        driver.findElement(application_number_input).sendKeys("2");
        driver.findElement(mobile_number_input).sendKeys("4569781212");
        driver.findElement(submit_button).click();
        Alert a =driver.switchTo().alert();
        a.accept();
        driver.quit();
    }
    //Family Name Empty
    @Test
    public void tc3() throws IOException {
        WebDriver driver=getDriver();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_user_webform_url"));
        Select s=new Select(driver.findElement(type_of_application));
        s.selectByIndex(0);
        driver.findElement(webform_textarea).sendKeys("My study permit application is taking too long to be processed" +
                "I request you to please look into this matter");
        driver.findElement(family_name_input).sendKeys("");
        driver.findElement(given_name_input).sendKeys("Anthony");
        driver.findElement(email_address_input).sendKeys("ad1@gmail.com");
        driver.findElement(date_of_birth_input).sendKeys("1995-08-22");
        driver.findElement(application_number_input).sendKeys("2");
        driver.findElement(mobile_number_input).sendKeys("4569781212");
        driver.findElement(submit_button).click();
        Alert a =driver.switchTo().alert();
        a.accept();
        driver.quit();
    }
    //Given name Empty
    @Test
    public void tc4() throws IOException {
        WebDriver driver=getDriver();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_user_webform_url"));
        Select s=new Select(driver.findElement(type_of_application));
        s.selectByIndex(0);
        driver.findElement(webform_textarea).sendKeys("My study permit application is taking too long to be processed" +
                "I request you to please look into this matter");
        driver.findElement(family_name_input).sendKeys("Ducamos");
        driver.findElement(given_name_input).sendKeys("");
        driver.findElement(email_address_input).sendKeys("ad1@gmail.com");
        driver.findElement(date_of_birth_input).sendKeys("1995-08-22");
        driver.findElement(application_number_input).sendKeys("2");
        driver.findElement(mobile_number_input).sendKeys("4569781212");
        driver.findElement(submit_button).click();
        Alert a =driver.switchTo().alert();
        a.accept();
        driver.quit();

    }
    //Email Address Empty
    @Test
    public void tc5() throws IOException {
        WebDriver driver=getDriver();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_user_webform_url"));
        Select s=new Select(driver.findElement(type_of_application));
        s.selectByIndex(0);
        driver.findElement(webform_textarea).sendKeys("My study permit application is taking too long to be processed" +
                "I request you to please look into this matter");
        driver.findElement(family_name_input).sendKeys("Ducamos");
        driver.findElement(given_name_input).sendKeys("Anthony");
        driver.findElement(email_address_input).sendKeys("");
        driver.findElement(date_of_birth_input).sendKeys("1995-08-22");
        driver.findElement(application_number_input).sendKeys("2");
        driver.findElement(mobile_number_input).sendKeys("4569781212");
        driver.findElement(submit_button).click();
        Alert a =driver.switchTo().alert();
        a.accept();
        driver.quit();
    }
    //Invalid Email address
    @Test
    public void tc6() throws IOException {
        WebDriver driver=getDriver();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_user_webform_url"));
        Select s=new Select(driver.findElement(type_of_application));
        s.selectByIndex(0);
        driver.findElement(webform_textarea).sendKeys("My study permit application is taking too long to be processed" +
                "I request you to please look into this matter");
        driver.findElement(family_name_input).sendKeys("Ducamos");
        driver.findElement(given_name_input).sendKeys("");
        driver.findElement(email_address_input).sendKeys("anthonyducamo123");
        driver.findElement(date_of_birth_input).sendKeys("1995-08-22");
        driver.findElement(application_number_input).sendKeys("2");
        driver.findElement(mobile_number_input).sendKeys("4569781212");
        driver.findElement(submit_button).click();
        Alert a =driver.switchTo().alert();
        a.accept();
        driver.quit();
    }
    //dob empty
    @Test
    public void tc7() throws IOException {
        WebDriver driver=getDriver();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_user_webform_url"));
        Select s=new Select(driver.findElement(type_of_application));
        s.selectByIndex(0);
        driver.findElement(webform_textarea).sendKeys("My study permit application is taking too long to be processed" +
                "I request you to please look into this matter");
        driver.findElement(family_name_input).sendKeys("Ducamos");
        driver.findElement(given_name_input).sendKeys("");
        driver.findElement(email_address_input).sendKeys("ad1@gmail.com");
        driver.findElement(date_of_birth_input).sendKeys("");
        driver.findElement(application_number_input).sendKeys("2");
        driver.findElement(mobile_number_input).sendKeys("4569781212");
        driver.findElement(submit_button).click();
        Alert a =driver.switchTo().alert();
        a.accept();
        driver.quit();
    }
    //application number empty
    @Test
    public void tc8() throws IOException {
        WebDriver driver=getDriver();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_user_webform_url"));
        Select s=new Select(driver.findElement(type_of_application));
        s.selectByIndex(0);
        driver.findElement(webform_textarea).sendKeys("My study permit application is taking too long to be processed" +
                "I request you to please look into this matter");
        driver.findElement(family_name_input).sendKeys("Ducamos");
        driver.findElement(given_name_input).sendKeys("");
        driver.findElement(email_address_input).sendKeys("ad1@gmail.com");
        driver.findElement(date_of_birth_input).sendKeys("1995-08-22");
        driver.findElement(application_number_input).sendKeys("");
        driver.findElement(mobile_number_input).sendKeys("4569781212");
        driver.findElement(submit_button).click();
        Alert a =driver.switchTo().alert();
        a.accept();
        driver.quit();

    }
    //mobile number empty
    @Test
    public void tc9() throws IOException {
        WebDriver driver=getDriver();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_user_webform_url"));
        Select s=new Select(driver.findElement(type_of_application));
        s.selectByIndex(0);
        driver.findElement(webform_textarea).sendKeys("My study permit application is taking too long to be processed" +
                "I request you to please look into this matter");
        driver.findElement(family_name_input).sendKeys("Ducamos");
        driver.findElement(given_name_input).sendKeys("");
        driver.findElement(email_address_input).sendKeys("ad1@gmail.com");
        driver.findElement(date_of_birth_input).sendKeys("1995-08-22");
        driver.findElement(application_number_input).sendKeys("2");
        driver.findElement(mobile_number_input).sendKeys("");
        driver.findElement(submit_button).click();
        Alert a =driver.switchTo().alert();
        a.accept();
        driver.quit();
    }
    //mobile number invalid
    @Test
    public void tc10() throws IOException {
        WebDriver driver=getDriver();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_user_webform_url"));
        Select s=new Select(driver.findElement(type_of_application));
        s.selectByIndex(0);
        driver.findElement(webform_textarea).sendKeys("My study permit application is taking too long to be processed" +
                "I request you to please look into this matter");
        driver.findElement(family_name_input).sendKeys("Ducamos");
        driver.findElement(given_name_input).sendKeys("");
        driver.findElement(email_address_input).sendKeys("ad1@gmail.com");
        driver.findElement(date_of_birth_input).sendKeys("1995-08-22");
        driver.findElement(application_number_input).sendKeys("2");
        //Length of mobile number is not correct
        driver.findElement(mobile_number_input).sendKeys("3434556");
        driver.findElement(submit_button).click();
        Alert a =driver.switchTo().alert();
        a.accept();
        driver.quit();
    }
    //application number incorrect
    @Test
    public void tc11() throws IOException {
        WebDriver driver=getDriver();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_user_webform_url"));
        Select s=new Select(driver.findElement(type_of_application));
        s.selectByIndex(0);
        driver.findElement(webform_textarea).sendKeys("My study permit application is taking too long to be processed" +
                "I request you to please look into this matter");
        driver.findElement(family_name_input).sendKeys("Ducamos");
        driver.findElement(given_name_input).sendKeys("Anthony");
        driver.findElement(email_address_input).sendKeys("ad1@gmail.com");
        driver.findElement(date_of_birth_input).sendKeys("1995-08-22");
        driver.findElement(application_number_input).sendKeys("2999");
        //Length of mobile number is not correct
        driver.findElement(mobile_number_input).sendKeys("4329801212");
        driver.findElement(submit_button).click();
        Alert a =driver.switchTo().alert();
        a.accept();
        driver.quit();

    }
    //invalid given name
    @Test
    public void tc12() throws IOException {
        WebDriver driver=getDriver();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_user_webform_url"));
        Select s=new Select(driver.findElement(type_of_application));
        s.selectByIndex(0);
        driver.findElement(webform_textarea).sendKeys("My study permit application is taking too long to be processed" +
                "I request you to please look into this matter");
        driver.findElement(family_name_input).sendKeys("Ducamos");
        driver.findElement(given_name_input).sendKeys("3435");
        driver.findElement(email_address_input).sendKeys("ad1@gmail.com");
        driver.findElement(date_of_birth_input).sendKeys("1995-08-22");
        driver.findElement(application_number_input).sendKeys("2");
        //Length of mobile number is not correct
        driver.findElement(mobile_number_input).sendKeys("3434556");
        driver.findElement(submit_button).click();
        Alert a =driver.switchTo().alert();
        a.accept();
        driver.quit();
    }
    //invalid family name
    @Test
    public void tc13() throws IOException {
        WebDriver driver=getDriver();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_user_webform_url"));
        Select s=new Select(driver.findElement(type_of_application));
        s.selectByIndex(0);
        driver.findElement(webform_textarea).sendKeys("My study permit application is taking too long to be processed" +
                "I request you to please look into this matter");
        driver.findElement(family_name_input).sendKeys("D44535");
        driver.findElement(given_name_input).sendKeys("Anthony");
        driver.findElement(email_address_input).sendKeys("ad1@gmail.com");
        driver.findElement(date_of_birth_input).sendKeys("1995-08-22");
        driver.findElement(application_number_input).sendKeys("2");
        //Length of mobile number is not correct
        driver.findElement(mobile_number_input).sendKeys("435465");
        driver.findElement(submit_button).click();
        Alert a =driver.switchTo().alert();
        a.accept();
        driver.quit();

    }
    //invalid date of birth
    @Test
    public void tc14() throws IOException {
        WebDriver driver=getDriver();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_user_webform_url"));
        Select s=new Select(driver.findElement(type_of_application));
        s.selectByIndex(0);
        driver.findElement(webform_textarea).sendKeys("My study permit application is taking too long to be processed" +
                "I request you to please look into this matter");
        driver.findElement(family_name_input).sendKeys("Ducamos");
        driver.findElement(given_name_input).sendKeys("Anthony");
        driver.findElement(email_address_input).sendKeys("ad1@gmail.com");
        driver.findElement(date_of_birth_input).sendKeys("2024-08-22");
        driver.findElement(application_number_input).sendKeys("2");
        //Length of mobile number is not correct
        driver.findElement(mobile_number_input).sendKeys("4329781818");
        driver.findElement(submit_button).click();
        Alert a =driver.switchTo().alert();
        Assert.assertTrue(a.getText().equals("Invalid Date of Birth"));
        a.accept();
        driver.quit();
    }

}
