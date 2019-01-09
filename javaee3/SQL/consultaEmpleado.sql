SELECT * FROM dgt.empleado;

-- 1. estadisticas del total empleados, total sueldos, total comosiones, min, max, avg => sueldos para todos los empleados
SELECT 
COUNT(*) AS 'total empleados',
SUM(salario) AS 'suma sueldos',
SUM(comision) AS 'suma comisiones',
MIN(salario) AS 'menor salario',
MAX(salario) AS 'mayor salario',
ROUND(AVG(salario),2)AS 'media salarios'
FROM dgt.empleado;

-- 2 lo mismo agrupado por departamento con inner join para mostrar el nombre del departamento
SELECT 
id_departamento, d.nombre,
COUNT(*) AS 'total empleados',
SUM(salario) AS 'suma sueldos',
SUM(comision) AS 'suma comisiones',
MIN(salario) AS 'menor salario',
MAX(salario) AS 'mayor salario',
ROUND(AVG(salario),2) AS 'media salarios'
FROM empleado AS e INNER JOIN departamento AS d ON e.id_departamento = d.id
GROUP BY id_departamento;


-- 3 lo mismo agrupado por departamento, pero empleados con antiguedad > 3 años
SELECT 
COUNT(*) AS 'total empleados',
SUM(salario) AS 'suma sueldos',
SUM(comision) AS 'suma comisiones',
MIN(salario) AS 'menor salario',
MAX(salario) AS 'mayor salario',
AVG(salario) AS 'media salarios'
FROM dgt.empleado
WHERE YEAR(fecha_contrato) < 2016 ;


-- 4. contar numero empleados con salario minimo
SELECT 
COUNT(*) AS 'num-sal-min'
FROM dgt.empleado
where salario = 900;



-- 5. contar numero empleados con salario minimo por departamento NO OLVIDAR SACAR EL NOMBRE DEL DEPARTAMENTO ASOCIADO
SELECT 
COUNT(*) AS 'total empleados'
FROM dgt.empleado
where salario = 900
GROUP BY id_departamento;




-- 6. detalle empleados del departamento Oficina = 38 ordenados por puesto de trabajo
SELECT * 
FROM dgt.empleado
WHERE id_departamento =38
ORDER BY id_puesto;


-- 7.  detalle empleados del departamento Oficina = 38 ordenados por salario
SELECT * 
FROM dgt.empleado
WHERE id_departamento =38
ORDER BY salario ;


-- 8. detalle empleados del departamento Oficina = 38 ordenados por fecha contrato
SELECT *
FROM dgt.empleado
WHERE id_departamento =38 
ORDER BY fecha_contrato;


 -- CONSULTAS EMPLEADO ANDER CORREGIDAS --

USE dgt;

SELECT fecha_contrato , 
	YEAR(fecha_contrato) as 'year' , 
	YEAR(NOW()) as 'actual' ,
    ( YEAR(NOW()) - YEAR(fecha_contrato) ) as 'diferencia'
FROM empleado ;

-- estadisticas del total empleados,  toal sueldos, total comosiones, min, max, avg => sueldos para todos los empleados
SELECT
	COUNT(*) as 'empleados',
    SUM(salario) as 'salarios',
    SUM(comision) as 'comision',
	MIN(salario) as 'sal_min',
    MAX(salario) as 'sal_max',
    ROUND(AVG(salario),2) as 'sal_media'    
FROM empleado;

-- lo mismo agrupado por departamento
SELECT
	id_departamento,
    d.nombre,
	COUNT(*) as 'empleados',
    SUM(salario) as 'salarios',
    SUM(comision) as 'comision',
	MIN(salario) as 'sal_min',
    MAX(salario) as 'sal_max',
    ROUND(AVG(salario),2) as 'sal_media'    
FROM empleado as e INNER JOIN departamento as d ON e.id_departamento = d.id
GROUP BY id_departamento;

