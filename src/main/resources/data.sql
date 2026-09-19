INSERT INTO reino.vilas
(nome, regiao, populacao, status)
VALUES
    ('Eldoria', 'Floresta', 850, 'ATIVA'),
    ('Valenor', 'Montanha', 620, 'ATIVA'),
    ('Nivéria', 'Gelo', 430, 'ATIVA'),
    ('Aqualis', 'Água', 710, 'ATIVA'),
    ('Ignara', 'Fogo', 390, 'ATIVA'),
    ('Darkmoor', 'Fogo', 280, 'CORROMPIDA');


INSERT INTO reino.habitantes
(nome, idade, profissao, vila_id, status)
VALUES
    ('Arion', 25, 'Ferreiro', 1, 'ATIVO'),
    ('Lyria', 22, 'Curandeira', 1, 'ATIVO'),
    ('Thoren', 35, 'Guarda', 1, 'ATIVO'),
    ('Elandra', 28, 'Alquimista', 1, 'ATIVO'),

    ('Borin', 41, 'Minerador', 2, 'ATIVO'),
    ('Mira', 26, 'Arqueira', 2, 'ATIVO'),

    ('Kael', 30, 'Caçador', 3, 'ATIVO'),
    ('Nara', 24, 'Curandeira', 3, 'ATIVO'),

    ('Daren', 33, 'Pescador', 4, 'ATIVO'),
    ('Selene', 27, 'Comerciante', 4, 'ATIVO'),

    ('Ragnar', 45, 'Ferreiro', 5, 'ATIVO'),

    ('Lyra', 29, 'Sacerdotisa', 6, 'CORROMPIDO');


INSERT INTO reino.soldados
(nome, nivel, classe, vila_id, status)
VALUES
    ('Aldric', 15, 'Guerreiro', 1, 'ATIVO'),
    ('Cedric', 22, 'Paladino', 1, 'ATIVO'),
    ('Elric', 10, 'Arqueiro', 1, 'ATIVO'),

    ('Gareth', 28, 'Guerreiro', 2, 'ATIVO'),
    ('Theron', 19, 'Arqueiro', 2, 'ATIVO'),
    ('Baldor', 12, 'Guerreiro', 2, 'FERIDO'),

    ('Kaelen', 25, 'Paladino', 3, 'ATIVO'),
    ('Dorian', 17, 'Arqueiro', 3, 'ATIVO'),

    ('Lucan', 21, 'Guerreiro', 4, 'ATIVO'),
    ('Orin', 14, 'Mago', 4, 'ATIVO'),

    ('Draven', 32, 'Guerreiro', 5, 'ATIVO'),
    ('Varek', 26, 'Paladino', 5, 'ATIVO'),

    ('Mordak', 30, 'Guerreiro', 6, 'CORROMPIDO');


INSERT INTO reino.armas
(nome, tipo, poder, raridade, soldado_id)
VALUES
    ('Espada de Ferro', 'Espada', 40, 'COMUM', 1),
    ('Lâmina Solar', 'Espada', 75, 'RARA', 2),
    ('Arco Élfico', 'Arco', 55, 'RARA', 3),

    ('Martelo da Montanha', 'Martelo', 90, 'ÉPICA', 4),
    ('Arco de Gelo', 'Arco', 60, 'RARA', 5),
    ('Machado de Ferro', 'Machado', 45, 'COMUM', 6),

    ('Espada Congelada', 'Espada', 80, 'ÉPICA', 7),
    ('Arco Boreal', 'Arco', 50, 'RARA', 8),

    ('Lança Marinha', 'Lança', 65, 'RARA', 9),
    ('Cajado das Marés', 'Cajado', 70, 'RARA', 10),

    ('Espada Flamejante', 'Espada', 95, 'ÉPICA', 11),
    ('Martelo Vulcânico', 'Martelo', 85, 'ÉPICA', 12),

    ('Lâmina Sombria', 'Espada', 100, 'LENDÁRIA', 13);


INSERT INTO reino.recursos
(nome, tipo, quantidade, vila_id)
VALUES
    ('Madeira', 'Natural', 500, 1),
    ('Ervas Medicinais', 'Medicinal', 120, 1),

    ('Minério de Ferro', 'Mineral', 300, 2),
    ('Cristais de Mana', 'Mágico', 180, 2),

    ('Gelo Encantado', 'Mágico', 250, 3),

    ('Peixes', 'Alimento', 400, 4),
    ('Pérolas', 'Precioso', 90, 4),

    ('Carvão', 'Mineral', 350, 5),
    ('Cristais de Fogo', 'Mágico', 200, 5),

    ('Cinzas Negras', 'Corrompido', 500, 6);



INSERT INTO reino.entregas
(recurso_id, origem_vila_id, destino_vila_id,
 quantidade, data_entrega, status)
