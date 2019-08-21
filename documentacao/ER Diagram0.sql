CREATE TABLE AtividadeComercial (
 idAtividadeComercial INT NOT NULL,
 descricaoAtividadeComercial VARCHAR(10)
);

ALTER TABLE AtividadeComercial ADD CONSTRAINT PK_AtividadeComercial PRIMARY KEY (idAtividadeComercial);


CREATE TABLE Bairro (
 idBairro INT NOT NULL,
 nomeBairro VARCHAR(10) NOT NULL
);

ALTER TABLE Bairro ADD CONSTRAINT PK_Bairro PRIMARY KEY (idBairro);


CREATE TABLE DDD (
 idDDD INT NOT NULL,
 numeroDDD INT NOT NULL
);

ALTER TABLE DDD ADD CONSTRAINT PK_DDD PRIMARY KEY (idDDD);


CREATE TABLE DDI (
 idDDI INT NOT NULL,
 numeroDDI INT NOT NULL
);

ALTER TABLE DDI ADD CONSTRAINT PK_DDI PRIMARY KEY (idDDI);


CREATE TABLE Etapa (
 idEtapa INT NOT NULL,
 descricaoEtapa VARCHAR(10) NOT NULL
);

ALTER TABLE Etapa ADD CONSTRAINT PK_Etapa PRIMARY KEY (idEtapa);


CREATE TABLE Pais (
 idPais INT NOT NULL,
 nomePais VARCHAR(10) NOT NULL
);

ALTER TABLE Pais ADD CONSTRAINT PK_Pais PRIMARY KEY (idPais);


CREATE TABLE Produto (
 idProduto INT NOT NULL,
 nomeProduto VARCHAR(10),
 precoBaseProduto FLOAT(10)
);

ALTER TABLE Produto ADD CONSTRAINT PK_Produto PRIMARY KEY (idProduto);


CREATE TABLE Servico (
 idServico INT NOT NULL,
 precoBaseServico FLOAT(10),
 nomeServico VARCHAR(10),
 horasBaseServico FLOAT(10)
);

ALTER TABLE Servico ADD CONSTRAINT PK_Servico PRIMARY KEY (idServico);


CREATE TABLE Sexo (
 idSexo INT NOT NULL,
 descricaoSexo VARCHAR(10) NOT NULL,
 siglaSexo VARCHAR(10) NOT NULL
);

ALTER TABLE Sexo ADD CONSTRAINT PK_Sexo PRIMARY KEY (idSexo);


CREATE TABLE TipoFone (
 idTipoFone INT NOT NULL,
 siglaTipoFone VARCHAR(10) NOT NULL,
 descricaoTipoFone VARCHAR(10)
);

ALTER TABLE TipoFone ADD CONSTRAINT PK_TipoFone PRIMARY KEY (idTipoFone);


CREATE TABLE TipoLogradouro (
 idTipoLogradouro INT NOT NULL,
 siglaTipo VARCHAR(10),
 nomeTIpo VARCHAR(10) NOT NULL
);

ALTER TABLE TipoLogradouro ADD CONSTRAINT PK_TipoLogradouro PRIMARY KEY (idTipoLogradouro);


CREATE TABLE UF (
 idUF INT NOT NULL,
 siglaUF VARCHAR(10),
 nomeUF VARCHAR(10) NOT NULL,
 idPais INT
);

ALTER TABLE UF ADD CONSTRAINT PK_UF PRIMARY KEY (idUF);


CREATE TABLE Cidade (
 idCidade INT NOT NULL,
 nomeCidade VARCHAR(10) NOT NULL,
 idUF INT
);

ALTER TABLE Cidade ADD CONSTRAINT PK_Cidade PRIMARY KEY (idCidade);


CREATE TABLE Logradouro (
 idLogradouro INT NOT NULL,
 nomeLogradouro VARCHAR(10) NOT NULL,
 idTipoLogradouro INT
);

ALTER TABLE Logradouro ADD CONSTRAINT PK_Logradouro PRIMARY KEY (idLogradouro);


CREATE TABLE OrgaoExpeditor (
 idOrgaoExpeditor INT NOT NULL,
 nomeOrgaoExpeditor VARCHAR(10) NOT NULL,
 idUF INT
);

