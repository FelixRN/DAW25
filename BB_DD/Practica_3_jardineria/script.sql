# Solución de la práctica 4
use jardineria;

-- Nombre del cliente, País, Fax y apellido del contacto de los clientes que han realizado pagos en el año 2008. Realizar sin JOIN, con INNER JOIN y con NATURAL JOIN
select c.NombreCliente, c.Pais, c.Fax, c.ApellidoContacto 
	from clientes as c, pagos as p where p.CodigoCliente = c.CodigoCliente 
    and p.FechaPago like '%2008%'; 
-- Vamos a realizar la misma Select pero con JOIN
SELECT * FROM clientes INNER JOIN pagos ON clientes.CodigoCliente = pagos.CodigoCliente
	where pagos.FechaPago like '%2008%'; # También funciona si quitamos el INNER
-- Vamos a realizar la misma Select pero con NATURAL JOIN
SELECT * FROM clientes NATURAL JOIN pagos 
	where pagos.FechaPago like '%2008%'; # Se puede realizar porque el nombre de los campos son iguales.

-- Listar todos los pedidos que realizó cada cliente
select clientes.NombreCliente, clientes.ApellidoContacto, pedidos.CodigoPedido, pedidos.Estado 
	from clientes, pedidos 
    where clientes.CodigoCliente = pedidos.CodigoCliente;
-- INNER JOIN
select clientes.NombreCliente, clientes.ApellidoContacto, pedidos.CodigoPedido, pedidos.Estado FROM
	clientes INNER JOIN pedidos ON clientes.CodigoCliente = pedidos.CodigoCliente;    
-- NATURAL JOIN
select clientes.NombreCliente, clientes.ApellidoContacto, pedidos.CodigoPedido, pedidos.Estado FROM
	clientes NATURAL JOIN pedidos;
    
-- Misma consulta que antes pero utilzando alias de tabla    
select c.NombreCliente as 'Nombre del cliente que realiza el pedido', c.ApellidoContacto, p.CodigoPedido, p.Estado 
	from clientes as c, pedidos as p
    where c.CodigoCliente = p.CodigoCliente;
    
     
-- Nombre clientes y nombre de productos comprados
SELECT c.nombreCliente, pr.Nombre
FROM clientes as c, pedidos as p, detallePedidos as d, productos as pr 
WHERE c.CodigoCliente = p.CodigoCliente 
AND p.CodigoPedido = d.CodigoPedido
AND d.CodigoProducto = pr.CodigoProducto;
-- La misma consulta que la anterior pero utilizando INNER JOIN
SELECT c.nombreCliente, pr.Nombre 
FROM clientes AS c
INNER JOIN pedidos AS p ON c.CodigoCliente = p.CodigoCliente
INNER JOIN detallePedidos AS d ON p.CodigoPedido = d.CodigoPedido
INNER JOIN productos AS pr ON d.CodigoProducto = pr.CodigoProducto;
-- NATURAL JOIN
SELECT c.nombreCliente, pr.Nombre 
FROM clientes AS c
NATURAL JOIN pedidos 
NATURAL JOIN detallePedidos
NATURAL JOIN productos AS pr;


-- Seleccionar todos los pedidos que han realizado los clientes con el nombre 'Tendo%' Realizar la consulta con NATURAL JOIN e Inner Join
-- INNER JOIN
SELECT * FROM clientes INNER JOIN pedidos ON clientes.CodigoCliente = pedidos.CodigoCliente where clientes.NOmbreCliente like 'Tendo%';
-- NATURAL JOIN
SELECT * FROM clientes NATURAL JOIN pedidos where clientes.NOmbreCliente like 'Tendo%';

-- Realiza un CROSS JOIN para conocer el funcionamiento de este operador. Consulta todas las posibles combinaciones entre empleados y oficinas (tener en cuenta que no son combinaciones reales porque no se está teniendo en cuenta las tuplas relacionadas)
SELECT * FROM empleados CROSS JOIN oficinas;

-- El nombre, apellidos y cargo de aquellos que no sean representantes de ventas. 
SELECT Nombre, Apellido1, Apellido2, Puesto FROM empleados WHERE Puesto not like '%Representante Ventas%'; -- Se trata de consulta de una tabla

-- Muestra el nombre de los clientes que no hayan realizado pagos junto con el nombre de sus representantes de ventas y el código del cliente de la tabla pagos
SELECT c.NombreCliente, e.Nombre, p.CodigoCliente FROM 
	(clientes c INNER JOIN empleados e ON e.CodigoEmpleado = c.CodigoEmpleadoRepVentas) -- Unimos las dos tablas iniciales con un INNER JOIN, el resultado hacemos un left join para sacar tuplas de la tabla de la izquierda que cumplan que no tienen tuplas relacionadas en la tabla de la derecha
    left outer join pagos p ON c.CodigoCliente = p.CodigoCliente
    WHERE p.CodigoCliente is null; -- Si no ponemos esta condición salen los que tienen pagos y los que no tienen pagos.

-- Muestra el nombre de los empleados que no estén asociados a ningún cliente (hacer un right o left join)
SELECT * FROM clientes right outer join empleados ON clientes.CodigoEmpleadoRepVentas = empleados.CodigoEmpleado
	WHERE clientes.CodigoEmpleadoRepVentas IS NULL; -- Si no ponemos esta opción salen los que están asociados a clientes y los que no

-- Muestra todos los datos de clientes y pagos pero solo muestra los clientes que hayan realizado algún pago (hacer un right o left join)
SELECT * FROM clientes left outer join pagos ON clientes.CodigoCliente = pagos.CodigoCliente
	WHERE pagos.CodigoCliente IS NULL; -- Si no ponemos esta opción salen los que están asociados a clientes y los que no

-- Muestra los empleados cuyo jefe directo sea Alberto con una consulta reflexiva
SELECT * FROM empleados a inner join empleados b ON a.CodigoEmpleado = b.CodigoJefe
	WHERE a.Nombre like 'Alberto'; -- Se hace un join de las dos tablas indicando la PK-FK y la condición

-- Muestra el nombre de los clientes y su teléfono cuyos representantes de ventas sean Hilario y Lucio (con UNION)
SELECT c.NombreCliente, c.Telefono, e.Nombre FROM clientes c, empleados e 
	WHERE e.CodigoEmpleado = c.CodigoEmpleadoRepVentas AND e.Nombre like 'Mariano'
UNION
SELECT c.NombreCliente, c.Telefono, e.Nombre FROM clientes c, empleados e 
	WHERE e.CodigoEmpleado = c.CodigoEmpleadoRepVentas AND e.Nombre like 'Lucio';

