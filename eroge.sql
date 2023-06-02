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
) ENGINE=InnoDB AUTO_INCREMENT=192 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jugador`
--

LOCK TABLES `jugador` WRITE;
/*!40000 ALTER TABLE `jugador` DISABLE KEYS */;
INSERT INTO `jugador` VALUES (1,'mo',23,'gatos'),(2,'m',3,'w'),(3,'irene',22,'pollera'),(4,'f',4,'r'),(5,'t',3,'r'),(6,'e',3,'e'),(7,'m',7,'h'),(8,'w',3,'e'),(9,'e',3,'e'),(10,'f',4,'g'),(11,'d',3,'q'),(12,'h',5,'e'),(13,'v',4,'f'),(14,'f',5,'w'),(15,'h',6,'3'),(16,'g',4,'t'),(17,'b',6,'f'),(18,'a',4,'r'),(19,'g',8,'e'),(20,'df',4,'r'),(21,'ds',3,'w'),(22,'NEPE',22,'extrovertida'),(23,'r',5,'t'),(24,',m',8,'n'),(25,'moi',9,'j'),(26,'KM',7,'H'),(27,'hgsd',3,'r'),(28,'uyt',6,'ges'),(29,'dfg',8,'yuyj'),(30,'fghjk',5,'ghgj'),(31,'tr',6,'hg'),(32,'uytr',5,'ytr'),(33,'gfd',4,'gd'),(34,'ghfd',765,'iujyhtdg'),(35,'tgfd',65,'ytr'),(36,'yt',6,'tr'),(37,'ñlkjgh',7,'yt'),(38,'UJYHR',6,'KUJY'),(39,'jty',67,'ty'),(40,'hg',76,'yhf'),(41,'hg',76,'yhf'),(42,'YNH',6,'r'),(43,'8uj',7,'yhrt'),(44,'756ew',8,'536'),(45,'jh',6,'gf'),(46,'hj',6,'gh'),(47,'kjh',6,'tyrt'),(48,'ujyr',76,'tyr'),(49,'gt',67,'yh'),(50,'ty',675,'yt'),(51,'t',67,'tu'),(52,'xff',65,'r'),(53,'kjf',76,'gk'),(54,'ru',75,'ur'),(55,'tu',7,'j'),(56,'hy',67,'y'),(57,'yu',76,'uy'),(58,'ghh',65,'yt'),(59,'gdr',5,'rd'),(60,'ty',6,'yu'),(61,'ru',6,'tr'),(62,'tye',5,'r'),(63,'dngh',65,'t'),(64,'yht',65,'ty'),(65,'f',65,'df'),(66,'er',6,''),(67,'ts',6,'fxg'),(68,'hnj',6,'h'),(69,'fgd',6,''),(70,'yh',6,'h'),(71,'gfh',56,''),(72,'rt',45,'r'),(73,'yt',67,''),(74,'bg',65,''),(75,'th',54,''),(76,'hy',6,''),(77,'ty',6,''),(78,'t',5,''),(79,'gd',6,''),(80,'th',56,''),(81,'tr',56,''),(82,'t',5,''),(83,'t',5,''),(84,'gf',5,''),(85,'t',5,''),(86,'t',5,''),(87,'f',5,''),(88,'rt',5,''),(89,'g',5,''),(90,'t',5,''),(91,'g',6,''),(92,'g',5,''),(93,'t',5,''),(94,'t',5,''),(95,'t',6,''),(96,'f',5,''),(97,'r',5,''),(98,'f',6,''),(99,'t',5,'5'),(100,'f',5,''),(101,'t',5,''),(102,'r',5,''),(103,'r',5,''),(104,'r',5,''),(105,'r',4,'r'),(106,'r',4,''),(107,'r',5,''),(108,'r',55,''),(109,'r',5,''),(110,'r',4,''),(111,'f',4,''),(112,'r',4,''),(113,'f',5,''),(114,'r',5,''),(115,'g',5,''),(116,'r',5,''),(117,'y',5,''),(118,'h',5,''),(119,'r',4,''),(120,'dd',4,''),(121,'r',4,''),(122,'v',4,''),(123,'r',4,''),(124,'r',4,''),(125,'r',44,''),(126,'r',4,''),(127,'r',5,''),(128,'r',5,''),(129,'GD',5,''),(130,'G',5,''),(131,'E',4,''),(132,'G',5,''),(133,'R',6,''),(134,'G',5,''),(135,'R',4,''),(136,'F',5,''),(137,'T',5,''),(138,'t',5,''),(139,'t',5,''),(140,'r',5,''),(141,'e',4,''),(142,'r',5,''),(143,'f',5,''),(144,'gf',6,''),(145,'fgbd',5,''),(146,'gf',5,''),(147,'thbteb',6,''),(148,'gge',5,''),(149,'tr',5,''),(150,'r',5,''),(151,'t',5,''),(152,'hj',67,''),(153,'y',6,''),(154,'gh',65,''),(155,'g',6,''),(156,'gfgs',65,''),(157,'r',5,''),(158,'t',7,''),(159,'fg',5,''),(160,'h',6,''),(161,'gf',5,''),(162,'gsf',56,''),(163,'tr',6,''),(164,'ht',46,''),(165,'gr',5,''),(166,'tdhn',5,''),(167,'tyh',56,''),(168,'dth',5,''),(169,'gfhj',5,''),(170,'hfsg',5,''),(171,'thsrths',5,''),(172,'rs',5,''),(173,'grsgh',5,''),(174,'Picotres',23,'simpático'),(175,'Felipe Nes',70,'Controvertido'),(176,'Zapatera',34,'Choni'),(177,'Ana Botella',55,'Madrid'),(178,'YSY',56,''),(179,'gt',5,''),(180,'Paul Ano',18,'Pubber'),(181,'PauL',46,'Francés'),(182,'FRE',43,''),(183,'HSR',5,''),(184,'TEZRT',5,''),(185,'HDT',5,''),(186,'Rt',4,''),(187,'dvs',56,''),(188,'fr',5,''),(189,'gr',5,''),(190,'ik',78,''),(191,'xyj',6,'');
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jugador_personaje`
--

