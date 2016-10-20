
package br.cefetmg.inf.prodigialis.model.dao.impl;

import br.cefetmg.inf.prodigialis.model.dao.ICandidatoDAO;
import br.cefetmg.inf.prodigialis.model.dao.IEntrevistaDAO;
import br.cefetmg.inf.prodigialis.model.dao.IFuncionarioDAO;
import br.cefetmg.inf.prodigialis.model.dao.IVagaDAO;
import br.cefetmg.inf.prodigialis.model.domain.Candidato;
import br.cefetmg.inf.prodigialis.model.domain.Entrevista;
import br.cefetmg.inf.prodigialis.model.domain.Funcionario;
import br.cefetmg.inf.prodigialis.model.domain.Vaga;
import br.cefetmg.inf.prodigialis.util.db.JDBCConnectionManager;
import br.cefetmg.inf.prodigialis.util.db.exception.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EntrevistaDAO implements IEntrevistaDAO {
    
    @Override
    public boolean inserir(Entrevista entrevista) throws PersistenciaException {

        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "INSERT INTO Entrevista (cpf, inss, cod_ent, dat_ent, est_aprov, desc_ent, cod_cargo) " 
                    + "VALUES(?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setString(1, String.valueOf(entrevista.getCandidato().getCpf()));
            statement.setString(2, String.valueOf(entrevista.getFuncionario().getInss()));
            statement.setLong(3, entrevista.getCod_ent());
            statement.setDate(4, new java.sql.Date(entrevista.getDat_ent().getTime()));
            statement.setBoolean(5, entrevista.isEst_aprov());
            statement.setString(6, entrevista.getDesc_ent());
            statement.setLong(7, entrevista.getVaga().getCod_cargo());

            statement.execute();
            
            PreparedStatement statement2 = connection.prepareStatement("UPDATE Candidanto " +
                            " SET cod_cargo = ? " +
                            " WHERE cpf = ?");
                
            statement2.setLong(1, entrevista.getVaga().getCod_cargo());
            statement2.setString(2, String.valueOf(entrevista.getCandidato().getCpf()));

            connection.close();
            
            return true;
            
        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
            
        }
        
    }

    @Override
    public boolean atualizar(Entrevista entrevista) throws PersistenciaException {

        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "UPDATE Entrevista " +
                            " SET cpf = ?, " +
                            "  inss = ?, " +    
                            "  dat_ent = ?, " +
                            "  est_aprov = ?, " +
                            "  desc_ent = ?, " +
                            "  cod_cargo = ?" +
                            " WHERE cod_ent = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setString(1, String.valueOf(entrevista.getCandidato().getCpf()));
            statement.setString(2, String.valueOf(entrevista.getFuncionario().getInss()));
            statement.setDate(3, new java.sql.Date(entrevista.getDat_ent().getTime()));
            statement.setBoolean(4, entrevista.isEst_aprov());
            statement.setString(5, entrevista.getDesc_ent());
            statement.setLong(6, entrevista.getVaga().getCod_cargo());
            statement.setLong(7, entrevista.getCod_ent());
            
            statement.execute();
            
            PreparedStatement statement2 = connection.prepareStatement("UPDATE Candidanto " +
                            " SET cod_cargo = ? " +
                            " WHERE cpf = ?");
                
            statement2.setLong(1, entrevista.getVaga().getCod_cargo());
            statement2.setString(2, String.valueOf(entrevista.getCandidato().getCpf()));

            connection.close();
            
            return true;
            
        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
            
        }
        
    }

    @Override
    public boolean excluir(Long cod_ent) throws PersistenciaException {

        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "DELETE FROM Entrevista WHERE cod_ent = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setLong(1, cod_ent);

            statement.execute();
            connection.close();
            
            return true;
            
        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
                
        }

    }

    @Override
    public List<Entrevista> listarTodos() throws PersistenciaException {

        List<Entrevista> entrevistaList = new ArrayList<Entrevista>();

        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Entrevista";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();
            
            ICandidatoDAO candidatoDAO = new CandidatoDAO();
            IFuncionarioDAO funcionarioDAO = new FuncionarioDAO();
            IVagaDAO vagaDAO = new VagaDAO();

            while(resultSet.next()){
                
                Entrevista entrevista = new Entrevista();
                Candidato candidato = candidatoDAO.consultarPorId(resultSet.getString("cpf").charAt(0));
                entrevista.setCandidato(candidato);
                Funcionario funcionario = funcionarioDAO.consultarPorId(resultSet.getString("inss").charAt(0));
                entrevista.setFuncionario(funcionario);
                entrevista.setCod_ent(resultSet.getLong("cod_ent"));
                entrevista.setDat_ent(resultSet.getDate("dat_ent"));
                entrevista.setEst_aprov(resultSet.getBoolean("est_aprov"));
                entrevista.setDesc_ent(resultSet.getString("desc_ent"));
                Vaga vaga = vagaDAO.consultarPorId(resultSet.getLong("cod_cargo"));
                entrevista.setVaga(vaga);
                

                entrevistaList.add(entrevista);
                
            }
            
            connection.close();
            
        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
                
        }
        
        return entrevistaList;
        
    }

    @Override
    public Entrevista consultarPorId(Long cod_ent) throws PersistenciaException {
        
        Entrevista entrevista = null;
        
        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Entrevista WHERE cod_ent = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, cod_ent);

            ResultSet resultSet = statement.executeQuery();

            ICandidatoDAO candidatoDAO = new CandidatoDAO();
            IFuncionarioDAO funcionarioDAO = new FuncionarioDAO();
            IVagaDAO vagaDAO = new VagaDAO();

            while(resultSet.next()){
                
                entrevista = new Entrevista();
                Candidato candidato = candidatoDAO.consultarPorId(resultSet.getString("cpf").charAt(0));
                entrevista.setCandidato(candidato);
                Funcionario funcionario = funcionarioDAO.consultarPorId(resultSet.getString("inss").charAt(0));
                entrevista.setFuncionario(funcionario);
                entrevista.setCod_ent(resultSet.getLong("cod_ent"));
                entrevista.setDat_ent(resultSet.getDate("dat_ent"));
                entrevista.setEst_aprov(resultSet.getBoolean("est_aprov"));
                entrevista.setDesc_ent(resultSet.getString("desc_ent"));
                Vaga vaga = vagaDAO.consultarPorId(resultSet.getLong("cod_cargo"));
                entrevista.setVaga(vaga);
                    
            }
            
            connection.close();

        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
                
        }
        
        return entrevista;
        
    }
       
}