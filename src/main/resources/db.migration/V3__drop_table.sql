
-- HISTORICOS depende de VACINAS, FUNCIONARIOS e OVINOS
IF OBJECT_ID('historicos', 'U') IS NOT NULL
BEGIN
DROP TABLE historicos;
END
GO

-- OVINOS (referenciado por historicos)
IF OBJECT_ID('ovinos', 'U') IS NOT NULL
BEGIN
DROP TABLE ovinos;
END
GO

-- FUNCIONARIOS (referenciado por historicos)
IF OBJECT_ID('funcionarios', 'U') IS NOT NULL
BEGIN
DROP TABLE funcionarios;
END
GO

-- VACINAS (referenciado por historicos)
IF OBJECT_ID('vacinas', 'U') IS NOT NULL
BEGIN
DROP TABLE vacinas;
END
GO
