/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.prodigialis.model.dao.impl;

import br.cefetmg.inf.prodigialis.model.dao.IProcessoSeletivoDAO;
import br.cefetmg.inf.prodigialis.model.domain.ProcessoSeletivo;
import br.cefetmg.inf.prodigialis.util.db.JDBCConnectionManager;
import br.cefetmg.inf.prodigialis.util.db.exception.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

/**
 *
 * @author Cliente
 */
public class ProcessoSeletivoDAO implements IProcessoSeletivoDAO{

    @Override
    public boolean inserir(ProcessoSeletivo obj) throws PersistenciaException {
        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "INSERT INTO processoseletivo (cod_proc, cod_prova, dat_ini,dat_fim,nom_proc,desc_proc,nro_vagas,em_andamento,cod_cargo) " 
                    + "VALUES(?, ?, ?, ?, ?,?,?,?,?)";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, obj.getCodProcesso());
            statement.setInt(2,obj.getProva().getCod_prova() );
            statement.setDate(3, obj.getDataInicio());
            statement.setBytes(4, participante.getArqRespostas());
            statement.setDouble(5,participante.getNota());
            
            statement.execute();
            
            connection.close();
            
            return true;
            
        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
            
        }
    }

    @Override
    public boolean atualizar(ProcessoSeletivo obj) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(Long id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProcessoSeletivo consultarPorId(Long id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProcessoSeletivo> listarTodos() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
