SET serveroutput ON;
--2.0 SQL Queries
--2.1 SELECT
--Select all records from the Employee table
SELECT * 
FROM EMPLOYEE;
--Select all records from the Employee table where last name is 'King'
SELECT * 
FROM EMPLOYEE
WHERE LASTNAME = 'King';
--Select all records from the Employee table where fist name is Andrew and REPORTISTO is NULL
SELECT *
FROM EMPLOYEE
WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;

--2.2 ORDER BY
--Select all albums in Album table and sort result set in descending order by title
SELECT *
FROM ALBUM
ORDER BY TITLE DESC;

--Select first name from Customer and sort result set in ascending order by city
SELECT FIRSTNAME
FROM CUSTOMER
ORDER BY CITY ASC;

--2.3 INSERT INTO
--Insert two new records into Genre table
INSERT INTO GENRE (GENREID, NAME)
VALUES (26, 'Psychobilly');
INSERT INTO GENRE (GENREID, NAME)
VALUES (27, 'Shoegaze');

--Insert two new records into Employee table
INSERT INTO EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE, HIREDATE,
ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL)
VALUES (9, 'Reznor', 'Trent', 'IT Staff', 6, '17-MAY-65', '21-APR-05',
'455 Lakeview Drive SW', 'Brooks', 'AB', 'Canada', 'T1K 2Z9', '+1 (403)-789-1212',
'+1 (403)-789-8452', 'trent@chinookcorp.com');

INSERT INTO EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE, HIREDATE,
ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL)
VALUES (10, 'Macdonald', 'Norm', 'IT Staff', 6, '17-OCT-59', '27-MAY-05',
'279 Snowy Hill Road SW', 'Brooks', 'AB', 'Canada', 'T1J 3X8', '+1 (403)-848-2188',
'+1 (403)-848-6224', 'norm@chinookcorp.com');

--Insert two new records into Customer table
INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, ADDRESS, CITY, STATE,
COUNTRY, POSTALCODE, PHONE, FAX, EMAIL, SUPPORTREPID)
VALUES (60, 'James', 'Johnson', 'Nokia', '224 Ohana Street', 'Kailua', 'HI',
'USA', '96722', '+1 (808)-488-8787', '+1 (808)-488-1212', 'jj@yahoo.com', 4);

INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, ADDRESS, CITY, STATE,
COUNTRY, POSTALCODE, PHONE, FAX, EMAIL, SUPPORTREPID)
VALUES (61, 'Dale', 'Dillinger', 'Plastic Omnium', '445 Broad Street', 'Chattanooga', 'TN',
'USA', '37422', '+1 (423)-454-8964', '+1 (423)-454-4731', 'ddillinger@yahoo.com', 4);

--2.4 UPDATE
--Update Aaron Mitchell in Customer table to Robert Walter
UPDATE CUSTOMER
SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
WHERE CUSTOMERID = '32';

--Update name of artist in the Artist table �Creedence Clearwater Revival� to �CCR�	
UPDATE ARTIST
SET NAME = 'CCR'
WHERE ARTISTID = 76;

--2.5 LIKE
--Select all invoices with a billing address like �T%� 
SELECT *
FROM INVOICE
WHERE BILLINGADDRESS LIKE 'T%';

--2.6 BETWEEN
--Select all invoices that have a total between 15 and 50
SELECT *
FROM INVOICE
WHERE TOTAL BETWEEN 15.00 AND 50.00;

--Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT *
FROM EMPLOYEE
WHERE HIREDATE BETWEEN '01-JUN-03' AND '01-MAR-04';

--2.7 DELETE
--Delete a record in Customer table where the name is Robert Walter
--Delete records from INVOICELINE where INVOICEID are specific numbers from 50-342
DELETE FROM INVOICELINE
WHERE INVOICEID IN (50, 61, 116, 245, 268, 290, 342);

--Delete child dependencies from the INVOICE table where CUSTOMERID = 32
DELETE FROM INVOICE
WHERE CUSTOMERID = 32;

--Delete Robert Walter. His CUSTOMERID is 32.
DELETE FROM CUSTOMER
WHERE CUSTOMERID = 32;

--3.0 SQL Functions

--3.1 System Defined Functions
--Create a function that returns the current time.
--Create a function that returns the length of name in MEDIATYPE table

