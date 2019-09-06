-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `atividadecomercial`
--

DROP TABLE IF EXISTS `atividadecomercial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `atividadecomercial` (
  `idAtividadeComercial` int(11) NOT NULL AUTO_INCREMENT,
  `descricaoAtividadeComercial` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`idAtividadeComercial`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atividadecomercial`
--

LOCK TABLES `atividadecomercial` WRITE;
/*!40000 ALTER TABLE `atividadecomercial` DISABLE KEYS */;
INSERT INTO `atividadecomercial` VALUES (1,'Comercio'),(2,'Suporte');
/*!40000 ALTER TABLE `atividadecomercial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `atividadecomercial_cliente`
--

DROP TABLE IF EXISTS `atividadecomercial_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `atividadecomercial_cliente` (
  `idAtividadeComercial` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  PRIMARY KEY (`idAtividadeComercial`,`idCliente`),
  KEY `FK_AtividadeComercial_Cliente_1` (`idCliente`),
  CONSTRAINT `FK_AtividadeComercial_Cliente_0` FOREIGN KEY (`idAtividadeComercial`) REFERENCES `atividadecomercial` (`idAtividadeComercial`),
  CONSTRAINT `FK_AtividadeComercial_Cliente_1` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atividadecomercial_cliente`
--

LOCK TABLES `atividadecomercial_cliente` WRITE;
/*!40000 ALTER TABLE `atividadecomercial_cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `atividadecomercial_cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bairro`
--

DROP TABLE IF EXISTS `bairro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bairro` (
  `idBairro` int(11) NOT NULL AUTO_INCREMENT,
  `nomeBairro` varchar(50) NOT NULL,
  PRIMARY KEY (`idBairro`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bairro`
--

LOCK TABLES `bairro` WRITE;
/*!40000 ALTER TABLE `bairro` DISABLE KEYS */;
INSERT INTO `bairro` VALUES (1,'Centro'),(2,'Vila A'),(3,'Vila B'),(4,'Vila C');
/*!40000 ALTER TABLE `bairro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cidade`
--

DROP TABLE IF EXISTS `cidade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cidade` (
  `idCidade` int(11) NOT NULL AUTO_INCREMENT,
  `nomeCidade` varchar(50) NOT NULL,
  `idUF` int(11) DEFAULT NULL,
  PRIMARY KEY (`idCidade`),
  KEY `FK_Cidade_0` (`idUF`),
  CONSTRAINT `FK_Cidade_0` FOREIGN KEY (`idUF`) REFERENCES `uf` (`idUF`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cidade`
--

LOCK TABLES `cidade` WRITE;
/*!40000 ALTER TABLE `cidade` DISABLE KEYS */;
INSERT INTO `cidade` VALUES (1,'Curitiba',1),(2,'Londrina',1),(3,'Medianeira',1),(4,'Sao Paulo',2);
/*!40000 ALTER TABLE `cidade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL AUTO_INCREMENT,
  `primeiroNomeCliente` varchar(50) NOT NULL,
  `nomeMeioCliente` varchar(50) DEFAULT NULL,
  `ultimoNomeCliente` varchar(50) DEFAULT NULL,
  `nomeAbreviadoCliente` varchar(50) DEFAULT NULL,
  `cpf` varchar(50) DEFAULT NULL,
  `cnpj` varchar(50) DEFAULT NULL,
  `idSexo` int(11) DEFAULT NULL,
  `numero` int(11) NOT NULL,
  `complemento` varchar(50) DEFAULT NULL,
  `idEndereco` int(11) DEFAULT NULL,
  `numeroDoc` varchar(50) DEFAULT NULL,
  `dataExpedicao` date DEFAULT NULL,
  `idOrgaoExpeditor` int(11) DEFAULT NULL,
  `caminhoFoto` varchar(50) DEFAULT NULL,
  `descricaoFoto` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idCliente`),
  KEY `FK_Cliente_0` (`idSexo`),
  KEY `FK_Cliente_1` (`idEndereco`),
  KEY `FK_Cliente_2` (`idOrgaoExpeditor`),
  CONSTRAINT `FK_Cliente_0` FOREIGN KEY (`idSexo`) REFERENCES `sexo` (`idSexo`),
  CONSTRAINT `FK_Cliente_1` FOREIGN KEY (`idEndereco`) REFERENCES `endereco` (`idEndereco`),
  CONSTRAINT `FK_Cliente_2` FOREIGN KEY (`idOrgaoExpeditor`) REFERENCES `orgaoexpeditor` (`idOrgaoExpeditor`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Tiago','Lopes','Pereira','Tiago V L Pereira','09722879901',NULL,1,23,'null',2,'97667450','1997-07-03',1,'C:/Users/Tiago/Fotos/foto.jpg','Arvores');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ddd`
--

DROP TABLE IF EXISTS `ddd`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ddd` (
  `idDDD` int(11) NOT NULL AUTO_INCREMENT,
  `numeroDDD` int(11) NOT NULL,
  PRIMARY KEY (`idDDD`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ddd`
--

LOCK TABLES `ddd` WRITE;
/*!40000 ALTER TABLE `ddd` DISABLE KEYS */;
INSERT INTO `ddd` VALUES (1,45);
/*!40000 ALTER TABLE `ddd` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ddi`
--

DROP TABLE IF EXISTS `ddi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ddi` (
  `idDDI` int(11) NOT NULL AUTO_INCREMENT,
  `numeroDDI` int(11) NOT NULL,
  PRIMARY KEY (`idDDI`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ddi`
--

LOCK TABLES `ddi` WRITE;
/*!40000 ALTER TABLE `ddi` DISABLE KEYS */;
INSERT INTO `ddi` VALUES (1,55);
/*!40000 ALTER TABLE `ddi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emailcliente`
--

DROP TABLE IF EXISTS `emailcliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emailcliente` (
  `idEmailCliente` int(11) NOT NULL AUTO_INCREMENT,
  `descricaoEmail` varchar(50) NOT NULL,
  `idCliente` int(11) DEFAULT NULL,
  PRIMARY KEY (`idEmailCliente`),
  KEY `FK_EmailCliente_0` (`idCliente`),
  CONSTRAINT `FK_EmailCliente_0` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emailcliente`
--

LOCK TABLES `emailcliente` WRITE;
/*!40000 ALTER TABLE `emailcliente` DISABLE KEYS */;
INSERT INTO `emailcliente` VALUES (1,'tiago.foz@hotmail.com',1);
/*!40000 ALTER TABLE `emailcliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emailfuncionario`
--

DROP TABLE IF EXISTS `emailfuncionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emailfuncionario` (
  `idEmailFuncionario` int(11) NOT NULL AUTO_INCREMENT,
  `descricaoEmail` varchar(50) NOT NULL,
  `idFuncionario` int(11) DEFAULT NULL,
  PRIMARY KEY (`idEmailFuncionario`),
  KEY `FK_EmailFuncionario_0` (`idFuncionario`),
  CONSTRAINT `FK_EmailFuncionario_0` FOREIGN KEY (`idFuncionario`) REFERENCES `funcionario` (`idFuncionario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emailfuncionario`
--

LOCK TABLES `emailfuncionario` WRITE;
/*!40000 ALTER TABLE `emailfuncionario` DISABLE KEYS */;
/*!40000 ALTER TABLE `emailfuncionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `endereco`
--

DROP TABLE IF EXISTS `endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `endereco` (
  `idEndereco` int(11) NOT NULL AUTO_INCREMENT,
  `cep` varchar(50) NOT NULL,
  `idBairro` int(11) DEFAULT NULL,
  `idCidade` int(11) DEFAULT NULL,
  `idLogradouro` int(11) DEFAULT NULL,
  PRIMARY KEY (`idEndereco`),
  KEY `FK_Endereco_0` (`idBairro`),
  KEY `FK_Endereco_1` (`idCidade`),
  KEY `FK_Endereco_2` (`idLogradouro`),
  CONSTRAINT `FK_Endereco_0` FOREIGN KEY (`idBairro`) REFERENCES `bairro` (`idBairro`),
  CONSTRAINT `FK_Endereco_1` FOREIGN KEY (`idCidade`) REFERENCES `cidade` (`idCidade`),
  CONSTRAINT `FK_Endereco_2` FOREIGN KEY (`idLogradouro`) REFERENCES `logradouro` (`idLogradouro`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `endereco`
--

LOCK TABLES `endereco` WRITE;
/*!40000 ALTER TABLE `endereco` DISABLE KEYS */;
INSERT INTO `endereco` VALUES (1,'85867530',1,1,1),(2,'85867500',1,1,1);
/*!40000 ALTER TABLE `endereco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `etapa`
--

DROP TABLE IF EXISTS `etapa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `etapa` (
  `idEtapa` int(11) NOT NULL AUTO_INCREMENT,
  `descricaoEtapa` varchar(50) NOT NULL,
  PRIMARY KEY (`idEtapa`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `etapa`
--

LOCK TABLES `etapa` WRITE;
/*!40000 ALTER TABLE `etapa` DISABLE KEYS */;
INSERT INTO `etapa` VALUES (1,'Inicio'),(2,'Executando'),(3,'Finalizado');
/*!40000 ALTER TABLE `etapa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fonecliente`
--

DROP TABLE IF EXISTS `fonecliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fonecliente` (
  `idFoneCliente` int(11) NOT NULL AUTO_INCREMENT,
  `numeroFone` varchar(50) NOT NULL,
  `idCliente` int(11) DEFAULT NULL,
  `idDDI` int(11) DEFAULT NULL,
  `idDDD` int(11) DEFAULT NULL,
  `idTipoFone` int(11) DEFAULT NULL,
  PRIMARY KEY (`idFoneCliente`),
  KEY `FK_FoneCliente_0` (`idCliente`),
  KEY `FK_FoneCliente_1` (`idDDI`),
  KEY `FK_FoneCliente_2` (`idDDD`),
  KEY `FK_FoneCliente_3` (`idTipoFone`),
  CONSTRAINT `FK_FoneCliente_0` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`),
  CONSTRAINT `FK_FoneCliente_1` FOREIGN KEY (`idDDI`) REFERENCES `ddi` (`idDDI`),
  CONSTRAINT `FK_FoneCliente_2` FOREIGN KEY (`idDDD`) REFERENCES `ddd` (`idDDD`),
  CONSTRAINT `FK_FoneCliente_3` FOREIGN KEY (`idTipoFone`) REFERENCES `tipofone` (`idTipoFone`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fonecliente`
--

LOCK TABLES `fonecliente` WRITE;
/*!40000 ALTER TABLE `fonecliente` DISABLE KEYS */;
INSERT INTO `fonecliente` VALUES (1,'99940308',1,1,1,1);
/*!40000 ALTER TABLE `fonecliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fonefuncionario`
--

DROP TABLE IF EXISTS `fonefuncionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fonefuncionario` (
  `idFoneFuncionario` int(11) NOT NULL AUTO_INCREMENT,
  `numeroFone` varchar(50) NOT NULL,
  `idTipoFone` int(11) DEFAULT NULL,
  `idDDD` int(11) DEFAULT NULL,
  `idDDI` int(11) DEFAULT NULL,
  `idFuncionario` int(11) DEFAULT NULL,
  PRIMARY KEY (`idFoneFuncionario`),
  KEY `FK_FoneFuncionario_0` (`idTipoFone`),
  KEY `FK_FoneFuncionario_1` (`idDDD`),
  KEY `FK_FoneFuncionario_2` (`idDDI`),
  KEY `FK_FoneFuncionario_3` (`idFuncionario`),
  CONSTRAINT `FK_FoneFuncionario_0` FOREIGN KEY (`idTipoFone`) REFERENCES `tipofone` (`idTipoFone`),
  CONSTRAINT `FK_FoneFuncionario_1` FOREIGN KEY (`idDDD`) REFERENCES `ddd` (`idDDD`),
  CONSTRAINT `FK_FoneFuncionario_2` FOREIGN KEY (`idDDI`) REFERENCES `ddi` (`idDDI`),
  CONSTRAINT `FK_FoneFuncionario_3` FOREIGN KEY (`idFuncionario`) REFERENCES `funcionario` (`idFuncionario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fonefuncionario`
--

LOCK TABLES `fonefuncionario` WRITE;
/*!40000 ALTER TABLE `fonefuncionario` DISABLE KEYS */;
/*!40000 ALTER TABLE `fonefuncionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funcionario` (
  `idFuncionario` int(11) NOT NULL AUTO_INCREMENT,
  `primeiroNomeFuncionario` varchar(50) NOT NULL,
  `nomeMeioFuncionario` varchar(50) DEFAULT NULL,
  `ultimoNomeFuncionario` varchar(50) DEFAULT NULL,
  `nomeAbreviadoPessoa` varchar(50) DEFAULT NULL,
  `cpf` varchar(50) DEFAULT NULL,
  `idSexo` int(11) DEFAULT NULL,
  `numero` int(11) NOT NULL,
  `complemento` varchar(50) DEFAULT NULL,
  `idEndereco` int(11) DEFAULT NULL,
  `numeroDoc` varchar(50) DEFAULT NULL,
  `dataExpedicao` date DEFAULT NULL,
  `idOrgaoExpeditor` int(11) DEFAULT NULL,
  `caminhoFoto` varchar(50) DEFAULT NULL,
  `descricaoFoto` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idFuncionario`),
  KEY `FK_Funcionario_0` (`idSexo`),
  KEY `FK_Funcionario_1` (`idEndereco`),
  KEY `FK_Funcionario_2` (`idOrgaoExpeditor`),
  CONSTRAINT `FK_Funcionario_0` FOREIGN KEY (`idSexo`) REFERENCES `sexo` (`idSexo`),
  CONSTRAINT `FK_Funcionario_1` FOREIGN KEY (`idEndereco`) REFERENCES `endereco` (`idEndereco`),
  CONSTRAINT `FK_Funcionario_2` FOREIGN KEY (`idOrgaoExpeditor`) REFERENCES `orgaoexpeditor` (`idOrgaoExpeditor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `logradouro`
--

DROP TABLE IF EXISTS `logradouro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `logradouro` (
  `idLogradouro` int(11) NOT NULL AUTO_INCREMENT,
  `nomeLogradouro` varchar(50) NOT NULL,
  `idTipoLogradouro` int(11) DEFAULT NULL,
  PRIMARY KEY (`idLogradouro`),
  KEY `FK_Logradouro_0` (`idTipoLogradouro`),
  CONSTRAINT `FK_Logradouro_0` FOREIGN KEY (`idTipoLogradouro`) REFERENCES `tipologradouro` (`idTipoLogradouro`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `logradouro`
--

LOCK TABLES `logradouro` WRITE;
/*!40000 ALTER TABLE `logradouro` DISABLE KEYS */;
INSERT INTO `logradouro` VALUES (1,'Vitorino',1),(2,'Brasil',2);
/*!40000 ALTER TABLE `logradouro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordemservico`
--

DROP TABLE IF EXISTS `ordemservico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ordemservico` (
  `idOrdemServico` int(11) NOT NULL AUTO_INCREMENT,
  `data` date NOT NULL,
  `observacoes` varchar(50) DEFAULT NULL,
  `idEtapa` int(11) DEFAULT NULL,
  `idVeiculo` int(11) DEFAULT NULL,
  `idFuncionario` int(11) DEFAULT NULL,
  PRIMARY KEY (`idOrdemServico`),
  KEY `FK_OrdemServico_0` (`idEtapa`),
  KEY `FK_OrdemServico_1` (`idVeiculo`),
  KEY `FK_OrdemServico_2` (`idFuncionario`),
  CONSTRAINT `FK_OrdemServico_0` FOREIGN KEY (`idEtapa`) REFERENCES `etapa` (`idEtapa`),
  CONSTRAINT `FK_OrdemServico_1` FOREIGN KEY (`idVeiculo`) REFERENCES `veiculo` (`idVeiculo`),
  CONSTRAINT `FK_OrdemServico_2` FOREIGN KEY (`idFuncionario`) REFERENCES `funcionario` (`idFuncionario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordemservico`
--

LOCK TABLES `ordemservico` WRITE;
/*!40000 ALTER TABLE `ordemservico` DISABLE KEYS */;
/*!40000 ALTER TABLE `ordemservico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordemservico_produto`
--

DROP TABLE IF EXISTS `ordemservico_produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ordemservico_produto` (
  `idOrdemServico` int(11) NOT NULL,
  `idProduto` int(11) NOT NULL,
  `precoProduto` float DEFAULT NULL,
  `quantidadeProduto` int(11) DEFAULT NULL,
  PRIMARY KEY (`idOrdemServico`,`idProduto`),
  KEY `FK_OrdemServico_Produto_1` (`idProduto`),
  CONSTRAINT `FK_OrdemServico_Produto_0` FOREIGN KEY (`idOrdemServico`) REFERENCES `ordemservico` (`idOrdemServico`),
  CONSTRAINT `FK_OrdemServico_Produto_1` FOREIGN KEY (`idProduto`) REFERENCES `produto` (`idProduto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordemservico_produto`
--

LOCK TABLES `ordemservico_produto` WRITE;
/*!40000 ALTER TABLE `ordemservico_produto` DISABLE KEYS */;
/*!40000 ALTER TABLE `ordemservico_produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordemservico_servico`
--

DROP TABLE IF EXISTS `ordemservico_servico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ordemservico_servico` (
  `idServico` int(11) NOT NULL,
  `idOrdemServico` int(11) NOT NULL,
  `precoServico` float DEFAULT NULL,
  `horasServico` float DEFAULT NULL,
  PRIMARY KEY (`idServico`,`idOrdemServico`),
  KEY `FK_OrdemServico_Servico_1` (`idOrdemServico`),
  CONSTRAINT `FK_OrdemServico_Servico_0` FOREIGN KEY (`idServico`) REFERENCES `servico` (`idServico`),
  CONSTRAINT `FK_OrdemServico_Servico_1` FOREIGN KEY (`idOrdemServico`) REFERENCES `ordemservico` (`idOrdemServico`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordemservico_servico`
--

LOCK TABLES `ordemservico_servico` WRITE;
/*!40000 ALTER TABLE `ordemservico_servico` DISABLE KEYS */;
/*!40000 ALTER TABLE `ordemservico_servico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orgaoexpeditor`
--

DROP TABLE IF EXISTS `orgaoexpeditor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orgaoexpeditor` (
  `idOrgaoExpeditor` int(11) NOT NULL AUTO_INCREMENT,
  `nomeOrgaoExpeditor` varchar(50) NOT NULL,
  `idUF` int(11) DEFAULT NULL,
  PRIMARY KEY (`idOrgaoExpeditor`),
  KEY `FK_OrgaoExpeditor_0` (`idUF`),
  CONSTRAINT `FK_OrgaoExpeditor_0` FOREIGN KEY (`idUF`) REFERENCES `uf` (`idUF`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orgaoexpeditor`
--

LOCK TABLES `orgaoexpeditor` WRITE;
/*!40000 ALTER TABLE `orgaoexpeditor` DISABLE KEYS */;
INSERT INTO `orgaoexpeditor` VALUES (1,'SSP',1);
/*!40000 ALTER TABLE `orgaoexpeditor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pais`
--

DROP TABLE IF EXISTS `pais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pais` (
  `idPais` int(11) NOT NULL AUTO_INCREMENT,
  `nomePais` varchar(50) NOT NULL,
  PRIMARY KEY (`idPais`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pais`
--

LOCK TABLES `pais` WRITE;
/*!40000 ALTER TABLE `pais` DISABLE KEYS */;
INSERT INTO `pais` VALUES (1,'Brasil'),(2,'Argentina'),(3,'Canada'),(4,'Irlanda');
/*!40000 ALTER TABLE `pais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produto`
--

DROP TABLE IF EXISTS `produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produto` (
  `idProduto` int(11) NOT NULL AUTO_INCREMENT,
  `nomeProduto` varchar(50) DEFAULT NULL,
  `precoBaseProduto` float DEFAULT NULL,
  PRIMARY KEY (`idProduto`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto`
--

LOCK TABLES `produto` WRITE;
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
INSERT INTO `produto` VALUES (1,'Pneu',80),(2,'Oleo',50);
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servico`
--

DROP TABLE IF EXISTS `servico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `servico` (
  `idServico` int(11) NOT NULL AUTO_INCREMENT,
  `precoBaseServico` float DEFAULT NULL,
  `nomeServico` varchar(50) DEFAULT NULL,
  `horasBaseServico` float DEFAULT NULL,
  PRIMARY KEY (`idServico`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servico`
--

LOCK TABLES `servico` WRITE;
/*!40000 ALTER TABLE `servico` DISABLE KEYS */;
INSERT INTO `servico` VALUES (1,20,'Troca Pneu',0.5),(2,35,'Troca Oleo',1);
/*!40000 ALTER TABLE `servico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sexo`
--

DROP TABLE IF EXISTS `sexo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sexo` (
  `idSexo` int(11) NOT NULL AUTO_INCREMENT,
  `descricaoSexo` varchar(50) NOT NULL,
  `siglaSexo` varchar(50) NOT NULL,
  PRIMARY KEY (`idSexo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sexo`
--

LOCK TABLES `sexo` WRITE;
/*!40000 ALTER TABLE `sexo` DISABLE KEYS */;
INSERT INTO `sexo` VALUES (1,'Masculino','M'),(2,'Feminino','F');
/*!40000 ALTER TABLE `sexo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipofone`
--

DROP TABLE IF EXISTS `tipofone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipofone` (
  `idTipoFone` int(11) NOT NULL AUTO_INCREMENT,
  `siglaTipoFone` varchar(50) NOT NULL,
  `descricaoTipoFone` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idTipoFone`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipofone`
--

LOCK TABLES `tipofone` WRITE;
/*!40000 ALTER TABLE `tipofone` DISABLE KEYS */;
INSERT INTO `tipofone` VALUES (1,'Cel','Celular');
/*!40000 ALTER TABLE `tipofone` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipologradouro`
--

DROP TABLE IF EXISTS `tipologradouro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipologradouro` (
  `idTipoLogradouro` int(11) NOT NULL AUTO_INCREMENT,
  `siglaTipo` varchar(50) DEFAULT NULL,
  `nomeTIpo` varchar(50) NOT NULL,
  PRIMARY KEY (`idTipoLogradouro`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipologradouro`
--

LOCK TABLES `tipologradouro` WRITE;
/*!40000 ALTER TABLE `tipologradouro` DISABLE KEYS */;
INSERT INTO `tipologradouro` VALUES (1,'RUA','rua'),(2,'AV','avenida');
/*!40000 ALTER TABLE `tipologradouro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uf`
--

DROP TABLE IF EXISTS `uf`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `uf` (
  `idUF` int(11) NOT NULL AUTO_INCREMENT,
  `siglaUF` varchar(50) DEFAULT NULL,
  `nomeUF` varchar(50) NOT NULL,
  `idPais` int(11) DEFAULT NULL,
  PRIMARY KEY (`idUF`),
  KEY `FK_UF_0` (`idPais`),
  CONSTRAINT `FK_UF_0` FOREIGN KEY (`idPais`) REFERENCES `pais` (`idPais`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uf`
--

LOCK TABLES `uf` WRITE;
/*!40000 ALTER TABLE `uf` DISABLE KEYS */;
INSERT INTO `uf` VALUES (1,'PR','Parana',1),(2,'SP','Sao Paulo',1);
/*!40000 ALTER TABLE `uf` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `veiculo`
--

DROP TABLE IF EXISTS `veiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `veiculo` (
  `idVeiculo` int(11) NOT NULL AUTO_INCREMENT,
  `nomeVeiculo` varchar(50) NOT NULL,
  `marcaVeiculo` varchar(50) NOT NULL,
  `modeloVeiculo` varchar(50) DEFAULT NULL,
  `kmVeiculo` int(11) NOT NULL,
  `placaVeiculo` varchar(50) DEFAULT NULL,
  `idCliente` int(11) DEFAULT NULL,
  PRIMARY KEY (`idVeiculo`),
  KEY `FK_Veiculo_0` (`idCliente`),
  CONSTRAINT `FK_Veiculo_0` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `veiculo`
--

LOCK TABLES `veiculo` WRITE;
/*!40000 ALTER TABLE `veiculo` DISABLE KEYS */;
/*!40000 ALTER TABLE `veiculo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-05 23:42:05
