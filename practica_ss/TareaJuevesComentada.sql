-- PUNTO 1 Y 2
-- Creamos una tabla con los id de cada una de las 32 entidades, las hicimos manualmente porque si las haciamos con auto_increment
-- Las id del 1 al 9 eran distintas a las del campo ENT en cemabe personal, teniamos 1 y 01
DROP TABLE IF EXISTS INEGI_ENTIDADES;
CREATE TABLE INEGI_ENTIDADES (
    ID_ENTIDAD VARCHAR (2) NOT NULL,
	CLAVE VARCHAR (2), 
    ENTIDAD_NAME VARCHAR (255) NOT NULL,
    PRIMARY KEY (ID_ENTIDAD)
);

-- Insertamos los 32 valores que ibamos a necesitar en esta tabla. Los sacamos de la pagina oficial de inegi, que vienen siendo su
-- ID, su clave y su nombre.
INSERT INTO INEGI_ENTIDADES (ID_ENTIDAD, ENTIDAD_NAME, CLAVE) VALUES ('01', 'Aguascalientes', 'AS'), ('02','Baja California', 'BC'), ('03', 'Baja California Sur', 'BS'), ('04', 'Campeche', 'CC'), ('05', 'Coahuila de Zaragoza', 'CL'), ('06', 'Colima', 'CM'), ('07', 'Chiapas', 'CS'), ('08', 'Chihuahua', 'CH'), 
('09','Disfrito Federal', 'DF'), ('10', 'Durango', 'DG'), ('11', 'Guanajuato', 'GT'), ('12', 'Guerrero', 'GR'), ('13', 'Hidalgo', 'HG'), ('14', 'Jalisco', 'JC'), ('15', 'Estado de Mexico', 'MC'), ('16', 'Michoacan de Ocampo', 'MN'), 
('17', 'Morelos', 'MS'), ('18', 'Nayarit', 'NT'), ('19', 'Nuevo leon', 'NL'), ('20', 'Oaxaca', 'OC'), ('21', 'Puebla', 'PL'), ('22', 'Queretaro de Arteaga', 'QT'), ('23', 'Quintana Roo', 'QR'), ('24', 'San Luis Potosi', 'SP'), 
('25', 'Sinaloa', 'SL'), ('26', 'Sonora', 'SR'), ('27', 'Tabasco', 'TC'), ('28', 'Tamaulipas', 'TS'), ('29', 'Tlaxcala', 'TL'), ('30', 'Veracruz de Ignacio de la Llave', 'VZ'), ('31', 'Yucatán', 'YN'), ('32', 'Zacatecas', 'ZS');

-- PUNTO 3-A
-- Con un inner join checamos el id de nuestra tabla 
--y el campo ent de cemabe personal y hacemos 
--un conteo para checar cuantos
-- trabajadores tiene cada estado
SELECT ENTIDAD_NAME AS ESTADO, COUNT(ENT) AS TRABAJADORES
FROM cemabe_personal
INNER JOIN INEGI_ENTIDADES
WHERE ID_ENTIDAD = ENT
AND LENGTH (CURP) = 18
GROUP BY ENT;

 
-- PUNTO 3-B
-- Como en el punto anterior hicimos un conteo de nuevo por estado, solo que ahora es un conteo de cuantas personas nacieron en ese
-- estado, asi que ahora trabajamos con la curp y un substr, checamos los campos que indican esa informacion (12 y 13), y despues 
-- hicimos un count.
SELECT ENTIDAD_NAME AS ESTADO, COUNT(SUBSTR(CURP,12,2)) AS NACIDOS
FROM cemabe_personal
INNER JOIN INEGI_ENTIDADES
WHERE LENGTH(CURP) = 18
AND CLAVE = SUBSTR(CURP,12,2)
GROUP BY CLAVE;

-- PUNTO 3-C
-- Aqui fue una combinacion del punto A y B, lo que queriamos es checar cuantas personas trabajan en el estado en el que nacieron, 
-- es un query parecido a los anteriores solo que ahora verificamos que el campo ENT sea igual al substr de la curp en el caracter 12 y 13.
select entidad_name  as ESTADO, count(substr(curp,12,2)) AS TRABAJADORES 
from  cemabe_personal 
inner join inegi_entidades 
where length(curp)=18 
and clave = substr(curp,12,2)
and ent = (select id_entidad from inegi_entidades where clave = substr(curp,12,2))
group by id_entidad;

