/*
 * Axel Fernando Montiel Aviles
 */

CREATE DATABASE coleccionables 
	CHARACTER SET utf8mb4
	COLLATE utf8mb4_unicode_ci;

USE coleccionables;

CREATE TABLE pais(
	id INT PRIMARY KEY AUTO_INCREMENT,
	nombre VARCHAR(50) NOT NULL,
	codigo VARCHAR(2) NOT NULL
);

ALTER TABLE pais MODIFY codigo CHAR(2) UNIQUE NOT NULL;

CREATE TABLE fabricante(
	id INT PRIMARY KEY AUTO_INCREMENT,
	nombre VARCHAR(50) NOT NULL,
	id_pais INT NOT NULL,
	FOREIGN KEY (id_pais) REFERENCES pais(id)
);

CREATE TABLE edicion(
	id INT PRIMARY KEY AUTO_INCREMENT,
	nombre VARCHAR(50) NOT NULL,
	descripcion VARCHAR(250) DEFAULT ''
);

CREATE TABLE figura(
	id INT PRIMARY KEY AUTO_INCREMENT,
	nombre VARCHAR(50) NOT NULL,
	descripcion VARCHAR(250) DEFAULT '',
	fecha_lanzamiento DATE NOT NULL,
	precio DECIMAL(10, 2) DEFAULT 0 CHECK (precio >= 0),
	id_fabricante INT NOT NULL,
	id_edicion INT NOT NULL,
	FOREIGN KEY (id_fabricante) REFERENCES fabricante(id),
	FOREIGN KEY (id_edicion) REFERENCES edicion(id)
);

CREATE TABLE coleccionista(
	id INT PRIMARY KEY AUTO_INCREMENT,
	nombre VARCHAR(50) NOT NULL,
	email VARCHAR(255) NOT NULL UNIQUE 
	CHECK (email LIKE '%@%'),
	telefono CHAR(10) NOT NULL UNIQUE
);

CREATE TABLE transaccion(
	id INT PRIMARY KEY AUTO_INCREMENT,
	fecha DATE NOT NULL,
	precio_transaccion DECIMAL(10, 2) DEFAULT 0 CHECK (precio_transaccion >= 0),
	id_figura INT NOT NULL,
	id_coleccionista INT NOT NULL,
	FOREIGN KEY (id_figura) REFERENCES figura(id),
	FOREIGN KEY (id_coleccionista) REFERENCES coleccionista(id)
);