VALUES
    (1, 1, 2, 100, '2026-01-10', 'CONCLUIDA'),
    (2, 1, 3, 50, '2026-01-15', 'PENDENTE'),
    (3, 2, 1, 80, '2026-01-20', 'CONCLUIDA'),
    (5, 3, 4, 100, '2026-02-02', 'PENDENTE'),
    (6, 4, 1, 150, '2026-02-10', 'CONCLUIDA'),
    (8, 5, 4, 120, '2026-02-18', 'PENDENTE'),
    (9, 5, 6, 60, '2026-02-20', 'INTERROMPIDA');



INSERT INTO reino.criaturas(nome, tipo, nivel, regiao, status)
VALUES
    ('Lobo Sombrio', 'Lobo', 12, 'Floresta', 'ATIVO'),
    ('Ent Corrompido', 'Ent', 25, 'Floresta', 'CORROMPIDO'),
    ('Urso Negro', 'Urso', 18, 'Floresta', 'ATIVO'),

    ('Gigante de Pedra', 'Gigante', 30, 'Montanha', 'ATIVO'),
    ('Grifo', 'Grifo', 22, 'Montanha', 'ATIVO'),

    ('Lobo de Gelo', 'Lobo', 20, 'Gelo', 'ATIVO'),
    ('Dragão de Gelo', 'Dragão', 40, 'Gelo', 'ATIVO'),
    ('Golem de Gelo', 'Golem', 28, 'Gelo', 'ATIVO'),

    ('Serpente Marinha', 'Serpente', 26, 'Água', 'ATIVO'),
    ('Kraken', 'Kraken', 45, 'Água', 'ADORMECIDO'),

    ('Salamandra', 'Salamandra', 24, 'Fogo', 'ATIVO'),
    ('Golem de Lava', 'Golem', 35, 'Fogo', 'ATIVO'),
    ('Dragão de Fogo', 'Dragão', 50, 'Fogo', 'ATIVO'),
    ('Demônio Flamejante', 'Demônio', 42, 'Fogo', 'ATIVO'),
    ('Serpente de Magma', 'Serpente', 29, 'Fogo', 'ATIVO');



INSERT INTO reino.mensagens(remetente, destinatario, assunto, conteudo, data_envio, prioridade)
VALUES
    (
        'Mestre Query',
        'Guardião',
        'O chamado',
        'Os registros do reino estão sendo corrompidos. Precisamos agir.',
        '2026-01-01 08:00:00',
        'ALTA'
    ),
    (
        'Rei Aldren',
        'Mestre Query',
        'Relatório do reino',
        'As primeiras regiões começaram a apresentar sinais de corrupção.',
        '2026-01-03 10:30:00',
        'ALTA'
    ),
    (
        'Mestre Query',
        'Guardião',
        'Primeira missão',
        'Comece recuperando os registros dos habitantes.',
        '2026-01-05 09:15:00',
        'NORMAL'
    ),
    (
        'Capitão Gareth',
        'Rei Aldren',
        'Defesas',
        'Nossos soldados estão preparados para defender as vilas.',
        '2026-01-10 14:00:00',
        'NORMAL'
    ),
    (
        'Mestre Query',
        'Guardião',
        'A corrupção avança',
        'Precisamos descobrir onde a corrupção está mais concentrada.',
        '2026-02-01 11:00:00',
        'ALTA'
    ),
    (
        'Rei Aldren',
        'Guardião',
        'Darkmoor',
        'A vila de Darkmoor perdeu contato com o restante do reino.',
        '2026-02-10 16:45:00',
        'CRÍTICA'
    );


INSERT INTO reino.registros_corrompidos(tipo_registro, registro_id, regiao, nivel_corrupcao, data_corrupcao, status)
VALUES

-- FLORESTA: 4
('HABITANTE', 3, 'Floresta', 35, '2026-01-08', 'CORROMPIDO'),
('SOLDADO', 2, 'Floresta', 40, '2026-01-10', 'CORROMPIDO'),
('RECURSO', 1, 'Floresta', 25, '2026-01-12', 'CORROMPIDO'),
('CRIATURA', 2, 'Floresta', 60, '2026-01-15', 'CORROMPIDO'),

-- MONTANHA: 3
('HABITANTE', 5, 'Montanha', 30, '2026-01-11', 'CORROMPIDO'),
('SOLDADO', 4, 'Montanha', 50, '2026-01-14', 'CORROMPIDO'),
('RECURSO', 3, 'Montanha', 45, '2026-01-18', 'CORROMPIDO'),

