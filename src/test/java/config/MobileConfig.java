package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env_test_run}.properties"
})
public interface MobileConfig extends Config {

    @Key("env_test_run")
    @DefaultValue("browserstack")
    String getEnvTestRun();

    @Key("user_name")
    @DefaultValue("christopherrobin_0GFQZR")
    String getUserName();

    @Key("access_key")
    @DefaultValue("pqC6yfC8Qw6prqMKpJpb")
    String getAccessKey();

    @Key("device")
    @DefaultValue("Google Pixel 3a")
    String getDevice();

    @Key("os_version")
    @DefaultValue("9.0")
    String getOsVersion();

    @Key("bs_application")
    @DefaultValue("bs://555e2c0758fb4bbfdc28fc351e5f6a27aad3a2fd")
    String getBSApp();

    @Key("bs_project")
    @DefaultValue("QA GURU DIPLOMA")
    String getProject();

    @Key("bs_build")
    @DefaultValue("browserstack-build-android")
    String getBuild();

    @Key("bs_name")
    @DefaultValue("android test")
    String getName();

    @Key("app_version")
    String getAppVersion();

    @Key("app_url")
    String getAppUrl();

    @Key("app_package")
    String getAppPackage();

    @Key("app_activity")
    String getAppActivity();
}
