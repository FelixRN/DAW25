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

<<<<<<< HEAD
-- 8.Devuelve un listado de los profesores junto con el nombre del departamento al que están vinculados. 
-- El listado debe devolver cuatro columnas, primer apellido, segundo apellido, nombre y nombre del departamento. 
-- El resultado estará ordenado alfabéticamente de menor a mayor por los apellidos y el nombre.

SELECT p.apellido1, p.apellido2, p.nombre, d.nombre AS departamento
FROM profesor pro
INNER JOIN departamento d ON d.id = pro.id_departamento
INNER JOIN persona p ON p.id = pro.id_profesor
ORDER BY 1, 2, 3;
-- ORDER BY p.apellido1 ASC, p.apellido2 ASC, p.nombre ASC;


=======
-- 8.Devuelve un listado de los profesores junto con el nombre del departamento al que están vinculados. El listado debe devolver cuatro columnas, 
-- primer apellido, segundo apellido, nombre y nombre del departamento. 
-- El resultado estará ordenado alfabéticamente de menor a mayor por los apellidos y el nombre.
select * from profesor;
select * from departamento;
select * from persona;

select p.apellido2, p.apellido1, p.nombre, d.nombre AS departamento from profesor pro 
INNER JOIN departamento d ON d.id =  pro.id_departamento 
INNER JOIN persona p ON p.id = pro.id_profesor
ORDER BY 1,2,3,4;

-- ORDER BY p.apellido2 ASC, p.apellido2 ASC, p.nombre ASC, d.nombre ASC;


-- 9. Devuelve un listado con el nombre de las asignaturas, 
-- año de inicio y año de fin del curso escolar del alumno con nif 26902806M.
select * from persona;

select a.nombre, c.anyo_inicio, c.anyo_fin from asignatura a
INNER JOIN curso_escolar c ON c.id = a.id
INNER JOIN persona p ON p.id = a.id
WHERE p.nif LIKE "%26902806M%";

-- 10. Devuelve un listado con el nombre de todos los departamentos
-- que tienen profesores que imparten alguna asignatura en el Grado en Ingeniería Informática (Plan 2015).

select d.nombre from profesor pro
INNER JOIN departamento d ON d.id = pro.id_departamento
INNER JOIN asignatura a ON a.id_profesor = pro.id_profesor
INNER JOIN grado g ON g.id = a.id_grado
WHERE g.nombre LIKE "Grado en Ingeniería Informática (Plan 2015)";

-- 11. Devuelve un listado con todos los alumnos que se han matriculado en alguna asignatura 
-- durante el curso escolar 2018/2019.
select * from curso_escolar;

select * from alumno_se_matricula_asignatura am
INNER JOIN persona p ON p.id = am.id_alumno
INNER JOIN curso_escolar c ON c.id = am.id_asignatura
INNER JOIN asignatura asig ON asig.id = c.id
WHERE c.anyo_inicio = 2018 AND c.anyo_fin = 2019;

-- Consultas multitabla (Composición externa)
-- Resolver todas las consultas utilizando las cláusulas LEFT JOIN y RIGHT JOIN.

-- 12.  Devuelve un listado con los nombres de todos los profesores y los departamentos que tienen vinculados. 
-- El listado también debe mostrar aquellos profesores que no tienen ningún departamento asociado. 
-- El listado debe devolver cuatro columnas, nombre del departamento, primer apellido, segundo apellido y nombre del profesor. 
-- El resultado estará ordenado alfabéticamente de menor a mayor por el nombre del departamento, apellidos y el nombre.

select d.nombre, p.apellido1, p.apellido2, p.nombre from profesor pro
LEFT JOIN  persona p ON p.id = pro.id_profesor
LEFT JOIN departamento d ON d.id = pro.id_departamento
ORDER BY d.nombre ASC, p.apellido1 ASC, p.apellido2 ASC, p.nombre ASC;

-- 13.  Devuelve un listado con los profesores que no están asociados a un departamento.
select pro.id_profesor from profesor pro
LEFT OUTER JOIN departamento d ON d.id = pro.id_departamento
WHERE id IS NULL;


-- 14.  Devuelve un listado con los departamentos que no tienen profesores asociados.
select d.nombre from departamento d
LEFT OUTER JOIN profesor pro ON pro.id_departamento = d.id
WHERE pro.id_profesor IS NULL;

