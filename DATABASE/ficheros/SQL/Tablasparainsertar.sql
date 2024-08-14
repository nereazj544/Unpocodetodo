
CREATE TABLE empresa(
    id INTEGER PRIMARY KEY AUTOINCREMENT, 
    nombre VARCHAR(255) NOT NULL
);

CREATE TABLE personajes(
    id INTEGER PRIMARY KEY AUTOINCREMENT, 
    nombre VARCHAR(255) NOT NULL,
    juego VARCHAR(255) NOT NULL,
    empresa_id INTEGER,
    FOREIGN KEY (empresa_id) REFERENCES empresa(id)
);

CREATE TABLE libros(
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    titulo VARCHAR(255) NOT Null,
    autor VARCHAR(255) NOT Null
);

CREATE TABLE personajeslibros (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    pnombre VARCHAR(255) NOT NULL,
    novela VARCHAR(255) NOT NULL,
    libros_id INTEGER,  
    FOREIGN KEY (libros_id) REFERENCES libros(id)
);


