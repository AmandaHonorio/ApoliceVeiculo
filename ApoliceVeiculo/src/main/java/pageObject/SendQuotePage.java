package pageObject;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;

public class SendQuotePage extends BasePage {
//	@FindBy(id = ")
//	private WebElement ;

	public SendQuotePage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		PageFactory.initElements(super.driver, this);
	}

	@FindBy(id = "email")
	private WebElement txtEmail = null;

	@FindBy(id = "username")
	private WebElement txtUsername = null;

	@FindBy(name = "Password") // Tratei pelo name, mas o correto seria o id ser password e n�o username.
	private WebElement txtPassword = null;

	@FindBy(id = "confirmpassword")
	private WebElement txtConfirmPassword = null;

	@FindBy(id = "sendemail")
	private WebElement btnSend = null;

	@FindBy(xpath = "//div[@class='sweet-alert showSweetAlert visible']/h2")
	private WebElement h2Messagem = null;

	public void preencherCampos(DataTable tabela) {

		List<Map<String, String>> rows = tabela.asMaps(String.class, String.class);
		Map<String, String> linha = rows.get(0);

		aguardarElemento(txtEmail);
		txtEmail.sendKeys(linha.get("E-Mail"));

		aguardarElemento(txtUsername);
		txtUsername.sendKeys(linha.get("Username"));

		aguardarElemento(txtPassword);
		txtPassword.sendKeys(linha.get("Password"));

		aguardarElemento(txtConfirmPassword);
		txtConfirmPassword.sendKeys(linha.get("Confirm Password"));
	}

	public void clicarSend() {
		aguardarElemento(btnSend);
		btnSend.click();
	}

	public boolean validarCadastroSucesso(String mensagem) {
		aguardarElemento(h2Messagem);
		if (h2Messagem.getText().equalsIgnoreCase(mensagem)) {
			return true;
		}
		return false;
	}
}
