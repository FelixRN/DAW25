-- BBDD para el examen práctico de Consultas
drop database if exists opera;
CREATE DATABASE IF NOT EXISTS opera CHARACTER SET utf8 COLLATE utf8_general_ci;
USE opera;

create table ciudad_pais(ciudad varchar(45) primary key, pais varchar (45) not null);

insert into ciudad_pais values ('Busseto','Italia');
insert into ciudad_pais values('Paris','Francia');
insert into ciudad_pais values('Bergamo','Italia');
insert into ciudad_pais values('Salzburgo','Austria');
insert into ciudad_pais values('Lucca','Italia');
insert into ciudad_pais values('Bonn','Alemania');
insert into ciudad_pais values('Milan','Italia');
insert into ciudad_pais values('Bougival','Francia');
insert into ciudad_pais values('Viena','Austria');
insert into ciudad_pais values('Bruselas','Belgica');
insert into ciudad_pais values('Praga','República Checa');
insert into ciudad_pais values('El Cairo','Egipto');
insert into ciudad_pais values('Venecia','Italia');
insert into ciudad_pais values('Roma','Italia');
insert into ciudad_pais values('Florencia','Italia');

CREATE TABLE `autor` (
   `idautor` int(10) unsigned NOT NULL AUTO_INCREMENT,
   `nombre` varchar(45) NOT NULL,
   `lugar_nacimiento` varchar(45) NOT NULL,
   `fecha_nacimiento` date NOT NULL,
   `lugar_defuncion` varchar(45) DEFAULT NULL,
   `fecha_defuncion` date DEFAULT NULL,
   PRIMARY KEY (`idautor`),
   KEY `lugar_nacimiento` (`lugar_nacimiento`),
   KEY `lugar_defuncion` (`lugar_defuncion`),
   CONSTRAINT `autor_ibfk_1` FOREIGN KEY (`lugar_nacimiento`) REFERENCES `ciudad_pais` (`ciudad`),
   CONSTRAINT `autor_ibfk_2` FOREIGN KEY (`lugar_defuncion`) REFERENCES `ciudad_pais` (`ciudad`)
 ) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
--
-- Volcado de datos para la tabla `autor`
--

INSERT INTO `autor` (`idautor`, `nombre`, `lugar_nacimiento`, `fecha_nacimiento`, `lugar_defuncion`, `fecha_defuncion`) VALUES
(1, 'Giuseppe Verdi', 'Busseto', '1813-10-10', 'Milan', '1901-01-27'),
(2, 'George Bizet', 'Paris', '1838-10-25', 'Bougival', '1875-06-27'),
(3, 'Gaetano Donizetti', 'Bergamo', '1797-11-29', 'Bergamo', '1848-04-08'),
(4, 'W. Amadeus Mozart', 'Salzburgo', '1756-01-27', 'Viena', '1791-12-05'),
(5, 'Giacomo Puccini', 'Lucca', '1858-12-22', 'Bruselas', '1924-11-29'),
(6, 'Ludwig van Beethoven', 'Bonn', '1770-12-16', 'Viena', '1827-03-26');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `opera`
--

