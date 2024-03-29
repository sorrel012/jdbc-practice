SELECT * FROM NOTICE;

SELECT * FROM NOTICE WHERE ROWNUM BETWEEN 1 AND 4;

SELECT * FROM (SELECT ROWNUM NUM, NOTICE.* FROM NOTICE) WHERE NUM BETWEEN 3 AND 6;



SELECT * FROM MEMBER;

UPDATE MEMBER SET AGE = 26 WHERE ID='hanee' OR ID='sorrel';

UPDATE MEMBER SET AGE = 27 WHERE ID='jiyou';

UPDATE MEMBER SET AGE = 30 WHERE ID='youl';

UPDATE MEMBER SET AGE = 29 WHERE ID='yeon';

UPDATE MEMBER SET BIRTHDAY='1998-01-17' WHERE ID='hanee';

UPDATE MEMBER SET BIRTHDAY='1998-06-27' WHERE ID='sorrel';

UPDATE MEMBER SET BIRTHDAY='1997-05-25' WHERE ID='jiyou';

UPDATE MEMBER SET BIRTHDAY='1995-12-01' WHERE ID='yeon';

UPDATE MEMBER SET BIRTHDAY='1994-06-06' WHERE ID='youl';


UPDATE MEMBER SET PHONE='010-1234-5678' WHERE ID='hanee';

UPDATE MEMBER SET PHONE='011-2468-3691' WHERE ID='sorrel';

UPDATE MEMBER SET PHONE='010-1234-7979' WHERE ID='jiyou';

UPDATE MEMBER SET PHONE='016-3456-7890' WHERE ID='yeon';

UPDATE MEMBER SET PHONE='011-1234-5679' WHERE ID='youl';

UPDATE MEMBER SET PHONE=NULL WHERE ID='youl';


SELECT AGE FROM MEMBER;

SELECT DISTINCT AGE FROM MEMBER;

SELECT NAME FROM MEMBER;
SELECT SUBSTR(NAME, 2) FROM MEMBER;

SELECT NAME FROM MEMBER;

SELECT * FROM MEMBER;

SELECT NAME, SUBSTR(BIRTHDAY, 6, 2) BIRTHDAY_MONTH FROM MEMBER;

SELECT PHONE FROM MEMBER;

SELECT * FROM MEMBER WHERE SUBSTR(PHONE, 1, 3) = '011';

SELECT * FROM MEMBER WHERE SUBSTR(BIRTHDAY, 6, 2) BETWEEN '05' AND '07';
SELECT * FROM MEMBER WHERE SUBSTR(BIRTHDAY, 6, 2) IN ('05', '06', '07');

SELECT * FROM MEMBER WHERE PHONE IS NULL AND SUBSTR(BIRTHDAY, 6, 2) IN ('05', '06', '07');
COMMIT;


UPDATE MEMBER SET ID='sorrel' WHERE ID='YOUL';

SELECT * FROM MEMBER WHERE LOWER(ID) = 'youl';

SELECT * FROM MEMBER WHERE UPPER(ID) = 'YOUL';

SELECT NAME, REPLACE(BIRTHDAY, '-', '') BIRTHDAY FROM MEMBER;
