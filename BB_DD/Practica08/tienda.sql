-- creamos la BBDD
DROP DATABASE if exists Comercio;
CREATE DATABASE IF NOT EXISTS Comercio;
use Comercio;

-- Creamos la tabla y sus atributos
Create table tienda (
nif varchar(10) ,
nombre varchar(20) ,
direccion varchar(20),
poblacion varchar(20), 
PROVINCIA varchar(20),
codpostal int(5)
);
-- modificamos la tabla
alter table tienda add primary key(nif);
-- modificar la provincia para que se almacene en mayusculas
alter table tienda add check(provincia=upper(provincia));
-- modificar una columna
alter table tienda modify column nombre varchar(30) NOT NULL;


Create table fabricantes(
cod_fabricante int(3), 
nombre varchar(15),
pais varchar(15)
);

alter table fabricantes add primary key(cod_fabricante);
alter table fabricantes add check(nombre=upper(nombre));
alter table fabricantes add check(pais=upper(pais));

Create table articulos(
articulo varchar(20) ,
cod_fabricante int(3) ,
peso int(3),
categoria varchar(10),
precio_venta int(6),
precio_costo int(6),
existencias int(5)
);

alter table articulos add primary key(articulo,cod_fabricante,peso,categoria);

alter table articulos add foreign key (cod_fabricante) references fabricantes (cod_fabricante);

alter table articulos add check(precio_venta > 0);
alter table articulos add check(precio_costo > 0);
alter table articulos add check(peso > 0);
alter table articulos add check (categoria in("Primero", "Segundo", "Tercero"));

Create table ventas(
nif varchar(10),
articulo varchar(20),
cod_fabricante int(3),
peso int(3),
categoria varchar(10),
fecha_venta date,
unidades_vendidas int(4)
);
alter table ventas add primary key(nif,articulo,cod_fabricante,peso,categoria,fecha_venta);

alter table ventas add foreign key (nif) references tienda (nif);
alter table ventas add foreign key (articulo,cod_fabricante,peso,categoria) references articulos (articulo,cod_fabricante,peso,categoria);
alter table ventas add check(unidades_vendidas > 0);
alter table ventas add check (categoria in("Primero", "Segundo", "Tercero"));
alter table ventas add column pvp int;

Create table pedidos(
nif varchar(20),
articulo varchar(20),
cod_fabricante int(3),
peso int(3),
categoria varchar(10),
fecha_pedido date,
unidades_pedidas int(4),
existencias int(5)
);

alter table pedidos add primary key(nif,articulo,cod_fabricante,peso,categoria,fecha_pedido);
alter table pedidos add foreign key (nif) references tienda (nif);
alter table pedidos add foreign key (articulo,cod_fabricante,peso,categoria) references articulos (articulo,cod_fabricante,peso,categoria);
alter table pedidos add check(unidades_pedidas > 0);
alter table pedidos add check (categoria in("Primero","Segundo","Tercero"));

alter table pedidos add column pvp int;

alter table articulos rename productos;