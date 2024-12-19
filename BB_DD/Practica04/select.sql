select * from alumnos where dni_Alumno='12345679p';

select * from alumnos where dni_delegado='12345679p' ;

update alumnos set dni_alumno='99999999o' where dni_alumno='12345679p';

delete from alumnos where dni_alumno='12345679p';

select * from alumnos where dni_delegado='12345679p' ;

select * from alumnos;

select * from cursa_asignaturas where dni_alumno='12345689d';

update alumnos set dni_alumno='99999999o' where dni_alumno='12345689d';

select cursa_asignaturas.dni_alumno,asignaturas.* from cursa_asignaturas, asignaturas where dni_alumno='12345689d' and cursa_asignaturas.id_asignatura=asignaturas.id_asignatura;

select cursa_asignaturas.dni_alumno,asignaturas.* from cursa_asignaturas, asignaturas where dni_alumno='99999999o' and cursa_asignaturas.id_asignatura=asignaturas.id_asignatura;

select cursa_asignaturas.dni_alumno,asignaturas.* from cursa_asignaturas, asignaturas where asignaturas.id_asignatura=1 and cursa_asignaturas.id_asignatura=asignaturas.id_asignatura;

delete from asignaturas where id_asignatura=1;

select * from asignaturas;