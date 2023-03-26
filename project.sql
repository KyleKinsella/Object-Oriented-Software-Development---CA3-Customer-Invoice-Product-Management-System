-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Mar 26, 2023 at 01:02 PM
-- Server version: 5.7.36
-- PHP Version: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `project`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE IF NOT EXISTS `customer` (
  `CustomerId` int(5) NOT NULL AUTO_INCREMENT,
  `Name` varchar(35) DEFAULT NULL,
  `DateOfBirth` varchar(15) NOT NULL,
  `Email` varchar(60) DEFAULT NULL,
  `PhoneNumber` int(10) DEFAULT NULL,
  `Password` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`CustomerId`)
) ENGINE=MyISAM AUTO_INCREMENT=123456791 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`CustomerId`, `Name`, `DateOfBirth`, `Email`, `PhoneNumber`, `Password`) VALUES
(55990, 'Wilson', '4-9-2019', 'willfarrel@yahoo.com', 897654325, '0988765trf'),
(78970, 'Mando', '1-2-2022', 'kk@gmail.com', 1234567890, '1234567yui'),
(1, 'Dylan', '22-06-2003', 'fortnite@gmail.com', 870897821, '123456789j'),
(75089, 'Barry', '03-02-2022', 'barryF@yahoo.com', 1234567895, '123456789p');

-- --------------------------------------------------------

--
-- Table structure for table `invoice`
--

DROP TABLE IF EXISTS `invoice`;
CREATE TABLE IF NOT EXISTS `invoice` (
  `InvoiceId` int(20) NOT NULL AUTO_INCREMENT,
  `CompanyName` varchar(35) DEFAULT NULL,
  `Address` varchar(100) DEFAULT NULL,
  `PhoneNumber` int(10) DEFAULT NULL,
  `Email` varchar(60) DEFAULT NULL,
  `Description` varchar(500) DEFAULT NULL,
  `Date` varchar(15) NOT NULL,
  PRIMARY KEY (`InvoiceId`)
) ENGINE=MyISAM AUTO_INCREMENT=2112010 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `invoice`
--

INSERT INTO `invoice` (`InvoiceId`, `CompanyName`, `Address`, `PhoneNumber`, `Email`, `Description`, `Date`) VALUES
(45679, 'Karts', 'Strawberry street', 1234567897, 'kk@gmail.com', 'Have fun', '2-2-2023'),
(34456, 'Fruits', 'Rasberry street', 1234567895, 'fruit@yahoo.com', 'Eat health', '23-02-2023'),
(34490, 'We sell Furniture', 'Furniture street', 876983512, 'wesellFurniture@gmail.com', 'Stay comfortable', '19-04-2020'),
(66553, 'Clothes', 'Clothes street', 898765432, 'weSellClothes@gmail.com', 'Stay drippy', '23-02-2022');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE IF NOT EXISTS `product` (
  `ProductId` int(20) NOT NULL AUTO_INCREMENT,
  `NameOfProduct` varchar(50) DEFAULT NULL,
  `NumberOfProductsBought` int(200) DEFAULT NULL,
  `ColorOfProduct` varchar(7) DEFAULT NULL,
  `PriceOfProduct` int(255) DEFAULT NULL,
  PRIMARY KEY (`ProductId`)
) ENGINE=MyISAM AUTO_INCREMENT=90908 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`ProductId`, `NameOfProduct`, `NumberOfProductsBought`, `ColorOfProduct`, `PriceOfProduct`) VALUES
(6, 'Hammer', 10, 'Red', 100),
(12345, 'Couch', 201, 'black', 50),
(90872, 'Watch', 4, 'yellow', 500),
(90907, 'Earphones', 1, 'Red', 150),
(54321, 'Speaker', 2, 'blue', 250),
(15790, 'Bed', 3, 'Brown', 150),
(65432, 'Hanger', 50, 'Red', 10);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
