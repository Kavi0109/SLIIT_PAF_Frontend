-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 15, 2022 at 05:58 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `test`
--

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(10) NOT NULL,
  `name` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `pass` varchar(20) NOT NULL,
  `mobile` varchar(10) NOT NULL,
  `type` varchar(20) NOT NULL,
  `accountNo` int(10) NOT NULL,
  `otp` int(10) NOT NULL,
  `status` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `pass`, `mobile`, `type`, `accountNo`, `otp`, `status`) VALUES
(12, 'Minsadi Perera', 'mini@gmail.com', 'mini', '0771895623', 'Investor', 6823722, 196, 'Active'),
(15, 'Kaveesha Perera', 'kaviperera0109@gmail.com', 'Kaveesha', '0778945612', 'Consumer', 84899106, 193, 'Active'),
(18, 'Rishma Packeeran', 'rishmapackeeran@gmail.com', 'rishma', '0448795162', 'Investor', 19386552, 183, 'Active'),
(20, 'Humaira Rizwan', 'humairarizwan@gmail.com', 'hum123', '0778451396', 'Government ', 30737208, 152, 'Active'),
(21, 'Ushani Dahanayake', 'ushanidaha@gmail.com', 'ushani', '0716998425', 'Buyer', 13233154, 25, 'Active');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
