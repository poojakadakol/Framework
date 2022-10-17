package com.crm.Generic_utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {
	/**
	 * this method is used to fetch data from Excel
	 * @param SheetName
	 * @param RowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable 
	 * @throwsThrowable
	 */

	public String getDataFromExcel(String sheetName,int RowNum,int cellNum) throws Throwable
	{
		FileInputStream fis1=new FileInputStream("./Book5.Xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(RowNum);
		Cell cell = row.getCell(cellNum);
		String data1=cell.getStringCellValue();
		return data1;
	}

}
