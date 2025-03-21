-- EJEMPLO: Obtener un listado de la cantidad de productos que nos suministra cada proveedor diferenciando por producto
select ProductID, ProductName, SupplierID, count(*) as num_productos from products GROUP BY SupplierID, ProductID;


-- Contar el número de líneas por pedido (de la tabla orderdetails)
-- Cada pedido puede constar de diferentes lotes o subpedidos (cuyo detalle nos lo da el detalle del pedido)
SELECT * FROM ORDERS;

SELECT OrderId, COUNT(*) as LineasPorPedido FROM orderdetails  GROUP BY OrderId;


-- Calcular el número de dinero gastado en cada pedido
select * from orderdetails;

select OrderID, SUM(Quantity*UnitPrice) as Quantity from orderdetails group by OrderId;


-- Hacer una lista del número de clientes de cada país

SELECT COUNT(CustomerID) as NúmeroClientes, Country FROM Customers GROUP BY Country;

SELECT COUNT(*), Country FROM Customers GROUP BY Country;

-- Ordenar la lista anterior de forma descendente

SELECT COUNT(CustomerID) as NúmeroClientes, Country FROM Customers GROUP BY Country ORDER BY NúmeroClientes DESC;

SELECT COUNT(*), Country FROM Customers GROUP BY Country ORDER BY COUNT(CustomerID) DESC;


-- Hacer un listado del número de pedidos por cliente 

select customerId, count(*) as NúmeroPedidos from orders group by customerid;


-- Contar el número de pedidos por cliente de los clientes de londres
select * from orders;

select COUNT(o.OrderId), c.CustomerID from customers c 
INNER JOIN orders o on o.customerId = c.customerId  
WHERE ShipCity = "London"  group by o.OrderID ;


select o.customerId, count(*) as PedidosPorCliente from orders o, customers c
where c.customerId = o.customerId AND c.city = 'london'
group by o.customerid;

select o.customerId, count(*) as PedidosPorCliente from orders o 
INNER JOIN customers c
on c.customerId = o.customerId where c.city = 'london'
group by o.customerid;

-- Ordernar la lista anterior por orden de pedidos (de más a menos)  

select o.customerId, count(*) as PedidosPorCliente from orders o, customers c
where c.customerId = o.customerId AND c.city = 'london'
group by o.customerid ORDER BY PedidosPorCliente desc;


-- En la tabla empleados Employees tenemos el puesto que ocupa cada empleado. Necesitamos un listado del número de personas que ocupan cada puesto

SELECT title, count(*) númeroPersonas FROM northwind.employees group by title;