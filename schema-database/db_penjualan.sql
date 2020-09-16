-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 16, 2020 at 05:43 PM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.4.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_penjualan`
--

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `KdBrg` varchar(6) NOT NULL DEFAULT '',
  `NmBrg` varchar(50) DEFAULT NULL,
  `Satuan` varchar(10) DEFAULT NULL,
  `HargaBrg` int(6) DEFAULT NULL,
  `Stok` int(3) DEFAULT NULL,
  `KdKategori` varchar(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `buktipesan`
--

CREATE TABLE `buktipesan` (
  `NoPesan` varchar(7) NOT NULL DEFAULT '',
  `TglPesan` date DEFAULT NULL,
  `KdPlg` varchar(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `detilpesan`
--

CREATE TABLE `detilpesan` (
  `NoPesan` varchar(7) NOT NULL,
  `KdBrg` varchar(6) DEFAULT NULL,
  `HrgPesan` int(6) DEFAULT NULL,
  `JmlPesan` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `kategori`
--

CREATE TABLE `kategori` (
  `KdKategori` varchar(3) NOT NULL DEFAULT '',
  `NmKategori` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `pelanggan`
--

CREATE TABLE `pelanggan` (
  `KdPlg` int(6) NOT NULL DEFAULT 0,
  `NmPlg` varchar(50) DEFAULT NULL,
  `AlamatPlg` varchar(50) DEFAULT NULL,
  `TelpPlg` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pelanggan`
--

INSERT INTO `pelanggan` (`KdPlg`, `NmPlg`, `AlamatPlg`, `TelpPlg`) VALUES
(1, 'Angga Aji', 'Cengkareng', '1123414123'),
(2, 'test', '23144', '444123123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`KdBrg`);

--
-- Indexes for table `buktipesan`
--
ALTER TABLE `buktipesan`
  ADD PRIMARY KEY (`NoPesan`);

--
-- Indexes for table `detilpesan`
--
ALTER TABLE `detilpesan`
  ADD PRIMARY KEY (`NoPesan`),
  ADD KEY `KdBrg` (`KdBrg`);

--
-- Indexes for table `kategori`
--
ALTER TABLE `kategori`
  ADD PRIMARY KEY (`KdKategori`);

--
-- Indexes for table `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`KdPlg`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `detilpesan`
--
ALTER TABLE `detilpesan`
  ADD CONSTRAINT `detilpesan_ibfk_1` FOREIGN KEY (`KdBrg`) REFERENCES `barang` (`KdBrg`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
