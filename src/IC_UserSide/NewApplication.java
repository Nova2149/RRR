package IC_UserSide;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Properties;
//status-done
public class NewApplication extends UserLoginUtility {
    By new_application_link_text=By.xpath("//a[contains(text(),'New Application')]");
    By account_profile_link_text=By.xpath("//a[contains(text(),'Account Profile')]");
    By logout_link_text=By.xpath("//a[contains(text(),'Logout')]");
    By type_of_applicaiton=By.xpath("//select[@id='type_of_application']");
    By ques1_input=By.xpath("//input[@id='ques1']");
    By ques2_input=By.xpath("//input[@id='ques2']");
    By ques3_input=By.xpath("//input[@id='ques3']");
    By date_of_birth_input=By.xpath("//input[@id='dob']");
    By file_upload_input=By.xpath("//input[@id='applicant_file']");
    By submit_button=By.xpath("//button[contains(text(),'Submit')]");
    @Test
    public void verify() throws IOException {
        WebDriver driver=loginUser();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_user_new_application_url"));
        Assert.assertTrue(driver.getCurrentUrl().equals(prop.getProperty("ic_user_new_application_url")));
        Assert.assertTrue(driver.getTitle().equals("New Application"));
        Assert.assertTrue(driver.findElement(type_of_applicaiton).isEnabled());
        Assert.assertTrue(driver.findElement(ques1_input).isEnabled());
        Assert.assertTrue(driver.findElement(ques2_input).isEnabled());
        Assert.assertTrue(driver.findElement(ques3_input).isEnabled());
        Assert.assertTrue(driver.findElement(date_of_birth_input).isEnabled());
        Assert.assertTrue(driver.findElement(file_upload_input).isEnabled());
        Assert.assertTrue(driver.findElement(submit_button).isEnabled());
        System.out.println("--End of Script--");
        driver.quit();


    }
    //when ques1 is empty
    @Test
    public void tc1() throws IOException {
        WebDriver driver=loginUser();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_user_new_application_url"));
        driver.findElement(ques1_input).sendKeys("");//study
        driver.findElement(ques2_input).sendKeys("5");
        driver.findElement(ques3_input).sendKeys("Australia");
        driver.findElement(date_of_birth_input).sendKeys("1995-12-12");
        driver.findElement(file_upload_input).sendKeys("D:\\Sequence diagram.pdf");
        driver.findElement(submit_button).click();

        Alert a =driver.switchTo().alert();
        a.accept();
        driver.quit();

    }
    //When ques 2 is Empty
    @Test
    public void tc2() throws IOException {
        WebDriver driver=loginUser();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_user_new_application_url"));
        driver.findElement(ques1_input).sendKeys("study");//study
        driver.findElement(ques2_input).sendKeys("");
        driver.findElement(ques3_input).sendKeys("Australia");
        driver.findElement(date_of_birth_input).sendKeys("1995-12-12");
        driver.findElement(file_upload_input).sendKeys("D:\\Sequence diagram.pdf");
        driver.findElement(submit_button).click();

        Alert a =driver.switchTo().alert();
        a.accept();
        driver.quit();
    }
    //When ques 3 is Empty
    @Test
    public void tc3() throws IOException {
        WebDriver driver=loginUser();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_user_new_application_url"));
        driver.findElement(ques1_input).sendKeys("study");//study
        driver.findElement(ques2_input).sendKeys("5");
        driver.findElement(ques3_input).sendKeys("");
        driver.findElement(date_of_birth_input).sendKeys("1995-12-12");
        driver.findElement(file_upload_input).sendKeys("D:\\Sequence diagram.pdf");
        driver.findElement(submit_button).click();

        Alert a =driver.switchTo().alert();
        a.accept();
        driver.quit();
    }
    //Invalid Date of Birth
    public void tc4() throws IOException {
        WebDriver driver=loginUser();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_user_new_application_url"));
        driver.findElement(ques1_input).sendKeys("study");//study
        driver.findElement(ques2_input).sendKeys("5");
        driver.findElement(ques3_input).sendKeys("Australia");
        driver.findElement(date_of_birth_input).sendKeys("2023-12-12");
        driver.findElement(file_upload_input).sendKeys("D:\\Sequence diagram.pdf");
        driver.findElement(submit_button).click();

        Alert a =driver.switchTo().alert();
        a.accept();
        driver.quit();
    }
    //No File Uploaded
    @Test
    public void tc5() throws IOException {
        WebDriver driver=loginUser();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_user_new_application_url"));
        driver.findElement(ques1_input).sendKeys("study");//study
        driver.findElement(ques2_input).sendKeys("5");
        driver.findElement(ques3_input).sendKeys("Australia");
        driver.findElement(date_of_birth_input).sendKeys("1993-11-11");

        driver.findElement(submit_button).click();

        Alert a =driver.switchTo().alert();
        a.accept();
        driver.quit();
    }
    //Application Submitted success
    //critical
    //If test case fails try giving a unique poth to file
    @Test
    public void tc6() throws IOException, InterruptedException {
        WebDriver driver=loginUser();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_user_new_application_url"));
        driver.findElement(ques1_input).sendKeys("study");//study
        driver.findElement(ques2_input).sendKeys("5");
        driver.findElement(ques3_input).sendKeys("Australia");
        driver.findElement(date_of_birth_input).sendKeys("1995-11-11");
        driver.findElement(file_upload_input).sendKeys("D:\\assignment1.pdf");
        Thread.sleep(3400);
        driver.findElement(submit_button).click();

        Alert a =driver.switchTo().alert();
        Assert.assertTrue(a.getText().equals("Application Submitted Successfully"));
        // Assert.assertTrue(a.getText().equals("File name is in use choose a different one"));
        a.accept();
        driver.quit();
    }

    @Test
    public void tc7() throws IOException {
        WebDriver driver=loginUser();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_user_new_application_url"));
        driver.findElement(ques1_input).sendKeys("study");//study
        driver.findElement(ques2_input).sendKeys("5");
        driver.findElement(ques3_input).sendKeys("Australia");
        driver.findElement(date_of_birth_input).sendKeys("");
        driver.findElement(file_upload_input).sendKeys("D:\\assignment1.pdf");
        driver.findElement(submit_button).click();

        Alert a =driver.switchTo().alert();

        a.accept();
        driver.quit();
    }
    //When file name already exists
    @Test
    public void tc8() throws IOException, InterruptedException {
        WebDriver driver=loginUser();
        Properties prop=getProperties();
        driver.get(prop.getProperty("ic_user_new_application_url"));
        driver.findElement(ques1_input).sendKeys("study");//study
        driver.findElement(ques2_input).sendKeys("5");
        driver.findElement(ques3_input).sendKeys("Australia");
        driver.findElement(date_of_birth_input).sendKeys("1995-11-11");
        driver.findElement(file_upload_input).sendKeys("D:\\ass.pdf");
        Thread.sleep(3400);
        driver.findElement(submit_button).click();

        Alert a =driver.switchTo().alert();
        Assert.assertTrue(a.getText().equals("File name is in use choose a different one"));
        // Assert.assertTrue(a.getText().equals("File name is in use choose a different one"));
        a.accept();
        driver.quit();
    }



}
