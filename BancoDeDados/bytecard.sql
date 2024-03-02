CREATE DATABASE  IF NOT EXISTS `bytecard` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bytecard`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: bytecard
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `cartao`
--

DROP TABLE IF EXISTS `cartao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cartao` (
  `Numero_cartao` bigint NOT NULL AUTO_INCREMENT,
  `Validade` date DEFAULT NULL,
  `CVV` int DEFAULT NULL,
  `Limite` decimal(10,2) DEFAULT NULL,
  `statuos` tinyint(1) DEFAULT NULL,
  `Cliente_Cpf` bigint NOT NULL,
  PRIMARY KEY (`Numero_cartao`),
  KEY `Cliente_Cpf` (`Cliente_Cpf`),
  CONSTRAINT `cartao_ibfk_1` FOREIGN KEY (`Cliente_Cpf`) REFERENCES `cliente` (`Cpf`)
) ENGINE=InnoDB AUTO_INCREMENT=235 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cartao`
--

LOCK TABLES `cartao` WRITE;
/*!40000 ALTER TABLE `cartao` DISABLE KEYS */;
INSERT INTO `cartao` VALUES (123,'2024-11-25',258,100.00,1,238),(234,'2024-11-25',258,100.00,1,238);
/*!40000 ALTER TABLE `cartao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `Cpf` bigint NOT NULL AUTO_INCREMENT,
  `Nome` varchar(255) NOT NULL,
  `Email` varchar(100) DEFAULT NULL,
  `Telefone` bigint DEFAULT NULL,
  PRIMARY KEY (`Cpf`)
) ENGINE=InnoDB AUTO_INCREMENT=239 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (238,'RAFAEL','RAFAEL@',12345);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compra`
--

DROP TABLE IF EXISTS `compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compra` (
  `ID_Compra` bigint NOT NULL AUTO_INCREMENT,
  `valor` decimal(10,2) DEFAULT NULL,
  `data_compra` datetime DEFAULT NULL,
  `estabelecimento` varchar(255) DEFAULT NULL,
  `categoria` varchar(100) DEFAULT NULL,
  `Numero_cartao` bigint NOT NULL,
  `Client_cpf` bigint NOT NULL,
  PRIMARY KEY (`ID_Compra`),
  KEY `Numero_cartao` (`Numero_cartao`),
  KEY `Client_cpf` (`Client_cpf`),
  CONSTRAINT `compra_ibfk_1` FOREIGN KEY (`Numero_cartao`) REFERENCES `cartao` (`Numero_cartao`),
  CONSTRAINT `compra_ibfk_2` FOREIGN KEY (`Client_cpf`) REFERENCES `cliente` (`Cpf`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compra`
--

LOCK TABLES `compra` WRITE;
/*!40000 ALTER TABLE `compra` DISABLE KEYS */;
INSERT INTO `compra` VALUES (1,2345.00,'2024-11-23 12:05:55','amarelinho','alimentação',123,238),(2,2345.00,'2024-11-23 12:05:55','amarelinho','alimentação',123,238),(3,2345.00,'2024-11-23 12:05:55','amarelinho','alimentação',123,238),(4,2345.00,'2024-11-23 12:05:55','amarelinho','alimentação',123,238),(5,2345.00,'2024-11-23 12:05:55','amarelinho','alimentação',123,238),(6,2345.00,'2024-11-23 12:05:55','amarelinho','alimentação',123,238),(7,2345.00,'2024-11-23 12:05:55','amarelinho','alimentação',123,238),(8,2345.00,'2024-11-23 12:05:55','amarelinho','alimentação',123,238),(9,2345.00,'2024-11-23 12:05:55','amarelinho','alimentação',123,238),(10,2345.00,'2024-11-23 12:05:55','amarelinho','alimentação',123,238),(11,2345.00,'2024-11-23 12:05:55','amarelinho','alimentação',123,238),(12,2345.00,'2024-11-23 12:05:55','amarelinho','alimentação',123,238),(13,2345.00,'2024-11-23 12:05:55','amarelinho','alimentação',123,238),(14,2345.00,'2024-11-23 12:05:55','amarelinho','alimentação',234,238);
/*!40000 ALTER TABLE `compra` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-01 21:13:23
