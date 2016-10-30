
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

            String sql = "INSERT INTO Participante (cod_prova, cpf, nro_inscricao) " 
                    + "VALUES(?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, participante.getProva().getCod_prova());
            statement.setString(2, String.valueOf(participante.getCandidato().getCpf()));
            statement.setInt(3, participante.getNro_ins());
            
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

            String sql = "UPDATE Participante " +
                            " SET cpf = ?, "+ 
                            " est_aprov = ? " +  
                            " vlr_nota = ? " +
                            " nro_colocacao = ? " +
                            " WHERE nro_ins = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, String.valueOf(participante.getCandidato().getCpf()));
            statement.setBoolean(2, participante.isEst_aprov());
            statement.setInt(3, participante.getNota());
            statement.setInt(4, participante.getColocao());
            statement.setLong(5, participante.getNro_ins());
            
            statement.execute();
            
            if (participante.isEst_aprov()) {
                
                PreparedStatement st3 = connection.prepareStatement("SELECT cod_cargo FROM "
                        + "ProcessoSeletivo WHERE nro_ins = ?");
                
                st3.setLong(1, participante.getNro_ins());
                ResultSet res = st3.executeQuery();
                
                if(res.next()){
                    
                    Long cod = res.getLong("cod_cargo");
                    PreparedStatement statement2 = connection.prepareStatement("UPDATE Candidato "
                        + "SET cod_cargo = ? WHERE cpf = ?");
                    
                    statement2.setLong(1, cod);
                    statement2.setLong(2, participante.getCandidato().getCpf());
                    statement2.execute();
                
                }
                
            }
            
            connection.close();
            
            return true;
            
        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
            
        }
        
    }

    @Override
    public boolean excluir(Long nro_ins) throws PersistenciaException {

        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "DELETE FROM Participante WHERE nro_ins = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setLong(1, nro_ins);

            statement.execute();
            
            PreparedStatement statement2 = connection.prepareStatement("DELETE FROM "
                    + "ProcessoSeletivo WHERE nro_ins = ?");
            
            statement2.setLong(1, nro_ins);
            
            statement2.execute();
            
            connection.close();
            
            return true;
            
        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
                
        }

    }

    @Override
    public List<Participante> listarTodos() throws PersistenciaException {

        List<Participante> ParticipanteList = new ArrayList<Participante>();

        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Participante";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();
            
            ICandidatoDAO candidatoDAO = new CandidatoDAO();
            
            while(resultSet.next()){
                
                Participante participante = new Participante();
                participante.setNro_ins(resultSet.getInt("nro_ins"));
                Candidato candidato = candidatoDAO.consultarPorId(resultSet.getString("cpf").charAt(0));
                participante.setCandidato(candidato);

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
    public Participante consultarPorId(Long nro_ins) throws PersistenciaException {
        
        Participante participante = null;
        
        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Participante WHERE nro_ins = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, nro_ins);

            ResultSet resultSet = statement.executeQuery();

            ICandidatoDAO candidatoDAO = new CandidatoDAO();
            
            while(resultSet.next()){
                
                participante = new Participante();
                participante.setNro_ins(resultSet.getInt("nro_ins"));
                Candidato candidato = candidatoDAO.consultarPorId(resultSet.getString("cpf").charAt(0));
                participante.setCandidato(candidato);
                    
            }
            
            connection.close();

        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
                
        }
        
        return participante;
        
    }
    
    
}
