package pimtestcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	public static void chromBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://sandbox.pimworks.io/PIMWorks_QA/Login");
		driver.manage().window().maximize();
	}

	public static void textBox(WebElement element, String name) {
		element.sendKeys(name);
	}

	public static void btnClick(WebElement element) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		element.click();
	}

	public static void productSelect() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebElement productSelect = driver.findElement(By.xpath("(//div[@class='pd_content'])[1]"));
		productSelect.click();
	}

	public static String readExcel(int rowNum, int cellNum) throws IOException {

		File f = new File(
				"C:\\Users\\MOB220005273\\eclipse-workspace\\PimAutomationTest\\ExcelTestFiles\\ExcelTestSheet.xlsx");
		FileInputStream fin = new FileInputStream(f);
		Workbook book = new XSSFWorkbook(fin);
		Sheet sh = book.getSheet("Login");
		Row r = sh.getRow(rowNum);
		Cell c = r.getCell(cellNum);
		String value = "";
		CellType type = c.getCellType();
		int t = type.getCode();
		if (t == 1) {
			value = c.getStringCellValue();
		} else if (DateUtil.isCellDateFormatted(c)) {
			Date date = c.getDateCellValue();
			SimpleDateFormat df = new SimpleDateFormat("DD-MM-YYYY");
			value = df.format(date);
		}else
		{
			double i = c.getNumericCellValue();
			long l = (long)i;
			value = String.valueOf(l);
		}
		return value;
	}

}
