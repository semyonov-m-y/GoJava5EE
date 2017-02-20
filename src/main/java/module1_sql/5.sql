-- The main code of task --
CREATE VIEW  total_cost_by_every_customer AS
  SELECT cust_name,comp_name,SUM(project_cost) as total, COUNT(project_id) as projectNumb
  FROM projects
    INNER JOIN customers USING (cust_id)
    INNER JOIN companies USING  (comp_id)
  GROUP BY cust_id ORDER BY comp_id;

SELECT
  cust_name,
  comp_name
FROM total_cost_by_every_customer
WHERE total IN (SELECT min(total)
                FROM total_cost_by_every_customer
                GROUP BY comp_name);

