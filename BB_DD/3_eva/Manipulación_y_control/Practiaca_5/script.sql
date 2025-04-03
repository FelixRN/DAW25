-- Anotaciones teóricas:

-- Visualizar los usuarios (los usuarios se almacenan en la tabla user): select * from mysql.user;
-- Crear usuarios: CREATE USER 'nombre_usuario'@'localhost' IDENTIFIED BY 'tu_contrasena'
-- Borrar usuarios: DROP USER ‘usuario_prueba’@‘localhost’;
-- Proporcionar privilegios: GRANT ALL PRIVILEGES ON *.* TO 'nombre_usuario'@'localhost';
-- Eliminar privilegios: REVOKE [permiso] ON [nombre de base de datos].[nombre de tabla] FROM ‘[nombre de usuario]’@‘localhost’;
-- Para poder probar un usuario, tienes que ir a la pantalla principal de Workbench y añadir una nueva conexión para ese usuario
-- Las operaciones anteriores también se pueden realizar con la interfaz gráfica del SGBD
-- Importante: para ver los cambios de permisos de un usuario, hay que cerrar la conexión y volver a cargarla.

-- Práctica:

-- Crear un copia de seguridad de una BBDD
CREATE TABLE productos_2 AS SELECT * FROM productos;

-- Importar una copia de seguridad desde un script

-- Crea varios usuarios en la BBDD
CREATE USER Felix IDENTIFIED BY 'pasion';

CREATE USER 'Elena' IDENTIFIED BY 'dulzura';

CREATE USER Lucia IDENTIFIED BY 'sabor';

-- Borra un usuario de los creados
DROP USER 'Lucia';
-- Otorga diferentes permisos al usuario sobre diferentes objetos. Realiza pruebas con ese usuario.
 GRANT ALL PRIVILEGES ON neptuno.* TO 'Elena';
 

FLUSH PRIVILEGES;
 
-- GRANT ON privilegios TO 'usuario'@'host_de_conexion'
-- -> IDENTIFIED BY 'password' WITH GRANT OPTION;

-- Elimina permisos a determinados usuarios. Realiza pruebas con ese usuario.
REVOKE SELECT ON neptuno.* FROM 'Elena';
FLUSH PRIVILEGES;