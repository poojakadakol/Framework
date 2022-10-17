package practies;

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

import io.github.bonigarcia.wdm.WebDriverManager;

public class Vtiger {

	public static void main(String[] args) throws Throwable {
		
		File_Utility  flib=new File_Utility  ();
		String BROWSER=flib.getPropertyKeyValue("Browser");
		WebDriver driver;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver =new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
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
			driver=new FirefoxDriver();
		}
		/*System.setProperty("webdriver.gecko.driver","./softwares/geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);*/
		 WebDriverUtlity wlib=new WebDriverUtlity ();
		wlib.waitForPageToLoad(driver);

		
		String URL=flib.getPropertyKeyValue("url");
		String UserName=flib.getPropertyKeyValue("un");
		String PassWord=flib.getPropertyKeyValue("pw");

		driver.get(URL);
	//	Logingpage login=new Logingpage(driver);
	//	login.login(UserName,PassWord);
		
		driver.findElement(By.name("user_name")).sendKeys(UserName);
		driver.findElement(By.name("user_password")).sendKeys(PassWord);
		
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[.='Organizations']")).click();

		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		Java_Utiltity jlib=new Java_Utiltity();
		int ranNum=jlib.getRanDomNum();

		Excel_Utility elib=new Excel_Utility ();
		String data=elib.getDataFromExcel("organisation", 0, 0) +ranNum;


		driver.findElement(By.name("accountname")).sendKeys(data);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String text=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(text.contains(data)) 
		{
			System.out.println("testcase pass");
		}
		else
		{
			System.out.println("failed");
		}
		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		driver.close();




	

		
	}	
}
	


