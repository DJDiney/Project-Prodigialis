
package br.cefetmg.inf.prodigialis.model.service;

import br.cefetmg.inf.prodigialis.model.domain.Cargo;
import br.cefetmg.inf.prodigialis.util.db.exception.NegocioException;
import br.cefetmg.inf.prodigialis.util.db.exception.PersistenciaException;
import java.util.List;


public interface IManterCargo {
    
    public boolean inserir(Cargo obj) throws PersistenciaException, NegocioException;
    public boolean atualizar(Cargo obj) throws PersistenciaException, NegocioException;
    public Cargo consultarPorId(Long id) throws PersistenciaException;
    public List<Cargo> listarTodos() throws PersistenciaException;
    public Cargo consultarPorNome(String nome) throws PersistenciaException;
    
}
