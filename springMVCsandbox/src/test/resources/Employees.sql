--<ScriptOptions statementTerminator=";"/>

ALTER TABLE EMPLOYEES DROP CONSTRAINT EMP_JOB_FK;

ALTER TABLE EMPLOYEES DROP CONSTRAINT EMP_MANAGER_FK;

ALTER TABLE EMPLOYEES DROP CONSTRAINT EMP_DEPT_FK;

ALTER TABLE EMPLOYEES DROP CONSTRAINT EMP_EMP_ID_PK;

DROP INDEX EMP_NAME_IX;

DROP INDEX EMP_MANAGER_IX;

DROP INDEX EMP_DEPARTMENT_IX;

DROP INDEX EMP_EMAIL_UK;

DROP INDEX EMP_JOB_IX;

DROP INDEX EMP_EMP_ID_PK;

DROP TABLE EMPLOYEES;

CREATE TABLE EMPLOYEES (
		EMPLOYEE_ID NUMBER(6 , 0) NOT NULL,
		FIRST_NAME VARCHAR2(20),
		LAST_NAME VARCHAR2(25) NOT NULL,
		EMAIL VARCHAR2(25) NOT NULL,
		PHONE_NUMBER VARCHAR2(20),
		HIRE_DATE DATE NOT NULL,
		JOB_ID VARCHAR2(10) NOT NULL,
		SALARY NUMBER(8 , 2),
		COMMISSION_PCT NUMBER(2 , 2),
		MANAGER_ID NUMBER(6 , 0),
		DEPARTMENT_ID NUMBER(4 , 0)
	);

CREATE INDEX EMP_NAME_IX ON EMPLOYEES (LAST_NAME ASC, FIRST_NAME ASC);

CREATE INDEX EMP_MANAGER_IX ON EMPLOYEES (MANAGER_ID ASC);

CREATE INDEX EMP_DEPARTMENT_IX ON EMPLOYEES (DEPARTMENT_ID ASC);

CREATE UNIQUE INDEX EMP_EMAIL_UK ON EMPLOYEES (EMAIL ASC);

CREATE INDEX EMP_JOB_IX ON EMPLOYEES (JOB_ID ASC);

CREATE UNIQUE INDEX EMP_EMP_ID_PK ON EMPLOYEES (EMPLOYEE_ID ASC);

ALTER TABLE EMPLOYEES ADD CONSTRAINT EMP_EMP_ID_PK PRIMARY KEY (EMPLOYEE_ID);

ALTER TABLE EMPLOYEES ADD CONSTRAINT EMP_JOB_FK FOREIGN KEY (JOB_ID)
	REFERENCES JOBS (JOB_ID)
	ON DELETE RESTRICT
	ON UPDATE CASCADE;

ALTER TABLE EMPLOYEES ADD CONSTRAINT EMP_MANAGER_FK FOREIGN KEY (MANAGER_ID)
	REFERENCES EMPLOYEES (EMPLOYEE_ID)
	ON DELETE RESTRICT
	ON UPDATE CASCADE;

ALTER TABLE EMPLOYEES ADD CONSTRAINT EMP_DEPT_FK FOREIGN KEY (DEPARTMENT_ID)
	REFERENCES DEPARTMENTS (DEPARTMENT_ID)
	ON DELETE RESTRICT
	ON UPDATE CASCADE;

