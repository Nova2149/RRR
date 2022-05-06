package IC_UserSide;

import org.openqa.selenium.By;

public class Register {
    By family_name=By.xpath("//input[@id='user_family_name']");
    By given_name=By.xpath("//input[@id='user_given_name']");
    By phone=By.xpath("//input[@id='user_phone']");
    By email=By.xpath("//input[@id='u_email']");
    By confirm_email=By.xpath("//input[@id='user_confirm_email']");
    By password=By.xpath("//input[@id='u_password']");
    By confirm_password=By.xpath("//input[@id='user_confirm_password']");
    By security1=By.xpath("//input[@id='user_security1']");
    By security2=By.xpath("//input[@id='user_security2']");
    By security3=By.xpath("//input[@id='user_security3']");
    By regitser_button=By.xpath("//button[contains(text(),'Register')]");



}
