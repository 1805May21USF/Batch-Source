/* 2.1 SELECT
Task – Select all records from the Employee table.
Task – Select all records from the Employee table where last name is King.
Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
*/
SELECT * FROM EMPLOYEE;

SELECT * FROM EMPLOYEE WHERE LASTNAME='King';

SELECT * FROM EMPLOYEE WHERE FIRSTNAME='Andrew' AND REPORTSTO IS NULL;

/* 2.2 ORDER BY
Task – Select all albums in Album table and sort result set in descending order by title.
Task – Select first name from Customer and sort result set in ascending order by city
*/
SELECT * FROM ALBUM ORDER BY TITLE DESC;

SELECT FIRSTNAME FROM CUSTOMER ORDER BY CITY ASC;

/*2.3 INSERT INTO
Task – Insert two new records into Genre table 
Task – Insert two new records into Employee table
Task – Insert two new records into Customer table
*/
INSERT INTO GENRE VALUES(26, 'Asian Pop');
INSERT INTO GENRE VALUES(27, 'Indie');

INSERT INTO EMPLOYEE
VALUES(9, 'Chowdhury', 'Shuva', 'Associate', 3, '26-APR-92', '21-MAY-18', '3441 Quail Hollow Trail', 'Snellville', 'GA', 'USA',
'30039', '+1 (404) 422-6087', NULL, 'spc2692@gmail.com');
INSERT INTO EMPLOYEE
VALUES(10, 'Neopane', 'Charlie', 'Associate', 3, NULL, NULL, NULL, 'Harrisburg', 'PA', 'USA',
NULL, NULL, NULL, 'crystal.chand73@gmail.com');

INSERT INTO CUSTOMER
VALUES(60, 'John', 'Doe', NULL, NULL, NULL, NULL,'USA', NULL, NULL, NULL, 'john.doe@gmail.com', NULL);
INSERT INTO CUSTOMER
VALUES(61, 'Martha', 'Stewart', NULL, NULL, NULL, NULL,'USA', NULL, NULL, NULL, 'martha_st@gmail.com', NULL);

/*2.4 UPDATE
Task – Update Aaron Mitchell in Customer table to Robert Walter
Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
*/
UPDATE CUSTOMER
SET FIRSTNAME='Robert', LASTNAME='Walter'
WHERE FIRSTNAME='Aaron' AND LASTNAME='Mitchell';

UPDATE ARTIST
SET NAME='CCR'
WHERE NAME='Creedence Clearwater Revival';

/*2.5 LIKE
Task – Select all invoices with a billing address like “T%” 
*/
SELECT * FROM INVOICE WHERE BILLINGADDRESS LIKE 'T%';

/*2.6 BETWEEN
Task – Select all invoices that have a total between 15 and 50
Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
*/
SELECT * FROM INVOICE WHERE TOTAL BETWEEN 15 AND 50;

SELECT * FROM EMPLOYEE WHERE HIREDATE BETWEEN '01-JUN-03' AND '01-MAR-04';

/*2.7 DELETE
Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
DELETE FROM CUSTOMER
WHERE FIRSTNAME='Robert' AND LASTNAME='Walter';
*/
DELETE FROM INVOICELINE WHERE INVOICEID IN (
    SELECT INVOICE.INVOICEID FROM INVOICE
    JOIN CUSTOMER 
    ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID
    WHERE CUSTOMER.FIRSTNAME = 'Robert' AND CUSTOMER.LASTNAME = 'Walter'
);

DELETE FROM INVOICE WHERE INVOICEID IN (
    SELECT INVOICE.INVOICEID FROM INVOICE
    JOIN CUSTOMER 
    ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID
    WHERE CUSTOMER.FIRSTNAME = 'Robert' AND CUSTOMER.LASTNAME = 'Walter'
);

DELETE FROM CUSTOMER WHERE FIRSTNAME = 'Robert' AND CUSTOMER.LASTNAME = 'Walter';

/*3.1 System Defined Functions
Task – Create a function that returns the current time.
Task – create a function that returns the length of name in MEDIATYPE table
*/
CREATE OR REPLACE FUNCTION GET_CUR_TIME
RETURN VARCHAR2 AS CUR_TIME VARCHAR(250);
BEGIN
    SELECT TO_CHAR(CURRENT_DATE,'HH:MI:SS') INTO CUR_TIME FROM DUAL;
    RETURN CUR_TIME;
END;
/

SELECT GET_CUR_TIME() FROM dual;

