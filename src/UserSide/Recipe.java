package UserSide;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Properties;
//Test case-done
public class Recipe extends LoginUtility {

    By searchFood=By.xpath("//a[@href='/nutrition']");
    By calculateFitness=By.xpath("//a[@href='/fitness']");
    By trackCalories=By.xpath("//a[@href='/calorie']");
    By recipes=By.xpath("//a[@href='/recipe']");
    By accountInfo=By.xpath("//a[@href='/account-info']");
    By reviews=By.xpath("//a[@href='/review']");

    //Recipe Page Elements
    By vegan_recipes=By.xpath("//a[contains(text(),'VEGAN RECIPES')]");
    By vegetarain_recipes=By.xpath("//a[@class='veg']");
    By non_vegetarian_recipes=By.xpath("//a[contains(text(),'NON VEGETARIAN RECIPES')]");

    By veg_div=By.xpath("//div[@id='veg_diet']");
    By non_veg_div=By.xpath("//div[@id='nonveg_diet']");
    By vegan_div=By.xpath("//div[@id='vegan_diet']");

    //To Check only the Veagn Foods items are displayed

    @Test
    public void t1() throws IOException {
        WebDriver driver=Login();
        driver.findElement(recipes).click();
        //Assertion for the Page url
        Config c=new Config();
        Properties prop=c.getProperties();
        //Assertion forCurrent Url
        Assert.assertTrue(driver.getCurrentUrl().equals(prop.getProperty("recipePageUrl")));
        //Assertion for Page Title
        Assert.assertTrue(driver.getTitle().equals("Recipes"));

        //Assertion for differnt Recipes buttons/links
        Assert.assertTrue(driver.findElement(vegan_recipes).isDisplayed());
        Assert.assertTrue(driver.findElement(vegetarain_recipes).isDisplayed());
        Assert.assertTrue(driver.findElement(non_vegetarian_recipes).isDisplayed());

        driver.findElement(vegan_recipes).click();
        Assert.assertTrue(driver.findElement(vegan_div).isDisplayed());
       Assert.assertFalse(driver.findElement(veg_div).isDisplayed());
       Assert.assertFalse(driver.findElement(non_veg_div).isDisplayed());

       System.out.println("--End of Script--");
       driver.quit();


    }

    //To check only the vegetarian food items are displayed
    @Test
    public void t2() throws IOException {
        WebDriver driver=Login();
        driver.findElement(recipes).click();

        driver.findElement(vegetarain_recipes).click();
        //Only the Veg_div should be displayed when the user clicks on the vegetarian recipe option
        Assert.assertFalse(driver.findElement(vegan_div).isDisplayed());
        Assert.assertTrue(driver.findElement(veg_div).isDisplayed());
        Assert.assertFalse(driver.findElement(non_veg_div).isDisplayed());

    }

    @Test
    public void t3() throws IOException {
        WebDriver driver=Login();
        driver.findElement(recipes).click();

        driver.findElement(non_vegetarian_recipes).click();

        //Only Non Veg div should appear
        Assert.assertFalse(driver.findElement(veg_div).isDisplayed());
        Assert.assertFalse(driver.findElement(vegan_div).isDisplayed());
        Assert.assertTrue(driver.findElement(non_veg_div).isDisplayed());
    }

}
