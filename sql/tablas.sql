-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.6.5-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para flores
CREATE DATABASE IF NOT EXISTS `flores` /*!40100 DEFAULT CHARACTER SET utf8mb3 */;
USE `flores`;

-- Volcando estructura para tabla flores.clientes
CREATE TABLE IF NOT EXISTS `clientes` (
  `IdCliente` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(50) NOT NULL,
  `Apellidos` varchar(50) DEFAULT NULL,
  `Telefono` varchar(11) DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  `Telefono 2` varchar(11) DEFAULT NULL,
  `Direccion entrega` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`IdCliente`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

-- Volcando datos para la tabla flores.clientes: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` (`IdCliente`, `Nombre`, `Apellidos`, `Telefono`, `email`, `Telefono 2`, `Direccion entrega`) VALUES
	(1, 'Manuel', 'Lopez', '925778899', 'sin email', NULL, 'Calle Tolosa, 3 Santa Cruz'),
	(2, 'Karl', 'Max', '925776431', 'sin', NULL, 'Calle Tui');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;

-- Volcando estructura para tabla flores.composiciones
CREATE TABLE IF NOT EXISTS `composiciones` (
  `idComposicion` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(50) NOT NULL,
  `FechaAlta` date NOT NULL DEFAULT current_timestamp(),
  `Observaciones` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idComposicion`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

-- Volcando datos para la tabla flores.composiciones: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `composiciones` DISABLE KEYS */;
INSERT INTO `composiciones` (`idComposicion`, `Nombre`, `FechaAlta`, `Observaciones`) VALUES
	(1, 'Fantasía ilusión', '2022-06-20', 'Ninguna'),
	(2, 'Recuerdos coloridos', '2022-06-21', 'Con verde oliva');
/*!40000 ALTER TABLE `composiciones` ENABLE KEYS */;

-- Volcando estructura para tabla flores.encargoflor
CREATE TABLE IF NOT EXISTS `encargoflor` (
  `idEncargo` int(11) NOT NULL,
  `idFlor` int(11) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  PRIMARY KEY (`idEncargo`,`idFlor`),
  KEY `FK__flores` (`idFlor`),
  CONSTRAINT `FK__encargos` FOREIGN KEY (`idEncargo`) REFERENCES `encargos` (`idEncargo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK__flores` FOREIGN KEY (`idFlor`) REFERENCES `flores` (`idFlor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Volcando datos para la tabla flores.encargoflor: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `encargoflor` DISABLE KEYS */;
INSERT INTO `encargoflor` (`idEncargo`, `idFlor`, `Cantidad`) VALUES
	(5, 1, 2),
	(5, 2, 1),
	(5, 3, 4),
	(5, 4, 7),
	(6, 1, 7),
	(6, 2, 4),
	(6, 3, 3),
	(6, 4, 6),
	(8, 1, 1),
	(8, 2, 1),
	(8, 3, 1),
	(8, 4, 1);
/*!40000 ALTER TABLE `encargoflor` ENABLE KEYS */;

-- Volcando estructura para tabla flores.encargos
CREATE TABLE IF NOT EXISTS `encargos` (
  `idEncargo` int(11) NOT NULL AUTO_INCREMENT,
  `idCliente` int(11) DEFAULT 0,
  `NombreComposicion` varchar(150) NOT NULL DEFAULT '0',
  `FechaAlta` datetime NOT NULL DEFAULT current_timestamp(),
  `FechaEntrega` datetime NOT NULL,
  `Estado` varchar(50) DEFAULT '',
  PRIMARY KEY (`idEncargo`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;

-- Volcando datos para la tabla flores.encargos: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `encargos` DISABLE KEYS */;
INSERT INTO `encargos` (`idEncargo`, `idCliente`, `NombreComposicion`, `FechaAlta`, `FechaEntrega`, `Estado`) VALUES
	(3, 0, 'Prueba 14', '2022-07-12 09:22:08', '2022-07-18 00:00:00', 'Pendiente'),
	(4, 1, 'Prueba5', '2022-07-12 09:25:11', '2022-07-18 00:00:00', 'Pendiente'),
	(5, 1, 'Cosas', '2022-07-12 09:26:51', '2022-07-19 00:00:00', 'Hecho'),
	(6, 0, 'Nuevo encargo', '2022-07-12 14:24:37', '2022-07-14 00:00:00', 'Pendiente'),
	(7, 0, 'Fantasía ilusión', '2022-07-12 14:59:45', '2022-07-31 00:00:00', 'Pendiente'),
	(8, 2, 'Recuerdos coloridos', '2022-07-12 15:05:05', '2022-07-31 00:00:00', 'Pendiente');
/*!40000 ALTER TABLE `encargos` ENABLE KEYS */;

-- Volcando estructura para tabla flores.estadosencargos
CREATE TABLE IF NOT EXISTS `estadosencargos` (
  `Nombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Volcando datos para la tabla flores.estadosencargos: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `estadosencargos` DISABLE KEYS */;
INSERT INTO `estadosencargos` (`Nombre`) VALUES
	('Pendiente'),
	('En proceso'),
	('Entregado');
/*!40000 ALTER TABLE `estadosencargos` ENABLE KEYS */;

-- Volcando estructura para tabla flores.familias
CREATE TABLE IF NOT EXISTS `familias` (
  `idFamilia` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(50) NOT NULL DEFAULT '0',
  `Duracion` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`idFamilia`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

-- Volcando datos para la tabla flores.familias: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `familias` DISABLE KEYS */;
INSERT INTO `familias` (`idFamilia`, `Nombre`, `Duracion`) VALUES
	(1, 'Rosa', 14),
	(2, 'Clavel', 25);
/*!40000 ALTER TABLE `familias` ENABLE KEYS */;

-- Volcando estructura para tabla flores.flores
CREATE TABLE IF NOT EXISTS `flores` (
  `idFlor` int(11) NOT NULL AUTO_INCREMENT,
  `idFamilia` int(11) NOT NULL DEFAULT 0,
  `Nombre` varchar(50) NOT NULL,
  `Duracion` int(11) NOT NULL DEFAULT 0 COMMENT 'Duracion media en días para calcular la caducidad',
  `Color` varchar(50) NOT NULL DEFAULT '0',
  `CantMinima` int(11) NOT NULL DEFAULT 0 COMMENT 'Cantidad mínima que queremos en el almacen',
  `CantidadAlmacen` int(11) NOT NULL DEFAULT 0 COMMENT 'Cantidad que realmente tenemos en el almacen',
  PRIMARY KEY (`idFlor`),
  KEY `FK1 Flor Familia` (`idFamilia`),
  CONSTRAINT `FK1 Flor Familia` FOREIGN KEY (`idFamilia`) REFERENCES `familias` (`idFamilia`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

-- Volcando datos para la tabla flores.flores: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `flores` DISABLE KEYS */;
INSERT INTO `flores` (`idFlor`, `idFamilia`, `Nombre`, `Duracion`, `Color`, `CantMinima`, `CantidadAlmacen`) VALUES
	(1, 2, 'Clavel Rosa', 24, 'Rosa\r\n', 15, 100),
	(2, 2, 'Clavel Rojo', 24, 'Rojo', 10, 25),
	(3, 1, 'Rosa blanca', 14, 'Blanco', 10, 20),
	(4, 1, 'Rosa Larga', 20, 'Negro', 0, 12);
/*!40000 ALTER TABLE `flores` ENABLE KEYS */;

-- Volcando estructura para tabla flores.florescomposicion
CREATE TABLE IF NOT EXISTS `florescomposicion` (
  `idComposicion` int(11) NOT NULL,
  `idFlor` int(11) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  PRIMARY KEY (`idComposicion`,`idFlor`),
  KEY `FK_florescomposicion_flores` (`idFlor`),
  CONSTRAINT `FK_florescomposicion_composicion` FOREIGN KEY (`idComposicion`) REFERENCES `composiciones` (`idComposicion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_florescomposicion_flores` FOREIGN KEY (`idFlor`) REFERENCES `flores` (`idFlor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='Relaciona las composiciones con lo que tiene la composicion o ramo';

-- Volcando datos para la tabla flores.florescomposicion: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `florescomposicion` DISABLE KEYS */;
INSERT INTO `florescomposicion` (`idComposicion`, `idFlor`, `Cantidad`) VALUES
	(1, 1, 6),
	(1, 2, 3),
	(2, 1, 1),
	(2, 3, 3),
	(2, 4, 6);
/*!40000 ALTER TABLE `florescomposicion` ENABLE KEYS */;

-- Volcando estructura para tabla flores.usuarios
CREATE TABLE IF NOT EXISTS `usuarios` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `user` varchar(50) NOT NULL,
  `password` varchar(65) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Apellidos` varchar(50) NOT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `user` (`user`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

-- Volcando datos para la tabla flores.usuarios: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` (`userId`, `user`, `password`, `Nombre`, `Apellidos`) VALUES
	(1, 'sergio', '70b09981842b8fc9371b143903eb3e90a7a2a48c8c2ecd8c3c6fdc09c3e48e45', 'Sergio', 'Sanchez Alvarez');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
