SELECT * FROM MEMBER;
SELECT * FROM NOTICE;

SELECT * FROM MEMBER INNER JOIN NOTICE ON MEMBER.ID = NOTICE.WRITER_ID;

SELECT * FROM MEMBER LEFT OUTER JOIN NOTICE ON MEMBER.ID = NOTICE.WRITER_ID;

SELECT * FROM MEMBER RIGHT OUTER JOIN NOTICE ON MEMBER.ID = NOTICE.WRITER_ID;

SELECT * FROM MEMBER FULL OUTER JOIN NOTICE ON MEMBER.ID = NOTICE.WRITER_ID;

SELECT M.*, B.NAME BOSS_NAME FROM MEMBER M LEFT OUTER JOIN MEMBER B ON B.ID = M.BOSS_ID;

SELECT ID, NAME FROM MEMBER
    UNION
SELECT WRITER_ID, TITLE FROM NOTICE;

SELECT ID, NAME FROM MEMBER
    UNION ALL
SELECT WRITER_ID, TITLE FROM NOTICE;

SELECT ID, NAME FROM MEMBER
    MINUS
SELECT WRITER_ID, TITLE FROM NOTICE;

SELECT ID, NAME FROM MEMBER
    INTERSECT
SELECT WRITER_ID, TITLE FROM NOTICE;


CREATE VIEW NOTICEVIEW 
AS
    SELECT N.ID, N.TITLE, N.WRITER_ID, M.NAME WRITER_NAME, COUNT(C.ID) CNT FROM MEMBER M
    RIGHT OUTER JOIN NOTICE N ON M.ID = N.WRITER_ID
    LEFT OUTER JOIN "COMMENT" C ON N.ID = C.NOTICE_ID
    GROUP BY N.ID, N.TITLE, N.WRITER_ID, M.NAME;
    
SELECT * FROM NOTICEVIEW WHERE TITLE LIKE '%J%';

COMMIT;