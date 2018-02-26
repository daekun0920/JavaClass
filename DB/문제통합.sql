-- 01. tblinsa 테이블 전체 레코드 조회
SELECT * FROM tblinsa;
-- 02. HR 사용자 소유 테이블 목록 확인
SELECT * FROM tabs;
-- 03. tblinsa 테이블 구조 확인
desc tblinsa;
-- 04. tblinsa 테이블의 이름(name), 기본급(basicpay) 조회
SELECT name, basicpay FROM tblinsa;
-- 05. tblinsa 테이블의 이름(name), 기본급(basicpay), 수당(sudang), 기본급+수당 조회
SELECT name, basicpay, sudang, basicpay + sudang FROM tblinsa;
-- 06. 이름(name), 출신도(city), 부서명(buseo) 조회. 별명 사용.
SELECT name as 이름, city as 출신도, buseo as 부서명 FROM tblinsa;
-- 07. 서울 사람의 이름(name), 출신도(city), 부서명(buseo), 직위(jikwi) 조회
SELECT name, city, buseo, jikwi FROM tblinsa WHERE city = '서울';
-- 08. 출신도가 서울 사람이면서       --> WHERE 구문
--     기본급이 150만원 이상인 사람   --> WHERE 구문
--     조회 (name, city, basicpay, ssn)
SELECT name, city, basicpay, ssn FROM tblinsa WHERE city = '서울' AND basicpay >= 1500000;

-- 09. 출신도가 '인천' 이면서, 기본급이 100만원이상 ~ 200만원 미만인 경우만 모든정보 조회.
SELECT * FROM tblinsa WHERE city = '인천' AND basicpay >= 1000000 AND basicpay < 2000000;
-- 10. 출신도가 서울 사람이거나 부서가 개발부인 자료 조회 (name, city, buseo)
SELECT name, city, buseo FROM tblinsa WHERE city = '서울' or buseo = '개발부';
-- 11. 출신도가 서울, 경기인 사람만 조회 (name, city, buseo). IN 연산자 사용.
SELECT name, city, buseo FROM tblinsa WHERE city in ('서울', '경기');
-- 12. 부서가 '개발부' 이거나 '영업부'인 사원의 모든정보 조회. IN 연산자 사용.
SELECT * FROM tblinsa WHERE buseo in ('개발부', '영업부');
-- 13. 급여(basicpay + sudang)가 250만원 이상인 사람 조회. --> WHERE 구문
--     단, 필드명은 한글로 출력. --> 별칭
--     (name, basicpay, sudang, basicpay+sudang)
SELECT name as 이름, basicpay as 기본급, sudang as 수당, basicpay + sudang as 총급여 FROM tblinsa WHERE basicpay + sudang >= 2500000;

-- 14. 주민번호를 기준으로 남자(성별란이 1, 3)만 조회. (이름(name), 주민번호(ssn)). 
--     단, SUBSTR() 함수 이용.
SELECT name, ssn FROM tblinsa WHERE substr(ssn, 8, 1) = 1 OR substr(ssn, 8, 1) = 3;
 
-- 15. 주민번호를 기준으로 80년대 태어난 사람만 출력. (이름(name), 주민번호(ssn)). 
--     단, SUBSTR() 함수 이용.
SELECT name, ssn FROM tblinsa WHERE substr(ssn, 1, 1) = 8;

-- 16. 서울 사람 중에서 70년대 태어난 사람만 출력. SUBSTR() 함수 이용.
SELECT * FROM tblinsa WHERE city = '서울' AND substr(ssn, 1, 1) = 7;
    
-- 17. 서울 사람 중에서 70년대 태어난 남자만 출력. SUBSTR() 함수 이용.
SELECT * FROM tblinsa WHERE city = '서울' AND substr(ssn, 1, 1) = 7 AND substr(ssn, 8, 1) = 1;
 
-- 18. 서울 사람이면서 김씨만 출력(성씨가 1자라는 가정). (이름, 출신도). 
-- SUBSTR() 함수 이용.
SELECT name as 이름, city as 출신도 FROM tblinsa WHERE city = '서울' AND substr(name, 1, 1) = '김';

-- 19. 2000년도에 입사한 사람 출력. (이름, 출신도, 입사일). 
-- SUBSTR() 또는 TO_CHAR() 함수 이용.
SELECT name as 이름, city as 출신도, ibsadate as 입사일 FROM tblinsa WHERE substr(ibsadate, 1, 1) = '2';

-- 20. 2000년 10월에 입사한 사람 출력. (이름, 출신도, 입사일). 
SELECT name as 이름, city as 출신도, ibsadate as 입사일 FROM tblinsa WHERE to_char(ibsadate, 'YYYY-MM') = '2000-10';

