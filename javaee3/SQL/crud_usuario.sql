/* operaciones de CRUD basicas */

use javaee;

-- getAll
SELECT id,email, password FROM usuario ORDER BY id DESC LIMIT 1000;

-- getById
SELECT id,email, password FROM usuario WHERE id = 1;

-- insert
INSERT INTO `usuario` (`email`, `password`) VALUES ('auraga2@ipartek.com', '12345678');


-- update
UPDATE `usuario` SET `email`='auraga@ipartek.com', `password`='222' WHERE `id`=1;


-- delete
DELETE FROM `usuario` WHERE  `id`=3;

-- login
SELECT id,email, password FROM usuario WHERE email='auraga@ipartek.com' AND `password`='222';


-- by id

SELECT v.id as 'id_video', u.id as 'id_usuario', email, password, nombre, codigo FROM video as v, usuario as u WHERE v.id_usuario = u.id AND v.id = ?;


-- Listado de videos con detalle usuario--
SELECT
	v.id as 'id_video',
	v.id as 'id_usuario',
	nombre,
	codigo,
	email,
	password
-- FROM video as v INNER JOIN usuario as u  ON u.id=v.id_usuario;  -- UNA JOIN TRADICIONAL PERO ANDER LO HACE COMO LO SIGUIENTE CON EL WHERE
FROM video as v, usuario as u  
WHERE u.id = v.id_usuario
ORDER BY v.id DESC LIMIT 1000;

