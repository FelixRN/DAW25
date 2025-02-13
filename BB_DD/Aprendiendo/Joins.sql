DROP DATABASE IF EXISTS Rewards;
CREATE DATABASE Rewards CHARACTER SET utf8mb4;
USE Rewards;

CREATE TABLE Rewards (
RewardID INTEGER AUTO_INCREMENT PRIMARY KEY,
EmployeeID INTEGER,
Reward INTEGER,
Month VARCHAR(100) 
);

CREATE TABLE Employees (
EmployeeID INTEGER,
LastName VARCHAR(20), 
FirstName VARCHAR(20),
BirthDate DATE,
Photo VARCHAR(20),
Notes VARCHAR(100)
);


INSERT INTO Rewards (EmployeeID,Reward, Month)VALUES
(3, 200,"January"),
(2, 180, "February"),
(5,250,"March"),
(1,280,"April"),
(8,160,"May"),
(null,null,"June")
;

INSERT INTO Employees (EmployeeID, LastName, FirstName, BirthDate, Photo, Notes) VALUES
(1, 'Davolio', 'Nancy', '1968-12-08', 'EmpID1.pic', 'Education includes a BA in ...'),
(2, 'Fuller', 'Andrew', '1952-02-19', 'EmpID2.pic', 'Andrew received his BTS ...'),
(3, 'Leverling', 'Janet', '1963-08-30', 'EmpID3.pic', 'Janet has a BS degree in ...'),
(4, 'Peacock', 'Margaret', '1958-09-19', 'EmpID4.pic', 'Margaret holds a BA in Engli...'),
(5, 'Buchanan', 'Steven', '1955-03-04', 'EmpID5.pic', 'Steven Buchanan graduated ...'),
(6, 'Suyama', 'Michael', '1963-07-02', 'EmpID6.pic', 'Michael is a graduate of ...'),
(7, 'King', 'Robert', '1960-05-29', 'EmpID7.pic', 'Robert King served in the ...'),
(8, 'Callahan', 'Laura', '1958-01-09', 'EmpID8.pic', 'Laura received a BA in ...'),
(9, 'Dodsworth', 'Anne', '1969-07-02', 'EmpID9.pic', 'Anne has a BA degree in ...'),
(10, 'West', 'Adam', '1928-09-19', 'EmpID10.pic', 'An old chum.')

