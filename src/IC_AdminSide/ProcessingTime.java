package IC_AdminSide;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class ProcessingTime extends AdminLoginUtility{
    //Navbar links wil show up here
    By users_navbar_link=By.xpath("//a[contains(text(),'USERS')]");
    By applications_navbar_link=By.xpath("//a[contains(text(),'APPLICATIONS')]");
    By news_section_navbar_link=By.xpath("//a[contains(text(),'NEWS SECTION')]");
    By webforms_navabr_link=By.xpath("//a[contains(text(),'WEBFORMS')]");
    By help_centre_navabr_link=By.xpath("//a[contains(text(),'HELP CENTRE SECTION')]");
    By processing_time_navbar_link=By.xpath("//a[contains(text(),'PROCESSING TIME')]");


    //processing time will show up here
    //all fields are disabled by default
    By tr_student_input= By.xpath("//input[@id='student_pt']");
    By tr_work_input=By.xpath("//input[@id='work_pt']");
    By tr_visitor_input=By.xpath("//input[@id='visitor_pt']");
    By pr_input=By.xpath("//input[@id='permanent_pt']");

    By edit_button=By.xpath("//button[contains(text(),'Edit')]");
    By update_button=By.xpath("//button[contains(text(),'Update')]");

    @Test
    public void verify() throws IOException {
       WebDriver driver= Login();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Assert.assertTrue(driver.findElement(users_navbar_link).isEnabled());
        Assert.assertTrue(driver.findElement(applications_navbar_link).isEnabled());
        Assert.assertTrue(driver.findElement(news_section_navbar_link).isDisplayed());
        Assert.assertTrue(driver.findElement(webforms_navabr_link).isEnabled());
        Assert.assertTrue(driver.findElement(help_centre_navabr_link).isEnabled());
        Assert.assertTrue(driver.findElement(processing_time_navbar_link).isEnabled());
        driver.findElement(processing_time_navbar_link).click();

        Assert.assertFalse(driver.findElement(tr_student_input).isEnabled());
        Assert.assertFalse(driver.findElement(tr_work_input).isEnabled());
        Assert.assertFalse(driver.findElement(tr_visitor_input).isEnabled());
        Assert.assertFalse(driver.findElement(pr_input).isEnabled());
        Assert.assertTrue(driver.findElement(edit_button).isEnabled());
        Assert.assertTrue(driver.findElement(update_button).isEnabled());
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        Properties prop=getProperties();
        Assert.assertTrue(driver.getCurrentUrl().equals(prop.getProperty("ic_admin_processing_time_url")));
        Assert.assertTrue(driver.getTitle().equals("Processing Time"));



    }

}
