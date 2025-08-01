-- **********************************************
--  Artifact:   BD_CineMagic_DML.sql
--  Version:    1.0
--  Date:       2025-07-31
--  Email:      gutierrezromopablo@gmail.com
--  Author:     Gutiérrez Pablo
-- **********************************************

USE CineMagic;

-- Se inserta informacion solo para pruebas
-- Persona
INSERT INTO Persona (nombre, correo) VALUES
('Pablo Guiovanni Gutiérrez Romo', 'gutierrez2002@gmail.com'),
('Ana Hernández Ramirez', 'ana77@gmail.com'),
('Pedro Zapata Pistolas', 'pistola66@outlook.com');

-- Cuenta
INSERT INTO Cuenta (usuario, contraseña, id_Persona) VALUES
('bolillo', 'contraseña', 1),
('banana', 'contraseña2jeje', 2),
('elzapato', 'labota', 3);

-- Espectador
-- Pablo y Pedro son espectadores
INSERT INTO Espectador (id_Persona) VALUES (1);
INSERT INTO Espectador (id_Persona) VALUES (3);

-- Administrador
-- Ana es administradora
INSERT INTO Administrador (id_Persona) VALUES (2);

-- Película
INSERT INTO Pelicula (titulo, genero, duracion, sinopsis) VALUES
('Los 4 Fantasticos: primeros pasos', 'Acción', 115, 'La película "Los 4 Fantásticos: Primeros pasos" se ambienta en un mundo retro-futurista inspirado en los años 60, donde la Primera Familia de Marvel enfrenta su desafío más terrorífico hasta la fecha. Obligados a equilibrar sus roles como héroes con la fortaleza de su vínculo familiar, deben defender la Tierra de un dios espacial voraz llamado Galactus y su enigmático Heraldo, Silver Surfer. La película también introduce a Franklin Richards, un mutante Omega que podría ser clave en el futuro del UCM y en los eventos de Avengers: Secret Wars.'),
('Jurassic World: el renacer', 'Aventura', 134, 'La película "Jurassic World: El Renacer" se desarrolla cinco años después de los eventos de "Jurassic World: Dominion". La trama sigue a Zora Bennett, una experta en operaciones encubiertas, quien es contratada para dirigir a un equipo de especialistas en una misión secreta para obtener material genético de tres dinosaurios prehistóricos. La operación se ve interrumpida por un barco volcado por dinosaurios acuáticos, llevando a los miembros del equipo a una isla donde descubren un secreto siniestro que ha estado oculto durante décadas. La película combina elementos de aventura, acción y un toque de humor, aunque algunos críticos han señalado que la dirección y el guion han sido mediocres.');

-- Función
INSERT INTO Funcion (fecha, hora, sala, formato, id_Pelicula, id_Administrador) VALUES
('2025-08-03', '18:00:00', 'Sala 1', '2D', 1, 2),
('2025-08-03', '20:00:00', 'Sala 3', '3D', 2, 2);

-- Asiento
INSERT INTO Asiento (fila, numeroFila, estado, id_Funcion) VALUES
('I', '11', 'Disponible', 1),
('C', '5', 'Ocupado', 1),
('B', '1', 'Disponible', 2),
('G', '7', 'Reservado', 2);

-- Compra 
INSERT INTO Compra (fecha, total, medioPago, id_Espectador) VALUES
('2025-07-31 17:30:00', 120.00, 'PayPal', 3);

-- DetalleCompra
INSERT INTO DetalleCompra (id_Compra, id_Asiento) VALUES
(1, 1),
(1, 2);

-- Calificación
INSERT INTO Calificacion (estrellas, fecha, id_Pelicula, id_Espectador) VALUES 
(5, '2025-08-04', 1, 1),
(3, '2025-08-04', 2, 3);

INSERT INTO Resenia (fecha, contenido, id_Espectador) VALUES
('2025-08-01', 'Es fantastico...', 3);
