-- MySQL dump 10.13  Distrib 5.7.20, for Linux (x86_64)
--
-- Host: localhost    Database: campeonato
-- ------------------------------------------------------
-- Server version	5.7.20-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- -----------------------------------------------------
-- Schema campeonato
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `campeonato` ;

-- -----------------------------------------------------
-- Schema campeonato
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `campeonato` DEFAULT CHARACTER SET utf8 ;
USE `campeonato` ;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categoria` (
  `idcategoria` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `fecha_registro` datetime DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  PRIMARY KEY (`idcategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'Juvenil','2017-11-18 14:17:51',1),(2,'Mayores','2017-11-18 14:17:59',1),(4,'Master','2017-11-18 14:18:23',1);
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deuda`
--

DROP TABLE IF EXISTS `deuda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `deuda` (
  `idinscripcion` int(11) NOT NULL,
  `equipo_idequipo` int(11) NOT NULL,
  `evento_idevento` int(11) NOT NULL,
  `observaciones` varchar(120) DEFAULT NULL,
  `valor_couta` decimal(6,2) DEFAULT NULL,
  `fecha_pago` datetime DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  PRIMARY KEY (`idinscripcion`),
  KEY `fk_inscripcion_equipo1_idx` (`equipo_idequipo`),
  KEY `fk_inscripcion_evento1_idx` (`evento_idevento`),
  CONSTRAINT `fk_inscripcion_equipo1` FOREIGN KEY (`equipo_idequipo`) REFERENCES `equipo` (`idequipo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_inscripcion_evento1` FOREIGN KEY (`evento_idevento`) REFERENCES `evento` (`idevento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deuda`
--

LOCK TABLES `deuda` WRITE;
/*!40000 ALTER TABLE `deuda` DISABLE KEYS */;
/*!40000 ALTER TABLE `deuda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `disciplina`
--

DROP TABLE IF EXISTS `disciplina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `disciplina` (
  `iddisciplina` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `fecha_registro` datetime DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  PRIMARY KEY (`iddisciplina`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disciplina`
--

LOCK TABLES `disciplina` WRITE;
/*!40000 ALTER TABLE `disciplina` DISABLE KEYS */;
INSERT INTO `disciplina` VALUES (5,'Futbol','2017-11-18 13:04:08',1),(6,'Voley','2017-11-18 13:04:12',1),(7,'Basquet','2017-11-18 13:04:17',1);
/*!40000 ALTER TABLE `disciplina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipo`
--

DROP TABLE IF EXISTS `equipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipo` (
  `idequipo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `descripcion` text,
  `logo` varchar(200) DEFAULT NULL,
  `color` varchar(50) DEFAULT NULL,
  `idmodalidad` int(11) NOT NULL,
  `iddelegado` int(11) NOT NULL,
  `estado` int(11) NOT NULL,
  `fecha_registro` datetime NOT NULL,
  PRIMARY KEY (`idequipo`),
  KEY `fk_equipo_modalidad_idx` (`idmodalidad`),
  KEY `fk_equipo_persona_idx` (`iddelegado`),
  CONSTRAINT `fk_equipo_modalidad` FOREIGN KEY (`idmodalidad`) REFERENCES `modalidad` (`idmodalidad`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_equipo_persona1` FOREIGN KEY (`iddelegado`) REFERENCES `persona` (`idpersona`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipo`
--

LOCK TABLES `equipo` WRITE;
/*!40000 ALTER TABLE `equipo` DISABLE KEYS */;
INSERT INTO `equipo` VALUES (3,'Los Galacticos','<p>ddfddf</p>\r\n',NULL,'Azul',1,1,1,'2017-11-26 21:06:39');
/*!40000 ALTER TABLE `equipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipo_evento`
--

DROP TABLE IF EXISTS `equipo_evento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipo_evento` (
  `idequipo` int(11) NOT NULL,
  `idevento` int(11) NOT NULL,
  PRIMARY KEY (`idequipo`,`idevento`),
  KEY `fk_equipo_has_evento_evento1_idx` (`idevento`),
  KEY `fk_equipo_has_evento_equipo1_idx` (`idequipo`),
  CONSTRAINT `fk_equipo_has_evento_equipo1` FOREIGN KEY (`idequipo`) REFERENCES `equipo` (`idequipo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_equipo_has_evento_evento1` FOREIGN KEY (`idevento`) REFERENCES `evento` (`idevento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipo_evento`
--

LOCK TABLES `equipo_evento` WRITE;
/*!40000 ALTER TABLE `equipo_evento` DISABLE KEYS */;
INSERT INTO `equipo_evento` VALUES (3,1);
/*!40000 ALTER TABLE `equipo_evento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evento`
--

DROP TABLE IF EXISTS `evento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evento` (
  `idevento` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(250) DEFAULT NULL,
  `descripcion` text,
  `fecha_inicio` datetime DEFAULT NULL,
  `fecha_fin` datetime DEFAULT NULL,
  `modo` int(11) DEFAULT NULL,
  `costo` decimal(6,2) DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  `idlugar` int(11) NOT NULL,
  `fecha_registro` datetime DEFAULT NULL,
  PRIMARY KEY (`idevento`),
  KEY `fk_evento_lugar1_idx` (`idlugar`),
  CONSTRAINT `fk_evento_lugar1` FOREIGN KEY (`idlugar`) REFERENCES `lugar` (`idlugar`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evento`
--

LOCK TABLES `evento` WRITE;
/*!40000 ALTER TABLE `evento` DISABLE KEYS */;
INSERT INTO `evento` VALUES (1,'Encuentro deportivo juvenil 2017','<p>Nunca hab&iacute;a visto algo as&iacute; en m&aacute;s de 20 a&ntilde;os como m&eacute;dico&quot;: el soldado que desert&oacute; de Corea del Norte ten&iacute;a &quot;enormes par&aacute;sitos&quot; en su cuerpo</p>\r\n','2017-11-22 11:47:00','2017-11-25 11:48:00',1,20.00,1,1,'2017-11-21 11:47:34'),(2,'Cibertec Independencia','<p>sdsdsd</p>\r\n','2017-11-30 10:14:00','2017-12-02 10:15:00',1,20.00,1,4,'2017-11-25 10:14:39');
/*!40000 ALTER TABLE `evento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evento_modalidad`
--

DROP TABLE IF EXISTS `evento_modalidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evento_modalidad` (
  `evento_idevento` int(11) NOT NULL,
  `modalidad_idmodalidad` int(11) NOT NULL,
  `tipo_genero` int(11) DEFAULT NULL,
  `cantidad_jugadores` int(11) DEFAULT NULL,
  `num_varones` int(11) DEFAULT NULL,
  `num_mujeres` int(11) DEFAULT NULL,
  PRIMARY KEY (`evento_idevento`,`modalidad_idmodalidad`),
  KEY `fk_evento_has_modalidad_modalidad1_idx` (`modalidad_idmodalidad`),
  KEY `fk_evento_has_modalidad_evento1_idx` (`evento_idevento`),
  CONSTRAINT `fk_evento_has_modalidad_evento1` FOREIGN KEY (`evento_idevento`) REFERENCES `evento` (`idevento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_evento_has_modalidad_modalidad1` FOREIGN KEY (`modalidad_idmodalidad`) REFERENCES `modalidad` (`idmodalidad`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evento_modalidad`
--

LOCK TABLES `evento_modalidad` WRITE;
/*!40000 ALTER TABLE `evento_modalidad` DISABLE KEYS */;
INSERT INTO `evento_modalidad` VALUES (1,1,1,3,3,0),(1,2,2,3,0,3),(2,1,1,3,3,0),(2,3,3,4,2,2);
/*!40000 ALTER TABLE `evento_modalidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `extrafield`
--

DROP TABLE IF EXISTS `extrafield`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `extrafield` (
  `idextrafield` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(100) DEFAULT NULL,
  `field` varchar(100) DEFAULT NULL,
  `valor` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idextrafield`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `extrafield`
--

LOCK TABLES `extrafield` WRITE;
/*!40000 ALTER TABLE `extrafield` DISABLE KEYS */;
INSERT INTO `extrafield` VALUES (1,'documento','1','Documento Nacional de Identidad'),(2,'documento','2','Carnet de Extranjeria'),(3,'documento','3','Registro Unico Contribuyente'),(4,'documento','4','Pasaporte'),(5,'documento','5','Partida de Nacimiento'),(6,'sexo','1','Masculino'),(7,'sexo','2','Femenino'),(8,'genero','1','Varones'),(9,'genero','2','Mujeres'),(10,'genero','3','Mixto');
/*!40000 ALTER TABLE `extrafield` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lugar`
--

DROP TABLE IF EXISTS `lugar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lugar` (
  `idlugar` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(250) DEFAULT NULL,
  `direccion` longtext,
  `latitud` varchar(100) DEFAULT NULL,
  `longitud` varchar(100) DEFAULT NULL,
  `estado` int(11) NOT NULL,
  `fecha_registro` datetime NOT NULL,
  PRIMARY KEY (`idlugar`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lugar`
--

LOCK TABLES `lugar` WRITE;
/*!40000 ALTER TABLE `lugar` DISABLE KEYS */;
INSERT INTO `lugar` VALUES (1,'Estadio de Chancay','1 de Mayo 286, Chancay, Perú','-11.5637441','-77.27325309999998',1,'2017-11-14 22:14:30'),(2,'Universidad Nacional de Ingenieria','Av. Túpac Amaru s/n, Rimac, Lima 25, Perú, Av. Tupac Amaru 210, Rímac Lima 25, Perú','-12.024022','-77.0481441',1,'2017-11-14 22:14:40'),(3,'Estadio Nacional del Perú','Calle José Díaz s/n, Cercado de Lima 15046, Perú','-12.0672896','-77.03372919999998',1,'2017-11-14 22:14:50'),(4,'Cibertec Independencia','Av. Carlos Alberto Izaguirre 233, Independencia 15311, Perú','-11.990168','-77.06103359999997',1,'2017-11-14 22:15:02');
/*!40000 ALTER TABLE `lugar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modalidad`
--

DROP TABLE IF EXISTS `modalidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `modalidad` (
  `idmodalidad` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` text,
  `idcategoria` int(11) NOT NULL,
  `iddisciplina` int(11) NOT NULL,
  `tipo_genero` int(11) DEFAULT NULL,
  `cantidad_jugadores` int(11) DEFAULT NULL,
  `num_varones` int(11) DEFAULT NULL,
  `num_mujeres` int(11) DEFAULT NULL,
  PRIMARY KEY (`idmodalidad`),
  KEY `fk_modalidad_categoria1_idx` (`idcategoria`),
  KEY `fk_modalidad_disciplina1_idx` (`iddisciplina`),
  CONSTRAINT `fk_modalidad_categoria1` FOREIGN KEY (`idcategoria`) REFERENCES `categoria` (`idcategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_modalidad_disciplina1` FOREIGN KEY (`iddisciplina`) REFERENCES `disciplina` (`iddisciplina`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modalidad`
--

LOCK TABLES `modalidad` WRITE;
/*!40000 ALTER TABLE `modalidad` DISABLE KEYS */;
INSERT INTO `modalidad` VALUES (1,'<p>Solo para competici&oacute;n de 3 entre 3 Varones</p>\r\n',1,5,1,3,3,0),(2,'<p>Solo para competici&oacute;n entre 3 y 3 Mujeres</p>\r\n',2,6,2,3,0,3),(3,'<p>dsdds</p>\r\n',2,7,3,4,2,2);
/*!40000 ALTER TABLE `modalidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modulo`
--

DROP TABLE IF EXISTS `modulo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `modulo` (
  `idmodulo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(250) DEFAULT NULL,
  `url` varchar(250) DEFAULT NULL,
  `icon_big` varchar(250) DEFAULT NULL,
  `icon_small` varchar(250) DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  PRIMARY KEY (`idmodulo`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modulo`
--

LOCK TABLES `modulo` WRITE;
/*!40000 ALTER TABLE `modulo` DISABLE KEYS */;
INSERT INTO `modulo` VALUES (1,'Disciplinas','ServletDisciplina?tipo=listar','disciplinas.png','fa-futbol-o',1),(2,'Categorias','ServletCategoria?tipo=listar','categorias.png','fa-folder',1),(3,'Modalidades','ServletModalidad?tipo=listar','modalidades.png','fa-bookmark',1),(4,'Lugares','ServletLugar?tipo=listar','lugares.png','fa-map-marker',1),(5,'Eventos','ServletEvento?tipo=listar','eventos.png','fa-bell',1),(6,'Personas','ServletPersona?tipo=listar','personas.png','fa-user',1),(7,'Equipos','ServletEquipo?tipo=listar','equipos.png','fa-users',1);
/*!40000 ALTER TABLE `modulo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modulo_perfil`
--

DROP TABLE IF EXISTS `modulo_perfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `modulo_perfil` (
  `idmodulo` int(11) NOT NULL,
  `idperfil` int(11) NOT NULL,
  PRIMARY KEY (`idmodulo`,`idperfil`),
  KEY `fk_modulo_has_perfil_perfil1_idx` (`idperfil`),
  KEY `fk_modulo_has_perfil_modulo1_idx` (`idmodulo`),
  CONSTRAINT `fk_modulo_has_perfil_modulo1` FOREIGN KEY (`idmodulo`) REFERENCES `modulo` (`idmodulo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_modulo_has_perfil_perfil1` FOREIGN KEY (`idperfil`) REFERENCES `perfil` (`idperfil`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modulo_perfil`
--

LOCK TABLES `modulo_perfil` WRITE;
/*!40000 ALTER TABLE `modulo_perfil` DISABLE KEYS */;
INSERT INTO `modulo_perfil` VALUES (1,1),(2,1),(3,1),(4,1),(5,1),(6,1),(7,1),(6,2),(7,2);
/*!40000 ALTER TABLE `modulo_perfil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `perfil`
--

DROP TABLE IF EXISTS `perfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `perfil` (
  `idperfil` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idperfil`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perfil`
--

LOCK TABLES `perfil` WRITE;
/*!40000 ALTER TABLE `perfil` DISABLE KEYS */;
INSERT INTO `perfil` VALUES (1,'Administrador'),(2,'Delegado'),(3,'Cajero');
/*!40000 ALTER TABLE `perfil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persona` (
  `idpersona` int(11) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(50) NOT NULL,
  `apaterno` varchar(50) NOT NULL,
  `amaterno` varchar(50) NOT NULL,
  `sexo` char(1) DEFAULT NULL,
  `tipo_documento` int(11) DEFAULT NULL,
  `num_documento` char(8) DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `telefono` char(9) DEFAULT NULL,
  `avatar` varchar(200) DEFAULT NULL,
  `es_usuario` tinyint(1) DEFAULT NULL,
  `estado` int(11) NOT NULL,
  `fecha_registro` datetime NOT NULL,
  PRIMARY KEY (`idpersona`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (1,'ALEX RUBEN','ARAGON','CALIXTO','1',1,'44197172','2017-10-08','aragcar@gmail.com','954189939',NULL,1,1,'2017-11-13 20:12:18'),(2,'ERICK RONALD','ARCE','YUPANQUI','1',1,'44197173','1987-10-04','ercik@gmail.com','950418993','',0,1,'2017-11-21 10:31:57'),(3,'DELIA XIMENA','PORTOCARRERO','FARFAN','2',1,'44197179','1987-10-04','delia@gmail.com','954189939','',0,1,'2017-11-21 10:33:00'),(4,'MIRLEY LINMEY','GONZALES','SANTOS','2',1,'44778855','1900-02-25','mirley@gmail.com','954189939','',0,1,'2017-11-21 10:34:07'),(5,'ALDO SANTIAGO','MALLQUI','CHINCHAY','1',1,'44197175','1987-10-04','aldo@gmail.com','954189939','',0,1,'2017-11-21 10:36:10'),(6,'NELIDA','CORTEZ','ZURITA','2',1,'44331562','1987-10-04','nelida@gmail.com','954189939','',0,1,'2017-11-21 10:42:06'),(7,'REMY','VARGAS','MARAZA','1',1,'42153366','1987-10-04','remy@gmail.com','954189939','',0,1,'2017-11-21 10:42:54'),(8,'DEVORA MIRTHA','DE ACOSTA','GALLARDO','2',1,'44197270','1987-10-04','devora@gmail.com','954189939','',0,1,'2017-11-21 11:37:23'),(9,'RODOLFO','PARI','CHOQUIHUILLCA','1',1,'44157188','1987-10-04','rodolfo@gmail.com','954189939','',0,1,'2017-11-21 11:37:49');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona_equipo`
--

DROP TABLE IF EXISTS `persona_equipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persona_equipo` (
  `idpersona` int(11) NOT NULL,
  `idequipo` int(11) NOT NULL,
  PRIMARY KEY (`idpersona`,`idequipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona_equipo`
--

LOCK TABLES `persona_equipo` WRITE;
/*!40000 ALTER TABLE `persona_equipo` DISABLE KEYS */;
INSERT INTO `persona_equipo` VALUES (2,3),(5,3),(7,3);
/*!40000 ALTER TABLE `persona_equipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `idusuario` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` char(10) NOT NULL,
  `idpersona` int(11) NOT NULL,
  `idperfil` int(11) NOT NULL,
  PRIMARY KEY (`idusuario`),
  KEY `fk_usuario_persona_idx` (`idpersona`),
  KEY `fk_usuario_perfil_idx` (`idperfil`),
  CONSTRAINT `fk_usuario_perfil` FOREIGN KEY (`idperfil`) REFERENCES `perfil` (`idperfil`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_persona` FOREIGN KEY (`idpersona`) REFERENCES `persona` (`idpersona`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'admin','1234',1,1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-27  2:14:20
