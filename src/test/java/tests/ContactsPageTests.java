package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.ContactsPage;
import pages.LoginPage;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ContactsPageTests extends TestBase {


    @Test
    public void openAndCloseNewContactDialog()
    {
        LoginPage myLoginPage = new LoginPage(driver);
        ContactsPage contactsPage = myLoginPage.login("test@gmail.com", "test@gmail.com");

        contactsPage.openAddNewContactDialog();
        sleep();
        Assert.assertEquals(contactsPage.AddContactTextinDialog.get(0).getText(), "Add contact");
        logger.info(String.valueOf(contactsPage.AddContactTextinDialog.get(0)));
        contactsPage.closeAddNewContactDialog();
        Assert.assertEquals(contactsPage.AddContactTextinDialog.size(), 0);

        contactsPage.logout();
    }

    @Test(testName = "tc_c1")
    public void newContactAddedToTheBottomOfCL(){
        logger.info("Running test tc_c1: New added contact is in the bottom of the Contacts list");
        String language = "English";


        LoginPage myLoginPage = new LoginPage(driver);
        ContactsPage cp = myLoginPage.login("test@gmail.com", "test@gmail.com");
        cp.selectLanguage(language);

        cp.openAddNewContactDialog();


        logger.info("2. Enter \"Name +\" current datetime as a first name, \"Second name\" + current datetime as a last name, enter current datetime as About.\n");
        String name = "qa36_" + System.currentTimeMillis()/1000;
        String sname = "qa36_"+ System.currentTimeMillis()/1000;
        String about = "About qa 36 " + System.currentTimeMillis()/1000;
        cp.fillAddContactsForm(name, sname, about);

        WebElement contacts = cp.getContacts(language);
        cp.click(contacts);
        sleep();

        List<WebElement> list = driver.findElements(By.className("list-group"));
        int listContactsSize = list.size();
     //       Assert.assertTrue(listContactsSize);
        System.out.println("Length of the list " +listContactsSize);

        Assert.assertTrue(list.get(listContactsSize-1).getText().contains(name));
        Assert.assertTrue(list.get(listContactsSize-1).getText().contains(sname));
    }

    @Test(testName = "tc_c2")
    public void openAccountInfoPageOnClickOnContact(){

        String language = "English";

        LoginPage myLoginPage = new LoginPage(driver);
        ContactsPage cp = myLoginPage.login("test@gmail.com", "test@gmail.com");
        cp.selectLanguage(language);
        sleep();

        List<WebElement> listOfButtons = driver.findElements(By.className("list-group"));
        int listContactsSize = listOfButtons.size();

        logger.info("Number of contact buttons " + String.valueOf(listContactsSize));
        Assert.assertTrue(listContactsSize>0);

        int listIndex = ThreadLocalRandom.current().nextInt(0, listContactsSize - 1);
        WebElement ContactButton = listOfButtons.get(listIndex);
        String buttonText = ContactButton.getText();
        System.out.println(buttonText);
        AccountPage ap = cp.clickOnContact(ContactButton);
        sleep();

        Assert.assertEquals((ap.firstName.getText()
                + " "
                + ap.lastName.getText()), buttonText);

    }
}
