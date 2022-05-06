package IC_AdminSide;

import org.openqa.selenium.By;

public class ApplicationDetail {
    //navabr links will show up here
    //Fields that are disabled by defualt
    By application_id= By.xpath("//input[@id='applicant_id']");
    By type_of_application=By.xpath("//input[@id='application_type']");
    By ques1=By.xpath("//input[@id='application_ques1']");
    By ques2=By.xpath("//input[@id='application_ques2']");
    By ques3=By.xpath("//input[@id='application_ques3']");
    By dob=By.xpath("//input[@id='application_dob']");
    By doc_file_name=By.xpath("//input[@id='application_file_name']");
    //These Fields are enabled and they are dropdowns
    By application_status=By.xpath("//select[@id='applicant_status']");
    By medical_status=By.xpath("//select[@id='medical_status']");
    By background_status=By.xpath("//select[@id='background_status']");

    By update_button=By.xpath("//button[contains(text(),'Update')]");
    By return_button=By.xpath("//button[contains(text(),'Return')]");

}
