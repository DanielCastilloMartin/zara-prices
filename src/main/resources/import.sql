
INSERT INTO BRAND(id, name, description) values (1, 'Zara', 'Esta tienda es la principal de la marca');
INSERT INTO BRAND(id, name, description) values (2, 'Pull and Bear', 'Esta tienda tiene un oso');
INSERT INTO BRAND(id, name, description) values (3, 'Berska', 'Esta tienda es de los chnis');

INSERT INTO PRICE_LIST(id, name, description) values (1, 'Tarifa 1', 'Tarifa Navidad');
INSERT INTO PRICE_LIST(id, name, description) values (2, 'Tarifa 2', 'Tarifa NocheVieja');
INSERT INTO PRICE_LIST(id, name, description) values (3, 'Tarifa 3', 'Tarifa Nochebuena');
INSERT INTO PRICE_LIST(id, name, description) values (4, 'Tarifa 4', 'Tarifa A;o nuevo');

INSERT INtO PRODUCT(id, name, description) values(35455, 'Product 34555', null);
INSERT INTO PRODUCT(id, name, description) values(34556, 'Product 34556', null);
INSERT INTO PRODUCT(id, name, description) values(34557, 'Product 34557', null);

INSERT INTO PRICES (id, brand_id, start_date, end_date, price_list_id, product_id, priority, price, currency) VALUES (1, 1, '2020-06-14 00:00:00', '2020-12-31 23:59:59', 1, 35455, 0, 35.50, 'EUR');
INSERT INTO PRICES (id, brand_id, start_date, end_date, price_list_id, product_id, priority, price, currency) VALUES (2, 1, '2020-06-14 15:00:00', '2020-06-14 18:30:00', 2, 35455, 1, 25.45, 'EUR');
INSERT INTO PRICES (id, brand_id, start_date, end_date, price_list_id, product_id, priority, price, currency) VALUES (3, 1, '2020-06-15 00:00:00', '2020-06-15 11:00:00', 3, 35455, 1, 30.50, 'EUR');
INSERT INTO PRICES (id, brand_id, start_date, end_date, price_list_id, product_id, priority, price, currency) VALUES (4, 1, '2020-06-15 16:00:00', '2020-12-31 23:59:59', 4, 35455, 1, 38.95, 'EUR');