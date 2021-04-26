-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.7.17-log - MySQL Community Server (GPL)
-- SO del servidor:              Win32
-- HeidiSQL Versión:             10.1.0.5464
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para suministrar
CREATE DATABASE IF NOT EXISTS `suministrar` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `suministrar`;

-- Volcando estructura para tabla suministrar.articulos
CREATE TABLE IF NOT EXISTS `articulos` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `Codigo` varchar(50) NOT NULL DEFAULT '0',
  `Categoria` int(11) NOT NULL,
  `Articulo` varchar(50) NOT NULL DEFAULT '0',
  `Precio` int(11) NOT NULL DEFAULT '0',
  `Cantidad` int(11) NOT NULL DEFAULT '0',
  `Precio_Prome` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`),
  KEY `FK_articulos_categorias` (`Categoria`),
  CONSTRAINT `FK_articulos_categorias` FOREIGN KEY (`Categoria`) REFERENCES `categorias` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=307 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla suministrar.articulos: ~375 rows (aproximadamente)
DELETE FROM `articulos`;
/*!40000 ALTER TABLE `articulos` DISABLE KEYS */;
INSERT INTO `articulos` (`ID`, `Codigo`, `Categoria`, `Articulo`, `Precio`, `Cantidad`, `Precio_Prome`) VALUES
	(1, '0', 1, 'CATETER # 18 ', 2600, 0, 0),
	(2, '0', 1, 'CATETER # 20 ', 2600, 0, 0),
	(3, '0', 1, 'CATETER # 22 ', 2600, 0, 0),
	(4, '0', 1, 'ABOCATH # 24 ', 2600, 0, 0),
	(5, '0', 1, 'ALCOHOL 3,700 ML  ', 19500, 0, 0),
	(6, '0', 1, 'ALGODÓN 500GR HOSPITALARIO ', 11400, 0, 0),
	(7, '0', 1, 'BACTRODER 3,5 LT SOLUCIÓN  ', 98000, 0, 0),
	(8, '0', 1, 'BACTRODER 3,5 LT  ESPUMA ', 98000, 0, 0),
	(9, '0', 1, 'BAJALENGUAS X 100UND ', 9800, 0, 0),
	(10, '0', 1, 'BENZAL X 3700ML', 78500, 0, 0),
	(11, '0', 1, 'CANULA NASAL ADULTO   ', 6700, 0, 0),
	(12, '0', 1, 'CANULA NASAL PEDIATRICA ', 6700, 0, 0),
	(13, '0', 1, 'CLAM UMBILICAL ', 1000, 0, 0),
	(14, '0', 1, 'CROMADO 2-0 ', 11300, 0, 0),
	(15, '0', 1, 'CROMADO 3-0 ', 11300, 0, 0),
	(16, '0', 1, 'CROMADO 4-0 ', 11300, 0, 0),
	(17, '0', 1, 'CUCHILLA PARA BISTURY # 15  X 100UND ', 62500, 0, 0),
	(18, '0', 1, 'CUCHILLA PARA BISTURY #20 X 100UND ', 62500, 0, 0),
	(19, '0', 1, 'ESPADADRAPO HOSPITALARIO  ', 59000, 0, 0),
	(20, '0', 1, 'ENEMA RECTAL X 133 C.C  ', 14800, 0, 0),
	(21, '0', 1, 'EQUIPO BURETROL x 150 ML  ', 4400, 0, 0),
	(22, '0', 1, 'EQUIPO VENOCLISIS MACROGOTEO ', 1800, 0, 0),
	(23, '0', 1, 'EQUIPO VENOCLISIS MICROGOTEO ', 2700, 0, 0),
	(24, '0', 1, 'FIJADOR PARA CITOLOGÍA  ', 18500, 0, 0),
	(25, '0', 1, 'GASA HOSPITALARÍA 1X100 YDR ', 71000, 0, 0),
	(26, '0', 1, 'GORROS DESECHABLES RESORTE X 50UND ', 14400, 0, 0),
	(27, '0', 1, 'GUANTES TALLA L CAJA X 100 UND ', 21000, 0, 0),
	(28, '0', 1, 'GUANTES TALLA M CAJA X 100 UND ', 21000, 0, 0),
	(29, '0', 1, 'GUANTES TALLA S CAJA X 100 UND ', 21000, 0, 0),
	(30, '0', 1, 'HUMIFICADOR PLÀSTICO PARA OXIGENO 400CC ', 16000, 0, 0),
	(31, '0', 1, 'JERINGA DE INSULINA  1ML  ', 400, 0, 0),
	(32, '0', 1, 'JERINGA 10ML', 550, 0, 0),
	(33, '0', 1, 'JERINGA 20ML ', 750, 0, 0),
	(34, '0', 1, 'JERINGA 5ML', 500, 0, 0),
	(35, '0', 1, 'KIT CITOLOGICO  ', 4400, 0, 0),
	(36, '0', 1, 'KIT NEBULIZACIÓN ADULTO  ', 6300, 0, 0),
	(37, '0', 1, 'KIT NEBULIZACIÓN PEDIATRICO ', 6300, 0, 0),
	(38, '0', 1, 'LACTACTO DE RINGER X 50ML ', 4200, 0, 0),
	(39, '0', 1, 'NAILON 2-0 ', 10500, 0, 0),
	(40, '0', 1, 'NAILON 3-0 ', 10500, 0, 0),
	(41, '0', 1, 'NAILON 4-0 ', 10500, 0, 0),
	(42, '0', 1, ' PAPEL KRAFF  18" X 60 GR X 175MTS ', 72000, 0, 0),
	(43, '0', 1, 'PAPEL PARA ELECTROCARDIOGRAMA SCHILLER AT-1 ', 23500, 0, 0),
	(44, '0', 1, 'RECOLECTOR DE ELEMENTOS CORTOPUNZANTES ', 16500, 0, 0),
	(45, '0', 1, 'SABANAS AJUSTABLES DESECHABLES ', 6500, 0, 0),
	(46, '0', 1, 'SONDA  FOLEY   2 VÍAS #16 ', 3800, 0, 0),
	(47, '0', 1, 'SONDA  FOLEY   2 VÍAS #18 ', 3800, 0, 0),
	(48, '0', 1, 'SONDA FOLEY 2 VIAS #14 ', 3800, 0, 0),
	(49, '0', 1, 'SONDA FOLEY 2 VIAS #12 ', 3800, 0, 0),
	(50, '0', 1, 'SONDA FOLEY 2 VIAS #10 ', 3800, 0, 0),
	(51, '0', 1, 'SONDA  NASOGASTRICA #6 ', 2400, 0, 0),
	(52, '0', 1, 'SONDA NASOGASTRICA #8 ', 2400, 0, 0),
	(53, '0', 1, 'SONDA  NASOGASTRICA #10 ', 2400, 0, 0),
	(54, '0', 1, 'SONDA NASOGASTRICA #12 ', 2400, 0, 0),
	(55, '0', 1, 'SUERO FISIOLOGICO X 500ML ', 4200, 0, 0),
	(56, '0', 1, 'TAPABOCA DESECHABLE CON ELASTICO CAJA X 50 UND ', 10500, 0, 0),
	(57, '0', 1, 'TAPÓN  HEPEMERIZADO ', 1600, 0, 0),
	(58, '0', 1, 'TERMOMETRO DIGITAL ORAL  ', 11500, 0, 0),
	(59, '0', 1, 'TERMOMETRO MERCURIO ', 4500, 0, 0),
	(60, '0', 1, 'TUBO ENDOCATREAL 6,0 ', 4200, 0, 0),
	(61, '0', 1, 'TUBO ENDOCATREAL  8,5 ', 4200, 0, 0),
	(62, '0', 1, 'TUBO ENDOCATREAL 10 ', 4200, 0, 0),
	(63, '0', 1, 'VENDA DE ALGODÓN LAMINADO 4X5 ', 4500, 0, 0),
	(64, '0', 1, 'VENDA DE ALGODÓN LAMINADO 5X5 ', 4500, 0, 0),
	(65, '0', 1, 'VENDA DE ALGODÓN LAMINADO 6X5 ', 4800, 0, 0),
	(66, '0', 1, 'VENDA ELASTICA 4X5 ', 4500, 0, 0),
	(67, '0', 1, 'VENDA ELASTICA 5X5 ', 4800, 0, 0),
	(68, '0', 1, 'VENDA ELÁSTICA  6X5 ', 5000, 0, 0),
	(69, '0', 1, 'VENDA DE YESO 4X5 ', 11200, 0, 0),
	(70, '0', 1, 'VENDA DE YESO 5X5 ', 11400, 0, 0),
	(71, '0', 1, 'VENDA DE YESO 6X5 ', 11500, 0, 0),
	(72, '7702605180011', 2, 'ACETAMINOFÉN  TAB X 500MG  ', 200, 0, 0),
	(73, '7706569002075', 2, 'ACETAMINOFÉN JRBE X 60ML ', 3200, 0, 0),
	(74, '7705959880361', 2, 'ACIDO ACETILSALICILICO  ', 100, 0, 0),
	(75, '0', 2, 'ÁCIDO FOLICO TAB ', 200, 0, 0),
	(76, '17800062002499', 2, 'ADRENALINA 1G AMP ', 2600, 0, 0),
	(77, '0', 2, 'AMIKACINA 100MG AMP  ', 4500, 0, 0),
	(78, '7707291520585', 2, 'AMPICILINA 1G AMP  ', 3000, 0, 0),
	(79, '0', 2, 'AMPICLILINA + SULBACTAN 1,5 GR AMP ', 4000, 0, 0),
	(80, '7703889155511', 2, 'BECLOMETASONA INHALADOR X 50MG ', 24600, 0, 0),
	(81, '7703381000463', 2, 'BERODUAL SOLUCIÓN PARA NEBULIZAR ', 63000, 0, 0),
	(82, '7707184161246', 2, 'BETAMETASONA 8 MG AMP ', 4500, 0, 0),
	(83, '0', 2, 'CAPTOPRIL X 25 MG TAB ', 150, 0, 0),
	(84, '0', 2, 'CAPTOPRIL X 50 MG TAB ', 200, 0, 0),
	(85, '7707355054841', 2, 'CARBONATO DE CALCIO 600MG TAB ', 250, 0, 0),
	(86, '0', 2, 'CEFALOTINA 1G AMP ', 5750, 0, 0),
	(87, '7707236121662', 2, 'CEFRADINA X 1G AMP ', 4600, 0, 0),
	(88, '6900191011042', 2, 'CEFTRIAZONA AMP ', 4100, 0, 0),
	(89, '7707236127039', 2, 'CIPROFLOXACINA 100 AMP  ', 6000, 0, 0),
	(90, '7707236122287', 2, 'CLINDAMICINA X 600MG  AMP ', 4400, 0, 0),
	(91, '0', 2, 'CLONIDINA TABLETA ', 180, 0, 0),
	(92, '0', 2, 'CLORURO DE POTASIO X 10 ML AMP ', 1400, 0, 0),
	(93, '7702870004319', 2, 'DEPOTRIN AMP', 13600, 0, 0),
	(94, '7707236124946', 2, 'DEXAMETASONA 4 MG AMP ', 1700, 0, 0),
	(95, '7707184160478', 2, 'DEXAMETASONA 8 MG AMP ', 1800, 0, 0),
	(96, '0', 2, 'DIAZEPAM X 10 MG ', 3400, 0, 0),
	(97, '0', 2, 'DICLOFENACO X 75 MG AMP ', 1200, 0, 0),
	(98, '0', 2, 'DINITRATO ISOSORBIDE 5MG TAB  ', 250, 0, 0),
	(99, '7707184160249', 2, 'DIPIRONA  2,5 G AMP ', 2300, 0, 0),
	(100, '7707184160232', 2, 'DIPIRONA X 1 GR AMP ', 2600, 0, 0),
	(101, '0', 2, 'DOPAMINA  200 MGAMPOLLA ', 2380, 0, 0),
	(102, '7702870004937', 2, 'FEMILYN  ', 14000, 0, 0),
	(103, '0', 2, 'FENITOINA X 40 MG AMP ', 8850, 0, 0),
	(104, '0', 2, 'FUROSEMIDA 20 MG AMP  ', 2350, 0, 0),
	(105, '7707236126322', 2, 'GENTAMICINA 160MG AMP ', 2100, 0, 0),
	(106, '7707236125141', 2, 'GENTAMICINA X 80 MG AMP ', 1900, 0, 0),
	(107, '0', 2, 'GLUCONATO DE CALCIO AMP ', 1500, 0, 0),
	(108, '0', 2, 'HALOPERIDOL X 5MG/ML  AMP ', 2000, 0, 0),
	(109, '7707236127480', 2, 'HIDROCORTISONA X 100MG  AMP ', 3700, 0, 0),
	(110, '7707236123086', 2, 'HIOSCINA  N BUTIL BROMURO  AMP ', 1200, 0, 0),
	(111, '7707236120405', 2, 'HIOSCINA AMPOLLA+ DIPIRONA AMP ', 1250, 0, 0),
	(112, '0', 2, 'LIDOCAINA AL 0,2% SIN EPINEFRINA X 50ML  ', 9200, 0, 0),
	(113, '7705959882129', 2, 'LOSARTAN 50 MG  ', 250, 0, 0),
	(114, '47709146799304', 2, 'METOCLOPRAMIDA 10 MG AMP ', 1700, 0, 0),
	(115, '0', 2, 'MICROFEMIN  ', 4500, 0, 0),
	(116, '0', 2, 'MIDAZOLAN 5MG AMPOLLA ', 13800, 0, 0),
	(117, '0', 2, 'MISOPROSTOL  FCO X 28 TAB ', 76000, 0, 0),
	(118, '0', 2, 'NALOXONA  X 0,4MG/ML AMP  ', 34000, 0, 0),
	(119, '0', 2, 'NIFEDIPINO X 10MG ', 400, 0, 0),
	(120, '0', 2, 'NOREPINEFRINA 4MG  AMPOLLA ', 3600, 0, 0),
	(121, '7707236123284', 2, 'OXACILINA 1G AMP  ', 3200, 0, 0),
	(122, '0', 2, 'OXACILINA X 1G  AMP ', 3300, 0, 0),
	(123, '0', 2, 'OXICOTCINA 10ML AMP ', 4500, 0, 0),
	(124, '7702057061371', 2, 'OXITMETAZOLINA HCL GOTAS  PEDIATRICO ', 9800, 0, 0),
	(125, '7702057707521', 2, 'OXITMETAZOLINA HCL GOTAS ADULTO ', 9800, 0, 0),
	(126, '0', 2, 'OXITOCINA 10 UI AMPOLLA ', 4500, 0, 0),
	(127, '7707291520042', 2, 'PENICILINA G SODICA  X 1.000.000 AMP ', 2000, 0, 0),
	(128, '7707236127381', 2, 'RANITIDINA  X 50MG  AMP ', 1400, 0, 0),
	(129, '0', 2, 'RANITIDINA 50 MG AMPOLLA ', 1400, 0, 0),
	(130, '0', 2, 'ROXICAINA JALEA ', 18500, 0, 0),
	(131, '0', 2, 'ROXICAINA X 50 ML SIN EPINEFRINA  ', 9200, 0, 0),
	(132, '7703889154392', 2, 'SALBUTAMOL INHALADOR ', 0, 0, 0),
	(133, '0', 2, 'SULFATO DEMAGNESIO AMPOLLA ', 2000, 0, 0),
	(134, '7702184011782', 2, 'SULFATO FERROSO TAB  ', 200, 0, 0),
	(135, '7707236124571', 2, 'TRAMADOL 100MG AMP ', 3500, 0, 0),
	(136, '7703153024345', 2, 'TRAMADOL 50MG AMP ', 2500, 0, 0),
	(137, '0', 2, 'VITAMINA K AMP ', 3800, 0, 0),
	(138, '0', 2, 'TOXOIDE TETANICO 	 ', 0, 0, 0),
	(139, '0', 3, 'ABON HCG ONE PREGNANCY TEST STRIP X50	', 68500, 0, 0),
	(140, '0', 3, 'ACEITE DE INMERSIÓN *100ML', 135800, 0, 0),
	(141, '0', 3, 'ACIDO URICO LS 2 X 125 ML', 192000, 0, 0),
	(142, '0', 3, 'ALCOHOL ACETONA X 500ML', 50000, 0, 0),
	(143, '0', 3, 'ANTI A MOMOCLONAL X 10ML', 45000, 0, 0),
	(144, '0', 3, 'ANTI B MONOCLONAL X 10ML', 33500, 0, 0),
	(145, '0', 3, 'ANTI D MOMOCLONAL X 10ML', 45000, 0, 0),
	(146, '0', 3, 'ANTIGENOS FEBRILES 3 X 6 ML', 230000, 0, 0),
	(147, '0', 3, 'APLICADORES DE MADERA CON PUNTA DE ALGODÒN X100UND', 9800, 0, 0),
	(148, '0', 3, 'APTT WIENER X2,5 150 DET', 35500, 0, 0),
	(149, '0', 3, 'ASTO LETEX ', 68500, 0, 0),
	(150, '0', 3, 'AZUL DE METILENO X 500ML', 38500, 0, 0),
	(151, '0', 3, 'CAPILARES AZULES SIN EPARINA FCO X 100 UND (HEMATR', 8800, 0, 0),
	(152, '0', 3, 'CERA SELLADORA PARA HEMATOCRI', 28500, 0, 0),
	(153, '0', 3, 'CINTA DE ENMASCARAR 18M X 20M', 5600, 0, 0),
	(154, '0', 3, 'CLORURO DE CALCIO X 100ML', 26000, 0, 0),
	(155, '0', 3, 'COLESTEROL  HDL 4X50ML', 220000, 0, 0),
	(156, '0', 3, 'COLESTEROL  LS 8 X 125 ML', 440000, 0, 0),
	(157, '0', 3, 'COLORANTE WRGTH + BUFFER GIORBANDO 500 ML ', 92000, 0, 0),
	(158, '0', 3, 'COVERGLASS  CUBREOBJETOS 22X22 MM', 8500, 0, 0),
	(159, '0', 3, 'COVERGLASS  PORTAOBJETOS 22X22 MM', 8500, 0, 0),
	(160, '0', 3, 'CREATINA 2 X 125ML +  1 X 5 ML', 110000, 0, 0),
	(161, '0', 3, 'CRP X 50 TEST', 72000, 0, 0),
	(162, '0', 3, 'DENGUE  IGG/IGM SD CASSETTES', 23500, 0, 0),
	(163, '0', 3, 'DENGUE  IGG/IGM SD CASSETTES CAJA X 20UND', 380000, 0, 0),
	(164, '0', 3, 'DEXTROSA MONOHID SABOR NARANJA ', 2000, 0, 0),
	(165, '0', 3, 'EDTA X 500ML', 75800, 0, 0),
	(166, '0', 3, 'GLUCOSA  2 x 125ml + 1x 5ml', 97000, 0, 0),
	(167, '0', 3, 'GLUCOSA  4 x 250ml + 1x 5ml', 200000, 0, 0),
	(168, '0', 3, 'GRADILLA   MULTI- FUNTION', 60000, 0, 0),
	(169, '0', 3, 'HBSAG DEVICE', 7000, 0, 0),
	(170, '0', 3, 'HIV DETERMINE ', 9800, 0, 0),
	(171, '0', 3, 'LUGOL  DE GRAM X 500ML', 35000, 0, 0),
	(172, '0', 3, 'PCR', 72000, 0, 0),
	(173, '0', 3, 'PORTAOBJETOS CAJA X50 UND', 8500, 0, 0),
	(174, '0', 3, 'PRUEBA DE EMBARAZO HCG X 50 ', 68500, 0, 0),
	(175, '0', 3, 'PUNTAS AMARRILLAS  200UL', 100, 0, 0),
	(176, '0', 3, 'RATEST BIOSYS', 68500, 0, 0),
	(177, '0', 3, 'RATEST BIOSYS', 68500, 0, 0),
	(178, '0', 3, 'SAFRANINA X 500ML', 48000, 0, 0),
	(179, '0', 3, 'SIFILIS DETERMINE * UND', 9300, 0, 0),
	(180, '0', 3, 'SOLUPLASTIN X 2ML', 23500, 0, 0),
	(181, '0', 3, 'SUEROS VALORADOS NIV I', 320000, 0, 0),
	(182, '0', 3, 'SUEROS VALORADOS NIV II', 300000, 0, 0),
	(183, '0', 3, 'TIRAS DE ORINA UROCOLOR 10 X100ML', 90000, 0, 0),
	(184, '0', 3, 'TOXOLATEX  50 TEST', 245000, 0, 0),
	(185, '0', 3, 'TRIGLICERIDOS 2 x 125ML', 330000, 0, 0),
	(186, '0', 3, 'TUBOS DE VIDRIO 12 X75', 2200, 0, 0),
	(187, '0', 3, 'TUBOS DE VIDRIO 13 X100', 2300, 0, 0),
	(188, '0', 3, 'UREA BUN COLOR 4X50ML', 140000, 0, 0),
	(189, '0', 3, 'UREA BUN COLOR 4X50ML', 140000, 0, 0),
	(190, '0', 3, 'VDRL ANTIGENO  X 250 TEST', 125000, 0, 0),
	(191, '0', 3, 'VIOLETA DE GRAM X 500ML', 52500, 0, 0),
	(192, '0', 4, 'APLICADORES MULTIUSOS X 100UND', 15000, 0, 0),
	(193, '0', 4, 'BANDA MATRIZ (1/4 UND-3/16 3UND)', 10200, 0, 0),
	(194, '0', 4, 'CEPILLO PARA PROFILAXIS ', 67000, 0, 0),
	(195, '0', 4, 'CK10', 7600, 0, 0),
	(196, '0', 4, 'CK4-', 7600, 0, 0),
	(197, '0', 4, 'CONTRAANGULO NO OPTICO SERIAL N OBJ80610 OBJ80609', 600000, 0, 0),
	(198, '0', 4, 'CURETA GRACEY  7/8', 8600, 0, 0),
	(199, '0', 4, 'CURETA GRACEY 11/12', 8600, 0, 0),
	(200, '0', 4, 'CURETA GRACEY 13/14', 8600, 0, 0),
	(201, '0', 4, 'CURETA GRACEY 5/6', 8600, 0, 0),
	(202, '0', 4, 'DENTOFAR X 5ML', 30200, 0, 0),
	(203, '0', 4, 'DERTARTROL FCO X 60ML', 25600, 0, 0),
	(204, '0', 4, 'DESMINERALIZANTE ', 20000, 0, 0),
	(205, '0', 4, 'DISCO SOFLEX X 40 + MANDRIL', 130000, 0, 0),
	(206, '0', 4, 'ESPEJO DE BOCA N° 5', 3000, 0, 0),
	(207, '0', 4, 'FORMO CRESOL X 13 ML', 29600, 0, 0),
	(208, '0', 4, 'FRESA  DE CARBURO', 11200, 0, 0),
	(209, '0', 4, 'FRESA BLANCA PULUIR RESINA', 3200, 0, 0),
	(210, '0', 4, 'FRESA DIAMANTE ECONOMICA DE PULIDO HALO AMARILLO', 3200, 0, 0),
	(211, '0', 4, 'FRESA DIAMANTE ECONOMICA INTERPROXIMAL 2200', 3200, 0, 0),
	(212, '0', 4, 'FRESA ZECRYA ECONOMICA', 26000, 0, 0),
	(213, '0', 4, 'FRESAS DIAMANTES  CILINDRICAS ECONOMICA ', 3200, 0, 0),
	(214, '0', 4, 'FRESAS DIAMANTES CONO INVERTIDO ECONOMICA', 3200, 0, 0),
	(215, '0', 4, 'FRESAS DIAMANTES REDONDAS ECONOMICA ', 3200, 0, 0),
	(216, '0', 4, 'GASA ODONTOLOGICA', 7000, 0, 0),
	(217, '0', 4, 'GELATAMP X 20', 106000, 0, 0),
	(218, '0', 4, 'HIDROXIDO DE CALCIO X 10 G', 7000, 0, 0),
	(219, '0', 4, 'LIJA PQ X 12', 28000, 0, 0),
	(220, '0', 4, 'LIJA PULIR RESINA X 100', 23600, 0, 0),
	(221, '0', 4, 'LUBRICANTE ', 33000, 0, 0),
	(222, '0', 4, 'LUPA  3,5', 270000, 0, 0),
	(223, '0', 4, 'MANGO PARA ESPEJO N°5 ', 5000, 0, 0),
	(224, '0', 4, 'NEWCAINA AL 2% X 50 UND', 47000, 0, 0),
	(225, '0', 4, 'OXIDO DE ZINC X 175G', 13000, 0, 0),
	(226, '0', 4, 'PAPEL ARTICULAR', 3200, 0, 0),
	(227, '0', 4, 'PAPEL CRISTAFLEX X 30 MT', 7000, 0, 0),
	(228, '0', 4, 'PINCELES PARA VARNISH X 50 UND', 20000, 0, 0),
	(229, '0', 4, 'RESINA  Z-350 JERINGA A1-A2D-A3D', 240000, 0, 0),
	(230, '0', 4, 'RESINA A1/B1-A2/B2-A3/B3', 62000, 0, 0),
	(231, '0', 4, 'RESINA P60 KIT', 350000, 0, 0),
	(232, '0', 4, 'RESINA Z100 3M JERINGA A1-A2-A3', 86000, 0, 0),
	(233, '0', 4, 'RESINA Z350 KIT X 3 JERINGAS COLOR: A1B-B1B-WB', 620000, 0, 0),
	(234, '0', 4, 'REVELADOR DE PLACA BACTERIANA X 10ML', 6800, 0, 0),
	(235, '0', 4, 'SEDA DENTAL X 400M', 12000, 0, 0),
	(236, '0', 4, 'SINGLE BOND X 3G', 188000, 0, 0),
	(237, '0', 4, 'TIRA DE MYLAR X 50UND', 6500, 0, 0),
	(238, '0', 4, 'VARNISH WHITW', 6000, 0, 0),
	(239, '0', 4, 'VITRIBOND', 350000, 0, 0),
	(240, '0', 4, 'VITRIMER ESTUCHE', 596000, 0, 0),
	(241, '0', 5, 'AZ OFICIO', 8700, 0, 0),
	(242, '0', 5, 'BORRADOR DE NATA', 210, 0, 0),
	(243, '0', 5, 'CALCULADORA 12 DIGÍTOS ', 19500, 0, 0),
	(244, '0', 5, 'CD PARA ARCHIVOS', 1300, 0, 0),
	(245, '0', 5, 'CINTA 48MM X 270 M 300YD', 12500, 0, 0),
	(246, '0', 5, 'CINTA LX 350', 29500, 0, 0),
	(247, '0', 5, 'CINTA TRANSPARENTE 48X200 MTS', 11500, 0, 0),
	(248, '0', 5, 'CLIP METALICO MARIPOSA  X 50UNDA', 6500, 0, 0),
	(249, '0', 5, 'CLIP PEQUEÑO X 100 UND ', 1500, 0, 0),
	(250, '0', 5, 'CD PARA ARCHIVOS', 2850, 0, 0),
	(251, '0', 5, 'FOLDER COLGANTE', 1200, 0, 0),
	(252, '0', 5, 'FOLDER SENCILLO', 1000, 0, 0),
	(253, '0', 5, 'FORMAS CONTINUAS UNIVERSALEA 91/2 X 5 1/22', 170000, 0, 0),
	(254, '0', 5, 'FORMAS CONTINUAS UNIVERSALEA 91/2 X111', 160000, 0, 0),
	(255, '0', 5, 'GANCHO LEGAJADOR PLÁSTICO X 20 UND', 3500, 0, 0),
	(256, '0', 5, 'GANCHOS LEGAJADORES CJA X 20 UND', 3500, 0, 0),
	(257, '0', 5, 'GRAPA GALVANIZADA X CAJA', 4500, 0, 0),
	(258, '0', 5, 'LAPICEROS NEGROS', 918, 0, 0),
	(259, '0', 5, 'LAPIZ CORRECTOR', 3800, 0, 0),
	(260, '0', 5, 'LAPIZ GRAFIRO NEGRO', 1000, 0, 0),
	(261, '0', 5, 'LIBROS DE CONTABLIDAD X 200 FOLIOS ', 32000, 0, 0),
	(262, '0', 5, 'MARCADOR SHARPIE ', 3800, 0, 0),
	(263, '0', 5, 'MARCADORES PERMANENTE DESECHABLES', 2500, 0, 0),
	(264, '0', 5, 'PEGANTE EN BARRA', 5500, 0, 0),
	(265, '0', 5, 'RESALTADORES SURTIDOS', 2500, 0, 0),
	(266, '0', 5, 'RESALTADORES SURTIDOS', 2500, 0, 0),
	(267, '0', 5, 'RESMAS DE PAPEL CARTA', 16500, 0, 0),
	(268, '0', 5, 'RESMAS DE PAPEL OFICIO', 17200, 0, 0),
	(269, '0', 5, 'SOBRE DE MANILA  CARTA', 300, 0, 0),
	(270, '0', 5, 'SOBRE DE MANILA GIGANTE', 650, 0, 0),
	(271, '0', 5, 'SOBRE DE MANILA OFICIO', 500, 0, 0),
	(272, '0', 5, 'SOBRES DE MANILA TAMAÑO CARTA', 300, 0, 0),
	(273, '0', 5, 'SOBRES DE MANILA TAMAÑO OFICIO', 500, 0, 0),
	(274, '0', 5, 'TONER 83 A', 55000, 0, 0),
	(275, '0', 5, 'TONER 85 A', 55000, 0, 0),
	(276, '7702184011362', 2, 'ATORVASTATINA 20 MG', 0, 0, 0),
	(277, '17709146799365', 2, 'BETAMETASONA 4 MG AMP ', 0, 0, 0),
	(278, '7703432424019', 2, 'ALPRAZOLAM 0.25 MG', 0, 0, 0),
	(279, '7707177972026', 2, 'ESPIRONOLACTONA', 0, 0, 0),
	(280, '7707236120641', 2, 'AMPICILINA 500MG AMP  ', 0, 0, 0),
	(281, '7703038066262', 2, 'METOCLOPRAMIDA 10 MG TAB ', 0, 0, 0),
	(282, '17800062002444', 2, 'ATROPINA SULFATO 1 MG AMP', 0, 0, 0),
	(283, '7703763506019', 2, 'BETAHISTINA DICLORHIDRATO 8MG', 0, 0, 0),
	(284, '7705959015220', 2, 'CEFALEXINA 500 MG CAPSULAS', 0, 0, 0),
	(285, '7703763997275', 2, 'CETIRIZINA JARABE 5MG', 0, 0, 0),
	(286, '7703763996179', 2, 'CEFALEXINA 250 MG POLVO', 0, 0, 0),
	(287, '7703038066057', 2, 'CETIRIZINA CLORHIDRATO 10MG', 0, 0, 0),
	(288, '7705451000250', 2, 'RENOBELL MINOXIDIL 5%', 0, 0, 0),
	(289, '7702057073602', 2, 'HIDROXIDO DE ALUMINIO 100ML', 0, 0, 0),
	(290, '7703712033924', 2, 'DINITRATO ISOSORBIDA 10MG TAB  ', 0, 0, 0),
	(291, '7707236124441', 2, 'GENTAMICINA X 40 MG AMP ', 0, 0, 0),
	(292, '7706569001979', 2, 'HIDROCORTISONA CREMA 1% ', 0, 0, 0),
	(293, '7707236126865', 2, 'OMEPRAZOL 40MG', 0, 0, 0),
	(294, '7702057070601', 2, 'NIMESULIDA 100MG', 0, 0, 0),
	(295, '7703712033276', 2, 'LORATADINA 1MG JARABE', 0, 0, 0),
	(296, '0', 1, 'GUANTE ESTERIL #7.5 CAJA X 50', 60000, 0, 0),
	(297, '814840011238', 5, 'probando', 3423432, 500, 0),
	(298, '7702003057908', 3, 'probando2', 23453, 343, 0),
	(299, '7734', 1, 'jesususs', 0, 322332, 0),
	(306, '0', 3, 'probando', 999, 0, 0);
/*!40000 ALTER TABLE `articulos` ENABLE KEYS */;

-- Volcando estructura para procedimiento suministrar.Articulos
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `Articulos`(
	IN `Condicion` INT,
	IN `ide` INT,
	IN `cod` VARCHAR(50),
	IN `cat` INT,
	IN `art` VARCHAR(50),
	IN `prec` INT


,
	IN `cant` INT


)
BEGIN
 IF Condicion = 1 THEN
     INSERT INTO articulos (Categoria ,Articulo, Precio) values (cat,art, prec);
 ELSEIF Condicion = 2 THEN
     UPDATE articulos set Codigo = cod, Categoria = cat, Articulo = art, Precio = prec , Cantidad = cant WHERE Id = ide;
 ELSEIF Condicion = 3 THEN
     DELETE FROM articulos WHERE Id = ide;
 ELSEIF Condicion = 4 THEN
     SELECT *FROM articulos WHERE Id = ide;
 ELSEIF Condicion = 5 THEN
     SELECT *FROM articulos;
ELSEIF Condicion = 6 THEN
     SELECT ID, Nombre FROM categoria_articulos;
ELSEIF Condicion = 7 THEN
     SELECT * FROM articulos WHERE Articulo like CONCAT(art,'%');
     ELSEIF Condicion = 8 THEN
     SELECT * FROM articulos WHERE Codigo like CONCAT(cod,'%');
 END IF;
END//
DELIMITER ;

-- Volcando estructura para tabla suministrar.categorias
CREATE TABLE IF NOT EXISTS `categorias` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla suministrar.categorias: ~6 rows (aproximadamente)
DELETE FROM `categorias`;
/*!40000 ALTER TABLE `categorias` DISABLE KEYS */;
INSERT INTO `categorias` (`ID`, `Nombre`) VALUES
	(1, 'MEDICOQUIRURGICO'),
	(2, 'MEDICAMENTOS'),
	(3, 'LABORATORIO'),
	(4, 'ODONTOLOGIA'),
	(5, 'PAPELERIA'),
	(6, 'OTRO');
/*!40000 ALTER TABLE `categorias` ENABLE KEYS */;

-- Volcando estructura para tabla suministrar.contabilidad
CREATE TABLE IF NOT EXISTS `contabilidad` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ID_USUARIO` int(11) DEFAULT NULL,
  `FECHA` int(11) DEFAULT NULL,
  `TIPO` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `ID_USUARIO` (`ID_USUARIO`),
  CONSTRAINT `ID_USUARIO` FOREIGN KEY (`ID_USUARIO`) REFERENCES `usuarios` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla suministrar.contabilidad: ~1 rows (aproximadamente)
