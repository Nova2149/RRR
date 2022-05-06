package IC_AdminSide;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class AddHelpCentre extends AdminLoginUtility {

    //Navbar links will show up Here
    By users_navbar_link=By.xpath("//a[contains(text(),'USERS')]");
    By applications_navbar_link=By.xpath("//a[contains(text(),'APPLICATIONS')]");
    By news_section_navbar_link=By.xpath("//a[contains(text(),'NEWS SECTION')]");
    By webforms_navabr_link=By.xpath("//a[contains(text(),'WEBFORMS')]");
    By help_centre_navabr_link=By.xpath("//a[contains(text(),'HELP CENTRE SECTION')]");
    By processing_time_navbar_link=By.xpath("//a[contains(text(),'PROCESSING TIME')]");

    By help_heading=By.xpath("//input[@id='help_title']");
    By help_description=By.xpath("//textarea[@id='help_description']");
    By add_button=By.xpath("//button[contains(text(),'Add')]");

    @Test
    public void verify() throws IOException {
        WebDriver driver=getDriver();
        Assert.assertTrue(driver.findElement(users_navbar_link).isEnabled());
        Assert.assertTrue(driver.findElement(applications_navbar_link).isEnabled());
        Assert.assertTrue(driver.findElement(news_section_navbar_link).isDisplayed());
        Assert.assertTrue(driver.findElement(webforms_navabr_link).isEnabled());
        Assert.assertTrue(driver.findElement(help_centre_navabr_link).isEnabled());
        Assert.assertTrue(driver.findElement(processing_time_navbar_link).isEnabled());

        driver.findElement(help_centre_navabr_link).click();
    }
}
