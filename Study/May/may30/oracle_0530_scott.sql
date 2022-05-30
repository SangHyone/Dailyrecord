/*
ROLLUP operator

ROLLUP구문은 GROUP BY 절과 같이 사용 되며, GROUP BY절에 의해서 그룹 지어진 
집합 결과에 대해서 좀 더 상세한 정보를 반환하는 기능을 수행 한다.

SELECT절에 ROLLUP을 사용함으로써 보통의 SELECT된 데이터와 그 데이터의 총계를 구할 수 있다.
*/

SELECT * FROM EMP e ;
SELECT DEPTNO , count(*), SUM(sal), round(avg(SAL))  FROM emp GROUP BY DEPTNO ;

-- 직업별 급여합계를 보고싶다.
SELECT 
	JOB, SUM(SAL)
FROM 
	EMP
GROUP BY 
	JOB;
	
-- 직업별 급여합계와 총계도 보고싶다.
SELECT 
	NVL(JOB,'총계'), SUM(SAL)
FROM 
	EMP
GROUP BY 
	ROLLUP(JOB);
	
-- 부서별로 인원수와 급여의 함계를 구하고 싶다.
SELECT 
	d.DNAME 부서명, e.JOB 직업, count(e.EMPNO) 인원수, sum(e.SAL) 급여합계
FROM 
	EMP e , DEPT d 
WHERE 
	e.DEPTNO = d.DEPTNO 
GROUP BY 
	d.DNAME , e.JOB ;

SELECT 
	d.DNAME 부서명, e.JOB 직업, count(e.EMPNO) 인원수, sum(e.SAL) 급여합계
FROM 
	EMP e , DEPT d 
WHERE 
	e.DEPTNO = d.DEPTNO 
GROUP BY 
	ROLLUP(d.DNAME , e.JOB) ; 

SELECT 
	d.DNAME 부서명, e.JOB 직업, count(e.EMPNO) 인원수, sum(e.SAL) 급여합계
FROM 
	EMP e , DEPT d 
WHERE 
	e.DEPTNO = d.DEPTNO 
GROUP BY 
	CUBE(d.DNAME , e.JOB) ; -- 부서별, 직업별 모두 구해준다.	
	
-- CUBE는 Cross-Tab에 대한 Summary를 추출하는데 사용 된다 
-- 즉 ROLLUP에 의해 나타 내어지는 Item Total값과 Column Total값을 나타 낼 수 있다.

/*
Grouping 함수 
: pseudo column (의사컬럼 : 실제로는 존재하지 않으나 특수목적으로 사용)

GROUPING 함수는 ROLLUP, CUBE에 모두 사용할 수 있다.
GROUPING 함수는 해당 Row가 GROUP BY에 의해서 산출된 Row인 경우에는 0을 반환하고, 
ROLLUP이나 CUBE에 의해서 산출된 Row인 경우에는 1을 반환하게 된다.
따라서 해당 Row가 결과집합에 의해 산출된 Data 인지, ROLLUP이나 CUBE에 의해서 산출된 Data 인지를 알 수 있도록 지원하는 함수이다.
 */
	
SELECT 
	b.dname, a.job, SUM(a.sal) sal, COUNT(a.empno) emp_count,
    GROUPING(b.dname) "D", GROUPING(a.job) "S"
FROM 
	emp a, dept b
WHERE 
	a.deptno = b.deptno
GROUP BY 
	CUBE(b.dname, a.job)
ORDER BY 
	b.DNAME;

























