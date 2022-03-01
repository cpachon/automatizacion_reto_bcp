package pe.bcp.reto.pages;

import com.google.errorprone.annotations.Var;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;

import org.openqa.selenium.support.ui.Select;
import pe.bcp.reto.helpers.Helper;
import pe.bcp.reto.helpers.PageWeb;

import java.util.concurrent.TimeUnit;

public class Paso3Page extends PageWeb {

    private By nomPas1;
    private By apePas1;
    private By brPas1;
    private By monthPas1;
    private By nacPas1;
    private By idPas1;
    private By numIdPas1;
    private By sexPas1;
    private By telfPas1;
    private By mailPas1;
    private By confrPas1;

    private By nomPas2;
    private By apePas2;
    private By brPas2;
    private By yearPas2;
    private By nacPas2;
    private By idPas2;
    private By numIdPas2;
    private By sexPas2;
    private By telfPas2;
    private By mailPas2;
    private By confrPas2;

    private By clickReg2;
    private By clickContinuar3;

    private By nomPasCab1;
    private By apePasCab1;
    private By brPasCab1;
    private By yearPasCab1;
    private By nacPasCab1;
    private By idPasCab1;
    private By numIdPasCab1;
    private By sexPasCab1;
    private By telfPasCab1;
    private By mailPasCab1;
    private By confrPasCab1;





    // Constructor
    public Paso3Page(WebDriver driver, ExtentTest test, Boolean TAKE_SS, int seconds) {
        super(driver, test, TAKE_SS, seconds);
        this.nomPas1 = By.name("txt_nombre[twin][cab1][1]");
        this.apePas1 = By.name("txt_apellido[twin][cab1][1]");
        this.brPas1 = By.id("txt_fecha_nacimiento[twin][cab1][1]");
        this.monthPas1 = By.xpath("//select[@class='ui-datepicker-month']");
        this.nacPas1 = By.name("sel_nacion[twin][cab1][1]");
        this.idPas1 = By.name("sel_tpdoc[twin][cab1][1]");
        this.numIdPas1 = By.name("txt_nroid[twin][cab1][1]");
        this.sexPas1 = By.name("sel_sexo[twin][cab1][1]");
        this.telfPas1 = By.name("txt_telefono[twin][cab1][1]");
        this.mailPas1 = By.name("txt_mail[twin][cab1][1]");
        this.confrPas1 = By.name("txt_mail_conf[twin][cab1][1]");

        this.nomPas2 = By.name("txt_nombre[twin][cab1][2]");
        this.apePas2 = By.name("txt_apellido[twin][cab1][2]");
        this.brPas2 = By.id("txt_fecha_nacimiento[twin][cab1][2]");
        this.yearPas2 = By.xpath("//select[@class='ui-datepicker-year']");
        this.nacPas2 = By.name("sel_nacion[twin][cab1][2]");
        this.idPas2 = By.name("sel_tpdoc[twin][cab1][2]");
        this.numIdPas2 = By.name("txt_nroid[twin][cab1][2]");
        this.sexPas2 = By.name("sel_sexo[twin][cab1][2]");
        this.telfPas2 = By.name("txt_telefono[twin][cab1][2]");
        this.mailPas2 = By.name("txt_mail[twin][cab1][2]");
        this.confrPas2 = By.name("txt_mail_conf[twin][cab1][2]");

        this.clickReg2 = By.id("itm1-2");
        this.clickContinuar3 = By.id("btnContinuarPas");

        this.nomPasCab1 = By.name("txt_nombre[suite][cab1][1]");
        this.apePasCab1 = By.name("txt_apellido[suite][cab1][1]");
        this.brPasCab1 = By.id("txt_fecha_nacimiento[suite][cab1][1]");
        this.yearPasCab1 = By.xpath("//select[@class='ui-datepicker-year']");
        this.nacPasCab1 = By.name("sel_nacion[suite][cab1][1]");
        this.idPasCab1 = By.name("sel_tpdoc[suite][cab1][1]");
        this.numIdPasCab1 = By.name("txt_nroid[suite][cab1][1]");
        this.sexPasCab1 = By.name("sel_sexo[suite][cab1][1]");
        this.telfPasCab1 = By.name("txt_telefono[suite][cab1][1]");
        this.mailPasCab1 = By.name("txt_mail[suite][cab1][1]");
        this.confrPasCab1 = By.name("txt_mail_conf[suite][cab1][1]");




    }
        // Metodos

    public void datosBasicosPasajero1 (String nombre, String apellido, String subDir) {
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            // Registro pasajero 1
            driver.findElement(nomPas1).sendKeys(nombre);
            driver.findElement(apePas1).sendKeys(apellido);
        Helper.addEvidence(TAKE_SS, driver, test, "Menu Busqueda Viaje", subDir, "datosBasicosPasajero1_01");

        }

