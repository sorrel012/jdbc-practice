
INSERT INTO NOTICE(ID, TITLE, WRITER_ID, CONTENT) VALUES(6, '전화번호로 연락 주시기 바랍니다. 010-123-5678'
                                                                , 'quest'
                                                                , '연락처를 남깁니다.');

INSERT INTO NOTICE(ID, TITLE, WRITER_ID, CONTENT) VALUES(7, '선반-접시-그릇'
                                                        , 'OKAY'
                                                        , '식기 준비.');

INSERT INTO NOTICE(ID, TITLE, WRITER_ID, CONTENT) VALUES(1, 'JDBC란 무엇인가?'
                                                        , 'sorrel', '자고 싶다.');
                                                        
INSERT INTO NOTICE(ID, TITLE, WRITER_ID, CONTENT) VALUES(4, '백엔드와 프론트엔드의 차이점'
                                                        , 'hanee', '적성에 뭐가 맞지?');
                                                        
INSERT INTO NOTICE(ID, TITLE, WRITER_ID, CONTENT) VALUES(2, 'Array'
                                                        , 'jiyou', '다차원 배열 출력');                                                     

INSERT INTO NOTICE(ID, TITLE, WRITER_ID, CONTENT) VALUES(3, '효율적으로 영어 공부하기'
                                                        , 'eng', '영어 공부 방법');
                                                        
DELETE NOTICE  WHERE HIT IN (1, 9, 12);

SELECT * FROM NOTICE;

SELECT * FROM NOTICE WHERE TITLE LIKE '%-%-%';

SELECT * FROM NOTICE WHERE REGEXP_LIKE(TITLE , '01[016-9]-\d{3,4}-\d{4}');

SELECT * FROM MEMBER;

UPDATE MEMBER SET EMAIL = 'sorrel012@gmail.com' WHERE ID='sorrel';

SELECT ID, PWD, NAME, EMAIL FROM MEMBER WHERE REGEXP_LIKE(EMAIL , '\D\w*@\D\w*.(org|net|com)');

