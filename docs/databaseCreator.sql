-- char_manager.users definition

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4;


-- char_manager.worlds definition

CREATE TABLE `worlds` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `medium` varchar(100) DEFAULT NULL,
  `desc` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;


-- char_manager.`characters` definition

CREATE TABLE `characters` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `world_id` int(11) DEFAULT NULL,
  `race` varchar(100) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `image` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `characters_FK` (`world_id`),
  CONSTRAINT `characters_FK` FOREIGN KEY (`world_id`) REFERENCES `worlds` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4;


-- char_manager.characters_links definition

CREATE TABLE `characters_links` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `from_id` int(11) NOT NULL,
  `to_id` int(11) NOT NULL,
  `relation` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `from_fk` (`from_id`),
  KEY `to_FK` (`to_id`),
  CONSTRAINT `from_fk` FOREIGN KEY (`from_id`) REFERENCES `characters` (`id`),
  CONSTRAINT `to_FK` FOREIGN KEY (`to_id`) REFERENCES `characters` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;


-- char_manager.user_roles definition

CREATE TABLE `user_roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `user_role` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_roles_FK` (`user_id`),
  CONSTRAINT `user_roles_FK` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
