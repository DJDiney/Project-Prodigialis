
package br.cefetmg.inf.prodigialis.model.dao;

import br.cefetmg.inf.prodigialis.model.domain.ProcessoSeletivo;
import br.cefetmg.inf.prodigialis.util.db.exception.PersistenciaException;
import java.util.List;


public interface IProcessoSeletivoDAO {

    public boolean inserir(ProcessoSeletivo obj) throws PersistenciaException;
    public boolean atualizar(ProcessoSeletivo obj, String antigo) throws PersistenciaException;
    public boolean excluir(String nome) throws PersistenciaException;
    public ProcessoSeletivo consultarPorId(Long id) throws PersistenciaException;
    public List<ProcessoSeletivo> listarTodos() throws PersistenciaException;
    public ProcessoSeletivo consultarPorNome(String nome) throws PersistenciaException;
    public List<ProcessoSeletivo> consultarPorNomeDistinto() throws PersistenciaException;
    public List<ProcessoSeletivo> consultarPorNomeDistintoUnico() throws PersistenciaException;
    
}
