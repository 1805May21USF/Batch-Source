/*
Lab Name: SQL Lab
Due: Monday June 4th at 9AM
Name: Nicholas Low
*/
SET SERVEROUTPUT ON;
/*2.0 SQL Queries******************************************************************/

--2.1 SELECT
---Task – Select all records from the Employee table.
SELECT * FROM EMPLOYEE;

---Task – Select all records from the Employee table where last name is King.
SELECT * FROM EMPLOYEE
WHERE LASTNAME = 'King';

---Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM EMPLOYEE
WHERE FIRSTNAME = 'Andrew' AND
REPORTSTO IS NULL;

--2.2 ORDER BY
---Task – Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM ALBUM
ORDER BY TITLE DESC;
---Task – Select first name from Customer and sort result set in ascending order by city
SELECT FIRSTNAME FROM CUSTOMER
ORDER BY CITY;

--2.3 INSERT INTO
---Task – Insert two new records into Genre table 
INSERT ALL
INTO GENRE (GENREID, NAME) VALUES (26,'HOUSE')
INTO GENRE (GENREID, NAME) VALUES (27,'TRAP')
SELECT * FROM DUAL;

---Task – Insert two new records into Employee table
INSERT ALL
INTO EMPLOYEE (EMPLOYEEID, FIRSTNAME, LASTNAME) VALUES (9,'ROLL', 'TIDE')
INTO EMPLOYEE (EMPLOYEEID, FIRSTNAME, LASTNAME) VALUES (10, 'ROLL1', 'TIDE1')
SELECT * FROM DUAL;

---Task – Insert two new records into Customer table
INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL) VALUES (60,'WHODAT', 'WHODAT', 'JIGGY@ME.COM');
INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL) VALUES (61, 'IG', 'GY', 'IGGY@ME.COM');

--2.4 UPDATE
---Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE CUSTOMER 
SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';

---Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR” 
UPDATE ARTIST
SET NAME = 'CCR'
WHERE NAME = 'Creedence Clearwater Revival';

--2.5 LIKE
---Task – Select all invoices with a billing address like “T%” 
SELECT * FROM INVOICE WHERE BILLINGADDRESS LIKE 'T%';

-- 2.6 BETWEEN
---Task – Select all invoices that have a total between 15 and 50
SELECT * FROM INVOICE WHERE TOTAL BETWEEN 15 AND 50;

---Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM EMPLOYEE WHERE HIREDATE BETWEEN '01-JUNE-03' AND '01-MARCH-04';