-- GELO: 5
('HABITANTE', 7, 'Gelo', 40, '2026-01-16', 'CORROMPIDO'),
('HABITANTE', 8, 'Gelo', 55, '2026-01-17', 'CORROMPIDO'),
('SOLDADO', 7, 'Gelo', 50, '2026-01-19', 'CORROMPIDO'),
('CRIATURA', 7, 'Gelo', 65, '2026-01-21', 'CORROMPIDO'),
('RECURSO', 5, 'Gelo', 35, '2026-01-22', 'CORROMPIDO'),

-- ÁGUA: 4
('HABITANTE', 9, 'Água', 30, '2026-01-20', 'CORROMPIDO'),
('SOLDADO', 9, 'Água', 45, '2026-01-23', 'CORROMPIDO'),
('CRIATURA', 9, 'Água', 50, '2026-01-25', 'CORROMPIDO'),
('RECURSO', 6, 'Água', 40, '2026-01-26', 'CORROMPIDO'),

-- FOGO: 13
('HABITANTE', 11, 'Fogo', 70, '2026-01-22', 'CORROMPIDO'),
('SOLDADO', 11, 'Fogo', 80, '2026-01-23', 'CORROMPIDO'),
('SOLDADO', 12, 'Fogo', 75, '2026-01-24', 'CORROMPIDO'),
('CRIATURA', 11, 'Fogo', 65, '2026-01-25', 'CORROMPIDO'),
('CRIATURA', 12, 'Fogo', 80, '2026-01-26', 'CORROMPIDO'),
('CRIATURA', 13, 'Fogo', 90, '2026-01-27', 'CORROMPIDO'),
('CRIATURA', 14, 'Fogo', 85, '2026-01-28', 'CORROMPIDO'),
('CRIATURA', 15, 'Fogo', 75, '2026-01-29', 'CORROMPIDO'),
('RECURSO', 8, 'Fogo', 70, '2026-01-30', 'CORROMPIDO'),
('RECURSO', 9, 'Fogo', 85, '2026-01-31', 'CORROMPIDO'),
('VILA', 5, 'Fogo', 65, '2026-02-01', 'CORROMPIDO'),
('ENTREGA', 7, 'Fogo', 90, '2026-02-02', 'CORROMPIDO'),
('MENSAGEM', 6, 'Fogo', 95, '2026-02-03', 'CORROMPIDO');


INSERT INTO jogo.capitulos(numero, nome, descricao, conceito_principal, recompensa)
VALUES
    (
        1,
        'A Floresta dos Registros',
        'Os primeiros registros do Grande Registro foram corrompidos. Recupere as informações perdidas.',
        'SELECT / FROM',
        'Espada do Conhecimento'
    ),
    (
        2,
        'A Caverna dos Filtros',
        'Informações importantes estão escondidas entre milhares de registros. Encontre exatamente o que precisamos.',
        'WHERE',
        'Escudo da Precisão'
    ),
    (
        3,
        'As Montanhas do Tempo',
        'As mensagens e registros estão fora de ordem. Organize as informações para descobrir o que aconteceu.',
        'ORDER BY',
        'Botas da Velocidade'
    ),
    (
        4,
        'A Floresta Sombria',
        'A corrupção se espalhou pelo reino. Analise os registros e descubra onde ela está mais concentrada.',
        'GROUP BY / COUNT / SUM / AVG',
        'Armadura dos Dados'
    ),
    (
        5,
        'O Reino Submerso',
        'Os registros foram separados em diferentes tabelas. Reconecte as informações perdidas.',
        'JOIN',
        'Amuleto das Conexões'
    ),
    (
        6,
        'A Fortaleza Perdida',
        'O esconderijo do Corruptor está protegido por informações ocultas dentro de outras consultas.',
        'Subconsultas',
        'Elmo do Guardião'
    );


INSERT INTO jogo.itens(nome, descricao, tipo, capitulo_desbloqueio)
VALUES
    (
        'Espada do Conhecimento',
        'Uma espada forjada com o conhecimento dos antigos registros.',
        'ARMA',
        1
    ),
    (
        'Escudo da Precisão',
        'Um escudo que representa a capacidade de encontrar exatamente o registro necessário.',
        'ESCUDO',
        2
    ),
    (
        'Botas da Velocidade',
        'Botas que simbolizam a rapidez na organização dos dados.',
        'ARMADURA',
        3
    ),
    (
        'Armadura dos Dados',
        'Uma armadura criada a partir dos registros recuperados do reino.',
        'ARMADURA',
        4
    ),
    (
        'Amuleto das Conexões',
        'Um amuleto capaz de reconectar informações separadas.',
        'ACESSORIO',
        5
    ),
    (
        'Elmo do Guardião',
        'O símbolo máximo do Guardião dos Dados.',
        'ELMO',
        6
    );


-- _______________________
-- CAPÍTULO 1 DESAFIOS
-- _______________________

