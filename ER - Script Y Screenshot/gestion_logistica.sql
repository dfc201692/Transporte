-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 26-03-2024 a las 23:58:11
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.2.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `gestion_logistica`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `id` bigint(20) NOT NULL,
  `direccion` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `nombre` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `telefono` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id`, `direccion`, `nombre`, `telefono`) VALUES
(1, 'calle 49a nº 72a - 11 Normandia', 'camilo suarez', '317958649'),
(2, 'calle 15 nº 94-28 Norte', 'Mario rincon', '3142568596'),
(3, 'centro', 'camilo cruz', '3105498762');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `envio_maritimo`
--

CREATE TABLE `envio_maritimo` (
  `id` bigint(20) NOT NULL,
  `cantidad_producto` int(11) NOT NULL,
  `fecha_entrega` datetime(6) DEFAULT NULL,
  `fecha_registro` datetime(6) DEFAULT NULL,
  `numero_flota` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `numero_guia` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `precio_envio` double NOT NULL,
  `puerto_entrega` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `cliente_id` bigint(20) DEFAULT NULL,
  `tipo_producto_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `envio_maritimo`
--

INSERT INTO `envio_maritimo` (`id`, `cantidad_producto`, `fecha_entrega`, `fecha_registro`, `numero_flota`, `numero_guia`, `precio_envio`, `puerto_entrega`, `cliente_id`, `tipo_producto_id`) VALUES
(11, 40, '2024-03-26 17:27:39.000000', '2024-03-26 17:27:39.000000', 'KEIQ475', 'AK34I5JK6N', 45000, 'Cartagena', 2, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `envio_terrestre`
--

CREATE TABLE `envio_terrestre` (
  `id` bigint(20) NOT NULL,
  `bodega_entrega` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `cantidad_producto` int(11) NOT NULL,
  `descuento` double NOT NULL,
  `fecha_entrega` datetime(6) DEFAULT NULL,
  `fecha_registro` datetime(6) DEFAULT NULL,
  `numero_guia` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `placa_vehiculo` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `precio_envio` double NOT NULL,
  `cliente_id` bigint(20) NOT NULL,
  `tipo_producto_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `envio_terrestre`
--

INSERT INTO `envio_terrestre` (`id`, `bodega_entrega`, `cantidad_producto`, `descuento`, `fecha_entrega`, `fecha_registro`, `numero_guia`, `placa_vehiculo`, `precio_envio`, `cliente_id`, `tipo_producto_id`) VALUES
(1, 'barranquilla', 10, 0, '2024-03-26 17:03:56.000000', '2024-03-26 17:03:56.000000', 'A455K3H4KO', 'AGE475', 100000, 3, 3),
(2, 'Bogotá', 10, 5, '2024-03-26 00:00:00.000000', '2024-03-30 00:00:00.000000', '2A455K3RI4', 'RIO421', 15000, 3, 4),
(3, 'Tunja', 70, 0, '2024-03-26 17:17:03.000000', '2024-03-26 17:17:03.000000', 'DKEU5I3K2N', 'TKE398', 25000, 1, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `id` bigint(20) NOT NULL,
  `nombre` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`id`, `nombre`) VALUES
(1, 'sala familiar'),
(2, 'Televisor 65 pulgadas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_producto`
--

CREATE TABLE `tipo_producto` (
  `id` bigint(20) NOT NULL,
  `nombre` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `tipo_producto`
--

INSERT INTO `tipo_producto` (`id`, `nombre`) VALUES
(1, 'Electrónicos'),
(2, 'Ropa'),
(3, 'Alimentos'),
(4, 'Herramientas'),
(5, 'Musica'),
(6, 'Libros');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `envio_maritimo`
--
ALTER TABLE `envio_maritimo`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK1iqy8ehf2hshyen7w0as1um64` (`cliente_id`),
  ADD KEY `FKkyi0c9vxsxmwv22flmt3ululs` (`tipo_producto_id`);

--
-- Indices de la tabla `envio_terrestre`
--
ALTER TABLE `envio_terrestre`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKr938vegedrhsg4m0njcp1788h` (`cliente_id`),
  ADD KEY `FKldf38r1kh9y1qlro649ge9fs5` (`tipo_producto_id`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tipo_producto`
--
ALTER TABLE `tipo_producto`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `envio_maritimo`
--
ALTER TABLE `envio_maritimo`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `envio_terrestre`
--
ALTER TABLE `envio_terrestre`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `tipo_producto`
--
ALTER TABLE `tipo_producto`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `envio_maritimo`
--
ALTER TABLE `envio_maritimo`
  ADD CONSTRAINT `FK1iqy8ehf2hshyen7w0as1um64` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`),
  ADD CONSTRAINT `FKkyi0c9vxsxmwv22flmt3ululs` FOREIGN KEY (`tipo_producto_id`) REFERENCES `tipo_producto` (`id`);

--
-- Filtros para la tabla `envio_terrestre`
--
ALTER TABLE `envio_terrestre`
  ADD CONSTRAINT `FKldf38r1kh9y1qlro649ge9fs5` FOREIGN KEY (`tipo_producto_id`) REFERENCES `tipo_producto` (`id`),
  ADD CONSTRAINT `FKr938vegedrhsg4m0njcp1788h` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