-- 15.  Devuelve un listado con los profesores que no imparten ninguna asignatura.
<<<<<<< HEAD
select p.*, pro.id_departamento from profesor pro
LEFT JOIN asignatura asig ON asig.id_profesor = pro.id_profesor
inner join persona p on p.id = pro.id_profesor
where asig is null;
=======
select * from profesor pro
LEFT OUTER JOIN asignatura asig ON asig.id = pro.id_profesor
where 
>>>>>>> a2b7f89a3bcf2bdf93a81011bb67e991743c2a3d
>>>>>>> dba5733f0d4408ca3d604d619d8128c3b092f187

-- 16.  Devuelve un listado con las asignaturas que no tienen un profesor asignado.
select a.* from profesor pr left join profesor p on a.id_profesor = pr.id_profesor where pr.id_profesor is null;
-- 17.  Devuelve un listado con todos los departamentos que tienen alguna asignatura que no se haya impartido en ningún curso escolar. El resultado debe mostrar el nombre del departamento y el nombre de la asignatura que no se haya impartido nunca.
select dp.nombre, a.nombre from departamento do inner join profesor pr on dp.id = pr.id_departamento
inner join asignatura a on a.id_profesor = pr.id_profesor
left join alumno_se_matricula_asignatura asm on a.id = asm.id_asignatura
where asm.id_asignatura is null
group by dp.id;

select count(pe.id) num;

#17.  Devuelve un listado con todos los departamentos que tienen alguna asignatura que no se haya impartido en ningún curso escolar. 
-- El resultado debe mostrar el nombre del departamento y el nombre de la asignatura que no se haya impartido nunca.
select dp.nombre, a.nombre from departamento dp inner join profesor pr on dp.id = pr.id_departamento
inner join asignatura a on a.id_profesor = pr.id_profesor
left join alumno_se_matricula_asignatura asm on a.id = asm.id_asignatura
where asm.id_asignatura is null 
group by dp.id;

-- No importa el órden
select dp.* from asignatura a
inner join profesor pr on a.id_profesor = pr.id_profesor
inner join departamento dp on dp.id = pr.id_departamento
left join alumno_se_matricula_asignatura asm on a.id = asm.id_asignatura
where asm.id_asignatura is null 
group by dp.id;


-- Consultas resumen

#18.  Devuelve el número total de alumnas que hay.
select count(pe.id) num_alumnas from persona pe where pe.tipo = "alumno" and pe.sexo = "M";

#19.  Calcula cuántos alumnos nacieron en 1999.
select count(id) as num_alumnos from persona where fecha_nacimiento like '%1999%' and tipo = "alumno";
select count(id) as num_alumnos from persona WHERE YEAR(fecha_nacimiento) IN (1999) and tipo = "alumno";

#20.  Calcula cuántos profesores hay en cada departamento. El resultado sólo debe mostrar dos columnas, una con el nombre del departamento y otra con el número de profesores que hay en ese departamento. 
-- El resultado sólo debe incluir los departamentos que tienen profesores asociados y deberá estar ordenado de mayor a menor por el número de profesores.
select dp.nombre, count(dp.id) numeroDeProfesoresPorDepartamento from departamento dp
inner join profesor pr on pr.id_departamento = dp.id
group by dp.id order by numeroDeProfesoresPorDepartamento desc;

#21.  Devuelve un listado con todos los departamentos y el número de profesores que hay en cada uno de ellos. 
-- Tenga en cuenta que pueden existir departamentos que no tienen profesores asociados. 
-- Estos departamentos también tienen que aparecer en el listado.
select 
CASE WHEN dp.id in (select dp.id from departamento dp
inner join profesor pr on pr.id_departamento = dp.id
) THEN count(id) 
ELSE 0
END AS NumeroProfesoresPorDepartamento,
dp.nombre
from departamento dp
left join profesor pr on pr.id_departamento = dp.id
group by dp.id;

select dp.nombre, count(pr.id_profesor) numeroDeProfesoresPorDepartamento from departamento dp
left join profesor pr on pr.id_departamento = dp.id
group by dp.id;


#22.  Devuelve un listado con el nombre de todos los grados existentes en la base de datos y el número de asignaturas que tiene cada uno. 
-- Tenga en cuenta que pueden existir grados que no tienen asignaturas asociadas. 
-- Estos grados también tienen que aparecer en el listado. El resultado deberá estar ordenado de mayor a menor por el número de asignaturas.
select 
CASE WHEN  gr.id in (
select g.id from grado g
inner join asignatura a on a.id_grado = g.id
) THEN count(gr.id) 
ELSE 0
END AS NumeroAsignaturasPorGrado,
gr.nombre
from grado gr
left join asignatura a on a.id_grado = gr.id
group by gr.id
order by NumeroAsignaturasPorGrado desc;

select gr.id, gr.nombre, count(a.id) from grado gr
left join asignatura a on a.id_grado = gr.id
group by gr.id
order by 3 desc;

