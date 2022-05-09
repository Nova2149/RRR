package IC_UserSide;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MyApplication extends UserLoginUtility {
    By user_name_heading=By.xpath("//h1[contains(text(),\"Account\")]");
    By new_application=By.xpath("//a[contains(text(),'New Application')]");
    By account_profile=By.xpath("//a[contains(text(),'Account Profile')]");
    By logout=By.xpath("//a[contains(text(),'Logout')]");
    By application_info=By.xpath("//tbody[@id='user_application_info']");
    @Test
    public void verify() throws IOException, InterruptedException {
        WebDriver driver=loginUser();
        Thread.sleep(500);
        Assert.assertTrue(driver.findElement(user_name_heading).isEnabled());
        Assert.assertTrue(driver.findElement(new_application).isEnabled());
        Assert.assertTrue(driver.findElement(account_profile).isEnabled());
        Assert.assertTrue(driver.findElement(logout).isEnabled());
        Assert.assertTrue(driver.findElement(application_info).isEnabled());
        driver.quit();


    }
    //redirect to new application page
    @Test
    public void tc1() throws IOException, InterruptedException {
        WebDriver driver=loginUser();
        Properties prop=getProperties();
        Thread.sleep(500);
        driver.findElement(new_application).click();
        Assert.assertTrue(driver.getCurrentUrl().equals(prop.getProperty("ic_user_new_application_url")));
        driver.quit();

    }
    //redirect to account profile page
    @Test
    public void tc2() throws IOException, InterruptedException {
        WebDriver driver=loginUser();
        Properties prop=getProperties();
        Thread.sleep(500);
        driver.findElement(account_profile).click();
        Assert.assertTrue(driver.getCurrentUrl().equals(prop.getProperty("ic_user_account_profile_url")));
        driver.quit();
    }
    //logout
    //redirect to sign in page again
    @Test
    public void tc3() throws IOException, InterruptedException {
        WebDriver driver=loginUser();
        Properties prop=getProperties();
        Thread.sleep(500);
        driver.findElement(logout).click();
        Assert.assertTrue(driver.getCurrentUrl().equals(prop.getProperty("ic_user_signin_url")));
        driver.quit();
    }
    //To check whether the applications have been populated or not
    @Test
    public void tc4() throws IOException, InterruptedException {
        WebDriver driver=loginUser();
        Thread.sleep(2300);
        int size=driver.findElement(application_info).findElements(By.tagName("tr")).size();
        System.out.println(size);

        List<String> application_number=new ArrayList<>();
        List<String> application_type=new ArrayList<>();
        List<String> application_status=new ArrayList<>();
        List<String> medical_status=new ArrayList<>();
        List<String> background_status=new ArrayList<>();

        for(int i=0;i<size;i++)
        {
           String application_number_value= driver.findElement(application_info)
                   .findElements(By.tagName("tr")).get(i).
                    findElements(By.tagName("td")).get(0).getText();
           application_number.add(application_number_value);
           String application_type_value=driver.findElement(application_info).findElements(By.tagName("tr")).get(i).
                   findElements(By.tagName("td")).get(1).getText();
           application_type.add(application_type_value);
           String application_status_value=driver.findElement(application_info).findElements(By.tagName("tr")).get(i).
                   findElements(By.tagName("td")).get(2).getText();
           application_status.add(application_status_value);

           String medical_status_value=driver.findElement(application_info).findElements(By.tagName("tr")).get(i).
                   findElements(By.tagName("td")).get(3).getText();
           medical_status.add(medical_status_value);

           String background_status_value=driver.findElement(application_info).findElements(By.tagName("tr")).get(i).
                   findElements(By.tagName("td")).get(4).getText();
           background_status.add(background_status_value);
        }

        for(String s:application_number)
        {
            System.out.println(s);
        }
        for(String s:application_type){
            System.out.println(s);
        }
        if(size==0)
        {
            Assert.assertTrue(application_number.isEmpty());
            Assert.assertTrue(application_type.isEmpty());
            Assert.assertTrue(application_status.isEmpty());
            Assert.assertTrue(medical_status.isEmpty());
            Assert.assertTrue(background_status.isEmpty());
        }
        else
        {
            Assert.assertFalse(application_number.isEmpty());
            Assert.assertFalse(application_type.isEmpty());
            Assert.assertFalse(application_status.isEmpty());
            Assert.assertFalse(medical_status.isEmpty());
            Assert.assertFalse(background_status.isEmpty());
        }

        System.out.println("--End of script--");
        driver.quit();


    }

    @Test
    public void tc5() throws IOException, InterruptedException {
        WebDriver driver=loginUser();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(user_name_heading).isEnabled());
        Assert.assertTrue(driver.findElement(user_name_heading).getText().equals("Anthony's Account"));
        driver.quit();

    }



}
