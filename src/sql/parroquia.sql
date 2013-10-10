-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 10-10-2013 a las 17:05:06
-- Versión del servidor: 5.5.32
-- Versión de PHP: 5.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `parroquia`
--
CREATE DATABASE IF NOT EXISTS `parroquia` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `parroquia`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `certificado`
--

CREATE TABLE IF NOT EXISTS `certificado` (
  `numeroCertificado` int(11) NOT NULL AUTO_INCREMENT,
  `idAhijado` int(11) NOT NULL,
  `idTutora` int(11) NOT NULL,
  `idTutor` int(11) NOT NULL,
  `idMadrina` int(11) NOT NULL,
  `idPadrino` int(11) NOT NULL,
  `nombreCura` varchar(45) NOT NULL,
  `libro` varchar(10) NOT NULL,
  `folio` varchar(10) NOT NULL,
  `partida` varchar(45) NOT NULL,
  `fechaBautizmo` date NOT NULL,
  `domicilioPadres` varchar(45) NOT NULL,
  `notasMarginales` varchar(100) NOT NULL,
  `ciudad` varchar(45) NOT NULL,
  `provincia` varchar(45) NOT NULL,
  PRIMARY KEY (`numeroCertificado`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `certificado`
--

INSERT INTO `certificado` (`numeroCertificado`, `idAhijado`, `idTutora`, `idTutor`, `idMadrina`, `idPadrino`, `nombreCura`, `libro`, `folio`, `partida`, `fechaBautizmo`, `domicilioPadres`, `notasMarginales`, `ciudad`, `provincia`) VALUES
(1, 1, 1, 1, 1, 1, 'APELLIDO  NOMBRE', '', '', '', '2013-10-10', '', 'no es necesario este campo', 'SAN SALVADOR DE JUJUY', 'Jujuy');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `parroquia`
--

CREATE TABLE IF NOT EXISTS `parroquia` (
  `idParroquia` int(11) NOT NULL AUTO_INCREMENT,
  `nombreParroquia` varchar(50) NOT NULL,
  `apellidoCura` varchar(45) DEFAULT NULL,
  `nombreCura` varchar(45) DEFAULT NULL,
  `ciudadParroquia` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idParroquia`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

--
-- Volcado de datos para la tabla `parroquia`
--

INSERT INTO `parroquia` (`idParroquia`, `nombreParroquia`, `apellidoCura`, `nombreCura`, `ciudadParroquia`) VALUES
(8, 'SAN PEDRO Y SAN PABLO', 'APELLIDO ', 'NOMBRE', 'SAN SALVADOR DE JUJUY');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE IF NOT EXISTS `persona` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dni` int(8) NOT NULL DEFAULT '0',
  `apellido` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `sexo` varchar(12) NOT NULL,
  `fechaNaciemiento` date NOT NULL,
  `lugarNacimiento` varchar(45) NOT NULL,
  `provNacimiento` varchar(45) NOT NULL,
  `nacionalidad` varchar(20) NOT NULL,
  `hijoDe` varchar(45) DEFAULT '-',
  `domicilio` varchar(45) DEFAULT '-',
  `barrio` varchar(45) DEFAULT '-',
  `telefonoFijo` varchar(45) DEFAULT '-',
  `telefonoCelular` varchar(45) DEFAULT '-',
  `tipoDeHijo` varchar(45) DEFAULT '-',
  PRIMARY KEY (`id`),
  UNIQUE KEY `dni` (`dni`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`id`, `dni`, `apellido`, `nombre`, `sexo`, `fechaNaciemiento`, `lugarNacimiento`, `provNacimiento`, `nacionalidad`, `hijoDe`, `domicilio`, `barrio`, `telefonoFijo`, `telefonoCelular`, `tipoDeHijo`) VALUES
(1, 31463646, 'ARAMAYO', 'VANESA ANAHI', 'Femenino', '1985-04-28', 'SAN SALVADOR DE JUJUY', 'Jujuy', 'ARGENTINA', NULL, 'PJE 155', 'CORONEL ARIAS', '4310218', '154091562', 'Legitimo');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
