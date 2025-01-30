-- La ciudad y el teléfono de las oficinas de Estados Unidos.
select * from Oficinas; 
select Ciudad, Telefono from Oficinas where Pais LIKE "EEUU";

-- El nombre, los apellidos y el email de los empleados a cargo de Alberto Soria.
select * from Empleados;

-- Mal ejecutado --> select Nombre, Apellido1, Apellido2, Email from Empleados where CodigoJefe like "3";

select Nombre, Apellido1, Apellido2, Email from Empleados where CodigoJefe = (select CodigoEmpleado from Empleados where Nombre like "Alberto" AND Apellido1 like "Soria");

-- El cargo, nombre, apellidos y email del jefe de la empresa.


-- El nombre, apellidos y cargo de aquellos que no sean representantes de ventas.

-- El nombre de los clientes españoles.

-- El código de empleado y el número de clientes al que atiende cada representante de ventas.

-- Cuál fue el primer y último pago que hizo algún cliente.

-- El código de cliente de aquellos clientes que hicieron pagos en 2008.

-- Los distintos estados por los que puede pasar un pedido.

-- El número de pedido, código de cliente, fecha requerida y fecha de entrega de los pedidos que no han sido entregados a tiempo.
