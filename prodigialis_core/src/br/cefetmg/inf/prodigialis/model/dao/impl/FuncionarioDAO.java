
package br.cefetmg.inf.prodigialis.model.dao.impl;

import br.cefetmg.inf.prodigialis.model.dao.IFuncionarioDAO;
import br.cefetmg.inf.prodigialis.model.domain.Funcionario;
import br.cefetmg.inf.prodigialis.util.db.JDBCConnectionManager;
import br.cefetmg.inf.prodigialis.util.db.exception.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO implements IFuncionarioDAO {
    
    @Override
    public boolean inserir(Funcionario funcionario) throws PersistenciaException {

        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "INSERT INTO Funcionario (inss, ibge, nom_fun, "
                    + "email, password, idt_perfil, tel_fixo, tel_movel) " 
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, String.valueOf(funcionario.getInss()));
            statement.setString(2, String.valueOf(funcionario.getIbge()));
            statement.setString(3, funcionario.getNom_fun());
            statement.setString(4, funcionario.getEmail());
            statement.setString(5, funcionario.getPassword());
            statement.setString(6, String.valueOf(funcionario.getIdt_perfil()));
            statement.setString(7, String.valueOf(funcionario.getTel_fixo()));
            statement.setString(8, String.valueOf(funcionario.getTel_movel()));
            
            statement.execute();
            
            connection.close();
            
            return true;
            
        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
            
        }
        
    }

    @Override
    public boolean atualizar(Funcionario funcionario) throws PersistenciaException {

        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "UPDATE Funcionario " +
                            " SET ibge = ?, "
                            + "nom_fun = ?, "
                            + "email = ?, "
                            + "password = ?, "
                            + "idt_perfil = ?, "
                            + "tel_fixo = ?, "
                            + "tel_movel = ? " +   
                            " WHERE inss = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, String.valueOf(funcionario.getIbge()));
            statement.setString(2, funcionario.getNom_fun());
            statement.setString(3, funcionario.getEmail());
            statement.setString(4, funcionario.getPassword());
            statement.setString(5, String.valueOf(funcionario.getIdt_perfil()));
            statement.setString(6, String.valueOf(funcionario.getTel_fixo()));
            statement.setString(7, String.valueOf(funcionario.getTel_movel()));
            statement.setString(8, String.valueOf(funcionario.getInss()));

            statement.execute();

            connection.close();
            
            return true;
            
        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
            
        }
        
    }

    @Override
    public boolean excluir(char inss) throws PersistenciaException {

        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "DELETE FROM Funcionario WHERE inss = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setLong(1, inss);

            statement.execute();
            connection.close();
            
            return true;
            
        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
                
        }

    }

    @Override
    public List<Funcionario> listarTodos() throws PersistenciaException {

        List<Funcionario> FuncionarioList = new ArrayList<Funcionario>();

        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Funcionario";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();
            
            
            while(resultSet.next()){
                
                Funcionario funcionario = new Funcionario();
                funcionario.setInss(resultSet.getString("inss"));
                funcionario.setIbge(resultSet.getString("ibge"));
                funcionario.setNom_fun(resultSet.getString("nom_fun"));
                funcionario.setEmail(resultSet.getString("email"));
                funcionario.setPassword(resultSet.getString("password"));
                funcionario.setIdt_perfil(resultSet.getString("idt_perfil").charAt(0));
                funcionario.setTel_fixo(resultSet.getString("tel_fixo"));
                funcionario.setTel_movel(resultSet.getString("tel_movel"));

                FuncionarioList.add(funcionario);
                
            }
            
            connection.close();
            
        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
                
        }
        
        return FuncionarioList;
        
    }

    @Override
    public Funcionario consultarPorId(String cod) throws PersistenciaException {
        
        Funcionario funcionario = null;
        
        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Funcionario WHERE cod_func = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, cod);

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                
                funcionario = new Funcionario();
                funcionario.setInss(resultSet.getString("inss"));
                funcionario.setIbge(resultSet.getString("ibge"));
                funcionario.setNom_fun(resultSet.getString("nom_fun"));
                funcionario.setEmail(resultSet.getString("email"));
                funcionario.setPassword(resultSet.getString("password"));
                funcionario.setIdt_perfil(resultSet.getString("idt_perfil").charAt(0));
                funcionario.setTel_fixo(resultSet.getString("tel_fixo"));
                funcionario.setTel_movel(resultSet.getString("tel_movel"));
                    
            }
            
            connection.close();

        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
                
        }
        
        return funcionario;
        
    }
    
    public Funcionario consultarPorUsuarioSenha(String email, String senha) throws PersistenciaException {
        Funcionario funcionario = null;
        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();
            
            System.out.println("Consulta usrsenha"+connection);

            String sql = "SELECT * FROM funcionario WHERE password = ? AND email = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, senha);
            statement.setString(2, email);
            

            ResultSet resultSet = statement.executeQuery();

            
            if(resultSet.next()){
                
                funcionario = new Funcionario();
                funcionario.setInss(resultSet.getString("inss"));
                funcionario.setIbge(resultSet.getString("ibge"));
                funcionario.setNom_fun(resultSet.getString("nom_fun"));
                funcionario.setEmail(resultSet.getString("email"));
                funcionario.setPassword(resultSet.getString("password"));
                funcionario.setIdt_perfil(resultSet.getString("idt_perfil").charAt(0));
                funcionario.setTel_fixo(resultSet.getString("tel_fixo"));
                funcionario.setTel_movel(resultSet.getString("tel_movel"));
                    
            }
            //else System.out.println("Achou n");
            
            connection.close();

        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
                
        }
        
        return funcionario;
        
    }
    
    public Funcionario consultarPorEmail(String email) throws PersistenciaException {
        Funcionario funcionario = null;
        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();
            
            System.out.println("Consulta usremail"+connection);

            String sql = "SELECT * FROM funcionario WHERE email = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            

            ResultSet resultSet = statement.executeQuery();

            
            if(resultSet.next()){
                
                funcionario = new Funcionario();
                funcionario.setInss(resultSet.getString("inss"));
                funcionario.setIbge(resultSet.getString("ibge"));
                funcionario.setNom_fun(resultSet.getString("nom_fun"));
                funcionario.setEmail(resultSet.getString("email"));
                funcionario.setPassword(resultSet.getString("password"));
                funcionario.setIdt_perfil(resultSet.getString("idt_perfil").charAt(0));
                funcionario.setTel_fixo(resultSet.getString("tel_fixo"));
                funcionario.setTel_movel(resultSet.getString("tel_movel"));
                    
            }
            //else System.out.println("Achou n");
            
            connection.close();

        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
                
        }
        
        return funcionario;
        
    }

    @Override
    public Funcionario consultarPorNome(String nom_fun) throws PersistenciaException {

        Funcionario funcionario = null;
        
        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Funcionario WHERE nom_fun = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nom_fun);

            ResultSet resultSet = statement.executeQuery();

            
            while(resultSet.next()){
                
                funcionario = new Funcionario();
                funcionario.setInss(resultSet.getString("inss"));
                funcionario.setIbge(resultSet.getString("cod_cep"));
                funcionario.setNom_fun(resultSet.getString("nom_fun"));
                funcionario.setEmail(resultSet.getString("email"));
                funcionario.setPassword(resultSet.getString("password"));
                funcionario.setIdt_perfil(resultSet.getString("idt_perfil").charAt(0));
                funcionario.setTel_fixo(resultSet.getString("tel_fixo"));
                funcionario.setTel_movel(resultSet.getString("tel_movel"));
                    
            }
            
            connection.close();

        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
                
        }
        
        return funcionario;
        
    }
      
}