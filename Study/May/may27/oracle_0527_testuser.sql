-- ====================================================================================
-- 서브쿼리(Sub-Query) : 쿼리안에 쿼리가 들어간다.
-- ====================================================================================
-- 1. 단일행 서브쿼리 : 서브쿼리의 결과가 1개인 서브쿼리
-- ------------------------------------------------------------------------------------   
-- 평균 연봉보다 많은 직원의 목록을 보고싶다면 어떻게 해야 할까?
-- 1) 일단은 평균연봉을 구한다.
SELECT avg(SALARY) FROM temp;
-- 2) 1번에서 구한 값을 기억하고 쿼리를 만들어 목록을 구한다.
SELECT * FROM temp WHERE SALARY >=43800000;
-- 이것을 여러번 해야 한다면 매번 위와같은 일을 반복해야 한다. 한번에 할 수 없을까? 이때 서브쿼리를 사용한다.
SELECT * FROM temp WHERE SALARY >=(SELECT avg(SALARY) FROM temp);
-- 초소 연봉을 받는 직원들의 목록
SELECT * FROM temp WHERE SALARY =(SELECT min(SALARY) FROM temp);

-- ====================================================================================
-- 2. 복수행 서브쿼리 : 서브쿼리의 결과가 여러 행인 서브쿼리
--                      IN, ANY, ALL, Exists와 같이; 사용된다.
-- ------------------------------------------------------------------------------------
-- 인천에 근무하는 직원의 사번과 성명을 읽어오자
SELECT * FROM temp; -- 이런 여기에 근무지가 없다.
SELECT * FROM tdept;
SELECT * FROM tdept WHERE AREA = '인천';

-- 조인을 이용하는 방법
SELECT 
	t1.EMP_ID , t1.EMP_NAME , t2.AREA 
FROM 
	TEMP t1 , TDEPT t2 
WHERE 
	t1.DEPT_CODE = t2.DEPT_CODE AND t2.AREA = '인천';

-- 서브쿼리를 이용하는 방법
SELECT 
	EMP_ID ,EMP_NAME 
FROM 
	TEMP t 
WHERE 
	DEPT_CODE IN (SELECT DEPT_CODE  FROM tdept WHERE AREA = '인천');

-- 문제] 부서별 커미션을 받는 인원수를 조회하시오

SELECT * FROM tab;
SELECT * FROM TCOM t ;
SELECT * FROM TDEPT t ;
-- 1) 부서별 인원수
SELECT 
	d.DEPT_NAME "부서명" , count(*) "부서별 인원수"
FROM 
	TEMP e, TDEPT d
WHERE 
	e.DEPT_CODE = d.DEPT_CODE  
GROUP BY 
	d.DEPT_NAME ;

-- 2) 1번의 결과에서 커미션을 받는 직원들만으로 조건을 더 주어야한다.

SELECT 
	d.DEPT_NAME "부서명" , count(*) "부서별 인원수"
FROM 
	TEMP e, TDEPT d
WHERE 
	e.DEPT_CODE = d.DEPT_CODE AND e.EMP_ID IN (SELECT t.EMP_ID  FROM TCOM t WHERE t.COMM IS NOT NULL)
GROUP BY 
	d.DEPT_NAME ;
	
-- ====================================================================================
-- 3. 복수행, 복수열 서브쿼리 : 서브쿼리의 결과가 여러 행에 여러 컬럼인 서브쿼리
--                              복수개의 열을 묶어서 비교할때 주로 사용
-- ------------------------------------------------------------------------------------ 
-- 부서 테이블에서 부서코드와 보스ID를 읽어 사원 테이블의 부서코드와 사번이 일치하는 자료를 조회
-- 1) 부서장들만 조회
SELECT t.DEPT_CODE ,t.BOSS_ID  FROM TDEPT t ;

SELECT 
	t.EMP_ID , t.EMP_NAME 
FROM 
	TEMP t 
WHERE 
	(t.DEPT_CODE,t.EMP_ID) IN (SELECT t.DEPT_CODE ,t.BOSS_ID  FROM TDEPT t);

-- ============================================================================================
-- 4. CORRELATED(상관; 상호관계) 서브쿼리 : 내부쿼리가 외부쿼리의 어떤 컬럼을 사용하는 서브쿼리
-- --------------------------------------------------------------------------------------------   
-- 직원 중 자신의 연봉이 자신과 같은 레벨에 해당하는 직원의 평균 연봉보다 많은 경우의 사번과 성명 조회
SELECT 	LEV , AVG(SALARY) FROM 	TEMP GROUP BY LEV ;

SELECT LEV , EMP_NAME , SALARY  FROM TEMP t WHERE LEV = '과장' AND SALARY >= (SELECT AVG(SALARY) FROM TEMP t2 WHERE LEV ='과장') ;
SELECT LEV , EMP_NAME , SALARY  FROM TEMP t WHERE LEV = '부장' AND SALARY >= (SELECT AVG(SALARY) FROM TEMP t2 WHERE LEV ='부장') ;
SELECT LEV , EMP_NAME , SALARY  FROM TEMP t WHERE LEV = '대리' AND SALARY >= (SELECT AVG(SALARY) FROM TEMP t2 WHERE LEV ='대리') ;

