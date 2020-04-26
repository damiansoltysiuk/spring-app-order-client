create table address (
    id bigint not null auto_increment,
    country varchar(30),
    city varchar(40),
    street varchar(50),
    flat_no integer,
    user_id bigint,
    primary key (id)
) engine=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO address (country, city, street, flat_no, user_id) VALUES ('PL', 'Warsaw', 'Zlota', 5, 1);
INSERT INTO address (country, city, street, flat_no, user_id) VALUES ('RU', 'Moscow', 'Dvorcova', 15, 2);
INSERT INTO address (country, city, street, flat_no, user_id) VALUES ('DE', 'Berlin', 'K. Marks', 31, 3);
INSERT INTO address (country, city, street, flat_no, user_id) VALUES ('FR', 'Paris', 'Cauchy', 33, 4);