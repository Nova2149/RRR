package IC_AdminSide;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Properties;

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
    public void verify() throws IOException, InterruptedException {
        WebDriver driver=Login();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_admin_help_url"));
        Assert.assertTrue(driver.getCurrentUrl().equals(prop.getProperty("ic_admin_help_url")));
        Assert.assertTrue(driver.getTitle().equals("Help Section"));
        Assert.assertTrue(driver.findElement(help_heading).isDisplayed());
        Assert.assertTrue(driver.findElement(help_description).isDisplayed());
        Assert.assertTrue(driver.findElement(add_button).isDisplayed());
        System.out.println("--End of Script--");
        driver.quit();
    }

    @Test
    public void tc1() throws IOException, InterruptedException {
        WebDriver driver=Login();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_admin_help_url"));
        Assert.assertTrue(driver.getCurrentUrl().equals(prop.getProperty("ic_admin_help_url")));
        Assert.assertTrue(driver.getTitle().equals("Help Section"));

        driver.findElement(help_heading).sendKeys("");
        driver.findElement(help_description).sendKeys("New IRCC Help status");
        driver.findElement(add_button).click();
        Thread.sleep(2300);
        Alert a =driver.switchTo().alert();
        a.accept();
        System.out.println("--End of Script--");
        driver.quit();

    }
    @Test
    public void tc2() throws IOException, InterruptedException {

        WebDriver driver=Login();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_admin_help_url"));
        Assert.assertTrue(driver.getCurrentUrl().equals(prop.getProperty("ic_admin_help_url")));
        Assert.assertTrue(driver.getTitle().equals("Help Section"));

        driver.findElement(help_heading).sendKeys("IRCC Heading");
        driver.findElement(help_description).sendKeys("");
        driver.findElement(add_button).click();
        Thread.sleep(2300);
        Alert a =driver.switchTo().alert();
        a.accept();
        System.out.println("--End of Script--");
        driver.quit();
    }
    //###critical test case remove the data from json once testing has been done
    //It can create complications,otherwise

    @Test
    public void tc3() throws IOException, InterruptedException {
        WebDriver driver=Login();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_admin_help_url"));
        Assert.assertTrue(driver.getCurrentUrl().equals(prop.getProperty("ic_admin_help_url")));
        Assert.assertTrue(driver.getTitle().equals("Help Section"));

        driver.findElement(help_heading).sendKeys("IRCC New Heading");
        driver.findElement(help_description).sendKeys("IRCC News Description");
        driver.findElement(add_button).click();
        Thread.sleep(2300);
        Alert a =driver.switchTo().alert();
        a.accept();
        System.out.println("--End of Script--");
        driver.quit();
    }


}
