use AdventureWorks2019;

select * from sales.salesperson;

-- Ventas de la persona que se ocupa del territorio de United Kingdom.
select * from Sales.SalesPerson s INNER JOIN Sales.SalesTerritory st on s.TerritoryID = st.TerritoryID where st.TerritoryID like 10;

--Tasa de cambio media y tasa de cambio de final del dia para el tipo de cambio DOLAR US a DOLAR de CANADA

-- Puesto de trabajo del empleado que fue contratado el primero
select * from HumanResources.JobCandidate;
select top 1 JobTitle from HumanResources.Employee order by HireDate ASC;

-- Nombre de las categorías de producto de la categoría Bikes

select * from Production.ProductCategory; 
select * from Production.ProductSubcategory;
--select name, ProductCategoryID from Production.ProductSubcategory where ProductCategoryID like 1 ;

select pc.Name, ps.ProductCategoryID, ps.Name from Production.ProductSubcategory ps INNER JOIN Production.ProductCategory pc on ps.ProductCategoryID = pc.ProductCategoryID
where pc.Name like '%Bikes%';

-- Total del pedido más barato
select top 1 TotalDue from Purchasing.PurchaseOrderHeader order by TotalDue ;

--Mostrar a todos los empleados que se encuentran en el departamento de manufactura (Production) 
--y de aseguramiento de la calidad(Quality assurance).

-- select BusinessEntityID from HumanResources.Employee where JobTitle like 'Production%' and JobTitle like 'Quality%';
select e.BusinessEntityID, d.name from HumanResources.Employee e 
INNER JOIN HumanResources.EmployeeDepartmentHistory dh on dh.BusinessEntityID = e.BusinessEntityID
INNER JOIN HumanResources.Department d on d.DepartmentID = dh.DepartmentID
where d.Name like '%Production%' or d.Name like 'Quality%';

--Los empleados que son del estado de Florida
select * from HumanResources.Employee;
select * from Sales.SalesPerson;
select * from Person.StateProvince where name like 'Fl%';

select * from Person.StateProvince spr 
INNER JOIN Sales.SalesTerritory st on st.TerritoryID = spr.TerritoryID
INNER JOIN Sales.SalesPerson sp on sp.TerritoryID = st.TerritoryID
INNER


--Empleados cuyo apellido sea con la letra “S”


--Ahora que conoces un poco mas sobre la base de datos, invéntate 3 enunciados en los que necesites JOIN para resolverlos y resuélvelos.

