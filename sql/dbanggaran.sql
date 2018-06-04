-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: May 15, 2018 at 06:46 AM
-- Server version: 5.7.19
-- PHP Version: 7.1.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbanggaran`
--

-- --------------------------------------------------------

--
-- Table structure for table `anggaran_daerah`
--

CREATE TABLE `anggaran_daerah` (
  `id` int(11) NOT NULL,
  `propinsi_id` int(11) NOT NULL,
  `mata_anggaran_id` int(11) NOT NULL,
  `tahun` int(11) DEFAULT NULL,
  `rencana` double DEFAULT NULL,
  `realisasi` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `kategori_belanja`
--

CREATE TABLE `kategori_belanja` (
  `id` int(11) NOT NULL,
  `nama` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `mata_anggaran`
--

CREATE TABLE `mata_anggaran` (
  `id` int(11) NOT NULL,
  `nama` varchar(45) DEFAULT NULL,
  `maksimal` double DEFAULT NULL,
  `kategori_belanja_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `propinsi`
--

CREATE TABLE `propinsi` (
  `id` int(11) NOT NULL,
  `kode` varchar(10) DEFAULT NULL,
  `nama` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `propinsi`
--

INSERT INTO `propinsi` (`id`, `kode`, `nama`) VALUES
(1, 'DKI', 'DKI Jakarta'),
(2, 'DIY', 'DI Yogyakarta'),
(3, 'JABAR', 'Jawa Barat'),
(4, 'JATENG', 'Jawa Tengah'),
(5, 'JATIM', 'Jawa Timur'),
(6, 'BTN', 'Banten');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `anggaran_daerah`
--
ALTER TABLE `anggaran_daerah`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_anggaran_daerah_propinsi_idx` (`propinsi_id`),
  ADD KEY `fk_anggaran_daerah_mata_anggaran1_idx` (`mata_anggaran_id`);

--
-- Indexes for table `kategori_belanja`
--
ALTER TABLE `kategori_belanja`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `mata_anggaran`
--
ALTER TABLE `mata_anggaran`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_mata_anggaran_kategori_belanja1_idx` (`kategori_belanja_id`);

--
-- Indexes for table `propinsi`
--
ALTER TABLE `propinsi`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `anggaran_daerah`
--
ALTER TABLE `anggaran_daerah`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `kategori_belanja`
--
ALTER TABLE `kategori_belanja`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `mata_anggaran`
--
ALTER TABLE `mata_anggaran`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `propinsi`
--
ALTER TABLE `propinsi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `anggaran_daerah`
--
ALTER TABLE `anggaran_daerah`
  ADD CONSTRAINT `fk_anggaran_daerah_mata_anggaran1` FOREIGN KEY (`mata_anggaran_id`) REFERENCES `mata_anggaran` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_anggaran_daerah_propinsi` FOREIGN KEY (`propinsi_id`) REFERENCES `propinsi` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `mata_anggaran`
--
ALTER TABLE `mata_anggaran`
  ADD CONSTRAINT `fk_mata_anggaran_kategori_belanja1` FOREIGN KEY (`kategori_belanja_id`) REFERENCES `kategori_belanja` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
