-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3308
-- Tiempo de generación: 06-09-2022 a las 01:13:55
-- Versión del servidor: 8.0.18
-- Versión de PHP: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `o29consultorio_veterinario14`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asinar`
--

DROP TABLE IF EXISTS `asinar`;
CREATE TABLE IF NOT EXISTS `asinar` (
  `id_asignar` int(11) NOT NULL AUTO_INCREMENT,
  `cedula_medicofk` int(11) DEFAULT NULL,
  `cedula_cuidadorfk` int(11) DEFAULT NULL,
  `id_consultorio_asignar` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_asignar`),
  KEY `FKopi4uopqqfqxg7crdhau24cy6` (`cedula_medicofk`),
  KEY `FKkebc8mwx5mhybqjm5tmtbmxlt` (`cedula_cuidadorfk`),
  KEY `FKevra7tyt1sj9e5nu4s0dtf2xk` (`id_consultorio_asignar`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cita`
--

DROP TABLE IF EXISTS `cita`;
CREATE TABLE IF NOT EXISTS `cita` (
  `idcita` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_cita` varchar(20) DEFAULT NULL,
  `hora_cita` varchar(20) DEFAULT NULL,
  `pago_cita` float DEFAULT NULL,
  `cedula_cuidador` int(11) DEFAULT NULL,
  `id_consultoriofk` int(11) DEFAULT NULL,
  PRIMARY KEY (`idcita`),
  UNIQUE KEY `UK_hxdhpqadr7p6yxofpu94mb1j3` (`cedula_cuidador`),
  UNIQUE KEY `UK_addh971t9i3rte96e3obt0ben` (`id_consultoriofk`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `consutorios`
--

DROP TABLE IF EXISTS `consutorios`;
CREATE TABLE IF NOT EXISTS `consutorios` (
  `id_consultorio` int(11) NOT NULL,
  `calle_consultorio` varchar(20) DEFAULT NULL,
  `carrera_consultorio` varchar(20) DEFAULT NULL,
  `detalle_consultorio` varchar(20) DEFAULT NULL,
  `numero_consultorio` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_consultorio`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuidadores`
--

DROP TABLE IF EXISTS `cuidadores`;
CREATE TABLE IF NOT EXISTS `cuidadores` (
  `cedula` int(11) NOT NULL,
  `apellido` varchar(20) DEFAULT NULL,
  `calle` varchar(20) DEFAULT NULL,
  `carrera` varchar(20) DEFAULT NULL,
  `detalle` varchar(20) NOT NULL,
  `nombre_paciente` varchar(20) DEFAULT NULL,
  `numero` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`cedula`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medicos`
--

DROP TABLE IF EXISTS `medicos`;
CREATE TABLE IF NOT EXISTS `medicos` (
  `cedula_medico` int(11) NOT NULL,
  `apellido_medico` varchar(20) DEFAULT NULL,
  `correo_medico` varchar(20) DEFAULT NULL,
  `especialidad` varchar(20) DEFAULT NULL,
  `nombre_medico` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`cedula_medico`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pacientes`
--

DROP TABLE IF EXISTS `pacientes`;
CREATE TABLE IF NOT EXISTS `pacientes` (
  `id_paciente` int(11) NOT NULL AUTO_INCREMENT,
  `color` varchar(20) NOT NULL,
  `edad` varchar(20) NOT NULL,
  `especie` varchar(20) NOT NULL,
  `raza` varchar(20) NOT NULL,
  `cedulafk` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_paciente`),
  KEY `FKkwwhokg7e7m8iwlv5dmq8s981` (`cedulafk`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
