CREATE TABLE users (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  username varchar(30) NOT NULL,
  first_name varchar(50) NOT NULL,
  last_name varchar(50) DEFAULT NULL,
  email varchar(50),
  PRIMARY KEY (id),
  UNIQUE KEY UK_username (username)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO users (username, first_name, last_name, email) VALUES ('kowalskij', 'Jan', 'Kowalski', 'jkowalski@ex.ex');
INSERT INTO users (username, first_name, last_name, email) VALUES ('nowaka', 'Andrzej', 'Nowak', 'anokaw@ex.ex');
INSERT INTO users (username, first_name, last_name, email) VALUES ('portmann', 'Natalie', 'Portman', 'nportman@ex.ex');
INSERT INTO users (username, first_name, last_name, email) VALUES ('leonP', 'Leon', 'The Proffesional', 'leonp@ex.ex');