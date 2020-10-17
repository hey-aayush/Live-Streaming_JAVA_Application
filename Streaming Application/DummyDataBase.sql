

#
# TABLE STRUCTURE FOR: users_account_details
#

DROP TABLE IF EXISTS `users_account_details`;

CREATE TABLE `users_account_details` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `firstname` varchar(30) DEFAULT NULL,
  `lastname` varchar(30) DEFAULT NULL,
  `password` varchar(7) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `Gender` enum('male','female') DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=201 DEFAULT CHARSET=latin1;

INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (101, 'ramon11', 'Gladyce', 'Stroman', '185dd69', 'marlee15@example.net', 'male');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (102, 'rosanna96', 'Angie', 'Quitzon', '6069734', 'deja.berge@example.com', 'female');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (103, 'terrance.kerluke', 'Marcia', 'Johnston', '0c35829', 'jaylan07@example.org', 'female');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (104, 'maximillia49', 'Savion', 'Fisher', '5be8afa', 'renner.lucie@example.net', 'male');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (105, 'samantha50', 'Isobel', 'Kuhlman', 'e755cd0', 'clarabelle83@example.net', 'female');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (106, 'sherman31', 'Easter', 'Cassin', 'e3e2eb5', 'yschroeder@example.net', 'female');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (107, 'showell', 'Issac', 'Kertzmann', '6b9a001', 'friedrich.williamson@example.net', 'male');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (108, 'vicenta86', 'Lonzo', 'Powlowski', '9a27ca2', 'ollie66@example.org', 'male');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (109, 'jfahey', 'Roscoe', 'Rempel', 'fb75799', 'akris@example.net', 'female');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (110, 'cooper21', 'Christelle', 'Fay', 'c851209', 'vpurdy@example.com', 'female');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (111, 'jhessel', 'Barrett', 'Marks', '97d8cf9', 'ludwig.moen@example.org', 'female');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (112, 'bella81', 'Misael', 'Leffler', '35d472a', 'rico03@example.org', 'female');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (113, 'prosacco.gage', 'Deborah', 'Hoppe', '492efda', 'fhuels@example.net', 'female');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (114, 'ronny.graham', 'Donny', 'Ward', 'ef0ce81', 'sabryna03@example.org', 'female');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (115, 'acollier', 'Prudence', 'Beer', 'f178951', 'reva.lowe@example.org', 'male');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (116, 'kolby.lebsack', 'Dominic', 'Pollich', '9de18be', 'dankunding@example.net', 'male');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (117, 'so\'hara', 'Abraham', 'Bayer', 'ada2e8d', 'dion.gleason@example.org', 'male');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (118, 'mafalda70', 'Jessyca', 'Monahan', '268797e', 'emmet48@example.org', 'male');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (119, 'selmer79', 'Madge', 'Bauch', '4cdead0', 'padberg.paxton@example.org', 'female');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (120, 'paula.dietrich', 'Lyda', 'Reichel', '713d37a', 'dconroy@example.net', 'male');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (121, 'ken.bednar', 'Hailee', 'Fisher', 'b9b0323', 'yschmidt@example.net', 'male');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (122, 'vickie94', 'Turner', 'Schroeder', '9036c09', 'waters.julianne@example.com', 'male');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (123, 'armani.thompson', 'Emmett', 'Dare', '9763ed3', 'thomas00@example.org', 'male');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (124, 'marvin.hildegard', 'Mya', 'Fadel', '7bb3a27', 'queenie.medhurst@example.com', 'female');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (125, 'kunde.makenzie', 'Chanel', 'Corwin', 'bfda068', 'o\'conner.maritza@example.org', 'male');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (126, 'lilliana15', 'Shakira', 'Schinner', '2ec2525', 'tgoyette@example.org', 'male');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (127, 'ashleigh.collins', 'Mackenzie', 'Johnston', '9b97fa0', 'frederique.marquardt@example.org', 'male');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (128, 'rosemarie.denesik', 'Alexie', 'Ledner', 'b3b61fd', 'estefania.howell@example.com', 'female');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (129, 'qstiedemann', 'Scotty', 'Abshire', '179c275', 'klakin@example.org', 'female');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (130, 'kiel.schumm', 'Dashawn', 'Olson', 'bb75475', 'jrath@example.com', 'female');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (131, 'ttillman', 'Kayli', 'Weissnat', 'c7326f0', 'jwehner@example.com', 'female');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (132, 'wolf.delphine', 'Tiara', 'Funk', '3db90c8', 'lblick@example.org', 'male');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (133, 'keeley.kuphal', 'Crawford', 'Pacocha', 'fca700d', 'lauryn.mcglynn@example.org', 'female');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (134, 'oral.larson', 'Beulah', 'Murazik', '81cf440', 'will.xavier@example.net', 'male');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (135, 'hermiston.brittany', 'Gussie', 'Rau', '362f5e1', 'blair60@example.org', 'female');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (136, 'jenkins.zachary', 'Matteo', 'Wisozk', 'd392589', 'nmarquardt@example.com', 'female');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (137, 'billie79', 'Crystel', 'Larkin', 'ac4c840', 'dlittle@example.com', 'male');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (138, 'angelina46', 'Ethan', 'Daugherty', '638ff88', 'rico74@example.com', 'male');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (139, 'zcorwin', 'Fletcher', 'Zieme', '6ea5286', 'tanner.mohr@example.com', 'female');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (140, 'uschultz', 'Jazmyne', 'Vandervort', 'ec73863', 'mayert.eino@example.org', 'female');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (141, 'elyse76', 'Estel', 'Altenwerth', 'cfa2719', 'furman.anderson@example.org', 'male');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (142, 'mbrekke', 'Jedediah', 'Abernathy', '4844436', 'rickey51@example.org', 'male');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (143, 'maybell96', 'Amina', 'Bosco', 'fa76aa1', 'yesenia56@example.org', 'male');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (144, 'cwalker', 'Maynard', 'Haley', '07316f0', 'leonard51@example.net', 'female');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (145, 'koch.dixie', 'Dulce', 'Hahn', '640f035', 'odell19@example.com', 'female');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (146, 'wintheiser.fritz', 'Frieda', 'Kovacek', '2df0cf5', 'sam.bogisich@example.net', 'female');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (147, 'rita52', 'Jenifer', 'Lindgren', '661b5ff', 'krystel.maggio@example.net', 'female');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (148, 'jerald.eichmann', 'Dock', 'Swift', 'ced258a', 'ycorwin@example.org', 'female');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (149, 'lkling', 'Isom', 'Kunde', 'f6c54cc', 'terrence27@example.org', 'male');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (150, 'mdietrich', 'Leilani', 'DuBuque', '358d2d8', 'jasen.gerhold@example.net', 'male');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (151, 'chanelle.stiedemann', 'Vinnie', 'Gaylord', '08856f4', 'forrest42@example.net', 'male');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (152, 'edward22', 'Mable', 'Kuphal', '1c47bb7', 'devante.lubowitz@example.net', 'female');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (153, 'pfeffer.nikki', 'Reagan', 'Cummings', '9601193', 'myrtle04@example.com', 'female');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (154, 'tina.casper', 'Eudora', 'Mohr', '0d5a296', 'eleanore44@example.org', 'female');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (155, 'droberts', 'Emilia', 'Dibbert', '466e0e4', 'knolan@example.com', 'female');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (156, 'hettinger.vella', 'Linwood', 'Ebert', 'ac419eb', 'tanner.medhurst@example.org', 'female');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (157, 'catalina99', 'Destinee', 'D\'Amore', '710542d', 'alexa94@example.com', 'female');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (158, 'ddavis', 'Romaine', 'Jones', 'c7a366d', 'herta98@example.org', 'female');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (159, 'tbogisich', 'Marcella', 'Satterfield', 'c65495a', 'korbin.eichmann@example.com', 'female');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (160, 'rtremblay', 'Billy', 'Streich', '6849f1e', 'austin.homenick@example.com', 'male');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (161, 'lisa91', 'Margaret', 'DuBuque', '793aff7', 'jschmeler@example.net', 'female');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (162, 'jamel.klocko', 'Easter', 'Kuvalis', 'a67a9ed', 'malika.howe@example.org', 'male');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (163, 'estella80', 'Marilyne', 'Predovic', '87f73bf', 'stroman.nedra@example.com', 'male');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (164, 'yost.alphonso', 'Stacy', 'Lubowitz', 'b345158', 'melba.abshire@example.com', 'female');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (165, 'aidan64', 'Verna', 'Mohr', '803e3fe', 'dnienow@example.net', 'male');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (166, 'elda.vandervort', 'Ignatius', 'Huels', 'ebb2a13', 'alvis80@example.com', 'female');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (167, 'vkeebler', 'Rollin', 'Kertzmann', '4f86a3c', 'lrippin@example.com', 'male');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (168, 'mueller.eliza', 'Merritt', 'Olson', '8af485e', 'marisol28@example.com', 'male');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (169, 'hbotsford', 'Sandy', 'Bradtke', 'c3a7f36', 'istehr@example.com', 'male');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (170, 'bernier.rachael', 'Ignacio', 'Pacocha', '0f95d9d', 'jalon09@example.net', 'male');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (171, 'felton.mohr', 'Halie', 'Quitzon', '93288c9', 'vivian46@example.org', 'female');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (172, 'yschmidt', 'Sedrick', 'Hegmann', '1d25812', 'krystal.graham@example.net', 'female');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (173, 'jettie84', 'Jovan', 'Reichel', '6ab4248', 'feeney.marlee@example.com', 'female');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (174, 'nicola.adams', 'Rhett', 'Pacocha', '70d73e1', 'hkrajcik@example.org', 'male');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (175, 'huels.sterling', 'Sherwood', 'Abernathy', 'c2bad2b', 'swilkinson@example.net', 'female');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (176, 'eldora.beier', 'Trevion', 'Wunsch', '42136e4', 'smacejkovic@example.net', 'male');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (177, 'vwatsica', 'Hassie', 'Trantow', 'f57f3e8', 'egislason@example.net', 'male');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (178, 'gerald06', 'Gabrielle', 'Cremin', 'c114b5a', 'marguerite76@example.org', 'male');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (179, 'price.vincenzo', 'Marlon', 'Dickinson', 'b7468d2', 'xdare@example.org', 'female');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (180, 'elian.upton', 'Roslyn', 'Schmidt', '68fcb6b', 'hmacejkovic@example.org', 'male');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (181, 'kirk26', 'Sheila', 'Klein', 'e49f985', 'durward29@example.net', 'male');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (182, 'gunner76', 'Lysanne', 'Schimmel', '7052504', 'hartmann.kieran@example.org', 'male');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (183, 'lynn.deckow', 'Jennyfer', 'Schinner', '6cf25b6', 'ukessler@example.net', 'male');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (184, 'mitchel72', 'Stanley', 'Prohaska', 'c853837', 'gschroeder@example.org', 'male');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (185, 'wsmitham', 'Noemi', 'Luettgen', '3827f81', 'wanda.lemke@example.net', 'female');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (186, 'reynolds.rachelle', 'Tyshawn', 'Greenholt', '951b520', 'santina96@example.com', 'female');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (187, 'columbus52', 'Jaylon', 'Steuber', 'b28d277', 'ora.rutherford@example.net', 'male');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (188, 'gbuckridge', 'Jess', 'Waters', '2466ef2', 'deion13@example.com', 'female');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (189, 'ahackett', 'Cornelius', 'Bernier', '804695a', 'forest08@example.com', 'male');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (190, 'qmurray', 'Jaeden', 'Schuster', 'd5ac74b', 'audreanne.kuhlman@example.net', 'female');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (191, 'glen.price', 'Olga', 'Langosh', 'dbc678a', 'maverick.leffler@example.net', 'male');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (192, 'joyce.connelly', 'Franz', 'Ruecker', '9ab1d3f', 'odell.metz@example.org', 'male');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (193, 'montana.schumm', 'Karelle', 'Price', 'a32056b', 'dkrajcik@example.com', 'male');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (194, 'pinkie31', 'Joana', 'Moen', '2ae4d8f', 'floyd60@example.net', 'female');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (195, 'martina.davis', 'Ally', 'Langosh', 'e3c7f0e', 'ujacobi@example.net', 'female');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (196, 'schaden.darron', 'Polly', 'Kerluke', 'ffc0051', 'gabrielle94@example.org', 'male');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (197, 'kristofer62', 'Pearline', 'Botsford', 'ee540c4', 'tyree.frami@example.net', 'female');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (198, 'lind.aurore', 'Stanford', 'Smith', '493d889', 'wbrakus@example.net', 'female');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (199, 'halle.labadie', 'Donavon', 'Grant', '559d7f8', 'lveum@example.org', 'female');
INSERT INTO `users_account_details` (`user_id`, `username`, `firstname`, `lastname`, `password`, `Email`, `Gender`) VALUES (200, 'hoeger.camilla', 'Anabelle', 'Schowalter', 'f429a09', 'remmerich@example.net', 'female');

