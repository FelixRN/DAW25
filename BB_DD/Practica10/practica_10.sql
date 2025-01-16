-- creamos la BBDD
DROP DATABASE if exists Pelix;
CREATE DATABASE IF NOT EXISTS Pelis;
use Pelis;

Create table alquila (
dni varchar(10),
id_peli varchar(10),
numero int,
fecha_alquiler date,
fechaDevolucion date
);

Create table Pelicula(
titulo varchar(10),
productora varchar(10),
nacionalidad varchar(10),
fecha date,
Director varchar(10)
);


Create table ejemplar(
id_peli varchar(10),
numero int,
estado varchar(10)
);
 
Create table socio (
dni varchar(10),
nombre varchar(10),
direccion varchar(10),
telefono int,
avalador varchar(10),
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