-- 위의 내용을 한번에 해결하려면 CORRELATED(상관; 상호관계) 서브쿼리를 이용하면 된다.
SELECT LEV , EMP_NAME , SALARY  FROM TEMP t WHERE SALARY >= (SELECT AVG(SALARY) FROM TEMP t2 WHERE t.LEV  = t2.LEV  ) ;

-- Select결과를 insert하기
-- insert into 테이블명 (컬럼명,...) select 컬럼리스트 from 테이블명
SELECT COUNT(*) FROM TCOM t ;
INSERT INTO tcom (WORK_YEAR, EMP_ID, BONUS_RATE, COMM)
	SELECT '2021', EMP_ID , 0.1, t.SALARY *0.1 FROM TEMP t ;

SELECT COUNT(*) FROM TCOM t ;

/*
오라클의 ANY, SOME, ALL 연산자는 실무에서 자주 사용은 안하지만, 
사용법이 궁금해서 찾아보면 사용법이 생각보다 어렵고 어떤 상황의 쿼리문에서 사용해야 할지 머릿속에 그려지지 않는다.

SOME은 ANY와 이름만 다를뿐 동일한 기능의 연산자이며 아래의 예제는 ANY로만 작성하였다.

ANY(SOME), ALL은 주로 서브쿼리와 함께 사용하는 다중 행 연산자이며, 
ANY는 조건을 만족하는 값이 하나라도 있으면 결과를 리턴하고, 
ALL은 모든 값이 조건을 만족해야 결과를 리턴한다.
 

● ANY 조건 예시 (만족하는 값 하나만 있으면 됨)

조건   결과   설명
 1000 > ANY (500, 1000, 2000)   TRUE    ANY 값에 1000 보다 작은 500이 있으므로 TRUE
 1000 = ANY (500, 1000, 2000)   TRUE    ANY 값에 같은 값 1000이 있으므로 TRUE
 2000 < ANY (500, 1000, 2000)   FALSE    ANY 값에 2000 보다 큰 값이 없으므로 FALSE
 

 = ANY        하나라도 만족하는 값이 있으면 결과를 리턴 (IN과 동일)
 > ANY        값들 중 최소값 보다 크면 결과를 리턴
 >= ANY    값들 중 최소값 보다 크거나 같으면 결과를 리턴
 < ANY        값들 중 최대값 보다 작으면 결과를 리턴
 <= ANY    값들 중 최대값 보다 작거나 같으면 결과를 리턴
 <> ANY    모든 값들 중 다른 값만 리턴 (값이 하나일 때만 가능, 사용X)
 

● ALL 조건 예시 (모든 값을 만족해야 함)
조건   결과   설명
 1000 > ALL (500, 1000, 2000)   FALSE    1000이 ALL의 모든 값 보다 커야하므로 FALSE
 1000 = ALL (500, 1000, 2000)   FALSE    1000이 ALL의 모든 값과 동일해야 하므로 FALSE
 3000 > ALL (500, 1000, 2000)   TRUE    3000은 ALL의 모든 값 보다 크므로 TRUE
 

 > ALL     값들 중 최대값 보다 크면 결과를 리턴
 >= ALL  값들 중 최대값 보다 크거나 같으면 결과를 리턴
 < ALL     값들 중 최소값 보다 작으면 결과를 리턴
 <= ALL  값들 중 최소값 보다 작거나 같으면 결과를 리턴
 = ALL     모든 값들과 같아야 결과를 리턴 (값이 하나일 때만 가능, 사용X)
 <> ALL  모든 값들과 다르면 결과를 리턴
 */

-- 임시테이블 작성
WITH emp AS (
  SELECT 7839 empno, 'KING'   ename, 'PRESIDENT' job, NULL mgr, '1981-11-17' hiredate, 5000 sal, 10 deptno FROM DUAL UNION ALL
  SELECT 7566 empno, 'JONES'  ename, 'MANAGER'   job, 7839 mgr, '1981-04-02' hiredate, 2000 sal, 20 deptno FROM DUAL UNION ALL
  SELECT 7788 empno, 'SCOTT'  ename, 'ANALYST'   job, 7566 mgr, '1987-04-19' hiredate, 3000 sal, 20 deptno FROM DUAL UNION ALL
  SELECT 7844 empno, 'TURNER' ename, 'SALESMAN'  job, 7698 mgr, '1981-09-08' hiredate, 1500 sal, 30 deptno FROM DUAL UNION ALL
  SELECT 7876 empno, 'ADAMS'  ename, 'CLERK'     job, 7788 mgr, '1987-05-23' hiredate, 1000 sal, 20 deptno FROM DUAL UNION ALL
  SELECT 7369 empno, 'SMITH'  ename, 'CLERK'     job, 7902 mgr, '1980-12-17' hiredate, 800  sal, 30 deptno FROM DUAL 
)
SELECT *
  FROM emp
 WHERE sal = ANY (1000, 2000, 3000);


