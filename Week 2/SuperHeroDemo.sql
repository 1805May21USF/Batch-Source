CREATE TABLE SUPERHERO(
HEROID INTEGER PRIMARY KEY,
HERONAME VARCHAR2(30)
);

CREATE TABLE POWERS (
POWERID INT PRIMARY KEY,
POWERNAME VARCHAR2(30)
);

CREATE SEQUENCE HEROSEQ;
CREATE SEQUENCE POWSEQ;

CREATE OR REPLACE PROCEDURE INSERTSUPERHERO(NAME IN VARCHAR2)
AS
BEGIN
INSERT INTO SUPERHERO VALUES(HEROSEQ.NEXTVAL, NAME);
COMMIT;
END;
/
