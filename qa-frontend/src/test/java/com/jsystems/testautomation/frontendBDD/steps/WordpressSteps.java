package com.jsystems.testautomation.frontendBDD.steps;

import com.jsystems.testautomation.Configuration;
import com.jsystems.testautomation.frontendBDD.page.LoginPageEmail;
import com.jsystems.testautomation.frontendBDD.page.LoginPasswordPage;
import com.jsystems.testautomation.frontendBDD.page.MainLogedPage;
import com.jsystems.testautomation.frontendBDD.page.MainPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WordpressSteps extends BaseSteps {
MainPage mainPage;
    LoginPageEmail loginPageEmail;
    LoginPasswordPage loginPasswordPage;
    MainLogedPage mainLogedPage;



    public WordpressSteps(StepsConfig config){
        super(config);
        try {
            driver = config.setUp();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(config.id);
        }
}

    
    @Given("^User is on wordpress website \"(.*)\"$")
    public void userIsInWordpressWebSite(String website) {
        driver.get(Configuration.WORDPRESS_BASE_URL);
        mainPage = new MainPage(driver);



    }

    @When("^User clicks to login button$")
    public void userClicksToLoginButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
     //   throw new PendingException();
        mainPage.loginButton.click();

    }

    @Then("^Email login page is displayed$")
    public void emailLoginPageIsDisplayed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
      //  throw new PendingException();
        loginPageEmail = new LoginPageEmail(driver);
        loginPageEmail.emailField.isDisplayed();
    }

    @When("^User enter email and clicks continue button$")
    public void userEnterEmailAndClicksContinueButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    //    throw new PendingException();

        loginPageEmail.emailField.sendKeys(Configuration.WORDPRESS_EMAIL);
        loginPageEmail.continueButton.click();
    }

    @Then("^Password login page is displayed$")
    public void passwordLoginPageIsDisplayed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
     //   throw new PendingException();
        loginPasswordPage = new LoginPasswordPage(driver);
        loginPasswordPage.passwordField.isDisplayed();
    }

    @When("^User enters password and press Login Button$")
    public void userEntersPasswordAndPressLoginButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
     //   throw new PendingException();
        loginPasswordPage.passwordField.sendKeys(Configuration.WORDPRESS_PASSOWRD);
        loginPasswordPage.logInButton.click();

    }

    @Then("^Main loged pag is displayed$")
    public void mainLogedPagIsDisplayed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
     //   throw new PendingException();
        mainLogedPage = new MainLogedPage(driver);
        Thread.sleep(2000);
        assertTrue(mainLogedPage.avatar.isDisplayed());
    }

    @When("^User press avatar$")
    public void userPressAvatar() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    //    throw new PendingException();
        // mainLogedPage.avatar.click();
    }

    @Then("^Personal Page is displayed$")
    public void personalPageIsDisplayed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    //    throw new PendingException();
    }

    @When("^User clikcs notification link$")
    public void userClikcsNotificationLink() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
     //   throw new PendingException();
    }

    @Then("^Notification page is displayed$")
    public void notificationPageIsDisplayed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
     //   throw new PendingException();
    }

    @When("^User Press checkbox$")
    public void userPressCheckbox() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
     //   throw new PendingException();
    }

    @Then("^Checkbox is unselected$")
    public void checkboxIsUnselected() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
     //   throw new PendingException();
    }
}
