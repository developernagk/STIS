USE practice_sql;

-- 서브쿼리: 쿼리 내부에 위치하는 또 다른 쿼리, 쿼리 결과를 조건이나 테이블로 사용할 수 있도록 함
-- WHERE 절에서 서브쿼리: 쿼리 결과를 조건으로 사용하여 조건을 동적으로 지정
-- WHERE 절에서 비교 연산으로 사용될 때 조회하는 컬럼의 개수 및 레코드 개수 주의
SELECT * FROM employee WHERE department_code = (SELECT code FROM department WHERE name = '인사부');
-- 아래의 코드 두 줄: 하나의 값에 하나만 연결되어야 함(department_code는 1개의 값이고 all(*)은 3개의 값이기 때문에 불가능 / department를 불러내도 all과 동일)
SELECT * FROM employee WHERE department_code = (SELECT * FROM department WHERE name = '인사부'); -- Error Code: 1241. Operand should contain 1 column(s)
SELECT * FROM employee WHERE department_code = (SELECT code FROM department); -- Error Code: 1241. Operand should contain 1 column(s)

-- FROM 절에서 서브쿼리: 쿼리 결과 테이블을 다시 FROM 절에 사용하여 복합적인 테이블 조회
-- FROM 절에서 서브쿼리를 사용할 경우 서브쿼리에 별칭을 붙여줘야 함
SELECT * FROM (SELECT name, department_code FROM employee WHERE department_code IS NOT NULL) 
WHERE name = '홍길동'; -- Error Code: 1248. Every derived table must have its own alias
SELECT * FROM (SELECT name, department_code FROM employee WHERE department_code IS NOT NULL) AS SQ 
WHERE name = '홍길동';
SELECT * FROM (SELECT name, department_code FROM employee WHERE department_code IS NULL) AS SQ 
WHERE name = '홍길동';
-- FROM 절 내부의 서브쿼리에서 컬럼명에 별칭을 붙여줄 경우 원문에서도 같이 변경해줘야 함
SELECT * 
FROM (SELECT
  name AS employee_name, 
  department_code 
  FROM employee 
  WHERE department_code IS NULL) AS SQ WHERE name = '홍길동'; -- Error Code: 1054. Unknown column 'name' in 'where clause'
SELECT * 
FROM (SELECT 
  name AS employee_name, 
  department_code 
  FROM employee 
  WHERE department_code IS NULL) AS SQ WHERE employee_name = '홍길동';

-- 부서 이름이 '개발부'인 사원이름, 부서코드, 부서명을 조회
-- 부서 이름이 '개발부'인 사원이름, 부서코드를 조회
SELECT * FROM department WHERE name = '개발부'; -- 가장 먼저 조건부 전체를 찾음
SELECT code FROM department WHERE name = '개발부'; -- 다음으로 관계를 찾아서 관계 작성
-- 조건부와 관계를 작성 후 원하는 데이터를 조회(아래 코드)
SELECT name, department_code 
FROM employee 
WHERE department_code = (SELECT code FROM department WHERE name = '개발부');
