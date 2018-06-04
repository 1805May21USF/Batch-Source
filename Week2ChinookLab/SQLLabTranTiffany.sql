/*2.1 SELECT 
Task – Select all records from the Employee table.*/
SELECT
    *
FROM
    employee;
    
/*Task – Select all records from the Employee table where last name is King. */

SELECT
    *
FROM
    employee
WHERE
    lastname = 'King';
    
/* Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL. */

SELECT
    *
FROM
    employee
WHERE
    firstname = 'Andrew'
    AND reportsto IS NULL;
    
/*2.2 ORDER BY
Task – Select all albums in Album table and sort result set in descending order by title.*/

SELECT
    *
FROM
    album
ORDER BY
    title DESC;

--Task – Select first name from Customer and sort result set in ascending order by city

SELECT
    *
FROM
    customer
ORDER BY
    city ASC;
--2.3 INSERT INTO
--Task – Insert two new records into Genre table 

INSERT INTO genre VALUES (
    26,
    'Dubstep'
);

INSERT INTO genre VALUES (
    27,
    'Lofi'
);
--Task – Insert two new records into Employee table

INSERT INTO employee VALUES (
    9,
    'Tran',
    'Tiffany',
    'Software Developer',
    5,
    '11-AUG-96',
    '31-May-18',
    '2936 Arrowwood Cir',
    'Augusta',
    'GA',
    'USA',
    '30815',
    '+1 (706) 461-8216',
    '+1 (403) 467-8888',
    'tiffanyttran28@gmail.com'
);

INSERT INTO employee VALUES (
    10,
    'Wiemer',
    'Bobby',
    'Professional E-Sports Player',
    2,
    '4-Jul-96',
    '31-May-13',
    '2936 Arrowwood Cir',
    'Augusta',
    'GA',
    'USA',
    '30815',
    '+1 (706) 500-8216',
    '+1 (403) 467-8888',
    'bobbert@gmail.com'
);

--Task – Insert two new records into Customer table

INSERT INTO customer VALUES (
    60,
    'Bobby',
    'Wiemer',
    'Selfless Co',
    '2343 Technic Lane',
    'Atlanta',
    'GA',
    'USA',
    '30815',
    '+1 (706) 500-8216',
    '+1 (706) 500-8216',
    'bobbert@gmail.com',
    '3'
);

INSERT INTO customer VALUES (
    61,
    'Bobbier',
    'Wiemier',
    'Selfless Copier',
    '2343 Technic Lane',
    'Atlanta',
    'GA',
    'USA',
    '30815',
    '+1 (706) 500-8216',
    '+1 (706) 500-8216',
    'bobbert@gmail.com',
    '5'
);

--2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter

UPDATE customer
SET
    firstname = 'Robert',
    lastname = 'Walter'
WHERE
    firstname = 'Aaron'
    AND lastname = 'Mitchell';
    
--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”	

UPDATE artist
SET
    name = 'CCR'
WHERE
    name = 'Creedence Clearwater Revival';
    
--2.5 LIKE
----Task – Select all invoices with a billing address like “T%” 

SELECT
    *
FROM
    invoice
WHERE
    billingaddress LIKE 'T%';
    
--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50

SELECT
    *
FROM
    invoice
WHERE
    total BETWEEN 15 AND 50;
--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004

SELECT
    *
FROM
    employee
WHERE
    hiredate BETWEEN '1-JUN-03' AND '1-MAR-04';
--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).

