CREATE DATABASE  IF NOT EXISTS `apolo` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `apolo`;
-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: localhost    Database: apolo
-- ------------------------------------------------------
-- Server version	8.0.40

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
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categoria` (
  `CategoriaID` varchar(50) NOT NULL,
  PRIMARY KEY (`CategoriaID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `ClienteID` int unsigned NOT NULL AUTO_INCREMENT,
  `Nombres` varchar(50) DEFAULT NULL,
  `Edad` int unsigned DEFAULT NULL,
  `Telefono` varchar(9) DEFAULT NULL,
  `Direccion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ClienteID`),
  CONSTRAINT `cliente_chk_1` CHECK ((`Edad` < 125))
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `detalleventa`
--

DROP TABLE IF EXISTS `detalleventa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalleventa` (
  `VentaID` int unsigned NOT NULL,
  `ProductoID` int unsigned NOT NULL,
  `Cantidad` int unsigned NOT NULL,
  `MontoTotal` decimal(20,3) unsigned DEFAULT NULL,
  KEY `fk_VentaID` (`VentaID`),
  KEY `fk_ProductoID` (`ProductoID`),
  CONSTRAINT `fk_ProductoID` FOREIGN KEY (`ProductoID`) REFERENCES `producto` (`ProductoID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_VentaID` FOREIGN KEY (`VentaID`) REFERENCES `venta` (`VentaID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `chk_MontoTotal` CHECK ((`MontoTotal` >= 0)),
  CONSTRAINT `detalleventa_chk_1` CHECK ((`MontoTotal` >= 0))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `ProductoID` int unsigned NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Precio` decimal(20,3) NOT NULL,
  `Descripcion` varchar(100) DEFAULT NULL,
  `Stock` int unsigned NOT NULL,
  `CodigoBarras` bigint unsigned NOT NULL,
  `UbicacionAlmacen` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ProductoID`),
  UNIQUE KEY `CodigoBarras` (`CodigoBarras`),
  UNIQUE KEY `CodigoBarras_2` (`CodigoBarras`),
  UNIQUE KEY `CodigoBarras_3` (`CodigoBarras`),
  CONSTRAINT `chk_Stock` CHECK ((`Stock` >= 0)),
  CONSTRAINT `producto_chk_1` CHECK ((`Precio` >= 0))
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `productoxcategoria`
--

DROP TABLE IF EXISTS `productoxcategoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productoxcategoria` (
  `ProductoID` int unsigned NOT NULL,
  `CategoriaID` varchar(50) NOT NULL,
  KEY `fk1_ProductoXCategoria` (`ProductoID`),
  KEY `fk2_ProductoXCategoria` (`CategoriaID`),
  CONSTRAINT `fk1_ProductoXCategoria` FOREIGN KEY (`ProductoID`) REFERENCES `producto` (`ProductoID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk2_ProductoXCategoria` FOREIGN KEY (`CategoriaID`) REFERENCES `categoria` (`CategoriaID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `productoxstockentrada`
--

DROP TABLE IF EXISTS `productoxstockentrada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productoxstockentrada` (
  `ProductoID` int unsigned NOT NULL,
  `StockEntradaID` int unsigned NOT NULL,
  KEY `fk_productoxstockentrada_ProductoID` (`ProductoID`),
  KEY `fk_productoxstockentrada_StockEntradaID` (`StockEntradaID`),
  CONSTRAINT `fk_productoxstockentrada_ProductoID` FOREIGN KEY (`ProductoID`) REFERENCES `producto` (`ProductoID`),
  CONSTRAINT `fk_productoxstockentrada_StockEntradaID` FOREIGN KEY (`StockEntradaID`) REFERENCES `stockentrada` (`StockEntradaID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedor` (
  `ProveedorID` int unsigned NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(50) NOT NULL,
  `Direccion` varchar(50) NOT NULL,
  `Telefono` varchar(9) NOT NULL,
  `Correo` varchar(50) NOT NULL,
  PRIMARY KEY (`ProveedorID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `stockentrada`
--

DROP TABLE IF EXISTS `stockentrada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stockentrada` (
  `StockEntradaID` int unsigned NOT NULL AUTO_INCREMENT,
  `FechaStock` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Cantidad` int unsigned NOT NULL,
  PRIMARY KEY (`StockEntradaID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `stockentradaxproveedor`
--

DROP TABLE IF EXISTS `stockentradaxproveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stockentradaxproveedor` (
  `StockEntradaID` int unsigned NOT NULL,
  `ProveedorID` int unsigned NOT NULL,
  KEY `fk_stockentradaxproveedor_StockEntradaID` (`StockEntradaID`),
  KEY `fk_stockentradaxproveedor_ProveedorID` (`ProveedorID`),
  CONSTRAINT `fk_stockentradaxproveedor_ProveedorID` FOREIGN KEY (`ProveedorID`) REFERENCES `proveedor` (`ProveedorID`),
  CONSTRAINT `fk_stockentradaxproveedor_StockEntradaID` FOREIGN KEY (`StockEntradaID`) REFERENCES `stockentrada` (`StockEntradaID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `vendedor`
--

DROP TABLE IF EXISTS `vendedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vendedor` (
  `VendedorID` int unsigned NOT NULL AUTO_INCREMENT,
  `Nombres` varchar(50) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `Contrasena` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`VendedorID`),
  UNIQUE KEY `Usuario` (`Usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `venta`
--

DROP TABLE IF EXISTS `venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venta` (
  `VentaID` int unsigned NOT NULL AUTO_INCREMENT,
  `VendedorID` int unsigned NOT NULL,
  `ClienteID` int unsigned NOT NULL,
  `FechaVenta` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `MontoTotal` decimal(20,3) NOT NULL,
  PRIMARY KEY (`VentaID`),
  KEY `fk_VendedorID` (`VendedorID`),
  KEY `fk_ClienteID` (`ClienteID`),
  CONSTRAINT `fk_ClienteID` FOREIGN KEY (`ClienteID`) REFERENCES `cliente` (`ClienteID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_VendedorID` FOREIGN KEY (`VendedorID`) REFERENCES `vendedor` (`VendedorID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `venta_chk_1` CHECK ((`MontoTotal` >= 0))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-15  4:02:48
