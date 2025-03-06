-- Seleccionar los autores que nacieron entre 1800 y 1850: fácil
select nombre from autor where YEAR(fecha_nacimiento) > 1800 AND YEAR(fecha_nacimiento) < 1850;

-- Mostrar todas las obras que no han sido representadas y que estén escritas en alemán idioma=’A’. Fácil
select o.nombre, t.opera_idopera from temporada_representa_opera t
INNER JOIN opera o on o.idopera = t.opera_idopera
where idioma like "A";

-- Todas las obras ordenadas según tu propio criterio. Fácil
select nombre from opera order by nombre;

-- Autores que no tienen ninguna obra almacenada en la base de datos.  Medio
select a.nombre, a.idautor, o.nombre AS Obra_almacenada from autor a 
LEFT JOIN opera o on o.autor_idautor = a.idautor
WHERE o.nombre IS NULL;


-- Selecciona los autores que vivieron menos de 50 años. Media****
select nombre from autor a WHERE  YEAR(fecha_defuncion) - YEAR(fecha_nacimiento) < 50; 

-- Edad que tenía el autor Giacomo Puccini cuando se estrenaron sus obras. Muy difícil. 
-- Mostrar nombre autor, nombre de obra, y edad del autor cuando se estrenó la obra*******.
select a.nombre, o.nombre, a.fecha_defuncion as edad_autor from autor a
INNER JOIN opera o on o.autor_idautor = a.idautor 
WHERE a.fecha_defuncion=YEAR(o.fecha_estreno - a.fecha_nacimiento);

-- El campo edad debe estar renombrado. Utiliza YEAR(columna_fecha) para obtener solo el año de una fecha

-- Autores que murieron en el mismo lugar en el que nacieron. Fácil
select nombre from autor where lugar_nacimiento = lugar_defuncion;

-- Autores cuyo nombre empieza por g y acaba por i. Fácil
select nombre from autor where nombre like "g%" and nombre like "%i";

-- Listar todos los nombres las óperas, junto con su fecha de estreno y el idioma, pero habrá que mostrar lo siguiente. Difícil
-- En el caso de que el idioma sea:
-- F-->Francés
-- I-->Italiano
-- A-->Alemán 
-- Habrá que renombrar el último campo como idioma.

-- Todas óperas que se estrenaron antes de 7 de julio de 1850. Fácil
select nombre from opera where YEAR(fecha_estreno) < 1850;

-- Todas las obras que se han representado en el teatro 1 durante la temporada 2015/2016. Muy difícil
-- Mostrar el siguiente formato: nombre teatro, temporada, nombre de la obra que se representó.
-- Anotación: ten en cuenta que las tablas temporada y temporada_representa_opera están relacionadas por una doble FK-PF
select * from teatro;
select * from opera;
select * from temporada_representa_opera;
select * from temporada;

select t.nombre, te.idtemporada, o.nombre from opera o
INNER JOIN teatro t on t.idteatro = t.teatro_idteatro
INNER JOIN temporada_representa_opera te on te.idtemporada = tem.temporada_idtemporada;

-- Todos los autores que murieron en distinto país del país donde nacieron. Difícil
select * from autor inner join ciudad_pais as pc on autor.lugar_lugarnacimiento = pn.ciudad
inner join ciudad_pais as pd on autor.lugar_defuncion = pd.ciudad 
where pn.pais <> pd.pais;

-- Todas las obras que hayan sido escritas por un italiano. Con el siguiente formato. Tendrán que ir ordenado por nombre de autor en orden descendente y nombre de la obra en orden ascendente. Difícil
-- País autor           Nombre autor                   Nombre obra

select ciudad_pais.pais as `Pais autor`, autor.nombre as `Nombre autor`, opera.nombre as `Nombre opera`
from opera inner join autor on opera.autor_idautor = autor.idautor
inner join ciudad_pais on autor.lugar_nacimiento = ciudad_ais.ciudad
where ciudad_pais.pais = `italia`
order by autor,nombre desc, opera.nombre asc;
-- Autores con todas las obras que han representado. En caso de que no tengan ninguna obra que se haya representado se mostraran los valores respectivos a las fechas de representación a vacío (null). Difícil
-- Solo habrá que seleccionar los siguientes datos: nombre autor, nombre opera, fecha de representación
-- Mostrar todas las obras con los datos de sus respectivos autores y el país donde se estrenaron ordenados por el nombre de la ópera descendentemente. Solo queremos que muestre dos registros a partir del registro 5.  Medio
-- Los datos a mostrar serán : nombre autor, nombre ópera, país de estreno