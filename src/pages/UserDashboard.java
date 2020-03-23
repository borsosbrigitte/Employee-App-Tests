package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserDashboard {
	public  WebDriver driver;
	
	public UserDashboard(WebDriver driver){
		this.driver = driver;
	}
	
	//UI Mapper
	
	By userWelcomeMessageLabel = By.xpath("//div[@class='welcome']");
	By lastFirstName = By.xpath("//table/tbody/tr[last()]/td[1]");
	By lastLastName = By.xpath("//table/tbody/tr[last()]/td[2]");
	By lastEmail = By.xpath("//table/tbody/tr[last()]/td[3]");

	By newUserButton = By.xpath("//button/span[contains(text(),'New user')]");
	
	//Actions
	public String getWelcomeMessageLabel(){
		return driver.findElement(userWelcomeMessageLabel).getText();
	}
	
	public String getLastFirstName() {
		return driver.findElement(lastFirstName).getText();
	}
		
	
	public String getLastLastName() {
		return driver.findElement(lastLastName).getText();
	}
	
	public String getLastEmail() {
		return driver.findElement(lastEmail).getText();
	}
	public void clickNewUserButton() {
		 driver.findElement(newUserButton).click();
	}
}
