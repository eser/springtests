CREATE TABLE team (
 id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
 name VARCHAR(200)
);

CREATE TABLE matchscore (
 id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
 hometeam INT,
 homescore INT,
 awayteam INT,
 awayscore INT
);