#23.  Devuelve un listado con el nombre de todos los grados existentes en la base de datos y el número de asignaturas que tiene cada uno, de los grados que tengan más de 40 asignaturas asociadas.
select g.nombre, count(a.id) as cuentaAsignaturasPorGrado from grado g 
inner join asignatura a on a.id_grado = g.id group by g.id having count(a.id) >40;

#24.  Devuelve un listado que muestre el nombre de los grados y la suma del número total de créditos que hay para cada tipo de asignatura. 
-- El resultado debe tener tres columnas: nombre del grado, tipo de asignatura y la suma de los créditos de todas las asignaturas que hay de ese tipo. 
-- Ordene el resultado de mayor a menor por el número total de créditos.
select g.nombre, a.tipo, sum(a.creditos) as creditos from asignatura a
inner join grado g on g.id = a.id_grado
group by a.id_grado, a.tipo
order by creditos desc;

#25.  Devuelve un listado que muestre cuántos alumnos se han matriculado de alguna asignatura en cada uno de los cursos escolares. 
-- El resultado deberá mostrar dos columnas, una columna con el año de inicio del curso escolar y otra con el número de alumnos matriculados.
select anyo_inicio, count(asm.id_alumno) as 'alumnos matriculados' from curso_escolar ce
inner join alumno_se_matricula_asignatura asm on ce.id = asm.id_curso_escolar
group by ce.anyo_inicio;

select * from curso_escolar;
select * from alumno_se_matricula_asignatura;

#26.  Devuelve un listado con el número de asignaturas que imparte cada profesor. El listado debe tener en cuenta aquellos profesores que no imparten ninguna asignatura. 
-- El resultado mostrará cinco columnas: id, nombre, primer apellido, segundo apellido y número de asignaturas. El resultado estará ordenado de mayor a menor por el número de asignaturas.
select 
CASE WHEN  pr.id_profesor in (
select pr.id_profesor from profesor pr
inner join asignatura a on a.id_profesor = pr.id_profesor
) THEN count(a.id) 
ELSE 0
END AS AsignaturasPorProfesor,
pe.nombre,pe.apellido1,pe.apellido2
from profesor pr
left join asignatura a on a.id_profesor= pr.id_profesor
inner join persona pe on pe.id = pr.id_profesor
group by pr.id_profesor
order by AsignaturasPorProfesor desc;

select pr.id_profesor, pe.nombre, pe.apellido1, pe.apellido2, count(a.id) AsignaturasPorProfesor
from profesor pr
left join asignatura a on a.id_profesor= pr.id_profesor
inner join persona pe on pe.id = pr.id_profesor
group by pr.id_profesor
order by AsignaturasPorProfesor desc;

-- Subconsultas

#27.  Devuelve todos los datos del alumno más joven.
select * from persona where tipo = "alumno"
and fecha_nacimiento =  (select max(fecha_nacimiento) from persona where tipo = "alumno");

#28.  Devuelve un listado con los profesores que no están asociados a un departamento.
select * from profesor
where id_departamento not in (select id from departamento);

select * from profesor p left join departamento d on p.id_departamento=d.id where d.id is null;

#29.  Devuelve un listado con los departamentos que no tienen profesores asociados.
select * from departamento
where id not in (select id_departamento from profesor);

#30.  Devuelve un listado con los profesores que tienen un departamento asociado y que no imparten ninguna asignatura.
select * from profesor 
where id_profesor in (select pr.id_profesor from profesor pr left join asignatura a on pr.id_profesor = a.id_profesor
where a.id is null) 
and id_profesor in (select pr.id_profesor from profesor pr inner join departamento d on pr.id_departamento=d.id);

select pr.id_profesor from profesor pr left join asignatura a on pr.id_profesor = a.id_profesor where a.id is null; -- profesores que no imparten asignaturas
select pr.id_profesor from profesor pr inner join departamento d on pr.id_departamento=d.id; -- profesores con los departamentos asociados

#31.  Devuelve un listado con las asignaturas que no tienen un profesor asignado.
select * from asignatura where id_profesor is null;

#32. Devuelve un listado con todos los departamentos que no han impartido asignaturas en ningún curso escolar.
select dp.* from profesor pr
inner join departamento dp on dp.id = pr.id_departamento
where id_profesor in (select pr.id_profesor from profesor pr
left outer join asignatura a on pr.id_profesor = a.id_profesor
where a.id is null     -- profesores que no han impartido asignaturas
) group by id;

select pr.id_profesor from profesor pr
left outer join asignatura a on pr.id_profesor = a.id_profesor
where a.id is null;