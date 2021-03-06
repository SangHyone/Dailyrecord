-- ================================================================================================	
-- CONNECT BY 를 이용한 계층 쿼리
-- ================================================================================================	
-- 1번 부터 10번까지 번호를 생성하려면 지금까지는 이런 방법을 사용 했었다.
SELECT rownum as "NO" FROM temp WHERE rownum<=15; -- 15번까지 나온다	
SELECT rownum as "NO" FROM temp WHERE rownum<=35; -- 레코드 갯수를 넘는 번호는 못만든다.	-- 20개다.

-- 조건 없이 조인하면 n*n개 총 20*20=400까지 가능
SELECT rownum as "NO" FROM temp, temp WHERE rownum<=35; 

-- CONNECT BY를 이용한 번호 생성
SELECT 
	LEVEL AS NO
FROM 
	dual
CONNECT BY 
	LEVEL <= 10;

SELECT 
	LEVEL AS NO
FROM 
	dual
CONNECT BY 
	LEVEL <= 100;
	
-- 2022년 01월 ~ 2022년 12월까지 출력하고 싶다.
SELECT 
	'2022년 ' || LPAD(LEVEL, 2, 0) || '월' AS "DATE"
FROM 
	dual
CONNECT BY 
	LEVEL <= 12;

-- 특정 날짜구간 조회하기
-- 2022년 5월 20일부터 6월 10일까지를 출력하고 싶다.
SELECT 
	TO_CHAR(TO_DATE('20220520','YYYYMMDD') + (LEVEL-1),'YYYY-MM-DD')  AS 날짜
FROM 
	dual
CONNECT BY 
	LEVEL <= (TO_DATE('20220610','YYYYMMDD')-TO_DATE('20220520','YYYYMMDD'))+1
	
-- 이번달 1일부터 말일까지의 날짜를 조회하시오
SELECT 
	TO_DATE(TO_CHAR(SYSDATE,'YYYYMM"01"'),'YYYYMMDD') + (LEVEL-1) "날짜"
FROM 
	dual
CONNECT BY 
	LEVEL <= (LAST_DAY(SYSDATE) - TO_DATE(TO_CHAR(SYSDATE,'YYYYMM"01"'),'YYYYMMDD')+1);

-- 테이블로 저장해보자
CREATE TABLE board2205 AS 
	SELECT 
		LEVEL NO,
		TO_DATE(TO_CHAR(SYSDATE,'YYYYMM"01"'),'YYYYMMDD') + (LEVEL-1) "DATE"
	FROM 
		dual
	CONNECT BY 
		LEVEL <= (LAST_DAY(SYSDATE) - TO_DATE(TO_CHAR(SYSDATE,'YYYYMM"01"'),'YYYYMMDD')+1);
	
SELECT * FROM board2205;

-- 직급별로 계층적으로 조회하고 싶다.
SELECT * FROM TDEPT t;
-- 사장실을 추가해보자
INSERT INTO	TDEPT 
	(DEPT_CODE, DEPT_NAME, PARENT_DEPT, USE_YN, AREA,BOSS_ID)
VALUES 
	('000000','사장실','  ','Y','서울','');
	
SELECT * FROM TDEPT t;

-- 상위부서 적용
update tdept 
set parent_dept='000000' where dept_code=parent_dept;

SELECT * FROM TDEPT t;

-- 부서를 상위부서부터 차례대로 단계를 붙여 조회해보자!!!
SELECT 
	LEVEL, DEPT_CODE , DEPT_NAME 
FROM 
	tdept
CONNECT BY 
	PRIOR DEPT_CODE = PARENT_DEPT;
	
SELECT 
	LEVEL, DEPT_CODE , DEPT_NAME 
FROM 
	tdept
CONNECT BY 
	PRIOR DEPT_CODE = PARENT_DEPT START WITH DEPT_CODE = '000000';

SELECT 
	LEVEL, DEPT_CODE , DEPT_NAME 
FROM 
	tdept
CONNECT BY 
	PRIOR DEPT_CODE = PARENT_DEPT START WITH DEPT_CODE = 'AA0001';

