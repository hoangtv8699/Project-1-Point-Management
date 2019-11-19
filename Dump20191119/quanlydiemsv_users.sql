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
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_swedish_ci DEFAULT NULL,
  `ten` varchar(255) CHARACTER SET utf8 COLLATE utf8_swedish_ci DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_swedish_ci DEFAULT NULL,
  `ngaySinh` date DEFAULT NULL,
  `diaChi` varchar(255) CHARACTER SET utf8 COLLATE utf8_swedish_ci DEFAULT NULL,
  `sdt` varchar(255) CHARACTER SET utf8 COLLATE utf8_swedish_ci DEFAULT NULL,
  `gioiTinh` tinyint(1) DEFAULT NULL,
  `chuongTrinh` varchar(255) CHARACTER SET utf8 COLLATE utf8_swedish_ci DEFAULT NULL,
  `level` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20000017 DEFAULT CHARSET=utf8 COLLATE=utf8_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (20000000,'12345','Trần Văn Hoàng','nhoxkhang351@gmail.com','1999-06-08','thụy ứng','0386458774',1,'kĩ thuật máy tinh',NULL),(20000001,'12345','Trần Văn điệp','nhoxkhang351@gmail.com','1999-06-08','thụy ứng','0386458774',1,'kĩ thuật máy tinh',NULL),(20000002,'12345','Phạm Văn Hùng','nhoxkhang351@gmail.com','1999-06-08','thụy ứng','0386458774',1,'kĩ thuật máy tinh',NULL),(20000003,'12345','Lê Trọng Nhân','nhoxkhang351@gmail.com','1999-06-08','thụy ứng','0386458774',1,'kĩ thuật máy tinh',NULL),(20000004,'12345','Trần Phương Thảo','nhoxkhang351@gmail.com','1999-06-08','thụy ứng','0386458774',0,'kĩ thuật máy tinh',NULL),(20000005,'12345','Nguyễn Văn Hải','nhoxkhang351@gmail.com','1999-06-08','thụy ứng','0386458774',1,'kĩ thuật máy tinh',NULL),(20000006,'12345','Nguyễn Đình Hoàng','nhoxkhang351@gmail.com','1999-06-08','thụy ứng','0386458774',1,'kĩ thuật máy tinh',NULL),(20000007,'12345','Hồ Quốc Khánh','nhoxkhang351@gmail.com','1999-06-08','thụy ứng','0386458774',1,'kĩ thuật máy tinh',NULL),(20000008,'12345','Bùi Trọng Tùng','nhoxkhang351@gmail.com','1999-06-08','thụy ứng','0386458774',1,NULL,7),(20000009,'12345','Nguyễn Tiến Thành','nhoxkhang351@gmail.com','1999-06-08','thụy ứng','0386458774',1,NULL,7),(20000010,'12345','Nguyễn Đức Tiến','nhoxkhang351@gmail.com','1999-06-08','thụy ứng','0386458774',1,NULL,7),(20000011,'12345','Nguyễn Hồng Phương','nhoxkhang351@gmail.com','1999-06-08','thụy ứng','0386458774',1,NULL,7),(20000012,'12345','Nguyễn Hồng Quang','nhoxkhang351@gmail.com','1999-06-08','thụy ứng','0386458774',1,NULL,7),(20000013,'12345','Ngô Thu Quỳnh','nhoxkhang351@gmail.com','1999-06-08','thụy ứng','0386458774',0,NULL,7),(20000014,'12345','Trần Văn Hoàng','nhoxkhang351@gmail.com','1999-06-08','thụy ứng','0386458774',1,NULL,NULL),(20000015,'12345','Trần Văn Điệp','nhoxkhang351@gmail.com','1999-06-08','thụy ứng','0386458774',1,NULL,NULL),(20000016,'12345','Phạn Văn Hùng','nhoxkhang351@gmail.com','1999-06-08','thụy ứng','0386458774',0,NULL,NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-19 15:04:31
