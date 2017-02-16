CREATE DATABASE  home_work1;
USE home_work1;

CREATE TABLE company (
  comp_id   INT AUTO_INCREMENT PRIMARY KEY,
  comp_name VARCHAR(30) NOT NULL
)
  ENGINE = InnoDB;

CREATE TABLE customer (
  cust_id   INT AUTO_INCREMENT PRIMARY KEY,
  cust_name VARCHAR(30)
)
  ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS project (
  project_id   INT AUTO_INCREMENT PRIMARY KEY,
  project_name VARCHAR(30) NOT NULL,
  comp_id      INT         NOT NULL,
  cust_id      INT         NOT NULL,
  FOREIGN KEY (comp_id) REFERENCES company (comp_id),
  FOREIGN KEY (cust_id) REFERENCES customer (cust_id)
)
  ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS developers(
  dev_id     INT AUTO_INCREMENT PRIMARY KEY,
  dev_name   VARCHAR(30) NOT NULL,
  project_id INT         NOT NULL,
  FOREIGN KEY (project_id) REFERENCES project (project_id)
)
  ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS skills (
  skill_id   INT AUTO_INCREMENT PRIMARY KEY,
  skill_name VARCHAR(30) NOT NULL
)
  ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS developers_skills (
  dev_id   INT NOT NULL,
  skill_id INT NOT NULL,
  PRIMARY KEY (dev_id, skill_id),
  FOREIGN KEY (dev_id) REFERENCES developers (dev_id),
  FOREIGN KEY (skill_id) REFERENCES skills (skill_id)
)
  ENGINE = InnoDB;