CREATE TABLE tb_payment (
     payment_id bigint(20) NOT NULL AUTO_INCREMENT,
     value_payment decimal(19,2) NOT NULL,
     name varchar(100) DEFAULT NULL,
     number_payment varchar(19) DEFAULT NULL,
     expiration varchar(7) DEFAULT NULL,
     code varchar(3) DEFAULT NULL,
     status_payment varchar(255) NOT NULL,
     payment_form_id bigint(20) NOT NULL,
     order_id bigint(20) NOT NULL,
PRIMARY KEY (payment_id)
);