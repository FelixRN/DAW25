drop database if exists oficina_mal;
create database oficina_mal;
use oficina_mal;

CREATE TABLE habitacion (
   id_hotel int(11) NOT NULL,
   id_habitacion int(11) NOT NULL,
   primary key(id_hotel, id_habitacion)
 ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE empleado (
   dni varchar(10) NOT NULL,
   nss int(11) DEFAULT NULL,
   puesto int(11) DEFAULT NULL,
   id_hotel int(11) DEFAULT NULL,
   id_habitacion int(11) DEFAULT NULL,
   PRIMARY KEY (dni),
   CONSTRAINT empleado_ibfk_3 FOREIGN KEY (id_puesto) REFERENCES puesto (puesto) ON DELETE SET NULL ON UPDATE CASCADE,
   CONSTRAINT empleado_ibfk_3 FOREIGN KEY (id_hotel) REFERENCES habitaciones (id_hotel) on delete set null on update cascade,
   CONSTRAINT empleado_ibfk_4 FOREIGN KEY (id_habitacion, id_hotel) REFERENCES habitaciones (id_habitacion, id_hotel) on update cascade
 ) ENGINE=InnoDB DEFAULT CHARSET=latin1;
 
  CREATE TABLE puesto (
   id_puesto int(11) NOT NULL,
   descr varchar(30) DEFAULT NULL,
   PRIMARY KEY (id_puesto)
 ) ENGINE=InnoDB DEFAULT CHARSET=latin1
 