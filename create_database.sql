CREATE DATABASE  IF NOT EXISTS `library` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `library`;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;

CREATE TABLE `address` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `country` varchar(45) NOT NULL DEFAULT 'Беларусь',
  `city` varchar(45) NOT NULL DEFAULT 'Минск',
  `street` varchar(45) NOT NULL,
  `phone` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `library`
--

DROP TABLE IF EXISTS `library`;

CREATE TABLE `library` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `address_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_LIBRARY_ADDRESS_idx` (`address_id`),
  CONSTRAINT `fk_library_address` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `author` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `publisher` varchar(45) DEFAULT NULL,
  `publish_year` int(11) DEFAULT NULL,
  `pages` int(11) DEFAULT NULL,
  `library_id` BIGINT NOT NULL,
  `receipt_date` datetime NOT NULL,
  `availability` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `LIBRARY_BOOK_idx` (`library_id`),
  CONSTRAINT `fk_book_library` FOREIGN KEY (`library_id`) REFERENCES `library` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `login` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `role` varchar(45) NOT NULL DEFAULT 'USER',
  `name` varchar(45) DEFAULT NULL,
  `surname` varchar(45) DEFAULT NULL,
  `patronymic` varchar(45) DEFAULT NULL,
  `address_id` BIGINT NOT NULL,
  `library_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  KEY `reader_address_idx` (`address_id`),
  KEY `reader_library_idx` (`library_id`),
  CONSTRAINT `fk_user_address` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_library` FOREIGN KEY (`library_id`) REFERENCES `library` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `user_card`
--

DROP TABLE IF EXISTS `user_card`;

CREATE TABLE `user_card` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT NOT NULL,
  `book_id` BIGINT NOT NULL,
  `date_from` datetime NOT NULL,
  `date_to` datetime NOT NULL,
  `returned` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `user_card_user_idx` (`user_id`),
  KEY `user_card_book_idx` (`book_id`),
  CONSTRAINT `fk_user_card_book` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_card_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `address` VALUES (1,'Беларусь','Минск','пр. Независимости, 11 -54','232-98-75'),(2,'Беларусь','Минск','ул. Притыцкого, 8 -19','290-87-65');
INSERT INTO `library` VALUES (1,'Национальная библиотека РБ',1);
INSERT INTO `user` VALUES (1,'admin','admin','ADMIN','Максим','Волков','Николаевич',2,1);
