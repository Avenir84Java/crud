DROP DATABASE IF EXISTS crud;

CREATE DATABASE crud CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
SHOW DATABASES;

USE crud;

CREATE TABLE produits (
	id					BIGINT PRIMARY KEY AUTO_INCREMENT,
	nom					VARCHAR(50) NOT NULL,
	prix				DECIMAL(8,2),
	montant_tva				DECIMAL(8,2),
	prix_ttc				DECIMAL(8,2),
	utilisateur_creation     VARCHAR(50)    NOT NULL DEFAULT  'root',
	date_creation            DATETIME       NOT NULL DEFAULT CURRENT_TIMESTAMP,
	utilisateur_maj          VARCHAR(50)    NOT NULL DEFAULT 'root',
	dat_maj                  DATETIME       NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,    
	INDEX(nom),
	INDEX(prix)
);
SHOW TABLES;
DESCRIBE produits;

INSERT INTO produits (nom, prix) VALUES ('PC HP', 1250);
INSERT INTO produits (nom, prix) VALUES ('Imprimante HP', 520);
INSERT INTO produits (nom, prix) VALUES ('Scanner HP', 324);
INSERT INTO produits (nom, prix) VALUES ('PC Acer', 850);
INSERT INTO produits (nom, prix) VALUES ('Smartphone Samsung', 350);
INSERT INTO produits (nom, prix) VALUES ('Imprimante Samsung', 220);
INSERT INTO produits (nom, prix) VALUES ('PC Asus', 1350);
INSERT INTO produits (nom, prix) VALUES ('Ecran HP', 510);
INSERT INTO produits (nom, prix) VALUES ('Imprimante Canon', 420);
INSERT INTO produits (nom, prix) VALUES ('Ecran Lenovo', 650);

SELECT * FROM produits;
