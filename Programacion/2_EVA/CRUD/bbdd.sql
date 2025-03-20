drop database if exists Prueba1;
create database Prueba1;
use Prueba1;

CREATE TABLE Prueba1(
  plate varchar(10) PRIMARY KEY ,
  model VARCHAR(255) NOT NULL
);

select * from Prueba1;