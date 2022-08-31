create database estoque;

CREATE TABLE usuario(
	codusuario serial primary key,
	nome_user VARCHAR(80) not null,
    email varchar(80),
    telefone varchar(80),
    senha_user VARCHAR(80) not null
);
CREATE TABLE funcionario (
    cod_funcionario serial PRIMARY KEY,
    nome_funcionario VARCHAR(80) not null,
     rg VARCHAR(80) not null,
    cpf VARCHAR(14) not null,
    fk_bairro INTEGER,
    fk_cidade INTEGER,
    fk_codtelefone integer,
    fk_codrua integer,
    numerocasa varchar(10) not null

);

CREATE TABLE estado (
    codestado serial PRIMARY KEY,
    nome_estado VARCHAR(80) not null
);

CREATE TABLE cidade (
    codcidade serial PRIMARY KEY,
    nomecidade varchar(80) not null,
    fk_uf INTEGER
   
);

CREATE TABLE bairro (
    codbairro serial PRIMARY KEY,
    bairro VARCHAR(80)
);

CREATE TABLE produto (
    codigo_barras INTEGER PRIMARY KEY,
    produto VARCHAR(80),
    quantidade INTEGER,
    fk_tipo INTEGER,
    fk_marca INTEGER
);

CREATE TABLE marca (
    cod_marca_produto serial PRIMARY KEY,
    marca_produto VARCHAR(80) not null
);

CREATE TABLE tipos (
    cod_tipo_produto serial PRIMARY KEY,
     tipo VARCHAR(80) not null
);

CREATE TABLE Cliente (
    cod_cliente serial PRIMARY KEY,
    nome_cliente VARCHAR(80),
     rg VARCHAR(80),
    cpf VARCHAR(14),
    fk_bairro INTEGER,
    fk_cidade INTEGER,
    fk_codtelefone integer,
    fk_codrua integer,
    numerocasa varchar(10) not null
);

CREATE TABLE Tipo_Telefone (
    codtipotel serial PRIMARY KEY,
    nometipotel varchar(80) not null

);

CREATE TABLE Rua (
    codrua serial PRIMARY KEY,
    nomerua varchar(80) not null 
);

CREATE TABLE Telefone (
    codtelefone serial PRIMARY KEY,
    numerotel varchar(20) not null,
    fk_codtipotel integer
    
);

CREATE TABLE Venda (
    codvenda serial PRIMARY KEY,
    datavenda date not null,
    fk_codcliente INTEGER,
    fk_codfuncionario INTEGER
);

CREATE TABLE Itens_Venda (
    fk_codproduto INTEGER,
    fk_codvenda integer,
    quantv numeric(10,2) not null,
    valorv numeric(10,2) not null,
    PRIMARY KEY (fk_codproduto, fk_codvenda)
);
 
 
ALTER TABLE funcionario ADD CONSTRAINT FK_funcionario_4
    FOREIGN KEY (fk_codrua)
    REFERENCES Rua (codrua);
 

 
ALTER TABLE funcionario ADD CONSTRAINT FK_funcionario_7
    FOREIGN KEY (fk_bairro)
    REFERENCES bairro (codbairro);
 
ALTER TABLE funcionario ADD CONSTRAINT FK_funcionario_8
    FOREIGN KEY (fk_cidade)
    REFERENCES cidade (codcidade);
 
ALTER TABLE funcionario ADD CONSTRAINT FK_funcionario_9
    FOREIGN KEY (fk_codtelefone)
    REFERENCES Telefone (codtelefone);
 
ALTER TABLE cidade ADD CONSTRAINT FK_cidade_3
    FOREIGN KEY (fk_uf)
    REFERENCES estado (codestado);

 
ALTER TABLE produto ADD CONSTRAINT FK_produto_2
    FOREIGN KEY (fk_marca)
    REFERENCES marca (cod_marca_produto);
 
ALTER TABLE produto ADD CONSTRAINT FK_produto_3
    FOREIGN KEY (fk_tipo)
    REFERENCES tipos (cod_tipo_produto);
 
 
ALTER TABLE Cliente ADD CONSTRAINT FK_Cliente_3
    FOREIGN KEY (fk_bairro)
    REFERENCES bairro (codbairro);
 
ALTER TABLE Cliente ADD CONSTRAINT FK_Cliente_4
    FOREIGN KEY (fk_cidade)
    REFERENCES cidade (codcidade);
 
ALTER TABLE Cliente ADD CONSTRAINT FK_Cliente_5
    FOREIGN KEY (fk_codtelefone)
    REFERENCES Telefone (codtelefone);
 
ALTER TABLE Cliente ADD CONSTRAINT FK_Cliente_6
    FOREIGN KEY (fk_codrua)
    REFERENCES Rua (codrua);
 
ALTER TABLE Venda ADD CONSTRAINT FK_Venda_3
    FOREIGN KEY (fk_codcliente)
    REFERENCES Cliente (cod_cliente);
 
ALTER TABLE Venda ADD CONSTRAINT FK_Venda_4
    FOREIGN KEY (fk_codfuncionario)
    REFERENCES funcionario (cod_funcionario);
 
ALTER TABLE Itens_Venda ADD CONSTRAINT FK_Itens_Venda_1
    FOREIGN KEY (fk_codproduto)
    REFERENCES produto (codigo_barras);
 
ALTER TABLE Itens_Venda ADD CONSTRAINT FK_Itens_Venda_3
    FOREIGN KEY (fk_codvenda)
    REFERENCES Venda (codvenda);

ALTER TABLE Telefone ADD CONSTRAINT FK_Telefone_1
    FOREIGN KEY (fk_codtipotel)
    REFERENCES Tipo_Telefone (codtipotel);

/*select T.codtelefone, T.numerotel, TT.nometipotel
from telefone as T, tipo_telefone as TT
WHERE T.fk_codtipotel = TT.codtipotel*/

