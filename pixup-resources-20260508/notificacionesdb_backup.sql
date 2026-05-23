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


-- Volcando estructura de base de datos para notificacionesdb
CREATE DATABASE IF NOT EXISTS `notificacionesdb` /*!40100 DEFAULT CHARACTER SET utf8mb3 */;
USE `notificacionesdb`;

-- Volcando estructura para tabla notificacionesdb.notificacion
CREATE TABLE IF NOT EXISTS `notificacion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_notificacion` datetime NOT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  `email` varchar(40) NOT NULL,
  `id_tipo_notificacion` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_TIPO_NOTIFICACION_idx` (`id_tipo_notificacion`),
  CONSTRAINT `FK_TIPO_NOTIFICACION` FOREIGN KEY (`id_tipo_notificacion`) REFERENCES `tipo_notificacion` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla notificacionesdb.notificacion: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `notificacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `notificacion` ENABLE KEYS */;

-- Volcando estructura para tabla notificacionesdb.tipo_notificacion
CREATE TABLE IF NOT EXISTS `tipo_notificacion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(40) NOT NULL,
  `ruta_plantilla` varchar(120) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `descripcion_UNIQUE` (`descripcion`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla notificacionesdb.tipo_notificacion: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `tipo_notificacion` DISABLE KEYS */;
INSERT INTO `tipo_notificacion` (`id`, `descripcion`, `ruta_plantilla`) VALUES
	(1, 'ALTA_USUARIO', 'plantilla_email_alta_usuario.template'),
	(2, 'VENTA', 'plantilla_email_venta.template'),
	(3, 'ENVIO', 'plantilla_email_envio.template');
/*!40000 ALTER TABLE `tipo_notificacion` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
