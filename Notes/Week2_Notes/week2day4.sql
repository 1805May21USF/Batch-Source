--SEQUENCES SYNTAX: CACHE SAVES 5 INTO A BUFFER ALLOWING FOR QUICKER ACCESS.
--CAN ALSO DO NEGATIVE INCREMENTS JUST MAKE SURE MAX AND MIN VALUE MAKE SENSE
CREATE SEQUENCE MYTESTSEQ
MINVALUE 600
MAXVALUE 900
INCREMENT BY 5
CACHE 5;

--DUAL IS A DUMMY TABLE USED IN NON TABLE QUERIES
SELECT MYTESTSEQ.NEXTVAL FROM DUAL;

--HOW WE MIGHT USE SEQUENCES
INSERT INTO STUDENT(MYTESTSEQ.NEXTVAL, 'BOB');

--VIEW: CREATES A VIRTUAL TEMPORARY TABLE YAY!
CREATE VIEW MYVIEW
AS SELECT TITLE FROM ALBUM
UNION
SELECT NAME FROM ARTIST;

SELECT * FROM MYVIEW;

--FUNCTIONS
CREATE OR REPLACE FUNCTION CALC_TAX
(T_ID IN NUMBER, TAX IN NUMBER)
RETURN NUMBER AS 
TOTAL_PRICE NUMBER(10,2);
BEGIN
    SELECT UNITPRICE INTO TOTAL_PRICE
    FROM TRACK WHERE TRACKID = T_ID;
    RETURN TOTAL_PRICE + (TOTAL_PRICE*TAX);
END;
/
SELECT CALC_TAX(2921,.06) FROM DUAL;

--STORED PROCEDURES
CREATE OR REPLACE PROCEDURE MYFAKEPRO
(NAME IN VARCHAR2)
AS
BEGIN
INSERT INTO SCHOOL VALUES(MYSEQ.NEXTVAL,NAME);
COMMIT;
END;
/
EXECUTE MYFAKEPRO('USF');

CREATE OR REPLACE PROCEDURE BEARPRO
(CAVE_NAME IN VARCHAR2, BEAR_NAME IN VARCHAR2,
BEAR_BIRTHDATE IN DATE, CAVE_ID IN NUMBER)
AS
BEGIN
INSERT INTO CAVE VALUES(MYSEQ.NEXTVAL, CAVE_NAME);
INSERT INTO BEEHIVE VALUES(MYSEQ.NEXTVAL, 50);
INSERT INTO BEAR VALUES(MYSEQ.NEXTVAL,1,BEAR_NAME, BEAR_BIRTHDATE,200, CAVE_ID);
COMMIT;
END;
/
EXECUTE BEARPRO('WOO','PERT',DATE '1999-02-15',1);

--FUNCTION
CREATE OR REPLACE FUNCTION ROLLTIDE
RETURN VARCHAR2 AS
BEGIN
    RETURN 'ROLL TIDE';
END;
/
SELECT ROLLTIDE FROM DUAL;
--FUNCTION

--PROCEDURE
CREATE TABLE ROLLTIDESTUFF(ID NUMBER, ACTION VARCHAR2(20));

CREATE OR REPLACE PROCEDURE INSERTROLLTIDE
AS
BEGIN
--INSERT INTO ROLLTIDESTUFF VALUES(1,'ROLLING TIDE');
--INSERT INTO ROLLTIDESTUFF VALUES(3, 'TIDE ROLL');
UPDATE ROLLTIDESTUFF SET ACTION = 'TIDE ROLL'
WHERE ACTION = 'ROLL TIDE';
COMMIT;
END;
/

EXECUTE INSERTROLLTIDE;

--PROCEDURE
CREATE OR REPLACE PROCEDURE MAKEAROLLTIDE
AS
BEGIN
UPDATE ROLLTIDESTUFF SET ACTION = 'ROLL TIDE'
WHERE ACTION = 'TIDE ROLL';
COMMIT;
END;
/

EXECUTE MAKEAROLLTIDE;