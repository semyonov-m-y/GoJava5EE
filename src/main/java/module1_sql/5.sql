

-- The main code of task --
CREATE VIEW ProjectCompany AS
  SELECT
    project_id,
    comp_name,
    project_name,
    project_cost
  FROM projects
    INNER JOIN companies USING (comp_id)
    INNER JOIN customers USING (cust_id);


SELECT
  comp_name,
  project_name,
  project_cost
FROM ProjectCompany
WHERE project_cost IN (SELECT MIN(project_cost)
                       FROM ProjectCompany
                       GROUP BY comp_name);

-- ---------------OR-----------------
SELECT
  comp_name,
  project_name,
  project_cost AS lower_cost
FROM projects
  INNER JOIN companies USING (comp_id)
  INNER JOIN customers USING (cust_id)
WHERE project_cost IN (SELECT MIN(project_cost)
                       FROM projects
                       GROUP BY projects.comp_id);

