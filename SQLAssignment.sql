
--2.1
--Select all from employee

Select * from employee;

select * from employee where LASTNAME = 'King';

select * from employee where FIRSTNAME = 'Andrew' AND REPORTSTO is NULL;

--2.2
select * from album 
order By title
desc;


select firstname from customer
order by city
asc;

--2.3.1

insert into genre(GenreId , Name)
values(26 , 'Screamo');

insert into genre(GenreId , Name)
values(27 , 'Papparockzi');


--2.3.2

select * from employee;

insert into employee(employeeID,LASTNAME,FIRSTNAME,TITLE,REPORTSTO,BIRTHDATE,HIREDATE,ADDRESS)
values(9, 'Martin', 'Kaleb', 'Janitor',6,'27-JAN-87','27-JAN-87','noneya');
insert into employee(employeeID,LASTNAME,FIRSTNAME,TITLE,REPORTSTO,BIRTHDATE,HIREDATE,ADDRESS)
values(10, 'Martin', 'Kmart', 'pooperScooper',5,'27-JAN-87','27-JAN-87','3103 fm 36 south');


--2.3.3

insert into customer values (60 ,'Kaleb','Martin','Revature','PoopDolla','Caddo Mills','TX','USA',75135,'+1 (903) 217-3563', '+1 (903) 217-3563','Kalebamartin05@gmail.com','1');
insert into customer values (61 ,'Bobby','Cobb','GolfPro','Holla','Greenville','TX','USA',75135,'+1 (903) 217-3563', '+1 (903) 217-3563','Kalebamartin05@gmail.com','1'); 
select * from customer;


--2.4.1

update customer
set LASTNAME = 'Walter', FIRSTNAME = 'Robert'
where FIRSTNAME = 'Aaron' and  LASTNAME = 'Mitchell';




update Artist
set NAME = 'CCR' where Name = 'Creedence Clearwater Revival';


--2.5
select * from invoice
where billingaddress
like 'T%';


--2.6
select * from invoice 
where TOTAL between 15 and 50;


--2.6.2
select * from employee
where hiredate between '01-JUN-03' and '01-MAR-04';



--TODO---------------------------------------------------------------------------------------------------------
--2.7.1

delete from customer
where FIRSTNAME = 'Robert' and Lastname = 'Walter';


--3.1

SELECT TO_CHAR
    (SYSDATE, 'MM-DD-YYYY HH24:MI:SS') "NOW"
     FROM DUAL;

--3.1.2
select name, length(name) from mediatype;


--3.2.1
select avg(total) from invoice;


select max(unitprice) from track;


--3.3
create or replace function user_average(total in int,  quantity in int) return number is
user_sum number :=0;
user_quantity number :=0;
begin
      for i in 1 .. numbers.count loop
        if numbers(i) is not null and numbers(i) <> 1 then
            v_sum := v_sum + numbers(i);
            v_quantity := v_quantity + 1;
        end if;
    end loop;
    
    if v_count = 0 then
        return null;
    else
        return v_sum/v_quantity;
    end if;
    
end;
--3.4
--4.1

create or replace procedure select_All_Employees(
f_name varchar, l_name varchar)
as
    begin
        select firstname into f_name, lastname into l_name from employee;
        DBMS.OUTPUT.PUTLINE
    end;
    
    
    begin 
        select_All_Employees;
    end;
--4.2

create or replace procedure update_Empolyee_Info
(I_D in number,
lname in varchar2,
fname in varchar2,
title_in in varchar2,
bday_in in date,
address_in in varchar2,
city_in in varchar2,
state_in in varchar2,
country_in in varchar2,
postal_in in varchar2,
phone_in in varchar2,
email_in in varchar2)
as 
begin
    update employee
    set  Lastname = lname, 
    firstname = fname,
    title = title_in,
    birthdate = bday_in,
    address = address_in,
    city = city_in,
    "STATE" = state_in,
    country = country_in,
    POSTALCODE = postal_in,
    phone = phone_in,
    email = email_in where EMPLOYEEID = I_D;
end;

create or replace procedure managersOUT
(employeeID_in in number,
manager_out out varchar2)
as 
    begin
        select reportsto into manager_out from employee where EMPLOYEEID = employeeID_in;
    end;

--4.3
create or replace procedure companyOUT
(I_D in number, ret_comp out varchar2, fname out varchar2, lname out varchar2)
as
begin
    select COMPANY into ret_comp from customer where CUSTOMERID = I_D;
    select FIRSTNAME into fname from customer where CUSTOMERID = I_D;
    select lASTNAME into lname from customer where CUSTOMERID = I_D;
end; 


--5.0


--6.1.1 after insert trigger
-- create an employee backup table and then store the inserted employee into the backup table

create table emp_backup( employeeid number(10),
firstname varchar(25),
lastname varchar(25)
);


create or replace trigger empInsertTrigger
after insert on employee for each row
begin
    insert into emp_backup values (:new.employeeid, :new.firstname, :new.lastname);
end;
/

--6.1.2
--create a table to hold the values of which table has been updated
create table updated_albums(
ARTISTID number(10),
TITLE varchar(20));

create or replace trigger albumUpdateTrigger
after update on album for each row
begin
        insert into updated_albums 
        values( :NEW.ARTISTID, :NEW.TITLE);
end;
/

--6.1.3
--hold the deleted customers in a seperate table
create table deleted_customers(
customerID number,
firstname varchar(20),
lastname varchar(20));

create or replace trigger customerDeleteTrigger
after delete on customer
for each row
begin
    if deleting then
        insert into deleted_customers values(
        :NEW.customerID, :NEW.firstname, :NEW.lastname);
   end if;
end;


--7.1
select invoice.invoiceid, customer.firstname, customer.lastname
from invoice
inner join customer
on invoice.customerid = customer.customerid
order by customer.lastname;



--7.2
select INVOICE.INVOICEID, Customer.customerID,
Customer.firstname, customer.lastname from Invoice
full outer join CUSTOMER
on INVOICE.CUSTOMERID = CUSTOMER.CUSTOMERID
order by customer.lastname;

--7.3
select artist."NAME", album.title
from album
right join artist 
on album.ARTISTID = artist.ARTISTID;


--7.4
select * from artist;
select ALBUM.TITLE, ARTIST."NAME" from album
cross join artist order by "NAME" asc;

--7.5
select * from employee a,employee b
where a.reportsto = b.reportsto;


