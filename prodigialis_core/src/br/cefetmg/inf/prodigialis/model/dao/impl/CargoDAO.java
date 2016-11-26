
package br.cefetmg.inf.prodigialis.model.dao.impl;

import br.cefetmg.inf.prodigialis.model.dao.ICargoDAO;
import br.cefetmg.inf.prodigialis.model.domain.Cargo;
import br.cefetmg.inf.prodigialis.util.db.JDBCConnectionManager;
import br.cefetmg.inf.prodigialis.util.db.exception.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CargoDAO implements ICargoDAO {
    
    
    @Override
    public boolean inserir(Cargo vaga) throws PersistenciaException {

        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "INSERT INTO Cargo (nom_cargo, desc_cargo) " 
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
    
    public long inserirComRetorno(Cargo vaga) throws PersistenciaException {

        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "INSERT INTO Cargo (nom_cargo, desc_cargo) " 
                    + "VALUES(?, ?) RETURNING cod_cargo";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, vaga.getNom_cargo());
            statement.setString(2, vaga.getDesc_cargo());
            
            ResultSet resultSet = statement.executeQuery();
            
            connection.close();
            
            if(resultSet.next()) return resultSet.getLong("cod_cargo");
            else return (long) -1;
            
        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
            
        }
        
    }
    
    
    @Override
    public boolean atualizar(Cargo vaga) throws PersistenciaException {

        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "UPDATE Cargo SET nom_cargo = ?, desc_cargo = ? WHERE cod_cargo = ? ";

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
    public List<Cargo> listarTodos() throws PersistenciaException {

        List<Cargo> vagaList = new ArrayList<Cargo>();

        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Cargo";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                
                Cargo vaga = new Cargo();
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
    public Cargo consultarPorId(Long cod_cargo) throws PersistenciaException {
        
        Cargo vaga = null;
        
        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Cargo WHERE cod_cargo = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, cod_cargo);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                
                vaga = new Cargo();
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
    public Cargo consultarPorNome(String nome) throws PersistenciaException {
        
        Cargo vaga = null;
        
        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Cargo WHERE nom_cargo = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nome);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                
                vaga = new Cargo();
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