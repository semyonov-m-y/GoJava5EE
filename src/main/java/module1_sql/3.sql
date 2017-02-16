-- Find total salary for Java developers --

SELECT SUM(developers.salary) AS total_salary_of_java_developers
FROM developers, skills, developers_skills
WHERE developers.dev_id = developers_skills.dev_id
      AND skills.skill_id = developers_skills.skill_id
      AND skills.skill_name LIKE '%ava%'
GROUP BY skill_name;