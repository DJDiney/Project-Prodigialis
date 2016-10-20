
package br.cefetmg.inf.prodigialis.model.service;

import br.cefetmg.inf.prodigialis.model.domain.EmpresaProva;
import br.cefetmg.inf.prodigialis.util.db.exception.PersistenciaException;
import java.util.List;


public interface IManterEmpresaProva {
    
    public EmpresaProva consultarPorId(char id) throws PersistenciaException;
    public List<EmpresaProva> listarTodos() throws PersistenciaException;
    public EmpresaProva consultarPorNome(String nome) throws PersistenciaException;
    
}