--create a function called 'get_time'
CREATE OR REPLACE FUNCTION get_time
--return a char variable
RETURN CHAR AS 
--create CHAR variable named sys_time 
--it is assigned to the current time
sys_time CHAR (20) := TO_CHAR(CURRENT_DATE, 'HH24:MI:SS');
BEGIN
--return sys_time
RETURN sys_time;
END;
/
--test the get_time function
SELECT get_time
FROM DUAL;

--Create a function that returns the length of name in MEDIATYPE table
--Takes in the media type id number
--Will return the length of the name of media type
CREATE OR REPLACE FUNCTION get_name_length(media_id NUMBER)
--return an INT variable
RETURN NUMBER AS 
--create an INT variable named name_length
--it is assigned to the length of the NAME in the MEDIATYPE table
--create a variable to store the name of the mediatype
media_name VARCHAR2(120);
name_length NUMBER;
BEGIN
--select the NAME column
SELECT NAME 
INTO media_name
FROM MEDIATYPE 
WHERE MEDIATYPEID = media_id;
--from the MEDIATYPE table
--return name_length 
--assign name_length to the length of the media name
name_length := LENGTH(media_name);
RETURN name_length;
END;
/

--Test the get_name_length function
SELECT get_name_length(5)
FROM DUAL;

--3.2 System Defined Aggregate Functions
--Create a function that returns the average total of all invoices 
CREATE OR REPLACE FUNCTION get_avg_inv_total
RETURN NUMBER AS
avg_inv_total NUMBER(10,2);
BEGIN
SELECT AVG(TOTAL)
--store the average into avg_inv_total
INTO avg_inv_total
FROM INVOICE;
RETURN avg_inv_total;
END;
/

--Test the get_avg_inv_total function
SELECT get_avg_inv_total
FROM DUAL;


--Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION get_max_track
RETURN VARCHAR2 AS
--create a variable to hold the track name
track_name VARCHAR2(200);
--create a variable to hold the price of the track
track_price NUMBER(10,2);
BEGIN
--store the most expensive track price into track_price
SELECT MAX(UNITPRICE)
INTO track_price
FROM TRACK;
--store the track name with the most expensive price into track_name
SELECT NAME
INTO track_name
FROM TRACK
--only select the first row that matches the max price
WHERE UNITPRICE = track_price AND ROWNUM = 1;

RETURN track_name;
END;
/

--Test the get_max_track function
SELECT get_max_track
FROM DUAL;

--3.3 User Defined Scalar Functions
--Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION get_avg_invlin_price
RETURN NUMBER AS
--create a variable to hold the avg price
avg_invlin_price NUMBER(10,2);
BEGIN
SELECT AVG (UNITPRICE)
INTO avg_invlin_price
FROM INVOICELINE;
RETURN avg_invlin_price;
END;
/

--Test the get_avg_invlin_price function
SELECT get_avg_invlin_price
FROM DUAL;

--3.4 User Defined Table Valued Functions
--create a function that returns all employees who are born after 1968.

CREATE OR REPLACE FUNCTION get_employees
RETURN SYS_REFCURSOR AS
--create a variable that stores a sys_refcursor
e_rc SYS_REFCURSOR;
BEGIN
OPEN e_rc
--use a for loop
FOR 
SELECT *
FROM EMPLOYEE
WHERE BIRTHDATE >= '01-JAN-69';
RETURN e_rc;
END;
/

--Test the get_employees function.
SELECT get_employees
FROM DUAL;

--4.0 Stored Procedures
--4.1 Basic Stored Procedure
--Create a stored procedure that selects the first and last names of all the employees.
--use a SYS_REFCURSOR
CREATE OR REPLACE PROCEDURE get_emp_first_last(
e_rc OUT SYS_REFCURSOR)
AS
BEGIN
OPEN e_rc 
FOR
SELECT FIRSTNAME, LASTNAME
FROM EMPLOYEE;
END;

--4.2 Stored Procedure Input Parameters
--Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE update_emp (eid NUMBER, ln VARCHAR2, fn VARCHAR2, 
tl VARCHAR2, rt NUMBER, bd DATE, hd DATE, ad VARCHAR2, cy VARCHAR2, st VARCHAR2, 
cou VARCHAR2, poc VARCHAR2, ph VARCHAR2, fx VARCHAR2, el VARCHAR2)
AS
BEGIN
UPDATE EMPLOYEE 
SET EMPLOYEEID = eid, LASTNAME = ln, FIRSTNAME = fn, TITLE = tl, REPORTSTO = rt, 
BIRTHDATE = bd, HIREDATE = hd, ADDRESS = ad, CITY = cy, STATE = st, COUNTRY = cou, 
POSTALCODE = poc, PHONE = ph, FAX = fx, EMAIL = el;
END;
/

