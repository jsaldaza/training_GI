package co.com.training_GI.ui;

import net.serenitybdd.screenplay.targets.Target;

public class SecureAreaPage {

    public static final Target SUCCESS_MESSAGE =
            Target.the("mensaje de login exitoso")
                    .locatedBy("#flash");
}
