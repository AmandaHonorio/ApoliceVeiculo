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

public class InsurantPage extends BasePage {

    public InsurantPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(super.driver, this);
    }

    @FindBy(id = "firstname")
    private WebElement txtFirstName;

    @FindBy(id = "lastname")
    private WebElement txtLastName;

    @FindBy(id = "birthdate")
    private WebElement dateBirthdate;

    @FindBy(xpath = "//input[@id='gendermale']/../span[@class='ideal-radio']")
    private WebElement rdbGenderMale;

    @FindBy(xpath = "//input[@id='genderfemale']/../span[@class='ideal-radio']")
    private WebElement rdbGenderFemale;

    @FindBy(id = "streetaddress")
    private WebElement txtstreetaddress;

    @FindBy(id = "country")
    private WebElement selcountry;

    @FindBy(id = "zipcode")
    private WebElement txtzipcode;

    @FindBy(id = "city")
    private WebElement txtcity;

    @FindBy(id = "occupation")
    private WebElement seloccupation;

    // hobbies
    @FindBy(xpath = "//input[@id='speeding']/..")
    private WebElement chkSpeeding;

    @FindBy(xpath = "//input[@id='bungeejumping']/..")
    private WebElement chkBungeeJumping;

    @FindBy(xpath = "//input[@id='cliffdiving']/..")
    private WebElement chkCliffDiving;

    @FindBy(xpath = "//input[@id='skydiving']/..")
    private WebElement chkSkydiving;

    @FindBy(xpath = "//input[@id='other']/..")
    private WebElement chkOther;
    //

    @FindBy(id = "website")
    private WebElement txtWebsite;

    @FindBy(id = "nextenterproductdata")
    private WebElement btnNext;

    public void preencherCampos(DataTable tabela) throws Exception {
        List<Map<String, String>> rows = tabela.asMaps(String.class, String.class);
        Map<String, String> linha = rows.get(0);
        Select select;

        aguardarElemento(btnNext);
        txtFirstName.sendKeys(linha.get("First Name"));

        aguardarElemento(btnNext);
        txtLastName.sendKeys(linha.get("Last Name"));

        aguardarElemento(btnNext);
        dateBirthdate.sendKeys(linha.get("Date of Birth"));

        // selecionar genero
        if (linha.get("Gender").equalsIgnoreCase("male")) {
            aguardarElemento(btnNext);
            rdbGenderMale.click();
        } else if (linha.get("Gender").toLowerCase() == "female") {
            aguardarElemento(btnNext);
            rdbGenderFemale.click();
        } else {
            throw new Exception("Opção de sexo inválida!");
        }

        aguardarElemento(btnNext);
        txtstreetaddress.sendKeys(linha.get("Street Address"));

        aguardarElemento(btnNext);
        select = new Select(selcountry);
        select.selectByValue(linha.get("Country"));

        aguardarElemento(btnNext);
        txtzipcode.sendKeys(linha.get("Zip Code"));

        aguardarElemento(btnNext);
        txtcity.sendKeys(linha.get("City"));

        aguardarElemento(btnNext);
        select = new Select(seloccupation);
        select.selectByValue(linha.get("Occupation"));

        // selecionar hobbies
        switch (linha.get("Hobbies").toLowerCase()) {
            case "speeding":
                aguardarElemento(chkSpeeding);
                chkSpeeding.click();
                break;
            case "bungeejumping":
                aguardarElemento(chkBungeeJumping);
                chkBungeeJumping.click();
                break;
            case "cliffdiving":
                aguardarElemento(chkCliffDiving);
                chkCliffDiving.click();
                break;
            case "skydiving":
                aguardarElemento(chkSkydiving);
                chkSkydiving.click();
                break;
            case "other":
                aguardarElemento(chkOther);
                chkOther.click();
                break;
            default:
                throw new Exception("Opção de hobbie inválida!");
        }

        aguardarElemento(txtWebsite);
        txtWebsite.sendKeys(linha.get("Website"));
    }

    public void clicarNext(){
        aguardarElemento(btnNext);
        btnNext.click();
    }
}