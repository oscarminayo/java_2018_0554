use dgt;

SELECT * 
FROM
agente as a, 
departamento as d,
multa as m,
coche as c
WHERE 
a.id_departamento = d.id AND
a.id=m.id_agente AND
m.id_coche= c.id;
 
-- join explicita , siempre debemos usar on
SELECT * FROM empleado AS  e
 INNER JOIN  departamento AS d ON
 e.id_departamento= d.id;  -- condidcion
 
 
  
SELECT * FROM empleado AS  e,
departamento AS d where
 e.id_departamento = d.id; -- condidcion
 
 
  
 -- listado empleados a pesar de no tener departamento
 SELECT * FROM empleado AS e LEFT JOIN departamento AS d ON e.id_departamento = d.id;
 