-- --------------------------------------------------------
-- Servidor:                     localhost
-- Versão do servidor:           PostgreSQL 9.6.0, compiled by Visual C++ build 1800, 64-bit
-- OS do Servidor:               
-- HeidiSQL Versão:              9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES  */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
-- Copiando dados para a tabela public.estado: 0 rows
/*!40000 ALTER TABLE "estado" DISABLE KEYS */;
INSERT INTO "estado" ("uf", "nom_est") VALUES
	(E'MG', E'Minas Gerais'),
	(E'AC', E'Acre'),
	(E'AL', E'Alagoas'),
	(E'AP', E'Amapá'),
	(E'AM', E'Amazonas	'),
	(E'BA', E'Bahia'),
	(E'CE', E'Ceará'),
	(E'DF', E'Distrito Federal'),
	(E'ES', E'Espírito Santo	'),
	(E'GO', E'Goiás'),
	(E'MA', E'Maranhão'),
	(E'MT', E'Mato Grosso'),
	(E'MS', E'Mato Grosso do Sul'),
	(E'PA', E'Pará'),
	(E'PB', E'Paraíba'),
	(E'PR', E'Paraná'),
	(E'PE', E'Pernambuco'),
	(E'PI', E'Piauí'),
	(E'RJ', E'Rio de Janeiro'),
	(E'RN', E'Rio Grande do Norte'),
	(E'RS', E'Rio Grande do Sul'),
	(E'RO', E'Rondônia'),
	(E'RR', E'Roraima'),
	(E'SC', E'Santa Catarina'),
	(E'SP', E'São Paulo'),
	(E'SE', E'Sergipe'),
	(E'TO', E'Tocantins');
/*!40000 ALTER TABLE "estado" ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
