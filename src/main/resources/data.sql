INSERT INTO customer (first_name, last_name, password, username) VALUES ('test', 'test', 'test', 'test');
INSERT INTO role (title) VALUES ('ROLE_ADMIN');
INSERT INTO role (title) VALUES ('ROLE_USER');
INSERT INTO customer_role (customer_id, role_id) VALUES (1, 1);
SELECT * FROM customer;