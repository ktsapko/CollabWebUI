package com.collaborator.Base;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Browser extends Base {

    public RemoteWebDriver driver;
    public Properties path_id = new TestIdentifiers().getIDs();

    public void setup(String name)  {
        if (name.contains("CBT_Chrome")) {
            String username = path_id.getProperty("MainUserName");
            String api_key = path_id.getProperty("Authkey");
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("os_api_name", "Win8.1");
            caps.setCapability("browser_api_name", "Chrome69x64");
            caps.setCapability("name", "Collaborator Smoke Test Chrome");
            caps.setCapability("record_video", "true");

            try {
                driver = new RemoteWebDriver(new URL("http://" + username + ":" + api_key + "@hub.crossbrowsertesting.com:80/wd/hub"), caps);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } else if (name.contains("Chrome")) {
            ChromeOptions option = new ChromeOptions();
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            capabilities.setCapability(ChromeOptions.CAPABILITY, option);
            try {
                driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), capabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        }
    }
    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
