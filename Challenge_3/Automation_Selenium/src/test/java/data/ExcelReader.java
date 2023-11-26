package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

static FileInputStream FIS = null;


public FileInputStream getFileData()
{
	String filepath = System.getProperty("user.dir")+"\\src\\test\\java\\data\\UserData_1.xlsx";
	File scrFile = new File(filepath);
	try {
		FIS = new FileInputStream(scrFile);
	} catch (FileNotFoundException e) {
		System.out.println("File not found!!");
	}
	return FIS;
}

public Object[][] getExcelData() throws IOException
{
	FIS = getFileData();
	XSSFWorkbook wb = new XSSFWorkbook(FIS);
	XSSFSheet sh = wb.getSheetAt(0);
	int NumberOfRows = 7;
	int NumberOfCols = 2;
	
	String[][] UserData = new String[NumberOfRows][NumberOfCols];
	for(int i=0; i < NumberOfRows; i++)
	{
		for(int j=0; j < NumberOfCols; j++)
		{
			XSSFRow row = sh.getRow(i);
			UserData[i][j] = row.getCell(j).toString();
		}
	}
	wb.close();
	return UserData;
	
}
	
}
