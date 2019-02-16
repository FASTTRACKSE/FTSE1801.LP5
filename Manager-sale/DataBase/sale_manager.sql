-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th2 16, 2019 lúc 04:33 AM
-- Phiên bản máy phục vụ: 10.1.37-MariaDB
-- Phiên bản PHP: 7.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `sale_manager`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `cart`
--

CREATE TABLE `cart` (
  `ID_CART` int(11) NOT NULL,
  `ID_CUSTOMER` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `customer`
--

CREATE TABLE `customer` (
  `ID_CUSTOMER` int(11) NOT NULL,
  `NAME_CUSTOMER` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `PHONE_CUSTOMER` int(11) NOT NULL,
  `CARD_ID` int(10) NOT NULL,
  `ID_GROUPCUST` int(11) NOT NULL,
  `DEL_FLG` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `employees`
--

CREATE TABLE `employees` (
  `ID_EMPl` int(11) NOT NULL,
  `NAME_EMPl` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `ADDRESS_EMPl` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `PHONE_EMPl` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `EMAIL_EMPl` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `DATE_ADD` date NOT NULL,
  `CARD_ID` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `ID_POSITION` int(11) NOT NULL,
  `DEL_FLG` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `employees`
--

INSERT INTO `employees` (`ID_EMPl`, `NAME_EMPl`, `ADDRESS_EMPl`, `PHONE_EMPl`, `EMAIL_EMPl`, `DATE_ADD`, `CARD_ID`, `ID_POSITION`, `DEL_FLG`) VALUES
(1, 'Nguyễn Văn Nam', 'Đà nẵng', '012548566', 'Nam@gmail.com', '2018-09-12', '231083868', 1, 0),
(2, 'Nguyễn Văn Sơn', 'Quảng Nam', '012844677', 'Sơn@gmail.com', '2018-10-12', '231083869', 2, 0),
(3, 'Nguyễn Văn Thiên', 'Hà Nội', '012548765', 'Thiên@gmail.com', '2018-11-08', '231083870', 3, 0),
(4, 'Nguyễn Văn Hiệu', 'Bình Định', '012598765', 'Hiệu@gmail.com', '2018-11-12', '231083871', 4, 0),
(5, 'Nguyễn Văn Hợi', 'Nghệ An', '012557823', 'Hợi@gmail.com', '2018-12-12', '231083872', 1, 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `group_customer`
--

CREATE TABLE `group_customer` (
  `ID_GROUPCUST` int(11) NOT NULL,
  `NAME_GROUPCUST` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `DELL_FLG` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `group_product`
--

CREATE TABLE `group_product` (
  `ID_GROUPPRO` int(11) NOT NULL,
  `NAME_GROUPPRO` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `ID_EMPl` int(11) NOT NULL,
  `DATE_ADD` date NOT NULL,
  `DEL_FLG` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `group_product`
--

INSERT INTO `group_product` (`ID_GROUPPRO`, `NAME_GROUPPRO`, `ID_EMPl`, `DATE_ADD`, `DEL_FLG`) VALUES
(1, 'Áo khoác gió nam', 1, '2018-10-09', 0),
(2, 'Áo vest nam', 1, '2018-10-10', 0),
(3, 'Quần jean nam', 1, '2018-10-11', 0),
(4, 'Quần thun nam', 1, '2018-10-12', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `line_cart`
--

CREATE TABLE `line_cart` (
  `ID_LINECART` int(11) NOT NULL,
  `ID_CART` int(11) NOT NULL,
  `ID_PRODUCT` int(11) NOT NULL,
  `AMOUNT` int(10) NOT NULL,
  `DEL_FLG` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `line_receipt`
--

CREATE TABLE `line_receipt` (
  `ID_LRECEIPT` int(11) NOT NULL,
  `ID_RECEIPT` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `ID_PRODUCT` int(11) NOT NULL,
  `DEL_FLG` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `position`
--

CREATE TABLE `position` (
  `ID_POSITION` int(11) NOT NULL,
  `NAME_POSITION` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `DEL_FLG` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `position`
--

INSERT INTO `position` (`ID_POSITION`, `NAME_POSITION`, `DEL_FLG`) VALUES
(1, 'Kế toán', 0),
(2, 'Giám đốc', 0),
(3, 'Quản lý', 0),
(4, 'Bán hàng', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `product`
--

CREATE TABLE `product` (
  `ID_PRODUCT` int(11) NOT NULL,
  `ID_EMPl` int(11) NOT NULL,
  `IMAGE` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `NAME_PRODUCT` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `UNIT` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `INPUT_PRICE` int(10) NOT NULL,
  `PRICE` int(10) NOT NULL,
  `QUANTITY_INPUTS` int(10) NOT NULL,
  `REMAINING_AMOUNT` int(10) NOT NULL,
  `DATE_ADD` date NOT NULL,
  `DESCRIBE` text COLLATE utf8_unicode_ci NOT NULL,
  `ID_STATUS` int(11) NOT NULL,
  `VIEW` int(10) NOT NULL,
  `ID_GROUPPRO` int(11) NOT NULL,
  `DEL_FLG` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `product`
--

INSERT INTO `product` (`ID_PRODUCT`, `ID_EMPl`, `IMAGE`, `NAME_PRODUCT`, `UNIT`, `INPUT_PRICE`, `PRICE`, `QUANTITY_INPUTS`, `REMAINING_AMOUNT`, `DATE_ADD`, `DESCRIBE`, `ID_STATUS`, `VIEW`, `ID_GROUPPRO`, `DEL_FLG`) VALUES
(6, 2, 'D:\\manh\\lp5\\FTSE1801.LP5\\Manager-sale\\managerSale\\src\\main\\resources\\static\\front-end\\images\\AoKhoacGioNam\\1', 'Khoac nam mu logo 125', 'Cái', 150000, 210000, 10, 8, '2018-10-15', '', 1, 0, 1, 0),
(7, 2, 'D:\\manh\\lp5\\FTSE1801.LP5\\Manager-sale\\managerSale\\src\\main\\resources\\static\\front-end\\images\\AoKhoacGioNam\\2', 'Khoac kaki nam mu 818', 'Cái', 160000, 220000, 11, 11, '2018-10-15', '', 2, 0, 1, 0),
(8, 2, 'D:\\manh\\lp5\\FTSE1801.LP5\\Manager-sale\\managerSale\\src\\main\\resources\\static\\front-end\\images\\AoKhoacGioNam\\3', 'Khoac nam bomber 2 lop', 'Cái', 170000, 230000, 12, 2, '2018-10-15', '', 1, 0, 1, 0),
(9, 2, 'D:\\manh\\lp5\\FTSE1801.LP5\\Manager-sale\\managerSale\\src\\main\\resources\\static\\front-end\\images\\AoKhoacGioNam\\4', 'Khoac kaki nam 801', 'Cái', 180000, 240000, 13, 6, '2018-10-15', '', 1, 0, 1, 0),
(10, 2, 'D:\\manh\\lp5\\FTSE1801.LP5\\Manager-sale\\managerSale\\src\\main\\resources\\static\\front-end\\images\\AoKhoacGioNam\\5', 'Khoac gio CP NH.HG0211B', 'Cái', 190000, 250000, 14, 8, '2018-10-15', '', 1, 0, 1, 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `receipt`
--

CREATE TABLE `receipt` (
  `ID_RECEIPT` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `ID_EMPL` int(11) NOT NULL,
  `ID_CUSTOMER` int(11) NOT NULL,
  `VAT` int(11) NOT NULL,
  `ID_TYPE_RECEIPT` int(2) NOT NULL,
  `DATE` date NOT NULL,
  `DEL_FLG` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `status`
--

CREATE TABLE `status` (
  `ID_STATUS` int(11) NOT NULL,
  `NAME_STATUS` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `status`
--

INSERT INTO `status` (`ID_STATUS`, `NAME_STATUS`) VALUES
(1, 'Còn hàng'),
(2, 'Hết hàng');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `type_receipt`
--

CREATE TABLE `type_receipt` (
  `ID_TYPE_RECEIPT` int(2) NOT NULL,
  `NAME_TYPE_RECEIPT` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`ID_CART`),
  ADD KEY `ID_CUSTOMER` (`ID_CUSTOMER`);

--
-- Chỉ mục cho bảng `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`ID_CUSTOMER`),
  ADD KEY `ID_GROUPCUST` (`ID_GROUPCUST`);

--
-- Chỉ mục cho bảng `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`ID_EMPl`),
  ADD KEY `ID_POSITION` (`ID_POSITION`);

--
-- Chỉ mục cho bảng `group_customer`
--
ALTER TABLE `group_customer`
  ADD PRIMARY KEY (`ID_GROUPCUST`);

--
-- Chỉ mục cho bảng `group_product`
--
ALTER TABLE `group_product`
  ADD PRIMARY KEY (`ID_GROUPPRO`),
  ADD KEY `ID_EMPl` (`ID_EMPl`);

--
-- Chỉ mục cho bảng `line_cart`
--
ALTER TABLE `line_cart`
  ADD PRIMARY KEY (`ID_LINECART`),
  ADD KEY `ID_CART` (`ID_CART`),
  ADD KEY `ID_PRODUCT` (`ID_PRODUCT`);

--
-- Chỉ mục cho bảng `line_receipt`
--
ALTER TABLE `line_receipt`
  ADD PRIMARY KEY (`ID_LRECEIPT`),
  ADD KEY `ID_RECEIPT` (`ID_RECEIPT`),
  ADD KEY `ID_PRODUCT` (`ID_PRODUCT`);

--
-- Chỉ mục cho bảng `position`
--
ALTER TABLE `position`
  ADD PRIMARY KEY (`ID_POSITION`);

--
-- Chỉ mục cho bảng `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`ID_PRODUCT`),
  ADD KEY `ID_EMPl` (`ID_EMPl`),
  ADD KEY `ID_GROUPPRO` (`ID_GROUPPRO`),
  ADD KEY `ID_STATUS` (`ID_STATUS`);

--
-- Chỉ mục cho bảng `receipt`
--
ALTER TABLE `receipt`
  ADD PRIMARY KEY (`ID_RECEIPT`),
  ADD KEY `ID_EMPL` (`ID_EMPL`),
  ADD KEY `ID_CUSTOMER` (`ID_CUSTOMER`),
  ADD KEY `ID_TYPE_RECEIPT` (`ID_TYPE_RECEIPT`);

--
-- Chỉ mục cho bảng `status`
--
ALTER TABLE `status`
  ADD PRIMARY KEY (`ID_STATUS`);

--
-- Chỉ mục cho bảng `type_receipt`
--
ALTER TABLE `type_receipt`
  ADD PRIMARY KEY (`ID_TYPE_RECEIPT`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `cart`
--
ALTER TABLE `cart`
  MODIFY `ID_CART` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `customer`
--
ALTER TABLE `customer`
  MODIFY `ID_CUSTOMER` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `employees`
--
ALTER TABLE `employees`
  MODIFY `ID_EMPl` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `group_customer`
--
ALTER TABLE `group_customer`
  MODIFY `ID_GROUPCUST` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `group_product`
--
ALTER TABLE `group_product`
  MODIFY `ID_GROUPPRO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `line_cart`
--
ALTER TABLE `line_cart`
  MODIFY `ID_LINECART` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `line_receipt`
--
ALTER TABLE `line_receipt`
  MODIFY `ID_LRECEIPT` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `position`
--
ALTER TABLE `position`
  MODIFY `ID_POSITION` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `product`
--
ALTER TABLE `product`
  MODIFY `ID_PRODUCT` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT cho bảng `status`
--
ALTER TABLE `status`
  MODIFY `ID_STATUS` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `type_receipt`
--
ALTER TABLE `type_receipt`
  MODIFY `ID_TYPE_RECEIPT` int(2) NOT NULL AUTO_INCREMENT;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `cart`
--
ALTER TABLE `cart`
  ADD CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`ID_CUSTOMER`) REFERENCES `customer` (`ID_CUSTOMER`);

--
-- Các ràng buộc cho bảng `customer`
--
ALTER TABLE `customer`
  ADD CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`ID_GROUPCUST`) REFERENCES `group_customer` (`ID_GROUPCUST`);

--
-- Các ràng buộc cho bảng `employees`
--
ALTER TABLE `employees`
  ADD CONSTRAINT `employees_ibfk_1` FOREIGN KEY (`ID_POSITION`) REFERENCES `position` (`ID_POSITION`);

--
-- Các ràng buộc cho bảng `group_product`
--
ALTER TABLE `group_product`
  ADD CONSTRAINT `group_product_ibfk_1` FOREIGN KEY (`ID_EMPl`) REFERENCES `employees` (`ID_EMPl`);

--
-- Các ràng buộc cho bảng `line_cart`
--
ALTER TABLE `line_cart`
  ADD CONSTRAINT `line_cart_ibfk_1` FOREIGN KEY (`ID_CART`) REFERENCES `cart` (`ID_CART`),
  ADD CONSTRAINT `line_cart_ibfk_2` FOREIGN KEY (`ID_PRODUCT`) REFERENCES `product` (`ID_PRODUCT`);

--
-- Các ràng buộc cho bảng `line_receipt`
--
ALTER TABLE `line_receipt`
  ADD CONSTRAINT `line_receipt_ibfk_1` FOREIGN KEY (`ID_RECEIPT`) REFERENCES `receipt` (`ID_RECEIPT`),
  ADD CONSTRAINT `line_receipt_ibfk_2` FOREIGN KEY (`ID_PRODUCT`) REFERENCES `product` (`ID_PRODUCT`);

--
-- Các ràng buộc cho bảng `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `product_ibfk_1` FOREIGN KEY (`ID_EMPl`) REFERENCES `employees` (`ID_EMPl`),
  ADD CONSTRAINT `product_ibfk_2` FOREIGN KEY (`ID_GROUPPRO`) REFERENCES `group_product` (`ID_GROUPPRO`),
  ADD CONSTRAINT `product_ibfk_3` FOREIGN KEY (`ID_STATUS`) REFERENCES `status` (`ID_STATUS`);

--
-- Các ràng buộc cho bảng `receipt`
--
ALTER TABLE `receipt`
  ADD CONSTRAINT `receipt_ibfk_1` FOREIGN KEY (`ID_EMPL`) REFERENCES `employees` (`ID_EMPl`),
  ADD CONSTRAINT `receipt_ibfk_2` FOREIGN KEY (`ID_CUSTOMER`) REFERENCES `customer` (`ID_CUSTOMER`),
  ADD CONSTRAINT `receipt_ibfk_3` FOREIGN KEY (`ID_TYPE_RECEIPT`) REFERENCES `type_receipt` (`ID_TYPE_RECEIPT`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
