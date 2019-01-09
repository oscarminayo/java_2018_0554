-- 1. listado de todas las peliculas por titulo
SELECT titulo
FROM cine.peliculas

--2. listado de todos los generos evitando duplicidad con DISTINCT
SELECT DISTINCT genero 
FROM cine.peliculas

-- 3. LISTADO PELICULAS SIN GENERO. OJO AL CREAR LA TABLA. LA COLUMNA GENERO NO PUEDES SER NOTNULL 
-- Y DEBE PONER POR DEFECTO NULL SIN COMILLAS
SELECT *
FROM cine.peliculas
WHERE genero IS NULL

-- 4. listado peliculas y su director. 2 tablas. inner join implicita. Esta vez elijo select en lugar de * 
SELECT peliculas.id as 'id_pelicula',
peliculas.titulo,
director.nombre
FROM cine.director, cine.peliculas
WHERE director.id = peliculas.id_director

-- 5 mostrar la info de todas las salas y si se proyecta alguna peli en ella mostrar tb su info
SELECT *
FROM cine.salas LEFT JOIN cine.peliculas
ON salas.id= peliculas.id_sala

-- 6. mostrar las salas que no proyectan ninguna pelicula
SELECT salas.nombre
FROM cine.salas
WHERE salas.pelicula IS NULL

-- 7. mostrar el nombre de las peliculas que no se proyectan en ninguna sala
SELECT peliculas.titulo
FROM cine.peliculas
WHERE peliculas.id_sala= 0;


-- 7. mostrar el nombre de las peliculas que no se proyectan en ninguna sala ORDENADAS POR TITULO
SELECT titulo
FROM cine.peliculas
WHERE peliculas.id_sala= 0
order by titulo;




-- en clase

-- 1 peliculas que ha hecho un actor
SELECT
	p.id as 'id_pelicula', 
	p.nombre as 'nombre pelicula',
	a.nombre as ' nombre actor',
	a.id as 'id_actor' 
FROM 
	pelicula as p, 
	pelicula_actor as pa, 
	actor as a
WHERE 
	p.id = pa.id_pelicula and 
	pa.id_actor = a.id and 
	a.nombre = 'Leonardo Di Caprio';


-- 2 Detalle completo de una pelicula
SELECT 
	p.id as 'id pelicula',
	p.nombre as 'nombre pelicula',
	p.duracion,
	p.fecha ,
	a.id as 'id actor',
	a.nombre as 'protagonista',
	pa.salario as 'salario actor',
	d.nombre as 'nombre director'
FROM 
	pelicula as p, 
	categoria as c, 
	pelicula_actor as pa,
	actor as a
WHERE 
	p.id = c.id AND 
	p.id = pa.id_pelicula AND 
	pa.id_actor = a.id AND 
	p.nombre = 'Matrix';

-- 3 Total peliculas del año 2011
	-- con detalle
		SELECT
			nombre as ' pelicula del 2011',
			id
		FROM pelicula
		WHERE YEAR(fecha) = 2011
		group by fecha;


		
	-- solo la cuenta
		SELECT
		COUNT(*) as 'Nº Estrenos en 2011'
		FROM pelicula
		WHERE YEAR(fecha) = 2011
		

-- 4 todas las pelis de una categoria  y su detalle
SELECT 
	p.id as 'id_pelicula',
	p.nombre,
	p.duracion,
	p.fecha,
	c.nombre 'genero',
	a.nombre
FROM 
	pelicula as p, 
	categoria as c, 
	pelicula_actor as pa, 
	actor as a
Where 
	p.id_categoria = c.id AND 
	p.id = pa.id_pelicula AND 
	pa.id_actor = a.id AND 
	c.nombre = 'ciencia ficcion';


-- 5/ total pelis por categoria
SELECT 
COUNT(*) AS 'total peliculas ciencia ficcion'
FROM cine.pelicula as p, cine.categoria as c
where p.id_categoria = c.id and c.nombre = 'ciencia ficcion';


-- 5 nº total de peliculas en una categoria
SELECT 
c.nombre as 'genero',
COUNT(*) as 'nº peliculas'
FROM pelicula as p, categoria as c
WHERE p.id_categoria = c.id AND c.nombre = 'ciencia ficcion';


-- 6  agrupar todas las pelis por categoria
SELECT
c.nombre as 'genero',
COUNT(*) as 'nº peliculas'
FROM pelicula as p, categoria as c
WHERE p.id_categoria = c.id 
group by c.nombre;

-- 7/ todas las categproas que no tengan peli asociada

SELECT 
p.id,
p.nombre as 'peliculas sin categoria'
FROM pelicula as p
WHERE p.id_categoria IS NULL;




-- 8 PELIS QUE TENGAN MAS DE DOS ACTORES
SELECT
p.nombre as 'nombre pelicula',
count(*)
FROM pelicula as p, pelicula_actor as pa, actor as a
WHERE p.id = pa.id_pelicula and pa.id_actor= a.id
group by p.nombre having count(*)>=2 ;


-- 9/ salario de un actor
SELECT 
a.nombre,
pa.salario
FROM pelicula_actor as pa , actor as a
WHERE pa.id_pelicula = a.id and a.nombre = 'Leonardo Di Caprio';


-- extra mi consulta. salario de todos los actores

SELECT
a.nombre, 
salario
FROM pelicula_actor as pa, actor as a
WHERE pa.id_actor= a.id;

-- extra mi consulta. mostrar el numero de peliculas de cada actor
SELECT 
a.nombre,
COUNT(*) AS 'total peliculas'
FROM actor as a, pelicula as p, pelicula_actor as pa 
WHERE p.id = pa.id_actor and pa.id_actor = a.id and p.id
group by a.nombre;

-- extra salario de todos los actores
SELECT 
a.nombre,
pa.salario
FROM pelicula_actor as pa , actor as a
WHERE pa.id_pelicula = a.id;


