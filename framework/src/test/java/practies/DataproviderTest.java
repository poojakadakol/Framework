package practies;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class DataproviderTest {
	@Test(dataProvider="dataProvider_test")

	public  void CompanyDetails(String name,String phnum,String email) {
		System.setProperty("webdriver.gecko.driver","./softwares/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(13,TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");
		}

}