INSERT INTO jogo.desafios(capitulo_id, ordem, titulo, descricao, objetivo, dificuldade, conceito_sql, xp, ouro, consulta_gabarito)
VALUES
    (1, 1,
     'O Grande Registro',
     'Os registros dos habitantes de Aethel foram espalhados pelo Grande Registro. Recupere todos os habitantes para descobrir quem ainda está no reino.',
     'Mostrar todos os habitantes do reino.',
     1,
     'SELECT / FROM',
     100,
     20,
     'SELECT * FROM reino.habitantes;');


INSERT INTO jogo.desafios(capitulo_id, ordem, titulo, descricao, objetivo, dificuldade, conceito_sql, xp, ouro, consulta_gabarito)
VALUES
    (1, 2,
     'Os Nomes Perdidos',
     'O Corruptor apagou os nomes da lista de habitantes. Recupere somente os nomes registrados.',
     'Mostrar apenas o nome dos habitantes.',
     1,
     'SELECT',
     100,
     20,
     'SELECT nome FROM reino.habitantes;');


INSERT INTO jogo.desafios(capitulo_id, ordem, titulo, descricao, objetivo, dificuldade, conceito_sql, xp, ouro, consulta_gabarito)
VALUES
    (1, 3,
     'Os Ofícios de Eldoria',
     'Mestre Query precisa descobrir quais profissões estão registradas entre os habitantes.',
     'Mostrar as profissões dos habitantes.',
     1,
     'SELECT',
     120,
     25,
     'SELECT profissao FROM reino.habitantes;');


INSERT INTO jogo.desafios(capitulo_id, ordem, titulo, descricao, objetivo, dificuldade, conceito_sql, xp, ouro, consulta_gabarito)
VALUES
    (1, 4,
     'O Registro Completo',
     'O Grande Registro está incompleto. Recupere as principais informações de cada habitante.',
     'Mostrar id, nome, idade e profissão dos habitantes.',
     2,
     'SELECT',
     150,
     30,
     'SELECT id, nome, idade, profissao FROM reino.habitantes;');


-- _______________________
-- CAPÍTULO 2 DESAFIOS
-- _______________________

INSERT INTO jogo.desafios(capitulo_id, ordem, titulo, descricao, objetivo, dificuldade, conceito_sql, xp, ouro, consulta_gabarito)
VALUES
    (2, 1,
     'Os Soldados Ativos',
     'Aethel precisa saber quais soldados ainda estão em condições de lutar contra a corrupção.',
     'Mostrar apenas os soldados com status ATIVO.',
     2,
     'WHERE',
     180,
     35,
     'SELECT * FROM reino.soldados WHERE status = ''ATIVO'';');


INSERT INTO jogo.desafios(capitulo_id, ordem, titulo, descricao, objetivo, dificuldade, conceito_sql, xp, ouro, consulta_gabarito)
VALUES
    (2, 2,
     'A Vila Perdida',
     'Um registro importante foi encontrado em Eldoria. Descubra quais habitantes pertencem à vila de código 1.',
     'Mostrar os habitantes da vila 1.',
     2,
     'WHERE',
     180,
     35,
     'SELECT * FROM reino.habitantes WHERE vila_id = 1;');


INSERT INTO jogo.desafios(capitulo_id, ordem, titulo, descricao, objetivo, dificuldade, conceito_sql, xp, ouro, consulta_gabarito)
VALUES
    (2, 3,
     'Recursos Mágicos',
     'Alguns recursos podem ser usados para combater a corrupção. Encontre os recursos classificados como mágicos.',
     'Mostrar os recursos do tipo Mágico.',
     2,
     'WHERE',
     200,
     40,
     'SELECT * FROM reino.recursos WHERE tipo = ''Mágico'';');


INSERT INTO jogo.desafios(capitulo_id, ordem, titulo, descricao, objetivo, dificuldade, conceito_sql, xp, ouro, consulta_gabarito)
VALUES
    (2, 4,
     'Entregas Pendentes',
     'Várias entregas importantes ainda não chegaram aos seus destinos. Encontre todas as entregas pendentes.',
     'Mostrar as entregas com status PENDENTE.',
     2,
     'WHERE',
     220,
     45,
     'SELECT * FROM reino.entregas WHERE status = ''PENDENTE'';');


-- _______________________
-- CAPÍTULO 3 DESAFIOS
-- _______________________

INSERT INTO jogo.desafios(capitulo_id, ordem, titulo, descricao, objetivo, dificuldade, conceito_sql, xp, ouro, consulta_gabarito)
VALUES
    (3, 1,
     'A Mensagem Mais Recente',
     'Mestre Query recebeu várias mensagens. Organize-as para descobrir primeiro as mais recentes.',
     'Ordenar as mensagens da mais recente para a mais antiga.',
     2,
     'ORDER BY',
     250,
     50,
     'SELECT * FROM reino.mensagens ORDER BY data_envio DESC;');


