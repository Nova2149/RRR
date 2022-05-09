package IC_UserSide;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
//status-done
public class Home extends ProjectConfig{
    By news_section= By.xpath("//ul[@id='news_info']//li//a");
    By  search_input=By.xpath("//input[@id='search_text']");
    By search_button=By.xpath("//button[contains(text(),'Search')]");
    //Not for this page
    By news_h=By.xpath("//h1[@id='news_h']");
    By news_d=By.xpath("//p[@id='news_d']");
    By go_back_button=By.xpath("//button[contains(text(),'Go Back')]");
    @Test
    public void verify() throws IOException {
        WebDriver driver=getDriver();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_user_home_url"));
        Assert.assertTrue(driver.getCurrentUrl().equals(prop.getProperty("ic_user_home_url")));
        Assert.assertTrue(driver.getTitle().equals("Home Page"));
        Assert.assertTrue(driver.findElement(news_section).isEnabled());
        Assert.assertTrue(driver.findElement(search_button).isEnabled());
        Assert.assertTrue(driver.findElement(search_input).isEnabled());
        driver.quit();

    }
    @Test
    public void tc1() throws IOException, InterruptedException {
        WebDriver driver=getDriver();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_user_home_url"));
        List<String> news_heading=new ArrayList<>();
        List<String> news_description=new ArrayList<>();
        int news_size=driver.findElements(By.xpath("//ul[@id='news_info']//li")).size();
        System.out.println(news_size);
        for(int i=0;i<news_size;i++)
        {
            driver.findElement(By.xpath("//ul[@id='news_info']")).findElements(By.tagName("li")).get(i).click();
            Thread.sleep(500);
            Assert.assertTrue(driver.findElement(news_h).isEnabled());
            Assert.assertTrue(driver.findElement(news_d).isEnabled());
            Assert.assertTrue(driver.findElement(go_back_button).isEnabled());
            news_heading.add(driver.findElement(news_h).getText());
            news_description.add(driver.findElement(news_d).getText());


            Thread.sleep(500);
            driver.navigate().back();
            Thread.sleep(500);

        }
        for(String s:news_heading)
        {
            System.out.println(s);
        }
        for(String s:news_description)
        {
            System.out.println(s);

        }
        Assert.assertFalse(news_heading.isEmpty());
        Assert.assertFalse(news_description.isEmpty());
        System.out.println("--End of script--");
        driver.quit();


    }
    @Test
    public void tc2() throws IOException {
        WebDriver driver=getDriver();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_user_home_url"));
        List<String> news_list=new ArrayList<>();
        int  news_list_size=driver.findElements(news_section).size();
        System.out.println(news_list_size);
        for(int i=0;i<news_list_size;i++)
        {
            WebElement w=driver.findElements(By.xpath("//ul[@id='news_info']//li")).get(i);
            System.out.println(w.getText());
            news_list.add(w.getText());
        }
        //Use of For Each loop
        for(String s:news_list)
        {
            System.out.println(s);
        }
        Assert.assertFalse(news_list.isEmpty());



        driver.quit();
    }
    @Test
   public void tc3() throws IOException, InterruptedException {
        String search_input_value="Mayank";
       WebDriver driver=getDriver();
       Properties prop=getProperties();
       driver.get(prop.getProperty("ic_user_home_url"));
       driver.findElement(search_input).sendKeys(search_input_value);
       driver.findElement(search_button).click();
       Thread.sleep(5000);
       System.out.println(driver.getCurrentUrl());
       System.out.println(prop.getProperty("ic_user_search_url"));
       Assert.assertTrue(driver.getCurrentUrl().equals(prop.getProperty("ic_user_search_url")));
       // Assert.assertTrue(driver.getCurrentUrl().equals(prop.getProperty("ic_user_search_url")));
        System.out.println(driver.findElement(By.xpath("//input[@id='u']")).getAttribute("value"));
        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='u']")).getAttribute("value")
                .equals(search_input_value));
      //  Assert.assertTrue(driver.findElement(By.xpath("//input[@id='u']")).getText().equals("Mayank"));
      Assert.assertTrue(driver.findElement(By.xpath("//div[@id='news_info']")).isDisplayed());
        System.out.println("--End of Script--");
        driver.quit();



   }
}
