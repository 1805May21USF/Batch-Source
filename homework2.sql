--2.1Select all records from the Employee table.
SELECT * FROM EMPLOYEE;

--2.1Select all records from the Employee table where last name is King
SELECT * FROM EMPLOYEE
WHERE LASTNAME = 'King';

--2.1Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM EMPLOYEE
WHERE FIRSTNAME = 'Andrew'
AND
REPORTSTO IS NULL;

--2.2 ORDER BY
--2.2 Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM ALBUM
ORDER BY TITLE DESC;

--2.2Select first name from Customer and sort result set in ascending order by city
SELECT FIRSTNAME FROM CUSTOMER
ORDER BY CITY ASC;

--2.3 INSERT INTO
--2.3Insert two new records into Genre table 
INSERT INTO GENRE
VALUES ('26','Personal');
INSERT INTO GENRE
VALUES('27','Nonpersonal');

--2.3 Insert two new records into EMPLOYEE table 
INSERT INTO EMPLOYEE
VALUES('9','BAYNE','DUSTIN','IT STAFF','6','10-JAN-1989','05-MAR-05','1500 SOUTH ST','CALGARY','AB','CANADA','T1H 1Y8','1 (789) 345 6789','1 (123) 456 7890','A@A.CHINOOKORP.COM');
INSERT INTO EMPLOYEE
VALUES('10','SMITH','JOHN','IT STAFF','6','10-JAN-1984','05-MAR-07','1600 SOUTH ST','CALGARY','AB','CANADA','T1H 1Y8','1 (789) 456 6789','1 (123) 456 79870','AB@A.CHINOOKORP.COM');

--2.3Insert two new records into CUSTOMER table 
INSERT INTO CUSTOMER
VALUES('60','JOHN','MAN','APPLE','5142 48 Street','Yellowknife','NT','Canada','X1A','1N6','+1 (867) 920-5656','JOHN.MAN@shaw.ca','3');
INSERT INTO CUSTOMER
VALUES('71','HANNAH','GILBERT','APPLE','5187 48 Street','Yellowknife','NT','Canada','X1A','1N6','+1 (867) 920-4756','HANNAH.GILBERT@shaw.ca','3');

--2.4UPDATE
--2.4Update Aaron Mitchell in Customer table to Robert Walter
UPDATE CUSTOMER
SET FIRSTNAME = 'Robert',LASTNAME = 'Walter'
WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';

--2.4 Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE ARTIST
SET NAME = 'CCR'
WHERE NAME = 'Creedence Clearwater Revival';
--2.5 LIKE
SELECT * FROM INVOICE
WHERE BILLINGADDRESS LIKE 'T%';

--2.6 BETWEEN
--2.6 Select all invoices that have a total between 15 and 50
SELECT * FROM INVOICE
WHERE TOTAL BETWEEN 15 AND 50;

--2.6 Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM EMPLOYEE
WHERE HIREDATE BETWEEN TO_DATE ('01/06/2003','DD/MM/YYYY') AND TO_DATE ('01/03/2004','DD/MM/YYYY');

--2.7DELETE
--2.7Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
ALTER TABLE INVOICE
DROP CONSTRAINT FK_INVOICECUSTOMERID;

DELETE FROM CUSTOMER
WHERE FIRSTNAME = 'ROBERT' and LASTNAME = 'WALTER';
ALTER TABLE INVOICE
ENABLE CONSTRAINT FK_INVOICECUSTOMERID;

