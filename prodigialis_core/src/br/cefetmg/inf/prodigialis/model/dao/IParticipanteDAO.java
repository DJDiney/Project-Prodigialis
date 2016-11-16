
package br.cefetmg.inf.prodigialis.model.dao;

import br.cefetmg.inf.prodigialis.model.domain.Participante;
import br.cefetmg.inf.prodigialis.util.db.exception.PersistenciaException;
import br.cefetmg.inf.prodigialis.util.db.persistence.GenericDAO;
import java.util.List;


public interface IParticipanteDAO{
    public boolean inserir(Participante obj) throws PersistenciaException;
    public boolean atualizar(Participante obj) throws PersistenciaException;
    public boolean excluir(int id) throws PersistenciaException;
    public Participante consultarPorId(int id) throws PersistenciaException;
    public List<Participante> listarTodos() throws PersistenciaException;
}