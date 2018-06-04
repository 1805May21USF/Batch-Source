CREATE OR REPLACE PROCEDURE GET_ALL_ALBUMS(S OUT SYS_REFCURSOR)
IS
BEGIN
OPEN S FOR SELECT ALBUMID, TITLE FROM ALBUM;
END;
/

DECLARE
S SYS_REFCURSOR;
ALBUM_ID ALBUM.ALBUMID%TYPE; --SET ALBUM_ID AS WHATEVER DATATYPE  ALBUMID IS
ALBUMNAME ALBUM.TITLE%TYPE;
BEGIN
GET_ALL_ALBUMS(S);
LOOP
FETCH S INTO ALBUM_ID,ALBUMNAME;
EXIT WHEN S%NOTFOUND; --BREAK OUT OF LOOP WHEN NO MORE ROWS ARE AVAILABLE
DBMS_OUTPUT.PUT_LINE(ALBUM_ID||' IS CURRENT ID,'|| ALBUMNAME||'IS CURRENT NAME');
END LOOP;
CLOSE S;
END;
/

SET SERVEROUTPUT ON;