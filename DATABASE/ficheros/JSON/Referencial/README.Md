## Tabla de contenido
1. [Introducción](#introducion)
2. [Concepto Basico](#concepto-básico)



# Introducion 
Los archivos <span style="color: #ED8B00">**_JSON referenciales_**</span> son archivos que contienen datos relacionados entre sí a través de referencias. Estas referencias permiten que los datos en un archivo se vinculen a datos en otro archivo, creando una estructura que refleja relaciones entre diferentes entidades.


# Concepto Básico:
- **Entidad**: Una entidad es un objeto o concepto del mundo real que tiene propiedades y puede ser representado en un archivo JSON. Ejemplos de entidades son "personajes" y "empresas".
- **Referencia**: Una referencia es un campo en una entidad que apunta a otra entidad. En JSON, esto se logra generalmente mediante un identificador (ID) que es compartido entre entidades relacionadas.

### Ejemplo con `personajes.json` y `empresas.json`:

#### 1. `empresas.json`
Este archivo contiene la información de las empresas. Cada empresa tiene un `id` único que la identifica.

```json
[
    {
        "id": 1,
        "nombre": "Level-5"
    },
    {
        "id": 2,
        "nombre": "Nintendo"
    },
    {
        "id": 3,
        "nombre": "Kuro Games"
    },
    {
        "id": 4,
        "nombre": "Hoyoverse"
    }
]
```

- **Campo `id`**: Este campo es el identificador único de cada empresa. Se utiliza para referenciar esta empresa desde otras entidades (por ejemplo, personajes).

#### 2. `personajes.json`
Este archivo contiene la información de los personajes. Cada personaje tiene un `id_empresa` que referencia el `id` de una empresa en `empresas.json`.

```json
[
    {
        "id": 1,
        "nombre": "Shawn Froste",
        "videojuego": "inazuma eleven",
        "id_empresa": 1
    },
    {
        "id": 9,
        "nombre": "Bennett",
        "videojuego": "Genshin Impact",
        "id_empresa": 4
    },
    {
        "id": 26,
        "nombre": "Mario",
        "videojuego": "Super Mario Bross",
        "id_empresa": 2
    }
]
```

- **Campo `id_empresa`**: Este campo referencia la empresa a la que pertenece el personaje. Por ejemplo, `"id_empresa": 1` indica que el personaje "Shawn Froste" pertenece a la empresa con `id: 1`, que es "Level-5".

### ¿Cómo funcionan las referencias?
- **Unión de datos**: Las referencias permiten vincular información de diferentes entidades. Por ejemplo, al consultar un personaje, puedes usar el `id_empresa` para buscar información adicional sobre la empresa en `empresas.json`.
- **Integridad**: Las referencias ayudan a mantener la consistencia de los datos. Si un personaje está asociado con una empresa específica, el `id_empresa` asegura que siempre puedas rastrear a qué empresa pertenece ese personaje.

### Relación en MongoDB:
Cuando trabajas con una base de datos como MongoDB, puedes almacenar estos datos referenciales en diferentes colecciones (similares a tablas en una base de datos relacional):
- Una colección `empresas` donde cada documento representa una empresa.
- Una colección `personajes` donde cada documento representa un personaje y contiene una referencia (por ejemplo, `id_empresa`) a un documento en la colección `empresas`.

Estas referencias permiten realizar consultas cruzadas, por ejemplo, para encontrar todos los personajes que pertenecen a una empresa específica.

### Resumen:
- Los archivos JSON referenciales utilizan identificadores (`id`) para establecer relaciones entre diferentes entidades.
- En el contexto de MongoDB o cualquier otra base de datos, estas referencias se usan para mantener relaciones entre documentos en diferentes colecciones, permitiendo consultas más complejas y estructuradas.