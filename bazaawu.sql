-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 02 Cze 2018, 14:34
-- Wersja serwera: 10.1.32-MariaDB
-- Wersja PHP: 7.2.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `bazaawu`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `harmonogram`
--

CREATE TABLE `harmonogram` (
  `id_harmonogramu` int(11) NOT NULL,
  `id_przedmiotu` int(11) NOT NULL,
  `id_pracownika` int(11) NOT NULL,
  `data_zajec_h` varchar(30) NOT NULL,
  `godzina_h` varchar(30) NOT NULL,
  `id_specjalizacji` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `harmonogram`
--

INSERT INTO `harmonogram` (`id_harmonogramu`, `id_przedmiotu`, `id_pracownika`, `data_zajec_h`, `godzina_h`, `id_specjalizacji`) VALUES
(1, 3, 2, '05.05.2018 ', '11:20', 1),
(2, 2, 1, '06:05.2018', '13:00', 2);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `oceny`
--

CREATE TABLE `oceny` (
  `id_oceny` int(11) NOT NULL,
  `id_przedmiotu` int(11) NOT NULL,
  `id_studenta` int(11) NOT NULL,
  `id_pracownika` int(11) NOT NULL,
  `ocena` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `oceny`
--

INSERT INTO `oceny` (`id_oceny`, `id_przedmiotu`, `id_studenta`, `id_pracownika`, `ocena`) VALUES
(1, 3, 6, 2, 5),
(2, 2, 3, 1, 4),
(3, 4, 5, 3, 4),
(4, 2, 3, 2, 4);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `pracownicy`
--

CREATE TABLE `pracownicy` (
  `id_pracownika` int(11) NOT NULL,
  `imie_p` varchar(30) NOT NULL,
  `nazwisko_p` varchar(30) NOT NULL,
  `pesel_p` bigint(11) NOT NULL,
  `email_p` varchar(30) NOT NULL,
  `data_urodzenia_p` varchar(30) NOT NULL,
  `nr_tel_p` int(11) NOT NULL,
  `login_p` varchar(30) NOT NULL,
  `haslo_p` varchar(35) NOT NULL,
  `specjalizacja_p` varchar(30) NOT NULL,
  `ostatnie_logowanie_pracownicy` varchar(30) NOT NULL,
  `zalogowany_p` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `pracownicy`
--

INSERT INTO `pracownicy` (`id_pracownika`, `imie_p`, `nazwisko_p`, `pesel_p`, `email_p`, `data_urodzenia_p`, `nr_tel_p`, `login_p`, `haslo_p`, `specjalizacja_p`, `ostatnie_logowanie_pracownicy`, `zalogowany_p`) VALUES
(1, 'Cong', 'Lu', 96120394586, 'Lu@armyspy.com', '11.12.1995', 768192405, 'admin', '098f6bcd4621d373cade4e832627b4f6', '1', '03.12.2018 10:20', NULL),
(2, 'Ping', 'Li', 75941039586, 'PingLi@rhyta.com', '11.07.1975', 798112998, 'prowadzacy', 'ad0234829205b9033196ba818f7a872b', '2', '11.04.2018 15:30', NULL),
(3, 'Betancourt', 'Mares', 94304958192, 'ares@armyspy.com', '01.01.1984', 687192003, 'dziekanat', '8ad8757baa8564dc136c1e07507f4a98', '3', '12.12.2017 23:24', NULL),
(4, 'Anna ', 'Rutkowska', 90185948192, 'wska@dayrep.com', '11.03.1990', 345968010, 'Nowest', 'chei4xuN', '2', '23.11.2017 14:30', NULL);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `przedmioty`
--

CREATE TABLE `przedmioty` (
  `id_przedmiotu` int(11) NOT NULL,
  `nazwa_przedmiotu` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `przedmioty`
--

INSERT INTO `przedmioty` (`id_przedmiotu`, `nazwa_przedmiotu`) VALUES
(1, 'Medyczne bazy danych'),
(2, 'Technologie Sieciowe 2'),
(3, 'Podstawy Programowania'),
(4, 'Programowanie Zespolowe'),
(5, 'Matematyka '),
(6, 'Matematyka Dyskretna'),
(7, 'Metody numeryczne'),
(8, 'Technologie internetowe'),
(9, 'Jezyk Angielski'),
(10, 'Jezyk Skryptowy'),
(11, 'Metody eksploracji baz danych'),
(12, 'Projekt inzynierski');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `specjalizacja_studenci`
--

CREATE TABLE `specjalizacja_studenci` (
  `id_specjalizacji` int(11) NOT NULL,
  `id_studenta` int(11) NOT NULL,
  `kierunek` varchar(11) NOT NULL,
  `rok` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `specjalizacja_studenci`
--

INSERT INTO `specjalizacja_studenci` (`id_specjalizacji`, `id_studenta`, `kierunek`, `rok`) VALUES
(1, 6, 'Informatyka', 2),
(2, 5, 'Informatyka', 3),
(3, 11, 'Ekonometria', 1),
(4, 10, 'Fizyka', 3);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `studenci`
--

CREATE TABLE `studenci` (
  `id_studenta` int(11) NOT NULL,
  `imie_s` varchar(30) NOT NULL,
  `nazwisko_s` varchar(30) NOT NULL,
  `pesel_s` bigint(11) NOT NULL,
  `email_s` varchar(30) NOT NULL,
  `data_urodzenia_s` varchar(30) NOT NULL,
  `nr_tel_s` int(11) NOT NULL,
  `login_s` varchar(30) NOT NULL,
  `haslo_s` varchar(30) NOT NULL,
  `nr_albumu_s` varchar(30) NOT NULL,
  `ostatnie_logowanie_studenta` varchar(30) NOT NULL,
  `zalogowany_s` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `studenci`
--

INSERT INTO `studenci` (`id_studenta`, `imie_s`, `nazwisko_s`, `pesel_s`, `email_s`, `data_urodzenia_s`, `nr_tel_s`, `login_s`, `haslo_s`, `nr_albumu_s`, `ostatnie_logowanie_studenta`, `zalogowany_s`) VALUES
(3, 'Richard', ' Roseboro', 96345301293, 'Rich@jourrapide.com', '03.23.1996', 758329106, 'Againto', 'oojoTep3ah', '110491', '17.03.2018 16:45', NULL),
(4, 'Celsa', 'Luna', 94584738594, 'Luna@teleworm.us', '01.06.1994', 685395483, 'Tooduked', 'AhFah0hup5f', '110394', '11.11.2001 22:11', NULL),
(5, 'Weronika ', 'Chmielewska', 96110239586, 'Chmielewska@rhyta.com', '07.07.1996', 758049582, 'Therencough', 'ooL8raixei2', '110011', '11.05.2017 15:30 ', NULL),
(6, 'Ubaida', 'Jalal ', 91110295483, 'alBata@jourrapide.com', '29.11.1991', 768493012, 'Onsid1987', 'eiJuepei5th', '111395', '11.12.2017 16:55', NULL),
(7, 'Abdul-Salam', 'Maroun', 95840195832, 'aroun@armyspy.com', '01.01.1958', 777694857, 'Oppostis', 'pie2Uwaa2o', '123451', '11.07.2017 17:20', NULL),
(8, 'Tadzio', 'Duda', 95843920594, 'Duda@dayrep.com', '12.14.1995', 884665382, 'Porknowle', 'bahg0Bei6o', '111333', '12.12.2017 11:20', NULL),
(9, 'Jakub ', 'Pawlak', 96584948123, 'Pawlak@armyspy.com', '11.11.1994', 711394867, 'Lins1951', 'oakai5Dil', '112002', '02.03.2018 11:33', NULL),
(10, 'Antoni ', 'Wozniak', 96123059586, 'zniak@rhyta.com', '11.04.1994', 666857463, 'Carch1990', 'Moowoo5ucah', '112395', '04.12.2017 14:27', NULL),
(11, 'Longin', 'Olszewski', 96584759112, 'wski@armyspy.com', '04.04.1992', 687594823, 'Shmisting', 'beirae6aeD', '114059', '22.04.2018 17:33', NULL);

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `harmonogram`
--
ALTER TABLE `harmonogram`
  ADD PRIMARY KEY (`id_harmonogramu`),
  ADD KEY `id_pracownika` (`id_pracownika`),
  ADD KEY `id_przedmiotu` (`id_przedmiotu`),
  ADD KEY `id_specjalizacji` (`id_specjalizacji`);

--
-- Indeksy dla tabeli `oceny`
--
ALTER TABLE `oceny`
  ADD PRIMARY KEY (`id_oceny`),
  ADD KEY `id_pracownika` (`id_pracownika`),
  ADD KEY `id_przedmiotu` (`id_przedmiotu`),
  ADD KEY `id_studenta` (`id_studenta`) USING BTREE;

--
-- Indeksy dla tabeli `pracownicy`
--
ALTER TABLE `pracownicy`
  ADD PRIMARY KEY (`id_pracownika`);

--
-- Indeksy dla tabeli `przedmioty`
--
ALTER TABLE `przedmioty`
  ADD PRIMARY KEY (`id_przedmiotu`);

--
-- Indeksy dla tabeli `specjalizacja_studenci`
--
ALTER TABLE `specjalizacja_studenci`
  ADD PRIMARY KEY (`id_specjalizacji`);

--
-- Indeksy dla tabeli `studenci`
--
ALTER TABLE `studenci`
  ADD PRIMARY KEY (`id_studenta`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `harmonogram`
--
ALTER TABLE `harmonogram`
  MODIFY `id_harmonogramu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT dla tabeli `oceny`
--
ALTER TABLE `oceny`
  MODIFY `id_oceny` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT dla tabeli `pracownicy`
--
ALTER TABLE `pracownicy`
  MODIFY `id_pracownika` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT dla tabeli `przedmioty`
--
ALTER TABLE `przedmioty`
  MODIFY `id_przedmiotu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
