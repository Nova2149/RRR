package IC_AdminSide;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class NewsSection extends AdminLoginUtility {
    By news_table=By.tagName("table");
    By news_edit_title=By.xpath("//input[@id='news_title']");
    By news_edit_description=By.xpath("//textarea[@id='news_description']");
    By update_button=By.xpath("//button[contains(text(),'Update')]");
    By return_edit_news_btn=By.xpath("//button[contains(text(),'Return')]");

    By news_add_title=By.xpath("//input[@id='news_heading']");
    By news_add_description=By.xpath("//textarea[@id='news_description']");
    By news_add_btn=By.xpath("//button[contains(text(),'Add')]");




    @Test
    public void verify() throws IOException, InterruptedException {
        WebDriver driver=Login();
       Properties prop=getProperties();
       driver.get(prop.getProperty("ic_admin_news_url"));
       Thread.sleep(2300);
       Assert.assertTrue(driver.getCurrentUrl().equals(prop.getProperty("ic_admin_news_url")));
       Assert.assertTrue(driver.getTitle().equals("News Section"));
       Assert.assertTrue(driver.findElement(news_table).isDisplayed());
       System.out.println("--End of Script--");
       driver.quit();
    }
    //News data is populated successfully
    @Test
    public void tc1() throws IOException, InterruptedException {
        WebDriver driver=Login();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_admin_news_url"));
        Thread.sleep(2300);
        int size=driver.findElement(news_table).findElements(By.tagName("tr")).size();
        System.out.println(size);
        List<String> news_title_list=new ArrayList<>();
        for(int i=1;i<size;i++)
        {
            String s=driver.findElement(news_table).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td"))
                    .get(0).getText();
            news_title_list.add(s);

        }
        Assert.assertNotNull(news_title_list);
        System.out.println("--End of Script--");
        driver.quit();


    }

    //Edit News Article
    @Test
    public void tc2() throws IOException, InterruptedException {
        WebDriver driver=Login();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_admin_news_url"));
        Thread.sleep(2300);
        driver.findElement(news_table).findElements(By.tagName("tr")).get(1).findElements(By.tagName("td"))
                .get(1).findElement(By.tagName("button")).click();
        Thread.sleep(2300);
        Assert.assertTrue(driver.findElement(news_edit_title).getAttribute("value").equals("Canadians continue to support Afghan refugees across the country"));
        driver.findElement(update_button).click();
        Assert.assertTrue(driver.findElement(update_button).isDisplayed());
        Assert.assertTrue(driver.findElement(return_edit_news_btn).isDisplayed());
        Thread.sleep(3500);
        Alert a =driver.switchTo().alert();
        Assert.assertTrue(a.getText().equals("News Updated success"));
        a.accept();
        driver.navigate().refresh();
        System.out.println("--End of script--");
        driver.quit();

    }
    //Add new news Article
    @Test
    public void tc3() throws IOException, InterruptedException {
        WebDriver driver=Login();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_admin_news_url"));
        Thread.sleep(2300);
        int size=driver.findElement(news_table).findElements(By.tagName("tr")).size();
        System.out.println(size);
        driver.findElement(news_table).findElements(By.tagName("tr")).get(size-1).findElements(By.tagName("td"))
                .get(1).findElement(By.tagName("button")).click();
        Assert.assertTrue(driver.findElement(news_add_title).isDisplayed());
        Assert.assertTrue(driver.findElement(news_add_description).isDisplayed());
        Assert.assertTrue(driver.findElement(news_add_btn).isDisplayed());
        Thread.sleep(2300);
        driver.findElement(news_add_title).sendKeys("New News Heading");
        driver.findElement(news_add_description).sendKeys("New News description");
        driver.findElement(news_add_btn).click();
        Thread.sleep(2300);
        Alert a=driver.switchTo().alert();
        Assert.assertTrue(a.getText().equals("New News Inserted"));
        a.accept();
        System.out.println("--End of Script--");
        driver.quit();


    }
    //Empty News Heading Field
    @Test
    public void tc4() throws IOException, InterruptedException {
        WebDriver driver=Login();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_admin_news_url"));
        Thread.sleep(2300);
        int size=driver.findElement(news_table).findElements(By.tagName("tr")).size();
        System.out.println(size);
        driver.findElement(news_table).findElements(By.tagName("tr")).get(size-1).findElements(By.tagName("td"))
                .get(1).findElement(By.tagName("button")).click();
        Assert.assertTrue(driver.findElement(news_add_title).isDisplayed());
        Assert.assertTrue(driver.findElement(news_add_description).isDisplayed());
        Assert.assertTrue(driver.findElement(news_add_btn).isDisplayed());
        Thread.sleep(2300);
        driver.findElement(news_add_title).sendKeys("");
        driver.findElement(news_add_description).sendKeys("New News description");
        driver.findElement(news_add_btn).click();
        Thread.sleep(2300);
        Alert a=driver.switchTo().alert();
        Assert.assertTrue(a.getText().equals("Missing Fields"));
        a.accept();
        System.out.println("--End of Script--");
        driver.quit();
    }
    //Empty News description Field
    @Test
    public void tc5() throws IOException, InterruptedException {
        WebDriver driver=Login();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_admin_news_url"));
        Thread.sleep(2300);
        int size=driver.findElement(news_table).findElements(By.tagName("tr")).size();
        System.out.println(size);
        driver.findElement(news_table).findElements(By.tagName("tr")).get(size-1).findElements(By.tagName("td"))
                .get(1).findElement(By.tagName("button")).click();
        Assert.assertTrue(driver.findElement(news_add_title).isDisplayed());
        Assert.assertTrue(driver.findElement(news_add_description).isDisplayed());
        Assert.assertTrue(driver.findElement(news_add_btn).isDisplayed());
        Thread.sleep(2300);
        driver.findElement(news_add_title).sendKeys("New News Heading");
        driver.findElement(news_add_description).sendKeys("");
        driver.findElement(news_add_btn).click();
        Thread.sleep(2300);
        Alert a=driver.switchTo().alert();
        Assert.assertTrue(a.getText().equals("Missing Fields"));
        a.accept();
        System.out.println("--End of Script--");
        driver.quit();
    }

    //Empty news description on edit news page
    @Test
    public void tc6() throws InterruptedException, IOException {
        WebDriver driver=Login();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_admin_news_url"));
        Thread.sleep(2300);
        driver.findElement(news_table).findElements(By.tagName("tr")).get(1).findElements(By.tagName("td"))
                .get(1).findElement(By.tagName("button")).click();
        Thread.sleep(2300);
        Assert.assertTrue(driver.findElement(news_edit_title).getAttribute("value").equals("Canadians continue to support Afghan refugees across the country"));
        Assert.assertTrue(driver.findElement(news_edit_description).isEnabled());
        Assert.assertTrue(driver.findElement(update_button).isDisplayed());
        Assert.assertTrue(driver.findElement(return_edit_news_btn).isDisplayed());
        driver.findElement(news_edit_description).clear();

        driver.findElement(update_button).click();
        Thread.sleep(3500);
        Alert a =driver.switchTo().alert();
        Assert.assertTrue(a.getText().equals("Missing Fields"));
        a.accept();



        driver.navigate().refresh();
        System.out.println("--End of script--");
        driver.quit();



    }
}
