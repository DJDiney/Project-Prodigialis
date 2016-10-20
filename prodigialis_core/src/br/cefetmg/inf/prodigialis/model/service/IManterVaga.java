
package br.cefetmg.inf.prodigialis.model.service;

import br.cefetmg.inf.prodigialis.model.domain.Vaga;
import br.cefetmg.inf.prodigialis.util.db.exception.NegocioException;
import br.cefetmg.inf.prodigialis.util.db.exception.PersistenciaException;
import java.util.List;


public interface IManterVaga {
    
    public boolean inserir(Vaga obj) throws PersistenciaException, NegocioException;
    public boolean atualizar(Vaga obj) throws PersistenciaException, NegocioException;
    public Vaga consultarPorId(Long id) throws PersistenciaException;
    public List<Vaga> listarTodos() throws PersistenciaException;
    public Vaga consultarPorNome(String nome) throws PersistenciaException;
    
}
