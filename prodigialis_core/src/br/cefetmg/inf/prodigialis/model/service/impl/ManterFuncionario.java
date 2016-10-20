
package br.cefetmg.inf.prodigialis.model.service.impl;

import br.cefetmg.inf.prodigialis.model.dao.IFuncionarioDAO;
import br.cefetmg.inf.prodigialis.model.dao.impl.FuncionarioDAO;
import br.cefetmg.inf.prodigialis.model.domain.Funcionario;
import br.cefetmg.inf.prodigialis.model.service.IManterFuncionario;
import br.cefetmg.inf.prodigialis.util.db.exception.NegocioException;
import br.cefetmg.inf.prodigialis.util.db.exception.PersistenciaException;
import java.util.List;

public class ManterFuncionario implements IManterFuncionario {
    
    private FuncionarioDAO funcionarioDAO;
    
    public ManterFuncionario(){
    
        funcionarioDAO = new FuncionarioDAO();
    
    }
    
    @Override
    public boolean inserir(Funcionario funcionario) throws PersistenciaException, NegocioException{
    
        if(funcionario == null)
            
            throw new NegocioException("Dados do funcionario não foram informados.");
        
       
        if(funcionario.getNom_fun() == null || funcionario.getNom_fun().equals(' '))
            
            throw new NegocioException("Nome do funcionario deve ser informado.");
        

        if(funcionario.getInss() == " ")
            
            throw new NegocioException("Inss deve ser informado.");
        
        
        if((funcionario.getIbge() == null))
            
            throw new NegocioException("Endereço do funcionario deve ser informado.");
        
        
        if(funcionario.getIdt_perfil() == ' ')
            
            throw new NegocioException("Idt do perfil do funcionario deve ser informado.");
        
        if((funcionario.getEmail() == null) || funcionario.getEmail().isEmpty())
            
            throw new NegocioException("Email do funcionario deve ser informado.");
        
        if((funcionario.getPassword() == null) || funcionario.getPassword().isEmpty())
            
            throw new NegocioException("Senha do funcionario deve ser informada.");
        
        if((funcionario.getTel_fixo() == null) || funcionario.getTel_fixo().isEmpty())
            
            throw new NegocioException("Telefone Fixo do funcionario deve ser informado.");
        
        if((funcionario.getTel_movel() == null) || funcionario.getTel_fixo().isEmpty())
            
            throw new NegocioException("Telefone movel do funcionario deve ser informado.");
        
        
        boolean funcionarioCod = funcionarioDAO.inserir(funcionario);
        
        return funcionarioCod;
    
    }

    @Override
    public boolean atualizar(Funcionario funcionario) throws PersistenciaException, NegocioException{
    
        if(funcionario == null)
            
            throw new NegocioException("Dados do funcionario não foram informados.");
        
       
        if(funcionario.getNom_fun() == null || funcionario.getNom_fun().equals(' '))
            
            throw new NegocioException("Nome do funcionario deve ser informado.");
        

        if(funcionario.getIbge() == " ")
            
            throw new NegocioException("Inss deve ser informado.");
        
        
        if((funcionario.getIbge() == null))
            
            throw new NegocioException("Endereço do funcionario deve ser informado.");
        
        
        if(funcionario.getIdt_perfil() == ' ')
            
            throw new NegocioException("Idt do perfil do funcionario deve ser informado.");
        
        if((funcionario.getEmail() == null) || funcionario.getEmail().isEmpty())
            
            throw new NegocioException("Email do funcionario deve ser informado.");
        
        if((funcionario.getPassword() == null) || funcionario.getPassword().isEmpty())
            
            throw new NegocioException("Senha do funcionario deve ser informada.");
        
        if((funcionario.getTel_fixo() == null) || funcionario.getTel_fixo().isEmpty())
            
            throw new NegocioException("Telefone Fixo do funcionario deve ser informado.");
        
        if((funcionario.getTel_movel() == null) || funcionario.getTel_fixo().isEmpty())
            
            throw new NegocioException("Telefone movel do funcionario deve ser informado.");
        
        
        boolean result = funcionarioDAO.atualizar(funcionario);
        
        return result;
    
    }

    @Override
    public boolean excluir(char id) throws PersistenciaException{
    
        boolean result = funcionarioDAO.excluir(id);
        return result; 
        
    }

    @Override
    public List<Funcionario> listarTodos() throws PersistenciaException{
    
        List<Funcionario> listFuncionario = funcionarioDAO.listarTodos();
        return listFuncionario;
    
    }

    @Override
    public Funcionario consultarPorId(char id) throws PersistenciaException{
    
        Funcionario result = funcionarioDAO.consultarPorId(id);
        return result; 
    
    }
    
    @Override
    public Funcionario consultarPorNome(String nome) throws PersistenciaException{
    
        Funcionario result = funcionarioDAO.consultarPorNome(nome);
        return result; 
    
    }
    
    public Funcionario getFuncLogin(String nome, String senha) throws PersistenciaException, NegocioException {
        Funcionario result = funcionarioDAO.consultarPorUsuarioSenha(nome,senha);
        return result;               
    }
    
}
