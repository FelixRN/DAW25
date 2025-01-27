DROP DATABASE if exists Elecciones_municipales;
CREATE DATABASE IF NOT EXISTS Elecciones_municipales;
use Elecciones_municipales;

create table Municipio (
Cod_municipio int primary key auto_increment ,
Nombre Varchar(25),
Provincia Varchar(25),
Num_censados int
-- Tipo boolean 

);

Create table Colegios_electorales (
Cod_municipio int,
Cod_colegio int,
Direccion Varchar(50),
nombre varchar(50),
foreign key(Cod_municipio) references Municipio (Cod_municipio)
);

Create table Mesa_electoral (
Distrito int,
Seccion int,
Letra char(1),
Cod_municipio int,
Cod_colegio int,
foreign key(Cod_municipio) references Colegios_electorales(Cod_municipio) On delete set null on update cascade,
foreign key(Cod_colegio) references Colegios_electorales(Cod_municipio)on delete set null on update cascade
);

create table Candidato (
dni varchar(10),
Puesto Varchar(50),
municipio int,
foreign key(dni) references politicos (Dni) on delete no action on update cascade,
foreign key(municipio) references Municipio (Cod_municipio)
);


Create table Elegido (
dni Varchar(10),
Cargo Varchar(50),
municipio int,
foreign key(dni) references politicos (dni) on delete no action on update cascade,
foreign key(municipio) references Municipio (Cod_municipio) on delete set null on update cascade
);

Create table Obtene_votos(
Distrito int,
Seccion int,
Letra Char(1),
siglas Char(4),
Num_votos int,

foreign key(siglas) references partidos_politicos(Siglas) on delete cascade on update cascade
);

Create table Resultados_municipio(
Cod_municipio int,
siglas Char(4),
Por_votos Char(4),
Num_concejales int default 0,
NUm_votos int,

foreign key(Cod_municipio) references Municipio(Cod_municipio) on delete cascade on update cascade,
foreign key(siglas) references partidos_politicos(Siglas) on delete cascade on update cascade
);