WITH emp AS (
  SELECT 7839 empno, 'KING'   ename, 'PRESIDENT' job, NULL mgr, '1981-11-17' hiredate, 5000 sal, 10 deptno FROM DUAL UNION ALL
  SELECT 7566 empno, 'JONES'  ename, 'MANAGER'   job, 7839 mgr, '1981-04-02' hiredate, 2000 sal, 20 deptno FROM DUAL UNION ALL
  SELECT 7788 empno, 'SCOTT'  ename, 'ANALYST'   job, 7566 mgr, '1987-04-19' hiredate, 3000 sal, 20 deptno FROM DUAL UNION ALL
  SELECT 7844 empno, 'TURNER' ename, 'SALESMAN'  job, 7698 mgr, '1981-09-08' hiredate, 1500 sal, 30 deptno FROM DUAL UNION ALL
  SELECT 7876 empno, 'ADAMS'  ename, 'CLERK'     job, 7788 mgr, '1987-05-23' hiredate, 1000 sal, 20 deptno FROM DUAL UNION ALL
  SELECT 7369 empno, 'SMITH'  ename, 'CLERK'     job, 7902 mgr, '1980-12-17' hiredate, 800  sal, 30 deptno FROM DUAL 
)
SELECT *
  FROM emp
 WHERE sal > ANY (1000, 2000, 3000);


WITH emp AS (
  SELECT 7839 empno, 'KING'   ename, 'PRESIDENT' job, NULL mgr, '1981-11-17' hiredate, 5000 sal, 10 deptno FROM DUAL UNION ALL
  SELECT 7566 empno, 'JONES'  ename, 'MANAGER'   job, 7839 mgr, '1981-04-02' hiredate, 2000 sal, 20 deptno FROM DUAL UNION ALL
  SELECT 7788 empno, 'SCOTT'  ename, 'ANALYST'   job, 7566 mgr, '1987-04-19' hiredate, 3000 sal, 20 deptno FROM DUAL UNION ALL
  SELECT 7844 empno, 'TURNER' ename, 'SALESMAN'  job, 7698 mgr, '1981-09-08' hiredate, 1500 sal, 30 deptno FROM DUAL UNION ALL
  SELECT 7876 empno, 'ADAMS'  ename, 'CLERK'     job, 7788 mgr, '1987-05-23' hiredate, 1000 sal, 20 deptno FROM DUAL UNION ALL
  SELECT 7369 empno, 'SMITH'  ename, 'CLERK'     job, 7902 mgr, '1980-12-17' hiredate, 800  sal, 30 deptno FROM DUAL 
)
SELECT *
  FROM emp
 WHERE sal >= ANY (1000, 2000, 3000);


WITH emp AS (
  SELECT 7839 empno, 'KING'   ename, 'PRESIDENT' job, NULL mgr, '1981-11-17' hiredate, 5000 sal, 10 deptno FROM DUAL UNION ALL
  SELECT 7566 empno, 'JONES'  ename, 'MANAGER'   job, 7839 mgr, '1981-04-02' hiredate, 2000 sal, 20 deptno FROM DUAL UNION ALL
  SELECT 7788 empno, 'SCOTT'  ename, 'ANALYST'   job, 7566 mgr, '1987-04-19' hiredate, 3000 sal, 20 deptno FROM DUAL UNION ALL
  SELECT 7844 empno, 'TURNER' ename, 'SALESMAN'  job, 7698 mgr, '1981-09-08' hiredate, 1500 sal, 30 deptno FROM DUAL UNION ALL
  SELECT 7876 empno, 'ADAMS'  ename, 'CLERK'     job, 7788 mgr, '1987-05-23' hiredate, 1000 sal, 20 deptno FROM DUAL UNION ALL
  SELECT 7369 empno, 'SMITH'  ename, 'CLERK'     job, 7902 mgr, '1980-12-17' hiredate, 800  sal, 30 deptno FROM DUAL 
)
SELECT *
  FROM emp
 WHERE sal < ANY (1000, 2000, 3000);


WITH emp AS (
  SELECT 7839 empno, 'KING'   ename, 'PRESIDENT' job, NULL mgr, '1981-11-17' hiredate, 5000 sal, 10 deptno FROM DUAL UNION ALL
  SELECT 7566 empno, 'JONES'  ename, 'MANAGER'   job, 7839 mgr, '1981-04-02' hiredate, 2000 sal, 20 deptno FROM DUAL UNION ALL
  SELECT 7788 empno, 'SCOTT'  ename, 'ANALYST'   job, 7566 mgr, '1987-04-19' hiredate, 3000 sal, 20 deptno FROM DUAL UNION ALL
  SELECT 7844 empno, 'TURNER' ename, 'SALESMAN'  job, 7698 mgr, '1981-09-08' hiredate, 1500 sal, 30 deptno FROM DUAL UNION ALL
  SELECT 7876 empno, 'ADAMS'  ename, 'CLERK'     job, 7788 mgr, '1987-05-23' hiredate, 1000 sal, 20 deptno FROM DUAL UNION ALL
  SELECT 7369 empno, 'SMITH'  ename, 'CLERK'     job, 7902 mgr, '1980-12-17' hiredate, 800  sal, 30 deptno FROM DUAL 
)
SELECT *
  FROM emp
 WHERE sal <= ANY (1000, 2000, 3000);


