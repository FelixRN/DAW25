-- 1. Selecciona el apellido de todos los empleados.
select LastName from Employees;
-- 2. Selecciona el apellido de todos los empleados, sin duplicados.
select LastName from Employees group by LastName;
-- select distinc LastName from Employees;
-- 3. Selecciona todos los datos de los empleados cuyo apellido sea "Smith".
select * from Employees where LastName like 'Smith%';
-- 4. Selecciona todos los datos de los empleados cuyo apellido sea "Smith" o "Doe". (Con OR y Con IN) 
select * from Employees where LastName like 'Smith%' or LastName like 'Doe%'; 

select * from Employees where LastName in ('Smith%','Doe%'); 

-- 5. Selecciona todos los datos de los empleados que trabajan en el departamento 14.alter
select * from Departments where Department = 14;

-- 6. Selecciona todos los datos de los empleados que trabajan en el departamento 37 o el departamento 77. (Con OR y Con IN) 
select * from Employees where Department = 37 or Department = 77;

select * from Employees where Department in (37,77);
-- 7. Selecciona todos los datos de los empleados cuyo apellido comience con una "S".
select * from Departments, Employees;
select * from Employees where LastName LIKE 'S%';

-- 8. Selecciona la suma de los presupuestos de todos los departamentos.
Select SUM(Budget) FROM Departments;
-- 9. Selecciona la cantidad de empleados en cada departamento (solo se necesita mostrar el código del departamento y la cantidad de empleados).
Select Department, COUNT(*) FROM Employees group by Departament;
-- 10. Selecciona todos los datos de los empleados, incluidos los datos del departamento de cada empleado.
select * from Employees e inner join departments d on e.Department = d.code;
-- 11. Seleccione el nombre y apellido de cada empleado, junto con el nombre y presupuesto del departamento del empleado. 
select e.name, LastName, d.Name DepartmentsName, Budget From Employees ;
-- 12. Seleccione el nombre y apellido de los empleados que trabajan para departamentos con un presupuesto mayor a $60,000.

-- 13. Seleccione los departamentos con un presupuesto mayor que el presupuesto promedio de todos los departamentos.
select * from Departments where Budget > (select ;
-- 14. Seleccione los nombres de los departamentos con más de dos empleados. 

-- 15. Seleccione el nombre y apellido de los empleados que trabajan para los departamentos con el segundo presupuesto más bajo.
select e.Name, e.LastName from employees e inner join departments d on e.Department=d.Code and e.Department = (select sub.code From (Select * from Departments d order by d.budget limit 2) sub order by budget desc limit 1);