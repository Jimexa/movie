DROP TABLE IF EXISTS MOVIES;

INSERT INTO Movie (TITLE, YEAR_ESTABLISHED, USERINSERT, TIMEINSERT) VALUES
('Star Wars: A new hope', '1977-05-25', 'EXADAKTYLOS', '2019-09-25');

INSERT INTO Movie (TITLE, YEAR_ESTABLISHED, USERINSERT, TIMEINSERT) VALUES
('Star Wars: The Empire Strikes Back', '1980-09-25', 'EXADAKTYLOS', '2019-09-25');

INSERT INTO Movie (TITLE, YEAR_ESTABLISHED, USERINSERT, TIMEINSERT) VALUES
('Star Wars: Return of the Jedi', '1983-05-25', 'EXADAKTYLOS', '2019-09-25');



DROP TABLE IF EXISTS MOVIE_DETAILS;

INSERT INTO Details (DIRECTOR, DESC, USERINSERT, TIMEINSERT, MOVIE_ID) VALUES
('George Lucas', 'Luke Skywalker joins forces with a Jedi Knight, a cocky pilot, a Wookiee and two droids to save the galaxy from the Empire_s world-destroying battle station, while also attempting to rescue Princess Leia from the mysterious Darth Vader.', 'EXADAKTYLOS', '2019-09-25', 1);

INSERT INTO Details (DIRECTOR, DESC, USERINSERT, TIMEINSERT, MOVIE_ID) VALUES
('George Lucas', 'After the Rebels are brutally overpowered by the Empire on the ice planet Hoth, Luke Skywalker begins Jedi training with Yoda, while his friends are pursued by Darth Vader.', 'EXADAKTYLOS', '2019-09-25', 2);

INSERT INTO Details (DIRECTOR, DESC, USERINSERT, TIMEINSERT, MOVIE_ID) VALUES
('George Lucas', 'After a daring mission to rescue Han Solo from Jabba the Hutt, the Rebels dispatch to Endor to destroy the second Death Star. Meanwhile, Luke struggles to help Darth Vader back from the dark side without falling into the Emperor_s trap.', 'EXADAKTYLOS', '2019-09-25', 3);




