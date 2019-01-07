
USE javaee;

SELECT v.id AS 'id_video',
		u.id AS 'id_usuario',
        nombre,
        codigo,
        email,
        `password`
FROM video AS v INNER JOIN usuario AS u ON u.id = v.id_usuario
ORDER BY v.id DESC LIMIT 1000;        

SELECT v.id AS 'id_video', v.id, v.nombre, v.codigo FROM video AS v , usuario AS u WHERE v.id_usuario = u.id AND  v.id= ?;

-- insert , update y delete para videos
INSERT INTO `javaee`. `video` (`nombre`, `codigo`,`id_usuario`) VALUES ('FISICA ACUSTICA', 'M6fDCg0zQTo', '2');

--- delete ---
DELETE FROM `javaee`.`video` WHERE `id`=7;

--- update ---
UPDATE `javaee`.`video` SET `nombre` = 'Bruce Dickinson - Tears of The Dragon', `codigo`='vXClBjNxiOA', `id_usuario` = 2 WHERE (`id` = 4);

UPDATE `dgt`.`multa` SET `fecha` = CURRENT_TIMESTAMP  WHERE (`id` = 2); -- con fecha--S