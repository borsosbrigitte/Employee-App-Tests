package tests;

import static org.junit.Assert.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import actions.LoginActions;
import actions.NewUserActions;
import actions.UserDashboardActions;
import pagedriver.BrowserInstance;
import pagedriver.Page;
import pages.BasePage;
import pages.LoginPage;
import pages.UserDashboard;
import pages.NewUserPage;
import utils.ConfigFileReader;
import utils.Constants;
import utils.Messages;
import utils.Util;

public class Tests extends BasePage {
	 
	@BeforeClass
	public static void Start(){
		
	}
	
	@Test @Ignore
	//Logging in 
	public void Login() throws InterruptedException{
		Page.navigateTo(ConfigFileReader.getAppURL());
		assertEquals(Messages.APPLICATION_TITLE, Page.getTitle());
		
		loginFlow.login("test_brigitte@test.com", "123abc");

		assertEquals("Welcome: test_brigitte@test.com", userDashboard.getWelcomeMessageLabel());
	}
	
	//Negative scenarios
	@Test @Ignore
	//negative scenario, email does not contain @
	
	public void LoginFailedWhenEmailDoesNotHaveAround() {
		Page.navigateTo(ConfigFileReader.getAppURL());
		assertEquals(Messages.APPLICATION_TITLE, Page.getTitle());

		loginFlow.login("test_brigittetest.com", "123abc");
		String actualErrorMessage = loginPage.getErrorMessage();
		assertTrue(actualErrorMessage.contains(Messages.LOGIN_ERROR_EMAIL_DOESNOTHAVE_AROUND));




	}
	
	//2. Negative scenario, trying to log in with an invalid password
	@Test @Ignore
		public void LoginWithInvalidPassword() throws InterruptedException{
			Page.navigateTo(ConfigFileReader.getAppURL());
			assertEquals(Messages.APPLICATION_TITLE, Page.getTitle());
			
			loginFlow.login("test_brigitte@test.com", "aaaa");

			String actualErrorMessage = loginPage.getErrorMessage();
		    assertTrue(actualErrorMessage.contains(Messages.LOGIN_ERROR_INVALID_PASSWORD));
		}
	
	@Test @Ignore
	//Logging in&adding a new user
	public void LoginandAddNewUser() throws InterruptedException {
		
		//log in with existing credentials

		Page.navigateTo(ConfigFileReader.getAppURL());
		assertEquals(Messages.APPLICATION_TITLE, Page.getTitle());
		
		loginFlow.login("test_brigitte@test.com", "123abc");
		
		//go to userDashboard
		userDashboard.getWelcomeMessageLabel();
		
		String currentWelcomeText = driver.findElement(By.xpath("//div[@class='welcome']")).getText();
		assertEquals("Welcome: test_brigitte@test.com", currentWelcomeText);
		userDashboard.clickNewUserButton();

		//go to NewUserPage, where we add a New User
		
		newUserFlow.addNewUser("Adam", "Brown", "adambrown@test.com", "IBM", "0711111111", "11/11/1980");
		
		
		//check if the value has been inserted
		
	
		
		

		

	}
	@Test 
	public void LoginandAddNewUserWithAnUniqueName() throws InterruptedException {

		//log in with existing credentials

		Page.navigateTo(ConfigFileReader.getAppURL());
		assertEquals(Messages.APPLICATION_TITLE, Page.getTitle());
		
		loginFlow.login("test_brigitte@test.com", "123abc");
		
		//go to userDashboard
				userDashboard.getWelcomeMessageLabel();
				
				String currentWelcomeText = driver.findElement(By.xpath("//div[@class='welcome']")).getText();
				assertEquals("Welcome: test_brigitte@test.com", currentWelcomeText);
				userDashboard.clickNewUserButton();

				//go to NewUserPage, where we add a New User
				
				String randomize = Integer.toString(Util.generateRandomInt(2000));

				newUserFlow.addNewUser("Adam"+randomize, "Brown"+randomize, "adambrown"+randomize+"@test.com", "IBM", "0711111111", "11/11/1980");
				
				String currentFirstName = userDashboard.getLastFirstName();
				String currentLastName = userDashboard.getLastLastName();
				String currentLastUserEmail= userDashboard.getLastEmail();
				assertEquals("Adam"+randomize, currentFirstName);
				assertEquals("Brown"+randomize, currentLastName);
				assertEquals("adambrown"+randomize+"@test.com", currentLastUserEmail);

	
	}
	
	
	
	
	@AfterClass
	public static void CloseTest(){
		Page.close();
	}

}
