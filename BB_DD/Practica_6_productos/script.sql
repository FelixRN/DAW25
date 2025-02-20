-- 1. Selecciona los nombres de todos los productos de la tienda.
select name from Products;
-- 2. Selecciona los nombres y los precios de todos los productos de la tienda.
select name, price  from Products;
-- 3. Selecciona el nombre de los productos con un precio menor o igual a $200.
select name from Products WHERE price <=200;
-- 4. Selecciona todos los productos con un precio entre $60 y $120.
select name from Products WHERE price >= 60 and price >= 120;
-- 5. Selecciona el nombre y el precio en centavos (es decir, el precio debe multiplicarse por 100).
select name, (100 * price) price from Products ;
-- 6. Calcula el precio promedio de todos los productos.
select AVG(price) Price from Products;
-- 7. Calcula el precio promedio de todos los productos con código de fabricante igual a 2.
select * from Products;
select AVG(price) Price from Products where code = 2;
-- 8. Calcula el número de productos con un precio mayor o igual a $180.
select count(Manufacturer) Manufacturer from Products WHERE price >= 180;
-- 9. Selecciona el nombre y el precio de todos los productos con un precio mayor o igual a $180 y ordena primero por precio (en orden descendente) y luego por nombre (en orden ascendente).
select name, price from Products where price >=180 order by price DESC,  name asc ;
-- 10. Selecciona todos los datos de los productos, incluidos todos los datos del fabricante de cada producto.
select * from Products, Manufacturers;
-- 11. Selecciona el nombre del producto, el precio y el nombre del fabricante de todos los productos.
select p.name, p.price, m.name from Products p, Manufacturers m;
-- 12. Selecciona el precio promedio de los productos de cada fabricante, mostrando solo el código del fabricante.
select * from Manufacturers;
select p.Manufacturer, AVG(p.price) AVG_Price from Products p group by p.Manufacturer;
-- 13. Selecciona el precio promedio de los productos de cada fabricante, mostrando el nombre del fabricante.
select m.Name, AVG(p.price) AVG_Price from Products p,Manufacturers m group by m.Name;
-- 14. Selecciona los nombres de los fabricantes cuyos productos tienen un precio promedio mayor o igual a $150.
select m.name from Manufacturers m, Products p where p.price >= 150;
-- 15. Selecciona el nombre y precio del producto más económico.
select name, price from Products order by price ASC LIMIT 1;
-- 16. Selecciona el nombre de cada fabricante junto con el nombre y el precio de su producto más caro.
select m.name, p.name, p.price from Manufacturers m, Products p order by price desc limit 1;
 -- 17. Selecciona el nombre de cada fabricante que tenga un precio promedio superior a $145 y contenga al menos 2 productos diferentes.
select p.name, m.name, avg(p.price) Price from Manufacturers m, Products p group by p.name HAVING Price > 145 limit 2;
-- 18 Mostrar: nombre fabricante, precio promedio y artículos diferentes