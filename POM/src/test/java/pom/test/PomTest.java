package pom.test;
//import javax.validation.constraints.AssertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pom.pages.HomePage;
import pom.pages.LoginPage;
import pom.pages.RegisterPage;
//import pomPage.LoginPage;

	public class PomTest extends BaseClass {
		@BeforeSuite
		public void launching(){
			doSetup();
		}
		@Test(enabled=true, priority=1)
		public void loginTest(){
			LoginPage login=new LoginPage(driver);
			HomePage home=	login.doLogin("queuecodes@gmail.com", "123456");	
			assertTrue(home.homeTitleAssertion());
			home.doLogout();
		}
		private void assertTrue(boolean homeTitleAssertion) {			
		}
		/*private void assertTrue(boolean homeTitleAssertion) {
			// TODO Auto-generated method stub
			
		}*/
		@Test(enabled=true, dataProvider="login", priority=0)
		public void loginWithInvalid(String uName, String uPass) {
			LoginPage login=new LoginPage(driver);
			boolean result=login.doLoginWithInvalid("uName","uPass");
			assertTrue(result);

		}
		@Test(enabled=true, priority=2)
		public void registerTest() {
			driver.findElement(By.linkText("Register a new membership")).click();
			RegisterPage register= new RegisterPage(driver);
			boolean result=register.doRegister("shital","7020533318","queuecodes@gmail.com","12345");
			assertTrue(result);
		}
		
		@AfterSuite
		public void closeBrowser(){
			driver.close();
		}
}



