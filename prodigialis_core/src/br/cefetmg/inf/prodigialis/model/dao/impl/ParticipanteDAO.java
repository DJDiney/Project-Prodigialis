
package br.cefetmg.inf.prodigialis.model.dao.impl;

import br.cefetmg.inf.prodigialis.model.dao.ICandidatoDAO;
import br.cefetmg.inf.prodigialis.model.dao.IParticipanteDAO;
import br.cefetmg.inf.prodigialis.model.domain.Candidato;
import br.cefetmg.inf.prodigialis.model.domain.Participante;
import br.cefetmg.inf.prodigialis.util.db.JDBCConnectionManager;
import br.cefetmg.inf.prodigialis.util.db.exception.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ParticipanteDAO implements IParticipanteDAO{
    
    @Override
    public boolean inserir(Participante participante) throws PersistenciaException {

        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "INSERT INTO participante (cod_proc, cpf, est_aprov,arq_respostas,nota) " 
                    + "VALUES(?, ?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, participante.getCodProcesso());
            statement.setString(2, String.valueOf(participante.getCandidato().getCpf()));
            statement.setBoolean(3, participante.isEst_aprov());
            statement.setBytes(4, participante.getArqRespostas());
            statement.setDouble(5,participante.getNota());
            
            statement.execute();
            
            connection.close();
            
            return true;
            
        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
            
        }
        
    }

    @Override
    public boolean atualizar(Participante participante) throws PersistenciaException {

        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "UPDATE participante " +
                            " SET cpf = ?, "+ 
                            " est_aprov = ? " +  
                            " vlr_nota = ? " +
                            " arq_repostas = ? " +
                            " WHERE nro_insc = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, String.valueOf(participante.getCandidato().getCpf()));
            statement.setBoolean(2, participante.isEst_aprov());
            statement.setDouble(3, participante.getNota());
            statement.setBytes(4, participante.getArqRespostas());
            statement.setLong(5, participante.getNroInscricao());
            
            statement.execute();
            
            
            connection.close();
            
            return true;
            
        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
            
        }
        
    }

    @Override
    public boolean excluir(int nro_ins) throws PersistenciaException {

        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "DELETE FROM Participante WHERE nro_insc = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, nro_ins);

            statement.execute();
            
            connection.close();
            
            return true;
            
        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
                
        }

    }

    @Override
    public ArrayList<Participante> listarTodos() throws PersistenciaException {

        ArrayList<Participante> ParticipanteList = new ArrayList<Participante>();

        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM participante";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();
            
            ICandidatoDAO candidatoDAO = new CandidatoDAO();
            
            while(resultSet.next()){
                
                Participante participante = new Participante();
                participante.setNroInscricao(resultSet.getInt("nro_insc"));
                Candidato candidato = candidatoDAO.consultarPorId(resultSet.getString("cpf"));
                participante.setCandidato(candidato);
                //participante.setArq_respostas(resultSet.getBytes("arq_repostas"));
                participante.setCodProcesso(resultSet.getInt("cod_proc"));
                participante.setEst_aprov(resultSet.getBoolean("est_aprov"));
                participante.setNota(resultSet.getDouble("nota"));

                ParticipanteList.add(participante);
                
            }
            
            connection.close();
            
        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
                
        }
        
        return ParticipanteList;
        
    }

    @Override
    public Participante consultarPorId(int id) throws PersistenciaException {
        
        Participante participante = new Participante();
        
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM participante WHERE nro_insc = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            CandidatoDAO candidatoDAO = new CandidatoDAO();
            
            while(resultSet.next()){
                
                participante.setNroInscricao(resultSet.getInt("nro_insc"));
                Candidato candidato = candidatoDAO.consultarPorId(resultSet.getString("cpf"));
                participante.setCandidato(candidato);
                //participante.setArq_respostas(resultSet.getBytes("arq_repostas"));
                participante.setCodProcesso(resultSet.getInt("cod_proc"));
                participante.setEst_aprov(resultSet.getBoolean("est_aprov"));
                participante.setNota(resultSet.getDouble("nota"));
                    
            }
            
            connection.close();

        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
                
        }
        
        return participante;
        
    }
    public Participante consultarPorProc(String cpf,int cod_proc) throws PersistenciaException {
        
        Participante participante = null;
        
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM participante WHERE cpf = ? AND cod_proc=?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, cpf);
            statement.setInt(2, cod_proc);

            ResultSet resultSet = statement.executeQuery();

            CandidatoDAO candidatoDAO = new CandidatoDAO();
            
            while(resultSet.next()){
                participante = new Participante();
                participante.setNroInscricao(resultSet.getInt("nro_insc"));
                Candidato candidato = candidatoDAO.consultarPorId(resultSet.getString("cpf"));
                participante.setCandidato(candidato);
                //participante.setArq_respostas(resultSet.getBytes("arq_repostas"));
                participante.setCodProcesso(resultSet.getInt("cod_proc"));
                participante.setEst_aprov(resultSet.getBoolean("est_aprov"));
                participante.setNota(resultSet.getDouble("nota"));
                    
            }
            
            connection.close();

        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
                
        }
        
        return participante;
        
    }
    
    
}
