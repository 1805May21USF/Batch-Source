-- JDBCBank SQL by Tiffany Tran
-- Note: Commit (F11) after running the statements to ensure it is sync with java program
-- Create sequences for accountID (using bankseq) and status (using statusseq)
DROP SEQUENCE bankseq;

CREATE SEQUENCE bankseq MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER NOCYCLE NOPARTITION;

DROP SEQUENCE statusseq;

CREATE SEQUENCE statusseq MINVALUE - 20 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH - 2 CACHE 20 NOORDER NOCYCLE NOPARTITION;

-- Create a Look-up table for status

DROP TABLE lookupstatus;

CREATE TABLE lookupstatus (
    status        INT,
    statusvalue   VARCHAR(255)
);
-- Insert into Look up status 

INSERT INTO lookupstatus VALUES (
    statusseq.NEXTVAL,
    'Cancelled Account'
);

INSERT INTO lookupstatus VALUES (
    statusseq.NEXTVAL,
    'Denied Application'
);

INSERT INTO lookupstatus VALUES (
    statusseq.NEXTVAL,
    'Open Application'
);

INSERT INTO lookupstatus VALUES (
    statusseq.NEXTVAL,
    'Customer'
);

INSERT INTO lookupstatus VALUES (
    statusseq.NEXTVAL,
    'Employee'
);

INSERT INTO lookupstatus VALUES (
    statusseq.NEXTVAL,
    'Bank Admin'
);

--Drop then create table for Person

DROP TABLE person;

CREATE TABLE person (
    personid       INT,
    firstname      VARCHAR(255),
    lastname       VARCHAR(255),
    username       VARCHAR(255),
    userpassword   VARCHAR(255),
    status         INT,
    accountid      VARCHAR(255)
);

--Drop then create table for PersonAccounts

DROP TABLE personaccounts;

CREATE TABLE personaccounts (
    accountid   VARCHAR(255),
    username    VARCHAR(255),
    balance     VARCHAR(255)
);


-- Create an Insert Person stored procedure with 

CREATE OR REPLACE PROCEDURE insertperson (
    fname    IN VARCHAR2,
    lname    IN VARCHAR2,
    uname    IN VARCHAR2,
    pname    IN VARCHAR2,
    status   IN INT,
    idname   IN VARCHAR2
)
    AS
BEGIN
    INSERT INTO person VALUES (
        bankseq.NEXTVAL,
        fname,
        lname,
        uname,
        pname,
        status,
        idname
    );

    COMMIT;
END;
/

-- Create an Insert PersonAccounts stored procedure

CREATE OR REPLACE PROCEDURE insertpersonacc (
    idname   IN VARCHAR2,
    uname    IN VARCHAR2,
    bal      IN VARCHAR2
)
    AS
BEGIN
    INSERT INTO personaccounts VALUES (
        idname,
        uname,
        bal
    );

    COMMIT;
END;
/

--Insert Admin

EXECUTE insertperson('Administrator',' ','admin','adminpass',3,'1528055320704');

EXECUTE insertpersonacc('1528055320704','admin','1000.00');

-- Insert Default Employee 1
EXECUTE insertperson('DefaultEmployee','DefaultEmployee','employee1','employee1',2,'1528055320705');

EXECUTE insertpersonacc('1528055320705','employee1','500.00');

-- Insert Default Customer 1
EXECUTE insertperson('DefaultCustomer','DefaultCustomer','customer1','customer1',1,'1528055320706');

EXECUTE insertpersonacc('1528055320706','customer1','10.00');

--***************SAMPLE PERSONS*************************
-- Austin Poe applied for an account
EXECUTE insertperson('Austin','Poe','poeaustin','12345',0,'1528055320708');
EXECUTE insertpersonacc('1528055320708','poeaustin','0.00');

-- Mary Jane owns an account
EXECUTE insertperson('Mary','Jane','mJane','12345',1,'1528055320709');
EXECUTE insertpersonacc('1528055320709','mJane','1420.39');

-- Scott Luis is an employee
EXECUTE insertperson('Scott','Luis','sLuis','12345',2,'1528055320710');
EXECUTE insertpersonacc('1528055320710','sLuis','3012.20');

-- Michael Scott is the bank admin
EXECUTE insertperson('Michael','Scott','mScott','password',3,'1528055320711');
EXECUTE insertpersonacc('1528055320711','mScott','20.00');

----------------------------------------------------------------------
--------------- PRACTICE CODE ----------------------------------------
----------------------------------------------------------------------

SELECT
    *
FROM
    person;

SELECT
    *
FROM
    personaccounts;











SELECT
    person.firstname,
    person.lastname,
    person.accountid,
    personaccounts.balance
FROM
    person
    INNER JOIN personaccounts ON person.username = personaccounts.username;

SELECT
    *
FROM
    person
WHERE
    person.username = 'tomTran';

SELECT
    person.username,
    person.userpassword
FROM
    person
WHERE
    person.username = 'admin';

SELECT
    *
FROM
    personaccounts;

UPDATE person
SET
    status = '1'
WHERE
    accountid = '0x1.63c6876012p40';

UPDATE personaccounts
SET
    balance = '5400'
WHERE
    accountid = '0x1.63c6876012p40';

SELECT
    person.firstname,
    person.lastname,
    person.accountid,
    personaccounts.balance,
    person.status
FROM
    person
    INNER JOIN personaccounts ON person.username = personaccounts.username;