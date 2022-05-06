package UserSide;

import java.io.IOException;
import java.util.Properties;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import graphql.Assert;


//Test case-done

public class Workout extends LoginUtility{
	By workout_dropdown=By.xpath("//select[@id='workout']");
	By workout_search=By.xpath("//button[contains(text(),'Search')]");
	
	By workout_image=By.xpath("//body/div[@id='workout-data']/div[1]/div[2]/div[2]/img[1]");
	By workout_calories=By.xpath("//body/div[@id='workout-data']/div[1]/div[3]/div[2]/input[1]");
	By workout_description=By.xpath("//textarea[@id='description_text_area']");
	
	
	
	@Test
	public void t1() throws IOException, InterruptedException
	{
		WebDriver driver=Login();
		Config c =new Config();
		
		Properties prop=c.getProperties();
		String workout_url=prop.getProperty("workoutPageUrl");
		driver.navigate().to(workout_url);
		
		Assert.assertTrue(driver.getTitle().equals("Workout Info"));
		Assert.assertTrue(driver.getCurrentUrl().equals(workout_url));
		Select select_workout=new Select(driver.findElement(workout_dropdown));
		Assert.assertFalse(select_workout.isMultiple());
		select_workout.selectByIndex(1);
		
		
		Assert.assertTrue(driver.findElement(workout_search).isDisplayed());
		driver.findElement(workout_search).click();
		Thread.sleep(1200);
		Assert.assertTrue(driver.findElement(workout_image).isDisplayed());
		Assert.assertTrue(driver.findElement(workout_calories).isDisplayed());
		Assert.assertTrue(driver.findElement(workout_description).isDisplayed());
		
		System.out.println("--End of Script--");
		driver.quit();
			
		
		
	}
	

}
