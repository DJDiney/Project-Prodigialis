
package br.cefetmg.inf.prodigialis.model.dao.impl;

import br.cefetmg.inf.prodigialis.model.dao.IEmpresaProvaDAO;
import br.cefetmg.inf.prodigialis.model.domain.EmpresaProva;
import br.cefetmg.inf.prodigialis.util.db.JDBCConnectionManager;
import br.cefetmg.inf.prodigialis.util.db.exception.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class EmpresaProvaDAO implements IEmpresaProvaDAO {
    
    @Override
    public List<EmpresaProva> listarTodos() throws PersistenciaException {

        List<EmpresaProva> empresaProvaList = new ArrayList<EmpresaProva>();

        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM EmpresaProva";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                
                EmpresaProva empresaProva = new EmpresaProva();
                empresaProva.setCnpj(resultSet.getString("cnpj").charAt(0));
                empresaProva.setNom_fant(resultSet.getString("nom_fant"));

                empresaProvaList.add(empresaProva);
                
            }
            
            connection.close();
            
        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
                
        }
        
        return empresaProvaList;
        
    }

    @Override
    public EmpresaProva consultarPorId(char cnpj) throws PersistenciaException {
        
        EmpresaProva empresaProva = null;
        
        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM EmpresaProva WHERE cnpj = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, String.valueOf(cnpj));

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                
                empresaProva = new EmpresaProva();
                empresaProva.setCnpj(resultSet.getString("cnpj").charAt(0));
                empresaProva.setNom_fant(resultSet.getString("nom_fant"));
                    
            }
            
            connection.close();

        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
                
        }
        
        return empresaProva;
        
    }

    @Override
    public EmpresaProva consultarPorNome(String nome) throws PersistenciaException {
        
        EmpresaProva empresaProva = null;
        
        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM EmpresaProva WHERE nom_fant = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nome);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                
                empresaProva = new EmpresaProva();
                empresaProva.setCnpj(resultSet.getString("cnpj").charAt(0));
                empresaProva.setNom_fant(resultSet.getString("nom_fant"));
                    
            }
            
            connection.close();

        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
                
        }
        
        return empresaProva;
    }
    
}
