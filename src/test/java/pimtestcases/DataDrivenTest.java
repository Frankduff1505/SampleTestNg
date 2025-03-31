package pimtestcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenTest {

	public static void main(String[] args) throws IOException {
		
		File f = new File("C:\\Users\\MOB220005273\\eclipse-workspace\\PimAutomationTest\\ExcelTestFiles\\ExcelTestSheet.xlsx");
		FileInputStream fin = new FileInputStream(f);
		
		Workbook book = new XSSFWorkbook(fin);
		Sheet sh = book.getSheet("Login");
		Row r = sh.getRow(1);
		Cell c = r.getCell(1);
		System.out.println(c);
		CellType type = c.getCellType();
		type.getCode();
		System.out.println(type.getCode());
		String s = type.toString();
		System.out.println(s);
		String s1 = "STRING";
		System.out.println(s1.equals(s));
		System.out.println("Number Of Rows : "+sh.getPhysicalNumberOfRows());
		System.out.println("Number Of Cells : "+r.getPhysicalNumberOfCells());
	
		
	}

}