CREATE OR REPLACE FUNCTION getLength(typeName IN STRING)
RETURN NUMBER
IS
BEGIN
    RETURN LENGTH(typeName);
END;
/

SELECT getLength(NAME) FROM MEDIATYPE;

/*3.2 System Defined Aggregate Functions
Task – Create a function that returns the average total of all invoices 
Task – Create a function that returns the most expensive track
*/
CREATE OR REPLACE FUNCTION GET_AVG_TOTAL
RETURN NUMBER IS AVG_TOTAL NUMBER(10, 2);
BEGIN
SELECT AVG(TOTAL) INTO AVG_TOTAL FROM INVOICE;
RETURN AVG_TOTAL;
END;
/

SELECT GET_AVG_TOTAL FROM DUAL;

CREATE OR REPLACE FUNCTION GET_EXP_TRACK
RETURN NUMBER IS GET_TRACK_PRICE NUMBER(10, 2);
BEGIN
SELECT MAX(UNITPRICE) INTO GET_TRACK_PRICE FROM TRACK;
RETURN GET_TRACK_PRICE;
END;
/

SELECT GET_EXP_TRACK FROM DUAL;

/*3.3 User Defined Scalar Functions
Task – Create a function that returns the average price of invoiceline items in the invoiceline table
*/
CREATE OR REPLACE FUNCTION GET_AVG_PRICE
RETURN NUMBER IS GET_AVG_PRICE NUMBER(10, 2);
BEGIN
SELECT AVG(UNITPRICE) INTO GET_AVG_PRICE FROM INVOICELINE;
RETURN GET_AVG_PRICE;
END;
/

SELECT GET_AVG_PRICE FROM DUAL;

/*3.4 User Defined Table Valued Functions
Task – Create a function that returns all employees who are born after 1968.
*/
CREATE OR REPLACE FUNCTION GET_EMPLOYEE
RETURN SYS_REFCURSOR
AS
 C SYS_REFCURSOR;
BEGIN
    OPEN C FOR
    SELECT FIRSTNAME, LASTNAME, BIRTHDATE FROM EMPLOYEE
    WHERE BIRTHDATE > '12-DEC-68';
    RETURN C;
END;
/
SELECT GET_EMPLOYEE FROM DUAL;

/*4.1 Basic Stored Procedure
Task – Create a stored procedure that selects the first and last names of all the employees.
*/
CREATE OR REPLACE PROCEDURE GET_FIRST_LAST
AS
    C SYS_REFCURSOR;
BEGIN
    OPEN C FOR
        SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
        DBMS_SQL.RETURN_RESULT(C);
END;
/

EXECUTE GET_FIRST_LAST;

/*4.2 Stored Procedure Input Parameters
Task – Create a stored procedure that updates the personal information of an employee.
Task – Create a stored procedure that returns the managers of an employee.
*/
CREATE OR REPLACE PROCEDURE UPDATE_EMPLOYEE
(FNAME IN VARCHAR2, LNAME IN VARCHAR2)
AS 
BEGIN
UPDATE EMPLOYEE 
SET HIREDATE = '21-MAY-18', 
PHONE = '+1 (678)629-8965'
WHERE FIRSTNAME = FNAME AND LASTNAME = LNAME;
COMMIT;
END;
/
EXECUTE UPDATE_EMPLOYEE('CHARLIE', 'NEOPANE');

CREATE OR REPLACE PROCEDURE FIND_MANAGER
(ID IN NUMBER)
AS
    C SYS_REFCURSOR;
BEGIN
    OPEN C FOR
        SELECT A.EMPLOYEEID, B.FIRSTNAME AS FNAME, B.LASTNAME AS LNAME
        FROM EMPLOYEE A
        JOIN EMPLOYEE B
        ON B.EMPLOYEEID = A.REPORTSTO
        WHERE A.EMPLOYEEID = ID;
        DBMS_SQL.RETURN_RESULT(C);
END;
/

DECLARE
ID NUMBER;
BEGIN
    ID := 7;
    FIND_MANAGER(ID);
END;
/

/*4.3 Stored Procedure Output Parameters
Task – Create a stored procedure that returns the name and company of a customer.
*/
CREATE OR REPLACE PROCEDURE GET_NAME_AND_COMPANY
(S OUT SYS_REFCURSOR, ID IN NUMBER)
IS
BEGIN
    OPEN S FOR
        SELECT FIRSTNAME, LASTNAME, COMPANY
        FROM CUSTOMER
        WHERE CUSTOMERID = ID;