SELECT 
	LEVEL, 
	LPAD(DEPT_CODE, LEVEL*6,' '),
	LPAD(DEPT_NAME, LEVEL *8, ' ') 
FROM 
	tdept
CONNECT BY 
	PRIOR DEPT_CODE = PARENT_DEPT START WITH DEPT_CODE = '000000';

-- where로 조건을 주면? 상위 부서만 사려지고 영업부서 밑의 모든 부서가 기술지원이 되어버린다.
SELECT 
	LEVEL, 
	LPAD(DEPT_CODE, LEVEL*6,' '),
	LPAD(DEPT_NAME, LEVEL *8, ' ') 
FROM 
	tdept
WHERE 
	DEPT_CODE <> 'CA0001'
CONNECT BY 
	PRIOR DEPT_CODE = PARENT_DEPT START WITH DEPT_CODE = '000000';

-- 조건을 CONNECT BY절에 줘야 한다. 그래야 하위부서까지 모두 제거된다.
SELECT 
	LEVEL, 
	LPAD(DEPT_CODE, LEVEL*6,' '),
	LPAD(DEPT_NAME, LEVEL *8, ' ') 
FROM 
	tdept
CONNECT BY 
	PRIOR DEPT_CODE = PARENT_DEPT AND DEPT_CODE <> 'CA0001' START WITH DEPT_CODE = '000000';

-- START WITH 값을 변경하면 원하는 레벨 값만 조회가 가능하다.
-- 기술지원부만 보고싶다.
SELECT 
	LEVEL, 
	LPAD(DEPT_CODE, LEVEL*6,' '),
	LPAD(DEPT_NAME, LEVEL *8, ' ') 
FROM 
	tdept
CONNECT BY 
	PRIOR DEPT_CODE = PARENT_DEPT START WITH DEPT_CODE = 'BA0001';
	
-- 역전개도 가능할까?
SELECT 
	LEVEL, 
	LPAD(DEPT_CODE, LEVEL*6,' '),
	LPAD(DEPT_NAME, LEVEL *8, ' ') 
FROM 
	tdept
CONNECT BY 
	PRIOR PARENT_DEPT  = DEPT_CODE  -- 여기
	START WITH DEPT_CODE = 'BC0001'; -- 여기
	
-- 역전개시 PRIOR절을 변경하지 않으면 어떻게 될까요?
SELECT 
	LEVEL, 
	LPAD(DEPT_CODE, LEVEL*6,' '),
	LPAD(DEPT_NAME, LEVEL *8, ' ') 
FROM 
	tdept
CONNECT BY 
	PRIOR DEPT_CODE  = PARENT_DEPT  -- 여기를 변경하지 않으면
	START WITH DEPT_CODE = 'BC0001'; -- 여기	


	-- ================================================================================
-- 5장. 랭킹
-- ================================================================================

