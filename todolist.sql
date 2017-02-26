-- Adminer 4.2.5 MySQL dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

CREATE DATABASE `To_Do_list` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `To_Do_list`;

DROP TABLE IF EXISTS `day`;
CREATE TABLE `day` (
  `task_date` date NOT NULL,
  PRIMARY KEY (`task_date`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `day` (`task_date`) VALUES
('2016-02-08'),
('2016-02-09'),
('2016-02-14'),
('2016-02-25'),
('2016-02-28');

DROP TABLE IF EXISTS `day_task`;
CREATE TABLE `day_task` (
  `t_id` int(11) NOT NULL AUTO_INCREMENT,
  `task` varchar(100) NOT NULL,
  `status` varchar(20) DEFAULT 'not completed ',
  `priority` varchar(5) DEFAULT 'low',
  `task_date` date DEFAULT NULL,
  PRIMARY KEY (`t_id`),
  KEY `task_date` (`task_date`),
  CONSTRAINT `day_task_ibfk_1` FOREIGN KEY (`task_date`) REFERENCES `day` (`task_date`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `day_task` (`t_id`, `task`, `status`, `priority`, `task_date`) VALUES
(51,	'meet to rajeev sir',	'Completed',	'High',	'2016-02-08'),
(56,	'hi',	'Completed',	'low',	'2016-02-28'),
(58,	'IT Officer',	'not completed ',	'High',	'2016-02-14'),
(59,	'',	'not completed ',	'null',	'2016-02-08');

-- 2017-02-26 10:27:08
