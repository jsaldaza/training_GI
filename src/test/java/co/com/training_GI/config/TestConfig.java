package co.com.training_GI.config;

import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;

public final class TestConfig {

    private static final EnvironmentVariables ENV =
            SystemEnvironmentVariables.createEnvironmentVariables();

    private TestConfig() {
    }

    private static String get(String key, String defaultValue) {
        String value = EnvironmentSpecificConfiguration.from(ENV).getProperty(key);
        return value != null ? value : defaultValue;
    }

    public static String baseUrl() {
        return get("app.base.url", "https://the-internet.herokuapp.com");
    }

    public static String loginPath() {
        return get("app.login.path", "/login");
    }

    public static String loginUrl() {
        return baseUrl() + loginPath();
    }

    public static String username() {
        return get("app.login.username", "tomsmith");
    }

    public static String password() {
        return get("app.login.password", "SuperSecretPassword!");
    }

    public static String successMessage() {
        return get("app.login.success.message", "You logged into a secure area");
    }
}
