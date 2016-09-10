DROP DATABASE IF EXISTS `library`;
CREATE DATABASE IF NOT EXISTS `library`
  DEFAULT CHARACTER SET utf8;
USE `library`;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;

CREATE TABLE `address` (
  `id`      BIGINT(20)  NOT NULL AUTO_INCREMENT,
  `country` VARCHAR(45) NOT NULL DEFAULT 'Беларусь',
  `city`    VARCHAR(45) NOT NULL DEFAULT 'Минск',
  `street`  VARCHAR(45) NOT NULL,
  `phone`   VARCHAR(45)          DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

--
-- Table structure for table `library`
--

DROP TABLE IF EXISTS `library`;

CREATE TABLE `library` (
  `id`         BIGINT(20)  NOT NULL AUTO_INCREMENT,
  `name`       VARCHAR(45) NOT NULL,
  `address_id` BIGINT(20)  NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_LIBRARY_ADDRESS_idx` (`address_id`),
  CONSTRAINT `fk_library_address` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `id`           BIGINT(20)  NOT NULL AUTO_INCREMENT,
  `author`       VARCHAR(45) NOT NULL,
  `name`         VARCHAR(45) NOT NULL,
  `publisher`    VARCHAR(45)          DEFAULT NULL,
  `publish_year` INT(11)              DEFAULT NULL,
  `pages`        INT(11)              DEFAULT NULL,
  `availability` TINYINT(1)  NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id`         BIGINT(20)  NOT NULL AUTO_INCREMENT,
  `login`      VARCHAR(45) NOT NULL,
  `password`   VARCHAR(45) NOT NULL,
  `role`       VARCHAR(45) NOT NULL DEFAULT 'USER',
  `name`       VARCHAR(45)          DEFAULT NULL,
  `surname`    VARCHAR(45)          DEFAULT NULL,
  `patronymic` VARCHAR(45)          DEFAULT NULL,
  `address_id` BIGINT(20)  NOT NULL,
  PRIMARY KEY (`id`),
  KEY `reader_address_idx` (`address_id`),
  CONSTRAINT `fk_user_address` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

--
-- Table structure for table `library_user`
--

DROP TABLE IF EXISTS `library_user`;

CREATE TABLE `library_user` (
  `library_id` BIGINT(20) NOT NULL,
  `user_id`    BIGINT(20) NOT NULL,
  PRIMARY KEY (`library_id`, `user_id`),
  KEY `fk_library_user_user_idx` (`user_id`),
  CONSTRAINT `fk_library_user_library` FOREIGN KEY (`library_id`) REFERENCES `library` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_library_user_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

--
-- Table structure for table `library_book`
--

DROP TABLE IF EXISTS `library_book`;

CREATE TABLE `library_book` (
  `library_id` BIGINT(20) NOT NULL,
  `book_id`    BIGINT(20) NOT NULL,
  PRIMARY KEY (`library_id`, `book_id`),
  KEY `fk_library_book_book_idx` (`book_id`),
  CONSTRAINT `fk_library_book_library` FOREIGN KEY (`library_id`) REFERENCES `library` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_library_book_book` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

--
-- Table structure for table `user_card`
--

DROP TABLE IF EXISTS `user_card`;

CREATE TABLE `user_card` (
  `id`        BIGINT(20) NOT NULL AUTO_INCREMENT,
  `user_id`   BIGINT(20) NOT NULL,
  `book_id`   BIGINT(20) NOT NULL,
  `date_from` DATETIME   NOT NULL,
  `date_to`   DATETIME   NOT NULL,
  `returned`  TINYINT(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `user_card_user_idx` (`user_id`),
  KEY `user_card_book_idx` (`book_id`),
  CONSTRAINT `fk_user_card_book` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_card_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

INSERT INTO `address` VALUES (1, 'Беларусь', 'Минск', 'пр. Независимости, 11 -54', '232-98-75'),
  (2, 'Беларусь', 'Минск', 'ул. Притыцкого, 8 -19', '290-87-65');
INSERT INTO `library` VALUES (1, 'Национальная библиотека РБ', 1);
INSERT INTO `user` VALUES (1, 'admin', 'admin', 'ADMIN', 'Максим', 'Волков', 'Николаевич', 2);
INSERT INTO `library_user` VALUES (1, 1);
