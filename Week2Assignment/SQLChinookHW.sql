--2.1 SELECT

-- Select all records from the Employee table
SELECT * FROM EMPLOYEE;

-- Select all records from the Employee table where
-- the last name is King
SELECT * FROM EMPLOYEE
WHERE (LASTNAME= 'King');

-- Select all records from the Employee table where
-- first name is Andrew and REPORTSTO is NULL
SELECT * FROM EMPLOYEE
WHERE (FIRSTNAME = 'Andrew')
AND (REPORTSTO IS NULL);


--ORDER BY

-- Select all albums in Album table and sort result set
-- in descending order by title
SELECT * FROM ALBUM
ORDER BY TITLE DESC;


-- Select all first name from from Customer and sort result
-- sets in ascending order by city
SELECT FIRSTNAME FROM CUSTOMER
ORDER BY CITY ASC;
 
 

--21.3 INSERT INTO

-- Insert two new records into Genre table
INSERT INTO GENRE(GENREID,NAME) VALUES(26,'JAPANESE POP');
INSERT INTO GENRE(GENREID,NAME) VALUES(27,'KOREAN POP');

-- Insert two new records into Employee table
INSERT INTO EMPLOYEE(EMPLOYEEID,LASTNAME,FIRSTNAME,TITLE,
    REPORTSTO,BIRTHDATE,HIREDATE,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,
    PHONE,FAX,EMAIL)
    VALUES (9,'White','John','Custodian',1,'20-NOV-88','16-FEB-03','100 South Ave',
        'Edmonton','AB','Canada','T5K 2T3','+1 (780) 123-4567','+1 (780) 765-4321',
        'johnthecustodian@chinookcorp.com');
        
INSERT INTO EMPLOYEE(EMPLOYEEID,LASTNAME,FIRSTNAME,TITLE,
    REPORTSTO,BIRTHDATE,HIREDATE,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,
    PHONE,FAX,EMAIL)
    VALUES (10,'Purama','Sunny','IT INTERN',6,'14-FEB-99','16-FEB-18','123 Main St',
        'Long Beach','CA','United States','90812','+1 (562) 123-4567','+1 (562) 765-4321',
        'sunnytheintern@chinookcorp.com');
        
-- Insert two new records into Customer table
INSERT INTO CUSTOMER(CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,
    COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID)
    VALUES (60,'Randal','Rudolph','Sunny Corporation','303 N Small Ave','Tampa','FL',
    'USA',33601,'+1 (123) 123-4567','+1 (123) 765-4321','randolrudolph@email.com',4);
    
INSERT INTO CUSTOMER(CUSTOMERID,FIRSTNAME,LASTNAME,ADDRESS,CITY,STATE,
    COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID)
    VALUES (61,'Carl','Trent','303 W Big Ave','Charlotte','NC',
    'USA',28802,'+1 (704) 123-4567','+1 (704) 765-4321','carktrent22@email.com',4);
    
--2.4 Update

--Update Aaron Mitchell in Customer table to Robert Walter
UPDATE CUSTOMER
    SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
    WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';

--Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”	
UPDATE ARTIST
    SET NAME = 'CCR'
    WHERE NAME = 'Creedence Clearwater Revival';

--2.5 LIKE

--Select all invoices with a billing address like “T%” 
SELECT * FROM INVOICE
    WHERE BILLINGADDRESS LIKE 'T%';

--2.6 BETWEEN

--Select all invoices that have a total between 15 and 50
SELECT * FROM INVOICE
    WHERE TOTAL
    BETWEEN 15 AND 20;

--Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM EMPLOYEE
    WHERE HIREDATE
    BETWEEN TO_DATE('June 1, 2003', 'Month dd, yyyy') AND
        TO_DATE('March 1, 2004', 'Month dd, yyyy');

