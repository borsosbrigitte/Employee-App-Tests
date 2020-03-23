package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewUserPage {
	public WebDriver driver;
	
	
	public NewUserPage(WebDriver driver){
		this.driver = driver;
	}
	
	//UI Mapper
	
	By firstNameField = By.xpath("//input[@name='firstName']");
	By lastNameField = By.xpath("//input[@name='lastName']");
	By userEmailField = By.xpath("//input[@name='email']");
	By companyField = By.xpath("//input[@name='company']");
	By phoneField = By.xpath("//input[@name='phone']");
	By birthdayField = By.xpath("//input[@name='birthday']");
	By checkBox = By.xpath("//label[@class='mat-checkbox-layout']");
	By submitBtn = By.xpath("//button/span[contains(text(),'Submit')]");

	//Actions
	
	public void enterFirstName(String firstname){
		driver.findElement(firstNameField).sendKeys(firstname);
	}
	
	public void enterLastName(String lastname){
		driver.findElement(lastNameField).sendKeys(lastname);
	}
	
	public void enterEmail(String useremail){
		driver.findElement(userEmailField).sendKeys(useremail);
	}
	
	public void enterCompany(String company) {
		driver.findElement(companyField).sendKeys(company);
	}
	
	public void enterPhone(String phone) {
		driver.findElement(phoneField).sendKeys(phone);
	}
	
	public void enterBirthDay(String birthday) {
		driver.findElement(birthdayField).sendKeys(birthday);
	}
	
	public void clickOnCheckbox() {
		driver.findElement(checkBox).click();
	}
	
	public void clickOnSubmit() {
		driver.findElement(submitBtn).click();
	}
}
