package com.jsystems.testautomation.frontedFactory.tests;

import com.jsystems.testautomation.Configuration;
import com.jsystems.testautomation.frontedFactory.pages.FrontendConfig;
import com.jsystems.testautomation.frontedFactory.pages.LoginPageEmail;
import com.jsystems.testautomation.frontedFactory.pages.LoginPasswordPage;
import com.jsystems.testautomation.frontedFactory.pages.MainLogedPage;
import com.jsystems.testautomation.frontedFactory.pages.MainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FrontentTestMainPage extends FrontendConfig {

    MainPage mainPage;
    LoginPageEmail loginPageEmail;
    LoginPasswordPage loginPasswordPage;
    MainLogedPage mainLogedPage;

    @Test
    @DisplayName("Test of main page content")
    public void contentMaiPageTest() {

        driver.get("https://wordpress.com/");
        mainPage = new MainPage(driver);
        mainPage.isContentPresent();


    }
    @Test
    @DisplayName("Login Test")
    public void loginTest(){
      //  driver.get("https://wordpress.com/");
        driver.get(Configuration.WORDPRESS_BASE_URL);
        mainPage = new MainPage(driver);
        mainPage.loginButton.click();


        loginPageEmail = new LoginPageEmail(driver);
        loginPageEmail.emailField.sendKeys(Configuration.WORDPRESS_EMAIL);
        //loginPageEmail.waitForVisibilityElement(loginPageEmail.continueButton, 15);
        loginPageEmail.continueButton.click();



        loginPasswordPage = new LoginPasswordPage(driver);
        loginPasswordPage.passwordField.sendKeys(Configuration.WORDPRESS_PASSOWRD);
        loginPasswordPage.logInButton.click();


        //  loginPasswordPage.continuePasswordButton.click();
        mainLogedPage = new MainLogedPage(driver);
          //mainLogedPage mainLogedPage = MainLogedPage(driver);
        //mainLogedPage.avatar.click();



    }
}
