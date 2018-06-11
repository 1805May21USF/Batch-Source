CREATE OR REPLACE PROCEDURE WITHDRAWAL 
(user in varchar2, amount in number)
AS 
BEGIN
  update bank_customers set checkings = checkings - amount where username = user;
END WITHDRAWAL;



create or replace PROCEDURE WITHDRAWAL_SAVINGS 
(user in varchar2, amount in number)
AS 
BEGIN
  update bank_customers set SAVINGS = SAVINGS - amount where username = user;
END WITHDRAWAL_SAVINGS;



create or replace PROCEDURE INCREASE_CHECKINGS 
(user in varchar2, amount in number)
as
BEGIN
  update bank_customers set checkings = checkings + amount where username = user;
END INCREASE_CHECKINGS;



create or replace PROCEDURE INCREASE_SAVINGS  
(user in varchar2, amount in number)
as
BEGIN
  update bank_customers set savings = SAVINGS + amount where username = user;
END INCREASE_SAVINGS;



CREATE OR REPLACE PROCEDURE DELETE_ACCOUNT 
(user in varchar2)
AS 
BEGIN
  delete from bank_customers where username = user and checkings = 0.0;
END DELETE_ACCOUNT;



CREATE OR REPLACE PROCEDURE DELETE_USER 
(user in varchar2)
AS 
BEGIN
  delete from bank_customers where username = user;
END DELETE_USER;




