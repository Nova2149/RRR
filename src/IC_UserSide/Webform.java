package IC_UserSide;

import org.openqa.selenium.By;

public class Webform {
    By type_of_application= By.xpath("//select[@id='type_of_application']");
    By webform_textarea=By.xpath("//textarea[@id='webform_message']");
    By family_name_input=By.xpath("//input[@id='family_name']");
    By given_name_input=By.xpath("//input[@id='given_name']");
    By email_address_input=By.xpath("//input[@id='email_address']");
    By date_of_birth_input=By.xpath("//input[@id='date_of_birth']");
    By application_number_input=By.xpath("//input[@id='application_number']");
    By mobile_number_input=By.xpath("//input[@id='application_number']");
    By submit_button_input=By.xpath("//button[contains(text(),'Submit')]");
    //End of xpath that are all used



}
