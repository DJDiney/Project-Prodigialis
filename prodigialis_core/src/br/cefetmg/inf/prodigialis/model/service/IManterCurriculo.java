
package br.cefetmg.inf.prodigialis.model.service;

import br.cefetmg.inf.prodigialis.model.domain.Curriculo;
import br.cefetmg.inf.prodigialis.util.db.exception.NegocioException;
import br.cefetmg.inf.prodigialis.util.db.exception.PersistenciaException;
import java.util.List;


public interface IManterCurriculo {
    
    public boolean inserir(Curriculo obj) throws PersistenciaException, NegocioException;
    public boolean atualizar(Curriculo obj) throws PersistenciaException, NegocioException;
    public boolean excluir(Long id) throws PersistenciaException;
    public Curriculo consultarPorId(Long id) throws PersistenciaException;
    public List<Curriculo> listarTodos() throws PersistenciaException;
    
}
