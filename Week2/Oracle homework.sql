--/*
--2.0 SQL Queries
--In this section you will be performing various queries against the Oracle Chinook database.
--2.1 SELECT
--Task – Select all records from the Employee table.
--Task – Select all records from the Employee table where last name is King.
--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
--2.2 ORDER BY
--Task – Select all albums in Album table and sort result set in descending order by title.
--Task – Select first name from Customer and sort result set in ascending order by city
--2.3 INSERT INTO
--Task – Insert two new records into Genre table 
--Task – Insert two new records into Employee table
--Task – Insert two new records into Customer table
--2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter
--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”    
--2.5 LIKE
--Task – Select all invoices with a billing address like “T%” 
--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
--
--SQL Functions
--In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database
--3.1 System Defined Functions
--Task – Create a function that returns the current time.
--Task – create a function that returns the length of name in MEDIATYPE table
--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices 
--Task – Create a function that returns the most expensive track
--3.3 User Defined Scalar Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.
--4.0 Stored Procedures
-- In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.
--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.
--Task – Create a stored procedure that returns the managers of an employee.
--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.
--5.0 Transactions
--In this section you will be working with transactions. Transactions are usually nested within a stored procedure.
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
--6.0 Triggers
--In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
--7.0 JOINS
--In this section you will be working with combining various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.
--*/




--2.1 
SELECT * FROM EMPLOYEE;

SELECT * FROM EMPLOYEE
WHERE LASTNAME = 'KING';

SELECT * FROM EMPLOYEE
WHERE FIRSTNAME = 'ANDREW' AND REPORTSTO = NULL;

--2.2
SELECT * FROM ALBUM
ORDER BY TITLE DESC;

SELECT FIRSTNAME FROM CUSTOMER
ORDER BY CITY ASC;

--2.3
INSERT INTO GENRE
VALUES(26, 'tibetan throat singing');

INSERT INTO GENRE
VALUES(101, 'banjo');

INSERT INTO EMPLOYEE
VALUES(200, 'Worker', 'Hard', 'Employee', 5, '1988-08-22', '2018-5-10', '50 Zinc Rd', 'Baxton', 'Washington', 'United States', 91020, 12212, 'whard@gmail.com');

INSERT INTO EMPLOYEE
VALUES(10001, 'Bosser', 'Large', 'Boss', 6, '1982-06-12', '2018-1-11', '22 Langstone Rd', 'Westly', 'California', 'United States', 16107, 22112ll, 'lbosser@gmail.com');

INSERT INTO CUSTOMER
VALUES(1000, 'Hubert', 'Humphrey', 'DamWell', '1024 Wellspring Dr', 'Irving', 'Pennsylvania', 'United States', 38291, '555-5555', 11111, 8743090, 'hhump@yahoo.com');

INSERT INTO CUSTOMER
VALUES(1001, 'Ferris', 'Wheeler', 'Rounders', '590 Circle Blvd', 'Weston', 'Tennessee', 'United States', 10901, '555-5555', null, 'ferriswheel@gmail.com', null);

--2.4
UPDATE CUSTOMER SET FIRSTNAME='Robert', LASTNAME='Walter' WHERE FIRSTNAME='Aaron' AND LASTNAME='Mitchell';
UPDATE ARTIST SET NAME='CCR' WHERE NAME='Creedence Clearwater Revival';

--2.5
SELECT * FROM INVOICE
WHERE BILLINGADDRESS LIKE 'T%';

--2.6
SELECT * FROM INVOICE
WHERE TOTAL BETWEEN 15 AND 50;

SELECT * FROM EMPLOYEE
WHERE HIREDATE BETWEEN '03-JUL-01' AND '04-MAR-01';

--2.7
DELETE FROM CUSTOMER
WHERE FIRSTNAME='Robert' AND LASTNAME='Walter';

--3.1

CREATE OR REPLACE FUNCTION CURRENTTIME
RETURN DATETIME AS
BEGIN
CURRENT_TIMESTAMP;
END;
/

CREATE OR REPLACE FUNCTION NAMELENGTH
(MEDIANAME VARCHAR2)
RETURN INTEGER IS
BEGIN
SELECT LEN(
NAME FROM MEDIATYPE
WHERE NAME IS MEDIANAME
)
END
/

--3.2

CREATE OR REPLACE FUNCTION INVOICETOTAL
RETURN NUMBER 
IS RTOTAL NUMBER;
BEGIN
SELECT AVG(TOTAL) INTO RTOTAL
FROM INVOICE;
RETURN RTOTAL;
END;
/

CREATE OR REPLACE FUNCTION EXPENSIVETRACK
RETURN NUMBER
IS RMAX NUMBER;
BEGIN
SELECT MAX(UNITPRICE) INTO RMAX
FROM TRACK;
RETURN RMAX;
END;
/

--3.3

CREATE OR REPLACE FUNCTION AVGINVOICE
RETURN NUMBER
IS RAVG NUMBER;
BEGIN
SELECT AVG(UNITPRICE) INTO RAVG
FROM INVOICELINE;
RETURN RAVG;
END;
/

