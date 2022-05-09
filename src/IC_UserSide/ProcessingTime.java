package IC_UserSide;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.Properties;

public class ProcessingTime extends ProjectConfig {
    By submit_button=By.xpath("//button[contains(text(),'Submit')]");
    By type_of_application=By.xpath("//select[@id='user_application_type']");
    By output_input=By.xpath("//input[@id='p_time']");

    @Test
    public void verify() throws IOException {
        WebDriver driver=getDriver();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_user_processing_time_url"));
        Assert.assertTrue(driver.getCurrentUrl().equals(prop.getProperty("ic_user_processing_time_url")));
        Assert.assertTrue(driver.getTitle().equals("Processing Time"));
        Assert.assertTrue(driver.findElement(submit_button).isEnabled());
        Assert.assertTrue(driver.findElement(type_of_application).isEnabled());
        driver.quit();

    }

    @Test
    public void t2() throws IOException {
        WebDriver driver=getDriver();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_user_processing_time_url"));
        Select s=new Select(driver.findElement(type_of_application));
        s.selectByIndex(1);
        driver.findElement(submit_button).click();
        Assert.assertTrue(driver.findElement(output_input).isEnabled());
        Assert.assertTrue(driver.findElement(output_input).getAttribute("value").contains("days"));
        driver.quit();

    }

}
