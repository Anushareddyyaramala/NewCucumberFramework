package genericUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public static XSSFWorkbook wb;

	public static XSSFSheet sh;

	public static  XSSFRow row;

	public static XSSFCell cell;

	public static void excelconfig()  {
try {
	     File src=new File(".\\src\\test\\resources\\IRCTC-data.xlsx");

	     FileInputStream fis=new FileInputStream(src);  // to read the data in excel file

	     wb=new XSSFWorkbook(fis);

	     sh=wb.getSheet("Details");
}catch(Exception e) {
	e.printStackTrace();
}
	} 

	public static String getdata(int rownm,int colsnum)  {

	     excelconfig();

	     try {

	     cell=sh.getRow(rownm).getCell(colsnum); // in build

	     String celldata=cell.getStringCellValue();

	    return celldata;

	}catch(Exception e) {

	     System.out.println("exception in thread");

	     return null;

	}

	}

	public static void setdata(String name,int rownm, int colsnum) throws Exception {

	     excelconfig();


	     File src=new File("./src/main/resources/excel file.xlsx");

	     cell=null; 

	     cell=sh.getRow(rownm).getCell(colsnum);

	     XSSFRow row=sh.getRow(rownm);

	     row.createCell(colsnum).setCellValue(name);

	     FileOutputStream fos=new FileOutputStream(src); // to write the data

	     wb.write(fos);

	     fos.close();



	}


}
