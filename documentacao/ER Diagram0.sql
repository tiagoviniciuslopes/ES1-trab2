CREATE TABLE AtividadeComercial (
 idAtividadeComercial INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 descricaoAtividadeComercial VARCHAR(10)
);

CREATE TABLE Bairro (
 idBairro INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 nomeBairro VARCHAR(10) NOT NULL
);


CREATE TABLE DDD (
 idDDD INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 numeroDDD INT NOT NULL
);


CREATE TABLE DDI (
 idDDI INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 numeroDDI INT NOT NULL
);


CREATE TABLE Etapa (
 idEtapa INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 descricaoEtapa VARCHAR(10) NOT NULL
);


CREATE TABLE Pais (
 idPais INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 nomePais VARCHAR(10) NOT NULL
);


CREATE TABLE Produto (
 idProduto INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 nomeProduto VARCHAR(10),
 precoBaseProduto FLOAT(10)
);


CREATE TABLE Servico (
 idServico INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 precoBaseServico FLOAT(10),
 nomeServico VARCHAR(10),
 horasBaseServico FLOAT(10)
);


CREATE TABLE Sexo (
 idSexo INT NOT NULL PRIMARY KEY  AUTO_INCREMENT,
 descricaoSexo VARCHAR(10) NOT NULL,
 siglaSexo VARCHAR(10) NOT NULL
);


CREATE TABLE TipoFone (
 idTipoFone INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 siglaTipoFone VARCHAR(10) NOT NULL,
 descricaoTipoFone VARCHAR(10)
);


CREATE TABLE TipoLogradouro (
 idTipoLogradouro INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 siglaTipo VARCHAR(10),
 nomeTIpo VARCHAR(10) NOT NULL
);


CREATE TABLE UF (
 idUF INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 siglaUF VARCHAR(10),
 nomeUF VARCHAR(10) NOT NULL,
 idPais INT
);


CREATE TABLE Cidade (
 idCidade INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 nomeCidade VARCHAR(10) NOT NULL,
 idUF INT
);


CREATE TABLE Logradouro (
 idLogradouro INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 nomeLogradouro VARCHAR(10) NOT NULL,
 idTipoLogradouro INT
);


CREATE TABLE OrgaoExpeditor (
 idOrgaoExpeditor INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 nomeOrgaoExpeditor VARCHAR(10) NOT NULL,
 idUF INT
);


CREATE TABLE Endereco (
 idEndereco INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 cep VARCHAR(10) NOT NULL,
 idBairro INT,
 idCidade INT,
 idLogradouro INT
);


CREATE TABLE Funcionario (
 idFuncionario INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 primeiroNomeFuncionario VARCHAR(10) NOT NULL,
 nomeMeioFuncionario VARCHAR(10),
 ultimoNomeFuncionario VARCHAR(10),
 nomeAbreviadoPessoa VARCHAR(10),
 cpf VARCHAR(10),
 idSexo INT,
 numero INT NOT NULL,
 complemento VARCHAR(10),
 idEndereco INT,
 numeroDoc VARCHAR(10),
 dataExpedicao DATE,
 idOrgaoExpeditor INT,
 caminhoFoto VARCHAR(10),
 descricaoFoto VARCHAR(10)
);


CREATE TABLE Cliente (
 idCliente INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 primeiroNomeCliente VARCHAR(10) NOT NULL,
 nomeMeioCliente VARCHAR(10),
 ultimoNomeCliente VARCHAR(10) NOT NULL,
 nomeAbreviadoCliente VARCHAR(10),
 cpf VARCHAR(10),
 cnpj VARCHAR(10),
 idSexo INT,
 numero INT NOT NULL,
 complemento VARCHAR(10),
 idEndereco INT,
 numeroDoc VARCHAR(10),
 dataExpedicao DATE,
 idOrgaoExpeditor INT,
 caminhoFoto VARCHAR(10),
 descricaoFoto VARCHAR(10)
);


CREATE TABLE EmailCliente (
 idEmailCliente INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 descricaoEmail VARCHAR(10) NOT NULL,
 idCliente INT
);


