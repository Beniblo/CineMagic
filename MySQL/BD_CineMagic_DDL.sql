-- **********************************************
--  Artifact:   BD_CineMagic_DDL.sql
--  Version:    1.0
--  Date:       2025-07-31
--  Email:      gutiérrezromopablo@gmail.com
--  Author:     Gutierrez Pablo
-- **********************************************

-- CREACIÓN DE LA BASE DE DATOS
CREATE DATABASE CineMagic;
USE CineMagic;

-- 1. Persona (Tabla padre que hereda mismos atributos a espectador y administrador)
CREATE TABLE Persona (
    id_Persona INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    correo VARCHAR(100) NOT NULL UNIQUE
);

-- 2. Cuenta (Esta tabla guarda las cuentas ya sea de espectadores o clientes)
CREATE TABLE Cuenta (
    id_Cuenta INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    usuario VARCHAR(50) NOT NULL UNIQUE,
    contraseña VARCHAR(255) NOT NULL,
    id_Persona INT NOT NULL,
    FOREIGN KEY (id_Persona) REFERENCES Persona(id_Persona)
);

-- 3. Espectador (Tabla que va guardando a los espectadores)
CREATE TABLE Espectador (
    id_Persona INT NOT NULL PRIMARY KEY,
    FOREIGN KEY (id_Persona) REFERENCES Persona(id_Persona)
);

-- 4. Administrador (Tabla que va guardando a los administradores)
CREATE TABLE Administrador (
    id_Persona INT NOT NULL PRIMARY KEY,
    FOREIGN KEY (id_Persona) REFERENCES Persona(id_Persona)
);

-- 5. Película (Tabla que guarda información de peliculas)
CREATE TABLE Pelicula (
    id_Pelicula INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    genero VARCHAR(50),
    duracion INT NOT NULL,
    sinopsis TEXT
);

-- 6. Función (Esta tabla contiene todos los datos de la función, los mas importantes, horario y que pelicula se esta emitiendo)
CREATE TABLE Funcion (
    id_Funcion INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    fecha DATE NOT NULL,
    hora TIME NOT NULL,
    sala ENUM('Sala 1', 'Sala 2', 'Sala 3') NOT NULL,
    formato ENUM('2D', '3D', 'IMAX') NOT NULL,
    id_Pelicula INT NOT NULL,
    id_Administrador INT NOT NULL,
    FOREIGN KEY (id_Pelicula) REFERENCES Pelicula(id_Pelicula),
    FOREIGN KEY (id_Administrador) REFERENCES Administrador(id_Persona)
);

-- 7. Asiento (modificado numeroFila a ENUM con 14 valores)
CREATE TABLE Asiento (
    id_Asiento INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    fila ENUM('A','B','C','D','E','F','G','H','I','J') NOT NULL,
    numeroFila ENUM('1','2','3','4','5','6','7','8','9','10','11','12','13','14') NOT NULL,
    estado ENUM('Disponible','Ocupado','Reservado') NOT NULL,
    id_Funcion INT NOT NULL,
    FOREIGN KEY (id_Funcion) REFERENCES Funcion(id_Funcion)
);

-- 8. Compra (Tabla que guarda la información de la compra)
CREATE TABLE Compra (
    id_Compra INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    fecha DATETIME NOT NULL,
    total DECIMAL(8,2) NOT NULL,
    medioPago ENUM('Efectivo', 'Tarjeta', 'Transferencia', 'PayPal') NOT NULL,
    id_Espectador INT NOT NULL,
    FOREIGN KEY (id_Espectador) REFERENCES Espectador(id_Persona)
);

-- 9. DetalleCompra (Guarda el detalle de las compras, creada para la medicion de tendencias por el administrador)
CREATE TABLE DetalleCompra (
    id_DetalleCompra INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    id_Compra INT NOT NULL,
    id_Asiento INT NOT NULL,
    FOREIGN KEY (id_Compra) REFERENCES Compra(id_Compra),
    FOREIGN KEY (id_Asiento) REFERENCES Asiento(id_Asiento)
);

-- 10. Calificación (tabla que se encargara de guardar las calificación de los espectadores)
CREATE TABLE Calificacion (
    id_Calificacion INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    estrellas INT NOT NULL CHECK (estrellas BETWEEN 1 AND 5),
    fecha DATE NOT NULL,
    id_Pelicula INT NOT NULL,
    id_Espectador INT NOT NULL,
    FOREIGN KEY (id_Pelicula) REFERENCES Pelicula(id_Pelicula),
    FOREIGN KEY (id_Espectador) REFERENCES Espectador(id_Persona)
);

-- 11. Resenia (tabla que se encargara de guardar los comentarios de los espectadores)
CREATE TABLE Resenia (
    id_Resenia INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    fecha DATE NOT NULL,
    contenido TEXT NOT NULL,
    id_Espectador INT NOT NULL,
    id_Pelicula INT NOT NULL,
    FOREIGN KEY (id_Espectador) REFERENCES Espectador(id_Persona),
    FOREIGN KEY (id_Pelicula) REFERENCES Pelicula(id_Pelicula)
);