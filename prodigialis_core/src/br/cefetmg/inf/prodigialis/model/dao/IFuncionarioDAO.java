
package br.cefetmg.inf.prodigialis.model.dao;

import br.cefetmg.inf.prodigialis.model.domain.Funcionario;
import br.cefetmg.inf.prodigialis.util.db.exception.PersistenciaException;
import java.util.List;

public interface IFuncionarioDAO {

    public boolean inserir(Funcionario obj) throws PersistenciaException;
    public boolean atualizar(Funcionario obj) throws PersistenciaException;
    public boolean excluir(char id) throws PersistenciaException;
    public Funcionario consultarPorId(String id) throws PersistenciaException;
    public List<Funcionario> listarTodos() throws PersistenciaException;
    public Funcionario consultarPorNome(String nome) throws PersistenciaException;

}