-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 04-08-2013 a las 18:15:56
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
CREATE DATABASE IF NOT EXISTS `parroquia` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci;
USE `parroquia`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `certificado`
--

CREATE TABLE IF NOT EXISTS `certificado` (
  `numeroCertificado` int(11) NOT NULL AUTO_INCREMENT,
  `idAhijado` int(11) DEFAULT NULL,
  `idTutora` int(11) DEFAULT NULL,
  `idTutor` int(11) DEFAULT NULL,
  `idMadrina` int(11) DEFAULT NULL,
  `idPadrino` int(11) DEFAULT NULL,
  `nombreCura` varchar(45) DEFAULT NULL,
  `libro` varchar(10) DEFAULT NULL,
  `folio` varchar(10) DEFAULT NULL,
  `partida` varchar(45) DEFAULT NULL,
  `fechaBautizmo` date DEFAULT NULL,
  `domicilioPadres` varchar(45) DEFAULT NULL,
  `notasMarginales` varchar(100) DEFAULT NULL,
  `ciudad` varchar(45) DEFAULT NULL,
  `provincia` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`numeroCertificado`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE IF NOT EXISTS `persona` (
  `idPersona` int(11) NOT NULL AUTO_INCREMENT,
  `dni` varchar(10) NOT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `sexo` varchar(12) NOT NULL,
  `fechaNaciemiento` date DEFAULT NULL,
  `lugarNacimiento` varchar(45) DEFAULT NULL,
  `provNacimiento` varchar(45) DEFAULT NULL,
  `nacionalidad` varchar(20) DEFAULT NULL,
  `hijoDe` varchar(45) DEFAULT NULL,
  `domicilio` varchar(45) DEFAULT NULL,
  `barrio` varchar(45) DEFAULT NULL,
  `telefonoFijo` varchar(45) DEFAULT NULL,
  `telefonoCelular` varchar(45) DEFAULT NULL,
  `tipoDeHijo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idPersona`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=14 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