CREATE TABLE EmailFuncionario (
 idEmailFuncionario INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 descricaoEmail VARCHAR(10) NOT NULL,
 idFuncionario INT
);


CREATE TABLE FoneCliente (
 idFoneCliente INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 numeroFone VARCHAR(10) NOT NULL,
 idCliente INT,
 idDDI INT,
 idDDD INT,
 idTipoFone INT
);


CREATE TABLE FoneFuncionario (
 idFoneFuncionario INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 numeroFone VARCHAR(10) NOT NULL,
 idTipoFone INT,
 idDDD INT,
 idDDI INT,
 idFuncionario INT
);


CREATE TABLE Veiculo (
 idVeiculo INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 nomeVeiculo VARCHAR(10) NOT NULL,
 marcaVeiculo VARCHAR(10) NOT NULL,
 modeloVeiculo VARCHAR(10),
 kmVeiculo INT NOT NULL,
 placaVeiculo VARCHAR(10),
 idCliente INT
);


CREATE TABLE AtividadeComercial_Cliente (
 idAtividadeComercial INT NOT NULL,
 idCliente INT NOT NULL
);

ALTER TABLE AtividadeComercial_Cliente ADD CONSTRAINT PK_AtividadeComercial_Cliente PRIMARY KEY (idAtividadeComercial,idCliente);


CREATE TABLE OrdemServico (
 idOrdemServico INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 data DATE NOT NULL,
 observacoes VARCHAR(10),
 idEtapa INT,
 idVeiculo INT,
 idFuncionario INT
);


CREATE TABLE OrdemServico_Produto (
 idOrdemServico INT NOT NULL,
 idProduto INT NOT NULL,
 precoProduto FLOAT(10),
 quantidadeProduto INT
);

ALTER TABLE OrdemServico_Produto ADD CONSTRAINT PK_OrdemServico_Produto PRIMARY KEY (idOrdemServico,idProduto);


CREATE TABLE OrdemServico_Servico (
 idServico INT NOT NULL,
 idOrdemServico INT NOT NULL,
 precoServico FLOAT(10),
 horasServico FLOAT(10)
);

ALTER TABLE OrdemServico_Servico ADD CONSTRAINT PK_OrdemServico_Servico PRIMARY KEY (idServico,idOrdemServico);


ALTER TABLE UF ADD CONSTRAINT FK_UF_0 FOREIGN KEY (idPais) REFERENCES Pais (idPais);


ALTER TABLE Cidade ADD CONSTRAINT FK_Cidade_0 FOREIGN KEY (idUF) REFERENCES UF (idUF);


ALTER TABLE Logradouro ADD CONSTRAINT FK_Logradouro_0 FOREIGN KEY (idTipoLogradouro) REFERENCES TipoLogradouro (idTipoLogradouro);


ALTER TABLE OrgaoExpeditor ADD CONSTRAINT FK_OrgaoExpeditor_0 FOREIGN KEY (idUF) REFERENCES UF (idUF);


ALTER TABLE Endereco ADD CONSTRAINT FK_Endereco_0 FOREIGN KEY (idBairro) REFERENCES Bairro (idBairro);
ALTER TABLE Endereco ADD CONSTRAINT FK_Endereco_1 FOREIGN KEY (idCidade) REFERENCES Cidade (idCidade);
ALTER TABLE Endereco ADD CONSTRAINT FK_Endereco_2 FOREIGN KEY (idLogradouro) REFERENCES Logradouro (idLogradouro);


ALTER TABLE Funcionario ADD CONSTRAINT FK_Funcionario_0 FOREIGN KEY (idSexo) REFERENCES Sexo (idSexo);
ALTER TABLE Funcionario ADD CONSTRAINT FK_Funcionario_1 FOREIGN KEY (idEndereco) REFERENCES Endereco (idEndereco);
ALTER TABLE Funcionario ADD CONSTRAINT FK_Funcionario_2 FOREIGN KEY (idOrgaoExpeditor) REFERENCES OrgaoExpeditor (idOrgaoExpeditor);


