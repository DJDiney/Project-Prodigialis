
package br.cefetmg.inf.prodigialis.model.service;

import br.cefetmg.inf.prodigialis.model.domain.Funcionario;
import br.cefetmg.inf.prodigialis.util.db.exception.NegocioException;
import br.cefetmg.inf.prodigialis.util.db.exception.PersistenciaException;
import java.util.List;


public interface IManterFuncionario {
    
    public boolean inserir(Funcionario obj) throws PersistenciaException, NegocioException;
    public boolean atualizar(Funcionario obj) throws PersistenciaException, NegocioException;
    public boolean excluir(char id) throws PersistenciaException;
    public Funcionario consultarPorId(char id) throws PersistenciaException;
    public List<Funcionario> listarTodos() throws PersistenciaException;
    public Funcionario consultarPorNome(String nome) throws PersistenciaException;
    
}