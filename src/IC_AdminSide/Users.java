package IC_AdminSide;

import UserSide.LoginUtility;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Users extends AdminLoginUtility {
    //cannot write as of now
    //dynamic test case
    By user_info_table=By.tagName("table");

    @Test
    public void verify() throws IOException {
        WebDriver driver=Login();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_admmin_users_url"));
        Assert.assertTrue(driver.getCurrentUrl().equals(prop.getProperty("ic_admmin_users_url")));
        Assert.assertTrue(driver.getTitle().equals("Users"));
        Assert.assertTrue(driver.findElement(user_info_table).isDisplayed());
        driver.quit();
        System.out.println("--End of script--");

    }

    //block users usccess
    //####################### critical text case all users should be bloacked first
    @Test
    public void tc1() throws IOException, InterruptedException {
        WebDriver driver=Login();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_admmin_users_url"));
        Thread.sleep(2300);
        int size=driver.findElement(user_info_table).findElements(By.tagName("tr")).size();
        System.out.println(size);
        Thread.sleep(3000);
//       String btn_text= driver.findElement(user_info_table).findElements(By.tagName("tr")).get(1).findElements(By.tagName("td"))
//                .get(5).getText();
//       System.out.println(btn_text);
//        driver.findElement(user_info_table).findElements(By.tagName("tr")).get(1).findElements(By.tagName("td"))
//                .get(5).findElement(By.tagName("button")).click();


        for(int i=1;i<size;i++) {
            String s = driver.findElement(user_info_table).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td"))
                    .get(5).findElement(By.tagName("button")).getText();
            System.out.println(s);
            if (s.equals("Block")) {
                driver.findElement(user_info_table).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td"))
                        .get(5).findElement(By.tagName("button")).click();
            } else
            {

                //Do Nothing
             }
            Thread.sleep(500);

        }
        Thread.sleep(2300);
        System.out.println("--End of Script--");
        driver.quit();

    }

    //unblock users
    //##############critical test case
    @Test
    public void tc4() throws InterruptedException, IOException {
        WebDriver driver=Login();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_admmin_users_url"));
        Thread.sleep(2300);
        int size=driver.findElement(user_info_table).findElements(By.tagName("tr")).size();
        System.out.println(size);
        Thread.sleep(3000);
//       String btn_text= driver.findElement(user_info_table).findElements(By.tagName("tr")).get(1).findElements(By.tagName("td"))
//                .get(5).getText();
//       System.out.println(btn_text);
//        driver.findElement(user_info_table).findElements(By.tagName("tr")).get(1).findElements(By.tagName("td"))
//                .get(5).findElement(By.tagName("button")).click();


        for(int i=1;i<size;i++) {
            String s = driver.findElement(user_info_table).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td"))
                    .get(5).findElement(By.tagName("button")).getText();
            System.out.println(s);
            if (s.equals("Unblock")) {
                driver.findElement(user_info_table).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td"))
                        .get(5).findElement(By.tagName("button")).click();
            } else
            {

                //Do Nothing
            }
            Thread.sleep(500);

        }
        Thread.sleep(2300);
        System.out.println("--End of Script--");
        driver.quit();

    }

    @Test
    public void tc3() throws IOException, InterruptedException {

        WebDriver driver=Login();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_admmin_users_url"));
        Thread.sleep(2300);
        int size=driver.findElement(user_info_table).findElements(By.tagName("tr")).size();
        System.out.println(size);
        //Temp code start Here


        //Temp code ends Here
//        int size=driver.findElement(user_info_table).findElements(By.tagName("tr")).size();
//        System.out.println(size);
        List<String> family_name_list=new ArrayList<>();
        List<String> given_name_list=new ArrayList<>();
        List<String> email_list=new ArrayList<>();
        List<String> phone_list=new ArrayList<>();
        List<String> status_list=new ArrayList<>();
        for(int i=1;i<size;i++)
        {
            family_name_list.add(driver.findElement(user_info_table).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td"))
                    .get(0).getText());

            given_name_list.add(driver.findElement(user_info_table).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td"))
                    .get(1).getText());
            email_list.add(driver.findElement(user_info_table).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td"))
                    .get(2).getText());
            phone_list.add(driver.findElement(user_info_table).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td"))
                    .get(3).getText());
            status_list.add(driver.findElement(user_info_table).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td"))
                    .get(4).getText());
        }
        for(String s:family_name_list)
        {
            System.out.println(s);

        }
        Assert.assertFalse(family_name_list.isEmpty());
        Assert.assertFalse(given_name_list.isEmpty());
        Assert.assertFalse(email_list.isEmpty());
        Assert.assertFalse(phone_list.isEmpty());
        Assert.assertFalse( status_list.isEmpty());
        Thread.sleep(3000);
        driver.quit();
    }

    //Not to run
//    @Test
//    public void tc2() throws IOException, InterruptedException {
//        //##critical test case to remove a user first add one
//        WebDriver driver=Login();
//        Properties prop=getProperties();
//        driver.get(prop.getProperty("ic_admmin_users_url"));
//        Thread.sleep(3500);
//        driver.findElement(user_info_table).findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"))
//                .get(6).findElement(By.tagName("button")).click();
//        System.out.println("User deleted success");
//        driver.quit();
//
//    }
}
