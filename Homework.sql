--Task – Select all records from the Employee table.

SELECT * FROM  EMPLOYEE;

--Task – Select all records from the Employee table where last name is King.

SELECT * FROM EMPLOYEE WHERE LASTNAME = 'King';

--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.

SELECT * FROM EMPLOYEE WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;

--Task – Select all albums in Album table and sort result set in descending order by title.

SELECT * FROM ALBUM ORDER BY  TITLE DESC;

--Task – Select first name from Customer and sort result set in ascending order by city

SELECT FIRSTNAME FROM CUSTOMER ORDER BY CITY DESC;

--Task – Insert two new records into Genre table 
INSERT INTO GENRE ( GENREID ,NAME) VALUES ( 30, 'MIDNIGHT TO MIDNIGHT');
INSERT INTO GENRE ( GENREID ,NAME) VALUES ( 45, 'DRAGON BALL Z');

--Task – Insert two new records into Employee table

INSERT INTO EMPLOYEE ( EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE,REPORTSTO,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL)
VALUES (9,'GARCIA','EDWIN','REVATURE ASSOCIATE',2,'DISNEY WORLD ROAD','ORLANDO','FL','USA','33645','408-897-898','4344','DISNEY123@GMAIL.COM');
--INSERT INTO EMPLOYEE (BIRTHDATE, HIREDATE)VALUES( DATE '1993-02-22', '2010-03-22');

--Task – Insert two new records into Customer table

INSERT INTO CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID) 
VALUES ( 60,'EDWIN','GARCIA','LOCKHEED MARTIN','JARDINES DE AGUADILLA','SAN JUAN','PR','USA','HDJ34','787-873-2498','234543','EDWIN@GMAIL.COM',5);

INSERT INTO CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID) 
VALUES ( 61,'BILLY','SMITH','RAYMOND JAMES','RAYMOND STREET','SAINT PETERSBURG','FL','USA','ER56','727-873-2498','234543','ROLLTIDE@GMAIL.COM',3);

--Task – Update Aaron Mitchell in Customer table to Robert Walter

UPDATE CUSTOMER SET FIRSTNAME = 'ROBERT', LASTNAME ='WALTER' WHERE CUSTOMERID =32;

--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”	

UPDATE ARTIST SET NAME ='CCR' WHERE ARTISTID =76;

--Task – Select all invoices with a billing address like “T%” 
SELECT * FROM INVOICE  WHERE BILLINGADDRESS LIKE 'T%';

--Task – Select all invoices that have a total between 15 and 50
SELECT * FROM INVOICE WHERE TOTAL BETWEEN 15 AND 20;

--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM EMPLOYEE WHERE HIREDATE BETWEEN '01-JUNE-2003' AND '01-MARCH-2004';

--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them)

DELETE FROM INVOICELINE WHERE INVOICEID = 60;

DELETE FROM INVOICE
WHERE CUSTOMERID = 32;
(SELECT CUSTOMERID FROM CUSTOMER
WHERE CUSTOMERID =32);

-- FUNCTIONS
--Task – Create a function that returns the current time.
SELECT TO_CHAR
    (SYSDATE, 'MM-DD-YYYY HH24:MI:SS') "NOW"
     FROM DUAL;
     
--Task – create a function that returns the length of name in MEDIATYPE table



CREATE OR REPLACE FUNCTION getl(str IN STRING)
   RETURN NUMBER
   IS
   BEGIN
       RETURN LENGTH(str);
   END getl;  
/

SELECT getl(NAME) FROM MEDIATYPE;

--Task – Create a function that returns the average total of all invoices 

--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices 
CREATE OR REPLACE FUNCTION GETAVG (INTE IN INTEGER)
RETURN NUMBER
IS
BEGIN
    RETURN AVG(INTE);
END;
/
SELECT AVG(TOTAL)
FROM INVOICE;
--Task – Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION GETMAX (INTE IN INTEGER)
RETURN NUMBER
IS
BEGIN
    RETURN MAX(INTE);
END;
/
SELECT AVG(UNITPRICE)
FROM TRACK;
--3.3 User Defined Scalar Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION GETAVGPRICE (INTE IN INTEGER)
RETURN NUMBER
IS
BEGIN
    RETURN AVG(INTE);
