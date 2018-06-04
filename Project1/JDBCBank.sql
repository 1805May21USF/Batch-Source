CREATE SEQUENCE USER_IDSEQ;
CREATE SEQUENCE ACCSEQ;
CREATE TABLE USERS(
USERID NUMBER NOT NULL,
USERNAME VARCHAR2(50),
PASS VARCHAR2(50),
PRIMARY KEY (USERID)
);
CREATE OR REPLACE PROCEDURE INSERTUSER (USER_NAME IN VARCHAR2, PASS IN VARCHAR2)
AS
BEGIN
INSERT INTO USERS VALUES(USER_IDSEQ.NEXTVAL,USER_NAME,PASS);
COMMIT;
END;
/
CREATE TABLE ACCOUNTS(
ACCOUNTID NUMBER NOT NULL,
USERID NUMBER,
BALANCE NUMBER,
PRIMARY KEY (ACCOUNTID),
FOREIGN KEY (USERID) REFERENCES USERS(USERID)
);
CREATE OR REPLACE PROCEDURE INSERTACCOUNT(USER_ID IN NUMBER, BALANCE_ IN NUMBER)
AS
BEGIN
INSERT INTO ACCOUNTS VALUES(ACCSEQ.NEXTVAL,USER_ID,BALANCE_);
COMMIT;
END;
/
CREATE OR REPLACE PROCEDURE WITHDRAWACCOUNT(ACCOUNT_ID IN NUMBER,WITHDRAW_AMOUNT IN NUMBER)
AS
BEGIN
UPDATE ACCOUNTS SET BALANCE = BALANCE-WITHDRAW_AMOUNT WHERE ACCOUNTID = ACCOUNT_ID;
COMMIT;
END;
/
CREATE OR REPLACE PROCEDURE DEPOSITACCOUNT(ACCOUNT_ID IN NUMBER,DEPOSIT_AMOUNT IN NUMBER)
AS
BEGIN
UPDATE ACCOUNTS SET BALANCE = BALANCE+DEPOSIT_AMOUNT WHERE ACCOUNTID = ACCOUNT_ID;
COMMIT;
END;
/
CREATE OR REPLACE PROCEDURE DELETEACCOUNT(ACCOUNT_ID IN NUMBER)
AS
BEGIN
DELETE FROM ACCOUNTS WHERE ACCOUNTID = ACCOUNT_ID;
COMMIT;
END;
/