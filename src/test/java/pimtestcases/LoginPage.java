package pimtestcases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass{

	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(id="loginEmail")
	private WebElement userName;
	
	@FindBy(id="loginPassword")
	private WebElement passWord;
	
	@FindBy(id="LoginButton")
	private WebElement loginBtn;
	
	
	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPassWord() {
		return passWord;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	
	
}