DELETE FROM `contabilidad`;
/*!40000 ALTER TABLE `contabilidad` DISABLE KEYS */;
INSERT INTO `contabilidad` (`ID`, `ID_USUARIO`, `FECHA`, `TIPO`) VALUES
	(1, 1, NULL, NULL);
/*!40000 ALTER TABLE `contabilidad` ENABLE KEYS */;

-- Volcando estructura para tabla suministrar.drogerias
CREATE TABLE IF NOT EXISTS `drogerias` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla suministrar.drogerias: ~12 rows (aproximadamente)
DELETE FROM `drogerias`;
/*!40000 ALTER TABLE `drogerias` DISABLE KEYS */;
INSERT INTO `drogerias` (`ID`, `Nombre`) VALUES
	(1, 'MAJAGUAL'),
	(2, 'ACHI'),
	(3, 'GUARANDA'),
	(4, 'GALERAS'),
	(5, 'SAN MARCOS'),
	(6, 'MAJAGUAL2'),
	(7, 'COTORRA'),
	(8, 'SINCE'),
	(9, 'SAN ONOFRE'),
	(10, 'CARILLO'),
	(11, 'SAN ANDRES'),
	(12, 'TUCHIN');
/*!40000 ALTER TABLE `drogerias` ENABLE KEYS */;

