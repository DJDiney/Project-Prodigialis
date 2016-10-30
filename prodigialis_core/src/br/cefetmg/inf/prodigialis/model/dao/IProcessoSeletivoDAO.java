
package br.cefetmg.inf.prodigialis.model.dao;

import br.cefetmg.inf.prodigialis.model.domain.Participante;
import br.cefetmg.inf.prodigialis.util.db.exception.PersistenciaException;


public interface IProcessoSeletivoDAO {
    
    public boolean inserir(Participante obj) throws PersistenciaException;
    
}