-- 21. 주민번호를 기준으로 직원의 나이 구하기(단, 모든 직원이 1900년대에 태어났다는 가정). (이름, 주민번호, 나이)
SELECT name, ssn, to_char(sysdate, 'YYYY') - ('19' || substr(ssn, 1, 2)) as 나이 FROM tblinsa;  

-- 22. 주민번호 기준으로 현재 나이대가 40대인 사람만 출력.
SELECT * FROM 
    tblinsa 
        WHERE to_char(sysdate, 'YYYY') - ('19' || substr(ssn, 1, 2)) >= 40 AND
            to_char(sysdate, 'YYYY') - ('19' || substr(ssn, 1, 2)) <= 49;

-- 23. 주민번호 기준으로 5월달생만 출력. SUBSTR() 함수 이용.
SELECT * FROM tblinsa WHERE substr(ssn, 3, 2) = '05';

-- 24. 주민번호 기준으로 5월달생만 출력. TO_CHAR() 함수 이용. ---------------------------------------------
-- 문자열 -> 날짜 -> 문자열
SELECT * FROM tblinsa WHERE to_date(ssn, "");

-- 25. 출신도 내림차순으로 정렬하고, 출신도가 같으면 기본급 내림차순
SELECT * FROM tblinsa ORDER BY city DESC, basicpay DESC;
 
 
-- 26. 서울 사람 중에서 기본급+수당(->급여) 내림차순으로 정렬. 
-- (이름, 출신도, 기본급+수당)
SELECT name, city, basicpay + sudang FROM tblinsa WHERE city = '서울' ORDER BY basicpay + sudang DESC;


 
-- 27. 여자 중 부서 오름차순으로 정렬하고, 부서가 같으면 기본급 내림차순 정렬. (이름, 주민번호, 부서, 기본급)
SELECT name, ssn, buseo, basicpay FROM tblinsa ORDER BY BUSEO ASC, basicpay DESC;


-- 28. 남자 중에서 나이를 기준으로 오름차순 정렬해서 출력.
SELECT * FROM tblinsa WHERE substr(ssn, 8, 1) = 1 ORDER BY to_char(sysdate, 'YYYY') - ('19' || substr(ssn, 1, 2)) ASC;

-- 29. 서울 지역 사람들 중에서 입사일이 빠른 사람을 먼저 출력.
SELECT * FROM tblinsa WHERE city = '서울' ORDER BY ibsadate DESC;

-- 30. 성씨가 김씨가 아닌 사람 출력. (이름, 출신도, 기본급). 
-- LIKE 연산자 또는 SUBSTR() 함수 이용.
SELECT name, city, basicpay FROM tblinsa WHERE name not like '김%'; 

-- 31. 출신도가 서울, 부산, 대구 이면서 
-- 전화번호에 5 또는 7이 포함된 자료 출력하되 
-- 부서명의 마지막 부는 출력되지 않도록함. 
-- (이름, 출신도, 부서명, 전화번호)
SELECT name, city, substr(buseo, 1, 2), tel FROM tblinsa WHERE city in ('서울', '부산', '대구') AND (tel like '%5%' OR tel like '%7%');

  
-- 32. 전화번호가 있으면 '-'을 제거하고 출력하고, 없으면 '전화번호없음'을 출력
-- 추가문제) HR계정, employees 테이블에서 커미션 받는 사람의 수와 
-- 안받는 사람의 수를 출력
--COUNT(), NVL(), GROUP BY 구문
SELECT 
    CASE
        WHEN TEL IS NOT NULL THEN replace(tel, '-', '')
        WHEN TEL IS NULL THEN '전화번호없음'
    END
FROM tblinsa;


-- 33. tblinsa 테이블에서 basicpay+sudang가 100만원 미만
-- , 100만원 이상~200만원 미만, 200만원 이상인 직원들의 수 출력.
--GROUP BY 구문
SELECT 급여수준, count(*) FROM 
    (SELECT
        CASE 
           WHEN basicpay + sudang < 1000000 THEN '100만원미만'
           WHEN basicpay + sudang >= 1000000 AND basicpay + sudang < 2000000 THEN '200만원미만'
           WHEN basicpay + sudang >= 2000000 THEN '200만원이상'
        END as 급여수준 
    FROM tblinsa)
GROUP BY 급여수준;
    
-- 34. tblinsa 테이블에서 주민번호를 가지고 생년월일의 년도별 직원수 출력
SELECT substr(ssn, 1, 2) as 년도, count(*) FROM tblinsa GROUP BY substr(ssn, 1, 2) ORDER BY substr(ssn, 1, 2) ASC;

