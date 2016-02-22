CREATE DATABASE `locomaps`; /*!40100 COLLATE 'latin1_general_cs' */

CREATE TABLE `user` (
    `idUser` INT(11) NOT NULL AUTO_INCREMENT,
    `lastName` VARCHAR(80) NOT NULL,
    `firstName` VARCHAR(40) NOT NULL,
    `pseudo` VARCHAR(50) NOT NULL,
    `email` VARCHAR(80) NOT NULL,
    `password` VARCHAR(30) NOT NULL,
    `sex` VARCHAR(10) NOT NULL,
    `smoker` VARCHAR(11) NOT NULL,
    `telephone` VARCHAR(20) NOT NULL,
    PRIMARY KEY (`idUser`),
    UNIQUE INDEX `Kemail` (`email`)
)
COLLATE='latin1_general_cs'
ENGINE=InnoDB
;

CREATE TABLE `address` (
    `idAddress` INT(11) NOT NULL AUTO_INCREMENT,
    `IdUser` INT(11) NULL DEFAULT NULL,
    `adress1` VARCHAR(50) NULL DEFAULT NULL,
    `adress2` VARCHAR(50) NULL DEFAULT NULL,
    `postalCode` VARCHAR(10) NULL DEFAULT NULL,
    `city` VARCHAR(80) NULL DEFAULT NULL,
    `onelineAddress` VARCHAR(500) NULL DEFAULT NULL,
    `latitude` VARCHAR(20) NULL DEFAULT NULL,
    `longitude` VARCHAR(20) NULL DEFAULT NULL,
    PRIMARY KEY (`idAddress`),
    INDEX `Kuser` (`idUser`),
    CONSTRAINT `FKUser` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`)
)
COLLATE='latin1_general_cs'
ENGINE=InnoDB
;