-- lo mismo agrupado por departamento, pero empleados con antiguedad > 3 años
SELECT
	id_departamento,
    d.nombre,
	COUNT(*) as 'empleados',
    SUM(salario) as 'salarios',
    SUM(comision) as 'comision',
	MIN(salario) as 'sal_min',
    MAX(salario) as 'sal_max',
    ROUND(AVG(salario),2) as 'sal_media'    
FROM empleado as e INNER JOIN departamento as d ON e.id_departamento = d.id
WHERE YEAR(NOW()) - YEAR(fecha_contrato) > 3
GROUP BY id_departamento;

-- contar numero empleados con salario minimo
SELECT COUNT(*) as 'num_sal_min' FROM empleado WHERE salario = 900;

-- contar numero empleados con salario minimo por departamento
SELECT 
	id_departamento,
    d.nombre,
	COUNT(*) as 'num_sal_min'
FROM empleado as e , departamento as d 
WHERE e.id_departamento = d.id AND salario = 900
GROUP BY id_departamento;

-- detalle empleados del departamento Oficina = 38 ordenados por puesto de trabajo
SELECT 
	d.nombre as 'departamento',
    e.id_jefe as 'id_jefe',
    j.nombre as 'jefe',
	e.id as 'empleado_id',
    e.nombre as 'empleado_nombre',
    e.fecha_contrato,
    e.salario,
    e.comision,
    e.id_puesto,
    p.nombre as 'puesto_nombre'
FROM empleado as e, empleado as j, puesto as p, departamento as d
WHERE 
	j.id = e.id_jefe AND
	e.id_departamento = d.id AND
	e.id_puesto = p.id AND
	e.id_departamento = 38
ORDER BY e.id_puesto ASC;

-- detalle empleados del departamento Oficina = 38 ordenados por salario
SELECT 
	d.nombre as 'departamento',
    e.id_jefe as 'id_jefe',
    j.nombre as 'jefe',
	e.id as 'empleado_id',
    e.nombre as 'empleado_nombre',
    e.fecha_contrato,
    e.salario,
    e.comision,
    e.id_puesto,
    p.nombre as 'puesto_nombre'
FROM empleado as e, empleado as j, puesto as p, departamento as d
WHERE 
	j.id = e.id_jefe AND
	e.id_departamento = d.id AND
	e.id_puesto = p.id AND
	e.id_departamento = 38
ORDER BY e.salario ASC;

-- detalle empleados del departamento Oficina = 38 ordenados por fecha contrato

SELECT 
	d.nombre as 'departamento',
    e.id_jefe as 'id_jefe',
    j.nombre as 'jefe',
	e.id as 'empleado_id',
    e.nombre as 'empleado_nombre',
    e.fecha_contrato,
    e.salario,
    e.comision,
    e.id_puesto,
    p.nombre as 'puesto_nombre'
FROM empleado as e, empleado as j, puesto as p, departamento as d
WHERE 
	j.id = e.id_jefe AND
	e.id_departamento = d.id AND
	e.id_puesto = p.id AND
	e.id_departamento = 38
ORDER BY e.fecha_contrato DESC;

-- LISTADO CONSULTAS INTERNET-------------------------
1) Nombre y edad de los empleados.
SELECT nombre, edad FROM empleados;

2) Salario y trienios de cada categoría si suponemos un aumento del 2%.
SELECT categoria,1.02*salario,1.02*trienio FROM categorías;

3) Fecha de contratación de cada empleado.
SELECT nombre, YEAR(contrato) FROM empleados;

4) Edades de los empleados.
SELECT DISTINCT edad FROM empleados;

5) Número de empleados que hay para cada una de las edades.
SELECT edad, COUNT(edad) FROM empleados GROUP BY edad; /* puede ser count(*) */

6) Edad media de los empleados por departamento.
SELECT departamento, AVG(edad) FROM empleados GROUP BY departamento;

