
package br.cefetmg.inf.prodigialis.model.service.impl;

import br.cefetmg.inf.prodigialis.model.dao.IEntrevistaDAO;
import br.cefetmg.inf.prodigialis.model.dao.impl.EntrevistaDAO;
import br.cefetmg.inf.prodigialis.model.domain.Entrevista;
import br.cefetmg.inf.prodigialis.model.service.IManterEntrevista;
import br.cefetmg.inf.prodigialis.util.db.exception.NegocioException;
import br.cefetmg.inf.prodigialis.util.db.exception.PersistenciaException;
import java.util.List;


public class ManterEntrevista implements IManterEntrevista{
    
    private IEntrevistaDAO entrevistaDAO;
    
    public ManterEntrevista(){
    
        entrevistaDAO = new EntrevistaDAO();
    
    }
    
    @Override
    public boolean inserir(Entrevista entrevista) throws PersistenciaException, NegocioException{
    
        if(entrevista == null)
            
            throw new NegocioException("Dados do entrevista não foram informados.");
        
        if(entrevista.getCandidato() == null)
            
            throw new NegocioException("Candidato deve ser informado.");
        
        if(entrevista.getFuncionario() == null)
            
            throw new NegocioException("Funcionario deve ser informado.");
        
        if(entrevista.getDat_ent() == null)
            
            throw new NegocioException("Data deve ser informada.");
        
        
        boolean entrevistaCod = entrevistaDAO.inserir(entrevista);
        
        return entrevistaCod;
    
    }

    @Override
    public boolean atualizar(Entrevista entrevista) throws PersistenciaException, NegocioException{
    
        if(entrevista == null)
            
            throw new NegocioException("Dados do entrevista não foram informados.");
        
        if(entrevista.getCod_ent() == null)
            
            throw new NegocioException("Codigo da entrevista deve ser informado.");
            
        if(entrevista.getCandidato() == null)
            
            throw new NegocioException("Candidato deve ser informado.");
        
        if(entrevista.getFuncionario() == null)
            
            throw new NegocioException("Funcionario deve ser informado.");
        
        if(entrevista.getDat_ent() == null)
            
            throw new NegocioException("Data deve ser informada.");
        
        
        boolean result = entrevistaDAO.atualizar(entrevista);
        
        return result;
    
    }

    @Override
    public boolean excluir(Long id) throws PersistenciaException{
    
        boolean result = entrevistaDAO.excluir(id);
        return result; 
        
    }

    @Override
    public List<Entrevista> listarTodos() throws PersistenciaException{
    
        List<Entrevista> listEntrevista = entrevistaDAO.listarTodos();
        return listEntrevista;
    
    }

    @Override
    public Entrevista consultarPorId(Long id) throws PersistenciaException{
    
        Entrevista result = entrevistaDAO.consultarPorId(id);
        return result; 
    
    }
    
}
