-- Geração de Modelo físico
-- Sql ANSI 2003 - brModelo.



CREATE TABLE Cliente (
idcliente Serial PRIMARY KEY,
nome varchar(400),
telefone int,
endereço varchar(400),
rg int,
email varchar(400),
datanasc date
);

CREATE TABLE Veiculo (
idveiculo Serial PRIMARY KEY,
idcliente Serial,
fabricante varchar(400),
modelo varchar(400),
ano int,
kilometragem int,
descricao varchar(1000),
FOREIGN KEY(idcliente) REFERENCES Cliente (idcliente)
);

CREATE TABLE Peca (
idpeca Serial PRIMARY KEY,
nome varchar(400),
valor int,
nomefornecedor varchar(400)
);

CREATE TABLE Funcionario (
idfuncionario Serial PRIMARY KEY,
nome varchar(400),
dataentrada date,
rg int,
cargo varchar(200),
salario int,
endereço varchar(400),
senha varchar(20)
);

CREATE TABLE Manutencao (
idmanutencao Serial PRIMARY KEY,
idveiculo Serial,
idfuncionario Serial,
idpeca Serial,
valor int,
FOREIGN KEY(idveiculo) REFERENCES Veiculo (idveiculo),
FOREIGN KEY(idfuncionario) REFERENCES Funcionario (idfuncionario),
FOREIGN KEY(idpeca) REFERENCES Peca (idpeca)
);



