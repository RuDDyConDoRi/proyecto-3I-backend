-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-07-2018 a las 02:14:47
-- Versión del servidor: 5.6.20
-- Versión de PHP: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `plaproc`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `actoprocesal`
--

CREATE TABLE IF NOT EXISTS `actoprocesal` (
  `codAct` varchar(5) NOT NULL DEFAULT '',
  `nombre` varchar(300) DEFAULT NULL,
  `descr` varchar(300) DEFAULT NULL,
  `nroPie` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `articulo`
--

CREATE TABLE IF NOT EXISTS `articulo` (
  `codArt` varchar(5) NOT NULL DEFAULT '',
  `nombre` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `caso`
--

CREATE TABLE IF NOT EXISTS `caso` (
  `codCas` varchar(15) NOT NULL DEFAULT '',
  `codDte` varchar(5) DEFAULT NULL,
  `codDdo` varchar(5) DEFAULT NULL,
  `delito` varchar(100) DEFAULT NULL,
  `nroArt` int(11) DEFAULT NULL,
  `fechaIni` datetime DEFAULT NULL,
  `fechaFin` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `caso`
--

INSERT INTO `caso` (`codCas`, `codDte`, `codDdo`, `delito`, `nroArt`, `fechaIni`, `fechaFin`) VALUES
('001', '001', '002', 'Un Delito', 1, '2018-07-09 00:00:00', '2018-07-15 00:00:00'),
('002', '002', '001', 'Repuesta al delito', 2, '2018-07-15 00:00:00', '2018-07-15 00:00:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `casoagra`
--

CREATE TABLE IF NOT EXISTS `casoagra` (
  `codCas` varchar(15) NOT NULL DEFAULT '',
  `codDdo` varchar(5) NOT NULL DEFAULT '',
  `agravante` varchar(50) DEFAULT NULL,
  `valoracion` int(11) DEFAULT NULL,
  `tiempo` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cierre`
--

CREATE TABLE IF NOT EXISTS `cierre` (
  `nroCie` int(11) NOT NULL DEFAULT '0',
  `codCas` varchar(15) DEFAULT NULL,
  `nroArt` int(11) DEFAULT NULL,
  `motivo` varchar(100) DEFAULT NULL,
  `fechaIngresoDoc` datetime DEFAULT NULL,
  `fechaEmiRes` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `conclusion`
--

CREATE TABLE IF NOT EXISTS `conclusion` (
  `codCas` varchar(15) NOT NULL DEFAULT '',
  `tipoResol` varchar(50) DEFAULT NULL,
  `accion` varchar(50) DEFAULT NULL,
  `fechaIngresoDoc` datetime DEFAULT NULL,
  `fechaEmiRes` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `continuacion`
--

CREATE TABLE IF NOT EXISTS `continuacion` (
  `codCas` varchar(15) NOT NULL DEFAULT '',
  `tipoResol` varchar(50) DEFAULT NULL,
  `accion` varchar(50) DEFAULT NULL,
  `fechaIngresoDoc` datetime DEFAULT NULL,
  `fechaEmiRes` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `designainvcaso`
--

CREATE TABLE IF NOT EXISTS `designainvcaso` (
  `nroDes` int(11) NOT NULL DEFAULT '0',
  `codCas` varchar(15) DEFAULT NULL,
  `codInv` varchar(5) DEFAULT NULL,
  `fechaIni` datetime DEFAULT NULL,
  `fechaFin` datetime DEFAULT NULL,
  `accion` varchar(30) DEFAULT NULL,
  `tipoRes` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `eleconviccioncierre`
--

CREATE TABLE IF NOT EXISTS `eleconviccioncierre` (
  `codCas` varchar(15) NOT NULL DEFAULT '',
  `nro` int(11) NOT NULL DEFAULT '0',
  `nroPie` int(11) DEFAULT NULL,
  `valoracion` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `eleconviccionconclusion`
--

CREATE TABLE IF NOT EXISTS `eleconviccionconclusion` (
  `codCas` varchar(15) NOT NULL DEFAULT '',
  `nro` int(11) NOT NULL DEFAULT '0',
  `nroPie` int(11) DEFAULT NULL,
  `valoracion` int(11) DEFAULT NULL,
  `fechaIngresoDoc` datetime DEFAULT NULL,
  `fechaEmiRes` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `eleconviccioncontinuacion`
--

CREATE TABLE IF NOT EXISTS `eleconviccioncontinuacion` (
  `codCas` varchar(5) NOT NULL DEFAULT '',
  `nro` int(11) NOT NULL DEFAULT '0',
  `nroPie` int(11) DEFAULT NULL,
  `valoracion` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `elementotipo`
--

CREATE TABLE IF NOT EXISTS `elementotipo` (
  `nroEle` int(11) NOT NULL DEFAULT '0',
  `codArt` varchar(5) DEFAULT NULL,
  `nro` int(11) DEFAULT NULL,
  `elemento` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `fuente`
--

CREATE TABLE IF NOT EXISTS `fuente` (
  `nroFue` int(11) NOT NULL DEFAULT '0',
  `nombre` varchar(100) DEFAULT NULL,
  `descr` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hechocaso`
--

CREATE TABLE IF NOT EXISTS `hechocaso` (
  `codCas` varchar(15) NOT NULL DEFAULT '',
  `nro` int(11) NOT NULL DEFAULT '0',
  `hecho` varchar(50) DEFAULT NULL,
  `nroEle` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `investigador`
--

CREATE TABLE IF NOT EXISTS `investigador` (
  `codInv` varchar(5) NOT NULL DEFAULT '',
  `nombre` varchar(15) DEFAULT NULL,
  `paterno` varchar(15) DEFAULT NULL,
  `materno` varchar(15) DEFAULT NULL,
  `grado` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE IF NOT EXISTS `persona` (
  `codPer` varchar(5) NOT NULL DEFAULT '',
  `paterno` varchar(15) DEFAULT NULL,
  `nombre` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`codPer`, `paterno`, `nombre`) VALUES
('001', 'Usuario', 'Uno'),
('002', 'Usuario', 'Dos');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `piezaprocesal`
--

CREATE TABLE IF NOT EXISTS `piezaprocesal` (
  `nroPie` int(11) NOT NULL DEFAULT '0',
  `nombre` varchar(100) DEFAULT NULL,
  `descr` varchar(200) DEFAULT NULL,
  `nroFuente` int(11) DEFAULT NULL,
  `documento` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `plazoprocesal`
--

CREATE TABLE IF NOT EXISTS `plazoprocesal` (
  `nroPlz` int(11) NOT NULL DEFAULT '0',
  `codIniAct` varchar(5) DEFAULT NULL,
  `codFinAct` varchar(5) DEFAULT NULL,
  `tiempo` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prueba`
--

CREATE TABLE IF NOT EXISTS `prueba` (
  `codCas` varchar(15) NOT NULL DEFAULT '',
  `codPie` int(11) NOT NULL DEFAULT '0',
  `nroPru` int(11) DEFAULT NULL,
  `valoracion` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `revcuadernoinv`
--

CREATE TABLE IF NOT EXISTS `revcuadernoinv` (
  `codCas` varchar(15) NOT NULL DEFAULT '',
  `nro` int(11) NOT NULL DEFAULT '0',
  `nroPie` int(11) DEFAULT NULL,
  `valoracion` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `revexpediente`
--

CREATE TABLE IF NOT EXISTS `revexpediente` (
  `codCas` varchar(15) NOT NULL DEFAULT '',
  `nro` int(11) NOT NULL DEFAULT '0',
  `nroPie` int(11) DEFAULT NULL,
  `valoracion` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `solfiscalia`
--

CREATE TABLE IF NOT EXISTS `solfiscalia` (
  `codCas` varchar(15) NOT NULL DEFAULT '',
  `tipoResol` varchar(50) DEFAULT NULL,
  `fechaIngresoDoc` datetime DEFAULT NULL,
  `fechaEmiRes` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `soljuzgado`
--

CREATE TABLE IF NOT EXISTS `soljuzgado` (
  `codCas` varchar(15) NOT NULL DEFAULT '',
  `tipoResol` varchar(50) DEFAULT NULL,
  `fechaIngresoDoc` datetime DEFAULT NULL,
  `fechaEmiRes` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `actoprocesal`
--
ALTER TABLE `actoprocesal`
 ADD PRIMARY KEY (`codAct`), ADD KEY `nroPie` (`nroPie`);

--
-- Indices de la tabla `articulo`
--
ALTER TABLE `articulo`
 ADD PRIMARY KEY (`codArt`);

--
-- Indices de la tabla `caso`
--
ALTER TABLE `caso`
 ADD PRIMARY KEY (`codCas`), ADD KEY `codDte` (`codDte`), ADD KEY `codDdo` (`codDdo`);

--
-- Indices de la tabla `casoagra`
--
ALTER TABLE `casoagra`
 ADD PRIMARY KEY (`codCas`,`codDdo`), ADD KEY `codDdo` (`codDdo`);

--
-- Indices de la tabla `cierre`
--
ALTER TABLE `cierre`
 ADD PRIMARY KEY (`nroCie`), ADD KEY `codCas` (`codCas`);

--
-- Indices de la tabla `conclusion`
--
ALTER TABLE `conclusion`
 ADD PRIMARY KEY (`codCas`);

--
-- Indices de la tabla `continuacion`
--
ALTER TABLE `continuacion`
 ADD PRIMARY KEY (`codCas`);

--
-- Indices de la tabla `designainvcaso`
--
ALTER TABLE `designainvcaso`
 ADD PRIMARY KEY (`nroDes`), ADD KEY `codCas` (`codCas`), ADD KEY `codInv` (`codInv`);

--
-- Indices de la tabla `eleconviccioncierre`
--
ALTER TABLE `eleconviccioncierre`
 ADD PRIMARY KEY (`codCas`,`nro`), ADD KEY `nroPie` (`nroPie`);

--
-- Indices de la tabla `eleconviccionconclusion`
--
ALTER TABLE `eleconviccionconclusion`
 ADD PRIMARY KEY (`codCas`,`nro`), ADD KEY `nroPie` (`nroPie`);

--
-- Indices de la tabla `eleconviccioncontinuacion`
--
ALTER TABLE `eleconviccioncontinuacion`
 ADD PRIMARY KEY (`codCas`,`nro`), ADD KEY `nroPie` (`nroPie`);

--
-- Indices de la tabla `elementotipo`
--
ALTER TABLE `elementotipo`
 ADD PRIMARY KEY (`nroEle`), ADD KEY `codArt` (`codArt`);

--
-- Indices de la tabla `fuente`
--
ALTER TABLE `fuente`
 ADD PRIMARY KEY (`nroFue`);

--
-- Indices de la tabla `hechocaso`
--
ALTER TABLE `hechocaso`
 ADD PRIMARY KEY (`codCas`,`nro`), ADD KEY `nroEle` (`nroEle`);

--
-- Indices de la tabla `investigador`
--
ALTER TABLE `investigador`
 ADD PRIMARY KEY (`codInv`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
 ADD PRIMARY KEY (`codPer`);

--
-- Indices de la tabla `piezaprocesal`
--
ALTER TABLE `piezaprocesal`
 ADD PRIMARY KEY (`nroPie`), ADD KEY `nroFuente` (`nroFuente`);

--
-- Indices de la tabla `plazoprocesal`
--
ALTER TABLE `plazoprocesal`
 ADD PRIMARY KEY (`nroPlz`), ADD KEY `codIniAct` (`codIniAct`), ADD KEY `codFinAct` (`codFinAct`);

--
-- Indices de la tabla `prueba`
--
ALTER TABLE `prueba`
 ADD PRIMARY KEY (`codCas`,`codPie`), ADD KEY `codPie` (`codPie`);

--
-- Indices de la tabla `revcuadernoinv`
--
ALTER TABLE `revcuadernoinv`
 ADD PRIMARY KEY (`codCas`,`nro`), ADD KEY `nroPie` (`nroPie`);

--
-- Indices de la tabla `revexpediente`
--
ALTER TABLE `revexpediente`
 ADD PRIMARY KEY (`codCas`,`nro`), ADD KEY `nroPie` (`nroPie`);

--
-- Indices de la tabla `solfiscalia`
--
ALTER TABLE `solfiscalia`
 ADD PRIMARY KEY (`codCas`);

--
-- Indices de la tabla `soljuzgado`
--
ALTER TABLE `soljuzgado`
 ADD PRIMARY KEY (`codCas`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `actoprocesal`
--
ALTER TABLE `actoprocesal`
ADD CONSTRAINT `actoprocesal_ibfk_1` FOREIGN KEY (`nroPie`) REFERENCES `piezaprocesal` (`nroPie`);

--
-- Filtros para la tabla `caso`
--
ALTER TABLE `caso`
ADD CONSTRAINT `caso_ibfk_1` FOREIGN KEY (`codDte`) REFERENCES `persona` (`codPer`),
ADD CONSTRAINT `caso_ibfk_2` FOREIGN KEY (`codDdo`) REFERENCES `persona` (`codPer`);

--
-- Filtros para la tabla `casoagra`
--
ALTER TABLE `casoagra`
ADD CONSTRAINT `casoagra_ibfk_1` FOREIGN KEY (`codCas`) REFERENCES `caso` (`codCas`),
ADD CONSTRAINT `casoagra_ibfk_2` FOREIGN KEY (`codDdo`) REFERENCES `persona` (`codPer`);

--
-- Filtros para la tabla `cierre`
--
ALTER TABLE `cierre`
ADD CONSTRAINT `cierre_ibfk_1` FOREIGN KEY (`codCas`) REFERENCES `caso` (`codCas`);

--
-- Filtros para la tabla `conclusion`
--
ALTER TABLE `conclusion`
ADD CONSTRAINT `conclusion_ibfk_1` FOREIGN KEY (`codCas`) REFERENCES `caso` (`codCas`);

--
-- Filtros para la tabla `continuacion`
--
ALTER TABLE `continuacion`
ADD CONSTRAINT `continuacion_ibfk_1` FOREIGN KEY (`codCas`) REFERENCES `caso` (`codCas`);

--
-- Filtros para la tabla `designainvcaso`
--
ALTER TABLE `designainvcaso`
ADD CONSTRAINT `designainvcaso_ibfk_1` FOREIGN KEY (`codCas`) REFERENCES `caso` (`codCas`),
ADD CONSTRAINT `designainvcaso_ibfk_2` FOREIGN KEY (`codInv`) REFERENCES `investigador` (`codInv`);

--
-- Filtros para la tabla `eleconviccioncierre`
--
ALTER TABLE `eleconviccioncierre`
ADD CONSTRAINT `eleconviccioncierre_ibfk_1` FOREIGN KEY (`codCas`) REFERENCES `caso` (`codCas`),
ADD CONSTRAINT `eleconviccioncierre_ibfk_2` FOREIGN KEY (`nroPie`) REFERENCES `piezaprocesal` (`nroPie`);

--
-- Filtros para la tabla `eleconviccionconclusion`
--
ALTER TABLE `eleconviccionconclusion`
ADD CONSTRAINT `eleconviccionconclusion_ibfk_1` FOREIGN KEY (`codCas`) REFERENCES `caso` (`codCas`),
ADD CONSTRAINT `eleconviccionconclusion_ibfk_2` FOREIGN KEY (`nroPie`) REFERENCES `piezaprocesal` (`nroPie`);

--
-- Filtros para la tabla `eleconviccioncontinuacion`
--
ALTER TABLE `eleconviccioncontinuacion`
ADD CONSTRAINT `eleconviccioncontinuacion_ibfk_1` FOREIGN KEY (`codCas`) REFERENCES `caso` (`codCas`),
ADD CONSTRAINT `eleconviccioncontinuacion_ibfk_2` FOREIGN KEY (`nroPie`) REFERENCES `piezaprocesal` (`nroPie`);

--
-- Filtros para la tabla `elementotipo`
--
ALTER TABLE `elementotipo`
ADD CONSTRAINT `elementotipo_ibfk_1` FOREIGN KEY (`codArt`) REFERENCES `articulo` (`codArt`);

--
-- Filtros para la tabla `hechocaso`
--
ALTER TABLE `hechocaso`
ADD CONSTRAINT `hechocaso_ibfk_1` FOREIGN KEY (`codCas`) REFERENCES `caso` (`codCas`),
ADD CONSTRAINT `hechocaso_ibfk_2` FOREIGN KEY (`nroEle`) REFERENCES `elementotipo` (`nroEle`);

--
-- Filtros para la tabla `piezaprocesal`
--
ALTER TABLE `piezaprocesal`
ADD CONSTRAINT `piezaprocesal_ibfk_1` FOREIGN KEY (`nroFuente`) REFERENCES `fuente` (`nroFue`);

--
-- Filtros para la tabla `plazoprocesal`
--
ALTER TABLE `plazoprocesal`
ADD CONSTRAINT `plazoprocesal_ibfk_1` FOREIGN KEY (`codIniAct`) REFERENCES `actoprocesal` (`codAct`),
ADD CONSTRAINT `plazoprocesal_ibfk_2` FOREIGN KEY (`codFinAct`) REFERENCES `actoprocesal` (`codAct`);

--
-- Filtros para la tabla `prueba`
--
ALTER TABLE `prueba`
ADD CONSTRAINT `prueba_ibfk_1` FOREIGN KEY (`codCas`) REFERENCES `caso` (`codCas`),
ADD CONSTRAINT `prueba_ibfk_2` FOREIGN KEY (`codPie`) REFERENCES `piezaprocesal` (`nroPie`);

--
-- Filtros para la tabla `revcuadernoinv`
--
ALTER TABLE `revcuadernoinv`
ADD CONSTRAINT `revcuadernoinv_ibfk_1` FOREIGN KEY (`codCas`) REFERENCES `caso` (`codCas`),
ADD CONSTRAINT `revcuadernoinv_ibfk_2` FOREIGN KEY (`nroPie`) REFERENCES `piezaprocesal` (`nroPie`);

--
-- Filtros para la tabla `revexpediente`
--
ALTER TABLE `revexpediente`
ADD CONSTRAINT `revexpediente_ibfk_1` FOREIGN KEY (`codCas`) REFERENCES `caso` (`codCas`),
ADD CONSTRAINT `revexpediente_ibfk_2` FOREIGN KEY (`nroPie`) REFERENCES `piezaprocesal` (`nroPie`);

--
-- Filtros para la tabla `solfiscalia`
--
ALTER TABLE `solfiscalia`
ADD CONSTRAINT `solfiscalia_ibfk_1` FOREIGN KEY (`codCas`) REFERENCES `caso` (`codCas`);

--
-- Filtros para la tabla `soljuzgado`
--
ALTER TABLE `soljuzgado`
ADD CONSTRAINT `soljuzgado_ibfk_1` FOREIGN KEY (`codCas`) REFERENCES `caso` (`codCas`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
