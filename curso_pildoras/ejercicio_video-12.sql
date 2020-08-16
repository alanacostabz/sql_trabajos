-- CONSULTAS DE ACCIÓN DE ELIMINACIÓN

-- EJEMPLO: ELIMINAR LOS CLIENTES DE MADRID
DELETE FROM CLIENTES
WHERE POBLACIÓN = 'MADRID';


-- EJEMPLO: ELIMINAR REGISTROS DE SECCION DEPORTIVOS
-- Y SU PRECIO ES ENTRE 50 Y 100 EUROS
DELETE FROM PRODUCTOS
WHERE SECCIÓN = 'DEPORTIVOS'
  AND PRECIO BETWEEN 50 AND 100;



-- PREDICADOS 
  -- DISTINCT: FILTRA LOS CAMPOS REPETIDOS
  -- DISTINCTROW: FILTRA LOS REGISTRO REPETIDOS (TODA LA FILA) 

-- EJEMPLOS:
SELECT DISTINCT EMPRESA
FROM CLIENTES
INNER JOIN PEDIDOS
ON CLIENTES.CÓDIGOCLIENTE = PEDIDOS.CÓDIGOCLIENTE;

SELECT DISTINCTROW * 
FROM PRODUCTOS 
WHERE SECCIÓN = 'FERRETERÍA'; 



DELETE DISTINCTROW CLIENTES.*, PEDIDOS.CÓDIGOCLIENTE
FROM CLIENTES LEFT JOIN PEDIDOS
ON CLIENTES.CÓDIGOCLIENTE = PEDIDOS.CÓDIGOCLIENTE
WHERE PEDIDOS.CÓDIGOCLIENTE IS NULL;