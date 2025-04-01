-- Ayuda: se pueden realizar INSERT utilizando una subselect. Ej:

-- INSERT INTO tabla (campo1, campo2, campo3) VALUES (1, 2, (SELECT  c3 FROM otra_tabla); La sentencia SELECT puede contener cualquier tipo filtro, orden, limitación, ect.
-- INSERT INTO tabla (campo1, campo2, campo3) (SELECT  c1, c2, c3 FROM otra_tabla); En este ejemplo se obtienen todos los datos mediante la select

-- Realiza los siguientes ejercicios (cuidado con el nombre de las columnas -acentos- utilizar doble click buscando en el árbol de BBDD del SGBD):

-- Crear una nueva categoría de producto. Habrá que insertar un nuevo registro. Con el id_categoria -> 9, nombre-> congelados y como descripción 'productos congelados'.

select * from categorias;

insert into productos (Nombre, IdCategoría, descripci) values (9);
insert into asignaturas(id_asignatura, nombre) values (6, 'Tutoria');

-- Crear una nueva categoría con id_categoria->10, nombre 'Pan' y con la descripción 'repostería, cereales, pan, dulces, galletas, etc…'

-- Crear una copia de seguridad de la tabla productos que llamaremos productos_bck.

-- Actualizar la tabla productos para poner con categoría 10 (la nueva categoría que hemos creado) a todos los productos que pertenezcan a la categoría 5 o 3.

-- Crear una nueva tabla ciudadpais que tenga dos campos
	-- ciudad varchar(15) pk
	-- país varchar(15)
    
-- Insertar en la tabla ciudadpais: todas las ciudades y países distintas de la tabla proveedores

-- Borrar todos los datos del país de la tabla empleados.

-- Damos de alta a un nuevo empleado en la empresa. Inserta los datos poniendo tu nombre y apellidos más los datos que no pueden estar en blanco en esa tabla.

-- Vamos a borrar los datos del empleado con idempleado=7 ya que deja de trabajar en la empresa. Antes de darlo de baja habrá que asignar todos los pedidos que realizó este empleado al empleado 8

-- En la categoría guardamos la imagen de la categoría, pero esto ocupa demasiado espacio. Vamos a realizar algunas modificaciones:

-- Borrar todos los datos del campo imagen de la tabla categorías. (Actualización). Poner el campo a 0

-- Cambiar el tipo de dato del campo imagen de longblob a varchar(15).(alter table)

-- Introducir en el campo imagen un texto que sea los cinco primeros caracteres del nombre de la Categoría seguido de un guion bajo más el id de la categoría con extensión .jpg. Por ejemplo bebid_1.jpg (realizar 8 querys diferentes, uno para cada categoría)

-- Poner en notas del empleado el valor 'Cumple con objetivos' a todos aquellos empleados que hayan preparado un pedido con un producto de la categoría cuya descripción es 'Quesos' (no tiene que salir ningún cambio porque la tabla detalle de pedidos está vacía). Anotación: para que se cargue correctamente la tabla `detalles de pedidos` hay que utilizar las comillas ``