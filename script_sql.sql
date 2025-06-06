CREATE DATABASE IF NOT EXISTS jdbc_exo_banque;
USE jdbc_exo_banque;

CREATE TABLE IF NOT EXISTS customers (
id INT PRIMARY KEY AUTO_INCREMENT,
lastname VARCHAR(50) NOT NULL,
firstname VARCHAR(50) NOT NULL,
phone VARCHAR(15) NOT NULL
);


CREATE TABLE IF NOT EXISTS bank_accounts(
id INT PRIMARY KEY AUTO_INCREMENT,
customer_id INT,
FOREIGN KEY (customer_id) REFERENCES customers(id)
);


CREATE TABLE IF NOT EXISTS operations(
id INT PRIMARY KEY AUTO_INCREMENT,
amount DOUBLE NOT NULL,
status ENUM ('WITHDRAWAL','DEPOSIT') NOT NULL,
account_id INT NOT NULL,
FOREIGN KEY (account_id) REFERENCES bank_accounts(id)
);


