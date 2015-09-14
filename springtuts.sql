-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema springtuts
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema springtuts
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `springtuts` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `springtuts` ;

-- -----------------------------------------------------
-- Table `springtuts`.`offers`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `springtuts`.`offers` ;

CREATE TABLE IF NOT EXISTS `springtuts`.`offers` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `name` VARCHAR(100) NOT NULL COMMENT '',
  `email` VARCHAR(60) NOT NULL COMMENT '',
  `text` TEXT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
