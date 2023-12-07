@testSelenium
Feature: Validacion de carrito de compras
  Como usuario de la web necesito realizar compras para poder validar el carrito de compras

  Background:
    Given estoy en la pagina de inicio

  @testSelenium1
  Scenario Outline: Validacion de carrito de compras seleccionando 01 telefono
    When selecciono la categoria a filtrar "<categoriaProducto>"
    And selecciono el producto a comprar "<nombreProducto>"
    And hago click en agregar al carrito
    And hago click en el menu carrito
    And verifico que se visualice el producto a comprar "<nombreProducto>"
    And hago click en el boton Place Order
    And completo los campos requeridos en el formulario "<nombreCliente>", "<PaisCliente>", "<CiudadCLiente>", "<TarjetaCliente>", "<MesTarjeta>", "<AnioTarjeta>"
    And  hago click en boton purchase
    Then Valido confirmacion de la compra
    Examples:
      | categoriaProducto | nombreProducto    | nombreCliente | PaisCliente | CiudadCLiente | TarjetaCliente | MesTarjeta | AnioTarjeta |
      | Phones            | Samsung galaxy s7 | test          | test        | test          | 987654321      | 01         | 1999        |

  @testSelenium2
  Scenario Outline: Validacion de carrito de compras seleccionando 02 telefonos diferentes
    When selecciono la categoria a filtrar "<categoriaProducto1>"
    And selecciono el producto a comprar "<nombreProducto1>"
    And hago click en agregar al carrito
    And retorno al home
    And selecciono el segundo producto a comprar "<categoriaProducto2>", "<nombreProducto2>"
    And hago click en el menu carrito
    And verifico que se visualicen los productos a comprar "<nombreProducto1>", "<nombreProducto2>"
    And hago click en el boton Place Order
    And completo los campos requeridos en el formulario "<nombreCliente>", "<PaisCliente>", "<CiudadCLiente>", "<TarjetaCliente>", "<MesTarjeta>", "<AnioTarjeta>"
    And  hago click en boton purchase
    Then Valido confirmacion de la compra
    Examples:
      | categoriaProducto1 | categoriaProducto2 | nombreProducto1   | nombreProducto2  | nombreCliente | PaisCliente | CiudadCLiente | TarjetaCliente | MesTarjeta | AnioTarjeta |
      | Phones             | Phones             | Samsung galaxy s7 | Nokia lumia 1520 | test          | test        | test          | 987654321      | 01         | 1999        |

  @testSelenium3
  Scenario Outline: Validacion de carrito de compras seleccionando 02 productos iguales
    When selecciono la categoria a filtrar "<categoriaProducto>"
    And selecciono el producto a comprar "<nombreProducto>"
    And hago click en agregar al carrito
    And retorno al home
    And selecciono el segundo producto a comprar "<categoriaProducto>", "<nombreProducto>"
    And hago click en el menu carrito
    And verifico que se visualicen los productos iguales a comprar "<nombreProducto>", 2
    And hago click en el boton Place Order
    And completo los campos requeridos en el formulario "<nombreCliente>", "<PaisCliente>", "<CiudadCLiente>", "<TarjetaCliente>", "<MesTarjeta>", "<AnioTarjeta>"
    And  hago click en boton purchase
    Then Valido confirmacion de la compra
    Examples:
      | categoriaProducto | nombreProducto | nombreCliente | PaisCliente | CiudadCLiente | TarjetaCliente | MesTarjeta | AnioTarjeta |
      | Laptops           | MacBook air    | test          | test        | test          | 987654321      | 01         | 1999        |