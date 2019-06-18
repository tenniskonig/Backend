DROP TABLE IF EXISTS user;
CREATE TABLE user
(
  id          int(11)      NOT NULL AUTO_INCREMENT,
  firstName   varchar(20)  NOT NULL,
  lastName    varchar(20)  NOT NULL,
  geschlechtw tinyint(1)   NOT NULL,
  admin       tinyint(1)   NOT NULL DEFAULT 0,
  username    varchar(20)  NOT NULL,
  password    varchar(255) NOT NULL,
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS game;
CREATE TABLE game
(
    id           int(11)     NOT NULL AUTO_INCREMENT,
    player1Team1 int(11)     NOT NULL,
    player2Team2 int(11)     NOT NULL,
    player3Team1 int(11) DEFAULT NULL,
    player4Team2 int(11) DEFAULT NULL,
    results      varchar(25),
    gameSetTeam1 int(11),
    gameSetTeam2 int(11),
    gameDate     date NOT NULL,
    playTime     time,
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



INSERT INTO user (id, firstName, lastName, geschlechtw, admin, username, password)
VALUES (1, 'Sven', 'Haala', 0, 1, 'sven.haala', '$2a$10$l9iGY8YEjstoKM.TFz17aOnTLW1vClZtu2EQOTFqrGZjRFOJ6nEES'),
       (2, 'Tobias', 'Fritz', 0, 0, 'tobias.fritz', '$2a$10$VHveNeWbf0SdmVljVBnQ3OexdYZAqIGOANz45tALmE0e3STL.Vo9e'),
       (3, 'Marvin', 'Kubik', 0, 0, 'marvin.kubik', '$2a$10$VHveNeWbf0SdmVljVBnQ3OexdYZAqIGOANz45tALmE0e3STL.Vo9e'),
       (4, 'Dani', 'Schädler', 1, 0, 'dani.schaedler', '$2a$10$VHveNeWbf0SdmVljVBnQ3OexdYZAqIGOANz45tALmE0e3STL.Vo9e'),
       (5, 'Jonas', 'Seydel', 0, 0, 'jonas.seydel', '$2a$10$VHveNeWbf0SdmVljVBnQ3OexdYZAqIGOANz45tALmE0e3STL.Vo9e'),
       (6, 'Anta', 'Wellblech', 1, 1, 'bernd.wellblech', '$2a$10$VHveNeWbf0SdmVljVBnQ3OexdYZAqIGOANz45tALmE0e3STL.Vo9e');


INSERT INTO game (id, player1Team1, player2Team2, player3Team1, player4Team2, results, gameSetTeam1, gameSetTeam2,
                  gameDate, playTime)
VALUES (11, 1, 2, NULL, NULL, '1:4;2:4;:', 0, 2, '2018-12-12', '00:00:00'),
       (12, 1, 2, NULL, NULL, '5:3;2:4;4:1', 2, 1, '2018-12-12', '00:00:00'),
       (13, 2, 0, NULL, NULL, NULL, NULL, NULL, '2018-12-12', '01:00:00'),
       (14, 2, 0, NULL, NULL, NULL, NULL, NULL, '2018-12-15', '00:15:00'),
       (15, 1, 0, NULL, NULL, NULL, NULL, NULL, '2018-12-12', '00:30:00'),
       (16, 5, 0, NULL, NULL, NULL, NULL, NULL, '2018-12-21', '00:15:00'),
       (17, 4, 0, NULL, NULL, NULL, NULL, NULL, '2018-12-28', '00:45:00'),
       (18, 3, 2, 4, 1, '4:2;1:4;5:3', 2, 1, '2019-05-05', '00:00:00'),
       (19, 5, 1, 3, 2, '3:5;2:4;:', 0, 2, '2019-05-25', '00:00:00'),
       (20, 4, 3, NULL, NULL, '5:3;2:4;4:1', 2, 1, '2019-06-12', '00:00:00');

INSERT INTO played (playedID, GameID, UserID, Points)
VALUES (14, 11, 1, 5),
       (15, 11, 2, 9),
       (16, 12, 1, 5),
       (17, 12, 2, 9),
       (18, 13, 2, 2),
       (21, 14, 2, 2),
       (22, 15, 1, 2),
       (23, 16, 5, 2),
       (24, 17, 4, 2),
       (25, 18, 3, 14),
       (26, 18, 2, 14),
       (27, 18, 4, 12),
       (28, 18, 1, 10),
       (29, 19, 5, 10),
       (30, 19, 1, 10),
       (31, 19, 3, 14),
       (32, 19, 2, 14),
       (33, 20, 4, 11),
       (34, 20, 3, 5);