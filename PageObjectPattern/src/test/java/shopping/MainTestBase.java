package shopping;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import utils.TestDataGenerator;

public class MainTestBase {
	protected static WebDriver driver;
	protected static TestDataGenerator emailGenerator = new TestDataGenerator();
	protected static String baseUrl = "http://automationpractice.com";

	@BeforeClass
	public static void setup() throws IOException {
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("before class working...");
	}

	@AfterClass
	public static void teardown() {
		System.out.println("after class working...");
		driver.quit();
	}
}