ALTER TABLE OrgaoExpeditor ADD CONSTRAINT PK_OrgaoExpeditor PRIMARY KEY (idOrgaoExpeditor);


CREATE TABLE Endereco (
 idEndereco INT NOT NULL,
 cep VARCHAR(10) NOT NULL,
 idBairro INT,
 idCidade INT,
 idLogradouro INT
);

ALTER TABLE Endereco ADD CONSTRAINT PK_Endereco PRIMARY KEY (idEndereco);


CREATE TABLE Funcionario (
 idFuncionario INT NOT NULL,
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

ALTER TABLE Funcionario ADD CONSTRAINT PK_Funcionario PRIMARY KEY (idFuncionario);


CREATE TABLE ClienteEmpresa (
 idClienteEmpresa CHAR(10) NOT NULL,
 primeiroNomeEmpresa VARCHAR(10) NOT NULL,
 nomeMeioEmpresa VARCHAR(10),
 ultimoNomeEmpresa VARCHAR(10),
 nomeAbreviadoEmpresa CHAR(10),
 cnpj VARCHAR(10) NOT NULL,
 numero INT NOT NULL,
 complemento VARCHAR(10),
 idEndereco INT,
 caminhoFoto VARCHAR(10),
 descricaoFoto VARCHAR(10)
);

ALTER TABLE ClienteEmpresa ADD CONSTRAINT PK_ClienteEmpresa PRIMARY KEY (idClienteEmpresa);


CREATE TABLE ClienteEmpresa_AtividadeComercial (
 idAtividadeComercial INT NOT NULL,
 idClienteEmpresa CHAR(10) NOT NULL
);

ALTER TABLE ClienteEmpresa_AtividadeComercial ADD CONSTRAINT PK_ClienteEmpresa_AtividadeComercial PRIMARY KEY (idAtividadeComercial,idClienteEmpresa);


CREATE TABLE ClientePessoa (
 idClientePessoa CHAR(10) NOT NULL,
 primeiroNomePessoa VARCHAR(10) NOT NULL,
 nomeMeioPessoa VARCHAR(10),
 ultimoNomePessoa VARCHAR(10) NOT NULL,
 nomeAbreviadoPessoa VARCHAR(10),
 cpf VARCHAR(10) NOT NULL,
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

ALTER TABLE ClientePessoa ADD CONSTRAINT PK_ClientePessoa PRIMARY KEY (idClientePessoa);


CREATE TABLE EmailClienteEmpresa (
 idEmailClienteEmpresa INT NOT NULL,
 descricaoEmail VARCHAR(10),
 idClienteEmpresa CHAR(10)
);

ALTER TABLE EmailClienteEmpresa ADD CONSTRAINT PK_EmailClienteEmpresa PRIMARY KEY (idEmailClienteEmpresa);


CREATE TABLE EmailClientePessoa (
 idEmailClientePessoa INT NOT NULL,
 descricaoEmail VARCHAR(10) NOT NULL,
 idClientePessoa CHAR(10)
);

ALTER TABLE EmailClientePessoa ADD CONSTRAINT PK_EmailClientePessoa PRIMARY KEY (idEmailClientePessoa);


CREATE TABLE EmailFuncionario (
 idEmailFuncionario INT NOT NULL,
 descricaoEmail VARCHAR(10) NOT NULL,
 idFuncionario INT
);

ALTER TABLE EmailFuncionario ADD CONSTRAINT PK_EmailFuncionario PRIMARY KEY (idEmailFuncionario);


CREATE TABLE FoneClienteEmpresa (
 idFoneClienteEmpresa INT NOT NULL,
 numeroFone VARCHAR(10) NOT NULL,
 idTipoFone INT,
 idDDD INT,
 idDDI INT,
 idClienteEmpresa CHAR(10)
);

ALTER TABLE FoneClienteEmpresa ADD CONSTRAINT PK_FoneClienteEmpresa PRIMARY KEY (idFoneClienteEmpresa);


CREATE TABLE FoneClientePessoa (
 idFoneClientePessoa INT NOT NULL,
 numeroFone VARCHAR(10) NOT NULL,
 idClientePessoa CHAR(10),
 idDDI INT,
 idDDD INT,
 idTipoFone INT
);

ALTER TABLE FoneClientePessoa ADD CONSTRAINT PK_FoneClientePessoa PRIMARY KEY (idFoneClientePessoa);


CREATE TABLE FoneFuncionario (
 idFoneFuncionario INT NOT NULL,
 numeroFone VARCHAR(10) NOT NULL,
 idTipoFone INT,
 idDDD INT,
 idDDI INT,
 idFuncionario INT
);

ALTER TABLE FoneFuncionario ADD CONSTRAINT PK_FoneFuncionario PRIMARY KEY (idFoneFuncionario);


CREATE TABLE VeiculoClienteEmpresa (
 idVeiculoClientePessoa INT NOT NULL,
 nomeVeiculo CHAR(10),
 marcaVeiculo VARCHAR(10) NOT NULL,
 modeloVeiculo VARCHAR(10),
 kmVeiculo INT NOT NULL,
 placaVeiculo VARCHAR(10),
 idClienteEmpresa CHAR(10)
);

ALTER TABLE VeiculoClienteEmpresa ADD CONSTRAINT PK_VeiculoClienteEmpresa PRIMARY KEY (idVeiculoClientePessoa);


CREATE TABLE VeiculoClientePessoa (
 idVeiculoClientePessoa INT NOT NULL,
 nomeVeiculo VARCHAR(10) NOT NULL,
 marcaVeiculo VARCHAR(10) NOT NULL,
 modeloVeiculo VARCHAR(10),
 kmVeiculo INT NOT NULL,
 placaVeiculo VARCHAR(10),
 idClientePessoa CHAR(10)
);

ALTER TABLE VeiculoClientePessoa ADD CONSTRAINT PK_VeiculoClientePessoa PRIMARY KEY (idVeiculoClientePessoa);


CREATE TABLE OrdemServicoClienteEmpresa (
 idOrdemServicoClientePessoa INT NOT NULL,
 data DATE,
 observacoes VARCHAR(10),
 idEtapa INT,
 idVeiculoClientePessoa INT,
 idFuncionario INT
);

ALTER TABLE OrdemServicoClienteEmpresa ADD CONSTRAINT PK_OrdemServicoClienteEmpresa PRIMARY KEY (idOrdemServicoClientePessoa);


CREATE TABLE OrdemServicoClienteEmpresa_Servico (
 idServico INT NOT NULL,
 idOrdemServicoClientePessoa INT NOT NULL,
 precoServico FLOAT(10),
 horasServico FLOAT(10)
);

ALTER TABLE OrdemServicoClienteEmpresa_Servico ADD CONSTRAINT PK_OrdemServicoClienteEmpresa_Servico PRIMARY KEY (idServico,idOrdemServicoClientePessoa);


CREATE TABLE OrdemServicoClientePessoa (
 idOrdemServicoClientePessoa INT NOT NULL,
 data DATE NOT NULL,
 observacoes VARCHAR(10),
 idEtapa INT,
 idVeiculoClientePessoa INT,
 idFuncionario INT
);

ALTER TABLE OrdemServicoClientePessoa ADD CONSTRAINT PK_OrdemServicoClientePessoa PRIMARY KEY (idOrdemServicoClientePessoa);


CREATE TABLE OrdemServicoClientePessoa_Produto (
 idOrdemServicoClientePessoa INT NOT NULL,
 idProduto INT NOT NULL,
 precoProduto FLOAT(10),
 quantidadeProduto INT
);

ALTER TABLE OrdemServicoClientePessoa_Produto ADD CONSTRAINT PK_OrdemServicoClientePessoa_Produto PRIMARY KEY (idOrdemServicoClientePessoa,idProduto);


CREATE TABLE OrdemServicoClientePessoa_Servico (
 idServico INT NOT NULL,
 idOrdemServicoClientePessoa INT NOT NULL,
 precoServico FLOAT(10),
 horasServico FLOAT(10)
);

ALTER TABLE OrdemServicoClientePessoa_Servico ADD CONSTRAINT PK_OrdemServicoClientePessoa_Servico PRIMARY KEY (idServico,idOrdemServicoClientePessoa);


CREATE TABLE OrderServicoClienteEmpresa_Produto (
 idProduto INT NOT NULL,
 idOrdemServicoClientePessoa INT NOT NULL,
 precoProduto FLOAT(10),
 quantidadeProduto FLOAT(10)
);

ALTER TABLE OrderServicoClienteEmpresa_Produto ADD CONSTRAINT PK_OrderServicoClienteEmpresa_Produto PRIMARY KEY (idProduto,idOrdemServicoClientePessoa);


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


ALTER TABLE ClienteEmpresa ADD CONSTRAINT FK_ClienteEmpresa_0 FOREIGN KEY (idEndereco) REFERENCES Endereco (idEndereco);


ALTER TABLE ClienteEmpresa_AtividadeComercial ADD CONSTRAINT FK_ClienteEmpresa_AtividadeComercial_0 FOREIGN KEY (idAtividadeComercial) REFERENCES AtividadeComercial (idAtividadeComercial);
ALTER TABLE ClienteEmpresa_AtividadeComercial ADD CONSTRAINT FK_ClienteEmpresa_AtividadeComercial_1 FOREIGN KEY (idClienteEmpresa) REFERENCES ClienteEmpresa (idClienteEmpresa);


ALTER TABLE ClientePessoa ADD CONSTRAINT FK_ClientePessoa_0 FOREIGN KEY (idSexo) REFERENCES Sexo (idSexo);
ALTER TABLE ClientePessoa ADD CONSTRAINT FK_ClientePessoa_1 FOREIGN KEY (idEndereco) REFERENCES Endereco (idEndereco);
ALTER TABLE ClientePessoa ADD CONSTRAINT FK_ClientePessoa_2 FOREIGN KEY (idOrgaoExpeditor) REFERENCES OrgaoExpeditor (idOrgaoExpeditor);


ALTER TABLE EmailClienteEmpresa ADD CONSTRAINT FK_EmailClienteEmpresa_0 FOREIGN KEY (idClienteEmpresa) REFERENCES ClienteEmpresa (idClienteEmpresa);


ALTER TABLE EmailClientePessoa ADD CONSTRAINT FK_EmailClientePessoa_0 FOREIGN KEY (idClientePessoa) REFERENCES ClientePessoa (idClientePessoa);


ALTER TABLE EmailFuncionario ADD CONSTRAINT FK_EmailFuncionario_0 FOREIGN KEY (idFuncionario) REFERENCES Funcionario (idFuncionario);


ALTER TABLE FoneClienteEmpresa ADD CONSTRAINT FK_FoneClienteEmpresa_0 FOREIGN KEY (idTipoFone) REFERENCES TipoFone (idTipoFone);
ALTER TABLE FoneClienteEmpresa ADD CONSTRAINT FK_FoneClienteEmpresa_1 FOREIGN KEY (idDDD) REFERENCES DDD (idDDD);
ALTER TABLE FoneClienteEmpresa ADD CONSTRAINT FK_FoneClienteEmpresa_2 FOREIGN KEY (idDDI) REFERENCES DDI (idDDI);
ALTER TABLE FoneClienteEmpresa ADD CONSTRAINT FK_FoneClienteEmpresa_3 FOREIGN KEY (idClienteEmpresa) REFERENCES ClienteEmpresa (idClienteEmpresa);


ALTER TABLE FoneClientePessoa ADD CONSTRAINT FK_FoneClientePessoa_0 FOREIGN KEY (idClientePessoa) REFERENCES ClientePessoa (idClientePessoa);
ALTER TABLE FoneClientePessoa ADD CONSTRAINT FK_FoneClientePessoa_1 FOREIGN KEY (idDDI) REFERENCES DDI (idDDI);
ALTER TABLE FoneClientePessoa ADD CONSTRAINT FK_FoneClientePessoa_2 FOREIGN KEY (idDDD) REFERENCES DDD (idDDD);
ALTER TABLE FoneClientePessoa ADD CONSTRAINT FK_FoneClientePessoa_3 FOREIGN KEY (idTipoFone) REFERENCES TipoFone (idTipoFone);


ALTER TABLE FoneFuncionario ADD CONSTRAINT FK_FoneFuncionario_0 FOREIGN KEY (idTipoFone) REFERENCES TipoFone (idTipoFone);
ALTER TABLE FoneFuncionario ADD CONSTRAINT FK_FoneFuncionario_1 FOREIGN KEY (idDDD) REFERENCES DDD (idDDD);
ALTER TABLE FoneFuncionario ADD CONSTRAINT FK_FoneFuncionario_2 FOREIGN KEY (idDDI) REFERENCES DDI (idDDI);
ALTER TABLE FoneFuncionario ADD CONSTRAINT FK_FoneFuncionario_3 FOREIGN KEY (idFuncionario) REFERENCES Funcionario (idFuncionario);


ALTER TABLE VeiculoClienteEmpresa ADD CONSTRAINT FK_VeiculoClienteEmpresa_0 FOREIGN KEY (idClienteEmpresa) REFERENCES ClienteEmpresa (idClienteEmpresa);


ALTER TABLE VeiculoClientePessoa ADD CONSTRAINT FK_VeiculoClientePessoa_0 FOREIGN KEY (idClientePessoa) REFERENCES ClientePessoa (idClientePessoa);


ALTER TABLE OrdemServicoClienteEmpresa ADD CONSTRAINT FK_OrdemServicoClienteEmpresa_0 FOREIGN KEY (idEtapa) REFERENCES Etapa (idEtapa);
ALTER TABLE OrdemServicoClienteEmpresa ADD CONSTRAINT FK_OrdemServicoClienteEmpresa_1 FOREIGN KEY (idVeiculoClientePessoa) REFERENCES VeiculoClienteEmpresa (idVeiculoClientePessoa);
ALTER TABLE OrdemServicoClienteEmpresa ADD CONSTRAINT FK_OrdemServicoClienteEmpresa_2 FOREIGN KEY (idFuncionario) REFERENCES Funcionario (idFuncionario);


ALTER TABLE OrdemServicoClienteEmpresa_Servico ADD CONSTRAINT FK_OrdemServicoClienteEmpresa_Servico_0 FOREIGN KEY (idServico) REFERENCES Servico (idServico);
ALTER TABLE OrdemServicoClienteEmpresa_Servico ADD CONSTRAINT FK_OrdemServicoClienteEmpresa_Servico_1 FOREIGN KEY (idOrdemServicoClientePessoa) REFERENCES OrdemServicoClienteEmpresa (idOrdemServicoClientePessoa);


ALTER TABLE OrdemServicoClientePessoa ADD CONSTRAINT FK_OrdemServicoClientePessoa_0 FOREIGN KEY (idEtapa) REFERENCES Etapa (idEtapa);
ALTER TABLE OrdemServicoClientePessoa ADD CONSTRAINT FK_OrdemServicoClientePessoa_1 FOREIGN KEY (idVeiculoClientePessoa) REFERENCES VeiculoClientePessoa (idVeiculoClientePessoa);
ALTER TABLE OrdemServicoClientePessoa ADD CONSTRAINT FK_OrdemServicoClientePessoa_2 FOREIGN KEY (idFuncionario) REFERENCES Funcionario (idFuncionario);


ALTER TABLE OrdemServicoClientePessoa_Produto ADD CONSTRAINT FK_OrdemServicoClientePessoa_Produto_0 FOREIGN KEY (idOrdemServicoClientePessoa) REFERENCES OrdemServicoClientePessoa (idOrdemServicoClientePessoa);
ALTER TABLE OrdemServicoClientePessoa_Produto ADD CONSTRAINT FK_OrdemServicoClientePessoa_Produto_1 FOREIGN KEY (idProduto) REFERENCES Produto (idProduto);


ALTER TABLE OrdemServicoClientePessoa_Servico ADD CONSTRAINT FK_OrdemServicoClientePessoa_Servico_0 FOREIGN KEY (idServico) REFERENCES Servico (idServico);
ALTER TABLE OrdemServicoClientePessoa_Servico ADD CONSTRAINT FK_OrdemServicoClientePessoa_Servico_1 FOREIGN KEY (idOrdemServicoClientePessoa) REFERENCES OrdemServicoClientePessoa (idOrdemServicoClientePessoa);


ALTER TABLE OrderServicoClienteEmpresa_Produto ADD CONSTRAINT FK_OrderServicoClienteEmpresa_Produto_0 FOREIGN KEY (idProduto) REFERENCES Produto (idProduto);
ALTER TABLE OrderServicoClienteEmpresa_Produto ADD CONSTRAINT FK_OrderServicoClienteEmpresa_Produto_1 FOREIGN KEY (idOrdemServicoClientePessoa) REFERENCES OrdemServicoClienteEmpresa (idOrdemServicoClientePessoa);


