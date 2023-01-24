package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends PageBase {

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "/html/body/app-root/app-home-page/div/app-user-details-pgae/div/div[2]/div/app-account-password/div[2]/form/div[1]/input")
    WebElement passwordField;

    @FindBy(xpath = "/html/body/app-root/app-home-page/div/app-user-details-pgae/div/div[2]/div/app-account-password/div[2]/form/button")
    WebElement acceptButton;

    @FindBy(xpath = "/html/body/app-root/app-home-page/div/app-user-details-pgae/div/div[2]/div/app-account-password/div[2]/h5")
    WebElement changePasswordString;

    public void enterPassword(String password) {
        type(passwordField, password);
    }

    public void submitForm() {
        click(acceptButton);
    }

    @FindBy(id="contact-first-name")
    public WebElement firstName;

    @FindBy(id="contact-last-name")
    public WebElement lastName;


}