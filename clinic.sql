-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 07, 2022 at 01:07 PM
-- Server version: 5.5.8
-- PHP Version: 5.3.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `clinic`
--

-- --------------------------------------------------------

--
-- Table structure for table `administrator`
--

CREATE TABLE IF NOT EXISTS `administrator` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `administrator`
--

INSERT INTO `administrator` (`username`, `password`) VALUES
('abubakar', '12345678'),
('ahmad', '12345678'),
('talha', '12345678');

-- --------------------------------------------------------

--
-- Table structure for table `appointment`
--

CREATE TABLE IF NOT EXISTS `appointment` (
  `APT_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `DR_ID` int(11) NOT NULL,
  `P_ID` int(11) NOT NULL,
  `APT_NO` int(11) NOT NULL,
  `APT_FEE` int(11) NOT NULL,
  PRIMARY KEY (`APT_DATE`,`DR_ID`,`P_ID`,`APT_NO`),
  KEY `DR_ID` (`DR_ID`),
  KEY `P_ID` (`P_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `appointment`
--

INSERT INTO `appointment` (`APT_DATE`, `DR_ID`, `P_ID`, `APT_NO`, `APT_FEE`) VALUES
('2022-02-05 00:00:00', 1, 2, 1, 1000),
('2022-02-06 16:15:54', 1, 1, 1, 1000);

-- --------------------------------------------------------

--
-- Table structure for table `bed`
--

CREATE TABLE IF NOT EXISTS `bed` (
  `BED_NO` int(10) NOT NULL AUTO_INCREMENT,
  `WRD_NO` int(11) NOT NULL,
  `BED_TYPE` varchar(20) NOT NULL,
  `Available` int(11) NOT NULL,
  PRIMARY KEY (`BED_NO`,`WRD_NO`),
  KEY `WRD_NO` (`WRD_NO`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `bed`
--

INSERT INTO `bed` (`BED_NO`, `WRD_NO`, `BED_TYPE`, `Available`) VALUES
(1, 1, '1', 0),
(2, 2, '2', 0);

-- --------------------------------------------------------

--
-- Table structure for table `bill`
--

CREATE TABLE IF NOT EXISTS `bill` (
  `BILL_NO` int(10) NOT NULL AUTO_INCREMENT,
  `P_ID` int(11) NOT NULL,
  `BILL_AMOUNT` int(11) NOT NULL,
  `BILL_DATE` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`BILL_NO`,`P_ID`,`BILL_DATE`),
  UNIQUE KEY `BILL_NO` (`BILL_NO`),
  KEY `P_ID` (`P_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `bill`
--

INSERT INTO `bill` (`BILL_NO`, `P_ID`, `BILL_AMOUNT`, `BILL_DATE`) VALUES
(1, 1, 1000, '2022-02-06 16:15:54'),
(2, 1, 10000, '2022-02-06 16:20:44'),
(4, 2, 10000, '2022-02-06 17:49:07');

-- --------------------------------------------------------

--
-- Table structure for table `booking_record`
--

CREATE TABLE IF NOT EXISTS `booking_record` (
  `BED_NO` int(11) NOT NULL,
  `BREC_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `P_ID` int(11) NOT NULL,
  `BREC_DAYS` int(11) NOT NULL,
  PRIMARY KEY (`BED_NO`,`BREC_DATE`,`P_ID`),
  KEY `P_ID` (`P_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `booking_record`
--

INSERT INTO `booking_record` (`BED_NO`, `BREC_DATE`, `P_ID`, `BREC_DAYS`) VALUES
(1, '2022-02-06 16:16:11', 1, 10),
(1, '2022-02-06 16:20:44', 1, 10),
(2, '2022-02-06 17:49:07', 2, 10);

-- --------------------------------------------------------

--
-- Table structure for table `doctor`
--

CREATE TABLE IF NOT EXISTS `doctor` (
  `DR_ID` int(11) NOT NULL AUTO_INCREMENT,
  `DR_FNAME` varchar(20) NOT NULL,
  `DR_LNAME` varchar(20) NOT NULL,
  `DR_SAL` int(11) NOT NULL,
  `DR_SPECIALIZATION` varchar(20) NOT NULL,
  `DR_GENDER` varchar(10) NOT NULL,
  `DR_DOB` date NOT NULL,
  `DR_PHONE` varchar(14) NOT NULL,
  `DR_SHIFT` varchar(11) NOT NULL,
  `DR_HOUSENO` varchar(20) NOT NULL,
  `DR_CITY` varchar(20) NOT NULL,
  `DR_ZIP` varchar(20) NOT NULL,
  PRIMARY KEY (`DR_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `doctor`
--

INSERT INTO `doctor` (`DR_ID`, `DR_FNAME`, `DR_LNAME`, `DR_SAL`, `DR_SPECIALIZATION`, `DR_GENDER`, `DR_DOB`, `DR_PHONE`, `DR_SHIFT`, `DR_HOUSENO`, `DR_CITY`, `DR_ZIP`) VALUES
(1, 'Muhammad', 'Abu bakar', 100000, 'allergy & immunology', 'male', '2002-04-19', '03364801803', 'Day', '123 dha', 'lahore', '12344'),
(2, 'aqib', 'amin', 100000, 'General', 'MALE', '2002-01-01', '+9233333333', 'DAY', 'Dont know', 'lahore', '12345');

-- --------------------------------------------------------

--
-- Table structure for table `nurse`
--

CREATE TABLE IF NOT EXISTS `nurse` (
  `NR_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NR_FNAME` varchar(20) NOT NULL,
  `NR_LNAME` varchar(20) NOT NULL,
  `WRD_NO` int(11) NOT NULL,
  `NR_GENDER` varchar(10) NOT NULL,
  `NR_DOB` date NOT NULL,
  `NR_PHONE` varchar(15) NOT NULL,
  `NR_SAL` int(10) NOT NULL,
  `NR_HOUSENO` varchar(20) NOT NULL,
  `NR_CITY` varchar(20) NOT NULL,
  `NR_ZIP` varchar(8) NOT NULL,
  `NR_SHIFT` varchar(10) NOT NULL,
  PRIMARY KEY (`NR_ID`),
  KEY `WRD_NO` (`WRD_NO`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `nurse`
--

INSERT INTO `nurse` (`NR_ID`, `NR_FNAME`, `NR_LNAME`, `WRD_NO`, `NR_GENDER`, `NR_DOB`, `NR_PHONE`, `NR_SAL`, `NR_HOUSENO`, `NR_CITY`, `NR_ZIP`, `NR_SHIFT`) VALUES
(1, 'M', 'A', 1, 'Female', '2022-01-05', '3636363737', 2662, 'gshshs', 'kkk', '1111', 'day');

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

CREATE TABLE IF NOT EXISTS `patient` (
  `P_ID` int(10) NOT NULL AUTO_INCREMENT,
  `P_FNAME` varchar(20) NOT NULL,
  `P_LNAME` varchar(20) NOT NULL,
  `P_DISEASE` varchar(20) NOT NULL,
  `P_PHONE` varchar(15) NOT NULL,
  `P_GENDER` varchar(10) NOT NULL,
  `P_DOB` date NOT NULL,
  `P_HOUSENO` varchar(20) NOT NULL,
  `P_CITY` varchar(14) NOT NULL,
  `P_ZIP` varchar(10) NOT NULL,
  PRIMARY KEY (`P_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`P_ID`, `P_FNAME`, `P_LNAME`, `P_DISEASE`, `P_PHONE`, `P_GENDER`, `P_DOB`, `P_HOUSENO`, `P_CITY`, `P_ZIP`) VALUES
(1, 'Hello', 'World', 'H', '6376373378', 'Male', '2022-01-28', '2', '3', '5'),
(2, 'Hello', 'World', 'H', '6376373378', 'Male', '2022-01-28', '2', '3', '5');

-- --------------------------------------------------------

--
-- Table structure for table `receptionist`
--

CREATE TABLE IF NOT EXISTS `receptionist` (
  `RPT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `firstname` varchar(20) NOT NULL,
  `lastname` varchar(20) NOT NULL,
  `sal` int(10) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `dob` date NOT NULL,
  `phone` varchar(14) NOT NULL,
  `houseno` varchar(20) NOT NULL,
  `city` varchar(20) NOT NULL,
  `zip` varchar(8) NOT NULL,
  `shift` varchar(10) NOT NULL,
  PRIMARY KEY (`RPT_ID`,`username`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=789 ;

--
-- Dumping data for table `receptionist`
--

INSERT INTO `receptionist` (`RPT_ID`, `username`, `password`, `firstname`, `lastname`, `sal`, `gender`, `dob`, `phone`, `houseno`, `city`, `zip`, `shift`) VALUES
(787, 'naukhaiz', '12345678', 'Naukhaiz', 'Anjum', 12345, 'Male', '2022-06-22', '030223456654', '123 Block B DHA', 'Lahore', '68222', 'Night'),
(788, 'abubakar', '12345678', 'abubakar', 'akmal', 60000, 'Male', '2022-06-19', '030223456654', '123 Block A DHA', 'Lahore', '12345', '');

-- --------------------------------------------------------

--
-- Table structure for table `visiting_record`
--

CREATE TABLE IF NOT EXISTS `visiting_record` (
  `VREC_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `DR_ID` int(11) NOT NULL,
  `WRD_NO` int(11) NOT NULL,
  `VREC_DURATION` varchar(15) NOT NULL,
  PRIMARY KEY (`VREC_DATE`,`DR_ID`,`WRD_NO`),
  UNIQUE KEY `VREC_DATE` (`VREC_DATE`),
  KEY `DR_ID` (`DR_ID`),
  KEY `WRD_NO` (`WRD_NO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `visiting_record`
--

INSERT INTO `visiting_record` (`VREC_DATE`, `DR_ID`, `WRD_NO`, `VREC_DURATION`) VALUES
('2022-02-06 16:24:22', 1, 1, '10');

-- --------------------------------------------------------

--
-- Table structure for table `ward`
--

CREATE TABLE IF NOT EXISTS `ward` (
  `WRD_NO` int(10) NOT NULL AUTO_INCREMENT,
  `WRD_CHAREGS` int(10) NOT NULL,
  `WRD_CAPACITY` int(10) NOT NULL,
  PRIMARY KEY (`WRD_NO`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `ward`
--

INSERT INTO `ward` (`WRD_NO`, `WRD_CHAREGS`, `WRD_CAPACITY`) VALUES
(1, 1000, 10),
(2, 1000, 12);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `appointment`
--
ALTER TABLE `appointment`
  ADD CONSTRAINT `appointment_ibfk_1` FOREIGN KEY (`DR_ID`) REFERENCES `doctor` (`DR_ID`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `appointment_ibfk_2` FOREIGN KEY (`P_ID`) REFERENCES `patient` (`P_ID`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `bed`
--
ALTER TABLE `bed`
  ADD CONSTRAINT `bed_ibfk_1` FOREIGN KEY (`WRD_NO`) REFERENCES `ward` (`WRD_NO`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `bill`
--
ALTER TABLE `bill`
  ADD CONSTRAINT `bill_ibfk_1` FOREIGN KEY (`P_ID`) REFERENCES `patient` (`P_ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `booking_record`
--
ALTER TABLE `booking_record`
  ADD CONSTRAINT `booking_record_ibfk_1` FOREIGN KEY (`BED_NO`) REFERENCES `bed` (`BED_NO`),
  ADD CONSTRAINT `booking_record_ibfk_2` FOREIGN KEY (`P_ID`) REFERENCES `patient` (`P_ID`);

--
-- Constraints for table `nurse`
--
ALTER TABLE `nurse`
  ADD CONSTRAINT `nurse_ibfk_1` FOREIGN KEY (`WRD_NO`) REFERENCES `ward` (`WRD_NO`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `visiting_record`
--
ALTER TABLE `visiting_record`
  ADD CONSTRAINT `visiting_record_ibfk_1` FOREIGN KEY (`DR_ID`) REFERENCES `doctor` (`DR_ID`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `visiting_record_ibfk_2` FOREIGN KEY (`WRD_NO`) REFERENCES `ward` (`WRD_NO`) ON DELETE NO ACTION ON UPDATE CASCADE;
