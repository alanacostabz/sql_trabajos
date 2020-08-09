DELIMITER //
CREATE FUNCTION toDate(FECHA_NAC VARCHAR(10)) RETURNS DATE
BEGIN
DECLARE ANIO DATE;
SET ANIO= str_to_date(fecha_nac,'%d/%m/%Y');
RETURN ANIO;
END //
DELIMITER ;



------------------------------------------PARTITION BY LIST------------------------------------------------
alter table cemabe_personal
 	partition by list(NIVEL)(
	partition partNivel1 values in (1,2,3),
	partition partNivel2 values in (4,5,6),
	partition partNivel3 values in (7,8,9)
);

select count(*)
from cemabe_personal
where nivel
between 7 and 9 
and curp<>'';

select count(*)
from cemabe_personal
partition(partNivel3)
where curp <>'';


---------------------------------------------PARTITION BY RANGE----------------------------------------------------------------
 alter table cemabe_personal
    partition by range(EDAD)(
    partition partEdad20 values less than (30),
    partition partEdad30 values less than (40),
    partition partEdad40 values less than (50),
    partition partEdad50 values less than (60),
    partition partEdad60 values less than (70),
    partition partEdad70 values less than (80),
    partition partEdad80 values less than (90));

select count(*)
from cemabe_personal
where edad
between 30 and 39 
and curp<>'';

select count(*)
from cemabe_personal
partition(partEdad30)
where curp <>'';


------------------------------------------PARTITION BY KEY---------------------------------------------------------------------
ALTER TABLE cemabe_personal
PARTITION BY KEY(id_persona,curp,clave_ct)
PARTITIONS 6;

select ap_paterno, ap_materno,nombre_mae, curp, clave_ct,id_persona
     from cemabe_personal partition(p0)
     where id_persona = 0802811;

select ap_paterno, ap_materno,nombre_mae, curp, clave_ct,id_persona
    from cemabe_personal partition(p1)
    where id_persona = 0802811;


-----------------------------COMPOSITE PARTITION--------------------------------
ALTER TABLE cemabe_personal
PARTITION BY RANGE(nivel)
SUBPARTITION BY KEY(edad) 
 subpartitions 7(
    partition par1 values less than (2),
    partition par2 values less than (3),
    partition par3 values less than (4),
    partition par4 values less than (5),
    partition par5 values less than (6),
    partition par6 values less than (7),
    partition par7 values less than (8),
    partition par8 values less than (9),
    partition par9 values less than (10));

 SELECT count(*) FROM cemabe_personal 
  where curp<>'' and nivel  = 9 
  and edad between 20 and 30;

SELECT count(*) FROM cemabe_personal partition(par9)
 where curp<>'' 
 and edad between 20 and 30;

