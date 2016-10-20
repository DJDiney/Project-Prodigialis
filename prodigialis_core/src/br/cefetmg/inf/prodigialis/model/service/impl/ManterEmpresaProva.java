
package br.cefetmg.inf.prodigialis.model.service.impl;

import br.cefetmg.inf.prodigialis.model.dao.IEmpresaProvaDAO;
import br.cefetmg.inf.prodigialis.model.dao.impl.EmpresaProvaDAO;
import br.cefetmg.inf.prodigialis.model.domain.EmpresaProva;
import br.cefetmg.inf.prodigialis.model.service.IManterEmpresaProva;
import br.cefetmg.inf.prodigialis.util.db.exception.PersistenciaException;
import java.util.List;


public class ManterEmpresaProva implements IManterEmpresaProva {
    
    private IEmpresaProvaDAO empresaProvaDAO;
    
    public ManterEmpresaProva(){
    
        empresaProvaDAO = new EmpresaProvaDAO();
    
    }
    
    
    @Override
    public List<EmpresaProva> listarTodos() throws PersistenciaException{
    
        List<EmpresaProva> listEmpresaProva = empresaProvaDAO.listarTodos();
        return listEmpresaProva;
    
    }

    @Override
    public EmpresaProva consultarPorId(char id) throws PersistenciaException{
    
        EmpresaProva result = empresaProvaDAO.consultarPorId(id);
        return result; 
    
    }
    
    @Override
    public EmpresaProva consultarPorNome(String nome) throws PersistenciaException{
    
        EmpresaProva result = empresaProvaDAO.consultarPorNome(nome);
        return result; 
    
    }
    
}