-- 35. 주민번호를 기준으로 월별 오름차순, 월이 같으면 년도 내림차순 출력. 
-- (이름, 주민번호) . SUBSTR() 함수 이용.
SELECT name, ssn FROM tblinsa ORDER BY substr(ssn, 3, 2) ASC, substr(ssn, 1, 2) DESC;

-- 36. 입사일을 기준으로  월별 오름차순, 월이 같으면 년도 내림차순 출력. 
-- 주의. 입사일은 자료형이 DATE이다.
SELECT * FROM tblinsa ORDER BY to_char(ibsadate, 'MM') ASC, to_char(ibsadate, 'YYYY') DESC;
    

-- 37. 전체인원수, 남자인원수, 여자인원수를 동시 출력.-------------------------------------------
SELECT 
    CASE
        WHEN substr(ssn, 8, 1) = 1 THEN '남자'
        WHEN substr(ssn, 8, 1) = 2 THEN '여자'
    END as 성별,
    count(*) 
FROM tblinsa GROUP BY substr(ssn, 8, 1);

-- 38. 개발부, 영업부, 총무부 인원수 출력. COUNT(), DECODE() 함수 이용.
SELECT count(decode(buseo, '영업부', NULL, '총무부', NULL, '개발부', '개발부')) as 개발부, 
       count(decode(buseo, '영업부', NULL, '총무부', '총무부', '개발부', NULL)) as 총무부, 
       count(decode(buseo, '영업부', '영업부', '총무부', NULL, '개발부', NULL)) as 영업부
    FROM tblinsa 
        
-- 39. 서울 사람의 남자 인원수 출력. ----------------------------
SELECT count(*) FROM tblinsa WHERE city = '서울' AND substr(ssn, 8, 1) = 1;

-- 40. 부서가 영업부이고, 남자 인원수, 여자 인원수 출력.  COUNT(), DECODE() 함수 이용.        ----------------
SELECT count(*) FROM tblinsa WHERE BUSEO = '영업부' GROUP BY substr(ssn, 8, 1);
    
-- 41. 개발부, 영업부, 총무부 인원수 출력. 단, 지역은 '서울'로 한정.
SELECT count(decode(buseo, '영업부', NULL, '총무부', NULL, '개발부', '개발부')) as 개발부, 
       count(decode(buseo, '영업부', NULL, '총무부', '총무부', '개발부', NULL)) as 총무부, 
       count(decode(buseo, '영업부', '영업부', '총무부', NULL, '개발부', NULL)) as 영업부 
FROM tblinsa WHERE city = '서울';
 
-- 42. 서울 사람의 남자와 여자의 기본급합 출력.
SELECT  CASE
        WHEN substr(ssn, 8, 1) = 1 THEN '남자'
        WHEN substr(ssn, 8, 1) = 2 THEN '여자'
        END as 성별, sum(basicpay) FROM tblinsa WHERE city = '서울' GROUP BY substr(ssn, 8, 1);

-- 43. 남자와 여자의 기본급 평균값 출력. AVG(), DECODE() 함수 이용.
SELECT  CASE
        WHEN substr(ssn, 8, 1) = 1 THEN '남자'
        WHEN substr(ssn, 8, 1) = 2 THEN '여자'
        END as 성별, round(avg(basicpay)) FROM tblinsa GROUP BY substr(ssn, 8, 1);


-- 44. 개발부의 남자, 여자 기본급 평균값 출력.
SELECT round(avg(basicpay)) FROM tblinsa WHERE buseo = '개발부' GROUP BY substr(ssn, 8, 1);

-- 45. 부서별 남자와 여자 인원수 구하기
SELECT  BUSEO, CASE
        WHEN substr(ssn, 8, 1) = 1 THEN '남자'
        WHEN substr(ssn, 8, 1) = 2 THEN '여자'
        END as 성별, count(*) FROM tblinsa GROUP BY BUSEO, substr(ssn, 8, 1)
        ORDER BY BUSEO ASC;
        
-- 46. 지역별 남자와 여자 인원수 구하기
SELECT city, CASE
        WHEN substr(ssn, 8, 1) = 1 THEN '남자'
        WHEN substr(ssn, 8, 1) = 2 THEN '여자'
        END as 성별, count(*) FROM tblinsa GROUP BY city, substr(ssn, 8, 1)
        ORDER BY city ASC;

