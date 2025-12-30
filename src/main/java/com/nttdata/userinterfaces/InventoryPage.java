package com.nttdata.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class InventoryPage {

    public static final Target ADD_TO_CART_BTN = Target.the("botón añadir al carrito de {0}")
            .locatedBy("//div[contains(@class, 'inventory_item_name')][text()='{0}']/ancestor::div[@class='inventory_item']//button");

    public static final Target CART_ICON = Target.the("icono del carrito")
            .located(By.className("shopping_cart_link"));
}