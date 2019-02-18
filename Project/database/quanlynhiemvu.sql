-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 05, 2018 at 04:18 AM
-- Server version: 10.1.32-MariaDB
-- PHP Version: 7.2.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quanlynhiemvu`
--

-- --------------------------------------------------------

--
-- Table structure for table `loai_cong_viec`
--

CREATE TABLE `loai_cong_viec` (
  `ID_loai_cong_viec` int(11) UNSIGNED ZEROFILL NOT NULL,
  `loai_cong_viec` varchar(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `loai_cong_viec`
--

INSERT INTO `loai_cong_viec` (`ID_loai_cong_viec`, `loai_cong_viec`) VALUES
(00000000001, 'Code'),
(00000000002, 'UT'),
(00000000003, 'Fix bug'),
(00000000004, 'Test');

-- --------------------------------------------------------

--
-- Table structure for table `quan_li_nhiem_vu`
--

CREATE TABLE `quan_li_nhiem_vu` (
  `ID` int(11) NOT NULL,
  `ma_du_an` int(11) UNSIGNED ZEROFILL NOT NULL,
  `ID_loai_cong_viec` int(11) UNSIGNED ZEROFILL NOT NULL,
  `ten_cong_viec` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `mo_ta` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `thoi_gian_bat_dau` date NOT NULL,
  `thoi_gian_ket_thuc` date NOT NULL,
  `ma_phong_ban` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `ma_nhan_vien` int(5) UNSIGNED ZEROFILL NOT NULL,
  `ma_vai_tro` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `tg_du_kien_hoan_thanh` int(5) NOT NULL,
  `ID_trang_thai` int(11) UNSIGNED ZEROFILL NOT NULL,
  `is_delete` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `quan_li_nhiem_vu`
--

INSERT INTO `quan_li_nhiem_vu` (`ID`, `ma_du_an`, `ID_loai_cong_viec`, `ten_cong_viec`, `mo_ta`, `thoi_gian_bat_dau`, `thoi_gian_ket_thuc`, `ma_phong_ban`, `ma_nhan_vien`, `ma_vai_tro`, `tg_du_kien_hoan_thanh`, `ID_trang_thai`, `is_delete`) VALUES
(2, 00000000111, 00000000001, 'Thiết kế web', 'Web bán hàng', '2018-12-02', '2018-12-03', 'PDA1', 00006, 'a', 2, 00000000002, 0),
(3, 00000022222, 00000000001, 'thiết kế phần mền', 'phần mền bán hàng', '2018-04-12', '2019-06-12', 'PDA1', 00001, 'tra', 2, 00000000001, 0),
(4, 00000033333, 00000000002, 'dsad', 'phần mền bán hàng', '2018-05-12', '2018-12-12', 'PDA3', 00016, 'tra', 1, 00000000003, 0);

-- --------------------------------------------------------

--
-- Table structure for table `trang_thai`
--

CREATE TABLE `trang_thai` (
  `ID_trang_thai` int(11) UNSIGNED ZEROFILL NOT NULL,
  `trang_thai` varchar(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `trang_thai`
--

INSERT INTO `trang_thai` (`ID_trang_thai`, `trang_thai`) VALUES
(00000000001, 'Mới'),
(00000000002, 'Đang làm'),
(00000000003, 'Đã xong'),
(00000000004, 'Hủy');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `loai_cong_viec`
--
ALTER TABLE `loai_cong_viec`
  ADD PRIMARY KEY (`ID_loai_cong_viec`);

--
-- Indexes for table `quan_li_nhiem_vu`
--
ALTER TABLE `quan_li_nhiem_vu`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `ID_loai_cong_viec` (`ID_loai_cong_viec`),
  ADD KEY `ID_trang_thai` (`ID_trang_thai`),
  ADD KEY `ma_phong_ban` (`ma_phong_ban`),
  ADD KEY `ma_nhan_vien` (`ma_nhan_vien`);

--
-- Indexes for table `trang_thai`
--
ALTER TABLE `trang_thai`
  ADD PRIMARY KEY (`ID_trang_thai`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `loai_cong_viec`
--
ALTER TABLE `loai_cong_viec`
  MODIFY `ID_loai_cong_viec` int(11) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `quan_li_nhiem_vu`
--
ALTER TABLE `quan_li_nhiem_vu`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `trang_thai`
--
ALTER TABLE `trang_thai`
  MODIFY `ID_trang_thai` int(11) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `quan_li_nhiem_vu`
--
ALTER TABLE `quan_li_nhiem_vu`
  ADD CONSTRAINT `quan_li_nhiem_vu_ibfk_1` FOREIGN KEY (`ID_loai_cong_viec`) REFERENCES `loai_cong_viec` (`ID_loai_cong_viec`),
  ADD CONSTRAINT `quan_li_nhiem_vu_ibfk_2` FOREIGN KEY (`ID_trang_thai`) REFERENCES `trang_thai` (`ID_trang_thai`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
