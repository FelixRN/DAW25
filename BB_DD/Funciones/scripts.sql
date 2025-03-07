
-- 1. Aumentar un 10% el precio de todos los productos
select ProductName, UnitPrice *1.1 from products;
-- 2. Aumentar el precio un 15% de los productos con la categoría de quesos (cheeses)
select ProductName, CategoryID, round(UnitPrice *1.10, 2) as Precio from products 
WHERE CategoryID = 4;

-- 3. Cómo hacer el update anterior si no supiéramos el id de la categoría
select p.ProductName, c.CategoryID, round(p.UnitPrice *1.15, 2) as Precio from products p
inner join categories c on c.CategoryID = p.CategoryID
WHERE c.CategoryID = 4;

-- 4. Sacar un listado con la cantidad de dinero que tenemos en stock de cada producto. (Que se vea el nombre del producto y el Dinero invertido en stock)

-- 5. Sacar un informe que nos muestre un listado de pedidos con el nombre del cliente y lo que se ha gastado en el pedido (quantity * unitPrice) - Discount.

-- 6. Sacar un informe que nos muestre un listado de pedidos con el nombre del cliente, el nombre del producto comprado y lo que se ha gastado en el pedido (quantity * unitPrice) - Discount. 

-- 7. Sacar una lista de productos por encima del precio medio (nota: para calcular la media, utilizar la función AVG).

-- 8. Si el coste del flete (freight, coste de envío) es mayor o igual a 500$ ha de ser gravado con un 10%. Crear un informe que muestre: el orderId, el coste del flete (freight) y el coste del flete con el impuesto para todos los pedidos (orders) de 500$ o más.