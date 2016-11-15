
package br.cefetmg.inf.prodigialis.model.service.impl;

import br.cefetmg.inf.prodigialis.model.dao.IParticipanteDAO;
import br.cefetmg.inf.prodigialis.model.dao.impl.ParticipanteDAO;
import br.cefetmg.inf.prodigialis.model.domain.Participante;
import br.cefetmg.inf.prodigialis.model.service.IManterParticipante;
import br.cefetmg.inf.prodigialis.util.db.exception.NegocioException;
import br.cefetmg.inf.prodigialis.util.db.exception.PersistenciaException;
import java.util.List;


public class ManterParticipante implements IManterParticipante{
    
    private IParticipanteDAO participanteDAO;
    
    public ManterParticipante(){
    
        participanteDAO = new ParticipanteDAO();
    
    }
    
    @Override
    public boolean inserir(Participante participante) throws PersistenciaException, NegocioException{
    
        if(participante == null)
            
            throw new NegocioException("Dados do participante não foram informados.");
        
       
        if(participante.getCandidato() == null)
            
            throw new NegocioException("Candidato deve ser informado.");
        
        
        boolean participanteCod = participanteDAO.inserir(participante);
        
        return participanteCod;
    
    }

    @Override
    public boolean atualizar(Participante participante) throws PersistenciaException, NegocioException{
    
        if(participante == null)
            
            throw new NegocioException("Dados do participante não foram informados.");
        
       
        if(participante.getNroInscricao() == -1)
            
            throw new NegocioException("Codigo do participante deve ser informado.");
        

        if(participante.getCandidato() == null)
            
            throw new NegocioException("Candidato deve ser informado.");
        
        
        boolean result = participanteDAO.atualizar(participante);
        
        return result;
    
    }

    @Override
    public boolean excluir(Long id) throws PersistenciaException{
    
        boolean result = participanteDAO.excluir(id);
        return result; 
        
    }

    @Override
    public List<Participante> listarTodos() throws PersistenciaException{
    
        List<Participante> listParticipante = participanteDAO.listarTodos();
        return listParticipante;
    
    }

    @Override
    public Participante consultarPorId(Long id) throws PersistenciaException{
    
        Participante result = participanteDAO.consultarPorId(id);
        return result; 
    
    }
    
}
