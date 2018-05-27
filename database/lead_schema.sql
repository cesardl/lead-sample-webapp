-- MySQL dump 10.13  Distrib 5.1.41, for debian-linux-gnu (i486)
--
-- Host: localhost    Database: lead
-- ------------------------------------------------------
-- Server version	5.1.41-3ubuntu12.6

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `CATEGORY`
--

DROP TABLE IF EXISTS `CATEGORY`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CATEGORY` (
  `CT_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CT_NAME` varchar(255) NOT NULL,
  `CT_DESCRIPTION` varchar(400) DEFAULT NULL,
  `CT_CREATED_DATE` datetime DEFAULT NULL,
  `CT_MODIFIED_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`CT_ID`),
  UNIQUE KEY `CT_NAME` (`CT_NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CATEGORY`
--

LOCK TABLES `CATEGORY` WRITE;
/*!40000 ALTER TABLE `CATEGORY` DISABLE KEYS */;
INSERT INTO `CATEGORY` VALUES (1,'Insurance','Insurance',NULL,NULL),(2,'IT Services','IT Services',NULL,NULL),(3,'Software','Software',NULL,NULL),(4,'Hardware','Hardware',NULL,NULL),(5,'Financial Services','Financial Services',NULL,NULL),(6,'Construction','Construction',NULL,NULL),(7,'Consumer Loans','Consumer Loans',NULL,NULL);
/*!40000 ALTER TABLE `CATEGORY` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `LEAD`
--

DROP TABLE IF EXISTS `LEAD`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `LEAD` (
  `LD_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `LD_TITLE` varchar(255) NOT NULL,
  `LD_DESCRIPTION` varchar(400) NOT NULL,
  `LD_FIRST_NAME` varchar(255) NOT NULL,
  `LD_LAST_NAME` varchar(255) NOT NULL,
  `LD_EMAIL` varchar(255) NOT NULL,
  `LD_PHONE` varchar(100) DEFAULT NULL,
  `LD_PRICE` decimal(19,2) DEFAULT NULL,
  `LD_STATUS` varchar(100) NOT NULL,
  `LD_OWNER_ID` bigint(20) NOT NULL,
  `LD_CATEGORY_ID` bigint(20) NOT NULL,
  `LD_CREATED_DATE` datetime DEFAULT NULL,
  `LD_MODIFIED_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`LD_ID`),
  KEY `LD_OWNER_ID` (`LD_OWNER_ID`),
  KEY `LD_CATEGORY_ID` (`LD_CATEGORY_ID`),
  CONSTRAINT `LEAD_ibfk_1` FOREIGN KEY (`LD_OWNER_ID`) REFERENCES `USER` (`USR_ID`),
  CONSTRAINT `LEAD_ibfk_2` FOREIGN KEY (`LD_CATEGORY_ID`) REFERENCES `CATEGORY` (`CT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `LEAD`
--

LOCK TABLES `LEAD` WRITE;
/*!40000 ALTER TABLE `LEAD` DISABLE KEYS */;
INSERT INTO `LEAD` VALUES
  (1,'Mi first lead','--','Pablo Cesar','Diaz Lurita','cesar.dl88@gmail.com','959656','150.00','NEW',2,3,NULL,NULL),
  (2,'Mi second lead','--','Pablo Cesar','Diaz Lurita','cesar.dl88@gmail.com','959656','150.00','NEW',2,3,NULL,NULL),
  (3,'Mi third lead','--','Pablo Cesar','Diaz Lurita','cesar.dl88@gmail.com','959656','150.00','NEW',2,3,NULL,NULL),
  (4,'Mi fourth lead','--','Pablo Cesar','Diaz Lurita','cesar.dl88@gmail.com','959656','150.00','NEW',2,3,NULL,NULL),
  (5,'Mi fifth lead','--','Pablo Cesar','Diaz Lurita','cesar.dl88@gmail.com','959656','150.00','NEW',2,3,NULL,NULL);
/*!40000 ALTER TABLE `LEAD` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USER`
--

DROP TABLE IF EXISTS `USER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USER` (
  `USR_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `USR_FIRST_NAME` varchar(255) NOT NULL,
  `USR_LAST_NAME` varchar(255) NOT NULL,
  `USR_EMAIL` varchar(255) NOT NULL,
  `USR_PASSWORD` varchar(255) NOT NULL,
  `USR_CREATED_DATE` datetime DEFAULT NULL,
  `USR_MODIFIED_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`USR_ID`),
  UNIQUE KEY `USR_EMAIL` (`USR_EMAIL`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USER`
--

LOCK TABLES `USER` WRITE;
/*!40000 ALTER TABLE `USER` DISABLE KEYS */;
INSERT INTO `USER` VALUES (1,'John','Miller','user@javachap.com','javachap','2010-10-31 18:07:09','2010-10-31 18:07:09'),(2,'Cesar','Diaz','cesar.dl88@gmail.com','123456','2010-10-31 21:44:34','2010-10-31 21:44:40'),(3,'Carlos','Suarez','user2@javachap.com','javachap',NULL,NULL);
/*!40000 ALTER TABLE `USER` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2010-11-01  3:58:08
