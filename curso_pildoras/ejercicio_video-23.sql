-- PROCEDIMIENTO ALMACENADO
  -- consiste en almacenar en un procedimiento
  -- instrucciones sql repetitivas que se ejecutan
  -- de diferentes aplicaciones, puestos usuarios
  -- ventajas: eficiencia y seguridad

  -- acces no admite esto, (hay otras formas)
  -- mysql a partir de la version 5.0 los admite

  -- PARA VER:
    -- SHOW PROCEDURE STATUS;
    -- SHOW FUNCTION STATUS;
    -- SHOW TRIGGER
  
  -- EJEMPLO:
  CREATE PROCEDURE MUESTRA_CLIENTES()
  SELECT * FROM CLIENTES
  WHERE POBLACIÓN = 'MADRID';

  -- EJEMPLO CON PARAMETROS:
 
  DROP PROCEDURE IF EXISTS ACTUALIZA_PRODUCTOS;
  DELIMITER //
    CREATE PROCEDURE ACTUALIZA_PRODUCTOS(N_PRECIO INT, CODIGO VARCHAR(4))
    BEGIN
      UPDATE PRODUCTOS
      SET PRECIO=N_PRECIO
      WHERE CÓDIGOARTÍCULO=CODIGO;
    END //
  DELIMITER ;

  CALL ACTUALIZA_PRODUCTOS(60,'AR22');
  SELECT * FROM PRODUCTOS WHERE CÓDIGOARTÍCULO = 'AR22';