package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getDataFromExcel(String sheetName,int rowNum,int celNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis1=new FileInputStream("./testdata/tsetscriptdata.xlsx");
		Workbook wb=WorkbookFactory.create(fis1);
		Sheet sh=wb.getSheet(sheetName);
		Row rw=sh.getRow(rowNum);
		String data=rw.getCell(celNum).getStringCellValue();
		return data;
	}
	public int getRowcount(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis1=new FileInputStream("./testdata/tsetscriptdata.xlsx");
		Workbook wb=WorkbookFactory.create(fis1);
		int rowcount=wb.getSheet(sheetName).getLastRowNum();
		return rowcount;
}
	public void setDataIntoExcel(String sheetName,int rowNum,int celNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis1=new FileInputStream("./testdata/tsetscriptdata.xlsx");
		Workbook wb=WorkbookFactory.create(fis1);
		wb.getSheet(sheetName).getRow(rowNum).createCell(celNum);
		FileOutputStream fos=new FileOutputStream("./testdata/tsetscriptdata.xlsx");
		wb.write(fos);
	
	wb.close();
	}
}