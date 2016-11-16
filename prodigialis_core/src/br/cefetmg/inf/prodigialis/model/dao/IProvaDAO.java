
package br.cefetmg.inf.prodigialis.model.dao;

import br.cefetmg.inf.prodigialis.model.domain.Participante;
import br.cefetmg.inf.prodigialis.model.domain.Prova;
import br.cefetmg.inf.prodigialis.util.db.exception.PersistenciaException;
import br.cefetmg.inf.prodigialis.util.db.persistence.GenericDAO;
import java.util.List;


public interface IProvaDAO{
    public boolean inserir(Prova obj) throws PersistenciaException;
    public boolean atualizar(Prova obj) throws PersistenciaException;
    public boolean excluir(int id) throws PersistenciaException;
    public Prova consultarPorId(int cod_prova) throws PersistenciaException;
    public List<Prova> listarTodos() throws PersistenciaException;

}