ALTER TABLE Cliente ADD CONSTRAINT FK_Cliente_0 FOREIGN KEY (idSexo) REFERENCES Sexo (idSexo);
ALTER TABLE Cliente ADD CONSTRAINT FK_Cliente_1 FOREIGN KEY (idEndereco) REFERENCES Endereco (idEndereco);
ALTER TABLE Cliente ADD CONSTRAINT FK_Cliente_2 FOREIGN KEY (idOrgaoExpeditor) REFERENCES OrgaoExpeditor (idOrgaoExpeditor);


ALTER TABLE EmailCliente ADD CONSTRAINT FK_EmailCliente_0 FOREIGN KEY (idCliente) REFERENCES Cliente (idCliente);


ALTER TABLE EmailFuncionario ADD CONSTRAINT FK_EmailFuncionario_0 FOREIGN KEY (idFuncionario) REFERENCES Funcionario (idFuncionario);


ALTER TABLE FoneCliente ADD CONSTRAINT FK_FoneCliente_0 FOREIGN KEY (idCliente) REFERENCES Cliente (idCliente);
ALTER TABLE FoneCliente ADD CONSTRAINT FK_FoneCliente_1 FOREIGN KEY (idDDI) REFERENCES DDI (idDDI);
ALTER TABLE FoneCliente ADD CONSTRAINT FK_FoneCliente_2 FOREIGN KEY (idDDD) REFERENCES DDD (idDDD);
ALTER TABLE FoneCliente ADD CONSTRAINT FK_FoneCliente_3 FOREIGN KEY (idTipoFone) REFERENCES TipoFone (idTipoFone);


ALTER TABLE FoneFuncionario ADD CONSTRAINT FK_FoneFuncionario_0 FOREIGN KEY (idTipoFone) REFERENCES TipoFone (idTipoFone);
ALTER TABLE FoneFuncionario ADD CONSTRAINT FK_FoneFuncionario_1 FOREIGN KEY (idDDD) REFERENCES DDD (idDDD);
ALTER TABLE FoneFuncionario ADD CONSTRAINT FK_FoneFuncionario_2 FOREIGN KEY (idDDI) REFERENCES DDI (idDDI);
ALTER TABLE FoneFuncionario ADD CONSTRAINT FK_FoneFuncionario_3 FOREIGN KEY (idFuncionario) REFERENCES Funcionario (idFuncionario);


ALTER TABLE Veiculo ADD CONSTRAINT FK_Veiculo_0 FOREIGN KEY (idCliente) REFERENCES Cliente (idCliente);


ALTER TABLE AtividadeComercial_Cliente ADD CONSTRAINT FK_AtividadeComercial_Cliente_0 FOREIGN KEY (idAtividadeComercial) REFERENCES AtividadeComercial (idAtividadeComercial);
ALTER TABLE AtividadeComercial_Cliente ADD CONSTRAINT FK_AtividadeComercial_Cliente_1 FOREIGN KEY (idCliente) REFERENCES Cliente (idCliente);


ALTER TABLE OrdemServico ADD CONSTRAINT FK_OrdemServico_0 FOREIGN KEY (idEtapa) REFERENCES Etapa (idEtapa);
ALTER TABLE OrdemServico ADD CONSTRAINT FK_OrdemServico_1 FOREIGN KEY (idVeiculo) REFERENCES Veiculo (idVeiculo);
ALTER TABLE OrdemServico ADD CONSTRAINT FK_OrdemServico_2 FOREIGN KEY (idFuncionario) REFERENCES Funcionario (idFuncionario);


ALTER TABLE OrdemServico_Produto ADD CONSTRAINT FK_OrdemServico_Produto_0 FOREIGN KEY (idOrdemServico) REFERENCES OrdemServico (idOrdemServico);
ALTER TABLE OrdemServico_Produto ADD CONSTRAINT FK_OrdemServico_Produto_1 FOREIGN KEY (idProduto) REFERENCES Produto (idProduto);


ALTER TABLE OrdemServico_Servico ADD CONSTRAINT FK_OrdemServico_Servico_0 FOREIGN KEY (idServico) REFERENCES Servico (idServico);
ALTER TABLE OrdemServico_Servico ADD CONSTRAINT FK_OrdemServico_Servico_1 FOREIGN KEY (idOrdemServico) REFERENCES OrdemServico (idOrdemServico);