LOCK TABLES `jugador_personaje` WRITE;
/*!40000 ALTER TABLE `jugador_personaje` DISABLE KEYS */;
INSERT INTO `jugador_personaje` VALUES (3,46,9),(4,55,8),(6,79,9),(7,5,11),(8,5,11),(9,46,8),(10,154,8),(11,16,9),(12,156,11),(13,156,8),(14,156,11),(15,156,11),(16,156,11),(17,162,11),(18,162,9),(19,162,10),(20,162,10),(21,31,11),(22,167,11),(23,167,11),(24,173,11),(25,173,9),(26,173,9),(27,173,10),(28,173,11),(29,174,10),(30,177,13),(31,177,13),(32,177,13),(33,177,13),(34,178,12),(35,178,8),(36,181,13),(37,181,10),(38,182,13),(39,182,14),(40,183,13),(41,183,13),(42,185,13),(43,185,14),(44,72,12),(45,188,12),(46,188,9),(47,165,12),(48,165,11),(49,165,12),(50,165,12),(51,190,11),(52,190,13),(53,191,12),(54,191,9);
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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personaje`
--

LOCK TABLES `personaje` WRITE;
/*!40000 ALTER TABLE `personaje` DISABLE KEYS */;
INSERT INTO `personaje` VALUES (8,'Tommy Rabo',25,'Cerveza',50,1,'Monstruo',0,'Sushi, Cosplay'),(9,'Aann Abocheiras',40,'Limpieza',50,1,'Robot',0,'Playa, Cine'),(10,'Elen Chufe',60,'Fiesta',50,1,'Robot',0,'Playa, Cine'),(11,'Zapatero',60,'Fiesta',50,1,'Robot',1,'Playa, Cine'),(12,'Paca Garte',44,'Lavarse los pies',50,1,'Robot',1,'Petanca, Cine'),(13,'Estela Gartija',33,'Reptiliano',50,1,'Robot',1,'Sushi, Cine'),(14,'Encarna Vales',78,'Novelas',50,1,'Robot',1,'Playa, Cine');
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

-- Dump completed on 2023-06-02 18:15:32
