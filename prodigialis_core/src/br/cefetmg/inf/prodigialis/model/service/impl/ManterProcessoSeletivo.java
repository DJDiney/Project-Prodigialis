
package br.cefetmg.inf.prodigialis.model.service.impl;

import br.cefetmg.inf.prodigialis.model.dao.IProcessoSeletivoDAO;
import br.cefetmg.inf.prodigialis.model.dao.impl.ProcessoSeletivoDAO;
import br.cefetmg.inf.prodigialis.model.domain.ProcessoSeletivo;
import br.cefetmg.inf.prodigialis.model.service.IManterProcessoSeletivo;
import br.cefetmg.inf.prodigialis.util.db.exception.NegocioException;
import br.cefetmg.inf.prodigialis.util.db.exception.PersistenciaException;
import java.util.List;

public class ManterProcessoSeletivo implements IManterProcessoSeletivo {
    
    private IProcessoSeletivoDAO processoSeletivoDAO;
    
    public ManterProcessoSeletivo(){
    
        processoSeletivoDAO = new ProcessoSeletivoDAO();
    
    }
    
    @Override
    public boolean inserir(ProcessoSeletivo processoSeletivo) throws PersistenciaException, NegocioException{
    
        if(processoSeletivo == null)
            
            throw new NegocioException("Dados do processo Seletivo não foram informados.");
        
       
        if(processoSeletivo.getNom_proc() == null || processoSeletivo.getNom_proc().equals(' '))
            
            throw new NegocioException("Nome do processo Seletivo deve ser informado.");
        

        if((processoSeletivo.getVaga() == null))
            
            throw new NegocioException("Cargo do processo Seletivo deve ser informado.");
        
        if((processoSeletivo.getProva() == null))
            
            throw new NegocioException("Prova do processo Seletivo deve ser informado.");
        
        if((processoSeletivo.getDat_ini() == null))
            
            throw new NegocioException("Data de inicio do processo Seletivo deve ser informado.");
        
        if((processoSeletivo.getDat_fim() == null))
            
            throw new NegocioException("Data de fim do processo Seletivo deve ser informado.");
        
        if((processoSeletivo.getDesc_proc() == null) || processoSeletivo.getDesc_proc().isEmpty())
            
            throw new NegocioException("Descricao do processo Seletivo deve ser informada.");
        
        if((processoSeletivo.getNro_vagas() == null) || processoSeletivo.getNro_vagas() == 0)
            
            throw new NegocioException("Numero de vagas do processo Seletivo deve ser informado.");
        
        
        boolean processoSeletivoCod = processoSeletivoDAO.inserir(processoSeletivo);
        
        return processoSeletivoCod;
    
    }

    @Override
    public boolean atualizar(ProcessoSeletivo processoSeletivo, String nom_antigo) throws PersistenciaException, NegocioException{
    
        if(processoSeletivo == null)
            
            throw new NegocioException("Dados do processo Seletivo não foram informados.");
        
        if(processoSeletivo.getCod_proc() == null)
            
            throw new NegocioException("Codigo do processo Seletivo não foi informado.");
       
        if(processoSeletivo.getNom_proc() == null || processoSeletivo.getNom_proc().equals(' '))
            
            throw new NegocioException("Nome do processo Seletivo deve ser informado.");
        

        if((processoSeletivo.getVaga() == null))
            
            throw new NegocioException("Cargo do processo Seletivo deve ser informado.");
        
        if((processoSeletivo.getProva() == null))
            
            throw new NegocioException("Prova do processo Seletivo deve ser informado.");
        
        if((processoSeletivo.getDat_ini() == null))
            
            throw new NegocioException("Data de inicio do processo Seletivo deve ser informado.");
        
        if((processoSeletivo.getDat_fim() == null))
            
            throw new NegocioException("Data de fim do processo Seletivo deve ser informado.");
        
        if((processoSeletivo.getDesc_proc() == null) || processoSeletivo.getDesc_proc().isEmpty())
            
            throw new NegocioException("Descricao do processo Seletivo deve ser informada.");
        
        if((processoSeletivo.getNro_vagas() == null) || processoSeletivo.getNro_vagas() == 0)
            
            throw new NegocioException("Numero de vagas do processo Seletivo deve ser informado.");
        
        
        boolean result = processoSeletivoDAO.atualizar(processoSeletivo, nom_antigo);
        
        return result;
    
    }

    @Override
    public boolean excluir(String id) throws PersistenciaException{
    
        boolean result = processoSeletivoDAO.excluir(id);
        return result; 
        
    }

    @Override
    public List<ProcessoSeletivo> listarTodos() throws PersistenciaException{
    
        List<ProcessoSeletivo> listProcessoSeletivo = processoSeletivoDAO.listarTodos();
        return listProcessoSeletivo;
    
    }

    @Override
    public ProcessoSeletivo consultarPorId(Long id) throws PersistenciaException{
    
        ProcessoSeletivo result = processoSeletivoDAO.consultarPorId(id);
        return result; 
    
    }
    
    @Override
    public ProcessoSeletivo consultarPorNome(String nome) throws PersistenciaException{
    
        ProcessoSeletivo result = processoSeletivoDAO.consultarPorNome(nome);
        return result; 
    
    }
    
    @Override
    public List<ProcessoSeletivo> consultarPorNomeDistinto() throws PersistenciaException{
    
        List<ProcessoSeletivo> listProcessoSeletivo = processoSeletivoDAO.consultarPorNomeDistinto();
        return listProcessoSeletivo;
        
    }
    
    @Override
    public List<ProcessoSeletivo> consultarPorNomeDistintoUnico() throws PersistenciaException{
    
        List<ProcessoSeletivo> listProcessoSeletivo = processoSeletivoDAO.consultarPorNomeDistintoUnico();
        return listProcessoSeletivo;
        
    }
    
}