--2.7 DELETE
---Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
DELETE (SELECT * FROM INVOICE I
            JOIN CUSTOMER C ON C.CUSTOMERID = I.CUSTOMERID 
            JOIN INVOICELINE IL ON I.INVOICEID = IL.INVOICEID
            WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter');
            
/*3. SQL FUNCTIONS*********************************************************************/
--3.1 System Defined Functions
---Task – Create a function that returns the current time.
CREATE OR REPLACE FUNCTION getCurrentDate
RETURN DATE AS THE_DATE DATE;
BEGIN
    SELECT CURRENT_TIME INTO THE_DATE FROM DUAL;
    RETURN THE_DATE;
END getCurrentDate;
/

SELECT getCurrentDate FROM DUAL;
---Task – create a function that returns the length of name in MEDIATYPE table
CREATE OR REPLACE FUNCTION getLength
(MEDIA_NAME IN VARCHAR2)
RETURN NUMBER AS NAME_LENGTH NUMBER(10,2);
BEGIN
    SELECT LENGTH(NAME) INTO NAME_LENGTH FROM MEDIATYPE WHERE NAME = MEDIA_NAME;
    RETURN NAME_LENGTH;
END;
/

SELECT getLength(NAME) FROM MEDIATYPE;

--3.2 System Defined Aggregate Functions
---Task – Create a function that returns the average total of all invoices
CREATE OR REPLACE FUNCTION findAverage
RETURN NUMBER AS 
theAverage NUMBER(10,2);
BEGIN
SELECT AVG(TOTAL) INTO theAverage FROM INVOICE;
RETURN theAverage;
END;
/
SELECT findAverage FROM DUAL;
---Task – Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION findMostExpensive
RETURN VARCHAR2 AS
mostExpensiveTracks VARCHAR2(50);
BEGIN
    SELECT NAME INTO mostExpensiveTracks FROM TRACK 
    WHERE UNITPRICE = (SELECT MAX(UNITPRICE) FROM TRACK)
    FETCH FIRST 1 ROWS ONLY;
    RETURN mostExpensiveTracks;
END;
/
SELECT findMostExpensive FROM DUAL;

--3.3 User Defined Scalar Functions
---Task – Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION GET_AVG_PRICE
RETURN NUMBER AS 
AVG_PRICE NUMBER(10,2);
BEGIN
    SELECT AVG(UNITPRICE) INTO AVG_PRICE FROM INVOICELINE;
    RETURN AVG_PRICE;
END;
/
SELECT GET_AVG_PRICE FROM DUAL;

--3.4 User Defined Table Valued Functions
---Task – Create a function that returns all employees who are born after 1968.
CREATE OR REPLACE FUNCTION GET_1968_EMPLOYEES
RETURN SYS_REFCURSOR IS EMPLOYEES1968 SYS_REFCURSOR;
BEGIN
    OPEN EMPLOYEES1968
    FOR SELECT FIRSTNAME, LASTNAME, BIRTHDATE 
    FROM EMPLOYEE
    WHERE BIRTHDATE >  '31-DEC-68';
    RETURN EMPLOYEES1968;
END;
/
SELECT GET_1968_EMPLOYEES() FROM DUAL;

/***4.0 Stored Procedures***************************************************************/
--4.1 Basic Stored Procedure
---Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE getNamesEmployees
AS C1 SYS_REFCURSOR;
BEGIN
    OPEN C1 FOR
    SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
    DBMS_SQL.RETURN_RESULT(C1);
END;
/
EXECUTE getNamesEmployees;

--4.2 Stored Procedure Input Parameters
---Task – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE UPDATE_PERSONAL_INFO
(ID NUMBER)
AS
BEGIN
    UPDATE EMPLOYEE SET LASTNAME = 'Tide' WHERE EMPLOYEEID = ID;
    UPDATE EMPLOYEE SET FIRSTNAME = 'Roll' WHERE EMPLOYEEID = ID;
END;
/
EXECUTE UPDATE_PERSONAL_INFO(1);

---Task – Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE getManagers
(ID NUMBER)
AS C2 SYS_REFCURSOR;
BEGIN
    OPEN C2 FOR
    SELECT A.EMPLOYEEID,A.FIRSTNAME,B.FIRSTNAME AS REPORTSTO, B.LASTNAME AS LASTNAME 
    FROM EMPLOYEE A JOIN EMPLOYEE B 
    ON A.REPORTSTO = B.EMPLOYEEID WHERE A.EMPLOYEEID = ID;
    DBMS_SQL.RETURN_RESULT(C2);
END;
/
EXECUTE getManagers(2);

--4.3 Stored Procedure Output Parameters
---Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE GET_CUSTOMER
(ID NUMBER, S OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN S FOR
    SELECT FIRSTNAME, LASTNAME, COMPANY FROM CUSTOMER WHERE CUSTOMERID = ID;
END;
/

DECLARE
S SYS_REFCURSOR;
FIRST_NAME CUSTOMER.FIRSTNAME%TYPE;
LAST_NAME CUSTOMER.LASTNAME%TYPE;
COMPANY CUSTOMER.COMPANY%TYPE;
BEGIN
GET_CUSTOMER(1,S);
FETCH S INTO FIRST_NAME, LAST_NAME, COMPANY;
DBMS_OUTPUT.PUT_LINE(FIRST_NAME ||' '|| LAST_NAME || ' WORKS FOR ' || COMPANY);
CLOSE S;
END;
/

SET SERVEROUTPUT ON;

/******5.0 Transactions*******************************************************/
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
CREATE OR REPLACE TRIGGER DELETE_INVOICE
BEFORE DELETE ON INVOICE
BEGIN
    DELETE FROM INVOICELINE WHERE INVOICEID = 1;
END;
/

BEGIN
SAVEPOINT sp1;
DELETE FROM INVOICE WHERE INVOICEID = 1;
ROLLBACK TO sp1;
COMMIT;
END;
/

DROP TRIGGER DELETE_INVOICE;

----Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
CREATE OR REPLACE PROCEDURE INSERT_CUSTOMER
AS
BEGIN
        INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL)
        VALUES(62, 'Roll', 'Tide', 'rolltide@gmail.com');
        COMMIT;
END;
/

EXECUTE INSERT_CUSTOMER;
/***6.0 Triggers**************************************************/
--6.1 AFTER/FOR
---Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER T_INSERT
AFTER INSERT ON EMPLOYEE
BEGIN
    UPDATE EMPLOYEE SET LASTNAME = 'YAY' WHERE EMPLOYEEID = 8;
END;
/

INSERT INTO EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME, EMAIL)
VALUES (9, 'SOME', 'BODY', 'SOMEBODY@GMAIL.COM');

DROP TRIGGER T_INSERT;

---Task – Create an after update trigger on the album table that fires after a row is updated in the table
CREATE OR REPLACE TRIGGER T_UPDATE
AFTER UPDATE ON ALBUM
BEGIN
    DELETE FROM EMPLOYEE WHERE EMPLOYEEID = 9;
END;
/
--
UPDATE ALBUM
SET TITLE = 'HIPPO'
WHERE ALBUMID = '50';

DROP TRIGGER T_UPDATE;
---Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER T_DELETE
AFTER DELETE ON CUSTOMER
BEGIN
    INSERT INTO EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME, EMAIL)
    VALUES (9, 'SOME', 'BODY', 'SOMEBODY@GMAIL.COM');
END;
/
--
DELETE FROM CUSTOMER WHERE CUSTOMERID = 61;

DROP TRIGGER T_DELETE;
/******7.0 Joins**************************************************/
--7.1 INNER
---Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT C.FIRSTNAME, C.LASTNAME , I.INVOICEID FROM CUSTOMER C
JOIN INVOICE I ON C.CUSTOMERID = I.CUSTOMERID;
--7.2 OUTER
---Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT C.CUSTOMERID, C.FIRSTNAME, C.LASTNAME, I.INVOICEID, I.TOTAL FROM CUSTOMER C
FULL OUTER JOIN INVOICE I ON C.CUSTOMERID = I.CUSTOMERID;
--7.3 RIGHT
---Task – Create a right join that joins album and artist specifying artist name and title.
SELECT AR.NAME, AL.TITLE FROM ALBUM AL
RIGHT JOIN ARTIST AR ON AL.ARTISTID = AR.ARTISTID;
--7.4 CROSS
---Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT DISTINCT AR.NAME FROM ALBUM AL
CROSS JOIN ARTIST AR
ORDER BY AR.NAME;
--7.5 SELF
---Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT A.FIRSTNAME, A.LASTNAME, B.FIRSTNAME AS REPORTSTO, B.LASTNAME AS LASTNAME 
FROM EMPLOYEE A JOIN EMPLOYEE B 
ON A.REPORTSTO = B.EMPLOYEEID;