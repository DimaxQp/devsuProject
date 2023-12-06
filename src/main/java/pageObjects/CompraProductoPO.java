package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class CompraProductoPO extends Base_PO {
    public CompraProductoPO() {
        super();
    }

    // Definicion de elementos
    private @FindBy(xpath = "//a[text()='Add to cart']")
    WebElement btn_agregarCarrito;
    private @FindBy(xpath = "//a[@id='cartur']")
    WebElement menu_carrito;
    private @FindBy(xpath = "//button[@class='btn btn-success']")
    WebElement btn_placeOrder;
    private @FindBy(xpath = "//input[@id='name']")
    WebElement campo_nombreCliente;
    private @FindBy(xpath = "//input[@id='country']")
    WebElement campo_paisCliente;
    private @FindBy(xpath = "//input[@id='city']")
    WebElement campo_ciudadCliente;
    private @FindBy(xpath = "//input[@id='card']")
    WebElement campo_tarjetaCliente;
    private @FindBy(xpath = "//input[@id='month']")
    WebElement campo_mesTarjeta;
    private @FindBy(xpath = "//input[@id='year']")
    WebElement campo_anioTarjeta;
    private @FindBy(xpath = "//button[text()='Purchase']")
    WebElement btn_purchase;
    private @FindBy(xpath = "//h2[text()='Thank you for your purchase!']")
    WebElement txt_graciasCompra;
    WebElement filtro_Categoria;

    private WebElement filtroCategoria(String categoriaProducto) {
        String xpathFiltroCategoria = String.format("//a[text()='%s']", categoriaProducto);
        filtro_Categoria = getDriver().findElement(By.xpath(xpathFiltroCategoria));
        return filtro_Categoria;
    }

    WebElement producto_Nombre;

    private WebElement productoNombre(String categoriaProducto) {
        String xpathProductoNombre = String.format("//a[text()='%s']", categoriaProducto);
        producto_Nombre = getDriver().findElement(By.xpath(xpathProductoNombre));
        return producto_Nombre;
    }

    WebElement td_NombreProductoEnCarrito;
    private WebElement tdNombreProductoEnCarrito(String NombreProducto) {
        String xpathTdNombreProductoEnCarrito = String.format("//td[text()='%s']", NombreProducto);
        td_NombreProductoEnCarrito = getDriver().findElement(By.xpath(xpathTdNombreProductoEnCarrito));
        return td_NombreProductoEnCarrito;
    }
    WebElement tdNombresProductosEnCarrito;
    private By tdNombresProductosEnCarrito(String NombreProductos) {
        return By.xpath(String.format("//td[text()='%s']", NombreProductos));
    }

    private List<WebElement> nombresProductosEnCarrito(String NombreProductos) {
        String xpathNombresProductosEnCarrito = String.format("//td[text()='%s']", NombreProductos);
        return getDriver().findElements(By.xpath(xpathNombresProductosEnCarrito));
    }

    // Definicion de metodos

    public void seleccionoLaCategoriaAFiltrar(String categoriaProducto) {
        waitForWebElementAndClick(filtroCategoria(categoriaProducto));
    }

    public void seleccionoElProductoAComprar(String categoriaProducto) {
        waitForWebElementAndClick(productoNombre(categoriaProducto));
    }

    public void hagoClickEnAgregarAlCarrito() {
        waitForWebElementAndClick(btn_agregarCarrito);
    }

    public void hagoClickEnElMenuCarrito() {
        waitForWebElementAndClick(menu_carrito);
        acceptAlert();
    }

    public void verificoQueSeVisualiceElProductoAComprar(String nombreProducto) {
        isVisibleElement(tdNombreProductoEnCarrito(nombreProducto), 5);
    }

    public void hagoClickEnElBotonPlaceOrder() {
        waitForWebElementAndClick(btn_placeOrder);
    }

    public void completoCampoNombrePlaceOrder(String nombreCliente) {
        sendKeys(campo_nombreCliente, nombreCliente);
    }

    public void completoCampoCountryPlaceOrder(String paisCliente) {
        sendKeys(campo_paisCliente, paisCliente);
    }

    public void completoCampoCityPlaceOrder(String ciudadCliente) {
        sendKeys(campo_ciudadCliente, ciudadCliente);
    }

    public void completoCampoCreditCardPlaceOrder(String tarjetaCliente) {
        sendKeys(campo_tarjetaCliente, tarjetaCliente);
    }

    public void completoCampoMonthPlaceOrder(String mesTarjeta) {
        sendKeys(campo_mesTarjeta, mesTarjeta);
    }

    public void completoCampoYearPlaceOrder(String anioTarjeta) {
        sendKeys(campo_anioTarjeta, anioTarjeta);
    }

    public void hagoClickEnBotonPurchase() {
        waitForWebElementAndClick(btn_purchase);
    }

    public void validoConfirmacionDeLaCompra() {
        isVisibleElement(txt_graciasCompra, 5);
        Assert.assertEquals(txt_graciasCompra.getText(), "Thank you for your purchase!");
    }

    public void seleccionoElSegundoProductoAComprar(String categoriaProducto2) {
        waitForWebElementAndClick(productoNombre(categoriaProducto2));
    }

    public void verificoQueSeVisualicenLosProductosAComprar(String nombreProducto1, String nombreProducto2) {
        isVisibleElement(tdNombreProductoEnCarrito(nombreProducto1), 5);
        isVisibleElement(tdNombreProductoEnCarrito(nombreProducto2), 5);
    }
    public void verificoQueSeVisualicenLosProductosIgualesAComprar(String nombreProducto, int cantidadProductos) {
        EsperarElementosMinimos(tdNombresProductosEnCarrito(nombreProducto),cantidadProductos);
        Assert.assertEquals(nombresProductosEnCarrito(nombreProducto).size(),cantidadProductos,"No se encontraron dos registros con el mismo producto'");

    }
}
