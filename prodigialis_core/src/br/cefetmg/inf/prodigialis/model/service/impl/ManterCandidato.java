package br.cefetmg.inf.prodigialis.model.service.impl;

import br.cefetmg.inf.prodigialis.model.dao.ICandidatoDAO;
import br.cefetmg.inf.prodigialis.model.dao.impl.CandidatoDAO;
import br.cefetmg.inf.prodigialis.model.domain.Candidato;
import br.cefetmg.inf.prodigialis.model.service.IManterCandidato;
import br.cefetmg.inf.prodigialis.util.db.exception.NegocioException;
import br.cefetmg.inf.prodigialis.util.db.exception.PersistenciaException;
import java.util.List;

public class ManterCandidato implements IManterCandidato {
    
    private ICandidatoDAO candidatoDAO;
    
    public ManterCandidato(){
    
        candidatoDAO = new CandidatoDAO();
    
    }
    
    @Override
    public boolean inserir(Candidato candidato) throws PersistenciaException, NegocioException{
    
        if(candidato == null)
            
            throw new NegocioException("Dados do candidato não foram informados.");
        
       
        if(candidato.getNom_cand() == null || candidato.getNom_cand().equals(' '))
            
            throw new NegocioException("Nome do candidato deve ser informado.");
        

        if(candidato.getCpf() == " ")
            
            throw new NegocioException("Cpf deve ser informado.");
        
        
        if((candidato.getCep() == null))
            
            throw new NegocioException("Endereço do candidato deve ser informado.");
        
        
        if((candidato.getIdt_perfil() == ' '))
            
            throw new NegocioException("Idt do perfil do candidato deve ser informado.");
        
        if((candidato.getEmail() == null) || candidato.getEmail().isEmpty())
            
            throw new NegocioException("Email do candidato deve ser informado.");
        
        if((candidato.getPassword() == null) || candidato.getPassword().isEmpty())
            
            throw new NegocioException("Senha do candidato deve ser informada.");
        
        if((candidato.getTel_fixo() == null) || candidato.getTel_fixo().isEmpty())
            
            throw new NegocioException("Telefone Fixo do candidato deve ser informado.");
        
        if((candidato.getTel_movel() == null) || candidato.getTel_fixo().isEmpty())
            
            throw new NegocioException("Telefone movel do candidato deve ser informado.");
        
        
        boolean candidatoCod = candidatoDAO.inserir(candidato);
        
        return candidatoCod;
    
    }

    @Override
    public boolean atualizar(Candidato candidato) throws PersistenciaException, NegocioException{
    
        if(candidato == null)
            
            throw new NegocioException("Dados do candidato não foram informados.");
        
       
        if(candidato.getNom_cand() == null || candidato.getNom_cand().equals(' '))
            
            throw new NegocioException("Nome do candidato deve ser informado.");
        

        if(candidato.getCpf() == " ")
            
            throw new NegocioException("Cpf deve ser informado.");
        
        
        if((candidato.getCep() == null))
            
            throw new NegocioException("Endereço do candidato deve ser informado.");
        
        
        if(candidato.getIdt_perfil()== ' ')
            
            throw new NegocioException("Idt do perfil do candidato deve ser informado.");
        
        if((candidato.getEmail() == null) || candidato.getEmail().isEmpty())
            
            throw new NegocioException("Email do candidato deve ser informado.");
        
        if((candidato.getPassword() == null) || candidato.getPassword().isEmpty())
            
            throw new NegocioException("Senha do candidato deve ser informada.");
        
        if((candidato.getTel_fixo() == null) || candidato.getTel_fixo().isEmpty())
            
            throw new NegocioException("Telefone Fixo do candidato deve ser informado.");
        
        if((candidato.getTel_movel() == null) || candidato.getTel_fixo().isEmpty())
            
            throw new NegocioException("Telefone movel do candidato deve ser informado.");
        
        
        boolean result = candidatoDAO.atualizar(candidato);
        
        return result;
    
    }

    @Override
    public boolean excluir(char id) throws PersistenciaException{
    
        boolean result = candidatoDAO.excluir(id);
        return result; 
        
    }

    @Override
    public List<Candidato> listarTodos() throws PersistenciaException{
    
        List<Candidato> listCandidato = candidatoDAO.listarTodos();
        return listCandidato;
    
    }

    @Override
    public Candidato consultarPorId(String id) throws PersistenciaException{
    
        Candidato result = candidatoDAO.consultarPorId(id);
        return result; 
    
    }
    
    @Override
    public Candidato consultarPorNome(String nome) throws PersistenciaException{
    
        Candidato result = candidatoDAO.consultarPorNome(nome);
        return result; 
    
    }
    
}