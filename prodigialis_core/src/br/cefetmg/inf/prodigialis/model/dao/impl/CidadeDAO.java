/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.prodigialis.model.dao.impl;

import br.cefetmg.inf.prodigialis.model.domain.Cidade;
import br.cefetmg.inf.prodigialis.model.domain.Curriculo;
import br.cefetmg.inf.prodigialis.util.db.JDBCConnectionManager;
import br.cefetmg.inf.prodigialis.util.db.exception.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cliente
 */
public class CidadeDAO {
    public ArrayList<Cidade> listarPorUf(String uf ) throws PersistenciaException {

        ArrayList<Cidade> cidades = new ArrayList<Cidade>();

        try {
            
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM cidade where uf=? ORDER BY uf";
            

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, uf);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                
                Cidade cidade = new Cidade();
                cidade.setIbge(resultSet.getString("ibge"));
                cidade.setNom_cid(resultSet.getString("nom_cid"));
                cidade.setUf(resultSet.getString("uf"));

                cidades.add(cidade);
                
            }
            
            connection.close();
            
        } catch (Exception e){
            
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
                
        }
        
        return cidades;
        
    }
}
