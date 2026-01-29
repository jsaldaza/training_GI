package co.com.training_GI.ui;

import co.com.training_GI.config.TestConfig;
import net.serenitybdd.screenplay.targets.Target;

public class LoginPage {

    public static String url() {
        return TestConfig.loginUrl();
    }

    public static final Target USERNAME_INPUT =
            Target.the("campo de usuario")
                    .locatedBy("#username");

    public static final Target PASSWORD_INPUT =
            Target.the("campo de contraseña")
                    .locatedBy("#password");

    public static final Target LOGIN_BUTTON =
            Target.the("botón de login")
                    .locatedBy("//button[@type='submit']");
}
