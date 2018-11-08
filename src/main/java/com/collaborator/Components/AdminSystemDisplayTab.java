package com.collaborator.Components;

import com.collaborator.Base.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class AdminSystemDisplayTab extends Browser {
    WebDriver driver;
    Actions actions;

    @FindBy(how = How.XPATH, using = "//h3[contains(text(), 'Display Options')]")
    WebElement DisplayOptionsHeader;
    @FindBy(how = How.ID, using = "user-login-prompt-text")
    WebElement UserLoginPromptInput; // User Login Prompt Input Filed
    @FindBy(how = How.ID, using = "buttonSubmitDisplay")
    WebElement SaveDisplayOptionsButton; // Save button -- Need to be fixed
    @FindBy(how = How.XPATH, using = "//div[contains(text(), 'Select default WebUI theme')]")
    WebElement SelectWebUILabel;
    @FindBy(how = How.TAG_NAME, using = "html")
    WebElement html;

    public AdminSystemDisplayTab(WebDriver driver) {
        this.driver = driver;
        actions =  new Actions(driver);
    }

    public void EditUserLoginPrompt(String prompt) {
        UserLoginPromptInput.clear();
        UserLoginPromptInput.sendKeys(prompt);
        log.info("Prompt message was changed to " + prompt);
        actions.moveToElement(SaveDisplayOptionsButton);
        wait(Wait1Second);
        Assert.assertTrue(SaveDisplayOptionsButton.isDisplayed());
        SaveDisplayOptionsButton.click();
        log.info("Changes Saved");
        actions.moveToElement(DisplayOptionsHeader);
        wait(Wait1Second);
    }
}
