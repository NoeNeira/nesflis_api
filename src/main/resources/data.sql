
DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id VARCHAR(250) PRIMARY KEY,
  username VARCHAR(250) NOT NULL,
);
INSERT INTO users (id, username) VALUES
  ('1L','yaz'),
  ('2L','noe'),
  ('3L','nadia');

CREATE TABLE series (
  id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  id_user VARCHAR(250) NOT NULL,
  title VARCHAR(250) NOT NULL,
  FOREIGN KEY (id_user) REFERENCES Users(id)
);
INSERT INTO series (id_user, title) VALUES
  ('1L','Breaking Bad'),
  ('2L','You');

CREATE TABLE movie (
  id INT AUTO_INCREMENT  PRIMARY KEY NOT NULL,
  id_user VARCHAR(250)  NOT NULL,
  title VARCHAR(250) NOT NULL,
  FOREIGN KEY (id_user) REFERENCES Users(id)
);
INSERT INTO movie (id_user,title) VALUES
  ('1L','Titanic'),
  ('3L','BraveHeart'),
  ('2L','Mask');

CREATE TABLE contenidoVistoPorUsuario (
   id VARCHAR(250) PRIMARY KEY NOT NULL,
   id_user VARCHAR(250) NOT NULL,
   title VARCHAR(250) NOT NULL,
   FOREIGN KEY (id_user) REFERENCES Users(id)
);
INSERT INTO contenidoVistoPorUsuario (id, id_user, title) values
    ('1LTITANIC', '1L','Titanic'),
    ('1LBREAKING','1L','Breaking Bad'),
    ('1LBRAVEHEART','1L','Brave heart'),
    ('2LMASK','2L','Mask'),
    ('2LYOU','2L','You'),
    ('2LSTRANGER','2L','Stranger things'),
    ('3LTITANIC','3L','Titanic'),
    ('3LYOU','3L','You'),
    ('3LBRAVEHEART','3L','Brave heart');