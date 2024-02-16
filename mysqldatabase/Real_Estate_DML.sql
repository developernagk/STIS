-- 1. 로그인 화면
-- 아이디와 비밀번호를 입력하여 로그인
-- 카카오, 네이버로 SNS 로그인을 할 수 있음

-- 2. 회원가입 화면
-- 아이디, 비밀번호, 비밀번호 확인, 이메일, 인증번호를 입력하여 회원가입
-- 아이디에 대한 중복 확인이 필요
-- 이메일 인증을 통해서 인증코드를 지정한 이메일로 전송
-- 전송 받은 인증코드를 입력하여 이메일 인증 처리를 함
-- 카카오, 네이버로 SNS 회원가입을 할 수 있음

-- 3. QnA 게시판 목록 화면
-- 관리자 계정만 미완료 보기를 할 수 있음
-- 미완료 보기 체크 시 답변이 미완료된 게시물을 조회
-- 게시물 목록은 하나의 아이템에 대하여 접수번호, 완료 상태, 제목, 작성자 아이디, 작성일, 조회수를 보여줌(접수번호 기준으로 내림차순 정렬하여 보여줌)
-- 게시물 제목으로 검색을 할 수 있음

-- 4. QnA 게시물 작성 화면
-- 제목, 내용을 작성할 수 있음

-- 5. 게시물 보기 화면
-- 제목, 작성자 아이디, 작성일, 조회수, 내용, 답변 내용을 조회
-- 만약 관리자로 로그인 상태이면 답변 내용으로 답변을 작성할 수 있음
-- 게시물을 삭제할 수 있음

-- 6. 게시물 수정 화면
-- 제목과 내용을 수정할 수 있음

-- Entity - Attribute
-- User(회원) - id, password, email, join_path, role, authentication_code
-- QnA(qna 게시물) - reception_number, title, write_datetime, contents, view_count, writer_id, reply, reply_status

-- Relationship
-- User - QnA : 회원이 게시물을 작성함
-- User - QnA : 관리자 회원이 답변을 작성함

-- Table
-- User
-- id VARCHAR(20) PRIMARY KEY,
-- password VARCHAR(13) NOT NULL,
-- email VARCHAR(50) NOT NULL UNIQUE, # 중복 가능 여부에 따라 후보키가 될 수도 있고 아닐 수도 있음, 실무에서는 중복 여부도 중요
-- join_path VARCHAR(5) NOT NULL DEFAULT 'HOME' CHECK(join_path IN ("HOME", "KAKAO", "NAVER")), # CHECK 제약조건은 다른 값 입력 불가능
-- role VARCHAR(5) NOT NULL DEFAULT 'NOMAL' CHECK(role IN ("NOMAL", "ADMIN"))

-- Email_Authentication
-- email VARCHAR(50) PRIMARY KEY,
-- authentication_code VARCHAR(4) NOT NULL

-- QnA
-- reception_number INT PRIMARY KEY AUTO_INCREMENT,
-- titleTEXT NOT NULL,
-- write_datetime DATETIME NOT NULL DEFAULT now(),
-- contents TEXT NOT NULL,
-- view_count INT NOT NULL DEFAULT 0,
-- writer_id VARCHAR(20) NOT NULL,
-- reply TEXT,
-- replyer VARCHAR(20),
-- reply_status BOOLEAN NOT NULL DEFAULT false

# 밑의 테이블 생성 시 데이터 관리 효율적이지만 계속해서 조인해야 한다는 점에서 속도 저하 발생
# 반정규화로 밑의 테이블 생성 안 함
-- Reply
-- reception_number INT,
-- replyer VARCHAR(20),
-- reply TEXT,
-- reply_status BOOLEAN NOT NULL DEFAULT false

-- Relationship
-- User - QnA : 회원은 여러 개의 게시물을 작성할 수 있고 게시물은 반드시 한 명의 회원에 의해 작성되어짐(1 : n)
-- User - QnA : 관리자 회원은 여러 개의 게시물에 답변을 작성할 수 있고 게시물은 한 명의 관리자에 의해 작성되어짐(1 : n)

# 외래키
-- FK writer User (id) - QnA (writer_id)
-- FK replyer User (id) - QnA (replyer)
# 정규화
-- FK email_auth Email_authentication (email) - User (email)

USE real_estate;

-- 1. 아이디 중복 확인
SELECT * FROM user WHERE user_id = 'userID';

-- 2. 이메일 인증 전송
INSERT INTO email_authentication VALUES ('email@email.com', 'QWER');

-- 3. 이메일 인증 확인
SELECT * FROM email_authentication WHERE email = 'email@email.com' AND authentication_code = 'QWER';

-- 4. 회원가입 처리
INSERT INTO user (user_id, password, email) VALUES ('userID', 'P!ssw0rd', 'email@email.com');

-- 5. 로그인 처리
SELECT user_id FROM user WHERE user_id = 'userID' AND password = 'P!ssw0rd';

-- 6. 게시물 작성
INSERT INTO qna (title, contents, writer_id) VALUES  ('질문 있습니다.', '데이터는 언제 데이터인가요?', 'userID');

-- 7. 게시물 목록 보기
SELECT reception_number, reply_status, title, writer_id, write_datetime, view_counts FROM qna ORDER BY reception_number DESC;

-- 8. 관리자로 미완료 게시물 보기
SELECT reception_number, reply_status, title, writer_id, write_datetime, view_counts FROM qna WHERE reply_status = 0 ORDER BY reception_number DESC;
# 아래와 위의 코드는 동일하게 조회
SELECT reception_number, reply_status, title, writer_id, write_datetime, view_counts FROM qna WHERE reply_status IS FALSE ORDER BY reception_number DESC;

-- 9. 검색 게시물 목록 보기
SELECT reception_number, reply_status, title, writer_id, write_datetime, view_counts FROM qna WHERE title LIKE '%질문%' ORDER BY reception_number DESC;
# 데이터베이스에 '안녕'이 들어간 제목은 없으므로 조회되는 컬럼 없음
SELECT reception_number, reply_status, title, writer_id, write_datetime, view_counts FROM qna WHERE title LIKE '%안녕%' ORDER BY reception_number DESC;

-- 10. 특정 게시물 보기
SELECT title, writer_id, write_datetime, view_counts, contents, reply FROM qna WHERE reception_number = '1';

-- 11. 관리자로 답변 작성
UPDATE qna SET reply = '2023년 데이터입니다.', replyer_id = 'userID', reply_status = 1 WHERE reception_number = '1';

-- 12. 게시물 수정하기
UPDATE qna SET  title = '변경한 제목입니다.', contents = '변경한 내용입니다.' WHERE reception_number = 1;

-- 13. 게시물 삭제하기
DELETE FROM qna WHERE reception_number = 1;