WITH emp AS (
  SELECT 7839 empno, 'KING'   ename, 'PRESIDENT' job, NULL mgr, '1981-11-17' hiredate, 5000 sal, 10 deptno FROM DUAL UNION ALL
  SELECT 7566 empno, 'JONES'  ename, 'MANAGER'   job, 7839 mgr, '1981-04-02' hiredate, 2000 sal, 20 deptno FROM DUAL UNION ALL
  SELECT 7788 empno, 'SCOTT'  ename, 'ANALYST'   job, 7566 mgr, '1987-04-19' hiredate, 3000 sal, 20 deptno FROM DUAL UNION ALL
  SELECT 7844 empno, 'TURNER' ename, 'SALESMAN'  job, 7698 mgr, '1981-09-08' hiredate, 1500 sal, 30 deptno FROM DUAL UNION ALL
  SELECT 7876 empno, 'ADAMS'  ename, 'CLERK'     job, 7788 mgr, '1987-05-23' hiredate, 1000 sal, 20 deptno FROM DUAL UNION ALL
  SELECT 7369 empno, 'SMITH'  ename, 'CLERK'     job, 7902 mgr, '1980-12-17' hiredate, 800  sal, 30 deptno FROM DUAL 
)
SELECT *
  FROM emp
 WHERE sal <> ANY (1000, 2000, 3000);

WITH emp AS (
  SELECT 7839 empno, 'KING'   ename, 'PRESIDENT' job, NULL mgr, '1981-11-17' hiredate, 5000 sal, 10 deptno FROM DUAL UNION ALL
  SELECT 7566 empno, 'JONES'  ename, 'MANAGER'   job, 7839 mgr, '1981-04-02' hiredate, 2000 sal, 20 deptno FROM DUAL UNION ALL
  SELECT 7788 empno, 'SCOTT'  ename, 'ANALYST'   job, 7566 mgr, '1987-04-19' hiredate, 3000 sal, 20 deptno FROM DUAL UNION ALL
  SELECT 7844 empno, 'TURNER' ename, 'SALESMAN'  job, 7698 mgr, '1981-09-08' hiredate, 1500 sal, 30 deptno FROM DUAL UNION ALL
  SELECT 7876 empno, 'ADAMS'  ename, 'CLERK'     job, 7788 mgr, '1987-05-23' hiredate, 1000 sal, 20 deptno FROM DUAL UNION ALL
  SELECT 7369 empno, 'SMITH'  ename, 'CLERK'     job, 7902 mgr, '1980-12-17' hiredate, 800  sal, 30 deptno FROM DUAL 
)
SELECT *
  FROM emp
 WHERE sal > SOME (SELECT sal
                    FROM emp
                   WHERE deptno = 20);

--------------------------------------
-- ALL 연산자 예제 쿼리
--------------------------------------

WITH emp AS (
  SELECT 7839 empno, 'KING'   ename, 'PRESIDENT' job, NULL mgr, '1981-11-17' hiredate, 5000 sal, 10 deptno FROM DUAL UNION ALL
  SELECT 7566 empno, 'JONES'  ename, 'MANAGER'   job, 7839 mgr, '1981-04-02' hiredate, 2000 sal, 20 deptno FROM DUAL UNION ALL
  SELECT 7788 empno, 'SCOTT'  ename, 'ANALYST'   job, 7566 mgr, '1987-04-19' hiredate, 3000 sal, 20 deptno FROM DUAL UNION ALL
  SELECT 7844 empno, 'TURNER' ename, 'SALESMAN'  job, 7698 mgr, '1981-09-08' hiredate, 1500 sal, 30 deptno FROM DUAL UNION ALL
  SELECT 7876 empno, 'ADAMS'  ename, 'CLERK'     job, 7788 mgr, '1987-05-23' hiredate, 1000 sal, 20 deptno FROM DUAL UNION ALL
  SELECT 7369 empno, 'SMITH'  ename, 'CLERK'     job, 7902 mgr, '1980-12-17' hiredate, 800  sal, 30 deptno FROM DUAL 
)
SELECT *
  FROM emp
 WHERE sal > ALL (1000, 2000, 3000)
;