-- Volcando estructura para tabla suministrar.estado
CREATE TABLE IF NOT EXISTS `estado` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Estado` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla suministrar.estado: ~3 rows (aproximadamente)
DELETE FROM `estado`;
/*!40000 ALTER TABLE `estado` DISABLE KEYS */;
INSERT INTO `estado` (`ID`, `Estado`) VALUES
	(1, 'ACTIVO'),
	(2, 'INACTIVO'),
	(3, 'PENDIENTE');
/*!40000 ALTER TABLE `estado` ENABLE KEYS */;

-- Volcando estructura para procedimiento suministrar.Filtro
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `Filtro`(
	IN `Condicion` INT,
	IN `codi` VARCHAR(50)


)
BEGIN
 IF Condicion = 1 THEN
     SELECT * FROM productos WHERE cod = codi ;
 END IF;
END//
DELIMITER ;

-- Volcando estructura para tabla suministrar.laboratorios
CREATE TABLE IF NOT EXISTS `laboratorios` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla suministrar.laboratorios: ~20 rows (aproximadamente)
DELETE FROM `laboratorios`;
/*!40000 ALTER TABLE `laboratorios` DISABLE KEYS */;
INSERT INTO `laboratorios` (`ID`, `Nombre`) VALUES
	(1, 'Ninguno'),
	(2, 'LABINCO'),
	(3, 'VITALIS'),
	(4, 'ECAR'),
	(5, 'GENFAR'),
	(6, 'FARMACOLOGICA S.A'),
	(7, 'LAFRANCOL'),
	(8, 'DELTA'),
	(9, 'EXPOFARMA'),
	(10, 'LAPROFF'),
	(11, 'MK'),
	(12, 'CHALVER'),
	(13, 'BIOESTERIL'),
	(14, 'SANDERSON'),
	(15, 'TECNOFAR'),
	(16, 'FARMIONNI'),
	(17, 'LASANTE'),
	(18, 'LICOL'),
	(19, 'BIOTOSCANA'),
	(20, 'COASPHARMA');
/*!40000 ALTER TABLE `laboratorios` ENABLE KEYS */;

-- Volcando estructura para procedimiento suministrar.ListBox
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `ListBox`(
	IN `Condicion` INT











)
BEGIN
	IF Condicion = 1 THEN
		SELECT ID, Nombre FROM categorias;
	ELSEIF Condicion = 2 THEN
		SELECT ID, Nombre FROM laboratorios;
	ELSEIF Condicion = 3 THEN
		SELECT ID, Tipo FROM privilegios;
	ELSEIF Condicion = 4 THEN
		SELECT ID, Nombre FROM drogerias;
	ELSEIF Condicion = 5 THEN
		SELECT ID, PROVEEDOR FROM proveedores;
	END IF;
END//
DELIMITER ;

-- Volcando estructura para procedimiento suministrar.Login
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `Login`(
	IN `Condicion` INT,
	IN `txtcedu` VARCHAR(50),
	IN `txtpass` VARCHAR(50),
	IN `dates` DATE

)
BEGIN
	IF Condicion = 1 THEN
		SELECT * FROM Usuarios WHERE Cedula = txtcedu and Pass = txtpass;
	ELSEIF Condicion = 2 THEN
		SELECT * FROM Usuarios WHERE Cedula = txtcedu;
	ELSEIF Condicion = 3 THEN
		UPDATE Usuarios set FechaIngreso = dates WHERE Cedula = txtcedu;
	END IF;
END//
DELIMITER ;

-- Volcando estructura para tabla suministrar.pdf
CREATE TABLE IF NOT EXISTS `pdf` (
  `codigopdf` int(10) NOT NULL AUTO_INCREMENT,
  `nombrepdf` varchar(50) DEFAULT NULL,
  `archivopdf` mediumblob,
  `valorpdf` int(11) DEFAULT NULL,
  `fechaemision` date DEFAULT NULL,
  `fechavencimiento` date DEFAULT NULL,
  `drogeriapdf` int(11) DEFAULT NULL,
  `proveedorpdf` int(11) DEFAULT NULL,
  `estadopdf` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigopdf`),
  KEY `Id_drogerias` (`drogeriapdf`),
  KEY `Id_Proveedor` (`proveedorpdf`),
  KEY `Id_Estado` (`estadopdf`),
  CONSTRAINT `Id_Estado` FOREIGN KEY (`estadopdf`) REFERENCES `estado` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Id_Proveedor` FOREIGN KEY (`proveedorpdf`) REFERENCES `proveedores` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Id_drogerias` FOREIGN KEY (`drogeriapdf`) REFERENCES `drogerias` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla suministrar.pdf: ~1 rows (aproximadamente)
