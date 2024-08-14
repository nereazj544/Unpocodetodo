CREATE TABLE libros(
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    titulo VARCHAR(255) NOT Null,
    es_saga boolean default false,
    autor VARCHAR(255) NOT Null
);

CREATE TABLE personajeslibros (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    pnombre VARCHAR(255) NOT NULL,
    novela VARCHAR(255) NOT NULL,
    es_protagonista boolean default false,
    libros_id INTEGER,  
    FOREIGN KEY (libros_id) REFERENCES libros(id)
);

insert INTO libros (titulo, autor, es_saga) values
('Saga Mancuso', 'Neo', true),
('Saga Magia Antigua', 'Neo', true),
('Rojo y Azul', 'Neo', false),
('Mi niñera un zombie', 'Neo', false);

insert INTO personajeslibros (pnombre, novela, es_protagonista, libros_id) values
('Leo Mancuso', 'Saga Mancuso', true, 1),
('Kilari Miracle', 'Magia Antigua', true, 2),
('Killian De Metz', 'Rojo y Azul', true, 3),
('Kaori Cadaval', 'Mi niñera un zombie', true, 3);


