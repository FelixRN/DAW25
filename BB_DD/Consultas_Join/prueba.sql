CREATE DATABASE TestJoin;

USE TestJoin;

CREATE TABLE Departamentos
(
    DepartamentoId int primary key,
    Nombre_Depto varchar(20)
);

CREATE TABLE Empleados
(
    Nombre varchar(20) primary key,
    DepartamentoId int,
    foreign key (DepartamentoId) references Departamentos (DepartamentoId)
);

INSERT INTO Departamentos VALUES(31, 'Sales');
INSERT INTO Departamentos VALUES(33, 'Engineering');
INSERT INTO Departamentos VALUES(34, 'Clerical');
INSERT INTO Departamentos VALUES(35, 'Marketing');

INSERT INTO Empleados VALUES('Rafferty', 31);
INSERT INTO Empleados VALUES('Jones', 33);
INSERT INTO Empleados VALUES('Heisenberg', 33);
INSERT INTO Empleados VALUES('Robinson', 34);
INSERT INTO Empleados VALUES('Smith', 34);
INSERT INTO Empleados VALUES('Williams', NULL);