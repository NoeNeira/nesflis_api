DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL

);
CREATE TABLE newusers (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL

);

INSERT INTO users (first_name, last_name) VALUES
  ('Yazmin', 'Longas'),
  ('Noelia', 'Neira'),
  ('Nadia', 'Centanaro');



CREATE TABLE series (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  id_user VARCHAR(250) NOT NULL,
  title VARCHAR(250) NOT NULL
);
INSERT INTO series (id_user, title) VALUES
  ('1','Breaking Bad'),
  ('2','You'),
  ('3','You'),
  ('1','Strangers things');

CREATE TABLE movie (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  id_user VARCHAR(250) NOT NULL,
  title VARCHAR(250) NOT NULL,
);
INSERT INTO series (id_user,title) VALUES
  ('1','Titanic'),
  ('1','BraveHeart'),
  ('2','Mask');




