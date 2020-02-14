-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 14-Fev-2020 às 20:34
-- Versão do servidor: 10.4.10-MariaDB
-- versão do PHP: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `bd_dp`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbcoparti`
--

CREATE TABLE `tbcoparti` (
  `codCop` int(11) NOT NULL,
  `fr_codFuncionario` int(50) NOT NULL,
  `fr_nomeFuncionario` varchar(150) NOT NULL,
  `fr_cpfFuncionario` varchar(50) NOT NULL,
  `fr_cargoFuncionario` varchar(150) NOT NULL,
  `fr_setorFuncionario` varchar(150) NOT NULL,
  `fr_codEsp` int(11) NOT NULL,
  `fr_nomeEsp` varchar(150) NOT NULL,
  `fr_codPro` int(11) NOT NULL,
  `fr_nomePro` varchar(150) NOT NULL,
  `fr_valorPro` double NOT NULL,
  `fr_parcelaPro` int(11) NOT NULL,
  `localPro` varchar(150) NOT NULL,
  `medicoPro` varchar(150) NOT NULL,
  `dataPro` date NOT NULL,
  `dataDescPro` date NOT NULL,
  `dataVencPro` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tbcoparti`
--

INSERT INTO `tbcoparti` (`codCop`, `fr_codFuncionario`, `fr_nomeFuncionario`, `fr_cpfFuncionario`, `fr_cargoFuncionario`, `fr_setorFuncionario`, `fr_codEsp`, `fr_nomeEsp`, `fr_codPro`, `fr_nomePro`, `fr_valorPro`, `fr_parcelaPro`, `localPro`, `medicoPro`, `dataPro`, `dataDescPro`, `dataVencPro`) VALUES
(33, 10, 'RONALDO JOSÉ CORREIA', '707.586.540-49', 'SUPERVISOR DE QUALID', 'PROCESSOS', 1, 'Pediatria', 3, 'Tomografia computadorizada', 220.64, 3, 'teste', 'teste', '2020-02-01', '2020-03-05', '2020-04-05'),
(34, 24, 'AGUINALDO DA SILVA CARDOSO', '916.809.560-00', 'ANALISTA DE PROCESSO', 'PROCESSOS', 1, 'Pediatria', 1, 'Consulta em pronto socorro', 400, 4, 'Esteio', 'Esteio', '2020-02-01', '2020-03-05', '2020-04-05');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbesp`
--

CREATE TABLE `tbesp` (
  `codEsp` int(255) NOT NULL,
  `nomeEsp` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tbesp`
--

INSERT INTO `tbesp` (`codEsp`, `nomeEsp`) VALUES
(1, 'Pediatria'),
(2, 'Dermatologista'),
(3, 'Clinico'),
(4, 'Ginecologista'),
(5, 'Cirurgião Dentista'),
(6, 'Ortopedista'),
(7, 'Oftalmologista'),
(8, 'Psiquiatra'),
(9, 'Neurologista'),
(10, 'Radiologia e Diagnosticos'),
(11, 'Anestesiologista'),
(12, 'Urologista'),
(13, 'Otorrinolaringologista');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbfuncionarios`
--

CREATE TABLE `tbfuncionarios` (
  `codFuncionario` int(11) NOT NULL,
  `nomeFuncionario` varchar(250) NOT NULL,
  `cpfFuncionario` varchar(45) NOT NULL,
  `setorFuncionario` varchar(150) NOT NULL,
  `cargoFuncionario` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tbfuncionarios`
--

