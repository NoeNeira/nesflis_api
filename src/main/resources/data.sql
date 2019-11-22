DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id VARCHAR(250)  PRIMARY KEY,
  username VARCHAR(250) NOT NULL,

);
INSERT INTO users (id, username) VALUES
  ('1L','yaz'),
  ('2L','noe'),
  ('3L','nadia');

CREATE TABLE series (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  id_user VARCHAR(250) NOT NULL,
  title VARCHAR(250) NOT NULL
);
INSERT INTO series (id_user, title) VALUES
  ('1L','Breaking Bad'),
  ('2L','You'),
  ('3L','You'),
  ('1L','Strangers things');

CREATE TABLE movie (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  id_user VARCHAR(250) NOT NULL,
  title VARCHAR(250) NOT NULL,
);
INSERT INTO series (id_user,title) VALUES
  ('1L','Titanic'),
  ('1L','BraveHeart'),
  ('2L ','Mask');




