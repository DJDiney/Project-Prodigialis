
package br.cefetmg.inf.prodigialis.model.dao.impl;

import br.cefetmg.inf.prodigialis.model.dao.ICurriculoDAO;
import br.cefetmg.inf.prodigialis.model.domain.Curriculo;
import br.cefetmg.inf.prodigialis.util.db.JDBCConnectionManager;
import br.cefetmg.inf.prodigialis.util.db.exception.PersistenciaException;
import com.google.common.io.Files;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class CurriculoDAO implements ICurriculoDAO{
    
    @Override
    public boolean inserir(Curriculo curriculo) throws PersistenciaException {

        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

                String sql = "INSERT INTO Curriculo (arq_cur, path_cur) " + "VALUES(?, ?) RETURNING cod_cur";

            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setBytes(1, curriculo.getArq_cur());
            statement.setString(2, " ");
            
            ResultSet resultSet = statement.executeQuery();
            
            Long id = null;
            
            /*if(resultSet.next()){
                
                id = resultSet.getLong("cod_cur");
                PreparedStatement statement2 = connection.prepareStatement("UPDATE Curriculo " +
                            " SET path_cur = ? " +
                            " WHERE cod_cur = ?");
                
                statement2.setString(1, "/curriculos/cur_" + id + ".pdf");
                
                statement2.execute();
                
                Files.write(curriculo.getArq_cur(), new File("./curriculos/cur_" + id + ".pdf"));
                
            }*/

            connection.close();
            
            return true;
            
        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
            
        }
        
    }

    @Override
    public boolean atualizar(Curriculo curriculo) throws PersistenciaException {

        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "UPDATE Curriculo " +
                            " SET arq_cur = ? " +
                            " WHERE cod_cur = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setBytes(1, curriculo.getArq_cur());
            statement.setLong(2, curriculo.getCod_cur());
            
            statement.execute();
            
            Files.write(curriculo.getArq_cur(), new File(curriculo.getPath_cur()));

            connection.close();
            
            return true;
            
        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
            
        }
        
    }

    @Override
    public boolean excluir(Long Cod_cur) throws PersistenciaException {

        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "DELETE FROM Curriculo WHERE cod_cur = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setLong(1, Cod_cur);

            statement.execute();
            connection.close();
            
            return true;
            
        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
                
        }

    }

    @Override
    public List<Curriculo> listarTodos() throws PersistenciaException {

        List<Curriculo> curriculoList = new ArrayList<Curriculo>();

        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Curriculo";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                
                Curriculo curriculo = new Curriculo();
                curriculo.setCod_cur(resultSet.getLong("cod_cur"));
                curriculo.setArq_cur(resultSet.getBytes("arq_cur"));
                curriculo.setPath_cur(resultSet.getString("path_cur"));

                curriculoList.add(curriculo);
                
            }
            
            connection.close();
            
        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
                
        }
        
        return curriculoList;
        
    }

    @Override
    public Curriculo consultarPorId(Long Cod_cur) throws PersistenciaException {
        
        Curriculo curriculo = null;
        
        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Curriculo WHERE cod_cur = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, Cod_cur);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                
                curriculo = new Curriculo();
                curriculo.setCod_cur(resultSet.getLong("cod_cur"));
                curriculo.setArq_cur(resultSet.getBytes("arq_cur"));
                curriculo.setPath_cur(resultSet.getString("path_cur"));
                    
            }
            
            connection.close();

        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
                
        }
        
        return curriculo;
        
    }
    
}
