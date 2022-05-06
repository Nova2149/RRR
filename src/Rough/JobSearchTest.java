package Rough;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class JobSearchTest {

    String  page_url="http://localhost:3000";
    By user_email= By.xpath("//input[@id='email']");
    By user_password=By.xpath("//input[@id='psw']");
    By user_retype_password=By.xpath("//input[@id='retype-psw']");
    By user_first_name=By.xpath("//input[@id='first_name']");
    By user_last_name=By.xpath("//input[@id='last_name']");
    By user_phone_number=By.xpath("//input[@id='phone']");

    By user_Address=By.xpath("//input[@id='address']");
    By user_city=By.xpath("//input[@id='city']");
    //dropdown
    By user_province=By.xpath("//select[@id='province']");
    By user_country=By.xpath("//input[@id='country']");
    By user_school=By.xpath("//input[@id='school']");
    By user_program=By.xpath("//input[@id='program']");
    //DropDown
    By user_education_level=By.xpath("//select[@id='ed_level']");
    By user_employeer=By.xpath("//input[@id='employer']");
    By user_job_title=By.xpath("//input[@id='job_title']");
    By user_job_duty=By.xpath("//textarea[@id='Job_duty']");
    By user_worked_year=By.xpath("//input[@id='worked_year']");
    By user_attachments=By.xpath("//input[@id='myfile']");

    By user_reset_button=By.xpath("//button[contains(text(),'Reset')]");
    By user_apply_button=By.xpath("//button[contains(text(),'Apply')]");


    WebDriver driver;




    @Before
    public void  getDriver()
    {
        System.setProperty("webdriver.gecko.driver","C:\\FirefoxDriver\\geckodriver.exe");
         driver=new FirefoxDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


    }

    //User is inserted successfully-Best case scenario

    @Test
    public void t1()
    {
        String my_email="hanutagra1@gmail.com";
        String my_password="Msdhoni0";
        String my_retype_password="Msdhoni0";
        String my_first_name="Hanu";
        String my_last_name="Tagra";
        String my_phone_number="4359782828";
        String my_address="3470 Rue Simpson";
        String my_city="Montreal";
        String my_country="Canada";
        //Education
        String my_school="Cegep de la gaspe et des Iles";
        String my_program="CST-Software Testing";
        String my_employer="NST";
        String my_job_title="Software Tester";
        String my_job_duty="Automate the test cases";
        String my_worked_year="2";
        String my_file_path="C:\\Users\\14389\\Desktop\\dd.PNG";


        //String Work Experience


        driver.get(page_url);
        Assert.assertTrue(driver.getTitle().equals("Job Search"));
        //Assert.assertTrue(driver.getCurrentUrl().equals(page_url));
        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().equals("http://localhost:3000/"));

        driver.findElement(user_email).sendKeys(my_email);
        driver.findElement(user_password).sendKeys(my_password);
        driver.findElement(user_retype_password).sendKeys(my_retype_password);
        driver.findElement(user_first_name).sendKeys(my_first_name);
        driver.findElement(user_last_name).sendKeys(my_last_name);
        driver.findElement(user_phone_number).sendKeys(my_phone_number);
        driver.findElement(user_Address).sendKeys(my_address);
        driver.findElement(user_city).sendKeys(my_city);
        //Select the province
        Select s=new Select(driver.findElement(user_province));
        s.selectByIndex(2);
        driver.findElement(user_country).sendKeys(my_country);

        //Education Starts Here
        driver.findElement(user_school).sendKeys(my_school);
        driver.findElement(user_program).sendKeys(my_program);
        Select select=new Select(driver.findElement(user_education_level));
        select.selectByIndex(3);

        //Select current Enrolled Input button
        driver.findElement(By.xpath("//input[@value='Current Enrolled']")).click();
        //WorkExperience Starts Here
        driver.findElement(user_employeer).sendKeys(my_employer);
        driver.findElement(user_job_title).sendKeys(my_job_title);
        driver.findElement(user_job_duty).sendKeys(my_job_duty);
        driver.findElement(user_worked_year).sendKeys(my_worked_year);
        driver.findElement(user_attachments).sendKeys(my_file_path);
        Assert.assertTrue(driver.findElement(user_apply_button).isDisplayed());
        driver.findElement(user_apply_button).click();

        //Handle the Alert
        Alert a =driver.switchTo().alert();
        Assert.assertTrue(a.getText().equals("User inserted Successfully"));
        a.accept();



        System.out.println("--End of Script--");
        driver.quit();


    }


    //All fields are cleared on clicking the Reset button
    @Test
    public void t2()
    {
        String my_email="hanutagra1@gmail.com";
        String my_password="Msdhoni0";
        String my_retype_password="Msdhoni0";
        String my_first_name="Hanu";
        String my_last_name="Tagra";
        String my_phone_number="4359782828";
        String my_address="3470 Rue Simpson";
        String my_city="Montreal";
        String my_country="Canada";
        //Education
        String my_school="Cegep de la gaspe et des Iles";
        String my_program="CST-Software Testing";
        String my_employer="NST";
        String my_job_title="Software Tester";
        String my_job_duty="Automate the test cases";
        String my_worked_year="2";
        String my_file_path="C:\\Users\\14389\\Desktop\\dd.PNG";


        //String Work Experience


        driver.get(page_url);
        Assert.assertTrue(driver.getTitle().equals("Job Search"));
        //Assert.assertTrue(driver.getCurrentUrl().equals(page_url));
        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().equals("http://localhost:3000/"));

        driver.findElement(user_email).sendKeys(my_email);
        driver.findElement(user_password).sendKeys(my_password);
        driver.findElement(user_retype_password).sendKeys(my_retype_password);
        driver.findElement(user_first_name).sendKeys(my_first_name);
        driver.findElement(user_last_name).sendKeys(my_last_name);
        driver.findElement(user_phone_number).sendKeys(my_phone_number);
        driver.findElement(user_Address).sendKeys(my_address);
        driver.findElement(user_city).sendKeys(my_city);
        //Select the province
        Select s=new Select(driver.findElement(user_province));
        s.selectByIndex(2);
        driver.findElement(user_country).sendKeys(my_country);

        //Education Starts Here
        driver.findElement(user_school).sendKeys(my_school);
        driver.findElement(user_program).sendKeys(my_program);
        Select select=new Select(driver.findElement(user_education_level));
        select.selectByIndex(3);

        //Select current Enrolled Input button
        driver.findElement(By.xpath("//input[@value='Current Enrolled']")).click();
        //WorkExperience Starts Here
        driver.findElement(user_employeer).sendKeys(my_employer);
        driver.findElement(user_job_title).sendKeys(my_job_title);
        driver.findElement(user_job_duty).sendKeys(my_job_duty);
        driver.findElement(user_worked_year).sendKeys(my_worked_year);
        driver.findElement(user_attachments).sendKeys(my_file_path);
        Assert.assertTrue(driver.findElement(user_reset_button).isDisplayed());
        driver.findElement(user_reset_button).click();
        //driver.quit();
    }
    //When user clicks directly on the apply button
    //Test case-passed
    @Test
    public void t3()
    {
        driver.get(page_url);
        driver.findElement(user_apply_button).click();
        Alert a =driver.switchTo().alert();
        Assert.assertTrue(a.getText().equals("Missing Fields !"));
        a.accept();

    }
    //When invalid email is entered
    //Test case-passed
    @Test
    public void t4() throws InterruptedException {
        String my_email="Cristano Ronaldo";
        String my_password="Msdhoni0";
        String my_retype_password="Msdhoni0";
        String my_first_name="Hanu";
        String my_last_name="Tagra";
        String my_phone_number="4359782828";
        String my_address="3470 Rue Simpson";
        String my_city="Montreal";
        String my_country="Canada";
        //Education
        String my_school="Cegep de la gaspe et des Iles";
        String my_program="CST-Software Testing";
        String my_employer="NST";
        String my_job_title="Software Tester";
        String my_job_duty="Automate the test cases";
        String my_worked_year="2";
        String my_file_path="C:\\Users\\14389\\Desktop\\dd.PNG";


        //String Work Experience


        driver.get(page_url);
        Assert.assertTrue(driver.getTitle().equals("Job Search"));
        //Assert.assertTrue(driver.getCurrentUrl().equals(page_url));
        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().equals("http://localhost:3000/"));

        driver.findElement(user_email).sendKeys(my_email);
        driver.findElement(user_password).sendKeys(my_password);
        driver.findElement(user_retype_password).sendKeys(my_retype_password);
        driver.findElement(user_first_name).sendKeys(my_first_name);
        driver.findElement(user_last_name).sendKeys(my_last_name);
        driver.findElement(user_phone_number).sendKeys(my_phone_number);
        driver.findElement(user_Address).sendKeys(my_address);
        driver.findElement(user_city).sendKeys(my_city);
        //Select the province
        Select s=new Select(driver.findElement(user_province));
        s.selectByIndex(2);
        driver.findElement(user_country).sendKeys(my_country);

        //Education Starts Here
        driver.findElement(user_school).sendKeys(my_school);
        driver.findElement(user_program).sendKeys(my_program);
        Select select=new Select(driver.findElement(user_education_level));
        select.selectByIndex(3);

        //Select current Enrolled Input button
        driver.findElement(By.xpath("//input[@value='Current Enrolled']")).click();
        //WorkExperience Starts Here
        driver.findElement(user_employeer).sendKeys(my_employer);
        driver.findElement(user_job_title).sendKeys(my_job_title);
        driver.findElement(user_job_duty).sendKeys(my_job_duty);
        driver.findElement(user_worked_year).sendKeys(my_worked_year);
        driver.findElement(user_attachments).sendKeys(my_file_path);
        Assert.assertTrue(driver.findElement(user_apply_button).isDisplayed());
        driver.findElement(user_apply_button).click();

        //Handle the Alert
        Thread.sleep(2300);
        Alert a =driver.switchTo().alert();
        Assert.assertTrue(a.getText().equals("Invalid email"));
        a.accept();



        System.out.println("--End of Script--");
        driver.quit();
    }

    //When password and confirm password doesn't match
    //Test case-passed
    @Test
    public void t5()
    {
        String my_email="hanutagra1@gmail.com";
        String my_password="Msdhoni0";
        String my_retype_password="Msdhoni123";
        String my_first_name="Hanu";
        String my_last_name="Tagra";
        String my_phone_number="4359782828";
        String my_address="3470 Rue Simpson";
        String my_city="Montreal";
        String my_country="Canada";
        //Education
        String my_school="Cegep de la gaspe et des Iles";
        String my_program="CST-Software Testing";
        String my_employer="NST";
        String my_job_title="Software Tester";
        String my_job_duty="Automate the test cases";
        String my_worked_year="2";
        String my_file_path="C:\\Users\\14389\\Desktop\\dd.PNG";


        //String Work Experience


        driver.get(page_url);
        Assert.assertTrue(driver.getTitle().equals("Job Search"));
        //Assert.assertTrue(driver.getCurrentUrl().equals(page_url));
        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().equals("http://localhost:3000/"));

        driver.findElement(user_email).sendKeys(my_email);
        driver.findElement(user_password).sendKeys(my_password);
        driver.findElement(user_retype_password).sendKeys(my_retype_password);
        driver.findElement(user_first_name).sendKeys(my_first_name);
        driver.findElement(user_last_name).sendKeys(my_last_name);
        driver.findElement(user_phone_number).sendKeys(my_phone_number);
        driver.findElement(user_Address).sendKeys(my_address);
        driver.findElement(user_city).sendKeys(my_city);
        //Select the province
        Select s=new Select(driver.findElement(user_province));
        s.selectByIndex(2);
        driver.findElement(user_country).sendKeys(my_country);

        //Education Starts Here
        driver.findElement(user_school).sendKeys(my_school);
        driver.findElement(user_program).sendKeys(my_program);
        Select select=new Select(driver.findElement(user_education_level));
        select.selectByIndex(3);

        //Select current Enrolled Input button
        driver.findElement(By.xpath("//input[@value='Current Enrolled']")).click();
        //WorkExperience Starts Here
        driver.findElement(user_employeer).sendKeys(my_employer);
        driver.findElement(user_job_title).sendKeys(my_job_title);
        driver.findElement(user_job_duty).sendKeys(my_job_duty);
        driver.findElement(user_worked_year).sendKeys(my_worked_year);
        driver.findElement(user_attachments).sendKeys(my_file_path);
        Assert.assertTrue(driver.findElement(user_apply_button).isDisplayed());
        driver.findElement(user_apply_button).click();

        //Handle the Alert
        Alert a =driver.switchTo().alert();
        Assert.assertTrue(a.getText().equals("Password and Confirm Password doesn't match"));
        a.accept();



        System.out.println("--End of Script--");
        driver.quit();
    }
    //When the phone number is invalid
    //Test case-passed
    @Test
    public void t6()
    {
        String my_email="hanutagra1@gmail.com";
        String my_password="Msdhoni0";
        String my_retype_password="Msdhoni0";
        String my_first_name="Hanu";
        String my_last_name="Tagra";
        String my_phone_number="4359782828123";
        String my_address="3470 Rue Simpson";
        String my_city="Montreal";
        String my_country="Canada";
        //Education
        String my_school="Cegep de la gaspe et des Iles";
        String my_program="CST-Software Testing";
        String my_employer="NST";
        String my_job_title="Software Tester";
        String my_job_duty="Automate the test cases";
        String my_worked_year="2";
        String my_file_path="C:\\Users\\14389\\Desktop\\dd.PNG";


        //String Work Experience


        driver.get(page_url);
        Assert.assertTrue(driver.getTitle().equals("Job Search"));
        //Assert.assertTrue(driver.getCurrentUrl().equals(page_url));
        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().equals("http://localhost:3000/"));

        driver.findElement(user_email).sendKeys(my_email);
        driver.findElement(user_password).sendKeys(my_password);
        driver.findElement(user_retype_password).sendKeys(my_retype_password);
        driver.findElement(user_first_name).sendKeys(my_first_name);
        driver.findElement(user_last_name).sendKeys(my_last_name);
        driver.findElement(user_phone_number).sendKeys(my_phone_number);
        driver.findElement(user_Address).sendKeys(my_address);
        driver.findElement(user_city).sendKeys(my_city);
        //Select the province
        Select s=new Select(driver.findElement(user_province));
        s.selectByIndex(2);
        driver.findElement(user_country).sendKeys(my_country);

        //Education Starts Here
        driver.findElement(user_school).sendKeys(my_school);
        driver.findElement(user_program).sendKeys(my_program);
        Select select=new Select(driver.findElement(user_education_level));
        select.selectByIndex(3);

        //Select current Enrolled Input button
        driver.findElement(By.xpath("//input[@value='Current Enrolled']")).click();
        //WorkExperience Starts Here
        driver.findElement(user_employeer).sendKeys(my_employer);
        driver.findElement(user_job_title).sendKeys(my_job_title);
        driver.findElement(user_job_duty).sendKeys(my_job_duty);
        driver.findElement(user_worked_year).sendKeys(my_worked_year);
        driver.findElement(user_attachments).sendKeys(my_file_path);
        Assert.assertTrue(driver.findElement(user_apply_button).isDisplayed());
        driver.findElement(user_apply_button).click();

        //Handle the Alert
       Alert a=driver.switchTo().alert();
       Assert.assertTrue(a.getText().equals("Invalid Phone Number"));
       a.accept();



        System.out.println("--End of Script--");
        driver.quit();
    }

}
//End of File

