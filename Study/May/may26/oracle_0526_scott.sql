-- scott으로 접속해서 다음 실행
DROP TABLE DEPT;
CREATE TABLE DEPT
       (DEPTNO NUMBER(2) CONSTRAINT PK_DEPT PRIMARY KEY,
	DNAME VARCHAR2(14) ,
	LOC VARCHAR2(13) ) ;
DROP TABLE EMP;
CREATE TABLE EMP
       (EMPNO NUMBER(4) CONSTRAINT PK_EMP PRIMARY KEY,
	ENAME VARCHAR2(10),
	JOB VARCHAR2(9),
	MGR NUMBER(4),
	HIREDATE DATE,
	SAL NUMBER(7,2),
	COMM NUMBER(7,2),
	DEPTNO NUMBER(2) CONSTRAINT FK_DEPTNO REFERENCES DEPT);
INSERT INTO DEPT VALUES	(10,'ACCOUNTING','NEW YORK');
INSERT INTO DEPT VALUES (20,'RESEARCH','DALLAS');
INSERT INTO DEPT VALUES	(30,'SALES','CHICAGO');
INSERT INTO DEPT VALUES	(40,'OPERATIONS','BOSTON');
INSERT INTO EMP VALUES  (7369,'SMITH','CLERK',7902,to_date('17-12-1980','dd-mm-yyyy'),800,NULL,20);
INSERT INTO EMP VALUES  (7499,'ALLEN','SALESMAN',7698,to_date('20-2-1981','dd-mm-yyyy'),1600,300,30);
INSERT INTO EMP VALUES  (7521,'WARD','SALESMAN',7698,to_date('22-2-1981','dd-mm-yyyy'),1250,500,30);
INSERT INTO EMP VALUES  (7566,'JONES','MANAGER',7839,to_date('2-4-1981','dd-mm-yyyy'),2975,NULL,20);
INSERT INTO EMP VALUES  (7654,'MARTIN','SALESMAN',7698,to_date('28-9-1981','dd-mm-yyyy'),1250,1400,30);
INSERT INTO EMP VALUES  (7698,'BLAKE','MANAGER',7839,to_date('1-5-1981','dd-mm-yyyy'),2850,NULL,30);
INSERT INTO EMP VALUES  (7782,'CLARK','MANAGER',7839,to_date('9-6-1981','dd-mm-yyyy'),2450,NULL,10);
INSERT INTO EMP VALUES  (7788,'SCOTT','ANALYST',7566,to_date('13-7-1987','dd-mm-yyyy'),3000,NULL,20);
INSERT INTO EMP VALUES  (7839,'KING','PRESIDENT',NULL,to_date('17-11-1981','dd-mm-yyyy'),5000,NULL,10);
INSERT INTO EMP VALUES  (7844,'TURNER','SALESMAN',7698,to_date('8-9-1981','dd-mm-yyyy'),1500,0,30);
INSERT INTO EMP VALUES  (7876,'ADAMS','CLERK',7788,to_date('13-7-1987','dd-mm-yyyy'),1100,NULL,20);
INSERT INTO EMP VALUES  (7900,'JAMES','CLERK',7698,to_date('3-12-1981','dd-mm-yyyy'),950,NULL,30);
INSERT INTO EMP VALUES  (7902,'FORD','ANALYST',7566,to_date('3-12-1981','dd-mm-yyyy'),3000,NULL,20);
INSERT INTO EMP VALUES  (7934,'MILLER','CLERK',7782,to_date('23-1-1982','dd-mm-yyyy'),1300,NULL,10);
DROP TABLE BONUS;
CREATE TABLE BONUS
	(
	ENAME VARCHAR2(10)	,
	JOB VARCHAR2(9)  ,
	SAL NUMBER,
	COMM NUMBER
	) ;
DROP TABLE SALGRADE;
CREATE TABLE SALGRADE
      ( GRADE NUMBER,
	LOSAL NUMBER,
	HISAL NUMBER );
INSERT INTO SALGRADE VALUES (1,700,1200);
INSERT INTO SALGRADE VALUES (2,1201,1400);
INSERT INTO SALGRADE VALUES (3,1401,2000);
INSERT INTO SALGRADE VALUES (4,2001,3000);
INSERT INTO SALGRADE VALUES (5,3001,9999);

SELECT * FROM tab;
SELECT * FROM emp;
SELECT * FROM dept;
SELECT * FROM bonus;
SELECT * FROM SALGRADE;

-- 1일차 과제!!!!!
-- 1. 사원 테이블에서 사원번호가 7369, 7698 번인 사원번호와 이름을 출력하세요?
SELECT 	e.EMPNO , e.ENAME FROM	EMP e WHERE e.EMPNO IN ( 7369, 7698);
SELECT 	e.EMPNO , e.ENAME FROM	EMP e WHERE e.EMPNO=7369 OR e.EMPNO=7698;

-- 2. 사원 테이블에서 사원번호가 7369, 7698 번인 아닌 사원번호와 이름을 출력하세요?
SELECT 	e.EMPNO , e.ENAME FROM	EMP e WHERE e.EMPNO NOT IN ( 7369, 7698);
SELECT 	e.EMPNO , e.ENAME FROM	EMP e WHERE e.EMPNO!=7369 AND e.EMPNO<>7698;

