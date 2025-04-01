drop database if exists instituto;

create database instituto;

use instituto;
 
 create table alumnos 
 (dni_alumno varchar(10) primary key, 
 nombre varchar(50) not null, 
 telefono int, 
 direccion varchar(100), 
 edad int not null default 18, 
 categoria enum('A','B','C') default 'A', 
 sexo char(1) not null, 
 repetidor bool,
 nota_media float(4,2), 
 fecha_nac date,
 dni_delegado varchar(10) references alumnos(dni_alumno) on delete set null)
 engine='InnoDB';
 

create table tipo_asignatura
(tipo int primary key,
descripcion varchar(100))
engine='InnoDB';  

create table asignaturas
(id_asignatura int primary key auto_increment,
nombre varchar(35) not null,
horas int,
tipo int, 
foreign key (tipo) references tipo_asignatura(tipo) 
)
engine='InnoDB';

 
 create table cursa_asignaturas
(dni_alumno varchar(10),
id_asignatura int,
primary key (dni_alumno,id_asignatura),
foreign key (dni_alumno) references alumnos(dni_alumno) on delete cascade,
foreign key (id_asignatura) references asignaturas(id_asignatura) on delete cascade
)
engine='InnoDB';
 

DROP TABLE IF EXISTS `per1`;

CREATE TABLE `per1` (
  `dni` varchar(10) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `apellido1` varchar(50) DEFAULT NULL,
  `apellido2` varchar(50) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `sexo` enum('H','M') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `per1` (`dni`, `nombre`, `apellido1`, `apellido2`, `direccion`, `sexo`) 
VALUES ('21919026Z','PEDRO','Medina','Crespo','ESCUELAS.','H'),
('75458961B','MARIA DOLORES','Núñez','Pascual','CRUZ DE MIRANDA','M'),
('27965528X','MANUEL','Giménez','Navarro','HUGO DE PAYNS','H'),
('12958474Q','MIRIAM','Martin','Crespo','PERALES (LOS)','M'),
('82434905I','MARIA CONCEPCION','Reyes','Román','CARNICERIAS','M'),
('26422561L','AINHOA','Montero','Gil','MARAGATA (LA)','M'),
('67436450L','MARINA','Suarez','Gutiérrez','PEDRACAL','M'),
('83171019E','JUAN FRANCISCO','Rodríguez','Gallego','CLAVELES','H'),
('75766065K','IRENE','Alonso','Martin','ISAAC PERAL','M'),
('81316171E','SUSANA','López','Vega','PERALES (LOS)','M');

-- Solución de la práctica 2

-- No se puede ejecutar dos veces este script porque nos daría problema con los datos duplicados.
-- Si queremos hacer dos ejecuciones, tendríamos que ejecutar de nuevo el script que borra y crea la BBDD

-- Utilizamos la BBDD
use instituto;

/*
Insertar en la tabla tipo_asignatura los siguientes datos:
tipo: 1
descripción: troncal.

tipo: 2
descripción: optativa.

tipo: 3
descripción: obligatoria.

tipo: 4
descripción: libre_configuración.
*/

insert into tipo_asignatura values (1,'Troncal'), (2,'Optativa'), (3,'Obligatoria'), (4,'Libre_configuración');

select * from tipo_asignatura;
/*
En la tabla asignaturas introduciremos las siguientes (todas tendrán como tipo troncal)
o	Gestión de bases de datos. 
o	Programación
o	Redes 1
o	Redes 2
o	Desarrollo en entorno servidor
*/

insert into asignaturas (nombre, tipo) values ('Gestión de bases de datos',1), ('Programación',1), ('Redes 1',1), ('Redes 2',1), ('Desarrollo en entorno servidor',1);
select * from tipo_asignatura;
-- insert into asignaturas values (7,'prueba',2, 1);

-- Inserta en la tabla alumnos los datos de la tabla per1. Solo los datos que puedas.
insert into alumnos (dni_alumno, nombre, direccion, sexo) select dni, nombre, direccion, sexo from per1;
select * from alumnos;
select * from per1;

-- Crea una copia de seguridad de la tabla alumnos y llámala alumnos seguido de un _ y la fecha actual.
create table alumnos_20230504 as select * from alumnos;
select * from alumnos_20230504;

-- Inserta estos nuevos alumnos.
-- En este ejercicio tenemos que tener en cuenta que tenemos datos que no están registrados en la tabla alumnos, como: apellidos. Entonces no podemos meterlos, por lo que los dejamos fuera o los metemos en el nombre
insert into alumnos (dni_alumno, nombre, telefono, sexo, categoria) values ('598926666M', 'JAVIER Ramírez Guerrero', 657890943, 'm', 'A');
insert into alumnos (dni_alumno, nombre, direccion, edad, sexo) values ('798004710J', 'LUIS	Herrero	Giménez', 'LAGO DE LA BAÑA', 23, 'm');
insert into alumnos (dni_alumno, nombre, edad, sexo, categoria) values ('153611090V', 'JOSE MIGUEL Campos Benítez', 23, 'm', 'A');
insert into alumnos (dni_alumno, nombre, telefono, sexo, repetidor) values ('176716292C', 'ALEJANDRO Navarro Domínguez', 678324567, 'm', true);
insert into alumnos (dni_alumno, nombre, telefono, sexo, repetidor) values ('127020940H', 'MIGUEL ANGEL	Campos Ferrer', 685090402, 'm', true);
insert into alumnos (dni_alumno, nombre, telefono, sexo, direccion, edad) values ('604274619B', 'INMACULADA Diaz Ramos', 678980456, 'f', 'Claveles', 23);
insert into alumnos (dni_alumno, nombre, edad, sexo, repetidor) values ('304405364W', 'JOAQUIN Jiménez Morales', 22, 'm', true);
insert into alumnos (dni_alumno, nombre, direccion, sexo, categoria) values ('915635113Y', 'NEREA Rojas Ortega', 'BUENAVISTA', 'f', 'C');
insert into alumnos (dni_alumno, nombre, telefono, sexo, repetidor) values ('522520305F', 'ANA Bravo Benítez', 658464940, 'f', true);
insert into alumnos (dni_alumno, nombre, direccion, sexo, categoria) values ('604342885G', 'INMACULADA Carrasco Nieto', 'Los Frailes', 'f', 'B');
insert into alumnos (dni_alumno, nombre, edad, sexo, repetidor) values ('172629264J', 'JUAN JOSE Pérez	Garrido', 28, 'm', true);

select * from alumnos;

-- Introduce en la tabla cursa_asignaturas los siguientes datos
insert into cursa_asignaturas values ('75458961B', 1), ('75458961B', 2), ('75458961B', 3);
insert into cursa_asignaturas values ('27965528X', 1), ('27965528X', 2), ('27965528X', 3);
insert into cursa_asignaturas values ('12958474Q', 1), ('12958474Q', 2), ('12958474Q', 3);
insert into cursa_asignaturas values ('82434905I', 1), ('82434905I', 2), ('82434905I', 3);
insert into cursa_asignaturas values ('26422561L', 4), ('26422561L', 5);
insert into cursa_asignaturas values ('67436450L', 4), ('67436450L', 5);
insert into cursa_asignaturas values ('83171019E', 4), ('83171019E', 5);
insert into cursa_asignaturas values ('75766065K', 4), ('75766065K', 5);
insert into cursa_asignaturas values ('81316171E', 4), ('81316171E', 5);

select * from cursa_asignaturas;

-- Crear una tabla que contenga la siguiente información: Nombre alumno, Dni, nombre asignatura, tipo_asignatura.
create table tablaNueva as 
	select alu.nombre as 'Nombre Alumno', alu.dni_alumno as 'DNI', asi.nombre as 'Nombre de la asignatura', tipo_asi.descripcion as 'Descripción de la asignatura' from 
	alumnos as alu inner join cursa_asignaturas as cursa on alu.dni_alumno = cursa.dni_alumno
	inner join asignaturas as asi on cursa.id_asignatura = asi.id_asignatura
    inner join tipo_asignatura as tipo_asi on asi.id_asignatura = tipo_asi.tipo
    order by alu.nombre;

select * from tablaNueva;
    
