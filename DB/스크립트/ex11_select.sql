/*

ex11_select.sql

group by 절
- 레코드들을 특정 컬럼값에 맞춰서 그룹을 나누는 작업 
- 그룹을 왜 묶을까?
    1. 그룹을 나눠서 구분하려고? 정렬 따로? X
    2. 나눠 놓은 그룹을 별도의 테이블로 만들기 위해서?
    3. 각각의 그룹별로 집계함수를 적용하기 위해서 (***) -> 집계함수를 사용안하면 GROUP BY 의미 없음
- group by 키 
    : 그룹을 나누는데 기준이 되는 컬럼(1개 or 이상)
- group by 사용 시 컬럼리스트에 올 수 있는 대상
    a. 집계 함수
    b. group by 키(group by 대상 컬럼)
    c. 그 외에는 나머지 컬럼 모두 불가능

group by 구문
- SELECT 컬럼리스트
    from 테이블
        [where 조건]
            [group by 그룹]
                [order by 정렬]
*/


-- 부서별 평균 월급?
SELECT round(avg(basicpay)) FROM tblinsa; -- 155만원 -- 전체 직원의 평균 월급

SELECT DISTINCT BUSEO FROM tblinsa;

SELECT round(avg(basicpay)) FROM tblinsa WHERE BUSEO = '총무부'; -- 171
SELECT round(avg(basicpay)) FROM tblinsa WHERE BUSEO = '개발부'; -- 138
SELECT round(avg(basicpay)) FROM tblinsa WHERE BUSEO = '영업부'; -- 160
SELECT round(avg(basicpay)) FROM tblinsa WHERE BUSEO = '기획부'; -- 185
SELECT round(avg(basicpay)) FROM tblinsa WHERE BUSEO = '인사부'; -- 153
SELECT round(avg(basicpay)) FROM tblinsa WHERE BUSEO = '자재부'; -- 141
SELECT round(avg(basicpay)) FROM tblinsa WHERE BUSEO = '홍보부'; -- 145

SELECT BUSEO, round(avg(basicpay)) FROM tblinsa
    GROUP BY BUSEO;
    
SELECT BUSEO, count(*) as 인원 FROM tblinsa
    GROUP BY BUSEO;
    
    
    
SELECT * FROM tblcountry -- ORA-00979: not a GROUP BY expression
    GROUP BY name; -- group by 키에는 PK는 사용 안함.
    
SELECT count(*), continent, name FROM tblcountry -- ORA-00979: not a GROUP BY expression
    GROUP BY continent;

SELECT * FROM tabs;

SELECT substr(ssn, 8, 1) FROM tblinsa;

SELECT count(*), substr(ssn, 8, 1) FROM tblinsa 
    GROUP BY substr(ssn, 8, 1);
    
SELECT count(*), to_char(ibsadate, 'mm') FROM tblinsa
    GROUP BY to_char(ibsadate, 'mm')
        ORDER BY to_char(ibsadate, 'mm') ASC;

SELECT count(*), substr(name, 1, 1) FROM tblinsa
    GROUP BY substr(name, 1, 1)
        ORDER BY count(*) DESC, substr(name, 1, 1) ASC;


SELECT count(*), floor(basicpay / 1000000) * 100 || '만원대' FROM tblinsa
    GROUP BY floor(basicpay / 1000000);
    
    
    
    
-- 1. SELECT    - 4
-- 2. FROM      - 1
-- 3. WHERE     - 2
-- 4. GROUP BY  - 3
-- 5. ORDER BY  - 5


-- 질문?
-- 조건 X : tblinsa에서 buseo별로 평균 급여를 가져오세요.
-- 조건 O : tblinsa에서 각 직원 당 개인 월급이 2백만원 이상인 사람들만 가지고 BUSEO별 그룹 > 평균 급여 
SELECT BUSEO, avg(basicpay) 
    FROM tblinsa
        WHERE basicpay >= 2000000
            GROUP BY BUSEO;
    


-- 조건 X : 지역별로 그룹 나눈뒤 각 지역당 직원들 중 가장 월급이 많은 사람의 월급?
-- 조건 O : 대리와 사원들에 한해서 지역별로 그룹 나눈뒤 ...
SELECT city, max(basicpay), count(*) 
    FROM tblinsa
        WHERE jikwi in ('대리', '사원')
            GROUP BY CITY;


/*

having 절(구)
- GROUP BY절과 함께 사용
- 조건절(WHERE절과 같은 역할)
- having에 올 수 있는 대상은 GROUP BY 대상과 동일 
- having 대상 : 집계함수 or GROUP BY 키

*/

-- 부서별 평균 월급?
SELECT BUSEO, round(avg(basicpay)) FROM tblinsa
    GROUP BY BUSEO;

SELECT BUSEO, round(avg(basicpay)) FROM tblinsa
    WHERE basicpay >= 2000000  -- 개인 월급이 200만원 넘는 사람들의 부서만 그룹화 
        GROUP BY BUSEO;

SELECT BUSEO, round(avg(basicpay)) FROM tblinsa
    GROUP BY BUSEO 
        HAVING avg(basicpay) >= 1500000; -- 부서 평균이 150만원 넘는 부서만 그룹화(그룹 조건)

SELECT jikwi, count(*), round(avg(basicpay)) FROM tblinsa
    WHERE basicpay >= 1400000 -- 월급 140만원이 넘는 모든 사원
        GROUP BY jikwi -- 직위별로 묶는다 
            HAVING count(*) >= 3; -- 위 조건으로 3명 이상이 존재하는 직위만 그룹화
    

-- 1. SELECT    - 5
-- 2. FROM      - 1
-- 3. WHERE     - 2
-- 4. GROUP BY  - 3
-- 5. HAVING    - 4
-- 6. ORDER BY  - 6

SELECT BUSEO, JIKWI, count(*) FROM tblinsa
    GROUP BY BUSEO, JIKWI
        ORDER BY BUSEO ASC, JIKWI ASC; -- 다차원 그룹화














    







        






































