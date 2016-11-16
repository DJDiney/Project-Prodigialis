
package br.cefetmg.inf.prodigialis.model.service.impl;

import br.cefetmg.inf.prodigialis.model.dao.ICurriculoDAO;
import br.cefetmg.inf.prodigialis.model.dao.impl.CurriculoDAO;
import br.cefetmg.inf.prodigialis.model.domain.Curriculo;
import br.cefetmg.inf.prodigialis.model.service.IManterCurriculo;
import br.cefetmg.inf.prodigialis.util.db.exception.NegocioException;
import br.cefetmg.inf.prodigialis.util.db.exception.PersistenciaException;
import java.util.List;


public class ManterCurriculo implements IManterCurriculo{
    
    private ICurriculoDAO curriculoDAO;
    
    public ManterCurriculo(){
    
        curriculoDAO = new CurriculoDAO();
    
    }
    
    @Override
    public boolean inserir(Curriculo curriculo) throws PersistenciaException, NegocioException{
    
        if(curriculo == null)
            
            throw new NegocioException("Dados do curriculo não foram informados.");
        
       
        if(curriculo.getArq_cur() == null)
            
            throw new NegocioException("Arquivo deve ser carregado.");
        
        
        boolean curriculoCod = curriculoDAO.inserir(curriculo);
        
        return curriculoCod;
    
    }

    @Override
    public boolean atualizar(Curriculo curriculo) throws PersistenciaException, NegocioException{
    
        if(curriculo == null)
            
            throw new NegocioException("Dados do curriculo não foram informados.");
        
       
        if(curriculo.getCod_cur() == null)
            
            throw new NegocioException("Codigo do curriculo deve ser informado.");
        

        if(curriculo.getArq_cur() == null)
            
            throw new NegocioException("Arquivo deve ser carregado.");
        
        
        if((curriculo.getPath_cur() == null || curriculo.getPath_cur().equals(' ')))
            
            throw new NegocioException("Path do arquivo deve ser informado.");
        
        
        boolean result = curriculoDAO.atualizar(curriculo);
        
        return result;
    
    }

    @Override
    public boolean excluir(Long id) throws PersistenciaException{
    
        boolean result = curriculoDAO.excluir(id);
        return result; 
        
    }

    @Override
    public List<Curriculo> listarTodos() throws PersistenciaException{
    
        List<Curriculo> listCurriculo = curriculoDAO.listarTodos();
        return listCurriculo;
    
    }

    
    
}
