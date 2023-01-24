*ID*: tc_
*Pre-conditions:* 
*Title:* 
*Steps:* 
*Expected result:* 

**Test cases**

**Login Page**

*ID*: tc_l1
*Pre-conditions:* Exiting user, known username and password test@gmail.com, logged out, login page opened
*Title:* Auth with valid email and password, already exiting user
*Steps:*
1. Enter valid email, password. 
2. Press Enter "Login" button
3. Choose english as a language
*Expected result:*
3Contacts page is opened, "Contacts list" block title is shown 


*ID*: tc_l2
*Pre-conditions:* Logged out, login page opened
*Title:* Verify a warning message when email and password field are left empty after editing
*Steps:*
1. left click on email field
2. left click on free space beyond fields
3. verify if warning message is displayed (email is required)
4. left click on password field
5. left click on free space beyond fields
6. verify if warning message is displayed (password is required)
*Expected result:*
Warning messages "Email|Password is required." are displayed

*ID*: tc_l3
*Pre-conditions:* Logged out, login page opened
*Title:* Check login button is enabled when required fields are filled with correct email and password => 8 chars
*Steps:*
1. Check Login button is disabled
2. enter "test@gmail.com" into email field
3. enter "test@gmail.com" into password field
4. Check if Login button is active
*Expected result:*
1. Login button is disabled
4. Login button is enabled

More TCs
Check login button is not enabled when email is filled with qwe@mail.com and empty password
Check login button is not enabled when email is empty and password is 12345678
Check login button is not enabled when email is empty and password is 123456
Check login button is not enabled when email is !!!@!!!.!! and password is 12345678
Verify if the password field is of the password type


**Contacts Page**

*ID*: tc_c1
*Pre-conditions:* Logged in as test@gmail.com, Contacts page is opened
*Title:* New added contact is in the bottom of the Contacts list
*Steps:*
1. Click on Add new contact link
2. Enter "Name +" current datetime as a first name, "Second name" + current datetime as a last name, enter current datetime as About.
3. Press Save button
4. Press on Contacts link
5. Find line with contact data
*Expected results:*
1. Add contact form appeared, Save button is disabled
2. Save button is active
3. New page is opened -- Contact info, First name and last name fields contain data from Step 2
4. Contacts page is opened
5. New contact is in the bottom of the list

Bug report:

Summary:
New created contact didn't appear at the bottom of the Contacts list
*Pre-conditions:* Logged in as test@gmail.com, Contacts page is opened

Steps to reproduce:
1. Click on Add new contact link
2. Enter "Name +" current datetime as a first name, "Second name" + current datetime as a last name, enter current datetime as About.
3. Press Save button
4. Press on Contacts link
5. Find line with contact data

Expected results:
3. New page is opened -- Contact info, First name and last name fields contain data from Step 2
5. New contact is in the bottom of the list

Actual results:
5. New contact is not at the bottom of the list

Priority: 
Severity: Minor | 2
Screenshot / attachment: screenshot.jpg / recording
Logs: .../logs.txt
TC_id: tc_c1 / automated
Component: webportal / Contacs list
Product: Phonebook
Version: 8.9.102
Product Line: 
Environment: MacOS 11 Chrome 109






*ID*: tc_c2 
*Pre-conditions:* Logged in as test@gmail.com, Contacts page is opened, there are contacts in the list
*Title:* When contact is clicked in the Contact list, the Contact info page of this contact is opened
*Steps:*
1. Choose random contact from Contacts list, remember its name, and click on it
2. Check that info in the contact list is the same as in the contact info
*Expected result:*
2. New page is opened -- Contact info, First name and last name fields contain data from the random contact  


*ID*: tc_c3
*Pre-conditions:* Logged in as test@gmail.com, Contacts page is opened
*Title:* Adding two users with the same Name and Surname is possible, both available at Contacts list
*Steps:* 
1. Click on the Add new contact link 
2. Generate a random string (e.g. from datetime)
3. Enter "Tim"+random string from s2, "Berton" + random string from s2 as a last name
4. Click Save button, write down url
5. Click on the Add new contact link
6. Repeat step 3 with the same data
7. Click Save button
8. Press on Contacts link
9. Find lines with those contacts
*Expected results:* 
1. Add contact dialog is opened
3. Save button is active
4. Contact info page is opened with name and surname entered in step 3
5. Add contact dialog is opned
6. Save button is active
7. Contact info page is opened with name and surname entered in step 3, url from step 4 > url from the current step
8. Contacts list is opened
9. Two users with the name, surname from step 3 are in the bottom of the list

*ID*: tc_c4
*Pre-conditions:* Logged in as test@gmail.com, Contacts page is opened
*Title:* Deleted contact is not visible in the Contacts list
*Steps:* 
1. Click on Add new contact link
2. Enter "Name "+ current datetime as a first name, "Second name" + current datetime as a last name
3. Press Save button
4. Press on Contacts link
5. Find line with contact data
6. Click on 'bin' button to delete our created contact on the line of the contact
7. Confirm the deletion and press Remove contact 
8. Find line with contact data
*Expected results:*
1. Add contact dialog is opened
2. Save button is active 
3. Contact info page is opened with data from step 2
4. Contact page is opened 
5. New contact is in the list
6. Remove contact dialog is opened
7. Contact list is reloaded, Remove contact message is shown for some seconds
8. Contact is not in the list