DELETE FROM invoiceline
WHERE
    invoiceid IN (
        SELECT
            invoiceid
        FROM
            invoice
        WHERE
            customerid IN (
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
    customerid IN (
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
    
--3.1 System Defined Functions
--Task – Create a function that returns the current time.

CREATE OR REPLACE FUNCTION gettime RETURN VARCHAR2 AS
    get_time   VARCHAR(260);
BEGIN
    SELECT
        TO_CHAR(SYSDATE,'HH24:MI:SS')
    INTO get_time
    FROM
        dual;

    RETURN get_time;
END;
/

SELECT
    gettime()
FROM
    dual;
--Task – create a function that returns the length of name in MEDIATYPE table

CREATE OR REPLACE FUNCTION getl (
    str IN STRING
) RETURN NUMBER
    IS
BEGIN
    RETURN length(str);
END getl;
/

SELECT
    getl(name)
FROM
    mediatype;
    
--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices

CREATE OR REPLACE FUNCTION add_invoice RETURN NUMBER AS
    total_price   NUMBER(10,2);
BEGIN
    SELECT
        AVG(total)
    INTO total_price
    FROM
        invoice;

    RETURN total_price;
END;
/

SELECT
    add_invoice()
FROM
    dual;
--Task – Create a function that returns the most expensive track

CREATE OR REPLACE FUNCTION max_track RETURN NUMBER AS
    expensive   NUMBER(10,2);
BEGIN
    SELECT
        MAX(unitprice)
    INTO expensive
    FROM
        track;

    RETURN expensive;
END;
/

SELECT
    max_track()
FROM
    dual;
--3.3 User Defined Scalar Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table

CREATE OR REPLACE FUNCTION avg_price_invoice RETURN NUMBER AS
    avg_unitprice   NUMBER(10,2);
BEGIN
    SELECT
        AVG(unitprice)
    INTO avg_unitprice
    FROM
        invoiceline;

    RETURN avg_unitprice;
END;
/

SELECT
    avg_price_invoice()
FROM
    dual;
--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.

--4.0 Stored Procedures
-- In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.

SET SERVEROUTPUT ON;

CREATE OR REPLACE PROCEDURE get_all_employee (
    s OUT SYS_REFCURSOR
)
    IS
BEGIN
    OPEN s FOR SELECT
        firstname,
        lastname
               FROM
        employee;

END;
/

DECLARE
    s           SYS_REFCURSOR;
    firstname   employee.firstname%TYPE;
    lastname    employee.lastname%TYPE;
BEGIN
    get_all_employee(s);
    LOOP
        FETCH s INTO
            firstname,
            lastname;
        EXIT WHEN s%notfound;
        dbms_output.put_line(firstname
                               || ' '
                               || lastname);
    END LOOP;

    CLOSE s;
END;
/

--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.
--Task – Create a stored procedure that returns the managers of an employee.
--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.

CREATE OR REPLACE PROCEDURE get_name_and_company (
    s OUT SYS_REFCURSOR
)
    IS
BEGIN
    OPEN s FOR SELECT
        firstname,
        lastname,
        company
               FROM
        customer;

END;
/
--5.0 Transactions
--In this section you will be working with transactions. Transactions are usually nested within a stored procedure.
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
--6.0 Triggers
--In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.

CREATE OR REPLACE TRIGGER catchnewemployee AFTER
    INSERT ON employee
    FOR EACH ROW
BEGIN
    dbms_output.put_line('Hello there!!');
END;
/

INSERT INTO employee VALUES (
    20,
    'temp',
    'temp',
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
--Task – Create an after update trigger on the album table that fires after a row is inserted in the table

--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.

--7.0 JOINS
--In this section you will be working with combining various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.

SELECT
    customer.firstname,
    customer.lastname,
    invoice.invoiceid
FROM
    customer
    INNER JOIN invoice ON customer.customerid = invoice.customerid;
--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.

SELECT
    customer.customerid,
    customer.firstname,
    customer.lastname,
    invoice.invoiceid,
    invoice.total
FROM
    customer
    FULL OUTER JOIN invoice ON customer.customerid = invoice.customerid;
--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.

SELECT
    artist.name,
    album.title
FROM
    artist
    RIGHT OUTER JOIN album ON artist.artistid = album.artistid;
--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.

SELECT
    *
FROM
    album
    CROSS JOIN artist
ORDER BY
    artist.name ASC;
--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.

SELECT
    *
FROM
    employee a,
    employee b
WHERE
    a.reportsto = b.reportsto;