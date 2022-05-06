package UserSide;

import java.io.IOException;
import java.util.Properties;

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import graphql.Assert;

public class Calorie extends LoginUtility{
	By searchFood=By.xpath("//a[@href='/nutrition']");
	By calculateFitness=By.xpath("//a[@href='/fitness']");
	By trackCalories=By.xpath("//a[@href='/calorie']");
	By recipes=By.xpath("//a[@href='/recipe']");
	By accountInfo=By.xpath("//a[@href='/account-info']");
	By reviews=By.xpath("//a[@href='/review']");
	
	//Calorie
	By daily_tracker=By.xpath("//h1[contains(text(),'DAILY TRACKER')]");
	By calorie_in=By.xpath("//div[contains(@class,'calorie_in')]/h1");
	By calorie_out=By.xpath("//div[contains(@class,'calorie_out')]/h1");
	
	By calorie_out_date=By.xpath("//input[@id='user_c_out_date']");
	By calorie_out_timeperiod=By.xpath("//select[@id='user_time_period']");
	By calorie_out_duration=By.xpath("//select[@id='user_duration']");
	By calorie_out_workout=By.xpath("//select[@id='user_workout']");
	By calorie_out_submit=By.xpath("//div[@id='c_out']//div[@class='row'][5]//button");
	By cout_amount=By.xpath("//div[@id='cout_amount']//input");
	
	
	By calorie_in_date=By.xpath("//input[@id='user_c_in_date']");
	By calorie_in_timeperiod=By.xpath("//select[@id='user_time']");
	By calorie_in_food_item=By.xpath("//input[@id='user_food_item']");
	By calorie_in_serving_size=By.xpath("//select[@id='user_serving_size']");
	By calorie_in_submit=By.xpath("//div[@id='c_in']//div[@class='row'][5]//button");
	By calorie_in_amount=By.xpath("");
	
	

	@Test
	public void t1() throws IOException
	{
		WebDriver driver=Login();
		driver.findElement(trackCalories).click();
		Assert.assertTrue(driver.getTitle().equals("Track Calories"));
		
		Config c=new Config();
		Properties prop=c.getProperties();
		Assert.assertTrue(driver.getCurrentUrl().equals(prop.getProperty("caloriePageUrl")));
		
		driver.findElement(daily_tracker).click();
		driver.findElement(calorie_in).click();
		driver.findElement(calorie_out).click();
		
		System.out.println("--End of Script--");
		driver.quit();
		
		
		
		
	}
	
	//User is on Calorie Page
	//User clicks on the Calorie Out section
	//User fills the fields and clicks submit
	//Calorie burned should appear below

	@Test
	public void t2() throws IOException, InterruptedException
	{
		WebDriver driver=Login();
		driver.findElement(trackCalories).click();
		driver.findElement(calorie_out).click();
		Thread.sleep(1200);
		driver.findElement(calorie_out_date).sendKeys("2022-03-11");
		
		Select selectTimePeriod=new Select(driver.findElement(calorie_out_timeperiod));
		selectTimePeriod.selectByIndex(1);
		Assert.assertFalse(selectTimePeriod.isMultiple());
		
		Select selectTimeDuration=new Select(driver.findElement(calorie_out_timeperiod));
		selectTimeDuration.selectByIndex(1);
		Assert.assertFalse(selectTimeDuration.isMultiple());
		
		Select selectWorkout=new Select(driver.findElement(calorie_out_timeperiod));
		selectWorkout.selectByIndex(1);
		Assert.assertFalse(selectWorkout.isMultiple());
		
		Assert.assertTrue(driver.findElement(calorie_out_submit).isDisplayed());
		driver.findElement(calorie_out_submit).click();
		Thread.sleep(1200);
		Assert.assertTrue(driver.findElement(cout_amount).isDisplayed());
		System.out.println("--End of Script--");
		driver.quit();
		
	
	}
	
	//User is in calorie_out section on the calorie page of the web application
	//User simply just clicks on the Submit button without filling all the fields
	

	@Test
	public void t3() throws InterruptedException, IOException
	{
		WebDriver driver=Login();
		driver.findElement(trackCalories).click();
		driver.findElement(calorie_out).click();
		Thread.sleep(1200);
		Assert.assertTrue(driver.findElement(calorie_out_submit).isDisplayed());
		driver.findElement(calorie_out_submit).click();
		
		//Missing Fields
		Alert a =driver.switchTo().alert();
		Assert.assertTrue(a.getText().equals("Missing Fields"));
		a.accept();
		System.out.println("--End of Script--");
		driver.quit();
		
		
	}
	@Test
	public void t4() throws IOException, InterruptedException
	{	
		String food_item_name="Grapes";
		WebDriver driver=Login();
		driver.findElement(trackCalories).click();
		driver.findElement(calorie_in).click();
		Thread.sleep(1200);
		driver.findElement(calorie_in_date).sendKeys("2022-03-11");
		
		Select calorie_in_time_stamp=new Select(driver.findElement(calorie_in_timeperiod));
		Assert.assertFalse(calorie_in_time_stamp.isMultiple());
		calorie_in_time_stamp.selectByIndex(2);
		
		driver.findElement(calorie_in_food_item).sendKeys(food_item_name);
		Select serving_size=new Select(driver.findElement(calorie_in_serving_size));
		Assert.assertFalse(serving_size.isMultiple());
		serving_size.selectByIndex(0);
		
		Assert.assertTrue(driver.findElement(calorie_in_submit).isDisplayed());
		driver.findElement(calorie_in_submit).click();
		
		System.out.println("--End of Script--");
		driver.quit();
		
		
		
	}
	

}
