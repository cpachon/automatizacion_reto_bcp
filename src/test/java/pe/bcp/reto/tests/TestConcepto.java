package pe.bcp.reto.tests;

import java.io.File;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pe.bcp.reto.helpers.Helper;
import pe.bcp.reto.pages.*;


public class TestConcepto {
	private WebDriver driver;
	private ExtentReports extent;
	private ExtentTest test;
	private static String SUBDIR = "AmbienteBase\\";
	private static Boolean TAKE_SS = true;
	private static int WAITING = 10;

	@BeforeSuite
	public void configExtentReports() {
		// ExtentReports config
		this.extent = new ExtentReports("ExtentReports/RetoTecnico.html", true);
		this.extent.addSystemInfo("Host Name", "BPC Reto Tecnico");
		this.extent.addSystemInfo("Enviroment", "Automation Testing");
		this.extent.addSystemInfo("User Name", "Carmen Pachon");
		//llamada a objeto de configuracion de Extent report
		File conf = new File("src/test/resources/extentReports/" + "extent-config.xml");
		this.extent.loadConfig(conf);
	}

	@BeforeMethod
	public void configSelenium() {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("Reto", "BCP");
		Helper.robotMoveMouse(2000, 2000);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//Navegar a url principal
		driver.navigate().to("https://www.perurail.com/");
	}

	@Test
	public void Ruta1() {
		String subDir = SUBDIR + Thread.currentThread().getStackTrace()[1].getMethodName();
		test = extent.startTest("Prueba CONCEPTO más", "Probando conceptos MáS.");
		test.log(LogStatus.INFO, "Prueba inicial conceptos");
		PaginaPrincipalPage buscar = new PaginaPrincipalPage(driver, test, TAKE_SS, 15);
		buscar.seleccionarViaje(subDir);
		buscar.ingresoRutas("Cusco", "Puno > Cusco");
		buscar.seleccionarTren("Andean Explorer, A Belmond Train", subDir);
		buscar.seleccionarCalendario();
		buscar.buscarMes();
		buscar.buscarDia();
		buscar.clickBuscarViaje(subDir);
		Paso2Page paso2 = new Paso2Page(driver, test, TAKE_SS, 15);
		paso2.cabinaDoble("1 CABIN", subDir);
		paso2.cantidadDoble("2", subDir);
		paso2.clickContinuarPaso2(subDir);
		Paso3Page paso3 = new Paso3Page(driver, test, TAKE_SS, 15);
		paso3.datosBasicosPasajero1("Maria", "Caro", subDir);
		paso3.fechaPasajero1();
		paso3.datosPasajero1("Venezuela", "Passport", "098111123","Female","0987009", "correo1@ejemplo.com", "correo1@ejemplo.com", subDir);
		paso3.datosBasicosPasajero2("Juan", "Perez");
		paso3.fechaPasajero2();
		paso3.datosPasajero2("Colombia", "Passport", "AW233456", "Male", "7645334", "correo2@ejemplo.com", "correo2@ejemplo.com", subDir);
		paso3.clickContinuarPaso3();
		Paso4Page paso4 = new Paso4Page(driver, test, TAKE_SS, 15);
		paso4.terminarCompra();
		paso4.clickTarjeta();
		paso4.verResumen();
		paso4.assertIngreso(subDir);

	}

	@Test
	public void MaximoPasajero() {
		String subDir = SUBDIR + Thread.currentThread().getStackTrace()[1].getMethodName();
		test = extent.startTest("Prueba CONCEPTO más", "Probando conceptos MáS.");
		test.log(LogStatus.INFO, "Prueba inicial conceptos");
		PaginaPrincipalPage buscar = new PaginaPrincipalPage(driver, test, TAKE_SS, 15);
		buscar.seleccionarViaje(subDir);
		buscar.ingresoRutas("Cusco", "Puno > Cusco");
		buscar.seleccionarTren("Andean Explorer, A Belmond Train", subDir);
		buscar.seleccionarCalendario();
		buscar.buscarMes();
		buscar.buscarDia();
		buscar.clickBuscarViaje(subDir);
		Paso2Page paso2 = new Paso2Page(driver, test, TAKE_SS, 15);
		paso2.cabinaDoble("9 CABINS", subDir);
		paso2.assertPasajeros(subDir);
	}

