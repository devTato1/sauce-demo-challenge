Feature: Compra de productos en SauceDemo

  @Exitoso
  Scenario Outline: Compra exitosa validando productos en el carrito
    Given que estoy en la pagina de inicio de SauceDemo
    When inicio sesion con el usuario "<usuario>" y password "<password>"
    And agrego un producto al carrito "<producto1>"
    And agrego un producto al carrito "<producto2>"
    Then visualizo el carrito con los productos "<producto1>" y "<producto2>"
    When completo el formulario de compra con "<nombre>", "<apellido>" y "<zip>"
    Then finalizo la compra y veo el mensaje "<mensaje>"

    Examples:
      | usuario       | password     | producto1           | producto2             | nombre   | apellido | zip    | mensaje                   |
      | standard_user | secret_sauce | Sauce Labs Backpack | Sauce Labs Bike Light | Leonardo | Reascos  | 170150 | Thank you for your order! |