
package br.cefetmg.inf.prodigialis.model.service;

import br.cefetmg.inf.prodigialis.model.domain.Entrevista;
import br.cefetmg.inf.prodigialis.util.db.exception.NegocioException;
import br.cefetmg.inf.prodigialis.util.db.exception.PersistenciaException;
import java.util.List;


public interface IManterEntrevista {
    
    public boolean inserir(Entrevista obj) throws PersistenciaException, NegocioException;
    public boolean atualizar(Entrevista obj) throws PersistenciaException, NegocioException;
    
}