--3 SQL FUNCTIONS
--3.1 Create a function that returns the current time.
--TO_CHAR(CURRENT_DATE, 'HH24:MI:SS');
CREATE OR REPLACE FUNCTION TIMENOW
RETURN TIMESTAMP AS CURTIME TIMESTAMP;
BEGIN
SELECT LOCALTIMESTAMP INTO CURTIME FROM DUAL;
RETURN CURTIME;
END;
/
SELECT TO_CHAR(TIMENOW,'HH24:MI:SS') FROM DUAL;
--3.1 create a function that returns the length of name in MEDIATYPE table
CREATE OR REPLACE FUNCTION LEN_MED(TYPE_ID IN NUMBER)
RETURN NUMBER AS LENG NUMBER;
BEGIN
SELECT LENGTH(NAME) INTO LENG FROM MEDIATYPE WHERE MEDIATYPEID = TYPE_ID;
RETURN LENG;
END;
/
SELECT LEN_MED(2) FROM DUAL;
--3.2 AVERAGE INVOICES
--3.2Create a function that returns the average total of all invoices 
CREATE OR REPLACE FUNCTION INVOICEAVG
RETURN NUMBER
AS AVG_RET NUMBER;
BEGIN
SELECT AVG(TOTAL) INTO AVG_RET FROM INVOICE;
RETURN (AVG_RET);
END;
/
SELECT INVOICEAVG FROM DUAL;
--3.2  Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION MOST_EXPENSIVE
RETURN NUMBER AS MAX_PRICE NUMBER;
BEGIN
SELECT MAX(UNITPRICE) INTO MAX_PRICE FROM TRACK;
RETURN MAX_PRICE;
END;
/
SELECT MOST_EXPENSIVE FROM DUAL;

--3.3 Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION INVOICELINEAVG
RETURN NUMBER AS INVOIC NUMBER;
BEGIN
SELECT AVG(UNITPRICE) INTO INVOIC FROM INVOICELINE;
RETURN INVOIC;
END;
/
SELECT INVOICELINEAVG FROM DUAL;
--3.4 TO DO
CREATE OR REPLACE FUNCTION EMPLOYEEBIRTH
RETURN TABLE AS HERE TABLE;
BEGIN
SELECT LASTNAME,FIRSTNAME INTO HERE FROM EMPLOYEE;
RETURN HERE;
END;
/
--4.1 BASIC STORED PROCEDURE TODO
CREATE OR REPLACE PROCEDURE GET_ALL_EMPLOYEES (S OUT SYS_REFCURSOR)
IS 
BEGIN
OPEN S FOR 
SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
END;
/
DECLARE
S SYS_REFCURSOR;
FIRST_NAME EMPLOYEE.FIRSTNAME%TYPE;
LAST_NAME EMPLOYEE.LASTNAME%TYPE;
BEGIN
GET_ALL_EMPLOYEES(S);
LOOP
FETCH S INTO FIRST_NAME,LAST_NAME;
EXIT WHEN S%NOTFOUND; --BREAK OUT OF LOOP WHEN NO MORE ROWS ARE AVAILABLE
DBMS_OUTPUT.PUT_LINE(FIRST_NAME||' IS FIRSTNAME,'|| LAST_NAME||'IS LASTNAME');
END LOOP;
CLOSE S;
END;


--4.2
CREATE OR REPLACE PROCEDURE EMPLOYEEUPDATE
(
EMPID IN NUMBER,
LASTN IN VARCHAR2,
FIRSTN IN VARCHAR2,
NEWTITLE IN VARCHAR2,
NEWREPORTSTO IN NUMBER,
NEWBIRTH IN DATE,
NEWHIRE IN DATE,
NEWADDR IN VARCHAR2,
NEWCITY IN VARCHAR2,
NEWST IN VARCHAR2,
COUNTR IN VARCHAR2,
NEWPOSTAL IN VARCHAR2,
PHON IN VARCHAR2,
FX IN VARCHAR2,
EMAI IN VARCHAR2
)
AS
BEGIN
UPDATE EMPLOYEE
SET LASTNAME = COALESCE(LASTN,LASTNAME),
FIRSTNAME = COALESCE(FIRSTN,FIRSTNAME),
TITLE = NEWTITLE,
REPORTSTO = NEWREPORTSTO,
BIRTHDATE = NEWBIRTH,
HIREDATE = NEWHIRE,
ADDRESS = NEWADDR,
CITY = NEWCITY,
STATE = NEWST,
COUNTRY = COUNTR,
POSTALCODE = NEWPOSTAL,
PHONE = PHON,
FAX = FX,
EMAIL = EMAI

WHERE EMPLOYEEID = EMPID;
END EMPLOYEEUPDATE;
/

--4.2 RETURNS MANAGER OF EMPLOYEE

--4.3 Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE COMPANY(COMPANY_ NUMBER,S OUT SYS_REFCURSOR)
IS
BEGIN
OPEN S FOR
SELECT FIRSTNAME,LASTNAME,COMPANY FROM CUSTOMER WHERE CUSTOMER.CUSTOMERID = COMPANY_;
END;
/