7) Categorías profesionales que superan las 35.000 de salario.
SELECT * FROM categorias WHERE salario>35000;

8) Datos del empleado número 1014.
SELECT * FROM empleados WHERE num=1014;

9) Empleados del departamento 106.
SELECT * FROM empleados WHERE departamento=106;

10) Empleados cuya contratación se produjo en el año 2000.
SELECT * FROM empleados WHERE contrato>='01/01/2000' AND contrato<'31/12/2000';

11) Empleados que no sean comerciales (código de categoría 4).
SELECT * FROM empleados WHERE categoria<>4;

12) Empleados contratados entre los años 1990 y 1994.
SELECT * FROM empleados WHERE contrato BETWEEN '01/01/1990' AND '31/12/1994';

13) Categorías que tienen un salario inferior a 35.000 o superior a 40.000.
SELECT * FROM categorias WHERE salario NOT BETWEEN 35000 AND 40000;

14) Empleados cuya categoría es director o jefe de sección (códigos 1 y 2).
SELECT * FROM empleados WHERE categoria IN (1,2);

15) Empleados de nombre 'Jose'.
SELECT * FROM empleados WHERE nombre LIKE 'Jose %';

16) Empleados que pertenecen a la categoría de administrativo (código 3) y que tienen una edad mayor
de 35 años.
SELECT * FROM empleados WHERE categoria=3 AND edad>35;

17) Empleados que no pertenecen al departamento 110.
SELECT * FROM empleados WHERE NOT departamento=110;

18) Nombre y edad de los empleados ordenados de menor a mayor edad.
SELECT nombre, edad FROM empleados ORDER BY edad; /* puede ponerse ASC */

19) Nombre y edad de los empleados ordenados por nombre de forma descendente.
SELECT nombre, edad FROM empleados ORDER BY nombre DESC;

20) Nombre del empleado y de la categoría en la que trabaja.
SELECT nombre, titulo FROM empleados, categorias
WHERE empleados.categoria=categorias.categoría;

21) Código y teléfonos de los departamentos de las oficinas de la región 'Centro'.
SELECT codigo, telefono FROM dptoficinas, oficinas
WHERE dptoficinas.oficina=oficinas.oficina AND region='Centro';

22) Nombre del empleado y ciudad en la que trabaja.
SELECT nombre, ciudad FROM empleados, dptoficinas, oficinas
WHERE empleados.departamento=codigo AND dptoficinas.oficina=oficinas.oficina;

23) Sueldo de cada empleado incluyendo trienios.
SELECT nombre, salario+trienio*((CURRENT DATE-contrato)/(365*3))
FROM empleados, categorias WHERE empleados.categoria=categorias.categoría;

24) Nombre de los empleados y de sus jefes de sección.
SELECT empl.nombre, jefe.nombre FROM empleados AS empl, empleados AS jefe
WHERE empl.departamento=jefe.departamento AND jefe.categoria=2 AND
empl.nombre<>jefe.nombre;

25) Suma del sueldo de los empleados, sin contar trienios.
SELECT SUM(salario) FROM empleados, categorias
WHERE empleados.categoria=categorias.categoría;

26) Promedio del sueldo, sin contar trienios, de la oficina de 'Barcelona'.
SELECT AVG(salario) FROM empleados, categorias, dptoficinas, oficinas
WHERE empleados.categoria=categorias.categoria AND empleados.departamento=codigo
AND dptoficinas.oficina=oficinas.oficina AND ciudad='Barcelona';

27) Salarios máximo y mínimo de los empleados, incluyendo trienios.
SELECT MAX(salario+trienio*((CURRENT DATE-contrato)/(365*3))),
MIN(salario+trienio*((CURRENT DATE-contrato)/(365*3)))
FROM empleados, categorias WHERE empleados.categoria=categorias.categoría;

28) Número de empleados que superan los 40 años.
SELECT COUNT(*) FROM empleados WHERE edad>40;

