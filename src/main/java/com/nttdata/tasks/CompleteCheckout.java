package com.nttdata.tasks;

import com.nttdata.userinterfaces.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CompleteCheckout implements Task {
    private final String firstName;
    private final String lastName;
    private final String zipCode;

    public CompleteCheckout(String firstName, String lastName, String zipCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.zipCode = zipCode;
    }

    public static CompleteCheckout withData(String firstName, String lastName, String zipCode) {
        return instrumented(CompleteCheckout.class, firstName, lastName, zipCode);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(firstName).into(CheckoutPage.FIRST_NAME),
                Enter.theValue(lastName).into(CheckoutPage.LAST_NAME),
                Enter.theValue(zipCode).into(CheckoutPage.POSTAL_CODE),
                Click.on(CheckoutPage.CONTINUE_BTN),
                Click.on(CheckoutPage.FINISH_BTN)
        );
    }
}