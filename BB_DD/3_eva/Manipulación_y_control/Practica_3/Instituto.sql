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

-- Asignar a todas las asignaturas 6 horas, excepto a programación que tiene 8 horas y tutoría que tiene 1

-- Asignar la categoría 'C' a todos los alumnos que no tengan la asignatura de 'Redes 2'

-- Modificar las asignaturas 'Tutoría' y 'Redes 2' como asignaturas Obligatorias

-- Poner como delegada a Ana Bravo a todos los alumnos.

-- Borrar a todos los alumnos que tengan más de 25 años

-- Borrar todos los datos de la tabla auxiliar per1

-- Borrar de cursa_asignaturas que tiene el dni '27965528X'

-- Borra todos los alumnos que tengan alguna asignatura cuya descripción sea 'Obligatoria'



