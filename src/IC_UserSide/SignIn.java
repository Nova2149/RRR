package IC_UserSide;

import org.openqa.selenium.By;

public class SignIn {
    By user_email=By.xpath("//input[@id='user_email']");
    By user_password=By.xpath("//input[@id='user_password']");
    By login_btn=By.xpath("//button[contains(text(),'Login')]");
}
