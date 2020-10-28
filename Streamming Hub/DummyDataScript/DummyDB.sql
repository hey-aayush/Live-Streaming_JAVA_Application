create database SoftaBlize;

use SoftaBlize;

#
# TABLE STRUCTURE FOR: user
#

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(40) NOT NULL,
  `firstName` varchar(40) DEFAULT NULL,
  `lastName` varchar(40) DEFAULT NULL,
  `Email` varchar(40) DEFAULT NULL,
  `status` enum('Online','Offline') DEFAULT NULL,
  `password` varchar(6) DEFAULT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `userName` (`userName`)
) ENGINE=InnoDB AUTO_INCREMENT=206 DEFAULT CHARSET=utf8mb4;

INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (106, 'rau.kasey', 'Michael', 'Labadie', 'cletus.o\'hara@example.com', 'Offline', '7b924b');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (107, 'terence18', 'Mazie', 'Emmerich', 'shana18@example.net', 'Offline', '72a348');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (108, 'brandi41', 'Sid', 'Dickinson', 'boyle.sarina@example.org', 'Offline', '6369b3');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (109, 'rhett76', 'Joseph', 'Kerluke', 'haskell.bednar@example.net', 'Offline', '05bf2b');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (110, 'wkilback', 'Jerald', 'Ziemann', 'kwalsh@example.com', 'Offline', '9d8700');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (111, 'huel.stanton', 'Julius', 'Kassulke', 'nikki.rogahn@example.net', 'Online', '24045c');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (112, 'zmraz', 'Maximus', 'Ward', 'wintheiser.oswaldo@example.com', 'Online', '4c01a0');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (113, 'ullrich.celine', 'Chadd', 'Botsford', 'micaela.schaden@example.org', 'Online', '8e8674');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (114, 'hahn.amy', 'Demarcus', 'Deckow', 'jermain.sawayn@example.com', 'Offline', '756979');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (115, 'kiehn.gene', 'Bradly', 'Rosenbaum', 'vcollier@example.com', 'Online', '755092');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (116, 'rosa.goldner', 'Rory', 'Hyatt', 'labadie.rosemarie@example.org', 'Online', 'c6b8d2');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (117, 'pierce.beatty', 'Bradford', 'Keeling', 'pparisian@example.com', 'Offline', 'e9d80c');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (118, 'kendra.wintheiser', 'Trystan', 'Nader', 'dulce58@example.net', 'Offline', 'ea7a81');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (119, 'ashly.schmidt', 'Ava', 'Glover', 'laury.doyle@example.org', 'Offline', '841c27');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (120, 'harvey.jessy', 'Sonia', 'Gusikowski', 'peggie.satterfield@example.com', 'Online', '2818a2');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (121, 'welch.domenic', 'Isabelle', 'Beier', 'npaucek@example.com', 'Online', 'e46ee2');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (122, 'aliyah70', 'Roberta', 'Ritchie', 'dietrich.darrel@example.net', 'Offline', '2c4566');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (123, 'jfahey', 'Darron', 'Mosciski', 'whowell@example.com', 'Online', '5d5915');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (124, 'erin87', 'Margot', 'Hickle', 'kshlerin.zula@example.net', 'Offline', '4c9b8b');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (125, 'lorenz10', 'Christy', 'Pfannerstill', 'jakubowski.garnett@example.net', 'Offline', '301768');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (126, 'obailey', 'Greyson', 'Larson', 'wschaefer@example.net', 'Online', 'f2c3d0');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (127, 'jayden69', 'Dulce', 'Pfannerstill', 'cierra80@example.net', 'Online', '90baed');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (128, 'lindgren.nicholaus', 'Nathanael', 'Schaefer', 'skertzmann@example.com', 'Online', 'ff515d');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (129, 'pwiza', 'Carmelo', 'Abernathy', 'wratke@example.com', 'Offline', 'd8e8ba');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (130, 'leopoldo59', 'Ezra', 'Kovacek', 'jhilpert@example.com', 'Online', 'd464aa');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (131, 'dakota.wunsch', 'Hermann', 'Brekke', 'nola.bode@example.org', 'Online', 'eb2f9a');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (132, 'ewill', 'Katelyn', 'Grimes', 'bernita.weber@example.com', 'Online', 'b70cd9');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (133, 'lisandro.powlowski', 'Austen', 'Hirthe', 'bernardo.bernhard@example.org', 'Online', '0c6d15');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (134, 'khaley', 'Leonora', 'Crona', 'cody.little@example.net', 'Online', '65131a');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (135, 'karlie.paucek', 'Hilario', 'Lang', 'wisozk.kayley@example.net', 'Online', '578663');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (136, 'flossie.feest', 'Jaron', 'Kirlin', 'mckayla17@example.net', 'Offline', '8b5c0d');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (137, 'geoffrey.gottlieb', 'Alvina', 'Goldner', 'rwatsica@example.net', 'Online', '00585b');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (138, 'josefina.effertz', 'Clotilde', 'Mraz', 'kimberly58@example.org', 'Online', 'e9d18a');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (139, 'willa.kub', 'Paul', 'Sauer', 'wilhelmine95@example.org', 'Online', '00a66a');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (140, 'vreynolds', 'Elfrieda', 'Tremblay', 'chaim89@example.net', 'Offline', '8578aa');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (141, 'ysmith', 'Deanna', 'Robel', 'gorczany.ulices@example.org', 'Online', '93e049');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (142, 'domingo.howell', 'Beatrice', 'Waelchi', 'howell.kennedy@example.com', 'Online', '058e84');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (143, 'mlynch', 'Roderick', 'Smitham', 'fabiola09@example.net', 'Online', '077c9b');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (144, 'delfina.shanahan', 'Oren', 'Schimmel', 'brady.waelchi@example.org', 'Online', '7dfae7');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (145, 'gretchen56', 'Felton', 'Sauer', 'bernhard.asha@example.org', 'Offline', '2f40cc');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (146, 'sunny.stracke', 'Estel', 'Ziemann', 'yfunk@example.net', 'Online', '0c26d0');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (147, 'rogahn.jasper', 'Alice', 'Cremin', 'zmurray@example.com', 'Offline', '0a3c05');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (148, 'mosciski.colton', 'Jaden', 'Rutherford', 'narciso.durgan@example.net', 'Online', '51bde3');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (149, 'uo\'hara', 'Gennaro', 'Doyle', 'gerhold.gino@example.net', 'Offline', 'ea31eb');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (150, 'nhane', 'Tommie', 'Boyer', 'conroy.trever@example.com', 'Online', 'b256c0');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (151, 'aheaney', 'Candice', 'Kohler', 'fleta43@example.org', 'Online', '743da5');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (152, 'vrutherford', 'Jordan', 'Hickle', 'gturcotte@example.org', 'Offline', 'd445ce');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (153, 'justice28', 'Darien', 'Crist', 'fisher.lew@example.org', 'Offline', '54c09f');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (154, 'myrtis32', 'Wayne', 'Kulas', 'paufderhar@example.org', 'Offline', '00fa2c');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (155, 'keshaun.kuhic', 'Berniece', 'Rodriguez', 'bahringer.evelyn@example.com', 'Online', '7865d1');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (156, 'lemuel.fadel', 'Adrian', 'Towne', 'auer.emilio@example.com', 'Online', 'b6862c');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (157, 'abogisich', 'Joanny', 'Jakubowski', 'tdenesik@example.org', 'Online', 'a8f19f');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (158, 'rolfson.orpha', 'Hank', 'Cartwright', 'daugherty.keagan@example.net', 'Online', 'f6fcd8');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (159, 'sam62', 'Quincy', 'Orn', 'sokuneva@example.org', 'Offline', '4f0cd4');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (160, 'pbarrows', 'Scarlett', 'Blanda', 'gutmann.kobe@example.com', 'Offline', 'df9ca3');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (161, 'hwiegand', 'Blair', 'Kessler', 'horacio13@example.org', 'Online', '8084ab');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (162, 'elian.kessler', 'Branson', 'Boyle', 'jamel.greenfelder@example.org', 'Online', '2b6cab');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (163, 'erin.lueilwitz', 'Kelton', 'Lemke', 'brook.lowe@example.com', 'Offline', '6cee0c');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (164, 'vschaden', 'Matilde', 'Frami', 'larkin.jedediah@example.net', 'Offline', '1f03c4');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (165, 'adella.goldner', 'Chloe', 'Brekke', 'bode.maya@example.net', 'Online', '776d6d');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (166, 'bbotsford', 'Anjali', 'Auer', 'jesse.gusikowski@example.org', 'Offline', '3c45f9');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (167, 'pearlie67', 'Drake', 'Smith', 'kasandra.schmeler@example.com', 'Offline', 'd87a2e');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (168, 'dudley.gibson', 'Hazle', 'Little', 'balistreri.leonie@example.org', 'Online', 'b66b6c');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (169, 'carolyne25', 'Howard', 'Jacobi', 'hudson28@example.org', 'Offline', '140ab3');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (170, 'madonna.rogahn', 'Marie', 'Grady', 'mweber@example.net', 'Offline', 'dc8d91');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (171, 'smcglynn', 'Garnet', 'Witting', 'isaac.cummings@example.net', 'Online', 'c25fe4');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (172, 'hilpert.jeramie', 'Nelson', 'Romaguera', 'pagac.lelia@example.com', 'Online', '3d37fd');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (173, 'no\'kon', 'Trisha', 'Effertz', 'charlie07@example.net', 'Online', '7e1fa1');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (174, 'vkeebler', 'Alisa', 'Bogisich', 'fanny43@example.org', 'Online', '57f148');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (175, 'tamara39', 'Aurelia', 'Kemmer', 'kim.zulauf@example.org', 'Online', '7dc6f6');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (176, 'gerhold.nestor', 'Selina', 'Skiles', 'brakus.stuart@example.net', 'Offline', '15403c');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (177, 'phoebe78', 'Aracely', 'Morissette', 'gayle07@example.org', 'Offline', '7bc49b');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (178, 'nikko14', 'Lyla', 'Yost', 'qvandervort@example.net', 'Offline', 'a22311');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (179, 'conroy.kristina', 'Owen', 'Fadel', 'ian.flatley@example.com', 'Offline', 'c89990');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (180, 'anya.turcotte', 'Golda', 'Bogisich', 'rmosciski@example.com', 'Offline', '8900d1');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (181, 'mraz.lizeth', 'Stephany', 'Yundt', 'catalina.grady@example.net', 'Online', '7eac99');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (182, 'skiles.virgil', 'Myra', 'Tremblay', 'luella62@example.org', 'Offline', '854f7a');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (183, 'natalia64', 'Adrain', 'Greenfelder', 'weimann.madyson@example.com', 'Offline', '27efed');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (184, 'uswift', 'Evelyn', 'Walker', 'lavonne38@example.com', 'Offline', 'cbfed3');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (185, 'jack.rippin', 'Santos', 'Kozey', 'powlowski.alvena@example.org', 'Online', 'e667af');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (186, 'cummerata.loyce', 'Eleonore', 'Wyman', 'kenneth.braun@example.org', 'Offline', 'c6ee57');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (187, 'rosenbaum.jessie', 'Osbaldo', 'Stracke', 'nhowe@example.com', 'Offline', '2ab7d7');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (188, 'dbrown', 'Carleton', 'Bruen', 'umraz@example.net', 'Online', '6b2892');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (189, 'qlangosh', 'Estella', 'White', 'joey60@example.org', 'Online', '5a4ab0');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (190, 'bauch.greg', 'Gennaro', 'Reichert', 'qgrady@example.org', 'Offline', 'd7f91b');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (191, 'spencer.concepcion', 'Florida', 'Gulgowski', 'herman.vivien@example.net', 'Offline', 'f78f3c');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (192, 'xjenkins', 'Remington', 'Grant', 'betty86@example.org', 'Online', '85c3b6');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (193, 'cwisoky', 'Dameon', 'Stiedemann', 'michale79@example.com', 'Online', '014af3');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (194, 'delta75', 'Edd', 'Reynolds', 'nora.mante@example.com', 'Online', 'c04cbc');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (195, 'alicia.hackett', 'Nichole', 'Bogisich', 'jordan45@example.org', 'Online', '7aff9c');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (196, 'niko39', 'Kaycee', 'Nolan', 'gutmann.jaden@example.org', 'Online', '0e627d');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (197, 'major71', 'Emmett', 'Turner', 'trantow.ocie@example.org', 'Offline', 'eaed51');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (198, 'alfonzo46', 'Hiram', 'Murray', 'hodkiewicz.amelie@example.org', 'Offline', 'b50d93');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (199, 'thiel.randi', 'Brooke', 'Walsh', 'dibbert.kattie@example.org', 'Online', '4ae440');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (200, 'ernestine.paucek', 'Emie', 'Willms', 'hterry@example.com', 'Online', 'b253a6');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (201, 'amos.reinger', 'Walter', 'Stoltenberg', 'hegmann.ismael@example.org', 'Online', '1cba45');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (202, 'marisol06', 'Vivienne', 'Koepp', 'mhaag@example.org', 'Online', '5d962f');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (203, 'harmony57', 'Michael', 'Bednar', 'walker.fahey@example.net', 'Offline', '55d3a0');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (204, 'ygleichner', 'Kelsi', 'Bins', 'conn.frank@example.net', 'Offline', 'f81076');
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `Email`, `status`, `password`) VALUES (205, 'ora.o\'kon', 'Kaia', 'Goyette', 'jewel.johnson@example.org', 'Online', '8dd1eb');


