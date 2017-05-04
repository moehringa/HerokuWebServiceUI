INSERT INTO customers(first_name, last_name) VALUES ('JOHN','HOPKINS');
INSERT INTO customers(first_name,last_name) VALUES ('DAN', 'DENTINGER');
INSERT INTO customers(first_name,last_name) VALUES ('DAN', 'THEMAN');
INSERT INTO customers(first_name,last_name) VALUES ('JOHN', 'DOE');

insert into orders(order_id, customer_id) values ('1', 2);
insert into orders(order_id, customer_id) values ('2', 2);
insert into orders(order_id, customer_id) values ('3', 3);

insert into order_detail(order_id, quantity, product) values ('1', 2,'food');
insert into order_detail(order_id, quantity, product) values ('1', 3,'drinks');
insert into order_detail(order_id, quantity, product) values ('2', 300,'stuff');