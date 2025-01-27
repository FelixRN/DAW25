-- 1
drop database if exists Elecciones_municipales;

-- 2
create database elecciones_municipales ;
-- el juego de caracteres que use deberá ser latin1.
use bibliotecas;

create table partidos_politicos
(siglas char (4) primary key,
id_partido int unique,
nombre varchar(30),
direccion varchar(30),
Localidad varchar(30),
Fecha_alta date);

create table politicos (
dni varchar(10) primary key,
partido char(4),
primer_apellido varchar (25),
segundo_apellido varchar (25),
Edad int,
foreign key (partido) references partidos_politicos(siglas));

