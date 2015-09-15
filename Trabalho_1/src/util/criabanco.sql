



CREATE TABLE Cliente (
idcliente Serial PRIMARY KEY,
nome varchar(400),
telefone varchar(20),
endereço varchar(400),
cpf char(11),
rg char(10),
email varchar(400),
datanasc date
);

CREATE TABLE Veiculo (
idveiculo Serial PRIMARY KEY,
idcliente Serial,
fabricante varchar(400),
modelo varchar(400),
ano char(4),
kilometragem varchar(20),
descricao varchar(1000),
FOREIGN KEY(idcliente) REFERENCES Cliente (idcliente)
);

CREATE TABLE Peca (
idpeca Serial PRIMARY KEY,
nome varchar(400),
valor varchar(20),
nomefornecedor varchar(400)
);

CREATE TABLE Funcionario (
idfuncionario Serial PRIMARY KEY,
nome varchar(400),
telefone varchar(20),
dataentrada date,
rg char(10),
cpf char(11),
cargo varchar(200),
salario varchar(20),
endereço varchar(400),
senha varchar(20)
);

CREATE TABLE Manutencao (
idmanutencao Serial PRIMARY KEY,
idveiculo Serial,
idfuncionario Serial,
idpeca Serial,
valor varchar(20),
FOREIGN KEY(idveiculo) REFERENCES Veiculo (idveiculo),
FOREIGN KEY(idfuncionario) REFERENCES Funcionario (idfuncionario),
FOREIGN KEY(idpeca) REFERENCES Peca (idpeca)
);


