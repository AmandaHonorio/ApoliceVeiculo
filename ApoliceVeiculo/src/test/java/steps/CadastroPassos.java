package steps;

import static org.junit.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.es.Dado;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Entao;
import pageObject.InsurantPage;
import pageObject.PricePage;
import pageObject.ProductPage;
import pageObject.SendQuotePage;
import pageObject.VehiclePage;

public class CadastroPassos {
	private WebDriver driver = null;
	private WebDriverWait wait = null;
	private VehiclePage vehiclePage = null;
	private InsurantPage insurantPage = null;
	private ProductPage productPage = null;
	private PricePage pricePage = null;
	private SendQuotePage sendQuotePage = null;

	@Dado("que o usuario esteja na aba Enter Vehicle Data da pagina tricentis")
	public void que_o_usuario_esteja_na_aba_enter_vehicle_data_da_pagina_tricentis() throws Exception {
		vehiclePage = new VehiclePage(driver, wait);
		
		vehiclePage.clicarMenuAutomobile();
		vehiclePage.verificarPagina();
		vehiclePage.verificarAba("Enter Vehicle Data");
	}
	@Quando("o usuario preencher os campos da tela Enter Vehicle Data")
	public void o_usuario_preencher_os_campos_da_tela_enter_vehicle_data(io.cucumber.datatable.DataTable dataTable) {
		vehiclePage.preencherCampos(dataTable);
	}

	@Quando("pressionar next da aba Enter Vehicle Data")
	public void pressionar_next_da_aba_enter_vehicle_data() {
		vehiclePage.clicarNext();
	}
	
	@Entao("sera exibida a aba Enter Insurant Data")
	public void sera_exibida_a_aba_enter_insurant_data() throws Exception {
		insurantPage = new InsurantPage(driver, wait);
		insurantPage.verificarAba("Enter Insurant Data");
	}
	
	@Quando("o usuario preencher os campos da tela Enter Insurant Data")
	public void o_usuario_preencher_os_campos_da_tela_enter_insurant_data(io.cucumber.datatable.DataTable dataTable) throws Exception {
	   insurantPage.preencherCampos(dataTable);
	}
	
	@Quando("pressionar next da aba Enter Insurant Data")
	public void pressionar_next_da_aba_enter_insurant_data() {
	    insurantPage.clicarNext();
	}
	
	@Entao("sera exibida a aba Enter Product Data")
	public void sera_exibida_a_aba_enter_product_data() throws Exception {
		productPage = new ProductPage(driver, wait);
		productPage.verificarAba("Enter Product Data");
	}
	
	@Quando("o usuario preencher os campos da tela Enter Product Data")
	public void o_usuario_preencher_os_campos_da_enter_product_data(io.cucumber.datatable.DataTable dataTable) throws Exception {
	   productPage.preencherCampos(dataTable);
	}
	
	@Quando("pressionar next da aba Enter Product Data")
	public void pressionar_next_da_aba_enter_product_data() {
	    productPage.clicarNext();

	}

	@Entao("sera exibida a aba Select Price Option")
	public void sera_exibida_a_aba_select_price_option() throws Exception {
		pricePage = new PricePage(driver, wait);
		pricePage.verificarAba("Select Price Option");
	}

	@Quando("o usuario selecionar a opcao de preco {string}")
	public void o_usuario_selecionar_a_op_o_de_preco(String string) throws Exception {
	    pricePage.preencherCampos(string);
	}

	@Quando("pressionar next da aba Select Price Option")
	public void pressionar_next_da_aba_select_price_option() {
	   pricePage.clicarNext();
	}

	@Entao("sera exibida a aba Send Quote")
	public void sera_exibida_a_aba_send_quote() throws Exception {
		sendQuotePage = new SendQuotePage(driver, wait);
		sendQuotePage.verificarAba("Send Quote");
	}

	@Quando("o usuario preencher os campos da tela Send Quote")
	public void o_usuario_preencher_os_campos_da_tela_send_quote(io.cucumber.datatable.DataTable dataTable) {
		sendQuotePage.preencherCampos(dataTable);
	}

	@Quando("pressionar Send")
	public void pressionar_send() {
		sendQuotePage.clicarSend();
	}

	@Entao("sera exibida uma mensage de sucesso {string}")
	public void ser_exibida_uma_mensage_de_sucesso(String string) {
		assertEquals(true, sendQuotePage.validarCadastroSucesso(string));
	}
	
	@Before
	public void iniciarDriver() {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 20);
		driver.get("http://sampleapp.tricentis.com/101/app.php");
	}

	@After
	public void fecharNavegador() {
		driver.quit();
	}
}
