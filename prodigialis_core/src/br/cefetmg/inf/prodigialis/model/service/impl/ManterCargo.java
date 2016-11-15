
package br.cefetmg.inf.prodigialis.model.service.impl;

import br.cefetmg.inf.prodigialis.model.dao.impl.CargoDAO;
import br.cefetmg.inf.prodigialis.model.domain.Cargo;
import br.cefetmg.inf.prodigialis.model.service.IManterCargo;
import br.cefetmg.inf.prodigialis.util.db.exception.NegocioException;
import br.cefetmg.inf.prodigialis.util.db.exception.PersistenciaException;
import java.util.List;
import br.cefetmg.inf.prodigialis.model.dao.ICargoDAO;


public class ManterCargo implements IManterCargo{
    
    private ICargoDAO cargoDAO;
    
    public ManterCargo(){
    
        cargoDAO = new CargoDAO();
    
    }
    
    @Override
    public boolean inserir(Cargo cargo) throws PersistenciaException, NegocioException{
    
        if(cargo == null)
            
            throw new NegocioException("Dados do cargo não foram informados.");
        
       
        if(cargo.getNom_cargo() == null || cargo.getNom_cargo().equals(' '))
            
            throw new NegocioException("Nome do cargo deve ser informado.");
        
        if(cargo.getDesc_cargo() == null || cargo.getDesc_cargo().equals(' '))
            
            throw new NegocioException("Descriao do cargo deve ser informada.");
        
        
        boolean cargoCod = cargoDAO.inserir(cargo);
        
        return cargoCod;
    
    }

    @Override
    public boolean atualizar(Cargo cargo) throws PersistenciaException, NegocioException{
    
        if(cargo == null)
            
            throw new NegocioException("Dados do cargo não foram informados.");
        
       
        if(cargo.getCod_cargo() == null)
            
            throw new NegocioException("Codigo do cargo deve ser informado.");
        

        if(cargo.getNom_cargo() == null || cargo.getNom_cargo().equals(' '))
            
            throw new NegocioException("Nome do cargo deve ser informado.");
        
        if(cargo.getDesc_cargo() == null || cargo.getDesc_cargo().equals(' '))
            
            throw new NegocioException("Descriao do cargo deve ser informada.");
        
        
        boolean result = cargoDAO.atualizar(cargo);
        
        return result;
    
    }

    @Override
    public List<Cargo> listarTodos() throws PersistenciaException{
    
        List<Cargo> listCargo = cargoDAO.listarTodos();
        return listCargo;
    
    }

    @Override
    public Cargo consultarPorId(Long id) throws PersistenciaException{
    
        Cargo result = cargoDAO.consultarPorId(id);
        return result; 
    
    }
    
    @Override
    public Cargo consultarPorNome(String nome) throws PersistenciaException{
    
        Cargo result = cargoDAO.consultarPorNome(nome);
        return result; 
    
    }
    
}
