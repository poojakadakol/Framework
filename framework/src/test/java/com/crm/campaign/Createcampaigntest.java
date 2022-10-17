package com.crm.campaign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.Generic_utilities.Excel_Utility;
import com.crm.Generic_utilities.File_Utility;
import com.crm.Generic_utilities.Java_Utiltity;
import com.crm.Generic_utilities.WebDriverUtlity;
import com.crm.ObjectRepository.Baseclass;
import com.crm.ObjectRepository.Campaign;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Createcampaigntest extends Baseclass {
    @Test (groups= {"regression testing"})
    public void createcampaign() throws Throwable {
		System.setProperty("webdriver.gecko.driver","./softwares/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(13,TimeUnit.SECONDS); 
		File_Utility flib=new File_Utility(); 
	/*	String BROWSER=flib.getPropertyKeyValue("Browser");
		
		WebDriver driver;
		if(BROWSER.equalsIgnoreCase("chrome"))
			{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			}
		
		if(BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else
		{
			driver = new FirefoxDriver();
		} */
	
	WebDriverUtlity wlib=new WebDriverUtlity();
	wlib.waitForPageToLoad(driver);
		
		
		String URL=flib.getPropertyKeyValue("url");
		String UserName=flib.getPropertyKeyValue("un");
		String PassWord=flib.getPropertyKeyValue("pw");
		
		driver.get(URL);
		LoginPage login=new LoginPage(driver);
		login.login(UserName, PassWord);
		
	/*	driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(UserName);
		driver.findElement(By.name("user_password")).sendKeys(PassWord);
		driver.findElement(By.id("submitButton")).click(); */
		
		driver.findElement(By.xpath("//img[@style='padding-left:5px']")).click();
	//	driver.findElement(By.name("Campaigns")).click();
		HomePage hp=new HomePage(driver);
		hp.CampaignsLnk(); 
		Campaign cp=new Campaign(driver);
		cp.createcampaign();
	//	driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		
		Java_Utiltity jlib=new Java_Utiltity();
		 int ranNum = jlib.getRanDomNum();
		
		Excel_Utility elib=new Excel_Utility();
		String data1=elib.getDataFromExcel("Organization",0,0)+ranNum;
		
		cp.campaigntextfield(data1);
		cp.savebutton();
		
	//	driver.findElement(By.name("campaignname")).sendKeys(data1);
	//	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String act_msg=driver.findElement(By.cssSelector("span.dvHeaderText")).getText();
		if(act_msg.contains(data1))
		{
			System.out.println("passed");
		}
		else
		{
			System.out.println("failed");
		}
		//	Actions a=new Actions(driver);
		//	a.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		//	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		cp.adminLink();
		cp.getSignOutLnk().click();
			
		}
		

}