CREATE TABLE SALE_HIST(
  SALE_DATE  DATE NOT NULL,
  SALE_SITE  VARCHAR2(10) NOT NULL,
  SALE_ITEM  VARCHAR2(10) NOT NULL,
  SALE_AMT   NUMBER,
  CONSTRAINT SALEHIST_PK PRIMARY KEY (SALE_DATE,SALE_SITE,SALE_ITEM)
);
INSERT INTO SALE_HIST VALUES('20010501','01','PENCIL',  5000);
INSERT INTO SALE_HIST VALUES('20010501','01','NOTEBOOK',9000);
INSERT INTO SALE_HIST VALUES('20010501','01','ERASER',  4500);
INSERT INTO SALE_HIST VALUES('20010501','02','PENCIL',  2500);
INSERT INTO SALE_HIST VALUES('20010501','02','NOTEBOOK',7000);
INSERT INTO SALE_HIST VALUES('20010501','02','ERASER',  3000);
INSERT INTO SALE_HIST VALUES('20010501','03','PENCIL',  2500);
INSERT INTO SALE_HIST VALUES('20010501','03','NOTEBOOK',7000);
INSERT INTO SALE_HIST VALUES('20010501','03','ERASER',  6000);
--
INSERT INTO SALE_HIST VALUES('20010502','01','PENCIL',  6000);
INSERT INTO SALE_HIST VALUES('20010502','01','NOTEBOOK',5000);
INSERT INTO SALE_HIST VALUES('20010502','01','ERASER',  5500);
INSERT INTO SALE_HIST VALUES('20010502','02','PENCIL',  3500);
INSERT INTO SALE_HIST VALUES('20010502','02','NOTEBOOK',7000);
INSERT INTO SALE_HIST VALUES('20010502','02','ERASER',  4000);
INSERT INTO SALE_HIST VALUES('20010502','03','PENCIL',  5500);
INSERT INTO SALE_HIST VALUES('20010502','03','NOTEBOOK',4500);
INSERT INTO SALE_HIST VALUES('20010502','03','ERASER',  5000);
--
INSERT INTO SALE_HIST VALUES('20010503','01','PENCIL',  7000);
INSERT INTO SALE_HIST VALUES('20010503','01','NOTEBOOK',6000);
INSERT INTO SALE_HIST VALUES('20010503','01','ERASER',  6500);
INSERT INTO SALE_HIST VALUES('20010503','02','PENCIL',  3500);
INSERT INTO SALE_HIST VALUES('20010503','02','NOTEBOOK',5000);
INSERT INTO SALE_HIST VALUES('20010503','02','ERASER',  5000);
INSERT INTO SALE_HIST VALUES('20010503','03','PENCIL',  6500);
INSERT INTO SALE_HIST VALUES('20010503','03','NOTEBOOK',3500);
INSERT INTO SALE_HIST VALUES('20010503','03','ERASER',  7000);
--
INSERT INTO SALE_HIST VALUES('20010504','01','PENCIL',  5500);
INSERT INTO SALE_HIST VALUES('20010504','01','NOTEBOOK',6500);
INSERT INTO SALE_HIST VALUES('20010504','01','ERASER',  3500);
INSERT INTO SALE_HIST VALUES('20010504','02','PENCIL',  7500);
INSERT INTO SALE_HIST VALUES('20010504','02','NOTEBOOK',5000);
INSERT INTO SALE_HIST VALUES('20010504','02','ERASER',  4000);
INSERT INTO SALE_HIST VALUES('20010504','03','PENCIL',  3500);
INSERT INTO SALE_HIST VALUES('20010504','03','NOTEBOOK',5500);
INSERT INTO SALE_HIST VALUES('20010504','03','ERASER',  3000);
COMMIT;

SELECT * FROM SALE_HIST sh;

-- 순위 구하기
SELECT 
	EMP_ID , EMP_NAME , SALARY ,
	DENSE_RANK () OVER (ORDER BY SALARY DESC) AS "순위1", -- 동률처리 방식이 다르다.
	RANK () OVER (ORDER BY SALARY DESC) AS "순위2",
	RANK () OVER (ORDER BY SALARY ) AS "순위3"
FROM 
	TEMP t ;

-- 부서별 급여 순위를 보고싶다.
SELECT 
	DEPT_CODE , avg(SALARY)
FROM 
	TEMP t 
GROUP BY 
	DEPT_CODE;
	
SELECT 
	DEPT_CODE , avg(SALARY), RANK() OVER (ORDER BY avg(SALARY) desc) 순위 
FROM 
	TEMP t 
GROUP BY 
	DEPT_CODE;

SELECT 
	DEPT_CODE , avg(SALARY), RANK() OVER (PARTITION BY DEPT_CODE ORDER BY avg(SALARY) desc) 순위 
FROM 
	TEMP t 
GROUP BY 
	DEPT_CODE;


-- 부서별 급여 합계 순위
SELECT 
	DEPT_CODE , EMP_ID , sum(SALARY),
	rank() OVER (PARTITION BY GROUPING(DEPT_CODE), GROUPING (EMP_ID) ORDER BY SUM(SALARY) DESC) 순위
