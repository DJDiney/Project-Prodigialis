
package br.cefetmg.inf.prodigialis.util.db.persistence;

import br.cefetmg.inf.prodigialis.util.db.exception.PersistenciaException;
import java.util.List;

public interface GenericConsultCharDAO<Entidade> {
    
    public Entidade consultarPorId(char id) throws PersistenciaException;
    public List<Entidade> listarTodos() throws PersistenciaException;
    public Entidade consultarPorNome(String nome) throws PersistenciaException;
    
}