
package br.cefetmg.inf.prodigialis.model.service.impl;

import br.cefetmg.inf.prodigialis.model.dao.IEstadoDAO;
import br.cefetmg.inf.prodigialis.model.dao.impl.EstadoDAO;
import br.cefetmg.inf.prodigialis.model.domain.Estado;
import br.cefetmg.inf.prodigialis.model.service.IManterEstado;
import br.cefetmg.inf.prodigialis.util.db.exception.PersistenciaException;
import java.util.List;


public class ManterEstado implements IManterEstado{
    
    private IEstadoDAO estadoDAO;
    
    public ManterEstado(){
    
        estadoDAO = new EstadoDAO();
    
    }
    
    
    @Override
    public List<Estado> listarTodos() throws PersistenciaException{
    
        List<Estado> listEstado = estadoDAO.listarTodos();
        return listEstado;
    
    }

    @Override
    public Estado consultarPorId(char id) throws PersistenciaException{
    
        Estado result = estadoDAO.consultarPorId(id);
        return result; 
    
    }
    
    @Override
    public Estado consultarPorNome(String nome) throws PersistenciaException{
    
        Estado result = estadoDAO.consultarPorNome(nome);
        return result; 
    
    }
    
}
