# Conectando JAVA a _data base_

## Tabla de contenido
1. [Introducion](#introducion)

2. [Tipos de Conexiones](#tipos-de-conexiones)
    - [Conexion a MySql](#conexion-a-mysql)
    - [Conexion a SQLite](#conexion-a-sqlite)

<br><br>

# INTRODUCION
Acceso a los datos almanecandos en distas bases de datos relacionales utilizando <span style="color: #ED8B00">**Java**. </span> <br>
En este reprosotorio se encontrar programas para acceder a las distintas bases de datos, usando distintas coneciones para acceder a las distantas <span style="color: #005fed">**_bases de datos_.**</span>
<br>

# Tipos de conexiones:

<span style="color:#005fed"> 

## Conexion a MySql 

</span>
MySQL es una de las bases de datos relacionales más populares, utilizada por aplicaciones web y de servidor debido a su rendimiento y fiabilidad.

Requisitos Previos:
- Driver JDBC para MySQL: mysql-connector-java
- Programa: MySql Workbench 

En el **proyecto java** que hemos creado debe de ser maven, (o en su defecto su es normal deberias de añadir una carpeta llamada "_lib_")

**Para proyectos Maven:**
 > Sino tambien se va a  https://mvnrepository.com/ y se busca el conector 

 > Codigo para _pom.xml_:
```
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>8.4.0</version>
 </dependency>
 ```

**Para el programa Java:**

```
Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/[ESQUEMA]?useSSL=true&serverTimezone=UTC", "[USUARIO]", "[CONTRASEÑA]");
```
Hay que sustitr lo que se encontra dentro de los "[]" (y estos tambien, _obviamente_) por lo que nos pide.

<span style="color:#005fed"> 

## Conexion a SQLite

</span>

SQLite es una base de datos ligera, embebida, y altamente portátil, utilizada a menudo en aplicaciones de escritorio y móviles.

Requisitos Previos:
- Driver JDBC para SQLite: sqlite-jdbc
- Archivo de base de datos SQLite

En el **proyecto java** que hemos creado debe de ser maven, (o en su defecto su es normal deberias de añadir una carpeta llamada "_lib_").



**Para proyectos Maven:**
 > Sino tambien se va a  https://mvnrepository.com/ y se busca el conector 

 > Codigo para _pom.xml_:
```
 <dependency>
   <groupId>org.xerial</groupId>
   <artifactId>sqlite-jdbc</artifactId>
   <version>3.42.0.0</version>
</dependency>
 ```

**Para el programa Java:**

```
Connection conexion = DriverManager.getConnection("jdbc:sqlite:[RUTA AL ARCHIVO '.db']");
```
Hay que sustitr lo que se encontra dentro de los "[]" (y estos tambien, _obviamente_) por lo que nos pide.

---