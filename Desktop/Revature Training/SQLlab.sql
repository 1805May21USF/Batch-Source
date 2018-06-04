--Task – Select all records from the Employee table.
select * from employee; --2.1

--Task – Select all records from the Employee table where last name is King.
select * from employee where lastname = 'King'; --2.1

--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
select * from employee where firstname = 'Andrew' and REPORTSTO is NULL; --2.1

--Task – Select all albums in Album table and sort result set in descending order by title.
select * from album order by title desc; --2.2

--Task – Select first name from Customer and sort result set in ascending order by city
select firstname from customer order by city asc; --2.2

--Task – Insert two new records into Genre table 
insert into genre(genreid, name) values(26, 'edm'); -- 2.3
insert into genre(genreid, name) values(27, 'texas country');

--Task – Insert two new records into Employee table
insert into employee(employeeid, lastname, firstname, title, reportsto, birthdate, hiredate, address, city, state, country, postalcode, phone, fax, email) 
values(9, 'mariano', 'rafael', 'software developer', 6, date '96-08-30', date '18-05-21', '2701 White Oak', 'GP', 'TX', 'United States', '75052', '(214) 999-9999', '+1 (403) 467-8773', 'something@gmail.com'); 

insert into employee(employeeid, lastname, firstname, title, reportsto, birthdate, hiredate, address, city, state, country, postalcode, phone, fax, email) 
values(10, 'smith', 'kris', 'software engineer', 1, date '96-02-14', date '18-05-21', '2802 White Oak', 'Arlington', 'TX', 'United States', '76011', '(214) 999-4569', '+1 (403) 555-8773', 'yay@gmail.com'); 

--Task – Insert two new records into Customer table
insert into customer(customerid, firstname, lastname, company, address, city, state, country, postalcode, phone, fax, email, supportrepid) 
values (60, 'smith', 'kris', 'null', '2802 White Oak', 'Arlington', 'TX', 'United States', '76011', '(214) 999-4569', '+1 (403) 555-8773', 'arlington@gmail.com', 6); --2.3

insert into customer(customerid, firstname, lastname, company, address, city, state, country, postalcode, phone, fax, email, supportrepid) 
values (61, 'williams', 'daniel', 'null', '445 Great Dr.', 'Tampa', 'FL', 'United States', '33605', '(214) 123-4569', '+1 (123) 555-8773', 'rolltide@gmail.com', 5); --2.3

--Task – Update Aaron Mitchell in Customer table to Robert Walter
update customer set firstname = 'Robert', lastname = 'Walter' where firstname = 'Aaron' and lastname ='Mitchell'; 

--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”	
update artist set name = 'CCR' where name = 'Creedence Clearwater Revival'; 

--Task – Select all invoices with a billing address like “T%” 
select * from invoice where billingaddress like 'T%'; -- 2.5

--Task – Select all invoices that have a total between 15 and 50
select * from invoice where total between 15 and 50; -- 2.6

--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
select * from employee where hiredate between date '03-06-01' and date '04-03-01'; -- 2.6

--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
delete from customer where firstname = 'Robert' and lastname = 'Walter'


-- Task – Create a function that returns the current time.
create or replace function returnDate
return date is -- the return type is date, whats the difference between is and as on here
l_sysdate date; -- l_sysdate is the variable for the date
begin
select sysdate into l_sysdate -- calling sysdate as l_sysdate
from dual;
return l_sysdate;
end;
/

select returnDate() from dual;


--Task – create a function that returns the length of name in MEDIATYPE table
select length(name) from mediatype; --3.1

--3.1 Task – create a function that returns the length of name in MEDIATYPE table
create or replace function returnLength 
(nam in varchar2) 
return number as num number; 
begin 
num := length(nam);
return num;
end;
/

select returnLength(name) from mediatype;

--Task – Create a function that returns the average total of all invoices 
select avg(total) from invoice; -- 3.2

--Task – Create a function that returns the most expensive track
select max(unitprice) from track; --3.2

--3.3 Task – Create a function that returns the average price of invoiceline items in the invoiceline table
create or replace function avgPrice
return number as 
y number(10,2);
begin
select avg(unitprice) into y
from invoiceline;
return y;
end;
/

select avgPrice() from dual;


--3.4 Task – Create a function that returns all employees who are born after 1968.
create or replace function bornAfter
return number 
as
begin
select * from employee where extract (year from birthdate) > '1968';
end;
/

select bornAfter() from dual;


--4.1 Task – Create a stored procedure that selects the first and last names of all the employees.
create or replace procedure firstAndLast
(vc_cursor out sys_refcursor)
as
begin
    open vc_cursor for
    select firstname, lastname from employee
    commit;
end;
/


variable rc refcursor;
exec firstAndLast(:rc);
print rc;


--4.2 Task – Create a stored procedure that updates the personal information of an employee.





--4.2 Task – Create a stored procedure that returns the managers of an employee.
create or replace procedure man_emp
(vc_cursor out sys_refcursor)
as
begin
    open vc_cursor for
    select firstname, lastname, title from employee 
    where reportsto = 1;
    commit;
end;
/

variable ra refcursor;
exec man_emp(:ra);
print ra;



--4.3 Task – Create a stored procedure that returns the name and company of a customer.
create or replace procedure name_comp_empl
(vc_cursor out sys_refcursor)
as
begin
    open vc_cursor for
    select firstname, lastname, company from customer
    commit;
end;
/

variable rb refcursor;
exec name_comp_empl(:rb);
print rb;





--5.0
delete from invoice where invoiceid > 203;
commit;



--5.0





--6.1 Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
create or replace trigger insert_employee
after insert on employee
begin
    DBMS_OUTPUT.PUT_LINE(employeeid||' IS CURRENT ID,'|| title||'IS CURRENT TITLE NAME');
end;
/

--6.1 Task – Create an after update trigger on the album table that fires after a row is inserted in the table
create or replace trigger insert_employee
after update on employee
begin
    DBMS_OUTPUT.PUT_LINE(employeeid||' IS CURRENT ID,'|| title||'IS CURRENT TITLE NAME');
end;
/

--6.1 Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
create or replace trigger insert_employee
after delete on employee
begin
    DBMS_OUTPUT.PUT_LINE(employeeid||' IS CURRENT ID,'|| title||'IS CURRENT TITLE NAME');
end;
/



--7.1 Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
select customer.firstname, customer.lastname, invoice.invoiceid from CUSTOMER inner join INVOICE on customer.customerid = INVOICE.CUSTOMERID;

--7.2 Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
select CUSTOMER.CUSTOMERID, customer.firstname, customer.lastname, invoice.invoiceid, invoice.total from CUSTOMER full outer join INVOICE on customer.customerid = INVOICE.CUSTOMERID;

--7.3 Task – Create a right join that joins album and artist specifying artist name and title.
select artist.NAME, album.title from album right join artist on album.artistid = artist.ARTISTID;

--7.4 Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
select * from album cross join artist order by artist.NAME asc;

--7.5 Task – Perform a self-join on the employee table, joining on the reportsto column.
select a.reportsto as reportsto1, b.reportsto as reportsto2 from employee a, employee b;


