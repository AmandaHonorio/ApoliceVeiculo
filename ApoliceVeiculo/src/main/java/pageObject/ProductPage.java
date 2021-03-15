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

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver, WebDriverWait wait) {
    super(driver, wait);
    PageFactory.initElements(super.driver, this);
    }

    @FindBy(id = "startdate")
    private WebElement dateStartDate;

    @FindBy(id = "insurancesum")
    private WebElement selInsuranceSum;

    @FindBy(id = "meritrating")
    private WebElement selMeritRating;

    @FindBy(id = "damageinsurance")
    private WebElement selDamageInsurance;

    // Optional products
    @FindBy(xpath = "//input[@id='EuroProtection']/..")
    private WebElement rdbEuroProtection;

    @FindBy(xpath = "//input[@id='LegalDefenseInsurance']/..")
    private WebElement rdbLegalDefenseInsurance;
    //

    @FindBy(id = "courtesycar")
    private WebElement selCourtesyCar;

    @FindBy(id = "nextselectpriceoption")
    private WebElement btnNext;

    public void preencherCampos(DataTable tabela) throws Exception {

        List<Map<String, String>> rows = tabela.asMaps(String.class, String.class);
        Map<String, String> linha = rows.get(0);
        Select select;

        aguardarElemento(dateStartDate);
        dateStartDate.sendKeys(linha.get("Start Date"));

        aguardarElemento(selInsuranceSum);
        select = new Select(selInsuranceSum);
        select.selectByValue(linha.get("Insurance Sum"));

        aguardarElemento(selMeritRating);
        select = new Select(selMeritRating);
        select.selectByValue(linha.get("Merit Rating"));

        aguardarElemento(selDamageInsurance);
        select = new Select(selDamageInsurance);
        select.selectByValue(linha.get("Damage Insurance"));

        switch (linha.get("Optional Products").toLowerCase()) {
            case "euro protection":
                aguardarElemento(rdbEuroProtection);
                rdbEuroProtection.click();
                break;
            case "legal defense insurance":
                aguardarElemento(rdbLegalDefenseInsurance);
                rdbLegalDefenseInsurance.click();
                break;
            default:
                throw new Exception("Opção de produto inválida!");
        }

        aguardarElemento(selCourtesyCar);
        select = new Select(selCourtesyCar);
        select.selectByValue(linha.get("Courtesy Car"));
    }

    public void clicarNext(){
        aguardarElemento(btnNext);
        btnNext.click();
    }
}