	@Test
	public void disponibilidadCabina() {
		String subDir = SUBDIR + Thread.currentThread().getStackTrace()[1].getMethodName();
		test = extent.startTest("Prueba CONCEPTO más", "Probando conceptos MáS.");
		test.log(LogStatus.INFO, "Prueba inicial conceptos");
		PaginaPrincipalPage buscar = new PaginaPrincipalPage(driver, test, TAKE_SS, 15);
		buscar.seleccionarViaje(subDir);
		buscar.ingresoRutas("Cusco", "Puno > Cusco");
		buscar.seleccionarTren("Andean Explorer, A Belmond Train", subDir);
		buscar.seleccionarCalendario();
		buscar.diasSinCabinas();
		buscar.clickBuscarViaje(subDir);
		Paso2Page paso2 = new Paso2Page(driver, test, TAKE_SS, 15);
		paso2.assertDisponibilidadCab(subDir);
	}

	@Test
	public void Ruta2() {
		String subDir = SUBDIR + Thread.currentThread().getStackTrace()[1].getMethodName();
		test = extent.startTest("Prueba CONCEPTO más", "Probando conceptos MáS.");
		test.log(LogStatus.INFO, "Prueba inicial conceptos");
		PaginaPrincipalPage buscar = new PaginaPrincipalPage(driver, test, TAKE_SS, 15);
		buscar.seleccionarViaje(subDir);
		buscar.ingresoRutas("Cusco", "Arequipa > Puno > Cusco");
		buscar.seleccionarTren("Andean Explorer, A Belmond Train", subDir);
		buscar.seleccionarCalendario();
		buscar.fechaRuta2(subDir);
		buscar.clickBuscarViaje(subDir);
		Paso2Page paso2 = new Paso2Page(driver, test, TAKE_SS, 15);
		paso2.cabinaSuite("1 CABIN", subDir);
		paso2.cantidadSuite("1", subDir);
		paso2.clickContinuarPaso2(subDir);
		Paso3Page paso3 = new Paso3Page(driver, test, TAKE_SS, 15);
		paso3.datosBasicosPasajero1Cab1("Mario", "Caro");
		paso3.fechaPasajero1Cab1();
		paso3.datosPasajero1Cab1("Venezuela", "Passport", "098234756", "Female","456798763", "correo3@ejemplo.com", "correo3@ejemplo.com" , subDir);
		paso3.clickContinuarPaso3();
		Paso4Page paso4 = new Paso4Page(driver, test, TAKE_SS, 15);
		paso4.terminarCompra();
		paso4.clickTarjeta();
		paso4.verResumen();
		paso4.assertIngreso(subDir);

	}

	@Test
	public void Ruta3() {
		String subDir = SUBDIR + Thread.currentThread().getStackTrace()[1].getMethodName();
		test = extent.startTest("Prueba CONCEPTO más", "Probando conceptos MáS.");
		test.log(LogStatus.INFO, "Prueba inicial conceptos");
		PaginaPrincipalPage buscar = new PaginaPrincipalPage(driver, test, TAKE_SS, 15);
		buscar.ingresoRutas("Machu Picchu", "Cusco > Machu Picchu");
		buscar.seleccionarCalendario();
		buscar.buscarDiaIdayVuelta();
		buscar.seleccionarPasajeros();
		buscar.seleccionarPassRuta3();
		buscar.clickBuscarViaje(subDir);
		Paso2MachuPicchuPage paso2 = new Paso2MachuPicchuPage(driver, test, TAKE_SS, 15);
		paso2.escogerIda(subDir);
		paso2.escogerRegreso(subDir);
		paso2.clickContinuarPaso3(subDir);
		Paso3MachuPicchuPage paso3 = new Paso3MachuPicchuPage(driver, test, TAKE_SS, 15);
		paso3.datosBasicosPass("Julio", "Perez", subDir);
		paso3.fechaPass();
		paso3.datosPass("Argentina", "Identification Card", "43251826", "Male", "0987009", "correo1@ejemplo.com", "correo1@ejemplo.com", subDir);
		paso3.clickNovedades(subDir);
		paso3.clickPaso(subDir);
		Paso4Page paso4 = new Paso4Page(driver, test, TAKE_SS, 15);
		paso4.terminarCompra();
		paso4.assertResumen(subDir);

	}




	@AfterMethod
	public void afterMethod(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, "Test failed.- <br>" + result.getThrowable());
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP, "Test skipped.- <br>" + result.getThrowable());
		} else {
			test.log(LogStatus.PASS, "Test passed.-");
		}
		// driver.close();
		extent.endTest(test);
	}

	@AfterSuite
	public void closeExtentReports() {
		// Escribimos los datos al reporte.
		extent.flush();
	}
}
