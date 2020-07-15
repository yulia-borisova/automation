package shopping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

// Super class to initialize the WebElement
public class PageObject {
	protected WebDriver driver;

//Constructor	
	public PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// PageFactory class locates all web elements using annotated selectors
	}

}
