DROP DATABASE IF EXISTS concesionario;
CREATE DATABASE concesionario;
USE concesionario;

DROP TABLE IF EXISTS `coches`;

CREATE TABLE `coches` (
  matricula varchar(11) NOT NULL,
  marca varchar(50) NOT NULL DEFAULT "Seat",
  modelo varchar(100) DEFAULT NULL,
  PRIMARY KEY(matricula)
  ) ENGINE =InnoDB DEFAULT CHARSET=utf8;
  
  ----- Insertar 3 datos
  select * from coches; 
  
  INSERT INTO coches values("98", "Volvo", "Z");
  INSERT INTO coches values("87", "Volvo", "X");
  INSERT INTO coches values("76", "Volvo", "Y");
  
  ----- Insertar 2 datos en una sola sentencia  
  INSERT INTO coches (matricula, marca, modelo) VALUES ("A", "Unit", "AY"), ("B", "Unit", "AZ"),("C", "Unit", "AT");

  --  Introduce 2 coches introduciendo datos con algunos valores DEFAULT
  INSERT INTO coches values ("5D", "Seat", DEFAULT);
  INSERT INTO coches values ("6D", DEFAULT, "AYZ");
  
  -- Introduce 2 coches dejando algunas de las columnas sin definir/usar (con dos sentencias)
  INSERT INTO coches values ("", "Seat", DEFAULT);
  INSERT INTO coches values ("8A", "Volvo", "");
  
  -- Introduce 2 coches dejando algunas de las columnas sin definir/usar (con una sola sentencia)
INSERT INTO coches (matricula, marca, modelo) VALUES ("58v", "Unit", "AY"), ("10R", "Fenix", "");
  
-- Crea una tabla idéntica a "coches" y llámala "coches_copia"
CREATE TABLE `coches_copia` (
  matricula varchar(11) NOT NULL,
  marca varchar(50) NOT NULL DEFAULT "Seat",
  modelo varchar(100) DEFAULT NULL,
  PRIMARY KEY(matricula)
  ) ENGINE =InnoDB DEFAULT CHARSET=utf8;


-- Introduce en la tabla anterior 5 coches de la tabla "coches". Utiliza, para ello, 
-- una SELECT con todos los coches ordenados por matrícula y solo introduce 5.
INSERT INTO coches_copia SELECT * FROM coches ORDER BY matricula LIMIT 5;

-- Crea una tabla llamada "copias_copia_auto" con una sentencia CREATE TABLE AS SELECT cuya tabla origen sea "coches". 
-- Introduce solo los coches de una determinada marca.
CREATE TABLE copias_copia_auto AS SELECT * FROM coches WHERE marca LIKE 'Seat';
select * from copias_copia_auto;