CREATE TABLE users (
    id BIGINT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    descricao TEXT,
    telefone VARCHAR(20),
    idade INT,
    endereco VARCHAR(255),
    funcao VARCHAR(100),
    role INT
);
