package pe.bcp.reto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;

import org.openqa.selenium.support.ui.Select;
import pe.bcp.reto.helpers.Helper;
import pe.bcp.reto.helpers.PageWeb;


public class Paso3MachuPicchuPage extends PageWeb {

    private By nomPassAdult;
    private By apePassAdult;
    private By caldPassAdult;
    private By monthPassAdult;
    private By nacPassAdult;
    private By tipDocumenAdult;
    private By numIdPassAdult;
    private By sexPassAdult;
    private By telfPassAdult;
    private By mailPassAdult;
    private By confrMailPassAdul;
    private By selNovedades;
    private By irPago;


    // Constructor
    public Paso3MachuPicchuPage(WebDriver driver, ExtentTest test, Boolean TAKE_SS, int seconds) {
        super(driver, test, TAKE_SS, seconds);

    this.nomPassAdult = By.id("formPasajero1-nomPasajero");
    this.apePassAdult = By.id("formPasajero1-apePasajero");
    this.caldPassAdult = By.id("formPasajero1-fecNacimiento");
    this.monthPassAdult = By.xpath("//select[contains(@id,'calendario_mes')]");
    this.nacPassAdult = By.id("formPasajero1-idPais");
    this.tipDocumenAdult = By.id("formPasajero1-idDocumentoIdentidad");
    this.numIdPassAdult = By.id("formPasajero1-numDocumentoIdentidad");
    this.sexPassAdult = By.id("formPasajero1-idSexo");
    this.telfPassAdult = By.id("formPasajero1-numTelefono");
    this.mailPassAdult = By.id("formPasajero1-desEmail");
    this.confrMailPassAdul = By.id("formPasajero1-desEmailConfirmacion");

    this.selNovedades = By.id("formPasajero1-recibirNovedades");
    this.irPago = By.xpath("//input[contains(@id,'enviarPago')]");

    }

    public void datosBasicosPass (String nombreAdult, String apellidoAdult, String subDir) {

        // Registro pasajero 1
        driver.findElement(nomPassAdult).sendKeys(nombreAdult);
        driver.findElement(apePassAdult).sendKeys(apellidoAdult);
        Helper.addEvidence(TAKE_SS, driver, test, "Menu Busqueda Viaje", subDir, "datosBasicosPass_01");

    }

    public void fechaPass () {
        driver.findElement(caldPassAdult).click();
        // choose month from dropdown
        WebElement n = driver.findElement(monthPassAdult);
        Select sel = new Select(n);
        sel.selectByVisibleText("APRIL");
        String brdate ="29";
        driver.findElement(By.xpath("//td[not(contains(@class,'ui−datepicker− month'))]/a[text()='"+brdate+"']")).click();

    }

    public void datosPass (String paisAdult, String tipoDocumentoAdult, String numeroDocumentoAdult, String sexoAdult, String telefonoAdult, String correoAdult, String confirmarCorreoAdult, String subDir) {


        Select nacionalidad1 = new Select(driver.findElement(nacPassAdult));
        nacionalidad1.selectByVisibleText(paisAdult);

        Select idpass1 = new Select(driver.findElement(tipDocumenAdult));
        idpass1.selectByVisibleText(tipoDocumentoAdult);

        driver.findElement(numIdPassAdult).sendKeys(numeroDocumentoAdult);

        Select sexpass1 = new Select(driver.findElement(sexPassAdult));
        sexpass1.selectByVisibleText(sexoAdult);

        driver.findElement(telfPassAdult).sendKeys(telefonoAdult);
        driver.findElement(mailPassAdult).sendKeys(correoAdult);
        driver.findElement(confrMailPassAdul).sendKeys(confirmarCorreoAdult);
        Helper.addEvidence(TAKE_SS, driver, test, "Menu Busqueda Viaje", subDir, "datosPass_01");

    }

    public void clickNovedades (String subDir)
    {

        driver.findElement(selNovedades).click();
        Helper.addEvidence(TAKE_SS, driver, test, "Menu Busqueda Viaje", subDir, "clickCheckNovedades_01");
    }

    public void clickPaso (String subDir)
    {

        driver.findElement(irPago).click();
        Helper.addEvidence(TAKE_SS, driver, test, "Menu Busqueda Viaje", subDir, "clickCheckNovedades_01");
    }

}
