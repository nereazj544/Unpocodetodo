-- Migrations will appear here as you chat with AI

CREATE TABLE libro (
  id bigint primary key generated always as identity,
  titulo text not null,
  autor text not null,
  fecha_publicacion date
);

CREATE TABLE personajes (
  id bigint primary key generated always as identity,
  nombre text not null,
  descripcion text,
  libro_id bigint references libro (id)
);

alter table personajes
rename column descripcion to novela;