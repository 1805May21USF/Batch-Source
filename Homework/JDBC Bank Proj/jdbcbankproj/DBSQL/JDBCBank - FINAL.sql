/* JDBC BANK ASSIGNMENT */




/* CREATE SEQUENCES */
CREATE SEQUENCE SEQ_CREATE_USER_ID
MINVALUE 1
START WITH 1
INCREMENT BY 1
CACHE 10;

CREATE SEQUENCE SEQ_CREATE_BANK_ACCOUNT_ID
MINVALUE 1
START WITH 1
INCREMENT BY 1
CACHE 10;

CREATE SEQUENCE SEQ_CREATE_TRANSACTION_ID
MINVALUE 1
START WITH 1
INCREMENT BY 1
CACHE 10;





/* CREATE TABLES */

CREATE TABLE USER_TYPE(
USER_TYPE_ID INTEGER NOT NULL,
USER_TYPE VARCHAR2(10) NOT NULL,
CONSTRAINT PK_USER_TYPE PRIMARY KEY (USER_TYPE_ID)
);

CREATE TABLE USER_STATUS(
USER_STATUS_ID INTEGER NOT NULL,
USER_STATUS VARCHAR(50) NOT NULL,
CONSTRAINT PK_USER_STATUS_ID PRIMARY KEY (USER_STATUS_ID)
);

CREATE TABLE USERS(
USER_ID INTEGER NOT NULL,
USERNAME VARCHAR2(50) NOT NULL,
USER_FNAME VARCHAR2(50),
USER_LNAME VARCHAR2(50),
USER_PASWD VARCHAR2(50),
USER_DOB DATE,
USER_TYPE_ID INTEGER,
USER_STATUS_ID INTEGER,
USER_CREATED_DATE DATE,
CONSTRAINT PK_USER_ID PRIMARY KEY (USER_ID),
CONSTRAINT FK_USER_TYPE_ID FOREIGN KEY (USER_TYPE_ID) 
REFERENCES USER_TYPE(USER_TYPE_ID),
CONSTRAINT FK_USER_STATUS_ID FOREIGN KEY (USER_STATUS_ID)
REFERENCES USER_STATUS(USER_STATUS_ID),
CONSTRAINT UQ_USERNAME UNIQUE (USERNAME)
);


CREATE TABLE BANKACCOUNTSTATUS(
BANK_ACCOUNT_STATUS_ID INTEGER NOT NULL,
BANK_ACCOUNT_STATUS VARCHAR2(50) NOT NULL,
CONSTRAINT PK_BANK_ACCOUNT_STATUS_ID PRIMARY KEY (BANK_ACCOUNT_STATUS_ID)
);

CREATE TABLE BANKACCOUNT(
BANK_ACCOUNT_ID INTEGER NOT NULL,
USER_ID INTEGER NOT NULL,
BANK_ACCOUNT_BALANCE NUMBER,
BANK_ACCOUNT_CREATED_DATE DATE,
BANK_ACCOUNT_STATUS_ID INTEGER,
CONSTRAINT PK_BANK_ACCOUNT_ID PRIMARY KEY (BANK_ACCOUNT_ID),
CONSTRAINT FK_BANK_ACCOUNT_STATUS_ID FOREIGN KEY (BANK_ACCOUNT_STATUS_ID) 
REFERENCES BANKACCOUNTSTATUS(BANK_ACCOUNT_STATUS_ID),
CONSTRAINT FK_USER_ID FOREIGN KEY (USER_ID)
REFERENCES USERS(USER_ID)
);




CREATE TABLE TRANSACTION_TYPE(
TRANSACTION_TYPE_ID INTEGER NOT NULL,
TRANSACTION_TYPE VARCHAR2(20) NOT NULL,
CONSTRAINT PK_TRANSACTION_TYPE_ID PRIMARY KEY (TRANSACTION_TYPE_ID)
);


CREATE TABLE TRANSACTIONS(
TRANSACTION_ID INTEGER NOT NULL,
USER_ID INTEGER NOT NULL,
TRANSACTION_TYPE_ID INTEGER,
TRANSACTION_AMOUNT NUMBER,
TRANSACTION_DATE DATE,
CONSTRAINT PK_TRANSACTION_ID PRIMARY KEY (TRANSACTION_ID),
CONSTRAINT FK_USER_ID_IN_T FOREIGN KEY (USER_ID)
REFERENCES USERS(USER_ID),
CONSTRAINT FK_TRANSACTION_TYPE_ID FOREIGN KEY (TRANSACTION_TYPE_ID)
REFERENCES TRANSACTION_TYPE(TRANSACTION_TYPE_ID)
);




/* Insert 1st Superuser */
INSERT INTO USERS (USER_ID, USERNAME, USER_FNAME, USER_LNAME, USER_PASWD, USER_DOB, USER_TYPE_ID, USER_STATUS_ID, USER_CREATED_DATE)
VALUES (SEQ_CREATE_USER_ID.NEXTVAL, 'ANNAARBOR', 'ANNA', 'ARBOR', 'ANNAARBOR01JAN00', '01-JAN-00', 1, 1, SYSDATE);

/* VIEW USER*/
SELECT * FROM USERS U
JOIN USER_TYPE UT ON U.USER_TYPE_ID = UT.USER_TYPE_ID
JOIN USER_STATUS US ON U.USER_STATUS_ID = US.USER_STATUS_ID;




/* INSERT 1st BANK ACCOUNT */
INSERT INTO BANKACCOUNT (BANK_ACCOUNT_ID, USER_ID, BANK_ACCOUNT_BALANCE, BANK_ACCOUNT_CREATED_DATE, BANK_ACCOUNT_STATUS_ID)
VALUES (SEQ_CREATE_BANK_ACCOUNT_ID.NEXTVAL, 1, 0.00, SYSDATE, 1);



/* INSERT Transaction Types */
INSERT INTO TRANSACTION_TYPE (TRANSACTION_TYPE_ID, TRANSACTION_TYPE)
VALUES (1, 'DEPOSIT');

INSERT INTO TRANSACTION_TYPE (TRANSACTION_TYPE_ID, TRANSACTION_TYPE)
VALUES (2, 'WITHDRAW');

INSERT INTO TRANSACTION_TYPE (TRANSACTION_TYPE_ID, TRANSACTION_TYPE)
VALUES (3, 'TRANSFER');








/* STORED PROCEDURES */
CREATE OR REPLACE PROCEDURE CLOSEUSER(USERID IN INT)
AS
BEGIN
    UPDATE USERS U
    SET USER_STATUS_ID = 2
    WHERE USER_ID = USERID;
COMMIT;
END;
/