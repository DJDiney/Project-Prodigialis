
package br.cefetmg.inf.prodigialis.model.dao.impl;

import br.cefetmg.inf.prodigialis.model.dao.ICandidatoDAO;
import br.cefetmg.inf.prodigialis.model.dao.ICurriculoDAO;
import br.cefetmg.inf.prodigialis.model.dao.ICargoDAO;
import br.cefetmg.inf.prodigialis.model.domain.Candidato;
import br.cefetmg.inf.prodigialis.model.domain.Curriculo;
import br.cefetmg.inf.prodigialis.model.domain.Cargo;
import br.cefetmg.inf.prodigialis.util.db.JDBCConnectionManager;
import br.cefetmg.inf.prodigialis.util.db.exception.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class CandidatoDAO implements ICandidatoDAO{
    
    @Override
    public boolean inserir(Candidato candidato) throws PersistenciaException {

        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "INSERT INTO candidato (cpf, cod_cur, cod_cep, nom_cand, "
                    + "email, password, idt_perfil, tel_fixo, tel_movel, cod_cargo) "
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, String.valueOf(candidato.getCpf()));
            statement.setLong(2, candidato.getCurriculo().getCod_cur());
            statement.setString(3, String.valueOf(candidato.getCep()));
            statement.setString(4, candidato.getNom_cand());
            statement.setString(5, candidato.getEmail());
            statement.setString(6, candidato.getPassword());
            statement.setString(7, String.valueOf(candidato.getIdt_perfil()));
            statement.setString(8, String.valueOf(candidato.getTel_fixo()));
            statement.setString(9, String.valueOf(candidato.getTel_movel()));
            statement.setLong(10, candidato.getCod_cargoPretendido());
            
            statement.execute();
            
            connection.close();
            
            return true;
            
        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
            
        }
        
    }

    @Override
    public boolean atualizar(Candidato candidato) throws PersistenciaException {

        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "UPDATE candidato " +
                            " SET cod_cur = ?, "
                            + "cod_cep = ?, "
                            + "nom_cand = ?, "
                            + "email = ?, "
                            + "password = ?, "
                            + "idt_perfil = ?, "
                            + "tel_fixo = ?, "
                            + "tel_movel = ?, "
                            + "cod_cur = ? " + 
                            " WHERE cpf = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setLong(1, candidato.getCurriculo().getCod_cur());
            statement.setString(2, String.valueOf(candidato.getCep()));
            statement.setString(3, candidato.getNom_cand());
            statement.setString(4, candidato.getEmail());
            statement.setString(5, candidato.getPassword());
            statement.setString(6, String.valueOf(candidato.getIdt_perfil()));
            statement.setString(7, String.valueOf(candidato.getTel_fixo()));
            statement.setString(8, String.valueOf(candidato.getTel_movel()));
            statement.setLong(9, candidato.getCod_cargoPretendido());
            statement.setString(10, String.valueOf(candidato.getCpf()));

            statement.execute();

            connection.close();
            
            return true;
            
        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
            
        }
        
    }

    @Override
    public boolean excluir(char cpf) throws PersistenciaException {

        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "DELETE FROM candidato WHERE cpf = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setLong(1, cpf);

            statement.execute();
            connection.close();
            
            return true;
            
        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
                
        }

    }

    @Override
    public List<Candidato> listarTodos() throws PersistenciaException {

        List<Candidato> CandidatoList = new ArrayList<Candidato>();

        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM candidato";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();
            
            ICurriculoDAO curriculoDAO = new CurriculoDAO();
            ICargoDAO cargoDAO = new CargoDAO();
            
            while(resultSet.next()){
                
                Candidato candidato = new Candidato();
                candidato.setCpf(resultSet.getString("cpf"));
                Curriculo curriculo = curriculoDAO.consultarPorId(resultSet.getLong("cod_cur"));
                candidato.setCurriculo(curriculo);
                candidato.setCep(resultSet.getString("ibge"));
                candidato.setNom_cand(resultSet.getString("nom_cand"));
                candidato.setEmail(resultSet.getString("email"));
                candidato.setPassword(resultSet.getString("password"));
                candidato.setIdt_perfil(resultSet.getString("idt_perfil").charAt(0));
                Cargo vaga = cargoDAO.consultarPorId(resultSet.getLong("cod_cargo"));
                candidato.setTel_fixo(resultSet.getString("tel_fixo"));
                candidato.setTel_movel(resultSet.getString("tel_movel"));
                candidato.setCod_cargoPretendido(vaga.getCod_cargo());

                CandidatoList.add(candidato);
                
            }
            
            connection.close();
            
        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
                
        }
        
        return CandidatoList;
        
    }

    @Override
    public Candidato consultarPorId(String cpf) throws PersistenciaException {
        
        Candidato candidato = null;
        
        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM candidato WHERE cpf = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, cpf);

            ResultSet resultSet = statement.executeQuery();

            ICurriculoDAO curriculoDAO = new CurriculoDAO();
            ICargoDAO vagaDAO = new CargoDAO();
            
            while(resultSet.next()){
                
                candidato = new Candidato();
                candidato.setCpf(resultSet.getString("cpf"));
                Curriculo curriculo = curriculoDAO.consultarPorId(resultSet.getLong("cod_cur"));
                candidato.setCurriculo(curriculo);
                candidato.setCep(resultSet.getString("ibge"));
                candidato.setNom_cand(resultSet.getString("nom_cand"));
                candidato.setEmail(resultSet.getString("email"));
                candidato.setPassword(resultSet.getString("password"));
                candidato.setIdt_perfil(resultSet.getString("idt_perfil").charAt(0));
                Cargo vaga = vagaDAO.consultarPorId(resultSet.getLong("cod_cargo"));
                candidato.setTel_fixo(resultSet.getString("tel_fixo"));
                candidato.setTel_movel(resultSet.getString("tel_movel"));
                candidato.setCod_cargoPretendido(vaga.getCod_cargo());
                    
            }
            
            connection.close();

        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
                
        }
        
        return candidato;
        
    }

    @Override
    public Candidato consultarPorNome(String nom_cand) throws PersistenciaException {

        Candidato candidato = null;
        
        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM candidato WHERE nom_cand = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nom_cand);

            ResultSet resultSet = statement.executeQuery();

            ICurriculoDAO curriculoDAO = new CurriculoDAO();
            ICargoDAO vagaDAO = new CargoDAO();
            
            while(resultSet.next()){
                
                candidato = new Candidato();
                candidato.setCpf(resultSet.getString("cpf"));
                Curriculo curriculo = curriculoDAO.consultarPorId(resultSet.getLong("cod_cur"));
                candidato.setCurriculo(curriculo);
                candidato.setCep(resultSet.getString("ibge"));
                candidato.setNom_cand(resultSet.getString("nom_cand"));
                candidato.setEmail(resultSet.getString("email"));
                candidato.setPassword(resultSet.getString("password"));
                candidato.setIdt_perfil(resultSet.getString("idt_perfil").charAt(0));
                Cargo vaga = vagaDAO.consultarPorId(resultSet.getLong("cod_cargo"));
                candidato.setTel_fixo(resultSet.getString("tel_fixo"));
                candidato.setTel_movel(resultSet.getString("tel_movel"));
                candidato.setCod_cargoPretendido(vaga.getCod_cargo());
                    
            }
            
            connection.close();

        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
                
        }
        
        return candidato;
        
    }
    public Candidato consultarPorUsuarioSenha(String email, String senha) throws PersistenciaException {
        Candidato candidato = null;
        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();
            
            System.out.println(connection);

            String sql = "SELECT * FROM candidato WHERE password = ? AND email = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, senha);
            statement.setString(2, email);
            

            ResultSet resultSet = statement.executeQuery();

            
            if(resultSet.next()){
                
                candidato = new Candidato();
                candidato.setCpf(resultSet.getString("cpf"));
                candidato.setCep(resultSet.getString("ibge"));
                candidato.setNom_cand(resultSet.getString("nom_cand"));
                candidato.setEmail(resultSet.getString("email"));
                candidato.setPassword(resultSet.getString("password"));
                candidato.setIdt_perfil(resultSet.getString("idt_perfil").charAt(0));
                candidato.setTel_fixo(resultSet.getString("tel_fixo"));
                candidato.setTel_movel(resultSet.getString("tel_movel"));
                    
            }
            //else System.out.println("Achou n");
            
            connection.close();

        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
                
        }
        
        return candidato;
        
    }
    
    public Candidato consultarPorEmail(String email) throws PersistenciaException {
        Candidato candidato = null;
        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();
            
            System.out.println(connection);

            String sql = "SELECT * FROM candidato WHERE  email = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            

            ResultSet resultSet = statement.executeQuery();
            CurriculoDAO aux = new CurriculoDAO();
            
            if(resultSet.next()){
                
                candidato = new Candidato();
                candidato.setCpf(resultSet.getString("cpf"));
                candidato.setCep(resultSet.getString("ibge"));
                candidato.setNom_cand(resultSet.getString("nom_cand"));
                candidato.setEmail(resultSet.getString("email"));
                candidato.setPassword(resultSet.getString("password"));
                candidato.setIdt_perfil(resultSet.getString("idt_perfil").charAt(0));
                candidato.setTel_fixo(resultSet.getString("tel_fixo"));
                candidato.setTel_movel(resultSet.getString("tel_movel"));
                candidato.setCurriculo(aux.consultarPorId(Long.parseLong(resultSet.getString("cod_cur"))));
                    
            }
            //else System.out.println("Achou n");
            
            connection.close();

        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
                
        }
        
        return candidato;
        
    }

    
}