-- The average developer`s salary in the cheapest project --
SELECT
  project_name,
  AVG(salary) AS average_dev_salary,
  COUNT(dev_id) AS numb_dev
FROM project
  INNER JOIN developers USING (project_id)
WHERE project_cost = (SELECT MIN(project_cost)
                      FROM project);