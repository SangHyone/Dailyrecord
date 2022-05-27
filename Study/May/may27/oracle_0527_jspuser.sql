-- 답변형 게시판의 로직을 처리해 보자
CREATE SEQUENCE category_idx_seq;
CREATE TABLE category(
	idx NUMBER PRIMARY KEY,
	REF NUMBER DEFAULT 0, -- 원본글의 번호
	seq NUMBER DEFAULT 0, -- 나타날 순서
	lev NUMBER DEFAULT 0, -- 몇단계? 0이면 원본, 1이면 답변,2면 답변의 답변.....
	item varchar(50) NOT NULL, -- 항목
	del char(1) DEFAULT 'N' CHECK(del IN ('Y','N'))  -- 삭제유무저장. 값제한 Y/N만 입력 가능
);

-- 원본글 2개를 넣어보자

INSERT INTO category (idx, REF, item) values(category_idx_seq.nextval,category_idx_seq.currval,'전자제품'); -- 원본글 쿼리
INSERT INTO category (idx, REF, item) values(category_idx_seq.nextval,category_idx_seq.currval,'주류');

SELECT * FROM CATEGORY c ;

-- 주류 밑으로 소주를 저장해보자
INSERT INTO category (idx, REF,seq,lev, item) values(category_idx_seq.nextval,2,1,1,'소주');
SELECT * FROM CATEGORY c ;

-- 전자제품 밑으로 냉장고를 저장해보자
INSERT INTO category (idx, REF,seq,lev, item) values(category_idx_seq.nextval,1,1,1,'냉장고'); -- 답변 등록 쿼리
SELECT * FROM CATEGORY c ;

SELECT * FROM CATEGORY c ORDER BY REF DESC , seq; -- selectList할 쿼리

-- 주류 밑에 맥주를 추가해보자 --->  5 2 1 1
-- 먼저 seq보다 큰 값을 모두 1씩 증가
UPDATE CATEGORY SET seq = seq + 1 WHERE  REF = 2 AND seq>0;
INSERT INTO category (idx, REF,seq,lev, item) values(category_idx_seq.nextval,2,1,1,'맥주');
SELECT * FROM CATEGORY c ORDER BY REF DESC , seq;

-- 맥주 밑에 카스를 추가해보자
UPDATE CATEGORY SET seq = seq + 1 WHERE  REF = 2 AND seq>1;
INSERT INTO category (idx, REF,seq,lev, item) values(category_idx_seq.nextval,2,2,2,'카스');
SELECT * FROM CATEGORY c ORDER BY REF DESC , seq;

-- 맥주 밑으로 테라를 넣어보자
UPDATE CATEGORY SET seq = seq + 1 WHERE  REF = 2 AND seq>1;
INSERT INTO category (idx, REF,seq,lev, item) values(category_idx_seq.nextval,2,2,2,'테라');
SELECT * FROM CATEGORY c ORDER BY REF DESC , seq;
