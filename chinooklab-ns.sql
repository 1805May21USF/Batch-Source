--2.1 SELECT
SELECT * FROM EMPLOYEE;

SELECT * FROM EMPLOYEE
WHERE LASTNAME = 'King';

SELECT * FROM EMPLOYEE
WHERE FIRSTNAME = 'Andrew'
AND REPORTSTO IS NULL;

--2.2 ORDER BY
SELECT * FROM ALBUM
ORDER BY TITLE DESC;

SELECT FIRSTNAME FROM CUSTOMER
ORDER BY CITY ASC;

--2.3 INSERT INTO
INSERT INTO GENRE(GENREID, NAME)
VALUES(26,'ANIME');
INSERT INTO GENRE(GENREID, NAME)
VALUES(27,'EDM');

INSERT INTO EMPLOYEE VALUES(9,'Ross','Bob','Painter',NULL,'29-OCT-42','5-MAY-18',
'123 Brush Ave','Orlando','FL','USA',32789,'+1 (234) 567-8901',NULL,'Bob.Ross@paint.gov');
INSERT INTO EMPLOYEE VALUES(10,'Ross2','Bob2','Painter',NULL,'29-NOV-42','5-JUNE-18',
'123 Paint Ave','Orlando','FL','USA',32789,'+1 (098) 765-4321',NULL,'Bob.Ross@brush.gov');

INSERT INTO CUSTOMER(CUSTOMERID,FIRSTNAME,LASTNAME,EMAIL)
VALUES(60,'Bob','Ross','Bob.Ross@happytrees.gov');
INSERT INTO CUSTOMER(CUSTOMERID,FIRSTNAME,LASTNAME,EMAIL)
VALUES(61,'Michael','Nwokocha','Michael.Nwokocha@nekomimi.com');

--2.4 UPDATE
UPDATE CUSTOMER
SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';

UPDATE ARTIST
SET NAME = 'CCR'
WHERE NAME = 'Creedence Clearwater Revival';

--2.5 LIKE
SELECT * FROM INVOICE
WHERE BILLINGADDRESS LIKE 'T%';

--2.6 BETWEEN
SELECT * FROM INVOICE
WHERE TOTAL
BETWEEN 15 AND 50;

SELECT * FROM EMPLOYEE
WHERE HIREDATE
BETWEEN TO_DATE('1-JUN-03') AND TO_DATE('1-MAR-04');