    public void fechaPasajero1 () {
        driver.findElement(brPas1).click();
        // choose month from dropdown
        WebElement n = driver.findElement(monthPas1);
        Select sel = new Select(n);
        sel.selectByVisibleText("Jul");
        String brdate = "23";
        driver.findElement(By.xpath("//td[not(contains(@class,'ui−datepicker− month'))]/a[text()='" + brdate + "']")).click();

    }

    public void datosPasajero1 (String pais, String tipoDocumento, String numeroDocumento, String sexo, String telefono, String correo, String confirmarCorreo, String subDir) {


        Select nacionalidad1 = new Select(driver.findElement(nacPas1));
        nacionalidad1.selectByVisibleText(pais);

        Select idpass1 = new Select(driver.findElement(idPas1));
        idpass1.selectByVisibleText(tipoDocumento);

        driver.findElement(numIdPas1).sendKeys(numeroDocumento);

        Select sexpass1 = new Select(driver.findElement(sexPas1));
        sexpass1.selectByVisibleText(sexo);

        driver.findElement(telfPas1).sendKeys(telefono);
        driver.findElement(mailPas1).sendKeys(correo);
        driver.findElement(confrPas1).sendKeys(confirmarCorreo);
        Helper.addEvidence(TAKE_SS, driver, test, "Menu Busqueda Viaje", subDir, "datosPasajero1_01");

    }

    public void datosBasicosPasajero2 (String nombre2, String apellido2) {

        // Registro pasajero 2
        driver.findElement(clickReg2).click();
        driver.findElement(nomPas2).sendKeys(nombre2);
        driver.findElement(apePas2).sendKeys(apellido2);
    }

    public void fechaPasajero2 () {

        driver.findElement(brPas2).click();
        // choose month from dropdown
        WebElement m = driver.findElement(yearPas2);
        Select sel2 = new Select(m);
        sel2.selectByVisibleText("1968");
        String brdate2 = "15";
        driver.findElement(By.xpath("//td[not(contains(@class,'ui-datepicker-year'))]/a[text()='" + brdate2 + "']")).click();
    }

    public void datosPasajero2 (String paisPas2, String tipoDocumentoPas2, String numeroDocumentoPas2, String sexoPas2, String telefonoPas2, String correoPas2, String confirmarCorreoPas2, String subDir) {

        Select nacionalidad2 = new Select(driver.findElement(nacPas2));
        nacionalidad2.selectByVisibleText(paisPas2);

        Select idpass2 = new Select(driver.findElement(idPas2));
        idpass2.selectByVisibleText(tipoDocumentoPas2);

        driver.findElement(numIdPas2).sendKeys(numeroDocumentoPas2);

        Select sexpass2 = new Select(driver.findElement(sexPas2));
        sexpass2.selectByVisibleText(sexoPas2);

        driver.findElement(telfPas2).sendKeys(telefonoPas2);
        driver.findElement(mailPas2).sendKeys(correoPas2);
        driver.findElement(confrPas2).sendKeys(confirmarCorreoPas2);
        Helper.addEvidence(TAKE_SS, driver, test, "Menu Busqueda Viaje", subDir, "datosPasajero2_01");
    }

    ////

    public void datosBasicosPasajero1Cab1 (String nom, String ape) {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        // Registro pasajero 1
        driver.findElement(nomPasCab1).sendKeys(nom);
        driver.findElement(apePasCab1).sendKeys(ape);

    }

    public void fechaPasajero1Cab1 () {
        driver.findElement(brPasCab1).click();
        // choose month from dropdown
        WebElement l = driver.findElement(yearPasCab1);
        Select sel2 = new Select(l);
        sel2.selectByVisibleText("1968");
        String brdate3 = "15";
        driver.findElement(By.xpath("//td[not(contains(@class,'ui-datepicker-year'))]/a[text()='" + brdate3 + "']")).click();

    }

    public void datosPasajero1Cab1 (String pais3, String tipoDocumento3, String numeroDocumento3, String sexo3, String telefono3, String correo3, String confirmarCorreo3, String subDir) {


        Select nacionalidad3 = new Select(driver.findElement(nacPasCab1));
        nacionalidad3.selectByVisibleText(pais3);

        Select idpass3 = new Select(driver.findElement(idPasCab1));
        idpass3.selectByVisibleText(tipoDocumento3);

        driver.findElement(numIdPasCab1).sendKeys(numeroDocumento3);

        Select sexpass3 = new Select(driver.findElement(sexPasCab1));
        sexpass3.selectByVisibleText(sexo3);

        driver.findElement(telfPasCab1).sendKeys(telefono3);
        driver.findElement(mailPasCab1).sendKeys(correo3);
        driver.findElement(confrPasCab1).sendKeys(confirmarCorreo3);
        Helper.addEvidence(TAKE_SS, driver, test, "Menu Busqueda Viaje", subDir, "datosPasajero1Cab1_01");

    }


        public void clickContinuarPaso3 ()
        {

            driver.findElement(clickContinuar3).click();
        }


    }




