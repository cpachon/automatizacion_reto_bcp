package pe.bcp.reto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.ExtentTest;

import org.openqa.selenium.support.ui.Select;
import pe.bcp.reto.helpers.Helper;
import pe.bcp.reto.helpers.PageWeb;

public class PaginaPrincipalPage extends PageWeb {

    // Atributos
    private By oneWay;
    private By destino;
    private By ruta;
    private By tren;
    private By fchaida;
    private By nextmes;
 //   private By fchavuelta;
 //   private By cantPasajeros;
    private By clickBuscar;


    // Constructor
    public PaginaPrincipalPage(WebDriver driver, ExtentTest test, Boolean TAKE_SS, int seconds) {
        super(driver, test, TAKE_SS, seconds);

        this.oneWay = By.xpath("/html//div[@id='radioset']/div[2]/label/span");
        this.destino = By.id("destinoSelect");
        this.ruta = By.id("rutaSelect");
        this.tren = By.id("cbTrenSelect");
        this.fchaida = By.name("salida");
        this.nextmes = By.xpath("//span[contains(.,'Next')]");
       // this.fchavuelta = ;
      //  this.cantPasajeros = ;
        this.clickBuscar = By.id("btn_search");
    }
    // Metodos

    public void ingresoRutas (String lugarDestino, String rutaViaje, String tipoTren , String subDir)
    {
        Helper.addEvidence(TAKE_SS, driver, test, "Menu Busqueda Viaje", subDir, "ingresoRutas_01");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(oneWay))).click();

        Select destination = new Select(driver.findElement(destino));
        destination.selectByVisibleText(lugarDestino);

        Select route = new Select(driver.findElement(ruta));
        route.selectByVisibleText(rutaViaje);

        Select train = new Select(driver.findElement(tren));
        train.selectByVisibleText(tipoTren);

        Helper.addEvidence(TAKE_SS, driver, test, "Menu Busqueda Viaje", subDir, "ingresoRutas_02");


    }

    public void seleccionarCalendario () {
        driver.findElement(fchaida).click();

    }
    public void buscarMes () {
        driver.findElement(nextmes).click();

    }

    public void buscarDia () {

        String frdate ="27";
        driver.findElement(By.xpath("//td[not(contains(@class,'ui−datepicker− month'))]/a[text()='"+frdate+"']")).click();

    }

    public void diasSinCabinas () {
        String sindate ="2";
        driver.findElement(By.xpath("//td[not(contains(@class,'ui−datepicker− month'))]/a[text()='"+sindate+"']")).click();

    }
    public void clickBuscarViaje (String subDir)
    {
        Helper.waitSeconds(1);
        Helper.addEvidence(TAKE_SS, driver, test, "Menu Busqueda Viaje", subDir, "clickBuscarViaje_01");
        driver.findElement(clickBuscar).click();
    }

    public void fechaRuta2 (String subDir) {

        Actions act = new Actions(driver);
        //Double click on element
        WebElement ele = driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e'][contains(.,'Next')]"));
        act.doubleClick(ele).perform();
        String frdate ="28";
        driver.findElement(By.xpath("//td[not(contains(@class,'ui−datepicker− month'))]/a[text()='"+frdate+"']")).click();

        Helper.waitSeconds(1);
        Helper.addEvidence(TAKE_SS, driver, test, "Menu Busqueda Viaje", subDir, "fechaRuta2_01");
    }



    }


	

