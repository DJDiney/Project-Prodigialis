
package br.cefetmg.inf.prodigialis.model.service;

import br.cefetmg.inf.prodigialis.model.domain.Prova;
import br.cefetmg.inf.prodigialis.util.db.exception.NegocioException;
import br.cefetmg.inf.prodigialis.util.db.exception.PersistenciaException;
import java.util.List;


public interface IManterProva {
    
    public boolean inserir(Prova obj) throws PersistenciaException, NegocioException;
    public boolean atualizar(Prova obj) throws PersistenciaException, NegocioException;
    
}
