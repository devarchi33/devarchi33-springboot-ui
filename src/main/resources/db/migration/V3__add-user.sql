CREATE TABLE users (username VARCHAR (100) NOT NULL PRIMARY KEY, encoded_password VARCHAR (255));
INSERT INTO users (username, encoded_password) VALUES ('user1', '$2a$10$slq.WcRqHtx7AQ68x.9puOvux/9L1MdE9kRhs5l4e/S7m1Gx/WAV6');
INSERT INTO users (username, encoded_password) VALUES ('user2', '$2a$10$slq.WcRqHtx7AQ68x.9puOvux/9L1MdE9kRhs5l4e/S7m1Gx/WAV6');
ALTER TABLE customers ADD username VARCHAR (100) NOT NULL DEFAULT 'user1';
ALTER TABLE customers ADD CONSTRAINT FK_CUSTOMERS_USERNAME FOREIGN KEY (username) REFERENCES users;