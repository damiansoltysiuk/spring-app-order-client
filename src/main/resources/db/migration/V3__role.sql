create table role (
    id bigint not null auto_increment,
    description varchar(200),
    role varchar(20),
    role_id bigint,
    primary key (id)
) engine=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO role (description, role, role_id) VALUES ('Normal user', 'USER', 1);
INSERT INTO role (description, role, role_id) VALUES ('Normal user', 'USER', 3);
INSERT INTO role (description, role, role_id) VALUES ('Grand user', 'SUPERUSER', 2);
INSERT INTO role (description, role, role_id) VALUES ('Full access', 'ADMIN', 4);
INSERT INTO role (description, role, role_id) VALUES ('Can read article', 'READER', 1);
INSERT INTO role (description, role, role_id) VALUES ('Can read article', 'READER', 2);
INSERT INTO role (description, role, role_id) VALUES ('Can read article', 'READER', 3);
INSERT INTO role (description, role, role_id) VALUES ('Can read article', 'READER', 4);
INSERT INTO role (description, role, role_id) VALUES ('Can write article', 'WRITER', 1);
INSERT INTO role (description, role, role_id) VALUES ('Can write article', 'WRITER', 4);
