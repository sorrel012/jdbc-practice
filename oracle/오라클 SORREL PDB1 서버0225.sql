
CREATE VIEW NOTICE_VIEW
AS
SELECT * FROM(
    SELECT ROWNUM NUM, N.* FROM
        (SELECT * FROM NOTICE ORDER BY REGDATE DESC ) N
    );
    
SELECT * FROM NOTICE_VIEW WHERE NUM BETWEEN 1 AND 3;
    