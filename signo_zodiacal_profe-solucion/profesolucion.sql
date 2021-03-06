DELIMITER //
CREATE FUNCTION FNC_CHINO (CURP VARCHAR(18), VAL_FECHA VARCHAR(10)) RETURNS VARCHAR(30) 
BEGIn

	--declaracion de variables
	DECLARE ANIO VARCHAR(1);
	DECLARE ASCENDENTE VARCHAR(6);
	DECLARE VAL_FECHA_NAC DATE;
	DECLARE ANYO_NAC INT;
	DECLARE ANIMAL VARCHAR(20);
	DECLARE HOROSCOPO VARCHAR(50);
	DECLARE RESTO FLOAT;

	--estructura definida por el profe, basicamente toma el ultimo digito
	--del año de nacimiento para determinar el elemento
	SET ANIO = SUBSTR( CURP, 6 , 1);
	CASE ANIO 
		WHEN '0' THEN SET ASCENDENTE = 'METAL';
		WHEN '1' THEN SET ASCENDENTE = 'METAL';
		WHEN '2' THEN SET ASCENDENTE = 'AGUA';
		WHEN '3' THEN SET ASCENDENTE = 'AGUA';
		WHEN '4' THEN SET ASCENDENTE = 'MADERA';
		WHEN '5' THEN SET ASCENDENTE = 'MADERA';
		WHEN '6' THEN SET ASCENDENTE = 'FUEGO';
		WHEN '7' THEN SET ASCENDENTE = 'FUEGO';
		WHEN '8' THEN SET ASCENDENTE = 'TIERRA';
		WHEN '9' THEN SET ASCENDENTE = 'TIERRA';
		ELSE SET ASCENDENTE = '';
		END CASE;

		--a partir del parametro de la fecha, se pasa de varchar a tipo date
		--despues obtengo el año de la fecha mediante el metodo YEAR()
		--al año obtenido se le saca el residuo de 12 lo cual nos dara valores
		--de entre 0 y 11 lo cual determinara el animal correspondiente
		SET VAL_FECHA_NAC = STR_TO_DATE(VAL_FECHA, '%d/%m/%Y');
		SET ANYO_NAC = YEAR(VAL_FECHA_NAC);
		SET RESTO = (ANYO_NAC%12);
		IF(RESTO = 0) THEN SET ANIMAL = 'MONO';
		ELSEIF(RESTO = 1) THEN SET ANIMAL = 'GALLO';
		ELSEIF(RESTO = 2) THEN SET ANIMAL = 'PERRO';
		ELSEIF(RESTO = 3) THEN SET ANIMAL = 'CERDO';
		ELSEIF(RESTO = 4) THEN SET ANIMAL = 'RATA';
		ELSEIF(RESTO = 5) THEN SET ANIMAL = 'BUEY';
		ELSEIF(RESTO = 6) THEN SET ANIMAL = 'TIGRE';
		ELSEIF(RESTO = 7) THEN SET ANIMAL = 'CONEJO';
		ELSEIF(RESTO = 8) THEN SET ANIMAL = 'DRAGON';
		ELSEIF(RESTO = 9) THEN SET ANIMAL = 'SERPIENTE';
		ELSEIF(RESTO = 10) THEN SET ANIMAL = 'CABALLO';
		ELSEIF(RESTO = 11) THEN SET ANIMAL = 'CABRA';
END IF;
		--se concatena el animal y elemento correspondiente
		SET HOROSCOPO = concat(ANIMAL, ' DE ', ASCENDENTE);
		RETURN HOROSCOPO;
	END //
	DELIMITER ;


--select utilizado para invocar la funcion
 SELECT AP_PATERNO, AP_MATERNO, NOMBRE_MAE,CURP,FECHA_NAC, FNC_CHINO(CURP, FECHA_NAC)
  FROM CEMABE_PERSONAL
   WHERE LENGTH(CURP)=18 
   AND FECHA_NAC <> '' LIMIT 20;