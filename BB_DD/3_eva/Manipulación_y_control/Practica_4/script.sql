# Solución de la práctica 4.

use neptuno;

/*
Ayuda: se pueden realizar INSERT utilizando una subselect. Ej:

INSERT INTO tabla (campo1, campo2, campo3) VALUES (1, 2, (SELECT  c3 FROM otra_tabla); La sentencia SELECT puede contener cualquier tipo filtro, orden, limitación, ect.
INSERT INTO tabla (campo1, campo2, campo3) (SELECT  c1, c2, c3 FROM otra_tabla); En este ejemplo se obtienen todos los datos mediante la select
*/

-- Crear una nueva categoría de producto. Habrá que insertar un nuevo registro. Con el id_categoria -> 9, nombre-> congelados y como descripción 'productos congelados'.
INSERT INTO categorias (IdCategoría, NombreCategoría, Descripción) VALUES (9, 'Congelados', 'Productos congelados');

-- Crear una nueva categoría con id_categoria->10, nombre 'Pan' y con la descripción 'repostería, cereales, pan, dulces, galletas, etc…'
INSERT INTO categorias (IdCategoría, NombreCategoría, Descripción) VALUES (10, 'Pan', 'Repostería, cereales, pan, dulces, galletas, etc…');

Select * from categorias;

-- Crear una copia de seguridad de la tabla productos que llamaremos productos_bck.
CREATE TABLE productos_bck AS SELECT * FROM productos;

select * from productos_bck;

-- Actualizar la tabla productos para poner con categoría 10 (la nueva categoría que hemos creado) a todos los productos que pertenezcan a la categoría 5 o 3.
UPDATE productos set IdCategoría = 10 where (IdCategoría = 5 or IdCategoría = 3);

select * from productos;

/* Crear una nueva tabla ciudadpais que tenga dos campos
        ciudad varchar(15) pk
        país varchar(15)
*/
CREATE TABLE ciudadpais (
	ciudad varchar(15) primary key,
    país varchar(15)
	)
ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- Insertar en la tabla ciudadpais: todas las ciudades y países distintas de la tabla proveedores
# Vale cualquiera de las tres sentencias siguientes
INSERT INTO ciudadpais (ciudad, país) (SELECT distinct Ciudad, País FROM proveedores);
INSERT INTO ciudadpais (ciudad, país) (SELECT Ciudad, País FROM proveedores GROUP BY País, Ciudad);
INSERT INTO ciudadpais (ciudad, país) (SELECT distinct Ciudad, País FROM proveedores GROUP BY País, Ciudad);
INSERT INTO ciudadpais (SELECT distinct Ciudad, País FROM proveedores);

select * from ciudadpais;

-- Borrar todos los datos del país de la tabla empleados.
UPDATE empleados set País = '';
# También es válido poner a NULL
UPDATE empleados set País = null;

Select * from empleados;

-- Damos de alta a un nuevo empleado en la empresa. Inserta los datos poniendo tu nombre y apellidos más los datos que no pueden estar en blanco en esa tabla.
INSERT INTO empleados (idEmpleado, Apellidos, Nombre) VALUES (10, 'Mateos', 'Teresa');

select * from empleados;

-- Vamos a borrar los datos del empleado con idempleado=7 ya que deja de trabajar en la empresa. 
-- Antes de darlo de baja habrá que asignar todos los pedidos que realizó este empleado al empleado 8
UPDATE pedidos SET IdEmpleado = 8 WHERE IdEmpleado = 7; 
DELETE FROM empleados WHERE IdEmpleado = 7;

select * from pedidos;
select * from empleados;

/* En la categoría guardamos la imagen de la categoría, pero esto ocupa demasiado espacio. Vamos a realizar algunas modificaciones:
        - Borrar todos los datos del campo imagen de la tabla categorías. (Actualización). Poner el campo a 0
        - Cambiar el tipo de dato del campo imagen de longblob a varchar(25).(alter table)
        - Introducir en el campo imagen un texto que sea los cinco primeros caracteres del nombre de la Categoría seguido de un guion bajo más el id de la categoría con extensión .jpg. Por ejemplo bebid_1.jpg (realizar 8 querys diferentes, uno para cada categoría)
*/
UPDATE categorias set imagen = 0;  # El SGBD puede dar error, se puede poner a null en vez de a 0
# También valdría: UPDATE categorias set imagen = null;
select * from categorias;