#
# TABLE STRUCTURE FOR: Channel_table
#

DROP TABLE IF EXISTS `Channel_table`;

CREATE TABLE `Channel_table` (
  `ChannelId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `NoofSubcribers` int(11) DEFAULT 0,
  `Curr_status` enum('Streamming','NotStreamming') COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ChannelId`),
  KEY `userId` (`userId`),
  CONSTRAINT `Channel_table_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (1, 129, 1, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (2, 151, 1, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (3, 166, 7, 'Streamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (4, 120, 1, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (5, 193, 8, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (6, 173, 0, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (7, 144, 3, 'Streamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (8, 198, 6, 'Streamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (9, 107, 2, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (10, 141, 4, 'Streamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (11, 178, 9, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (12, 204, 6, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (13, 161, 0, 'Streamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (14, 183, 5, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (15, 168, 2, 'Streamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (16, 118, 7, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (17, 141, 9, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (18, 135, 4, 'Streamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (19, 132, 5, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (20, 168, 0, 'Streamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (21, 118, 6, 'Streamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (22, 189, 4, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (23, 147, 2, 'Streamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (24, 178, 3, 'Streamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (25, 164, 5, 'Streamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (26, 165, 8, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (27, 149, 2, 'Streamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (28, 122, 4, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (29, 181, 4, 'Streamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (30, 188, 6, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (31, 196, 6, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (32, 204, 7, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (33, 133, 9, 'Streamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (34, 157, 6, 'Streamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (35, 118, 6, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (36, 121, 6, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (37, 125, 8, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (38, 157, 6, 'Streamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (39, 113, 5, 'Streamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (40, 127, 1, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (41, 193, 4, 'Streamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (42, 185, 1, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (43, 125, 4, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (44, 148, 8, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (45, 163, 2, 'Streamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (46, 188, 8, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (47, 160, 3, 'Streamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (48, 199, 7, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (49, 118, 1, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (50, 187, 7, 'Streamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (51, 161, 8, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (52, 130, 8, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (53, 171, 9, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (54, 203, 5, 'Streamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (55, 202, 2, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (56, 129, 5, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (57, 162, 8, 'Streamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (58, 145, 3, 'Streamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (59, 145, 3, 'Streamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (60, 138, 5, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (61, 128, 8, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (62, 136, 3, 'Streamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (63, 137, 2, 'Streamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (64, 156, 1, 'Streamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (65, 187, 2, 'Streamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (66, 150, 4, 'Streamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (67, 171, 4, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (68, 107, 3, 'Streamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (69, 201, 6, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (70, 179, 6, 'Streamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (71, 128, 8, 'Streamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (72, 189, 8, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (73, 158, 2, 'Streamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (74, 148, 1, 'Streamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (75, 132, 5, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (76, 116, 5, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (77, 130, 2, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (78, 187, 0, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (79, 109, 2, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (80, 142, 7, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (81, 168, 1, 'Streamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (82, 165, 8, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (83, 167, 4, 'Streamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (84, 134, 6, 'Streamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (85, 163, 0, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (86, 163, 4, 'Streamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (87, 157, 5, 'Streamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (88, 119, 8, 'Streamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (89, 203, 8, 'Streamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (90, 196, 7, 'Streamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (91, 152, 3, 'Streamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (92, 126, 2, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (93, 126, 9, 'Streamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (94, 183, 3, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (95, 176, 5, 'Streamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (96, 108, 8, 'Streamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (97, 127, 9, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (98, 142, 2, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (99, 110, 3, 'Streamming');
INSERT INTO `Channel_table` (`ChannelId`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (100, 123, 7, 'Streamming');


#
# TABLE STRUCTURE FOR: Subscribtion_table
#

DROP TABLE IF EXISTS `Subscribtion_table`;

CREATE TABLE `Subscribtion_table` (
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `SubcribtionId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `ChannelId` int(11) NOT NULL,
  `Curr_status` enum('active','inactive') COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`SubcribtionId`),
  KEY `userId` (`userId`),
  KEY `ChannelId` (`ChannelId`),
  CONSTRAINT `Subscribtion_table_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`),
  CONSTRAINT `Subscribtion_table_ibfk_2` FOREIGN KEY (`ChannelId`) REFERENCES `Channel_table` (`ChannelId`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('2014-12-08 10:38:07', 1, 106, 1, 'inactive');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('1977-06-14 12:55:10', 2, 107, 2, 'inactive');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('1979-07-29 20:10:56', 3, 108, 3, 'inactive');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('1978-10-06 15:59:04', 4, 109, 4, 'active');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('2008-01-25 13:57:56', 5, 110, 5, 'active');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('1997-01-15 08:41:00', 6, 111, 6, 'inactive');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('1989-08-07 18:16:46', 7, 112, 7, 'inactive');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('2000-08-27 01:04:15', 8, 113, 8, 'active');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('1975-08-25 01:58:10', 9, 114, 9, 'inactive');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('1974-01-16 10:12:45', 10, 115, 10, 'inactive');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('1990-06-26 20:07:45', 11, 116, 11, 'inactive');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('2019-09-06 18:25:29', 12, 117, 12, 'active');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('2009-06-26 15:35:09', 13, 118, 13, 'active');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('1985-06-29 10:49:57', 14, 119, 14, 'active');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('2016-01-03 06:57:46', 15, 120, 15, 'active');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('1998-05-13 20:21:30', 16, 121, 16, 'active');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('2016-11-11 17:16:24', 17, 122, 17, 'inactive');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('2018-11-30 18:38:08', 18, 123, 18, 'inactive');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('2019-01-26 20:57:47', 19, 124, 19, 'active');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('1981-06-16 15:33:16', 20, 125, 20, 'active');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('1992-11-14 10:07:43', 21, 126, 21, 'inactive');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('2019-05-13 22:10:03', 22, 127, 22, 'inactive');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('2007-12-31 00:20:40', 23, 128, 23, 'inactive');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('1985-12-08 07:27:53', 24, 129, 24, 'inactive');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('2000-04-19 12:01:22', 25, 130, 25, 'inactive');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('1991-05-27 05:49:14', 26, 131, 26, 'active');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('1982-11-03 08:08:32', 27, 132, 27, 'inactive');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('2014-01-18 17:56:12', 28, 133, 28, 'inactive');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('1994-02-25 12:11:45', 29, 134, 29, 'inactive');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('1986-10-26 18:18:00', 30, 135, 30, 'active');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('1984-09-10 05:34:39', 31, 136, 31, 'active');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('1987-10-13 08:00:05', 32, 137, 32, 'inactive');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('1997-10-19 16:56:13', 33, 138, 33, 'inactive');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('2002-10-18 19:48:56', 34, 139, 34, 'inactive');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('1999-08-21 03:38:04', 35, 140, 35, 'inactive');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('1985-09-30 05:33:57', 36, 141, 36, 'inactive');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('1987-06-28 09:25:03', 37, 142, 37, 'inactive');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('1991-09-05 04:19:19', 38, 143, 38, 'active');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('1977-06-18 00:34:18', 39, 144, 39, 'inactive');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('2007-03-02 15:44:38', 40, 145, 40, 'active');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('1981-02-23 09:27:57', 41, 146, 41, 'inactive');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('2011-01-26 18:08:20', 42, 147, 42, 'inactive');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('2018-05-10 22:19:13', 43, 148, 43, 'inactive');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('2002-03-02 16:05:31', 44, 149, 44, 'inactive');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('1971-07-28 03:12:37', 45, 150, 45, 'inactive');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('2005-10-24 05:21:10', 46, 151, 46, 'inactive');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('2014-03-03 07:13:41', 47, 152, 47, 'active');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('1974-11-12 16:31:53', 48, 153, 48, 'inactive');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('2015-07-01 17:25:14', 49, 154, 49, 'active');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('1974-09-19 08:51:33', 50, 155, 50, 'inactive');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('1970-04-23 11:56:19', 51, 156, 51, 'active');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('1983-07-29 05:04:23', 52, 157, 52, 'inactive');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('2013-10-13 06:30:19', 53, 158, 53, 'active');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('1986-01-22 20:52:40', 54, 159, 54, 'inactive');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('2018-01-11 03:57:07', 55, 160, 55, 'active');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('1991-11-02 00:59:42', 56, 161, 56, 'active');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('1996-09-23 21:10:12', 57, 162, 57, 'active');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('2016-02-08 15:37:36', 58, 163, 58, 'inactive');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('1978-06-03 05:29:20', 59, 164, 59, 'inactive');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('1975-04-14 23:44:12', 60, 165, 60, 'inactive');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('2007-05-09 16:20:50', 61, 166, 61, 'inactive');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('2018-12-28 07:01:43', 62, 167, 62, 'inactive');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('1977-06-09 20:17:01', 63, 168, 63, 'inactive');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('1972-08-04 02:03:05', 64, 169, 64, 'active');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('2000-02-19 08:54:25', 65, 170, 65, 'active');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('1978-06-10 00:05:26', 66, 171, 66, 'inactive');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('2010-06-05 10:43:59', 67, 172, 67, 'inactive');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('2011-02-22 14:57:34', 68, 173, 68, 'active');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('1975-07-14 04:21:45', 69, 174, 69, 'active');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('2012-08-02 13:30:42', 70, 175, 70, 'inactive');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('1996-08-19 04:03:35', 71, 176, 71, 'inactive');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('1978-05-22 00:29:56', 72, 177, 72, 'inactive');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('1987-04-22 03:25:30', 73, 178, 73, 'active');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('2011-04-20 00:55:40', 74, 179, 74, 'inactive');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('2005-03-07 19:47:12', 75, 180, 75, 'inactive');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('1988-05-21 23:19:27', 76, 181, 76, 'inactive');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('1977-10-21 09:18:58', 77, 182, 77, 'inactive');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('1975-01-19 00:28:48', 78, 183, 78, 'inactive');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('1977-04-10 06:01:38', 79, 184, 79, 'inactive');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('1971-12-21 23:16:33', 80, 185, 80, 'active');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('1982-04-08 15:32:10', 81, 186, 81, 'inactive');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('2007-01-03 15:09:00', 82, 187, 82, 'active');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('2011-09-02 13:33:22', 83, 188, 83, 'active');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('1983-05-03 05:32:21', 84, 189, 84, 'inactive');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('2005-09-04 07:39:18', 85, 190, 85, 'inactive');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('1998-08-08 23:33:20', 86, 191, 86, 'inactive');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('1990-06-24 19:07:18', 87, 192, 87, 'inactive');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('1981-12-03 04:39:30', 88, 193, 88, 'active');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('1985-11-19 08:15:16', 89, 194, 89, 'inactive');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('2012-03-17 04:49:50', 90, 195, 90, 'active');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('1989-10-15 12:26:19', 91, 196, 91, 'inactive');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('2019-11-22 02:09:31', 92, 197, 92, 'inactive');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('1973-02-27 10:14:41', 93, 198, 93, 'inactive');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('2015-01-16 05:09:47', 94, 199, 94, 'active');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('2020-09-29 05:54:48', 95, 200, 95, 'inactive');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('2008-05-08 09:00:35', 96, 201, 96, 'inactive');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('1981-04-01 23:06:28', 97, 202, 97, 'inactive');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('2010-03-23 05:32:22', 98, 203, 98, 'active');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('2003-10-20 04:36:16', 99, 204, 99, 'active');
INSERT INTO `Subscribtion_table` (`created_at`, `SubcribtionId`, `userId`, `ChannelId`, `Curr_status`) VALUES ('2019-08-29 05:00:15', 100, 205, 100, 'active');



#
# TABLE STRUCTURE FOR: Messages_table
#

DROP TABLE IF EXISTS `Messages_table`;

CREATE TABLE `Messages_table` (
  `Sent_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `ConversionationId` int(11) NOT NULL AUTO_INCREMENT,
  `SenderuserId` int(11) NOT NULL,
  `RecieveruserId` int(11) NOT NULL,
  `Message` text COLLATE utf8_unicode_ci NOT NULL,
  `Curr_status` enum('seen','Unseen') COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ConversionationId`),
  KEY `SenderuserId` (`SenderuserId`),
  KEY `RecieveruserId` (`RecieveruserId`),
  CONSTRAINT `Messages_table_ibfk_1` FOREIGN KEY (`SenderuserId`) REFERENCES `user` (`userId`),
  CONSTRAINT `Messages_table_ibfk_2` FOREIGN KEY (`RecieveruserId`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('2019-11-26 15:07:41', 1, 171, 156, 'I\'ve finished.\' So they went up to Alice, and tried to open them again, and did not like to show you! A little bright-eyed terrier, you know, upon the other side, the puppy jumped into the roof of.', 'Unseen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('2015-10-02 00:15:07', 2, 205, 151, 'I wonder what they said. The executioner\'s argument was, that if you like!\' the Duchess was sitting on the same as they all looked puzzled.) \'He must have got altered.\' \'It is a long argument with.', 'Unseen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('2011-12-16 19:46:47', 3, 174, 130, 'Just then she noticed that one of the cupboards as she said to live. \'I\'ve seen a rabbit with either a waistcoat-pocket, or a serpent?\' \'It matters a good deal on where you want to go! Let me see:.', 'Unseen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('1991-07-01 06:36:47', 4, 139, 164, 'I can\'t understand it myself to begin with; and being ordered about by mice and rabbits. I almost wish I\'d gone to see the earth takes twenty-four hours to turn round on its axis--\' \'Talking of.', 'seen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('1975-02-22 12:27:14', 5, 144, 124, 'Suddenly she came suddenly upon an open place, with a round face, and was just beginning to feel very sleepy and stupid), whether the pleasure of making a daisy-chain would be offended again. \'Mine.', 'Unseen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('2017-01-25 01:07:46', 6, 116, 151, 'No, it\'ll never do to hold it. As soon as look at all the players, except the Lizard, who seemed too much of a globe of goldfish she had never left off writing on his flappers, \'--Mystery, ancient.', 'Unseen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('1998-05-20 16:20:00', 7, 117, 137, 'She waited for a rabbit! I suppose Dinah\'ll be sending me on messages next!\' And she began shrinking directly. As soon as she could, for her to wink with one finger, as he spoke, and then a voice.', 'seen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('1972-10-15 12:01:03', 8, 139, 168, 'Only I don\'t want to be?\' it asked. \'Oh, I\'m not looking for eggs, as it lasted.) \'Then the eleventh day must have got altered.\' \'It is a raven like a candle. I wonder if I shall be a LITTLE larger,.', 'seen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('2017-09-17 18:21:06', 9, 115, 192, 'Duchess: \'and the moral of that is, but I shall have somebody to talk about wasting IT. It\'s HIM.\' \'I don\'t much care where--\' said Alice. \'Why, you don\'t even know what to say it over) \'--yes,.', 'Unseen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('1996-10-31 09:10:23', 10, 197, 186, 'Yet you turned a corner, \'Oh my ears and the King triumphantly, pointing to the confused clamour of the suppressed guinea-pigs, filled the air, and came flying down upon their faces, and the words.', 'seen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('2014-03-30 01:00:55', 11, 154, 173, 'Gryphon repeated impatiently: \'it begins \"I passed by his garden, and marked, with one finger; and the jury wrote it down \'important,\' and some were birds,) \'I suppose they are the jurors.\' She said.', 'seen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('1988-04-03 11:02:44', 12, 171, 114, 'Alice ventured to ask. \'Suppose we change the subject. \'Go on with the Queen in a minute or two the Caterpillar seemed to be no use denying it. I suppose it were nine o\'clock in the last time she.', 'Unseen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('1996-10-26 12:34:20', 13, 162, 140, 'Alice again, for she felt a little house in it a very melancholy voice. \'Repeat, \"YOU ARE OLD, FATHER WILLIAM,\' to the Knave of Hearts, she made some tarts, All on a branch of a muchness\"--did you.', 'seen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('2019-07-18 10:53:05', 14, 128, 164, 'The hedgehog was engaged in a whisper.) \'That would be four thousand miles down, I think--\' (for, you see, as she could. \'No,\' said the Dormouse. \'Fourteenth of March, I think you\'d better ask HER.', 'seen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('1983-04-10 23:43:51', 15, 178, 133, 'VERY turn-up nose, much more like a tunnel for some time after the birds! Why, she\'ll eat a bat?\' when suddenly, thump! thump! down she came suddenly upon an open place, with a sigh. \'I only took.', 'Unseen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('2008-11-02 10:53:33', 16, 157, 144, 'CURTSEYING as you\'re falling through the doorway; \'and even if I would talk on such a fall as this, I shall have to ask the question?\' said the King. \'Nearly two miles high,\' added the Dormouse..', 'seen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('2016-10-12 15:39:07', 17, 183, 156, 'March Hare and his buttons, and turns out his toes.\' [later editions continued as follows The Panther took pie-crust, and gravy, and meat, While the Duchess asked, with another dig of her hedgehog..', 'seen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('2018-07-14 19:59:17', 18, 190, 151, 'Duchess. \'Everything\'s got a moral, if only you can find it.\' And she went slowly after it: \'I never went to him,\' the Mock Turtle would be a letter, after all: it\'s a set of verses.\' \'Are they in.', 'seen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('2018-10-15 14:05:04', 19, 181, 123, 'I begin, please your Majesty,\' said Alice in a great thistle, to keep herself from being run over; and the sound of a bottle. They all made a snatch in the sky. Twinkle, twinkle--\"\' Here the other.', 'Unseen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('2008-01-29 17:10:19', 20, 110, 120, 'Mock Turtle yawned and shut his note-book hastily. \'Consider your verdict,\' he said in a soothing tone: \'don\'t be angry about it. And yet you incessantly stand on their slates, when the White.', 'Unseen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('2003-06-09 11:51:27', 21, 141, 120, 'Hatter, \'I cut some more bread-and-butter--\' \'But what am I then? Tell me that first, and then, \'we went to school in the way YOU manage?\' Alice asked. \'We called him a fish)--and rapped loudly at.', 'seen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('2009-02-11 10:31:11', 22, 165, 153, 'Where CAN I have done that, you know,\' the Hatter with a bound into the sky all the jelly-fish out of a muchness?\' \'Really, now you ask me,\' said Alice, a little door about fifteen inches high: she.', 'seen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('1992-07-31 14:09:52', 23, 152, 198, 'Mary Ann, what ARE you doing out here? Run home this moment, I tell you, you coward!\' and at once set to work very carefully, with one foot. \'Get up!\' said the March Hare, who had been all the.', 'Unseen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('1978-09-18 03:30:39', 24, 116, 162, 'Dormouse,\' the Queen said--\' \'Get to your little boy, And beat him when he sneezes; For he can EVEN finish, if he would not allow without knowing how old it was, even before she found she could see.', 'Unseen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('2009-09-08 19:18:38', 25, 185, 107, 'All this time the Queen in a minute, nurse! But I\'ve got to come once a week: HE taught us Drawling, Stretching, and Fainting in Coils.\' \'What was THAT like?\' said Alice. \'And be quick about it,\'.', 'Unseen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('1988-08-30 23:11:36', 26, 142, 134, 'King; \'and don\'t look at a king,\' said Alice. The poor little thing howled so, that Alice had not the smallest notice of her sharp little chin. \'I\'ve a right to think,\' said Alice desperately: \'he\'s.', 'seen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('1979-09-24 19:27:24', 27, 175, 108, 'However, this bottle does. I do wonder what I like\"!\' \'You might just as if a dish or kettle had been jumping about like mad things all this grand procession, came THE KING AND QUEEN OF HEARTS..', 'Unseen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('1975-06-04 05:57:05', 28, 142, 131, 'She felt very curious to see what I was a little bottle on it, and behind them a new pair of white kid gloves: she took courage, and went to school in the long hall, and close to the heads of the.', 'Unseen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('2003-11-23 13:23:54', 29, 143, 164, 'I chose,\' the Duchess to play croquet with the Dormouse. \'Don\'t talk nonsense,\' said Alice to herself, as she could even make out who was peeping anxiously into her eyes--and still as she tucked it.', 'Unseen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('1999-04-28 00:04:28', 30, 189, 116, 'Alice, \'it would have done that?\' she thought. \'But everything\'s curious today. I think you\'d better ask HER about it.\' \'She\'s in prison,\' the Queen of Hearts were seated on their slates, and she.', 'seen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('2020-07-05 13:37:50', 31, 191, 140, 'First, she dreamed of little pebbles came rattling in at once.\' And in she went. Once more she found herself in a low, hurried tone. He looked at Alice. \'It must be really offended. \'We won\'t talk.', 'Unseen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('1989-11-21 13:26:58', 32, 155, 169, 'ALL RETURNED FROM HIM TO YOU,\"\' said Alice. \'Well, I can\'t get out again. The rabbit-hole went straight on like a wild beast, screamed \'Off with their fur clinging close to them, they set to work.', 'seen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('2002-07-22 19:17:52', 33, 191, 139, 'Lory. Alice replied in an offended tone, \'Hm! No accounting for tastes! Sing her \"Turtle Soup,\" will you, won\'t you, won\'t you, will you, old fellow?\' The Mock Turtle\'s Story \'You can\'t think how.', 'seen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('1978-01-29 09:38:31', 34, 115, 166, 'Alice thought to herself. (Alice had been anything near the house if it makes me grow larger, I can creep under the hedge. In another moment that it was empty: she did not like to go and get ready.', 'seen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('2017-03-13 11:04:16', 35, 156, 119, 'I can do without lobsters, you know. Come on!\' \'Everybody says \"come on!\" here,\' thought Alice, \'or perhaps they won\'t walk the way to hear her try and say \"How doth the little--\"\' and she went on.', 'Unseen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('2010-12-13 18:22:44', 36, 181, 192, 'The Frog-Footman repeated, in the sun. (IF you don\'t know one,\' said Alice. The King and the second time round, she found she had never forgotten that, if you like,\' said the Mock Turtle is.\' \'It\'s.', 'Unseen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('1984-09-13 07:48:39', 37, 134, 140, 'After a while she was always ready to play croquet.\' Then they both cried. \'Wake up, Alice dear!\' said her sister; \'Why, what a long tail, certainly,\' said Alice in a great hurry; \'this paper has.', 'seen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('1992-10-08 16:32:47', 38, 139, 181, 'CHAPTER XII. Alice\'s Evidence \'Here!\' cried Alice, quite forgetting in the sand with wooden spades, then a row of lodging houses, and behind it, it occurred to her great delight it fitted! Alice.', 'seen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('1982-12-21 01:04:16', 39, 132, 149, 'I know I do!\' said Alice more boldly: \'you know you\'re growing too.\' \'Yes, but some crumbs must have been a holiday?\' \'Of course it is,\' said the Mock Turtle to sing \"Twinkle, twinkle, little bat!.', 'Unseen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('2002-05-18 11:17:15', 40, 137, 112, 'However, it was certainly not becoming. \'And that\'s the queerest thing about it.\' \'She\'s in prison,\' the Queen merely remarking that a moment\'s delay would cost them their lives. All the time she.', 'seen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('1999-06-20 18:08:21', 41, 151, 174, 'Alice went on growing, and, as they came nearer, Alice could only see her. She is such a fall as this, I shall never get to twenty at that rate! However, the Multiplication Table doesn\'t signify:.', 'seen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('1975-02-25 02:15:32', 42, 140, 120, 'Cat\'s head began fading away the time. Alice had been broken to pieces. \'Please, then,\' said the Mock Turtle, capering wildly about. \'Change lobsters again!\' yelled the Gryphon remarked: \'because.', 'Unseen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('1977-11-11 02:43:10', 43, 177, 176, 'This question the Dodo managed it.) First it marked out a race-course, in a low curtain she had never done such a thing as \"I get what I say,\' the Mock Turtle to the croquet-ground. The other side.', 'seen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('2000-02-10 11:26:53', 44, 145, 114, 'Queen, and Alice, were in custody and under sentence of execution.\' \'What for?\' said the King. (The jury all looked so grave that she was now about two feet high, and her face brightened up at this.', 'seen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('1999-10-14 16:03:37', 45, 135, 129, 'PLEASE mind what you\'re talking about,\' said Alice. \'I\'ve read that in some book, but I hadn\'t quite finished my tea when I find a number of bathing machines in the wind, and was in the long hall,.', 'seen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('1976-11-16 23:15:34', 46, 124, 121, 'I know. Silence all round, if you were down here till I\'m somebody else\"--but, oh dear!\' cried Alice again, for she had brought herself down to them, they were nowhere to be full of smoke from one.', 'seen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('1970-10-14 16:41:01', 47, 163, 173, 'So she tucked her arm affectionately into Alice\'s, and they lived at the door--I do wish I had to stoop to save her neck kept getting entangled among the people that walk with their heads down and.', 'Unseen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('2003-10-27 09:39:34', 48, 184, 149, 'This question the Dodo in an undertone, \'important--unimportant--unimportant--important--\' as if it please your Majesty,\' he began. \'You\'re a very deep well. Either the well was very uncomfortable,.', 'seen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('1997-02-22 15:58:57', 49, 106, 194, 'Rabbit actually TOOK A WATCH OUT OF ITS WAISTCOAT-POCKET, and looked at it uneasily, shaking it every now and then unrolled the parchment scroll, and read out from his book, \'Rule Forty-two. ALL.', 'Unseen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('1983-02-11 19:39:16', 50, 110, 156, 'WHAT? The other side will make you grow taller, and the Panther received knife and fork with a smile. There was a body to cut it off from: that he had a head could be no use their putting their.', 'Unseen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('2005-07-14 10:47:45', 51, 108, 185, 'Hatter. This piece of it at all,\' said the Cat, as soon as she passed; it was out of the Lobster Quadrille, that she was walking hand in hand, in couples: they were nice grand words to say.).', 'Unseen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('2005-03-19 05:12:45', 52, 142, 137, 'Hatter. He had been to her, still it had lost something; and she went on planning to herself in a great thistle, to keep herself from being run over; and the March Hare said in a frightened tone..', 'seen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('1993-02-26 02:15:05', 53, 119, 176, 'At last the Dodo solemnly presented the thimble, looking as solemn as she could, \'If you do. I\'ll set Dinah at you!\' There was not going to do THAT in a day is very confusing.\' \'It isn\'t,\' said the.', 'Unseen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('1970-04-26 12:55:33', 54, 112, 146, 'I wish you would have made a memorandum of the shepherd boy--and the sneeze of the table. \'Have some wine,\' the March Hare said in an offended tone. And she began again: \'Ou est ma chatte?\' which.', 'seen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('1998-12-05 11:55:09', 55, 119, 144, 'Queen. An invitation from the change: and Alice was very likely it can be,\' said the one who had meanwhile been examining the roses. \'Off with his whiskers!\' For some minutes the whole court was a.', 'seen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('1978-01-31 05:01:35', 56, 152, 165, 'And oh, I wish you could keep it to be full of smoke from one minute to another! However, I\'ve got to the garden with one of the garden, where Alice could not think of nothing else to say which),.', 'seen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('2014-09-30 13:16:40', 57, 113, 187, 'Alice hastily, afraid that she was holding, and she felt a little house in it a violent shake at the mouth with strings: into this they slipped the guinea-pig, head first, and then a row of lodging.', 'Unseen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('2019-01-02 02:20:50', 58, 179, 184, 'Who in the sun. (IF you don\'t know much,\' said the Queen, who was a little wider. \'Come, it\'s pleased so far,\' thought Alice, \'they\'re sure to do such a thing. After a while she ran, as well she.', 'seen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('2000-02-08 16:41:00', 59, 158, 119, 'I dare say you\'re wondering why I don\'t care which happens!\' She ate a little door about fifteen inches high: she tried hard to whistle to it; but she did not see anything that had a consultation.', 'seen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('1985-04-27 21:37:17', 60, 192, 187, 'Alice desperately: \'he\'s perfectly idiotic!\' And she thought it over afterwards, it occurred to her that she had felt quite strange at first; but she was about a thousand times as large as the.', 'Unseen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('2006-12-08 00:56:29', 61, 142, 111, 'For he can thoroughly enjoy The pepper when he finds out who I WAS when I get SOMEWHERE,\' Alice added as an unusually large saucepan flew close by it, and found that, as nearly as large as himself,.', 'seen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('2007-02-08 23:57:13', 62, 202, 200, 'Hatter. \'He won\'t stand beating. Now, if you hold it too long; and that is enough,\' Said his father; \'don\'t give yourself airs! Do you think you can find out the proper way of nursing it, (which was.', 'Unseen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('1978-05-08 19:06:22', 63, 178, 181, 'Dodo had paused as if nothing had happened. \'How am I to do it.\' (And, as you go on? It\'s by far the most interesting, and perhaps after all it might belong to one of them even when they saw the.', 'Unseen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('2017-02-23 16:48:08', 64, 143, 179, 'Will you, won\'t you, won\'t you, won\'t you, won\'t you join the dance. So they had any sense, they\'d take the place of the house opened, and a large ring, with the other arm curled round her head. \'If.', 'Unseen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('2014-02-06 05:15:50', 65, 169, 148, 'Alice as he spoke. \'A cat may look at all a proper way of settling all difficulties, great or small. \'Off with his tea spoon at the bottom of a well--\' \'What did they live at the door--I do wish.', 'seen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('1985-07-26 07:11:55', 66, 129, 172, 'Pigeon in a whisper.) \'That would be grand, certainly,\' said Alice, quite forgetting that she had made her draw back in their paws. \'And how many miles I\'ve fallen by this time). \'Don\'t grunt,\' said.', 'Unseen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('1981-10-12 17:25:19', 67, 127, 166, 'Duchess; \'and that\'s why. Pig!\' She said it to make the arches. The chief difficulty Alice found at first was moderate. But the insolence of his great wig.\' The judge, by the fire, stirring a large.', 'seen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('2018-10-05 22:51:44', 68, 203, 140, 'COULD! I\'m sure I can\'t quite follow it as a partner!\' cried the Gryphon. \'Do you mean by that?\' said the March Hare said to herself, as usual. \'Come, there\'s half my plan done now! How puzzling all.', 'seen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('1978-09-08 14:01:15', 69, 136, 110, 'You see the Mock Turtle a little startled when she was quite impossible to say than his first remark, \'It was the first question, you know.\' \'Not at first, perhaps,\' said the King. \'Shan\'t,\' said.', 'Unseen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('1974-07-18 11:52:01', 70, 181, 150, 'Caterpillar contemptuously. \'Who are YOU?\' Which brought them back again to the Gryphon. \'Well, I hardly know--No more, thank ye; I\'m better now--but I\'m a hatter.\' Here the Queen had only one who.', 'seen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('1982-02-26 14:19:30', 71, 149, 128, 'Alice went on, \'and most of \'em do.\' \'I don\'t think--\' \'Then you should say what you would seem to dry me at all.\' \'In that case,\' said the Duchess: \'flamingoes and mustard both bite. And the.', 'seen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('2004-06-15 05:28:05', 72, 110, 156, 'Duchess. \'I make you dry enough!\' They all sat down in a tone of great relief. \'Now at OURS they had to fall upon Alice, as she did it so VERY much out of the words \'EAT ME\' were beautifully marked.', 'Unseen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('2020-06-04 04:35:47', 73, 109, 183, 'So she went on, \'I must go back and see after some executions I have dropped them, I wonder?\' And here poor Alice began to cry again. \'You ought to be Number One,\' said Alice. \'Call it what you.', 'Unseen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('2019-06-22 11:20:54', 74, 134, 161, 'I\'ve had such a curious dream!\' said Alice, as she spoke. Alice did not wish to offend the Dormouse turned out, and, by the time they were nice grand words to say.) Presently she began looking at it.', 'Unseen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('1974-11-16 03:46:04', 75, 197, 121, 'Was kindly permitted to pocket the spoon: While the Duchess to play croquet with the edge with each hand. \'And now which is which?\' she said to herself, \'I wish you were or might have been changed.', 'seen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('2016-01-10 18:36:44', 76, 142, 134, 'Alice very humbly: \'you had got to the game. CHAPTER IX. The Mock Turtle in the face. \'I\'ll put a stop to this,\' she said to the end of the house of the garden: the roses growing on it in with the.', 'Unseen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('1996-10-17 23:41:27', 77, 126, 139, 'Alice was just beginning to end,\' said the Caterpillar. \'Well, I hardly know--No more, thank ye; I\'m better now--but I\'m a hatter.\' Here the Queen put on your head-- Do you think you could only hear.', 'seen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('1988-04-23 06:12:18', 78, 129, 199, 'King said, with a knife, it usually bleeds; and she felt that it might tell her something about the twentieth time that day. \'No, no!\' said the King. Here one of its mouth and yawned once or twice,.', 'seen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('1998-11-05 08:36:35', 79, 114, 167, 'I had our Dinah here, I know I do!\' said Alice in a wondering tone. \'Why, what are YOUR shoes done with?\' said the King, and the White Rabbit, trotting slowly back again, and put it in the last.', 'Unseen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('2006-09-07 11:43:05', 80, 172, 178, 'Lory, as soon as she was now about two feet high: even then she walked off, leaving Alice alone with the dream of Wonderland of long ago: and how she would catch a bad cold if she did not feel.', 'Unseen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('2004-02-09 09:51:16', 81, 109, 195, 'Duchess, the Duchess! Oh! won\'t she be savage if I\'ve been changed for any of them. However, on the whole party look so grave and anxious.) Alice could hear the Rabbit say to itself, \'Oh dear! Oh.', 'Unseen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('2004-06-29 12:44:20', 82, 144, 130, 'Dormouse\'s place, and Alice could see it trot away quietly into the jury-box, or they would go, and broke to pieces against one of the treat. When the sands are all dry, he is gay as a lark, And.', 'seen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('1984-08-28 20:53:54', 83, 156, 142, 'However, I\'ve got to come down the chimney?--Nay, I shan\'t! YOU do it!--That I won\'t, then!--Bill\'s to go with Edgar Atheling to meet William and offer him the crown. William\'s conduct at first was.', 'Unseen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('1997-09-06 15:31:20', 84, 165, 187, 'Gryphon. \'I\'ve forgotten the words.\' So they had at the Mouse\'s tail; \'but why do you like to be sure! However, everything is queer to-day.\' Just then she walked up towards it rather timidly, as she.', 'Unseen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('2002-01-02 12:02:15', 85, 147, 140, 'I should like to hear her try and repeat something now. Tell her to speak good English); \'now I\'m opening out like the tone of great relief. \'Now at OURS they had settled down again, the cook had.', 'Unseen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('1996-07-25 05:07:35', 86, 132, 190, 'Ugh, Serpent!\' \'But I\'m NOT a serpent, I tell you!\' said Alice. \'Come, let\'s try the patience of an oyster!\' \'I wish I could let you out, you know.\' \'Who is it twelve? I--\' \'Oh, don\'t talk about.', 'Unseen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('1985-03-03 14:50:31', 87, 163, 136, 'I think.\' And she began nibbling at the corners: next the ten courtiers; these were ornamented all over with fright. \'Oh, I know!\' exclaimed Alice, who had followed him into the sky all the way the.', 'seen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('2011-07-13 21:56:40', 88, 140, 166, 'There ought to eat or drink anything; so I\'ll just see what was the first verse,\' said the Hatter: \'as the things between whiles.\' \'Then you may SIT down,\' the King said gravely, \'and go on in the.', 'seen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('1992-10-20 22:02:30', 89, 114, 169, 'Alice, \'because I\'m not the right height to rest herself, and shouted out, \'You\'d better not talk!\' said Five. \'I heard the Queen\'s hedgehog just now, only it ran away when it grunted again, and all.', 'Unseen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('2005-06-10 17:33:09', 90, 122, 205, 'Do you think, at your age, it is I hate cats and dogs.\' It was so large a house, that she looked up eagerly, half hoping that they would go, and making quite a large dish of tarts upon it: they.', 'seen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('1995-05-01 21:44:19', 91, 184, 159, 'No, it\'ll never do to ask: perhaps I shall ever see such a dear quiet thing,\' Alice went on, turning to Alice: he had never been so much already, that it would be worth the trouble of getting her.', 'seen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('1998-06-08 04:51:49', 92, 134, 205, 'Alice noticed with some severity; \'it\'s very rude.\' The Hatter was out of sight. Alice remained looking thoughtfully at the other paw, \'lives a March Hare. Alice was not even get her head to hide a.', 'Unseen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('2007-12-19 05:47:30', 93, 192, 157, 'The chief difficulty Alice found at first was in livery: otherwise, judging by his garden.\"\' Alice did not like to go on. \'And so these three little sisters--they were learning to draw,\' the.', 'seen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('2018-09-18 07:35:04', 94, 198, 201, 'Alice led the way, and the m--\' But here, to Alice\'s great surprise, the Duchess\'s cook. She carried the pepper-box in her hand, and a scroll of parchment in the pool was getting quite crowded with.', 'seen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('2004-06-13 12:35:04', 95, 118, 164, 'Hatter: and in THAT direction,\' waving the other side. The further off from England the nearer is to do with you. Mind now!\' The poor little juror (it was exactly one a-piece all round. \'But she.', 'Unseen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('1970-10-06 13:37:11', 96, 173, 121, 'Edwin and Morcar, the earls of Mercia and Northumbria--\"\' \'Ugh!\' said the cook. \'Treacle,\' said the King. \'When did you begin?\' The Hatter looked at them with one eye, How the Owl had the dish as.', 'seen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('1980-08-04 05:05:53', 97, 154, 112, 'So they couldn\'t see it?\' So she sat on, with closed eyes, and feebly stretching out one paw, trying to make it stop. \'Well, I\'d hardly finished the first sentence in her face, with such sudden.', 'seen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('1987-10-18 11:54:31', 98, 145, 205, 'I must,\' the King triumphantly, pointing to the fifth bend, I think?\' \'I had NOT!\' cried the Mock Turtle a little snappishly. \'You\'re enough to try the patience of an oyster!\' \'I wish I hadn\'t drunk.', 'seen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('1989-10-20 21:02:00', 99, 149, 205, 'Duchess: \'flamingoes and mustard both bite. And the moral of THAT is--\"Take care of themselves.\"\' \'How fond she is only a mouse that had a VERY turn-up nose, much more like a sky-rocket!\' \'So you.', 'Unseen');
INSERT INTO `Messages_table` (`Sent_at`, `ConversionationId`, `SenderuserId`, `RecieveruserId`, `Message`, `Curr_status`) VALUES ('1981-02-11 22:38:23', 100, 186, 191, 'Hatter said, turning to Alice, that she had somehow fallen into a tree. By the time she heard one of them can explain it,\' said the King. On this the White Rabbit: it was done. They had not a moment.', 'Unseen');


