-- Modelos de vehículos TDI
select *  from coches where Modelo like "%TDI%";

-- Modelos de la marca 'Audi' y de la marca 'Seat' ordenado por Marca y Modelo.
select * from coches where Marca like "%Audi%" OR Marca like "%Seat%" order by Marca, Modelo;

-- Marcas de Vehículos que empiecen por T y terminen en a.
select * from coches where Marca like "T%a%";

-- Vehículos que tengan foto.
select * from coches where Imagen like "";

-- El consumo de los vehículos está expresado en litros/1OOkm. Listar el consumo de los vehículos 'Seat' en MPG, Millas por galón (10 MPG=23.52 l/1OOkm).
select *,(Consumo*10 )/23.52 from coches where Marca like "%Seat%"; 

-- Mostrar los vehículos, ordenados por consumo, que cumplan que tienen un consumo menor de 4, 
-- sus emisiones son menores que 110, que no tengan imagen y que no sean de la marca Volkswagen
select * from coches WHERE Consumo < 4 AND Emisiones < 110 AND Imagen not like ('%.bmp') AND Marca not like("%Volkswagen%") order by Consumo;

-- Mostrar todos los vehículos y añadir una columna que indique 'Poco contaminante' si las emisiones son <110. 'Bastante contaminante' 
-- si el consumo es entre 110 y 150. Utilizar else para el resto indicando 'No comprar, atentado ecológico' .
select *, CASE WHEN Emisiones < 110 THEN "Poco contaminante" WHEN Emisiones between 110 AND 150 THEN "Bastante contaminante" ELSE "No comprar, atentado ecológico" END AS contaminación FROM coches;

-- Crear una consulta cualquier limitando el número de registros.
select * from coches limit 25;

-- Modifica la sentencia anterior para que salga un número de registros a partir de un número de registros especificado.
select * from coches limit 2,1;

-- Los datos de los vehículos cuyo consumo sea menor que el consumo del coche con ID 25
select Consumo from cohes where id=25;
select * from coches where Consumo < (select Consumo from coches where Id= 25);

-- Los datos de los vehículos cuyas emisiones sea mayor o igual que las emisiones del vehículo con ID 25 y al mismo tiempo cuyo consumo sea menor que 6

-- Muestra el coche que más contamina

-- Muestra el coche con el mínimo consumo

-- Muestra si el coche con el ID 53 tiene un consumo mayor que el que tienen los coches con unas emisiones mayores 150

-- Selecciona el coche que tenga el máximo consumo de la marca 'Alfa Romeo'

-- Selecciona los coches que tengan un consumo mayor de 12, sus emisiones sean menor de 420 y la marca sea igual que el coche con el Id 235.
