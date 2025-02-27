CREATE DATABASE IF NOT EXISTS book_database;
USE book_database;

DROP TABLE IF EXISTS book_review;
DROP TABLE IF EXISTS adaptation;
DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS author;

CREATE TABLE author (
    id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    birth_year INT NOT NULL,
    death_year INT NULL
);

INSERT INTO author (id, name, birth_year, death_year) VALUES
(1, 'Marcella Cole', 1983, NULL),
(2, 'Lisa Mullins', 1891, 1950),
(3, 'Dennis Stokes', 1935, 1994),
(4, 'Randolph Vasquez', 1957, 2004),
(5, 'Daniel Branson', 1965, 1990),
(6, 'Autor Desconocido', 1970, NULL);

CREATE TABLE book (
    id INT PRIMARY KEY,
    author_id INT NULL,
    title VARCHAR(255) NOT NULL,
    publish_year INT NOT NULL,
    publishing_house VARCHAR(255) NOT NULL,
    rating DECIMAL(2,1) NOT NULL,
    FOREIGN KEY (author_id) REFERENCES author(id) ON DELETE SET NULL
);

INSERT INTO book (id, author_id, title, publish_year, publishing_house, rating) VALUES
(1, NULL, 'Soulless girl', 2008, 'Golden Albatros', 4.3),
(2, NULL, 'Weak Heart', 1980, 'Diarmud Inc.', 3.8),
(3, 4, 'Faith Of Light', 1995, 'White Cloud Press', 4.3),
(4, NULL, 'Memory Of Hope', 2000, 'Rutis Enterprises', 2.7),
(5, 6, 'Warrior Of Wind', 2005, 'Maverick', 4.6),
(6, 2, 'Lost in the Stars', 2010, 'Silver Moon Publishing', 4.0);

CREATE TABLE adaptation (
    book_id INT,
    type VARCHAR(50) NOT NULL,
    title VARCHAR(255) NOT NULL,
    release_year INT NOT NULL,
    rating DECIMAL(2,1) NOT NULL,
    PRIMARY KEY (book_id, type, title),
    FOREIGN KEY (book_id) REFERENCES book(id) ON DELETE CASCADE
);

INSERT INTO adaptation (book_id, type, title, release_year, rating) VALUES
(1, 'movie', 'Gone With The Wolves: The Beginning', 2008, 3.0),
(3, 'movie', 'Companions Of Tomorrow', 2001, 4.2),
(5, 'movie', 'Homeless Warrior', 2008, 4.0),
(2, 'movie', 'Blacksmith With Silver', 2014, 4.3),
(4, 'movie', 'Patrons And Bearers', 2004, 3.2);

CREATE TABLE book_review (
    book_id INT,
    review TEXT NOT NULL,
    author VARCHAR(255) NOT NULL,
    PRIMARY KEY (book_id, author),
    FOREIGN KEY (book_id) REFERENCES book(id) ON DELETE CASCADE
);

INSERT INTO book_review (book_id, review, author) VALUES
(1, 'An incredible book', 'Sylvia Jones'),
(1, 'Great, although it has some flaws', 'Jessica Parker'),
(2, 'Dennis Stokes takes the reader for a ride full of emotions', 'Thomas Green'),
(3, 'Incredible craftsmanship of the author', 'Martin Freeman'),
(4, 'Not the best book by this author', 'Jude Falth'),
(5, 'Claudia Johnson at her best!', 'Joe Marqiz'),
(6, 'I cannot recall more captivating plot', 'Alexander Durham');