#
# TABLE STRUCTURE FOR: follow_request_table
#

DROP TABLE IF EXISTS `follow_request_table`;

CREATE TABLE `follow_request_table` (
  `follow_request_id` int(11) NOT NULL AUTO_INCREMENT,
  `request_Time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `sender_user_id` int(11) DEFAULT NULL,
  `reciever_user_id` int(11) DEFAULT NULL,
  `curr_status` enum('active','inactive') DEFAULT NULL,
  PRIMARY KEY (`follow_request_id`),
  KEY `sender_user_id` (`sender_user_id`),
  KEY `reciever_user_id` (`reciever_user_id`),
  CONSTRAINT `follow_request_table_ibfk_1` FOREIGN KEY (`sender_user_id`) REFERENCES `users_account_details` (`user_id`),
  CONSTRAINT `follow_request_table_ibfk_2` FOREIGN KEY (`reciever_user_id`) REFERENCES `users_account_details` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=201 DEFAULT CHARSET=latin1;

INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (101, '2008-07-17 15:56:00', 130, 101, 'active');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (102, '1982-01-25 00:04:49', 137, 102, 'active');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (103, '1990-11-15 19:18:31', 137, 103, 'active');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (104, '1992-03-29 06:23:31', 179, 104, 'inactive');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (105, '2011-02-26 07:46:31', 158, 105, 'active');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (106, '2017-01-26 05:59:41', 169, 106, 'active');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (107, '1983-04-08 02:22:40', 143, 107, 'inactive');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (108, '1982-08-22 18:39:08', 154, 108, 'inactive');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (109, '1975-09-09 19:27:21', 194, 109, 'inactive');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (110, '1975-05-30 19:14:29', 143, 110, 'active');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (111, '2000-10-19 07:08:50', 173, 111, 'active');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (112, '2010-04-20 12:25:54', 163, 112, 'inactive');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (113, '1994-08-28 08:04:36', 137, 113, 'inactive');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (114, '1991-08-07 21:17:58', 101, 114, 'active');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (115, '1985-05-30 18:40:07', 125, 115, 'active');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (116, '2005-04-06 22:07:15', 132, 116, 'inactive');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (117, '1997-01-07 13:47:55', 118, 117, 'inactive');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (118, '2005-11-04 17:23:08', 107, 118, 'inactive');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (119, '2001-03-31 00:57:44', 195, 119, 'inactive');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (120, '1972-10-26 03:58:14', 119, 120, 'active');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (121, '2007-09-13 09:28:36', 155, 121, 'active');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (122, '2008-12-21 03:17:26', 115, 122, 'active');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (123, '2006-10-07 11:26:00', 150, 123, 'active');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (124, '1982-09-26 13:46:02', 161, 124, 'inactive');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (125, '1993-12-17 09:49:13', 164, 125, 'active');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (126, '1976-02-04 15:06:46', 118, 126, 'inactive');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (127, '2014-05-13 02:15:05', 164, 127, 'active');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (128, '1973-07-23 20:01:49', 193, 128, 'active');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (129, '1978-03-23 10:36:23', 163, 129, 'active');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (130, '2016-10-29 12:06:06', 179, 130, 'inactive');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (131, '1990-08-29 07:11:52', 106, 131, 'inactive');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (132, '1982-04-16 23:16:25', 192, 132, 'active');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (133, '1990-04-16 14:48:01', 115, 133, 'active');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (134, '1975-06-24 01:42:50', 142, 134, 'active');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (135, '2018-02-21 17:39:59', 171, 135, 'active');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (136, '1987-04-13 05:30:42', 173, 136, 'inactive');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (137, '1982-12-12 11:18:37', 111, 137, 'inactive');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (138, '1970-07-21 01:02:01', 113, 138, 'active');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (139, '1992-08-31 20:06:06', 126, 139, 'inactive');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (140, '1981-12-06 01:15:49', 105, 140, 'inactive');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (141, '2020-10-09 16:54:32', 156, 141, 'inactive');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (142, '1997-05-06 15:22:22', 198, 142, 'inactive');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (143, '1985-11-28 10:21:17', 167, 143, 'active');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (144, '1988-12-11 00:39:47', 193, 144, 'inactive');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (145, '1979-10-08 11:10:51', 199, 145, 'active');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (146, '1987-12-11 15:52:21', 191, 146, 'active');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (147, '2007-12-18 11:55:12', 124, 147, 'inactive');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (148, '1998-05-23 07:37:19', 116, 148, 'inactive');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (149, '2019-12-23 04:14:48', 198, 149, 'inactive');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (150, '1985-11-30 00:54:47', 119, 150, 'active');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (151, '1982-12-27 19:27:37', 135, 151, 'active');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (152, '2003-11-12 08:16:28', 153, 152, 'inactive');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (153, '2015-08-11 18:12:49', 134, 153, 'inactive');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (154, '1995-06-08 06:40:08', 185, 154, 'inactive');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (155, '1988-03-13 08:46:52', 113, 155, 'inactive');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (156, '1977-08-21 21:45:13', 197, 156, 'active');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (157, '2001-09-22 03:05:45', 103, 157, 'inactive');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (158, '1982-12-29 08:09:49', 176, 158, 'inactive');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (159, '2012-10-09 22:08:01', 190, 159, 'inactive');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (160, '2011-04-08 02:30:41', 165, 160, 'active');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (161, '1990-12-17 11:43:39', 155, 161, 'inactive');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (162, '2005-10-31 16:12:51', 195, 162, 'active');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (163, '1994-06-18 18:03:36', 157, 163, 'active');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (164, '1980-12-15 04:34:28', 169, 164, 'active');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (165, '2018-10-18 23:16:17', 137, 165, 'active');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (166, '1995-01-18 05:22:16', 127, 166, 'inactive');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (167, '2000-06-17 00:16:23', 142, 167, 'active');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (168, '2008-08-21 09:55:26', 148, 168, 'active');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (169, '2000-05-21 17:06:23', 140, 169, 'inactive');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (170, '1979-02-02 06:34:49', 167, 170, 'active');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (171, '1971-10-13 03:13:25', 153, 171, 'active');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (172, '1978-01-26 06:28:33', 196, 172, 'inactive');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (173, '2019-03-13 11:23:10', 165, 173, 'active');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (174, '2001-08-12 05:50:37', 119, 174, 'active');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (175, '1984-06-25 04:02:06', 188, 175, 'inactive');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (176, '1978-08-17 15:08:35', 164, 176, 'active');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (177, '2000-08-07 03:56:32', 109, 177, 'inactive');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (178, '2011-09-21 12:12:48', 112, 178, 'active');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (179, '2010-07-13 07:45:34', 179, 179, 'inactive');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (180, '2013-01-08 11:31:12', 107, 180, 'active');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (181, '1988-06-09 00:49:49', 130, 181, 'inactive');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (182, '1992-06-03 17:51:47', 113, 182, 'inactive');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (183, '1980-03-20 20:38:18', 159, 183, 'inactive');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (184, '2013-06-10 12:47:16', 164, 184, 'active');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (185, '2003-04-08 07:23:11', 197, 185, 'inactive');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (186, '1993-06-21 18:31:51', 172, 186, 'active');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (187, '1994-06-25 19:41:40', 160, 187, 'inactive');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (188, '2019-01-21 09:38:25', 199, 188, 'active');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (189, '1970-07-28 19:58:29', 148, 189, 'active');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (190, '2018-09-23 01:17:36', 150, 190, 'active');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (191, '2012-10-05 15:55:03', 164, 191, 'active');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (192, '2016-05-21 07:48:51', 102, 192, 'active');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (193, '1990-08-09 07:22:12', 145, 193, 'inactive');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (194, '1992-10-04 17:27:57', 120, 194, 'inactive');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (195, '1995-05-12 01:07:50', 171, 195, 'active');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (196, '1998-10-27 13:15:37', 182, 196, 'inactive');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (197, '1970-07-08 14:17:50', 147, 197, 'active');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (198, '2012-03-23 11:16:04', 112, 198, 'active');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (199, '1977-05-07 20:27:04', 130, 199, 'inactive');
INSERT INTO `follow_request_table` (`follow_request_id`, `request_Time`, `sender_user_id`, `reciever_user_id`, `curr_status`) VALUES (200, '1970-10-13 15:27:34', 187, 200, 'inactive');

