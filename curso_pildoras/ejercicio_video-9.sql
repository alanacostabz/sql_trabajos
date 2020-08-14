-- SUBCONSULTAS: ES UNA CONSULTA DENTRO DE OTRA
-- (UN SELECT DENTRO DE OTRO SELECT)
  -- TIPOS:
    -- ESCALONADA
    -- DE LISTA
    -- CORRELACIONADA

  -- OPERADORES LÓGICOS:
    -- AND: todas la condiciones verdaderas
    -- OR: una de las codicionaes verdaderas
    -- NOT: valor contrario de la expresión
  
  -- OPERADORES DE COMPARACIÓN:
    -- LIKE: comparacion de cadenas de carácteres
    -- <>, <=, <, > : mayor que..., menor que..., distinto que... etc
    -- BETWEEN: intervalos
    -- IN
    -- ANY
    -- ALL

    -- EJEMPLO: ESCALONADA -> devuelven un campo in un registro
    SELECT NOMBREARTÍCULO, SECCIÓN, PRECIO
    FROM PRODUCTOS WHERE PRECIO > (SELECT AVG(PRECIO) FROM PRODUCTOS); 

    -- EJEMPLO: DE LISTA -> devuelva una lista de registro
    -- (aquí se usan más los operadores IN, ANY, ALL)
    SELECT * 
    FROM PRODUCTOS 
    WHERE PRECIO > ALL 
    (SELECT PRECIO FROM PRODUCTOS WHERE SECCIÓN = "CERÁMICA");

    SELECT * 
    FROM PRODUCTOS 
    WHERE PRECIO > ANY 
    (SELECT PRECIO FROM PRODUCTOS WHERE SECCIÓN = "CERÁMICA");

    SELECT *
    FROM PRODUCTOS
    WHERE PRECIO > ALL
    (SELECT PRECIO FROM PRODUCTOS WHERE SECCIÓN = 'JUGUETERÍA');

    SELECT *
    FROM PRODUCTOS
    WHERE PRECIO > ANY
    (SELECT PRECIO FROM PRODUCTOS WHERE SECCIÓN = 'JUGUETERÍA');