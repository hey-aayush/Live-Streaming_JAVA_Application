#
# TABLE STRUCTURE FOR: user
#

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(40) NOT NULL,
  `firstName` varchar(40) DEFAULT NULL,
  `lastName` varchar(40) DEFAULT NULL,
  `status` enum('Online','Offline') CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `Email` varchar(40) DEFAULT NULL,
  `password` varchar(7) DEFAULT NULL,
  `IsStreammer` tinyint(1) DEFAULT 0,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `userName` (`userName`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb4;

INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (1, 'ottis30', 'Polly', 'Halvorson', 'Offline', 'nikolaus.freeda@example.net', '69e116c', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (2, 'anderson.johnson', 'Loyal', 'Boyer', 'Offline', 'taurean96@example.com', 'b6c3a22', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (3, 'pschuppe', 'Darien', 'McClure', 'Offline', 'wuckert.stevie@example.org', '40f5ee4', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (4, 'uondricka', 'Amalia', 'Moen', 'Offline', 'helene94@example.com', '00d3fe4', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (5, 'quigley.omer', 'Carleton', 'Kutch', 'Offline', 'khegmann@example.org', '7600b29', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (6, 'alek56', 'Jennifer', 'Weber', 'Offline', 'pgraham@example.com', 'af1ffee', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (7, 'mackenzie.rippin', 'Guadalupe', 'Bashirian', 'Offline', 'kertzmann.cassandre@example.com', '6ac5218', 1);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (8, 'sydnie84', 'Roselyn', 'Brown', 'Offline', 'gwendolyn.hyatt@example.org', 'd4e2ede', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (9, 'lemuel09', 'Jenifer', 'Okuneva', 'Offline', 'hyatt.vivien@example.net', '8c171d1', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (10, 'crona.rory', 'Sylvester', 'Runolfsdottir', 'Offline', 'rigoberto.hammes@example.org', '74bd40c', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (11, 'sammie57', 'Demarcus', 'Weber', 'Offline', 'hardy.dach@example.com', 'f6c1697', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (12, 'hoppe.ericka', 'Rogelio', 'Weber', 'Offline', 'eldridge.balistreri@example.org', 'cf70bc0', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (13, 'zledner', 'Noel', 'Rodriguez', 'Offline', 'jast.sheridan@example.net', '70517b8', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (14, 'eschroeder', 'Ramona', 'Stanton', 'Offline', 'waelchi.serenity@example.net', '58034d7', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (15, 'ophelia.brown', 'Cortney', 'Littel', 'Offline', 'wilkinson.enrico@example.net', '79cbfe4', 1);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (16, 'jazlyn85', 'Tia', 'Kerluke', 'Offline', 'alexandrine.runolfsdottir@example.com', 'a5826dc', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (17, 'brandyn.wyman', 'Darron', 'Bins', 'Offline', 'ebayer@example.org', '5778153', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (18, 'vstracke', 'Eduardo', 'Halvorson', 'Offline', 'hgreenholt@example.net', 'dbea916', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (19, 'aswift', 'Buford', 'O\'Reilly', 'Offline', 'ijast@example.org', '8f50e31', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (20, 'maddison.spencer', 'Morgan', 'Kuphal', 'Offline', 'lera78@example.com', 'bf4a466', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (21, 'nolan.patrick', 'Amos', 'Kilback', 'Offline', 'elton.farrell@example.org', 'e9e73d8', 1);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (22, 'cboyer', 'Ellsworth', 'Volkman', 'Offline', 'mikel51@example.org', 'da951f9', 1);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (23, 'miles.graham', 'Shawna', 'Reichert', 'Offline', 'jaron.buckridge@example.org', '67149ee', 1);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (24, 'delta.rempel', 'Jannie', 'Schowalter', 'Offline', 'daphney.gutkowski@example.org', '67f838a', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (25, 'dlind', 'Otto', 'Ebert', 'Offline', 'rhianna91@example.net', 'b605d52', 1);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (26, 'abbey93', 'Justine', 'Schumm', 'Offline', 'orval.rodriguez@example.com', '53641fd', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (27, 'ressie.little', 'Jackie', 'Bechtelar', 'Offline', 'denesik.chelsie@example.net', '00f0d1b', 1);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (28, 'medhurst.denis', 'Clinton', 'Kirlin', 'Offline', 'cecile.wiegand@example.net', '020427c', 1);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (29, 'ismael59', 'Ambrose', 'Casper', 'Offline', 'loyal.fritsch@example.com', '038b2ee', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (30, 'maymie10', 'Coleman', 'Emmerich', 'Offline', 'mlarson@example.com', 'e9ccfe7', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (31, 'jewell.mcglynn', 'Malvina', 'Paucek', 'Offline', 'cbotsford@example.net', '871f79e', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (32, 'kdooley', 'Webster', 'Schaefer', 'Offline', 'kmann@example.org', 'd58db07', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (33, 'hollis13', 'Bridgette', 'Pfeffer', 'Offline', 'zfarrell@example.org', '964d065', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (34, 'marquardt.rowena', 'Elroy', 'Morar', 'Offline', 'nmacejkovic@example.com', '660dd51', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (35, 'aufderhar.layne', 'Myriam', 'Cartwright', 'Offline', 'christiansen.celine@example.com', '35268e5', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (36, 'cpacocha', 'Lilly', 'Ankunding', 'Offline', 'ahoppe@example.com', 'ba058a3', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (37, 'rosie.eichmann', 'Treva', 'Tillman', 'Offline', 'jack62@example.net', 'f8c30f4', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (38, 'blake16', 'Arlo', 'Schuster', 'Offline', 'roob.natalie@example.com', 'f232d2c', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (39, 'gschowalter', 'Vivien', 'Orn', 'Offline', 'florencio.bergstrom@example.com', 'a24de9f', 1);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (40, 'ernser.myra', 'Ivy', 'Howe', 'Offline', 'cristobal13@example.org', '816308e', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (41, 'omiller', 'Luz', 'Little', 'Offline', 'bernier.thurman@example.net', 'd9aed76', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (42, 'adolfo64', 'Camron', 'Stoltenberg', 'Offline', 'lenny53@example.com', '1bdbf39', 1);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (43, 'tremblay.lisa', 'Alana', 'Bartell', 'Offline', 'alice.auer@example.org', '42b90ee', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (44, 'blanda.queen', 'Bonita', 'Bosco', 'Offline', 'dante.batz@example.org', '23bb7d0', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (45, 'lemke.ozella', 'Quinton', 'Hodkiewicz', 'Offline', 'dave.spinka@example.net', 'affc051', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (46, 'flindgren', 'Mack', 'Runolfsdottir', 'Offline', 'wyatt.haley@example.org', 'e920080', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (47, 'o\'keefe.emelie', 'Alexandro', 'Reinger', 'Offline', 'duncan.cassin@example.net', '1179b42', 1);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (48, 'adicki', 'Lilyan', 'Heathcote', 'Offline', 'quigley.itzel@example.org', 'daf09f4', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (49, 'spacocha', 'Marguerite', 'Leffler', 'Offline', 'dangelo.carter@example.org', 'e95e22d', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (50, 'jailyn88', 'Jodie', 'Metz', 'Offline', 'kgerlach@example.org', '84e10ec', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (51, 'salvatore02', 'Nicola', 'Mohr', 'Offline', 'shayna43@example.net', 'f311056', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (52, 'murazik.dewayne', 'Cecil', 'Ernser', 'Offline', 'qsmith@example.net', '82f4bce', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (53, 'carlie02', 'Ervin', 'Legros', 'Offline', 'carter.judson@example.com', 'd20535a', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (54, 'elna.price', 'Dan', 'Hermann', 'Offline', 'kareem.rohan@example.org', 'b158035', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (55, 'wehner.pearline', 'Kristy', 'Roberts', 'Offline', 'clifton.zulauf@example.org', '05a5bc8', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (56, 'turner.brandy', 'Judge', 'Koepp', 'Offline', 'sratke@example.net', 'f40ce72', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (57, 'pacocha.shanon', 'Maiya', 'Jaskolski', 'Offline', 'haleigh.rowe@example.net', 'e0b054a', 1);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (58, 'reuben33', 'Reginald', 'Rolfson', 'Offline', 'estella74@example.com', 'ba11aa3', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (59, 'brad.bergnaum', 'Murl', 'Bahringer', 'Offline', 'herzog.rosemarie@example.com', 'd6c1bd8', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (60, 'jaeden.brakus', 'Elvera', 'Collins', 'Offline', 'marlee17@example.net', '941e63e', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (61, 'augustus48', 'Carlie', 'Smitham', 'Offline', 'jannie.armstrong@example.net', '99a004b', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (62, 'raul40', 'Elena', 'Daniel', 'Offline', 'felipe24@example.net', '2242398', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (63, 'nkshlerin', 'Burdette', 'Kling', 'Offline', 'shanel.boehm@example.org', '644a656', 1);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (64, 'foster83', 'Maudie', 'Heidenreich', 'Offline', 'dexter02@example.com', '7ec9da8', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (65, 'ryley.senger', 'Elmer', 'Corkery', 'Offline', 'nstoltenberg@example.org', 'dc1cf23', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (66, 'aauer', 'Joany', 'Lebsack', 'Offline', 'mayert.marcella@example.net', '98a39c0', 1);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (67, 'karine.jakubowski', 'Javier', 'McCullough', 'Offline', 'eondricka@example.org', '0e88476', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (68, 'jwalsh', 'Rosalia', 'Feest', 'Offline', 'gbeahan@example.net', 'd77371f', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (69, 'lang.paul', 'Felipa', 'Fay', 'Offline', 'uturner@example.com', '22fc48b', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (70, 'gutkowski.garrison', 'Delaney', 'Hane', 'Offline', 'dolly.ernser@example.org', '3ed30b4', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (71, 'o\'hara.sarah', 'Elisabeth', 'Emard', 'Offline', 'metz.moises@example.com', 'bc262f8', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (72, 'fadel.diamond', 'Schuyler', 'Barton', 'Offline', 'kilback.erwin@example.net', '3c587e7', 1);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (73, 'jframi', 'Terence', 'Stoltenberg', 'Offline', 'spencer.alfred@example.com', 'b905f88', 1);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (74, 'herzog.carrie', 'Abraham', 'Fay', 'Offline', 'jschulist@example.org', '69b76c7', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (75, 'malika48', 'Danny', 'Koelpin', 'Offline', 'crooks.glenna@example.com', '6097ad3', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (76, 'dprosacco', 'Santa', 'Schultz', 'Offline', 'dallas94@example.com', 'e53533f', 1);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (77, 'kihn.darrin', 'Hillary', 'Bins', 'Offline', 'swift.johnpaul@example.com', 'afb9910', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (78, 'crogahn', 'Kailee', 'Renner', 'Offline', 'gladys33@example.net', 'ff11fc7', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (79, 'icollins', 'Gina', 'Daugherty', 'Offline', 'terry.issac@example.net', 'c0a56ea', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (80, 'bbecker', 'Lourdes', 'Ullrich', 'Offline', 'jalyn.fadel@example.org', 'd5efd3c', 1);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (81, 'rohan.gretchen', 'Madeline', 'Bernhard', 'Offline', 'nedra.schuster@example.com', '9d91131', 1);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (82, 'berta.wisoky', 'Keshawn', 'Mohr', 'Offline', 'ebaumbach@example.net', 'd98797f', 1);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (83, 'vladimir26', 'Jordy', 'Towne', 'Offline', 'sierra98@example.com', '3608f81', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (84, 'purdy.stacey', 'Hal', 'Kub', 'Offline', 'lakin.gwen@example.com', '9e4aa40', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (85, 'iward', 'Judd', 'Nikolaus', 'Offline', 'jennifer.klocko@example.org', '72272af', 1);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (86, 'dlangosh', 'Margarita', 'Parker', 'Offline', 'eliezer.rodriguez@example.org', 'ed20855', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (87, 'bogisich.sedrick', 'Elyse', 'Sanford', 'Offline', 'santa23@example.org', 'e61f05a', 1);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (88, 'zora37', 'Rosa', 'Swift', 'Offline', 'howell.watson@example.org', 'e593f5c', 1);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (89, 'gpowlowski', 'Adaline', 'McKenzie', 'Offline', 'pink97@example.com', 'd445691', 1);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (90, 'koss.trevor', 'Karlee', 'Walsh', 'Offline', 'wilber.thompson@example.org', '63415dc', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (91, 'alize91', 'Marielle', 'Renner', 'Offline', 'constance69@example.net', '62f6d07', 1);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (92, 'scotty70', 'Alexandrine', 'Wisozk', 'Offline', 'earnestine18@example.net', '5298c68', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (93, 'dlindgren', 'Myrtle', 'Stoltenberg', 'Offline', 'julie.mckenzie@example.com', '1e620fe', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (94, 'anika58', 'Elaina', 'Dickens', 'Offline', 'keith.corwin@example.org', 'dd70652', 1);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (95, 'zrutherford', 'Lucy', 'Dickinson', 'Offline', 'malachi86@example.org', 'b8658b7', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (96, 'rgoldner', 'Chaz', 'Ondricka', 'Offline', 'aubree.kunde@example.net', '651b551', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (97, 'franecki.jillian', 'Leonora', 'Marks', 'Offline', 'enola.gleason@example.com', 'f9b6908', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (98, 'theron.donnelly', 'Isabel', 'Schulist', 'Offline', 'jodie.bashirian@example.com', 'ab4d199', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (99, 'tabitha.stanton', 'Kirstin', 'Zulauf', 'Offline', 'mireya.ullrich@example.net', '22d3998', 0);
INSERT INTO `user` (`userId`, `userName`, `firstName`, `lastName`, `status`, `Email`, `password`, `IsStreammer`) VALUES (100, 'lgerhold', 'Kiley', 'Lebsack', 'Offline', 'yskiles@example.net', 'e9cf19b', 0);


#
# TABLE STRUCTURE FOR: Channel_table
#

DROP TABLE IF EXISTS `Channel_table`;

CREATE TABLE `Channel_table` (
  `ChannelId` int(11) NOT NULL AUTO_INCREMENT,
  `channelName` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `userId` int(11) NOT NULL,
  `NoofSubcribers` int(11) DEFAULT 0,
  `Curr_status` enum('Streamming','NotStreamming') COLLATE utf8_unicode_ci DEFAULT 'NotStreamming',
  PRIMARY KEY (`ChannelId`),
  KEY `userId` (`userId`),
  CONSTRAINT `Channel_table_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (1, 'mathias57', 66, 4, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (2, 'adella37', 67, 5, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (3, 'uconnelly', 49, 4, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (4, 'jewell93', 35, 0, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (5, 'adolf.doyle', 27, 7, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (6, 'skuhlman', 77, 8, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (7, 'afarrell', 100, 2, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (8, 'beatty.josue', 30, 3, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (9, 'baron66', 93, 2, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (10, 'cschmeler', 54, 1, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (11, 'hansen.sibyl', 30, 0, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (12, 'tgaylord', 43, 9, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (13, 'olson.sydney', 45, 4, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (14, 'finn99', 84, 0, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (15, 'mante.cathy', 9, 4, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (16, 'demetris47', 58, 4, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (17, 'hermiston.alford', 89, 4, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (18, 'fausto.bergnaum', 42, 3, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (19, 'tess11', 66, 7, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (20, 'carter.miller', 68, 4, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (21, 'monique68', 90, 3, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (22, 'bpagac', 48, 9, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (23, 'terrell78', 86, 4, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (24, 'sonny.bergnaum', 91, 5, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (25, 'weber.wayne', 94, 3, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (26, 'aron55', 73, 5, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (27, 'brakus.raul', 36, 3, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (28, 'braden15', 94, 8, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (29, 'torrey.reilly', 57, 3, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (30, 'carolyne28', 80, 8, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (31, 'greta.bednar', 99, 9, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (32, 'luettgen.reymundo', 23, 6, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (33, 'clifton49', 46, 0, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (34, 'fredy24', 48, 0, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (35, 'polson', 58, 7, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (36, 'charles97', 72, 6, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (37, 'turner.jayde', 24, 3, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (38, 'xvon', 58, 5, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (39, 'harry.kerluke', 2, 9, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (40, 'mattie.price', 17, 6, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (41, 'gerhold.lavern', 11, 6, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (42, 'ybalistreri', 32, 9, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (43, 'lwolf', 59, 1, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (44, 'bmorar', 55, 6, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (45, 'gennaro.doyle', 15, 9, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (46, 'parker.reagan', 68, 9, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (47, 'jackson89', 13, 2, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (48, 'abelardo59', 4, 3, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (49, 'vdicki', 10, 6, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (50, 'mohammed21', 79, 6, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (51, 'ursula57', 72, 2, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (52, 'jacynthe.homenick', 99, 7, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (53, 'beatty.iva', 26, 1, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (54, 'harrison.rogahn', 58, 5, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (55, 'leora29', 90, 6, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (56, 'ophelia89', 19, 8, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (57, 'deondre30', 30, 2, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (58, 'ratke.adolphus', 25, 1, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (59, 'simonis.zella', 13, 3, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (60, 'lemke.cierra', 86, 6, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (61, 'armstrong.karelle', 4, 9, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (62, 'ronaldo80', 12, 2, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (63, 'morissette.larissa', 8, 0, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (64, 'josue.sipes', 50, 7, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (65, 'leo75', 60, 7, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (66, 'reggie.koelpin', 65, 2, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (67, 'jordy03', 21, 5, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (68, 'ucormier', 83, 0, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (69, 'mclaughlin.odessa', 22, 1, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (70, 'ymcclure', 23, 9, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (71, 'noel13', 100, 5, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (72, 'kyle59', 33, 5, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (73, 'cassin.aracely', 54, 9, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (74, 'bergnaum.eleanora', 58, 0, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (75, 'jordon.mclaughlin', 88, 7, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (76, 'rosalyn62', 68, 1, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (77, 'jflatley', 26, 7, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (78, 'ncummerata', 100, 2, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (79, 'cleve.spencer', 72, 2, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (80, 'weimann.pablo', 35, 3, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (81, 'mckenna55', 78, 5, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (82, 'predovic.alia', 43, 4, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (83, 'gwen.murazik', 34, 0, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (84, 'lprohaska', 4, 8, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (85, 'king.felipa', 100, 1, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (86, 'cassie.hermiston', 23, 8, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (87, 'ymurray', 23, 6, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (88, 'adell.robel', 29, 0, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (89, 'tate.veum', 48, 7, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (90, 'magdalena31', 36, 6, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (91, 'tgleichner', 15, 6, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (92, 'towne.fritz', 52, 5, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (93, 'bertrand56', 47, 6, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (94, 'sylvester.jerde', 22, 8, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (95, 'dorothy.kautzer', 1, 9, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (96, 'gabe79', 7, 1, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (97, 'tmurazik', 87, 5, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (98, 'lhamill', 22, 1, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (99, 'schmitt.grace', 89, 1, 'NotStreamming');
INSERT INTO `Channel_table` (`ChannelId`, `channelName`, `userId`, `NoofSubcribers`, `Curr_status`) VALUES (100, 'heloise.crona', 8, 4, 'NotStreamming');


#
# TABLE STRUCTURE FOR: Subscription_table
#

DROP TABLE IF EXISTS `Subscription_table`;

CREATE TABLE `Subscription_table` (
  `ReqTime` timestamp NULL DEFAULT NULL,
  `SubscriptionId` int(10) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `ChannelId` int(11) NOT NULL,
  `status` enum('Active','Inactive') CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT 'Active',
  PRIMARY KEY (`SubscriptionId`),
  KEY `userId` (`userId`),
  KEY `ChannelId` (`ChannelId`),
  CONSTRAINT `Subscription_table_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`),
  CONSTRAINT `Subscription_table_ibfk_2` FOREIGN KEY (`ChannelId`) REFERENCES `Channel_table` (`ChannelId`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=latin1;

INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('1985-09-03 16:37:25', 1, 10, 2, 'Inactive');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('1991-12-21 13:12:59', 2, 27, 43, 'Inactive');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('1974-11-01 22:24:40', 3, 68, 70, 'Inactive');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('2013-01-10 19:23:21', 4, 57, 12, 'Active');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('2014-11-09 17:21:32', 5, 14, 15, 'Inactive');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('1990-10-30 14:11:05', 6, 96, 67, 'Inactive');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('1983-09-06 23:10:50', 7, 73, 14, 'Active');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('1988-08-29 14:57:41', 8, 31, 32, 'Active');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('2019-03-31 16:38:14', 9, 4, 97, 'Inactive');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('1993-11-14 02:40:48', 10, 58, 32, 'Active');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('2013-06-21 10:53:09', 11, 10, 10, 'Inactive');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('1995-12-18 18:08:15', 12, 59, 79, 'Active');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('2018-03-05 05:26:56', 13, 60, 40, 'Active');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('1971-04-01 20:14:38', 14, 50, 49, 'Active');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('2000-12-07 12:59:15', 15, 35, 81, 'Active');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('2001-11-28 16:15:41', 16, 51, 44, 'Inactive');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('1999-12-09 12:40:40', 17, 82, 78, 'Active');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('1990-11-24 03:57:03', 18, 86, 50, 'Inactive');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('1983-02-06 23:33:42', 19, 48, 43, 'Active');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('1997-03-20 01:48:50', 20, 61, 61, 'Inactive');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('1987-03-16 03:05:58', 21, 57, 56, 'Inactive');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('1999-11-11 22:43:30', 22, 28, 30, 'Active');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('1982-02-28 20:59:23', 23, 70, 59, 'Inactive');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('1988-01-18 04:04:26', 24, 61, 74, 'Inactive');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('2002-09-19 02:58:35', 25, 55, 18, 'Active');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('2002-05-22 21:10:04', 26, 5, 64, 'Active');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('1988-08-22 08:21:36', 27, 28, 63, 'Active');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('1988-11-22 22:26:02', 28, 43, 87, 'Inactive');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('1974-05-18 09:06:41', 29, 3, 92, 'Inactive');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('1995-11-24 21:22:15', 30, 36, 37, 'Inactive');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('1987-10-26 18:29:26', 31, 73, 86, 'Active');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('1973-09-09 17:48:19', 32, 80, 54, 'Active');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('1983-06-08 04:55:40', 33, 64, 66, 'Active');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('2013-07-10 07:30:18', 34, 3, 11, 'Inactive');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('1984-05-16 12:31:51', 35, 8, 64, 'Active');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('2015-05-16 15:49:00', 36, 72, 65, 'Active');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('1995-05-16 07:49:17', 37, 19, 99, 'Active');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('1983-08-28 13:24:19', 38, 94, 89, 'Inactive');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('2014-09-08 18:17:10', 39, 58, 55, 'Active');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('2010-08-04 07:34:33', 40, 62, 12, 'Inactive');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('1990-02-17 12:00:49', 41, 73, 66, 'Inactive');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('1987-02-20 22:41:41', 42, 75, 1, 'Inactive');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('2019-01-17 23:14:36', 43, 29, 18, 'Inactive');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('1988-01-03 02:21:21', 44, 87, 31, 'Inactive');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('1987-10-10 13:11:45', 45, 9, 22, 'Active');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('1999-07-12 17:17:16', 46, 67, 81, 'Active');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('1995-04-17 03:53:29', 47, 8, 47, 'Active');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('2002-01-13 11:17:23', 48, 35, 71, 'Active');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('1999-05-19 10:16:11', 49, 13, 38, 'Inactive');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('1990-10-23 23:20:32', 50, 82, 20, 'Inactive');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('1977-08-13 09:43:50', 51, 1, 53, 'Inactive');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('2001-12-23 22:45:44', 52, 85, 20, 'Inactive');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('2011-05-06 07:40:09', 53, 52, 78, 'Inactive');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('1973-05-20 02:29:00', 54, 9, 9, 'Inactive');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('1970-09-20 05:20:12', 55, 33, 70, 'Inactive');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('2020-07-22 05:44:43', 56, 20, 5, 'Inactive');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('1988-08-30 14:13:26', 57, 36, 95, 'Active');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('1972-06-28 20:29:52', 58, 5, 64, 'Inactive');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('2013-06-06 03:06:00', 59, 12, 92, 'Active');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('2014-02-03 23:51:40', 60, 95, 21, 'Inactive');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('1988-05-10 23:40:38', 61, 14, 62, 'Inactive');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('1982-10-18 08:38:43', 62, 2, 21, 'Active');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('1974-12-25 23:08:05', 63, 8, 37, 'Inactive');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('1971-10-17 12:22:03', 64, 92, 21, 'Inactive');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('1997-08-14 05:20:14', 65, 74, 73, 'Active');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('1971-11-12 00:29:21', 66, 40, 75, 'Inactive');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('1983-09-08 02:27:49', 67, 25, 24, 'Inactive');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('2020-06-24 09:08:10', 68, 94, 76, 'Inactive');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('2006-03-16 14:48:11', 69, 2, 2, 'Inactive');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('1996-11-21 03:46:40', 70, 84, 34, 'Inactive');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('1975-08-02 16:12:19', 71, 72, 4, 'Inactive');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('2020-09-13 11:52:08', 72, 39, 8, 'Inactive');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('2020-02-03 06:22:05', 73, 99, 44, 'Inactive');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('2019-01-03 04:26:17', 74, 72, 11, 'Inactive');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('1975-11-16 14:23:35', 75, 35, 67, 'Active');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('2001-09-17 20:28:46', 76, 31, 49, 'Active');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('1974-05-13 10:28:15', 77, 28, 33, 'Active');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('1981-06-25 17:31:59', 78, 69, 36, 'Active');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('2015-12-15 15:08:06', 79, 69, 61, 'Active');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('2007-12-07 15:23:39', 80, 56, 43, 'Active');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('1994-06-22 14:35:37', 81, 33, 96, 'Active');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('2001-08-26 15:56:55', 82, 17, 58, 'Active');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('2017-03-13 18:30:28', 83, 20, 11, 'Active');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('1977-08-06 04:40:03', 84, 34, 22, 'Active');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('1980-06-17 20:50:02', 85, 13, 18, 'Inactive');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('2013-01-20 02:33:30', 86, 56, 85, 'Inactive');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('1979-07-29 04:10:38', 87, 21, 94, 'Inactive');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('1992-10-03 05:05:15', 88, 92, 19, 'Inactive');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('1971-04-21 16:05:33', 89, 38, 64, 'Inactive');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('1973-06-30 04:29:02', 90, 30, 73, 'Active');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('1997-09-01 08:20:25', 91, 30, 60, 'Active');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('2015-12-31 19:37:00', 92, 21, 57, 'Active');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('1998-10-13 11:56:29', 93, 93, 90, 'Inactive');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('1982-10-13 08:48:32', 94, 92, 62, 'Active');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('1973-05-15 02:09:58', 95, 50, 48, 'Inactive');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('2004-06-06 21:20:07', 96, 4, 83, 'Active');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('2007-05-21 17:16:36', 97, 43, 21, 'Inactive');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('2018-03-03 21:05:34', 98, 40, 62, 'Inactive');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('2020-09-17 06:46:54', 99, 31, 73, 'Inactive');
INSERT INTO `Subscription_table` (`ReqTime`, `SubscriptionId`, `userId`, `ChannelId`, `status`) VALUES ('1977-07-15 16:38:48', 100, 83, 43, 'Inactive');

select * from user;

select * from Channel_table;

select * from Subscription_table;
