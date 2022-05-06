package AdminSide;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Properties;

public class EditRecipe extends LoginUtility{

    By userInfo=By.xpath("//a[@href='/adminuinfo']");
    By workouts=By.xpath("//a[@href='/workout-admin']");
    By recipes=By.xpath("//a[@href='/edit-recipe']");
    By reviews=By.xpath("//a[@href='/admin-review']");

    By first_edit_button=By.xpath("//body/div[3]/div[1]/div[1]/div[4]/div[3]/button[1]");
    By update_recipe_calories=By.xpath("//input[@id='update_recipe_calories']");
    By update_recipe_serving_size=By.xpath("//input[@id='update_recipe_serving_size']");
    By update_recipe_type=By.xpath("//select[@id='update_recipe_type']");
    By update_recipe_image_url=By.xpath("//input[@id='update_recipe_image_url']");
    By update_recipe_description=By.xpath("//textarea[@id='update_recipe_description']");
    By update_close_button=By.xpath("//div[contains(text(),'×')]");

//This test case demonstrates that when the user clicks on the Edit button the recipe's details are displayed
//They don't appear to come null

@Test
public void t1() throws IOException {
        WebDriver driver=login();
        driver.findElement(recipes).click();
        Config c=new Config();
        Properties prop=c.getProperties();
        //Assertion for Page Url
        Assert.assertTrue(driver.getCurrentUrl().equals(prop.getProperty("adminRecipePageUrl")));
        //Assertion for Page Title
        Assert.assertTrue(driver.getTitle().equals("Edit Recipes"));

        //Assertion for whether the edit button is present or not
        Assert.assertTrue(driver.findElement(first_edit_button).isDisplayed());
        driver.findElement(first_edit_button).click();

        Assert.assertTrue(driver.findElement(update_recipe_calories).isDisplayed());
        Assert.assertNotNull(driver.findElement(update_recipe_calories).getAttribute("value"));

        Assert.assertTrue(driver.findElement(update_recipe_serving_size).isDisplayed());
        Assert.assertNotNull(driver.findElement(update_recipe_serving_size).getAttribute("value"));

        Assert.assertTrue(driver.findElement(update_recipe_type).isDisplayed());
        Assert.assertNotNull(driver.findElement(update_recipe_type).getAttribute("value"));



        Assert.assertTrue(driver.findElement(update_recipe_image_url).isDisplayed());
        Assert.assertNotNull(driver.findElement(update_recipe_image_url).getAttribute("value"));

        Assert.assertTrue(driver.findElement(update_recipe_description).isDisplayed());
        Assert.assertNotNull(driver.findElement(update_recipe_description).getAttribute("value"));


        System.out.println("--End of Script--");
        driver.quit();

    }


    //To demonstrate that the user is able to close the Popup box successfully
    @Test
    public void t2() throws IOException {
        WebDriver driver=login();
        driver.findElement(recipes).click();

        driver.findElement(first_edit_button).click();
        Assert.assertTrue(driver.findElement(update_close_button).isDisplayed());
        driver.findElement(update_close_button).click();



    }
}