--Create a stored procedure that returns the managers of an employee.
--use a SYS_REFCURSOR
CREATE OR REPLACE PROCEDURE get_mans_of_emp (eid NUMBER,
e_rc OUT SYS_REFCURSOR)
AS
BEGIN
OPEN e_rc 
--use a for loop
FOR
SELECT REPORTSTO 
FROM EMPLOYEE 
WHERE EMPLOYEEID = eid;
END;
/

--4.3 Stored Procedure Output Parameters
--Create a stored procedure that returns the name and company of a customer.
--use a SYS_REFCURSOR
CREATE OR REPLACE PROCEDURE get_name_comp_of_cust(
e_rc out SYS_REFCURSOR)
AS
BEGIN
OPEN e_rc 
--use a for loop
FOR
SELECT FIRSTNAME, LASTNAME, COMPANY 
FROM CUSTOMER;
END;
/

--5.0 Transactions
--Create a transaction that given a invoiceId will delete that invoice 
CREATE OR REPLACE PROCEDURE delete_invoice(
inv_id NUMBER)
AS
BEGIN
DELETE 
FROM INVOICE 
WHERE INVOICEID = inv_id;
COMMIT;
END;
/

--Create a transaction nested within a stored procedure that inserts a new record in the Customer table
CREATE OR REPLACE PROCEDURE insert_customer(cid NUMBER, fn VARCHAR2, ln VARCHAR2, co VARCHAR2, ad VARCHAR2,
ci VARCHAR2, st VARCHAR2, cy VARCHAR2, pc VARCHAR2, ph VARCHAR2, fx VARCHAR2, em VARCHAR2, srepid NUMBER)
AS
BEGIN
--Insert record into CUSTOMER table
INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, ADDRESS, CITY, STATE,
COUNTRY, POSTALCODE, PHONE, FAX, EMAIL, SUPPORTREPID)
VALUES (cid, fn, ln, co, ad, ci, st, cy, pc, ph, fx, em, srepid);
COMMIT;
END;
/

--6.0 Triggers
--6.1 AFTER/FOR
--Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER insert_on_employee
AFTER INSERT ON EMPLOYEE
BEGIN
DBMS_OUTPUT.PUT_LINE('Employee record inserted');
END;
/

--Create an after update trigger on the album table that fires after a row is inserted in the table.
CREATE OR REPLACE TRIGGER insert_on_album
AFTER INSERT ON ALBUM
BEGIN
DBMS_OUTPUT.PUT_LINE('Album record inserted');
END;
/
--Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER delete_on_customer
AFTER DELETE ON CUSTOMER
BEGIN
DBMS_OUTPUT.PUT_LINE('Customer record deleted');
END;
/
--7.0 JOINS
--7.1 INNER
--Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
--select columns FIRSTNAME, LASTNAME, and INVOICEID
SELECT CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID
FROM CUSTOMER
INNER JOIN INVOICE 
--CUSTOMERID must match in both tables
ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;

--7.2 OUTER
--Create an outer join that joins the customer and invoice table,
--specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT CUSTOMER.CUSTOMERID, CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID,
INVOICE.TOTAL
FROM CUSTOMER
FULL OUTER JOIN INVOICE 
--CUSTOMERID must match in both tables
ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;

--7.3 RIGHT
--Create a right join that joins album and artist specifying artist name and title.
SELECT ARTIST.NAME, ALBUM.TITLE
FROM ALBUM
RIGHT JOIN ARTIST 
ON ALBUM.ARTISTID = ARTIST.ARTISTID
ORDER BY ARTIST.ARTISTID;

--7.4 CROSS
--Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT * 
FROM ALBUM
CROSS JOIN ARTIST
ORDER BY ARTIST.NAME ASC;

--7.5 SELF
--Perform a self-join on the employee table, joining on the reports to column.
SELECT *
FROM EMPLOYEE e1, EMPLOYEE e2
WHERE e1.REPORTSTO = e2.REPORTSTO
ORDER BY e1.EMPLOYEEID;

--END--