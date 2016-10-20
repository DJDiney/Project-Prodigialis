
package br.cefetmg.inf.prodigialis.model.service;

import br.cefetmg.inf.prodigialis.model.domain.Cidade;
import br.cefetmg.inf.prodigialis.util.db.exception.PersistenciaException;
import java.util.List;

public interface IManterCidade {
    
    public Cidade consultarPorId(char id) throws PersistenciaException;
    public List<Cidade> listarTodos() throws PersistenciaException;
    public Cidade consultarPorNome(String nome) throws PersistenciaException;
    
}