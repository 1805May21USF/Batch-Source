-- https://docs.google.com/document/d/1De6zZgF2xHmIjmGnKNm3TLuoNQScn7nw8LzYkC2b2bg/edit?usp=sharing

-- Using Chinook_Oracle.sql from https://github.com/lerocha/chinook-database
-- Setting up

-- SQL Chinook Lab --

-- Jacqueline Tummala --


-- 2.1 SELECT

-- Task - Select all records from the Employee table where last name is King.
SELECT * FROM EMPLOYEE; -- uppercase/lowercase doesn't matter.

-- Task – Select all records from the Employee table where last name is King.
SELECT * FROM EMPLOYEE
WHERE LASTNAME = 'King'; -- Use single quote.

-- Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM EMPLOYEE
WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;


-- 2.2 ORDER BY

-- Task – Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM ALBUM
ORDER BY TITLE DESC;

-- Task – Select first name from Customer and sort result set in ascending order by city
SELECT FIRSTNAME FROM CUSTOMER
ORDER BY CITY ASC;


-- 2.3 INSERT INTO

-- Task – Insert two new records into Genre table 
SELECT * FROM GENRE
ORDER BY GENREID ASC;

INSERT INTO GENRE (GENREID, NAME) VALUES (26, 'Nature'); -- GENREID is not auto incrementing, so must insert ID manually for now.
INSERT INTO GENRE (GENREID, NAME) VALUES (27, 'Study');

-- Task – Insert two new records into Employee table
SELECT * FROM EMPLOYEE
ORDER BY EMPLOYEEID DESC;

INSERT INTO EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE,
HIREDATE, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL)
VALUES (9, 'Flag', 'Red', 'IT Staff', 6, '01-JAN-00','01-JAN-2010','123 ABC ST', 'TAMPA', 'FL', 'USA', 33617, '+1 (813) 990-0000', '+1 (813) 990-0000', 'red.flag@chinooklab.com');

INSERT INTO EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE,
HIREDATE, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL)
VALUES (10, 'Flag', 'Blue', 'IT Staff', 6, '01-FEB-01','01-FEB-2011','123 ABC ST', 'TAMPA', 'FL', 'USA', 33617, '+1 (813) 990-0001', '+1 (813) 990-0001', 'blue.flag@chinooklab.com');


-- Task – Insert two new records into Customer table
SELECT * FROM CUSTOMER
ORDER BY CUSTOMERID DESC;

INSERT INTO CUSTOMER 
VALUES (60, 'Flam', 'Rem', 'Revature', '123 ABC ST', 'TAMPA', 'FL', 'USA', 33617, '+1 (813) 990-0000', '+1 (813) 990-0000', 'rem.flam@chinooklab.com', 1);

INSERT INTO CUSTOMER 
VALUES (61, 'Flam', 'Bluem', 'Revature', '123 ABC ST', 'TAMPA', 'FL', 'USA', 33617, '+1 (813) 990-0001', '+1 (813) 990-0001', 'bluem.flam@chinooklab.com', 2);


-- 2.4 UPDATE
-- VIEW CUSTOMER
SELECT * FROM CUSTOMER
WHERE LASTNAME = 'Mitchell' AND FIRSTNAME = 'Aaron';

-- Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE CUSTOMER
SET LASTNAME = 'Walter', FIRSTNAME = 'Robert'
WHERE LASTNAME = 'Mitchell' AND FIRSTNAME = 'Aaron';

-- CHECK
SELECT * FROM CUSTOMER
WHERE LASTNAME = 'Walter' AND FIRSTNAME = 'Robert';

-- Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
-- VIEW CUSTOMER
SELECT * FROM ARTIST
WHERE NAME = 'Creedence Clearwater Revival';

UPDATE ARTIST
SET NAME = 'CCR'
WHERE NAME = 'Creedence Clearwater Revival';

-- VIEW
SELECT * FROM ARTIST
WHERE NAME = 'CCR';


-- 2.5 LIKE
SELECT * FROM INVOICE;

-- Task – Select all invoices with a billing address like “T%” 
SELECT * FROM INVOICE
WHERE BILLINGADDRESS LIKE 'T%';


-- 2.6 BETWEEN
SELECT * FROM INVOICE;

-- Task – Select all invoices that have a total between 15 and 50
SELECT * FROM INVOICE
WHERE TOTAL BETWEEN 15 AND 50;

-- Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM EMPLOYEE
ORDER BY HIREDATE ASC;

SELECT * FROM EMPLOYEE
WHERE HIREDATE BETWEEN '01-JAN-03' AND '31-MAR-04';


-- 2.7 DELETE
SELECT * FROM CUSTOMER
WHERE LASTNAME = 'Walter' AND FIRSTNAME = 'Robert';

-- Task – Delete a record in Customer table where the name is Robert Walter 
-- (There may be constraints that rely on this, find out how to resolve them).

--DELETE FROM CUSTOMER
--WHERE LASTNAME = 'Walter' AND FIRSTNAME = 'Robert';

ALTER TABLE CUSTOMER
DROP CONSTRAINT FK_CUSTOMERSUPPORTREPID;

ALTER TABLE CUSTOMER
ADD CONSTRAINT FK_CUSTOMERSUPPORTREPID
FOREIGN KEY (SUPPORTREPID)
REFERENCES EMPLOYEE(EMPLOYEEID)
ON DELETE CASCADE;

