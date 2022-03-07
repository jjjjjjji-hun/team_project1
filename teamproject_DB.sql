/* 1. 데이터베이스 생성 명령
DB생성시 한글을 쓸 수 있도록 -> default character set utf8;  아직 실행안함*/
create database project default character set utf8;

-- 유저 테이블
CREATE TABLE userinfo(
uid VARCHAR(20) PRIMARY KEY,
uname VARCHAR(10) NOT NULL,
upw VARCHAR(20) NOT NULL,
upnum VARCHAR(20) NOT NULL,
uemail VARCHAR(20) NOT NULL,
utype BOOL DEFAULT FALSE,
counting INT DEFAULT 0
);

SELECT * FROM userinfo;


-- 책 테이블
CREATE TABLE book(
bnum INT PRIMARY KEY AUTO_INCREMENT,
bname VARCHAR(20) NOT NULL,
bwriter VARCHAR(20) NOT NULL,
bpub VARCHAR(20) NOT NULL,
bcategory VARCHAR(10) NOT NULL,
check_out BOOL
);

SELECT * FROM book;


-- 대여 테이블
CREATE TABLE rent(
rentnum INT PRIMARY KEY AUTO_INCREMENT,
rentdate DATETIME DEFAULT now(),
returnschedule DATETIME DEFAULT now(),
bnum INT NOT NULL,
uid VARCHAR(20) NOT NULL,
overdue BOOL
);

SELECT * FROM rent;


-- 반납 테이블
CREATE TABLE returnb(
returnnum INT PRIMARY KEY AUTO_INCREMENT,
rentdate DATETIME DEFAULT now(),
returndate DATETIME DEFAULT now(),
bnum INT NOT NULL,
uid VARCHAR(20) NOT NULL
);

SELECT * FROM returnb;


-- 리뷰 테이블
CREATE TABLE review(
revnum INT PRIMARY KEY AUTO_INCREMENT,
bnum INT NOT NULL,
uid VARCHAR(20) NOT NULL,
revtitle VARCHAR(50) NOT NULL,
revcontent VARCHAR(1000) NOT NULL,
revdate DATETIME DEFAULT now()
);

SELECT * FROM review;


-- 수정 : 대여 반납 리뷰 테이블 PK에 auto_increment 추가,  DATE -> DATETIME DEFAULT now() 변경
-- 수정 : 책 테이블 bnum auto_increment 추가