WITH emp AS (
  SELECT 7839 empno, 'KING'   ename, 'PRESIDENT' job, NULL mgr, '1981-11-17' hiredate, 5000 sal, 10 deptno FROM DUAL UNION ALL
  SELECT 7566 empno, 'JONES'  ename, 'MANAGER'   job, 7839 mgr, '1981-04-02' hiredate, 2000 sal, 20 deptno FROM DUAL UNION ALL
  SELECT 7788 empno, 'SCOTT'  ename, 'ANALYST'   job, 7566 mgr, '1987-04-19' hiredate, 3000 sal, 20 deptno FROM DUAL UNION ALL
  SELECT 7844 empno, 'TURNER' ename, 'SALESMAN'  job, 7698 mgr, '1981-09-08' hiredate, 1500 sal, 30 deptno FROM DUAL UNION ALL
  SELECT 7876 empno, 'ADAMS'  ename, 'CLERK'     job, 7788 mgr, '1987-05-23' hiredate, 1000 sal, 20 deptno FROM DUAL UNION ALL
  SELECT 7369 empno, 'SMITH'  ename, 'CLERK'     job, 7902 mgr, '1980-12-17' hiredate, 800  sal, 30 deptno FROM DUAL 
)
SELECT *
  FROM emp
 WHERE sal >= ALL (1000, 2000, 3000)
;

WITH emp AS (
  SELECT 7839 empno, 'KING'   ename, 'PRESIDENT' job, NULL mgr, '1981-11-17' hiredate, 5000 sal, 10 deptno FROM DUAL UNION ALL
  SELECT 7566 empno, 'JONES'  ename, 'MANAGER'   job, 7839 mgr, '1981-04-02' hiredate, 2000 sal, 20 deptno FROM DUAL UNION ALL
  SELECT 7788 empno, 'SCOTT'  ename, 'ANALYST'   job, 7566 mgr, '1987-04-19' hiredate, 3000 sal, 20 deptno FROM DUAL UNION ALL
  SELECT 7844 empno, 'TURNER' ename, 'SALESMAN'  job, 7698 mgr, '1981-09-08' hiredate, 1500 sal, 30 deptno FROM DUAL UNION ALL
  SELECT 7876 empno, 'ADAMS'  ename, 'CLERK'     job, 7788 mgr, '1987-05-23' hiredate, 1000 sal, 20 deptno FROM DUAL UNION ALL
  SELECT 7369 empno, 'SMITH'  ename, 'CLERK'     job, 7902 mgr, '1980-12-17' hiredate, 800  sal, 30 deptno FROM DUAL 
)
SELECT *
  FROM emp
 WHERE sal < ALL (1000, 2000, 3000)
;

WITH emp AS (
  SELECT 7839 empno, 'KING'   ename, 'PRESIDENT' job, NULL mgr, '1981-11-17' hiredate, 5000 sal, 10 deptno FROM DUAL UNION ALL
  SELECT 7566 empno, 'JONES'  ename, 'MANAGER'   job, 7839 mgr, '1981-04-02' hiredate, 2000 sal, 20 deptno FROM DUAL UNION ALL
  SELECT 7788 empno, 'SCOTT'  ename, 'ANALYST'   job, 7566 mgr, '1987-04-19' hiredate, 3000 sal, 20 deptno FROM DUAL UNION ALL
  SELECT 7844 empno, 'TURNER' ename, 'SALESMAN'  job, 7698 mgr, '1981-09-08' hiredate, 1500 sal, 30 deptno FROM DUAL UNION ALL
  SELECT 7876 empno, 'ADAMS'  ename, 'CLERK'     job, 7788 mgr, '1987-05-23' hiredate, 1000 sal, 20 deptno FROM DUAL UNION ALL
  SELECT 7369 empno, 'SMITH'  ename, 'CLERK'     job, 7902 mgr, '1980-12-17' hiredate, 800  sal, 30 deptno FROM DUAL 
)
SELECT *
  FROM emp
 WHERE sal <= ALL (1000, 2000, 3000)
;

WITH emp AS (
  SELECT 7839 empno, 'KING'   ename, 'PRESIDENT' job, NULL mgr, '1981-11-17' hiredate, 5000 sal, 10 deptno FROM DUAL UNION ALL
  SELECT 7566 empno, 'JONES'  ename, 'MANAGER'   job, 7839 mgr, '1981-04-02' hiredate, 2000 sal, 20 deptno FROM DUAL UNION ALL
  SELECT 7788 empno, 'SCOTT'  ename, 'ANALYST'   job, 7566 mgr, '1987-04-19' hiredate, 3000 sal, 20 deptno FROM DUAL UNION ALL
  SELECT 7844 empno, 'TURNER' ename, 'SALESMAN'  job, 7698 mgr, '1981-09-08' hiredate, 1500 sal, 30 deptno FROM DUAL UNION ALL
  SELECT 7876 empno, 'ADAMS'  ename, 'CLERK'     job, 7788 mgr, '1987-05-23' hiredate, 1000 sal, 20 deptno FROM DUAL UNION ALL
  SELECT 7369 empno, 'SMITH'  ename, 'CLERK'     job, 7902 mgr, '1980-12-17' hiredate, 800  sal, 30 deptno FROM DUAL 
)
SELECT *
  FROM emp
 WHERE sal > ALL (1000, 2000, 3000)
;

