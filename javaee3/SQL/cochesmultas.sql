LA MIVXBGD


-- 1. LISTADO total multas en 2019
SELECT id, importe, id_agente, fecha
FROM multa 
WHERE YEAR (fecha) =2019 ;

-- 2. TOTAL MULTAS EN 2019
SELECT COUNT(*) AS 'multas_2019' FROM multa WHERE YEAR(fecha) = 2019;

-- 3. LISTADO de coches multados en 2019
SELECT c.id AS 'id_coche',
matricula,
m.id AS 'id_multa',
fecha,
importe
 FROM coche as c, multa as m 
  WHERE c.id = m.id_coche AND YEAR(fecha) = 2019;

-- 4. detalle de todas las multas del coche con matricula '3548MKZ'
SELECT * FROM coche as c, multa as m WHERE c.id = m.id_coche AND matricula='3548MKZ';

-- 5. LISTADO de coches con mas de XXXXy menos de XXXXX
SELECT * FROM coche WHERE km>100  AND km < 2000 ORDER BY ID DESC LIMIT 1000;

-- 6. Sumar el total de kilometros de todos los coches
SELECT SUM(km) AS 'total_km' FROM coche;

-- 7. sumar los euros recaudados en 2019 con multas
SELECT SUM(importe) AS 'total_importe' FROM multa WHERE YEAR(fecha) = 2019; 

-- 8.listado de coches con mas de una multa
SELECT * FROM coche WHERE id IN  
-- subconsulta id de los cocches con mas de una multa
(SELECT id_coche FROM  multa  GROUP BY id_coche HAVING COUNT(id_coche) >=2 );
-- FIN 8-------