alter table categorias change column imagen imagen varchar(15);
# También es válida la siguiente sentencia:
alter table categorias modify imagen varchar(25);

# Se pide hacer 8 UPDATE. Para la función del texto se puede utilziar SUBSTRING o LEFT para recortar el texto
update categorias set imagen =  (select concat(SUBSTRING(NombreCategoría,1,5),'_1.jpg') from categorias where IdCategoría = 1) where IdCategoría = 1;
update categorias set imagen =  (select concat(SUBSTRING(NombreCategoría,1,5),'_2.jpg') from categorias where IdCategoría = 2) where IdCategoría = 2;
update categorias set imagen =  (select concat(SUBSTRING(NombreCategoría,1,5),'_3.jpg') from categorias where IdCategoría = 3) where IdCategoría = 3;
update categorias set imagen =  (select concat(SUBSTRING(NombreCategoría,1,5),'_4.jpg') from categorias where IdCategoría = 4) where IdCategoría = 4;
update categorias set imagen =  (select concat(SUBSTRING(NombreCategoría,1,5),'_5.jpg') from categorias where IdCategoría = 5) where IdCategoría = 5;
update categorias set imagen =  (select concat(SUBSTRING(NombreCategoría,1,5),'_6.jpg') from categorias where IdCategoría = 6) where IdCategoría = 6;
update categorias set imagen =  (select concat(SUBSTRING(NombreCategoría,1,5),'_7.jpg') from categorias where IdCategoría = 7) where IdCategoría = 7;
update categorias set imagen =  (select concat(SUBSTRING(NombreCategoría,1,5),'_8.jpg') from categorias where IdCategoría = 8) where IdCategoría = 8;
# La sentencia anterior se puede hacer automáticamente a la vez para todos las tuplas
update categorias set imagen = (select concat (SUBSTRING(NombreCategoría, 1, 5), '_', IdCategoría, '.jpg')); -- hay que cambiar en categoría la imagen por varchar(25)

select * from categorias;

-- Poner en notas del empleado el valor 'Cumple con objetivos' a todos aquellos empleados que hayan preaparado un pedido con un producto de la categoría cuya descripción es 'Quesos'
-- No tiene que salir ningún cambio porque la tabla detalle de pedidos está vacía
UPDATE empleados set Notas = 'Cumple con objetivos' WHERE 
	IdEmpleado = any (SELECT E.IdEmpleado FROM 
    empleados AS E INNER JOIN pedidos AS p ON e.IdEmpleado = p.IdEmpleado
    INNER JOIN `detalles de pedidos` AS detalle ON p.IdPedido = detalle.IdPedido
    INNER JOIN productos AS prod ON prod.IdProducto = detalle.IdProducto
    INNER JOIN categorias AS cat ON cat.IdCategoría = prod.IdCategoría 
    WHERE Descripción LIKE '%Quesos%'
    );
    select * from empleados;
    
    SELECT E.IdEmpleado FROM 
    empleados AS E INNER JOIN pedidos AS p ON e.IdEmpleado = p.IdEmpleado
    INNER JOIN `detalles de pedidos` AS detalle ON p.IdPedido = detalle.IdPedido
    INNER JOIN productos AS prod ON prod.IdProducto = detalle.IdProducto
    INNER JOIN categorias AS cat ON cat.IdCategoría = prod.IdCategoría 
    WHERE Descripción LIKE '%Quesos%';

UPDATE empleados set Notas = 'Cumple con objetivos' WHERE 
	IdEmpleado = any (select * from (SELECT E.IdEmpleado FROM 
    empleados AS E INNER JOIN pedidos AS p ON e.IdEmpleado = p.IdEmpleado
    INNER JOIN `detalles de pedidos` AS detalle ON p.IdPedido = detalle.IdPedido
    INNER JOIN productos AS prod ON prod.IdProducto = detalle.IdProducto
    INNER JOIN categorias AS cat ON cat.IdCategoría = prod.IdCategoría 
    WHERE Descripción LIKE '%Quesos%'
    )as X);
    
select * from empleados;