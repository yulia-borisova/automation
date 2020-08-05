package ShoppingStepDifinitions;

import io.cucumber.java.en.*;

public class ResetPasswordSteps {
    @Given("User is on Home page")
    public void user_is_on_home_page() {
        System.out.println("Step 1: User is on home page");
    }

    @When("User clicks Sign-in button")
    public void user_clicks_sign_in_button() {
        System.out.println("Step 2: User clicks signin button");
    }

    @When("User clicks Forgot your passoword link")
    public void user_clicks_forgot_your_passoword_link() {
        System.out.println("Step 3: User clicks forgot pass link");
    }

    @When("User inputs {word}")
    public void user_iputs_email(String email) {
        System.out.println("Step 4: User is on home page");
    }

    @When("User clicks Retrieve password")
    public void user_clicks_retrieve_password() {
        System.out.println("Step 5: clicks retrive");
    }

    @Then("User gets a confirmation message")
    public void user_gets_a_confirmation_message() {
        System.out.println("Step 6: Getting confirmation message");
    }
}