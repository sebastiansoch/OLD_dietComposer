CREATE DATABASE  IF NOT EXISTS `dietcomposer` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_polish_ci */;
USE `dietcomposer`;
-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: localhost    Database: dietcomposer
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `dish_components`
--

DROP TABLE IF EXISTS `dish_components`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `dish_components` (
  `dish_component_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8_polish_ci NOT NULL,
  `unit_id` int(11) NOT NULL,
  `calories_per_unit` decimal(6,0) NOT NULL,
  PRIMARY KEY (`dish_component_id`),
  UNIQUE KEY `dish_component_id_UNIQUE` (`dish_component_id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dish_components`
--

LOCK TABLES `dish_components` WRITE;
/*!40000 ALTER TABLE `dish_components` DISABLE KEYS */;
INSERT INTO `dish_components` VALUES (1,'baban',2,116),(2,'bekon',6,68),(3,'bułka',2,163),(4,'chleb',6,54),(5,'dzem',5,38),(6,'gruszka',2,75),(7,'jabłko',2,90),(8,'jajko',2,71),(9,'jogurt naturalny',1,1),(10,'kotlet schabowy',1,4),(11,'makaron',1,4),(12,'masło',1,22),(13,'śmietana 18%',5,47),(14,'naleśnik',2,170),(15,'ogórek kiszony',2,7),(16,'pieczarka',1,0),(17,'płatki górske',1,4),(18,'rodzynki',1,3),(19,'ser zółty',6,47),(20,'szynka',6,78),(21,'ziemniaki',1,1),(22,'zupa pomidorowa',4,11);
/*!40000 ALTER TABLE `dish_components` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dish_items`
--

DROP TABLE IF EXISTS `dish_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `dish_items` (
  `dish_item_id` int(11) NOT NULL AUTO_INCREMENT,
  `dish_id` int(11) DEFAULT NULL,
  `dish_component_id` int(11) DEFAULT NULL,
  `amount` decimal(6,2) NOT NULL,
  PRIMARY KEY (`dish_item_id`),
  UNIQUE KEY `dish_item_id_UNIQUE` (`dish_item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dish_items`
--

LOCK TABLES `dish_items` WRITE;
/*!40000 ALTER TABLE `dish_items` DISABLE KEYS */;
INSERT INTO `dish_items` VALUES (1,1,8,3.00),(2,1,2,2.00),(3,1,4,1.00),(4,1,12,3.00),(5,2,8,2.00),(6,2,16,15.00),(7,2,2,2.00),(8,2,4,1.00),(9,2,12,3.00),(10,3,3,1.00),(11,3,12,3.00),(12,3,19,1.00),(13,3,20,2.00),(14,4,3,1.00),(15,4,12,3.00),(16,4,19,1.00),(17,4,20,1.00),(18,4,8,1.00),(19,5,14,1.00),(20,5,5,1.00),(21,6,17,100.00),(22,6,9,100.00),(23,6,18,20.00),(24,7,22,1.00),(25,7,11,50.00),(26,7,13,1.00),(27,8,7,1.00),(28,8,6,1.00),(29,8,1,1.00),(30,8,18,20.00),(31,9,10,100.00),(32,9,21,200.00),(33,9,15,1.00);
/*!40000 ALTER TABLE `dish_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dish_types`
--

DROP TABLE IF EXISTS `dish_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `dish_types` (
  `dish_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(20) COLLATE utf8_polish_ci NOT NULL,
  PRIMARY KEY (`dish_type_id`),
  UNIQUE KEY `dish_type_id_UNIQUE` (`dish_type_id`),
  UNIQUE KEY `type_UNIQUE` (`type`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dish_types`
--

LOCK TABLES `dish_types` WRITE;
/*!40000 ALTER TABLE `dish_types` DISABLE KEYS */;
INSERT INTO `dish_types` VALUES (1,'BREAKFAST'),(7,'MAIN_COURSE'),(5,'SECOND_BREAKFAST'),(6,'SOUP'),(4,'SUPPER'),(8,'TEA');
/*!40000 ALTER TABLE `dish_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dishes`
--

DROP TABLE IF EXISTS `dishes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `dishes` (
  `dish_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8_polish_ci NOT NULL,
  PRIMARY KEY (`dish_id`),
  UNIQUE KEY `id_dishes_UNIQUE` (`dish_id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dishes`
--

LOCK TABLES `dishes` WRITE;
/*!40000 ALTER TABLE `dishes` DISABLE KEYS */;
INSERT INTO `dishes` VALUES (1,'jajecznica z bekonem'),(2,'jajecznica z pieczarkami'),(3,'kanapka z serem, szynką'),(4,'kanapka z serem, szynką, jajkiem'),(5,'naleśniki z dżemem'),(6,'owsianka'),(7,'pomidorowa'),(8,'sałatka owocowa'),(9,'schabowy');
/*!40000 ALTER TABLE `dishes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dishes_dish_types`
--

DROP TABLE IF EXISTS `dishes_dish_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `dishes_dish_types` (
  `dish_id` int(11) NOT NULL,
  `dish_type_id` int(11) NOT NULL,
  PRIMARY KEY (`dish_id`,`dish_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dishes_dish_types`
--

LOCK TABLES `dishes_dish_types` WRITE;
/*!40000 ALTER TABLE `dishes_dish_types` DISABLE KEYS */;
INSERT INTO `dishes_dish_types` VALUES (1,1),(2,1),(3,1),(3,4),(3,5),(3,8),(4,1),(4,4),(4,5),(5,7),(6,1),(6,4),(6,5),(7,6),(8,8),(9,7);
/*!40000 ALTER TABLE `dishes_dish_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `units`
--

DROP TABLE IF EXISTS `units`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `units` (
  `unit_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(15) COLLATE utf8_polish_ci NOT NULL,
  PRIMARY KEY (`unit_id`),
  UNIQUE KEY `unit_id_UNIQUE` (`unit_id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `units`
--

LOCK TABLES `units` WRITE;
/*!40000 ALTER TABLE `units` DISABLE KEYS */;
INSERT INTO `units` VALUES (4,'BOWL'),(3,'GLASS'),(1,'GRAM'),(2,'NUMBER'),(6,'SLICE'),(5,'SPOON');
/*!40000 ALTER TABLE `units` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'dietcomposer'
--

--
-- Dumping routines for database 'dietcomposer'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-13 11:22:21
