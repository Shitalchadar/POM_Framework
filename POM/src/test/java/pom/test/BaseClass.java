package pom.test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;

public class BaseClass {
	WebDriver driver;
	public void doSetup(){
		driver=new ChromeDriver();
		driver.get("file:///home/vishal/Downloads/Offline%20Website/index.html");
		driver.manage().window().maximize();
		}
	@DataProvider(name="login")
	public Object[][] getLoginInvalidData(){
		
	return new Object[][]{
			new Object[]{"", ""},
			new Object[]{"", "123456"},
			new Object[] {"queuecodes@gmail.com", ""},
			new Object[] {"queuecodes@gmail", ""},
			new Object[] {"queuecodes@gmail.com", "2343"},
			new Object[] {"queuecodes@gmail.", "566767"},

	};
}
}