INSERT INTO jogo.desafios(capitulo_id, ordem, titulo, descricao, objetivo, dificuldade, conceito_sql, xp, ouro, consulta_gabarito)
VALUES
    (3, 2,
     'Os Guerreiros Mais Fortes',
     'Os soldados de Aethel possuem diferentes níveis de poder. Organize-os começando pelo soldado de maior nível.',
     'Ordenar os soldados pelo nível decrescente.',
     2,
     'ORDER BY',
     250,
     50,
     'SELECT * FROM reino.soldados ORDER BY nivel DESC;');


INSERT INTO jogo.desafios(capitulo_id, ordem, titulo, descricao, objetivo, dificuldade, conceito_sql, xp, ouro, consulta_gabarito)
VALUES
    (3, 3,
     'As Criaturas Mais Perigosas',
     'As criaturas corrompidas estão se aproximando. Organize os registros para descobrir primeiro as criaturas de maior nível.',
     'Ordenar as criaturas pelo nível decrescente.',
     2,
     'ORDER BY',
     280,
     55,
     'SELECT * FROM reino.criaturas ORDER BY nivel DESC;');


INSERT INTO jogo.desafios(capitulo_id, ordem, titulo, descricao, objetivo, dificuldade, conceito_sql, xp, ouro, consulta_gabarito)
VALUES
    (3, 4,
     'Os Soldados Ativos Mais Fortes',
     'Mestre Query precisa dos soldados ativos mais poderosos para a próxima missão.',
     'Filtrar os soldados ativos e ordená-los pelo nível.',
     3,
     'WHERE / ORDER BY',
     300,
     60,
     'SELECT * FROM reino.soldados WHERE status = ''ATIVO'' ORDER BY nivel DESC;');


-- _______________________
-- CAPÍTULO 4 DESAFIOS
-- _______________________

INSERT INTO jogo.desafios(capitulo_id, ordem, titulo, descricao, objetivo, dificuldade, conceito_sql, xp, ouro, consulta_gabarito)
VALUES
    (4, 1,
     'Quantos Soldados Restam?',
     'O Corruptor atacou as forças de Aethel. Descubra quantos soldados estão registrados atualmente.',
     'Contar todos os soldados.',
     3,
     'COUNT',
     350,
     70,
     'SELECT COUNT(*) FROM reino.soldados;');


INSERT INTO jogo.desafios(capitulo_id, ordem, titulo, descricao, objetivo, dificuldade, conceito_sql, xp, ouro, consulta_gabarito)
VALUES
    (4, 2,
     'Soldados por Vila',
     'O exército está espalhado pelo reino. Descubra quantos soldados existem em cada vila.',
     'Contar os soldados agrupando-os por vila.',
     3,
     'GROUP BY / COUNT',
     400,
     80,
     'SELECT vila_id, COUNT(*) FROM reino.soldados GROUP BY vila_id;');


INSERT INTO jogo.desafios(capitulo_id, ordem, titulo, descricao, objetivo, dificuldade, conceito_sql, xp, ouro, consulta_gabarito)
VALUES
    (4, 3,
     'Recursos do Reino',
     'Mestre Query precisa saber quantos recursos estão armazenados em cada vila.',
     'Somar os recursos agrupando-os por vila.',
     3,
     'GROUP BY / SUM',
     400,
     80,
     'SELECT vila_id, SUM(quantidade) FROM reino.recursos GROUP BY vila_id;');


INSERT INTO jogo.desafios(capitulo_id, ordem, titulo, descricao, objetivo, dificuldade, conceito_sql, xp, ouro, consulta_gabarito)
VALUES
    (4, 4,
     'O Nível Médio',
     'Descubra qual é o nível médio dos soldados de Aethel.',
     'Calcular a média dos níveis dos soldados.',
     3,
     'AVG',
     400,
     80,
     'SELECT AVG(nivel) FROM reino.soldados;');


INSERT INTO jogo.desafios(capitulo_id, ordem, titulo, descricao, objetivo, dificuldade, conceito_sql, xp, ouro, consulta_gabarito)
VALUES
    (4, 5,
     'Onde a Corrupção Está Maior?',
     'Os registros corrompidos estão espalhados pelas regiões. Descubra como a corrupção está distribuída.',
     'Contar os registros corrompidos por região e ordenar do maior para o menor.',
     4,
     'GROUP BY / COUNT / ORDER BY',
     500,
     100,
     'SELECT regiao, COUNT(*) AS total FROM reino.registros_corrompidos GROUP BY regiao ORDER BY total DESC;');


-- _______________________
-- CAPÍTULO 5 DESAFIOS
-- _______________________

