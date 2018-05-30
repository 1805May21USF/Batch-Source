Banking app Instructions

Main is in App.java. In this class, I left a way to recreate the default files the program reads from file. Further instructions in the App.java
admin and employee are default users(admin has Admin permissions and employee has Employee permissions). There is also one customer user with account. 
Their credentials below:
Login Name: admin
Password: pass

Login Name: employee
Password: pass

Login Name: DoeJ
Password: pass

All users created through the app's menu have customer permissions.
All commands are case sensitive (lowercase).A word of warning - bad input could cause run time errors. Below I've added example of commands below.

Initial menu presents options to Login, Register New User, and Exit. Input taken is numbers: 1 2 3 for selections

Register New User menu:
Prompted for a Login Name. Example Input: DoeJ
Prompted for a password. Example Input: password
Prompted for Full Name. Example Input: John Doe
Naming convention shown above is not enforced.


Login Menu
Prompted for Login Name. Example Input: DoeJ
Prompted for password. Eample Input: password

Customer Menu:
Displays all accounts owned or jointly owned by that user.
Commands that can be entered here:
Deposit funds. Example Input: deposit <amount> to <account number>  Example looks: deposit 250 to 1000
Withdraw funds. Example Input: withdraw <amount> from <account number>   Example looks: withdraw 100 from 1000
Transfer funds. Example Input: transfer <amount> from <account number> to <account number>   Example looks: transfer 200 from 1000 to 1001
Logout. Return to the Initial menu. Example Input: logout
Open account. Example Input: open account
Open account prompts asking for single or joint account.
Example Input: single
Example Input: joint
Single will return the user to the top of the customer menu.
Joint will ask the user for the Login Name of the other purposed joint owner.
After a joint is approved by admin/employee, the joint owner must accept or decline the account.
Accept. Example Input: accept joint account <account number>   Example looks: accept joint account 1234
Decline. Example Input: decline joint account <account number>  Example looks: decline joint account 1234

After the account has been created, a admin or employee will need to approve/deny the new account for use.

Admin or Employee menu - Employee can only approve or deny accounts in a pending state. Admin can do this and deposit, withdraw, transfer, cancel and reopen accounts.
Displays all accounts. 
Deposit funds. Example Input: deposit <amount> to <account number>  Example looks: deposit 250 to 1000
Withdraw funds. Example Input: withdraw <amount> from <account number>   Example looks: withdraw 100 from 1000
Transfer funds. Example Input: transfer <amount> from <account number> to <account number>   Example looks: transfer 200 from 1000 to 1001
Logout. Return to the Initial menu. Example Input: logout
Approve account. Example Input: approve <account number>    Example looks: approve 1234
Deny account. Example Input: deny <account number>    Example looks: deny 1234
Cancel account. Example Input: cancel <account number>   Example looks: cancel 1234
