-- 1.Borrar "clave foranea" 
show create table habitaciones;
alter table habitaciones drop foreign key habitaciones_ibfk_1;

-- 2. Borrar "campo" 
alter table habitaciones drop nombre_hotel;

-- 3 Eliminar "campo"
alter table hoteles drop nombre;

-- 4 "Añadir/Crear" campo
alter table hoteles add id_hotel int primary key auto_increment first;

-- 5 "Crear/Añadir" campo
alter table habitaciones add id_hotel int;

-- 6 "Borrar campo"
show create table reservas;
alter table reservas drop foreign key reservas_ibfk_1;
alter table reservas drop id_habitacion;
alter table habitaciones drop id_habitacion;

-- 7 "Cambiar(re-nombrar) campo de una columna"
alter table reservas rename column fecha to fecha_reserva;

-- 8 Agregar/establecer clave primaria
alter table habitaciones add primary key(id_hotel,numero,planta);

-- 9  Agregar/establecer foreign key
alter table habitaciones add foreign key (id_hotel) references hoteles (id_hotel);

-- 10 "Re-nombrar"
alter table reserva_cliente rename reservas_habitaciones_cliente;

-- 11 Crear columnas
alter table reservas add column planta int;
alter table reservas add column numero int;
alter table reservas add column id_hotel int;
-- alter table reservas add column (planta int, numero int, id_hotel int);


-- 12 "Eliminar columnas y claves foraneas"
show create table reservas_habitaciones_cliente;
show create table reservas;
alter table reservas_habitaciones_cliente drop foreign key reservas_habitaciones_cliente_ibfk_1;
alter table reservas_habitaciones_cliente drop foreign key reservas_habitaciones_cliente_ibfk_2;

alter table reservas drop column id_reserva;

-- 13 Establecer clave primaria
show create table reservas;
alter table reservas add primary key (numero,planta,id_hotel,fecha_reserva);

-- 14 Establecer nueva clave foranea
show create table habitaciones;
alter table reservas add foreign key (id_hotel,numero,planta) references habitaciones (id_hotel,numero,planta);

-- 15 Borrar clave primaria (no hace falta nombrarlo directamente)
alter table reservas_habitaciones_cliente drop primary key;

-- 16 Crear campos
alter table reservas_habitaciones_cliente add numero int;
alter table reservas_habitaciones_cliente add planta int;
alter table reservas_habitaciones_cliente add id_hotel int;
alter table reservas_habitaciones_cliente add fecha_reserva date;

-- 17 Establecer claves primarias
alter table reservas_habitaciones_cliente add primary key (numero,planta,id_hotel,dni_cliente);

-- 18 Establecer claves foraneas
show create table reservas_habitaciones_cliente;
alter table reservas_habitaciones_cliente add foreign key (dni_cliente) references clientes (dni_cliente);
alter table reservas_habitaciones_cliente add foreign key (numero, planta, id_hotel, fecha_reserva) references reservas (numero, planta, id_hotel, fecha_reserva);

#Añadir un comentaio a todas las tablas acerca de la información que guardan.

alter table clientes comment= "Información clientes";
alter table habitaciones comment= "Información clientes";
alter table hoteles comment= "Información clientes";
alter table reservas comment= "Información clientes";
alter table reserva_habitaciones_cliente comment= "Información clientes";

