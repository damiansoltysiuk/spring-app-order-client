create table product (
    id bigint not null auto_increment,
    description varchar(200),
    name varchar(50),
    prize float,
    product_order_id bigint,
    primary key (id)
) engine=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO product (description, name, prize, product_order_id) VALUES ('Candy', 'Mars', 1.99, 1);
INSERT INTO product (description, name, prize, product_order_id) VALUES ('Candy', 'Snickers', 2.99, 1);
INSERT INTO product (description, name, prize, product_order_id) VALUES ('Alcohol', 'Łomża', 2.49, 1);
INSERT INTO product (description, name, prize, product_order_id) VALUES ('Alcohol', 'Wyborowa', 31.99, 2);
