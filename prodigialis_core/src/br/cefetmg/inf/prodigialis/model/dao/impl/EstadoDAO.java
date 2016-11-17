
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
    public ArrayList<Estado> listarTodos() throws PersistenciaException {

        ArrayList<Estado> estadoList = new ArrayList<Estado>();

        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM estado ORDER BY uf";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();
            CidadeDAO cid = new CidadeDAO();
            while(resultSet.next()){
                
                Estado estado = new Estado();
                estado.setUf((resultSet.getString("uf")));
                estado.setNom_est(resultSet.getString("nom_est"));
                estado.setCidades(cid.listarPorUf(resultSet.getString("uf")));
                
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

            String sql = "SELECT * FROM estado WHERE uf = ? ORDER BY uf";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, uf);

            ResultSet resultSet = statement.executeQuery();
            
            CidadeDAO cid = new CidadeDAO();

            if(resultSet.next()){
                
                estado = new Estado();
                estado.setUf((resultSet.getString("uf")));
                estado.setNom_est(resultSet.getString("nom_est"));
                estado.setCidades(cid.listarPorUf(resultSet.getString("uf")));
                    
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
                estado.setUf((resultSet.getString("uf")));
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
