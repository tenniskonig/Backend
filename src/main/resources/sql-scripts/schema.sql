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

DROP TABLE IF EXISTS game;
CREATE TABLE game (
  id int(11) NOT NULL AUTO_INCREMENT,
  player1Team1 int(11) NOT NULL,
  player2Team2 int(11) NOT NULL,
  player3Team1 int(11) DEFAULT NULL,
  player4Team2 int(11) DEFAULT NULL,
  results varchar(25) NOT NULL,
  gameSetTeam1 int(11) NOT NULL,
  gameSetTeam2 int(11) DEFAULT NULL,
  gameDate date DEFAULT NULL,
  playTime time DEFAULT NULL,
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS played;
create table played
(
  playedID int auto_increment
    primary key,
  GameID   int not null,
  UserID   int not null,
  Points   int not null,
  constraint Game
  foreign key (GameID) references game (id),
  constraint User
  foreign key (UserID) references user (id)
);

create index Game
  on played (GameID);

create index User
  on played (UserID);



INSERT INTO user (id, vorname, nachname, geschlechtw, admin, username, password) VALUES
(1,	'Sven',	'Haala',	0,	1,	'sven.haala',	'$2a$10$l9iGY8YEjstoKM.TFz17aOnTLW1vClZtu2EQOTFqrGZjRFOJ6nEES'),
(2,	'Tobias',	'Fritz',	0,	0,	'tobias.fritz',	'$2a$10$VHveNeWbf0SdmVljVBnQ3OexdYZAqIGOANz45tALmE0e3STL.Vo9e');


INSERT INTO game (id, player1Team1, player2Team2, player3Team1, player4Team2, results, gameSetTeam1, gameSetTeam2, gameDate, playTime) VALUES
(11,	1,	2,	0,	0,	'1:2;1:6;:',	0,	2,	'2018-12-12',	'00:00:00'),
(12,	1,	2,	0,	0,	'5:1;4:6;3:1',	2,	1,	'2018-12-12',	'00:00:00'),
(13,	2,	1,	0,	0,	':;:;:',	0,	0,	'2018-12-12',	'01:00:00'),
(14,	2,	1,	0,	0,	':;:;:',	0,	0,	'2018-12-12',	'00:15:00'),
(15,	2,	1,	0,	0,	':;:;:',	0,	0,	'2018-12-12',	'00:30:00'),
(16,	2,	1,	0,	0,	':;:;:',	0,	0,	'2018-12-12',	'00:15:00'),
(17,	2,	1,	0,	0,	':;:;:',	0,	0,	'2018-12-12',	'00:45:00');

INSERT INTO played (playedID, GameID, UserID, Points) VALUES
(15,	11,	1,	9),
(16,	11,	2,	5),
(17,	12,	2,	10),
(18,	12,	1,	10),
(21,	13,	2,	0),
(22,	14,	1,	0),
(23,	15,	1,	0);