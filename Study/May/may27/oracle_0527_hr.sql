---- 13-1.  직업이 AD_PRESS 인 사람은 A 등급을, ST_MAN 인 사람은 B 등급을, IT_PROG 인 사람은 C 등급을,
--          SA_REP 인 사람은 D 등급을, ST_CLERK 인 사람은 E 등급을 기타는 0 을 부여하여 조회한다.
/*
 CASE 필드명 또는 식
    WHEN 값1 THEN
       값1이 일치할때 실행할 명령
    WHEN 값2 THEN
       값2이 일치할때 실행할 명령
    WHEN 값3 THEN
       값3이 일치할때 실행할 명령
       .
       .
       .
    ELSE
       일치하는 값이 없을때 실행할 명령
 END
 */
SELECT 
	e.EMPLOYEE_ID 사번, e.FIRST_NAME || ' ' || e.LAST_NAME 이름,
	CASE e.job_id
		WHEN 'AD_PRES' THEN 'A'
		WHEN 'ST_MAN' THEN 'B'
		WHEN 'IT_PROG' THEN 'C'
		WHEN 'SA_REP' THEN 'D'
		WHEN 'ST_CLERK' THEN 'E'
		ELSE '0'
	END 등급
FROM 
	EMPLOYEES e ;

SELECT 
	e.EMPLOYEE_ID 사번, e.FIRST_NAME || ' ' || e.LAST_NAME 이름,
	DECODE(e.job_id,'AD_PRES','A','ST_MAN','B','IT_PROG','C','SA_REP','D','ST_CLERK','E','0') 등급 
FROM 
	EMPLOYEES e ;