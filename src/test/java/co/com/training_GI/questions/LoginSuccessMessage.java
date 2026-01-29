package co.com.training_GI.questions;

import co.com.training_GI.ui.SecureAreaPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class LoginSuccessMessage implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return SecureAreaPage.SUCCESS_MESSAGE.resolveFor(actor).getText();
    }

    public static LoginSuccessMessage text() {
        return new LoginSuccessMessage();
    }
}
