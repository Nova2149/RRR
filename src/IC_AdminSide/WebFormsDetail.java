package IC_AdminSide;

import org.openqa.selenium.By;

public class WebFormsDetail {

    //navbar links will show up here
    //all fields are disabled by default
    By webform_id=By.xpath("//input[@id='webform_id']");
    By webform_dob=By.xpath("//input[@id='webform_dob']");
    By webform_email=By.xpath("//input[@id='webform_email']");
    By webform_mobile=By.xpath("//input[@id='webform_mobile']");
    By webform_type_of_application=By.xpath("//input[@id='webform_type_of_enquiry']");
    By webform_enquiry_message=By.xpath("//textarea[@id='webform_enquiry']");
    By return_button=By.xpath("//button[contains(text(),'Return')]");
}
