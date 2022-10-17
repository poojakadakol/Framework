package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.crm.Generic_utilities.File_Utility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	
	public WebDriver driver;
	@BeforeSuite (groups= {"smoke testing","regression testing"})
	public void BS()
	{
		System.out.println("DataBase Connection");
	}
	@BeforeTest (groups= {"smoke testing","regression testing"})
	public void BT() 
	{
		System.out.println("Execute in Parallel mode");
	}
	@Parameters("BROWSER")
    @BeforeClass (groups= {"smoke testing","regression testing"})
	public void BC() throws Throwable 
	{
		File_Utility flib=new File_Utility(); 
		String BROWSER=flib.getPropertyKeyValue("Browser");
		
		
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
		}
	
		System.out.println("Launching the Browser");
	}
	@BeforeMethod (groups= {"smoke testing","regression testing"})
	public void BM() throws Throwable 
	{
		File_Utility flib=new File_Utility();
		String URL=flib.getPropertyKeyValue("url");
		String UserName=flib.getPropertyKeyValue("un");
		String PassWord=flib.getPropertyKeyValue("pw"); 
			
		driver.get(URL);
		LoginPage login=new LoginPage(driver);
		login.login(UserName, PassWord);
		System.out.println("Login to Application");
	}
	@AfterMethod (groups= {"smoke testing","regression testing"})
	public void AM() 
	{
		System.out.println("Logout to Application");
	}
	@AfterTest (groups= {"smoke testing","regression testing"})
	public void AT() 
	{
		System.out.println("Close the Browser");
	}
	@AfterClass (groups= {"smoke testing","regression testing"})
	public void AC() 
	{
		System.out.println("Executedsuccessfully");
	}
	@AfterSuite (groups= {"smoke testing","regression testing"})
	public void AS() 
	{
		System.out.println("DataBase Close");
	}
	
	}
