/*
-- Query: SELECT * FROM extrafield
LIMIT 0, 1000

-- Date: 2017-09-17 01:33
*/
INSERT INTO `extrafield` (`idextrafield`,`tipo`,`field`,`valor`) VALUES (1,'documento','1','Documento Nacional de Identidad');
INSERT INTO `extrafield` (`idextrafield`,`tipo`,`field`,`valor`) VALUES (2,'documento','2','Carnet de Extranjeria');
INSERT INTO `extrafield` (`idextrafield`,`tipo`,`field`,`valor`) VALUES (3,'documento','3','Registro Unico Contribuyente');
INSERT INTO `extrafield` (`idextrafield`,`tipo`,`field`,`valor`) VALUES (4,'documento','4','Pasaporte');
INSERT INTO `extrafield` (`idextrafield`,`tipo`,`field`,`valor`) VALUES (5,'documento','5','Partida de Nacimiento');
INSERT INTO `extrafield` (`idextrafield`,`tipo`,`field`,`valor`) VALUES (6,'sexo','1','Masculino');
INSERT INTO `extrafield` (`idextrafield`,`tipo`,`field`,`valor`) VALUES (7,'sexo','2','Femenino');
INSERT INTO `extrafield` (`idextrafield`,`tipo`,`field`,`valor`) VALUES (8,'genero','V','Varones');
INSERT INTO `extrafield` (`idextrafield`,`tipo`,`field`,`valor`) VALUES (9,'genero','M','Mujeres');
INSERT INTO `extrafield` (`idextrafield`,`tipo`,`field`,`valor`) VALUES (10,'genero','MX','Mixto');

INSERT INTO `perfil` VALUES (1,'Administrador');
INSERT INTO `perfil` VALUES (2,'Delegado');
INSERT INTO `perfil` VALUES (3,'Cajero');

/* PARA INSERTAR UN USUARIO PARA LOGEO */
INSERT INTO persona VALUES (1, 'ALEX RUBEN', 'ARAGON', 'CALIXTO', '1', 1, '44197172', '2017-10-08', 'aragcar@gmail.com', '954189939', NULL , 1, 1, now());
INSERT INTO usuario VALUES (1, 'admin', '1234', 1 , 1 );
