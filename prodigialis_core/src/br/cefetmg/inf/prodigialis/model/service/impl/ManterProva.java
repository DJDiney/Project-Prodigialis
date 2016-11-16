
package br.cefetmg.inf.prodigialis.model.service.impl;

import br.cefetmg.inf.prodigialis.model.dao.IProvaDAO;
import br.cefetmg.inf.prodigialis.model.dao.impl.ProvaDAO;
import br.cefetmg.inf.prodigialis.model.domain.Prova;
import br.cefetmg.inf.prodigialis.model.service.IManterProva;
import br.cefetmg.inf.prodigialis.util.db.exception.NegocioException;
import br.cefetmg.inf.prodigialis.util.db.exception.PersistenciaException;
import java.util.List;


public class ManterProva implements IManterProva{
    
    private IProvaDAO provaDAO;
    
    public ManterProva(){
    
        provaDAO = new ProvaDAO();
    
    }
    
    @Override
    public boolean inserir(Prova prova) throws PersistenciaException, NegocioException{
    
        if(prova == null)
            
            throw new NegocioException("Dados do prova não foram informados.");
        
        if(prova.getDat_prova() == null)
            
            throw new NegocioException("Data da prova deve ser informada.");
        
        if(prova.getArq_prova() == null)
            
            throw new NegocioException("Arquivo da prova deve ser carregado.");
        
        if(prova.getArq_edital() == null)
            
            throw new NegocioException("Arquivo do edital da prova deve ser carregado.");
        
        
        boolean provaCod = provaDAO.inserir(prova);
        
        return provaCod;
    
    }

    @Override
    public boolean atualizar(Prova prova) throws PersistenciaException, NegocioException{
    
        if(prova == null)
            
            throw new NegocioException("Dados do prova não foram informados.");
        
        if(prova.getCod_prova() == null)
            
            throw new NegocioException("Codigo da prova não foi informado.");
        
        
        if(prova.getDat_prova() == null)
            
            throw new NegocioException("Data da prova deve ser informada.");
        
        if(prova.getArq_prova() == null)
            
            throw new NegocioException("Arquivo da prova deve ser carregado.");
        
        if(prova.getArq_edital() == null)
            
            throw new NegocioException("Arquivo do edital da prova deve ser carregado.");
        
        
        if((prova.getPath_prova() == null || prova.getPath_prova().equals(' ')))
            
            throw new NegocioException("Path do arquivo da prova deve ser informado.");
        
        if((prova.getPath_edital() == null || prova.getPath_edital().equals(' ')))
            
            throw new NegocioException("Path do arquivo do edital deve ser informado.");
        
        
        boolean result = provaDAO.atualizar(prova);
        
        return result;
    
    }

    
}
