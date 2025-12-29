package com.nttdata.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CheckoutPage {
    // Formulario de datos
    public static final Target FIRST_NAME = Target.the("campo nombre")
            .located(By.id("first-name"));
    public static final Target LAST_NAME = Target.the("campo apellido")
            .located(By.id("last-name"));
    public static final Target POSTAL_CODE = Target.the("código postal")
            .located(By.id("postal-code"));
    public static final Target CONTINUE_BTN = Target.the("botón continuar")
            .located(By.id("continue"));

    // Página Overview (Resumen) - Nuevo ID que me pasaste
    public static final Target FINISH_BTN = Target.the("botón finish")
            .located(By.id("finish"));

    // Página Final (Confirmación) - Nueva Clase que me pasaste
    public static final Target CONFIRMATION_MSG = Target.the("mensaje de confirmación")
            .located(By.className("complete-header"));

    // Validación extra: Título de la página final (opcional, pero recomendado)
    public static final Target TITLE = Target.the("titulo de sección")
            .located(By.className("title"));
}