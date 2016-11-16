package br.cefetmg.inf.prodigialis.model.dao.impl;

import br.cefetmg.inf.prodigialis.model.dao.ICargoDAO;
import br.cefetmg.inf.prodigialis.model.dao.IProcessoSeletivoDAO;
import br.cefetmg.inf.prodigialis.model.dao.IProvaDAO;
import br.cefetmg.inf.prodigialis.model.domain.Cargo;
import br.cefetmg.inf.prodigialis.model.domain.ProcessoSeletivo;
import br.cefetmg.inf.prodigialis.model.domain.Prova;
import br.cefetmg.inf.prodigialis.util.db.JDBCConnectionManager;
import br.cefetmg.inf.prodigialis.util.db.exception.PersistenciaException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Felipe Rabelo
 */
public class ProcessoSeletivoDAO implements IProcessoSeletivoDAO{

    @Override
    public boolean inserir(ProcessoSeletivo obj) throws PersistenciaException {
        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "INSERT INTO processoseletivo (cod_proc, cod_prova, dat_ini,"
                    + "dat_fim, nom_proc, desc_proc, nro_vagas, em_andamento, cod_cargo) " 
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, obj.getCodProcesso());
            statement.setInt(2,obj.getProva().getCod_prova() );
            statement.setDate(3, (Date) obj.getDataInicio());
            statement.setDate(4, (Date) obj.getDataFinal());
            statement.setString(5, obj.getNome());
            statement.setString(6, obj.getDescricao());
            statement.setInt(7, obj.getNroVagas());
            statement.setBoolean(8, obj.isEm_andamento());
            statement.setInt(9, Integer.parseInt(obj.getCargoOferecido().getCod_cargo().toString()));
            
            statement.execute();
            
            connection.close();
            
            return true;
            
        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
            
        }
    }

    @Override
    public boolean atualizar(ProcessoSeletivo obj) throws PersistenciaException {
        
        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();
            
            String sql = "UPDATE processoseletivo "
                    + "SET cod_prova = ?,"
                    + "dat_ini = ?,"
                    + "dat_fim = ?,"
                    + "nom_proc = ?,"
                    + "desc_proc = ?,"
                    + "nro_vagas = ?,"
                    + "em_andamento = ?,"
                    + "cod_cargo = ?"
                    + "WHERE cod_proc = ?";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setInt(1,obj.getProva().getCod_prova() );
            statement.setDate(2, (Date) obj.getDataInicio());
            statement.setDate(3, (Date) obj.getDataFinal());
            statement.setString(4, obj.getNome());
            statement.setString(5, obj.getDescricao());
            statement.setInt(6, obj.getNroVagas());
            statement.setBoolean(7, obj.isEm_andamento());
            statement.setInt(8, Integer.parseInt(obj.getCargoOferecido().getCod_cargo().toString()));
            statement.setInt(9, obj.getCodProcesso());
            
            statement.execute();

            connection.close();
            
            return true;
        
        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
            
        }
    }

    @Override
    public boolean excluir(Long id) throws PersistenciaException {
        
        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "DELETE FROM processoseletivo WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setLong(1, id);

            statement.execute();
            connection.close();
            
            return true;
            
        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
                
        }
        
    }

    @Override
    public ProcessoSeletivo consultarPorId(Long id) throws PersistenciaException {
        
        ProcessoSeletivo processo = null;
        
        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM processoseletivo WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();
            
            IProvaDAO provaDAO = new ProvaDAO();
            ICargoDAO cargoDAO = new CargoDAO();
            
            while (resultSet.next()) {
                
                processo = new ProcessoSeletivo();
                processo.setCodProcesso(resultSet.getInt("cod_proc"));
                Prova prova = provaDAO.consultarPorId(resultSet.getLong("cod_prova"));
                processo.setProva(prova);
                processo.setDataInicio(resultSet.getDate("dat_ini"));
                processo.setDataFinal(resultSet.getDate("dat_fim"));
                processo.setNome(resultSet.getString("nom_proc"));
                processo.setDescricao(resultSet.getString("desc_proc"));
                processo.setNroVagas(resultSet.getInt("nro_vagas"));
                processo.setEm_andamento(resultSet.getBoolean("em_andamento"));
                Cargo cargo = cargoDAO.consultarPorId(resultSet.getLong("cod_cargo"));
                processo.setCargoOferecido(cargo);
                
            }
            
            connection.close();
            
        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
                
        }
        
        return processo;
        
    }

    @Override
    public List<ProcessoSeletivo> listarTodos() throws PersistenciaException {
        
        List<ProcessoSeletivo> ProcessoList = new ArrayList<ProcessoSeletivo>();
        
        try {
        
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM ProcessoSeletivo";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();
            
            IProvaDAO provaDAO = new ProvaDAO();
            ICargoDAO cargoDAO = new CargoDAO();
            
            while (resultSet.next()) {
                
                ProcessoSeletivo processo = new ProcessoSeletivo();
                processo.setCodProcesso(resultSet.getInt("cod_proc"));
                Prova prova = provaDAO.consultarPorId(resultSet.getLong("cod_prova"));
                processo.setProva(prova);
                processo.setDataInicio(resultSet.getDate("dat_ini"));
                processo.setDataFinal(resultSet.getDate("dat_fim"));
                processo.setNome(resultSet.getString("nom_proc"));
                processo.setDescricao(resultSet.getString("desc_proc"));
                processo.setNroVagas(resultSet.getInt("nro_vagas"));
                processo.setEm_andamento(resultSet.getBoolean("em_andamento"));
                Cargo cargo = cargoDAO.consultarPorId(resultSet.getLong("cod_cargo"));
                processo.setCargoOferecido(cargo);
                
                ProcessoList.add(processo);
                
            }
        
        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
                
        }
        
        return ProcessoList;
        
    }
    
}
