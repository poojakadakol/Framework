package com.crm.organisation;

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
import org.openqa.selenium.WebElement;
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
import com.crm.ObjectRepository.CreateNewOrganization;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationInfo;
import com.crm.ObjectRepository.Organizations;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Createorganisationtest extends Baseclass {
	@Test (groups= {"smoke"})
	public void createorganisation() throws Throwable {
		
		System.setProperty("webdriver.gecko.driver","./softwares/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(13,TimeUnit.SECONDS);
		File_Utility flib=new File_Utility(); 
     /*   String BROWSER=flib.getPropertyKeyValue("Browser");
		
		
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
		}  */
	
		
	
	WebDriverUtlity wlib=new WebDriverUtlity();
	wlib.waitForPageToLoad(driver);
		
	String URL=flib.getPropertyKeyValue("url");
	String UserName=flib.getPropertyKeyValue("un");
	String PassWord=flib.getPropertyKeyValue("pw"); 
		
	driver.get(URL);
	LoginPage login=new LoginPage(driver);
	login.login(UserName, PassWord); 
		
	//	driver.findElement(By.name("user_name")).sendKeys(UserName);
	//	driver.findElement(By.name("user_password")).sendKeys(PassWord);
	//	driver.findElement(By.id("submitButton")).click();ss
		
	/*step 3 : naviagte to org*/
	HomePage hp=new HomePage (driver);
	hp.getOrganizationsLnk().click();
		
	//Organizations og=new Organizations(driver);
	//og.getCreateOrgImg().click();
		
	//driver.findElement(By.xpath("(//a[text()='Organizations'])")).click();
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
	Java_Utiltity jlib=new Java_Utiltity();
	int ranNum = jlib.getRanDomNum();
		
	Excel_Utility elib=new Excel_Utility();
	String data1=elib.getDataFromExcel("Organization",0,0)+ranNum;
		 
	CreateNewOrganization cno= new CreateNewOrganization(driver);
	cno.createOrg(data1);
	cno.getsaveBtn().click();
	//driver.findElement(By.name("accountname")).sendKeys(data1);
	//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
	String text=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if(text.contains(data1))
		{
			System.out.println("testcase pass");
		}
		else
		{
			System.out.println("testcase failed");
		}
	  /*Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();*/
	hp.getAdminLink().click();
	hp.getSignOutLnk().click();
	
		}
		}

