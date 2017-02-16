-- Fill the company table --
INSERT INTO company VALUES (NULL, 'NIX Solution');
INSERT INTO company VALUES (NULL, 'SOFT WARE dev');
INSERT INTO company VALUES (NULL, 'ORACLE');

-- Fill the customers table --
INSERT INTO customer VALUES (NULL, 'EPAM');
INSERT INTO customer VALUES (NULL, 'CIKLUM');
INSERT INTO customer VALUES (NULL, 'Privat Bank');

-- Fill the project table --
INSERT INTO project VALUES (NULL, '\"TNK\"corp. Finance tools', 1, 1);
INSERT INTO project VALUES (NULL, 'GoIT phone application', 2, 2);
INSERT INTO project VALUES (NULL, 'Times stat', 3, 3);

-- Fill the developers table--
INSERT INTO developers VALUES (NULL, 'Denys', 1);
INSERT INTO developers VALUES (NULL, 'Nick', 2);
INSERT INTO developers VALUES (NULL, 'Joe', 3);
INSERT INTO developers VALUES (NULL, 'Roman', 1);

-- Fill the skills table--
INSERT INTO skills VALUES (NULL, 'Java');
INSERT INTO skills VALUES (NULL, 'C++');
INSERT INTO skills VALUES (NULL, 'C#');
INSERT INTO skills VALUES (NULL, 'Maven');
INSERT INTO skills VALUES (NULL, 'Tomcat');

-- Fill the developers skills table--
INSERT INTO developers_skills VALUES (1, 1);
INSERT INTO developers_skills VALUES (1, 4);
INSERT INTO developers_skills VALUES (1, 5);
INSERT INTO developers_skills VALUES (2, 2);
INSERT INTO developers_skills VALUES (2, 4);
INSERT INTO developers_skills VALUES (2, 5);
INSERT INTO developers_skills VALUES (3, 3);
INSERT INTO developers_skills VALUES (3, 4);
INSERT INTO developers_skills VALUES (3, 5);
INSERT INTO developers_skills VALUES (4, 1);
INSERT INTO developers_skills VALUES (4, 4);
INSERT INTO developers_skills VALUES (4, 5);