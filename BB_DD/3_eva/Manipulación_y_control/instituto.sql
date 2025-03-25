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
'81316171E','SUSANA','López','Vega','PERALES (LOS)','M');

insert into tipo_asignatura (tipo, descripcion)
values (1, 'troncal'), (2, 'optativa'), (3, 'obligatoria'),(4, 'libre configuración');

insert into asignaturas (nombre, tipo)
value('Gestión',1), ('Programación',1), ('Redes 1',1),
('Redes 2',1),('Desarrollo en entorno servidor',1);

insert into alumnos;
select * from alumnos 
