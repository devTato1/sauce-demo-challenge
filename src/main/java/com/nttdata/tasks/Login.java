package com.nttdata.tasks;

import com.nttdata.userinterfaces.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Login implements Task {
    private final String usuario;
    private final String password;

    public Login(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    public static Login conCredenciales(String usuario, String password) {
        return instrumented(Login.class, usuario, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(usuario).into(LoginPage.USERNAME_FIELD),
                Enter.theValue(password).into(LoginPage.PASSWORD_FIELD),
                Click.on(LoginPage.LOGIN_BUTTON)
        );
    }
}