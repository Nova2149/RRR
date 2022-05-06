package UserSide;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Properties;
//Testing-done
public class AccountInfo extends LoginUtility{
	By searchFood=By.xpath("//a[@href='/nutrition']");
	By calculateFitness=By.xpath("//a[@href='/fitness']");
	By trackCalories=By.xpath("//a[@href='/calorie']");
	By recipes=By.xpath("//a[@href='/recipe']");
	By accountInfo=By.xpath("//a[@href='/account-info']");
	By reviews=By.xpath("//a[@href='/review']");
	//Password Fields
	By old_password=By.xpath("//input[@id='old_password']");
	By new_password=By.xpath("//input[@id='new_password']");
	By update_new_password=By.xpath("//input[@id='confirm_password']");
	By submit_password=By.xpath("//button[contains(text(),'Submit')]");

	//User Info Fields
	By user_first_name=By.xpath("//input[@id='first-name']");
	By user_last_name=By.xpath("//input[@id='last-name']");
	By user_email=By.xpath("//input[@id='email']");
	By user_cell_number=By.xpath("//input[@id='cell_number']");
	By user_address=By.xpath("//input[@id='address']");
	By user_postal_code=By.xpath("//input[@id='postal_code']");

	By edit_button=By.xpath("//button[contains(text(),'EDIT')]");


	//When all fields in update password section are kept empty

	@Test
	public void t1() throws IOException {
		WebDriver driver=Login();
		driver.findElement(accountInfo).click();
		Config c=new Config();
		Properties prop=c.getProperties();
		//Assertion for Page Url
		Assert.assertTrue(driver.getCurrentUrl().equals(prop.getProperty("accountInfoPageUrl")));
		//Assertion for Title
		Assert.assertTrue(driver.getTitle().equals("AccountInfo Page"));
		//driver.findElement
		//Assertion for Input Fields
		Assert.assertTrue(driver.findElement(old_password).isDisplayed());
		Assert.assertTrue(driver.findElement(new_password).isDisplayed());
		Assert.assertTrue(driver.findElement(update_new_password).isDisplayed());
		Assert.assertTrue(driver.findElement(submit_password).isDisplayed());
		driver.findElement(submit_password).click();
		Alert a =driver.switchTo().alert();
		Assert.assertTrue(a.getText().equals("Missing Fields!"));
		a.accept();
		System.out.println("--End of Script--");
		driver.quit();


	}
	//To Check in selenium if the fields have become editable or not
	//using selenium
	@Test
	public void t2() throws IOException {
		WebDriver driver=Login();
		driver.findElement(accountInfo).click();

		//To  check whether the fields are disabled before clicking the Edit button
		Assert.assertFalse(driver.findElement(user_first_name).isEnabled());
		Assert.assertFalse(driver.findElement(user_last_name).isEnabled()) ;
		Assert.assertFalse(driver.findElement(user_email).isEnabled());
		Assert.assertFalse(driver.findElement(user_address).isEnabled());
		Assert.assertFalse(driver.findElement(user_cell_number).isEnabled());
		Assert.assertFalse(driver.findElement(user_postal_code).isEnabled());

		driver.findElement(edit_button).click();
		//To check whether the fields have bceome editable after clicking the edit button
		Assert.assertTrue(driver.findElement(user_first_name).isEnabled());
		Assert.assertTrue(driver.findElement(user_last_name).isEnabled());
		Assert.assertTrue(driver.findElement(user_email).isEnabled());
		Assert.assertTrue(driver.findElement(user_address).isEnabled());
		Assert.assertTrue(driver.findElement(user_postal_code).isEnabled());
		Assert.assertTrue(driver.findElement(user_cell_number).isEnabled());

		System.out.println("--End of Script--");
		driver.quit();

	}

	

}
