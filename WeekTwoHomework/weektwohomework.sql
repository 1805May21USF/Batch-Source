/*
    Section 2.0 SQL Queries: Perform queries against the database
    Section 2.1 Select Queries
*/
--Select all columns from all rows in the EMPLOYEE table
SELECT * FROM EMPLOYEE;

--Select all columns from the rows where the last name field is King in the EMPLOYEE table
SELECT * FROM EMPLOYEE
WHERE LASTNAME = 'King';

--Selects all columns from the rows where the first name is Andrew and Andrew doesn't report to anyone in the EMPLOYEE table
SELECT * FROM EMPLOYEE
WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;

/*
    Section 2.2 Order By
*/

--Selects all columns from all rows in the ALBUM table and orders the results in descending order by the title
SELECT * FROM ALBUM
ORDER BY TITLE DESC;

-- Selects the first name column from all rows in the CUSTOMER table and orders the results in ascending order by city
SELECT FIRSTNAME FROM CUSTOMER
ORDER BY CITY ASC;

/*
    Section 2.3 Insert Into
*/

--Inserts two new rows into the GENRE table
INSERT INTO GENRE VALUES(26, 'K-Pop');
INSERT INTO GENRE VALUES(27, 'Parody');

--Inserts two new rows into the EMPLOYEE table
INSERT INTO EMPLOYEE(EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, HIREDATE) VALUES (9, 'Loyd', 'Thomas', 'Associate', CURRENT_DATE);
INSERT INTO EMPLOYEE(EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, HIREDATE) VALUES (10, 'Doe', 'Jane', 'Manager', CURRENT_DATE);

--Inserts a new rows into the CUSTOMER table
INSERT INTO CUSTOMER(CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, EMAIL) VALUES (60, 'John', 'Doe', 'Revature', 'test@test.com');
INSERT INTO CUSTOMER(CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, EMAIL) VALUES (61, 'Doe', 'Jane', 'Test Co', 'example@example.net');

/*
    Section 2.4 Update
*/

--Updates customer Aaron Mitchell to Robert Walter
UPDATE CUSTOMER
SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';

--Updates artist Creedence Clearwater Revival to CCR
UPDATE ARTIST
SET NAME = 'CCR'
WHERE NAME = 'Creedence Clearwater Revival';

/*
    Section 2.5 Like
*/

--Select all columns from all rows where the billing address starts with a T from the INVOICE table
SELECT * FROM INVOICE
WHERE BILLINGADDRESS LIKE 'T%';

/*
    Section 2.6 Between
*/

--Select all columns and rows whose total is between 15 and 50 from the INVOICE table
SELECT * FROM INVOICE
WHERE TOTAL BETWEEN 15 AND 50;

--Select all columns and rows where the hired date is between 6/1/03 and 3/1/04 from the EMPLOYEE table
SELECT * FROM EMPLOYEE
WHERE HIREDATE BETWEEN '01/JUN/03' AND '01/MAR/04';

/*
    Section 2.7 Delete
*/

--Deletes any row in the INVOICELINE table where the invoice id matches any invoice belonging to Robert Walter
DELETE FROM INVOICELINE
WHERE INVOICEID IN
(SELECT INVOICE.INVOICEID FROM INVOICE
WHERE INVOICE.CUSTOMERID = 
(SELECT UNIQUE CUSTOMER.CUSTOMERID FROM CUSTOMER
WHERE CUSTOMER.FIRSTNAME = 'Robert' AND CUSTOMER.LASTNAME = 'Walter'));

