-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: eroge
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `jugador`
--

DROP TABLE IF EXISTS `jugador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jugador` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  `edad` int NOT NULL,
  `personalidad` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jugador`
--

LOCK TABLES `jugador` WRITE;
/*!40000 ALTER TABLE `jugador` DISABLE KEYS */;
INSERT INTO `jugador` VALUES (1,'mo',23,'gatos'),(2,'m',3,'w'),(3,'irene',22,'pollera'),(4,'f',4,'r'),(5,'t',3,'r'),(6,'e',3,'e'),(7,'m',7,'h'),(8,'w',3,'e'),(9,'e',3,'e'),(10,'f',4,'g'),(11,'d',3,'q'),(12,'h',5,'e'),(13,'v',4,'f'),(14,'f',5,'w'),(15,'h',6,'3'),(16,'g',4,'t'),(17,'b',6,'f'),(18,'a',4,'r'),(19,'g',8,'e'),(20,'df',4,'r'),(21,'ds',3,'w'),(22,'NEPE',22,'extrovertida'),(23,'r',5,'t'),(24,',m',8,'n'),(25,'moi',9,'j'),(26,'KM',7,'H'),(27,'hgsd',3,'r'),(28,'uyt',6,'ges'),(29,'dfg',8,'yuyj'),(30,'fghjk',5,'ghgj'),(31,'tr',6,'hg'),(32,'uytr',5,'ytr'),(33,'gfd',4,'gd'),(34,'ghfd',765,'iujyhtdg'),(35,'tgfd',65,'ytr'),(36,'yt',6,'tr'),(37,'ñlkjgh',7,'yt'),(38,'UJYHR',6,'KUJY'),(39,'jty',67,'ty'),(40,'hg',76,'yhf'),(41,'hg',76,'yhf'),(42,'YNH',6,'r'),(43,'8uj',7,'yhrt'),(44,'756ew',8,'536'),(45,'jh',6,'gf'),(46,'hj',6,'gh'),(47,'kjh',6,'tyrt'),(48,'ujyr',76,'tyr'),(49,'gt',67,'yh'),(50,'ty',675,'yt'),(51,'t',67,'tu'),(52,'xff',65,'r'),(53,'kjf',76,'gk'),(54,'ru',75,'ur'),(55,'tu',7,'j'),(56,'hy',67,'y'),(57,'yu',76,'uy');
/*!40000 ALTER TABLE `jugador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jugador_personaje`
--

DROP TABLE IF EXISTS `jugador_personaje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jugador_personaje` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idJugador` int NOT NULL,
  `idPersonaje` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idPersonaje` (`idPersonaje`),
  KEY `idJugador` (`idJugador`),
  CONSTRAINT `jugador_personaje_ibfk_1` FOREIGN KEY (`idJugador`) REFERENCES `jugador` (`id`),
  CONSTRAINT `jugador_personaje_ibfk_2` FOREIGN KEY (`idPersonaje`) REFERENCES `personaje` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jugador_personaje`
--

LOCK TABLES `jugador_personaje` WRITE;
/*!40000 ALTER TABLE `jugador_personaje` DISABLE KEYS */;
INSERT INTO `jugador_personaje` VALUES (3,46,9),(4,55,8);
/*!40000 ALTER TABLE `jugador_personaje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personaje`
--

DROP TABLE IF EXISTS `personaje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personaje` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  `edad` int NOT NULL,
  `personalidad` varchar(255) NOT NULL,
  `nivelAmor` int NOT NULL,
  `nivel` int NOT NULL,
  `tipoPersonaje` varchar(255) NOT NULL,
  `poliamoroso` tinyint(1) NOT NULL,
  `gustos` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personaje`
--

LOCK TABLES `personaje` WRITE;
/*!40000 ALTER TABLE `personaje` DISABLE KEYS */;
INSERT INTO `personaje` VALUES (8,'Tommy Rabo',25,'Cerveza',50,1,'Monstruo',0,'Sushi, Cosplay'),(9,'Aann Abocheiras',40,'Limpieza',50,1,'Robot',0,'Playa, Cine');
/*!40000 ALTER TABLE `personaje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tema_de_conversacion`
--

DROP TABLE IF EXISTS `tema_de_conversacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tema_de_conversacion` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tema` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tema_de_conversacion`
--

LOCK TABLES `tema_de_conversacion` WRITE;
/*!40000 ALTER TABLE `tema_de_conversacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `tema_de_conversacion` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-30 11:17:05
