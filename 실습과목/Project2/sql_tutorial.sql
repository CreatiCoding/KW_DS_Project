DROP DATABASE IF EXISTS sql_tutorial;
CREATE DATABASE sql_tutorial;
USE sql_tutorial;

CREATE TABLE userTbl( -- 회원 테이블
	userID	 CHAR(8) NOT NULL PRIMARY KEY,  -- 기본키
    name 	 VARCHAR(10) NOT NULL,
    birthYear	INT NOT NULL,
    addr 	 CHAR(2) NOT NULL,
    mobile1  CHAR(3), -- 휴대폰의 국번(011, 016, 017, 018 등)
    mobile2	 CHAR(8), -- 휴대폰의 나머지 전화번호
    height	 SMALLINT, -- 키
    mDate	 DATE -- 회원 가입일 
);
CREATE TABLE buyTbl( 
	num		    INT AUTO_INCREMENT NOT NULL PRIMARY KEY, 
    userID      CHAR(8) NOT NULL, 
    prodName	CHAR(6) NOT NULL,
    groupName 	CHAR(4) ,
    price		INT NOT NULL,
    amount		SMALLINT NOT NULL,
    FOREIGN KEY (userID) REFERENCES userTbl(userID) 
);

INSERT INTO userTbl   (userID, name, birthYear, addr, mobile1, mobile2, height, mDate) 
					VALUES('LSG','이승기', 1987, '서울', '011','1111111', 182,'2008-08-08');
INSERT INTO userTbl VALUES('KBS','김범수', 1979, '경남', '011','2222222', 173,'2012-04-04');
INSERT INTO userTbl VALUES('KHH','김경호', 1971, '전남', '019','3333333', 177,'2007-07-07');
INSERT INTO userTbl VALUES('JYP','조용필', 1950, '경기', '011','4444444', 166,'2009-04-04');
INSERT INTO userTbl VALUES('SSK','성시경', 1979, '서울',  NULL,     NULL, 186,'2013-12-12');
INSERT INTO userTbl VALUES('LJB','임재범', 1963, '서울', '016','6666666', 182,'2009-09-09');
INSERT INTO userTbl VALUES('YJS','윤종신', 1969, '경남',  NULL,     NULL, 170,'2005-05-05');
INSERT INTO userTbl VALUES('EJW','은지원', 1978, '경북', '011','8888888', 174,'2014-03-03');
INSERT INTO userTbl VALUES('JKW','조관우', 1965, '경기', '018','9999999', 172,'2010-10-10');
INSERT INTO userTbl VALUES('BBK','바비킴', 1973, '서울', '011','0000000', 176,'2013-05-05');

INSERT INTO buyTbl VALUES(NULL, 'KBS', '운동화', NULL, 30, 2);
INSERT INTO buyTbl VALUES(NULL, 'KBS', '노트북', '전자', 1000, 1);
INSERT INTO buyTbl VALUES(NULL, 'JYP', '모니터', '전자', 200, 1);
INSERT INTO buyTbl VALUES(NULL, 'BBK', '모니터', '전자', 200, 5);
INSERT INTO buyTbl VALUES(NULL, 'KBS', '청바지', '의류', 50, 3);
INSERT INTO buyTbl VALUES(NULL, 'BBK', '메모리', '전자', 80, 10);
INSERT INTO buyTbl VALUES(NULL, 'SSK', '책', '서적', 15, 5);
INSERT INTO buyTbl VALUES(NULL, 'EJW', '책', '서적', 15, 2);
INSERT INTO buyTbl VALUES(NULL, 'EJW', '청바지', '의류', 50, 1);
INSERT INTO buyTbl VALUES(NULL, 'BBK', '운동화', NULL, 30, 2);
INSERT INTO buyTbl VALUES(NULL, 'EJW', '책', '서적', 15, 1);
INSERT INTO buyTbl VALUES(NULL, 'BBK', '운동화', NULL, 30, 2);