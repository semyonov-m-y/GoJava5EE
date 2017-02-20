-- Fill the company table --
INSERT INTO companies (comp_name) VALUES ('NIX Solution'),
  ('SOFT WARE dev'),
  ('ORACLE');

-- Fill the customers table --
INSERT INTO customers (cust_name) VALUES ('EPAM'),
  ('CIKLUM'),
  ('Privat Bank');
-- Fill the project table --
INSERT INTO projects (project_name, comp_id, cust_id) VALUES
  ('\"TNK\"corp. Finance tools', 1, 1),
  ('GoIT phone application', 2, 2),
  ('Times stat', 3, 3);

-- Fill the developers table--
INSERT INTO developers (dev_name, project_id) VALUES
  ('Denys', 1),
  ('Nick', 2),
  ('Joe', 3),
  ('Roman', 1);

-- Fill the skills table--
INSERT INTO skills (skill_name) VALUES
  ('Java'),
  ('C++'),
  ('C#'),
  ('Maven'),
  ('Tomcat');

-- Fill the developers skills table--
INSERT INTO developers_skills (dev_id, skill_id) VALUES (1, 1),
  (1, 4),
  (1, 5),
  (2, 2),
  (2, 4),
  (2, 5),
  (3, 3),
  (3, 4),
  (3, 5),
  (4, 1),
  (4, 4),
  (4, 5);

-- PAY ATTENTION! YOU MUST TO UPDATE DATA AFTER YOU RUN 4.sql FILE --
-- Data updates --
INSERT INTO customers (cust_name) VALUES
  ('OOO "Рога и Копыта"'),
  ('ФЛП Порох П.А'),
  ('Укртатнафта');


INSERT INTO projects (project_name, project_cost, comp_id, cust_id) VALUES
  ('Сомнительное приложение для отмывания денег', 3000, 1, 4),
  ('PersonSecurity app', 4000, 2, 5),
  ('Tracking management system', 6000, 3, 6);

INSERT INTO developers (dev_name, salary, project_id) VALUES
  ('John', 1400, 4),
  ('Michele', 800, 5),
  ('Andrea', 2100, 6);

INSERT INTO developers_skills (dev_id, skill_id) VALUES
  (5, 2),
  (5, 4),
  (5, 5),
  (6, 3),
  (6, 4),
  (6, 5),
  (7, 1),
  (7, 4),
  (7, 5);
  
 -- PAY ATTENTION! YOU MUST TO UPDATE DATA BEFORE YOU RUN 5.sql FILE -- 
 -- UPDATE DATA
INSERT INTO projects (project_name, project_cost, comp_id, cust_id) VALUES
  ('Тесты для Java Junior', 100, 1, 1),
  ('Тесты для Objective-C Junior', 150, 1, 1);
