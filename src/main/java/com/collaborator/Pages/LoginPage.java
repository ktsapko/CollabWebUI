package com.collaborator.Pages;

import com.collaborator.Base.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class LoginPage extends Browser {

    WebDriver driver;

    @FindBy(how= How.ID, using="loginFormUserName")
    WebElement username;
    @FindBy(how= How.ID, using="loginFormPassword")
    WebElement password;
    @FindBy(how= How.ID, using="loginFormSubmit")
    WebElement singInButton;
    @FindBy(how= How.XPATH, using="//img[@title=\"Collaborator Enterprise\"]")
    WebElement collabLogo;
    @FindBy(how = How.XPATH, using = "//a[@title=\"Go to the home page\"]")
    WebElement HomePageTab;
    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'gwt-HTML')]")
    WebElement PromptText;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    public void OpenCollabServerURL() {
        driver.get("http://41d0fb30.ngrok.io");
        wait(Wait2Seconds);
    }

    public void checkLogo() {
        log.info("Checking Logo");
        collabLogo.isDisplayed();
    }

    public void setUserName(String strUserName) {
        username.clear();
        username.sendKeys(strUserName);
        log.info("Username is " + username);
    }

    public void setPassword(String strPassword) {
        password.clear();
        password.sendKeys(strPassword);
        log.info("Fill in the password");
    }

    public void clickLogin() {
        singInButton.click();
        log.info("Click on Login button");
    }

    public void verifyHomeTab() {
        log.info("Check Home tab");
        Assert.assertEquals(HomePageTab.getText(), "HOME");
    }

    /**
     * This POM method will be exposed in test case to login in the application
     *
     * @param strUserName
     * @param strPasword
     * @return
     */


    public void LoginToCollab(String strUserName, String strPasword) {

        this.OpenCollabServerURL();
        this.setUserName(strUserName);
        this.setPassword(strPasword);
        this.checkLogo();
        this.clickLogin();
        wait(Wait5Seconds);
        this.verifyHomeTab();
    }

    public void CheckPrompt(String prompt) {
        String currentPrompt = PromptText.getText();
        Assert.assertTrue(currentPrompt.contains(prompt));
        log.info("Proper prompt message is displayed");
    }
}