-- 3. 사원 테이블에서 급여(SAL)가 3000에서 5000사이인 사원 정보를 다 출력하세요?
SELECT 	* FROM 	EMP WHERE sal >=3000 AND sal <=5000;
SELECT 	* FROM 	EMP WHERE sal BETWEEN 3000 AND 5000;

-- 4. 사원 테이블에서 고용일자(HIREDATE)가 1981년 12월 1일 이후 고용된 사원 정보를 다 출력하세요?
SELECT 	* FROM 	EMP WHERE HIREDATE >= '1981/12/01';
SELECT 	* FROM 	EMP WHERE HIREDATE >= TO_DATE('1981/12/01','YYYY/MM/DD');

-- 5. 사원 테이블에서 직업(JOB)이 SALESMAN 중에서 사원번호의 최대값을 출력하세요
SELECT 	MAX(EMPNO) FROM 	EMP WHERE JOB = 'SALESMAN';
SELECT	MAX(EMPNO) FROM 	EMP WHERE JOB IN ('SALESMAN');
SELECT	MAX(EMPNO) FROM 	EMP GROUP BY JOB HAVING JOB = 'SALESMAN';


-- 2일차 과제!!!!!

-- 1. 사원 테이블에서 각 사원에 부서명을 아래 예제처럼 출력하세요?
--    (사원, 부서 테이블 조인 시 메니저가 없는 사원은 출력 안함)
--    ex) 정렬은 부서명(DNAME), 사원명(ENAME) 오름차순
SELECT * FROM emp;
SELECT * FROM dept;

SELECT 
	d.DNAME 부서명, e.EMPNO 사번, e.ENAME 이름
FROM 
	EMP e , DEPT d 
WHERE 
	e.DEPTNO = d.DEPTNO AND e.MGR IS NOT NULL 
ORDER BY 
	1, 3;

-- 2. 사원 테이블에서 각 사원에 부서명을 아래 예제처럼 출력하세요?
--    (사원, 부서 테이블 조인 시 메니저가 없는 사원도 출력)
--    ex) 정렬은 부서명(DNAME), 사원명(ENAME) 오름차순

SELECT 
	d.DNAME 부서명, e.EMPNO 사번, e.ENAME 이름
FROM 
	EMP e , DEPT d 
WHERE 
	e.DEPTNO = d.DEPTNO 
ORDER BY 
	1, 3;

-- 3.	부서 위치가 'DALLAS', 'CHICAGO' 곳에 근무하는 사원 정보 아래 
--      예제처럼 출력하세요? (LOC, EMPNO, ENAME)
--      ex) 정렬은 부서위치(LOC) 내림차순, 사원명(ENAME) 오름차순
SELECT 
	d.LOC , e.EMPNO , e.ENAME 
FROM 
	EMP e , DEPT d 
WHERE 
	e.DEPTNO = d.DEPTNO AND d.LOC IN ('DALLAS', 'CHICAGO')
ORDER BY 
	1 desc, 3;
-- 4. 부서별 최고 급여(SAL) 금액을 아래 예제처럼 출력하세요?
--    ex) 메니저 없는 사원은 제외
SELECT 	DEPTNO , MAX(SAL) FROM EMP WHERE MGR IS NOT NULL GROUP BY DEPTNO ORDER BY DEPTNO ;

-- 5.  부서별 최고 급여(SAL) 금액을 받는 사원 정보를 아래 예제처럼 출력하세요?
--     DEPTNO, SAL, EMPNO, ENAME, JOB
--     ex) 매니저가 없는 사원은 제외
--     ㅠㅠ 서브쿼리 문제네요!!!
SELECT 
	DEPTNO, SAL, EMPNO, ENAME, JOB
FROM 
	emp
WHERE 
	(DEPTNO, SAL) IN (SELECT DEPTNO, MAX(SAL) FROM EMP WHERE MGR IS NOT NULL GROUP BY DEPTNO)
ORDER  BY DEPTNO ;
-- ===============================================================================
-- 추가문제
-- ===============================================================================
-- 1. 각 부서별로 1982년 이전에 입사한 직원들의 인원수를 출력하시오.
-- 2. 직원 중 현재시간 기준으로 근무 개월 수가 30년(12 * 30개월) 보다 많은 사람의 이름, 급여 , 입사일 , 부서명을 출력하시오
-- 3. 자신의 관리자 보다 연봉(sal)을 많이 받는 사원의 이름과 연봉을 출력하시오.
-- 4. DALLAS에 근무하는 사원 중 급여 1500 이상인 사원의 이름, 급여, 입사일 , 보너스(comm)을 출력하시오.
-- 5. 이름에 ‘A’ 가 들어가는 사원들의 이름과 부서명 출력하기.
-- 6. 커미션을 받는 사원의 이름, 커미션, 부서이름 출력하시오.
-- 7. 20번 부서의 이름과 그 부서에 근무하는 사원의 이름을 출력하시오.
-- 8. 사원 테이블에서 사원명, 해당 사원의 관리자명, 해당 사원의 관리자의 관리자명을 검색하시오
-- 9.  8번 결과에서 상위 관리자가 없는 모든 사원의 이름도 사원명에 출력되도록 수정하시오.
-- 10. 사원 테이블에서 사원명과 해당 사원의 관리자명을 검색하시오
SELECT e1.ENAME, e2.ENAME   FROM emp e1, emp e2 WHERE e1.EMPNO = e2.MGR ;





