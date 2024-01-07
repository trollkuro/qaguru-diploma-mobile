package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.MobileConfig;
import drivers.BrowserstackDriver;
import drivers.LocalDriver;
import helpers.Attachments;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    static MobileConfig mobileConfig = ConfigFactory.create(MobileConfig.class, System.getProperties());


    @BeforeAll
    static void beforeAll() {
        switch (mobileConfig.getEnvTestRun()){
            case "browserstack":
                Configuration.browser = BrowserstackDriver.class.getName();
                break;
            case "emulator":
                Configuration.browser = LocalDriver.class.getName();
                break;
            default:
                System.out.println("Oooops, something wrong! Recheck your Configs :)");
        }
        Configuration.browserSize = null;
        Configuration.timeout = 10000;
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    void addAttachments() {
        String sessionId = Selenide.sessionId().toString();
        if (mobileConfig.getEnvTestRun().equals("emulator")) {
            Attachments.screenshotAs("Last screenshot");
        }
        Attachments.pageSource();
        closeWebDriver();
        if (mobileConfig.getEnvTestRun().equals("browserstack")) {
            Attachments.addVideo(sessionId);
        }
    }
}
