CREATE DATABASE p04_gym;
USE p04_gym;

CREATE TABLE room(
id_room INT PRIMARY KEY,
name VARCHAR(100) NOT NULL,
capacity VARCHAR(50) NOT NULL,
type VARCHAR(50)
);

CREATE TABLE personal(
id_personal INT PRIMARY KEY,
name VARCHAR(100) NOT NULL,
occupation VARCHAR(50) NOT NULL,
id_room INT,
FOREIGN KEY (id_room) REFERENCES room (id_room)
);
