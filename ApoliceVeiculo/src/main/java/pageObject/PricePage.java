package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PricePage extends BasePage {

	public PricePage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		PageFactory.initElements(super.driver, this);
	}

    @FindBy(xpath = "//input[@id='selectsilver']/../span[@class='ideal-radio']")
	private WebElement rdbSilver = null;

    @FindBy(xpath = "//input[@id='selectgold']/../span[@class='ideal-radio']")
	private WebElement rdbGold = null;

    @FindBy(xpath = "//input[@id='selectplatinum']/../span[@class='ideal-radio']")
	private WebElement rdbPlatinum = null;

    @FindBy(xpath = "//input[@id='selectultimate']/../span[@class='ideal-radio']")
	private WebElement rdbUltimate = null;

	@FindBy(id = "nextsendquote")
	private WebElement btnNext = null;

	public void preencherCampos(String plano) throws Exception {

		switch (plano.toLowerCase()) {
		case "silver":
			rdbSilver.click();
			break;
		case "gold":
			rdbSilver.click();
			break;
		case "platinum":
			rdbSilver.click();
			break;
		case "ultimate":
			rdbSilver.click();
			break;
		default:
			throw new Exception("Op��o de pre�o inv�lida!");
		}
	}
	
	public void clicarNext() {
		btnNext.click();
	}
}
