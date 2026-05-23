-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.7.3-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para pixupdb
CREATE DATABASE IF NOT EXISTS `pixupdb` /*!40100 DEFAULT CHARACTER SET utf8mb3 */;
USE `pixupdb`;

-- Volcando estructura para tabla pixupdb.artista
CREATE TABLE IF NOT EXISTS `artista` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla pixupdb.artista: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `artista` DISABLE KEYS */;
INSERT INTO `artista` (`id`, `nombre`) VALUES
	(2, 'Guns and Roses'),
	(1, 'Metallica');
/*!40000 ALTER TABLE `artista` ENABLE KEYS */;

-- Volcando estructura para tabla pixupdb.cancion
CREATE TABLE IF NOT EXISTS `cancion` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `titulo` varchar(100) NOT NULL,
  `duracion` time NOT NULL,
  `id_disco` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `titulo` (`titulo`),
  KEY `cancion_ibfk_1` (`id_disco`),
  CONSTRAINT `cancion_ibfk_1` FOREIGN KEY (`id_disco`) REFERENCES `disco` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla pixupdb.cancion: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `cancion` DISABLE KEYS */;
/*!40000 ALTER TABLE `cancion` ENABLE KEYS */;

-- Volcando estructura para tabla pixupdb.colonia
CREATE TABLE IF NOT EXISTS `colonia` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `cp` char(5) NOT NULL,
  `id_municipio` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre` (`nombre`,`cp`),
  KEY `id_municipio` (`id_municipio`),
  KEY `cp` (`cp`),
  CONSTRAINT `colonia_ibfk_1` FOREIGN KEY (`id_municipio`) REFERENCES `municipio` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla pixupdb.colonia: ~7 rows (aproximadamente)
/*!40000 ALTER TABLE `colonia` DISABLE KEYS */;
INSERT INTO `colonia` (`id`, `nombre`, `cp`, `id_municipio`) VALUES
	(1, 'Santa María la Ribera', '06400', 2),
	(2, 'San Rafael', '06400', 2),
	(3, 'Guerrero', '06300', 2),
	(4, 'Anáhuac', '11320', 1),
	(5, 'Lomas de Chapultepec I Sección', '11000', 1),
	(6, 'Lomas de Chapultepec II Sección', '11000', 1),
	(7, 'Lomas de Chapultepec III Sección', '11000', 1);
/*!40000 ALTER TABLE `colonia` ENABLE KEYS */;

-- Volcando estructura para tabla pixupdb.detalle_orden
CREATE TABLE IF NOT EXISTS `detalle_orden` (
  `id_disco` int(10) unsigned NOT NULL,
  `id_orden` int(10) unsigned NOT NULL,
  `cantidad` int(10) unsigned NOT NULL,
  `costo` float(9,2) NOT NULL,
  PRIMARY KEY (`id_orden`,`id_disco`),
  KEY `detalle_orden_ibfk_1` (`id_disco`),
  CONSTRAINT `detalle_orden_ibfk_1` FOREIGN KEY (`id_disco`) REFERENCES `disco` (`id`),
  CONSTRAINT `detalle_orden_ibfk_2` FOREIGN KEY (`id_orden`) REFERENCES `orden` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla pixupdb.detalle_orden: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `detalle_orden` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle_orden` ENABLE KEYS */;

-- Volcando estructura para tabla pixupdb.disco
CREATE TABLE IF NOT EXISTS `disco` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `titulo` varchar(100) NOT NULL,
  `precio` float(5,2) NOT NULL,
  `existencia` int(10) unsigned NOT NULL DEFAULT 0,
  `descuento` float(5,2) NOT NULL DEFAULT 0.00,
  `fecha_lanzamiento` date NOT NULL,
  `imagen` varchar(120) NOT NULL,
  `id_disquera` int(10) unsigned NOT NULL,
  `id_artista` int(10) unsigned NOT NULL,
  `id_genero_musical` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_artista` (`id_artista`,`titulo`),
  UNIQUE KEY `imagen` (`imagen`),
  KEY `id_disquera` (`id_disquera`),
  KEY `id_genero` (`id_genero_musical`),
  KEY `titulo` (`titulo`),
  CONSTRAINT `disco_ibfk_1` FOREIGN KEY (`id_disquera`) REFERENCES `disquera` (`id`),
  CONSTRAINT `disco_ibfk_2` FOREIGN KEY (`id_artista`) REFERENCES `artista` (`id`),
  CONSTRAINT `disco_ibfk_3` FOREIGN KEY (`id_genero_musical`) REFERENCES `genero_musical` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla pixupdb.disco: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `disco` DISABLE KEYS */;
/*!40000 ALTER TABLE `disco` ENABLE KEYS */;

-- Volcando estructura para tabla pixupdb.disquera
CREATE TABLE IF NOT EXISTS `disquera` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(60) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla pixupdb.disquera: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `disquera` DISABLE KEYS */;
INSERT INTO `disquera` (`id`, `nombre`) VALUES
	(3, 'BMG'),
	(1, 'MGM ESTUDIO'),
	(2, 'WARNER BROS');
/*!40000 ALTER TABLE `disquera` ENABLE KEYS */;

-- Volcando estructura para tabla pixupdb.domicilio
CREATE TABLE IF NOT EXISTS `domicilio` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `calle` varchar(60) NOT NULL,
  `num_exterior` varchar(30) NOT NULL,
  `num_interior` varchar(30) DEFAULT NULL,
  `id_usuario` int(10) unsigned NOT NULL,
  `id_colonia` int(10) unsigned NOT NULL,
  `id_tipo_domicilio` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_usuario` (`id_usuario`,`id_tipo_domicilio`),
  KEY `id_colonia` (`id_colonia`),
  KEY `id_tipo_domicilio` (`id_tipo_domicilio`),
  CONSTRAINT `domicilio_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`) ON DELETE CASCADE,
  CONSTRAINT `domicilio_ibfk_2` FOREIGN KEY (`id_colonia`) REFERENCES `colonia` (`id`),
  CONSTRAINT `domicilio_ibfk_3` FOREIGN KEY (`id_tipo_domicilio`) REFERENCES `tipo_domicilio` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla pixupdb.domicilio: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `domicilio` DISABLE KEYS */;
