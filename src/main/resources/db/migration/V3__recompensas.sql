
-- =====================================================
-- ATUALIZAÇÃO DAS IMAGENS DOS 6 ITENS EXISTENTES
-- =====================================================

UPDATE jogo.itens
SET image_url = 'assets/recompensas/itens/espada-conhecimento.png'
WHERE id = 1;

UPDATE jogo.itens
SET image_url = 'assets/recompensas/itens/escudo-precisao.png'
WHERE id = 2;

UPDATE jogo.itens
SET image_url = 'assets/recompensas/itens/botas-velocidade.png'
WHERE id = 3;

UPDATE jogo.itens
SET image_url = 'assets/recompensas/itens/armadura-dados.png'
WHERE id = 4;

UPDATE jogo.itens
SET image_url = 'assets/recompensas/itens/amuleto-conexoes.png'
WHERE id = 5;

UPDATE jogo.itens
SET image_url = 'assets/recompensas/itens/elmo-guardiao.png'
WHERE id = 6;


-- =========================================
-- NOVOS ITENS DO SQL QUEST
-- =========================================

INSERT INTO jogo.itens
(nome, descricao, tipo, capitulo_desbloqueio, image_url)
VALUES
    ('Lupa da Investigação',
     'Uma lupa encantada que revela os registros escondidos entre as informações do reino.',
     'ACESSORIO', 2, '\assets\recompensas\itens\lupa-investigador.png'),

    ('Pergaminho da Sabedoria',
     'Um pergaminho que guarda o conhecimento necessário para interpretar os registros.',
     'ACESSORIO', 2, 'assets\recompensas\itens\pergaminho-sabedoria.png'),

    ('Relógio Arcano',
     'Um relógio mágico capaz de organizar os acontecimentos em sua ordem temporal.',
     'ACESSORIO', 3, 'assets\recompensas\itens\relogio-arcano.png'),

    ('Machado dos Guerreiros',
     'Um machado que representa a força dos soldados mais poderosos.',
     'ARMA', 3, 'assets\recompensas\itens\machado-guerreiros.png'),

    ('Adaga do Rastreador',
     'Uma adaga utilizada para identificar as criaturas mais perigosas.',
     'ARMA', 3, 'assets\recompensas\itens\adaga-rastreador.png'),

    ('Anel da Estratégia',
     'Um anel que concede sabedoria para selecionar e organizar os guerreiros.',
     'ACESSORIO', 3, 'assets\recompensas\itens\anel-estrategia.png'),

    ('Medalhão da Contagem',
     'Um medalhão que revela a quantidade exata de registros existentes.',
     'ACESSORIO', 4, 'assets\recompensas\itens\medalhao-contagem.png'),

    ('Bússola das Vilas',
     'Uma bússola que revela como as forças estão distribuídas entre as vilas.',
     'ACESSORIO', 4, 'assets\recompensas\itens\bussola-vilas.png'),

    ('Bolsa dos Tesouros',
     'Uma bolsa encantada que contabiliza os recursos armazenados no reino.',
     'ACESSORIO', 4, 'assets\recompensas\itens\bolsa-tesouros.png'),

    ('Cristal da Corrupção',
     'Um cristal capaz de revelar as regiões mais afetadas pela corrupção.',
     'ACESSORIO', 4, 'assets\recompensas\itens\cristao-corrupcao.png'),

    ('Elo da União',
     'Um elo mágico que conecta informações pertencentes a diferentes registros.',
     'ACESSORIO', 5, 'assets\recompensas\itens\machado-guerreiros.png'),

    ('Capa da Floresta',
     'Uma capa que permite encontrar os guerreiros escondidos nas regiões florestais.',
     'ARMADURA', 5, 'assets\recompensas\itens\capa-floresta.png'),

    ('Mapa dos Recursos',
     'Um mapa que revela onde os recursos de cada vila estão armazenados.',
     'ACESSORIO', 5, 'assets\recompensas\itens\mapa-recursos.png'),

    ('Martelo das Armas',
     'Um martelo que revela os equipamentos utilizados pelos guerreiros.',
     'ARMA', 5, 'assets\recompensas\itens\martelo-armas.png'),

    ('Estandarte da Batalha',
     'Um estandarte que reúne os guerreiros preparados para defender Aethel.',
     'ACESSORIO', 6, 'assets\recompensas\itens\estandarte-batalha.png'),

    ('Coroa das Vilas',
     'Uma coroa que representa o domínio sobre os recursos e a organização das vilas.',
     'ACESSORIO', 6, 'assets\recompensas\itens\coroa-vilas.png'),

    ('Orbe do Conhecimento',
     'Um orbe ancestral que permite investigar o reino utilizando consultas avançadas.',
     'ACESSORIO', 6, 'assets\recompensas\itens\orbe-conhecimento.png');


-- =========================================
-- RECOMPENSAS DOS 23 DESAFIOS
-- Cada desafio recebe 1 item e 1 conquista
-- =========================================

