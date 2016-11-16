
package br.cefetmg.inf.prodigialis.model.dao;

import br.cefetmg.inf.prodigialis.model.domain.Candidato;
import br.cefetmg.inf.prodigialis.util.db.exception.PersistenciaException;
import java.util.List;

public interface ICandidatoDAO{

    public boolean inserir(Candidato obj) throws PersistenciaException;
    public boolean atualizar(Candidato obj) throws PersistenciaException;
    public boolean excluir(char id) throws PersistenciaException;
    public Candidato consultarPorId(String id) throws PersistenciaException;
    public List<Candidato> listarTodos() throws PersistenciaException;
    public Candidato consultarPorNome(String nome) throws PersistenciaException;


}
