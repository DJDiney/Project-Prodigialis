
package br.cefetmg.inf.prodigialis.model.dao.impl;

import br.cefetmg.inf.prodigialis.model.dao.IVagaDAO;
import br.cefetmg.inf.prodigialis.model.domain.Vaga;
import br.cefetmg.inf.prodigialis.util.db.JDBCConnectionManager;
import br.cefetmg.inf.prodigialis.util.db.exception.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VagaDAO implements IVagaDAO {
    
    
    @Override
    public boolean inserir(Vaga vaga) throws PersistenciaException {

        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "INSERT INTO Vaga (nom_cargo, desc_cargo) " 
                    + "VALUES(?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, vaga.getNom_cargo());
            statement.setString(2, vaga.getDesc_cargo());
            
            statement.execute();
            
            connection.close();
            
            return true;
            
        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
            
        }
        
    }
    
    @Override
    public boolean atualizar(Vaga vaga) throws PersistenciaException {

        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "UPDATE Vaga SET nom_cargo = ?, desc_cargo = ? WHERE cod_cargo = ? ";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, vaga.getNom_cargo());
            statement.setString(2, vaga.getDesc_cargo());
            statement.setLong(3, vaga.getCod_cargo());
            
            statement.execute();
            
            connection.close();
            
            return true;
            
        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
            
        }
        
    }
    
    @Override
    public List<Vaga> listarTodos() throws PersistenciaException {

        List<Vaga> vagaList = new ArrayList<Vaga>();

        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Vaga";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                
                Vaga vaga = new Vaga();
                vaga.setCod_cargo(resultSet.getLong("cod_cargo"));
                vaga.setNom_cargo(resultSet.getString("nom_cargo"));
                vaga.setDesc_cargo(resultSet.getString("desc_cargo"));

                vagaList.add(vaga);
                
            }
            
            connection.close();
            
        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
                
        }
        
        return vagaList;
        
    }

    @Override
    public Vaga consultarPorId(Long cod_cargo) throws PersistenciaException {
        
        Vaga vaga = null;
        
        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Vaga WHERE cod_cargo = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, cod_cargo);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                
                vaga = new Vaga();
                vaga.setCod_cargo(resultSet.getLong("cod_cargo"));
                vaga.setNom_cargo(resultSet.getString("nom_cargo"));
                vaga.setDesc_cargo(resultSet.getString("desc_cargo"));
                    
            }
            
            connection.close();

        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
                
        }
        
        return vaga;
        
    }

    @Override
    public Vaga consultarPorNome(String nome) throws PersistenciaException {
        
        Vaga vaga = null;
        
        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Vaga WHERE nom_cargo = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nome);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                
                vaga = new Vaga();
                vaga.setCod_cargo(resultSet.getLong("cod_cargo"));
                vaga.setNom_cargo(resultSet.getString("nom_cargo"));
                vaga.setDesc_cargo(resultSet.getString("desc_cargo"));
                    
            }
            
            connection.close();

        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
                
        }
        
        return vaga;
    }
    
}