-- Os títulos dos desafios e nomes dos itens
-- são utilizados para localizar seus respectivos IDs.

INSERT INTO jogo.recompensas_desafio
(desafio_id, item_id, conquista_id, quantidade)

SELECT
    d.id,
    i.id,
    NULL,
    1
FROM (
         VALUES
             ('O Grande Registro', 'Espada do Conhecimento'),
             ('Os Nomes Perdidos', 'Escudo da Precisão'),
             ('Os Ofícios de Eldoria', 'Botas da Velocidade'),
             ('O Registro Completo', 'Armadura dos Dados'),
             ('Os Soldados Ativos', 'Amuleto das Conexões'),
             ('A Vila Perdida', 'Elmo do Guardião'),
             ('Recursos Mágicos', 'Lupa da Investigação'),
             ('Entregas Pendentes', 'Pergaminho da Sabedoria'),
             ('A Mensagem Mais Recente', 'Relógio Arcano'),
             ('Os Guerreiros Mais Fortes', 'Machado dos Guerreiros'),
             ('As Criaturas Mais Perigosas', 'Adaga do Rastreador'),
             ('Os Soldados Ativos Mais Fortes', 'Anel da Estratégia'),
             ('Quantos Soldados Restam?', 'Medalhão da Contagem'),
             ('Soldados por Vila', 'Bússola das Vilas'),
             ('Recursos do Reino', 'Bolsa dos Tesouros'),
             ('Onde a Corrupção Está Maior?', 'Cristal da Corrupção'),
             ('Onde Estão os Soldados?', 'Elo da União'),
             ('Guerreiros da Floresta', 'Capa da Floresta'),
             ('Recursos das Vilas', 'Mapa dos Recursos'),
             ('As Armas dos Guerreiros', 'Martelo das Armas'),
             ('Soldados da Linha de Frente', 'Estandarte da Batalha'),
             ('A Força das Vilas', 'Coroa das Vilas'),
             ('A Região Dominada', 'Orbe do Conhecimento')
     ) AS recompensa(titulo_desafio, nome_item)
         JOIN jogo.desafios d
              ON d.titulo = recompensa.titulo_desafio
         JOIN jogo.itens i
              ON i.nome = recompensa.nome_item;


-- =========================================
-- CONQUISTAS DOS 23 DESAFIOS
-- =========================================

INSERT INTO jogo.recompensas_desafio
(desafio_id, item_id, conquista_id, quantidade)

SELECT
    d.id,
    NULL,
    c.id,
    0
FROM (
         VALUES
             ('O Grande Registro', 'O Despertar do Guardião'),
             ('Os Nomes Perdidos', 'Memória Recuperada'),
             ('Os Ofícios de Eldoria', 'Investigador de Profissões'),
             ('O Registro Completo', 'Restaurador do Registro'),
             ('Os Soldados Ativos', 'Sentinela de Aethel'),
             ('A Vila Perdida', 'Explorador de Eldoria'),
             ('Recursos Mágicos', 'Caçador de Relíquias'),
             ('Entregas Pendentes', 'Mensageiro da Esperança'),
             ('A Mensagem Mais Recente', 'Guardião do Tempo'),
             ('Os Guerreiros Mais Fortes', 'Comandante de Aethel'),
             ('As Criaturas Mais Perigosas', 'Rastreador das Criaturas'),
             ('Os Soldados Ativos Mais Fortes', 'Estrategista de Guerra'),
             ('Quantos Soldados Restam?', 'Contador do Exército'),
             ('Soldados por Vila', 'Mestre das Vilas'),
             ('Recursos do Reino', 'Tesoureiro do Reino'),
             ('Onde a Corrupção Está Maior?', 'Investigador da Corrupção'),
             ('Onde Estão os Soldados?', 'Conector de Destinos'),
             ('Guerreiros da Floresta', 'Protetor da Floresta'),
             ('Recursos das Vilas', 'Explorador de Recursos'),
             ('As Armas dos Guerreiros', 'Mestre das Armas'),
             ('Soldados da Linha de Frente', 'Estrategista Supremo'),
             ('A Força das Vilas', 'Administrador de Aethel'),
             ('A Região Dominada', 'Mente Estratégica')
     ) AS recompensa(titulo_desafio, nome_conquista)
         JOIN jogo.desafios d
              ON d.titulo = recompensa.titulo_desafio
         JOIN jogo.conquistas c
              ON c.nome = recompensa.nome_conquista;


-- =========================================
-- CONQUISTAS ESPECIAIS DA JORNADA
-- =========================================

INSERT INTO jogo.recompensas_desafio
(desafio_id, item_id, conquista_id, quantidade)

SELECT d.id, NULL, c.id, 0
FROM jogo.desafios d
         CROSS JOIN jogo.conquistas c
WHERE d.titulo = 'A Região Dominada'
  AND c.nome IN (
                 'Lenda de Aethel',
                 'Guardião Supremo do Grande Registro'
    );
