package br.cefetmg.inf.prodigialis.util.db.persistence;

import br.cefetmg.inf.prodigialis.util.db.exception.PersistenciaException;

public interface GenericNamedDAO<Entidade> extends GenericDAO<Entidade> {
    
    public Entidade consultarPorNome(String nome) throws PersistenciaException;
    
}