END;
/

SET SERVEROUTPUT ON;

DECLARE
S SYS_REFCURSOR;
ID CUSTOMER.CUSTOMERID%TYPE;
FIRST_NAME CUSTOMER.FIRSTNAME%TYPE;
LAST_NAME CUSTOMER.LASTNAME%TYPE;
COMPANY_NAME CUSTOMER.COMPANY%TYPE;
BEGIN
    ID := 16;
    GET_NAME_AND_COMPANY(S, ID);
    FETCH S INTO FIRST_NAME, LAST_NAME, COMPANY_NAME;
    DBMS_OUTPUT.PUT_LINE(
    'Customer with the name of '||FIRST_NAME||' '||LAST_NAME||
    ', works at '||COMPANY_NAME);
CLOSE S;
END;
/

/*5.0 Transactions
Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this,
find out how to resolve them).
Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
*/
--TASK 1: DELETE INVOICE BASED ON INVOICEID
BEGIN
DELETE FROM INVOICELINE
    WHERE INVOICEID = 22;
DELETE FROM INVOICE 
    WHERE INVOICEID = 22;
    COMMIT;
END;
/

--TASK 2: INSERT NEW RECORD INTO CUSTOMER
BEGIN
    INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL) 
    VALUES (65, 'Wade', 'Wilson', 'ww2@gmail.com');
    COMMIT;
END;
/

--DROP PROCEDURE INSERT_RECORD;

/*6.1 AFTER/FOR
Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
Task – Create an after update trigger on the album table that fires after a row is inserted in the table
Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
*/

--TASK 6.1.1: CREATE AN AFTER INSERT TRIGGER
CREATE OR REPLACE TRIGGER trigger_new_employee
AFTER INSERT
    ON EMPLOYEE
BEGIN
    UPDATE EMPLOYEE
        SET HIREDATE = '04-JUN-18'
        WHERE EMPLOYEEID = 9;
END;
/
INSERT INTO EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, EMAIL) 
    VALUES(10, 'Da', 'Employee', 'Associate', 'demp@gmail.com');
    
--DROP TRIGGER trigger_new_employee;
    
--TASK 6.1.2: CREATE AN AFTER UPDATE TRIGGER
CREATE OR REPLACE TRIGGER trigger_new_album
AFTER UPDATE
    ON ALBUM
    FOR EACH ROW
DECLARE
BEGIN
    DELETE FROM EMPLOYEE WHERE EMPLOYEEID = 9;
END;
/

UPDATE ALBUM
    SET TITLE = 'STORMBREAKER'
    WHERE ALBUMID = 65;
    
--DROP TRIGGER trigger_new_album;
    
--TASK 6.1.3: CREATE AN AFTER DELETE TRIGGER
CREATE OR REPLACE TRIGGER trigger_delete_customer
AFTER DELETE
    ON CUSTOMER
BEGIN
    UPDATE EMPLOYEE
        SET HIREDATE = '04-JUN-18'
        WHERE EMPLOYEEID = 10;
END;
/

DELETE FROM CUSTOMER WHERE CUSTOMERID = 62;

--DROP TRIGGER trigger_delete_customer;

/*7.1 INNER
Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
*/
SELECT CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID
    FROM CUSTOMER
    INNER JOIN INVOICE
        ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;
        
/*7.2 OUTER
Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
*/
SELECT CUSTOMER.CUSTOMERID, CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID, INVOICE.TOTAL
FROM CUSTOMER
    FULL OUTER JOIN INVOICE
    ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;
    
/*7.3 RIGHT
Task – Create a right join that joins album and artist specifying artist name and title.
*/
SELECT ARTIST.NAME, ALBUM.TITLE
FROM ARTIST
    RIGHT JOIN ALBUM
    ON ALBUM.ARTISTID = ARTIST.ARTISTID;

/*7.4 CROSS
Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
*/
SELECT ARTIST.NAME, ALBUM.TITLE 
FROM ARTIST
CROSS JOIN ALBUM ORDER BY NAME ASC;

/*7.5 SELF
Task – Perform a self-join on the employee table, joining on the reportsto column.
*/
SELECT A.FIRSTNAME||' '||A.LASTNAME||' reports to '||B.FIRSTNAME||' '||B.LASTNAME
"Employees and Managers"
FROM EMPLOYEE A, EMPLOYEE B
    WHERE A.REPORTSTO = B.EMPLOYEEID;