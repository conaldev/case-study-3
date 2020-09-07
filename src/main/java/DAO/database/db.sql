-- MySQL dump 10.13  Distrib 8.0.21, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: webLaptop
-- ------------------------------------------------------
-- Server version	8.0.21-0ubuntu0.20.04.4

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
-- Table structure for table `Accounts`
--

DROP TABLE IF EXISTS `Accounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Accounts` (
  `email` varchar(300) NOT NULL,
  `password` varchar(50) NOT NULL,
  `role` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`email`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `Accounts_ibfk_1` (`role`),
  CONSTRAINT `Accounts_ibfk_1` FOREIGN KEY (`role`) REFERENCES `Users` (`userNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Accounts`
--

LOCK TABLES `Accounts` WRITE;
/*!40000 ALTER TABLE `Accounts` DISABLE KEYS */;
/*!40000 ALTER TABLE `Accounts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Cart`
--

DROP TABLE IF EXISTS `Cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Cart` (
  `cusNumber` int NOT NULL,
  `productID` int NOT NULL,
  `quantity` int NOT NULL,
  PRIMARY KEY (`cusNumber`),
  UNIQUE KEY `cusNumber_UNIQUE` (`cusNumber`),
  KEY `productID` (`productID`),
  CONSTRAINT `Cart_ibfk_1` FOREIGN KEY (`cusNumber`) REFERENCES `Users` (`userNumber`),
  CONSTRAINT `Cart_ibfk_2` FOREIGN KEY (`productID`) REFERENCES `Product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Cart`
--

LOCK TABLES `Cart` WRITE;
/*!40000 ALTER TABLE `Cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `Cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Orderdetail`
--

DROP TABLE IF EXISTS `Orderdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Orderdetail` (
  `productID` int NOT NULL,
  `orderNumber` int NOT NULL AUTO_INCREMENT,
  `quantityOrdered` int NOT NULL,
  `priceProduct` bigint NOT NULL,
  `orderDate` date NOT NULL,
  `cusNumber` int NOT NULL,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`orderNumber`),
  KEY `productID` (`productID`),
  CONSTRAINT `OrderDetail_ibfk_1` FOREIGN KEY (`productID`) REFERENCES `Product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Orderdetail`
--

LOCK TABLES `Orderdetail` WRITE;
/*!40000 ALTER TABLE `Orderdetail` DISABLE KEYS */;
/*!40000 ALTER TABLE `Orderdetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Product`
--

DROP TABLE IF EXISTS `Product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `productName` varchar(255) NOT NULL,
  `price` bigint NOT NULL,
  `description` text NOT NULL,
  `imgURL` varchar(400) NOT NULL,
  `Vendor` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `productName_UNIQUE` (`productName`)
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Product`
--

LOCK TABLES `Product` WRITE;
/*!40000 ALTER TABLE `Product` DISABLE KEYS */;
INSERT INTO `Product` VALUES (1,'Laptop Asus VivoBook X409JA i3 1005G1/4GB/512GB/Win10 (EK015T)',11590000,'CPU: Intel Core i3 Ice Lake 1005G1 120 GHz\nRAM: 4 GB DDR4 (On board +1 khe) 2666 MHz\nỔ CỨNG: SSD 512 GB M2 PCIe Hỗ trợ khe cắm HDD SATA\nMàn Hình: 14 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/220526/asus-x409ja-i3-ek015t-220526-2-600x600.jpg\n','Asus'),(2,'Laptop Asus VivoBook X409JA i5 1035G1/8GB/512GB/Win10 (EK052T)',15490000,'CPU: Intel Core i5 Ice Lake 1035G1 100 GHz\nRAM: 8 GB DDR4 (On board 4GB +1 khe 4GB) 2666 MHz\nỔ CỨNG: SSD 512 GB M2 PCIe Không hỗ trợ khe cắm HDD\nMàn Hình: 14 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/220976/asus-vivobook-x409ja-i5-ek052t-220976-600x600.jpg\n','Asus'),(3,'Laptop HP 348 G7 i5 10210U/8GB/512GB/Win10 (9PH06PA)',16290000,'CPU: Intel Core i5 Comet Lake 10210U 160 GHz\nRAM: 8 GB DDR4 (2 khe) 2666 MHz\nỔ CỨNG: SSD 512 GB M2 PCIe Hỗ trợ khe cắm HDD SATA\nMàn Hình: 14 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/218439/hp-348-g7-i5-9ph06pa-kg2-1-218439-600x600.jpg\n','HP'),(4,'Laptop Asus VivoBook A512FA i3 10110U/8GB/512GB/Win10 (EJ2033T)',13690000,'CPU: Intel Core i3 Comet Lake 10110U 210 GHz\nRAM: 8 GB DDR4 (On board 4GB +1 khe 4GB) 2666 MHz\nỔ CỨNG: SSD 512 GB M2 PCIe\nMàn Hình: 156 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/226254/asus-vivobook-a512fa-i3-10110u-ej2033t-226254-600x600.jpg\n','Asus'),(5,'Laptop Dell Vostro 3590 i5 10210U/8GB/256GB/Win10 (GRMGK3)',15590000,'CPU: Intel Core i5 Comet Lake 10210U 160 GHz\nRAM: 8 GB DDR4 (On board +1 khe) 2666 MHz\nỔ CỨNG: SSD 256GB NVMe PCIe\nMàn Hình: 156 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/225808/dell-vostro-3590-i5-grmgk3-225520-055537-600x600.jpg\n','Dell'),(6,'Laptop HP 15s du2050TX i3 1005G1/4GB/256GB/2GB MX130/Win10 (1M8W2PA)',12390000,'CPU: Intel Core i3 Ice Lake 1005G1 120 GHz\nRAM: 4 GB DDR4 (2 khe) 2666 MHz\nỔ CỨNG: SSD 256GB NVMe PCIe Hỗ trợ khe cắm HDD SATA\nMàn Hình: 156 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/224065/hp-15s-du2050tx-i3-1m8w2pa-usb-224065-600x600.jpg\n','HP'),(7,'Laptop Apple MacBook Air 2017 i5 18GHz/8GB/128GB (MQD32SA/A)',19490000,'CPU: Intel Core i5 Broadwell 180 GHz\nRAM: 8 GB DDR3L(On board) 1600 MHz\nỔ CỨNG: SSD: 128 GB\nMàn Hình: 133 inch WXGA+(1440 x 900)','https://cdn.tgdd.vn/Products/Images/44/106875/apple-macbook-air-mqd32sa-a-i5-5350u-600x600.jpg\n','Apple'),(8,'Laptop HP 15s fq1111TU i3 1005G1/4GB/256GB/Win10 (193R0PA)',11390000,'CPU: Intel Core i3 Ice Lake 1005G1 120 GHz\nRAM: 4 GB DDR4 (2 khe) 2666 MHz\nỔ CỨNG: SSD 256GB NVMe PCIe Hỗ trợ khe cắm HDD SATA\nMàn Hình: 156 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/224012/hp-15s-fq1111tu-i3-193r0pa-224012-224012-600x600.jpg\n','HP'),(9,'Laptop Lenovo IdeaPad Slim 3 15IIL05 i3 1005G1/4GB/512GB/Win10 (81WE003RVN)',12990000,'CPU: Intel Core i3 Ice Lake 1005G1 120 GHz\nRAM: 4 GB DDR4 (On board +1 khe) 2666 MHz\nỔ CỨNG: SSD 512 GB M2 PCIe Hỗ trợ khe cắm HDD SATA\nMàn Hình: 156 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/223534/lenovo-ideapad-3-15iil05-i3-81we003rvn-013920-053901-600x600.jpg\n','Lenovo'),(10,'Laptop Asus VivoBook X509JP i5 1035G1/8GB/512GB/2GB MX330/Win10 (EJ023T)',17190000,'CPU: Intel Core i5 Ice Lake 1035G1 100 GHz\nRAM: 8 GB DDR4 (On board 4GB +1 khe 4GB) 2666 MHz\nỔ CỨNG: SSD 512 GB M2 PCIe Hỗ trợ khe cắm HDD SATA\nMàn Hình: 156 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/221617/asus-vivobook-x509jp-i5-ej023t-2gb-221617-600x600.jpg\n','Asus'),(11,'Laptop Dell Inspiron 3493 i5 1035G1/8GB/256GB/Win10 (N4I5122WA)',15290000,'CPU: Intel Core i5 Ice Lake 1035G1 100 GHz\nRAM: 8 GB DDR4 (2 khe) 2666 MHz\nỔ CỨNG: SSD 256GB NVMe PCIe Hỗ trợ khe cắm HDD SATA\nMàn Hình: 14 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/222088/dell-inspiron-3493-i5-n4i5122w-222088-600x600.jpg\n','Dell'),(12,'Laptop Asus VivoBook X509M N5000/4GB/512GB/Win10 (EJ255T)',8890000,'CPU: Intel Pentium N5000 110 GHz\nRAM: 4 GB DDR4 (1 khe) 2666 MHz\nỔ CỨNG: SSD 512 GB M2 PCIe Hỗ trợ khe cắm HDD SATA\nMàn Hình: 156 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/225951/asus-vivobook-x509m-n5000-ej255t-6-225951-600x600.jpg\n','Asus'),(13,'Laptop HP 348 G7 i3 8130U/4GB/512GB/Win10 (1A0Z1PA)',12390000,'CPU: Intel Core i3 Coffee Lake 8130U 220 GHz\nRAM: 4 GB DDR4 (2 khe) 2666 MHz\nỔ CỨNG: SSD 512 GB M2 PCIe Hỗ trợ khe cắm HDD SATA\nMàn Hình: 14 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/225549/hp-348-g7-i3-1a0z1pa-1-225549-600x600.jpg\n','HP'),(14,'Laptop Acer Aspire 3 A315 54K 37B0 i3 8130U/4GB/256GB/Win10 (NXHEESV00D)',10990000,'CPU: Intel Core i3 Coffee Lake 8130U 220 GHz\nRAM: 4 GB DDR4 (On board +1 khe) 2400 MHz\nỔ CỨNG: SSD 256GB NVMe PCIe Hỗ trợ khe cắm HDD SATA\nMàn Hình: 156 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/221251/acer-aspire-3-a315-nx-heesv-00d-221251-1-600x600.jpg\n','Acer'),(15,'Laptop Acer Aspire 3 A315 56 58EB i5 1035G1/8GB/512GB/Win10 (NXHS5SV00B)',15990000,'CPU: Intel Core i5 Ice Lake 1035G1 100 GHz\nRAM: 8 GB DDR4 (On board 4GB +1 khe 4GB) 2400 MHz\nỔ CỨNG: SSD 512 GB M2 PCIe Hỗ trợ khe cắm HDD SATA\nMàn Hình: 156 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/224584/acer-aspire-3-a315-56-i5-nxhs5sv00b-025720-095710-600x600.jpg\n','Acer'),(16,'Laptop HP Pavilion 15 cs3012TU i5 1035G1/8GB/512GB/Win10 (8QP30PA)',17190000,'CPU: Intel Core i5 Ice Lake 1035G1 100 GHz\nRAM: 8 GB DDR4 (2 khe) 2666 MHz\nỔ CỨNG: SSD 512 GB M2 PCIe Hỗ trợ khe cắm HDD SATA\nMàn Hình: 156 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/216087/hp-pavilion-15-cs3012tu-i5-1035g1-8gb-512gb-win10-15-216087-600x600.jpg\n','HP'),(17,'Laptop Lenovo IdeaPad Slim 3 15IIL05 i5 1035G4/8GB/512GB/Win10 (81WE003QVN)',15790000,'CPU: Intel Core i5 Ice Lake 1035G4 110 GHz\nRAM: 8 GB DDR4 (On board 4GB +1 khe 4GB) 2666 MHz\nỔ CỨNG: SSD 512 GB M2 PCIe Hỗ trợ khe cắm HDD SATA\nMàn Hình: 156 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/222649/lenovo-ideapad-3-15iil05-i5-81we003qvn-222649-2-600x600.jpg\n','Lenovo'),(18,'Laptop HP 15s du1077TX i7 10510U/8GB/512GB/2GB MX130/Win10 (1R8E3PA)',18990000,'CPU: Intel Core i7 Comet Lake 10510U 180 GHz\nRAM: 8 GB DDR4 (2 khe) 2666 MHz\nỔ CỨNG: SSD 512 GB M2 PCIe\nMàn Hình: 156 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/227071/hp-15s-du1077tx-i7-8gb-10510u-512gb-2gb-mx130-win1-600x600.jpg\n','HP'),(19,'Laptop Dell Inspiron 5593 i5 1035G1/8GB/256GB/2GB MX230/Win10 (N5I5513W)',17990000,'CPU: Intel Core i5 Ice Lake 1035G1 100 GHz\nRAM: 8 GB DDR4 (2 khe) 2666 MHz\nỔ CỨNG: SSD 256GB NVMe PCIe Hỗ trợ khe cắm HDD SATA\nMàn Hình: 156 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/213570/dell-inspiron-5593-i5-1035g1-8gb-256gb-2gb-mx230-w-213570-600x600.jpg\n','Dell'),(20,'Laptop Acer Aspire A315 56 308N i3 1005G1/4GB/256GB/Win10 (NXHS5SV00C)',11990000,'CPU: Intel Core i3 Ice Lake 1005G1 120 GHz\nRAM: 4 GB DDR4 (On board +1 khe) 2400 MHz\nỔ CỨNG: SSD 256GB NVMe PCIe Hỗ trợ khe cắm HDD SATA\nMàn Hình: 156 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/223654/acer-aspire-a315-56-308n-i3-nxhs5sv00c-15-223654-600x600.jpg\n','Acer'),(21,'Laptop Asus VivoBook X441MA N5000/4GB/1TB/Win10 (GA024T)',7190000,'CPU: Intel Pentium N5000 110 GHz\nRAM: 4 GB DDR4 (1 khe) 2133 MHz\nỔ CỨNG: HDD: 1 TB SATA3\nMàn Hình: 14 inch HD (1366 x 768)','https://cdn.tgdd.vn/Products/Images/44/191993/asus-x441ma-ga024t11-191993-600x600.jpg\n','Asus'),(22,'Laptop Asus VivoBook A512FA i5 10210U/8GB/512GB/Chuột/Win10 (EJ1734T)',16590000,'CPU: Intel Core i5 Comet Lake 10210U 160 GHz\nRAM: 8 GB DDR4 (On board 4GB +1 khe 4GB) 2666 MHz\nỔ CỨNG: SSD 512 GB M2 PCIe Hỗ trợ khe cắm HDD SATA\nMàn Hình: 156 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/217510/asus-vivobook-a512fa-i5-ej1734t-9-217510-600x600.jpg\n','Asus'),(23,'Laptop HP Pavilion 15 cs3061TX i5 1035G1/8GB/512GB/2G MX250/Win10 (8RE83PA)',18190000,'CPU: Intel Core i5 Ice Lake 1035G1 100 GHz\nRAM: 8 GB DDR4 (2 khe) 2666 MHz\nỔ CỨNG: SSD 512 GB M2 PCIe Hỗ trợ khe cắm HDD SATA\nMàn Hình: 156 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/216088/hp-pavilion-15-cs3061tx-i5-8re83pa-29-216088-600x600.jpg\n','HP'),(24,'Laptop HP Pavilion x360 14 dw0060TU i3 1005G1/4GB/256GB/Pen/Office H&S2019/Win10 (195M8PA)',14190000,'CPU: Intel Core i3 Ice Lake 1005G1 120 GHz\nRAM: 4 GB DDR4 (2 khe) 3200 MHz\nỔ CỨNG: SSD 256GB NVMe PCIe\nMàn Hình: 14 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/225695/hp-pavilion-x360-dw0060tu-i3-195m8pa-225695-600x600.jpg\n','HP'),(25,'Laptop HP Pavilion 15 cs3014TU i5 1035G1/4GB/256GB/Win10 (8QP20PA)',15590000,'CPU: Intel Core i5 Ice Lake 1035G1 100 GHz\nRAM: 4 GB DDR4 (2 khe) 2666 MHz\nỔ CỨNG: SSD 256GB NVMe PCIe Hỗ trợ khe cắm HDD SATA\nMàn Hình: 156 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/216085/hp-pavilion-15-cs3014tu-i5-8qp20pa-8-216085-600x600.jpg\n','HP'),(26,'Laptop HP Pavilion 15 cs3119TX i5 1035G1/4GB/256GB/2GB MX250/Win10 (9FN16PA)',16590000,'CPU: Intel Core i5 Ice Lake 1035G1 100 GHz\nRAM: 4 GB DDR4 (2 khe) 2666 MHz\nỔ CỨNG: SSD 256GB NVMe PCIe Hỗ trợ khe cắm HDD SATA\nMàn Hình: 156 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/216291/hp-pavilion-15-cs3119tx-i5-1035g1-4gb-256gb-2gb-mx-9-216291-600x600.jpg\n','HP'),(27,'Laptop Huawei MateBook D 15 R5 3500U 8GB/256GB+1TB/Win10 (Boh-WAQ9R)',15990000,'CPU: AMD Ryzen 5 3500U 210 GHz\nRAM: 8 GB DDR4 (On board) 2400 MHz\nỔ CỨNG: SSD 256GB NVMe PCIe HDD: 1 TB SATA3\nMàn Hình: 156 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/224257/huawei-matebook-d15-r5-3500u-kg-kg-224257-600x600.jpg\n','Huawei'),(28,'Laptop Dell Vostro 3590 i7 10510U/8GB/256GB/2GB 610R5/Win10 (GRMGK2)',20290000,'CPU: Intel Core i7 Comet Lake 10510U 180 GHz\nRAM: 8 GB DDR4 (On board +1 khe) 2666 MHz\nỔ CỨNG: SSD 256GB NVMe PCIe Hỗ trợ khe cắm HDD SATA\nMàn Hình: 156 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/220718/dell-vostro-3590-i7-grmgk2-220718-220718-600x600.jpg\n','Dell'),(29,'Laptop HP 15s fq0004TU N5000/4GB/512GB/Win10 (1A0D5PA)',8890000,'CPU: Intel Pentium N5000 110 GHz\nRAM: 4 GB DDR4 (1 khe) 2400 MHz\nỔ CỨNG: SSD 512 GB M2 PCIe Hỗ trợ khe cắm HDD SATA\nMàn Hình: 156 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/224010/hp-15s-fq0004tu-n5000-1a0d5pa-224010-1-600x600.jpg\n','HP'),(30,'Laptop Dell Vostro 5490 i5 10210U/8GB/256GB/Win10 (V4I5106W)',17990000,'CPU: Intel Core i5 Comet Lake 10210U 160 GHz\nRAM: 8 GB DDR4 (On board +1 khe) 2666 MHz\nỔ CỨNG: SSD 256GB NVMe PCIe Hỗ trợ khe cắm HDD SATA\nMàn Hình: 14 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/213861/dell-vostro-5490-i5-10210u-8gb-256gb-win10-v4i510-9-213861-600x600.jpg\n','Dell'),(31,'Laptop Asus VivoBook A412FA i3 8145U/4GB/512GB/Win10 (EK342T)',12190000,'CPU: Intel Core i3 Coffee Lake 8145U 210 GHz\nRAM: 4 GB DDR4 (On board +1 khe) 2400 MHz\nỔ CỨNG: SSD 512 GB M2 PCIe Hỗ trợ khe cắm HDD SATA\nMàn Hình: 14 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/203670/asus-vivobook-s412f-i3-8145u-4gb-512gb-ek342t-203670-600x600.jpg\n','Asus'),(32,'Laptop Asus VivoBook A412FA i3 10110U/4GB/32GB+512GB/Win10 (EK1179T)',13290000,'CPU: Intel Core i3 Comet Lake 10110U 210 GHz\nRAM: 4 GB DDR4 (On board +1 khe) 2666 MHz\nỔ CỨNG: Intel Optane 32GB (H10) SSD 512 GB M2 PCIe Hỗ trợ khe cắm HDD SATA\nMàn Hình: 14 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/223980/asus-vivobook-a412fa-i3-ek1179t-223980-1-600x600.jpg\n','Asus'),(33,'Laptop Asus VivoBook A512FL i5 10210U/8GB/512GB/2GB MX250/Win10 (EJ569T)',18190000,'CPU: Intel Core i5 Comet Lake 10210U 160 GHz\nRAM: 8 GB DDR4 (On board 4GB +1 khe 4GB) 2666 MHz\nỔ CỨNG: SSD 512 GB M2 PCIe Hỗ trợ khe cắm HDD SATA\nMàn Hình: 156 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/217320/asus-vivobook-a512fl-i5-10210u-8gb-512gb-2gb-mx250-9-217320-600x600.jpg\n','Asus'),(34,'Laptop HP Envy 13 ba0046TU i5 1035G4/8GB/512GB/Office H&S2019/Win10 (171M7PA)',22990000,'CPU: Intel Core i5 Ice Lake 1035G4 110 GHz\nRAM: 8 GB DDR4 (On board) 3200 MHz\nỔ CỨNG: SSD 512 GB M2 PCIe\nMàn Hình: 133 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/225859/hp-envy-13-ba0046tu-i5-171m7pa-225859-600x600.jpg\n','HP'),(35,'Laptop Asus VivoBook A412FA i5 10210U/8GB/512GB/Win10 (EK738T)',16290000,'CPU: Intel Core i5 Comet Lake 10210U 160 GHz\nRAM: 8 GB DDR4 (On board 4GB +1 khe 4GB) 2666 MHz\nỔ CỨNG: SSD 512 GB M2 PCIe Hỗ trợ khe cắm HDD SATA\nMàn Hình: 14 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/217509/asus-vivobook-a412fa-i5-ek738t-217509-600x600.jpg\n','Asus'),(36,'Laptop HP Pavilion 14 ce3067TU i5 1035G1/8GB/32GB+512GB/Win10 (1A1M7PA)',17990000,'CPU: Intel Core i5 Ice Lake 1035G1 100 GHz\nRAM: 8 GB DDR4 (1 khe) 2666 MHz\nỔ CỨNG: Intel Optane 32GB (H10) SSD 512 GB M2 PCIe\nMàn Hình: 14 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/217509/asus-vivobook-a412fa-i5-ek738t-217509-600x600.jpg\n','HP'),(37,'Laptop Lenovo IdeaPad S340 14IIL i5 1035G1/8GB/512GB/Win10 (81VV003SVN)',15990000,'CPU: Intel Core i5 Ice Lake 1035G1 100 GHz\nRAM: 8 GB DDR4 (On board 4GB +1 khe 4GB) 2666 MHz\nỔ CỨNG: SSD 512 GB M2 PCIe Hỗ trợ khe cắm HDD SATA\nMàn Hình: 14 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/214708/lenovo-ideapad-s340-14iil-i5-1035g1-8gb-512gb-win1-8-214708-2-600x600.jpg\n','Lenovo'),(38,'Laptop Apple MacBook Air 2020 i5 11GHz/8GB/256GB (Z0YL)',31990000,'CPU: Intel Core i5 Thế hệ 10 110 GHz\nRAM: 8 GB LPDDR4X (On board) 3733 MHz\nỔ CỨNG: SSD: 256 GB\nMàn Hình: 133 inch Retina (2560 x 1600)','https://cdn.tgdd.vn/Products/Images/44/220173/apple-macbook-air-2020-vântay-220173-600x600.jpg\n','Apple'),(39,'Laptop Dell Inspiron 5593 i5 1035G1/8GB/512GB/Win10 (7WGNV1)',17990000,'CPU: Intel Core i5 Ice Lake 1035G1 100 GHz\nRAM: 8 GB DDR4 (On board +1 khe) 2666 MHz\nỔ CỨNG: SSD 512 GB M2 PCIe\nMàn Hình: 156 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/213535/dell-inspiron-5593-i5-7wgnv1-213535-600x600.jpg\n','Dell'),(40,'Laptop Dell Inspiron 3580 i5 8265U/4GB/1TB/2GB R520/Win10 (70184569)',13490000,'CPU: Intel Core i5 Coffee Lake 8265U 160 GHz\nRAM: 4 GB DDR4 (2 khe) 2666 MHz\nỔ CỨNG: HDD: 1 TB SATA3 Hỗ trợ khe cắm SSD M2 PCIe\nMàn Hình: 156 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/204047/dell-inspiron-3580-i5-8265u-4gb-1tb-radeon-2gb-70-204047-600x600.jpg\n','Dell'),(41,'Laptop HP 15s du0063TU i5 8265U/4GB/1TB/Win10 (6ZF63PA)',11750000,'CPU: Intel Core i5 Coffee Lake 8265U 160 GHz\nRAM: 4 GB DDR4 (2 khe) 2400 MHz\nỔ CỨNG: HDD: 1 TB SATA3 Hỗ trợ khe cắm SSD M2\nMàn Hình: 156 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/204053/hp-15s-du0063tu-i5-8265u-4gb-1tb-win10-6zf63pa-020720-110758-600x600.jpg\n','HP'),(42,'Laptop Dell Vostro 3580 i5 8265U/4GB/1TB/2GB AMD520/Win10 (P75F010V80I)',14190000,'CPU: Intel Core i5 Coffee Lake 8265U 160 GHz\nRAM: 4 GB DDR4 (2 khe) 2666 MHz\nỔ CỨNG: HDD: 1 TB SATA3 Hỗ trợ khe cắm SSD M2 PCIe\nMàn Hình: 156 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/209423/dell-vostro-3580-i5-8265u-4gb-1tb-2gb-amd520-win10-15-209423-600x600.jpg\n','Dell'),(43,'Laptop Asus Gaming Rog Strix G512 i7 10750H/8GB/512GB/144Hz/4GB GTX1650Ti/Win10 (IAL001T)',28990000,'CPU: Intel Core i7 Comet Lake 10750H 260 GHz\nRAM: 8 GB DDR4 (2 khe) 2933 MHz\nỔ CỨNG: Hỗ trợ thêm 2 khe cắm SSD M2 PCIe SSD 512 GB M2 PCIe\nMàn Hình: 156 inch Full HD (1920 x 1080) 144Hz','https://cdn.tgdd.vn/Products/Images/44/225687/asus-gaming-rog-strix-g512-i7-ial001t-272120-022128-225687-600x600.jpg\n','Asus'),(44,'Laptop Lenovo Ideapad S145 15IWL i7 8565U/8GB/512GB/2GB MX110/Win10 (81MV00TAVN)',18590000,'CPU: Intel Core i7 Coffee Lake 8565U 180 GHz\nRAM: 8 GB DDR4 (On board 4GB +1 khe 4GB) 2400 MHz\nỔ CỨNG: SSD 512 GB M2 PCIe\nMàn Hình: 156 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/207797/lenovo-ideapad-s145-15iwl-i7-8565u-8gb-512gb-mx110-025820-105848-600x600.jpg\n','Lenovo'),(45,'Laptop HP Pavilion 15 cs3010TU i3 1005G1/4GB/256GB/Win10 (8QN78PA)',13590000,'CPU: Intel Core i3 Ice Lake 1005G1 120 GHz\nRAM: 4 GB DDR4 (2 khe) 2666 MHz\nỔ CỨNG: SSD 256GB NVMe PCIe Hỗ trợ khe cắm HDD SATA\nMàn Hình: 156 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/220955/hp-pavilion-15-cs3010tu-i3-8qn78pa-220955-1-600x600.jpg\n','HP'),(46,'Laptop Asus VivoBook A412FA i3 10110U/4GB/512GB/Win10 (EK1175T)',12890000,'CPU: Intel Core i3 Ice Lake 10110U 210 GHz\nRAM: 4 GB DDR4 (On board +1 khe) 2666 MHz\nỔ CỨNG: SSD 512 GB M2 PCIe Hỗ trợ khe cắm HDD SATA\nMàn Hình: 14 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/225610/asus-vivobook-a412fa-i3-ek1175t-225610-600x600.jpg\n','Asus'),(47,'Laptop Lenovo IdeaPad S340 14IIL i3 1005G1/8GB/512GB/Win10 (81VV003VVN)',13990000,'CPU: Intel Core i3 Ice Lake 1005G1 120 GHz\nRAM: 8 GB DDR4 (On board 4GB +1 khe 4GB) 2666 MHz\nỔ CỨNG: SSD 512 GB M2 PCIe Hỗ trợ khe cắm HDD SATA\nMàn Hình: 14 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/214710/lenovo-ideapad-s340-14iil-i3-1005g1-8gb-512gb-win1-20-600x600.jpg\n','Lenovo'),(48,'Laptop HP 15s du1039TX i7 10510U/8GB/512GB/2GB MX130/Win10 (8RK39PA)',18990000,'CPU: Intel Core i7 Comet Lake 10510U 180 GHz\nRAM: 8 GB DDR4 (2 khe) 2666 MHz\nỔ CỨNG: SSD 512 GB M2 PCIe Hỗ trợ khe cắm HDD SATA\nMàn Hình: 156 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/217270/hp-15s-du1039tx-i7-10510u-8gb-512gb-2gb-mx130-win1-217270-1-600x600.jpg\n','HP'),(49,'Laptop Asus Gaming Rog Strix G512 i5 10300H/8GB/512GB/144Hz/4GB GTX1650Ti/Win10 (IAL013T)',24490000,'CPU: Intel Core i5 Comet Lake 10300H 250 GHz\nRAM: 8 GB DDR4 (2 khe) 2933 MHz\nỔ CỨNG: Hỗ trợ thêm 2 khe cắm SSD M2 PCIe SSD 512 GB M2 PCIe\nMàn Hình: 156 inch Full HD (1920 x 1080) 144Hz','https://cdn.tgdd.vn/Products/Images/44/225940/asus-gaming-rog-strix-g512-i5-ial031t-225940-225940-600x600.jpg\n','Asus'),(50,'Laptop HP 15s du0040TX i7 8565U/8GB/1TB/ MX130/Win10 (6ZF62PA)',18290000,'CPU: Intel Core i7 Coffee Lake 8565U 180 GHz\nRAM: 8 GB DDR4 (2 khe) 2400 MHz\nỔ CỨNG: HDD: 1 TB SATA3 Hỗ trợ khe cắm SSD M2 SATA3\nMàn Hình: 156 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/204052/hp-15s-du0040tx-i7-8565u-8gb-1tb-mx130-win10-6zf6-204052-600x600.jpg\n','HP'),(51,'Laptop Dell Inspiron 5490 i5 10210U/8GB/512GB/2GB MX230/Win10 (FMKJV1)',20990000,'CPU: Intel Core i5 Comet Lake 10210U 160 GHz\nRAM: 8 GB DDR4 (On board +1 khe) 2666 MHz\nỔ CỨNG: SSD 512 GB M2 PCIe\nMàn Hình: 14 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/225813/dell-inspiron-5490-i5-fmkjv1-224320-054321-600x600.jpg\n','Dell'),(52,'Laptop HP 15s du1035TX i5 10210U/8GB/512GB/2GB MX130/Win10 (8RK36PA)',17390000,'CPU: Intel Core i5 Comet Lake 10210U 160 GHz\nRAM: 8 GB DDR4 (2 khe) 2666 MHz\nỔ CỨNG: SSD 512 GB M2 PCIe Hỗ trợ khe cắm HDD SATA\nMàn Hình: 156 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/216286/hp-15s-du1035tx-i5-8rk36pa-9-216286-600x600.jpg\n','HP'),(53,'Laptop Acer Nitro AN515 43 R9FD R5 3550H/8GB/512GB/4GB GTX1650/Win10 (NHQ6ZSV003)',19490000,'CPU: AMD Ryzen 5 3550H 210 GHz\nRAM: 8 GB DDR4 (2 khe) 2400 MHz\nỔ CỨNG: SSD 512 GB M2 PCIe Hỗ trợ khe cắm HDD SATA\nMàn Hình: 156 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/221409/acer-nitro-an515-43-r5-nhq6zsv003-221409-600x600.jpg\n','Acer'),(54,'Laptop HP Pavilion 14 ce2100TX i5 8265U/8GB+16GB/1TB/2GB MX130/Win10 (7YA48PA)',14390000,'CPU: Intel Core i5 Coffee Lake 8265U 160 GHz\nRAM: 8 GB DDR4 (1 khe) 2400 MHz\nỔ CỨNG: HDD: 1 TB SATA3 Intel Optane 16GB\nMàn Hình: 14 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/210082/hp-pavilion-14-ce2100tx-i5-8265u-8gb-16gb-1tb-2gb-022120-122105-600x600.jpg\n','HP'),(55,'Laptop Asus VivoBook X509JA i7 1065G7/8GB/512GB/Office H&S2019/Win10 (EJ232TS)',19190000,'CPU: Intel Core i7 Ice Lake 1065G7 130 GHz\nRAM: 8 GB DDR4 (On board 4GB +1 khe 4GB) 2666 MHz\nỔ CỨNG: SSD 512 GB M2 PCIe Hỗ trợ khe cắm HDD SATA\nMàn Hình: 156 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/220576/asus-vivobook-x509ja-i7-ej232ts-vântay-220576-600x600.jpg\n','Asus'),(56,'Laptop HP Envy 13 ba0045TU i5 1035G4/8GB/256GB/Office H&S2019/Win10 (171M2PA)',21990000,'CPU: Intel Core i5 Ice Lake 1035G4 110 GHz\nRAM: 8 GB DDR4 (On board) 3200 MHz\nỔ CỨNG: SSD 256GB NVMe PCIe\nMàn Hình: 133 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/225690/hp-envy-13-ba0045tu-i5-171m2pa-225690-600x600.jpg\n','HP'),(57,'Laptop Dell Vostro 5581 i5 8265U/4GB/1TB/Office365/Win10 (70175950)',15490000,'CPU: Intel Core i5 Coffee Lake 8265U 160 GHz\nRAM: 4 GB DDR4 (2 khe) 2666 MHz\nỔ CỨNG: HDD: 1 TB SATA3 Hỗ trợ khe cắm SSD M2 PCIe\nMàn Hình: 156 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/203138/dell-vostro-5581-i5-8265u-4gb-1tb-office365-win10-1-2-203138-600x600.jpg\n','Dell'),(58,'Laptop Lenovo Gaming 15IMH05 i7 10750H/8GB/512GB/4GB GTX1650/Win10 (81Y40068VN)',23990000,'CPU: Intel Core i7 Comet Lake 10750H 260 GHz\nRAM: 8 GB DDR4 (2 khe) 2933 MHz\nỔ CỨNG: SSD 512 GB M2 PCIe Hỗ trợ khe cắm SSD M2 PCIe Hỗ trợ khe cắm HDD SATA\nMàn Hình: 156 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/225389/lenovo-gaming-15imh05-i7-81y40068vn-225389-600x600.jpg\n','Lenovo'),(59,'Laptop HP 15s fq1105TU i5 1035G1/8GB/512GB/Win10 (193P7PA)',16490000,'CPU: Intel Core i5 Ice Lake 1035G1 100 GHz\nRAM: 8 GB DDR4 (2 khe) 2666 MHz\nỔ CỨNG: SSD 512 GB M2 PCIe Hỗ trợ khe cắm HDD SATA\nMàn Hình: 156 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/223682/hp-15s-fq1105tu-i5-193p7pa-223682-1-600x600.jpg\n','HP'),(60,'Laptop Apple Macbook Air 2020 i5 11GHz 8GB/256GB (Z0YJ)',31990000,'CPU: Intel Core i5 Thế hệ 10 110 GHz\nRAM: 8 GB LPDDR4X (On board) 3733 MHz\nỔ CỨNG: SSD: 256 GB\nMàn Hình: 133 inch Retina (2560 x 1600)','https://cdn.tgdd.vn/Products/Images/44/226170/apple-macbook-air-2020-i5-z0yj-600x600.jpg\n','Apple'),(61,'Laptop Asus VivoBook Gaming F571GT i5 9300H/8GB/32GB+512GB/120Hz/4GB GTX1650/Win10 (AL851T)',21790000,'CPU: Intel Core i5 Coffee Lake 9300H 240 GHz\nRAM: 8 GB DDR4 (On board 4GB +1 khe 4GB) 2666 MHz\nỔ CỨNG: Intel Optane 32GB (H10) SSD 512 GB M2 PCIe Hỗ trợ khe cắm HDD SATA\nMàn Hình: 156 inch Full HD (1920 x 1080) 120Hz','https://cdn.tgdd.vn/Products/Images/44/226255/asus-vivobook-gaming-f571gt-i5-al851t-226255-600x600.jpg\n','Asus'),(62,'Laptop Acer Aspire A315 34 C38Y N4020/4GB/256GB/Win10 (NXHE3SV00G)',7290000,'CPU: Intel Celeron N4020 110 GHz\nRAM: 4 GB DDR4 (On board +1 khe) 2666 MHz\nỔ CỨNG: SSD 256GB NVMe PCIe Hỗ trợ khe cắm HDD SATA\nMàn Hình: 156 inch HD 720 (1280 x 720)','https://cdn.tgdd.vn/Products/Images/44/224120/acer-aspire-a315-n4020-nxhe3sv00g-224120-2-600x600.jpg\n','Acer'),(63,'Laptop Acer Nitro 5 AN515 55 58A7 i5 10300H 8GB/512GB/4GB GTX1650/Win10 (NHQ7RSV002)',23290000,'CPU: Intel Core i5 Comet Lake 10300H 250 GHz\nRAM: 8 GB DDR4 (2 khe) 2933 MHz\nỔ CỨNG: SSD 512 GB M2 PCIe Hỗ trợ khe cắm SSD M2 PCIe Hỗ trợ khe cắm HDD SATA\nMàn Hình: 156 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/223539/acer-nitro-5-an515-55-58a7-i5-nhq7rsv002-100020-120051-600x600.jpg\n','Acer'),(64,'Laptop HP Pavilion 15 cs2120TX i5 8265U/8GB/1TB/2GB MX130/Win10 (8AG58PA)',13590000,'CPU: Intel Core i5 Coffee Lake 8265U 160 GHz\nRAM: 8 GB DDR4 (2 khe) 2666 MHz\nỔ CỨNG: HDD: 1 TB SATA3 Hỗ trợ khe cắm SSD M2 PCIe\nMàn Hình: 156 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/210649/hp-pavilion-15-cs2120tx-i5-8265u-8gb-1tb-2g-mx130-11-210649-600x600.jpg\n','HP'),(65,'Laptop Asus VivoBook A412F i5 10210U/8GB/32GB+512GB/Win10 (EK739T)',16590000,'CPU: Intel Core i5 Comet Lake 10210U 160 GHz\nRAM: 8 GB DDR4 (On board 4GB +1 khe 4GB) 2666 MHz\nỔ CỨNG: Intel Optane 32GB (H10) SSD 512 GB M2 PCIe Hỗ trợ khe cắm HDD SATA\nMàn Hình: 14 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/218865/asus-vivobook-a412f-i510210u-8gb-32gb-512gb-win10-kg-218865-600x600.jpg\n','Asus'),(66,'Laptop Apple MacBook Air 2020 i3 11GHz/8GB/256GB (MWTL2SA/A)',28990000,'CPU: Intel Core i3 Thế hệ 10 110 GHz\nRAM: 8 GB LPDDR4X (On board) 3733 MHz\nỔ CỨNG: SSD: 256 GB\nMàn Hình: 133 inch Retina (2560 x 1600)','https://cdn.tgdd.vn/Products/Images/44/220174/apple-macbook-air-2020-i3-220174-1-600x600.jpg\n','Apple'),(67,'Laptop Lenovo IdeaPad S145 15IIL i5 1035G1/8GB/512GB/Win10 (81W80021VN)',15290000,'CPU: Intel Core i5 Ice Lake 1035G1 100 GHz\nRAM: 8 GB DDR4 (On board 4GB +1 khe 4GB) 2666 MHz\nỔ CỨNG: SSD 512 GB M2 PCIe Hỗ trợ khe cắm HDD SATA\nMàn Hình: 156 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/214720/lenovo-ideapad-s145-15iil-i5-1035g1-8gb-512gb-win1-214720-600x600.jpg\n','Lenovo'),(68,'Laptop Asus VivoBook S530FN i7 8565U/8GB+16GB/1TB/2GB MX150/Win10 (BQ550T)',21790000,'CPU: Intel Core i7 Coffee Lake 8565U 180 GHz\nRAM: 8 GB DDR4 (2 khe) 2400 MHz\nỔ CỨNG: HDD: 1 TB SATA3 Intel Optane 16GB\nMàn Hình: 156 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/203137/asus-s530f-i7-bq550t-040720-100759-203137-600x600.jpg\n','Asus'),(69,'Laptop Asus VivoBook Gaming F571GT i7 9750H/8GB/32GB+512GB/120Hz/4GB GTX1650/Win10 (AL858T)',24490000,'CPU: Intel Core i7 Coffee Lake 9750H 260 GHz\nRAM: 8 GB DDR4 (On board 4GB +1 khe 4GB) 2666 MHz\nỔ CỨNG: Intel Optane 32GB (H10) SSD 512 GB M2 PCIe Hỗ trợ khe cắm HDD SATA\nMàn Hình: 156 inch Full HD (1920 x 1080) 120Hz','https://cdn.tgdd.vn/Products/Images/44/203454/dell-inspiron-3480-i3-8145u-4gb-1tb-win10-nt4x01-203454-600x600.jpg\n','Asus'),(70,'Laptop Dell Inspiron 3480 i3 8145U/4GB/1TB/Win10 (NT4X01)',10790000,'CPU: Intel Core i3 Coffee Lake 8145U 210 GHz\nRAM: 4 GB DDR4 (2 khe) 2666 MHz\nỔ CỨNG: HDD: 1 TB SATA3 Hỗ trợ khe cắm SSD M2 PCIe\nMàn Hình: 14 inch HD (1366 x 768)','https://cdn.tgdd.vn/Products/Images/44/210665/acer-aspire-a315-34-c2h9-n4000-4gb-256gb-win10-nx-210665-600x600.jpg\n','Dell'),(71,'Laptop Acer Aspire A315 34 C2H9 N4000/4GB/256GB/Win10 (NXHE3SV005)',6990000,'CPU: Intel Celeron N4000 110 GHz\nRAM: 4 GB DDR4 (On board +1 khe) 2400 MHz\nỔ CỨNG: SSD 256GB NVMe PCIe Hỗ trợ khe cắm HDD SATA\nMàn Hình: 156 inch HD (1366 x 768)','https://cdn.tgdd.vn/Products/Images/44/204049/hp-pavilion-x360-dh0103tu-i3-8145u-4gb-1tb-touch-w-20-204049-600x600.jpg\n','Acer'),(72,'Laptop HP Pavilion x360 dh0103TU i3 8145U/4GB/1TB/Touch/Win10 (6ZF24PA)',10630000,'CPU: Intel Core i3 Coffee Lake 8145U 210 GHz\nRAM: 4 GB DDR4 (2 khe) 2666 MHz\nỔ CỨNG: HDD: 1 TB SATA3 Hỗ trợ khe cắm SSD M2 SATA3\nMàn Hình: 14 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/222634/lenovo-ideapad-5-15iil05-i3-81yk004tvn-024920-104953-600x600.jpg\n','HP'),(73,'Laptop Lenovo IdeaPad Slim 5 15IIL05 i3 1005G1/8GB/512GB/Win10 (81YK004TVN)',14990000,'CPU: Intel Core i3 Ice Lake 1005G1 120 GHz\nRAM: 8 GB DDR4 (On board) 3200 MHz\nỔ CỨNG: SSD 512 GB M2 PCIe Hỗ trợ khe cắm HDD SATA\nMàn Hình: 156 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/224583/acer-aspire-3-a315-56-i3-nxhs5sv008-8-1-224583-600x600.jpg\n','Lenovo'),(74,'Laptop Acer Aspire 3 A315 56 36YS i3 1005G1/8GB/512GB/Win10 (NXHS5SV008)',13990000,'CPU: Intel Core i3 Ice Lake 1005G1 120 GHz\nRAM: 8 GB DDR4 (On board 4GB +1 khe 4GB) 2400 MHz\nỔ CỨNG: SSD 512 GB M2 PCIe Hỗ trợ khe cắm HDD SATA\nMàn Hình: 156 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/220574/asus-vivobook-a512fa-i3-ej1868t-220574-600x600.jpg\n','Acer'),(75,'Laptop Asus VivoBook A512FA i3 8145U/4GB/512GB/Win10 (EJ1868T)',12490000,'CPU: Intel Core i3 Coffee Lake 8145U 210 GHz\nRAM: 4 GB DDR4 (On board +1 khe) 2400 MHz\nỔ CỨNG: SSD 512GB Hỗ trợ khe cắm HDD SATA\nMàn Hình: 156 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/217440/lenovo-ideapad-s340-i5-81vw00a8vn-1-217440-600x600.jpg\n','Asus'),(76,'Laptop Lenovo IdeaPad S340 15IIL i5 1035G4/8GB/512GB/Win10 (81VW00A8VN)',16290000,'CPU: Intel Core i5 Ice Lake 1035G4 110 GHz\nRAM: 8 GB DDR4 (On board 4GB +1 khe 4GB) 2666 MHz\nỔ CỨNG: SSD 512 GB M2 PCIe Hỗ trợ khe cắm HDD SATA\nMàn Hình: 156 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/205975/dell-inspiron-5584-i3-8145u-4gb-1tb-win10-7018684a4-205975-600x600.jpg\n','Lenovo'),(77,'Laptop Dell Inspiron 5584 i3 8145U/4GB/1TB/Win10 (70186849)',12390000,'CPU: Intel Core i3 Coffee Lake 8145U 210 GHz\nRAM: 4 GB DDR4 (2 khe) 2666 MHz\nỔ CỨNG: HDD: 1 TB SATA3 Hỗ trợ khe cắm SSD M2 PCIe\nMàn Hình: 156 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/210080/hp-15s-du0056tu-i3-7020u-4gb-1tb-win10-6zf53pa-17-210080-600x600.jpg\n','Dell'),(78,'Laptop HP 15s du0056TU i3 7020U/4GB/1TB/Win10 (6ZF53PA)',10990000,'CPU: Intel Core i3 Kabylake 7020U 230 GHz\nRAM: 4 GB DDR4 (2 khe) 2133 MHz\nỔ CỨNG: HDD: 1 TB SATA3 Hỗ trợ khe cắm SSD M2 PCIe\nMàn Hình: 156 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/227709/hp-15s-du1056tu-6405u-1w7r5pa-600x600.jpg\n','HP'),(79,'Laptop HP 15s du1056TU 6405U/4GB/512GB/Win10 (1W7R5PA)',9290000,'CPU: Intel Pentium 6405U 240 GHz\nRAM: 4 GB DDR4 (1 khe) 2400 MHz\nỔ CỨNG: SSD 512 GB M2 PCIe Hỗ trợ khe cắm HDD SATA\nMàn Hình: 156 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/223657/acer-aspire-a514-53-5921-i5-nxhupsv001-223657-1-600x600.jpg\n','HP'),(80,'Laptop Acer Aspire A514 53 5921 i5 1035G1/8GB/512GB/Win10 (NXHUPSV001)',16990000,'CPU: Intel Core i5 Ice Lake 1035G1 100 GHz\nRAM: 8 GB DDR4 (On board 4GB +1 khe 4GB) 2666 MHz\nỔ CỨNG: SSD 512 GB M2 PCIe Hỗ trợ khe cắm HDD SATA\nMàn Hình: 14 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/223657/acer-aspire-a514-53-5921-i5-nxhupsv001-223657-1-600x600.jpg\n','Acer'),(81,'Laptop Lenovo ThinkBook 14IML i3 10110U/4GB/256GB/Win10 (20RV00B7VN)',13490000,'CPU: Intel Core i3 Comet Lake 10110U 210 GHz\nRAM: 4 GB DDR4 (On board +1 khe) 2666 MHz\nỔ CỨNG: SSD 256GB NVMe PCIe Hỗ trợ khe cắm HDD SATA\nMàn Hình: 14 inch Full HD (1920 x 1080)','https://cdn.tgdd.vn/Products/Images/44/217440/lenovo-ideapad-s340-i5-81vw00a8vn-1-217440-600x600.jpg\n','Lenovo');
/*!40000 ALTER TABLE `Product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Users`
--

DROP TABLE IF EXISTS `Users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Users` (
  `userNumber` int NOT NULL AUTO_INCREMENT,
  `userFullName` varchar(255) NOT NULL,
  `userPhoneNumber` varchar(255) NOT NULL,
  `userAddress` varchar(400) NOT NULL,
  `userEmail` varchar(300) NOT NULL,
  PRIMARY KEY (`userNumber`),
  UNIQUE KEY `userNumber_UNIQUE` (`userNumber`),
  UNIQUE KEY `userEmail_UNIQUE` (`userEmail`),
  CONSTRAINT `Users_ibfk_1` FOREIGN KEY (`userEmail`) REFERENCES `Accounts` (`email`),
  CONSTRAINT `Users_ibfk_2` FOREIGN KEY (`userEmail`) REFERENCES `Accounts` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Users`
--

LOCK TABLES `Users` WRITE;
/*!40000 ALTER TABLE `Users` DISABLE KEYS */;
/*!40000 ALTER TABLE `Users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-09-07 12:01:49
