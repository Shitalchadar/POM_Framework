package pom.pages;


	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.testng.annotations.BeforeSuite;
	import org.testng.annotations.Test;


	public class LoginPage {
		WebDriver driver;
		public LoginPage(WebDriver driver){
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		@FindBy(id="email")
		WebElement email;
		
		@FindBy(id="password")
		WebElement pass;
		@FindBy(id="submit")
		WebElement signIn;
		
		public void enterEmail(String str){
			email.clear();
			email.sendKeys(str);
		}
		public void enterPassword(String str){
			pass.clear();
			pass.sendKeys(str);
		}
		public HomePage clickOnSubmit(){
			signIn.click();
			return new HomePage(driver);
		}
		public HomePage doLogin(String uName, String Upass){
			enterEmail(uName);
			enterPassword(Upass);
			return clickOnSubmit();
		}
		public void ClickOnButton() {
			signIn.click();
		}
		public boolean verifyTitle() {
			String actual=driver.getTitle();
			return actual.equalsIgnoreCase("Queue Codes | Log in");
		}
		public boolean doLoginWithInvalid(String uName, String Upass){
			enterEmail(uName);
			enterPassword(Upass);
			 clickOnSubmit();
			 return verifyTitle();
		}
	}



