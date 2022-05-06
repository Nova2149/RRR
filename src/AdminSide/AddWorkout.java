package AdminSide;

import java.io.IOException;
import java.util.Properties;
import java.util.function.Supplier;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


//Test Case-done
public class AddWorkout extends LoginUtility{
	
	By userInfo=By.xpath("//a[@href='/adminuinfo']");
	By workouts=By.xpath("//a[@href='/workout-admin']");
	By recipes=By.xpath("//a[@href='/edit-recipe']");
	By reviews=By.xpath("//a[@href='/admin-review']");
	
	By workout_name=By.xpath("//input[@id='Workout_name']");
	By workout_calories=By.xpath("//input[@id='workout_calories']");
	By workout_time_period=By.xpath("//input[@id='workout_time_period']");
	By workout_image_url=By.xpath("//input[@id='workout_image_url']");
	By workout_description=By.xpath("//textarea[@id='workout_description']");
	By workout_submit=By.xpath("//button[contains(text(),'Add Workout')]");
	
	
	
	
	//In this test case we out all the fields empty and click on submit
	//An Error Message should appear saying that the fields are empty.
	@Test
	public void t1() throws IOException, InterruptedException {
		WebDriver driver=login();
		driver.findElement(workouts).click();
		//Assertion for the Page Title

		Assert.assertTrue("Title Assertion failed ",driver.getTitle().equals("Add Workout"));
		//Assert.assertTrue(driver.getTitle().equals("Add Workout"));
		
		Config c =new Config();
		Properties prop=c.getProperties();
		//Assertion for the Page Url
		System.out.println(prop.getProperty("adminWorkoutPageUrl"));
		
		String workout_current_url=prop.getProperty("adminWorkoutPageUrl");
		
		Assert.assertTrue("Url assertion failed",driver.getCurrentUrl().equals(workout_current_url));

		Assert.assertTrue(driver.findElement(workout_submit).isDisplayed());
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,30)");
		driver.findElement(workout_submit).click();
		Thread.sleep(2500);


		Alert a =driver.switchTo().alert();
		Assert.assertTrue(a.getText().equals("Missing Fields"));
		a.accept();
		//Missing Fields
		
		System.out.println("--End of Script--");
		driver.quit();
		
		//End of Script

		
		
		
		
	}
	

	@Test
	public void t2() throws IOException
	{
		WebDriver driver=login();
		driver.findElement(workouts).click();
		String user_workout_name="Swimming";
		String user_workout_calories="no calories";
		String user_workout_time_perioed="0.50";
		String user_workout_image_url="http://myimage.jpg";
		String user_workout_description="Weather should be suitable for performing this workout";
		
		//Assertion to check that the button is present or not
		Assert.assertTrue(driver.findElement(workout_submit).isDisplayed());
		
		
		driver.findElement(workout_name).sendKeys(user_workout_name);
		driver.findElement(workout_calories).sendKeys(user_workout_calories);
		driver.findElement(workout_time_period).sendKeys(user_workout_time_perioed);
		driver.findElement(workout_image_url).sendKeys(user_workout_image_url);
		driver.findElement(workout_description).sendKeys(user_workout_description);

		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,30)");
		driver.findElement(workout_submit).click();
		Alert a =driver.switchTo().alert();
		
		//Assertion for the Alert
		Assert.assertTrue(a.getText().equals("Invalid Calories Entered"));
		a.accept();
		
		System.out.println("--End of Script--");
		driver.quit();
		
		
		
	
		
		
		
	}

}
