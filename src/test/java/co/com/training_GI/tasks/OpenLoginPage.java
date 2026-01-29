package co.com.training_GI.tasks;

import co.com.training_GI.ui.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class OpenLoginPage implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(LoginPage.URL)
        );
    }

    public static OpenLoginPage open() {
        return new OpenLoginPage();
    }
}
