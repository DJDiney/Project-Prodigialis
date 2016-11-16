
package br.cefetmg.inf.prodigialis.model.service;

import br.cefetmg.inf.prodigialis.model.domain.Participante;
import br.cefetmg.inf.prodigialis.util.db.exception.NegocioException;
import br.cefetmg.inf.prodigialis.util.db.exception.PersistenciaException;
import java.util.List;

public interface IManterParticipante {
    
    public boolean inserir(Participante obj) throws PersistenciaException, NegocioException;
    public boolean atualizar(Participante obj) throws PersistenciaException, NegocioException;
    
}
