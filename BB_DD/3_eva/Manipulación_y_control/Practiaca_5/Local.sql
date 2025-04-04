-- Vemos los usuarios que hay en el sistema
select * from mysql.user;

-- Creamos un usuario nuevo, pero en este momento no tiene permisos para nada
CREATE USER 'teresa'@'localhost' IDENTIFIED BY '1234';
CREATE USER 'curioso'@'localhost' IDENTIFIED BY 'curioso';

-- Damos permiso de select a curioso
GRANT select ON neptuno.productos TO 'curioso'@'localhost';

-- Damos permisos de control total
GRANT ALL PRIVILEGES ON * . * TO 'teresa'@'localhost';

-- Se hacen efectivos los permisos
FLUSH PRIVILEGES;

-- Vemos los permisos que tiene un usuario
SHOW GRANTS for 'curioso'@'localhost';
SHOW GRANTS for 'teresa'@'localhost';

-- Borramos el usuario
DROP USER 'curioso'@'localhost';

-- Quitamos el permiso de select al usuario teresa
REVOKE SELECT ON neptuno.* FROM 'teresa'@'localhost';
FLUSH PRIVILEGES;