WITH emp AS (
  SELECT 7839 empno, 'KING'   ename, 'PRESIDENT' job, NULL mgr, '1981-11-17' hiredate, 5000 sal, 10 deptno FROM DUAL UNION ALL
  SELECT 7566 empno, 'JONES'  ename, 'MANAGER'   job, 7839 mgr, '1981-04-02' hiredate, 2000 sal, 20 deptno FROM DUAL UNION ALL
  SELECT 7788 empno, 'SCOTT'  ename, 'ANALYST'   job, 7566 mgr, '1987-04-19' hiredate, 3000 sal, 20 deptno FROM DUAL UNION ALL
  SELECT 7844 empno, 'TURNER' ename, 'SALESMAN'  job, 7698 mgr, '1981-09-08' hiredate, 1500 sal, 30 deptno FROM DUAL UNION ALL
  SELECT 7876 empno, 'ADAMS'  ename, 'CLERK'     job, 7788 mgr, '1987-05-23' hiredate, 1000 sal, 20 deptno FROM DUAL UNION ALL
  SELECT 7369 empno, 'SMITH'  ename, 'CLERK'     job, 7902 mgr, '1980-12-17' hiredate, 800  sal, 30 deptno FROM DUAL 
)
SELECT *
  FROM emp
 WHERE sal <> ALL (1000, 2000, 3000)
;

WITH emp AS (
  SELECT 7839 empno, 'KING'   ename, 'PRESIDENT' job, NULL mgr, '1981-11-17' hiredate, 5000 sal, 10 deptno FROM DUAL UNION ALL
  SELECT 7566 empno, 'JONES'  ename, 'MANAGER'   job, 7839 mgr, '1981-04-02' hiredate, 2000 sal, 20 deptno FROM DUAL UNION ALL
  SELECT 7788 empno, 'SCOTT'  ename, 'ANALYST'   job, 7566 mgr, '1987-04-19' hiredate, 3000 sal, 20 deptno FROM DUAL UNION ALL
  SELECT 7844 empno, 'TURNER' ename, 'SALESMAN'  job, 7698 mgr, '1981-09-08' hiredate, 1500 sal, 30 deptno FROM DUAL UNION ALL
  SELECT 7876 empno, 'ADAMS'  ename, 'CLERK'     job, 7788 mgr, '1987-05-23' hiredate, 1000 sal, 20 deptno FROM DUAL UNION ALL
  SELECT 7369 empno, 'SMITH'  ename, 'CLERK'     job, 7902 mgr, '1980-12-17' hiredate, 800  sal, 30 deptno FROM DUAL 
)
SELECT *
  FROM emp
 WHERE sal > ALL (SELECT sal
                    FROM emp
                   WHERE deptno = 20)
;

-- EXISTS : 서브 쿼리가 적어도 하나의 행을 돌려주면 TRUE가 된다.
-- NOT EXISTS : 서브 쿼리가 적어도 하나의 행을 돌려주지 않으면 TRUE가 된다.

SELECT 
   DEPT_NAME  as "부서명", DEPT_CODE  as "부서코드"
FROM 
   tdept
WHERE EXISTS(SELECT * FROM temp WHERE tdept.DEPT_CODE = temp.DEPT_CODE);
                   
                  
SELECT 
   DEPT_NAME  as "부서명", DEPT_CODE  as "부서코드"
FROM 
   tdept
WHERE NOT EXISTS(SELECT * FROM temp WHERE tdept.DEPT_CODE = temp.DEPT_CODE);

SELECT rownum, rowid, t.EMP_ID ,t.EMP_NAME  FROM TEMP t ; 

SELECT rownum, t.EMP_ID ,t.EMP_NAME  FROM TEMP t ORDER BY t.EMP_NAME ; -- 번호를 붙이고 정렬을 한것이다. 

SELECT * FROM TEMP t WHERE t.EMP_TYPE ='인턴';
SELECT rownum, t.* FROM TEMP t WHERE t.EMP_TYPE ='인턴'; -- where가 적용되고 번호가 붙는다.
SELECT rownum, t.* FROM TEMP t WHERE t.EMP_TYPE ='인턴' ORDER BY EMP_NAME ; -- where가 적용되고 번호가 붙는다.

-- 1페이지 분량의 행을 가져오는 쿼리를 만들어 보자
SELECT * FROM TEMP t ; --전체 20개
-- 상위 5개만 가져와보자
SELECT rownum, t.* FROM TEMP t ;
SELECT rownum, t.* FROM TEMP t WHERE rownum<=5;

-- 6번째 이후를 모두 가져와
SELECT rownum, t.* FROM TEMP t WHERE rownum>5; -- 아무것도 나오지 않는다.

SELECT
	Q.*
FROM 
	(SELECT rownum R, t.* FROM TEMP t) Q 
WHERE 
	R>5 ;
	
-- 6~10행의 데이터만 가져와라
SELECT
	Q.*
FROM 
	(SELECT rownum R, t.* FROM TEMP t ORDER BY t.EMP_ID) Q 
WHERE 
	R>5 AND R<=10; -- 내부쿼리를 정렬하였더니 나타나는 데이터가 다르다.
SELECT 
	R.*
FROM 
	(SELECT 
		rownum rnum, Q.*
	FROM 
		(SELECT * FROM TEMP t ORDER BY EMP_ID DESC) Q  -- 원하는 순서대로 전체를 가져온다
	WHERE 
		rownum<=10) R -- 뒷자리를 잘라낸다.