INSERT INTO `tbfuncionarios` (`codFuncionario`, `nomeFuncionario`, `cpfFuncionario`, `setorFuncionario`, `cargoFuncionario`) VALUES
(10, 'RONALDO JOSÉ CORREIA', '707.586.540-49', 'PROCESSOS', 'SUPERVISOR DE QUALID'),
(24, 'AGUINALDO DA SILVA CARDOSO', '91680956000', 'PROCESSOS', 'ANALISTA DE PROCESSO'),
(63, 'LUCIANO VASCONCELOS DA SILVA', '76160955004', 'PREPARACAO', 'PREPARADOR DE MAQUIN'),
(116, 'ANTâNIO ANDR CEZAR', '80823114015', 'PREPARACAO', 'ENCARREGADO DE PRODU'),
(122, 'LUIZ CARLOS ALEGRE RODRIGUES', '54717736087', 'PRODUÇÃO', 'OPERADOR DE MAQUINA'),
(138, 'DELEANDRO LARSSEM', '000.000.000-00', 'PREPARACAO', 'PREPARADOR DE MAQUIN'),
(165, 'EMERSON DA SILVA', '1513236075', 'PRODUÇÃO', 'OPER. MAQUINA CNC'),
(176, 'QUENIA ROSANA BARBOSA LINHARES', '40348202091', 'QUALIDADE', 'OPERADOR DE MAQUINA'),
(181, 'LUIS F. DE AZEVEDO CAMPOS', '83267930006', 'VENDAS', 'ENCARREGADO DE PCP'),
(206, 'MICHEL ANDERSON S. ZINTH', '1720256055', 'PREPARACAO', 'ENCARREGADO DE PRODU'),
(231, 'LETÖCIA SCHMITZ DA SILVA', '431216088', 'ADMINISTRATIVO', 'ASSISTENTE DE DP'),
(241, 'IVAN CARLOS LOPES DE AZEVEDO', '2635718075', 'PREPARACAO', 'OPER. MAQUINA CNC'),
(249, 'ROBERTO RIBEIRO DUARTE', '2185828037', 'PREPARACAO', 'PREPARADOR DE MAQUIN'),
(259, 'PAULO SRGIO SELANI GOMES', '2595274082', 'PRODUÇÃO', 'OPER. MAQUINA CNC'),
(279, 'HENRIQUE DE SÁ BRITO', '224.595.504-8 ', 'PROCESSOS', 'TCNICO DE PROCESSOS'),
(286, 'MARCELO ROCHA HOFFMANN', '2440847003', 'PREPARACAO', 'PREPARADOR DE MAQUIN'),
(288, 'NEREU PINHEIRO GOMES JUNIOR', '2567861009', 'MANUTENÇÃO', 'MECANICO DE MANUTEN€'),
(290, 'RAFAEL MANICA AMBOS', '1740976037', 'PCP', 'AUXILIAR DE PCP'),
(302, 'QUEITI DA SILVA DE MORAES FRANK', '1754723004', 'QUALIDADE', 'ENCARREGADA QUALIDAD'),
(309, 'MICHEL MENDES SILVEIRA', '2917605030', 'PROCESSOS', 'TCNICO DE PROCESSO'),
(312, 'PAULO JUNIOR ALMEIDA DE LIZ', '2428133055', 'QUALIDADE EXTERNA', 'AUXILIAR QUALIDADE'),
(355, 'GIOVANI ROCHA TERRA', '2779333073', 'PREPARACAO', 'SOLDADOR'),
(358, 'GABRIEL RODRIGUES BONNESS', '2939830037', 'PREPARACAO', 'PREPARADOR DE MAQUIN'),
(366, 'DOUGLAS GUILHERME MORAES JANTSCH', '3097551077', 'PRODUÇÃO', 'OPER. MAQUINA CNC'),
(386, 'MARCOS JOSIAS CARDOSO DOS SANTOS', '1238742033', 'PREPARACAO', 'PREPARADOR DE MAQUIN'),
(394, 'INEZ ANTONIA BARBOSA VENCATO', '40940217015', 'COMPRAS', 'COMPRADORA'),
(395, 'JOSUE PAULO ORTIZ', '2977423028', 'COMPRAS', 'COMPRADOR'),
(404, 'VINICIUS GODOI BATISTA', '3312622077', 'QUALIDADE', 'AUXILIAR QUALIDADE'),
(405, 'ANGELO JONES DE LIMA RODRIGUES', '953.836.200-44', 'EXPEDIÇÃO', 'AUXILIAR DE EXPEDI€Ç'),
(409, 'FµBIO LUIZ DA SILVA', '3981583981', 'PRODUÇÃO', 'OPER. MAQUINA CNC'),
(412, 'REGES ANDERSON DE SOUZA RODRIGUES', '82677310082', 'PRODUÇÃO', 'OPER. MAQUINA CNC'),
(413, 'VANDERLEI DOS SANTOS', '1548406023', 'PRODUÇÃO', 'OPER. MAQUINA CNC'),
(423, 'CARLOS ALBERTO SANTOS DA SILVEIRA', '54584523053', 'PRODUÇÃO', 'OPER. MAQUINA CNC'),
(425, 'ANDRIUS PEREIRA BARCELOS', '1693617056', 'PRODUÇÃO', 'OPERADOR DE MAQUINA'),
(426, 'ANTONIO CARLOS DA CRUZ', '64229696000', 'PRODUÇÃO', 'OPERADOR DE MAQUINA'),
(427, 'ANTONIO ZANDONERI SOARES APOLINARIO', '45706719004', 'PRODUÇÃO', 'OPER. MAQUINA CNC'),
(431, 'LEANDRO DA SILVA MACHADO', '1898997004', 'EXPEDIÇÃO', 'AUXILIAR DE EXPEDI€Ç'),
(432, 'MARLENE SANTOS DA SILVA LOPES', '1145978045', 'PRODUÇÃO', 'OPERADOR DE MAQUINA'),
(435, 'BRUNO NUNES GABRIEL', '1159049050', 'PRODUÇÃO', 'SOLDADOR'),
(437, 'MAICK RODRIGUE GOMES', '2709687097', 'PRODUÇÃO', 'OPER. MAQUINA CNC'),
(441, 'ALESCIO JOSE BIASI', '79055796034', 'PRODUÇÃO', 'OPER. MAQUINA CNC'),
(445, 'LUCAS BORGES MOLOZZI', '3284261052', 'PRODUÇÃO', 'OPER. MAQUINA CNC'),
(446, 'JOÇO EVANGELISTA DA SILVA', '262020009', 'PRODUÇÃO', 'OPER. MAQUINA CNC'),
(447, 'LARISSA DA SILVEIRA LIMA', '3816096000', 'PRODUÇÃO', 'OPER. MAQUINA CNC'),
(450, 'VOLNI DA SILVA VICENTE', '42360803034', 'QUALIDADE', 'ENCARREGADA QUALIDAD'),
(451, 'JEFERSON PEDRÇO DOS SANTOS', '391647059', 'PREPARACAO', 'ENCARREGADO DE PRODU'),
(454, 'RUDIMAR JOS TRINDADE SOARES', '71195289049', 'PREPARACAO', 'PREPARADOR DE MAQUIN'),
(455, 'JULIO CESAR VIEIRA LUIZ JUNIOR', '3300454077', 'PRODUÇÃO', 'OPERADOR DE MAQUINA'),
(460, 'CAMILA SANTOS DA CRUZ', '3316183035', 'QUALIDADE EXTERNA', 'AUXILIAR DE QUALIDAD'),
(464, 'PAULO ROBERTO SCHARDOZIM JACOBI', '35166878000', 'PREPARACAO', 'OPER. MAQUINA'),
(466, 'ADAUTO BOFF', '47271680063', 'PREPARACAO', 'OPER. MAQUINA CNC'),
(469, 'MARLON DA SILVEIRA LEAL', '99866374068', 'EXPEDIÇÃO', 'AUXILIAR DE EXPEDI€Ç'),
(470, 'CANDIDO NORBERTO DA SILVEIRA RODRIGUES', '96290617087', 'PROCESSOS', 'ANALISTA DE PROCESSO'),
(473, 'MARCOS DE SOUZA XAVIER', '89713923049', 'PRODUÇÃO', 'OPERADOR DE MAQUINA'),
(474, 'CRISTIANE LOPES DE OLIVEIRA', '904152057', 'PRODUÇÃO', 'AUX. DE PRODUÇÃO'),
(476, 'JOSE VANDERLEI ALVES DE FREITAS', '56957483053', 'PRODUÇÃO', 'OPER. MAQUINA CNC'),
(477, 'CELSO LIMA DA SILVA', '88963683087', 'PRODUÇÃO', 'AUXILIAR DE PRODUÇÃO'),
(478, 'ALEXANDRO MOISES DALLA COSTA', '78211778068', 'PRODUÇÃO', 'OPER. MAQUINA CNC'),
(479, 'SERGIO DA SILVA MIRANDA', '46330798087', 'PRODUÇÃO', 'OPER. MAQUINA CNC'),
(480, 'JENYFER DA SILVA CARDOSO', '2475101067', 'PRODUÇÃO', 'AUX. DE PRODUÇÃO'),
(481, 'ANDERSON BENDO DOMINGUES', '2541046029', 'MANUTENÇÃO', 'AUXILIAR DE MANUTEN€'),
(482, 'MARINA DA SILVA MENEZES', '3419271042', 'PRODUÇÃO', 'AUX. DE PRODUÇÃO'),
(485, 'DAIANE SANTOS DE MORAIS', '3766408046', 'PRODUÇÃO', 'OPER. MAQUINA CNC'),
(486, 'ELIZANDRA FARINHA NUNES', '640408010', 'PRODUÇÃO', 'AUXILIAR DE PRODUÇÃO'),
(490, 'MARCELO DA SILVEIRA REIS', '97552356049', 'PRODUÇÃO', 'OPER. MAQUINA CNC'),
(493, 'EMANUEL DOS SANTOS COELHO', '2907939041', 'QUALIDADE', 'AUXILIAR DE QUALIDAD'),
(499, 'LEONARDO NUNES DA SILVA', '3737778094', 'PRODUÇÃO', 'OPER. MAQUINA CNC'),
(500, 'JOÇO RICARDO DA SILVA ROSA', '93684800015', 'PRODUÇÃO', 'OPER. MAQUINA CNC'),
(501, 'TAINARA DIAS MARTINS', '1852428040', 'ADMINISTRATIVO', 'AUXILIAR ADMINISTRAT'),
(503, 'JULIANO LUIS DA SILVA', '459919016', 'PRODUÇÃO', 'OPER. MAQUINA CNC'),
(504, 'EDEMAR BATISTA CHAVES', '58177833049', 'PRODUÇÃO', 'OPER. MAQUINA CNC'),
(507, 'EDERSON GAI NUNES', '476174031', 'PRODUÇÃO', 'OPER. MAQUINA CNC'),
(508, 'JOS HILµRIO TEIXEIRA', '37295110097', 'PRODUÇÃO', 'OPER. MAQUINA CNC'),
(510, 'THIAGO DA SILVA DE SOUZA', '1041159048', 'PRODUÇÃO', 'OPERADOR DE MAQUINA'),
(512, 'MATEUS DUARTE SOUZA', '1959583069', 'PRODUÇÃO', 'OPER. MAQUINA CNC'),
(513, 'JOS MURILO MACHADO DA SILVA', '2912989078', 'PRODUÇÃO', 'OPER. MAQUINA CNC'),
(515, 'GUILHERME SOUZA DOS SANTOS', '4064244036', 'PRODUÇÃO', 'OPERADOR DE MAQUINA'),
(518, 'NORTHON ANDRADE MACHADO', '3858888052', 'PRODUÇÃO', 'OPER. MAQUINA'),
(519, 'SERGIO QUEIROZ LOPES', '69318123000', 'PRODUÇÃO', 'OPER. MAQUINA CNC'),
(521, 'FABIANO DA SILVA µVILA', '2335996061', 'PREPARACAO', 'PREPARADOR DE MAQUIN'),
(522, 'DENIS ALEX DE ALMEIDA', '82186871068', 'PROCESSOS', 'AUXILIAR DE PROCESSO'),
(524, 'LUCAS DE OLIVEIRA DORNELES', '2915856044', 'MANUTENÇÃO', 'AUXILIAR DE MANUTEN€'),
(526, 'ANDERSON GARCIA DA ROSA', '2367119031', 'QUALIDADE', 'AUXILIAR DE QUALIDAD'),
(529, 'GABRIEL BRENTANO', '2188247000', 'PREPARACAO', 'OPER. MAQUINA CNC'),
(530, 'EDSON LUIS DA SILVA SOARES', '93897502020', 'PRODUÇÃO', 'OPER. MAQUINA CNC'),
(533, 'EDSON RENAN SARMENTO GOMES', '82349380025', 'PRODUÇÃO', 'OPER. MAQUINA CNC'),
(534, 'ODALGIRO FERREIRA PINTO', '44095082020', 'PRODUÇÃO', 'AUX. DE PRODUÇÃO'),
(535, 'LUCAS DE OLIVEIRA DA LUZ', '3185649044', 'PRODUÇÃO', 'OPERADOR DE MAQUINA'),
(545, 'IGOR WILLIAM DOS SANTOS FERREIRA', '4119970094', 'PRODUÇÃO', 'OPER. MAQUINA CNC'),
(553, 'ALEXANDRE CARVALHO DA SILVA', '64694755072', 'PRODUÇÃO', 'OPER. MAQUINA CNC'),
(555, 'LUCAS JUNIOR DE PAULA BARBOZA', '1607039052', 'PRODUÇÃO', 'OPER. MAQUINA CNC'),
(556, 'ADRIANA TRENTIN', '92539262015', 'QUALIDADE EXTERNA', 'AUXILIAR DE QUALIDAD'),
(558, 'ANGELICA PEREIRA SARAIVA', '680666001', 'PRODUÇÃO', 'OPER. MAQUINA CNC'),
(560, 'ANDERSON CARNEIRO SEIDENKRANZ', '827815085', 'QUALIDADE', 'AUXILIAR DE QUALIDAD'),
(562, 'BRUNO SCHMITZ ORTIZ', '3617235042', 'PRODUÇÃO', 'OPER. MAQUINA CNC'),
(563, 'ANDRIEL CARVALHO DA ROSA', '4233021080', 'PRODUÇÃO', 'OPER. MAQUINA CNC'),
(564, 'ELISANDRO FRAGA PEREIRA', '47644044', 'PRODUÇÃO', 'OPERADOR DE MAQUINA'),
(565, 'LEONEL DA ROSA VIEIRA', '3978199009', 'PRODUÇÃO', 'OPERADOR DE MAQUINA'),
(566, 'EDUARDO PINHEIRO DAVILA', '3974092064', 'PRODUÇÃO', 'OPER. MAQUINA CNC'),
(567, 'LUCIANO JUNIOR VERA DE MELLO', '85263761015', 'PRODUÇÃO', 'OPER. MAQUINA'),
(569, 'EGIDIO JOÇO KERBER', '31640290044', 'PRODUÇÃO', 'OPER. MAQUINA'),
(570, 'JULIANO CARDOSO CUNHA', '4206144001', 'PRODUÇÃO', 'OPER. MAQUINA'),
(571, 'MANOEL RENATO LOPES PEREIRA', '41545915091', 'PREPARACAO', 'SOLDADOR'),
(573, 'WILLIAM SILVA DA SILVEIRA', '3215600005', 'PRODUÇÃO', 'OPERADOR DE MAQUINA'),
(574, 'ISAIAS PEREIRA DOS SANTOS', '55572804053', 'PREPARACAO', 'OPERADOR DE MAQUINA'),
(581, 'ALEXANDRE HENRIQUE CONCEI€ÇO RODRIGUES', '2946059081', 'EXPEDIÇÃO', 'AUXILIAR DE EXPEDI€Ç'),
(590, 'ELTON FELIPE GULARTE DOS SANTOS', '3895223093', 'QUALIDADE', 'AUXILIAR DE QUALIDAD'),
(591, 'PATRICIA MATTOS MORALES', '1180236084', 'ADMINISTRATIVO', 'AUXILIAR DE LIMPEZA'),
(593, 'CARLOS HENRIQUE DA CUNHA ROMAN', '845154060', 'PRODUÇÃO', 'OPER. MAQUINA CNC'),
(594, 'JEFERSON DURAND NUNES', '207011010', 'PRODUÇÃO', 'OPER. MAQUINA CNC'),
(595, 'MATEUS RIBEIRO DE MATOS', '2426938064', 'PRODUÇÃO', 'OPER. MAQUINA CNC'),
(596, 'BRUNO MICHAEL RODRIGUES DA SILVA', '2816461041', 'PRODUÇÃO', 'OPER. MAQUINA CNC'),
(597, 'SANDRO DE FREITAS INACIO', '70760950091', 'PRODUÇÃO', 'OPER. MAQUINA CNC'),
(599, 'CARLOS ALEXANDRE MENDON€A DA ROCHA', '434004006', 'PRODUÇÃO', 'OPER. MAQUINA CNC'),
(600, 'CLAUDIOMIRO LEITE', '74294741015', 'PRODUÇÃO', 'OPER. MAQUINA'),
(601, 'CLEBER RONI DA SILVA FREIRE', '353842044', 'PRODUÇÃO', 'OPER. MAQUINA CNC'),
(602, 'JOSE EDUARDO DA SILVA LUIZ', '2304030009', 'PRODUÇÃO', 'OPER. MAQUINA CNC'),
(603, 'ANDRE DA SILVA OLIVEIRA', 'BLOQUETO GE', 'T.I', 'AUXILIAR DE INFORMAT'),
(604, 'JOICE DA ROCHA SALA', '84921609004', 'VENDAS', 'AUXILIAR ADMINISTRAT'),
(614, 'VERA LUCIA ZWETSCH', '90679989072', 'PRODUÇÃO', 'AUX. DE PRODUÇÃO'),
(616, 'MARRARA KATRIELE BATISTA ROCHA', '4162453071', 'PRODUÇÃO', 'AUX. DE PRODUÇÃO'),
(619, 'ARTHUR RODRIGUES FREITAS', '4298408027', 'PCP', 'AUXILIAR DE PCP'),
(620, 'PAULO ROBERTO RODRIGUES DORNELES', '51891042068', 'PRODUÇÃO', 'OPER. MAQUINA CNC'),
(621, 'JONES RODRIGUES', '35153695034', 'PRODUÇÃO', 'AUXILIAR DE PRODUÇÃO'),
(622, 'ISRAEL SILVEIRA DE LIMA', '91097754049', 'PRODUÇÃO', 'OPER. MAQUINA CNC'),
(624, 'AMARILDO LEMES DIAS', '98376527053', 'PRODUÇÃO', 'OPER. MAQUINA CNC'),
(625, 'DALTRO OLIVEIRA DE OLIVEIRA', '62570943053', 'PREPARACAO', 'AUX. DE PRODUÇÃO'),
(626, 'ROGER BABINTON DE OLIVEIRA MAGALHAES', '97899623049', 'PRODUÇÃO', 'OPER. MAQUINA CNC'),
(628, 'NATHALIA NICOLINI DE OLIVEIRA', '3431683088', 'PROCESSOS', 'AUXILIAR DE PROCESSO'),
(629, 'WALDEMAR MARTINS MATIOLA', '51538709015', 'QUALIDADE', 'INSPETOR DE QUALIDAD'),
(672, 'PAULO ROBERTO HUBNER', '51078767068', 'EXPEDIÇÃO', 'AUXILIAR DE EXPEDI€Ç'),
(673, 'FABIANA PEREIRA PAIXÇO', '99425475504', 'TECNICO DE SEGURANCA', 'TCNICA DE SEGURAN€A'),
(679, 'PAULO GILBERTO MELO GUTERRES', '33033951015', 'PRODUÇÃO', 'AUX. DE PRODUÇÃO'),
(680, 'ALEXANDRE DA ROSA DE ANDRADE', '598878009', 'PRODUÇÃO', 'AUX. DE PRODUÇÃO'),
(682, 'MAICON DOUGLAS COSTA VIEIRA', '3904314009', 'PCP', 'ESTAGIARIO'),
(683, 'GUILHERME ZIMMER LINHAR', '4160912028', 'PRODUÇÃO', 'OPERADOR DE MAQUINA'),
(684, 'MAURICIO RIBEIRO DE OLIVEIRA', '69531919020', 'PREPARACAO', 'OPER. MAQUINA CNC'),
(689, 'MATHEUS STANGUERLIN', '85442208000', 'PRODUÇÃO', 'OPER. MAQUINA CNC'),
(690, 'FABRICIO BARBOSA VENCATO', '85391514053', 'MANUTENÇÃO', 'ESTAGIµRIO'),
(691, 'DOUGLAS VAZ ADAM', '99381109087', 'PRODUÇÃO', 'OPER. MAQUINA CNC'),
(692, 'GEDILSON MATEUS LEAL', '1173369040', 'PRODUÇÃO', 'OPER. MAQUINA CNC'),
(693, 'DANIEL GOMES MACHADO', '403534003', 'PRODUÇÃO', 'AUX. DE PRODUÇÃO'),
(695, 'MANOEL MOISES ALVES VELLEDA', '57735328087', 'PREPARACAO', 'AUX. DE PRODUÇÃO'),
(2081, 'DANIELE DIAS DOS REIS', '4022032081', 'ADMINISTRATIVO', 'ESTAGIµRIA'),
(6150, 'GUILHERME KLAFKE VARGAS', '3981848012', 'QUALIDADE', 'AUXILIAR DE QUALIDAD'),
(6871, 'SAMUEL KAFER NEUMANN', '2841595064', 'ALMOXARIFADO', 'AUXILIAR ALMOXARIFAD'),
(8039, 'NICOLE GIULIAN LEITE VIEIRA', '4324748039', 'ADMINISTRATIVO', 'ESTAGIµRIA'),
(8057, 'GUILHERME SANTOS DE CASTRO', '4704638057', 'PROCESSOS', 'ESTAGIARIO'),
(9079, 'GABRIEL FELIPE CARDOSO BOGO', '4212919079', 'PROCESSOS', 'ESTAGIARIO');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbparcela`
--

CREATE TABLE `tbparcela` (
  `codParcela` int(10) UNSIGNED NOT NULL,
  `fr_codFuncionario` int(11) NOT NULL,
  `fr_codPro` int(11) NOT NULL,
  `valorParcela` double NOT NULL,
  `dataVencParcela` date NOT NULL,
  `statusParcela` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tbparcela`
