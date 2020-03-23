package pages;

import org.openqa.selenium.WebDriver;


import actions.LoginActions;
import actions.UserDashboardActions;
import actions.NewUserActions;
import pagedriver.BrowserInstance;
public class BasePage {
	protected static WebDriver driver = BrowserInstance.readBrowser();
	
	protected LoginPage loginPage = new LoginPage(driver);
	protected LoginActions loginFlow = new LoginActions(driver);

	protected UserDashboard userDashboard = new UserDashboard(driver);
	protected UserDashboardActions userDashboardFlow = new UserDashboardActions(driver);
	
	protected NewUserPage newUserPage = new NewUserPage(driver);
	protected NewUserActions newUserFlow = new NewUserActions(driver);

}
