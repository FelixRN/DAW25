-- BBDD pruebas

use pruebas;

select * from tblusuarios;

# Contar el número de usuarios por marca de teléfono
SELECT marca, COUNT(*) FROM tblUsuarios GROUP BY marca;

# Listar nombre y teléfono de los usuarios con teléfono que no sea de la marca LG
SELECT nombre, telefono FROM tblUsuarios WHERE marca <> "LG";

# Listar las diferentes compañias en orden alfabético ascendentemente
SELECT DISTINCT compañia FROM tblUsuarios ORDER BY compañia ASC;

# Calcular la suma de los saldos de los usuarios de la compañia telefónica UNEFON
SELECT SUM(saldo) FROM tblUsuarios WHERE compañia = 'UNEFON';

# Mostrar el email de los usuarios que usan hotmail
SELECT email FROM tblUsuarios WHERE email LIKE "%hotmail.com";

# Listar los nombres de los usuarios sin saldo o inactivos
SELECT nombre FROM tblUsuarios WHERE NOT activo OR saldo <= 0;

# Listar el login y teléfono de los usuarios con compañia telefónica IUSACELL o TELCEL
SELECT usuario, telefono FROM tblUsuarios WHERE compañia IN('IUSACELL', 'TELCEL');

# Listar las diferentes marcas de celular en orden alfabético ascendentemente
SELECT DISTINCT marca FROM tblUsuarios ORDER BY marca DESC;

# Listar las diferentes marcas de celular en orden alfabético aleatorio
SELECT DISTINCT marca FROM tblUsuarios ORDER BY RAND();


# Listar nombre y teléfono de los usuarios con teléfono que no sea de la marca MOTOROLA o NOKIA
SELECT nombre, telefono FROM tblUsuarios WHERE marca NOT IN('MOTOROLA', 'NOKIA');

# Calcular la suma de los saldos de los usuarios de la compañia telefónica TELCEL
SELECT SUM(saldo) as suma FROM tblUsuarios WHERE compañia = 'TELCEL';