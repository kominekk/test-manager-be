DROP TABLE IF EXISTS TESTS;

CREATE TABLE TESTS (
  ID INT AUTO_INCREMENT  PRIMARY KEY,
  NAME VARCHAR(100) NOT NULL,
  DESCRIPTION VARCHAR(250) NOT NULL,
  EXECUTION_STATUS VARCHAR(100) DEFAULT NULL
);