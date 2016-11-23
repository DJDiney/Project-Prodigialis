/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.prodigialis.model.dao.impl;

import br.cefetmg.inf.prodigialis.model.dao.ICargoDAO;
import br.cefetmg.inf.prodigialis.model.dao.IProvaDAO;
import br.cefetmg.inf.prodigialis.model.domain.Cargo;
import br.cefetmg.inf.prodigialis.model.domain.Participante;
import br.cefetmg.inf.prodigialis.model.domain.ProcessoSeletivo;
import br.cefetmg.inf.prodigialis.model.domain.Prova;
import br.cefetmg.inf.prodigialis.util.db.JDBCConnectionManager;
import br.cefetmg.inf.prodigialis.util.db.exception.PersistenciaException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Cliente
 */
public class SpecsDAO {
    public boolean inserir(ProcessoSeletivo obj) throws PersistenciaException {
        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "INSERT INTO processoseletivo (cod_prova, dat_ini,"
                    + "dat_fim, nom_proc, desc_proc, nro_vagas, em_andamento, cod_cargo) " 
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1,obj.getProva().getCod_prova() );
            statement.setDate(2, (Date) obj.getDataInicio());
            statement.setDate(3, (Date) obj.getDataFinal());
            statement.setString(4, obj.getNome());
            statement.setString(5, obj.getDescricao());
            statement.setInt(6, obj.getNroVagas());
            statement.setBoolean(7, obj.isEm_andamento());
            statement.setInt(8, Integer.parseInt(obj.getCargoOferecido().getCod_cargo().toString()));
            
            statement.execute();
            
            connection.close();
            ParticipanteDAO dao = new ParticipanteDAO();
            for(int i=0;i<obj.getParticipantes().size();i++){
                dao.inserir(obj.getParticipantes().get(i));
            }
            
            return true;
            
        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
            
        }
    }


    public boolean excluir(int id) throws PersistenciaException {
        
        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "DELETE FROM especificacao WHERE cod_proc = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, id);

            statement.execute();
            connection.close();
            
            return true;
            
        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
                
        }
        
    }

    public ArrayList<String> consultarPorId(int id) throws PersistenciaException {
        
        ArrayList<String> specs = new ArrayList<String>();
        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM especificacao WHERE cod_proc = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                specs.add(resultSet.getString("txt_especificacao"));
            }
            connection.close();    
        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
                
        }
        return specs;
        
    }
}
