package com.nttdata.tasks;

import com.nttdata.userinterfaces.InventoryPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AddProduct implements Task {
    private final String productName;

    public AddProduct(String productName) {
        this.productName = productName;
    }

    public static AddProduct toCart(String productName) {
        return instrumented(AddProduct.class, productName);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(InventoryPage.ADD_TO_CART_BTN.of(productName))
        );
    }
}