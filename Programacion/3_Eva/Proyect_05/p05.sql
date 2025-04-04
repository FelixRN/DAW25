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
(2, 'Adrian', 'b'),
(3, 'Lucas', 'c'),
(4, 'Carlos', 'd'),
(5, 'Felix', 'e'),
(6, 'Guty', 'f'),
(7, 'Frank', 'g'),
(8, 'Jorge', 'h'),
(9, 'Mario', 'i'),
(10, 'Tomy', 'j');

select * from user;