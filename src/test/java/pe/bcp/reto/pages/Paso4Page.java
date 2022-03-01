package pe.bcp.reto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.ExtentTest;

import org.openqa.selenium.support.ui.Select;
import pe.bcp.reto.helpers.Helper;
import org.testng.Assert;
import pe.bcp.reto.helpers.PageWeb;

import java.util.concurrent.TimeUnit;

public class Paso4Page extends PageWeb {

    // Atributos
    private By tipoPago;
    private By agree;
    private By resumen;
    private By clickEnterCard;
    private By validarResumen;


    // Constructor
    public Paso4Page(WebDriver driver, ExtentTest test, Boolean TAKE_SS, int seconds) {
        super(driver, test, TAKE_SS, seconds);

        this.tipoPago = By.id("mastercard");
        this.agree = By.name("tipo-manera");
        this.clickEnterCard = By.id("ingresar_tarjeta");
        this.resumen = By.xpath("//a[@click='0'][contains(.,'purchase summary')]");
        this.validarResumen = By.xpath("//div[contains(@class,'cabecera-compra')]");

    }

    // Metodos

    public void terminarCompra () {

        driver.findElement(tipoPago).click();
        driver.findElement(agree).click();
        driver.findElement(clickEnterCard);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(resumen).click();
    }

    public void assertIngreso(String subDir) {

        Helper.addEvidence(TAKE_SS, driver, test, "Menu Busqueda Viaje", subDir, "assertIngreso_01");
        Assert.assertTrue(driver.findElement(validarResumen).isDisplayed());

    }



}
