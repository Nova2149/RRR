package IC_UserSide;

import org.openqa.selenium.By;

public class ForgotPassword {
    By email_address=By.xpath("//input[@id='user_email']");
    //Its a dropdown
    By security_question=By.xpath("//select[@id='security_ques']");
    By security_answer_input=By.xpath("//input[@id='security_ques_ans']");
    By check_button=By.xpath("//button[contains(text(),'Check')]");
    By new_password_input=By.xpath("//input[@id='new_password']"); //disabled on page laod
    By new_confirm_password_input=By.xpath("//input[@id='confirm_new_password']");//disabled on page load
    By reset_password_input=By.xpath("//button[@id='re']");



}
