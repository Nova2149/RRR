package AdminSide;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//######ALERT:-Order of test cases is critical please proceed with caution
//Status-done
public class UserInfo extends LoginUtility {
	
	By userInfo=By.xpath("//a[@href='/adminuinfo']");
	By workouts=By.xpath("//a[@href='/add-workout']");
	By recipes=By.xpath("//a[@href='/edit-recipe']");
	By reviews=By.xpath("//a[@href='/admin-review']");
	
	By user_info_table=By.xpath("//tbody[@id='user_info']//tr");
	By user_logout=By.xpath("//button[contains(text(),'Logout')]");
	
	//The below test demonstrates that whenver user loads the user info 
	//all the user details should show up

	@Test
	public void t1() throws IOException
	{
		WebDriver driver=login();
		driver.findElement(userInfo).click();
		Config c=new Config();
		Properties prop=c.getProperties();
		Assert.assertTrue(true);
		//Url Assertion
		Assert.assertTrue(driver.getCurrentUrl().equals(prop.getProperty("userInfoPageUrl")));
		//Title Assertion
		Assert.assertTrue(driver.getTitle().equals("User Info"));
		int size=driver.findElements(user_info_table).size();
		System.out.println(size);
		
		//to Check all the users email are loading up 
		List<String> emailList=new ArrayList<String>();
		List<String> firstNameList=new ArrayList<String>();
		List<String> lastNameList=new ArrayList<String>();
		List<String> phoneList=new ArrayList<String>();
		List<String> addressList=new ArrayList<String>();
		List<String> postalCodeList=new ArrayList<String>();
		for(int i=0;i<size;i++)
		{		
			WebElement user=driver.findElements(By.xpath("//tbody[@id='user_info']//tr")).get(i);
			String email_text=user.findElements(By.tagName("td")).get(2).getText();
			System.out.println(email_text);
			emailList.add(email_text);
			
			String first_name_text=user.findElements(By.tagName("td")).get(0).getText();
			System.out.println(first_name_text);
			firstNameList.add(first_name_text);
			
			String last_name_text=user.findElements(By.tagName("td")).get(1).getText();
			System.out.println(last_name_text);
			lastNameList.add(last_name_text);
			
			String phone_text=user.findElements(By.tagName("td")).get(3).getText();
			System.out.println(phone_text);
			phoneList.add(phone_text);
			
			String address_text=user.findElements(By.tagName("td")).get(4).getText();
			System.out.println(address_text);
			addressList.add(address_text);
			
			String postal_code_text=user.findElements(By.tagName("td")).get(5).getText();
			System.out.println(postal_code_text);
			postalCodeList.add(postal_code_text);
			
			
			
		}
	
		Assert.assertFalse(emailList.isEmpty());
		Assert.assertFalse(firstNameList.isEmpty());
		Assert.assertFalse(lastNameList.isEmpty());
		Assert.assertFalse(phoneList.isEmpty());
		Assert.assertFalse(addressList.isEmpty());
		Assert.assertFalse(postalCodeList.isEmpty());
		
		//
		System.out.println("--End Of Script--");
		driver.quit();
		
		
	}
	//Test case for Blocking a particular User

	@Test
	public void t2() throws IOException
	{
		WebDriver driver=login();
		driver.findElement(userInfo).click();
		
//		Scanner sc=new Scanner(System.in);
//		System.out.println("Enter the name of the user who you want to block");
//		String user_email=sc.next();
		
		String user_email="mayanktagra1@gmail.com";
		
		int size=driver.findElements(user_info_table).size();
		System.out.println(size);
		
		for(int i=0;i<size;i++)
		{
			WebElement user=driver.findElements(By.xpath("//tbody[@id='user_info']//tr")).get(i);
			String email_text=user.findElements(By.tagName("td")).get(2).getText();
			if(email_text.equals(user_email))
			{
				user.findElements(By.tagName("td")).get(6).click();	
				Assert.assertTrue(user.findElements(By.tagName("td")).get(6).getText().equals("Unblock"));
			}
		}
		
		driver.findElement(user_logout).click();
		System.out.println("--End of Script--");
		driver.quit();
	
	}
	
	
	//Test case for Unblocking a particular User

	@Test
	public void t3() throws IOException
	{
		WebDriver driver=login();
		driver.findElement(userInfo).click();
		
//		Scanner sc=new Scanner(System.in);
//		System.out.println("Enter the name of the user who you want to block");
//		String user_email=sc.next();
		
		String user_email="mayanktagra1@gmail.com";
		
		int size=driver.findElements(user_info_table).size();
		System.out.println(size);
		
		for(int i=0;i<size;i++)
		{
			WebElement user=driver.findElements(By.xpath("//tbody[@id='user_info']//tr")).get(i);
			String email_text=user.findElements(By.tagName("td")).get(2).getText();
			if(email_text.equals(user_email))
			{
				user.findElements(By.tagName("td")).get(6).click();	
				Assert.assertTrue(user.findElements(By.tagName("td")).get(6).getText().equals("Block"));
			}
		}
		
		driver.findElement(user_logout).click();
		System.out.println("--End of Script--");
		driver.quit();
	}

}
