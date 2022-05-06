package AdminSide;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import graphql.Assert;
//Test Case-done
public class Review extends LoginUtility {
	
	By userInfo=By.xpath("//a[@href='/adminuinfo']");
	By workouts=By.xpath("//a[@href='/workout-admin']");
	By recipes=By.xpath("//a[@href='/edit-recipe']");
	By reviews=By.xpath("//a[@href='/admin-review']");
	
	By review_rows=By.xpath("//tbody[@id='user_review']//tr");
	
	//Test case to check whether all the reviews are appearing or not
	//Method for that purpose only


	@Test
	public void t1() throws IOException
	{
		
		WebDriver driver=login();
		driver.findElement(reviews).click();
		
		Config c=new Config();
		Properties prop=c.getProperties();
		
		//Assertion for title
		
		Assert.assertTrue(driver.getTitle().equals("All Reviews"));
		//Assertion for Web page url
		Assert.assertTrue(driver.getCurrentUrl().equals(prop.getProperty("adminReviewPageUrl")));
		//To check you are getting all the reviews
		int size=driver.findElements(review_rows).size();
		System.out.println(size);
		
		List<String> userIdList=new ArrayList<String>();
		List<String> firstNameList=new ArrayList<String>();
		List<String> emailList=new ArrayList<String>();
		List<String> dateTimeList=new ArrayList<>();
		List<String> reviewList=new ArrayList<String>();
		
		
		
		for(int i=0;i<size;i++) {

			WebElement userId = driver.findElements(By.xpath("//tbody[@id='user_review']//tr")).get(i);
			String userId_text = userId.findElements(By.tagName("td")).get(0).getText();
			System.out.println(userId_text);
			userIdList.add(userId_text);

			WebElement firstName = driver.findElements(review_rows).get(i);
			String firstName_text = firstName.findElements(By.tagName("td")).get(1).getText();
			System.out.println(firstName_text);
			firstNameList.add(firstName_text);

			WebElement email = driver.findElements(review_rows).get(i);
			String email_text = email.findElements(By.tagName("td")).get(2).getText();
			System.out.println(email_text);
			emailList.add(email_text);

			WebElement dateTime = driver.findElements(review_rows).get(i);
			String dateTime_text = dateTime.findElements(By.tagName("td")).get(3).getText();
			System.out.println(dateTime_text);
			dateTimeList.add(dateTime_text);

			WebElement review = driver.findElements(review_rows).get(i);
			String review_text = review.findElements(By.tagName("td")).get(4).getText();
			System.out.println(review_text);
			reviewList.add(review_text);
		}
			
			Assert.assertNotEmpty(reviewList);
			Assert.assertNotEmpty(userIdList);
			Assert.assertNotEmpty(firstNameList);
			Assert.assertNotEmpty(emailList);
			Assert.assertNotEmpty(dateTimeList);
			Assert.assertNotEmpty(reviewList);
			
			System.out.println("--End of Script--");
			driver.quit();
			
			
			
			
			
			
			
			
			
			

		
		
		
		
	}

}