--2.7 DELETE
DELETE FROM INVOICELINE
WHERE INVOICEID IN (SELECT INVOICEID FROM INVOICE
WHERE CUSTOMERID IN (SELECT CUSTOMERID FROM CUSTOMER
WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter'));
DELETE FROM INVOICE
WHERE INVOICEID IN (SELECT INVOICEID FROM INVOICE
WHERE CUSTOMERID IN (SELECT CUSTOMERID FROM CUSTOMER
WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter'));
DELETE FROM CUSTOMER
WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';

--3.1 SYSTEM-DEFINED FUNCTIONS 
CREATE OR REPLACE FUNCTION GET_TIME
RETURN VARCHAR2 AS T VARCHAR(260);
BEGIN
SELECT TO_CHAR(SYSDATE, 'HH:MI:SS AM') INTO T FROM DUAL;
RETURN T;
END;
/
SELECT GET_TIME() FROM DUAL;

CREATE OR REPLACE FUNCTION GET_LENGTH (MEDIA_NAME IN VARCHAR2)
RETURN NUMBER AS NAME_LENGTH NUMBER;
BEGIN
RETURN LENGTH(MEDIA_NAME);
END;
/
SELECT GET_LENGTH(NAME) FROM MEDIATYPE;

--3.2 SYSTEM-DEFINED AGGREGATE FUNCTIONS
CREATE OR REPLACE FUNCTION AVG_INVOICES
RETURN NUMBER AS AVERAGE NUMBER(10,2);
BEGIN
SELECT AVG(TOTAL) INTO AVERAGE FROM INVOICE;
RETURN AVERAGE;
END;
/
SELECT AVG_INVOICES() FROM DUAL;

CREATE OR REPLACE FUNCTION MAX_PRICE
RETURN NUMBER AS MAXIMUM NUMBER(10,2);
BEGIN
SELECT MAX(UNITPRICE) INTO MAXIMUM FROM TRACK;
RETURN MAXIMUM;
END;
/
SELECT MAX_PRICE() FROM DUAL;

--3.3 USER-DEFINED SCALAR FUNCTIONS
CREATE OR REPLACE FUNCTION AVG_PRICE
RETURN NUMBER AS AVERAGE NUMBER(10,2);
BEGIN
SELECT AVG(UNITPRICE) INTO AVERAGE FROM INVOICELINE;
RETURN AVERAGE;
END;
/
SELECT AVG_PRICE() FROM DUAL;

--3.4 USER-DEFINED TABLE VALUED FUNCTIONS
--CREATE OR REPLACE FUNCTION EMPLOYEE1968 (S OUT SYS_REFCURSOR)
--RETURN VARCHAR2 AS EMP VARCHAR2(100);
--BEGIN
--OPEN S FOR
--SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE
--WHERE EXTRACT(YEAR FROM BIRTHDATE) > 1968;
--RETURN EMP;
--END;
--/


--4.1 BASIC STORED PROCEDURES
SET SERVEROUTPUT ON;

CREATE OR REPLACE PROCEDURE GET_ALL_EMPLOYEE (S OUT SYS_REFCURSOR)
IS 
BEGIN
OPEN S FOR 
SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
END;
/

DECLARE 
    S SYS_REFCURSOR;
    FIRSTNAME EMPLOYEE.FIRSTNAME%TYPE;
    LASTNAME EMPLOYEE.LASTNAME%TYPE;
BEGIN 
GET_ALL_EMPLOYEE(S);
    LOOP
        FETCH S INTO FIRSTNAME, LASTNAME;
        EXIT WHEN S%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(FIRSTNAME||' '||LASTNAME);
    END LOOP;
    CLOSE S;
END;
/

--4.2
--CREATE OR REPLACE PROCEDURE UPDATE_EMP_INFO (S OUT SYS_REFCURSOR)
--IS
--BEGIN
--OPEN S FOR

--4.3 STORED PROCEDURE OUTPUT PARAMETERS
--SET SERVEROUTPUT ON;
--
--CREATE OR REPLACE PROCEDURE GET_NAME_AND_COMPANY (S OUT SYS_REFCURSOR)
--IS
--BEGIN
--OPEN S FOR
--SELECT FIRSTNAME, LASTNAME, COMPANY FROM CUSTOMER;
--END;
--/
--
--DECLARE
--    S SYS_CURSOR;
--    FIRSTNAME CUSTOMER.FIRSTNAME%TYPE;
--    LASTNAME CUSTOMER.LASTNAME%TYPE;
--    COMPANY CUSTOMER.COMPANY%TYPE;
--BEGIN
--GET_NAME_AND_COMPANY(S);
--    LOOP
--        FETCH S INTO FIRSTNAME,LASTNAME,COMPANY;
--        EXIT WHEN S%NOTFOUND;
--        DBMS_OUTPUT.PUT_LINE(FIRSTNAME||' '||LASTNAME||' '||COMPANY);
--    END LOOP;
--    CLOSE S;
--END;
--/

--5.0 TRANSACTIONS


--6.1 AFTER/FOR

--7.1 INNER
SELECT CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME,
INVOICE.INVOICEID
FROM CUSTOMER
INNER JOIN INVOICE ON
CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;

--7.2 OUTER
SELECT CUSTOMER.CUSTOMERID, CUSTOMER.FIRSTNAME,
CUSTOMER.LASTNAME, INVOICE.INVOICEID, INVOICE.TOTAL
FROM CUSTOMER
FULL OUTER JOIN INVOICE ON
CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;

--7.3 RIGHT
SELECT ALBUM.TITLE, ARTIST.NAME
FROM ALBUM
RIGHT OUTER JOIN ARTIST ON
ALBUM.ARTISTID = ARTIST.ARTISTID;

--7.4 CROSS
SELECT * FROM ALBUM
CROSS JOIN ARTIST
ORDER BY ARTIST.NAME ASC;

--7.5 SELF
SELECT A.FIRSTNAME, A.LASTNAME, B.FIRSTNAME, B.LASTNAME
FROM EMPLOYEE A, EMPLOYEE B
WHERE A.REPORTSTO = B.EMPLOYEEID;