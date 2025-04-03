DROP DATABASE IF exists p05;
CREATE database p05;
USE p05;

CREATE TABLE user(
id int auto_increment,
name VARCHAR(100),
password VARCHAR(100),
Primary key (id)
);

CREATE TABLE rol(
id int,
occupation varchar(100)
);


insert into rol (id, occupation) values 
(1, 'Administrador'),
(2, 'Analista'),
(3, 'Desarrollador'),
(4, 'Gestor'),
(5, 'Soporte'),
(6, 'Especialista'),
(7, 'Contable'),
(8, 'Recursos humanos'),
(9, 'Diseñador gráfico'),
(10, 'Consultor');


insert into user (id, name, password) values 
(1, 'Juan', 'a'),
(2, 'Juan', 'b'),
(3, 'Juan', 'c'),
(4, 'Juan', 'd'),
(5, 'Juan', 'e'),
(6, 'Juan', 'f'),
(7, 'Juan', 'g'),
(8, 'Juan', 'h'),
(9, 'Juan', 'i'),
(10, 'Juan', 'j');

select * from rol;