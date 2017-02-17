-- Create cost column in project table --
ALTER TABLE projects
  ADD COLUMN project_cost REAL NOT NULL
  AFTER project_name;

-- Fill this column --

UPDATE projects
SET project_cost = 10000
WHERE project_id = 1;

UPDATE projects
SET project_cost = 30000
WHERE project_id = 2;

UPDATE projects
SET project_cost = 25000
WHERE project_id = 3;