package practies;

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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Makemytrip {

	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.gecko.driver","./softwares/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(13,TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		
		String srcCity="Bangkok, Thailand";
		WebElement src=driver.findElement(By.xpath("//input[@id='fromCity']"));
		src.sendKeys("'"+srcCity+"'");
		driver.findElement(By.xpath("//p[text()='"+srcCity+"']")).click();
		
		String desCity="Mumbai, India";
	    WebElement des = driver.findElement(By.xpath("//input[@id='toCity']"));
	    des.sendKeys("'"+desCity+"'");
	    driver.findElement(By.xpath("//p[text()='"+desCity+"']")).click();
	    
	    driver.findElement(By.xpath("//span[@class='lbl_input latoBold appendBottom10']")).click();
	    Thread.sleep(1000);
	    String month = "September 2022";
	    String date = "30";
	    driver.findElement(By.xpath("//div[text()='"+month+"']"
	    		+"/ancestor::div[@class='DayPicker-Months']/descendant::p[text()='"+date+"']")).click();
	    system.out.println("bye");
	    
	    }

}
