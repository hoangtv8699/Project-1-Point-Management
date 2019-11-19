CREATE DATABASE  IF NOT EXISTS `quanlydiemsv` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_swedish_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `quanlydiemsv`;
-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: quanlydiemsv
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
-- Table structure for table `mon_hoc`
--

DROP TABLE IF EXISTS `mon_hoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `mon_hoc` (
  `tenHP` varchar(255) CHARACTER SET utf8 COLLATE utf8_swedish_ci NOT NULL,
  `maHP` varchar(255) CHARACTER SET utf8 COLLATE utf8_swedish_ci NOT NULL,
  `maLop` varchar(255) CHARACTER SET utf8 COLLATE utf8_swedish_ci NOT NULL,
  `hocky` varchar(255) CHARACTER SET utf8 COLLATE utf8_swedish_ci NOT NULL,
  `soTinChi` tinyint(4) DEFAULT NULL,
  `qt` float DEFAULT NULL,
  PRIMARY KEY (`maHP`,`maLop`,`hocky`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mon_hoc`
--

LOCK TABLES `mon_hoc` WRITE;
/*!40000 ALTER TABLE `mon_hoc` DISABLE KEYS */;
INSERT INTO `mon_hoc` VALUES ('Nhập môn CNTT và TT','IT2000','99584','20171',3,0.3),('Cấu trúc dữ liệu và thuật toán','IT3011','108515','20171',2,0.3),('Mạng máy tính','IT3080','689529','20171',3,0.3),('Cơ sở dữ liệu','IT3090','111565','20171',3,0.3),('Lập trình hướng đối tượng','IT3100','110494','20171',2,0.3),('Xử lý tín hiệu','IT4172','111569','20171',2,0.3);
/*!40000 ALTER TABLE `mon_hoc` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-19 15:04:30
