INSERT INTO article(title, content) VALUES('테스트', '테스트');
INSERT INTO article(title, content) VALUES('취미', '댓글에 적어주세요.');
INSERT INTO article(title, content) VALUES('주로하는 운동', '댓글에 적어주세요.');
INSERT INTO article(title, content) VALUES('좋아하는 가수', '댓글에 적어주세요.');

INSERT INTO comment(article_id, nickname, body) VALUES(2, '홍길동', '유튜브 보기');
INSERT INTO comment(article_id, nickname, body) VALUES(2, '김철수', '독서');
INSERT INTO comment(article_id, nickname, body) VALUES(2, '김영희', '게임');

INSERT INTO comment(article_id, nickname, body) VALUES(3, '홍길동', '배드민턴');
INSERT INTO comment(article_id, nickname, body) VALUES(3, '김철수', '자전거');
INSERT INTO comment(article_id, nickname, body) VALUES(3, '김영희', '산책');

INSERT INTO comment(article_id, nickname, body) VALUES(4, '홍길동', '뉴진스');
INSERT INTO comment(article_id, nickname, body) VALUES(4, '김철수', '아이유');
INSERT INTO comment(article_id, nickname, body) VALUES(4, '김영희', 'BTS');