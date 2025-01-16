CREATE TABLE Director (
    Nombre VARCHAR(100) PRIMARY KEY,
    Nacionalidad VARCHAR(50)
);

CREATE TABLE Pelicula (
    ID INT PRIMARY KEY,
    Titulo VARCHAR(255),
    Productora VARCHAR(100),
    Nacionalidad VARCHAR(50),
    Fecha DATE,
    Director VARCHAR(100),
    FOREIGN KEY (Director) REFERENCES Director(Nombre)
);

CREATE TABLE Ejemplar (
    ID_Peli INT,
    Numero INT,
    Estado VARCHAR(50),
    PRIMARY KEY (ID_Peli, Numero),
    FOREIGN KEY (ID_Peli) REFERENCES Pelicula(ID)
);

CREATE TABLE Socio (
    DNI VARCHAR(20) PRIMARY KEY,
    Nombre VARCHAR(100),
    Direccion VARCHAR(255),
    Telefono VARCHAR(20),
    Avalador VARCHAR(20),
    FOREIGN KEY (Avalador) REFERENCES Socio(DNI)
);

CREATE TABLE alquila (
    DNI VARCHAR(20),
    ID_Peli INT,
    Numero INT,
    FechaAlquiler DATE,
    FechaDevolucion DATE,
    PRIMARY KEY (DNI, ID_Peli, Numero, FechaAlquiler),
    FOREIGN KEY (DNI) REFERENCES Socio(DNI),
    FOREIGN KEY (ID_Peli, Numero) REFERENCES Ejemplar(ID_Peli, Numero)
);

CREATE TABLE Actores (
    Nombre VARCHAR(100) PRIMARY KEY,
    Nacionalidad VARCHAR(50),
    Sexo ENUM('M', 'F')
);

CREATE TABLE actua (
    Actor VARCHAR(100),
    ID_Peli INT,
    Prota BOOLEAN,
    PRIMARY KEY (Actor, ID_Peli),
    FOREIGN KEY (Actor) REFERENCES Actores(Nombre),
    FOREIGN KEY (ID_Peli) REFERENCES Pelicula(ID)
);