WHERE 
	rnum>=6 ; -- 앞자리를 잘라낸다.
	
-- 번호를 1~100까지 발생
SELECT LEVEL NO FROM dual CONNECT BY LEVEL <= 100;
-- 253개 데이터가 있는 게시판 테이블을 생성해보자
CREATE TABLE board AS SELECT LEVEL idx , '제목 ' || LEVEL subject FROM dual CONNECT BY LEVEL <=253;
SELECT * FROM board;

-- 253번부터 244번까지 1페이지이다 가져와보자!!
SELECT 
	R.*
FROM 
	(SELECT 
		rownum rnum, Q.*
	FROM 
		(SELECT * FROM BOARD b  ORDER BY idx DESC) Q  -- 원하는 순서대로 전체를 가져온다
	WHERE 
		rownum<=10) R -- 뒷자리를 잘라낸다.
WHERE 
	rnum>=1 ; -- 앞자리를 잘라낸다.
-- 243번부터 234번까지 2페이지이다 가져와보자!!
SELECT 
	R.*
FROM 
	(SELECT 
		rownum rnum, Q.*
	FROM 
		(SELECT * FROM BOARD b  ORDER BY idx DESC) Q  -- 원하는 순서대로 전체를 가져온다
	WHERE 
		rownum<=20) R -- 뒷자리를 잘라낸다.
WHERE 
	rnum>=11 ; -- 앞자리를 잘라낸다.
	
/*
DECODE 함수
DECODE(필드명 또는 식, 값1, 값1이 일치하면 실행할 명령,값2,값1이 일치하면 실행할 명령.... , 모두일치하지 않으면 실행할 명령)
*/
   
CREATE TABLE LECTURE (LEC_ID VARCHAR2(05),LEC_TIME NUMBER,LEC_POINT NUMBER);
INSERT INTO LECTURE VALUES('L0001',3,3);
INSERT INTO LECTURE VALUES('L0002',3,2);
INSERT INTO LECTURE VALUES('L0003',2,3);
INSERT INTO LECTURE VALUES('L0004',2,2);
INSERT INTO LECTURE VALUES('L0005',3,1);
COMMIT;   

SELECT * FROM LECTURE l ;

SELECT 
	DECODE(1,1,'하나'), -- 단순 if
	DECODE(1,2,'하나','몰라'), -- IF ~ ELSE 
	decode(3,1,'하나',2,'둘','몰라') -- IF ~~ ELSE IF ~
FROM 
	dual;

-- 1학점은 일반과목 2학점은 전공과목 3학점은 교양과목 이라고 조회하시오
SELECT 
	l.LEC_ID ,
	l.LEC_TIME ,
	DECODE(l.LEC_POINT,1,'일반과목',2,'전공과목',3,'교양과목') 구분,
	DECODE(l.LEC_POINT,1,'일반과목',2,'전공과목','교양과목') 구분
FROM 
	LECTURE l ;

-- 월 01, 화 11, 수 21, 목 31, 금 41, 토 51, 일 61
-- 해당일자에 위의 번호를 붙여 4자리의 암호를 출력하는 쿼리를 완성해라.

SELECT 
   SYSDATE "오늘",
   TO_CHAR(SYSDATE, 'DD') 일, 
   TO_CHAR(SYSDATE, 'DAY') 요일1,
   TO_CHAR(SYSDATE, 'DY') 요일2,
   TO_CHAR(SYSDATE, 'D') 요일3,
   TO_CHAR(SYSDATE+1, 'D') 요일4,
   TO_CHAR(SYSDATE+2, 'D') 요일5
FROM 
   dual;

SELECT 
   EMP_ID , EMP_NAME , BIRTH_DATE , TO_CHAR(BIRTH_DATE,'DAY') || '에 태어남'
FROM 
   TEMP t;

-- 월 01, 화 11, 수 21, 목 31, 금 41, 토 51, 일 61
SELECT 
   EMP_ID , EMP_NAME , BIRTH_DATE , 
   TO_CHAR(BIRTH_DATE,'DD') 일자,
   TO_CHAR(BIRTH_DATE,'DAY') 요일,
   TO_CHAR(BIRTH_DATE,'DD') || DECODE(TO_CHAR(BIRTH_DATE,'D'), 1,'61', 2,'01', 3,'11', 4,'21', 5,'31', 6,'41', 7, '51') 암호
FROM 
   TEMP t;
  
-- temp테이블의 사번과 이름을 1줄에 3개씩 출력해보자
SELECT  * FROM temp t;
SELECT t.EMP_ID , t.EMP_NAME  FROM TEMP t ;  
SELECT rownum, CEIL(rownum/3), t.EMP_ID , t.EMP_NAME  FROM TEMP t ;  -- 여기에서 같은 번호를 1줄에 출력해보자

