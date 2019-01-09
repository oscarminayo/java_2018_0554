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
select * from cine.actor;
select * from cine.pelicula_actor;
select * from cine.pelicula;

-- 1/ pelis q ha hecho un actor
SELECT 
a.id as 'id actor',
p.id as 'id pelicula',
a.nombre as 'actor',
p.nombre as 'nombre pelicula'
FROM cine.actor as a, cine.pelicula as p, pelicula_actor as pa 
where a.id = pa.id_actor and p.id = pa.id_pelicula and a.nombre = 'harrison ford';

-- 2/ detalle completo de una peli. (falta sacar actor)
SELECT 
p.id as 'id pelicula',
d.nombre as 'nombre director',
p.nombre, 
p.duracion, 
p.fecha 
FROM cine.pelicula as p, cine.director as d
where p.id_director= d.id and p.nombre= 'matrix';  -- relaciona el director con la peli matrix 

-- 3/ peliculas del año xxx
SELECT 
COUNT(*) AS 'total pelis 2000'
FROM cine.pelicula
where fecha = '2000-05-17';

-- 4/ todas las pelis de una categoria xxx
SELECT 
p.id as 'id_pelicula',
p.nombre,
p.duracion,
p.fecha,
c.nombre 'genero' 
FROM cine.pelicula as p, cine.categoria as c
where p.id_categoria = c.id and c.nombre = 'ciencia ficcion';


-- 5/ total pelis por categoria
SELECT 
COUNT(*) AS 'total peliculas ciencia ficcion'
FROM cine.pelicula as p, cine.categoria as c
where p.id_categoria = c.id and c.nombre = 'ciencia ficcion';


-- 6/ agrupar todas las pelis por categoria





-- 7/ todas las categproas que no tengan peli asociada
-- 8/ pelis q tengan mas de 2 actores
-- 9/ salario de un actor
-- 10/ una peli cuanto presupuesto tiene para actores

