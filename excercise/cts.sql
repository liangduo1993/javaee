-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema cts
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema cts
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cts` DEFAULT CHARACTER SET utf8 ;
USE `cts` ;

-- -----------------------------------------------------
-- Table `cts`.`library`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cts`.`library` ;

CREATE TABLE IF NOT EXISTS `cts`.`library` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cts`.`question`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cts`.`question` ;

CREATE TABLE IF NOT EXISTS `cts`.`question` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `difficulty` INT NOT NULL,
  `type` INT NULL,
  `time_limit` BIGINT(20) NOT NULL,
  `date_creation` DATETIME NOT NULL,
  `user_creation` BIGINT(20) NOT NULL,
  `lib_id` BIGINT(20) NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_question_library1_idx` (`lib_id` ASC),
  CONSTRAINT `fk_question_library1`
    FOREIGN KEY (`lib_id`)
    REFERENCES `cts`.`library` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cts`.`question_content`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cts`.`question_content` ;

CREATE TABLE IF NOT EXISTS `cts`.`question_content` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `question_id` BIGINT(20) NOT NULL,
  `content` VARCHAR(1024) NOT NULL,
  `sort` INT NULL,
  `type` INT NOT NULL,
  `is_right` INT NULL,
  `score` INT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_question_property_question1_idx` (`question_id` ASC),
  CONSTRAINT `fk_question_property_question1`
    FOREIGN KEY (`question_id`)
    REFERENCES `cts`.`question` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cts`.`exam`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cts`.`exam` ;

CREATE TABLE IF NOT EXISTS `cts`.`exam` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NULL,
  `date_creation` DATETIME NOT NULL,
  `user_creation` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cts`.`exam_question_mapping`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cts`.`exam_question_mapping` ;

