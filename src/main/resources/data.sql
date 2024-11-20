INSERT INTO category ("CATEGORY_NAME") VALUES ('Fashion');
INSERT INTO category ("CATEGORY_NAME") VALUES ('Electronics');
INSERT INTO category ("CATEGORY_NAME") VALUES ('Books'); 
INSERT INTO category ("CATEGORY_NAME") VALUES ('Groceries');
INSERT INTO category ("CATEGORY_NAME") VALUES ('Medicines');

INSERT INTO users ("USERNAME", "PASSWORD") VALUES ('jack', '$2a$10$zljzifz96ONqWT57znKGZOwrO56CdP4Lz3dLoW6LakEjBrbTmSaDG');
INSERT INTO users ("USERNAME", "PASSWORD") VALUES ('bob', '$2a$10$zljzifz96ONqWT57znKGZOwrO56CdP4Lz3dLoW6LakEjBrbTmSaDG');
INSERT INTO users ("USERNAME", "PASSWORD") VALUES ('apple', '$2a$10$zljzifz96ONqWT57znKGZOwrO56CdP4Lz3dLoW6LakEjBrbTmSaDG'); 
INSERT INTO users ("USERNAME", "PASSWORD") VALUES ('glaxo', '$2a$10$zljzifz96ONqWT57znKGZOwrO56CdP4Lz3dLoW6LakEjBrbTmSaDG');

INSERT INTO roles ("NAME") VALUES ('CONSUMER');
INSERT INTO roles ("NAME") VALUES ('SELLER');

INSERT INTO cart ("TOTAL_AMOUNT", "USER_USER_ID") VALUES (20, 1);
INSERT INTO cart ("TOTAL_AMOUNT", "USER_USER_ID") VALUES (0, 2);

INSERT INTO USERS_ROLES ("USER_ID", "ROLES") VALUES (1, 'CONSUMER');
INSERT INTO USERS_ROLES ("USER_ID", "ROLES") VALUES (2, 'CONSUMER'); 
INSERT INTO USERS_ROLES ("USER_ID", "ROLES") VALUES (3, 'SELLER');
INSERT INTO USERS_ROLES ("USER_ID", "ROLES") VALUES (4, 'SELLER');

INSERT INTO PRODUCT ("PRICE", "PRODUCT_NAME", "CATEGORY_ID", "SELLER_ID") VALUES (29190, 'Apple iPad 10.2 8th Gen WiFi 10S Tablet', 2, 3); 
INSERT INTO PRODUCT ("PRICE", "PRODUCT_NAME", "CATEGORY_ID", "SELLER_ID") VALUES (18, 'Crocin pain relief tablet', 5, 4);

INSERT INTO CART_PRODUCT ("CART_ID", "PRODUCT_ID", "QUANTITY") VALUES (1, 2, 2);