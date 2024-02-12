create database school;
use school;

# 관계:
# 학과와 학생: 한 한과에는 여러 학생이 속할 수 있으며 학생은 반드시 하나의 학과에 속해야 한다.
# 학과와 교수: 한 학과에는 여러 교수가 속할 수 있으며 교수는 반드시 하나의 학과에 속해야 한다.
# 교수와 과목: 한 교수는 여러 과목을 가르칠 수 있으며 과목은 반드시 한명의 교수에 의해 진행되어야 하고 교수는 강의를 반드시 하지는 않는다.
# 학생과 과목: 학생은 여러 과목을 수강할 수 있으며 과목은 여러 학생에 의해 수강될 수 있다. 또한 학생이 특정 과목을 수강하면 실수 형태의 평점(grade)이 나온다.

create table department (
	department_id varchar(5) primary key,
    name varchar(20) not null unique,
    office_location varchar(150),
    contact_number varchar(15) not null unique
);

create table student (
	student_number int primary key,
    name varchar(20) not null,
    year enum('1', '2', '3', '4') not null,
    email varchar(50) not null unique,
    department_id varchar(5),
    foreign key student(department_id) references department(department_id)
);

create table course (
	course_code varchar(5) primary key,
    title varchar(40) not null unique,
    credits double not null
);

create table professor (
	professor_id varchar(7) primary key,
    name varchar(20) not null,
    specialization varchar(40) not null,
    office_location varchar(150),
    department_id varchar(5),
    foreign key professor(department_id) references department(department_id)
);