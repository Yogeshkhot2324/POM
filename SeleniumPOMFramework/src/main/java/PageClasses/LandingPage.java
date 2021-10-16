package PageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseClasses.PageBaseClass;
import baseClasses.TopMenuClass;

public class LandingPage extends PageBaseClass {

	public LandingPage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}

	@FindBy(xpath = "//*[contains(@class,'moneyicon')]")
	public WebElement moneyLink;
	
	@FindBy(xpath = "//a[contains(text(),'Rediffmail')]")
	public WebElement Rediffmail;
	
	public RediffMailLoginPage clickRediffMailLink() {
		logger.log(Status.INFO, "Clicking the Rediff mail Link, Present in Header");
		Rediffmail.click();
		logger.log(Status.PASS, "Clicked the Rediff mail Link");
		RediffMailLoginPage mailpage = new RediffMailLoginPage(driver, logger);
		PageFactory.initElements(driver, mailpage);
		return mailpage;
	}


	public MoneyPage clickMoneyLink() {
		logger.log(Status.INFO, "Clicking the Money Link, Present in Header");
		moneyLink.click();
		logger.log(Status.PASS, "Clicked the Money Link");
		MoneyPage moneyPage = new MoneyPage(driver, logger);
		PageFactory.initElements(driver, moneyPage);
		return moneyPage;
	}

	public PortFolioLoginPage clickSingIn() {
		// Perform the Click
		PortFolioLoginPage portFolioLoginPage = new PortFolioLoginPage(driver, logger);
		PageFactory.initElements(driver, portFolioLoginPage);
		return portFolioLoginPage;
	}
}
