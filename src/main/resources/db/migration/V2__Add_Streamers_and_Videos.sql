insert into streamer (pseudonym, firstname, lastname, description, picture_name) values
       ('VjLink', 'Кирилл', 'Зырянов', 'Ему зубы выбил его кореш.', 'maxresdefault.jpg'),
       ('Симонов', 'Сергей', 'Симонов', 'Симонов сдал в аренду свой канал мошенникам.', 'artworks.jpg');

insert into streamer_other_pseudonyms (streamer_id, other_pseudonym) values
       (1, 'Top gamer in the World!'),
       (1, 'Ludojop');

insert into video (youtube_id, name, description) values
       ('6F6JrYs3lxM', 'СЕРГЕЙ СИМОНОВ — ВЖЛИНК НАШЕЛ НОВОГО КОРОЛЯ ЕБАТОРИИ', 'Симонов и линк'),
       ('gwuHEC1UUI8', 'VJLink Не сдержался.ДРАКА Солевая Ксюша', 'солевая и линк');

insert into streamer_video (streamer_id, video_id) values
(1, 1),
(1, 2),
(2, 1);



