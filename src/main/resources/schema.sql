DROP TABLE customers IF EXISTS;
CREATE TABLE customers(id IDENTITY PRIMARY KEY, first_name VARCHAR(255), last_name VARCHAR(255));

DROP TABLE orders IF exists;
CREATE TABLE orders(id IDENTITY PRIMARY KEY, order_id varchar(255), customer_id INT );

DROP TABLE order_detail if exists;
CREATE TABLE order_detail(id IDENTITY PRIMARY KEY, order_id varchar(255), quantity INT, product varchar(255));
