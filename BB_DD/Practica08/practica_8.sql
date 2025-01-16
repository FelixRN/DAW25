-- creamos la BBDD
DROP DATABASE if exists Hotel;
CREATE DATABASE IF NOT EXISTS Hotel;
use Hotel;

Create table hoteles (
nombre varchar(50) not null primary key,
ubicacion varchar(100) null,
numero_habitaciones int null
);


-- Declarar "nombre" 
Create table habitaciones (
id_habitacion int not null primary key auto_increment,
numero int null,
planta int null,
metros_cuadrados int null,
nombre_hotel varchar(50) null,
foreign key(nombre_hotel) references hoteles (nombre) ON DELETE CASCADE 
);

Create table clientes(
dni_cliente varchar(10) not null primary key,
nombre varchar(50) null,
edad int null
);

-- Declarar "id_habitaciones" 
Create table reservas (
id_reserva int not null primary key auto_increment,
id_habitacion int null,
fecha date null,
foreign key(id_habitacion) references habitaciones (id_habitacion)
);
-- si hay multiples primary key:
Create table reserva_cliente (
id_reserva int not null,
dni_cliente varchar(10) not null ,
primary key (id_reserva, dni_cliente),
foreign key(id_reserva) references reservas (id_reserva),
foreign key(dni_cliente) references clientes (dni_cliente)
);

