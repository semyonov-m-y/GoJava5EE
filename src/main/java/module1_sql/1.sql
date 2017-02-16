-- Create salary column --
ALTER TABLE developers
  ADD COLUMN
  salary REAL AFTER dev_name;

-- Fill this column --
UPDATE developers SET  salary = 1500 WHERE dev_id = 1;
UPDATE developers SET  salary = 1800 WHERE dev_id = 2;
UPDATE developers SET  salary = 2000 WHERE dev_id = 3;
UPDATE developers SET  salary = 1300 WHERE dev_id = 4;

