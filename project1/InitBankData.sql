drop table BANKUSERS;
DROP TABLE BANKUSERSLOGIN;
CREATE TABLE BANKUSERS
(
    UserID NUMBER NOT NULL,
    isAdmin NUMBER NOT NULL,
    isActive NUMBER NOT NULL,
    Balance NUMBER NOT NULL,

    CONSTRAINT BANKUSERSpk PRIMARY KEY  (UserID)
);
CREATE TABLE BANKUSERSLOGINS
(
    UserID NUMBER NOT NULL,
    USERNAME VARCHAR2(80) NOT NULL,
    PASSWORD VARCHAR2(80) NOT NULL,
    CONSTRAINT BANKUSERSLOGINSFK FOREIGN KEY  (UserID) REFERENCES BANKUSERS(UserID)
);

insert into bankUsers values(0,0,1,0.0);
insert into bankUsersLogins values(0,'defaultUser', 'defaultUser');

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