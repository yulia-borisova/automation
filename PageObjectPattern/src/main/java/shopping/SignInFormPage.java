package shopping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInFormPage extends PageObject {

	public SignInFormPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(id = "customer_firstname")
	private WebElement firstName;

	@FindBy(id = "customer_lastname")
	private WebElement lastName;

	@FindBy(id = "passwd")
	private WebElement password;

	@FindBy(id = "days")
	private WebElement day;

	@FindBy(id = "months")
	private WebElement month;

	@FindBy(id = "years")
	private WebElement year;

	@FindBy(id = "firstname")
	private WebElement addressFirstName;

	@FindBy(id = "lastname")
	private WebElement addressLastName;

	@FindBy(id = "address1")
	private WebElement address;

	@FindBy(id = "city")
	private WebElement city;

	@FindBy(id = "id_state")
	private WebElement state;

	@FindBy(id = "postcode")
	private WebElement zip;

	@FindBy(id = "phone_mobile")
	private WebElement phone;

	@FindBy(id = "alias")
	private WebElement aliasAddress;

	@FindBy(id = "submitAccount")
	private WebElement registerButton;

// Methods 
	public void enterMainCredentials(String firstName, String lastName, String password) {
		this.firstName.sendKeys(firstName);
		this.lastName.sendKeys(lastName);
		this.password.sendKeys(password);
	}

	public void setDOB(String day, String month, String year) {
		this.day.sendKeys(day);
		this.month.sendKeys(month);
		this.year.sendKeys(year);
	}

	public void enterAddress(String addressFirstName, String addressLastName, String address, String city, String state,
			String zip, String phone, String aliasAddress) {
		this.addressFirstName.sendKeys(addressFirstName);
		this.addressLastName.sendKeys(addressLastName);
		this.address.sendKeys(address);
		this.city.sendKeys(city);
		this.state.sendKeys(state);
		this.zip.sendKeys(zip);
		this.phone.sendKeys(phone);
		this.aliasAddress.sendKeys(aliasAddress);
	}

	public UserPage clickRegisterButton() {
		this.registerButton.click();
		return new UserPage(driver);
	}

}

