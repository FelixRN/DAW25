-- La ciudad y el teléfono de las oficinas de Estados Unidos.
use jardineria;
select * from Oficinas; 
select Ciudad, Telefono from Oficinas where Pais LIKE "EEUU";

-- El nombre, los apellidos y el email de los empleados a cargo de Alberto Soria.
select * from Empleados;

-- Mal ejecutado --> select Nombre, Apellido1, Apellido2, Email from Empleados where CodigoJefe like "3";

select Nombre, Apellido1, Apellido2, Email from Empleados where CodigoJefe = (select CodigoEmpleado from Empleados where Nombre like "Alberto" AND Apellido1 like "Soria");

-- El cargo, nombre, apellidos y email del jefe de la empresa.

select Puesto, Nombre, Apellido1, Apellido2, Email from empleados where CodigoJefe is null;
-- El nombre, apellidos y cargo de aquellos que no sean representantes de ventas.
select * from empleados;
select Nombre, Apellido1, Apellido2, Puesto from empleados where Puesto not like "Repesentate ventas";
-- El nombre de los clientes españoles.
select NombreCliente from clientes where (Pais like "Spain%") or (Pais like "España%");

-- El código de empleado y el número de clientes al que atiende cada representante de ventas.
select CodigoEmpleadoRepVentras, count(*) as num_clientes from clientes group by CodigoEmpleaddoRevVentas;
-- Cuál fue el primer y último pago que hizo algún cliente.

-- El código de cliente de aquellos clientes que hicieron pagos en 2008.

-- Los distintos estados por los que puede pasar un pedido.

-- El número de pedido, código de cliente, fecha requerida y fecha de entrega de los pedidos que no han sido entregados a tiempo.

-- -	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-	-		-	-	
-- Nombre del cliente, País, Fax y apellido del contacto de los clientes que han realizado pagos en el año 2008. Realizar sin JOIN, con =INNER JOIN y con NATURAL JOIN.)

-- Listar todos los pedidos que realizó cada cliente. Realizar sin JOIN, con INNER JOIN y con NATURAL JOIN.

-- Nombre clientes y nombre de productos comprados. Realizar sin JOIN, con INNER JOIN y con NATURAL JOIN..

-- Seleccionar todos los pedidos que han realizado los clientes con el nombre 'Tendo%' Realizar la consulta con NATURAL JOIN e Inner Join

-- Realiza un CROSS JOIN para conocer el funcionamiento de este operador. Consulta todas las posibles combinaciones entre empleados y oficinas (tener en cuenta que no son combinaciones reales porque no se está teniendo en cuenta las tuplas relacionadas);

-- El nombre, apellidos y cargo de aquellos que no sean representantes de ventas.

-- Muestra el nombre de los clientes que no hayan realizado pagos junto con el nombre de sus representantes de ventas y el código del cliente de la tabla pagos

-- Muestra el nombre de los empleados que no estén asociados a ningún cliente (hacer un right o left join)

-- Muestra el nombre de los empleados que no estén asociados a ningún cliente (hacer un right o left join)

-- Muestra todos los datos de clientes y pagos pero solo muestra los clientes que hayan realizado algún pago (hacer un right o left join)

-- Muestra los empleados cuyo jefe directo sea Alberto con una consulta reflexiva

-- Muestra el nombre de los clientes y su teléfono cuyos representantes de ventas sean Hilario y Lucio (con UNION)

