
LOAD DATA INFILE 'C://Users//bryan//Desktop//BASE IGE//IGE_1999.txt'
into table IGE_1999 FIELDS TERMINATED BY '\t' IGNORE 1 ROWS;


--------------ESTA
CREATE DATA BASE IGE_DB;
USE IGE_DB;

DROP TABLE IF EXISTS IGE_1999;
DROP TABLE IF EXISTS IGE_1999;
CREATE TABLE IGE_1999 (
F_NAC VARCHAR(10),
LUG_NAC VARCHAR(2),
SEXO ENUM('H','M'),
HOMONIMA VARCHAR(2),
ESTADO INT(2) zerofill,
DISTRITO INT(3) zerofill,
MUNICIPIO INT(3) zerofill,
SECCION INT(4) zerofill,
LOCALIDAD INT(4) zerofill,
MANZANA VARCHAR(2),
F_INSC VARCHAR(10),
CP VARCHAR(5),
PATERNO VARCHAR(50),
MATERNO VARCHAR(50),
NOMBRE VARCHAR(50),
COLONIA VARCHAR(255),
OCUPACION VARCHAR(2)
);


LOAD DATA LOCAL INFILE 'C:\\Users\\bryan\\Desktop\\BASE IGE\\IGE_1999.txt'
INTO TABLE IGE_1999
FIELDS TERMINATED BY '\t' ENCLOSED BY '"'
IGNORE 1 LINES;


ALTER TABLE IGE_1999 ADD `ID_PERSONA` INT(8) zerofill 
NOT NULL AUTO_INCREMENT, ADD
 PRIMARY KEY (ID_PERSONA,ESTADO);

 ALTER TABLE IGE_1999 ADD EDAD INT;

ALTER TABLE IGE_1999
PARTITION BY LIST(ESTADO)(
PARTITION EST1 VALUES IN (1),
PARTITION EST2 VALUES IN (2),
PARTITION EST3 VALUES IN (3),
PARTITION EST4 VALUES IN (4),
PARTITION EST5 VALUES IN (5),
PARTITION EST6 VALUES IN (6),
PARTITION EST7 VALUES IN (7),
PARTITION EST8 VALUES IN (8),
PARTITION EST9 VALUES IN (9),
PARTITION EST10 VALUES IN (10),
PARTITION EST11 VALUES IN (11),
PARTITION EST12 VALUES IN (12),
PARTITION EST13 VALUES IN (13),
PARTITION EST14 VALUES IN (14),
PARTITION EST15 VALUES IN (15),
PARTITION EST16 VALUES IN (16),
PARTITION EST17 VALUES IN (17),
PARTITION EST18 VALUES IN (18),
PARTITION EST19 VALUES IN (19),
PARTITION EST20 VALUES IN (20),
PARTITION EST21 VALUES IN (21),
PARTITION EST22 VALUES IN (22),
PARTITION EST25 VALUES IN (25),
PARTITION EST26 VALUES IN (26),
PARTITION EST27 VALUES IN (27),
PARTITION EST30 VALUES IN (30),
PARTITION EST31 VALUES IN (31)
);

----------------------------- HASTA AQUI
ALTER TABLE IGE_1999
PARTITION BY HASH(LOCALIDAD)
PARTITIONS 2625 ;

ALTER TABLE IGE_1999
PARTITION BY RANGE COLUMNS (FECHA_NAC) (
	PARTITION P1900 VALUES LESS THAN ('1910-01-01'),
	PARTITION P1910 VALUES LESS THAN ('1920-01-01'),
	PARTITION P1920 VALUES LESS THAN ('1930-01-01'),
	PARTITION P1930 VALUES LESS THAN ('1940-01-01'),
	PARTITION P1940 VALUES LESS THAN ('1950-01-01'),
	PARTITION P1950 VALUES LESS THAN ('1960-01-01'),
	PARTITION P1960 VALUES LESS THAN ('1970-01-01'),
	PARTITION P1980 VALUES LESS THAN ('1980-01-01'),
	PARTITION P1990 VALUES LESS THAN ('1990-01-01'),
	PARTITION P2000 VALUES LESS THAN ('2000-01-01')
);


------------------AQUI
CREATE INDEX ID_PERSONA_IDX ON IGE_1999(ID_PERSONA);
CREATE INDEX NOMBRE_FNAC_IDX ON IGE_1999 (PATERNO,MATERNO,NOMBRE,F_NAC);
------------------HASTA AQUI



--------------AQUI
UPDATE IGE_1999 
SET EDAD = TIMESTAMPDIFF(YEAR, str_to_date(f_nac,'%d/%m/%Y'), NOW());

UPDATE IGE_1999 
SET EDAD = TIMESTAMPDIFF(YEAR, str_to_date(f_nac,'%d/%m/%Y'), toDate(F_INSC));

---------------HASTA AQUI

