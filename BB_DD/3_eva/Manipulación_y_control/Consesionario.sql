DROP DATABASE IF EXISTS concesionario;
CREATE DATABASE concesionario;
USE concesionario;

DROP TABLE IF EXISTS `coches`;

CREATE TABLE `coches` (
  matricula varchar(11) NOT NULL,
  marca varchar(50) NOT NULL,
  modelo varchar(100) DEFAULT NULL
  );
  PRIMARY KEY(matricula);
  ENGINE =InnoDB DEFAULT CHARSET=utf8;
  
  ----- Insertar 3 datos
  
  INSERT INTO coches values(`98`, `Volvo`, `Z`);
  INSERT INTO coches values(`87`, `Volvo`, `X`);
  INSERT INTO coches values(`76`, `Volvo`, `Y`);
  
  ----- Insertar 2 datos en una sola sentencia  
  INSERT INTO coches (matricula, marca, modelo) VALUES 
  (`A`, `Unit`, `AY`), (`B`, `Unit`, `AZ`),(`A`, `Unit`, `AY`);
  -------- 
  INSERT INTO coches values (DEFAULT, `Seat`, DEFAULT);
  INSERT INTO coches values (DEFAULT, `Lambo`, `AYZ`);
  -----------
  INSERT INTO coches values (``, `Seat`, DEFAULT);
  INSERT INTO coches values (DEFAULT, ``, ``);
  
  ------------
INSERT INTO coches (matricula, marca, modelo) VALUES 
  (``, `Unit`, `AY`), (`B`, ``, `AZ`);
  
  ------------- 
  