INSERT INTO jogo.desafios(capitulo_id, ordem, titulo, descricao, objetivo, dificuldade, conceito_sql, xp, ouro, consulta_gabarito)
VALUES
    (5, 1,
     'Onde Estão os Soldados?',
     'Os registros dos soldados não informam diretamente o nome das vilas. Reconecte as duas tabelas para descobrir onde cada soldado está.',
     'Mostrar o nome do soldado e o nome de sua vila.',
     4,
     'JOIN',
     550,
     110,
     'SELECT soldados.nome, vilas.nome FROM reino.soldados JOIN reino.vilas ON soldados.vila_id = vilas.id;');


INSERT INTO jogo.desafios(capitulo_id, ordem, titulo, descricao, objetivo, dificuldade, conceito_sql, xp, ouro, consulta_gabarito)
VALUES
    (5, 2,
     'Guerreiros da Floresta',
     'Mestre Query descobriu que soldados da região da Floresta podem ajudar na próxima missão. Encontre-os.',
     'Mostrar soldados pertencentes a vilas da região Floresta.',
     4,
     'JOIN / WHERE',
     600,
     120,
     'SELECT soldados.nome, vilas.nome FROM reino.soldados JOIN reino.vilas ON soldados.vila_id = vilas.id WHERE vilas.regiao = ''Floresta'';');


INSERT INTO jogo.desafios(capitulo_id, ordem, titulo, descricao, objetivo, dificuldade, conceito_sql, xp, ouro, consulta_gabarito)
VALUES
    (5, 3,
     'Recursos das Vilas',
     'Os recursos estão registrados separadamente das vilas. Reconecte os registros para descobrir quais recursos pertencem a cada vila.',
     'Mostrar nome da vila, nome do recurso e quantidade.',
     4,
     'JOIN',
     600,
     120,
     'SELECT vilas.nome, recursos.nome, recursos.quantidade FROM reino.recursos JOIN reino.vilas ON recursos.vila_id = vilas.id;');


INSERT INTO jogo.desafios(capitulo_id, ordem, titulo, descricao, objetivo, dificuldade, conceito_sql, xp, ouro, consulta_gabarito)
VALUES
    (5, 4,
     'As Armas dos Guerreiros',
     'As armas dos soldados estão armazenadas em outro registro. Reconecte os dados para descobrir quais armas pertencem a cada soldado.',
     'Mostrar soldado, arma e poder da arma.',
     4,
     'JOIN',
     650,
     130,
     'SELECT soldados.nome, armas.nome, armas.poder FROM reino.soldados JOIN reino.armas ON armas.soldado_id = soldados.id;');


INSERT INTO jogo.desafios(capitulo_id, ordem, titulo, descricao, objetivo, dificuldade, conceito_sql, xp, ouro, consulta_gabarito)
VALUES
    (5, 5,
     'A Conexão Perdida',
     'O Corruptor separou soldados, vilas e armas em registros diferentes. Reconecte todas as informações.',
     'Mostrar soldado, vila e arma em uma única consulta.',
     5,
     'JOIN',
     700,
     150,
     'SELECT soldados.nome AS soldado, vilas.nome AS vila, armas.nome AS arma FROM reino.soldados JOIN reino.vilas ON soldados.vila_id = vilas.id JOIN reino.armas ON armas.soldado_id = soldados.id;');


-- _______________________
-- CAPÍTULO 6 DESAFIOS
-- _______________________

INSERT INTO jogo.desafios(capitulo_id, ordem, titulo, descricao, objetivo, dificuldade, conceito_sql, xp, ouro, consulta_gabarito)
VALUES
    (6, 1,
     'Soldados da Linha de Frente',
     'Mestre Query precisa organizar os soldados ativos para enfrentar o Corruptor. Mostre-os do mais forte para o mais fraco.',
     'Mostrar soldados ativos, suas vilas e níveis, ordenados pelo nível.',
     5,
     'JOIN / WHERE / ORDER BY',
     750,
     160,
     'SELECT soldados.nome, vilas.nome AS vila, soldados.nivel FROM reino.soldados JOIN reino.vilas ON soldados.vila_id = vilas.id WHERE soldados.status = ''ATIVO'' ORDER BY soldados.nivel DESC;');


INSERT INTO jogo.desafios(capitulo_id, ordem, titulo, descricao, objetivo, dificuldade, conceito_sql, xp, ouro, consulta_gabarito)
VALUES
    (6, 2,
     'A Força das Vilas',
     'Descubra a quantidade total de recursos armazenada em cada vila e organize as vilas pela quantidade de recursos.',
     'Somar os recursos por vila e ordenar pelo total.',
     5,
     'JOIN / GROUP BY / SUM / ORDER BY',
     800,
     170,
     'SELECT vilas.nome, SUM(recursos.quantidade) AS total_recursos FROM reino.vilas JOIN reino.recursos ON recursos.vila_id = vilas.id GROUP BY vilas.nome ORDER BY total_recursos DESC;');


