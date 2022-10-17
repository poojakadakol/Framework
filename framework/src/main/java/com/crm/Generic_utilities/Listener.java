package com.crm.Generic_utilities;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener{

	public void onTestFailure(ITestResult result) {
		String data=result.getMethod().getMethodName();
		
		
	}
	

}
