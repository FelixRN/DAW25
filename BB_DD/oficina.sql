drop database if exists oficina_mal;
create database oficina_mal;
use oficina_mal;

CREATE TABLE habitacion (
   id_hotel int(11) NOT NULL,
   id_habitacion int(11) NOT NULL,
   primary key(id_hotel, id_habitacion)
   
 ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE puesto (
   id_puesto int(11) NOT NULL,
   descr varchar(30) DEFAULT NULL,
   primary key (id_puesto)
 ) ENGINE=InnoDB DEFAULT CHARSET=latin1;
 
CREATE TABLE empleado (
   dni varchar(10) NOT NULL,
   nss int(11) DEFAULT NULL,
   id_hotel int(11) DEFAULT NULL,
   id_habitacion int(11) DEFAULT NULL,
   id_puesto int(11) NOT NULL,
   PRIMARY KEY (dni),
   CONSTRAINT empleado_ibfk_2 FOREIGN KEY (id_puesto) REFERENCES puesto (id_puesto)  ON DELETE CASCADE ON UPDATE CASCADE,
   CONSTRAINT empleado_ibfk_3 FOREIGN KEY (id_hotel, id_habitacion) REFERENCES habitacion (id_hotel, id_habitacion) on delete set null on update cascade
 ) ENGINE=InnoDB DEFAULT CHARSET=latin1;
 
  
 