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