--2.7 DELETE
--Delete a record in Customer table where the name is Robert Walter 
--(There may be constraints that rely on this, find out how to resolve 
--them).
DELETE FROM INVOICELINE WHERE INVOICEID IN
    (SELECT INVOICEID FROM INVOICE WHERE CUSTOMERID IN
        (SELECT CUSTOMERID FROM CUSTOMER 
        WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter'));

DELETE FROM INVOICE
    WHERE CUSTOMERID IN 
    (SELECT CUSTOMERID FROM CUSTOMER WHERE FIRSTNAME = 'Robert' 
        AND LASTNAME = 'Walter');

DELETE FROM CUSTOMER
    WHERE FIRSTNAME= 'Robert' 
    AND LASTNAME= 'Walter';

--3.1 System Defined Functions

--Create a function that returns the current time.
CREATE OR REPLACE FUNCTION TIMENOW
RETURN DATE
AS
BEGIN
RETURN TO_DATE(CURRENT_DATE);
END;
/
SELECT TIMENOw FROM DUAL;

--create a function that returns the length of name in MEDIATYPE table
CREATE OR REPLACE FUNCTION NAMELENGTH(MLENGTH IN STRING)
    RETURN NUMBER
    AS
    BEGIN
        RETURN LENGTH(MLENGTH);
    END;
/
SELECT NAMELENGTH(NAME) FROM MEDIATYPE;
   
   
--3.2 System Defined Aggregate Functions

--Create a function that returns the average total of all invoices 
CREATE OR REPLACE FUNCTION AVGTOTAL
    RETURN NUMBER AS
    AVG_TOTAL NUMBER(10,2);
    BEGIN
        SELECT AVG(TOTAL) 
        INTO AVG_TOTAL FROM INVOICE;
        RETURN AVG_TOTAL;
    END;
    /

SELECT AVGTOTAL FROM DUAL;

--Create a function that returns the most expensive track 
CREATE OR REPLACE FUNCTION METRACK
    RETURN NUMBER AS TOPCOST NUMBER (10,2);
    BEGIN
        SELECT MAX(UNITPRICE) INTO TOPCOST FROM TRACK;
        RETURN TOPCOST;
    END;
    /

SELECT METRACK FROM DUAL;

-- 3.3 User Defined Scalar Functions

-- Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION AVG_IN_LINE_ITEM
    RETURN NUMBER AS
    AVG_ITEM_TOTAL NUMBER(10,2);
    BEGIN
        SELECT AVG(UNITPRICE) 
        INTO AVG_ITEM_TOTAL FROM INVOICELINE;
        RETURN AVG_ITEM_TOTAL;
    END;
    /
SELECT AVG_IN_LINE_ITEM FROM DUAL;

-- 3.4 User Defined Table Valued Functions
-- Create a function that returns all employees who are born after 1968.
CREATE OR REPLACE TYPE EMPLOYEE_OBJ_TYPE
AS OBJECT(
    EMPLOYEEID NUMBER,
    LASTNAME VARCHAR2(20),
    FIRSTNAME VARCHAR2(20),
    TITLE VARCHAR2(30),
    REPORTSTO NUMBER,
    BIRTHDATE DATE,
    HIREDATE DATE,
    ADDRESS VARCHAR2(70),
    CITY VARCHAR2(40),
    STATE VARCHAR2(40),
    COUNTRY VARCHAR2(40),
    POSTALCODE VARCHAR2(10),
    PHONE VARCHAR2(24),
    FAX VARCHAR2(24),
    EMAIL VARCHAR2(60)
    )
    /
    
    CREATE OR REPLACE FUNCTION GET_AFTER_1968_EMP
    RETURN EMPLOYEE_OBJ_TYPE
    AS
    PLUS_1968 EMPLOYEE_OBJ_TYPE;
    BEGIN
    SELECT EMPLOYEE_OBJ_TYPE(EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE,
        REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS, CITY, STATE, COUNTRY,
        POSTALCODE, PHONE, FAX, EMAIL)
        INTO PLUS_1968 FROM EMPLOYEE
    WHERE BIRTHDATE > TO_DATE('January 1, 1968', 'Month dd, yyyy');
    RETURN PLUS_1968;
    END;
    /
    
SELECT GET_AFTER_1968_EMP FROM DUAL;
    



CREATE OR REPLACE FUNCTION GET_AFTER_1968_EMP
    RETURN EMPLOYEE%ROWTYPE
    AS
    PLUS_1968 EMPLOYEE%ROWTYPE;
    BEGIN
    SELECT * INTO PLUS_1968 FROM EMPLOYEE;
    --WHERE BIRTHDATE > TO_DATE('January 1, 1968', 'Month dd, yyyy');
    RETURN PLUS_1968;
    END;
    /
    
SELECT GET_AFTER_1968_EMP FROM DUAL;

SELECT * FROM EMPLOYEE 
WHERE BIRTHDATE > TO_DATE('January 1, 1968', 'Month dd, yyyy');


-- 4.1 Basic Stored Procedures
-- Create a stored procedure that selects the first and last names 
-- of all the employees.
CREATE OR REPLACE PROCEDURE GETALLEMPLOYEES(OUT SYSREF
AS
TEMP EMPLOYEE;
BEGIN
SELECT FIRSTNAME, LASTNAME INTO TEMP FROM EMPLOYEE;
END;
/

SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;

--4.2 Stored Procedure Input Parameters
-- Create a stored procedure that updates the
-- personal information of an employee.


-- Create a stored procedure that returns the managers of an employee.

--4.3 Stored Procedure Output Parameters
--Create a stored procedure that returns the name and company of a customer.

--5.0 Transactions
--Create a transaction that given a invoiceId will delete that invoice 
--(There may be constraints that rely on this, find out how to resolve them).


--Create a transaction nested within a stored procedure that inserts 
--a new record in the Customer table


--6.1 AFTER/FOR
--Create an after insert trigger on the employee table fired after a
--new record is inserted into the table.


--Create an after update trigger on the album table that fires after a 
--row is inserted in the table


--Create an after delete trigger on the customer table that 
--fires after a row is deleted from the table.



--7.1 INNER
--Create an inner join that joins customers and orders and 
--specifies the name of the customer and the invoiceId.
SELECT CUSTOMER.FIRSTNAME,CUSTOMER.LASTNAME, INVOICE.INVOICEID
FROM CUSTOMER 
INNER JOIN INVOICE
ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;


--7.2 OUTER
--Create an outer join that joins the customer and invoice table, 
--specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT CUSTOMER.CUSTOMERID, CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME,
   INVOICE.INVOICEID, INVOICE.TOTAL
FROM CUSTOMER
FULL OUTER JOIN INVOICE
ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;

--7.3 RIGHT
--Create a right join that joins album and artist specifying artist name and title.
SELECT ARTIST.NAME, ALBUM.TITLE
FROM ARTIST
RIGHT JOIN ALBUM
ON ARTIST.ARTISTID = ALBUM.ARTISTID;

--7.4 CROSS
--Create a cross join that joins album and artist and sorts 
--by artist name in ascending order.
SELECT ARTIST.NAME, ALBUM.TITLE
FROM ARTIST
CROSS JOIN ALBUM
WHERE ARTIST.ARTISTID = ALBUM.ARTISTID
ORDER BY ARTIST.NAME ASC;



--7.5 SELF
--Perform a self-join on the employee table, joining on the reportsto column.
SELECT A.FIRSTNAME AS EMPLOYEE, B.FIRSTNAME AS REPORTSTO
FROM EMPLOYEE A, EMPLOYEE B
WHERE A.REPORTSTO= B.EMPLOYEEID;

