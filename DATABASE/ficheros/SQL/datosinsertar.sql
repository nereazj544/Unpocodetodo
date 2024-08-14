insert INTO empresa (nombre) values ('Hoyoverse'), ('Kuro Game'), ('Level-5');


insert INTO personajes (nombre, juego, empresa_id) values
('Bennett', 'Genshin Impact', 1),
('Kazuha', 'Genshin Impact', 1),
('Arlecchino', 'Genshin Impact', 1),
('Xiao', 'Genshin Impact', 1),
('Jing Yan', 'Honkai Star Rail', 1),
('Kafka', 'Honkai Star Rail', 1),
('Gepard', 'Honkai Star Rail', 1),
('Topaz y Conti', 'Honkai Star Rail', 1),
('Jiyan', 'Wuthering Waves', 2),
('Calcharo', 'Wuthering Waves', 2),
('Lingyang', 'Wuthering Waves', 2),
('Encore', 'Wuthering Waves', 2),
('Arion', 'Inazuma Eleven', 3),
('Mark', 'Inazuma Eleven', 3),
('Umei', 'Inazuma Eleven', 3),
('Sonny', 'Inazuma Eleven', 3);

insert INTO libros (titulo, autor, es_saga) values
('Saga Mancuso', 'Neo', true),
('Saga Magia Antigua', 'Neo', true),
('Rojo y Azul', 'Neo', false),
('Mi niñera un zombie', 'Neo', false);

insert INTO personajeslibros (pnombre, novela, es_protagonista, libros_id) values
('Leo Mancuso', 'Saga Mancuso', true, 1),
('Kilari Miracle', 'Magia Antigua', true, 2),
('Killian De Metz', 'Rojo y Azul', true, 3),
('Kaori Cadaval', 'My babysitter is a zombie', true, 3);
