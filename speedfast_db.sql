CREATE DATABASE IF NOT EXISTS speedfast_db;
USE speedfast_db;

DROP TABLE IF EXISTS entrega;
DROP TABLE IF EXISTS pedido;
DROP TABLE IF EXISTS repartidor;

-- Tabla pedido
CREATE TABLE pedido (
    id INT AUTO_INCREMENT PRIMARY KEY,
    direccion VARCHAR(100) NOT NULL,
    tipo VARCHAR(50) NOT NULL,
    estado VARCHAR(50) NOT NULL
);

-- Tabla repartidor
CREATE TABLE repartidor (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    telefono VARCHAR(20)
);

CREATE TABLE entrega (
    id INT AUTO_INCREMENT PRIMARY KEY,
    pedido_id INT NOT NULL,
    repartidor_id INT NOT NULL,
    fecha DATE NOT NULL,
    FOREIGN KEY (pedido_id) REFERENCES pedido(id) ON DELETE CASCADE,
    FOREIGN KEY (repartidor_id) REFERENCES repartidor(id) ON DELETE CASCADE
);

INSERT INTO repartidor (nombre, telefono)
VALUES ('Vince Lombardi', '987654321');

INSERT INTO pedido (direccion, tipo, estado)
VALUES ('Av. HighMark 17', 'COMIDA', 'PENDIENTE');

INSERT INTO entrega (pedido_id, repartidor_id, fecha)
VALUES (1, 1, '2026-10-04');

SELECT * FROM repartidor;
SELECT * FROM pedido;
SELECT * FROM entrega;

DELETE FROM pedido WHERE id = 1;

DELETE FROM repartidor WHERE id = 1;

