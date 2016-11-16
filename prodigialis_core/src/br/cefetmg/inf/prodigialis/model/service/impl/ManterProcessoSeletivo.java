package br.cefetmg.inf.prodigialis.model.service.impl;

import br.cefetmg.inf.prodigialis.model.dao.IParticipanteDAO;
import br.cefetmg.inf.prodigialis.model.dao.IProcessoSeletivoDAO;
import br.cefetmg.inf.prodigialis.model.dao.impl.ParticipanteDAO;
import br.cefetmg.inf.prodigialis.model.dao.impl.ProcessoSeletivoDAO;
import br.cefetmg.inf.prodigialis.model.domain.Participante;
import br.cefetmg.inf.prodigialis.model.domain.ProcessoSeletivo;
import br.cefetmg.inf.prodigialis.model.service.IManterProcessoSeletivo;
import br.cefetmg.inf.prodigialis.util.db.exception.NegocioException;
import br.cefetmg.inf.prodigialis.util.db.exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author Felipe Rabelo
 */
public class ManterProcessoSeletivo implements IManterProcessoSeletivo {
    
    private IProcessoSeletivoDAO processoDAO;

    public ManterProcessoSeletivo() {
        
        processoDAO = new ProcessoSeletivoDAO();
        
    }

    @Override
    public boolean inserir(ProcessoSeletivo obj) throws PersistenciaException, NegocioException {
        
        if (obj == null)
            
            throw new NegocioException("Dados do processo não foram informados.");
        
        if (obj.getDataInicio() == null)
            
            throw new NegocioException("Data do processo deve ser informada.");
        
        if (obj.getDataFinal() == null)
            
            throw new NegocioException("Data do fim do processo deve ser informada.");
        
        if (obj.getNome() == null)
            
            throw new NegocioException("Nome do processo deve ser informado.");
        
        if (obj.getNroVagas() == null)
            
            throw new NegocioException("Número de vagas do processo deve ser informado.");
        
        if (obj.getCargoOferecido() == null)
            
            throw new NegocioException("Cargo concorrido deve ser informado.");
        
        boolean processoCod = processoDAO.inserir(obj);
        
        return processoCod;
        
    }

    @Override
    public boolean atualizar(ProcessoSeletivo obj) throws PersistenciaException, NegocioException {
        
        if (obj == null)
            
            throw new NegocioException("Dados do processo não foram informados.");
        
        if (obj.getCodProcesso() == null) 
            
            throw new NegocioException("Codigo da processo não foi informado.");
        
        if (obj.getProva() == null)
            
            throw new NegocioException("Codigo da prova não foi informado.");
        
        if (obj.getDataInicio() == null)
            
            throw new NegocioException("Data do processo deve ser informada.");
        
        if (obj.getDataFinal() == null)
            
            throw new NegocioException("Data do fim do processo deve ser informada.");
        
        if (obj.getNome() == null)
            
            throw new NegocioException("Nome do processo deve ser informado.");
        
        if (obj.getDescricao() == null) 
            
            throw new NegocioException("Descrição do processo não informada.");
        
        if (obj.getNroVagas() == null)
            
            throw new NegocioException("Número de vagas do processo deve ser informado.");
        
        if (obj.getCargoOferecido() == null)
            
            throw new NegocioException("Cargo concorrido deve ser informado.");
        
        boolean result = processoDAO.atualizar(obj);
        
        return result;
        
    }

    
}
