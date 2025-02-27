CREATE DATABASE IF NOT EXISTS product_database;
USE product_database;

DROP TABLE IF EXISTS sales_history;
DROP TABLE IF EXISTS nutrition_data;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS producer;
DROP TABLE IF EXISTS department;

CREATE TABLE department (
    id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

INSERT INTO department (id, name) VALUES
(1, 'fruits'),
(2, 'vegetables'),
(3, 'seafood'),
(4, 'deli'),
(5, 'bakery'),
(6, 'meat'),
(7, 'dairy');

CREATE TABLE producer (
    id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

INSERT INTO producer (id, name) VALUES
(1, 'BeHealthy'),
(2, 'HealthyFood Inc.'),
(3, 'SupremeFoods'),
(4, 'Foodie'),
(5, 'Gusto'),
(6, 'Baker n Sons'),
(7, 'GoodFoods'),
(8, 'Tasty n Healthy');

CREATE TABLE product (
    id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    department_id INT NULL,
    shelf_id INT NOT NULL,
    producer_id INT NULL,
    price DECIMAL(5,2) NOT NULL,
    FOREIGN KEY (department_id) REFERENCES department(id) ON DELETE SET NULL,
    FOREIGN KEY (producer_id) REFERENCES producer(id) ON DELETE SET NULL
);

INSERT INTO product (id, name, department_id, shelf_id, producer_id, price) VALUES
(1, 'Apple', 1, 1, NULL, 0.5),
(2, 'Avocado', 1, 1, 7, 1.0),
(3, 'Banana', 1, 1, 7, 0.5),
(4, 'Grapefruit', NULL, 1, 1, 0.5),
(5, 'Grapes', 1, 1, 4, 2.0);

CREATE TABLE nutrition_data (
    product_id INT,
    calories INT NOT NULL,
    fat DECIMAL(5,2) NOT NULL,
    carbohydrate DECIMAL(5,2) NOT NULL,
    protein DECIMAL(5,2) NOT NULL,
    PRIMARY KEY (product_id),
    FOREIGN KEY (product_id) REFERENCES product(id) ON DELETE CASCADE
);

INSERT INTO nutrition_data (product_id, calories, fat, carbohydrate, protein) VALUES
(1, 130, 0, 5, 1),
(2, 50, 4.5, 3, 1),
(3, 110, 0, 30, 1),
(4, 60, 0, 15, 1);

CREATE TABLE sales_history (
    date DATE NOT NULL,
    product_id INT NOT NULL,
    amount INT NOT NULL,
    FOREIGN KEY (product_id) REFERENCES product(id) ON DELETE CASCADE
);

INSERT INTO sales_history (date, product_id, amount) VALUES
('2015-01-14', 1, 14),
('2015-01-14', 1, 13),
('2015-01-15', 2, 2),
('2015-01-16', 2, 6),
('2015-01-17', 3, 8);