-- 47. 입사년도별 남자와 여자 인원수 구하기
SELECT to_char(ibsadate, 'YYYY'), 
        CASE
            WHEN substr(ssn, 8, 1) = 1 THEN '남자'
            WHEN substr(ssn, 8, 1) = 2 THEN '여자'
        END as 성별
        ,count(*) FROM tblinsa GROUP BY to_char(ibsadate, 'YYYY'), substr(ssn, 8, 1)
        ORDER BY to_char(ibsadate, 'YYYY') ASC;

-- 48. 영업부, 총무부 인원만을 가지고 입사년도별 남자와 여자 인원수 구하기
SELECT to_char(ibsadate, 'YYYY'), 
        CASE
            WHEN substr(ssn, 8, 1) = 1 THEN '남자'
            WHEN substr(ssn, 8, 1) = 2 THEN '여자'
        END as 성별,
    count(*)
    FROM tblinsa
        WHERE buseo in ('영업부', '총무부')
          GROUP BY to_char(ibsadate, 'YYYY'), substr(ssn, 8, 1)
          ORDER BY to_char(ibsadate, 'YYYY');


-- 49. 서울 사람중 부서별 남자와 여자인원수, 남자와 여자 급여합 출력.
SELECT BUSEO, CASE
            WHEN substr(ssn, 8, 1) = 1 THEN '남자'
            WHEN substr(ssn, 8, 1) = 2 THEN '여자'
        END as 성별,
        count(*), sum(basicpay) FROM tblinsa WHERE city = '서울' GROUP BY BUSEO, substr(ssn, 8, 1)
        ORDER BY BUSEO ASC;


-- 50. 부서별 인원수 출력. 인원수가 10 이상인 경우만.
SELECT BUSEO, count(*) FROM tblinsa GROUP BY BUSEO HAVING count(*) > 10
    ORDER BY BUSEO ASC;


-- 51. 부서별 남,여 인원수 출력. 여자인원수가 5명 이상인 부서만 출력. -----------------------------
SELECT count(*) FROM tblinsa GROUP BY BUSEO, substr(ssn, 8, 1); 

 
-- 52. 이름, 성별, 나이 출력
--        성별: 주민번호 1,3->남자, 2,4->여자 (DECODE 사용)
--        나이: 주민번호 이용해서
SELECT 
    name, 
    decode(substr(ssn, 8, 1), 1, '남자', 2, '여자', 3, '남자', 4, '여자'),
    to_char(sysdate, 'YYYY') - ('19' || substr(ssn, 1, 2))
FROM tblinsa;

 
-- 53. 서울 사람 중에서 기본급이 200만원 이상이 사람. (이름, 기본급)
SELECT name, basicpay FROM tblinsa WHERE city = '서울' AND basicpay >= 2000000;


 
-- 54. 입사월별 인원수 구하기. (월, 인원수)   COUNT, GROUP BY, TO_CHAR 사용
--         출력형태 ----------
--         월      인원수
--         1월    10명
--         2월    25명
SELECT to_char(ibsadate, 'MM') as 월, count(*) as 인원수 
    FROM tblinsa 
        GROUP BY to_char(ibsadate, 'MM')
            ORDER BY to_char(ibsadate, 'MM') ASC;


-- 55. 이름, 생년월일, 기본급, 수당을 출력.
--        생년월일은 주민번호 기준 (2000-10-10 형식으로 출력)
--        기본급은 \1,000,000 형식으로 출력
SELECT name, '19' || substr(ssn, 1, 2) || '-' || substr(ssn, 3, 2) || '-' || substr(ssn, 5, 2), ltrim(to_char(basicpay, '9,999,999')), sudang FROM tblinsa
     ORDER BY sudang DESC, name ASC;
 
-- 56. 이름, 출신도, 기본급을 출력하되 출신도 내림차순 출력(1차 정렬 기준). 
-- 출신도가 같으면 기본급 오름차순 출력(2차 정렬 기준).
SELECT name, city, basicpay FROM tblinsa ORDER BY city DESC, basicpay ASC; 
 
-- 57. 전화번호가 NULL이 아닌것만 출력. (이름, 전화번호)
SELECT name, tel FROM tblinsa WHERE tel is not null;

-- 58. 근무년수가 15년 이상인 사람 출력. (이름, 입사일)
SELECT name, ibsadate FROM tblinsa WHERE (sysdate - ibsadate) / 365 >= 15
ORDER BY IBSADATE ASC, NAME ASC;  
 
-- 59. 주민번호를 기준으로 75~82년생 출력. (이름, 주민번호, 출신도). 
-- SUBSTR() 함수, BEWTEEN AND 구문, TO_NUMBER() 함수 이용.
SELECT name, ssn, city FROM tblinsa WHERE substr(ssn, 1, 2) BETWEEN 75 AND 82; 

