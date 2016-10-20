
package br.cefetmg.inf.prodigialis.model.dao.impl;

import br.cefetmg.inf.prodigialis.model.dao.IParticipanteDAO;
import br.cefetmg.inf.prodigialis.model.dao.IProcessoSeletivoDAO;
import br.cefetmg.inf.prodigialis.model.dao.IProvaDAO;
import br.cefetmg.inf.prodigialis.model.dao.IVagaDAO;
import br.cefetmg.inf.prodigialis.model.domain.Participante;
import br.cefetmg.inf.prodigialis.model.domain.ProcessoSeletivo;
import br.cefetmg.inf.prodigialis.model.domain.Prova;
import br.cefetmg.inf.prodigialis.model.domain.Vaga;
import br.cefetmg.inf.prodigialis.util.db.JDBCConnectionManager;
import br.cefetmg.inf.prodigialis.util.db.exception.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ProcessoSeletivoDAO implements IProcessoSeletivoDAO{
    
    @Override
    public boolean inserir(ProcessoSeletivo processoSeletivo) throws PersistenciaException {

        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "INSERT INTO ProcessoSeletivo (cod_cargo, cod_prova, nro_ins, "
                    + "dat_ini, dat_fim, nom_proc, desc_proc, nro_vagas) "
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setLong(1, processoSeletivo.getVaga().getCod_cargo());
            statement.setLong(2, processoSeletivo.getProva().getCod_prova());
            statement.setLong(3, processoSeletivo.getParticipante().getNro_ins());
            statement.setDate(4, new java.sql.Date(processoSeletivo.getDat_ini().getTime()));
            statement.setDate(5, new java.sql.Date(processoSeletivo.getDat_fim().getTime()));
            statement.setString(6, processoSeletivo.getNom_proc());
            statement.setString(7, processoSeletivo.getDesc_proc());
            statement.setLong(8, processoSeletivo.getNro_vagas());
            
            statement.execute();
            
            connection.close();
            
            return true;
            
        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
            
        }
        
    }

    @Override
    public boolean atualizar(ProcessoSeletivo processoSeletivo, String nome_antigo) throws PersistenciaException {

        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "UPDATE ProcessoSeletivo " +
                            " SET cod_cargo = ?, "
                            + "cod_prova = ?, "
                            + "nro_ins = ?, "
                            + "dat_ini = ?, "
                            + "dat_fim = ?, "
                            + "nom_proc = ?, "
                            + "desc_proc = ?, "
                            + "nro_vagas = ? " + 
                            " WHERE nom_proc = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setLong(1, processoSeletivo.getVaga().getCod_cargo());
            statement.setLong(2, processoSeletivo.getProva().getCod_prova());
            statement.setLong(3, processoSeletivo.getParticipante().getNro_ins());
            statement.setDate(4, new java.sql.Date(processoSeletivo.getDat_ini().getTime()));
            statement.setDate(5, new java.sql.Date(processoSeletivo.getDat_fim().getTime()));
            statement.setString(6, processoSeletivo.getNom_proc());
            statement.setString(7, processoSeletivo.getDesc_proc());
            statement.setLong(8, processoSeletivo.getNro_vagas());
            statement.setString(9, nome_antigo);

            statement.execute();

            connection.close();
            
            return true;
            
        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
            
        }
        
    }

    @Override
    public boolean excluir(String nom_proc) throws PersistenciaException {

        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "DELETE FROM ProcessoSeletivo WHERE nom_proc = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, nom_proc);

            statement.execute();
            connection.close();
            
            return true;
            
        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
                
        }

    }

    @Override
    public List<ProcessoSeletivo> listarTodos() throws PersistenciaException {

        List<ProcessoSeletivo> ProcessoSeletivoList = new ArrayList<ProcessoSeletivo>();

        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM ProcessoSeletivo";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();
            
            IProvaDAO provaDAO = new ProvaDAO();
            IParticipanteDAO participanteDAO = new ParticipanteDAO();
            IVagaDAO vagaDAO = new VagaDAO();
            
            while(resultSet.next()){
                
                ProcessoSeletivo processoSeletivo = new ProcessoSeletivo();
                processoSeletivo.setCod_proc(resultSet.getLong("cod_proc"));
                Prova prova = provaDAO.consultarPorId(resultSet.getLong("cod_prova"));
                processoSeletivo.setProva(prova);
                Participante participante = participanteDAO.consultarPorId(resultSet.getLong("nro_ins"));
                processoSeletivo.setParticipante(participante);
                processoSeletivo.setDat_ini(resultSet.getDate("dat_ini"));
                processoSeletivo.setDat_fim(resultSet.getDate("dat_fim"));
                processoSeletivo.setNom_proc(resultSet.getString("nom_proc"));
                processoSeletivo.setDesc_proc(resultSet.getString("desc_proc"));
                Vaga vaga = vagaDAO.consultarPorId(resultSet.getLong("cod_cargo"));
                processoSeletivo.setNro_vagas(resultSet.getLong("nro_vagas"));
                processoSeletivo.setVaga(vaga);

                ProcessoSeletivoList.add(processoSeletivo);
                
            }
            
            connection.close();
            
        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
                
        }
        
        return ProcessoSeletivoList;
        
    }

    @Override
    public ProcessoSeletivo consultarPorId(Long cod_proc) throws PersistenciaException {
        
        ProcessoSeletivo processoSeletivo = null;
        
        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM ProcessoSeletivo WHERE cod_proc = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, cod_proc);

            ResultSet resultSet = statement.executeQuery();

            IProvaDAO provaDAO = new ProvaDAO();
            IParticipanteDAO participanteDAO = new ParticipanteDAO();
            IVagaDAO vagaDAO = new VagaDAO();
            
            while(resultSet.next()){
                
                processoSeletivo = new ProcessoSeletivo();
                processoSeletivo.setCod_proc(resultSet.getLong("cod_proc"));
                Prova prova = provaDAO.consultarPorId(resultSet.getLong("cod_prova"));
                processoSeletivo.setProva(prova);
                Participante participante = participanteDAO.consultarPorId(resultSet.getLong("nro_ins"));
                processoSeletivo.setParticipante(participante);
                processoSeletivo.setDat_ini(resultSet.getDate("dat_ini"));
                processoSeletivo.setDat_fim(resultSet.getDate("dat_fim"));
                processoSeletivo.setNom_proc(resultSet.getString("nom_proc"));
                processoSeletivo.setDesc_proc(resultSet.getString("desc_proc"));
                Vaga vaga = vagaDAO.consultarPorId(resultSet.getLong("cod_cargo"));
                processoSeletivo.setNro_vagas(resultSet.getLong("nro_vagas"));
                processoSeletivo.setVaga(vaga);
                    
            }
            
            connection.close();

        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
                
        }
        
        return processoSeletivo;
        
    }

    @Override
    public ProcessoSeletivo consultarPorNome(String nom_proc) throws PersistenciaException {

        ProcessoSeletivo processoSeletivo = null;
        
        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM ProcessoSeletivo WHERE nom_proc = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nom_proc);

            ResultSet resultSet = statement.executeQuery();

            IProvaDAO provaDAO = new ProvaDAO();
            IParticipanteDAO participanteDAO = new ParticipanteDAO();
            IVagaDAO vagaDAO = new VagaDAO();
            
            while(resultSet.next()){
                
                processoSeletivo = new ProcessoSeletivo();
                processoSeletivo.setCod_proc(resultSet.getLong("cod_proc"));
                Prova prova = provaDAO.consultarPorId(resultSet.getLong("cod_prova"));
                processoSeletivo.setProva(prova);
                Participante participante = participanteDAO.consultarPorId(resultSet.getLong("nro_ins"));
                processoSeletivo.setParticipante(participante);
                processoSeletivo.setDat_ini(resultSet.getDate("dat_ini"));
                processoSeletivo.setDat_fim(resultSet.getDate("dat_fim"));
                processoSeletivo.setNom_proc(resultSet.getString("nom_proc"));
                processoSeletivo.setDesc_proc(resultSet.getString("desc_proc"));
                Vaga vaga = vagaDAO.consultarPorId(resultSet.getLong("cod_cargo"));
                processoSeletivo.setNro_vagas(resultSet.getLong("nro_vagas"));
                processoSeletivo.setVaga(vaga);
                    
            }
            
            connection.close();

        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
                
        }
        
        return processoSeletivo;
        
    }
    
    @Override
    public List<ProcessoSeletivo> consultarPorNomeDistinto() throws PersistenciaException {
        
        ProcessoSeletivo processoSeletivo = null;
        List<ProcessoSeletivo> processoSeletivoList = new ArrayList<ProcessoSeletivo>();
        
        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT DISTINCT ON (nom_proc) cod_cargo, cod_prova, nro_ins, "
                    + "dat_ini, dat_fim, nom_proc, desc_proc, nro_vagas FROM ProcessoSeletivo ";
                    
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            
            IProvaDAO provaDAO = new ProvaDAO();
            IParticipanteDAO participanteDAO = new ParticipanteDAO();
            IVagaDAO vagaDAO = new VagaDAO();
            
            while (resultSet.next()){

                processoSeletivo = new ProcessoSeletivo();
                processoSeletivo.setCod_proc(resultSet.getLong("cod_proc"));
                Prova prova = provaDAO.consultarPorId(resultSet.getLong("cod_prova"));
                processoSeletivo.setProva(prova);
                Participante participante = participanteDAO.consultarPorId(resultSet.getLong("nro_ins"));
                processoSeletivo.setParticipante(participante);
                processoSeletivo.setDat_ini(resultSet.getDate("dat_ini"));
                processoSeletivo.setDat_fim(resultSet.getDate("dat_fim"));
                processoSeletivo.setNom_proc(resultSet.getString("nom_proc"));
                processoSeletivo.setDesc_proc(resultSet.getString("desc_proc"));
                Vaga vaga = vagaDAO.consultarPorId(resultSet.getLong("cod_cargo"));
                processoSeletivo.setNro_vagas(resultSet.getLong("nro_vagas"));
                processoSeletivo.setVaga(vaga);
                
            }  
            
            connection.close();

        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
                
        }
        
        return processoSeletivoList;
    }
    
    @Override
    public List<ProcessoSeletivo> consultarPorNomeDistintoUnico() throws PersistenciaException {
        
        ProcessoSeletivo processoSeletivo = null;
        List<ProcessoSeletivo> processoSeletivoList = new ArrayList<ProcessoSeletivo>();
        
        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT DISTINCT nom_proc FROM ProcessoSeletivo ";
                    
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){

                processoSeletivo =  new ProcessoSeletivo();
                processoSeletivo.setNom_proc(resultSet.getString("nom_proc"));
                
                String nom_proc = resultSet.getString("nom_proc");
                String sql2 = "Select cod_proc FROM ProcessoSeletivo WHERE nom_proc = ? ";
                PreparedStatement statement2 = connection.prepareStatement(sql2);
                statement2.setString(1, nom_proc);
                ResultSet resultSet2 = statement2.executeQuery();
                
                if(resultSet2.next()){
                    
                    processoSeletivo.setCod_proc(resultSet2.getLong("cod_proc"));

                    processoSeletivoList.add(processoSeletivo);
                    
                }
                
            }  
            
            connection.close();

        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
                
        }
        
        return processoSeletivoList;
    }
    
    
}