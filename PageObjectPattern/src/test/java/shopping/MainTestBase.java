package shopping;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainTestBase {
	protected static WebDriver driver;

	@BeforeClass
	public static void SetUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Yulia_Borisova\\Desktop\\Java_Study\\Projects\\Eclipse-Selenium\\PageObjectPattern\\src\\test\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("before class working...");

	}

	@AfterClass
	public static void tearDown() {
		System.out.println("after class working...");
		driver.quit();
	}

}
