DROP TABLE IF EXISTS user;
CREATE TABLE user (
  id int(11) NOT NULL AUTO_INCREMENT,
  vorname varchar(20) NOT NULL,
  nachname varchar(20) NOT NULL,
  geschlechtw tinyint(1) NOT NULL,
  admin tinyint(1) NOT NULL DEFAULT 0,
  username varchar(20) NOT NULL,
  password varchar(255) NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO user (id, vorname, nachname, geschlechtw, admin, username, password) VALUES
(1,	'Sven',	'Haala',	0,	1,	'sven.haala',	'$2a$10$l9iGY8YEjstoKM.TFz17aOnTLW1vClZtu2EQOTFqrGZjRFOJ6nEES'),
(2,	'Tobias',	'Fritz',	0,	0,	'tobias.fritz',	'$2a$10$VHveNeWbf0SdmVljVBnQ3OexdYZAqIGOANz45tALmE0e3STL.Vo9e');