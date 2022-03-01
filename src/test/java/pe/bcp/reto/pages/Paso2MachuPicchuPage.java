package pe.bcp.reto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.ExtentTest;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pe.bcp.reto.helpers.Helper;
import pe.bcp.reto.helpers.PageWeb;

import java.util.concurrent.TimeUnit;

public class Paso2MachuPicchuPage extends PageWeb {

    // Atributos
    private By pasajeIda;
    private By pasajeVuelta;
    private By clickContinuarCompra;


    // Constructor
    public Paso2MachuPicchuPage(WebDriver driver, ExtentTest test, Boolean TAKE_SS, int seconds) {
        super(driver, test, TAKE_SS, seconds);

        this.pasajeIda = By.id("div_2021010505_10");
        this.pasajeVuelta = By.id("div_2021012820_11");
        this.clickContinuarCompra = By.xpath("//input[@class='btn  btn-continuar']");

    }

    // Metodos

    public void escogerIda (String subDir) {

        Helper.addEvidence(TAKE_SS, driver, test, "Menu Busqueda Viaje", subDir, "escogerIda _01");
        driver.findElement(pasajeIda).click();
    }

    public void escogerRegreso (String subDir) {

        driver.findElement(pasajeVuelta).click();
        Helper.addEvidence(TAKE_SS, driver, test, "Menu Busqueda Viaje", subDir, "escogerRegreso_01");
    }

    public void clickContinuarPaso3 (String subDir) {

        driver.findElement(clickContinuarCompra).click();
        Helper.addEvidence(TAKE_SS, driver, test, "Menu Busqueda Viaje", subDir, "clickContinuarPaso301");
    }


}
