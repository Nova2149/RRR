package UserSide;

import java.io.IOException;

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import graphql.Assert;
//Testing -done
public class SearchFood extends LoginUtility{
	
	By searchFood=By.xpath("//a[@href='/nutrition']");
	By calculateFitness=By.xpath("//a[@href='/fitness']");
	By trackCalories=By.xpath("//a[@href='/calorie']");
	By recipes=By.xpath("//a[@href='/recipe']");
	By accountInfo=By.xpath("//a[@href='/account-info']");
	By reviews=By.xpath("//a[@href='/review']");
	
	By input_food_name=By.xpath("//input[@id='food_name']");
	By submit=By.xpath("//button[contains(text(),'Submit')]");
	By food_result=By.xpath("//div[@id='food-info']");
	
	private WebDriver driver;
	
	
	//Test Case 1-When  you keep the search feild empty

	@Test
	public void t1() throws IOException, InterruptedException
	{
		driver=Login();
		driver.findElement(searchFood).click();
		driver.findElement(input_food_name).sendKeys("");
		driver.findElement(submit).click();
		Thread.sleep(1200);
		Alert a =driver.switchTo().alert();
		
		String alert_text="Please enter the Name of the Fodd";
		Assert.assertTrue(a.getText().equals(alert_text));
		a.accept();
		
		Assert.assertTrue(driver.findElement(food_result).isDisplayed());
		
		System.out.println("--End of Script--");
		driver.quit();
		
		
		
	}
	//When you  provide an invalid food name into the input box
	@Test
	public void t2() throws IOException, InterruptedException
	{	
		String input_food_value="chair";
		
		driver=Login();
		driver.findElement(searchFood).click();
		driver.findElement(input_food_name).sendKeys(input_food_value);
		driver.findElement(submit).click();
		String alert_text="Sorry we cannot give you info for this product";
		Thread.sleep(3200);
		Alert a1 =driver.switchTo().alert();
		Assert.assertTrue(a1.getText().equals(alert_text));
		a1.accept();
		
		Assert.assertFalse(driver.findElement(food_result).isDisplayed());
		
		System.out.println("-End of Script--");
		driver.quit();
		
		
	}
	//Best Scenario

	@Test
	public void t3() throws IOException, InterruptedException
	{
		String input_food_value="Brown Rice";
		
		driver=Login();
		driver.findElement(searchFood).click();
		driver.findElement(input_food_name).sendKeys(input_food_value);
		driver.findElement(submit).click();
		Thread.sleep(3200);
		Assert.assertTrue(driver.findElement(food_result).isDisplayed());
		
		
		
		
		
		Thread.sleep(1200);
		

		System.out.println("-End of Script--");
		driver.quit();
		
	}
}