--

INSERT INTO `tbparcela` (`codParcela`, `fr_codFuncionario`, `fr_codPro`, `valorParcela`, `dataVencParcela`, `statusParcela`) VALUES
(24, 10, 3, 73.54666666666667, '2020-04-05', 1),
(25, 10, 3, 73.54666666666667, '2020-04-05', 1),
(26, 10, 3, 73.54666666666667, '2020-04-05', 1),
(27, 24, 1, 100, '2020-04-05', 1),
(28, 24, 1, 100, '2020-04-05', 1),
(29, 24, 1, 100, '2020-04-05', 1),
(30, 24, 1, 100, '2020-04-05', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbprocedimento`
--

CREATE TABLE `tbprocedimento` (
  `codPro` int(255) NOT NULL,
  `nomePro` varchar(150) NOT NULL,
  `valorPro` double NOT NULL,
  `parcelaPro` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tbprocedimento`
--

INSERT INTO `tbprocedimento` (`codPro`, `nomePro`, `valorPro`, `parcelaPro`) VALUES
(1, 'Consulta em pronto socorro', 15, 1),
(2, 'Consulta em consultorio com hora marcada', 15, 1),
(3, 'Tomografia computadorizada', 220.64, 3),
(4, 'Ecografia abdomem total', 92, 2),
(5, 'Radiografia panoramica mandibular', 15, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbusuarios`
--

CREATE TABLE `tbusuarios` (
  `codUsuario` int(255) NOT NULL,
  `nomeUsuario` varchar(250) NOT NULL,
  `setorUsuario` varchar(150) NOT NULL,
  `cargoUsuario` varchar(150) NOT NULL,
  `loginUsuario` varchar(45) NOT NULL,
  `senhaUsuario` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tbusuarios`
--

INSERT INTO `tbusuarios` (`codUsuario`, `nomeUsuario`, `setorUsuario`, `cargoUsuario`, `loginUsuario`, `senhaUsuario`) VALUES
(1, 'admin', 'cpd', 'ti', 'admin', 'admin');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `tbcoparti`
--
ALTER TABLE `tbcoparti`
  ADD PRIMARY KEY (`codCop`);

--
-- Índices para tabela `tbesp`
--
ALTER TABLE `tbesp`
  ADD PRIMARY KEY (`codEsp`);

--
-- Índices para tabela `tbfuncionarios`
--
ALTER TABLE `tbfuncionarios`
  ADD PRIMARY KEY (`codFuncionario`),
  ADD UNIQUE KEY `codUsuario_UNIQUE` (`codFuncionario`),
  ADD UNIQUE KEY `cpfFuncionario_UNIQUE` (`cpfFuncionario`);

--
-- Índices para tabela `tbparcela`
--
ALTER TABLE `tbparcela`
  ADD PRIMARY KEY (`codParcela`);

--
-- Índices para tabela `tbprocedimento`
--
ALTER TABLE `tbprocedimento`
  ADD PRIMARY KEY (`codPro`);

--
-- Índices para tabela `tbusuarios`
--
ALTER TABLE `tbusuarios`
  ADD PRIMARY KEY (`codUsuario`),
  ADD UNIQUE KEY `codUsuario_UNIQUE` (`codUsuario`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `tbcoparti`
--
ALTER TABLE `tbcoparti`
  MODIFY `codCop` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT de tabela `tbesp`
--
ALTER TABLE `tbesp`
  MODIFY `codEsp` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de tabela `tbfuncionarios`
--
ALTER TABLE `tbfuncionarios`
  MODIFY `codFuncionario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9082;

--
-- AUTO_INCREMENT de tabela `tbparcela`
--
ALTER TABLE `tbparcela`
  MODIFY `codParcela` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT de tabela `tbprocedimento`
--
ALTER TABLE `tbprocedimento`
  MODIFY `codPro` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;