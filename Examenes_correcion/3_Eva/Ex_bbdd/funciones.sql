-- NOMBRE: Felix Rojas

# Examen sobre funciones SQL
use sakila;

-- FUNCIONES ARITMÉTICAS
/*
AVG() Calcula la media aritmética 
MAX() Devuelve el valor mayor 
MIN() Devuelve el valor menor 
SUM() Devuelve la suma
COUNT() Cuenta
*/

-- FUNCIONES DE CADENAS DE CARACTERES
/*
LOWER(c): Devuelve la cadena “c” con todas las letras convertidas a minúsculas.
UPPER(c): Devuelve la cadena “c” con todas las letras convertidas a mayúsculas.
LTRIM(c): Elimina los espacios por la izquierda de la cadena “c”.
RTRIM(c): Elimina los espacios por la derecha de la cadena “c”.
REPLACE(c, b, s): Sustituye en la cadena “c” el valor buscado “b” por el valor indicado en “s”.
REPLICATE(c, n): Devuelve el valor de la cadena “c” el número de veces “n” indicado.
CONCAT(str1,str2,...): Devuelve la cadena que resulta de concatenar los argumentos.
LEFT(c, n): Devuelve “n” caracteres por la izquierda de la cadena “c”.
RIGHT(c, n): Devuelve “n” caracteres por la derecha de la cadena “c”.
SUBSTRING(c, m, n): Devuelve una sub-cadena obtenida de la cadena “c”, a partir de la posición “m” y tomando “n” caracteres.
LENGTH(c): Tamaño de la cadena de caracteres.
*/

-- FUNCIONES DE FECHAS
/*
ADDDATE(date, INTERVAL expr unit), ADDDATE(expr,days), DATE_ADD(date, INTERVAL value unit): añade expr a una fecha   
CURRENT_DATE() / CURRENT_TIME () / CURTIME () /CURRENT_TIMESTAMP() / NOW(): Nos da la fecha / hora actual / fecha y hora actual 
DATE(fecha): Selecciona la fecha del parámetro (desechando la hora:minutos:segundos) 
DATEDIFF (fecha, fecha): Devuelve el número de días entre esas dos fechas. 
DATE_SUB (fecha, INTERVAL exprunit): Resta expr a una fecha
DAYNAME(fecha), DAYOFMONTH(fecha), DAYOFWEEK(fecha), DAYOFYEAR(fecha) 
SYSDATE(): La fecha y hora del sistema. 
TIMEDIFF('hh:mm:ss', 'hh:mm:ss'): Devuelve la diferencia entre dos horas 
DATEFORMAT (date, format): dar formato a una fecha.
*/

-- FUNCIONES DE CONVERSIÓN
/*
CONVERT(input_value, data_type):  convertir valores de un tipo de datos otro tipo de datos diferente
*/



-- 1- Saca el tiempo de duración media de todas las películas
select * from film;
select title, ROUND(AVG(rental_duration)) as duracion from film group by title;

-- 2- Haz un listado de las veces que se repite el nombre de los actores en la tabla actor, junto con su longitud y ordénalo de manera ascendente 
select * from actor;

-- select first_name as name, COUNT(first_name) as veces_repetidas from actor group by first_name;
	select first_name as name, COUNT(first_name) as veces_repetidas from actor group by first_name order by veces_repetidas ;

-- 3- Sacar un listado con el nombre completo y la antigüedad de cada cliente. 
select * from customer;

select first_name, last_name, datediff(create_date, last_update) from customer;

-- SELECT CONCAT(first_name, ' ', last_name) AS nombre_completo,
-- DATEDIFF(CURRENT_DATE(), create_date) AS antiguedad_dias
-- FROM customer;

-- 4- En la tabla payment, se muestran los pagos realizados por cada cliente y qué empleado lo ha cobrado. 
-- Sacar un listado de lo que ha facturado cada empleado: mostrar el staff_id y el total facturado (amount).

select * from payment;
-- select staff_id, amount from payment group by staff_id;

select staff_id, COUNT(amount) as monto_total from payment group by staff_id;

-- 5- Sacar la misma información que antes pero añadiendo nombre y apellidos del empleado.
select * from staff;

select s.first_name name, s.last_name, p.staff_id, COUNT(p.amount) as monto_total from payment p
INNER JOIN staff s ON p.staff_id = s.staff_id
group by staff_id;

-- 6 - ¿Cuántos distritos hay? Se mostrará el distrito y la cuenta de ese distrito ordenado de más a menos distritos. 
-- Solo se mostrarán aquellos que tengan más de un distrito.  
     -- Un ejemplo de salida sería:
		-- Abu Dhabi 3 
        -- Aceh 2

select * from city;
select * from address;

-- select district, COUNT(address) as count from address group by district;
select district, COUNT(address) as count from address group by district having count > 1 order by count;

-- 7 - Sacar el número de clientes que tiene cada tienda de esta forma: store_id, número clientes
select * from store;
select * from customer;

select store_id, COUNT(customer_id) as número_clientes from customer group by store_id;

-- 8 - Listar cada película y el número de actores que aparecen en cada película ordenados de más a menos. 
-- Debe aparecer el título en minúscula y el número de actores
select * from film;
select * from film_actor;

-- select f.title, fa.actor_id AS numero_actores from film fa left join film_id f on fa.film_id = f.film_id group by f.title;

select LOWER(f.title), COUNT(fa.actor_id) AS numero_actores from film f
inner join film_actor fa on f.film_id = fa.film_id
group by f.title ORDER BY numero_actores desc;

-- 9 - Sacar una lista con la cantidad de películas que ha hecho cada actor(nombres y apellidos) y ordenar por el nombre y apellidos del actor.

-- select a.first_name as name, a.last_name, COUNT(f.film_id) from actor a left join film_actor f on a.actor_id = f.actor_id group by a.first_name;
select * from actor;
select a.first_name nombre, a.last_name apellido, COUNT(fa.film_id) cantidad_peliculas from actor a
INNER JOIN film_actor fa on a.actor_id = fa.actor_id
group by nombre, apellido 
order by nombre, apellido;


-- 10 - Usar JOIN para mostrar la cantidad recaudada (payment) de cada miembro de la empresa en agosto de 2005
-- Mostar: nombre, apellidos y la cantidad recaudada

select * from payment;
select * from staff;

select s.first_name nombre, s.last_name apellido , SUM(p.amount) cantidad_recaudada from staff s
INNER JOIN payment p on s.staff_id = p.staff_id
WHERE p.payment_date BETWEEN '2005-08-01' and '2005-08-31'
group by nombre, apellido
ORDER BY cantidad_recaudada desc;



