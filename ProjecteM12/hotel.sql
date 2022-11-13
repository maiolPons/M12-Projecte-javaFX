-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 13, 2022 at 03:12 PM
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
  `estatCivil` varchar(40) NOT NULL,
  `eliminatClient` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `client`
--

INSERT INTO `client` (`dni`, `nomClient`, `dataNaixament`, `sexe`, `nacionalitat`, `telefon`, `email`, `ocupacio`, `estatCivil`, `eliminatClient`) VALUES
('123456789', 'maxe', '2022-09-15', 'Home', 'mataro', '345345', 'asdas@asd.com', 'comercialg', 'Separat', 0),
('awaw', 'awaw', '2022-10-20', 'dona', 'awaw', 'awaw', 'awaw', 'Casat', 'awaw', 1),
('dfgdfggfd', 'asd', '2022-09-29', 'altres', 'asd', 'asd', 'dfgdfgdfg', 'asd', 'Unio lliure', 0),
('eloi', 'eloi', '2022-10-20', 'dona', 'eloi', 'eloi', 'eloi', 'Casat', 'eloi', 1),
('maiol', 'maiol', '2022-10-20', 'altres', 'maiol', 'maiol', 'maiol', 'Unio lliure', 'maiol', 1);

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
('96042060L', ' lluis', 'blade', 'admin', '21232f297a57a5a743894a0e4a801fc3', 'Catalana', '92374032', 'lluis@gmail.com', 'admin', 'si'),
('aa', 'd', 'asd', 'asdas', '196b0f14eba66e10fba74dbf9e99c22f', 'sda', 'sdas', 'asdas', NULL, 'si'),
('eloi', 'eloi', 'eloi', 'eloi', '3d43405a2720862f368745afa50793b4', 'eloi', 'eloi', 'eloi', NULL, 'si'),
('ex', 'ex', 'ex', 'exex', '54d54a126a783bc9cba8c06137136943', 'ex', 'ex', 'ex', NULL, 'no'),
('fgh', 'fgh', 'fgh', 'fghfg', 'df70df7a415d835f0aa7377c0f408f92', 'fgh', 'fgh', 'fgh', NULL, 'si'),
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
(3, '27', 656, 'Suite', 1, 3, 2, 1, 1),
(4, '456', 456, 'Suite', 1, 456, 5, 1, 0),
(6, '5', 200, 'Suite', 1, 2, 5, 0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `reserva`
--

CREATE TABLE `reserva` (
  `idReserva` int(90) NOT NULL,
  `dataEntrada` date NOT NULL,
  `dataSortida` date NOT NULL,
  `fkdniClient` varchar(9) NOT NULL,
  `fkdniEmpleat` varchar(9) NOT NULL,
  `fknumHabitacio` int(11) NOT NULL,
  `pagamentRealitzat` tinyint(1) NOT NULL,
  `observacions` longtext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `reserva`
--

INSERT INTO `reserva` (`idReserva`, `dataEntrada`, `dataSortida`, `fkdniClient`, `fkdniEmpleat`, `fknumHabitacio`, `pagamentRealitzat`, `observacions`) VALUES
(1, '2022-10-12', '2022-10-15', '123456789', 'maiol', 1, 1, ''),
(3, '2022-10-26', '2022-10-29', '123456789', 'maiol', 3, 0, 's'),
(4, '2022-10-17', '2022-10-19', 'dfgdfggfd', 'maiol', 4, 0, 'as '),
(5, '2022-10-17', '2022-10-20', '123456789', 'maiol', 1, 0, ' '),
(6, '2022-10-16', '2022-10-19', 'dfgdfggfd', 'maiol', 3, 0, ''),
(7, '2022-10-20', '2022-10-29', 'dfgdfggfd', 'maiol', 4, 1, ''),
(8, '2022-10-24', '2022-10-27', '123456789', 'maiol', 1, 1, ''),
(9, '2022-10-24', '2022-10-27', '123456789', 'maiol', 1, 1, ''),
(10, '2022-10-21', '2022-10-22', '123456789', 'maiol', 1, 1, ''),
(11, '2022-10-28', '2022-10-29', '123456789', 'maiol', 1, 1, ''),
(12, '2022-10-24', '2022-10-28', 'dfgdfggfd', 'maiol', 6, 1, ''),
(13, '2022-10-23', '2022-10-24', '123456789', 'maiol', 3, 1, ''),
(14, '2022-10-30', '2022-10-31', 'dfgdfggfd', 'maiol', 3, 1, ''),
(15, '2022-10-30', '2022-10-31', '123456789', 'maiol', 6, 1, ''),
(16, '2022-10-18', '2022-10-19', 'dfgdfggfd', 'maiol', 6, 1, ''),
(17, '2022-10-15', '2022-10-16', '123456789', 'maiol', 4, 1, ''),
(18, '2023-10-10', '2023-10-13', 'dfgdfggfd', 'maiol', 6, 1, ''),
(19, '2022-10-30', '2022-10-31', '123456789', 'maiol', 4, 0, 'asdasdasdasdasdasdasdasdasdasdasdasdasdaasdasdasdas'),
(20, '2022-11-01', '2022-11-03', '123456789', 'maiol', 4, 1, ''),
(21, '2022-10-21', '2022-10-22', '123456789', 'maiol', 6, 1, 'ergerge'),
(22, '2022-11-07', '2022-11-08', 'dfgdfggfd', 'maiol', 6, 1, ''),
(23, '2022-11-22', '2022-11-24', 'dfgdfggfd', 'maiol', 6, 1, ''),
(24, '2022-11-14', '2022-11-16', 'dfgdfggfd', 'maiol', 6, 1, ''),
(25, '2022-11-27', '2022-11-27', '123456789', 'maiol', 6, 1, ''),
(26, '2022-11-15', '2022-11-19', 'dfgdfggfd', 'maiol', 3, 1, ''),
(27, '2022-11-15', '2022-11-17', 'awaw', 'maiol', 4, 1, 'Call of the wild call of the wild call of the wild call of the wild Call of the wild call of the wild call of the wild call of the wild Call of the wild call of the wild call of the wild call of the wild Call of the wild call of the wild call of the wild call of the wild');

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
  ADD KEY `fk.dniClient` (`fkdniClient`,`fkdniEmpleat`,`fknumHabitacio`),
  ADD KEY `fk.numHabitacio` (`fknumHabitacio`),
  ADD KEY `fk.dniEmpleat` (`fkdniEmpleat`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `reserva`
--
ALTER TABLE `reserva`
  MODIFY `idReserva` int(90) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `reserva`
--
ALTER TABLE `reserva`
  ADD CONSTRAINT `reserva_ibfk_1` FOREIGN KEY (`fknumHabitacio`) REFERENCES `habitacio` (`numHabitacio`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `reserva_ibfk_2` FOREIGN KEY (`fkdniEmpleat`) REFERENCES `empleats` (`dni`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `reserva_ibfk_3` FOREIGN KEY (`fkdniClient`) REFERENCES `client` (`dni`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
