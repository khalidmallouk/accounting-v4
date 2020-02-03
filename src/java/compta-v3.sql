-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  lun. 03 fév. 2020 à 12:19
-- Version du serveur :  10.4.8-MariaDB
-- Version de PHP :  7.1.33

SET FOREIGN_KEY_CHECKS=0;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `compta-v3`
--

-- --------------------------------------------------------

--
-- Structure de la table `comptecomptable`
--

CREATE TABLE `comptecomptable` (
  `ID` bigint(20) NOT NULL,
  `LIBELLE` varchar(255) DEFAULT NULL,
  `NUMERO` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `comptecomptable`
--

INSERT INTO `comptecomptable` (`ID`, `LIBELLE`, `NUMERO`) VALUES
(1, 'Achat de matiÃ¨res premiÃ¨res', 6121),
(2, 'Achat de marchandises', 6111),
(3, 'Vente de marchandises au Maroc', 7111),
(4, 'Fournisseurs', 4411),
(5, 'Clients', 3421),
(6, 'Vente de marchandises Ã Â  l\'etranger', 7113),
(7, 'Transports', 6142),
(8, 'Vente de produits finis', 71211);

-- --------------------------------------------------------

--
-- Structure de la table `facture`
--

CREATE TABLE `facture` (
  `ID` bigint(20) NOT NULL,
  `MONTANTHT` decimal(38,0) DEFAULT NULL,
  `MONTANTTTC` decimal(38,0) DEFAULT NULL,
  `REFERENCE` varchar(255) DEFAULT NULL,
  `SOCIETE_ID` bigint(20) DEFAULT NULL,
  `TVA_ID` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `operationsaisie`
--

CREATE TABLE `operationsaisie` (
  `ID` bigint(20) NOT NULL,
  `DATEOPERATION` datetime DEFAULT NULL,
  `LIBELLE` varchar(255) DEFAULT NULL,
  `MONTANT` decimal(38,0) DEFAULT NULL,
  `NUMEROENREGISTREMENT` double DEFAULT NULL,
  `NUMEROFACTURE` varchar(255) DEFAULT NULL,
  `COMPTECOMPTABLE_ID` bigint(20) DEFAULT NULL,
  `SOCIETE_ID` bigint(20) DEFAULT NULL,
  `TYPEJOURNAL_ID` bigint(20) DEFAULT NULL,
  `TYPEOPERATIONSAISIE_ID` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `sequence`
--

CREATE TABLE `sequence` (
  `SEQ_NAME` varchar(50) NOT NULL,
  `SEQ_COUNT` decimal(38,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `sequence`
--

INSERT INTO `sequence` (`SEQ_NAME`, `SEQ_COUNT`) VALUES
('SEQ_GEN', '0');

-- --------------------------------------------------------

--
-- Structure de la table `societe`
--

CREATE TABLE `societe` (
  `ID` bigint(20) NOT NULL,
  `IFISCAL` varchar(255) DEFAULT NULL,
  `ICE` varchar(255) DEFAULT NULL,
  `RAISONSOCIALE` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `societe`
--

INSERT INTO `societe` (`ID`, `IFISCAL`, `ICE`, `RAISONSOCIALE`) VALUES
(11, '45678', '00012345678', 'SociÃ©tÃ© X'),
(12, '567899', '0007635552', 'SociÃ©tÃ© Y');

-- --------------------------------------------------------

--
-- Structure de la table `tva`
--

CREATE TABLE `tva` (
  `ID` bigint(20) NOT NULL,
  `LIBELLE` varchar(255) DEFAULT NULL,
  `VALEUR` decimal(38,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `typejournal`
--

CREATE TABLE `typejournal` (
  `ID` bigint(20) NOT NULL,
  `LIBELLE` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `typejournal`
--

INSERT INTO `typejournal` (`ID`, `LIBELLE`) VALUES
(1, 'ACHATS'),
(2, 'VENTES'),
(3, 'BANQUE'),
(4, 'CAISSE'),
(5, 'OPERATIONDIVERS'),
(6, 'REPORTANOUVEAU');

-- --------------------------------------------------------

--
-- Structure de la table `typeoperationsaisie`
--

CREATE TABLE `typeoperationsaisie` (
  `ID` bigint(20) NOT NULL,
  `LIBELLE` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `typeoperationsaisie`
--

INSERT INTO `typeoperationsaisie` (`ID`, `LIBELLE`) VALUES
(7, 'DEBIT'),
(8, 'CREDIT');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `comptecomptable`
--
ALTER TABLE `comptecomptable`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `facture`
--
ALTER TABLE `facture`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_FACTURE_SOCIETE_ID` (`SOCIETE_ID`),
  ADD KEY `FK_FACTURE_TVA_ID` (`TVA_ID`);

--
-- Index pour la table `operationsaisie`
--
ALTER TABLE `operationsaisie`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_OPERATIONSAISIE_TYPEJOURNAL_ID` (`TYPEJOURNAL_ID`),
  ADD KEY `FK_OPERATIONSAISIE_TYPEOPERATIONSAISIE_ID` (`TYPEOPERATIONSAISIE_ID`),
  ADD KEY `FK_OPERATIONSAISIE_COMPTECOMPTABLE_ID` (`COMPTECOMPTABLE_ID`),
  ADD KEY `FK_OPERATIONSAISIE_SOCIETE_ID` (`SOCIETE_ID`);

--
-- Index pour la table `sequence`
--
ALTER TABLE `sequence`
  ADD PRIMARY KEY (`SEQ_NAME`);

--
-- Index pour la table `societe`
--
ALTER TABLE `societe`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `tva`
--
ALTER TABLE `tva`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `typejournal`
--
ALTER TABLE `typejournal`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `typeoperationsaisie`
--
ALTER TABLE `typeoperationsaisie`
  ADD PRIMARY KEY (`ID`);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `facture`
--
ALTER TABLE `facture`
  ADD CONSTRAINT `FK_FACTURE_SOCIETE_ID` FOREIGN KEY (`SOCIETE_ID`) REFERENCES `societe` (`ID`),
  ADD CONSTRAINT `FK_FACTURE_TVA_ID` FOREIGN KEY (`TVA_ID`) REFERENCES `tva` (`ID`);

--
-- Contraintes pour la table `operationsaisie`
--
ALTER TABLE `operationsaisie`
  ADD CONSTRAINT `FK_OPERATIONSAISIE_COMPTECOMPTABLE_ID` FOREIGN KEY (`COMPTECOMPTABLE_ID`) REFERENCES `comptecomptable` (`ID`),
  ADD CONSTRAINT `FK_OPERATIONSAISIE_SOCIETE_ID` FOREIGN KEY (`SOCIETE_ID`) REFERENCES `societe` (`ID`),
  ADD CONSTRAINT `FK_OPERATIONSAISIE_TYPEJOURNAL_ID` FOREIGN KEY (`TYPEJOURNAL_ID`) REFERENCES `typejournal` (`ID`),
  ADD CONSTRAINT `FK_OPERATIONSAISIE_TYPEOPERATIONSAISIE_ID` FOREIGN KEY (`TYPEOPERATIONSAISIE_ID`) REFERENCES `typeoperationsaisie` (`ID`);
SET FOREIGN_KEY_CHECKS=1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