DECLARE
S SYS_REFCURSOR;
FIRST_NAME CUSTOMER.FIRSTNAME%TYPE;
LAST_NAME CUSTOMER.LASTNAME%TYPE;
COMPANY_ CUSTOMER.COMPANY%TYPE;
BEGIN
COMPANY(1,S);
LOOP
FETCH S INTO FIRST_NAME,LAST_NAME,COMPANY_;
EXIT WHEN S%NOTFOUND;
DBMS_OUTPUT.PUT_LINE(FIRST_NAME||' '||LAST_NAME||' IS CUSTOMER NAME,' ||COMPANY_||' IS COMPANY');
END LOOP;
CLOSE S;
END;

--5.0
--5.0Create a transaction that given a invoiceId will delete that invoice
ALTER TABLE INVOICELINE DROP CONSTRAINT FK_INVOICELINEINVOICEID;

ALTER TABLE INVOICELINE
ADD CONSTRAINT FK_INVOICELINEINVOICEID
FOREIGN KEY(INVOICEID)
REFERENCES INVOICE(INVOICEID)
ON DELETE CASCADE;
CREATE OR REPLACE PROCEDURE DELINV(
INVOICE_ID IN NUMBER
)
AS
BEGIN
DELETE FROM INVOICE WHERE INVOICEID = INVOICE_ID;
COMMIT;
END;
/
EXECUTE DELINV(404);
--5.0Create a transaction nested within a stored procedure that inserts a new record in the Customer
CREATE OR REPLACE PROCEDURE NEWCUST(
NEWCUSTOMERID IN NUMBER,
NEWFIRSTNAME IN VARCHAR2,
NEWLASTNAME IN VARCHAR2,
NEWEMAIL IN VARCHAR2
)
AS
BEGIN
INSERT INTO CUSTOMER ("CUSTOMERID","FIRSTNAME","LASTNAME","EMAIL")
VALUES(NEWCUSTOMERID,NEWFIRSTNAME,NEWLASTNAME,NEWEMAIL);
COMMIT;
END;
/
--TRIGGER
CREATE OR REPLACE TRIGGER T
AFTER
INSERT
ON EMPLOYEE
BEGIN
DBMS_OUTPUT.PUT_LINE('FINISHED INSERTING');
END;
/
CREATE OR REPLACE TRIGGER T2
AFTER
UPDATE
ON ALBUM
BEGIN
DBMS_OUTPUT.PUT_LINE('FINISHED UPDATING');
END;
/
DROP TRIGGER T2;
CREATE OR REPLACE TRIGGER T3
AFTER
DELETE
ON CUSTOMER
BEGIN
DBMS_OUTPUT.PUT_LINE('FINISHED DELETE');
END;
/
--7.1 INNER JOINS NAME CUSTOMER AND INVOICE ID
SELECT CUSTOMER.FIRSTNAME,CUSTOMER.LASTNAME,INVOICE.INVOICEID
FROM CUSTOMER
INNER JOIN INVOICE
ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;
--7.2 OUTER JOINS CUSTOMER ID INVOICE ID FIRSTNAME LASTNAME TOTAL
SELECT CUSTOMER.FIRSTNAME,
CUSTOMER.LASTNAME,
CUSTOMER.CUSTOMERID,
INVOICE.INVOICEID,
INVOICE.CUSTOMERID,
INVOICE.TOTAL
FROM CUSTOMER
FULL OUTER JOIN INVOICE
ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;
--7.3 RIGHT JOIN ALBUM AND ARTIST SPECIFYING ARTIST NAME AND TITLE
SELECT ARTIST.NAME,ALBUM.TITLE
FROM ARTIST
RIGHT OUTER JOIN ALBUM
ON ALBUM.ARTISTID = ARTIST.ARTISTID;
--7.4Create a cross join that joins album and artist and sorts by artist name in ascending order
SELECT * FROM ALBUM
CROSS JOIN ARTIST
ORDER BY ARTIST.NAME ASC;
--7.5Perform a self-join on the employee table, joining on the reportsto column.
SELECT E1.LASTNAME,E2.LASTNAME
FROM EMPLOYEE E1, EMPLOYEE E2
WHERE E1.REPORTSTO = E2.REPORTSTO;
