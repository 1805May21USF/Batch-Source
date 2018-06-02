--Alex Patton's SQL lab
/*
 2.0 SQL Queries
In this section you will be performing various queries against the Oracle Chinook database.
2.1 SELECT
Task – Select all records from the Employee table.
Task – Select all records from the Employee table where last name is King.
Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
*/
SELECT
    *
FROM
    employee;

SELECT
    *
FROM
    employee
WHERE
    lastname = 'King';

SELECT
    *
FROM
    employee
WHERE
    firstname = 'Andrew'
    AND reportsto IS NULL;

/*
2.2 ORDER BY
Task – Select all albums in Album table and sort result set in descending order by title.
Task – Select first name from Customer and sort result set in ascending order by city
*/

SELECT
    *
FROM
    album
ORDER BY
    title DESC;

SELECT
    firstname
FROM
    customer
ORDER BY
    city ASC;
/*
2.3 INSERT INTO
Task – Insert two new records into Genre table 
Task – Insert two new records into Employee table
Task – Insert two new records into Customer table
*/

INSERT INTO genre VALUES (
    999,
    'G1'
);

INSERT INTO genra VALUES (
    312,
    'G2'
);

INSERT INTO employee VALUES (
    99999,
    'DUMB',
    'PERSON',
    NULL,
    NULL,
    NULL,
    NULL,
    NULL,
    NULL,
    NULL,
    NULL,
    NULL,
    NULL,
    NULL,
    NULL
);

INSERT INTO employee VALUES (
    99939,
    'DUMB',
    'PERSON',
    NULL,
    NULL,
    NULL,
    NULL,
    NULL,
    NULL,
    NULL,
    NULL,
    NULL,
    NULL,
    NULL,
    NULL
);

INSERT INTO customer VALUES (
    88888,
    'RANDO',
    'BOB',
    NULL,
    NULL,
    NULL,
    NULL,
    NULL,
    NULL,
    NULL,
    NULL,
    'JUNKEMAIL.COM',
    NULL
);

INSERT INTO customer VALUES (
    88889,
    'RANDO',
    'BOB',
    NULL,
    NULL,
    NULL,
    NULL,
    NULL,
    NULL,
    NULL,
    NULL,
    'JUNKEMAIL.COM',
    NULL
);


/*
2.4 UPDATE
Task – Update Aaron Mitchell in Customer table to Robert Walter
Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”	
*/

UPDATE customer
SET
    firstname = 'Robert',
    lastname = 'Walter'
WHERE
    firstname = 'Aaron'
    AND lastname = 'Mitchell';

UPDATE artist
SET
    name = 'CCR'
WHERE
    name = 'Creedence Clearwater Revival';

/*
2.5 LIKE
Task – Select all invoices with a billing address like “T%” 
*/

SELECT
    *
FROM
    invoice
WHERE
    billingaddress LIKE 'T%';
/*
2.6 BETWEEN
Task – Select all invoices that have a total between 15 and 50
Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
*/

SELECT
    *
FROM
    invoice
WHERE
    total < 50
    AND total > 15;

SELECT
    *
FROM
    employee
WHERE
    hiredate >= DATE '2003-06-01'
    AND hiredate <= DATE '2004-03-01';
