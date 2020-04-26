CREATE TABLE cart (
	id BIGINT auto_increment NOT NULL,
	order_date DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
	user_id BIGINT NOT NULL,
	primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO cart (user_id) VALUE (1);
INSERT INTO cart (user_id) VALUE (2);