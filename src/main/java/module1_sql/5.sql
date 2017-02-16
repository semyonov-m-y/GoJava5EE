-- Data updates --
INSERT INTO customer VALUES (NULL, 'OOO "Рога и Копыта"');
INSERT INTO customer VALUES (NULL, 'ФЛП Порох П.А');
INSERT INTO customer VALUES (NULL, 'Укртатнафта');

ALTER TABLE project
  CHANGE project_name project_name VARCHAR(60);
INSERT INTO project VALUES (NULL, 'Сомнительное приложение для отмывания денег', 3000, 1, 4);
INSERT INTO project VALUES (NULL, 'PersonSecurity app', 4000, 2, 5);
INSERT INTO project VALUES (NULL, 'Tracking management system', 6000, 3, 6);

INSERT INTO developers VALUES (NULL, 'John', 1400, 4);
INSERT INTO developers VALUES (NULL, 'Michele', 800, 5);
INSERT INTO developers VALUES (NULL, 'Andrea', 2100, 6);

INSERT INTO developers_skills VALUES (5, 2);
INSERT INTO developers_skills VALUES (5, 4);
INSERT INTO developers_skills VALUES (5, 5);
INSERT INTO developers_skills VALUES (6, 3);
INSERT INTO developers_skills VALUES (6, 4);
INSERT INTO developers_skills VALUES (6, 5);
INSERT INTO developers_skills VALUES (7, 1);
INSERT INTO developers_skills VALUES (7, 4);
INSERT INTO developers_skills VALUES (7, 5);


-- The main code of task --
CREATE VIEW ProjectCompany AS
  SELECT
    project_id,
    comp_name,
    project_name,
    project_cost
  FROM project
    INNER JOIN company USING (comp_id)
    INNER JOIN  customer USING (cust_id);


SELECT comp_name, project_name, project_cost
FROM ProjectCompany
WHERE project_cost IN(SELECT MIN(project_cost)FROM ProjectCompany GROUP BY comp_name);

-- ---------------OR-----------------
SELECT
  comp_name,
  project_name,
  project_cost AS lower_cost
FROM project
  INNER JOIN company USING (comp_id)
  INNER JOIN customer USING (cust_id)
WHERE project_cost IN (SELECT MIN(project_cost)
                       FROM project
                       GROUP BY project.comp_id);

