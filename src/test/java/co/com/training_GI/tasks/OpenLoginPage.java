package co.com.training_GI.tasks;

import co.com.training_GI.ui.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenLoginPage implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(LoginPage.url())
        );
    }

    public static OpenLoginPage open() {
        return instrumented(OpenLoginPage.class);
    }
}
