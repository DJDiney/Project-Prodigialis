
package br.cefetmg.inf.prodigialis.model.service.impl;

import br.cefetmg.inf.prodigialis.model.dao.IVagaDAO;
import br.cefetmg.inf.prodigialis.model.dao.impl.VagaDAO;
import br.cefetmg.inf.prodigialis.model.domain.Vaga;
import br.cefetmg.inf.prodigialis.model.service.IManterVaga;
import br.cefetmg.inf.prodigialis.util.db.exception.NegocioException;
import br.cefetmg.inf.prodigialis.util.db.exception.PersistenciaException;
import java.util.List;


public class ManterVaga implements IManterVaga{
    
    private IVagaDAO vagaDAO;
    
    public ManterVaga(){
    
        vagaDAO = new VagaDAO();
    
    }
    
    @Override
    public boolean inserir(Vaga vaga) throws PersistenciaException, NegocioException{
    
        if(vaga == null)
            
            throw new NegocioException("Dados do vaga não foram informados.");
        
       
        if(vaga.getNom_cargo() == null || vaga.getNom_cargo().equals(' '))
            
            throw new NegocioException("Nome do cargo deve ser informado.");
        
        if(vaga.getDesc_cargo() == null || vaga.getDesc_cargo().equals(' '))
            
            throw new NegocioException("Descriao do cargo deve ser informada.");
        
        
        boolean vagaCod = vagaDAO.inserir(vaga);
        
        return vagaCod;
    
    }

    @Override
    public boolean atualizar(Vaga vaga) throws PersistenciaException, NegocioException{
    
        if(vaga == null)
            
            throw new NegocioException("Dados do vaga não foram informados.");
        
       
        if(vaga.getCod_cargo() == null)
            
            throw new NegocioException("Codigo do cargo deve ser informado.");
        

        if(vaga.getNom_cargo() == null || vaga.getNom_cargo().equals(' '))
            
            throw new NegocioException("Nome do cargo deve ser informado.");
        
        if(vaga.getDesc_cargo() == null || vaga.getDesc_cargo().equals(' '))
            
            throw new NegocioException("Descriao do cargo deve ser informada.");
        
        
        boolean result = vagaDAO.atualizar(vaga);
        
        return result;
    
    }

    @Override
    public List<Vaga> listarTodos() throws PersistenciaException{
    
        List<Vaga> listVaga = vagaDAO.listarTodos();
        return listVaga;
    
    }

    @Override
    public Vaga consultarPorId(Long id) throws PersistenciaException{
    
        Vaga result = vagaDAO.consultarPorId(id);
        return result; 
    
    }
    
    @Override
    public Vaga consultarPorNome(String nome) throws PersistenciaException{
    
        Vaga result = vagaDAO.consultarPorNome(nome);
        return result; 
    
    }
    
}
