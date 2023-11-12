CREATE TABLE inventario (
    idInventario INT AUTO_INCREMENT PRIMARY KEY,
    idJuguete INT NOT NULL,
    cantidad INT NOT NULL,
    clasiJuguete VARCHAR(50) NOT NULL,
    FOREIGN KEY (idJuguete) REFERENCES juguete(id)
);

INSERT INTO juguete (nombre, precio, color, marca, piezas) VALUES
    ('Pelota', 9.99, 'Rojo', 'MarcaA', 10),
    ('Muñeca', 19.99, 'Rosado', 'MarcaB', 5),
    ('Rompecabezas', 14.99, 'Azul', 'MarcaC', 3);


INSERT INTO inventario (idJuguete, cantidad, clasiJuguete) VALUES
    (1, 20, 'Pelota'),
    (2, 15, 'Muñeca'),
    (3, 5, 'Rompecabezas');