-- 60. 근무년수가 15~20년인 사람 출력. (이름, 입사일)
SELECT name, ibsadate FROM tblinsa WHERE (sysdate - ibsadate) / 365 >= 15 AND (sysdate - ibsadate) / 365 <= 20;
 
-- 61. 김씨, 이씨, 박씨만 출력 (이름, 부서). SUBSTR() 함수 이용.
SELECT name, buseo FROM tblinsa WHERE substr(name, 1, 1) in ('김', '이', '박');
 
-- 62. 입사일을 "년-월-일 요일" 형식으로 남자만 출력 (이름, 주민번호, 입사일)
SELECT name, ssn, ibsadate || ' ' || to_char(ibsadate, 'dy') FROM tblinsa WHERE substr(ssn, 8, 1) = '1';


-- 63. 부서별 직위별 급여합 구하기. (부서, 직위, 급여합)
SELECT buseo, jikwi, sum(basicpay)  FROM tblinsa GROUP BY buseo, jikwi;

-- 64. 부서별 직위별 인원수, 급여합, 급여평균 구하기. (부서, 직위, 급여합)
SELECT buseo, jikwi, count(*), sum(basicpay), round(avg(basicpay)) FROM tblinsa GROUP BY buseo, jikwi;
 
-- 65. 부서별 직위별 인원수를 구하되 인원수가 5명 이상인 경우만 출력.
SELECT buseo, jikwi, count(*) FROM tblinsa GROUP BY buseo, jikwi HAVING count(*) >= 5;

-- 66. 2000년에 입사한 여사원. (이름, 주민번호, 입사일)
SELECT name, ssn, ibsadate FROM tblinsa WHERE to_char(ibsadate, 'yyyy') = '2000' AND substr(ssn, 8, 1) = '2';
 
-- 67. 성씨가 한 글자(김, 이, 박 등)라는 가정하에 성씨별 인원수 (성씨, 인원수)
SELECT substr(name, 1, 1), count(*) FROM tblinsa GROUP BY substr(name, 1, 1);
    
-- 68. 출신도(CITY)별 성별 인원수.
SELECT city, 
CASE
    WHEN substr(ssn, 8, 1) = '1' THEN '남자'
    WHEN substr(ssn, 8, 1) = '2' THEN '여자'
END,
count(*)

FROM tblinsa GROUP BY city, substr(ssn, 8, 1);
 
-- 69. 부서별 남자인원수가 5명 이상인 부서와 남자인원수.
SELECT buseo, count(*) FROM tblinsa WHERE substr(ssn, 8, 1) = '1' GROUP BY buseo HAVING count(*) >= 5;
 
-- 70. 입사년도별 인원수.
SELECT to_char(ibsadate, 'yyyy'), count(*) FROM tblinsa GROUP BY to_char(ibsadate, 'yyyy');

-- 71. 전체인원수, 2000년, 1999년, 1998년도에 입사한 인원을 다음의 형식으로 출력.---------------
--         2000 1999 1998
--          x    x    x
SELECT distinct (SELECT count(*) FROM tblinsa),
                (SELECT count(*) FROM tblinsa WHERE ibsadate like '2000%') as "2000",
                (SELECT count(*) FROM tblinsa WHERE ibsadate like '1999%') as "1999",
                (SELECT count(*) FROM tblinsa WHERE ibsadate like '1998%') as "1998" FROM tblinsa; 

-- 72. 아래 형식으로 지역별 인원수 출력.--------------------------
--          서울  인천  경기
--           x     x     x
SELECT distinct (SELECT count(*) FROM tblinsa),
                (SELECT count(*) FROM tblinsa WHERE city = '서울') as "2000",
                (SELECT count(*) FROM tblinsa WHERE city = '인천') as "1999",
                (SELECT count(*) FROM tblinsa WHERE city = '경기') as "1998" FROM tblinsa; 

-- 73. 기본급(basicpay)이 평균 이하인 사원 출력. (이름, 기본급). AVG() 함수. 하위쿼리.
SELECT name, basicpay FROM tblinsa WHERE basicpay <= (SELECT avg(basicpay) FROM tblinsa);


-- 74. 기본급 상위 10%만 출력. (이름, 기본급)
SELECT name, basicpay FROM tblinsa WHERE basicpay <= (SELECT max(basicpay) FROM tblinsa) AND basicpay >= (SELECT max(basicpay) - max(basicpay) / 10 FROM tblinsa);


-- 75.기본급 순위가 5순위까지만 출력
SELECT name, basicpay, rownum FROM (SELECT * FROM tblinsa ORDER BY basicpay DESC) WHERE rownum <= 5;


