
package br.cefetmg.inf.prodigialis.util.db.persistence;

import br.cefetmg.inf.prodigialis.util.db.exception.PersistenciaException;
import java.util.List;


public interface GenericConsultLongDAO<Entidade> {
    
    public Entidade consultarPorId(Long id) throws PersistenciaException;
    public List<Entidade> listarTodos() throws PersistenciaException;
    public Entidade consultarPorNome(String nome) throws PersistenciaException;
    
}