--3.4

CREATE OR REPLACE FUNCTION EMPRETURN
RETURN VARCHAR2
AS CURSOR S IS SELECT * FROM EMPLOYEE WHERE BIRTHDATE>'68-DEC-31';
BEGIN

RETURN S;
END;
/

--3.5

--4.1
CREATE PROCEDURE SELECTFL
BEGIN
SELECT FIRSTNAME AND LASTNAME
FROM EMPLOYEE
COMMIT;
END;

--4.2
CREATE OR REPLACE PROCEDURE UPDATEEMP
(P_EMPLOYEEID IN NUMBER, P_TITLE IN VARCHAR2, P_REPORTSTO IN NUMBER, P_ADDRESS IN VARCHAR2, P_CITY IN VARCHAR2, 
P_STATE IN VARCHAR2, P_COUNTRY IN VARCHAR2, P_POSTALCODE IN NUMBER, P_PHONE IN VARCHAR2, P_EMAIL IN VARCHAR2)
AS
BEGIN
UPDATE EMPLOYEE
SET TITLE=P_TITLE,
    REPORTSTO=P_REPORTSTO,
    ADDRESS=P_ADDRESS,
    CITY=P_CITY,
    STATE=P_STATE,
    COUNTRY=P_COUNTRY,
    POSTALCODE=P_POSTALCODE,
    PHONE=P_PHONE,
    EMAIL=P_EMAIL
WHERE EMPLOYEEID=P_EMPLOYEEID;
COMMIT;
END;


CREATE OR REPLACE PROCEDURE EMPMANAGERS
(P_LASTNAME IN VARCHAR2, P_FIRSTNAME IN VARCHAR2)
AS
BEGIN

SELECT REPORTSTO FROM EMPLOYEE
WHERE FIRSTNAME=P_FIRSTNAME AND LASTNAME=P_LASTNAME;
COMMIT;
END;

--4.3

CREATE OR REPLACE PROCEDURE NAMECOMP
(P_CUSTOMERID IN NUMBER, REPORTS OUT VARCHAR2)
AS
BEGIN
SELECT FIRSTNAME, LASTNAME, COMPANY INTO REPORTS FROM CUSTOMER
WHERE CUSTOMERID=P_CUSTOMERID;
COMMIT;
END;

--5.0
CREATE OR REPLACE PROCEDURE DELETEID
(P_INVOICEID IN NUMBER)
AS
BEGIN
DELETE FROM INVOICE
WHERE INVOICEID=P_INVOICEID;
COMMIT;
END;

CREATE OR REPLACE PROCEDURE INSERTCUSTOMER
(P_CUSTOMERID IN NUMBER, P_FIRSTNAME IN VARCHAR2, P_LASTNAME IN VARCHAR2, P_COMPANY IN VARCHAR2, P_ADDRESS IN VARCHAR2,
P_CITY IN VARCHAR2, P_STATE IN VARCHAR2, P_COUNTRY IN VARCHAR2, P_POSTALCODE IN VARCHAR2, P_PHONE IN VARCHAR2, P_FAX IN VARCHAR2, 
P_EMAIL IN VARCHAR2, P_SUPPORTREPID IN NUMBER)
AS
BEGIN
INSERT INTO CUSTOMER
VALUES(P_CUSTOMERID, P_FIRSTNAME, P_LASTNAME, P_COMPANY, P_ADDRESS, P_CITY, P_STATE, P_COUNTRY, P_POSTALCODE, P_PHONE, P_FAX, P_EMAIL, P_SUPPORTREPID);
COMMIT;
END;

--6.1 AFTER/FOR
CREATE OR REPLACE TRIGGER EMPLOYEETRIGGER 
AFTER
INSERT 
ON EMPLOYEE
END; 

CREATE OR REPLACE TRIGGER ALBUMTRIGGER 
AFTER
INSERT 
ON ALBUM
END; 

CREATE OR REPLACE TRIGGER CUSTOMERTRIGGER 
AFTER
DELETE 
ON ALBUM
END;

--7.1
SELECT CUSTOMER.CUSTOMERID, INVOICE.CUSTOMERID FROM CUSTOMER
INNER JOIN INVOICE ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;

--7.2
SELECT CUSTOMER.CUSTOMERID, CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID, INVOICE.TOTAL FROM CUSTOMER
FULL OUTER JOIN INVOICE ON CUSTOMER.CUSTOMERID=INVOICE.INVOICEID;

--7.3

SELECT ARTIST.NAME, ALBUM.TITLE
FROM ALBUM
RIGHT JOIN ARTIST ON ALBUM.ALBUMID = ARTIST.ARTISTID;

--7.4 
SELECT *
FROM ARTIST
CROSS JOIN ALBUM ORDER BY ARTIST.NAME ASC;

--7.5
SELECT * FROM EMPLOYEE E1, EMPLOYEE E2
WHERE E1.REPORTSTO = E2.EMPLOYEEID;
