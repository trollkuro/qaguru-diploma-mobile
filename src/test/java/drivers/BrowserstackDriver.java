package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.MobileConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {

    protected static MobileConfig mobileConfig = ConfigFactory.create(MobileConfig.class, System.getProperties());

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities caps = new MutableCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", mobileConfig.getUserName());
        caps.setCapability("browserstack.key", mobileConfig.getAccessKey());

        // Set URL of the application under test
        caps.setCapability("app", mobileConfig.getBSApp());

        // Specify device and os_version for testing
        caps.setCapability("device", mobileConfig.getDevice());
        caps.setCapability("os_version", mobileConfig.getOsVersion());

        // Set other BrowserStack capabilities
        caps.setCapability("project", mobileConfig.getProject());
        caps.setCapability("build", mobileConfig.getBuild());
        caps.setCapability("name", mobileConfig.getName());

        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        return new RemoteWebDriver(getBrowserstackURL(), caps);
    }

    public static URL getBrowserstackURL(){
        try {
            return new URL("https://hub.browserstack.com/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}