SELECT * FROM dgt.multa;

-- 1   LISTADO  de todos los agentes y multas de 2019
SELECT a.id AS 'id_agente',
 m.id AS 'id_multa',
 a.nombre,
 a.numero_placa,
 m.fecha FROM multa AS m 
 INNER JOIN agente AS a 
 ON m.id_agente = a.id AND YEAR(fecha) = 2019;
 
-- 2. detalle de matricula yaris agente y placa que le ha multado
SELECT a.id AS 'id_agente', 
c.id AS 'id_coche', 
m.id AS 'id_multa', 
c.matricula, 
c.modelo, 
a.nombre, 
a.numero_placa, 
m.importe FROM coche AS c 
INNER JOIN multa AS m 
ON m.id_coche = c.id 
INNER JOIN agente AS a 
ON m.id_agente = a.id AND matricula = '3548MKZ';


-- 3. listado agente xxx y sus multas , a pesar de no tener multas asociadas
-- puede ser left , right o inner. como agente está a la izquierda se usa left en lugar de inner
SELECT a.nombre, COUNT(a.id) FROM agente AS a LEFT JOIN multa AS m ON m.id_agente = a.id
WHERE year (fecha) = 2019 OR fecha IS null;



-- EJERCICO PARA MAÑANA MARTES 8/01/2019

--crear un tabla que sea empleados
-- una tabla que sea departamento
-- juego de datos que nosotros queramos para estas tres consultas

--1todos los empleados que tengan departamentos
-- 2 listado de los empleados que no tengan departamento
-- 3 todos los departamentos que no tengan empleados.