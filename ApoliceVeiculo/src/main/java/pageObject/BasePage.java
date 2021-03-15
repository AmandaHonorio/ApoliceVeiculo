package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

	@FindBy(id = "selectedinsurance")
	protected WebElement lblSelectedInsurance;

	protected WebDriver driver = null;
	protected WebDriverWait wait;

	public BasePage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	protected void aguardarElemento(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void verificarPagina() {
		wait.until(ExpectedConditions.textToBePresentInElement(lblSelectedInsurance, "Automobile Insurance"));
	}
	
	public void verificarAba(String titulo) throws Exception {
		if (!driver.getTitle().equalsIgnoreCase(titulo)) {
			throw new Exception("Aba n�o encontrada!");
		}
	}
	
}
