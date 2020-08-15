package ShoppingStepDifinitions;

import io.cucumber.java.en.*;
//Step definition just to execute Cucumber scenario 

public class RegistrationStepTwo {

    @Given("User is on SignIn Form Page")
    public void getSignInForm() {
        System.out.println("Step1: New User is on Registration Form page");

    }

    @When("^User inputs (.+), (.+), (.+), (.+),(.+), (.+),(.+), (.+), (.+), (.+), (.+), (.+)$")
    public void inputUserData(String firstname, String lastname, String password, String day, String month, String year,
            String address, String city, String state, String code, String phone, String alias) {
        System.out.println("Step2: User inputs data");
    }

    @And("Clicks Register button")
    public void clickRegisterButton() {
        System.out.println("Step3: User clicks register button");
    }

    @Then("User is navigated to My Account Page")
    public void user_is_navigated_to_my_account_page() {
        System.out.println("Step4: User is navitated to My Account Page");
    }
}