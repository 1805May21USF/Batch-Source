JDBC Bank Application Assignment
By: Tiffany Tran
Due: Monday, June 4th at 5pm
Trainer: Matt Knighten

The project contains a logger using Log4j. The log file is log.txt and is found in the main project folder.
The DB creation script is JDBCBank.sql and is found in the main project folder. After running the script, make sure the changes are committed by pressing Commit (or F11) in the Oracle SQL Developer.

Utilized software:
  - Oracle SQL Developer
  - Eclipse Oxygen.3a Release (4.7.3a)

The Maven project features
  - Utilitizes the Scanner all user input and the console for output
  - Stores the data to an Oracle database using JDBC
  - Uses sequences to generate PersonID
  - Throws a custom exception (OverDraftException)
  - Provide validation messages through the console for user actions
  - Use the DAO design pattern
  - Uses a stored procedure with PL/SQL
  - Uses prepared/callable statements with JDBC
  - JUnit 5 to test logic method

The project contains three main users: Customer, Employee, and Bank Admin.

The Customer is able to:
  - Withdraw from account
  - Deposit into account
  - Delete account (If balance is 0)
  
The Employee is able to:
  - Approve/Deny Open Applications
  - View Customer Info
  
The Customer is able to:
  - Approve/Deny Open Applications
  - View and Edit Customer Info
  - Withdraw from an account from any user
  - Deposit to an account to any user
  - Cancel an account
  
If a user does not have an account, they may register for an account. After registering, the user must wait for a Bank Admin or Employee to approve of their account before they can use it. The user can also apply as a joint-account. A joint account shares the same accountID.
