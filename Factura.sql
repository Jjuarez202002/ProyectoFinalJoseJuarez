USE jugueteria;

CREATE TABLE factura (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATE NOT NULL,
    cliente_nombre VARCHAR(50) NOT NULL,
    total DECIMAL(10,2) NOT NULL
);

INSERT INTO factura (fecha, cliente_nombre, total) VALUES
    ('2023-01-01', 'Cliente1', 39.97),
    ('2023-01-02', 'Cliente2', 29.98);