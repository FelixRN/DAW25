-- Devuelve un listado con el primer apellido, segundo apellido y el nombre de todos los alumnos. El listado deberá estar ordenado alfabéticamente de menor a mayor por el primer apellido, segundo apellido y nombre.
select * from persona;
select apellido1, apellido2, nombre from persona where tipo like "%alumno%" order by apellido1, apellido2, nombre;

-- Averigua el nombre y los dos apellidos de los alumnos que no han dado de alta su número de teléfono en la base de datos.
select * from persona;
select nombre, apellido1, apellido2 from persona where tipo like "%alumno%" and telefono is null; 

-- Devuelve el listado de los alumnos que nacieron en 1999.
select * from persona where tipo like "%alumno%" and fecha_nacimiento = 1999;

-- Devuelve el listado de profesores que no han dado de alta su número de teléfono en la base de datos y además su nif termina en K.
select nombre, apellido1, apellido2 from persona where tipo like "%profesor%" and telefono is null and nif like "%k";

-- Devuelve el listado de las asignaturas que se imparten en el primer cuatrimestre, en el tercer curso del grado que tiene el identificador 7.
select * from asignatura where cuatrimestre = 1  and curso = 3 and id_grado = 7;

-- Consultas multitabla (Composición interna)

-- 6. Devuelve un listado con los datos de todas las alumnas que se han matriculado alguna vez en el Grado en Ingeniería Informática (Plan 2015).
select * from grado;
select * from persona;

select * from persona p INNER JOIN alumno_se_matricula_asignatura am on  p.id = am.id_alumno
inner join asignatura a on am.id_asignatura = a.id
inner join grado g on a.id_grado = g.id 
where p.sexo like "%M%" and g.id = 4;

-- 7.Devuelve un listado con todas las asignaturas ofertadas en el Grado en Ingeniería Informática (Plan 2015).
select * from asignatura;
select * from asignatura a INNER JOIN grado g 
on g.id = a.id_grado
where g.id = 4;

-- 8.Devuelve un listado de los profesores junto con el nombre del departamento al que están vinculados. 
-- El listado debe devolver cuatro columnas, primer apellido, segundo apellido, nombre y nombre del departamento. 
-- El resultado estará ordenado alfabéticamente de menor a mayor por los apellidos y el nombre.

SELECT p.apellido1, p.apellido2, p.nombre, d.nombre AS departamento
FROM profesor pro
INNER JOIN departamento d ON d.id = pro.id_departamento
INNER JOIN persona p ON p.id = pro.id_profesor
ORDER BY 1, 2, 3;
-- ORDER BY p.apellido1 ASC, p.apellido2 ASC, p.nombre ASC;



-- 9. Devuelve un listado con el nombre de las asignaturas, año de inicio y año de fin del curso escolar del alumno con nif 26902806M.

-- 10. Devuelve un listado con el nombre de todos los departamentos que tienen profesores que imparten alguna asignatura en el Grado en Ingeniería Informática (Plan 2015).

-- 11. Devuelve un listado con todos los alumnos que se han matriculado en alguna asignatura durante el curso escolar 2018/2019.