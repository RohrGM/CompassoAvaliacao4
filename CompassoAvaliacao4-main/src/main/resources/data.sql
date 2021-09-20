INSERT INTO PARTIDO(nome, sigla, ideologia, datafundacao) VALUES('Partido1', 'par1', 'CENTRO', '2021-09-10');
INSERT INTO PARTIDO(nome, sigla, ideologia, datafundacao) VALUES('Partido2', 'par2', 'DIREITA', '2021-09-10');
INSERT INTO PARTIDO(nome, sigla, ideologia, datafundacao) VALUES('Partido3', 'par3', 'ESQUERDA', '2021-09-10');
INSERT INTO PARTIDO(nome, sigla, ideologia, datafundacao) VALUES('Partido4', 'par4', 'ESQUERDA', '2021-09-10');


INSERT INTO ASSOCIADO(nome, cargopolitico, datanascimento, partido_id, sexo)
 VALUES ('Associado1', 'VEREADOR', '1950-02-11', 1 ,'MASCULINO');

INSERT INTO ASSOCIADO(nome, cargopolitico, datanascimento, partido_id, sexo)
VALUES ('Associado2', 'PRESIDENTE', '1960-02-11', 1 ,'MASCULINO');

INSERT INTO ASSOCIADO(nome, cargopolitico, datanascimento, partido_id, sexo)
VALUES ('Associado3', 'PREFEITO', '1981-02-11', 2 ,'MASCULINO');

INSERT INTO ASSOCIADO(nome, cargopolitico, datanascimento, partido_id, sexo)
VALUES ('Associado4', 'DEPUTADO_ESTADUAL', '1980-02-11', 3 ,'FEMININO');

INSERT INTO ASSOCIADO(nome, cargopolitico, datanascimento, sexo)
VALUES ('Associado5', 'PREFEITO', '1988-02-11','MASCULINO');