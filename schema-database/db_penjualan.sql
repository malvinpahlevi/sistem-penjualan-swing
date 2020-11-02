-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 13, 2020 at 02:29 PM
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
  `KdKategori` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`KdBrg`, `NmBrg`, `Satuan`, `HargaBrg`, `Stok`, `KdKategori`) VALUES
('B401', 'panadol', 'Item 2', 232322, 2, 4),
('B501', 'panadol', 'Item 2', 232322, 2, 5),
('B601', 'wewwewe', 'Item 3', 22232, 2, 6);

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
  `KdKategori` int(6) NOT NULL DEFAULT 0,
  `NmKategori` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `kategori`
--

INSERT INTO `kategori` (`KdKategori`, `NmKategori`) VALUES
(2, 'obat'),
(4, 'kue'),
(5, 'obat keras'),
(6, 'tablet');

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

-- --------------------------------------------------------

--
-- Table structure for table `petugas`
--

CREATE TABLE `petugas` (
  `kdpetugas` int(3) NOT NULL,
  `nmpetugas` varchar(50) DEFAULT NULL,
  `alamatpetugas` varchar(50) DEFAULT NULL,
  `telppetugas` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `petugas`
--

INSERT INTO `petugas` (`kdpetugas`, `nmpetugas`, `alamatpetugas`, `telppetugas`) VALUES
(1, 'acuy', 'cengkareng', '02321'),
(2, 'asdasd22', 'asdasd22', 'asdasd');

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
-- Indexes for table `petugas`
--
ALTER TABLE `petugas`
  ADD PRIMARY KEY (`kdpetugas`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `petugas`
--
ALTER TABLE `petugas`
  MODIFY `kdpetugas` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

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
