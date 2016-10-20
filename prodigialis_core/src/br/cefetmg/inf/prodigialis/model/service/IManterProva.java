
package br.cefetmg.inf.prodigialis.model.service;

import br.cefetmg.inf.prodigialis.model.domain.Prova;
import br.cefetmg.inf.prodigialis.util.db.exception.NegocioException;
import br.cefetmg.inf.prodigialis.util.db.exception.PersistenciaException;
import java.util.List;


public interface IManterProva {
    
    public boolean inserir(Prova obj) throws PersistenciaException, NegocioException;
    public boolean atualizar(Prova obj) throws PersistenciaException, NegocioException;
    public boolean excluir(Long id) throws PersistenciaException;
    public Prova consultarPorId(Long id) throws PersistenciaException;
    public List<Prova> listarTodos() throws PersistenciaException;
    
}
