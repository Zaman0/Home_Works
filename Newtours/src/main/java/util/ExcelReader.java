package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public static String filepath;
	public FileInputStream fis=null;
	private XSSFWorkbook workbook=null;
	private XSSFSheet sheet=null;
	private XSSFRow row=null;
	private XSSFCell cell=null;
	
	public static String[] userdata=new String[2];
	
	public String[] readexceldata(String filepath) throws FileNotFoundException, IOException {
		 workbook=new XSSFWorkbook(new FileInputStream(filepath));
		 sheet=workbook.getSheet("Sheet1");
		 XSSFRow row=sheet.getRow(0);
		 for (int i = 0; i < userdata.length; i++) {
				switch (row.getCell(i).getCellType()) {
				case STRING:
					userdata[i]=row.getCell(i).getStringCellValue();
				default:
					break;
				}
			}
			return userdata;
	}
	
	
}
