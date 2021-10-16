package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseClasses.PageBaseClass;
import baseClasses.TopMenuClass;

public class RediffMailLoginPage extends PageBaseClass{
	public TopMenuClass topmenu;

	public RediffMailLoginPage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
		topmenu = new TopMenuClass(driver, logger);
		PageFactory.initElements(driver, topmenu);
	}
	
	
	@FindBy(xpath = "//input[@id='login1']")
	public WebElement userName;
	
	@FindBy(xpath = "//input[@id='password']")
	public WebElement password;
	
	@FindBy(xpath = "//input[@class='signinbtn']")
	public WebElement SignInButton;
	
public RediffMailPage doLogin(String uName, String pass) {
		
		userName.sendKeys(uName);
		logger.log(Status.PASS, "Entered the UserName : " + userName);
		//Commented below link, since its not required now
		//emailSubmit_button.click();
		//waitForPageLoad();
		logger.log(Status.PASS, "Clicked the UserName Submit Buttton");
		password.sendKeys(pass);
		logger.log(Status.PASS, "Entered the Password : " + password);
		System.out.println("Entered password");
		SignInButton.click();
		//waitForPageLoad();
		logger.log(Status.PASS, "Cliecked the Submit Login Button");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String currentPageTitle = driver.getTitle();
		
		RediffMailPage myrediffmailPage = new RediffMailPage(driver, logger);
		PageFactory.initElements(driver, myrediffmailPage);
		return myrediffmailPage;
	}
	
	

}