-- PUNTO 3-D (not ready)
select ORIGEN.entidad_name AS ORIGEN,t1.entidad_name AS ESTADO, (select count(ent) from cemabe_personal 
   	where substr(curp,12,2) = ORIGEN.clave and length(curp)=18 and ent=T1.id_entidad) as TRABAJADORES
 from inegi_entidades as t1 inner join (select entidad_name,clave, id_entidad from inegi_entidades) as ORIGEN 

-- PUNTO 3-E
-- Aqui checamos cuantas personas nacieron en el extranjero y decimos en que estado trabajan actualmente, igual que en los puntos 
-- pasados checamos el caracter 12 y 13 de su curp, y para este caso como no son nacidos en el pais no tienen ninguna de las 32 claves
-- y tienen un NE, checamos que ese substr sea NE y hacemos el query.
select entidad_name AS ESTADO, count(substr(curp,12,2)) AS EXTRANJEROS
from  cemabe_personal 
inner join inegi_entidades 
where length(curp)=18 
and ID_ENTIDAD = ent
and SUBSTR(CURP,12,2) = 'NE'
group by id_entidad;

-- Punto 3-F 
select ORIGEN.entidad_name AS ORIGEN,t1.entidad_name AS ESTADO, (select count(ent) from cemabe_personal 
   	where substr(curp,12,2) = ORIGEN.clave and length(curp)=18 and ent=T1.id_entidad) as TRABAJADORES
 from inegi_entidades as t1 inner join (select entidad_name,clave, id_entidad from inegi_entidades) as ORIGEN 
unioN (select 'Extranjero', entidad(ent)
AS ESTADO, count(substr(curp,12,2)) AS EXTRANJEROS
from  cemabe_personal 
inner join inegi_entidades 
where length(curp)=18 
and ID_ENTIDAD = ent
and SUBSTR(CURP,12,2) = 'NE'
group by id_entidad);



-- PUNTO 4-A
-- Creamos una funcion que recibe como parametro la curp del trabajador, 
--se maneja con un sub string, checamos el valor 12 y 13 y ese lo
-- comparamos con la clave que tenemos y regresamos el 
--estado de nacimiento de dicha curp.
DROP FUNCTION IF EXISTS FNC_ESTADO;
DELIMITER //
CREATE FUNCTION FNC_ESTADO(VAL_CURP VARCHAR(18)) RETURNS VARCHAR(50)
BEGIN
	DECLARE NOM_ESTADO VARCHAR(50);
	DECLARE SIGLAS VARCHAR(2);
	SET SIGLAS = SUBSTR( VAL_CURP, 12 , 2);
	SET NOM_ESTADO = (SELECT ENTIDAD_NAME FROM INEGI_ENTIDADES WHERE CLAVE = SIGLAS);

	RETURN NOM_ESTADO;
END //
DELIMITER ;

-- PUNTO 4-B
-- Creamos una funcion que recibe como parametro el id del estado como en el campo ent en cemabe_personal, o sea un valor de 01 a 32
-- A partir de eso checamos que sea igual al valor que tiene asignado cada estado (id_entidad) e imprimimos el nombre del estado con su
-- respectivo id. 
DROP FUNCTION IF EXISTS ENTIDAD;

DELIMITER //
CREATE FUNCTION ENTIDAD(ENT VARCHAR(2))
RETURNS VARCHAR(50)
BEGIN

DECLARE NUM_ENT VARCHAR(2);
DECLARE ENTIDAD VARCHAR(50);

SET NUM_ENT = ENT;
SET ENTIDAD = (SELECT ENTIDAD_NAME AS ENTIDAD FROM INEGI_ENTIDADES WHERE ID_ENTIDAD = NUM_ENT);

RETURN ENTIDAD;
END//

DELIMITER ;

--PUNTO 5-A
--Utilizamos las funciones creadas en el punto 4 para generar el nombre del estado segun sea el caso

--Punto 3-A utilizando la funcion entidad para generar el nombre del estado
SELECT ENTIDAD(ENT) AS ESTADO, COUNT(ENT) AS TRABAJADORES
FROM cemabe_personal
INNER JOIN INEGI_ENTIDADES
WHERE ID_ENTIDAD = ENT
AND LENGTH (CURP) = 18
GROUP BY ENT;

--Punto 3-B utilizando la fnc_estado para generar el nombre del estado
SELECT FNC_ESTADO(curp) AS ESTADO , COUNT(SUBSTR(CURP,12,2)) AS NACIDOS
FROM cemabe_personal
INNER JOIN INEGI_ENTIDADES
WHERE LENGTH(CURP) = 18
AND CLAVE = SUBSTR(CURP,12,2)
GROUP BY CLAVE;

