package IC_UserSide;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Properties;

public class HelpCentre  extends ProjectConfig{
    By help_centre_input= By.xpath("//input[@id='u']");
    By help_centre_heading=By.xpath("//h1[contains(text(),'Help Centre')]");
    By help_body=By.xpath("//div[@id='help_info']");


    @Test
    public void verify() throws IOException {
        WebDriver driver=getDriver();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_user_help_url"));
        Assert.assertTrue(driver.getCurrentUrl().equals(prop.getProperty("ic_user_help_url")));
        Assert.assertTrue(driver.getTitle().equals("Help Section"));
        Assert.assertTrue(driver.findElement(help_centre_heading).isEnabled());
        Assert.assertTrue(driver.findElement(help_centre_input).isEnabled());
        Assert.assertFalse(driver.findElement(help_body).isDisplayed());
        driver.quit();


    }
    //Successful Search
    @Test
    public void tc1() throws IOException, InterruptedException {
        WebDriver driver=getDriver();
        Properties prop=getProperties();

        driver.get(prop.getProperty("ic_user_help_url"));
        driver.findElement(help_centre_input).sendKeys("an");
        Thread.sleep(2300);
        int size=driver.findElement(help_body).findElements(By.tagName("li")).size();

            driver.findElement(help_body).findElements(By.tagName("li")).get(0).findElement(By.tagName("a")).click();
            Thread.sleep(2500);
            Assert.assertTrue(driver.findElement(By.tagName("h1")).isDisplayed());
            Assert.assertTrue(driver.findElement(By.tagName("blockquote")).isDisplayed());
            Thread.sleep(500);
            driver.navigate().back();
            Thread.sleep(2500);

        System.out.println(size);

        driver.quit();


    }
    //Unsuccessful Search
    @Test
    public void tc2() throws IOException, InterruptedException {
        WebDriver driver=getDriver();
        Properties prop=getProperties();

        driver.get(prop.getProperty("ic_user_help_url"));
        driver.findElement(help_centre_input).sendKeys("rfrfer");
        Thread.sleep(2300);
        int size=driver.findElement(help_body).findElements(By.tagName("li")).size();
        System.out.println(size);
        Assert.assertTrue(driver.findElement(help_body).getText().equals("No Result Found"));
        driver.quit();

    }


}
