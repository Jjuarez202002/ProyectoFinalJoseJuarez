USE jugueteria;

CREATE TABLE juguete (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(45) NOT NULL,
    precio DECIMAL(10,2) NOT NULL,
    color VARCHAR(15) NOT NULL,
    marca VARCHAR(40) NOT NULL,
    piezas INT NOT NULL
);

SELECT * FROM JUGUETE;

INSERT INTO juguete (nombre, precio, color, marca, piezas) VALUES ('Pelota', 12.99, 'Rojo', 'Nike', 1);

-- Insert 2
INSERT INTO juguete (nombre, precio, color, marca, piezas) VALUES ('Rompecabezas', 19.99, 'Azul', 'Ravensburger', 500);

-- Insert 3
INSERT INTO juguete (nombre, precio, color, marca, piezas) VALUES ('Muñeca', 29.99, 'Rosado', 'Barbie', 1);

-- Insert 4
INSERT INTO juguete (nombre, precio, color, marca, piezas) VALUES ('Coche de juguete', 15.99, 'Verde', 'Hot Wheels', 1);

-- Insert 5
INSERT INTO juguete (nombre, precio, color, marca, piezas) VALUES ('Peluche', 9.99, 'Marrón', 'Disney', 1);
