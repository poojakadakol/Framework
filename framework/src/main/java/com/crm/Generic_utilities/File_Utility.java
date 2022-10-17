package com.crm.Generic_utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class File_Utility {
	public  String getPropertyKeyValue(String Key) throws Throwable { 
		//FileInputStream fis=new FileInputStream("./common.data.properties.txt");
		FileInputStream fis=new FileInputStream(Ipathconstant.PROPERTYFILE_PATH);
		Properties pro=new Properties();
		pro.load(fis);
		String value=pro.getProperty(Key);
		return value;
	}
	
}
