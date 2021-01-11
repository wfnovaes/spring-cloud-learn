DROP TABLE IF EXISTS INFORMACAO_FORNECEDOR;

CREATE TABLE INFORMACAO_FORNECEDOR (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(250) NOT NULL,
  uf VARCHAR(250) NOT NULL,
  endereco VARCHAR(250) DEFAULT NULL
);

INSERT INTO INFORMACAO_FORNECEDOR (nome, uf, endereco) VALUES
  ('flor SP', 'SP', 'Billionaire Industrialist'),
  ('flor GO', 'GO', 'Billionaire Tech Entrepreneur'),
  ('RAFA', 'CE', 'texto qualquer');