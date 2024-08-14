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


