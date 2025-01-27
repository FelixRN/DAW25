# BBDD para modificar
drop database if exists bibliotecas ;
create database bibliotecas;
use bibliotecas;

create table editoriales(
nombre varchar(25) primary key,
direccion varchar(50)
);

create table usuario(
dni varchar(10) primary key,
nombre varchar(25),
edad int,
telefono int);

create table estanteria(
id_estaneria int,
ubicacion varchar(50));

create table autor(
id_autor int primary key,
nombre varchar (25),
nacionaliad varchar (30),
direccion varchar(35)
);

create table libro (
isbn varchar (15),
titulo varchar(40),
tema varchar(40),
nombre_editorial varchar(25),
dni_usuario varchar(10) unique,
id_estanteria int ,
letra char(1),
foreign key (nombre_editorial) references editoriales(nombre),
foreign key (dni_usuario) references usuario(dni)
);

create table escribe(
id_autor int,
isbn varchar(15)
); 
-- 1
alter table usuario add column id_usuario int;

-- 2
show create table libro;
alter table libro drop foreign key libro_ibfk_2;

-- 3
alter table libro change dni_usuario id_usuario int;

-- 4
show create table usuario;
alter table usuario drop primary key; 

-- 5 
alter table usuario add primary key autoincrement (id_usuario);

-- 6
alter table usuario modify dni varchar(10) unique;

-- 7
alter table libros ;

-- 8
alter table escribe rename escribe_libros;


-- 9 
alter table libro add primary key (titulo,isbn);

-- 10
alter table usuario comment= "Con el objetivo, de en un futuro. poder borrar el DNI del usuario de la base de datos hemos cambiado el DNI del usuario por oro campo id_usuario";

