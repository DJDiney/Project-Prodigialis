
package br.cefetmg.inf.prodigialis.model.dao.impl;

import br.cefetmg.inf.prodigialis.model.dao.IEmpresaProvaDAO;
import br.cefetmg.inf.prodigialis.model.dao.IProvaDAO;
import br.cefetmg.inf.prodigialis.model.domain.EmpresaProva;
import br.cefetmg.inf.prodigialis.model.domain.Prova;
import br.cefetmg.inf.prodigialis.util.db.JDBCConnectionManager;
import br.cefetmg.inf.prodigialis.util.db.exception.PersistenciaException;
import com.google.common.io.Files;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ProvaDAO implements IProvaDAO{
    
    @Override
    public boolean inserir(Prova prova) throws PersistenciaException {

        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "INSERT INTO Prova (cnpj, dat_prova, "
                    + "arq_prova, path_prov, arq_edital, path_edt, desc_prova) " 
                    + "VALUES(?, ?, ?, ?, ?, ?, ?) RETURNING cod_prova";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, String.valueOf(prova.getEmpresa().getCnpj()));
            statement.setDate(2, new java.sql.Date(prova.getDat_prova().getTime()));
            statement.setBytes(3, prova.getArq_prova());
            statement.setString(4, " ");
            statement.setBytes(5, prova.getArq_edital());
            statement.setString(6, " ");
            statement.setString(7, prova.getDesc_prova());
            
            ResultSet resultSet = statement.executeQuery();
            
            Long id = null;
            
            if(resultSet.next()){
                
                id = resultSet.getLong("cod_prova");
                PreparedStatement statement2 = connection.prepareStatement("UPDATE Prova " +
                            " SET path_prov = ?, " +
                            "     path_edt = ? " +
                            " WHERE cod_prova = ?");
                
                statement2.setString(1, "/provas/prov_" + id + ".pdf");
                statement2.setString(2, "/provas/edt_" + id + ".pdf");
                statement2.setLong(3, id);
                
                statement2.execute();
                
                Files.write(prova.getArq_prova(), new File("./provas/prov_" + id + ".pdf"));
                Files.write(prova.getArq_edital(), new File("./provas/edt_" + id + ".pdf"));
                
            }
                
            connection.close();
            
            return true;
            
        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
            
        }
        
    }

    @Override
    public boolean atualizar(Prova prova) throws PersistenciaException {

        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "UPDATE Prova " +
                            " SET cnpj = ?, "
                            + "dat_prova = ?, "
                            + "arq_prova = ?, "
                            + "arq_edital = ?, "
                            + "desc_prova = ?" +   
                            " WHERE cod_prova = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, String.valueOf(prova.getEmpresa().getCnpj()));
            statement.setDate(2, new java.sql.Date(prova.getDat_prova().getTime()));
            statement.setBytes(3, prova.getArq_prova());
            statement.setBytes(4, prova.getArq_edital());
            statement.setString(5, prova.getDesc_prova());
            statement.setLong(6, prova.getCod_prova());
            
            statement.execute();
            
            Files.write(prova.getArq_prova(), new File(prova.getPath_prova()));
            Files.write(prova.getArq_edital(), new File(prova.getPath_edital()));

            connection.close();
            
            return true;
            
        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
            
        }
        
    }

    @Override
    public boolean excluir(Long cod_prova) throws PersistenciaException {

        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "DELETE FROM Prova WHERE cod_prova = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setLong(1, cod_prova);

            statement.execute();
            connection.close();
            
            return true;
            
        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
                
        }

    }

    @Override
    public List<Prova> listarTodos() throws PersistenciaException {

        List<Prova> ProvaList = new ArrayList<Prova>();

        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Prova";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();
            
            IEmpresaProvaDAO empresaProvaDAO = new EmpresaProvaDAO();
            
            while(resultSet.next()){
                
                Prova prova = new Prova();
                prova.setCod_prova(resultSet.getInt("cod_prova"));
                EmpresaProva empresaProva = empresaProvaDAO.consultarPorId(resultSet.getString("cnpj").charAt(0));
                prova.setEmpresa(empresaProva);
                prova.setDat_prova(resultSet.getDate("dat_prova"));
                prova.setArq_prova(resultSet.getBytes("arq_prova"));
                prova.setPath_prova(resultSet.getString("path_prov"));
                prova.setArq_edital(resultSet.getBytes("arq_edital"));
                prova.setPath_edital(resultSet.getString("path_edt"));
                prova.setDesc_prova(resultSet.getString("desc_prova"));

                ProvaList.add(prova);
                
            }
            
            connection.close();
            
        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
                
        }
        
        return ProvaList;
        
    }

    @Override
    public Prova consultarPorId(Long cod_prova) throws PersistenciaException {
        
        Prova prova = null;
        
        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Prova WHERE cod_prova = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, cod_prova);

            ResultSet resultSet = statement.executeQuery();

            IEmpresaProvaDAO empresaProvaDAO = new EmpresaProvaDAO();
            
            while(resultSet.next()){
                
                prova = new Prova();
                prova.setCod_prova(resultSet.getInt("cod_prova"));
                EmpresaProva empresaProva = empresaProvaDAO.consultarPorId(resultSet.getString("cnpj").charAt(0));
                prova.setEmpresa(empresaProva);
                prova.setDat_prova(resultSet.getDate("dat_prova"));
                prova.setArq_prova(resultSet.getBytes("arq_prova"));
                prova.setPath_prova(resultSet.getString("path_prov"));
                prova.setArq_edital(resultSet.getBytes("arq_edital"));
                prova.setPath_edital(resultSet.getString("path_edt"));
                prova.setDesc_prova(resultSet.getString("desc_prova"));
                    
            }
            
            connection.close();

        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
                
        }
        
        return prova;
        
    }
    
}