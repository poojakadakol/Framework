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
import org.openqa.selenium.Alert;
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

public class Deleteproduct {

	public Deleteproduct(WebDriver driver1) {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws Throwable {
	/*	System.setProperty("webdriver.gecko.driver","./softwares/geckodriver.exe");
	     WebDriver driver=new FirefoxDriver();
	     driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) */
	     
	     File_Utility flib=new File_Utility(); 
			String BROWSER=flib.getPropertyKeyValue("Browser");
			
			WebDriver driver1;
			if(BROWSER.equalsIgnoreCase("chrome"))
				{
				WebDriverManager.chromedriver().setup();
				driver1=new ChromeDriver();
				}
			
			if(BROWSER.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver1=new FirefoxDriver();
			}
			else if(BROWSER.equalsIgnoreCase("edge"))
			{
				WebDriverManager.edgedriver().setup();
				driver1=new EdgeDriver();
			}
			else
			{
				driver1 = new FirefoxDriver();
			}
		
		WebDriverUtlity wlib=new WebDriverUtlity();
		wlib.waitForPageToLoad(driver1);
	     
	     
			String URL=flib.getPropertyKeyValue("url");
			String UserName=flib.getPropertyKeyValue("un");
			String PassWord=flib.getPropertyKeyValue("pw");
			
			driver1.get(URL);
			LoginPage login=new LoginPage(driver1);
			login.login(UserName, PassWord);
	     
	   //     driver1.get(URL);
		//	driver1.findElement(By.name("user_name")).sendKeys(UserName);
		//	driver1.findElement(By.name("user_password")).sendKeys(PassWord);
		//	driver1.findElement(By.id("submitButton")).click();
			
			HomePage hp=new HomePage(driver1);
			hp.ProductsLnk();
	     
		//	 driver1.findElement(By.xpath("//a[.='Products']")).click();
			
		//	 driver1.findElement(By.xpath("//img[@alt='Create Product...']")).click();
			 Products pdt=new  Products(driver1);
			 pdt.creatProduct();
			 
			 Java_Utiltity jlib=new Java_Utiltity();
			 int ranNum = jlib.getRanDomNum();
			 
			 Excel_Utility elib=new Excel_Utility();
			String data1=elib.getDataFromExcel("Organization",0,0)+ranNum;
			    
			pdt.productName(data1);	
	   //  driver1.findElement(By.name("productname")).sendKeys(data1);
			pdt.getProductSaveButton().click();
	   //  driver1.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	     driver1.findElement(By.xpath("//input[@name='Delete']")).click();
	     Alert A=driver1.switchTo().alert();
	     A.accept();
	 //    Actions a=new Actions(driver1);
	  //   a.moveToElement(driver1.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
			
	//	driver1.findElement(By.xpath("//a[.='Sign Out']")).click();
		 pdt.getAdminLink().click();
		   pdt.getSignOutLnk().click();
		
	   }

}
