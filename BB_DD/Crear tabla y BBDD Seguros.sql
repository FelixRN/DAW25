-- creamos la BBDD
CREATE DATABASE IF NOT EXISTS Seguros;
use Seguros;

-- Creamos la tabla y sus atributos
Create table empleados (
num_empleado int primary key,
nombre varchar(30) NOT NULL,
salario float,
-- Creamos una clave externa para el num del jefe y la autoreferenciamos  con la clave primaria de la primera tabla
num_emp_jefe int NOT NULL,
foreign key (num_emp_jefe) references empleados (num_empleado) 

);

-- Creamos el resto de tablas
Create table Agentes (
num_empleado int primary key,
foreign key (num_empleado) references empleados (num_empleado)
);

Create table Beneficiarios (
dni CHAR(9) NOT NULL primary key,
nombreben varchar(30) NOT NULL,
direccion VARCHAR(30) NOT NULL
);

Create table Polizas (
Num_poliza int primary key,
Descripción varchar(70),
Cantidad int,
dni CHAR(9) NOT NULL,
num_empleado int,
foreign key (num_empleado) references Agentes (num_empleado),
foreign key (dni) references Beneficiarios (dni)
);