FROM 
	temp
GROUP BY 
	ROLLUP(DEPT_CODE, EMP_ID);

	
-- 문제] sale_hits의 자료를 이용하여 일자별 매출 순위와 순위별 사업장 품목을 보여라!!!!
SELECT * FROM SALE_HIST sh;

SELECT 
	SH.*, RANK() OVER (PARTITION BY SALE_DATE ORDER BY SALE_AMT DESC) 순위
FROM 
	SALE_HIST sh ;

-- CUME_DIST, PERCENT_RANK, NTILE(N), ROW_NUMBER()

SELECT 
	EMP_ID , EMP_NAME , SALARY ,
	RANK() OVER (ORDER BY SALARY desc) 순위1,
	CUME_DIST() OVER (ORDER BY SALARY desc) 순위2,  -- 순위를 0~1사이의 실수로 표시
	COUNT(SALARY) OVER (ORDER BY SALARY RANGE BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW) 순위3
FROM 
	TEMP t ;

SELECT 
	EMP_ID , EMP_NAME , SALARY ,
	rank() OVER (ORDER BY SALARY ) 순위1,			-- 순위를 자연수로 표시
	CUME_DIST() OVER (ORDER BY SALARY ) 순위2,		-- 순위를 0~1사이의 실수로 표시
	PERCENT_RANK() OVER (ORDER BY SALARY)  순위3,	-- 퍼센트
	NTILE(5) OVER (ORDER BY SALARY ) 순위4,			-- n개의 그룹으로 나눈다.
	ROW_NUMBER() OVER (ORDER BY SALARY ) 순위5		-- 파티션 내의 실행된 ROW 순서의 일련번호
FROM 
	TEMP;

-- 입사연도별 급여의 합계를 구하라
SELECT 
	SUBSTR(EMP_ID, 1, 4), sum(SALARY)
FROM 
	TEMP t 
GROUP BY
	SUBSTR(EMP_ID, 1, 4); 

-- 입사연도별 차례대로 전부 급여의 합계를 구하라
SELECT 
	SUBSTR(EMP_ID, 1, 4), EMP_ID , EMP_NAME,  sum(SALARY)
FROM 
	TEMP t 
GROUP BY
	SUBSTR(EMP_ID, 1, 4), EMP_ID , EMP_NAME 
ORDER BY 
	1;

-- 순위를 구하고 싶다.
SELECT 
	SUBSTR(EMP_ID, 1, 4), EMP_ID , EMP_NAME,  sum(SALARY),
	RANK() OVER (PARTITION BY SUBSTR(EMP_ID, 1, 4) ORDER BY SALARY) 순위1,
	CUME_DIST() OVER (PARTITION BY SUBSTR(EMP_ID, 1, 4) ORDER BY SALARY) 순위2,
	PERCENT_RANK() OVER (PARTITION BY SUBSTR(EMP_ID, 1, 4) ORDER BY SALARY) 순위3,
	NTILE(2) OVER (PARTITION BY SUBSTR(EMP_ID, 1, 4) ORDER BY SALARY) 순위4,
	ROW_NUMBER() OVER (PARTITION BY SUBSTR(EMP_ID, 1, 4) ORDER BY SALARY) 순위5
FROM 
	TEMP t 
GROUP BY
	SUBSTR(EMP_ID, 1, 4), EMP_ID , EMP_NAME , SALARY ;

-- SALE_HITS의 자료를 이용하여 '01' 사업장의 품목별 당일 판매액과 
-- 당일까지의 누적 판매액을 구하는 쿼리
SELECT 
	SH.* , sum(SALE_AMT) OVER (PARTITION BY SALE_ITEM ORDER BY SALE_ITEM ROWS UNBOUNDED PRECEDING) 누계
FROM 
	SALE_HIST sh 
WHERE
	SALE_SITE = '01'
ORDER BY 
	SALE_ITEM , SALE_DATE ;

-- 가장 간단한 형태의 익명 프로시져!!!
BEGIN
	DBMS_OUTPUT.PUT_LINE('Hello PL/SQL!!!');