INSERT INTO jogo.desafios(capitulo_id, ordem, titulo, descricao, objetivo, dificuldade, conceito_sql, xp, ouro, consulta_gabarito)
VALUES
    (6, 3,
     'A Região Dominada',
     'A corrupção se espalhou pelo reino. Descubra primeiro qual região possui mais registros corrompidos e depois recupere todos os registros daquela região.',
     'Encontrar os registros pertencentes à região com maior quantidade de corrupção.',
     5,
     'SUBQUERY',
     1000,
     200,
     'SELECT * FROM reino.registros_corrompidos WHERE regiao = (SELECT regiao FROM reino.registros_corrompidos GROUP BY regiao ORDER BY COUNT(*) DESC LIMIT 1);');


-- _______________________
-- DESAFIO 1 DICAS
-- _______________________

INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (1, 1, 'Você precisa consultar a tabela que guarda os habitantes.', 10);


INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (1, 2, 'Use SELECT para escolher os dados e FROM para indicar a tabela.', 25);


INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (1, 3, 'Tente SELECT * FROM reino.habitantes.', 50);


-- _______________________
-- DESAFIO 2 DICAS
-- _______________________
INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (2, 1, 'Você precisa escolher apenas uma coluna da tabela.', 10);


INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (2, 2, 'A coluna que você procura se chama nome.', 25);


INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (2, 3, 'Use SELECT nome FROM reino.habitantes.', 50);


-- _______________________
-- DESAFIO 3 DICAS
-- _______________________
INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (3, 1, 'Procure na tabela de habitantes.', 10);

INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (3, 2, 'A informação procurada está na coluna profissao.', 25);

INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (3, 3, 'Use SELECT profissao FROM reino.habitantes.', 50);


-- _______________________
-- DESAFIO 4 DICAS
-- _______________________
INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (4, 1, 'Você precisa selecionar algumas colunas específicas.', 10);

INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (4, 2, 'As colunas são id, nome, idade e profissao.', 25);

INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (4, 3, 'Use SELECT id, nome, idade, profissao FROM reino.habitantes.', 50);


-- _______________________
-- DESAFIO 5 DICAS
-- _______________________
INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (5, 1, 'Você precisa filtrar os soldados.', 10);

INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (5, 2, 'A filtragem será feita usando a coluna status.', 25);

INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (5, 3, 'Use WHERE status = ''ATIVO''.', 50);


-- _______________________
-- DESAFIO 6 DICAS
-- _______________________
INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (6, 1, 'Você precisa encontrar os habitantes de uma determinada vila.', 10);

INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (6, 2, 'A vila é identificada pela coluna vila_id.', 25);

INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (6, 3, 'Use WHERE vila_id = 1.', 50);


-- _______________________
-- DESAFIO 7 DICAS
-- _______________________

INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (7, 1, 'Você precisa filtrar os recursos pelo tipo.', 10);

INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (7, 2, 'A coluna que identifica o tipo do recurso se chama tipo.', 25);

INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (7, 3, 'Use WHERE tipo = ''Mágico''.', 50);


-- _______________________
-- DESAFIO 8 DICAS
-- _______________________
INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (8, 1, 'Procure na tabela de entregas.', 10);

INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (8, 2, 'Use a coluna status para encontrar somente as pendentes.', 25);

INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (8, 3, 'Use WHERE status = ''PENDENTE''.', 50);


-- _______________________
-- DESAFIO 9 DICAS
-- _______________________
INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (9, 1, 'Você precisa organizar as mensagens pela data.', 10);

INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (9, 2, 'Use ORDER BY com a coluna data_envio.', 25);

INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (9, 3, 'Use ORDER BY data_envio DESC.', 50);


-- _______________________
-- DESAFIO 10 DICAS
-- _______________________
INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (10, 1, 'Você precisa ordenar os soldados pelo nível.', 10);

INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (10, 2, 'A coluna que representa o nível se chama nivel.', 25);

INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (10, 3, 'Use ORDER BY nivel DESC.', 50);


-- _______________________
-- DESAFIO 11 DICAS
-- _______________________
INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (11, 1, 'Procure na tabela de criaturas.', 10);

INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (11, 2, 'As criaturas devem ser organizadas pela coluna nivel.', 25);

INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (11, 3, 'Use ORDER BY nivel DESC.', 50);


-- _______________________
-- DESAFIO 12 DICAS
-- _______________________
INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (12, 1, 'Esse desafio precisa de duas operações: filtrar e ordenar.', 10);

INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (12, 2, 'Use WHERE para encontrar os ativos e ORDER BY para ordenar pelo nível.', 25);

INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (12, 3, 'Use WHERE status = ''ATIVO'' ORDER BY nivel DESC.', 50);


