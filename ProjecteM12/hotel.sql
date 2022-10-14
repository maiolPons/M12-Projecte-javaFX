-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 30, 2022 at 10:11 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hotel`
--

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

CREATE TABLE `client` (
  `dni` varchar(9) NOT NULL,
  `nomClient` varchar(40) NOT NULL,
  `dataNaixament` date NOT NULL,
  `sexe` varchar(50) NOT NULL,
  `nacionalitat` varchar(60) NOT NULL,
  `telefon` varchar(20) NOT NULL,
  `email` varchar(90) NOT NULL,
  `ocupacio` varchar(40) NOT NULL,
  `estatCivil` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `client`
--

INSERT INTO `client` (`dni`, `nomClient`, `dataNaixament`, `sexe`, `nacionalitat`, `telefon`, `email`, `ocupacio`, `estatCivil`) VALUES
('123456789', 'max', '2022-09-15', 'Home', 'mataro', '345345', 'asdas@asd.com', 'Separat', 'comercialg'),
('asddddddd', 'asd', '2022-09-29', 'altres', 'asd', 'asd', 'dfgdfgdfg', 'Unio lliure', 'asd'),
('Separat', 'Separat', '2022-09-30', 'dona', 'Separat', 'Separat', 'Separat', 'Casat', 'Separat');

-- --------------------------------------------------------

--
-- Table structure for table `empleats`
--

CREATE TABLE `empleats` (
  `dni` varchar(9) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `cognoms` varchar(50) NOT NULL,
  `nomUsuari` varchar(50) NOT NULL,
  `contrasenya` varchar(60) NOT NULL,
  `nacionalitat` varchar(50) NOT NULL,
  `telefon` varchar(20) NOT NULL,
  `email` varchar(60) NOT NULL,
  `admin` varchar(10) DEFAULT NULL,
  `validat` varchar(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `empleats`
--

INSERT INTO `empleats` (`dni`, `nom`, `cognoms`, `nomUsuari`, `contrasenya`, `nacionalitat`, `telefon`, `email`, `admin`, `validat`) VALUES
('38875608L', 'Maiol', 'pons i Billà', 'maiolpons', 'maiol', 'Catalana', '546346342', 'maiol@gmail.com', NULL, 'no'),
('4', '4', '4', '4', 'a87ff679a2f3e71d9181a67b7542122c', '4', '4', '4', NULL, 'no'),
('96042060L', ' lluis', 'blade', 'admin', '21232f297a57a5a743894a0e4a801fc3', 'Catalana', '92374032', 'lluis@gmail.com', 'admin', 'si'),
('aa', 'd', 'asd', 'asdas', '196b0f14eba66e10fba74dbf9e99c22f', 'sda', 'sdas', 'asdas', NULL, 'no'),
('eloi', 'eloi', 'eloi', 'eloi', '3d43405a2720862f368745afa50793b4', 'eloi', 'eloi', 'eloi', NULL, 'si'),
('fgh', 'fgh', 'fgh', 'fghfg', 'df70df7a415d835f0aa7377c0f408f92', 'fgh', 'fgh', 'fgh', NULL, 'no'),
('gfhfgh', 'hfgh', 'fgh', 'hfgh', '3c97f91afa8fb9af0794af239cbbb058', 'h', 'fghfgh', 'df', NULL, 'no'),
('maiol', 'maiol', 'maiol', 'maiol', '5f0ad77b699eac25ce0d04e3a4ae4271', 'maiol', 'maiol', 'maiol', NULL, 'si'),
('marc435', 'maec', 'mrace', 'marc', '97e1e59c0375e0f55c10d4314db20466', 'marquestine', '235', 'marc@gmail.com', NULL, 'no'),
('teller', 'teller', 'teller', 'teller', '8482dfb1bca15b503101eb438f52deed', 'teller', 'teller', 'teller', NULL, 'si');

-- --------------------------------------------------------

--
-- Table structure for table `habitacio`
--

CREATE TABLE `habitacio` (
  `numHabitacio` int(11) NOT NULL,
  `planta` varchar(10) NOT NULL,
  `preu` double NOT NULL,
  `tipus` varchar(30) NOT NULL,
  `estat` tinyint(1) NOT NULL,
  `numeroLlitsDobles` int(11) NOT NULL,
  `numeroLlitsNormals` int(11) NOT NULL,
  `cuina` tinyint(1) NOT NULL,
  `vistaMar` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `habitacio`
--

INSERT INTO `habitacio` (`numHabitacio`, `planta`, `preu`, `tipus`, `estat`, `numeroLlitsDobles`, `numeroLlitsNormals`, `cuina`, `vistaMar`) VALUES
(1, '1', 200, 'familiar', 1, 1, 2, 1, 1),
(2, '2', 5000, 'Suite', 0, 3, 10, 1, 1),
(3, '2', 656, 'Suite', 1, 3, 2, 1, 1),
(4, '456', 456, 'Suite', 0, 456, 456, 1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `reserva`
--

CREATE TABLE `reserva` (
  `idReserva` varchar(90) NOT NULL,
  `dataEntrada` date NOT NULL,
  `dataSortida` date NOT NULL,
  `fk.dniClient` varchar(9) NOT NULL,
  `fk.dniEmpleat` varchar(9) NOT NULL,
  `fk.numHabitacio` int(11) NOT NULL,
  `pagamentRealitzat` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`dni`);

--
-- Indexes for table `empleats`
--
ALTER TABLE `empleats`
  ADD PRIMARY KEY (`dni`),
  ADD UNIQUE KEY `numUsuari` (`nomUsuari`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `habitacio`
--
ALTER TABLE `habitacio`
  ADD PRIMARY KEY (`numHabitacio`);

--
-- Indexes for table `reserva`
--
ALTER TABLE `reserva`
  ADD PRIMARY KEY (`idReserva`),
  ADD KEY `fk.dniClient` (`fk.dniClient`,`fk.dniEmpleat`,`fk.numHabitacio`),
  ADD KEY `fk.numHabitacio` (`fk.numHabitacio`),
  ADD KEY `fk.dniEmpleat` (`fk.dniEmpleat`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `reserva`
--
ALTER TABLE `reserva`
  ADD CONSTRAINT `reserva_ibfk_1` FOREIGN KEY (`fk.numHabitacio`) REFERENCES `habitacio` (`numHabitacio`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `reserva_ibfk_2` FOREIGN KEY (`fk.dniEmpleat`) REFERENCES `empleats` (`dni`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `reserva_ibfk_3` FOREIGN KEY (`fk.dniClient`) REFERENCES `client` (`dni`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
