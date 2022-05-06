package IC_UserSide;

import org.openqa.selenium.By;

public class AccountProfile {


    By new_application_link_text=By.xpath("//a[contains(text(),'New Application')]");
    By account_profile_link_text=By.xpath("//a[contains(text(),'Account Profile')]");
    By logout_link_text=By.xpath("//a[contains(text(),'Logout')]");

    By email_input=By.xpath("//input[@id='user_email']"); //disabled on page load
    By phone_ionput=By.xpath("//input[@id='user_phone']");//disabled on page load
    By edit_button=By.xpath("//button[contains(text(),'Edit')]");
    By update_account_info_button=By.xpath("//button[@id='update_button']");//disabled on page load
    By old_password_input=By.xpath("//input[@id='old_password']");
    By new_password_input=By.xpath("//input[@id='new_password']");
    By confirm_password_input=By.xpath("//input[@id='confirm_password']");
    By check_button=By.xpath("//button[contains(text(),'Check')]");
    By update_password_button=By.xpath("//button[@id='update_password']");

}