--Punto 3-C utilizando la fnc_estado para generar el nombre del estado
select FNC_ESTADO(curp) AS ESTADO, count(substr(curp,12,2)) AS TRABAJADORES 
from  cemabe_personal 
inner join inegi_entidades 
where length(curp)=18 
and clave = substr(curp,12,2)
and ent = (select id_entidad from inegi_entidades where clave = substr(curp,12,2))
group by id_entidad;

--Punto 3-D 
select ORIGEN.entidad_name AS ORIGEN,t1.entidad_name AS ESTADO, (select count(ent) from cemabe_personal 
   	where substr(curp,12,2) = ORIGEN.clave and length(curp)=18 and ent=T1.id_entidad) as TRABAJADORES
 from inegi_entidades as t1 inner join (select entidad_name,clave, id_entidad from inegi_entidades) as ORIGEN 


--Punto 3-E utilizando la entidad para generar el nombre del estado
select ENTIDAD(ent) AS ESTADO, count(substr(curp,12,2))  AS EXTRANJEROS
from  cemabe_personal 
inner join inegi_entidades 
where length(curp)=18 
and ID_ENTIDAD = ent
and SUBSTR(CURP,12,2) = 'NE'
group by id_entidad;

--Punto 3-F 
select ORIGEN.entidad_name AS ORIGEN,t1.entidad_name AS ESTADO, (select count(ent) from cemabe_personal 
   	where substr(curp,12,2) = ORIGEN.clave and length(curp)=18 and ent=T1.id_entidad) as TRABAJADORES
 from inegi_entidades as t1 inner join (select entidad_name,clave, id_entidad from inegi_entidades) as ORIGEN 
unioN (select 'Extranjero', entidad(ent)
AS ESTADO, count(substr(curp,12,2)) AS EXTRANJEROS
from  cemabe_personal 
inner join inegi_entidades 
where length(curp)=18 
and ID_ENTIDAD = ent
and SUBSTR(CURP,12,2) = 'NE'
group by id_entidad);



------------------------------------------------------------------------------------------------------------------------------
-- SKETCHES/DRAFTS
select entidad_name, count(substr(curp,12,2))
from  cemabe_personal 
inner join inegi_entidades 
where length(curp)=18 
and clave = substr(curp,12,2) and ent = (SELECT ID_ENTIDAD FROM INEGI_ENTIDADES WHERE CLAVE = SUBSTR(CURP,12,2))
group by id_entidad;

--TEST
select entidad_name, count(substr(curp,12,2)) 
from  cemabe_personal 
inner join inegi_entidades 
where length(curp)=18 
and clave = 'SR' and ent = '26'
group by id_entidad;

select ENTIDAD_NAME, ent, CURP 
FROM cemabe_personal 
inner join INEGI_ENTIDADES 
WHERE LENGTH(CURP) = 18
AnD CLAVE ='SR' AnD ent = (select id_entidad from inegi_entidades where substr(curp,12,2) = 'SR') LIMIT 10;




-- DRAFT 3 (D)
SELECT cemabe_personal.ENT, T1.ENTIDAD_NAME AS AGGH, T2.ENTIDAD_NAME AS OIOI,COUNT(cemabe_personal.ent)
FROM cemabe_personal
RIGHT JOIN INEGI_ENTIDADES AS T1 ON T1.ID_ENTIDAD = cemabe_personal.ent
RIGHT JOIN INEGI_ENTIDADES AS T2 ON T2.ID_ENTIDAD = cemabe_personal.ent
WHERE T1.ID_ENTIDAD = cemabe_personal.ENT
AND T2.ID_ENTIDAD = cemabe_personal.ent
AND LENGTH (CURP) = 18
GROUP BY ENT;

select ESTADO.entidad_name AS ESTADO,inegi_entidades.entidad_name  AS ORIGEN, (SELECT COUNT(ENT) 
FROM CEMABE_PERSONAL WHERE ENT = (SELECT ORIGEN.ID_ENTIDAD FROM ORIGEN.INEGI_ENTIDADES WHERE ORIGEN.ID_ENTIDAD = ENT))
from inegi_entidades inner join (select entidad_name from inegi_entidades) as ESTADO;


SELECT (SELECT ENTIDAD_NAME FROM INEGI_ENTIDADES WHERE ENT=ID_ENTIDAD) AS ENT_trabajo, ENT_nac, COUNT(*) FROM CEMABE_PERSONAL WHERE ENT<>'' GROUP BY ENT;
 
SELECT DISTINCT ENTIDAD(ent),  COUNT(ent)
 	FROM CEMABE_PERSONAL 
 	WHERE substr(curp,12,2) = 'AS' 
 	AND LENGTH(CURP)=18 group by ent;