package com.collaborator.Pages;

import com.collaborator.Base.Browser;
import com.collaborator.Components.AdminSystemDisplayTab;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AdminPage extends Browser {

    WebDriver driver;
    public AdminSystemDisplayTab adminSystemDisplayTab;

    /*
     * The Right Panel In Admin Section
     * */
    @FindBy(how= How.XPATH, using="//td[@class='WizardStepSelected First']")
    WebElement SystemTab;
    @FindBy(how= How.XPATH, using="//a[contains(text(), 'Email')]")
    WebElement EmailSubTab;
    @FindBy(how= How.XPATH, using="//a[contains(text(), 'Version Control')]")
    WebElement VersionControlSubTab;
    @FindBy(how= How.XPATH, using="//a[contains(text(), 'Triggers')]")
    WebElement TriggersSubTab;

    /*
     * System tabs on the page
     * */
    @FindBy(how= How.XPATH, using="//*[@id=\"ext-comp-1001__preferences-settings\"]")
    WebElement SettingTab;
    @FindBy(how= How.XPATH, using="//*[@id=\"ext-comp-1001__preferences-display\"]")
    WebElement DisplayTab;


    public AdminPage(WebDriver driver) {
        this.driver = driver;
        adminSystemDisplayTab = PageFactory.initElements(this.driver, AdminSystemDisplayTab.class);
    }

    public void OpenSystemDisplayTab() {
        DisplayTab.click();
        log.info("Display Tab Opened");
    }
}
