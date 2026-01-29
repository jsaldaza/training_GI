package co.com.training_GI.ui;

import net.serenitybdd.screenplay.targets.Target;

public class LoginPage {

    public static final String URL = "https://the-internet.herokuapp.com/login";

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
