DROP TABLE IF EXISTS MOVIES;

INSERT INTO Movie (TITLE, YEAR_ESTABLISHED, USERINSERT, TIMEINSERT) VALUES
('TO KEFALAIO', '1867-09-25', 'EXADAKTYLOS', '2019-09-25');

INSERT INTO Movie (TITLE, YEAR_ESTABLISHED, USERINSERT, TIMEINSERT) VALUES
('KRATOS KAI EPANASTASH', '1917-09-25', 'EXADAKTYLOS', '2019-09-25');

INSERT INTO Movie (TITLE, YEAR_ESTABLISHED, USERINSERT, TIMEINSERT) VALUES
('AREIANARA', '1914-09-25', 'EXADAKTYLOS', '2019-09-25');



DROP TABLE IF EXISTS MOVIE_DETAILS;

INSERT INTO Details (DIRECTOR, DESC, USERINSERT, TIMEINSERT, MOVIE_ID) VALUES
('MARX', 'quia et suscipit suscipit recusandae consequuntur expedita et cum reprehenderit molestiae ut ut quas totam nostrum rerum est autem sunt rem eveniet architecto', 'EXADAKTYLOS', '2019-09-25', 1);

INSERT INTO Details (DIRECTOR, DESC, USERINSERT, TIMEINSERT, MOVIE_ID) VALUES
('LENIN', 'est rerum tempore vitae sequi sint nihil reprehenderit dolor beatae ea dolores neque fugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis qui aperiam non debitis possimus qui neque nisi nulla', 'EXADAKTYLOS', '2019-09-25', 2);

INSERT INTO Details (DIRECTOR, DESC, USERINSERT, TIMEINSERT, MOVIE_ID) VALUES
('PATSIMAS', 'et iusto sed quo iure voluptatem occaecati omnis eligendi aut ad voluptatem doloribus vel accusantium quis pariatur molestiae porro eius odio et labore et velit aut', 'EXADAKTYLOS', '2019-09-25', 3);




