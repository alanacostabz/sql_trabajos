CRATE TABLE LEVEL_TRIGGER (


)


CREATE TRIGGER TG_SPNIVEL_AI
AFTER INSERT ON ORDERS_DESCRIPTION
FOR EACH ROW
BEGIN

DECLARE VAL_CURP VARCHAR(255);
DECLARE VAL_ID_PERSONA VARCHAR(255);
DECLARE VAL_CLAVE_CT VARCHAR(255);
DECLARE VAL_NIVEL INT;
DECLARE VAL_NIVEL_NUEVO INT;
DECLARE FINALIZADO INT DEFAULT 0;
	
DECLARE CUR_PERSONAL CURSOR FOR;
  SELECT CURP, ID_PERSONA, CLAVE_CT, NIVEL
  FROM CEMABE_PERSONAL
  WHERE NIVEL < 9
  FOR UPDATE;
 
DECLARE CONTINUE HANDLER FOR NOT FOUND SET FINALIZADO = 1;
OPEN CUR_PERSONAL;
REPEAT
FETCH CUR_PERSONAL INTO VAL_CURP, VAL_ID_PERSONA, VAL_CLAVE_CT, VAL_NIVEL;
SET VAL_NIVEL_NUEVO = NIVEL + 2;
IF VAL_NIVEL_NUEVO >= 9 THEN
   SET VAL_NIVEL_NUEVO = 9;
END IF;
UPDATE CEMABE_PERSONAL SET NIVEL = VAL_NIVEL_NUEVO WHERE CURP = VAL_CURP AND ID_PERSONA = VAL_ID_PERSONA AND CLAVE_CT = VAL_CLAVE_CT;
UNTIL FINALIZADO = 1 END REPEAT;
CLOSE CUR_PERSONAL;
END//
DELIMITER;

------------------------------------------------------------------------------------------------------------------------------------

---------------------------------------------ESTE EL BUENO------------------------------------------------------------------------------------------

CREATE TABLE AUDIT_LEVEL (
AUDIT_DATE TIMESTAMP,
AUDIT_USER VARCHAR(40) not null,
AUDIT_ACTION ENUM('update','insert'),
CLAVE_CT  VARCHAR(23) NOT NULL,
AP_PATERNO VARCHAR(51) NOT NULL,
AP_MATERNO VARCHAR(51) NOT NULL,
NOMBRE_MAE VARCHAR(51) NOT NULL,
VIEJO_NIVEL INT(11) NOT NULL,
NIVEL INT(11) NOT NULL
);



---------------------------------------------------------------------------------------------------------------------------------
DROP TRIGGER IF EXISTS TG_SPNIVEL_AI;
DELIMITER //
CREATE TRIGGER TG_SPNIVEL_AI
BEFORE UPDATE ON CEMABE_PERSONAL
FOR EACH ROW
BEGIN
declare msg varchar(70);
DECLARE OLD_LEVEL INT DEFAULT OLD.NUEVO_NIVEL;
DECLARE NEW_LEVEL INT DEFAULT NEW.LEVEL;

IF OLD_LEVEL <= 7 THEN
	IF NEW_LEVEL - OLD_LEVEL != 2 THEN SET NEW.LEVEL = (OLD_LEVEL+2);
	END IF;
ELSEIF OLD_LEVEL = 8 THEN
	IF NEW_LEVEL - OLD_LEVEL !=1 THEN  SET NEW.LEVEL = (OLD_LEVEL+1);
    END IF;
ELSEIF OLD_LEVEL = 9 THEN
	IF NEW_LEVEL - OLD_LEVEL != 0 THEN SET NEW.LEVEL= 9;
    END IF;
END IF;

INSERT INTO AUDIT_LEVEL
(AUDIT_USER, AUDIT_ACTION, CLAVE_CT, AP_PATERNO, AP_MATERNO, NOMBRE_MAE, VIEJO_NIVEL,NIVEL) VALUES
(CURRENT_USER(),'update', NEW.CLAVE_CT, NEW.AP_PATERNO, NEW.AP_MATERNO,NEW.NOMBRE_MAE, OLD.NUEVO_NIVEL, NEW.LEVEL);
END	 
//
DELIMITER ;