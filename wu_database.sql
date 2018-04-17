-- phpMyAdmin SQL Dump
-- version 4.8.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 16 Kwi 2018, 22:47
-- Wersja serwera: 10.1.31-MariaDB
-- Wersja PHP: 7.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `wu_database`
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

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `pracownicy`
--

CREATE TABLE `pracownicy` (
  `id_pracownika` int(11) NOT NULL,
  `imie_p` varchar(30) NOT NULL,
  `nazwisko_p` varchar(30) NOT NULL,
  `pesel_p` int(11) NOT NULL,
  `email_p` varchar(30) NOT NULL,
  `data_urodzenia_p` varchar(30) NOT NULL,
  `nr_tel_p` int(11) NOT NULL,
  `login_p` varchar(30) NOT NULL,
  `haslo_p` varchar(30) NOT NULL,
  `specjalizacja_p` varchar(30) NOT NULL,
  `ostatnie_logowanie_pracownicy` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `przedmioty`
--

CREATE TABLE `przedmioty` (
  `id_przedmiotu` int(11) NOT NULL,
  `nazwa_przedmiotu` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `specjalizacja_studenci`
--

CREATE TABLE `specjalizacja_studenci` (
  `id_specjalizacji` int(11) NOT NULL,
  `id_studenta` int(11) NOT NULL,
  `kierunek` int(11) NOT NULL,
  `rok` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `studenci`
--

CREATE TABLE `studenci` (
  `id_studenta` int(11) NOT NULL,
  `imie_s` varchar(30) NOT NULL,
  `nazwisko_s` varchar(30) NOT NULL,
  `pesel_s` int(11) NOT NULL,
  `email_s` varchar(30) NOT NULL,
  `data_urodzenia_s` varchar(30) NOT NULL,
  `nr_tel_s` int(11) NOT NULL,
  `login_s` varchar(30) NOT NULL,
  `haslo_s` varchar(30) NOT NULL,
  `nr_albumu_s` varchar(30) NOT NULL,
  `ostatnie_logowanie_studenta` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  ADD PRIMARY KEY (`id_specjalizacji`),
  ADD KEY `id_studenta` (`id_studenta`) USING BTREE;

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
  MODIFY `id_harmonogramu` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT dla tabeli `oceny`
--
ALTER TABLE `oceny`
  MODIFY `id_oceny` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT dla tabeli `pracownicy`
--
ALTER TABLE `pracownicy`
  MODIFY `id_pracownika` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT dla tabeli `przedmioty`
--
ALTER TABLE `przedmioty`
  MODIFY `id_przedmiotu` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT dla tabeli `specjalizacja_studenci`
--
ALTER TABLE `specjalizacja_studenci`
  MODIFY `id_specjalizacji` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT dla tabeli `studenci`
--
ALTER TABLE `studenci`
  MODIFY `id_studenta` int(11) NOT NULL AUTO_INCREMENT;

--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `harmonogram`
--
ALTER TABLE `harmonogram`
  ADD CONSTRAINT `harmonogram_ibfk_1` FOREIGN KEY (`id_pracownika`) REFERENCES `pracownicy` (`id_pracownika`),
  ADD CONSTRAINT `harmonogram_ibfk_2` FOREIGN KEY (`id_przedmiotu`) REFERENCES `przedmioty` (`id_przedmiotu`),
  ADD CONSTRAINT `harmonogram_ibfk_3` FOREIGN KEY (`id_specjalizacji`) REFERENCES `specjalizacja_studenci` (`id_specjalizacji`);

--
-- Ograniczenia dla tabeli `oceny`
--
ALTER TABLE `oceny`
  ADD CONSTRAINT `oceny_ibfk_1` FOREIGN KEY (`id_pracownika`) REFERENCES `pracownicy` (`id_pracownika`),
  ADD CONSTRAINT `oceny_ibfk_2` FOREIGN KEY (`id_przedmiotu`) REFERENCES `przedmioty` (`id_przedmiotu`),
  ADD CONSTRAINT `oceny_ibfk_3` FOREIGN KEY (`id_studenta`) REFERENCES `studenci` (`id_studenta`);

--
-- Ograniczenia dla tabeli `specjalizacja_studenci`
--
ALTER TABLE `specjalizacja_studenci`
  ADD CONSTRAINT `specjalizacja_studenci_ibfk_1` FOREIGN KEY (`id_studenta`) REFERENCES `studenci` (`id_studenta`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
