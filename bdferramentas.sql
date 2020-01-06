-- Banco de dados: `bdferramentas`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `ferramentasatr`
--

CREATE TABLE `ferramentasatr` (
  `cod` int(11) NOT NULL,
  `tbmaquinas_codigoMaquina` varchar(200) NOT NULL,
  `tbferramentas_codigoFerramenta` varchar(200) NOT NULL,
  `codigoProduto` varchar(200) NOT NULL,
  `dataLancamento` date DEFAULT NULL,
  `horaLancamento` time DEFAULT NULL,
  `tbusuarios_loginUsuario` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `lancamentoferramentas`
--

CREATE TABLE `lancamentoferramentas` (
  `cod` int(11) NOT NULL,
  `tipolancamento` varchar(200) NOT NULL,
  `tbferramentasatr_tbmaquinas_codigoMaquina` varchar(200) NOT NULL,
  `tbferramentasatr_tbferramentas_codigoFerramenta` varchar(200) NOT NULL,
  `tbferramentasatr_codigoProduto` varchar(200) NOT NULL,
  `tbferramentasatr_dataLancamento` date DEFAULT NULL,
  `tbferramentasatr_horaLancamento` time DEFAULT NULL,
  `tbferramentasatr_tbusuarios_loginUsuario` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbferramentas`
--

CREATE TABLE `tbferramentas` (
  `cod` int(11) NOT NULL,
  `codigoFerramenta` varchar(200) NOT NULL,
  `nomeFerramenta` varchar(45) NOT NULL,
  `descriFerramenta` varchar(45) NOT NULL,
  `tempCaliFerramenta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbmaquinas`
--

CREATE TABLE `tbmaquinas` (
  `cod` int(11) NOT NULL,
  `codigoMaquina` varchar(200) NOT NULL,
  `nomeMaquina` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbusuarios`
--

CREATE TABLE `tbusuarios` (
  `codUsuario` int(11) NOT NULL,
  `nomeUsuario` varchar(200) NOT NULL,
  `setorUsuario` varchar(200) NOT NULL,
  `loginUsuario` varchar(200) NOT NULL,
  `senhaUsuario` varchar(200) NOT NULL,
  `emailUsuario` varchar(200) NOT NULL,
  `cargoUsuario` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tbusuarios`
--

INSERT INTO `tbusuarios` (`codUsuario`, `nomeUsuario`, `setorUsuario`, `loginUsuario`, `senhaUsuario`, `emailUsuario`, `cargoUsuario`) VALUES
(1, 'admin', 'admin', 'admin', 'admin', 'admin', 'admin');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `ferramentasatr`
--
ALTER TABLE `ferramentasatr`
  ADD PRIMARY KEY (`cod`,`tbmaquinas_codigoMaquina`,`tbferramentas_codigoFerramenta`);

--
-- Índices para tabela `lancamentoferramentas`
--
ALTER TABLE `lancamentoferramentas`
  ADD PRIMARY KEY (`cod`);

--
-- Índices para tabela `tbferramentas`
--
ALTER TABLE `tbferramentas`
  ADD PRIMARY KEY (`cod`);

--
-- Índices para tabela `tbmaquinas`
--
ALTER TABLE `tbmaquinas`
  ADD PRIMARY KEY (`cod`);

--
-- Índices para tabela `tbusuarios`
--
ALTER TABLE `tbusuarios`
  ADD PRIMARY KEY (`codUsuario`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `ferramentasatr`
--
ALTER TABLE `ferramentasatr`
  MODIFY `cod` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- AUTO_INCREMENT de tabela `lancamentoferramentas`
--
ALTER TABLE `lancamentoferramentas`
  MODIFY `cod` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT de tabela `tbferramentas`
--
ALTER TABLE `tbferramentas`
  MODIFY `cod` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `tbmaquinas`
--
ALTER TABLE `tbmaquinas`
  MODIFY `cod` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `tbusuarios`
--
ALTER TABLE `tbusuarios`
  MODIFY `codUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;