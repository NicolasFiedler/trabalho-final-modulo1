-- -----------------------------------------------------
-- Schema DONATOR_PROJECT
-- -----------------------------------------------------
CREATE USER DONATOR_PROJECT IDENTIFIED BY oracle;
GRANT CONNECT TO DONATOR_PROJECT;
GRANT CONNECT, RESOURCE, DBA TO DONATOR_PROJECT;
GRANT CREATE SESSION TO DONATOR_PROJECT;
GRANT DBA TO DONATOR_PROJECT;
GRANT CREATE VIEW, CREATE PROCEDURE, CREATE SEQUENCE to DONATOR_PROJECT;
GRANT UNLIMITED TABLESPACE TO DONATOR_PROJECT;
GRANT CREATE MATERIALIZED VIEW TO DONATOR_PROJECT;
GRANT CREATE TABLE TO DONATOR_PROJECT;
GRANT GLOBAL QUERY REWRITE TO DONATOR_PROJECT;
GRANT SELECT ANY TABLE TO DONATOR_PROJECT;

-- -----------------------------------------------------
-- Table DONATOR_PROJECT.CATEGORY
-- -----------------------------------------------------
CREATE TABLE  DONATOR_PROJECT.CATEGORY (
  id_category NUMBER NOT NULL AUTO_INCREMENT,
  name VARCHAR2(45) UNIQUE NOT NULL,
  category_description VARCHAR2(100) NULL,
  
  PRIMARY KEY (id_category)
);


-- -----------------------------------------------------
-- Table DONATOR_PROJECT.DONATE
-- -----------------------------------------------------
CREATE TABLE  DONATOR_PROJECT.DONATE (
  id_donate NUMBER NOT NULL AUTO_INCREMENT,
  donator_name VARCHAR2(45) NOT NULL,
  donator_email VARCHAR2(70) NOT NULL,
  donate_value NUMBER NOT NULL,
  donate_description VARCHAR2(2000),
  
  PRIMARY KEY (id_donate)
);


-- -----------------------------------------------------
-- Table DONATOR_PROJECT.BANK_ACCOUNT
-- -----------------------------------------------------
CREATE TABLE  DONATOR_PROJECT.BANK_ACCOUNT (
  id_bank_account NUMBER NOT NULL AUTO_INCREMENT,
  account_number VARCHAR2(7) NOT NULL,
  agency VARCHAR2(4) NOT NULL,
  
  PRIMARY KEY (id_bank_account)
);


-- -----------------------------------------------------
-- Table DONATOR_PROJECT.USER
-- -----------------------------------------------------
CREATE TABLE  DONATOR_PROJECT.USER (
  id_user NUMBER NOT NULL AUTO_INCREMENT,
  name VARCHAR2(45) NOT NULL,
  email VARCHAR2(70) NOT NULL,
  password VARCHAR2(2000) NOT NULL,
  
  PRIMARY KEY (id_user)
);


-- -----------------------------------------------------
-- Table DONATOR_PROJECT.REQUEST
-- -----------------------------------------------------
CREATE TABLE  DONATOR_PROJECT.REQUEST (
  id_request NUMBER NOT NULL, -- AUTO-IMCREMENT
  title VARCHAR2(45) NOT NULL,
  request_description VARCHAR2(2000) NOT NULL,
  goal NUMBER NOT NULL,
  reached_value NUMBER NOT NULL DEFAULT 0.0,
  id_category NUMBER NOT NULL,
  id_bank_account NUMBER NOT NULL,
  id_donate NUMBER NOT NULL,
  id_user NUMBER NOT NULL,
  
  PRIMARY KEY (id_request, id_category, id_bank_account, id_donate, id_user),
  CONSTRAINT fk_Request_Category
    FOREIGN KEY (id_category)
    REFERENCES DONATOR_PROJECT.CATEGORY (id_category),
  CONSTRAINT fk_Request_BankAccount1
    FOREIGN KEY (id_bank_account)
    REFERENCES DONATOR_PROJECT.BANK_ACCOUNT (id_bank_account),
  CONSTRAINT fk_Request_Donate1
    FOREIGN KEY (id_donate)
    REFERENCES DONATOR_PROJECT.DONATE (id_donate),
  CONSTRAINT fk_REQUEST_USER1
    FOREIGN KEY (id_user)
    REFERENCES DONATOR_PROJECT.USER (id_user)
);


-- -----------------------------------------------------
-- Table DONATOR_PROJECT.PERSON
-- -----------------------------------------------------
CREATE TABLE  DONATOR_PROJECT.PERSON (
  id_user NUMBER NOT NULL,
  cpf VARCHAR2(14) UNIQUE NOT NULL,
  
  PRIMARY KEY (id_user),
  CONSTRAINT fk_Person_User1
    FOREIGN KEY (id_user)
    REFERENCES DONATOR_PROJECT.USER (id_user)
);


-- -----------------------------------------------------
-- Table DONATOR_PROJECT.INSTITUTION
-- -----------------------------------------------------
CREATE TABLE  DONATOR_PROJECT.INSTITUTION (
  id_user NUMBER NOT NULL,
  cnpj VARCHAR2(18) UNIQUE NOT NULL,
  
  PRIMARY KEY (id_user),
  CONSTRAINT fk_Institution_User1
    FOREIGN KEY (id_user)
    REFERENCES DONATOR_PROJECT.USER (id_user)
);
