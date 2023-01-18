package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactsPage;
import pages.LoginPage;

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
}
