package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactsPage;
import pages.LoginPage;

public class LoginPageTests extends TestBase{

    @Test(testName = "tc_l1")
    public void loginPositiveTest(){

        logger.info("Starting login test");
        //String language = System.getProperty("language");
        String language = "English";

        LoginPage myLoginPage = new LoginPage(driver);
        ContactsPage contactsPage = myLoginPage.login("test@gmail.com", "test@gmail.com");
        sleep();
        contactsPage.selectLanguage(language);
        sleep();
        Assert.assertEquals(contactsPage.getContacts(language).getText(), ContactsPage.getContactWord(language));
        Assert.assertTrue(searchInPageSource("Contacts list"));
        logger.info("Finished login test");
        contactsPage.logout();
    }

    @Test
    public void loginNegativeTest(){
        logger.info("Starting negative login test");

        LoginPage myLoginPage = new LoginPage(driver);
        myLoginPage.loginNegative("test@gmail.com", "123456789");
        sleep();
        Assert.assertEquals(myLoginPage.registerLink.getText(), "Register new Account");
        Assert.assertEquals(myLoginPage.errorMsg.getText(), "Please check your activation or Login + Password combination" );
        logger.info("Finished negative login test");
    }

    @Test(testName = "tc_l2")
    public void loginEmptyFieldsWarningMessage(){
        logger.info("Starting tc_l2 on empty fields");

        LoginPage lp = new LoginPage(driver);
        lp.click(lp.userName);
        lp.click(lp.password);
        Assert.assertEquals(lp.emailErrorMsg.getText() , "Email is required.");
        lp.click(lp.userName);
        Assert.assertEquals(lp.passwordErrorMsg.getText() , "Password is required.");
    }

    @Test(testName="tc_l3")
    public void loginButtonEnabledWithCorrectEmailAndPass(){
        logger.info("Starting tc_l3: Check login button is enabled when required fields are filled with correct email and password => 8 chars");
        LoginPage myLoginPage = new LoginPage(driver);
        Assert.assertFalse(myLoginPage.loginButton.isEnabled());

        logger.info("1. enter \"test@gmail.com\" into email field");
        logger.info("2. enter \"test@gmail.com\" into password field");
        myLoginPage.enterCreds("test@gmail.com", "test@gmail.com");

        logger.info("3. Check if Login button is active\n" +
                "*Expected result:* Login button is enabled");
        Assert.assertTrue(myLoginPage.loginButton.isEnabled());
    }



}