-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 06, 2018 lúc 11:16 AM
-- Phiên bản máy phục vụ: 10.1.32-MariaDB
-- Phiên bản PHP: 7.2.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `project1`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `danh_muc`
--

CREATE TABLE `danh_muc` (
  `Ma_Danh_Muc` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `Ten_Danh_Muc` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `isDelete` tinyint(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `icon`
--

CREATE TABLE `icon` (
  `ma_icon` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `link_File` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `ten_icon` varchar(300) COLLATE utf8_unicode_ci NOT NULL,
  `isDelete` tinyint(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tai_lieu`
--

CREATE TABLE `tai_lieu` (
  `id_tai_lieu` int(11) NOT NULL,
  `ma_tai_lieu` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `Ma_Danh_Muc` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `ma_icon` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `ten_tai_lieu` varchar(300) COLLATE utf8_unicode_ci NOT NULL,
  `ma_phong_ban` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `mo_taTL` varchar(300) COLLATE utf8_unicode_ci NOT NULL,
  `Link` varchar(300) COLLATE utf8_unicode_ci NOT NULL,
  `ma_trang_thai` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `isDelete` tinyint(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `trang_thai`
--

CREATE TABLE `trang_thai` (
  `ma_trang_thai` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `ten_trang_thai` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `isDelete` tinyint(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `danh_muc`
--
ALTER TABLE `danh_muc`
  ADD PRIMARY KEY (`Ma_Danh_Muc`);

--
-- Chỉ mục cho bảng `icon`
--
ALTER TABLE `icon`
  ADD PRIMARY KEY (`ma_icon`);

--
-- Chỉ mục cho bảng `tai_lieu`
--
ALTER TABLE `tai_lieu`
  ADD PRIMARY KEY (`id_tai_lieu`),
  ADD KEY `Ma_Danh_Muc` (`Ma_Danh_Muc`),
  ADD KEY `ma_icon` (`ma_icon`),
  ADD KEY `ma_trang_thai` (`ma_trang_thai`);

--
-- Chỉ mục cho bảng `trang_thai`
--
ALTER TABLE `trang_thai`
  ADD PRIMARY KEY (`ma_trang_thai`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `tai_lieu`
--
ALTER TABLE `tai_lieu`
  MODIFY `id_tai_lieu` int(11) NOT NULL AUTO_INCREMENT;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `tai_lieu`
--
ALTER TABLE `tai_lieu`
  ADD CONSTRAINT `tai_lieu_ibfk_1` FOREIGN KEY (`Ma_Danh_Muc`) REFERENCES `danh_muc` (`Ma_Danh_Muc`),
  ADD CONSTRAINT `tai_lieu_ibfk_2` FOREIGN KEY (`ma_icon`) REFERENCES `icon` (`ma_icon`),
  ADD CONSTRAINT `tai_lieu_ibfk_3` FOREIGN KEY (`ma_trang_thai`) REFERENCES `trang_thai` (`ma_trang_thai`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
