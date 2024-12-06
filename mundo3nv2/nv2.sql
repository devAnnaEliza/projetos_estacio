CREATE DATABASE Loja ON loja 
GO 


CREATE TABLE Pessoas (
  idpessoa INTEGER  NOT NULL   IDENTITY ,
  Nome VARCHAR(255)    ,
  Cidade VARCHAR(20)    ,
  Celular VARCHAR(11)      ,
PRIMARY KEY(idpessoa));
GO




CREATE TABLE Produto (
  idProduto INTEGER  NOT NULL   IDENTITY ,
  Nome VARCHAR(255)    ,
  Quantidade INTEGER    ,
  PrecoVenda NUMERIC(10,2)      ,
PRIMARY KEY(idProduto));
GO




CREATE TABLE Usuarios (
  usuariosid INTEGER  NOT NULL   IDENTITY ,
  Login VARCHAR(20)    ,
  Senha VARCHAR(20)      ,
PRIMARY KEY(usuariosid));
GO




CREATE TABLE pessoafisica (
  id_pessoafisica INTEGER  NOT NULL   IDENTITY ,
  Pessoas_idpessoa INTEGER  NOT NULL  ,
  CPF VARCHAR(20)      ,
PRIMARY KEY(id_pessoafisica)  ,
  FOREIGN KEY(Pessoas_idpessoa)
    REFERENCES Pessoas(idpessoa));
GO


CREATE INDEX pessoafisica_FKIndex1 ON pessoafisica (Pessoas_idpessoa);
GO


CREATE INDEX IFK_Rel_04 ON pessoafisica (Pessoas_idpessoa);
GO


CREATE TABLE pessoajuridica (
  id_pessoajuridica INTEGER  NOT NULL   IDENTITY ,
  pessoa_idpessoa INTEGER  NOT NULL  ,
  Pessoas_idpessoa INTEGER  NOT NULL  ,
  CNPJ VARCHAR(20)      ,
PRIMARY KEY(id_pessoajuridica, pessoa_idpessoa)  ,
  FOREIGN KEY(Pessoas_idpessoa)
    REFERENCES Pessoas(idpessoa));
GO


CREATE INDEX pessoajuridica_FKIndex1 ON pessoajuridica (Pessoas_idpessoa);
GO


CREATE INDEX IFK_Rel_05 ON pessoajuridica (Pessoas_idpessoa);
GO


CREATE TABLE movimento (
  idmovimento INTEGER  NOT NULL   IDENTITY ,
  Produto_idProduto INTEGER  NOT NULL  ,
  Usuarios_usuariosid INTEGER  NOT NULL  ,
  Pessoas_idpessoa INTEGER  NOT NULL  ,
  Quantidade INTEGER    ,
  Tipo VARCHAR(1)    ,
  Valor NUMERIC(10,2)      ,
PRIMARY KEY(idmovimento)      ,
  FOREIGN KEY(Pessoas_idpessoa)
    REFERENCES Pessoas(idpessoa),
  FOREIGN KEY(Usuarios_usuariosid)
    REFERENCES Usuarios(usuariosid),
  FOREIGN KEY(Produto_idProduto)
    REFERENCES Produto(idProduto));
GO


CREATE INDEX movimento_FKIndex1 ON movimento (Pessoas_idpessoa);
GO
CREATE INDEX movimento_FKIndex2 ON movimento (Usuarios_usuariosid);
GO
CREATE INDEX movimento_FKIndex3 ON movimento (Produto_idProduto);
GO


CREATE INDEX IFK_Rel_06 ON movimento (Pessoas_idpessoa);
GO
CREATE INDEX IFK_Rel_07 ON movimento (Usuarios_usuariosid);
GO
CREATE INDEX IFK_Rel_08 ON movimento (Produto_idProduto);
GO


