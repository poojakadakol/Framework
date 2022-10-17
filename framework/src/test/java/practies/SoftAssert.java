package practies;

import org.testng.annotations.Test;

public class SoftAssert {
	@Test
	public void createCustomerTest(){
		System.out.println("Step1");
		System.out.println("Step2");
		org.testng.asserts.SoftAssert soft = new org.testng.asserts.SoftAssert();
		soft.assertEquals("A", "B");
		System.out.println("Step3");
		System.out.println("Step4");
		soft.assertAll();
		}
	
public void modifyCustomerTest()
{
	System.out.println("=====");
	System.out.println("Step1");
	System.out.println("Step2");
	System.out.println("Step3");
	
}

}
