
package br.cefetmg.inf.prodigialis.model.dao.impl;

import br.cefetmg.inf.prodigialis.model.dao.IProcessoSeletivoDAO;
import br.cefetmg.inf.prodigialis.model.domain.Participante;
import br.cefetmg.inf.prodigialis.util.db.JDBCConnectionManager;
import br.cefetmg.inf.prodigialis.util.db.exception.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class ProcessoSeletivoDAO implements IProcessoSeletivoDAO{
    
    @Override
    public boolean inserir(Participante participante) throws PersistenciaException {
        
        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "INSERT INTO Participante (cod_prova, cpf, nro_ins) "
                    + "VALUES(?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setLong(1, participante.getProva().getCod_prova());
            statement.setLong(2, participante.getCandidato().getCpf());
            statement.setLong(3, participante.getNro_ins());
            
            statement.execute();
            
            connection.close();
            
            return true;
            
        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
            
        }
        
    }
    
}