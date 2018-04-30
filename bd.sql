CREATE DATABASE  IF NOT EXISTS `todo`;
USE `todo`;

--
-- Table structure 
--

DROP TABLE IF EXISTS `task`;
CREATE TABLE `task` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `task_name` varchar(45) DEFAULT NULL,
  `estimated_time` int(11) DEFAULT 0,
  `description` varchar(100) DEFAULT NULL,
  `day` int(11),
  PRIMARY KEY (`id`),
);

DROP TABLE IF EXISTS `task_history`;
CREATE TABLE `task_history` (
   `id` int(11) NOT NULL AUTO_INCREMENT,
  `execution_date` date,
  `task_name` varchar(45),
  `estimated_time` int(11),
  `description` varchar(45),
  PRIMARY KEY (`id`)
);

DROP TRIGGER task_history_ad;
DELIMITER //

CREATE TRIGGER task_history_ad
AFTER DELETE
   ON task FOR EACH ROW

BEGIN

   
   INSERT INTO task_history
   ( execution_date,
     task_name,
     estimated_time,
     description)
   VALUES
   ( SYSDATE(),
     OLD.task_name,
     OLD.estimated_time,
     OLD.description);

END; //

DELIMITER ;
