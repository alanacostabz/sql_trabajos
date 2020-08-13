 /* 1. Realizar una consulta que visualice los campos NOMBRE ARTÍCULO,
SECCIÓN, PRECIO de la tabla PRODUCTOS y un campo nuevo que
nombramos con el texto “DESCUENTO_7”. Debe mostrar el resultado de aplicar
sobre el campo PRECIO un descuento de un 7 %. El formato del nuevo campo
para debe aparecer con 2 lugares decimales. */
SELECT NOMBREARTÍCULO, SECCIÓN, PRECIO, ROUND(PRECIO-(PRECIO*0.07),2) AS DESCUENTO_7
FROM PRODUCTOS;

/* 2. Realizar una consulta visualizando los campos FECHA, SECCIÓN, NOMBRE
ARTÍCULO y PRECIO de la tabla PRODUCTOS y un campo nuevo que
nombramos con el texto “DTO2 €_EN_CERÁMICA”. Debe mostrar el resultado
de aplicar sobre el campo PRECIO la resta de 2 € sólo a los artículos de la sección
CERÁMICA. El formato del nuevo campo debe aparecer con 2 lugares decimales.
Ordenar el resultado de la consulta por el campo FECHA descendente.  */
SELECT FECHA, SECCIÓN, NOMBREARTÍCULO, PRECIO,
ROUND(PRECIO - 2,2) AS DETO2_EUROS_EN_CERÁMICA
FROM PRODUCTOS
WHERE SECCIÓN = 'CERÁMICA'
ORDER BY FECHA DESC;

/* 3. Realizar una consulta visualizando los campos NOMBRE ARTÍCULO,
SECCIÓN, PRECIO de la tabla PRODUCTOS y un campo nuevo que
nombramos con el texto “PRECIO_AUMENTADO_EN_2”. Debe mostrar el
PRECIO con un incremento de un 2% del PRECIO. Sólo debemos tener en cuenta
los registros de la sección FERRETERÍA. El nuevo campo debe aparecer en Euros
y con 2 lugares decimales. */
SELECT NOMBREARTÍCULO, SECCIÓN, PRECIO, ROUND(PRECIO*1.02,2) AS PRECIO_AUMENTADO_EN_2
FROM PRODUCTOS
WHERE SECCIÓN = "FERRETERÍA";