-- _______________________
-- DESAFIO 13 DICAS
-- _______________________
INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (13, 1, 'Você precisa contar quantos registros existem.', 10);

INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (13, 2, 'A função COUNT pode contar os registros.', 25);

INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (13, 3, 'Use SELECT COUNT(*) FROM reino.soldados.', 50);


-- _______________________
-- DESAFIO 14 DICAS
-- _______________________
INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (14, 1, 'Você precisa separar os soldados de acordo com a vila.', 10);

INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (14, 2, 'Use GROUP BY junto com COUNT.', 25);

INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (14, 3, 'Use GROUP BY vila_id e COUNT(*).', 50);


-- _______________________
-- DESAFIO 15 DICAS
-- _______________________
INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (15, 1, 'Você precisa descobrir a quantidade total por vila.', 10);

INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (15, 2, 'A função SUM pode somar a quantidade dos recursos.', 25);

INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (15, 3, 'Use SUM(quantidade) e GROUP BY vila_id.', 50);


-- _______________________
-- DESAFIO 16 DICAS
-- _______________________
INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (16, 1, 'Você precisa calcular um valor médio.', 10);

INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (16, 2, 'Existe uma função SQL chamada AVG para calcular médias.', 25);

INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (16, 3, 'Use SELECT AVG(nivel) FROM reino.soldados.', 50);


-- _______________________
-- DESAFIO 17 DICAS
-- _______________________
INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (17, 1, 'Compare a quantidade de corrupção em cada região.', 10);

INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (17, 2, 'Agrupe por regiao e conte os registros.', 25);

INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (17, 3, 'Use GROUP BY regiao, COUNT(*) e ORDER BY total DESC.', 50);


-- _______________________
-- DESAFIO 18 DICAS
-- _______________________
INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (18, 1, 'Os dados estão em duas tabelas relacionadas.', 10);

INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (18, 2, 'A ligação entre soldados e vilas usa vila_id e id.', 25);

INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (18, 3, 'Use JOIN reino.vilas ON soldados.vila_id = vilas.id.', 50);


-- _______________________
-- DESAFIO 19 DICAS
-- _______________________
INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (19, 1, 'Primeiro conecte soldados e vilas.', 10);

INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (19, 2, 'Depois filtre a região da vila.', 25);

INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (19, 3, 'Use WHERE vilas.regiao = ''Floresta''.', 50);


-- _______________________
-- DESAFIO 20 DICAS
-- _______________________
INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (20, 1, 'Os recursos e as vilas estão em tabelas diferentes.', 10);

INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (20, 2, 'A relação é feita através de recursos.vila_id e vilas.id.', 25);

INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (20, 3, 'Use JOIN reino.vilas ON recursos.vila_id = vilas.id.', 50);


-- _______________________
-- DESAFIO 21 DICAS
-- _______________________
INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (21, 1, 'Você precisa conectar soldados e armas.', 10);

INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (21, 2, 'A coluna soldado_id da tabela armas aponta para o soldado.', 25);

INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (21, 3, 'Use JOIN reino.armas ON armas.soldado_id = soldados.id.', 50);


-- _______________________
-- DESAFIO 22 DICAS
-- _______________________
INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (22, 1, 'Agora você precisa conectar três tabelas.', 10);

INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (22, 2, 'Conecte soldados com vilas e depois soldados com armas.', 25);

INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (22, 3, 'Use dois JOINs: um com vilas e outro com armas.', 50);


-- _______________________
-- DESAFIO 23 DICAS
-- _______________________
INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (23, 1, 'Você precisa juntar informações de soldados e vilas.', 10);

INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (23, 2, 'Depois filtre apenas os soldados ATIVOS e organize pelo nível.', 25);

INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (23, 3, 'Use JOIN, WHERE status = ''ATIVO'' e ORDER BY nivel DESC.', 50);


-- _______________________
-- DESAFIO 24 DICAS
-- _______________________
INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (24, 1, 'Você precisa relacionar vilas e recursos.', 10);

INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (24, 2, 'Depois agrupe por vila e some a quantidade de recursos.', 25);

INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (24, 3, 'Use SUM(quantidade), GROUP BY vilas.nome e ORDER BY total_recursos DESC.', 50);


-- _______________________
-- DESAFIO 25 DICAS
-- _______________________
INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (25, 1, 'Primeiro descubra qual região possui mais registros.', 10);

INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (25, 2, 'Uma consulta pode ser colocada dentro de outra consulta.', 25);

INSERT INTO jogo.dicas (desafio_id, nivel, texto, custo_ouro)
VALUES (25, 3, 'Use uma subconsulta com GROUP BY, COUNT, ORDER BY DESC e LIMIT 1.', 50);

