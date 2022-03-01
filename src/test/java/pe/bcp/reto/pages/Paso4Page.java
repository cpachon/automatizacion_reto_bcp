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
    private By resumen;
    private By clickEnterCard;
    private By validarResumen;
    private By validarResumenRuta3;


    // Constructor
    public Paso4Page(WebDriver driver, ExtentTest test, Boolean TAKE_SS, int seconds) {
        super(driver, test, TAKE_SS, seconds);

        this.tipoPago = By.id("mastercard");
        this.clickEnterCard = By.id("ingresar_tarjeta");
        this.resumen = By.xpath("//a[@click='0'][contains(.,'purchase summary')]");
        this.validarResumen = By.xpath("//div[contains(@class,'cabecera-compra')]");
        this.validarResumenRuta3 = By.xpath("//div[@class='cabecera-compra'][contains(.,'Outbound Journey:')]");

    }

    // Metodos

    public void terminarCompra () {

        driver.findElement(tipoPago).click();
    }

    public void clickTarjeta (){
        driver.findElement(clickEnterCard);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }
    public void verResumen () {
        driver.findElement(resumen).click();
    }

    public void assertIngreso(String subDir) {

        Helper.addEvidence(TAKE_SS, driver, test, "Menu Busqueda Viaje", subDir, "assertIngreso_01");
        Assert.assertTrue(driver.findElement(validarResumen).isDisplayed());

    }

    public void assertResumen(String subDir) {

        Helper.addEvidence(TAKE_SS, driver, test, "Menu Busqueda Viaje", subDir, "assertResumen_01");
        Assert.assertTrue(driver.findElement(validarResumenRuta3).isDisplayed());

    }


}
