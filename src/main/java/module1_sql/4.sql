-- Create cost column in project table --
ALTER TABLE project
  ADD COLUMN project_cost REAL NOT NULL
  AFTER project_name;

-- Fill this column --

UPDATE project
SET project_cost = 10000
WHERE project_id = 1;

UPDATE project
SET project_cost = 30000
WHERE project_id = 2;

UPDATE project
SET project_cost = 25000
WHERE project_id = 3;