
INSERT INTO NOTICE(ID, TITLE, WRITER_ID, CONTENT) VALUES(6, '��ȭ��ȣ�� ���� �ֽñ� �ٶ��ϴ�. 010-123-5678'
                                                                , 'quest'
                                                                , '����ó�� ����ϴ�.');

INSERT INTO NOTICE(ID, TITLE, WRITER_ID, CONTENT) VALUES(7, '����-����-�׸�'
                                                        , 'OKAY'
                                                        , '�ı� �غ�.');

INSERT INTO NOTICE(ID, TITLE, WRITER_ID, CONTENT) VALUES(1, 'JDBC�� �����ΰ�?'
                                                        , 'sorrel', '�ڰ� �ʹ�.');
                                                        
INSERT INTO NOTICE(ID, TITLE, WRITER_ID, CONTENT) VALUES(4, '�鿣��� ����Ʈ������ ������'
                                                        , 'hanee', '������ ���� ����?');
                                                        
INSERT INTO NOTICE(ID, TITLE, WRITER_ID, CONTENT) VALUES(2, 'Array'
                                                        , 'jiyou', '������ �迭 ���');                                                     

INSERT INTO NOTICE(ID, TITLE, WRITER_ID, CONTENT) VALUES(3, 'ȿ�������� ���� �����ϱ�'
                                                        , 'eng', '���� ���� ���');
                                                        
DELETE NOTICE  WHERE HIT IN (1, 9, 12);

SELECT * FROM NOTICE;

SELECT * FROM NOTICE WHERE TITLE LIKE '%-%-%';

SELECT * FROM NOTICE WHERE REGEXP_LIKE(TITLE , '01[016-9]-\d{3,4}-\d{4}');

SELECT * FROM MEMBER;

UPDATE MEMBER SET EMAIL = 'sorrel012@gmail.com' WHERE ID='sorrel';

SELECT ID, PWD, NAME, EMAIL FROM MEMBER WHERE REGEXP_LIKE(EMAIL , '\D\w*@\D\w*.(org|net|com)');

