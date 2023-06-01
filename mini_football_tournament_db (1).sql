-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mer. 31 mai 2023 à 20:19
-- Version du serveur : 10.4.28-MariaDB
-- Version de PHP : 8.1.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `mini_football_tournament_db`
--

-- --------------------------------------------------------

--
-- Structure de la table `but`
--

CREATE TABLE `but` (
  `id` int(11) NOT NULL,
  `match_id` int(11) DEFAULT NULL,
  `joueur_marqueur_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `changement`
--

CREATE TABLE `changement` (
  `id` int(11) NOT NULL,
  `match_id` int(11) DEFAULT NULL,
  `joueur_sortant_id` int(11) DEFAULT NULL,
  `joueur_entrant_id` int(11) DEFAULT NULL,
  `minute_changement` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `entraineur`
--

CREATE TABLE `entraineur` (
  `id` int(11) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `prenom` varchar(100) NOT NULL,
  `date_naissance` date NOT NULL,
  `pays` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `equipe`
--

CREATE TABLE `equipe` (
  `id` int(11) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `date_creation` date NOT NULL,
  `pays` varchar(100) NOT NULL,
  `entraineur_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `gardien_de_but`
--

CREATE TABLE `gardien_de_but` (
  `id` int(11) NOT NULL,
  `joueur_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `joueur`
--

CREATE TABLE `joueur` (
  `id` int(11) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `prenom` varchar(100) NOT NULL,
  `date_naissance` date NOT NULL,
  `pays` varchar(100) NOT NULL,
  `salaire` double NOT NULL,
  `matchs_joues` int(11) NOT NULL,
  `avertissements_total` int(11) NOT NULL,
  `avertissements_actifs` int(11) NOT NULL,
  `expulsions_total` int(11) NOT NULL,
  `matchs_suspendus` int(11) NOT NULL,
  `competitif` tinyint(1) NOT NULL,
  `equipe_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `joueur_milieu_terrain`
--

CREATE TABLE `joueur_milieu_terrain` (
  `id` int(11) NOT NULL,
  `joueur_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `journee`
--

CREATE TABLE `journee` (
  `id` int(11) NOT NULL,
  `tournoi_id` int(11) DEFAULT NULL,
  `date_journee` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `journee`
--

INSERT INTO `journee` (`id`, `tournoi_id`, `date_journee`) VALUES
(1, 1, '2023-01-05'),
(2, 1, '2023-01-05');

-- --------------------------------------------------------

--
-- Structure de la table `match`
--

CREATE TABLE `match` (
  `id` int(11) NOT NULL,
  `journee_id` int(11) DEFAULT NULL,
  `equipe_domicile_id` int(11) DEFAULT NULL,
  `equipe_visiteur_id` int(11) DEFAULT NULL,
  `score_domicile` int(11) DEFAULT NULL,
  `score_visiteur` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `tournoi`
--

CREATE TABLE `tournoi` (
  `id` int(11) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `date_debut` date NOT NULL,
  `date_fin` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `tournoi`
--

INSERT INTO `tournoi` (`id`, `nom`, `date_debut`, `date_fin`) VALUES
(1, 'aziz ', '2021-02-04', '2023-02-15'),
(2, 'saybniiii', '2023-01-05', '2023-01-31'),
(3, 'heni', '2023-05-25', '2023-05-31'),
(5, 'New Tournament', '2023-05-23', '2023-05-30'),
(6, 'ahla', '2023-05-25', '2023-06-01'),
(7, 'yooo', '2023-06-14', '2023-06-14'),
(8, 'sfsf', '2023-05-06', '2023-07-24'),
(9, 'New Tournament', '2023-05-24', '2023-05-31'),
(10, 'ahled', '2023-05-01', '2023-05-02');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `login` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `nom`, `prenom`, `login`, `password`) VALUES
(1, 'Ayyadi', 'Slim', 'aa', 'bb'),
(2, 'Ben Omar', 'Ali', 'zz', 'yy'),
(3, 'Sallemi', 'Mohamed', '11', '22'),
(4, 'Sallemi', 'Mohamed', '11', '22'),
(5, 'Sallemi', 'Mohamed', '11', '22'),
(6, 'khlif', 'ahmed', 'ah', '789maida789'),
(7, 'Sallemi', 'Mohamed', '11', '22'),
(8, 'admin', 'admin', 'admin', 'admin'),
(9, 'admin', 'admin', 'admin', 'admin'),
(10, '123456', 'aaaa', 'sgfds', '123456'),
(11, 'ahla', 'bik', 'ahmed', 'khlif'),
(12, 'admin', 'admin', 'admin', 'admin');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `but`
--
ALTER TABLE `but`
  ADD PRIMARY KEY (`id`),
  ADD KEY `match_id` (`match_id`),
  ADD KEY `joueur_marqueur_id` (`joueur_marqueur_id`);

--
-- Index pour la table `changement`
--
ALTER TABLE `changement`
  ADD PRIMARY KEY (`id`),
  ADD KEY `match_id` (`match_id`),
  ADD KEY `joueur_sortant_id` (`joueur_sortant_id`),
  ADD KEY `joueur_entrant_id` (`joueur_entrant_id`);

--
-- Index pour la table `entraineur`
--
ALTER TABLE `entraineur`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `equipe`
--
ALTER TABLE `equipe`
  ADD PRIMARY KEY (`id`),
  ADD KEY `entraineur_id` (`entraineur_id`);

--
-- Index pour la table `gardien_de_but`
--
ALTER TABLE `gardien_de_but`
  ADD PRIMARY KEY (`id`),
  ADD KEY `joueur_id` (`joueur_id`);

--
-- Index pour la table `joueur`
--
ALTER TABLE `joueur`
  ADD PRIMARY KEY (`id`),
  ADD KEY `equipe_id` (`equipe_id`);

--
-- Index pour la table `joueur_milieu_terrain`
--
ALTER TABLE `joueur_milieu_terrain`
  ADD PRIMARY KEY (`id`),
  ADD KEY `joueur_id` (`joueur_id`);

--
-- Index pour la table `journee`
--
ALTER TABLE `journee`
  ADD PRIMARY KEY (`id`),
  ADD KEY `tournoi_id` (`tournoi_id`);

--
-- Index pour la table `match`
--
ALTER TABLE `match`
  ADD PRIMARY KEY (`id`),
  ADD KEY `journee_id` (`journee_id`),
  ADD KEY `equipe_domicile_id` (`equipe_domicile_id`),
  ADD KEY `equipe_visiteur_id` (`equipe_visiteur_id`);

--
-- Index pour la table `tournoi`
--
ALTER TABLE `tournoi`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `but`
--
ALTER TABLE `but`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `changement`
--
ALTER TABLE `changement`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `entraineur`
--
ALTER TABLE `entraineur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `equipe`
--
ALTER TABLE `equipe`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `gardien_de_but`
--
ALTER TABLE `gardien_de_but`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `joueur`
--
ALTER TABLE `joueur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `joueur_milieu_terrain`
--
ALTER TABLE `joueur_milieu_terrain`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `journee`
--
ALTER TABLE `journee`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `match`
--
ALTER TABLE `match`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `tournoi`
--
ALTER TABLE `tournoi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `but`
--
ALTER TABLE `but`
  ADD CONSTRAINT `but_ibfk_1` FOREIGN KEY (`match_id`) REFERENCES `match` (`id`),
  ADD CONSTRAINT `but_ibfk_2` FOREIGN KEY (`joueur_marqueur_id`) REFERENCES `joueur` (`id`);

--
-- Contraintes pour la table `changement`
--
ALTER TABLE `changement`
  ADD CONSTRAINT `changement_ibfk_1` FOREIGN KEY (`match_id`) REFERENCES `match` (`id`),
  ADD CONSTRAINT `changement_ibfk_2` FOREIGN KEY (`joueur_sortant_id`) REFERENCES `joueur` (`id`),
  ADD CONSTRAINT `changement_ibfk_3` FOREIGN KEY (`joueur_entrant_id`) REFERENCES `joueur` (`id`);

--
-- Contraintes pour la table `equipe`
--
ALTER TABLE `equipe`
  ADD CONSTRAINT `equipe_ibfk_1` FOREIGN KEY (`entraineur_id`) REFERENCES `entraineur` (`id`);

--
-- Contraintes pour la table `gardien_de_but`
--
ALTER TABLE `gardien_de_but`
  ADD CONSTRAINT `gardien_de_but_ibfk_1` FOREIGN KEY (`joueur_id`) REFERENCES `joueur` (`id`);

--
-- Contraintes pour la table `joueur`
--
ALTER TABLE `joueur`
  ADD CONSTRAINT `joueur_ibfk_1` FOREIGN KEY (`equipe_id`) REFERENCES `equipe` (`id`);

--
-- Contraintes pour la table `joueur_milieu_terrain`
--
ALTER TABLE `joueur_milieu_terrain`
  ADD CONSTRAINT `joueur_milieu_terrain_ibfk_1` FOREIGN KEY (`joueur_id`) REFERENCES `joueur` (`id`);

--
-- Contraintes pour la table `journee`
--
ALTER TABLE `journee`
  ADD CONSTRAINT `journee_ibfk_1` FOREIGN KEY (`tournoi_id`) REFERENCES `tournoi` (`id`);

--
-- Contraintes pour la table `match`
--
ALTER TABLE `match`
  ADD CONSTRAINT `match_ibfk_1` FOREIGN KEY (`journee_id`) REFERENCES `journee` (`id`),
  ADD CONSTRAINT `match_ibfk_2` FOREIGN KEY (`equipe_domicile_id`) REFERENCES `equipe` (`id`),
  ADD CONSTRAINT `match_ibfk_3` FOREIGN KEY (`equipe_visiteur_id`) REFERENCES `equipe` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