29) Número de edades diferentes que tienen los empleados.
SELECT COUNT(DISTINCT edad) FROM empleados;

30) Categoría y suma de los sueldos de los empleados, contando trienios, de cada una de las categorías.
SELECT empleados.categoria, SUM(salario+trienio*((CURRENT DATE-contrato)/(365*3)))
FROM empleados, categorias
WHERE empleados.categoria=categorias.categoria GROUP BY empleados.categoría;

31) Nombre y suma de los sueldos de los empleados, sin contar trienios, de cada oficina.
SELECT ciudad, SUM(salario) FROM empleados, categorias, dptoficinas, oficinas
WHERE empleados.categoria=categorias.categoria AND empleados.departamento=codigo
AND dptoficinas.oficina=oficinas.oficina GROUP BY oficinas.oficina, ciudad;

32) Titulo y suma de trienios de las categorías cuya suma supera las 10000.
SELECT titulo, SUM(trienio*((CURRENT DATE-contrato)/(365*3)))
FROM empleados, categorias WHERE empleados.categoria=categorias.categoria
GROUP BY titulo HAVING SUM(trienio*((CURRENT DATE-contrato)/(365*3)))>10000;

33) Nombre del departamento y número de empleados de los departamentos que tienen más de 5
empleados.
SELECT departamentos.nombre, COUNT(*) FROM empleados, dptoficinas, departamentos
WHERE empleados.departamento=codigo AND deptno=dptoficinas.departamento
GROUP BY departamentos.nombre HAVING COUNT(*)>5;

34) Nombre y sueldo, sin contar trienios, de los empleados cuyos sueldos son inferiores a la media de
sueldos de la empresa.
SELECT nombre, salario FROM empleados, categorias
WHERE empleados.categoria=categorias.categoria AND salario< (SELECT AVG(salario)
FROM empleados, categorias WHERE empleados.categoria=categorias.categoria);

35) Título de las categorías donde existe un empleado con contrato anterior a 1990.
SELECT titulo FROM categorias WHERE EXISTS (SELECT * FROM empleados
WHERE empleados.categoria=categorias.categoria AND
contrato<'01/01/1990');

36) Nombre de los empleados que tiene un contrato más antiguo que cualquier empleado del
departamento de 'Informática'.
SELECT nombre FROM empleados WHERE contrato<ALL ( SELECT contrato FROM
dptoficinas, departamentos WHERE empleados.departamento=codigo AND
dptoficinas.departamento=deptno AND departamentos.nombre='Informatica');

37) Ciudad y número de empleados de la oficina que tiene un número de empleados superior a la
media de la empresa.
SELECT ciudad, COUNT(*) FROM oficinas, dptoficinas, empleados
WHERE oficinas.oficina=dptoficinas.oficina AND codigo=empleados.departamento
GROUP BY ciudad HAVING COUNT(*)>
(SELECT COUNT(*)/(SELECT COUNT(*) FROM oficinas) FROM empleados);

38) Año de contratación de cada empleado.
SELECT nombre, YEAR(contrato) FROM empleados;

39) Crear la tabla de empleados y de categorías suponiendo que todo empleado tiene un sueldo
superior a 5.000 ptas.
CREATE TABLE categorias (categoria INTEGER NOT NULL, titulo VARCHAR(20), salario
FLOAT(5), trienio INTEGER, PRIMARY KEY (categoria), CHECK (salario > 5000));
CREATE TABLE empleados (num INTEGER NOT NULL, nombre VARCHAR(50), edad
INTEGER, departamento INTEGER NOT NULL, categoria INTEGER NOT NULL,
contrato DATE, PRIMARY KEY (num), FOREIGN KEY (departamento) REFERENCES
dptoficinas, FOREIGN KEY (categoria) REFERENCES (categorias));

40) Añadirle a la tabla de empleados una nueva columna que sea la dirección del empleado.
ALTER TABLE empleados ADD direccion VARCHAR(70); 


