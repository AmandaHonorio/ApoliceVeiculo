package pageObject;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;

public class VehiclePage extends BasePage {
	@FindBy(id = "nav_automobile")
	private WebElement menuAutomobile;

	@FindBy(id = "make")
	private WebElement selMake;

	@FindBy(id = "engineperformance")
	private WebElement txtEnginePerformance;

	@FindBy(id = "dateofmanufacture")
	private WebElement txtDateOfManufacture;

	@FindBy(id = "numberofseats")
	private WebElement selNumberOfSeats;

	@FindBy(id = "fuel")
	private WebElement selFuel;

	@FindBy(id = "listprice")
	private WebElement txtListPrice;

	@FindBy(id = "licenseplatenumber")
	private WebElement txtLicensePlateNumber;

	@FindBy(id = "annualmileage")
	private WebElement txtAnnualMileage;

	@FindBy(id = "nextenterinsurantdata")
	private WebElement btnNext;

	public VehiclePage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		PageFactory.initElements(super.driver, this);
	}

	public void clicarMenuAutomobile() {
		aguardarElemento(menuAutomobile);
		menuAutomobile.click();
	}

	public void preencherCampos(DataTable tabela) {
		List<Map<String, String>> rows = tabela.asMaps(String.class, String.class);
		Map<String, String> linha = rows.get(0);
		Select select;

		aguardarElemento(selMake);
		select = new Select(selMake);
		select.selectByValue(linha.get("Make"));

		aguardarElemento(txtEnginePerformance);
		txtEnginePerformance.sendKeys(linha.get("Engine Performance"));

		aguardarElemento(txtDateOfManufacture);
		txtDateOfManufacture.sendKeys(linha.get("Date of Manufacture"));

		aguardarElemento(selNumberOfSeats);
		select = new Select(selNumberOfSeats);
		select.selectByValue(linha.get("Number of Seats"));

		aguardarElemento(selFuel);
		select = new Select(selFuel);
		select.selectByValue(linha.get("Fuel Type"));

		aguardarElemento(txtListPrice);
		txtListPrice.sendKeys(linha.get("List Price"));

		aguardarElemento(txtLicensePlateNumber);
		txtLicensePlateNumber.sendKeys(linha.get("License Plate Number"));

		aguardarElemento(txtAnnualMileage);
		txtAnnualMileage.sendKeys(linha.get("Annual Mileage"));
	}

	public void clicarNext() {
		aguardarElemento(btnNext);
		btnNext.click();
	}
}
