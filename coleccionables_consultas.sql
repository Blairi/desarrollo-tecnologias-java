/*
 * Axel Fernando Montiel Aviles
 */

USE coleccionables;

INSERT INTO pais (nombre, codigo) VALUES
('Estados Unidos', 'US'),
('Japón', 'JP'),
('China', 'CN'),
('México', 'MX'),
('Reino Unido', 'GB');

INSERT INTO fabricante (nombre, id_pais) VALUES
('McFarlane Toys', 1),        -- ID 1 (US)
('Good Smile Company', 2),    -- ID 2 (JP)
('Hot Toys', 3),              -- ID 3 (CN)
('Bandai', 2),                -- ID 4 (JP)
('Diamond Select', 1);        -- ID 5 (US)


INSERT INTO edicion (nombre, descripcion) VALUES
('Estándar', 'Versión de producción regular sin accesorios extra.'),
('Edición Limitada', 'Tiraje limitado con certificado de autenticidad.'),
('Bloody Variant', 'Versión especial con detalles de daño de batalla y salpicaduras.'),
('Collector''s Edition', 'Caja premium, base dinámica y múltiples cambios de manos/rostros.');


INSERT INTO figura (nombre, descripcion, fecha_lanzamiento, precio, id_fabricante, id_edicion) VALUES
('Invincible', 'Figura articulada de Mark Grayson con traje clásico.', '2023-05-15', 450.00, 1, 1),
('Omni-Man', 'Nolan Grayson con capa de tela y rostro intercambiable enfurecido.', '2023-08-20', 480.00, 1, 3),
('Atom Eve', 'Figura con efectos de energía translúcida rosada.', '2023-11-10', 450.00, 1, 1),
('Goku Super Saiyan', 'Línea SH Figuarts con efectos de aura y rostros extra.', '2022-04-05', 1200.00, 4, 1),
('Spider-Man 1/6 Scale', 'Figura hiperrealista del videojuego con base dinámica.', '2024-01-15', 5500.00, 3, 4),
('Allen the Alien', 'Figura de lujo tamaño XL con gran nivel de detalle.', '2024-02-28', 850.00, 5, 1),
('Nendoroid Link', 'Versión Tears of the Kingdom con planeador y espada maestra.', '2024-03-10', 1100.00, 2, 1),
('Iron Man Mark LXXXV', 'Diecast metal con luces LED integradas en pecho y repulsores.', '2021-12-01', 8900.00, 3, 2),
('Invincible - Battle Damage', 'Variante exclusiva de convención con traje roto y daño de batalla.', '2024-07-20', 1500.00, 1, 2),
('Batman The Dark Knight', 'Figura articulada con batarang, pistola gancho y capa alambrada.', '2020-09-14', 1350.00, 4, 1);


INSERT INTO coleccionista (nombre, email, telefono) VALUES
('Héctor', 'hector.coleccion@email.com', '5511223344'),
('Carlos Ruiz', 'cruiz99@email.com', '5599887766'),
('Ana Sofía Gómez', 'anasof_g@email.com', '5544332211'),
('Luis Mendoza', 'luis.mendoza@email.com', '3322114455'),
('Valeria Torres', 'val.torres_collect@email.com', '8112233445');


INSERT INTO transaccion (fecha, precio_transaccion, id_figura, id_coleccionista) VALUES
('2025-01-10', 450.00, 1, 1),   -- Héctor compra la figura de Invincible
('2025-01-15', 550.00, 2, 1),   -- Héctor compra a Omni-Man
('2025-02-20', 1200.00, 4, 2),  -- Carlos compra a Goku
('2025-03-05', 5500.00, 5, 3),  -- Ana compra a Spider-Man
('2025-04-12', 450.00, 3, 1),   -- Héctor compra a Atom Eve
('2025-05-22', 850.00, 6, 4),   -- Luis compra a Allen the Alien
('2025-06-30', 8900.00, 8, 5),  -- Valeria compra a Iron Man
('2025-08-14', 1800.00, 9, 2),  -- Carlos compra la variante de Invincible Battle Damage
('2025-09-01', 1100.00, 7, 3),  -- Ana compra el Nendoroid de Link
('2025-10-15', 1350.00, 10, 4); -- Luis compra a Batman

INSERT INTO transaccion (fecha, precio_transaccion, id_figura, id_coleccionista) VALUES
-- Transacciones de Enero 2024 (Primer trimestre)
('2024-01-12', 450.00, 1, 1),
('2024-01-25', 1200.00, 4, 2),
('2024-01-28', 480.00, 2, 3),

-- Transacciones de Febrero 2024 (Primer trimestre)
('2024-02-14', 850.00, 6, 4),
('2024-02-20', 5500.00, 5, 5),

-- Transacciones de Marzo 2024 (Primer trimestre)
('2024-03-05', 1100.00, 7, 1),
('2024-03-18', 450.00, 3, 2),
('2024-03-29', 1350.00, 10, 3),

-- Transacciones fuera del trimestre
('2024-04-10', 8900.00, 8, 4),
('2024-05-22', 1500.00, 9, 5);

-- a. Listar todas las figuras junto con sus fabricantes.
SELECT 
	fig.nombre AS nombre_figura,
	fab.nombre AS fabricante
FROM figura fig
JOIN fabricante fab
ON fig.id_fabricante = fab.id;

-- b. Listar las figuras de un fabricante en particular con precio mayor a $200.00.
SELECT 
	fig.nombre AS nombre_figura,
	fig.precio,
	fab.nombre AS fabricante
FROM figura fig
JOIN fabricante fab
ON fig.id_fabricante = fab.id
WHERE 
	fig.id_fabricante = 1 AND
	fig.precio > 200;

-- c. Promedio de precios por fabricante
SELECT 
	fab.nombre as nombre_fabricante,
	AVG(fig.precio)
FROM figura fig
JOIN fabricante fab
ON fig.id_fabricante = fab.id
GROUP BY fig.id_fabricante;

-- d. Obtener la cantidad vendida por mes del primer trimestre de 2024.
SELECT 
	t.fecha,
	SUM(t.precio_transaccion)
FROM transaccion t
WHERE t.fecha BETWEEN '2024-01-01' AND '2024-04-01'
GROUP BY MONTH(t.fecha);






