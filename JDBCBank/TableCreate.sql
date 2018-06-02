DROP TABLE JDBCBANK_TRANSACTION;
DROP TABLE JDBCBANK_CUSTOMER_ACCOUNT;
DROP TABLE JDBCBANK_CUSTOMER_APPLICATION;
DROP TABLE JDBCBANK_ACCOUNT;
DROP TABLE JDBCBANK_APPLICATION;
DROP TABLE JDBCBANK_CUSTOMER;
DROP TABLE JDBCBANK_EMPLOYEE;
    
 
CREATE TABLE JDBCBANK_CUSTOMER (
 CUSTOMER_ID NUMBER GENERATED ALWAYS AS IDENTITY(START WITH 1000 INCREMENT BY 1) PRIMARY KEY,
 USERNAME VARCHAR(50) UNIQUE NOT NULL,
 PASSWORD VARCHAR(50),
 FNAME VARCHAR(50),
 LNAME VARCHAR(50)
);

CREATE TABLE JDBCBANK_EMPLOYEE (
 EMPLOYEE_ID NUMBER GENERATED ALWAYS AS IDENTITY(START WITH 1000 INCREMENT BY 1) PRIMARY KEY,
 USERNAME VARCHAR(50) UNIQUE NOT NULL,
 PASSWORD VARCHAR(50),
 FNAME VARCHAR(50),
 LNAME VARCHAR(50),
 ISADMIN CHAR
);

CREATE TABLE JDBCBANK_APPLICATION (
 APPLICATION_ID NUMBER GENERATED ALWAYS AS IDENTITY(START WITH 1000 INCREMENT BY 1) PRIMARY KEY,
 FINGERPRINT NUMBER,
 INITIAL_BALANCE NUMBER(15,2),
 APPROVAL VARCHAR(20)
);

CREATE TABLE JDBCBANK_ACCOUNT (
 ACCOUNT_ID NUMBER GENERATED ALWAYS AS IDENTITY(START WITH 1000 INCREMENT BY 1) PRIMARY KEY,
 FINGERPRINT NUMBER,
 BALANCE NUMBER(15,2),
 STATUS VARCHAR(20)
);

CREATE TABLE JDBCBANK_TRANSACTION(
 TRANSACTION_ID NUMBER GENERATED ALWAYS AS IDENTITY(START WITH 1000 INCREMENT BY 1) PRIMARY KEY,
 COMPLETION_DATE DATE,
 STATUS VARCHAR(20),
 TRANSACTION_TYPE VARCHAR(20),
 FROM_ACCOUNT_ID INTEGER,
 TO_ACCOUNT_ID INTEGER,
 AMOUNT NUMBER(30,2),
 BALANCE NUMBER(30,2)
);

ALTER TABLE JDBCBANK_TRANSACTION
ADD CONSTRAINT FK_FROM_ACCOUNT_ID
FOREIGN KEY (FROM_ACCOUNT_ID) REFERENCES JDBCBANK_ACCOUNT(ACCOUNT_ID)
ON DELETE CASCADE;

CREATE TABLE JDBCBANK_CUSTOMER_APPLICATION(
 REL_ID NUMBER GENERATED ALWAYS AS IDENTITY(START WITH 1000 INCREMENT BY 1) PRIMARY KEY,
 CUSTOMER_ID INTEGER,
 APPLICATION_ID INTEGER
);

ALTER TABLE JDBCBANK_CUSTOMER_APPLICATION
ADD CONSTRAINT FK_APP_REL_CUSTOMER_ID
FOREIGN KEY (CUSTOMER_ID) REFERENCES JDBCBANK_CUSTOMER(CUSTOMER_ID)
ON DELETE CASCADE;

ALTER TABLE JDBCBANK_CUSTOMER_APPLICATION
ADD CONSTRAINT FK_APP_REL_APPLICATION_ID
FOREIGN KEY (APPLICATION_ID) REFERENCES JDBCBANK_APPLICATION(APPLICATION_ID)
ON DELETE CASCADE;

