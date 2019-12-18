# Creación de la base de datos

CREATE DATABASE Aplicacion;

USE Aplicacion;

# Creación del usuario

CREATE USER 'aplicacion'@'%' IDENTIFIED BY 'patata23';

GRANT ALL PRIVILEGES ON Aplicacion.* TO 'aplicacion'@'%';

# Creación de las tablas

CREATE TABLE Usuarios (
  id INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(45) NULL,
  usuario VARCHAR(45) NULL,
  password VARCHAR(45) NULL,
  PRIMARY KEY (id)) CHARSET=utf8;
 
# Inserción de datos de ejemplo
 
INSERT INTO Usuarios (id, nombre, usuario, password) VALUES ('1', 'Tomás', 'tom', 'tom');
INSERT INTO Usuarios (id, nombre, usuario, password) VALUES ('2', 'Pau', 'pau', 'pau');
INSERT INTO Usuarios (id, nombre, usuario, password) VALUES ('3', 'Juan', 'juan', 'juan');