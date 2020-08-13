-- 1. Realizar una consulta que muestre aquellos productos españoles 
-- cuya fecha esté comprendida entre febrero y mayo del 2002. Ordenar 
-- los resultados por el campo “Nombre artículo” descendentemente
SELECT *
FROM PRODUCTOS 
WHERE PAÍSDEORIGEN = 'ESPAÑA'
AND FECHA BETWEEN '2002-02-01' AND '2002-05-31'
ORDER BY NOMBREARTÍCULO DESC;


/* 2. Realizar una consulta que muestre los campos “Empresa”, “Dirección” y
“Población” de la tabla “Clientes”. Ordenar la consulta por el campo 
“Población” ascendentemente y por “Dirección” descendentemente. */
SELECT EMPRESA, DIRECCIÓN, POBLACIÓN
FROM CLIENTES 
ORDER BY POBLACIÓN, DIRECCIÓN DESC; -- ORDER BY POR DEFAULT ES ASC