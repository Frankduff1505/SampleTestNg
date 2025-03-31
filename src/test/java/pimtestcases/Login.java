package pimtestcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login extends BaseClass {

	public static void main(String[] args) throws IOException {

		chromBrowser();
		LoginPage lp = new LoginPage();
		//WebElement userName = driver.findElement(By.id("loginEmail"));
		textBox(lp.getUserName(), readExcel(1,1));
		//WebElement passWord = driver.findElement(By.id("loginPassword"));
		textBox(lp.getPassWord(),readExcel(1,2));
		//WebElement loginBtn = driver.findElement(By.id("LoginButton"));
		btnClick(lp.getLoginBtn());
		productSelect();
		WebElement saveBtn = driver.findElement(By.id("toptoSave"));
		btnClick(saveBtn);
		
	}

}
