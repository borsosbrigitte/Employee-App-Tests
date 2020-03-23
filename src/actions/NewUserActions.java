package actions;

import org.openqa.selenium.WebDriver;
import pages.NewUserPage;

public class NewUserActions {
	public WebDriver driver;
	
	public NewUserActions(WebDriver driver) {
		this.driver = driver;
	}
	
	public void addNewUser(String firstname, String lastname, String useremail, String company, String phone, String birthday) {
		NewUserPage newUserPage= new NewUserPage(driver);
		newUserPage.enterFirstName(firstname);
		newUserPage.enterLastName(lastname);
		newUserPage.enterCompany(company);
		newUserPage.enterEmail(useremail);
		newUserPage.enterPhone(phone);
		newUserPage.enterBirthDay(birthday);
		newUserPage.clickOnCheckbox();
		newUserPage.clickOnSubmit();
	}
	
	

}
