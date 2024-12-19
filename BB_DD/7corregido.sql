drop database if exists oficina;
create database oficina;
use oficina;

CREATE TABLE habitaciones (
   id_hotel int(11) NOT NULL,
   id_habitacion int(11) NOT NULL,
   PRIMARY KEY (id_hotel,id_habitacion)
 ) ENGINE=InnoDB DEFAULT CHARSET=latin1;
 

CREATE TABLE puesto (
   id_puesto int(11) NOT NULL,
   descr varchar(30) DEFAULT NULL,
   PRIMARY KEY (id_puesto)
 ) ENGINE=InnoDB DEFAULT CHARSET=latin1;
 
 
 # El anterior script fallaba porque la FK se hacía una FK por cada columna. Se debe hacer un FK que apunte a las dos columnas de la PK de habitaciones
CREATE TABLE empleado (
   dni varchar(10) NOT NULL,
   nss int(11) DEFAULT NULL,
   puesto int(11) DEFAULT NULL,
   id_hotel int(11) DEFAULT NULL,
   id_habitacion int(11) DEFAULT NULL,
   PRIMARY KEY (dni),
   -- UNIQUE KEY nss (nss),
   -- KEY puesto (puesto),
   -- KEY id_hotel (id_hotel,id_habitacion),
   CONSTRAINT empleado_ibfk_2 FOREIGN KEY (puesto) REFERENCES puesto (id_puesto) ON DELETE SET NULL ON UPDATE CASCADE,
   CONSTRAINT empleado_ibfk_3 FOREIGN KEY (id_hotel,id_habitacion) REFERENCES habitaciones (id_hotel,id_habitacion) on delete set null on update cascade
 ) ENGINE=InnoDB DEFAULT CHARSET=latin1;
 
 
 
 
 /* La tabla anterior daba fallo porque cuando utilizamos CONSTRAINT hay que poner las foreign key en la misma fila. 
 En la siguiente tabla se muestra la opción para poner las FK en la definición de cada columna. El problema es que no podemos poner un nombre a la restricción*/
 /*
 CREATE TABLE empleado (
   dni varchar(10) NOT NULL,
   nss int(11) DEFAULT NULL,
   puesto int(11) DEFAULT NULL,
   id_hotel int(11) DEFAULT NULL REFERENCES habitaciones (id_hotel) on delete set null on update cascade,
   id_habitacion int(11) DEFAULT NULL REFERENCES habitaciones (id_habitacion) on delete set null on update cascade,
   PRIMARY KEY (dni),
   UNIQUE KEY nss (nss),
   KEY puesto (puesto),
   KEY id_hotel (id_hotel,id_habitacion),
   CONSTRAINT empleado_ibfk_2 FOREIGN KEY (puesto) REFERENCES puesto (id_puesto) ON DELETE SET NULL ON UPDATE CASCADE
 ) ENGINE=InnoDB DEFAULT CHARSET=latin1;
 */
 
 insert into habitaciones values(1,1);
 insert into habitaciones values(1,2);
 insert into habitaciones values(1,3);
 insert into habitaciones values(1,4);
 insert into habitaciones values(2,1);
 insert into habitaciones values(2,2);
 
 insert into puesto values(1,'programador');
 insert into puesto values(2,'analista');
 insert into puesto values(3,'jefe');
      
 insert into empleado values ('123456k',12345,1,1,1);
 insert into empleado values ('123457k',12346,1,1,2);
 insert into empleado values ('123458k',12347,2,1,3);
 insert into empleado values ('123459k',12348,2,1,1);
 insert into empleado values ('123460k',12349,1,1,2);
 insert into empleado values ('123461k',12350,3,1,3); 
 insert into empleado values ('123462k',12351,3,2,1);
 insert into empleado values ('123463k',12352,1,1,1);
 insert into empleado values ('123464k',12353,2,1,4); 
 insert into empleado values ('123465k',12354,1,1,4);