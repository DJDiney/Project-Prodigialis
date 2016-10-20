package br.cefetmg.inf.prodigialis.util.db.persistence;

import br.cefetmg.inf.prodigialis.util.db.exception.PersistenciaException;
import java.util.List;

public interface GenericDAO<Entidade> {

    public boolean inserir(Entidade obj) throws PersistenciaException;
    public boolean atualizar(Entidade obj) throws PersistenciaException;
    public boolean excluir(Long id) throws PersistenciaException;
    public Entidade consultarPorId(Long id) throws PersistenciaException;
    public List<Entidade> listarTodos() throws PersistenciaException;

}