package UserSide;

import java.io.IOException;

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import graphql.Assert;
//Testing-done
public class CalculateFitness{
	//First User will login then will be navigated to the fitness page
	By searchFood=By.xpath("//a[@href='/nutrition']");
	By calculateFitness=By.xpath("//a[@href='/fitness']");
	By trackCalories=By.xpath("//a[@href='/calorie']");
	By recipes=By.xpath("//a[@href='/recipe']");
	By accountInfo=By.xpath("//a[@href='/account-info']");
	By reviews=By.xpath("//a[@href='/review']");
	
	//Calculate Fitness
	By height=By.xpath("//input[@id='user_height']");
	By weight=By.xpath("//input[@id='user_weight']");
	By age=By.xpath("//input[@id='user_age']");
	By selectWeight=By.xpath("//select[@id='user_weight_type']");
	By selectHeight=By.xpath("//select[@id='user_height_type']");
	By genderMaleButton=By.xpath("//input[@value='male']");
	By genderFemaleButton=By.xpath("//input[@value='female']");
	By submit=By.xpath("//button[@id='calculate_fitness']");
	
	By result_bmi=By.xpath("//input[@id='result_bmi']");
	By result_bmr=By.xpath("//input[@id='result_bmr']");
	
	By error_box=By.xpath("//div[@id='error']");
	
	//Values
	
	String user_height_value="170";
	String user_weight_value="82";
	String user_age_value="26";
		
	
	private  WebDriver driver=null;
	
	//When the user is able to calculate the bmi successfully when all data is provided correctly

	@Test
	public void t1() throws IOException
	{
		LoginUtility ul=new LoginUtility();
		driver=ul.Login();
		driver.findElement(calculateFitness).click();
		
		//Entering the Height of the user
		driver.findElement(height).sendKeys(user_height_value);
		//Entering the weight of the user
		driver.findElement(weight).sendKeys(user_weight_value);
		//Entering the age of the user
		driver.findElement(age).sendKeys(user_age_value);
		
		//Select height(cm/inches) of the user
		Select select_height=new Select(driver.findElement(selectHeight));
		Assert.assertTrue(driver.findElement(selectHeight).isEnabled());
		select_height.selectByIndex(1);
		//Select weight (kg/pounds) of the user
		Select select_weight=new Select(driver.findElement(selectWeight));
		select_weight.selectByIndex(0);
		
		//Select the Gender Radio Button
		Assert.assertTrue(driver.findElement(genderMaleButton).isDisplayed());
		driver.findElement(genderMaleButton).click();
		Assert.assertTrue(driver.findElement(genderMaleButton).isEnabled());
		Assert.assertFalse(driver.findElement(genderFemaleButton).isSelected());
		
		driver.findElement(submit).click();
		System.out.println(driver.findElement(result_bmi).getAttribute("value"));
		
		Assert.assertTrue(!driver.findElement(result_bmi).getAttribute("value").equals("0"));
		Assert.assertTrue(!driver.findElement(result_bmr).getAttribute("value").equals("0"));
		Assert.assertFalse(driver.findElement(error_box).isDisplayed());
		
	}
	//When the user selects invaid health metrices like (Inches/Kg) or(cm/pounds)
	@Test
	public void t2() throws IOException, InterruptedException
	{
		
			LoginUtility ul=new LoginUtility();
			 driver=ul.Login();
			driver.findElement(calculateFitness).click();
			
			//Entering the Height of the user
			driver.findElement(height).sendKeys(user_height_value);
			//Entering the weight of the user
			driver.findElement(weight).sendKeys(user_weight_value);
			//Entering the age of the user
			driver.findElement(age).sendKeys(user_age_value);
			
			//Select height(cm/inches) of the user
			Select select_height=new Select(driver.findElement(selectHeight));
			Assert.assertTrue(driver.findElement(selectHeight).isEnabled());
			select_height.selectByIndex(0);
			//Select weight (kg/pounds) of the user
			Select select_weight=new Select(driver.findElement(selectWeight));
			select_weight.selectByIndex(0);
			
			//Select the Gender Radio Button
			Assert.assertTrue(driver.findElement(genderMaleButton).isDisplayed());
			driver.findElement(genderMaleButton).click();
			Assert.assertTrue(driver.findElement(genderMaleButton).isEnabled());
			Assert.assertFalse(driver.findElement(genderFemaleButton).isSelected());
			
			driver.findElement(submit).click();
			Thread.sleep(1200);
			String bmi=driver.findElement(result_bmi).getText();
			System.out.println("Below");
			
			System.out.println(driver.findElement(result_bmi).getAttribute("value"));
			Assert.assertTrue(driver.findElement(result_bmi).getAttribute("value").equals("0"));
			Assert.assertTrue(driver.findElement(result_bmr).getAttribute("value").equals("0"));
			Assert.assertTrue(driver.findElement(error_box).isDisplayed());
			
			
			System.out.println("--End of Script--");
			driver.quit();
			
		}
		
			
			
		
		
	
	

}
