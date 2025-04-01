-- Cambia la descripción del tipo de asignatura 'Libre_configuración' por 'De libre configuración'
select * from tipo_asignatura;
UPDATE tipo_asignatura SET descripcion = 'Libre_configuración' 
WHERE descripcion like 'De_libre_configuración';

-- Juan Francisco ya no cursa 'Desarrollo en entorno servidor', ha cambiado de asignatura a 'Programación'
select * from alumnos;
select * from cursa_asignaturas;
select * from asignaturas;

update cursa_asignaturas set id_asignatura = (select id_asignatura from asignaturas where nombre like 'Programación') 
where id_asignatura = (select id_asignatura from asignaturas where nombre like 'Desarrollo en entorno servidor') 
AND dni_alumno = ( select dni_alumno from alumnos where nombre like 'JUAN FRANCISCO');

-- Introducir un nueva asignatura llamada 'Tutoría'. Cambiar la asignatura 'Redes 1' por 'Tutoría' del alumno con el dni '82434905I'
insert into asignaturas(id_asignatura, nombre) values (6, 'Tutoria');

update cursa_asignaturas set id_asignatura = (select id_asignatura from asignaturas where nombre like 'Tutoria')
where id_asignatura = (select id_asignatura from asignaturas where nombre like 'Redes 1') 
AND dni_alumno = '82434905I';

-- Asignar a todas las asignaturas 6 horas, excepto a programación que tiene 8 horas y tutoría que tiene 1
select * from asignaturas;

update asignaturas set horas = 6 WHERE 
nombre like 'Gestión de bases de datos' or
nombre like 'Redes 1' or
nombre like 'Redes 2' or
nombre like 'Desarrollo en entorno servidor';

update asignaturas set horas = 8 where nombre like 'Programación';

-- Asignar la categoría 'C' a todos los alumnos que no tengan la asignatura de 'Redes 2'
select * from cursa_asignaturas;

update alumnos set categoria = 'c' where
dni_alumno = any(select dni_alumno from cursa_asignaturas c
inner join asignaturas a on c.id_asignatura = a.id_asignatura
where nombre != '%Redes 2%');

-- Modificar las asignaturas 'Tutoría' y 'Redes 2' como asignaturas Obligatorias
select * from tipo_asignatura;
select * from asignaturas;

update asignaturas set tipo = (select tipo from tipo_asignatura where nombre like 'Obligatoria')
where nombre = 'Redes 2'and nombre like 'Tutoria' ;

-- update asignaturas set tipo = '3' where nombre = 'Tutoria';

-- Poner como delegada a Ana Bravo a todos los alumnos.
select * from alumnos;

update alumnos set dni_delegado =(select * from (select dni_delegado from alumnos where nombre like 'ANA Bravo Benítez') as tabla2)
where nombre != 'ANA Bravo Benítez';

update alumnos set dni_delegado = '522520305F' where nombre != 'ANA Bravo Benítez';

-- Borrar a todos los alumnos que tengan más de 25 años
select * from alumnos;

delete from alumnos where edad < 25;
-- Borrar todos los datos de la tabla auxiliar per1
select * from per1;

-- Borrar de cursa_asignaturas que tiene el dni '27965528X'
delete from cursa_asignaturas where dni_alumno like '27965528X';

-- Borra todos los alumnos que tengan alguna asignatura cuya descripción sea 'Obligatoria'
delete from alumnos where dni_alumno = ANY (select * from alumnos
inner join cursa_asigntaura as cursa on a.dni_alumno = cursa.dni_alumno
inner join asignaturas as asi on asi.id_asignautra = crursa.id_asignaturas
inner join tipo_asignaturas tipo on tipo.tipo
where descripcion like 'Obligatoria');


