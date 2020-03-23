package actions;

import org.openqa.selenium.WebDriver;

import pages.UserDashboard;

public class UserDashboardActions {
	public  WebDriver driver;

	public UserDashboardActions(WebDriver driver){
		this.driver = driver;
	}
	
	public void userDashboardActions() {
		UserDashboard userDashboard = new UserDashboard(driver);
		
	}
	
	}