--Deletes any row in the INVOICE table where the customer id matches Robert Walter's customer id
DELETE FROM INVOICE
WHERE CUSTOMERID = 
(SELECT UNIQUE CUSTOMERID FROM CUSTOMER
WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter');

-- Deletes any row whare Rober Walter is a customer's first and last name from the CUSTOMER table
DELETE FROM CUSTOMER
WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';

/*
    Section 3.0 SQL Functions: Performing various actions against the database
    Section 3.1 System Defined Functions
*/

-- Creates a function to return the current time
CREATE OR REPLACE FUNCTION GET_CURRENT_TIME
--Sets the return type to varchar with a maximum of 100 characters
RETURN VARCHAR IS
    OUTPUT STRING(100);
--Begins the function code
BEGIN
    --Sets the OUTPUT variable equal to 'Time is ' + the current time
    OUTPUT := 'Time is '|| TO_CHAR(CURRENT_DATE, 'HH24:MI:SS');
    --Returns the
    RETURN OUTPUT;
--Ends the function code
END;
/

--Displays the current time
SELECT GET_CURRENT_TIME AS Current_Time FROM DUAL;

--Creates a function to return the length of an entered varchar
CREATE OR REPLACE FUNCTION MEDIATYPE_LENGTH(INPUT VARCHAR)
--Sets the return type to integer
RETURN INTEGER IS
    OUTPUT INTEGER;
--Begins the function code
BEGIN
    --Sets the OUTPUT variable equal to the length of the entered varchar and returns output
    OUTPUT := LENGTH(INPUT);
    RETURN OUTPUT;
--Ends the function code
END;
/

--Displays the names stored in the MEDIATYPE table and the length of each name
SELECT NAME, MEDIATYPE_LENGTH(NAME) FROM MEDIATYPE;

/*
    Section 3.2 System Defined Aggregate Funtions
*/


--Displays the average value of all the totals in the INVOICE table
SELECT AVG(TOTAL) FROM INVOICE;

--Displays the cost of the track with the highest unit proce in TRACK
SELECT MAX(UNITPRICE) FROM TRACK;

/*
    Section 3.3 User Defined Scalar Functions
*/

--Creates a function to return a message stating the average price of a sent number
CREATE OR REPLACE FUNCTION AVERAGE_INVOICELINE_PRICE(INPUT NUMBER)
--Sets the return type to varchar
RETURN VARCHAR IS
    OUTPUT VARCHAR(100);
--Begin the function code
BEGIN
    --Sets the output equal to 'The average is ' + INPUT and returns OUTPUT
    OUTPUT := 'The average invoice price is ' || INPUT;
    RETURN OUTPUT;
--Ends the function code
END;
/

--Displays the average price of all the unit prices in the INVOICELINE table
SELECT AVERAGE_INVOICELINE_PRICE(AVG(UNITPRICE)) AS Average_Price FROM INVOICELINE;

--Creates a function to return the number of employees born after 1968
CREATE OR REPLACE FUNCTION EMPLOYEE_BORN_AFTER_1968
--Sets the return type to number
RETURN NUMBER AS
    OUTPUT NUMBER;
--Begin the function code
BEGIN
   SELECT COUNT(*) INTO OUTPUT FROM EMPLOYEE WHERE BIRTHDATE > '31/DEC/68';
   RETURN OUTPUT;
END;
/

--Displays the number of employees born after 1968
SELECT EMPLOYEE_BORN_AFTER_1968 AS EMPLOYEES_BORN_AFTER_1968 FROM DUAL;

/*
    Section 4.0 Stored Procedures: Create and execute stored procedures
    Section 4.1 Basic Stored Procedure
*/

--Creates a procedure the retrieves the first and last names of every employee in the EMPLOYEE table
CREATE OR REPLACE PROCEDURE GET_EMPLOYEE_NAMES (EMPLOYEE_NAME_CURSOR OUT SYS_REFCURSOR)
IS 
BEGIN
--Opens the provided cursor and uses it to retrieve information about employees
OPEN EMPLOYEE_NAME_CURSOR FOR 
SELECT LASTNAME, FIRSTNAME FROM EMPLOYEE;
END;
/

--Creates the EMPLOYEE_NAME_CURSOR cursor that stores the first and last names of employees
DECLARE
EMPLOYEE_NAME_CURSOR SYS_REFCURSOR;
FIRST_NAME EMPLOYEE.FIRSTNAME%TYPE;
LAST_NAME EMPLOYEE.LASTNAME%TYPE;
--Sends the cursor to the GET_EMPLOYEE_NAMES procedure
BEGIN
GET_EMPLOYEE_NAMES(EMPLOYEE_NAME_CURSOR);
--Loops through the results and puts the cursor values into the local variables
LOOP
FETCH EMPLOYEE_NAME_CURSOR INTO FIRST_NAME, LAST_NAME;
EXIT WHEN EMPLOYEE_NAME_CURSOR%NOTFOUND;
--Prints out the local variables
DBMS_OUTPUT.PUT_LINE(FIRST_NAME || ' ' || LAST_NAME);
END LOOP;
--Closes the cursor and ends the block of code
CLOSE EMPLOYEE_NAME_CURSOR;
END;
/

/*
    Section 4.2 Stored Procedure Input Parameters
*/

--Updates the title of the employee with the entered id to the entered title
CREATE OR REPLACE PROCEDURE UPDATE_EMPLOYEE_TITLE(
    ID NUMBER,
    NEW_TITLE VARCHAR
)
AS
BEGIN
    --Updates the Employee table using the entered values
    UPDATE EMPLOYEE SET TITLE = NEW_TITLE WHERE EMPLOYEEID = ID;
END;
/

-- Executes the stored procedure
EXECUTE UPDATE_EMPLOYEE_TITLE(2, 'VP');

--Creates a procedure the retrieves the first and last names of every employee in the EMPLOYEE table
CREATE OR REPLACE PROCEDURE GET_EMPLOYEE_MANAGER (
    EMPLOYEE_MANAGER_CURSOR OUT SYS_REFCURSOR, 
    MANAGER NUMBER
)
IS 
BEGIN
--Opens the provided cursor and uses it to retrieve information about employees
OPEN EMPLOYEE_MANAGER_CURSOR FOR 
SELECT LASTNAME, FIRSTNAME FROM EMPLOYEE
WHERE REPORTSTO = MANAGER;
END;
/

--Creates the EMPLOYEE_MANAGER_CURSOR cursor that stores the first and last names of employees managers
DECLARE
EMPLOYEE_MANAGER_CURSOR SYS_REFCURSOR;
MANAGER_FIRST_NAME EMPLOYEE.FIRSTNAME%TYPE;
MANAGER_LAST_NAME EMPLOYEE.LASTNAME%TYPE;
--Sends the cursor to the GET_EMPLOYEE_MANAGER procedure
BEGIN
GET_EMPLOYEE_MANAGER(EMPLOYEE_MANAGER_CURSOR, 1);
--Loops through the results and puts the cursor values into the local variables
LOOP
FETCH EMPLOYEE_MANAGER_CURSOR INTO MANAGER_FIRST_NAME, MANAGER_LAST_NAME;
EXIT WHEN EMPLOYEE_MANAGER_CURSOR%NOTFOUND;
--Prints out the local variables
DBMS_OUTPUT.PUT_LINE(MANAGER_FIRST_NAME || ' ' || MANAGER_LAST_NAME);
END LOOP;
--Closes the cursor and ends the block of code
CLOSE EMPLOYEE_MANAGER_CURSOR;
END;
/

/*
    Section 4.3 Stored Procedure Output Parameters
*/

--Creates a procedure the retrieves the first and last names of every customer and their company names from the CUSTOMER table
CREATE OR REPLACE PROCEDURE GET_CUSTOMER_INFO (CUSTOMER_INFO_CURSOR OUT SYS_REFCURSOR)
IS 
BEGIN
--Opens the provided cursor and uses it to retrieve information about customers
OPEN CUSTOMER_INFO_CURSOR FOR 
SELECT FIRSTNAME, LASTNAME, COMPANY FROM CUSTOMER;
END;
/

--Creates the CUSTOMER_INFO_CURSOR cursor that stores the first and last names of customers, and prints the customer's company's name
DECLARE
CUSTOMER_INFO_CURSOR SYS_REFCURSOR;
CUSTOMER_FIRST_NAME CUSTOMER.FIRSTNAME%TYPE;
CUSTOMER_LAST_NAME CUSTOMER.LASTNAME%TYPE;
CUSTOMER_COMPANY CUSTOMER.COMPANY%TYPE;
--Sends the cursor to the GET_CUSTOMER_INFO procedure
BEGIN
GET_CUSTOMER_INFO(CUSTOMER_INFO_CURSOR);
--Loops through the results and puts the cursor values into the local variables
LOOP
FETCH CUSTOMER_INFO_CURSOR INTO CUSTOMER_FIRST_NAME, CUSTOMER_LAST_NAME, CUSTOMER_COMPANY;
EXIT WHEN CUSTOMER_INFO_CURSOR%NOTFOUND;
--Prints out the local variables
DBMS_OUTPUT.PUT_LINE(CUSTOMER_FIRST_NAME || ' ' || CUSTOMER_LAST_NAME || ' : ' || CUSTOMER_COMPANY);
END LOOP;
--Closes the cursor and ends the block of code
CLOSE CUSTOMER_INFO_CURSOR;
END;
/

/*
    Section 5.0 Transactions: Create transactions to manage a database
*/

--Creates or replaces the stored procedure DELETE_INVOICE that takes a number as input
CREATE OR REPLACE PROCEDURE DELETE_INVOICE(INPUT IN NUMBER)
AS
BEGIN
    --Deletes the invoice, and invoiceline, associated with an entered id number
    DELETE FROM INVOICELINE WHERE INVOICEID = INPUT;
    DELETE FROM INVOICE WHERE INVOICEID = INPUT;
END;

--Executes the stored procedure
EXECUTE DELETE_INVOICE(1);

--Creates or replaces the INSERT_CUSTOMER procedure that takes an integer and four varchar variables
CREATE OR REPLACE PROCEDURE INSERT_CUSTOMER(
    ID INTEGER,
    FNAME VARCHAR,
    LNAME VARCHAR,
    COMP VARCHAR,
    E VARCHAR
)
AS
BEGIN
    --Inserts the input into the CUSTOMER table as a new row
    INSERT INTO CUSTOMER(CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, EMAIL) VALUES (ID, FNAME, LNAME, COMP, E);
END;
/

--Executes the stored procedure
EXECUTE INSERT_CUSTOMER(142, 'Adam', 'Warlock', 'JL INC.', 'adamw@aol.com');
/*
    Section 6.0 Triggers: Create various triggers that activate when DML language is used
    Section 6.1 After/For
*/

--Creates a trigger that activates after a row has been inserted into the EMPLOYEE table
CREATE OR REPLACE TRIGGER EMPLOYEE_AFTER_INSERT AFTER INSERT ON EMPLOYEE
    FOR EACH ROW
BEGIN
    --Prints that the EMPLOYEE table has had a new row inserted
    DBMS_OUTPUT.PUT_LINE('Employee table has a new row!');
END;

--Creates a trigger that activates after a row has been updated in the ALBUM table
CREATE OR REPLACE TRIGGER ALBUM_AFTER_UPDATE AFTER UPDATE ON ALBUM
    FOR EACH ROW
BEGIN
    --Prints that the ALBUM table has had one of its rows update
    DBMS_OUTPUT.PUT_LINE('Album table has updated a row!');
END;

--Creates a trigger that activates after customer information is deleted from the CUSTOMER table
CREATE OR REPLACE TRIGGER CUSTOMER_AFTER_DELETE AFTER DELETE ON CUSTOMER
    FOR EACH ROW
BEGIN
    --Prints that the CUSTOMER table has removed a row
    DBMS_OUTPUT.PUT_LINE('Customer table has a removed a row!');
END;

/*
    Section 7.0 Joins: Combine various tables together through JOIN statements
    Section 7.1 Inner Join
*/

-- Prints all the employees linked with an invoice
SELECT CONCAT(C.FIRSTNAME, C.LASTNAME) AS NAME, I.INVOICEID FROM CUSTOMER C
INNER JOIN INVOICE I ON C.CUSTOMERID = I.CUSTOMERID;

/*
    Section 7.2 Outer Join
*/

-- Prints all employees and all invoices, displaying a null value if the there's no match
SELECT C.CUSTOMERID, C.FIRSTNAME, C.LASTNAME, I.INVOICEID, I.TOTAL FROM CUSTOMER C
FULL OUTER JOIN INVOICE I ON C.CUSTOMERID = I.CUSTOMERID;

/*
    Section 7.3 Right Join
*/

--Displays the album title joined with the artists name and prints null if the artist who made an album is unknown
SELECT AR.NAME, AL.TITLE FROM ARTIST AR RIGHT JOIN ALBUM AL ON AR.ARTISTID = AL.ARTISTID;

/*
    Section 7.4 Cross Join
*/

--Creates and lists the Cartesian Product of the ARTIST and ALBUM tables
SELECT AR.NAME, AL.TITLE FROM ARTIST AR CROSS JOIN ALBUM AL ORDER BY AR.NAME ASC;

/*
    Section 7.5 Self Join
*/

-- Concats the first and last name of employees and lists an employee and who they report to
SELECT CONCAT(E.FIRSTNAME, E.LASTNAME) AS EMPLOYEE, CONCAT(EM.FIRSTNAME, EM.LASTNAME) AS REPORTS_TO 
FROM EMPLOYEE E, EMPLOYEE EM
WHERE E.REPORTSTO = EM.REPORTSTO;