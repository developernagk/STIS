-- 주석
# 주석

-- DDL(데이터 정의어)
-- 데이터베이스, 테이블, 인덱스, 사용자를 정의하는데 사용되는 언어

-- CREATE: 구조를 생성하는 명령어
-- CREATE 생성할구조 구조이름 [...구조 정의];

-- 데이터베이스 생성
CREATE DATABASE practice_sql;
-- 특정 데이터베이스 사용
USE practice_sql;

-- 테이블 생성
CREATE TABLE example_table (
	-- VARCHAR(문자열길이) : 가변길이 문자열 / 인덱스 사용 가능
	string_column VARCHAR(100),
    -- TEXT: 장문의 문자열 / 인덱스 사용 불가능
    text_column TEXT,
    -- INT: 정수
    int_column INT,
    -- DOUBLE: 실수
    double_column DOUBLE,
    -- FLOAT: 실수
    float_column FLOAT,
    -- BOOLEAN: 논리형
    boolean_column BOOLEAN,
    -- DATE: 날짜
    date_column DATE,
    -- DATETIME: 날짜 및 시간
    datetime_column DATETIME
);

-- 사용자 생성
-- CREATE USER '사용자명'@'접속IP' IDENTIFIED BY '비밀번호';
CREATE USER 'developer'@'localhost' IDENTIFIED BY 'P!ssW0rd';

-- 생성된 사용자 보기
USE mysql;
SELECT * FROM user;

-- DROP: 데이터 구조를 삭제하는 명령어
-- 테이블 삭제
DROP TABLE example_table;

-- 데이터베이스 삭제
DROP DATABASE practice_sql;

 -- ALTER: 데이터 구조를 변경하는 명령어
 -- 테이블 컬럼 추가
 ALTER TABLE example_table ADD added_column INT;
 
 -- 테이블 컬럼 삭제
 ALTER TABLE example_table DROP COLUMN added_column;
 
 -- 테이블 컬럼 타입 수정
 ALTER TABLE example_table MODIFY COLUMN string_column VARCHAR(200);
 
 -- 테이블 컬럼 이름 수정
 ALTER TABLE example_table CHANGE string_column varchar_column varchar(200);