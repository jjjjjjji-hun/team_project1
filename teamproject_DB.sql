-- 유저 테이블
CREATE TABLE userinfo(
uid VARCHAR(20) PRIMARY KEY,
uname VARCHAR(10) NOT NULL,
upw VARCHAR(20) NOT NULL,
upnum VARCHAR(20) NOT NULL,
uemail VARCHAR(20) NOT NULL,
utype BOOL,
counting INT
);

SELECT * FROM userinfo;


-- 책 테이블
CREATE TABLE book(
bnum INT PRIMARY KEY,
bname VARCHAR(20) NOT NULL,
bwriter VARCHAR(20) NOT NULL,
bpub VARCHAR(20) NOT NULL,
bcategory VARCHAR(10) NOT NULL,
check_out BOOL
);

SELECT * FROM book;


-- 대여 테이블
CREATE TABLE rent(
rentnum INT PRIMARY KEY,
returnschedule DATE,
bnum INT NOT NULL,
uid VARCHAR(20) NOT NULL,
overdue BOOL
);

SELECT * FROM rent;


-- 반납 테이블
CREATE TABLE returnb(
returnnum INT PRIMARY KEY,
rentdate DATE,
returndate DATE,
bnum INT NOT NULL,
uid VARCHAR(20) NOT NULL
);

SELECT * FROM returnb;


-- 리뷰 테이블
CREATE TABLE review(
revnum INT PRIMARY KEY,
bnum INT NOT NULL,
uid VARCHAR(20) NOT NULL,
revtitle VARCHAR(20) NOT NULL,
revcontent VARCHAR(100) NOT NULL,
revdate DATE
);

SELECT * FROM review;