/*!40000 ALTER TABLE `domicilio` ENABLE KEYS */;

-- Volcando estructura para tabla pixupdb.estado
CREATE TABLE IF NOT EXISTS `estado` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla pixupdb.estado: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `estado` DISABLE KEYS */;
INSERT INTO `estado` (`id`, `nombre`) VALUES
	(1, 'CIUDAD DE MÉXICO');
/*!40000 ALTER TABLE `estado` ENABLE KEYS */;

-- Volcando estructura para tabla pixupdb.genero_musical
CREATE TABLE IF NOT EXISTS `genero_musical` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `descripcion` (`descripcion`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla pixupdb.genero_musical: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `genero_musical` DISABLE KEYS */;
INSERT INTO `genero_musical` (`id`, `descripcion`) VALUES
	(2, 'Pop'),
	(1, 'Rock');
/*!40000 ALTER TABLE `genero_musical` ENABLE KEYS */;

-- Volcando estructura para tabla pixupdb.municipio
CREATE TABLE IF NOT EXISTS `municipio` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `id_estado` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre` (`nombre`,`id_estado`),
  KEY `id_estado` (`id_estado`),
  CONSTRAINT `municipio_ibfk_1` FOREIGN KEY (`id_estado`) REFERENCES `estado` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla pixupdb.municipio: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `municipio` DISABLE KEYS */;
INSERT INTO `municipio` (`id`, `nombre`, `id_estado`) VALUES
	(2, 'Cuauhtémoc', 1),
	(1, 'Miguel Hidalgo', 1);
/*!40000 ALTER TABLE `municipio` ENABLE KEYS */;

-- Volcando estructura para tabla pixupdb.orden
CREATE TABLE IF NOT EXISTS `orden` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `costo_total` float(9,2) NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `cantidad_total` int(10) unsigned NOT NULL,
  `estatus_envio` tinyint(1) NOT NULL DEFAULT 0,
  `costo_envio` float(5,2) NOT NULL DEFAULT 0.00,
  `id_usuario` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `costo_total` (`costo_total`,`fecha`,`id_usuario`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `orden_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla pixupdb.orden: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `orden` DISABLE KEYS */;
/*!40000 ALTER TABLE `orden` ENABLE KEYS */;

-- Volcando estructura para tabla pixupdb.pago
CREATE TABLE IF NOT EXISTS `pago` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `numero_tarjeta` char(4) NOT NULL,
  `monto` float(9,2) NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `id_orden` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_orden_UNIQUE` (`id_orden`),
  KEY `fecha` (`fecha`),
  CONSTRAINT `orden_pago_ibfk_1` FOREIGN KEY (`id_orden`) REFERENCES `orden` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla pixupdb.pago: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `pago` DISABLE KEYS */;
/*!40000 ALTER TABLE `pago` ENABLE KEYS */;

-- Volcando estructura para tabla pixupdb.tipo_domicilio
CREATE TABLE IF NOT EXISTS `tipo_domicilio` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `descripcion` (`descripcion`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla pixupdb.tipo_domicilio: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `tipo_domicilio` DISABLE KEYS */;
INSERT INTO `tipo_domicilio` (`id`, `descripcion`) VALUES
	(1, 'Entrega'),
	(2, 'Facturacion');
/*!40000 ALTER TABLE `tipo_domicilio` ENABLE KEYS */;

-- Volcando estructura para tabla pixupdb.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(40) NOT NULL,
  `primer_apellido` varchar(40) NOT NULL,
  `segundo_apellido` varchar(40) DEFAULT NULL,
  `password` char(150) NOT NULL,
  `email` varchar(40) NOT NULL,
  `rfc` varchar(13) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla pixupdb.usuario: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
