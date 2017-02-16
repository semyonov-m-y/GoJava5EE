-- The most expensive project --
SELECT project_name,  sum(developers.salary) AS dev_salary FROM project LEFT JOIN developers
    ON project.project_id = developers.project_id
GROUP BY project_name ORDER BY dev_salary DESC LIMIT 1;