DELETE FROM `pdf`;
/*!40000 ALTER TABLE `pdf` DISABLE KEYS */;
INSERT INTO `pdf` (`codigopdf`, `nombrepdf`, `archivopdf`, `valorpdf`, `fechaemision`, `fechavencimiento`, `drogeriapdf`, `proveedorpdf`, `estadopdf`) VALUES
/*!40000 ALTER TABLE `pdf` ENABLE KEYS */;

-- Volcando estructura para tabla suministrar.privilegios
CREATE TABLE IF NOT EXISTS `privilegios` (
  `ID` int(2) NOT NULL AUTO_INCREMENT,
  `Tipo` varchar(50) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla suministrar.privilegios: ~4 rows (aproximadamente)
DELETE FROM `privilegios`;
/*!40000 ALTER TABLE `privilegios` DISABLE KEYS */;
INSERT INTO `privilegios` (`ID`, `Tipo`) VALUES
	(1, 'USUARIO'),
	(2, 'EMPLEADO'),
	(3, 'ADMIN'),
	(4, 'INGE');
/*!40000 ALTER TABLE `privilegios` ENABLE KEYS */;

-- Volcando estructura para procedimiento suministrar.Productos
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `Productos`(
	IN `Condicion` INT,
	IN `codi` VARCHAR(50),
	IN `nom` VARCHAR(50),
	IN `cate` INT,
	IN `lab` INT,
	IN `uni` INT,
	IN `caj` INT,
	IN `cost` INT,
	IN `gan` INT













)
BEGIN
	IF Condicion = 1 THEN
		INSERT INTO productos (cod, Nombre, Categoria, Laboratorio, Unidades, Cajas, Costo, Ganancia ) values (codi, nom, cate, lab, uni, caj, cost, gan);
	ELSEIF Condicion = 2 THEN
		UPDATE productos set Nombre = nom , Categoria = cate , Laboratorio = lab , Unidades = uni , Cajas = caj , Costo = cost , Ganancia = gan WHERE cod = codi;
	ELSEIF Condicion = 3 THEN
		DELETE FROM productos WHERE cod = codi;
	ELSEIF Condicion = 4 THEN
		select Unidades from productos AS anterior where cod=codi; 
		UPDATE productos set Unidades = uni  WHERE cod = codi;
	END IF;
END//
DELIMITER ;

-- Volcando estructura para tabla suministrar.productos
CREATE TABLE IF NOT EXISTS `productos` (
  `cod` varchar(50) NOT NULL,
  `Nombre` varchar(50) DEFAULT NULL,
  `Categoria` int(11) DEFAULT NULL,
  `Laboratorio` int(11) DEFAULT NULL,
  `Unidades` int(11) DEFAULT NULL,
  `Cajas` int(11) DEFAULT NULL,
  `Costo` int(11) DEFAULT NULL,
  `Ganancia` int(3) DEFAULT NULL,
  PRIMARY KEY (`cod`),
  KEY `id_categorias` (`Categoria`),
  KEY `id_laboratorios` (`Laboratorio`),
  CONSTRAINT `id_categorias` FOREIGN KEY (`Categoria`) REFERENCES `categorias` (`ID`),
  CONSTRAINT `id_laboratorios` FOREIGN KEY (`Laboratorio`) REFERENCES `laboratorios` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla suministrar.productos: ~53 rows (aproximadamente)
DELETE FROM `productos`;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` (`cod`, `Nombre`, `Categoria`, `Laboratorio`, `Unidades`, `Cajas`, `Costo`, `Ganancia`) VALUES
	('17709146799358', 'FUROSEMIDA', 2, 13, 10, 1, 2350, 0),
	('17709146799365', 'BETAMETASONA 4MG AMP', 2, 13, 1, 1, 0, 0),
	('17800062002444', 'ATROPINA SULFATO 1MG AMP', 2, 14, 1, 1, 0, 0),
	('17800062002499', 'APINEFRINA (ADRENALINA) 1G AMP', 2, 14, 1, 1, 2600, 0),
	('47709146799304', 'METOCLOPRAMIDA 10MG AMP', 2, 13, 1, 1, 1700, 0),
	('6900191011042', 'CEFTRIAZONA SODICA 1G', 2, 8, 1, 0, 4100, 0),
	('6921875005577', 'AMPICILINA + SULBACTAN 1,5G AMP', 2, 8, 1, 0, 4000, 0),
	('7702003057908', 'PEGASTIC', 5, 1, 1, 1, 15000, 40),
	('7702057061371', 'OXIMETAZOLINA HCL GOTAS PEDIATRICO', 2, 11, 1, 0, 9800, 0),
	('7702057073602', 'HIDROXIDO DE ALUMINIO 100ML', 2, 11, 1, 0, 0, 0),
	('7702057707521', 'OXITMETAZOLINA HCL GOTAS ADULTO', 2, 15, 1, 0, 9800, 0),
	('7702184030158', 'VITAMINA B12 1ML AMP', 2, 4, 25, 1, 3800, 0),
	('7702184030196', 'COMPLEJO B AMP', 2, 4, 12, 1, 0, 0),
	('7702605180011', 'ACETAMINOFEN 500MG TAB', 2, 5, 100, 1, 200, 0),
	('7702870004319', 'DEPOTRIN AMP', 2, 7, 1, 1, 13600, 0),
	('7702870004937', 'FEMELYN', 2, 7, 1, 1, 14000, 0),
	('7703038066057', 'CETIRIZINA CLORHIDRATO 10MG', 2, 10, 300, 1, 0, 0),
	('7703038066262', 'METOCLOPRAMIDA 10MG TAB', 2, 10, 300, 1, 0, 0),
	('7703153024345', 'TRAMADOL 50MG AMP ', 2, 16, 10, 1, 2500, 0),
	('7703153024369', 'TRAMADOL 100MG AMP', 2, 16, 10, 1, 3500, 0),
	('7703432424019', 'ALPRAZOLAM 0,25MG 30TAB', 2, 9, 0, 1, 0, 0),
	('7703712033924', 'DINITRATO ISOSORBIDA 10MG TAB', 2, 20, 30, 1, 0, 0),
	('7703763670215', 'CLINDAMICINA X 300MG  AMP ', 2, 17, 24, 1, 0, 0),
	('7703763996179', 'CEFALEXINA 250 MG POLVO', 2, 17, 1, 0, 0, 0),
	('7703763997275', 'CETIRIZINA JARABE 5MG', 2, 17, 1, 0, 0, 0),
	('7703889154392', 'SALBUTAMOL INHALADOR', 2, 12, 1, 0, 0, 0),
	('7703889155511', 'BECLOMETAZONA INHALADOR 50MG', 2, 12, 1, 0, 24600, 0),
	('7705451000250', 'RENOBELL MINOXIDIL 5%', 2, 18, 1, 0, 0, 0),
	('7705959015220', 'CEFALEXINA 500 MG CAPSULAS', 2, 5, 300, 1, 0, 0),
	('7705959880361', 'ACIDO ACETILSALICILICO', 2, 5, 900, 1, 100, 0),
	('7706569002075', 'ACETAMINOFEN JRBE 60ML', 2, 7, 1, 0, 3200, 0),
	('7707177972026', 'ESPIRONOLACTONA 25MG', 2, 2, 20, 1, 0, 0),
	('7707184160232', 'DIPIRONA  SODICA 1GR AMP ', 2, 16, 100, 1, 2600, 0),
	('7707184160249', 'DIPIRONA  SODICA 2,5G AMP ', 2, 16, 100, 1, 2300, 0),
	('7707184160478', 'DEXAMETASONA 8 MG AMP ', 2, 16, 100, 1, 1800, 0),
	('7707184161246', 'BETAMETASONA 8 MG AMP ', 2, 16, 100, 1, 4500, 0),
	('7707236120405', 'HIOSCINA N BUTIL + DIPIRONA AMP ', 2, 3, 10, 1, 1250, 0),
	('7707236120641', 'AMPICILINA 500MG AMP', 2, 3, 10, 1, 0, 0),
	('7707236122188', 'CEFTRIAZONA 1G AMP', 2, 3, 1, 1, 4100, 0),
	('7707236122836', 'DIPIRONA X 1 GR AMP ', 2, 3, 10, 1, 2600, 0),
	('7707236123086', 'HIOSCINA  N BUTIL BROMURO  AMP', 2, 3, 10, 1, 1200, 0),
	('7707236123284', 'OXACILINA 1G AMP', 2, 3, 10, 1, 3200, 0),
	('7707236124441', 'GENTAMICINA X 40 MG AMP', 2, 3, 10, 1, 0, 0),
	('7707236124571', 'TRAMADOL 100MG AMP', 2, 3, 10, 1, 3500, 0),
	('7707236124946', 'DEXAMETASONA 4MG AMP', 2, 3, 1, 1, 1700, 0),
	('7707236125141', 'GENTAMICINA X 80 MG AMP ', 2, 3, 10, 1, 1900, 0),
	('7707236126322', 'GENTAMICINA 160MG AMP', 2, 3, 10, 1, 2100, 0),
	('7707236126940', 'DIPIRONA MAGNESICA 2G AMP', 2, 3, 10, 1, 0, 0),
	('7707236127381', 'RANITIDINA 50MG AMP', 2, 3, 1, 1, 1400, 0),
	('7707236127480', 'HIDROCORTISONA  100MG  AMP', 2, 3, 10, 1, 3700, 0),
	('7707291520042', 'PENICILINA G SODICA X1,000,000 AMP', 2, 6, 1, 1, 2000, 0),
	('7707291520585', 'AMPICILINA 1G AMP', 2, 6, 10, 1, 3000, 0),
	('8901117293168', 'CIPLATROPIUN', 2, 19, 1, 0, 0, 0);
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;

-- Volcando estructura para tabla suministrar.proveedores
CREATE TABLE IF NOT EXISTS `proveedores` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PROVEEDOR` varchar(50) NOT NULL,
  `NIT` varchar(50) NOT NULL,
  `DIRECCION` varchar(50) NOT NULL,
  `TELEFONO` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla suministrar.proveedores: ~18 rows (aproximadamente)
DELETE FROM `proveedores`;
/*!40000 ALTER TABLE `proveedores` DISABLE KEYS */;
INSERT INTO `proveedores` (`ID`, `PROVEEDOR`, `NIT`, `DIRECCION`, `TELEFONO`) VALUES
	(1, 'MUNDO DENTAL DE LA COSTA', '68302970-3', 'CARRERA 42F # 75B-124 BARRANQUILLA', 3357879),
	(2, 'INSTITUTO NACIONAL DE SALUD', '899999403-4', 'Avenida calle 26 No. 51-20 - Zona 6 CAN. Bogotá', 220),
	(3, 'METALMEDICAS', '72169219-4', 'CARRERA 57 # 77-24 BARRANQUILLA', 2147483647),
	(4, 'CASA DEL MEDICO S.A.S.', '800019856-3', 'CALLE 21 # 17 - 23 SINCELEJO', 2812352),
	(5, 'MEDIMARCAS S.A.S.', '830512218-7', 'CALLE 38 # 4A - 184 BL A BOD 10 y 11 SINCELEJO', 2754810),
	(6, 'COMPUTADORES L&F', '64589098-2', 'CARRERA 20 # 27 - 87 LOC 7 SINCELEJO', 2745555),
	(7, 'MUNDO COPIAS DEL CARIBE S.A.S.', '900809610-1', 'CARRERA 20 # 16A - 26 SINCELEJO', 2820404),
	(8, 'PLASTIGIRALDO SINCELEJO ', '70383173', 'CALLE 22 # 23 - 97 SINCELEJO', 2829494),
	(9, 'SURTILINEAS DEL CARIBE', '800094742-1', 'CALLE 38 # 4A - 184 BL B BOD 22 SINCELEJO', 2714848),
	(10, 'FELIX CRUZ ARAUJO', '8671984-1', 'CARRERA 17 # 18 - 11 SINCELEJO', 2147483647),
	(11, 'REPRESENTACIONES F.C. E.U.', '823004637-5', 'CARRERA 17 # 18 - 11 SINCELEJO', 2828765),
	(12, 'INSUMOS QUIRURGICOS Y MEDICOS S.A.S.', '900128625-9', 'CARRERA 52 #72 - 65 BARRANQUILLA', 2147483647),
	(13, 'DISFARMA', '900580962-2', 'KM 7 + 400 ANILLO VIAL BODEGA 92 FLORIDABLANCA', 6915767),
	(14, 'GLOBAL PHARMACEUTICA S.A.S', '900008190-2', 'CALLE 39 # 4F - 83 BOD 5 SINCELEJO', 2805622),
	(15, 'MAKRO SUPERMAYORISTA S.A.S.', '900059238-5', 'CARRERA 14 # 48A - 42 MONTERIA', 2147483647),
	(16, 'COOPIDROGAS', '860026123-0', 'PQ IND Y CIAL DEL CARIBE. VIA CIRCUNVALAR BOD MB23', 3289342),
	(17, 'INVERSIONES ROMERO - QUIMED', '800233307-8', 'CALLE 75 # 72 - 40 BARRANQUILLA', 3850007),
	(18, 'DIAGNOSTILAB VM S.A.S', '900635373-2', 'CARRERA 19 N° 15-111 SINCELEJO', 2147483647);
/*!40000 ALTER TABLE `proveedores` ENABLE KEYS */;

-- Volcando estructura para procedimiento suministrar.Proveedores
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `Proveedores`(
	IN `Condicion` INT,
	IN `ide` VARCHAR(50),
	IN `prov` VARCHAR(50),
	IN `nit` VARCHAR(50),
	IN `dir` VARCHAR(50),
	IN `tel` INT






)
BEGIN
	IF Condicion = 1 THEN
		INSERT INTO proveedores (PROVEEDOR, NIT, DIRECCION, TELEFONO) values (prov, nit, dir, tel);
	ELSEIF Condicion = 2 THEN
		UPDATE articulos set Categoria = cat, Articulo = art, Precio = prec WHERE Id = ide;
	ELSEIF Condicion = 3 THEN
		DELETE FROM Proveedores WHERE NIT = nit;
	ELSEIF Condicion = 4 THEN
		SELECT *FROM Proveedores WHERE Id = ide;
	ELSEIF Condicion = 5 THEN
		SELECT *FROM proveedores;
	ELSEIF Condicion = 6 THEN
		SELECT ID, Nombre FROM categoria_articulos;
	ELSEIF Condicion = 7 THEN
		SELECT * FROM proveedores WHERE PROVEEDOR like CONCAT(prov,'%');
 	END IF;
END//
DELIMITER ;

-- Volcando estructura para procedimiento suministrar.usuarios
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `usuarios`(
	IN `Condicion` INT
,
	IN `cod` INT,
	IN `nom` VARCHAR(50),
	IN `ape` VARCHAR(50),
	IN `cedu` BIGINT,
	IN `email` VARCHAR(50),
	IN `tel` BIGINT,
	IN `rol` INT






,
	IN `fecha` DATE

)
BEGIN
	IF Condicion = 1 THEN
		INSERT INTO usuarios (ID,Nombre, Apellido, Cedula, Pass, correo_electronico, Telefono, ID_Privilegios, FechaIngreso) values (cod, nom, ape, cedu, cedu, email, tel, rol, fecha);
	ELSEIF Condicion = 2 THEN
		UPDATE usuarios set Nombre = nom , Apellido = ape , Cedula = cedu , Pass = cedu , correo_electronico = email , Telefono = tel , ID_Privilegios = rol WHERE Cedula = cedu;
	ELSEIF Condicion = 3 THEN
		DELETE FROM usuarios WHERE Cedula = cedu;
	ELSEIF Condicion = 4 THEN
		select Unidades from usuarios AS anterior where cod=codi; 
		UPDATE usuarios set Unidades = uni  WHERE cod = codi;
	END IF;
END//
DELIMITER ;

-- Volcando estructura para tabla suministrar.usuarios
CREATE TABLE IF NOT EXISTS `usuarios` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(50) NOT NULL DEFAULT '0',
  `Apellido` varchar(50) NOT NULL DEFAULT '0',
  `Cedula` bigint(20) NOT NULL DEFAULT '0',
  `Pass` bigint(20) NOT NULL DEFAULT '0',
  `correo_electronico` varchar(50) DEFAULT '0',
  `Telefono` int(11) DEFAULT '0',
  `ID_Privilegios` int(2) NOT NULL DEFAULT '0',
  `FechaIngreso` date DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `Cedula` (`Cedula`),
  KEY `ID_Privilegios` (`ID_Privilegios`),
  CONSTRAINT `ID_Privilegios` FOREIGN KEY (`ID_Privilegios`) REFERENCES `privilegios` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- Volcando datos para la tabla suministrar.usuarios: ~4 rows (aproximadamente)
DELETE FROM `usuarios`;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` (`ID`, `Nombre`, `Apellido`, `Cedula`, `Pass`, `correo_electronico`, `Telefono`, `ID_Privilegios`, `FechaIngreso`) VALUES
	(1, 'jesus', 'garcia', 1100628871, 1100628871, 'jegarba1996@gmail.com', 0, 3, '2019-05-20'),
	(2, 'Carmen', 'Bueno', 64585203, 64585203, 'carmenbuenotovar@gmail.com', 0, 1, '2019-05-15'),
	(3, 'ramiro', 'rada', 9195534, 9195534, 'none', 0, 2, '2019-05-16'),
	(4, 'Diego', 'Argel', 6844141, 6844141, 'diegoargel@hotmail.com', 2147483647, 2, '2019-05-20');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;