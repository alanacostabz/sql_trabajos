-- CONSULTAS DE ACCIÓN
  -- ACTUALIZACIÓN
  -- CREACIÓN DE TABLA
  -- ELIMINACIÓN
  -- DATOS ANEXADOS

-- COMADOS DML Y DDL
  -- CREATE
  -- UPDATE
  -- DELETE
  -- INSERT INTO
  -- SELECT INTO

  -- EJEMPLO UPDATE
  UPDATE PRODUCTOS 
  SET PRECIO = PRECIO + 10
  WHERE SECCIÓN = "DEPORTES";

    UPDATE PRODUCTOS 
  SET SECCIÓN = 'DEPORTIVOS'
  WHERE SECCIÓN = 'DEPORTES';

  -- EJEMPLO CREATE
  -- QUERY EN ACCESS -> select into solo crea la tabla sim
  -- determinar propiedades ni caracteristicas de la tabla
  SELECT *  INTO CLIENTES_MADRID 
  FROM CLIENTES 
  WHERE POBLACIÓN = "MADRID";

  -- QUERY EN MYSQL -> permite determinar las propiedades y
  -- caracteristicas de la nueva tabla es más potente
  CREATE TABLE CLIENTES_MADRID
  SELECT * FROM CLIENTES
  WHERE POBLACIÓN = 'MADRID';



  -- EJERCICIOS DE CONSULTAS DE CREACIÓN DE TABLA

/* 1. Realizar una consulta de acción de creación de tabla a partir de la tabla
CLIENTES, utilizando todos los campos de la tabla, pero únicamente los
registros que sean de la población Madrid. El nuevo objeto lo nombramos
con el texto “CLIENTES_DE_MADRID”. Ejecutamos la consulta.  */

-- SOLUCIÓN MYSQL
CREATE TABLE CLIENTES_DE_MADRID
SELECT *
FROM CLIENTES
WHERE POBLACIÓN = "MADRID";

-- SOLUCIÓN ACCESS
SELECT * INTO CLIENTES_DE_MADRID
FROM CLIENTES
WHERE POBLACIÓN = "MADRID";


/* 2. Realizar una consulta de acción de creación de tabla a partir de la tabla
PRODUCTOS, utilizando todos los campos de la tabla, pero sólo los
registros que sean de la sección DEPORTES. El nuevo objeto – tabla lo
nombramos con el texto “ARTÍCULOS_DE_DEPORTES”. Ejecutamos la
consulta. */

-- SOLUCIÓN MYSQL
CREATE TABLE ARTÍCULO_DE_DEPORTES
SELECT * 
FROM PRODUCTOS
WHERE SECCIÓN = "DEPORTES";

-- SOLUCIÓN ACCESS
SELECT * INTO ARTÍCULO_DE_DEPORTES
FROM PRODUCTOS
WHERE SECCIÓN = "DEPORTIVOS";


/* 3. Realizar una consulta de acción de creación de tabla a partir de la tabla
PEDIDOS, utilizando todos los campos de la tabla, pero sólo los registros
que tengan registrada la forma de pago TARJETA. El nuevo objeto – tabla
lo nombramos con el texto “PEDIDOS_PAGADOS_CON_TARJETA”.
Ejecutamos la consulta.  */

-- SOLUCIÓN MYSQL
CREATE TABLE PEDIDOS_PAGADOS_CON_TARJETA
SELECT * 
FROM PEDIDOS
WHERE FORMADEPAGO = "TARJETA";

-- SOLUCIÓN ACCESS
SELECT * INTO PEDIDOS_PAGADOS_CON_TARJETA
FROM PEDIDOS
WHERE FORMADEPAGO = "TARJETA";




-- EJERCICIO DE CONSULTA DE ACTUALIZACIÓN

/* 4. Realizar una consulta que actualice los precios de la tabla ARTÍCULOS DE
DEPORTE. La actualización consiste en calcular el IVA (21%) y mostrar en
ese campo como resultado el precio con el IVA incluido. Ejecutar la
consulta.  */

-- SOLUCIÓN GENERAL
UPDATE PRODUCTOS 
SET PRECIO = (PRECIO*1.21) 
WHERE SECCIÓN = "DEPORTES";

/* 
5. Realizar una consulta que actualice el campo DESCUENTO de la tabla
PEDIDOS_PAGADOS_CON TARJETA. La actualización consiste poner a un
5% los descuentos que se muestran inferiores a esta cifra. Ejecutar la
consulta. */

-- SOLUCIÓN GENERAL
UPDATE PEDIDOS_PAGADOS_CON_TARJETA 
SET DESCUENTO = 0.05
WHERE DESCUENTO < 0.05;