SELECT * FROM Empleados;
SELECT * FROM Departamentos;

-- Cláusula INNER JOIN o JOIN
-- Busca coincidencias entre 2 tablas, en función a una columna que tienen en común. Sólo la intersección se mostrará en los resultados.
-- Excluye los que no tienen coincidencias

-- Listar a los empleados e indicar el nombre del departamento al que pertenecen
SELECT * FROM Empleados E INNER JOIN Departamentos D ON E.DepartamentoId = D.DepartamentoId;

SELECT * FROM Empleados as E, Departamentos as D where E.DepartamentoId = D.DepartamentoId;

SELECT E.Nombre as 'Empleado', D.Nombre_Depto as 'Departamento' FROM Empleados E JOIN Departamentos D ON E.DepartamentoId = D.DepartamentoId;

-- Cláusula NATURAL JOIN
SELECT * FROM Empleados NATURAL JOIN Departamentos;

-- Cláusula LEFT JOIN
-- Damos prioridad a la tabla de la izquierda, y buscamos en la tabla derecha.
-- Si no existe ninguna coincidencia para alguna de las filas de la tabla de la izquierda, de igual, todos los resultados de la primera tabla se muestran.

SELECT E.Nombre as 'Empleado', D.Nombre_Depto as 'Departamento' FROM Empleados E LEFT JOIN Departamentos D ON E.DepartamentoId = D.DepartamentoId;


-- Cláusula RIGHT JOIN
-- Similar, pero aquí se da prioridad a la tabla de la derecha mostrando todas las filas de la tabla de la derecha

SELECT E.Nombre as 'Empleado', D.Nombre_Depto as 'Departamento' FROM Empleados E RIGHT JOIN Departamentos D ON E.DepartamentoId = D.DepartamentoId;


-- CROSS JOIN
-- Muestra el producto cruzado de todos los registros de todas las tablas implicadas
SELECT * FROM Empleados CROSS JOIN Departamentos;


-- Cláusula LEFT OUTER JOIN -- Simular un MINUS
-- Muestra sólo los valores de la tabla de la izquierda, sin valores en la intersección

SELECT E.Nombre as 'Empleado', D.Nombre_Depto as 'Departamento' FROM Empleados E LEFT JOIN Departamentos D ON E.DepartamentoId = D.DepartamentoId 
where D.DepartamentoId is null;

-- Cláusula RIGTH OUTER JOIN
-- Muestra sólo los valores de la tabla de la derecha, sin valores en la intersección

SELECT E.Nombre as 'Empleado', D.Nombre_Depto as 'Departamento' FROM Empleados E RIGHT JOIN Departamentos D ON E.DepartamentoId = D.DepartamentoId 
where E.DepartamentoId is null;

-- Cláusula FULL OUTER JOIN
-- No existe como tal en MYSQL, hay que hacerla con UNION

SELECT * FROM Empleados E LEFT JOIN Departamentos D ON E.DepartamentoId = D.DepartamentoId
UNION
SELECT * FROM Empleados E RIGHT JOIN Departamentos D ON E.DepartamentoId = D.DepartamentoId;

-- Cláusula FULL OUTER JOIN (Muestra sólo lo que no tienen en común)
SELECT * FROM Empleados E LEFT JOIN Departamentos D ON E.DepartamentoId = D.DepartamentoId where D.departamentoId is null
UNION
SELECT * FROM Empleados E RIGHT JOIN Departamentos D ON E.DepartamentoId = D.DepartamentoId where E.departamentoId is null;


-- UNION
select nombre from empleados where DepartamentoId = 31
UNION
select nombre from empleados where DepartamentoId = 33;

-- INTERSEC
select nombre from empleados where DepartamentoId IN (
select DepartamentoId from empleados where DepartamentoId = 31 OR DepartamentoId = 33);

-- MINUS
SELECT E.Nombre as 'Empleado', D.Nombre_Depto as 'Departamento' FROM Empleados E LEFT JOIN Departamentos D ON E.DepartamentoId = D.DepartamentoId 
where D.DepartamentoId is null;
 