CREATE TABLE JDBCBANK_CUSTOMER_ACCOUNT (
 REL_ID NUMBER GENERATED ALWAYS AS IDENTITY(START WITH 1000 INCREMENT BY 1) PRIMARY KEY,
 CUSTOMER_ID INTEGER,
 ACCOUNT_ID INTEGER
);

ALTER TABLE JDBCBANK_CUSTOMER_ACCOUNT
ADD CONSTRAINT FK_ACC_REL_CUSTOMER_ID
FOREIGN KEY (CUSTOMER_ID) REFERENCES JDBCBANK_CUSTOMER(CUSTOMER_ID)
ON DELETE CASCADE;

ALTER TABLE JDBCBANK_CUSTOMER_ACCOUNT
ADD CONSTRAINT FK_ACC_REL_ACCOUNT_ID
FOREIGN KEY (ACCOUNT_ID) REFERENCES JDBCBANK_ACCOUNT(ACCOUNT_ID)
ON DELETE CASCADE;

/*-------------------------------------------------

Stored Procedures

---------------------------------------------------*/

CREATE OR REPLACE PROCEDURE add_employee(u IN VARCHAR,p IN VARCHAR, f IN VARCHAR, l IN VARCHAR, c IN VARCHAR)
IS
BEGIN
    INSERT INTO JDBCBANK_EMPLOYEE (USERNAME,PASSWORD,FNAME,LNAME,ISADMIN) VALUES (u,p,f,l,c);
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE update_employee(eid IN NUMBER,u IN VARCHAR,p IN VARCHAR, f IN VARCHAR, l IN VARCHAR, c IN VARCHAR)
IS
BEGIN
    UPDATE JDBCBANK_EMPLOYEE SET USERNAME = u,PASSWORD = p,FNAME = f,LNAME = p ,ISADMIN = c WHERE EMPLOYEE_ID=eid;
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE delete_employee(eid IN NUMBER)
IS
BEGIN
    DELETE FROM JDBCBANK_EMPLOYEE WHERE EMPLOYEE_ID = eid;
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE add_customer(u IN VARCHAR,p IN VARCHAR, f IN VARCHAR, l IN VARCHAR)
IS 
BEGIN
    INSERT INTO JDBCBANK_CUSTOMER (USERNAME,PASSWORD,FNAME,LNAME) VALUES (u,p,f,l);
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE update_customer(cid IN NUMBER,u IN VARCHAR,p IN VARCHAR, f IN VARCHAR, l IN VARCHAR)
IS
BEGIN
    UPDATE JDBCBANK_CUSTOMER SET USERNAME = u,PASSWORD = p,FNAME = f,LNAME = p WHERE CUSTOMER_ID = cid;
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE delete_customer(cid IN NUMBER)
IS
BEGIN
    DELETE FROM JDBCBANK_CUSTOMER WHERE CUSTOMER_ID = cid;
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE add_application(f IN NUMBER, b IN NUMBER,a IN VARCHAR)
IS
BEGIN
    INSERT INTO JDBCBANK_APPLICATION (FINGERPRINT,INITIAL_BALANCE,APPROVAL) VALUES (f,b,a);
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE update_application( aid IN NUMBER,f IN NUMBER,b IN NUMBER,a IN VARCHAR)
IS
BEGIN
    UPDATE JDBCBANK_APPLICATION SET FINGERPRINT = f,INITIAL_BALANCE = b, APPROVAL = a WHERE APPLICATION_ID = aid;
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE delete_application(did IN NUMBER)
IS 
BEGIN
    DELETE FROM JDBCBANK_APPLICATION WHERE APPLICATION_ID = did;
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE add_cust_app_relation(cid IN NUMBER, aid IN NUMBER)
IS
BEGIN
    INSERT INTO JDBCBANK_CUSTOMER_APPLICATION (CUSTOMER_ID,APPLICATION_ID) VALUES (cid,aid);
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE update_cust_app_relation(rid IN NUMBER,cid IN NUMBER, aid IN NUMBER)
IS
BEGIN
    UPDATE JDBCBANK_CUSTOMER_APPLICATION SET CUSTOMER_ID=cid, APPLICATION_ID=aid WHERE REL_ID=rid;
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE delete_cust_app_relation(rid IN NUMBER)
IS
BEGIN
    DELETE FROM JDBCBANK_CUSTOMER_APPLICATION WHERE REL_ID = rid;
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE add_account(f in NUMBER, b in NUMBER, s in VARCHAR)
IS
BEGIN
    INSERT INTO JDBCBANK_ACCOUNT (FINGERPRINT,BALANCE,STATUS) VALUES (f,b,s);
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE update_account(aid IN NUMBER,f IN NUMBER, b in NUMBER,s in VARCHAR)
IS
BEGIN
    UPDATE JDBCBANK_ACCOUNT SET FINGERPRINT = f, BALANCE = b, STATUS = S WHERE ACCOUNT_ID = aid;
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE delete_account(aid IN NUMBER)
IS 
BEGIN
    DELETE FROM JDBCBANK_ACCOUNT WHERE ACCOUNT_ID = aid;
