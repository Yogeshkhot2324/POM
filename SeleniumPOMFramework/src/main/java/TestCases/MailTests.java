package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import PageClasses.LandingPage;
import PageClasses.MoneyPage;
import PageClasses.MyPorfolioPage;
import PageClasses.PortFolioLoginPage;
import PageClasses.RediffMailLoginPage;
import PageClasses.RediffMailPage;
import baseClasses.BaseTestClass;
import baseClasses.PageBaseClass;
import utilities.ConstantValue;

public class MailTests extends BaseTestClass {
	LandingPage landingPage;
	MoneyPage moneyPage;
	PortFolioLoginPage portfolioLoginPage;
	MyPorfolioPage myporfolioPage;
	RediffMailPage myrediffmailPage;
	RediffMailLoginPage mailPage;
@Test
public void MailTest() throws InterruptedException{
	
	logger = report.createTest("Rediff Msil Test");
	invokeBrowser("chrome");
	PageBaseClass pageBase = new PageBaseClass(driver, logger);
	PageFactory.initElements(driver, pageBase);
	landingPage = pageBase.OpenApplication();
	mailPage =landingPage.clickRediffMailLink();
	//waitForPageLoad();
	myrediffmailPage = mailPage.doLogin(ConstantValue.uName, ConstantValue.pass);
	myrediffmailPage.verifyRediffMail();
	myrediffmailPage.clickWriteEmail();
	//waitForPageLoad();
	Thread.sleep(1000);
	myrediffmailPage.typeMail("yogeshkhot2324@rediff.com", "POM testing", "hi Yogesh");
	Thread.sleep(2000);
	myrediffmailPage.IsmailReceived();
	Thread.sleep(1000);
	System.out.println("end of code");
	
	
	
	
}

}
