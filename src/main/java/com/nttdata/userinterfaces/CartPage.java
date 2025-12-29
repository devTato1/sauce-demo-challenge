package com.nttdata.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CartPage {
    // Validamos que el elemento exista en el carrito usando tu HTML
    public static final Target CART_ITEM_NAME = Target.the("nombre del producto en carrito {0}")
            .locatedBy("//div[@class='cart_item']//div[@class='inventory_item_name'][text()='{0}']");

    // Tu HTML: id="checkout"
    public static final Target CHECKOUT_BTN = Target.the("botón checkout")
            .located(By.id("checkout"));
}