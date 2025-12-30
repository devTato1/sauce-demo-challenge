package com.nttdata.glue;

import com.nttdata.tasks.AddProduct;
import com.nttdata.tasks.CompleteCheckout;
import com.nttdata.tasks.Login;
import com.nttdata.userinterfaces.CartPage;
import com.nttdata.userinterfaces.InventoryPage;
import com.nttdata.userinterfaces.CheckoutPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class SauceDemoStepsDefs {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("que estoy en la pagina de inicio de SauceDemo")
    public void queEstoyEnLaPaginaDeInicioDeSauceDemo() {
        theActorCalled("Usuario").attemptsTo(
                Open.url("https://www.saucedemo.com/")
        );
    }

    @When("inicio sesion con el usuario {string} y password {string}")
    public void inicioSesion(String user, String password) {
        theActorInTheSpotlight().attemptsTo(
                Login.conCredenciales(user, password)
        );
    }

    @And("agrego un producto al carrito {string}")
    public void agregoUnProducto(String productName) {
        theActorInTheSpotlight().attemptsTo(
                AddProduct.toCart(productName)
        );
    }

    @Then("visualizo el carrito con los productos {string} y {string}")
    public void visualizoElCarritoConLosProductos(String product1, String product2) {
        theActorInTheSpotlight().attemptsTo(
                Click.on(InventoryPage.CART_ICON),
                Ensure.that(CartPage.CART_ITEM_NAME.of(product1)).isDisplayed(),
                Ensure.that(CartPage.CART_ITEM_NAME.of(product2)).isDisplayed(),
                Click.on(CartPage.CHECKOUT_BTN)
        );
    }

    @When("completo el formulario de compra con {string}, {string} y {string}")
    public void completoElFormulario(String name, String lastName, String zipCode) {
        theActorInTheSpotlight().attemptsTo(
                CompleteCheckout.withData(name, lastName, zipCode)
        );
    }

    @Then("finalizo la compra y veo el mensaje {string}")
    public void finalizoLaCompra(String expectedMessage) {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(CheckoutPage.CONFIRMATION_MSG).isDisplayed(),
                Ensure.that(CheckoutPage.CONFIRMATION_MSG).text().containsIgnoringCase(expectedMessage)
        );
    }
}