package UserSide;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Properties;
//Test Case-done

public class Review  extends LoginUtility{
    By searchFood=By.xpath("//a[@href='/nutrition']");
    By calculateFitness=By.xpath("//a[@href='/fitness']");
    By trackCalories=By.xpath("//a[@href='/calorie']");
    By recipes=By.xpath("//a[@href='/recipe']");
    By accountInfo=By.xpath("//a[@href='/account-info']");
    By reviews=By.xpath("//a[@href='/review']");

    By review_input= By.xpath("//textarea[@id='review_input']");
    By submit_review=By.xpath("//button[contains(text(),'Submit')]");

    //If the review input box is empty
    @Test
    public void t1() throws IOException {
        WebDriver driver=Login();
        driver.findElement(reviews).click();
        Config c =new Config();
        Properties prop=c.getProperties();
        //Assertion for Page Url
        Assert.assertTrue(driver.getCurrentUrl().equals(prop.getProperty("reviewPageUrl")));
        //Assertion for Current Title
        Assert.assertTrue(driver.getTitle().equals("Review Page"));

        Assert.assertTrue(driver.findElement(review_input).isDisplayed());
        Assert.assertTrue(driver.findElement(submit_review).isDisplayed());
        driver.findElement(submit_review).click();

        //Handle Alert
        Alert a =driver.switchTo().alert();
        Assert.assertTrue(a.getText().equals("Please write review before submitting"));
        a.accept();
        System.out.println("--End of Script--");
        driver.quit();
    }


    //When you write a review and submit it successfully
    @Test
    public void t2() throws IOException {
        WebDriver driver=Login();
        driver.findElement(reviews).click();

        String user_review="We  are currently evaluating this website";
        driver.findElement(review_input).sendKeys(user_review);
        driver.findElement(submit_review).click();
        //Handle Alert
        Alert a =driver.switchTo().alert();
        Assert.assertTrue(a.getText().equals("Review Submit Successfully"));
        a.accept();

        System.out.println("--End of Script--");
        driver.quit();

    }
}
