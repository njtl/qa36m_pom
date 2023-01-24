package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ContactsPage extends PageBase{

    public ContactsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "/html/body/app-root/app-home-page/app-header/nav/div/div[2]/button[2]")
    WebElement logOutButton;

    @FindBy(xpath = "//a[contains(text(),'Contacts')]")
    WebElement contacts;

    @FindBy(xpath = "//select[@id='langSelect']")
    WebElement selectLang;

    @FindBy(xpath = "/html/body/app-root/app-home-page/app-header/nav/div/ul/li[2]/a")
    public WebElement addNewContactDialogOpenButton;

    @FindBy(xpath = "//*[@id=\"add-contact-modal\"]/a")
    public WebElement addNewContactDialogCloseButton;

    @FindBy(xpath = "/html/body/ngb-modal-window/div/div/app-modal-content/div[1]/h4")
    public List<WebElement> AddContactTextinDialog;

    @FindBy(className = "list-group-item.list-group-item-action")
    public List<WebElement> contactCards;

    @FindBy(xpath = "/html/body/app-root/app-home-page/app-header/nav/div/div[2]/button[1]")
    WebElement accountButton;


//    @FindBy(xpath = "//option[contains(text(),'English')]")
//    WebElement engLang;

    public LoginPage logout(){
        click(logOutButton);
        return new LoginPage(driver);
    }

    public WebElement getContacts(String lang) {
        String contactWord = getContactWord(lang);
        contacts = driver.findElement(By.xpath("//a[contains(text(),'"+contactWord+"')]"));
        return contacts;
    }

    public static String getContactWord(String lang) {
        logger.info("Language specified: " + lang);
        String contactWord = null;
        if (lang.equals("English")) {
            contactWord = "Contacts";
        } else if (lang.equals("Russian")) {
            contactWord = "Контакты";
        } else if (lang.equals("German")) {
            contactWord = "Kontakte";
        } else if (lang.equals("Ukraine")) {
            contactWord = "Контакти";
        } else {
            logger.error("Language not supported: "+ lang);
            throw new RuntimeException("Language not supported: "+ lang);
        }
        return contactWord;
    }

    public ContactsPage selectLanguage(String lang){
        click(selectLang);
        WebElement language = driver.findElement(By.xpath("//option[contains(text(),'"+lang+"')]"));
        click(language);
        return this;
    }

    public void openAddNewContactDialog() {
        click(addNewContactDialogOpenButton);
    }

    public void closeAddNewContactDialog() {
        click(addNewContactDialogCloseButton);
    }

    public AccountPage openAccount() {
        click(accountButton);
        return new AccountPage(driver);
    }

    @FindBy(id = "form-name")
    WebElement fNameField;
    @FindBy(id = "form-lastName")
    WebElement lNameField;
    @FindBy(id = "form-about")
    WebElement aboutField;
    @FindBy(xpath = "//*[@id=\"add-contact-form\"]/div[4]/button[2]")
    WebElement saveBtn;

    public ContactsPage fillAddContactsForm(String firstNameKeys, String lastNameKeys, String aboutKeys){
        type(fNameField, firstNameKeys);
        type(lNameField, lastNameKeys);
        type(aboutField, aboutKeys);
        saveBtn.click();
        return new ContactsPage(driver);
    }

    public AccountPage clickOnContact(WebElement element) {
        element.click();
        return new AccountPage(driver);
    }
}