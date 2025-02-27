-- Mostrar el nombre de cada autor junto con el título del libro que escribió y el año en que se publicó.


select a.id, b.title, b.publish_year from author a 
INNER JOIN book b on b.id = a.id;

-- Lista de autores y libros publicados después de 2005
select a.name, b.title from author a 
INNER JOIN book b on b.id = a.id 
WHERE b.publish_year >2005;

-- Mostrar libros adaptados en un plazo de 4 años y clasificados por debajo de la adaptación
select b.title from book b
INNER JOIN adaptation ad on ad.book_id = b.id
where (ad.release_year - b.publish_year) <= 4 and b.rating < ad.rating;

-- SELECT b.id, b.title, b.publish_year, ad.release_year, b.rating AS book_rating, ad.rating AS adaptation_rating, 
--       (ad.release_year - b.publish_year) AS diff_years
-- FROM book b
-- INNER JOIN adaptation ad ON ad.book_id = b.id;

-- Mostrar todos los libros y sus adaptaciones
select b.title, ad.title, ad.release_year from book b
LEFT JOIN adaptation ad on b.id = ad.book_id;

-- Seleccione el título de cada libro, el nombre de su editorial, 
-- el título de su adaptación y el tipo de adaptación. Mantenga en el resultado los libros sin adaptaciones.

select b.title, b.publishing_house, ad.title, ad.type from book b
LEFT JOIN adaptation ad on ad.book_id = b.id 
where ad.type like "movie" or ad.type IS NULL;

-- Unir las tablas book_review y book utilizando RIGHT JOIN. 
-- Muestre el título del libro, la reseña correspondiente y el nombre del autor de la reseña. 
-- Considere todos los libros, incluso los que no han sido reseñados.
select * from author;
select * from book, adaptation ; 
select * from adaptation;
select * from book_review;

select b.title, br.review, br.author from book_review br
RIGHT JOIN book b 
on b.id = br.book_id;



