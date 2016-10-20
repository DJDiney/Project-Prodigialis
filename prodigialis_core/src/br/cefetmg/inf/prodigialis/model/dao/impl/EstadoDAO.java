
package br.cefetmg.inf.prodigialis.model.dao.impl;

import br.cefetmg.inf.prodigialis.model.dao.IEstadoDAO;
import br.cefetmg.inf.prodigialis.model.domain.Estado;
import br.cefetmg.inf.prodigialis.util.db.JDBCConnectionManager;
import br.cefetmg.inf.prodigialis.util.db.exception.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class EstadoDAO implements IEstadoDAO{
    
    @Override
    public List<Estado> listarTodos() throws PersistenciaException {

        List<Estado> estadoList = new ArrayList<Estado>();

        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Estado";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                
                Estado estado = new Estado();
                estado.setUf((resultSet.getString("uf").charAt(0)));
                estado.setNom_est(resultSet.getString("nom_est"));

                estadoList.add(estado);
                
            }
            
            connection.close();
            
        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
                
        }
        
        return estadoList;
        
    }

    @Override
    public Estado consultarPorId(char uf) throws PersistenciaException {
        
        Estado estado = null;
        
        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Estado WHERE uf = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, uf);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                
                estado = new Estado();
                estado.setUf((resultSet.getString("uf").charAt(0)));
                estado.setNom_est(resultSet.getString("nom_est"));
                    
            }
            
            connection.close();

        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
                
        }
        
        return estado;
        
    }

    @Override
    public Estado consultarPorNome(String nome) throws PersistenciaException {
        
        Estado estado = null;
        
        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Estado WHERE nom_est = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nome);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                
                estado = new Estado();
                estado.setUf((resultSet.getString("uf").charAt(0)));
                estado.setNom_est(resultSet.getString("nom_est"));
                    
            }
            
            connection.close();

        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
                
        }
        
        return estado;
    }
    
    
}