END;

BEGIN
	FOR cnt IN 1..10 LOOP
		DBMS_OUTPUT.PUT_LINE('Hello PL/SQL!!!');		
	END LOOP;
END;

-- 1~100까지 합
DECLARE -- 선언부
	vsum NUMBER := 0;
BEGIN
	FOR cnt IN 1..100 LOOP
		vsum := vsum + cnt;		
	END LOOP;
	DBMS_OUTPUT.PUT_LINE('1~100까지 합 : ' || vsum);		
END;

-- ===================================================================================
-- 사원 정보를 저장하는 프로시져를 만들어 보자
-- ===================================================================================
-- 사번,이름,연봉만 저장하는 임시테이블을 만들어서 작업해보자
CREATE TABLE emp2 AS SELECT EMP_ID id, EMP_NAME name, SALARY sal  FROM TEMP t ;
SELECT * FROM emp2;
CREATE OR REPLACE PROCEDURE insert_emp2(
	vid IN NUMBER ,
	vname IN Varchar2,
	vsal IN NUMBER 
)
IS 
BEGIN 
	INSERT INTO emp2 VALUES (vid,vname,vsal);
	COMMIT;
	DBMS_OUTPUT.PUT_LINE('사번 : ' || vid);		
	DBMS_OUTPUT.PUT_LINE('이름 : ' || vname);		
	DBMS_OUTPUT.PUT_LINE('연봉 : ' || vsal);		
	DBMS_OUTPUT.PUT_LINE('저장 성공!!!');		
END;

-- 프로시져 호출
DELETE from emp2; -- 모두 삭제
SELECT * FROM emp2;
CALL insert_emp2(20200501,'나그네',56789000);
SELECT * FROM emp2;

-- 지정 사번의 연봉을 10% 인상하는 프로시져를 작성해보자
CREATE OR REPLACE PROCEDURE update_sal(
	vid IN NUMBER 
)
IS 
BEGIN 
	UPDATE emp2 SET sal = sal * 1.1 WHERE id=vid;
END;


SELECT * FROM emp2;
CALL update_sal(20200501);
SELECT * FROM emp2;
CALL insert_emp2(20200502,'나사람', 34567800);
SELECT * FROM emp2;
CALL update_sal(20200502);
SELECT * FROM emp2;

-- 사번과 인상률을 인수로 받아 연봉을 변경하도록 바꿔보자
CREATE OR REPLACE PROCEDURE update_sal(
	vid IN NUMBER ,
	vrate IN NUMBER
)
IS 
BEGIN 
	UPDATE emp2 SET sal = sal * (1+vrate) WHERE id=vid;
END;
SELECT * FROM emp2;

CALL update_sal(20200501, 0.5)

SELECT * FROM emp2;

-- SQL 전용 클라이언트에서 프로시져를 호출하는 방법
-- EXECUTE update_sal(20200501, 0.5);

-- 프로시져와 함수의 차이는 리턴값이 있느냐 여부이다, 리턴값이 있으면 function이라 한다.

-- 사번과 인상률을 인수로 받아 연봉을 변경하고 변경된 연봉을 돌려주는 함수를 만들어 보자
CREATE OR REPLACE FUNCTION  update_sal_fn(vid IN NUMBER ) RETURN NUMBER 
IS 
	vsal NUMBER 
BEGIN 
	UPDATE emp2 SET sal = sal * 1.1 WHERE id=vid;
	COMMIT;
	SELECT sal INTO vsal FROM emp2 WHERE id=vid;
	RETURN vsal;
END;

-- 함수는 select 명령으로 실행한다.
SELECT update_sal_fn(20200501) FROM dual;

CREATE OR REPLACE FUNCTION  get_sal_fn(vid IN NUMBER ) RETURN NUMBER 
IS 
	vsal NUMBER 
BEGIN 
	SELECT sal INTO vsal FROM emp2 WHERE id = vid;
	RETURN vsal;
END;

SELECT get_sal_fn(20200501) FROM dual;









