package PageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseClasses.PageBaseClass;

public class RediffMailPage extends PageBaseClass{
	
	
	public RediffMailPage(WebDriver driver, ExtentTest logger){
		super(driver, logger);
	}
	
	//WebElements of RediffMail Page
	//Operation of Rediffmail Page
	
	
	
	public void verifyRediffMail()
	{
		String currentPageTitle = driver.getTitle();
		if (currentPageTitle.equals("Rediffmail")){
			System.out.println("correct page");
		}
		
	}
	
	@FindBy(xpath = "//b[contains(text(),'Write mail')]")
	public WebElement writeMail;
	
	public void clickWriteEmail(){
		writeMail.click();
		waitForPageLoad();
		logger.log(Status.PASS, "Cliecked the Write Mail");
	}
	
	
	@FindBy(xpath = "//input[@id='TO_IDcmp2']")
	public WebElement entermailaddress;
	
	
	@FindBy(xpath = "//input[@class='rd_inp_sub rd_subject_datacmp2']")
	public WebElement subject;
	
	@FindBy(xpath = "//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")
	public WebElement body;
	
	
	@FindBy(xpath = "//body/div[4]/div[2]/div[2]/div[2]/div[2]/ul[2]/li[2]/div[1]/div[1]/div[1]/a[1]")
	public WebElement sendbutton;
	
	
	@FindBy(xpath = "//a[@class='rd_active']")
	public WebElement inbox;
	
	
	
	@FindBy(xpath = "//body/div[4]/div[2]/div[2]/div[2]/div[2]/ul[2]/li[2]/div[1]/div[1]/ul[1]/li[6]/div[1]/div[1]/div[1]/iframe[1]")
	public WebElement iframe;
	
	
	public void typeMail(String mail,String subjectLine,String content) throws InterruptedException{
		
		entermailaddress.sendKeys(mail);
		Thread.sleep(1000);
		subject.sendKeys(subjectLine);
		Thread.sleep(1000);
		driver.switchTo().frame(driver.findElement(By.xpath("//body/div[4]/div[2]/div[2]/div[2]/div[2]/ul[2]/li[2]/div[1]/div[1]/ul[1]/li[6]/div[1]/div[1]/div[1]/iframe[1]")));
		body.sendKeys(content);
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		sendbutton.click();
		waitForPageLoad();
		inbox.click();
	
		
	}
	
	@FindBy(xpath = "//body/div[4]/div[2]/div[2]/div[2]/div[2]/ul[2]/li[1]/div[1]/div[1]/ul[1]/li[1]/span[1]")
	public WebElement mailcheck;
	
public void IsmailReceived(){
	String mailbox = mailcheck.getText();
	
	if (mailbox.equals("yogesh anna khot")){
		System.out.println("Mail receiveed sucessfully.");
	}
	
	}
}
