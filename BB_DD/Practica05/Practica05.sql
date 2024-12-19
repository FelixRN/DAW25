drop database if exists medico;
CREATE DATABASE IF NOT EXISTS medico;
use medico;

-- Creamos la tabla y sus atributos
Create table medico(
Dni_medico Varchar(10) primary key,
Nombre_med Varchar(30) NOT NULL,
Año_colegio Int NOT NULL default 1900,
direccion Varchar(50)
);

Create table paciente(
Dni_paciente Varchar(10) primary key,
Nombre_pac Varchar(30) Not null,
Dir_pac Varchar(50),
Telefono Varchar(10),

Dni_medico Varchar(10),
foreign key (Dni_medico) references medico (Dni_medico) 
); 

Create table Salas(
Id_sala INT primary key,
Ubicacion Varchar(50) Not null
);

Create table trabaja(
Dni_medico Varchar(10),
Id_sala INT,
Horario Varchar(40) Not null,
primary key (Dni_medico, Id_sala), /*Si hay más de una clase primaria se ponen juntas*/

foreign key (Dni_medico) references medico (Dni_medico) on delete cascade,
foreign key (Id_sala) references Salas (Id_sala) on delete no action on update cascade
);



