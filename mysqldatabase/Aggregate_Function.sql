USE practice_sql;

-- 집계 함수: 레코드를 '그룹화'하여 하나의 결과를 반환하는 함수
-- COUNT(): 특정 조건에 맞는 행의 개수를 반환
-- null이 있으면 null은 제외하고 행의 개수를 반환
SELECT COUNT(*) FROM jeju;
SELECT COUNT(speed_80m) FROM jeju;
SELECT COUNT(*) FROM jeju WHERE speed_80m > 3;

-- SUM(): 특정 컬럼의 값을 모두 합한 결과를 반환
SELECT SUM(speed_80m) FROM jeju;
SELECT SUM(speed_80m) FROM jeju WHERE observe_date LIKE '2023-08-__';
SELECT SUM(speed_80m), SUM(speed_70m) FROM jeju WHERE observe_date LIKE '2023-08-__';
SELECT SUM(speed_80m) / COUNT(speed_80m) FROM jeju; -- 평균 구하기

-- AVG(): 특정 컬럼의 값의 평균을 반환
SELECT AVG(speed_80m) FROM jeju; -- 위의 '평균 구하기' 값과 동일

-- MIN(), MAX(): 특정 컬럼의 최솟값과 최댓값을 반환
SELECT MIN(speed_80m), MAX(speed_80m) FROM jeju;