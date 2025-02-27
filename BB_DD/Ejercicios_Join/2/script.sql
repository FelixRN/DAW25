-- Enumere todos los productos que tienen menos de 150 calorías. 
-- Para cada producto, muestre su nombre (renombre la columna product) 
-- y el nombre del departamento donde se puede encontrar (nombre la columna department).

select pt.name, n.calories, d.name from product pt
INNER JOIN nutrition_data n on n.product_id = pt.id
INNER JOIN department d on d.id = pt.department_id
WHERE n.calories < 150 ;


SELECT p.name AS product, d.name AS department FROM department d
JOIN product p ON d.id = p.department_id
JOIN nutrition_data nd ON nd.product_id = p.id
WHERE nd.calories < 150;



-- Nombre de la empresa que lo ha producido (nombre de la columna producer_name).
-- Nombre del departamento donde se encuentra el producto (nómbrelo department_name).
-- Nombre del producto (nómbralo product_name).
-- Número total de carbohidratos en el producto.
-- Su consulta debe seguir considerando los productos sin información sobre producer_id o department_id.

select pr.id, pr.name, d.name, p.name, n.carbohydrate from product p
INNER JOIN producer pr on pr.id = p.producer_id
INNER JOIN department d on d.id = p.department_id
INNER JOIN nutrition_data n on n.product_id = p.id;

SELECT prod.name AS producer_name, d.name AS department_name, p.name AS product_name, nd.carbohydrate FROM product p
LEFT JOIN producer prod ON prod.id = p.producer_id
LEFT JOIN department d ON d.id = p.department_id
LEFT JOIN nutrition_data nd ON nd.product_id = p.id;

select * from sales_history;
select * from nutrition_data;
select * from product;
select * from producer;
select * from department;

-- Alias las columnas como product_name, product_price, producer_name, y department_name, respectivamente. 
-- Incluya todos los productos, incluso aquellos sin productor o departamento. Incluya también los productores y departamentos sin producto.

select p.name as Nombre_producto, p.price as Precio_producto, pr.name as Productora , d.name as Departamento from product p 
LEFT JOIN producer pr on pr.id = p.producer_id
LEFT JOIN department d on d.id = p.department_id;