-- 76. 입사일이 빠른 순서로 5순위까지만 출력.
SELECT * FROM (SELECT * FROM tblinsa ORDER BY ibsadate DESC) WHERE rownum <= 5;


-- 77. 평균 급여보다 많은 급여를 받는 직원 출력  
SELECT * FROM tblinsa WHERE basicpay > (SELECT avg(basicpay) FROM tblinsa);

-- 78. '이순애' 직원의 급여보다 더 많은 급여를 받는 직원 출력.
SELECT name, basicpay FROM tblinsa WHERE basicpay > (SELECT basicpay FROM tblinsa WHERE name = '이순애');


-- 79. 총무부의 평균 급여보다 많은 급여를 받는 직원들의 이름, 부서명 출력.
SELECT name, buseo FROM tblinsa WHERE basicpay > (SELECT avg(basicpay) FROM tblinsa WHERE buseo = '총무부');


-- 80. 총무부 직원들보다 더 많은 급여를 받는 직원 정보.
SELECT * FROM tblinsa WHERE basicpay > (SELECT min(basicpay) FROM tblinsa);


-- 81. 직원 전체 평균 급여보다 많은 급여를 받는 직원의 수 출력.
SELECT count(*) FROM tblinsa WHERE basicpay > (SELECT avg(basicpay) FROM tblinsa);


-- 82. '홍길동' 직원과 같은 부서의 직원 정보.
SELECT * FROM tblinsa WHERE buseo = (SELECT buseo FROM tblinsa WHERE name = '홍길동');


-- 83. '김신애' 직원과 같은 부서, 직위를 가진 직원 정보
SELECT * FROM tblinsa WHERE buseo = (SELECT buseo FROM tblinsa WHERE name = '김신애') AND jikwi = (SELECT jikwi FROM tblinsa WHERE name = '김신애');

            


-- 84. 부서별 기본급이 가장 높은 사람 출력. (부서, 기본급)     
SELECT buseo, max(basicpay) FROM tblinsa GROUP BY buseo;
       


-- 85. 남자 기본급 순위 출력.
    -- 여자 기본급 순위 출력.
SELECT a.*, rownum as 순위 FROM (SELECT * FROM tblinsa WHERE substr(ssn, 8, 1) = '1' ORDER BY basicpay DESC) a; 
SELECT b.*, rownum as 순위 FROM (SELECT * FROM tblinsa WHERE substr(ssn, 8, 1) = '2' ORDER BY basicpay DESC) b; 
        
-- 86. 지역(city)별로 급여(기본급+수당) 1순위 직원만 출력.
SELECT city, max(basicpay + sudang) FROM tblinsa GROUP BY city;


-- 87. 부서별 인원수가 가장 많은 부서 및 인원수 출력.
SELECT * FROM (SELECT buseo, count(*) FROM tblinsa GROUP BY buseo ORDER BY count(*) DESC) WHERE rownum = '1';

        
-- 88. 지역(city)별 인원수가 가장 많은 지역 및 인원수 출력.
SELECT * FROM (SELECT city, count(*) FROM tblinsa GROUP BY city ORDER BY count(*) DESC) WHERE rownum = '1';


-- 89. 지역(city)별 평균 급여(basicpay+sudang)가 
 --      가장 높은 지역 및 평균급여 출력.
SELECT * FROM (SELECT city, round(avg(basicpay + sudang)) FROM tblinsa GROUP BY city ORDER BY round(avg(basicpay + sudang)) DESC) WHERE rownum = 1;


-- 90. 여자 인원수가 가장 많은 부서 및 인원수 출력.
SELECT * FROM 
    (SELECT buseo, count(*) FROM tblinsa WHERE substr(ssn, 8, 1) = '2' GROUP BY BUSEO ORDER BY count(*) DESC)
        WHERE rownum = 1;


    
-- 91. 지역별 인원수 순위 출력.
SELECT city, count, rownum as 순위 FROM (SELECT city, count(*) as count FROM tblinsa a GROUP BY city ORDER BY count(*) DESC) ORDER BY rownum ASC;

                
-- 92. 지역별 인원수 순위 출력하되 5순위까지만 출력.

SELECT * FROM (SELECT city, count(*) FROM tblinsa GROUP BY city ORDER BY count(*) DESC) WHERE rownum <= 5;

 
-- 93. 이름, 부서, 출신도, 기본급, 수당, 기본급+수당, 세금, 실수령액 출력
--        세금: 총급여가 250만원 이상이면 2%, 200만원 이상이면 1%, 나머지 0.
--        실수령액: 총급여-세금
--        CASE~END 문 사용.
SELECT name, buseo, city, basicpay, sudang, basicpay + sudang, 
    CASE 
        WHEN basicpay + sudang >= 2500000 THEN (basicpay + sudang) * 0.02 
        WHEN basicpay + sudang >= 2000000 THEN (basicpay + sudang) * 0.01
        ELSE 0
    END as 세금,
    basicpay + sudang - CASE 
                            WHEN basicpay + sudang >= 2500000 THEN (basicpay + sudang) * 0.02 
                            WHEN basicpay + sudang >= 2000000 THEN (basicpay + sudang) * 0.01
                            ELSE 0
                         END as 실수령액
