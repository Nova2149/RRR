package UserSide;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Scanner;

import org.checkerframework.checker.units.qual.s;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import graphql.Assert;
//Testing-done
public class Register extends Config{
	
	By signupButton=By.xpath("/html/body/div[1]/div[3]/button[1]");
	By signUpSlideButton=By.xpath("/html/body/center/div/div[2]/div[1]/label[2]");
	By firstName=By.xpath("//input[@name='firstname']");
	By lastName=By.xpath("//input[@name='lastname']");
	By email=By.xpath("/html/body/center/div/div[2]/div[2]/form[2]/div[3]/input");
	By password=By.id("psw");
	By confirmPassword=By.id("cpsw");
	By cellNumber=By.id("phone");
	By address=By.xpath("//input[@name='address']");
	By postalCode=By.xpath("//input[@id='pcode']");
	By province=By.id("user_weight_type");
	
	By registerButton=By.xpath("//button[contains(text(),'Register')]");

	
	
	

	
	//Best Case Scenario for the inputs

	@Test
	public void t1() throws IOException
	{
		System.out.println("Hello World");
		WebDriver driver=getDriver();
		Properties prop=getProperties();
		String url=prop.getProperty("homePageUrl");
		System.out.println(url);		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//To Check if user lands on the correct page or not
		String current_url=driver.getCurrentUrl();
		//Assertion for Page Url
		Assert.assertTrue(url.equals(current_url));



		
		
		String user_first_name="Neel";
		String user_last_name="Christian";
		String user_email="nc1@gmail.com";
		String user_password="Msdhoni1";
		String user_confirm_password="Mayank";
		String user_cell_number="4389782345";
		String user_address="5767 Rue Eadie";
		String user_postal_code="H3E4T5";
		
		driver.findElement(signupButton).click();
		driver.findElement(signUpSlideButton).click();

		//Assertion for the Page Title
		Assert.assertTrue(driver.getTitle().equals("Register"));

		driver.findElement(firstName).sendKeys(user_first_name);
		driver.findElement(lastName).sendKeys(user_last_name);
		driver.findElement(email).sendKeys(user_email);
		driver.findElement(password).sendKeys(user_password);
		driver.findElement(confirmPassword).sendKeys(user_confirm_password);
		driver.findElement(cellNumber).sendKeys(user_cell_number);
		driver.findElement(address).sendKeys(user_address);
		driver.findElement(postalCode).sendKeys(user_postal_code);
		
		Select s=new Select(driver.findElement(province));
//		System.out.println("Enter the name of the province starting with capital letter");
//		Scanner sc=new Scanner(System.in);
//		String input_province=sc.next();
		s.selectByIndex(1);
		Assert.assertTrue(driver.findElement(registerButton).isDisplayed());
		driver.findElement(registerButton).click();

		Alert a =driver.switchTo().alert();
		Assert.assertTrue(a.getText().equals("Password and Confirm Password dont match"));
		a.accept();
		//All inputs fields are filled now
		
		
		System.out.println("--End of script--");
		driver.quit();
		
		
		
		
	}

	//When the user keeps all the fields empty
	@Test
	public void t2() throws IOException {

		WebDriver driver=getDriver();
		Properties prop=getProperties();
		driver.get(prop.getProperty("registertaionPageUrl"));
		driver.findElement(signUpSlideButton).click();

		//To check whether the Register button is present or not
		Assert.assertTrue(driver.findElement(registerButton).isDisplayed());
		driver.findElement(registerButton).click();

		Alert a =driver.switchTo().alert();
		Assert.assertTrue(a.getText().equals("Missing Fields"));
		a.accept();

		System.out.println("--End of Script---");
		driver.quit();







	}




}