/*
2.7 DELETE
Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
*/
--I had to do an insert. Not sure why.
--INSERT INTO CUSTOMER VALUES (999991, 'Robert', 'Walter',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

DELETE FROM invoiceline
WHERE
    invoiceid = ANY (
        SELECT
            invoiceid
        FROM
            invoice
        WHERE
            customerid = (
                SELECT
                    customerid
                FROM
                    customer
                WHERE
                    firstname = 'Robert'
                    AND lastname = 'Walter'
            )
    );

DELETE FROM invoice
WHERE
    customerid = (
        SELECT
            customerid
        FROM
            customer
        WHERE
            firstname = 'Robert'
            AND lastname = 'Walter'
    );

DELETE FROM customer
WHERE
    firstname = 'Robert'
    AND lastname = 'Walter';
/*
SQL Functions
In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database
3.1 System Defined Functions
Task – Create a function that returns the current time.
Task – create a function that returns the length of name in MEDIATYPE table
*/

CREATE OR REPLACE FUNCTION currtime RETURN VARCHAR
    AS
BEGIN
    return(TO_CHAR(current_date,'HH24:MI:SS') );
END;
/

SELECT
    currtime
FROM
    dual;

SELECT
    length(name)
FROM
    mediatype;

/*
3.2 System Defined Aggregate Functions
Task – Create a function that returns the average total of all invoices 
Task – Create a function that returns the most expensive track
*/

SELECT
    AVG(invoice.total)
FROM
    invoice;

SELECT
    MAX(unitprice)
FROM
    track;

/*
3.3 User Defined Scalar Functions
Task – Create a function that returns the average price of invoiceline items in the invoiceline table
*/

CREATE OR REPLACE FUNCTION invoavg RETURN NUMBER AS
    avgp   NUMBER(10,2);
BEGIN
    SELECT
        AVG(unitprice * quantity)
    INTO avgp
    FROM
        invoiceline;

    return(avgp);
END;
/

SELECT
    invoavg
FROM
    dual;
/*
3.4 User Defined Table Valued Functions
Task – Create a function that returns all employees who are born after 1968.
*/
/*
drop type TableForFunction;
CREATE or replace type TypeForFunction as object (n varchar2(90) );

CREATE or replace type TableForFunction as table of TypeForFunction; 

CREATE OR REPLACE FUNCTION getyoungsters RETURN TableForFunction AS
youngsters TableForFunction ;
BEGIN
SELECT LASTNAME INTO youngsters from EMPLOYEE where BIRTHDATE after date '1968-1-1';
RETURN(youngsters );
END;
/
select getyoungsters from dual;
*/

SELECT
    lastname
FROM
    employee
WHERE
    birthdate > DATE '1968-1-1';

/*
4.0 Stored Procedures
 In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
4.1 Basic Stored Procedure
Task – Create a stored procedure that selects the first and last names of all the employees.
*/

CREATE OR REPLACE PROCEDURE firstlast (
    cursorresults OUT SYS_REFCURSOR
)
    AS
BEGIN
    OPEN cursorresults FOR SELECT
        firstname,
        lastname
                           FROM
        employee;

END;
/
set serveroutput on;
DECLARE
    cursorout   SYS_REFCURSOR;
    firstname   employee.firstname%TYPE;
    lastname    employee.lastname%TYPE;
begin 
firstlast(cursorout);
 loop 
 fetch cursorout into firstname, lastname;
 exit when cursorout%notfound; --exit when no more rows are avaliable
 DBMS_OUTPUT.PUT_LINE(firstname || ' , then ' || lastname);
 end loop;
 close cursorout;
end;
/
/*
4.2 Stored Procedure Input Parameters
Task – Create a stored procedure that updates the personal information of an employee.
Task – Create a stored procedure that returns the managers of an employee.
*/
CREATE OR REPLACE PROCEDURE updatePersonal (
fname in varchar2
, lname in varchar2
, newfname in varchar2
, newlname in varchar2 ) AS
BEGIN
update EMPLOYEE set firstname=newfname, lastname=newlname where firstname = fname and lastname = lname;

end updatePersonal;
/

select * from EMPLOYEE;

execute updatepersonal( 'PERSON', 'DUMB','PERSON', 'DUMMY');
select * from EMPLOYEE;


CREATE OR REPLACE PROCEDURE getManagers (
idnum in number) AS

BEGIN
declare
 managers number;
 BEGIN
select EMPLOYEE.reportsto into managers from EMPLOYEE  where EMPLOYEEID = idnum;
 DBMS_OUTPUT.PUT_LINE(managers || ' is the manager of number ' || idnum);
end;
end getManagers;
/

select * from EMPLOYEE;
set serveroutput on;

execute getManagers( 4);

/*
4.3 Stored Procedure Output Parameters
Task – Create a stored procedure that returns the name and company of a customer.
*/
CREATE OR REPLACE PROCEDURE getCompAndName (
idnum in number, cname out varchar2, company out varchar2) AS

 BEGIN
select customer.firstname||' ' ||customer.lastname into cname from CUSTOMER where customerID = idnum;
select CUSTOMER.COMPANY into company from CUSTOMER where CUSTOMERID=idnum;
 DBMS_OUTPUT.PUT_LINE(cname || ' works at ' || company);
end getCompAndName;
/
declare
 a varchar2(344);
 b varchar2(444);
 BEGIN
 getCompAndName( 1, a, b);
end;
/
/*
5.0 Transactions
In this section you will be working with transactions. Transactions are usually nested within a stored procedure.
Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer 
*/
CREATE OR REPLACE PROCEDURE transactionInvoiceDel (
ivID in number) AS
 BEGIN
DELETE FROM invoiceline WHERE invoiceid = ivID;
DELETE FROM invoice WHERE invoiceid = ivID;


end transactionInvoiceDel;
/
SET TRANSACTION NAME 'invoice_delete';
execute transactionInvoiceDel(111);
commit;



CREATE OR REPLACE PROCEDURE addBob AS
 BEGIN
 SET TRANSACTION NAME 'adding_bob';
insert into CUSTOMER Values(    88989,
    'RANDO',
    'ULTRABOB!',
    NULL,
    NULL,
    NULL,
    NULL,
    NULL,
    NULL,
    NULL,
    NULL,
    'JUNKEMAIL.COM',
    NULL
);
commit;
end addBob;
/
execute addBob;






/*    
6.0 Triggers
In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
6.1 AFTER/FOR
Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
Task – Create an after update trigger on the album table that fires after a row is inserted in the table
Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
*/
set serveroutput on;

CREATE or replace TRIGGER alertNewEmployee
AFTER INSERT ON EMPLOYEE
FOR EACH ROW
BEGIN
 DBMS_OUTPUT.PUT_LINE('WE ARE ADDING EMPLOYEE!');

END;
/
CREATE or replace TRIGGER alertAlbumTable
AFTER UPDATE ON ALBUM
FOR EACH ROW
BEGIN
 DBMS_OUTPUT.PUT_LINE('WE ARE UPDATEING ALBUM!');

END;
/

CREATE or replace TRIGGER ALERTDELETECUSTOMER
AFTER DELETE ON CUSTOMER
FOR EACH ROW
BEGIN
 DBMS_OUTPUT.PUT_LINE('WE ARE DELETING A CUSTOMER!');

END;
/
/*
7.0 JOINS
In this section you will be working with combining various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
7.1 INNER
Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
*/
SELECT * FROM CUSTOMER JOIN INVOICE ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID; 
/*
7.2 OUTER
Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
*/
SELECT  CUSTOMER.CUSTOMERID, firstname, lastname, INVOICE.INVOICEID, total FROM CUSTOMER FULL OUTER JOIN INVOICE ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID; 
/*
7.3 RIGHT
Task – Create a right join that joins album and artist specifying artist name and title.
*/
SELECT ARTIST.NAME, ALBUM.TITLE FROM ALBUM RIGHT JOIN ARTIST ON ALBUM.artistid = ARTIST.ARTISTID;

/*
7.4 CROSS
Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
*/
SELECT * FROM ALBUM CROSS JOIN ARTIST ORDER BY ARTIST.NAME ASC;


/*
7.5 SELF
Task – Perform a self-join on the employee table, joining on the reportsto column.
*/
SELECT * FROM EMPLOYEE JOIN EMPLOYEE ON EMPLOYEE.EMPLOYEEID = EMPLOYEE.REPORTSTO;
