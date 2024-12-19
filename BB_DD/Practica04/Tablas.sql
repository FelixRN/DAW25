drop database if exists instituto;
create database instituto;
 use instituto;
 create table alumnos 
 (dni_alumno varchar(10) primary key, 
 nombre varchar(50) not null, 
 telefono int, 
 direccion varchar(100), 
 edad int not null, 
 categoria enum("A","B","C") default 'A', 
 sexo char(1) not null, 
 repetidor bool,
 nota_media numeric(4,2), 
 fecha_nac date,
 dni_delegado varchar(10),
 foreign key (dni_delegado) references alumnos(dni_alumno) on delete set null on update no action)
 engine='InnoDB';
 

create table tipo_asignatura
(tipo int primary key,
descripcion varchar(100))
engine='InnoDB';  

create table asignaturas
(id_asignatura int primary key,
nombre varchar(35) not null,
horas int,
tipo int,
foreign key (tipo) references tipo_asignatura(tipo) on delete set null on update cascade
)
engine='InnoDB';

 create table cursa_asignaturas
 (dni_alumno varchar(10) ,
 id_asignatura int,
 primary key (dni_alumno,id_asignatura),
 foreign key (dni_alumno) references alumnos (dni_alumno) on delete cascade on update cascade,
 foreign key (id_asignatura) references asignaturas(id_asignatura) on delete cascade on update cascade)
 engine='InnoDB';
