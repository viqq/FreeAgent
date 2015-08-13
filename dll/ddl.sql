CREATE TABLE USER (
  USER_ID BIGINT(20) NOT NULL AUTO_INCREMENT,
  LOGIN VARCHAR(20) NOT NULL,
  PASSWORD VARCHAR(20) NOT NULL,
  CITY VARCHAR(20) NULL DEFAULT NULL,
  EMAIL VARCHAR(50) NULL DEFAULT NULL,
  ROLE VARCHAR(10) NOT NULL,
  GENDER VARCHAR(10) NOT NULL,
  DESCRIPTION VARCHAR(250) NULL DEFAULT NULL,
  FIRST_NAME VARCHAR(25) NULL DEFAULT NULL,
  LAST_NAME VARCHAR(25) NULL DEFAULT NULL,
  PHONE VARCHAR(25) NULL DEFAULT NULL,
  DATE_OF_BIRTH DATE NOT NULL,
  IMAGE VARCHAR(50) NULL DEFAULT NULL,
  DATE_OF_REGISTRATION DATE NOT NULL,
  PRIMARY KEY (USER_ID)
);


CREATE TABLE SPORT (
  SPORT_ID BIGINT(20) NOT NULL AUTO_INCREMENT,
  NAME VARCHAR(20) NOT NULL,
  IMAGE VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (SPORT_ID)
);


CREATE TABLE MESSAGE (
  MESSAGE_ID BIGINT(20) NOT NULL AUTO_INCREMENT,
  AUTHOR VARCHAR(20) NOT NULL,
  TITLE VARCHAR(20) NULL DEFAULT NULL,
  TEXT VARCHAR(20) NULL DEFAULT NULL,
  TIME_OF_CREATE DATE NOT NULL,
  TIME_OF_READ DATE NULL DEFAULT NULL,
  USER_ID BIGINT(20) NOT NULL,
  PRIMARY KEY (MESSAGE_ID),
  INDEX FK_DEPT (USER_ID),
  CONSTRAINT FK_DEPT FOREIGN KEY (USER_ID) REFERENCES USER (USER_ID)
);


CREATE TABLE USER_SPORT (
  USER_ID BIGINT(20) NOT NULL,
  SPORT_ID BIGINT(20) NOT NULL,
  PRIMARY KEY (USER_ID, SPORT_ID),
  INDEX FK_SPORT (SPORT_ID),
  CONSTRAINT FK_USER FOREIGN KEY (USER_ID) REFERENCES USER (USER_ID),
  CONSTRAINT FK_SPORT FOREIGN KEY (SPORT_ID) REFERENCES SPORT (SPORT_ID)
);

