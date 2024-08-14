create table Libros{
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    titulo VARCHAR(255) NOT Null,
    autor VARCHAR(255) NOT Null
}
create table Personajes_Libros{
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre_personaje VARCHAR(255) NOT Null,
    novela VARCHAR(255) NOT Null,
    FOREIGN KEY (id_libro) REFERENCES Libros(id)
}