FROM tblinsa;

-- 94. 부서별 평균 급여를 출력하되, A, B, C 등급으로 나눠서 출력.
-- 200만원 초과 - A등급
-- 150~200만원 - B등급
-- 150만원 미만 - C등급
SELECT buseo,
CASE
    WHEN round(avg(basicpay)) > 2000000 THEN 'A등급'
    WHEN round(avg(basicpay)) >= 1500000 AND round(avg(basicpay)) <= 2000000 THEN 'B등급'
    WHEN round(avg(basicpay)) < 1500000 THEN 'C등급'
END
FROM tblinsa GROUP BY buseo;

 
-- 95. 기본급+수당이 가장 많은 사람의 이름, 기본급+수당 출력. 
-- MAX() 함수, 하위 쿼리 이용.
SELECT * FROM (SELECT * FROM tblinsa ORDER BY basicpay + sudang DESC) WHERE rownum = 1;


-- 96. tblinsa. 80년대생 남자 직원들의 평균 월급(basicpay)보다 더 많이 받는 70년대생 여직원들을 출력.
SELECT * FROM tblinsa WHERE substr(ssn, 8, 1) = '2' AND basicpay > (SELECT avg(basicpay) FROM tblinsa WHERE substr(ssn, 1, 1) = '8');


-- 97. tblStaff, tblProject. 현재 재직중인 모든 직원의 이름, 주소, 월급, 담당프로젝트명을 출력.
SELECT s.name, s.address, s.salary, p.name FROM tblStaff s INNER JOIN tblProject p ON s.seq = p.staff;

-- 98. tblVideo, tblRent, tblMember. '뽀뽀할까요' 라는 비디오를 빌려간 회원의 이름?
desc tblVideo;
desc tblRent;
desc tblMember;

SELECT name FROM tblMember WHERE seq = (SELECT member FROM tblRent WHERE video = (SELECT seq FROM tblVideo WHERE name = '뽀뽀할까요'));

-- 99. tblinsa. 평균 이상의 월급을 받는 직원들?
SELECT * FROM tblinsa WHERE basicpay >= (SELECT avg(basicpay) FROM tblinsa);

-- 100. tblStaff, tblProejct. '노조협상건'을 담당한 직원의 월급?
SELECT SALARY FROM tblStaff WHERE seq = (SELECT staff FROM tblProject WHERE name = '노조 협상');
SELECT salary FROM tblStaff s INNER JOIN tblProject p ON s.seq = p.staff WHERE p.name = '노조 협상'; 
-- 101. tblMember. 가장 나이가 많은 회원의 주소? (bYear)
desc tblMember;

SELECT address FROM (SELECT * FROM tblMember ORDER BY byear ASC) WHERE rownum = 1;

-- 102. tblvideo. '털미네이터' 비디오를 한번이라도 빌려갔던 회원들의 이름?
SELECT * FROM tblRent;
SELECt * FROM tblVideo;

SELECT * FROM tblMember 
    WHERE seq 
        in (SELECT member FROM tblRent r INNER JOIN tblVideo v ON r.video = v.seq WHERE  v.name = '털미네이터'); 

SELECT * FROM tblMember 
    WHERE seq 
        in (SELECT member FROM tblRent WHERE video = (SELECT seq FROM tblVideo WHERE name = '털미네이터')) 
            ORDER BY seq ASC;
            
-- 103. tblStaff, tblProject. 서울시에 사는 직원을 제외한 나머지 직원들의
--     이름, 월급, 담당프로젝트명을 출력하시오.
SELECT s.name, s.salary, p.name  
    FROM tblStaff s INNER JOIN tblProject p 
        ON s.seq = p.staff 
            WHERE s.address <> '서울시'; 

-- 104. tblCustomer, tblSales. 상품을 2개(단일상품) 이상 구매한 회원의
--    연락처, 이름, 구매상품명, 수량 출력
desc tblCustomer;
desc tblSales;
SELECT * FROM tblSales;

SELECT c.tel, c.name, s.item, s.qty 
    FROM tblSales s INNER JOIN tblCustomer c ON c.seq = s.customer 
        WHERE qty >= 2; 


