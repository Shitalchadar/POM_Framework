package pom.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	WebDriver driver;
	Alert alt;
	String alrtMsg;
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="name")
	WebElement name;
	
	@FindBy(id="mobile")
	WebElement mobile;
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="password")
	WebElement password;
	@FindBy(className="btn")
	WebElement submit;
	
	public void entername(String str){
		name.sendKeys(str);
	}
	public void enterMobile(String str){
		mobile.sendKeys(str);
	}
	public void enterEmail(String str){
		email.sendKeys(str);
	}
	public void enterPassword(String str){
		password.sendKeys(str);
	}
	public void clickOnSubmit(){
		submit.click();
		//alt.accept();
	}
	public String getAlert() {
		alt=driver.switchTo().alert();
		alrtMsg=alt.getText();
		alt.accept();
		return alrtMsg;
	}
	public boolean doRegister(String name, String mobile, String email, String password) {
		entername(name);
		enterMobile(mobile);
		enterEmail(email);
		enterPassword(password);
		clickOnSubmit();
		String actualMsg=getAlert();
		return actualMsg.equalsIgnoreCase("User registered successfully.");

	}
	
}
