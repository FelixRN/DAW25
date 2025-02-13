
-- Nos devuelve solamente las coincidencias de las 2 tablas
SELECT FirstName, Reward, Month FROM employees e 
INNER JOIN rewards r on e.EmployeeID = r.EmployeeID;

-- Nos devuelve la tabla "a(employyes)" completa y si hay coincidencia los muestra y si no, también
SELECT FirstName, Reward, Month FROM employees e 
LEFT JOIN rewards r on e.EmployeeID = r.EmployeeID;

-- El RIGHT JOIN es lo mismo que el LEFT pero al reves
SELECT FirstName, Reward, Month FROM employees e 
RIGHT JOIN rewards r on e.EmployeeID = r.EmployeeID;

-- SIMULANDO UN FULL JOIN CON UNA SIMULACION DE RIGHT Y LEFT JOIN---------------

SELECT FirstName, Reward, Month FROM employees e 
LEFT JOIN rewards r on e.EmployeeID = r.EmployeeID

UNION 

SELECT FirstName, Reward, Month FROM employees e 
RIGHT JOIN rewards r on e.EmployeeID = r.EmployeeID;

-- CROSS JOIN multiplica cada valor de una fila con todas las de la otra tabla
-- SELECT * FROM employees e CROSS JOIN rewards r
SELECT * FROM employees e, rewards r;

-- Sin el WHERE es un CROSS JOIN, con el WHERE es un INNER JOIN(JOIN IMPLICITO)
SELECT * FROM employees e, rewards r WHERE e.EmployeeID = r.EmployeeID