END;
/

CREATE OR REPLACE PROCEDURE add_cust_acc_relation(cid IN NUMBER, aid IN NUMBER)
IS
BEGIN
    INSERT INTO JDBCBANK_CUSTOMER_ACCOUNT (CUSTOMER_ID,ACCOUNT_ID) VALUES (cid,aid);
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE add_cust_app_relation(cid IN NUMBER, aid IN NUMBER)
IS
BEGIN
    INSERT INTO JDBCBANK_CUSTOMER_APPLICATION (CUSTOMER_ID,APPLICATION_ID) VALUES (cid,aid);
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE update_cust_acc_relation(rid IN NUMBER,cid IN NUMBER, aid IN NUMBER)
IS
BEGIN
    UPDATE JDBCBANK_CUSTOMER_ACCOUNT SET CUSTOMER_ID=cid, ACCOUNT_ID=aid WHERE REL_ID=rid;
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE delete_cust_acc_relation(rid IN NUMBER)
IS
BEGIN
    DELETE FROM JDBCBANK_CUSTOMER_ACCOUNT WHERE REL_ID = rid;
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE add_transaction(cdate in DATE, s in VARCHAR, t in VARCHAR,
fid IN NUMBER, toid in NUMBER, a in NUMBER,b in NUMBER )
IS
BEGIN
    INSERT INTO JDBCBANK_TRANSACTION (COMPLETION_DATE,STATUS,TRANSACTION_TYPE,FROM_ACCOUNT_ID,TO_ACCOUNT_ID,AMOUNT,BALANCE)
    VALUES (cdate,s,t,fid,toid,a,b);
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE update_transaction(tid IN INTEGER, cdate in DATE, s in VARCHAR, t in VARCHAR,
fid IN NUMBER, toid in NUMBER, a in NUMBER,b in NUMBER )
IS
BEGIN
    UPDATE JDBCBANK_TRANSACTION SET COMPLETION_DATE=cdate,STATUS=s,TRANSACTION_TYPE=t,FROM_ACCOUNT_ID=fid,TO_ACCOUNT_ID=toid,
    AMOUNT=a,BALANCE = b WHERE TRANSACTION_ID = tid;
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE delete_transaction(tid IN NUMBER)
IS
BEGIN
    DELETE FROM JDBCBANK_TRANSACTION WHERE TRANSACTION_ID = tid;
    COMMIT;
END;
/

/*--------------------------------------------------

Initial Data

---------------------------------------------------*/
INSERT INTO JDBCBANK_EMPLOYEE (USERNAME,PASSWORD,FNAME,LNAME,ISADMIN) VALUES ('admin','admin','Admin','Admin','Y');
INSERT INTO JDBCBANK_EMPLOYEE (USERNAME,PASSWORD,FNAME,LNAME,ISADMIN) VALUES ('employee','employee','Employee','Employee','N');
INSERT INTO JDBCBANK_CUSTOMER (USERNAME,PASSWORD,FNAME,LNAME) VALUES ('corwin','lester','Corwin','Lester');

EXECUTE add_account(898948938,100.00,'OPEN');
EXECUTE add_cust_acc_relation(1000,1000);
EXECUTE delete_account(1000);

EXECUTE add_account(747390604,100.00,'OPEN');
EXECUTE add_cust_acc_relation(1000,1001);
