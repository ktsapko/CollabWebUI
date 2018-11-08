package com.collaborator;

import org.testng.annotations.*;

public class LoginPageTest {

    public Actionwords actionwords;

    @BeforeMethod
    public void setUp() {
        actionwords = new Actionwords();

        actionwords.theBrowserNameIsStarted("CBT_Chrome");
    }
    // **In order to** customize the message on the login screen
    // **As a** admin user
    // **I can** change login prompt in the Admin section 
    // 
    // Tags: Admin
    @Test
    public void changeUserLoginPrompt() {
        // When I login as "admin" with password "admin"
        actionwords.iLoginAsUsernameWithPasswordPassword("admin", "admin");
        // And I edit user login prompt with text "QA TEST"
        actionwords.iEditUserLoginPromptWithTextText("QA TEST");
        // And Logout
        actionwords.logout();
        // Then New prompt displays text "QA TEST"
        actionwords.newPromptDisplaysTextText("QA TEST");
    }
}