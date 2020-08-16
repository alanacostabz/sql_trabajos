-- ÍNDICES

-- nos permiten realizar busquedas con mayor 
-- rapidez en una BD. No forma parte del 
-- estandar sql, cada gestor de bd tiene su
-- propia sintaxis

-- Tipos índices:

  -- Clave primaria: cada valor es unico no permite null
  -- Índices ordinarios: permite dublicadoos y null
  -- Índices únicos: no permite dublicados pero si null
  -- Índices compuestos: permite multiples columnas y null

  -- ACCESS y MYSQL

  -- indices clave primaria
  CREATE TABLE EJEMPLO(
    DNI TEXT,
    NOMBRE TEXT,
    APELLIDO TEXT,
    EDAD NUMBER,
    PRIMARY KEY(DNI)
  );

  ALTER TABLE EJEMPLO
  ADD PRIMARY KEY(DNI);


  CREATE TABLE EJEMPLO(
    DNI TEXT,
    NOMBRE TEXT,
    APELLIDO TEXT,
    EDAD NUMBER,
    PRIMARY KEY(NOMBRE, APELLIDO)
  );

-- indices ordinarios
CREATE INDEX MIINDICE 
  ON EJEMPLO(APELLIDO);

-- indices unicos
CREATE UNIQUE INDEX MIINDICE
ON EJEMPLO(APELLIDO);

-- indices compuesto 
CREATE INDEX MIINDICE 
  ON EJEMPLO(NOMBRE,APELLIDO);


-- ELIMINACION DE INDICES

-- ACCESS
  CREATE TABLE EJEMPLO(
    DNI TEXT,
    NOMBRE TEXT,
    APELLIDO TEXT,
    EDAD NUMBER
  );

  CREATE INDEX MIINDICE
  ON EJEMPLO(DNI);

  DROP INDEX MIINDICE
  ON EJEMPLO;
  
  ALTER TABLE EJEMPLO
  ADD PRIMARY KEY(DNI);

-- CONSTRAINT ES SOLO VALIDO PARA SQL SERVER, ORACLE
-- ACCESS
  ALTER TABLE EJEMPLO
  DROP CONSTRAINT 'INSERTE INDICE';

  -- MYSQL
  ALTER TABLE EJEMPLO
  DROP PRIMARY KEY;
