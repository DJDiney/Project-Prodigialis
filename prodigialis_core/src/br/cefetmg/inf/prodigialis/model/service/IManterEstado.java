
package br.cefetmg.inf.prodigialis.model.service;

import br.cefetmg.inf.prodigialis.model.domain.Estado;
import br.cefetmg.inf.prodigialis.util.db.exception.PersistenciaException;
import java.util.List;

public interface IManterEstado {
    
    public Estado consultarPorId(char id) throws PersistenciaException;
    public List<Estado> listarTodos() throws PersistenciaException;
    public Estado consultarPorNome(String nome) throws PersistenciaException;
    
}