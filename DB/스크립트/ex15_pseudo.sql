/*
ex15_pseudo.sql

의사(가짜) 컬럼, Pseudo Column

rownum
- 오라클 전용
- 행번호 
- 행의 순서를 번호로 반환하는 가상 컬럼(개발자가 직접 생성하지 않더라도 존재하는 컬럼)
- 서브쿼리를 잘해야 사용하기 쉽다.
- rownum은 FROM 절을 실행 할때 번호를 할당한다.(**********************)
- DELETE시 뒤에서 앞으로 밀어넣는다.
- 절대 Sequence 대신 사용하면 안된다.
*/

SELECT * FROM tblinsa;
SELECT name, buseo, jikwi, rownum FROM tblinsa;

SELECT name, buseo, jikwi, rownum, basicpay FROM tblinsa;

SELECT name, buseo, jikwi, rownum, basicpay -- 2.
    FROM tblinsa -- 1. 
        ORDER BY basicpay DESC; --3.

SELECT name, buseo, jikwi, basicpay, rnum, rownum FROM -- 서브쿼리로 가져온 테이블에 rownum이 다시 생성됨
    (SELECT name, buseo, jikwi, basicpay, rownum as rnum -- 익명 뷰
        FROM tblinsa 
            ORDER BY basicpay DESC); 

SELECT name, buseo, jikwi, basicpay, rnum, rownum FROM
    (SELECT name, buseo, jikwi, basicpay, rownum as rnum  -- 익명 뷰
        FROM tblinsa 
            ORDER BY basicpay DESC)
                WHERE rownum <=3; 

-- rownum이 조건으로 사용 -> 1등이 포함된 조건 
SELECT name, basicpay, rownum FROM tblinsa;
SELECT name, basicpay, rownum FROM tblinsa WHERE rownum = 1;
SELECT name, basicpay, rownum FROM tblinsa WHERE rownum = 3; -- 1번부터 조건을 물어보고 조건에 맞지않으면 지우고 재정렬 된다. -> 평생 3번 만나지 못함 
SELECT name, basicpay, rownum FROM tblinsa WHERE rownum <= 5;
SELECT name, basicpay, rownum FROM tblinsa WHERE rownum >= 6 AND rownum <= 10;


-- rownum을 조건으로 사용하기 위해서... -> 서브쿼리 사용 -> rownum 변하지 않도록 하기 위해서(정적)
SELECT name, basicpay, rownum FROM tblinsa;

SELECT name, basicpay, rownum, rnum 
    FROM (SELECT name, basicpay, rownum as rnum FROM tblinsa)
        WHERE rnum >= 5 AND rnum <= 10;


-- 급여가 많은 순서대로 정렬
SELECT * FROM 
    (SELECT rownum as rnum, a.* FROM 
            (SELECT t.* FROM tblinsa t ORDER BY basicpay DESC) a) b
                WHERE rnum >= 3 AND rnum <= 5; 
                
                































