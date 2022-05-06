package Rough;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.time.Duration;

public class ActionExample {

        @Test
       public void dragAndDropExample() throws InterruptedException {
            System.out.println("Hello World");
            System.setProperty("webdriver.gecko.driver","C:\\FirefoxDriver\\geckodriver.exe");
            WebDriver driver=new FirefoxDriver();
            driver.get("https://demoqa.com/droppable/");

            By dragme=By.xpath("//div[@id='draggable']");
            By drophere=By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']");
           Actions action=new Actions(driver);
           //The dragAndDrop() takes the Source and the Target Element as the parameters
           action.dragAndDrop(driver.findElement(dragme),driver.findElement(drophere)).build().perform();
           Thread.sleep(5000);
           driver.navigate().refresh();
           //The dragAndDropBy takes the source element ,x-offset and the y-offset as the parameter
           action.dragAndDropBy(driver.findElement(dragme),200,0).build().perform();
           Thread.sleep(5000);
           System.out.println("--End Of Script");
           driver.quit();
        }

        @Test
        public void t2() throws InterruptedException {
            //KeyDown and Keyup Method Provided by the Action Class
            System.setProperty("webdriver.gecko.driver","C:\\FirefoxDriver\\geckodriver.exe");
            WebDriver driver=new FirefoxDriver();
            String current_url="https://www.google.com/";
            driver.get(current_url);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            //softwarehelping.com

            By user_input=By.xpath("//input[@name='q']");
            Actions action=new Actions(driver);
            action.keyDown(Keys.SHIFT).sendKeys(driver.findElement(user_input),"IPad").
                    keyUp(Keys.SHIFT).sendKeys(driver.findElement(user_input),"PRO").build().perform();
            Thread.sleep(3000);
            System.out.println("--end Of Script");
            driver.quit();



        }

        @Test
        public void t3() throws InterruptedException {

            //Example of Click and Hold in Selenium
            System.setProperty("webdriver.gecko.driver","C:\\FirefoxDriver\\geckodriver.exe");
            WebDriver driver=new FirefoxDriver();
            String url="https://www.google.com/";
            driver.get(url);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            By search_button=By.xpath("//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[3]/center[1]/input[1]");
            Actions action=new Actions(driver);
            action.clickAndHold(driver.findElement(search_button)).build().perform();
            //Context Click or Right Click and Double Click Example using Selenium

            Thread.sleep(2300);
            driver.navigate().to("https://demoqa.com/buttons");
            By double_click=By.xpath("//button[@id='doubleClickBtn']");
            By click_me=By.xpath("//button[@id='yOEAN']");
            By right_click=By.xpath("//button[@id='rightClickBtn']");

            action.contextClick(driver.findElement(right_click)).build().perform();
            Thread.sleep(2000);
            action.doubleClick(driver.findElement(double_click)).build().perform();
            Thread.sleep(2000);

            Thread.sleep(2000);
            driver.navigate().refresh();
            //Example of moveToElement() in selenium
            action.moveToElement(driver.findElement(double_click)).doubleClick().build().perform();

            System.out.println("--End of Script--");
            driver.quit();
            //This is the end of script


        }

        @Test
        public void t4()
        {
            System.setProperty("webdriver.chrome.driver","C:\\FirefoxDriver\\geckodriver.exe");
            WebDriver driver=new FirefoxDriver();
            driver.get("");

        }
}
