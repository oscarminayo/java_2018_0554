 SELECT * FROM dgt.departamento;
 update departamento set nombre= 'oficina' where id=38;

SELECT * FROM dgt.puesto;
insert into puesto (nombre, id_departamento) values ('secretari@', 38), ('programad@r', 38), ('becari@', 38);