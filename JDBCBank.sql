CREATE TABLE Users (
    User_id     INTEGER Primary Key,
    Firstname   VARCHAR2(100),    
    Lastname    VARCHAR2(100),
    Username    VARCHAR2(100),
    Pass_Word   VARCHAR2(100),
    status      INTEGER DEFAULT 1,
    account_number INTEGER,
    account_id INTEGER
);

CREATE TABLE Accounts (
    Account_id INTEGER PRIMARY KEY,
    Account_Number     INTEGER,
    Account_balance   Number(10, 2)
);

/*ALTER TABLE Users
    ADD CONSTRAINT fk_account_number FOREIGN KEY (Account_Number)
        REFERENCES Accounts (Account_Number);*/

ALTER TABLE Users
    ADD CONSTRAINT fk_account_id FOREIGN KEY (Account_id)
        REFERENCES Accounts (Account_id)
            on delete cascade;
        
CREATE SEQUENCE USERIDSEQ;
CREATE SEQUENCE ACCOUNTIDSEQ;
CREATE SEQUENCE ACCOUNTNUMBERSEQ;

create or replace procedure deleteUser(user_name in varchar2)
as begin
delete from users u where u.USERNAME = user_name;
end;
/

create or replace procedure deleteAccount(accountNumber in varchar2)
as begin
delete from accounts a where a.account_number = accountNumber;
end;
/