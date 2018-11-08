package com.collaborator;

import com.collaborator.Base.Browser;
import com.collaborator.Components.TopBar;
import com.collaborator.Pages.*;
import org.openqa.selenium.support.PageFactory;

public class TestHelper extends Browser {
    Dashboard dashboard;
    DiffViewerPage diffViewerPage;
    ReportsPage reportsPage;
    ReviewPage reviewPage;
    LoginPage loginPage;
    AdminPage adminPage;
    TopBar topBar;

    public void init() {
        dashboard = PageFactory.initElements(this.driver, Dashboard.class);
        reportsPage = PageFactory.initElements(this.driver, ReportsPage.class);
        reviewPage = PageFactory.initElements(this.driver, ReviewPage.class);
        diffViewerPage = PageFactory.initElements(this.driver, DiffViewerPage.class);
        loginPage = PageFactory.initElements(this.driver, LoginPage.class);
        adminPage = PageFactory.initElements(this.driver, AdminPage.class);
        topBar = PageFactory.initElements(this.driver, TopBar.class);
    }
}
