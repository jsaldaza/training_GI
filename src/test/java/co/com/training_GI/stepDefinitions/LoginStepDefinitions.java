package co.com.training_GI.stepDefinitions;

import co.com.training_GI.config.TestConfig;
import co.com.training_GI.questions.LoginSuccessMessage;
import co.com.training_GI.tasks.EnterCredentials;
import co.com.training_GI.tasks.OpenLoginPage;
import co.com.training_GI.ui.SecureAreaPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.waits.WaitUntil.the;
import static org.hamcrest.Matchers.containsString;

public class LoginStepDefinitions {

    @Given("el usuario abre la página de login")
    public void elUsuarioAbreLaPaginaDeLogin() {
        theActorCalled("Juan").attemptsTo(
                OpenLoginPage.open()
        );
    }

    @When("ingresa credenciales válidas")
    public void ingresaCredencialesValidas() {
        theActorInTheSpotlight().attemptsTo(
                EnterCredentials.with(TestConfig.username(), TestConfig.password())
        );
    }

    @Then("debería ver el mensaje de login exitoso")
    public void deberiaVerElMensajeDeLoginExitoso() {

        theActorInTheSpotlight().attemptsTo(
                the(SecureAreaPage.SUCCESS_MESSAGE, isVisible())
        );

        theActorInTheSpotlight().should(
                seeThat(
                        LoginSuccessMessage.text(),
                        containsString(TestConfig.successMessage())
                )
        );
    }
}
