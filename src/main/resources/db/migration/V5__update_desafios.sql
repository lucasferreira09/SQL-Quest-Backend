UPDATE desafios
SET ordem_importa = true
WHERE id IN (9, 10, 11, 12, 16, 21, 22);

INSERT INTO jogo.blocos_desafio (desafio_id, ordem, texto)
VALUES
(9, 12, 'DESC'),
(10, 14, 'DESC'),
(11, 14, 'DESC'),
(12, 18, 'DESC'),
(16, 21, 'DESC');


