package pe.bcp.reto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pe.bcp.reto.helpers.Helper;
import pe.bcp.reto.helpers.PageWeb;


public class Paso2Page extends PageWeb {
    // Atributos
    //Cabina tipo doble
    private By dobleCabina;
    private By pasajerosCab2;
    private By clickContinuar;
    private By validarMaximoPasajeros;
    private By validarCabinasSuite;
    private By validarCabinaDoble;
    private By validarCabinaLitera;
    // Cabina tipo suite
    private By suiteCabina;
    private By pasajerosCab1;
    private By pasajerosCab2Adult;
    private By pasajeroChild;


    // Constructor
    public Paso2Page(WebDriver driver, ExtentTest test, Boolean TAKE_SS, int seconds) {
        super(driver, test, TAKE_SS, seconds);

        this.dobleCabina = By.name("selectRooms[twin]");
        this.pasajerosCab2 = By.name("selectRooms[twin][cabinas][cab1][adult]");
        this.clickContinuar = By.id("continuar_bae");
        this.validarMaximoPasajeros = By.xpath("//div[contains(@id,'sb-player')]");
        this.validarCabinasSuite = By.xpath("(//a[contains(.,'No cabins available for the selected date')])[1]");
        this.validarCabinaDoble = By.xpath("(//a[contains(.,'No cabins available for the selected date')])[2]");
        this.validarCabinaLitera = By.xpath("(//a[contains(.,'No cabins available for the selected date')])[3]");

        this.suiteCabina = By.name("selectRooms[suite]");
        this.pasajerosCab1 = By.name("selectRooms[suite][cabinas][cab1][adult]");
        this.pasajerosCab2Adult = By.name("selectRooms[suite][cabinas][cab2][adult]");
        this.pasajeroChild = By.name("selectRooms[suite][cabinas][cab2][nin]");


    }
    // Metodos

    public void cabinaDoble (String tipoCabina, String subDir)
    {
        Select cabins = new Select(driver.findElement(dobleCabina));
        cabins.selectByVisibleText(tipoCabina);
        Helper.addEvidence(TAKE_SS, driver, test, "Menu Busqueda Viaje", subDir, "cabinaDoble_01");
    }

    public void cabinaSuite (String selecCabina, String subDir)
    {
        Select cabins = new Select(driver.findElement(suiteCabina));
        cabins.selectByVisibleText(selecCabina);
        Helper.addEvidence(TAKE_SS, driver, test, "Menu Busqueda Viaje", subDir, "cabinaSuite_01");
    }

    public void cantidadDoble (String cantCabinDoble, String subDir) {
        Select passenger = new Select(driver.findElement(pasajerosCab2));
        passenger.selectByVisibleText(cantCabinDoble);
        Helper.addEvidence(TAKE_SS, driver, test, "Menu Busqueda Viaje", subDir, "cantidadDoble_01");

    }

    public void cantidadSuite (String cantCabinSuite1, String subDir) {
        Select passenger = new Select(driver.findElement(pasajerosCab1));
        passenger.selectByVisibleText(cantCabinSuite1);
        Helper.addEvidence(TAKE_SS, driver, test, "Menu Busqueda Viaje", subDir, "cabinaSuite_01");


    }

        public void clickContinuarPaso2 (String subDir)
    {

        Helper.addEvidence(TAKE_SS, driver, test, "Menu Busqueda Viaje", subDir, "clickContinuarPaso2_01");
        driver.findElement(clickContinuar).click();
    }


    public void assertPasajeros(String subDir) {

        Helper.addEvidence(TAKE_SS, driver, test, "Menu Busqueda Viaje", subDir, "assertPasajeros_01");
        Assert.assertTrue(driver.findElement(validarMaximoPasajeros).isDisplayed());

    }

    public void assertDisponibilidadCab(String subDir) {

        Helper.addEvidence(TAKE_SS, driver, test, "Menu Busqueda Viaje", subDir, "assertDisponibilidadCab_01");
        Assert.assertTrue(driver.findElement(validarCabinasSuite).isDisplayed());

        Helper.addEvidence(TAKE_SS, driver, test, "Menu Busqueda Viaje", subDir, "assertDisponibilidadCab_02");
        Assert.assertTrue(driver.findElement(validarCabinaDoble).isDisplayed());

        Helper.addEvidence(TAKE_SS, driver, test, "Menu Busqueda Viaje", subDir, "assertDisponibilidadCab_03");
        Assert.assertTrue(driver.findElement(validarCabinaLitera).isDisplayed());

    }

}