CREATE TABLE IF NOT EXISTS `opera` (
  `idopera` int(10) unsigned NOT NULL,
  `nombre` varchar(80) NOT NULL,
  `lugar_estreno` varchar(45) NOT NULL,
  `fecha_estreno` date NOT NULL,
  `idioma` enum('I','A','F') DEFAULT NULL,
  `sinopsis` text,
  `video` varchar(100) DEFAULT NULL,
  `autor_idautor` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`idopera`),
  foreign key (lugar_estreno) references ciudad_pais(ciudad),
  CONSTRAINT `fk_opera_autor` FOREIGN KEY (`autor_idautor`) REFERENCES `autor` (`idautor`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;


INSERT INTO `opera` (`idopera`, `nombre`, `lugar_estreno`, `fecha_estreno`, `idioma`, `sinopsis`, `video`, `autor_idautor`) VALUES
(1, 'Carmen', 'París', '1875-03-03', 'F', 'Con argumento extraído de la novela homónima de Prosper Mérimée, es probablemente la más famosa de todas las óperas francesas. Los críticos del estreno estaban impresionados por la mezcla que hizo Bizet del Romanticismo y el realismo. Opéra-comique que en sus inicios no tuvo el éxito que fue adquiriendo en el siglo XX para convertirse en una de las más representadas.', NULL, 2),
(2, 'El elixir de amor', 'Milán', '1832-05-12', 'I', 'Esta obra fue la ópera interpretada más a menudo en Italia entre 1838 y 1848 y no ha desaparecido en ningún momento del repertorio. A principios del siglo XX fue adoptada por Enrico Caruso como título de éxito seguro y poco esfuerzo, motivo por el que duplicó su prestigio.', NULL, 3),
(3, 'Don Giovanni', 'Praga', '1787-10-29', 'I', 'La segunda con libreto de Da Ponte, Don Giovanni ha supuesto desde entonces un rompecabezas para escritores y filósofos sobre su composición. Fue la única ópera de Mozart que se representó con cierta regularidad durante el sigli XIX.', NULL, 4),
(4, 'La flauta mágica', 'Viena', '1791-09-30', 'A', 'Llegándose a describir como "la apoteosis del Singspiel", fue denigrada durante el siglo XIX por su confusión y falta de definición. No se convirtió en ópera de culto hasta la segunda mitad del siglo XX.', NULL, 4),
(5, 'Aida', 'El Cairo', '1871-12-24', 'I', 'Encargada por el gobernador de Egipto para la inauguración del canal de Suez, Verdi se inspiró en la grand''opéra francesa. Su gran dramatismo y excitante música le otorgó un éxito inmediato y en diez años se representó a 155 teatros diferentes en todo el mundo.', NULL, 1),
(6, 'Nabucco', 'Milán', '1842-03-09', 'I', 'Verdi describió esta ópera como el verdadero comienzo de su carrera artística. Recibió este encargo tras varios fracasos y después de la muerte sucesiva de sus dos hijos y de su esposa. Con esta ópera y su coro Va pensiero, Verdi se convirtió en el símbolo del Risorgimiento italiano.', NULL, 1),
(7, 'Madame Butterfly', 'Milán', '1904-02-17', 'I', 'Puccini investiga la música popular y la cultura japonesa para darle autenticidad a la obra. Aunque contiene motivos japoneses, la música sigue siendo italiana. Él mismo la definió como una de sus óperas más profundas e imaginativas.', NULL, 5),
(8, 'Rigoletto', 'Venecia', '1851-03-11', 'I', '﻿La primera -y más innovadora- de las tres óperas de Verdi del periodo intermedio y que se ha convertido en indispensable del repertorio. Basada en la comedia El rey se divierte de Victor Hugo. Después de un periodo no reeixit desde Luisa Miller, Verdi entra en la madurez con un drama de pasión, engaño, amor filial y venganza con una figura central, Rigoletto, un bufón cheperudo de la corte del ducado de Mantua. Es muy conocida el aria La donna è mobile.', NULL, 1),
(9, 'La traviata', 'Venecia', '1853-03-06', 'I', 'Basada en la narración de La dame aux camélias de Alejandro Dumas, marcó el cenit de los éxitos de Verdi en la segunda parte de su carrera. Pocas óperas han tenido tanta difusión como esta. La escena del brindis es de las más conocidas de este género.', NULL, 1),
(10, 'Don Pasquale', 'París', '1843-01-03', 'I', '﻿La obra maestra cómica de Donizetti, una de las últimas grandes opere buffe. La escribió como una pieza de época para contentar a un público distante con las nuevas tendencias. Es de las pocas óperas de Donizetti que siempre se han representado.', NULL, 3),
(11, 'Tosca', 'Roma', '1900-01-14', 'I', 'Tosca es la más wagneriana de las óperas de Puccini con un empleo frecuente del leitmotiv. Es una de sus óperas más famosas: un drama febril de amor, celos y muerte. La partitura, guiada por el temperamento feroz de Tosca, está llena de inquietantes arias y dúos.', NULL, 5),
(12, 'Macbeth', 'Florencia', '1847-03-14', 'I', 'El primer Shakespeare de Verdi. Como tantos otros compositores románticos, Verdi admiraba a Shakespeare y llegó a componer tres óperas basadas en sus obras teatrales.', NULL, 1),
(13, 'Otello', 'Milán', '1887-02-05', 'I', NULL, NULL, 1);


CREATE TABLE IF NOT EXISTS `teatro` (
  `idteatro` tinyint(3) unsigned NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `ciudad` varchar(45) NOT NULL,
  `aforo` smallint(5) unsigned NOT NULL,
  `telefono1` varchar(9) DEFAULT NULL,
  `telefono2` varchar(9) DEFAULT NULL,
   PRIMARY KEY (`idteatro`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

INSERT INTO `teatro` (`idteatro`, `nombre`, `ciudad`, `aforo`, `telefono1`, `telefono2`) VALUES
(1, 'Teatro Villamarta', 'Jerez de la Frontera', 1226, '956149685', NULL);

CREATE TABLE IF NOT EXISTS `temporada` (
  `teatro_idteatro` tinyint(3) unsigned NOT NULL,
  `idtemporada` mediumint(8) unsigned NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  PRIMARY KEY (`teatro_idteatro`,`idtemporada`),
  CONSTRAINT `fk_temporada_teatro1` FOREIGN KEY (`teatro_idteatro`) REFERENCES `teatro` (`idteatro`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



INSERT INTO `temporada` (`teatro_idteatro`, `idtemporada`, `descripcion`) VALUES
(1, 1, 'Otoño Invierno 2015/2016'),
(1, 2, 'Otoño Invierno 2014/2015');


CREATE TABLE IF NOT EXISTS `temporada_representa_opera` (
  `temporada_teatro_idteatro` tinyint(3) unsigned NOT NULL,
  `temporada_idtemporada` mediumint(8) unsigned NOT NULL,
  `opera_idopera` int(10) unsigned NOT NULL,
  `fecha` date NOT NULL,
  `hora` time NOT NULL,
  `espectadores` smallint(6) DEFAULT '0',
  primary key(`temporada_teatro_idteatro`,`temporada_idtemporada`,`opera_idopera`,`fecha`),
  CONSTRAINT `fk_temporada_has_opera_opera1` FOREIGN KEY (`opera_idopera`) REFERENCES `opera` (`idopera`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_temporada_has_opera_temporada1` FOREIGN KEY (`temporada_teatro_idteatro`, `temporada_idtemporada`) REFERENCES `temporada` (`teatro_idteatro`, `idtemporada`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `temporada_representa_opera` (`temporada_teatro_idteatro`, `temporada_idtemporada`, `opera_idopera`, `fecha`, `hora`, `espectadores`) VALUES
(1, 1, 13, '2016-01-30', '20:00:00', 1000),
(1, 2, 11, '2015-01-11', '20:00:00', 1200);