SELECT 
	CEIL(rownum/3) 번호,
	MOD(rownum,3) 나머지,
	DECODE(MOD(rownum,3),1, EMP_ID,'') 사번,
	DECODE(MOD(rownum,3),1, EMP_NAME ,'') 이름,
	DECODE(MOD(rownum,3),2, EMP_ID,'') 사번,
	DECODE(MOD(rownum,3),2, EMP_NAME ,'') 이름,
	DECODE(MOD(rownum,3),0, EMP_ID,'') 사번,
	DECODE(MOD(rownum,3),0, EMP_NAME ,'') 이름
FROM 
	TEMP t ;

SELECT 
	CEIL(rownum/3) 번호,
	MAX(DECODE(MOD(rownum,3),1, EMP_ID,'')) 사번,
	MAX(DECODE(MOD(rownum,3),1, EMP_NAME ,'')) 이름,
	MAX(DECODE(MOD(rownum,3),2, EMP_ID,'')) 사번,
	MAX(DECODE(MOD(rownum,3),2, EMP_NAME ,'')) 이름,
	MAX(DECODE(MOD(rownum,3),0, EMP_ID,'')) 사번,
	MAX(DECODE(MOD(rownum,3),0, EMP_NAME ,'')) 이름
FROM 
	TEMP t 
GROUP BY 
	CEIL(rownum/3)
ORDER BY 
	1;

-- ===========================================================================================   
-- NOT IN의 함정
-- ===========================================================================================   
SELECT COUNT(*) FROM TEMP t ; -- 20개

SELECT COUNT(*) FROM TEMP t WHERE HOBBY IN ('등산', '낚시'); -- 4명
SELECT COUNT(*) FROM TEMP t WHERE HOBBY NOT IN ('등산', '낚시', ); -- 10명

-- 6개는 어디로 갔을까요? -----> null이 제외됨 6명이 취미가 없다.
-- NULL처리까지 해줘야한다.
SELECT COUNT(*) FROM TEMP t WHERE HOBBY NOT IN ('등산', '낚시') OR HOBBY IS NULL;
SELECT COUNT(*) FROM TEMP t WHERE HOBBY NOT IN ('등산', '낚시', NULL); -- 0개 : 이렇게 하면 안된다. 

-- resource 롤에는 뷰를 만들 수 있는 권한이 없다.
-- 별도로 권한을 부여해야만 한다.
-- 권한은 sys로 로그인해야 한다.
CREATE OR REPLACE VIEW emp_30 AS SELECT * FROM temp WHERE DEPT_CODE LIKE 'A%';
SELECT * FROM tab;

SELECT * FROM temp WHERE DEPT_CODE LIKE 'A%';
SELECT * FROM emp_30; -- 뷰를 이용한 조회

SELECT * FROM user_objects; -- 접속 계정이 소유하고 있는 모든 객체를 조회할 수 있다.

SELECT uo.OBJECT_NAME , uo.OBJECT_TYPE  FROM user_objects uo WHERE uo.OBJECT_TYPE IN ('TABLE','VIEW');

CREATE OR REPLACE VIEW my_tab
AS
SELECT uo.OBJECT_NAME , uo.OBJECT_TYPE  FROM user_objects uo WHERE uo.OBJECT_TYPE IN ('TABLE','VIEW');

SELECT * FROM MY_TAB mt;

-- 뷰에 조건 지정이 가능할까?
SELECT * FROM MY_TAB mt WHERE OBJECT_TYPE ='VIEW' ;
SELECT * FROM MY_TAB mt WHERE OBJECT_TYPE ='TABLE' ;

-- 뷰만 보는 명령은?
SELECT * FROM user_views;
SELECT VIEW_NAME , TExt FROM user_views;

-- 문제] 자신이 속한 직급의 평균 연봉보다 더 받는 직원의 목록을 보고싶다.
-- 1) 직급별평균의 연봉
SELECT lev, avg(SALARY) FROM TEMP t GROUP BY lev;
SELECT lev, avg(SALARY) avg_sal FROM TEMP t GROUP BY lev;
-- 2) 1의 결과를 뷰로 만들자
CREATE OR REPLACE VIEW avg_sal_view AS SELECT lev, avg(SALARY) avg_sal FROM TEMP t GROUP BY lev;
SELECT * FROM avg_sal_view; -- 가상의 테이블 생성

-- 3) 뷰를 이용하여 일반 JOIN을 한다.
SELECT 
	EMP_ID 사번,EMP_NAME 이름, SALARY 연봉, asv.AVG_SAL 평균연봉, t.LEV 직급
FROM 
	TEMP t , AVG_SAL_VIEW asv
WHERE 
	t.LEV = asv.LEV AND t.SALARY > asv.AVG_SAL ;

-- 뷰를 만들지 않고 IN LINE VIEW로 바꾸면 
-- IN LINE VIEW : from 절에 들어가는 서브쿼리
SELECT 
	EMP_ID 사번,EMP_NAME 이름, SALARY 연봉, asv.AVG_SAL 평균연봉, t.LEV 직급
FROM 
	TEMP t , (SELECT lev, avg(SALARY) avg_sal FROM TEMP t GROUP BY lev) asv
WHERE 
	t.LEV = asv.LEV AND t.SALARY > asv.AVG_SAL ;
