package stepDefinitions.base;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Base_PO;
import pageObjects.CompraProductoPO;
import utils.Constants_Vars;

public class CompraProductosSteps extends Base_PO {
     private CompraProductoPO compraProductoPO;


    public CompraProductosSteps(CompraProductoPO compraProductoPO) {
        this.compraProductoPO = compraProductoPO;
    }

    @Given("estoy en la pagina de inicio")
    public void estoy_en_la_pagina_de_inicio() {
        compraProductoPO.navigateToUrl(Constants_Vars.URL_BASE);
    }

    @When("selecciono la categoria a filtrar {string}")
    public void seleccionoLaCategoriaAFiltrar(String categoriaProducto) {
        compraProductoPO.seleccionoLaCategoriaAFiltrar(categoriaProducto);
    }

    @And("selecciono el producto a comprar {string}")
    public void seleccionoElProductoAComprar(String nombreProducto) {
        compraProductoPO.seleccionoElProductoAComprar(nombreProducto);
    }

    @And("hago click en agregar al carrito")
    public void hagoClickEnAgregarAlCarrito() {
        compraProductoPO.hagoClickEnAgregarAlCarrito();
    }

    @And("hago click en el menu carrito")
    public void hagoClickEnElMenuCarrito() {
        compraProductoPO.hagoClickEnElMenuCarrito();
    }

    @And("verifico que se visualice el producto a comprar {string}")
    public void verificoQueSeVisualiceElProductoAComprar(String nombreProducto) {
        compraProductoPO.verificoQueSeVisualiceElProductoAComprar(nombreProducto);
    }

    @And("hago click en el boton Place Order")
    public void hagoClickEnElBotonPlaceOrder() {
        compraProductoPO.hagoClickEnElBotonPlaceOrder();
    }

    @And("completo los campos requeridos en el formulario {string}, {string}, {string}, {string}, {string}, {string}")
    public void completoLosCamposRequeridosEnElFormulario(String nombreCliente, String PaisCliente, String CiudadCLiente, String TarjetaCliente, String MesTarjeta, String AnioTarjeta) {
        compraProductoPO.completoCampoNombrePlaceOrder(nombreCliente);
        compraProductoPO.completoCampoCountryPlaceOrder(PaisCliente);
        compraProductoPO.completoCampoCityPlaceOrder(CiudadCLiente);
        compraProductoPO.completoCampoCreditCardPlaceOrder(TarjetaCliente);
        compraProductoPO.completoCampoMonthPlaceOrder(MesTarjeta);
        compraProductoPO.completoCampoYearPlaceOrder(AnioTarjeta);
    }

    @And("hago click en boton purchase")
    public void hagoClickEnBotonPurchase() {
        compraProductoPO.hagoClickEnBotonPurchase();
    }

    @Then("Valido confirmacion de la compra")
    public void validoConfirmacionDeLaCompra() {
        compraProductoPO.validoConfirmacionDeLaCompra();
    }

    @And("retorno al home")
    public void retornoAlHome() {
        compraProductoPO.navigateToUrl(Constants_Vars.URL_BASE);
    }

    @And("selecciono el segundo producto a comprar {string}, {string}")
    public void seleccionoElSegundoProductoAComprar(String categoriaProducto2,String nombreProducto2) {
        compraProductoPO.seleccionoLaCategoriaAFiltrar(categoriaProducto2);
        compraProductoPO.seleccionoElSegundoProductoAComprar(nombreProducto2);
        compraProductoPO.hagoClickEnAgregarAlCarrito();
    }

    @And("verifico que se visualicen los productos a comprar {string}, {string}")
    public void verificoQueSeVisualicenLosProductosAComprar(String nombreProducto1, String nombreProducto2) {
        compraProductoPO.verificoQueSeVisualicenLosProductosAComprar(nombreProducto1,nombreProducto2);
    }

    @And("verifico que se visualicen los productos iguales a comprar {string}, {int}")
    public void verificoQueSeVisualicenLosProductosIgualesAComprar(String nombreProducto, int cantidadProductos) throws InterruptedException {
        compraProductoPO.verificoQueSeVisualicenLosProductosIgualesAComprar(nombreProducto, cantidadProductos);
    }
}
