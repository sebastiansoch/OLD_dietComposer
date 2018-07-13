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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dish_components`
--

LOCK TABLES `dish_components` WRITE;
/*!40000 ALTER TABLE `dish_components` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dish_items`
--

LOCK TABLES `dish_items` WRITE;
/*!40000 ALTER TABLE `dish_items` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dishes`
--

LOCK TABLES `dishes` WRITE;
/*!40000 ALTER TABLE `dishes` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `units`
--

LOCK TABLES `units` WRITE;
/*!40000 ALTER TABLE `units` DISABLE KEYS */;
INSERT INTO `units` VALUES (4,'BOWL'),(3,'GLASS'),(1,'GRAM'),(2,'NUMBER'),(5,'SPOON');
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

-- Dump completed on 2018-07-06 15:45:08