END;
/
SELECT AVG(UNITPRICE)
FROM INVOICELINE;
--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.
CREATE OR REPLACE FUNCTION AGE(INT IN INTEGER)
RETURN NUMBER
IS V_KIDDOS NUMBER;
cursor c1 is SELECT EMPLOYEEID FROM EMPLOYEE
WHERE BIRTHDATE > '31-DEC-68';
BEGIN
open c1;
fetch c1 into V_KIDDOS;
close c1;
RETURN V_KIDDOS;
END;
/
SELECT AGE(EMPLOYEEID)FROM EMPLOYEE;
--4.0 Stored Procedures
--In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE PROCEDURE GETNAMES
AS V_NAMES STRING
CURSOR C1 AS SELECT FIRSTNAME AND LASTNAME FROM EMPLOYEE;
BEGIN
open C1;
fetch C1 into V_NAMES;
close C1;
COMMIT;
END;
SELECT GETNAMES(FIRSTNAME, LASTNAME) FROM EMPLOYEE;
--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE UPDATE_EMPLOYEE 
(
  THE_EMPLOYEEID IN NUMBER,
  NEW_LASTNAME IN VARCHAR2,
  NEW_FIRSTNAME IN VARCHAR2,
  NEW_TITLE IN VARCHAR2,
  NEW_REPORTSTO IN NUMBER,
  NEW_BIRTHDATE IN DATE,
  NEW_HIREDATE IN DATE,
  NEW_ADDRESS IN VARCHAR2,
  NEW_CITY IN VARCHAR2,
  NEW_STATE IN VARCHAR2,
  NEW_COUNTRY VARCHAR2,
  NEW_POSTALCODE VARCHAR2,
  NEW_PHONE VARCHAR2,
  NEW_FAX VARCHAR2,
  NEW_EMAIL VARCHAR2
)
AS 
BEGIN
  UPDATE EMPLOYEE
  SET LASTNAME = 
        CASE WHEN new_lastname IS NULL
     THEN lastname
     ELSE new_lastname
 END
      FIRSTNAME =
        CASE WHEN new_firstname IS NULL
     THEN firstname
     ELSE new_firstname
 END
      TITLE = NEW_TITLE,
      REPORTSTO = NEW_REPORTSTO,
      BIRTHDATE = NEW_BIRTHDATE,
      HIREDATE = NEW_HIREDATE,
      ADDRESS = NEW_ADDRESS,
      CITY = NEW_CITY,
      STATE = NEW_STATE,
      COUNTRY = NEW_COUNTRY,
      POSTALCODE = NEW_POSTALCODE,
      PHONE = NEW_PHONE,
      FAX = NEW_FAX,
      EMAIL = NEW_EMAIL
    WHERE EMPLOYEEID = THE_EMPLOYEEID;
END UPDATE_EMPLOYEE;
--Task – Create a stored procedure that returns the managers of an employee.
create or replace PROCEDURE MANAGER_OF_EMPLOYEE 
(
  THE_EMPLOYEEID IN NUMBER
)
AS 
  TEMP VARCHAR2(20);
  TEMP2 VARCHAR2(20);
  TEMP3 VARCHAR2(20);
  TEMP4 VARCHAR2(20);
BEGIN
  SELECT MGR.FIRSTNAME, MGR.LASTNAME, EMP.FIRSTNAME, EMP.LASTNAME INTO TEMP, TEMP2, TEMP3, TEMP4
  FROM EMPLOYEE EMP
  LEFT OUTER JOIN EMPLOYEE MGR 
ON MGR.EMPLOYEEID = EMP.REPORTSTO
  WHERE EMP.EMPLOYEEID = THE_EMPLOYEEID AND EMP.REPORTSTO = MGR.EMPLOYEEID;
  DBMS_OUTPUT.PUT_LINE(TEMP || ' ' || TEMP2 || ' IS THE MANAGER OF ' || TEMP3 || ' ' || TEMP4);
END MANAGER_OF_EMPLOYEE;
--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.
CREATE PROCEDURE GETNAMEANDCOMPANTY
AS V_NAMEANDCOMPANY STRING
CURSOR C1 AS SELECT FIRSTNAME AND COMPANY FROM EMPLOYEE;
BEGIN
open c1;
fetch c1 into V_NAMEANDCOMPANY;
close c1;
COMMIT;
END;





