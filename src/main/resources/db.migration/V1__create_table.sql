-- =========================================================
-- Tabela: FUNCIONARIOS
-- =========================================================
CREATE TABLE funcionarios (
idfuncionario BIGINT IDENTITY(1,1) PRIMARY KEY,
funcao VARCHAR(50) NOT NULL,
nome VARCHAR(150) NOT NULL
);
GO

-- =========================================================
-- Tabela: VACINAS
-- =========================================================
CREATE TABLE vacinas (
idvacina BIGINT IDENTITY(1,1) PRIMARY KEY,
nome_vacina VARCHAR(100) NOT NULL,
lote_vacina VARCHAR(50) NOT NULL
);
GO

-- =========================================================
-- Tabela: OVINOS
-- =========================================================
CREATE TABLE ovinos (
id_ovino BIGINT IDENTITY(1,1) PRIMARY KEY,
numero_brinco VARCHAR(20) UNIQUE NOT NULL,
data_nascimento DATE NOT NULL,
peso_nascimento DECIMAL(5,2) NULL,
peso_15d DECIMAL(5,2) NULL,
peso_30d DECIMAL(5,2) NULL,
peso_45d DECIMAL(5,2) NULL,
data_vacina DATE NULL
);
GO

-- =========================================================
-- Tabela: HISTORICOS
-- =========================================================
CREATE TABLE historicos (
id BIGINT IDENTITY(1,1) PRIMARY KEY,
acao VARCHAR(50) NOT NULL,              -- Enum armazenado como texto
dataHora DATETIME2 NOT NULL,
pesoRegistrado DECIMAL(6,2) NULL,
vacina_id BIGINT NULL,
funcionario_id BIGINT NULL,
ovino_id BIGINT NULL,
observacao VARCHAR(255) NULL,

CONSTRAINT fk_historico_vacina FOREIGN KEY (vacina_id)
    REFERENCES vacinas(idvacina)
    ON DELETE SET NULL
    ON UPDATE CASCADE,

CONSTRAINT fk_historico_funcionario FOREIGN KEY (funcionario_id)
    REFERENCES funcionarios(idfuncionario)
    ON DELETE SET NULL
    ON UPDATE CASCADE,

CONSTRAINT fk_historico_ovino FOREIGN KEY (ovino_id)
    REFERENCES ovinos(id_ovino)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);
GO
