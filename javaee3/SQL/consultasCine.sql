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


-- 7. mostrar el nombre de las peliculas que no se proyectan en ninguna sala ORDENADAS POR TITU LO
SELECT titulo
FROM cine.peliculas
WHERE peliculas.id_sala= 0
order by titulo;