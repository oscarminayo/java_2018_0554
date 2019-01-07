SELECT * FROM dgt.multa;
SELECT * FROM dgt.coche;

-- total de multas en el año 2019

-- SELECT COUNT(*) AS 'multas_2019' FROM multa WHERE YEAR(fecha) = 2019;

-- listado de coches multados en 2019

-- SELECT c.id AS 'id_coche', m.id AS 'id_multa', modelo, matricula, km, concepto, importe FROM coche AS c INNER JOIN multa AS m ON m.id_coche = c.id AND YEAR(fecha) = 2019;
SELECT c.id AS 'id_coche',
matricula,
m.id AS 'id_multa',
fecha,
importe
 FROM coche as c, multa as m 
 WHERE c.id = m.id_coche AND YEAR(fecha) = 2019;
-- detalle de todas las multas del coche con matricula '3548MKZ'

-- SELECT m.id AS 'id_multa', c.id AS 'id_coche', m.concepto, m.importe, m.fecha, c.matricula FROM multa AS m INNER JOIN coche AS c ON m.id_coche = c.id WHERE id_coche = 1;

SELECT * FROM coche as c, multa as m WHERE c.id = m.id_coche AND matricula='3548MKZ';

-- listado de coches con mas de 1000km y menos de 5000 

SELECT * FROM coche WHERE km>1000  AND km < 5000 ORDER BY ID DESC LIMIT 1000;

-- sumar el total de kilometros de todos los coches

SELECT SUM(km) AS 'total_km' FROM coche;

-- sumar los euros recaudados en 2019 con multas

SELECT SUM(importe) AS 'total_importe' FROM multa WHERE YEAR(fecha) = 2019; 

-- listado de coches con mas de una multa

SELECT * FROM coche WHERE id IN 
-- subconsulta id de los cocches con mas de una multa
(SELECT id_coche FROM  multa  GROUP BY id_coche HAVING COUNT(id_coche) >=2 );