-- 105. tblvideo. 모든 비디오 제목, 보유수량, 대여가격을 출력
SELECT v.name, v.qty, g.price FROM tblvideo v INNER JOIN tblgenre g ON v.genre = g.seq;
SELECT * FROM tblgenre;

-- 106. tblvideo. 2007년 2월에 대여된 구매내역을 출력하시오. 회원명, 비디오명, 언제, 대여가격
SELECT m.name, v.name, r.rentdate, g.price FROM tblVideo v 
    INNER JOIN tblRent r ON v.seq = r.video 
        INNER JOIN tblgenre g ON v.GENRE = g.seq 
            INNER JOIN tblMember m ON m.seq = r.member
                WHERE r.RENTDATE like '2007-02%';

desc tblrent;
-- 107. tblvideo. 현재 반납을 안한 회원명과 비디오명, 대여날짜 출력.
SELECT m.name, v.name, r.rentdate FROM tblRent r INNER JOIN tblvideo v ON r.video = v.seq INNER JOIN tblmember m ON m.seq = r.member WHERE RETDATE is null;



-- 108. tblhousekeeping. 지출 내역(가격 * 수량) 중 가장 많은 금액을 지출한 내역 3가지를 출력.
SELECT * FROM (SELECT * FROM tblhousekeeping ORDER BY price * qty DESC) WHERE rownum <= 3;


-- 109. tblinsa. 평균 급여 2위인 부서에 속한 직원들을 출력
SELECT * FROM tblinsa 
    WHERE buseo = 
        (SELECT buseo 
            FROM (SELECT buseo, rownum as rnum FROM 
                    (SELECT buseo FROM tblinsa GROUP BY buseo ORDER BY avg(basicpay) DESC)) WHERE rnum = 2);


-- 110. tblinsa. 부서별 최고 연봉을 받는 직원들을 출력(7명)
SELECT buseo, max(basicpay * 12) FROM tblinsa GROUP BY buseo ORDER BY max(basicpay * 12) DESC;


-- 111. tbltodo. 등록 후 가장 빠르게 완료한 할일을 순서대로 5개 출력
SELECT * FROM (SELECT * FROM tbltodo ORDER BY completedate - adddate) WHERE rownum <= 5;


-- 112. tblinsa. 남자 직원 중에서 급여를 3번째로 많이 받는 직원과 9번째로 많이 받는 직원의 급여 차액은 얼마?

SELECT distinct

(SELECT basicpay 
    FROM 
    (SELECT basicpay, rownum as rnum 
        FROM 
            (SELECT * FROM tblinsa WHERE substr(ssn, 8, 1) = '1' ORDER BY basicpay DESC)) 
                WHERE rnum = 3) -
(SELECT basicpay 
    FROM 
    (SELECT basicpay, rownum as rnum 
        FROM 
            (SELECT * FROM tblinsa WHERE substr(ssn, 8, 1) = '1' ORDER BY basicpay DESC))
                WHERE rnum = 9) as 답
            
FROM (SELECT basicpay 
        FROM 
            (SELECT basicpay, rownum as rnum 
                FROM 
                    (SELECT * 
                        FROM tblinsa
                            WHERE substr(ssn, 8, 1) = '1' 
                                ORDER BY basicpay DESC)) 
                                    WHERE rnum = 3 or rnum = 9);



SELECT s.SUBJECT_SEQ as 과목번호,
       bs.BASIC_SUBJECT_NAME as 과목명,
       s.SUBJECT_START_DATE as 과목시작일,
       s.SUBJECT_END_DATE as 과목종료일,
       bc.BASIC_COURSE_NAME as 과정명,
       c.COURSE_START_DATE as 과정시작일,
       c.COURSE_END_DATE as 과정종료일,
       bb.BASIC_BOOK_NAME as 교재명
  FROM tbl_subject s
    INNER JOIN tbl_course c
      ON s.COURSE_SEQ = c.COURSE_SEQ
        INNER JOIN TBL_BASIC_COURSE bc
          ON bc.BASIC_COURSE_SEQ = c.BASIC_COURSE_SEQ
            INNER JOIN TBL_BASIC_SUBJECT bs
              ON bs.BASIC_SUBJECT_SEQ = s.BASIC_SUBJECT_SEQ
                INNER JOIN TBL_BASIC_BOOK bb
                  ON bb.BASIC_BOOK_seq = s.BASIC_BOOK
                    INNER JOIN TBL_STUDENT_ENROLLMENT se
                      ON se.COURSE_SEQ = c.COURSE_SEQ
                        WHERE s.DETAIL_TEACHER_SEQ = 1;



