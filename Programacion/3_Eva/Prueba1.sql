DROP DATABASE IF EXISTS Prueba1;
CREATE DATABASE Prueba1;
USE Prueba1;

DROP TABLE IF EXISTS `Pruebas1`;

CREATE TABLE `Pruebas1` (
  Id INT PRIMARY KEY,
  isbn varchar(15) NOT NULL,
  title varchar(15) NOT NULL
  );
  
  select * from Pruebas1;