CREATE TABLE IF NOT EXISTS `cts`.`exam_question_mapping` (
  `exam_id` BIGINT(20) NOT NULL,
  `question_id` BIGINT(20) NOT NULL,
  INDEX `fk_exam_question_mapping_exam1_idx` (`exam_id` ASC),
  INDEX `fk_exam_question_mapping_question1_idx` (`question_id` ASC),
  CONSTRAINT `fk_exam_question_mapping_exam1`
    FOREIGN KEY (`exam_id`)
    REFERENCES `cts`.`exam` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_exam_question_mapping_question1`
    FOREIGN KEY (`question_id`)
    REFERENCES `cts`.`question` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cts`.`role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cts`.`role` ;

CREATE TABLE IF NOT EXISTS `cts`.`role` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cts`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cts`.`user` ;

CREATE TABLE IF NOT EXISTS `cts`.`user` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `pwd` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NULL,
  `role_id` BIGINT(20) NOT NULL,
  `email` VARCHAR(45) NULL,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `cv` VARCHAR(5000) NULL,
  PRIMARY KEY (`id`, `role_id`),
  INDEX `fk_user_role1_idx` (`role_id` ASC),
  CONSTRAINT `fk_user_role1`
    FOREIGN KEY (`role_id`)
    REFERENCES `cts`.`role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cts`.`test`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cts`.`test` ;

CREATE TABLE IF NOT EXISTS `cts`.`test` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `start` DATETIME NOT NULL,
  `end` DATETIME NOT NULL,
  `duration` BIGINT(20) NOT NULL,
  `score` DECIMAL(4,2) NOT NULL,
  `assigner` BIGINT(20) NULL,
  `assignee` BIGINT(20) NOT NULL,
  `exam_id` BIGINT(20) NOT NULL,
  `launch_time` DATETIME NULL,
  `score_choices` DECIMAL(4,2) NULL,
  `score_choices_max` INT NULL,
  `score_max` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_test_user1_idx` (`assignee` ASC),
  INDEX `fk_test_exam1_idx` (`exam_id` ASC),
  CONSTRAINT `fk_test_user1`
    FOREIGN KEY (`assignee`)
    REFERENCES `cts`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_test_exam1`
    FOREIGN KEY (`exam_id`)
    REFERENCES `cts`.`exam` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cts`.`answer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cts`.`answer` ;

CREATE TABLE IF NOT EXISTS `cts`.`answer` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `question_content_id` BIGINT(20) NOT NULL,
  `text_answer` VARCHAR(2048) NULL,
  `test_id` BIGINT(20) NOT NULL,
  `score` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_answer_test2_idx` (`test_id` ASC),
  INDEX `fk_answer_question_content1_idx` (`question_content_id` ASC),
  CONSTRAINT `fk_answer_test2`
    FOREIGN KEY (`test_id`)
    REFERENCES `cts`.`test` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_answer_question_content1`
    FOREIGN KEY (`question_content_id`)
    REFERENCES `cts`.`question_content` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cts`.`permission`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cts`.`permission` ;

CREATE TABLE IF NOT EXISTS `cts`.`permission` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `url` VARCHAR(128) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cts`.`role_permission_mapping`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cts`.`role_permission_mapping` ;

CREATE TABLE IF NOT EXISTS `cts`.`role_permission_mapping` (
  `role_id` BIGINT(20) NOT NULL,
  `permission_id` BIGINT(20) NOT NULL,
  INDEX `fk_role_permission_mapping_role1_idx` (`role_id` ASC),
  INDEX `fk_role_permission_mapping_permission1_idx` (`permission_id` ASC),
  CONSTRAINT `fk_role_permission_mapping_role1`
    FOREIGN KEY (`role_id`)
    REFERENCES `cts`.`role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_role_permission_mapping_permission1`
    FOREIGN KEY (`permission_id`)
    REFERENCES `cts`.`permission` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cts`.`config`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cts`.`config` ;

CREATE TABLE IF NOT EXISTS `cts`.`config` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(45) NULL,
  `value` VARCHAR(45) NULL,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cts`.`random_questions_config`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cts`.`random_questions_config` ;

CREATE TABLE IF NOT EXISTS `cts`.`random_questions_config` (
  `exam_id` BIGINT(20) NOT NULL,
  `no_questions` INT NOT NULL,
  `difficulty` INT NOT NULL,
  `lib_id` BIGINT(20) NOT NULL,
  INDEX `fk_random_questions_config_exam1_idx` (`exam_id` ASC),
  INDEX `fk_random_questions_config_library1_idx` (`lib_id` ASC),
  CONSTRAINT `fk_random_questions_config_exam1`
    FOREIGN KEY (`exam_id`)
    REFERENCES `cts`.`exam` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_random_questions_config_library1`
    FOREIGN KEY (`lib_id`)
    REFERENCES `cts`.`library` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cts`.`test_question_mapping`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cts`.`test_question_mapping` ;

CREATE TABLE IF NOT EXISTS `cts`.`test_question_mapping` (
  `test_id` BIGINT(20) NOT NULL,
  `question_id` BIGINT(20) NOT NULL,
  INDEX `fk_test_question_mapping_test1_idx` (`test_id` ASC),
  INDEX `fk_test_question_mapping_question1_idx` (`question_id` ASC),
  CONSTRAINT `fk_test_question_mapping_test1`
    FOREIGN KEY (`test_id`)
    REFERENCES `cts`.`test` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_test_question_mapping_question1`
    FOREIGN KEY (`question_id`)
    REFERENCES `cts`.`question` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cts`.`reports`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cts`.`reports` ;

CREATE TABLE IF NOT EXISTS `cts`.`reports` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `report_id` BIGINT(20) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `date_creation` DATETIME NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cts`.`category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cts`.`category` ;

CREATE TABLE IF NOT EXISTS `cts`.`category` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(256) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cts`.`category_question_mapping`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cts`.`category_question_mapping` ;

CREATE TABLE IF NOT EXISTS `cts`.`category_question_mapping` (
  `category_id` BIGINT(20) NOT NULL,
  `question_id` BIGINT(20) NOT NULL,
  INDEX `fk_category_question_mapping_question1_idx` (`question_id` ASC),
  INDEX `fk_category_question_mapping_category1_idx` (`category_id` ASC),
  CONSTRAINT `fk_category_question_mapping_question1`
    FOREIGN KEY (`question_id`)
    REFERENCES `cts`.`question` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_category_question_mapping_category1`
    FOREIGN KEY (`category_id`)
    REFERENCES `cts`.`category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `cts`.`library`
-- -----------------------------------------------------
START TRANSACTION;
USE `cts`;
INSERT INTO `cts`.`library` (`id`, `name`, `description`) VALUES (1, 'JAVA', NULL);
INSERT INTO `cts`.`library` (`id`, `name`, `description`) VALUES (2, 'SQL', NULL);
INSERT INTO `cts`.`library` (`id`, `name`, `description`) VALUES (3, 'C++', NULL);
INSERT INTO `cts`.`library` (`id`, `name`, `description`) VALUES (4, '.NET', NULL);
INSERT INTO `cts`.`library` (`id`, `name`, `description`) VALUES (5, 'JAVASCRIPT', NULL);
INSERT INTO `cts`.`library` (`id`, `name`, `description`) VALUES (6, 'PHP', NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `cts`.`role`
-- -----------------------------------------------------
START TRANSACTION;
USE `cts`;
INSERT INTO `cts`.`role` (`id`, `name`, `description`) VALUES (1, 'Admin', 'admin');
INSERT INTO `cts`.`role` (`id`, `name`, `description`) VALUES (2, 'Candidate', 'candidate');

COMMIT;


-- -----------------------------------------------------
-- Data for table `cts`.`user`
-- -----------------------------------------------------
START TRANSACTION;
USE `cts`;
INSERT INTO `cts`.`user` (`id`, `name`, `pwd`, `description`, `role_id`, `email`, `first_name`, `last_name`, `cv`) VALUES (1, 'admin', '21232f297a57a5a743894a0e4a801fc3', 'Administrator', 1, 'chandler.zhu@abc.com', 'Admin', 'Admin', NULL);
INSERT INTO `cts`.`user` (`id`, `name`, `pwd`, `description`, `role_id`, `email`, `first_name`, `last_name`, `cv`) VALUES (2, 'general', 'a1536158cf8d8818ae9f3fe4de0af729', 'User for general prints', 1, 'general@abc.com', 'General', 'Print', NULL);

COMMIT;

