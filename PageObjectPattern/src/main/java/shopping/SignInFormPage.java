package shopping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInFormPage extends PageObject {

    public SignInFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "customer_firstname")
    private WebElement firstNameInput;

    @FindBy(id = "customer_lastname")
    private WebElement lastNameInput;

    @FindBy(id = "passwd")
    private WebElement passwordInput;

    @FindBy(id = "days")
    private WebElement dayInput;

    @FindBy(id = "months")
    private WebElement monthInput;

    @FindBy(id = "years")
    private WebElement yearInput;

    @FindBy(id = "firstname")
    private WebElement addressFirstNameInput;

    @FindBy(id = "lastname")
    private WebElement addressLastNameInput;

    @FindBy(id = "address1")
    private WebElement addressInput;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "id_state")
    private WebElement stateInput;

    @FindBy(id = "postcode")
    private WebElement zipInput;

    @FindBy(id = "phone_mobile")
    private WebElement phoneInput;

    @FindBy(id = "alias")
    private WebElement aliasAddressInput;

    @FindBy(id = "submitAccount")
    private WebElement registerButton;

    // Methods
    public void enterMainCredentials(String firstName, String lastName, String password) {
        this.firstNameInput.sendKeys(firstName);
        this.lastNameInput.sendKeys(lastName);
        this.passwordInput.sendKeys(password);
    }

    public void setDOB(String day, String month, String year) {
        this.dayInput.sendKeys(day);
        this.monthInput.sendKeys(month);
        this.yearInput.sendKeys(year);
    }

    public void enterAddress(String addressFirstName, String addressLastName, String address, String city, String state,
            String zip, String phone, String aliasAddress) {
        this.addressFirstNameInput.sendKeys(addressFirstName);
        this.addressLastNameInput.sendKeys(addressLastName);
        this.addressInput.sendKeys(address);
        this.cityInput.sendKeys(city);
        this.stateInput.sendKeys(state);
        this.zipInput.sendKeys(zip);
        this.phoneInput.sendKeys(phone);
        this.aliasAddressInput.sendKeys(aliasAddress);
    }

    public String getUrl() {
        String url = driver.getCurrentUrl();
        return url;
    }

    public UserPage clickRegisterButton() {
        this.registerButton.click();
        return new UserPage(driver);
    }
}