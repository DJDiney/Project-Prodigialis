package br.cefetmg.inf.prodigialis.model.service;

import br.cefetmg.inf.prodigialis.model.domain.Participante;
import br.cefetmg.inf.prodigialis.model.domain.ProcessoSeletivo;
import br.cefetmg.inf.prodigialis.util.db.exception.NegocioException;
import br.cefetmg.inf.prodigialis.util.db.exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author Cliente
 */
public interface IManterProcessoSeletivo {
    public boolean inserir(ProcessoSeletivo obj) throws PersistenciaException, NegocioException;
    public boolean atualizar(ProcessoSeletivo obj) throws PersistenciaException, NegocioException;
}
