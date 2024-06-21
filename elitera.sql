-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 19, 2024 at 03:04 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `elitera`
--

-- --------------------------------------------------------

--
-- Table structure for table `db_sementara`
--

CREATE TABLE `db_sementara` (
  `jrsn` varchar(20) NOT NULL,
  `kls` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `db_sementara`
--

INSERT INTO `db_sementara` (`jrsn`, `kls`) VALUES
('IPA', 10),
('IPA', 11),
('Informatika', 10),
('Farmasi', 12),
('Informatika', 12),
('Multimedia', 10),
('Farmasi', 12),
('Akuntansi', 11),
('Multimedia', 10),
('Multimedia', 10),
('Akuntansi', 11),
('Akuntansi', 11),
('Akuntansi', 10),
('IPA', 10),
('IPS', 11),
('IPA', 11),
('Multimedia', 12),
('IPA', 11),
('IPS', 12),
('Informatika', 11),
('Informatika', 11),
('Akuntansi', 10),
('IPS', 12),
('Akuntansi', 11),
('Multimedia', 11),
('Multimedia', 11),
('IPA', 11),
('IPS', 10),
('IPA', 11),
('Multimedia', 11),
('IPA', 10),
('IPA', 12),
('IPA', 10),
('IPA', 11),
('IPA', 10),
('IPA', 10),
('Informatika', 11),
('Multimedia', 12),
('Informatika', 12),
('IPA', 10),
('Multimedia', 11),
('IPS', 12),
('IPS', 10),
('IPS', 11),
('Multimedia', 10),
('Informatika', 11),
('Akuntansi', 12),
('Multimedia', 11);

-- --------------------------------------------------------

--
-- Table structure for table `materi_tbl`
--

CREATE TABLE `materi_tbl` (
  `Materi_id` varchar(7) NOT NULL,
  `Materi_title` varchar(25) NOT NULL,
  `Materi_sub_id` varchar(7) NOT NULL,
  `Materi_desc` varchar(70) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `materi_tbl`
--

INSERT INTO `materi_tbl` (`Materi_id`, `Materi_title`, `Materi_sub_id`, `Materi_desc`) VALUES
('DPB1', 'Perulangan', 'DPB', 'Pembelajaran Perulangan C++'),
('DPB2', 'Percabangan', 'DPB', 'Pembelajaran Percabangan C++'),
('DPB3', 'Array', 'DPB', 'Pembelajaran Array C++'),
('PBO1', 'Enkapsulasi', 'PBO', 'Pembelajaran enkapsulasi atribut'),
('PBO2', 'ArrayList', 'PBO', 'Pembelajaran Array dan ArrayList'),
('PBO3', 'Try and Exception', 'PBO', 'Pembelajaran Try and Exception'),
('PBO4', 'GUI', 'PBO', 'Pembelajaran Interface Java GUI');

-- --------------------------------------------------------

--
-- Table structure for table `student_tbl`
--

CREATE TABLE `student_tbl` (
  `Stud_email` varchar(20) NOT NULL,
  `Stud_firstname` varchar(11) NOT NULL,
  `Stud_lastname` varchar(11) NOT NULL,
  `Stud_role` varchar(4) NOT NULL,
  `Stud_jurusan` varchar(20) NOT NULL,
  `Stud_kelas` int(3) NOT NULL,
  `Stud_pass` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student_tbl`
--

INSERT INTO `student_tbl` (`Stud_email`, `Stud_firstname`, `Stud_lastname`, `Stud_role`, `Stud_jurusan`, `Stud_kelas`, `Stud_pass`) VALUES
('alabama@gmail.com', 'alba', 'abama', 'SMK', 'Akuntasi', 12, 'albagtg'),
('cobalagisih', 'coba', 'lagi', 'SMA', 'IPS', 10, 'gtw13'),
('elbodok', 'el', 'manuel', 'SMK', 'Informatika', 12, 'abcdefgh'),
('iniberhasilkan', 'ini', 'berhasil', 'SMA', 'IPA', 10, 'apalah'),
('inicobacoba', 'ini', 'coba', 'SMK', 'Akuntasi', 10, 'gtw12'),
('jiahanhan', 'jia', 'han', 'SMK', 'Akuntasi', 10, '102030'),
('keketanakbaik', 'cat', 'kucing', 'SMK', 'Akuntasi', 10, 'ketlove'),
('oeothecat', 'oeo', 'cat', 'SMK', 'Farmasi', 12, 'oeolove');

-- --------------------------------------------------------

--
-- Table structure for table `subject_tbl`
--

CREATE TABLE `subject_tbl` (
  `Sub_id` varchar(7) NOT NULL,
  `Sub_name` varchar(20) NOT NULL,
  `Sub_desc` varchar(70) NOT NULL,
  `Sub_jurusan` varchar(20) NOT NULL,
  `Sub_teach` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `subject_tbl`
--

INSERT INTO `subject_tbl` (`Sub_id`, `Sub_name`, `Sub_desc`, `Sub_jurusan`, `Sub_teach`) VALUES
('AKNDB', 'Akuntansi Dasar', 'Pembelajaran Akuntansi Dasar SMK Akuntansi', 'Akuntansi', '56709845'),
('ASD', 'Struktur Data', 'Pembelajaran Algoritma dan Struktur Data SMK Informatika', 'Informatika', '22356378'),
('BINA', 'Sastra Indonesia-IPA', 'Kursus Sastra Indonesia Untuk SMA IPA', 'IPA', '01234567'),
('DEGP', 'Desain Grafis', 'Pembelajaran Desain Grafis SMK Multimedia', 'Multimedia', '27890123'),
('DPB', 'Dasar Pemrograman', 'Pembelajaran Dasar Pemrograman SMK Informatika', 'Informatika', '22356378'),
('FIS', 'Elektronika', 'Kursus Elektronika Untuk SMA IPA', 'IPA', '10678923'),
('INF', 'Informatika-IPA', 'Kursus Informatika Dasar SMA IPA', 'IPA', '22356378'),
('JARKOM', 'Jaringan Komputer', 'Kursus Jaringan Komputer SMK Informatika', 'Informatika', '22356378'),
('KMB', 'Kimia', 'Pembelajaran Kimia SMK Farmasi', 'Farmasi', '25678456'),
('KMPR', 'Komputasi Paralel', 'kompar', 'Informatika', '22356378'),
('MTK1B', 'Ekonomi Dasar-Akunta', 'Kursus Ekonomi Dasar Untuk SMK Akuntansi', 'Akuntansi', '12345678'),
('MTK2B', 'Kalkulus-Farmasi', 'Kursus Kalkulus Untuk SMK Farmasi', 'Farmasi', '12345678'),
('MTK3B', 'Kalkulus-Multimedia', 'Kursus Kalkulus Untuk SMK Multimedia', 'Multimedia', '12345678'),
('MTKA', 'Ekonomi Dasar-IPS', 'Kursus Ekonomi Dasar Untuk SMA IPS', 'IPS', '12345678'),
('PBO', 'Pemrograman Berorien', 'Kursus Pemrograman Berorientasi Objek SMK-Informatika', 'Informatika', '22356378'),
('SJRH', 'Hubungan Internasion', 'Kursus Hubungan Internasional Untuk SMA IPS', 'IPS', '25900807');

-- --------------------------------------------------------

--
-- Table structure for table `teacher_tbl`
--

CREATE TABLE `teacher_tbl` (
  `Teach_id` varchar(11) NOT NULL,
  `Teach_email` varchar(25) NOT NULL,
  `Teach_firstname` varchar(11) NOT NULL,
  `Teach_lastname` varchar(11) NOT NULL,
  `Teach_telp` varchar(14) NOT NULL,
  `Teach_edu` varchar(11) NOT NULL,
  `Teach_major` varchar(25) NOT NULL,
  `Teach_pass` varchar(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `teacher_tbl`
--

INSERT INTO `teacher_tbl` (`Teach_id`, `Teach_email`, `Teach_firstname`, `Teach_lastname`, `Teach_telp`, `Teach_edu`, `Teach_major`, `Teach_pass`) VALUES
('01234567', 'admin2BINDO@elitera.ac.id', 'Sri', 'Dewi', '085242902040', 'S2', 'Sastra Indonesia', 'admin2'),
('10678923', 'admin4FIS@elitera.ac.id', 'Maryana', 'Ruth', '081245670304', 'S2', 'Fisika Murni', 'admin4'),
('12345678', 'admin1MTK@elitera.ac.id', 'Siti', 'Hartati', '081524680788', 'S2', 'Matematika Murni', 'admin1'),
('22356378', 'admin6DASPRO@elitera.ac.i', 'Sriyanto', 'Tangahu', '082292499912', 'S2', 'Teknik Informatika', 'admin6'),
('25678456', 'admin5KIM@elitera.ac.id', 'Alfita', 'Gobel', '082206845604', 'S1', 'Kimia Murni', 'admin5'),
('25900807', 'admin7SJRH@elitera.ac.id', 'Rustam', 'Maduni', '081278000678', 'S1', 'Ilmu Hukum', 'admin7'),
('27890123', 'admin3DGRAF@elitera.ac.id', 'Siti', 'Hadju', '081578050067', 'S2', 'DKV', 'admin3'),
('56709845', 'admin8AKNTSD@elitera.ac.i', 'Merlin', 'Pakaya', '084206050703', 'S1', 'Akuntansi', 'admin8');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `materi_tbl`
--
ALTER TABLE `materi_tbl`
  ADD PRIMARY KEY (`Materi_id`);

--
-- Indexes for table `student_tbl`
--
ALTER TABLE `student_tbl`
  ADD PRIMARY KEY (`Stud_email`);

--
-- Indexes for table `subject_tbl`
--
ALTER TABLE `subject_tbl`
  ADD PRIMARY KEY (`Sub_id`);

--
-- Indexes for table `teacher_tbl`
--
ALTER TABLE `teacher_tbl`
  ADD PRIMARY KEY (`Teach_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
