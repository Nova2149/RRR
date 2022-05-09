package IC_AdminSide;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class WebForms extends AdminLoginUtility {
    //navbar links will show up here
    By webform_table=By.tagName("table");
    By webform_id=By.xpath("//input[@id='webform_id']");
    By webform_dob=By.xpath("//input[@id='webform_dob']");
    By webform_email=By.xpath("//input[@id='webform_email']");
    By webform_mobile=By.xpath("//input[@id='webform_mobile']");
    By webform_type_of_application=By.xpath("//input[@id='webform_type_of_enquiry']");
    By webform_enquiry_message=By.xpath("//textarea[@id='webform_enquiry']");
    By return_button=By.xpath("//button[contains(text(),'Return')]");
    @Test
    public void verify() throws IOException {
        WebDriver driver=Login();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_admin_webform_url"));
        Assert.assertTrue(driver.getCurrentUrl().equals(prop.getProperty("ic_admin_webform_url")));
        Assert.assertTrue(driver.getTitle().equals("WebForm"));
        Assert.assertTrue(driver.findElement(webform_table).isDisplayed());
        System.out.println("--end of Script---");
        driver.quit();

    }
    //all webforms should be listed on the WebForm Page
    @Test
    public void tc1() throws IOException {
        WebDriver driver=Login();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_admin_webform_url"));



        int size=driver.findElement(webform_table).findElements(By.tagName("tr")).size();
        System.out.println(size);
        List<String> webform_id_list=new ArrayList<>();
        List<String> application_enquiry_list=new ArrayList<>();
        List<String> application_number_list=new ArrayList<>();
        List<String> email_list=new ArrayList<>();

        for(int i=1;i<size;i++)
        {
          String s1=  driver.findElement(webform_table).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td"))
                    .get(0).getText();
          webform_id_list.add(s1);
          String s2=driver.findElement(webform_table).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td"))
                  .get(1).getText();
          application_enquiry_list.add(s2);
          String s3=driver.findElement(webform_table).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td"))
                  .get(3).getText();
          application_number_list.add(s3);

          String s4=driver.findElement(webform_table).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td"))
                  .get(4).getText();
          email_list.add(s4);

        }
        Assert.assertNotNull(webform_id_list);
        Assert.assertNotNull(application_enquiry_list);
        Assert.assertNotNull(application_number_list);
        Assert.assertNotNull(email_list);
        System.out.println("--End of Script--");
        driver.quit();

    }
    @Test
    public void tc2() throws IOException, InterruptedException {
        WebDriver driver=Login();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_admin_webform_url"));
        Thread.sleep(2300);
        driver.findElement(webform_table).findElements(By.tagName("tr")).get(1).findElements(By.tagName("td"))
                .get(4).findElement(By.tagName("button")).click();
        Thread.sleep(3400);
        Assert.assertTrue(driver.findElement(webform_id).isDisplayed());
        Assert.assertTrue(driver.findElement(webform_dob).isDisplayed());
        Assert.assertTrue(driver.findElement(webform_email).isDisplayed());
        Assert.assertTrue(driver.findElement(webform_mobile).isDisplayed());
        Assert.assertTrue(driver.findElement(webform_enquiry_message).isDisplayed());
        Assert.assertTrue(driver.findElement(webform_type_of_application).isDisplayed());
        Assert.assertTrue(driver.findElement(return_button).isDisplayed());
        driver.findElement(return_button).click();
        Thread.sleep(3400);
        //System.out.println("--End of Scirpt---")

        System.out.println("--End of Script--");
        driver.quit();
    }

}
