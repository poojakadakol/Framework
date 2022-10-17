package com.crm.product;

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

import com.crm.Generic_utilities.Excel_Utility;
import com.crm.Generic_utilities.File_Utility;
import com.crm.Generic_utilities.Java_Utiltity;
import com.crm.Generic_utilities.WebDriverUtlity;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.Products;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Createproducttest 
{

	public static void main(String[] args) throws Throwable {
	/*	System.setProperty("webdriver.gecko.driver","./softwares/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(13,TimeUnit.SECONDS);*/
		File_Utility flib=new File_Utility(); 
		String BROWSER=flib.getPropertyKeyValue("Browser");
		
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
		}
	
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
		HomePage hp=new HomePage(driver);
		hp.ProductsLnk();
		
		//  driver.findElement(By.xpath("//a[.='Products']")).click();
		 Products pdt=new  Products(driver);
		 pdt.creatProduct();
	  //  driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
	    
	    Java_Utiltity jlib=new Java_Utiltity();
		 int ranNum = jlib.getRanDomNum();
	    
		 
		Excel_Utility elib=new Excel_Utility();
		String data1=elib.getDataFromExcel("Organization",0,0)+ranNum;
		pdt.productName(data1);
		
      // driver.findElement(By.name("productname")).sendKeys(data1);
		pdt.getProductSaveButton().click();
		
      //  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
      String text=driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		if(text.contains(data1))
	    {
			System.out.println("pass");
		}
			else
			{
				System.out.println("fail");
			}
		//	Actions a1=new Actions(driver);
	    //    a1.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		//   driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		   pdt.getAdminLink().click();
		   pdt.getSignOutLnk().click();
	    
        } 
	
        
}
	
	