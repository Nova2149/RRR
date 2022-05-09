package IC_AdminSide;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Application extends AdminLoginUtility {
    By application_table=By.tagName("table");
    //Application Detail Page
    By application_id= By.xpath("//input[@id='applicant_id']");
    By type_of_application=By.xpath("//input[@id='application_type']");
    By ques1=By.xpath("//input[@id='application_ques1']");
    By ques2=By.xpath("//input[@id='application_ques2']");
    By ques3=By.xpath("//input[@id='application_ques3']");
    By dob=By.xpath("//input[@id='application_dob']");
    By doc_file_name=By.xpath("//input[@id='application_file_name']");
    //These Fields are enabled and they are dropdowns
    By application_status=By.xpath("//select[@id='applicant_status']");
    By medical_status=By.xpath("//select[@id='medical_status']");
    By background_status=By.xpath("//select[@id='background_status']");

    By update_button=By.xpath("//button[contains(text(),'Update')]");
    By return_button=By.xpath("//button[contains(text(),'Return')]");

    @Test
    public void verify() throws IOException {
        WebDriver driver=Login();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_admin_applications_url"));
        Assert.assertTrue(driver.getCurrentUrl().equals(prop.getProperty("ic_admin_applications_url")));
        Assert.assertTrue(driver.getTitle().equals("Application"));
        Assert.assertTrue(driver.findElement(application_table).isDisplayed());
        System.out.println("--End of script--");
        driver.quit();


    }
    @Test
    public void tc1() throws IOException, InterruptedException {
        WebDriver driver=Login();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_admin_applications_url"));
        Thread.sleep(2300);

        int size=driver.findElement(application_table).findElements(By.tagName("tr")).size();
        System.out.println(size);

        driver.findElement(application_table).findElements(By.tagName("tr")).get(1).findElements(By.tagName("td"))
                .get(6).findElement(By.tagName("button")).click();
        Thread.sleep(2300);
        Assert.assertTrue(driver.findElement(application_id).isDisplayed());
        Assert.assertTrue(driver.findElement(type_of_application).isDisplayed());
        Assert.assertTrue(driver.findElement(ques1).isDisplayed());
        Assert.assertTrue(driver.findElement(ques2).isDisplayed());
        Assert.assertTrue(driver.findElement(ques3).isDisplayed());
        Assert.assertTrue(driver.findElement(dob).isDisplayed());
        Assert.assertTrue(driver.findElement(application_status).isDisplayed());
        Assert.assertTrue(driver.findElement(medical_status).isDisplayed());
        Assert.assertTrue(driver.findElement(background_status).isDisplayed());
        Assert.assertTrue(driver.findElement(doc_file_name).isDisplayed());
        Assert.assertTrue(driver.findElement(return_button).isDisplayed());
        Assert.assertTrue(driver.findElement(update_button).isDisplayed());
        driver.findElement(return_button).click();

        Thread.sleep(2300);



        System.out.println("--End of Script--");
        driver.quit();
    }
    //admin changes the status of the Application
    @Test
    public void tc2() throws InterruptedException, IOException {
        WebDriver driver=Login();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_admin_applications_url"));
        Thread.sleep(2300);

        int size=driver.findElement(application_table).findElements(By.tagName("tr")).size();
        System.out.println(size);

        driver.findElement(application_table).findElements(By.tagName("tr")).get(1).findElements(By.tagName("td"))
                .get(6).findElement(By.tagName("button")).click();
        Thread.sleep(2300);
        Assert.assertTrue(driver.findElement(application_id).isDisplayed());
        Assert.assertTrue(driver.findElement(type_of_application).isDisplayed());
        Assert.assertTrue(driver.findElement(ques1).isDisplayed());
        Assert.assertTrue(driver.findElement(ques2).isDisplayed());
        Assert.assertTrue(driver.findElement(ques3).isDisplayed());
        Assert.assertTrue(driver.findElement(dob).isDisplayed());
        Assert.assertTrue(driver.findElement(application_status).isDisplayed());
        Assert.assertTrue(driver.findElement(medical_status).isDisplayed());
        Assert.assertTrue(driver.findElement(background_status).isDisplayed());
        Assert.assertTrue(driver.findElement(doc_file_name).isDisplayed());
        Assert.assertTrue(driver.findElement(return_button).isDisplayed());
        Assert.assertTrue(driver.findElement(update_button).isDisplayed());


        //application_status
        Select as=new Select(driver.findElement(application_status));
        as.selectByIndex(4);
        Select ms=new Select(driver.findElement(medical_status));
        ms.selectByIndex(4);
        Select bs=new Select(driver.findElement(background_status));
        bs.selectByIndex(4);
       driver.findElement(update_button).click();
       Alert a =driver.switchTo().alert();
       Assert.assertTrue(a.getText().equals("Status updated successfully"));
       a.accept();
        driver.findElement(return_button).click();


        Thread.sleep(2300);



        System.out.println("--End of Script--");
        driver.quit();
    }
    //User Info is populated successfully
    @Test
    public void tc3() throws IOException, InterruptedException {
        WebDriver driver = Login();
        Properties prop = getProperties();
        driver.get(prop.getProperty("ic_admin_applications_url"));
        Thread.sleep(2300);

        int size = driver.findElement(application_table).findElements(By.tagName("tr")).size();
        System.out.println(size);
        List<String> application_number_list=new ArrayList<>();
        List<String> application_type_list=new ArrayList<>();
        List<String> applicant_id_list=new ArrayList<>();
        List<String> application_status_list=new ArrayList<>();
        List<String> medical_status_list=new ArrayList<>();
        List<String> background_status_list=new ArrayList<>();

        for (int i = 1; i < size; i++){

            application_number_list.add(driver.findElement(application_table).findElements(By.tagName("tr"))
                    .get(i).findElements(By.tagName("td")).get(0).getText());
            application_type_list.add(driver.findElement(application_table).findElements(By.tagName("tr"))
                    .get(i).findElements(By.tagName("td")).get(1).getText());
            applicant_id_list.add(driver.findElement(application_table).findElements(By.tagName("tr"))
                    .get(i).findElements(By.tagName("td")).get(2).getText());
            application_status_list.add(driver.findElement(application_table).findElements(By.tagName("tr"))
                    .get(i).findElements(By.tagName("td")).get(3).getText());
            medical_status_list.add(driver.findElement(application_table).findElements(By.tagName("tr"))
                    .get(i).findElements(By.tagName("td")).get(4).getText());
            background_status_list.add(driver.findElement(application_table).findElements(By.tagName("tr"))
                    .get(i).findElements(By.tagName("td")).get(5).getText());


        }

        Assert.assertNotNull(application_number_list);
        Assert.assertNotNull(application_type_list);
        Assert.assertNotNull(applicant_id_list);
        Assert.assertNotNull(application_status_list);
        Assert.assertNotNull(background_status_list);
        Thread.sleep(2300);

        System.out.println("--End of Script--");


    }

}
